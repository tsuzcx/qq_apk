package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager
{
  private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
  private static final String MANAGE_PERMISSION_PREFIX = "manage";
  private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
  private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
  private static final String PUBLISH_PERMISSION_PREFIX = "publish";
  private static volatile LoginManager instance;
  private String authType;
  private DefaultAudience defaultAudience;
  private LoginBehavior loginBehavior;
  private final SharedPreferences sharedPreferences;
  
  static
  {
    AppMethodBeat.i(7952);
    OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    AppMethodBeat.o(7952);
  }
  
  LoginManager()
  {
    AppMethodBeat.i(7905);
    this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    this.defaultAudience = DefaultAudience.FRIENDS;
    this.authType = "rerequest";
    Validate.sdkInitialized();
    this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
    AppMethodBeat.o(7905);
  }
  
  static LoginResult computeLoginResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(7943);
    Set localSet = paramRequest.getPermissions();
    HashSet localHashSet = new HashSet(paramAccessToken.getPermissions());
    if (paramRequest.isRerequest()) {
      localHashSet.retainAll(localSet);
    }
    paramRequest = new HashSet(localSet);
    paramRequest.removeAll(localHashSet);
    paramRequest = new LoginResult(paramAccessToken, localHashSet, paramRequest);
    AppMethodBeat.o(7943);
    return paramRequest;
  }
  
  private LoginClient.Request createLoginRequestFromResponse(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(7911);
    Validate.notNull(paramGraphResponse, "response");
    paramGraphResponse = paramGraphResponse.getRequest().getAccessToken();
    if (paramGraphResponse != null) {}
    for (paramGraphResponse = paramGraphResponse.getPermissions();; paramGraphResponse = null)
    {
      paramGraphResponse = createLoginRequest(paramGraphResponse);
      AppMethodBeat.o(7911);
      return paramGraphResponse;
    }
  }
  
  private void finishLogin(AccessToken paramAccessToken, LoginClient.Request paramRequest, FacebookException paramFacebookException, boolean paramBoolean, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(7944);
    if (paramAccessToken != null)
    {
      AccessToken.setCurrentAccessToken(paramAccessToken);
      Profile.fetchProfileForCurrentAccessToken();
    }
    if (paramFacebookCallback != null)
    {
      if (paramAccessToken != null) {}
      for (paramRequest = computeLoginResult(paramRequest, paramAccessToken); (paramBoolean) || ((paramRequest != null) && (paramRequest.getRecentlyGrantedPermissions().size() == 0)); paramRequest = null)
      {
        paramFacebookCallback.onCancel();
        AppMethodBeat.o(7944);
        return;
      }
      if (paramFacebookException != null)
      {
        paramFacebookCallback.onError(paramFacebookException);
        AppMethodBeat.o(7944);
        return;
      }
      if (paramAccessToken != null)
      {
        setExpressLoginStatus(true);
        paramFacebookCallback.onSuccess(paramRequest);
      }
    }
    AppMethodBeat.o(7944);
  }
  
  static Map<String, String> getExtraDataFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(7916);
    if (paramIntent == null)
    {
      AppMethodBeat.o(7916);
      return null;
    }
    paramIntent = (LoginClient.Result)paramIntent.getParcelableExtra("com.facebook.LoginFragment:Result");
    if (paramIntent == null)
    {
      AppMethodBeat.o(7916);
      return null;
    }
    paramIntent = paramIntent.extraData;
    AppMethodBeat.o(7916);
    return paramIntent;
  }
  
  public static LoginManager getInstance()
  {
    AppMethodBeat.i(7906);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new LoginManager();
      }
      LoginManager localLoginManager = instance;
      AppMethodBeat.o(7906);
      return localLoginManager;
    }
    finally
    {
      AppMethodBeat.o(7906);
    }
  }
  
  private static Set<String> getOtherPublishPermissions()
  {
    AppMethodBeat.i(7934);
    Set localSet = Collections.unmodifiableSet(new LoginManager.2());
    AppMethodBeat.o(7934);
    return localSet;
  }
  
  private static Profile getProfileFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(7948);
    String str1 = paramBundle.getString("com.facebook.platform.extra.PROFILE_NAME");
    String str2 = paramBundle.getString("com.facebook.platform.extra.PROFILE_FIRST_NAME");
    String str3 = paramBundle.getString("com.facebook.platform.extra.PROFILE_MIDDLE_NAME");
    String str4 = paramBundle.getString("com.facebook.platform.extra.PROFILE_LAST_NAME");
    String str5 = paramBundle.getString("com.facebook.platform.extra.PROFILE_LINK");
    paramBundle = paramBundle.getString("com.facebook.platform.extra.PROFILE_USER_ID");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null) && (str5 != null) && (paramBundle != null))
    {
      paramBundle = new Profile(paramBundle, str2, str3, str4, str1, Uri.parse(str5));
      AppMethodBeat.o(7948);
      return paramBundle;
    }
    AppMethodBeat.o(7948);
    return null;
  }
  
  private static void handleLoginStatusError(String paramString1, String paramString2, String paramString3, LoginLogger paramLoginLogger, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(7949);
    paramString1 = new FacebookException(paramString1 + ": " + paramString2);
    paramLoginLogger.logLoginStatusError(paramString3, paramString1);
    paramLoginStatusCallback.onError(paramString1);
    AppMethodBeat.o(7949);
  }
  
  private boolean isExpressLoginAllowed()
  {
    AppMethodBeat.i(7947);
    boolean bool = this.sharedPreferences.getBoolean("express_login_allowed", true);
    AppMethodBeat.o(7947);
    return bool;
  }
  
  static boolean isPublishPermission(String paramString)
  {
    AppMethodBeat.i(7933);
    if ((paramString != null) && ((paramString.startsWith("publish")) || (paramString.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(paramString))))
    {
      AppMethodBeat.o(7933);
      return true;
    }
    AppMethodBeat.o(7933);
    return false;
  }
  
  private void logCompleteLogin(Context paramContext, LoginClient.Result.Code paramCode, Map<String, String> paramMap, Exception paramException, boolean paramBoolean, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7939);
    LoginLogger localLoginLogger = LoginLoggerHolder.access$000(paramContext);
    if (localLoginLogger == null)
    {
      AppMethodBeat.o(7939);
      return;
    }
    if (paramRequest == null)
    {
      localLoginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
      AppMethodBeat.o(7939);
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramContext = "1";; paramContext = "0")
    {
      localHashMap.put("try_login_activity", paramContext);
      localLoginLogger.logCompleteLogin(paramRequest.getAuthId(), localHashMap, paramCode, paramMap, paramException);
      AppMethodBeat.o(7939);
      return;
    }
  }
  
  private void logInWithPublishPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7929);
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
    AppMethodBeat.o(7929);
  }
  
  private void logInWithReadPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7922);
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
    AppMethodBeat.o(7922);
  }
  
  private void logStartLogin(Context paramContext, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7938);
    paramContext = LoginLoggerHolder.access$000(paramContext);
    if ((paramContext != null) && (paramRequest != null)) {
      paramContext.logStartLogin(paramRequest);
    }
    AppMethodBeat.o(7938);
  }
  
  private void reauthorizeDataAccess(FragmentWrapper paramFragmentWrapper)
  {
    AppMethodBeat.i(7926);
    LoginClient.Request localRequest = createReauthorizeRequest();
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), localRequest);
    AppMethodBeat.o(7926);
  }
  
  private void resolveError(FragmentWrapper paramFragmentWrapper, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(7910);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), createLoginRequestFromResponse(paramGraphResponse));
    AppMethodBeat.o(7910);
  }
  
  private boolean resolveIntent(Intent paramIntent)
  {
    AppMethodBeat.i(7941);
    if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(paramIntent, 0) != null)
    {
      AppMethodBeat.o(7941);
      return true;
    }
    AppMethodBeat.o(7941);
    return false;
  }
  
  private void retrieveLoginStatusImpl(Context paramContext, final LoginStatusCallback paramLoginStatusCallback, long paramLong)
  {
    AppMethodBeat.i(7945);
    final String str1 = FacebookSdk.getApplicationId();
    final String str2 = UUID.randomUUID().toString();
    final LoginLogger localLoginLogger = new LoginLogger(paramContext, str1);
    if (!isExpressLoginAllowed())
    {
      localLoginLogger.logLoginStatusFailure(str2);
      paramLoginStatusCallback.onFailure();
      AppMethodBeat.o(7945);
      return;
    }
    paramContext = new LoginStatusClient(paramContext, str1, str2, FacebookSdk.getGraphApiVersion(), paramLong);
    paramContext.setCompletedListener(new PlatformServiceClient.CompletedListener()
    {
      public void completed(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(7897);
        String str;
        Date localDate1;
        ArrayList localArrayList;
        Date localDate2;
        if (paramAnonymousBundle != null)
        {
          localObject = paramAnonymousBundle.getString("com.facebook.platform.status.ERROR_TYPE");
          str = paramAnonymousBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
          if (localObject != null)
          {
            LoginManager.access$100((String)localObject, str, str2, localLoginLogger, paramLoginStatusCallback);
            AppMethodBeat.o(7897);
            return;
          }
          str = paramAnonymousBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
          localDate1 = Utility.getBundleLongAsDate(paramAnonymousBundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
          localArrayList = paramAnonymousBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
          localObject = paramAnonymousBundle.getString("signed request");
          localDate2 = Utility.getBundleLongAsDate(paramAnonymousBundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
          if (Utility.isNullOrEmpty((String)localObject)) {
            break label273;
          }
        }
        label273:
        for (Object localObject = LoginMethodHandler.getUserIDFromSignedRequest((String)localObject);; localObject = null)
        {
          if ((!Utility.isNullOrEmpty(str)) && (localArrayList != null) && (!localArrayList.isEmpty()) && (!Utility.isNullOrEmpty((String)localObject)))
          {
            localObject = new AccessToken(str, str1, (String)localObject, localArrayList, null, null, localDate1, null, localDate2);
            AccessToken.setCurrentAccessToken((AccessToken)localObject);
            paramAnonymousBundle = LoginManager.access$200(paramAnonymousBundle);
            if (paramAnonymousBundle != null) {
              Profile.setCurrentProfile(paramAnonymousBundle);
            }
            for (;;)
            {
              localLoginLogger.logLoginStatusSuccess(str2);
              paramLoginStatusCallback.onCompleted((AccessToken)localObject);
              AppMethodBeat.o(7897);
              return;
              Profile.fetchProfileForCurrentAccessToken();
            }
          }
          localLoginLogger.logLoginStatusFailure(str2);
          paramLoginStatusCallback.onFailure();
          AppMethodBeat.o(7897);
          return;
          localLoginLogger.logLoginStatusFailure(str2);
          paramLoginStatusCallback.onFailure();
          AppMethodBeat.o(7897);
          return;
        }
      }
    });
    localLoginLogger.logLoginStatusStart(str2);
    if (!paramContext.start())
    {
      localLoginLogger.logLoginStatusFailure(str2);
      paramLoginStatusCallback.onFailure();
    }
    AppMethodBeat.o(7945);
  }
  
  private void setExpressLoginStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(7946);
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putBoolean("express_login_allowed", paramBoolean);
    localEditor.apply();
    AppMethodBeat.o(7946);
  }
  
  private void startLogin(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7937);
    logStartLogin(paramStartActivityDelegate.getActivityContext(), paramRequest);
    CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(7896);
        boolean bool = LoginManager.this.onActivityResult(paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(7896);
        return bool;
      }
    });
    if (!tryFacebookActivity(paramStartActivityDelegate, paramRequest))
    {
      FacebookException localFacebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
      logCompleteLogin(paramStartActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, localFacebookException, false, paramRequest);
      AppMethodBeat.o(7937);
      throw localFacebookException;
    }
    AppMethodBeat.o(7937);
  }
  
  private boolean tryFacebookActivity(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7940);
    paramRequest = getFacebookActivityIntent(paramRequest);
    if (!resolveIntent(paramRequest))
    {
      AppMethodBeat.o(7940);
      return false;
    }
    try
    {
      paramStartActivityDelegate.startActivityForResult(paramRequest, LoginClient.getLoginRequestCode());
      AppMethodBeat.o(7940);
      return true;
    }
    catch (ActivityNotFoundException paramStartActivityDelegate)
    {
      AppMethodBeat.o(7940);
    }
    return false;
  }
  
  private void validatePublishPermissions(Collection<String> paramCollection)
  {
    AppMethodBeat.i(7932);
    if (paramCollection == null)
    {
      AppMethodBeat.o(7932);
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (!isPublishPermission(str))
      {
        paramCollection = new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] { str }));
        AppMethodBeat.o(7932);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(7932);
  }
  
  private void validateReadPermissions(Collection<String> paramCollection)
  {
    AppMethodBeat.i(7931);
    if (paramCollection == null)
    {
      AppMethodBeat.o(7931);
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (isPublishPermission(str))
      {
        paramCollection = new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] { str }));
        AppMethodBeat.o(7931);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(7931);
  }
  
  protected LoginClient.Request createLoginRequest(Collection<String> paramCollection)
  {
    AppMethodBeat.i(7935);
    LoginBehavior localLoginBehavior = this.loginBehavior;
    if (paramCollection != null) {}
    for (paramCollection = new HashSet(paramCollection);; paramCollection = new HashSet())
    {
      paramCollection = new LoginClient.Request(localLoginBehavior, Collections.unmodifiableSet(paramCollection), this.defaultAudience, this.authType, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
      paramCollection.setRerequest(AccessToken.isCurrentAccessTokenActive());
      AppMethodBeat.o(7935);
      return paramCollection;
    }
  }
  
  protected LoginClient.Request createReauthorizeRequest()
  {
    AppMethodBeat.i(7936);
    LoginClient.Request localRequest = new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.defaultAudience, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
    AppMethodBeat.o(7936);
    return localRequest;
  }
  
  public String getAuthType()
  {
    return this.authType;
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return this.defaultAudience;
  }
  
  protected Intent getFacebookActivityIntent(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7942);
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(paramRequest.getLoginBehavior().toString());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("request", paramRequest);
    localIntent.putExtra("com.facebook.LoginFragment:Request", localBundle);
    AppMethodBeat.o(7942);
    return localIntent;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return this.loginBehavior;
  }
  
  public void logInWithPublishPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7930);
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
    AppMethodBeat.o(7930);
  }
  
  public void logInWithPublishPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7928);
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(7928);
  }
  
  public void logInWithPublishPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7927);
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(7927);
  }
  
  public void logInWithReadPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7923);
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
    AppMethodBeat.o(7923);
  }
  
  public void logInWithReadPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7921);
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(7921);
  }
  
  public void logInWithReadPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(7920);
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(7920);
  }
  
  public void logOut()
  {
    AppMethodBeat.i(7917);
    AccessToken.setCurrentAccessToken(null);
    Profile.setCurrentProfile(null);
    setExpressLoginStatus(false);
    AppMethodBeat.o(7917);
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(7914);
    boolean bool = onActivityResult(paramInt, paramIntent, null);
    AppMethodBeat.o(7914);
    return bool;
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(7915);
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = LoginClient.Result.Code.ERROR;
    Object localObject3 = null;
    LoginClient.Request localRequest = null;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramIntent != null)
    {
      localObject3 = (LoginClient.Result)paramIntent.getParcelableExtra("com.facebook.LoginFragment:Result");
      if (localObject3 == null) {
        break label262;
      }
      localRequest = ((LoginClient.Result)localObject3).request;
      localObject2 = ((LoginClient.Result)localObject3).code;
      if (paramInt == -1) {
        if (((LoginClient.Result)localObject3).code == LoginClient.Result.Code.SUCCESS)
        {
          paramIntent = ((LoginClient.Result)localObject3).token;
          localObject1 = null;
          localObject3 = ((LoginClient.Result)localObject3).loggingExtras;
          localObject4 = paramIntent;
          paramIntent = (Intent)localObject1;
        }
      }
    }
    for (localObject1 = localObject4;; localObject1 = localObject4)
    {
      localObject4 = localObject2;
      localObject2 = paramIntent;
      paramIntent = (Intent)localObject4;
      for (;;)
      {
        label115:
        if ((localObject2 == null) && (localObject1 == null) && (!bool1)) {
          localObject2 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        for (;;)
        {
          logCompleteLogin(null, paramIntent, (Map)localObject3, (Exception)localObject2, true, localRequest);
          finishLogin((AccessToken)localObject1, localRequest, (FacebookException)localObject2, bool1, paramFacebookCallback);
          AppMethodBeat.o(7915);
          return true;
          localObject1 = new FacebookAuthorizationException(((LoginClient.Result)localObject3).errorMessage);
          paramIntent = null;
          break;
          if (paramInt != 0) {
            break label254;
          }
          bool1 = true;
          paramIntent = null;
          localObject1 = null;
          break;
          if (paramInt != 0) {
            break label234;
          }
          paramIntent = LoginClient.Result.Code.CANCEL;
          bool1 = true;
          localObject1 = null;
          localObject2 = localObject4;
          break label115;
        }
        label234:
        bool1 = false;
        Object localObject5 = null;
        paramIntent = (Intent)localObject1;
        localObject2 = localObject4;
        localObject1 = localObject5;
      }
      label254:
      paramIntent = null;
      localObject1 = null;
      break;
      label262:
      localRequest = null;
      localObject3 = null;
      localObject4 = null;
      bool1 = bool2;
      paramIntent = (Intent)localObject2;
      localObject2 = localObject1;
    }
  }
  
  public void reauthorizeDataAccess(Activity paramActivity)
  {
    AppMethodBeat.i(7924);
    LoginClient.Request localRequest = createReauthorizeRequest();
    startLogin(new ActivityStartActivityDelegate(paramActivity), localRequest);
    AppMethodBeat.o(7924);
  }
  
  public void reauthorizeDataAccess(android.support.v4.app.Fragment paramFragment)
  {
    AppMethodBeat.i(7925);
    reauthorizeDataAccess(new FragmentWrapper(paramFragment));
    AppMethodBeat.o(7925);
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, final FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(7912);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(7912);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(7894);
        boolean bool = LoginManager.this.onActivityResult(paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
        AppMethodBeat.o(7894);
        return bool;
      }
    });
    AppMethodBeat.o(7912);
  }
  
  public void resolveError(Activity paramActivity, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(7907);
    startLogin(new ActivityStartActivityDelegate(paramActivity), createLoginRequestFromResponse(paramGraphResponse));
    AppMethodBeat.o(7907);
  }
  
  public void resolveError(android.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(7909);
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
    AppMethodBeat.o(7909);
  }
  
  public void resolveError(android.support.v4.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(7908);
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
    AppMethodBeat.o(7908);
  }
  
  public void retrieveLoginStatus(Context paramContext, long paramLong, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(7919);
    retrieveLoginStatusImpl(paramContext, paramLoginStatusCallback, paramLong);
    AppMethodBeat.o(7919);
  }
  
  public void retrieveLoginStatus(Context paramContext, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(7918);
    retrieveLoginStatus(paramContext, 5000L, paramLoginStatusCallback);
    AppMethodBeat.o(7918);
  }
  
  public LoginManager setAuthType(String paramString)
  {
    this.authType = paramString;
    return this;
  }
  
  public LoginManager setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    this.defaultAudience = paramDefaultAudience;
    return this;
  }
  
  public LoginManager setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    this.loginBehavior = paramLoginBehavior;
    return this;
  }
  
  public void unregisterCallback(CallbackManager paramCallbackManager)
  {
    AppMethodBeat.i(7913);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(7913);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    AppMethodBeat.o(7913);
  }
  
  static class ActivityStartActivityDelegate
    implements StartActivityDelegate
  {
    private final Activity activity;
    
    ActivityStartActivityDelegate(Activity paramActivity)
    {
      AppMethodBeat.i(7898);
      Validate.notNull(paramActivity, "activity");
      this.activity = paramActivity;
      AppMethodBeat.o(7898);
    }
    
    public Activity getActivityContext()
    {
      return this.activity;
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      AppMethodBeat.i(7899);
      this.activity.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(7899);
    }
  }
  
  static class FragmentStartActivityDelegate
    implements StartActivityDelegate
  {
    private final FragmentWrapper fragment;
    
    FragmentStartActivityDelegate(FragmentWrapper paramFragmentWrapper)
    {
      AppMethodBeat.i(7900);
      Validate.notNull(paramFragmentWrapper, "fragment");
      this.fragment = paramFragmentWrapper;
      AppMethodBeat.o(7900);
    }
    
    public Activity getActivityContext()
    {
      AppMethodBeat.i(7902);
      Activity localActivity = this.fragment.getActivity();
      AppMethodBeat.o(7902);
      return localActivity;
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      AppMethodBeat.i(7901);
      this.fragment.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(7901);
    }
  }
  
  static class LoginLoggerHolder
  {
    private static LoginLogger logger;
    
    /* Error */
    private static LoginLogger getLogger(Context paramContext)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: sipush 7903
      //   6: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: ifnull +20 -> 30
      //   13: aload_0
      //   14: ifnonnull +23 -> 37
      //   17: aconst_null
      //   18: astore_0
      //   19: sipush 7903
      //   22: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: ldc 2
      //   27: monitorexit
      //   28: aload_0
      //   29: areturn
      //   30: invokestatic 34	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
      //   33: astore_0
      //   34: goto -21 -> 13
      //   37: getstatic 36	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
      //   40: ifnonnull +17 -> 57
      //   43: new 38	com/facebook/login/LoginLogger
      //   46: dup
      //   47: aload_0
      //   48: invokestatic 42	com/facebook/FacebookSdk:getApplicationId	()Ljava/lang/String;
      //   51: invokespecial 45	com/facebook/login/LoginLogger:<init>	(Landroid/content/Context;Ljava/lang/String;)V
      //   54: putstatic 36	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
      //   57: getstatic 36	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
      //   60: astore_0
      //   61: sipush 7903
      //   64: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: goto -42 -> 25
      //   70: astore_0
      //   71: ldc 2
      //   73: monitorexit
      //   74: aload_0
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	paramContext	Context
      // Exception table:
      //   from	to	target	type
      //   3	9	70	finally
      //   19	25	70	finally
      //   30	34	70	finally
      //   37	57	70	finally
      //   57	67	70	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.LoginManager
 * JD-Core Version:    0.7.0.1
 */