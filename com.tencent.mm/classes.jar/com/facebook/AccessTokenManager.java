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
    AppMethodBeat.i(71554);
    this.tokenRefreshInProgress = new AtomicBoolean(false);
    this.lastAttemptedTokenExtendDate = new Date(0L);
    Validate.notNull(paramd, "localBroadcastManager");
    Validate.notNull(paramAccessTokenCache, "accessTokenCache");
    this.localBroadcastManager = paramd;
    this.accessTokenCache = paramAccessTokenCache;
    AppMethodBeat.o(71554);
  }
  
  private static GraphRequest createExtendAccessTokenRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71565);
    Bundle localBundle = new Bundle();
    localBundle.putString("grant_type", "fb_extend_sso_token");
    paramAccessToken = new GraphRequest(paramAccessToken, "oauth/access_token", localBundle, HttpMethod.GET, paramCallback);
    AppMethodBeat.o(71565);
    return paramAccessToken;
  }
  
  private static GraphRequest createGrantedPermissionsRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71564);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/permissions", new Bundle(), HttpMethod.GET, paramCallback);
    AppMethodBeat.o(71564);
    return paramAccessToken;
  }
  
  static AccessTokenManager getInstance()
  {
    AppMethodBeat.i(71555);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AccessTokenManager(d.R(FacebookSdk.getApplicationContext()), new AccessTokenCache());
      }
      AccessTokenManager localAccessTokenManager = instance;
      AppMethodBeat.o(71555);
      return localAccessTokenManager;
    }
    finally
    {
      AppMethodBeat.o(71555);
    }
  }
  
  private void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    AppMethodBeat.i(71567);
    AccessToken localAccessToken = this.currentAccessToken;
    if (localAccessToken == null)
    {
      if (paramAccessTokenRefreshCallback != null) {
        paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
      }
      AppMethodBeat.o(71567);
      return;
    }
    if (!this.tokenRefreshInProgress.compareAndSet(false, true))
    {
      if (paramAccessTokenRefreshCallback != null) {
        paramAccessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
      }
      AppMethodBeat.o(71567);
      return;
    }
    this.lastAttemptedTokenExtendDate = new Date();
    final HashSet localHashSet1 = new HashSet();
    final HashSet localHashSet2 = new HashSet();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    AccessTokenManager.RefreshResult localRefreshResult = new AccessTokenManager.RefreshResult(null);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch(new GraphRequest[] { createGrantedPermissionsRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(71551);
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null)
        {
          AppMethodBeat.o(71551);
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.optJSONArray("data");
        if (paramAnonymousGraphResponse == null)
        {
          AppMethodBeat.o(71551);
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
                break label137;
              }
              localHashSet1.add(str);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label137:
            if (((String)localObject).equals("declined")) {
              localHashSet2.add(str);
            }
          }
        }
        AppMethodBeat.o(71551);
      }
    }), createExtendAccessTokenRequest(localAccessToken, new AccessTokenManager.3(this, localRefreshResult)) });
    localGraphRequestBatch.addCallback(new AccessTokenManager.4(this, localAccessToken, paramAccessTokenRefreshCallback, localAtomicBoolean, localRefreshResult, localHashSet1, localHashSet2));
    localGraphRequestBatch.executeAsync();
    AppMethodBeat.o(71567);
  }
  
  private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    AppMethodBeat.i(71560);
    Intent localIntent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
    localIntent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", paramAccessToken1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", paramAccessToken2);
    this.localBroadcastManager.c(localIntent);
    AppMethodBeat.o(71560);
  }
  
  private void setCurrentAccessToken(AccessToken paramAccessToken, boolean paramBoolean)
  {
    AppMethodBeat.i(71558);
    AccessToken localAccessToken = this.currentAccessToken;
    this.currentAccessToken = paramAccessToken;
    this.tokenRefreshInProgress.set(false);
    this.lastAttemptedTokenExtendDate = new Date(0L);
    if (paramBoolean)
    {
      if (paramAccessToken == null) {
        break label75;
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
      AppMethodBeat.o(71558);
      return;
      label75:
      this.accessTokenCache.clear();
      Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
    }
  }
  
  private void setTokenExpirationBroadcastAlarm()
  {
    AppMethodBeat.i(71561);
    Object localObject = FacebookSdk.getApplicationContext();
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    AlarmManager localAlarmManager = (AlarmManager)((Context)localObject).getSystemService("alarm");
    if ((!AccessToken.isCurrentAccessTokenActive()) || (localAccessToken.getExpires() == null) || (localAlarmManager == null))
    {
      AppMethodBeat.o(71561);
      return;
    }
    Intent localIntent = new Intent((Context)localObject, CurrentAccessTokenExpirationBroadcastReceiver.class);
    localIntent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localObject = PendingIntent.getBroadcast((Context)localObject, 0, localIntent, 0);
    localAlarmManager.set(1, localAccessToken.getExpires().getTime(), (PendingIntent)localObject);
    AppMethodBeat.o(71561);
  }
  
  private boolean shouldExtendAccessToken()
  {
    AppMethodBeat.i(71563);
    if (this.currentAccessToken == null)
    {
      AppMethodBeat.o(71563);
      return false;
    }
    Long localLong = Long.valueOf(new Date().getTime());
    if ((this.currentAccessToken.getSource().canExtendToken()) && (localLong.longValue() - this.lastAttemptedTokenExtendDate.getTime() > 3600000L) && (localLong.longValue() - this.currentAccessToken.getLastRefresh().getTime() > 86400000L))
    {
      AppMethodBeat.o(71563);
      return true;
    }
    AppMethodBeat.o(71563);
    return false;
  }
  
  final void currentAccessTokenChanged()
  {
    AppMethodBeat.i(71559);
    sendCurrentAccessTokenChangedBroadcastIntent(this.currentAccessToken, this.currentAccessToken);
    AppMethodBeat.o(71559);
  }
  
  final void extendAccessTokenIfNeeded()
  {
    AppMethodBeat.i(71562);
    if (!shouldExtendAccessToken())
    {
      AppMethodBeat.o(71562);
      return;
    }
    refreshCurrentAccessToken(null);
    AppMethodBeat.o(71562);
  }
  
  final AccessToken getCurrentAccessToken()
  {
    return this.currentAccessToken;
  }
  
  final boolean loadCurrentAccessToken()
  {
    AppMethodBeat.i(71556);
    AccessToken localAccessToken = this.accessTokenCache.load();
    if (localAccessToken != null)
    {
      setCurrentAccessToken(localAccessToken, false);
      AppMethodBeat.o(71556);
      return true;
    }
    AppMethodBeat.o(71556);
    return false;
  }
  
  final void refreshCurrentAccessToken(AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    AppMethodBeat.i(71566);
    if (Looper.getMainLooper().equals(Looper.myLooper()))
    {
      refreshCurrentAccessTokenImpl(paramAccessTokenRefreshCallback);
      AppMethodBeat.o(71566);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AccessTokenManager.1(this, paramAccessTokenRefreshCallback));
    AppMethodBeat.o(71566);
  }
  
  final void setCurrentAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(71557);
    setCurrentAccessToken(paramAccessToken, true);
    AppMethodBeat.o(71557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.AccessTokenManager
 * JD-Core Version:    0.7.0.1
 */