package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessTokenManager
{
  public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
  public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
  public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
  private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
  public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  public static final String TAG = "AccessTokenManager";
  private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
  private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
  private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
  private static volatile AccessTokenManager instance;
  private final AccessTokenCache accessTokenCache;
  private AccessToken currentAccessToken;
  private Date lastAttemptedTokenExtendDate;
  private final d localBroadcastManager;
  private AtomicBoolean tokenRefreshInProgress;
  
  AccessTokenManager(d paramd, AccessTokenCache paramAccessTokenCache)
  {
    AppMethodBeat.i(16990);
    this.tokenRefreshInProgress = new AtomicBoolean(false);
    this.lastAttemptedTokenExtendDate = new Date(0L);
    Validate.notNull(paramd, "localBroadcastManager");
    Validate.notNull(paramAccessTokenCache, "accessTokenCache");
    this.localBroadcastManager = paramd;
    this.accessTokenCache = paramAccessTokenCache;
    AppMethodBeat.o(16990);
  }
  
  private static GraphRequest createExtendAccessTokenRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(17001);
    Bundle localBundle = new Bundle();
    localBundle.putString("grant_type", "fb_extend_sso_token");
    paramAccessToken = new GraphRequest(paramAccessToken, "oauth/access_token", localBundle, HttpMethod.GET, paramCallback);
    AppMethodBeat.o(17001);
    return paramAccessToken;
  }
  
  private static GraphRequest createGrantedPermissionsRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(17000);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/permissions", new Bundle(), HttpMethod.GET, paramCallback);
    AppMethodBeat.o(17000);
    return paramAccessToken;
  }
  
  static AccessTokenManager getInstance()
  {
    AppMethodBeat.i(16991);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AccessTokenManager(d.U(FacebookSdk.getApplicationContext()), new AccessTokenCache());
      }
      AccessTokenManager localAccessTokenManager = instance;
      AppMethodBeat.o(16991);
      return localAccessTokenManager;
    }
    finally
    {
      AppMethodBeat.o(16991);
    }
  }
  
  private void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    AppMethodBeat.i(17003);
    final AccessToken localAccessToken = this.currentAccessToken;
    if (localAccessToken == null)
    {
      if (paramAccessTokenRefreshCallback != null) {
        paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
      }
      AppMethodBeat.o(17003);
      return;
    }
    if (!this.tokenRefreshInProgress.compareAndSet(false, true))
    {
      if (paramAccessTokenRefreshCallback != null) {
        paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
      }
      AppMethodBeat.o(17003);
      return;
    }
    this.lastAttemptedTokenExtendDate = new Date();
    final HashSet localHashSet1 = new HashSet();
    final HashSet localHashSet2 = new HashSet();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    final RefreshResult localRefreshResult = new RefreshResult(null);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch(new GraphRequest[] { createGrantedPermissionsRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(16987);
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null)
        {
          AppMethodBeat.o(16987);
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.optJSONArray("data");
        if (paramAnonymousGraphResponse == null)
        {
          AppMethodBeat.o(16987);
          return;
        }
        localAtomicBoolean.set(true);
        int i = 0;
        if (i < paramAnonymousGraphResponse.length())
        {
          Object localObject = paramAnonymousGraphResponse.optJSONObject(i);
          String str;
          if (localObject != null)
          {
            str = ((JSONObject)localObject).optString("permission");
            localObject = ((JSONObject)localObject).optString("status");
            if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty((String)localObject)))
            {
              localObject = ((String)localObject).toLowerCase(Locale.US);
              if (!((String)localObject).equals("granted")) {
                break label140;
              }
              localHashSet1.add(str);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label140:
            if (((String)localObject).equals("declined")) {
              localHashSet2.add(str);
            }
          }
        }
        AppMethodBeat.o(16987);
      }
    }), createExtendAccessTokenRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(16988);
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null)
        {
          AppMethodBeat.o(16988);
          return;
        }
        localRefreshResult.accessToken = paramAnonymousGraphResponse.optString("access_token");
        localRefreshResult.expiresAt = paramAnonymousGraphResponse.optInt("expires_at");
        localRefreshResult.dataAccessExpirationTime = Long.valueOf(paramAnonymousGraphResponse.optLong("data_access_expiration_time"));
        AppMethodBeat.o(16988);
      }
    }) });
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        AppMethodBeat.i(16989);
        Object localObject;
        for (;;)
        {
          try
          {
            if ((AccessTokenManager.getInstance().getCurrentAccessToken() == null) || (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != localAccessToken.getUserId()))
            {
              if (paramAccessTokenRefreshCallback != null) {
                paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
              }
              AccessTokenManager.this.tokenRefreshInProgress.set(false);
              AppMethodBeat.o(16989);
              return;
            }
            if ((!localAtomicBoolean.get()) && (localRefreshResult.accessToken == null) && (localRefreshResult.expiresAt == 0))
            {
              if (paramAccessTokenRefreshCallback != null) {
                paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
              }
              AccessTokenManager.this.tokenRefreshInProgress.set(false);
              AppMethodBeat.o(16989);
              return;
            }
            if (localRefreshResult.accessToken != null)
            {
              paramAnonymousGraphRequestBatch = localRefreshResult.accessToken;
              String str1 = localAccessToken.getApplicationId();
              String str2 = localAccessToken.getUserId();
              if (!localAtomicBoolean.get()) {
                continue;
              }
              localObject = localHashSet1;
              if (!localAtomicBoolean.get()) {
                continue;
              }
              localSet = localHashSet2;
              AccessTokenSource localAccessTokenSource = localAccessToken.getSource();
              if (localRefreshResult.expiresAt == 0) {
                continue;
              }
              localDate1 = new Date(localRefreshResult.expiresAt * 1000L);
              Date localDate3 = new Date();
              if (localRefreshResult.dataAccessExpirationTime == null) {
                continue;
              }
              localDate2 = new Date(localRefreshResult.dataAccessExpirationTime.longValue() * 1000L);
              localObject = new AccessToken(paramAnonymousGraphRequestBatch, str1, str2, (Collection)localObject, localSet, localAccessTokenSource, localDate1, localDate3, localDate2);
            }
          }
          finally
          {
            Set localSet;
            Date localDate1;
            Date localDate2;
            localObject = null;
          }
          try
          {
            AccessTokenManager.getInstance().setCurrentAccessToken((AccessToken)localObject);
            AccessTokenManager.this.tokenRefreshInProgress.set(false);
            if (paramAccessTokenRefreshCallback == null) {
              break label463;
            }
            paramAccessTokenRefreshCallback.OnTokenRefreshed((AccessToken)localObject);
            AppMethodBeat.o(16989);
            return;
          }
          finally
          {
            break;
          }
          paramAnonymousGraphRequestBatch = localAccessToken.getToken();
          continue;
          localObject = localAccessToken.getPermissions();
          continue;
          localSet = localAccessToken.getDeclinedPermissions();
          continue;
          localDate1 = localAccessToken.getExpires();
          continue;
          localDate2 = localAccessToken.getDataAccessExpirationTime();
        }
        AccessTokenManager.this.tokenRefreshInProgress.set(false);
        if ((paramAccessTokenRefreshCallback != null) && (localObject != null)) {
          paramAccessTokenRefreshCallback.OnTokenRefreshed((AccessToken)localObject);
        }
        AppMethodBeat.o(16989);
        throw paramAnonymousGraphRequestBatch;
        label463:
        AppMethodBeat.o(16989);
      }
    });
    localGraphRequestBatch.executeAsync();
    AppMethodBeat.o(17003);
  }
  
  private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    AppMethodBeat.i(16996);
    Intent localIntent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
    localIntent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", paramAccessToken1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", paramAccessToken2);
    this.localBroadcastManager.b(localIntent);
    AppMethodBeat.o(16996);
  }
  
  private void setCurrentAccessToken(AccessToken paramAccessToken, boolean paramBoolean)
  {
    AppMethodBeat.i(16994);
    AccessToken localAccessToken = this.currentAccessToken;
    this.currentAccessToken = paramAccessToken;
    this.tokenRefreshInProgress.set(false);
    this.lastAttemptedTokenExtendDate = new Date(0L);
    if (paramBoolean)
    {
      if (paramAccessToken == null) {
        break label77;
      }
      this.accessTokenCache.save(paramAccessToken);
    }
    for (;;)
    {
      if (!Utility.areObjectsEqual(localAccessToken, paramAccessToken))
      {
        sendCurrentAccessTokenChangedBroadcastIntent(localAccessToken, paramAccessToken);
        setTokenExpirationBroadcastAlarm();
      }
      AppMethodBeat.o(16994);
      return;
      label77:
      this.accessTokenCache.clear();
      Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
    }
  }
  
  private void setTokenExpirationBroadcastAlarm()
  {
    AppMethodBeat.i(16997);
    Object localObject = FacebookSdk.getApplicationContext();
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    AlarmManager localAlarmManager = (AlarmManager)((Context)localObject).getSystemService("alarm");
    if ((!AccessToken.isCurrentAccessTokenActive()) || (localAccessToken.getExpires() == null) || (localAlarmManager == null))
    {
      AppMethodBeat.o(16997);
      return;
    }
    Intent localIntent = new Intent((Context)localObject, CurrentAccessTokenExpirationBroadcastReceiver.class);
    localIntent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localObject = PendingIntent.getBroadcast((Context)localObject, 0, localIntent, 0);
    localAlarmManager.set(1, localAccessToken.getExpires().getTime(), (PendingIntent)localObject);
    AppMethodBeat.o(16997);
  }
  
  private boolean shouldExtendAccessToken()
  {
    AppMethodBeat.i(16999);
    if (this.currentAccessToken == null)
    {
      AppMethodBeat.o(16999);
      return false;
    }
    Long localLong = Long.valueOf(new Date().getTime());
    if ((this.currentAccessToken.getSource().canExtendToken()) && (localLong.longValue() - this.lastAttemptedTokenExtendDate.getTime() > 3600000L) && (localLong.longValue() - this.currentAccessToken.getLastRefresh().getTime() > 86400000L))
    {
      AppMethodBeat.o(16999);
      return true;
    }
    AppMethodBeat.o(16999);
    return false;
  }
  
  final void currentAccessTokenChanged()
  {
    AppMethodBeat.i(16995);
    sendCurrentAccessTokenChangedBroadcastIntent(this.currentAccessToken, this.currentAccessToken);
    AppMethodBeat.o(16995);
  }
  
  final void extendAccessTokenIfNeeded()
  {
    AppMethodBeat.i(16998);
    if (!shouldExtendAccessToken())
    {
      AppMethodBeat.o(16998);
      return;
    }
    refreshCurrentAccessToken(null);
    AppMethodBeat.o(16998);
  }
  
  final AccessToken getCurrentAccessToken()
  {
    return this.currentAccessToken;
  }
  
  final boolean loadCurrentAccessToken()
  {
    AppMethodBeat.i(16992);
    AccessToken localAccessToken = this.accessTokenCache.load();
    if (localAccessToken != null)
    {
      setCurrentAccessToken(localAccessToken, false);
      AppMethodBeat.o(16992);
      return true;
    }
    AppMethodBeat.o(16992);
    return false;
  }
  
  final void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    AppMethodBeat.i(17002);
    if (Looper.getMainLooper().equals(Looper.myLooper()))
    {
      refreshCurrentAccessTokenImpl(paramAccessTokenRefreshCallback);
      AppMethodBeat.o(17002);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16986);
        AccessTokenManager.access$000(AccessTokenManager.this, paramAccessTokenRefreshCallback);
        AppMethodBeat.o(16986);
      }
    });
    AppMethodBeat.o(17002);
  }
  
  final void setCurrentAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(16993);
    setCurrentAccessToken(paramAccessToken, true);
    AppMethodBeat.o(16993);
  }
  
  static class RefreshResult
  {
    public String accessToken;
    public Long dataAccessExpirationTime;
    public int expiresAt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.AccessTokenManager
 * JD-Core Version:    0.7.0.1
 */