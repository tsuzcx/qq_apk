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
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
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
    AppMethodBeat.i(96928);
    OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    AppMethodBeat.o(96928);
  }
  
  LoginManager()
  {
    AppMethodBeat.i(96881);
    this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    this.defaultAudience = DefaultAudience.FRIENDS;
    this.authType = "rerequest";
    Validate.sdkInitialized();
    this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
    AppMethodBeat.o(96881);
  }
  
  static LoginResult computeLoginResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(96919);
    Set localSet = paramRequest.getPermissions();
    HashSet localHashSet = new HashSet(paramAccessToken.getPermissions());
    if (paramRequest.isRerequest()) {
      localHashSet.retainAll(localSet);
    }
    paramRequest = new HashSet(localSet);
    paramRequest.removeAll(localHashSet);
    paramRequest = new LoginResult(paramAccessToken, localHashSet, paramRequest);
    AppMethodBeat.o(96919);
    return paramRequest;
  }
  
  private LoginClient.Request createLoginRequestFromResponse(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96887);
    Validate.notNull(paramGraphResponse, "response");
    paramGraphResponse = paramGraphResponse.getRequest().getAccessToken();
    if (paramGraphResponse != null) {}
    for (paramGraphResponse = paramGraphResponse.getPermissions();; paramGraphResponse = null)
    {
      paramGraphResponse = createLoginRequest(paramGraphResponse);
      AppMethodBeat.o(96887);
      return paramGraphResponse;
    }
  }
  
  private void finishLogin(AccessToken paramAccessToken, LoginClient.Request paramRequest, FacebookException paramFacebookException, boolean paramBoolean, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(96920);
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
        AppMethodBeat.o(96920);
        return;
      }
      if (paramFacebookException != null)
      {
        paramFacebookCallback.onError(paramFacebookException);
        AppMethodBeat.o(96920);
        return;
      }
      if (paramAccessToken != null)
      {
        setExpressLoginStatus(true);
        paramFacebookCallback.onSuccess(paramRequest);
      }
    }
    AppMethodBeat.o(96920);
  }
  
  static Map<String, String> getExtraDataFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(96892);
    if (paramIntent == null)
    {
      AppMethodBeat.o(96892);
      return null;
    }
    paramIntent = (LoginClient.Result)paramIntent.getParcelableExtra("com.facebook.LoginFragment:Result");
    if (paramIntent == null)
    {
      AppMethodBeat.o(96892);
      return null;
    }
    paramIntent = paramIntent.extraData;
    AppMethodBeat.o(96892);
    return paramIntent;
  }
  
  public static LoginManager getInstance()
  {
    AppMethodBeat.i(96882);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new LoginManager();
      }
      LoginManager localLoginManager = instance;
      AppMethodBeat.o(96882);
      return localLoginManager;
    }
    finally
    {
      AppMethodBeat.o(96882);
    }
  }
  
  private static Set<String> getOtherPublishPermissions()
  {
    AppMethodBeat.i(96910);
    Set localSet = Collections.unmodifiableSet(new LoginManager.2());
    AppMethodBeat.o(96910);
    return localSet;
  }
  
  private static Profile getProfileFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(96924);
    String str1 = paramBundle.getString("com.facebook.platform.extra.PROFILE_NAME");
    String str2 = paramBundle.getString("com.facebook.platform.extra.PROFILE_FIRST_NAME");
    String str3 = paramBundle.getString("com.facebook.platform.extra.PROFILE_MIDDLE_NAME");
    String str4 = paramBundle.getString("com.facebook.platform.extra.PROFILE_LAST_NAME");
    String str5 = paramBundle.getString("com.facebook.platform.extra.PROFILE_LINK");
    paramBundle = paramBundle.getString("com.facebook.platform.extra.PROFILE_USER_ID");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null) && (str5 != null) && (paramBundle != null))
    {
      paramBundle = new Profile(paramBundle, str2, str3, str4, str1, Uri.parse(str5));
      AppMethodBeat.o(96924);
      return paramBundle;
    }
    AppMethodBeat.o(96924);
    return null;
  }
  
  private static void handleLoginStatusError(String paramString1, String paramString2, String paramString3, LoginLogger paramLoginLogger, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(96925);
    paramString1 = new FacebookException(paramString1 + ": " + paramString2);
    paramLoginLogger.logLoginStatusError(paramString3, paramString1);
    paramLoginStatusCallback.onError(paramString1);
    AppMethodBeat.o(96925);
  }
  
  private boolean isExpressLoginAllowed()
  {
    AppMethodBeat.i(96923);
    boolean bool = this.sharedPreferences.getBoolean("express_login_allowed", true);
    AppMethodBeat.o(96923);
    return bool;
  }
  
  static boolean isPublishPermission(String paramString)
  {
    AppMethodBeat.i(96909);
    if ((paramString != null) && ((paramString.startsWith("publish")) || (paramString.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(paramString))))
    {
      AppMethodBeat.o(96909);
      return true;
    }
    AppMethodBeat.o(96909);
    return false;
  }
  
  private void logCompleteLogin(Context paramContext, LoginClient.Result.Code paramCode, Map<String, String> paramMap, Exception paramException, boolean paramBoolean, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96915);
    LoginLogger localLoginLogger = LoginManager.LoginLoggerHolder.access$000(paramContext);
    if (localLoginLogger == null)
    {
      AppMethodBeat.o(96915);
      return;
    }
    if (paramRequest == null)
    {
      localLoginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
      AppMethodBeat.o(96915);
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramContext = "1";; paramContext = "0")
    {
      localHashMap.put("try_login_activity", paramContext);
      localLoginLogger.logCompleteLogin(paramRequest.getAuthId(), localHashMap, paramCode, paramMap, paramException);
      AppMethodBeat.o(96915);
      return;
    }
  }
  
  private void logInWithPublishPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96905);
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
    AppMethodBeat.o(96905);
  }
  
  private void logInWithReadPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96898);
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
    AppMethodBeat.o(96898);
  }
  
  private void logStartLogin(Context paramContext, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96914);
    paramContext = LoginManager.LoginLoggerHolder.access$000(paramContext);
    if ((paramContext != null) && (paramRequest != null)) {
      paramContext.logStartLogin(paramRequest);
    }
    AppMethodBeat.o(96914);
  }
  
  private void reauthorizeDataAccess(FragmentWrapper paramFragmentWrapper)
  {
    AppMethodBeat.i(96902);
    LoginClient.Request localRequest = createReauthorizeRequest();
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), localRequest);
    AppMethodBeat.o(96902);
  }
  
  private void resolveError(FragmentWrapper paramFragmentWrapper, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96886);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), createLoginRequestFromResponse(paramGraphResponse));
    AppMethodBeat.o(96886);
  }
  
  private boolean resolveIntent(Intent paramIntent)
  {
    AppMethodBeat.i(96917);
    if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(paramIntent, 0) != null)
    {
      AppMethodBeat.o(96917);
      return true;
    }
    AppMethodBeat.o(96917);
    return false;
  }
  
  private void retrieveLoginStatusImpl(Context paramContext, LoginStatusCallback paramLoginStatusCallback, long paramLong)
  {
    AppMethodBeat.i(96921);
    String str1 = FacebookSdk.getApplicationId();
    String str2 = UUID.randomUUID().toString();
    LoginLogger localLoginLogger = new LoginLogger(paramContext, str1);
    if (!isExpressLoginAllowed())
    {
      localLoginLogger.logLoginStatusFailure(str2);
      paramLoginStatusCallback.onFailure();
      AppMethodBeat.o(96921);
      return;
    }
    paramContext = new LoginStatusClient(paramContext, str1, str2, FacebookSdk.getGraphApiVersion(), paramLong);
    paramContext.setCompletedListener(new LoginManager.4(this, str2, localLoginLogger, paramLoginStatusCallback, str1));
    localLoginLogger.logLoginStatusStart(str2);
    if (!paramContext.start())
    {
      localLoginLogger.logLoginStatusFailure(str2);
      paramLoginStatusCallback.onFailure();
    }
    AppMethodBeat.o(96921);
  }
  
  private void setExpressLoginStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(96922);
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putBoolean("express_login_allowed", paramBoolean);
    localEditor.apply();
    AppMethodBeat.o(96922);
  }
  
  private void startLogin(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96913);
    logStartLogin(paramStartActivityDelegate.getActivityContext(), paramRequest);
    CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new LoginManager.3(this));
    if (!tryFacebookActivity(paramStartActivityDelegate, paramRequest))
    {
      FacebookException localFacebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
      logCompleteLogin(paramStartActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, localFacebookException, false, paramRequest);
      AppMethodBeat.o(96913);
      throw localFacebookException;
    }
    AppMethodBeat.o(96913);
  }
  
  private boolean tryFacebookActivity(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96916);
    paramRequest = getFacebookActivityIntent(paramRequest);
    if (!resolveIntent(paramRequest))
    {
      AppMethodBeat.o(96916);
      return false;
    }
    try
    {
      paramStartActivityDelegate.startActivityForResult(paramRequest, LoginClient.getLoginRequestCode());
      AppMethodBeat.o(96916);
      return true;
    }
    catch (ActivityNotFoundException paramStartActivityDelegate)
    {
      AppMethodBeat.o(96916);
    }
    return false;
  }
  
  private void validatePublishPermissions(Collection<String> paramCollection)
  {
    AppMethodBeat.i(96908);
    if (paramCollection == null)
    {
      AppMethodBeat.o(96908);
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (!isPublishPermission(str))
      {
        paramCollection = new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] { str }));
        AppMethodBeat.o(96908);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(96908);
  }
  
  private void validateReadPermissions(Collection<String> paramCollection)
  {
    AppMethodBeat.i(96907);
    if (paramCollection == null)
    {
      AppMethodBeat.o(96907);
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (isPublishPermission(str))
      {
        paramCollection = new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] { str }));
        AppMethodBeat.o(96907);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(96907);
  }
  
  protected LoginClient.Request createLoginRequest(Collection<String> paramCollection)
  {
    AppMethodBeat.i(96911);
    LoginBehavior localLoginBehavior = this.loginBehavior;
    if (paramCollection != null) {}
    for (paramCollection = new HashSet(paramCollection);; paramCollection = new HashSet())
    {
      paramCollection = new LoginClient.Request(localLoginBehavior, Collections.unmodifiableSet(paramCollection), this.defaultAudience, this.authType, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
      paramCollection.setRerequest(AccessToken.isCurrentAccessTokenActive());
      AppMethodBeat.o(96911);
      return paramCollection;
    }
  }
  
  protected LoginClient.Request createReauthorizeRequest()
  {
    AppMethodBeat.i(96912);
    LoginClient.Request localRequest = new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.defaultAudience, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
    AppMethodBeat.o(96912);
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
    AppMethodBeat.i(96918);
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(paramRequest.getLoginBehavior().toString());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("request", paramRequest);
    localIntent.putExtra("com.facebook.LoginFragment:Request", localBundle);
    AppMethodBeat.o(96918);
    return localIntent;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return this.loginBehavior;
  }
  
  public void logInWithPublishPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96906);
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new LoginManager.ActivityStartActivityDelegate(paramActivity), paramCollection);
    AppMethodBeat.o(96906);
  }
  
  public void logInWithPublishPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96904);
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(96904);
  }
  
  public void logInWithPublishPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96903);
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(96903);
  }
  
  public void logInWithReadPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96899);
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new LoginManager.ActivityStartActivityDelegate(paramActivity), paramCollection);
    AppMethodBeat.o(96899);
  }
  
  public void logInWithReadPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96897);
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(96897);
  }
  
  public void logInWithReadPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    AppMethodBeat.i(96896);
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
    AppMethodBeat.o(96896);
  }
  
  public void logOut()
  {
    AppMethodBeat.i(96893);
    AccessToken.setCurrentAccessToken(null);
    Profile.setCurrentProfile(null);
    setExpressLoginStatus(false);
    AppMethodBeat.o(96893);
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(96890);
    boolean bool = onActivityResult(paramInt, paramIntent, null);
    AppMethodBeat.o(96890);
    return bool;
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(96891);
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
          AppMethodBeat.o(96891);
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
    AppMethodBeat.i(96900);
    LoginClient.Request localRequest = createReauthorizeRequest();
    startLogin(new LoginManager.ActivityStartActivityDelegate(paramActivity), localRequest);
    AppMethodBeat.o(96900);
  }
  
  public void reauthorizeDataAccess(android.support.v4.app.Fragment paramFragment)
  {
    AppMethodBeat.i(96901);
    reauthorizeDataAccess(new FragmentWrapper(paramFragment));
    AppMethodBeat.o(96901);
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(96888);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(96888);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new LoginManager.1(this, paramFacebookCallback));
    AppMethodBeat.o(96888);
  }
  
  public void resolveError(Activity paramActivity, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96883);
    startLogin(new LoginManager.ActivityStartActivityDelegate(paramActivity), createLoginRequestFromResponse(paramGraphResponse));
    AppMethodBeat.o(96883);
  }
  
  public void resolveError(android.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96885);
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
    AppMethodBeat.o(96885);
  }
  
  public void resolveError(android.support.v4.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96884);
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
    AppMethodBeat.o(96884);
  }
  
  public void retrieveLoginStatus(Context paramContext, long paramLong, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(96895);
    retrieveLoginStatusImpl(paramContext, paramLoginStatusCallback, paramLong);
    AppMethodBeat.o(96895);
  }
  
  public void retrieveLoginStatus(Context paramContext, LoginStatusCallback paramLoginStatusCallback)
  {
    AppMethodBeat.i(96894);
    retrieveLoginStatus(paramContext, 5000L, paramLoginStatusCallback);
    AppMethodBeat.o(96894);
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
    AppMethodBeat.i(96889);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(96889);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    AppMethodBeat.o(96889);
  }
  
  static class FragmentStartActivityDelegate
    implements StartActivityDelegate
  {
    private final FragmentWrapper fragment;
    
    FragmentStartActivityDelegate(FragmentWrapper paramFragmentWrapper)
    {
      AppMethodBeat.i(96876);
      Validate.notNull(paramFragmentWrapper, "fragment");
      this.fragment = paramFragmentWrapper;
      AppMethodBeat.o(96876);
    }
    
    public Activity getActivityContext()
    {
      AppMethodBeat.i(96878);
      Activity localActivity = this.fragment.getActivity();
      AppMethodBeat.o(96878);
      return localActivity;
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      AppMethodBeat.i(96877);
      this.fragment.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(96877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.LoginManager
 * JD-Core Version:    0.7.0.1
 */