package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient
  implements Parcelable
{
  public static final Parcelable.Creator<LoginClient> CREATOR;
  LoginClient.BackgroundProcessingListener backgroundProcessingListener;
  boolean checkedInternetPermission;
  int currentHandler;
  Map<String, String> extraData;
  Fragment fragment;
  LoginMethodHandler[] handlersToTry;
  Map<String, String> loggingExtras;
  private LoginLogger loginLogger;
  LoginClient.OnCompletedListener onCompletedListener;
  LoginClient.Request pendingRequest;
  
  static
  {
    AppMethodBeat.i(96842);
    CREATOR = new LoginClient.1();
    AppMethodBeat.o(96842);
  }
  
  public LoginClient(Parcel paramParcel)
  {
    AppMethodBeat.i(96840);
    this.currentHandler = -1;
    Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
    this.handlersToTry = new LoginMethodHandler[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      this.handlersToTry[i] = ((LoginMethodHandler)arrayOfParcelable[i]);
      this.handlersToTry[i].setLoginClient(this);
      i += 1;
    }
    this.currentHandler = paramParcel.readInt();
    this.pendingRequest = ((LoginClient.Request)paramParcel.readParcelable(LoginClient.Request.class.getClassLoader()));
    this.loggingExtras = Utility.readStringMapFromParcel(paramParcel);
    this.extraData = Utility.readStringMapFromParcel(paramParcel);
    AppMethodBeat.o(96840);
  }
  
  public LoginClient(Fragment paramFragment)
  {
    this.currentHandler = -1;
    this.fragment = paramFragment;
  }
  
  private void addLoggingExtra(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(96826);
    if (this.loggingExtras == null) {
      this.loggingExtras = new HashMap();
    }
    String str = paramString2;
    if (this.loggingExtras.containsKey(paramString1))
    {
      str = paramString2;
      if (paramBoolean) {
        str = (String)this.loggingExtras.get(paramString1) + "," + paramString2;
      }
    }
    this.loggingExtras.put(paramString1, str);
    AppMethodBeat.o(96826);
  }
  
  private void completeWithFailure()
  {
    AppMethodBeat.i(96825);
    complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
    AppMethodBeat.o(96825);
  }
  
  static String getE2E()
  {
    AppMethodBeat.i(96839);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("init", System.currentTimeMillis());
      label23:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(96839);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label23;
    }
  }
  
  private LoginLogger getLogger()
  {
    AppMethodBeat.i(96833);
    if ((this.loginLogger == null) || (!this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId()))) {
      this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
    }
    LoginLogger localLoginLogger = this.loginLogger;
    AppMethodBeat.o(96833);
    return localLoginLogger;
  }
  
  public static int getLoginRequestCode()
  {
    AppMethodBeat.i(96817);
    int i = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    AppMethodBeat.o(96817);
    return i;
  }
  
  private void logAuthorizationMethodComplete(String paramString, LoginClient.Result paramResult, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96837);
    logAuthorizationMethodComplete(paramString, paramResult.code.getLoggingValue(), paramResult.errorMessage, paramResult.errorCode, paramMap);
    AppMethodBeat.o(96837);
  }
  
  private void logAuthorizationMethodComplete(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96838);
    if (this.pendingRequest == null)
    {
      getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", paramString1);
      AppMethodBeat.o(96838);
      return;
    }
    getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), paramString1, paramString2, paramString3, paramString4, paramMap);
    AppMethodBeat.o(96838);
  }
  
  private void notifyOnCompleteListener(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96834);
    if (this.onCompletedListener != null) {
      this.onCompletedListener.onCompleted(paramResult);
    }
    AppMethodBeat.o(96834);
  }
  
  void addExtraData(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(96827);
    if (this.extraData == null) {
      this.extraData = new HashMap();
    }
    String str = paramString2;
    if (this.extraData.containsKey(paramString1))
    {
      str = paramString2;
      if (paramBoolean) {
        str = (String)this.extraData.get(paramString1) + "," + paramString2;
      }
    }
    this.extraData.put(paramString1, str);
    AppMethodBeat.o(96827);
  }
  
  void authorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96819);
    if (paramRequest == null)
    {
      AppMethodBeat.o(96819);
      return;
    }
    if (this.pendingRequest != null)
    {
      paramRequest = new FacebookException("Attempted to authorize while a request is pending.");
      AppMethodBeat.o(96819);
      throw paramRequest;
    }
    if ((AccessToken.isCurrentAccessTokenActive()) && (!checkInternetPermission()))
    {
      AppMethodBeat.o(96819);
      return;
    }
    this.pendingRequest = paramRequest;
    this.handlersToTry = getHandlersToTry(paramRequest);
    tryNextHandler();
    AppMethodBeat.o(96819);
  }
  
  void cancelCurrentHandler()
  {
    AppMethodBeat.i(96820);
    if (this.currentHandler >= 0) {
      getCurrentHandler().cancel();
    }
    AppMethodBeat.o(96820);
  }
  
  boolean checkInternetPermission()
  {
    AppMethodBeat.i(96823);
    if (this.checkedInternetPermission)
    {
      AppMethodBeat.o(96823);
      return true;
    }
    if (checkPermission("android.permission.INTERNET") != 0)
    {
      Object localObject = getActivity();
      String str = ((Activity)localObject).getString(2131296308);
      localObject = ((Activity)localObject).getString(2131296307);
      complete(LoginClient.Result.createErrorResult(this.pendingRequest, str, (String)localObject));
      AppMethodBeat.o(96823);
      return false;
    }
    this.checkedInternetPermission = true;
    AppMethodBeat.o(96823);
    return true;
  }
  
  int checkPermission(String paramString)
  {
    AppMethodBeat.i(96831);
    int i = getActivity().checkCallingOrSelfPermission(paramString);
    AppMethodBeat.o(96831);
    return i;
  }
  
  void complete(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96830);
    LoginMethodHandler localLoginMethodHandler = getCurrentHandler();
    if (localLoginMethodHandler != null) {
      logAuthorizationMethodComplete(localLoginMethodHandler.getNameForLogging(), paramResult, localLoginMethodHandler.methodLoggingExtras);
    }
    if (this.loggingExtras != null) {
      paramResult.loggingExtras = this.loggingExtras;
    }
    if (this.extraData != null) {
      paramResult.extraData = this.extraData;
    }
    this.handlersToTry = null;
    this.currentHandler = -1;
    this.pendingRequest = null;
    this.loggingExtras = null;
    notifyOnCompleteListener(paramResult);
    AppMethodBeat.o(96830);
  }
  
  void completeAndValidate(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96829);
    if ((paramResult.token != null) && (AccessToken.isCurrentAccessTokenActive()))
    {
      validateSameFbidAndFinish(paramResult);
      AppMethodBeat.o(96829);
      return;
    }
    complete(paramResult);
    AppMethodBeat.o(96829);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  FragmentActivity getActivity()
  {
    AppMethodBeat.i(96816);
    FragmentActivity localFragmentActivity = this.fragment.getActivity();
    AppMethodBeat.o(96816);
    return localFragmentActivity;
  }
  
  LoginClient.BackgroundProcessingListener getBackgroundProcessingListener()
  {
    return this.backgroundProcessingListener;
  }
  
  LoginMethodHandler getCurrentHandler()
  {
    if (this.currentHandler >= 0) {
      return this.handlersToTry[this.currentHandler];
    }
    return null;
  }
  
  public Fragment getFragment()
  {
    return this.fragment;
  }
  
  protected LoginMethodHandler[] getHandlersToTry(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96822);
    ArrayList localArrayList = new ArrayList();
    paramRequest = paramRequest.getLoginBehavior();
    if (paramRequest.allowsGetTokenAuth()) {
      localArrayList.add(new GetTokenLoginMethodHandler(this));
    }
    if (paramRequest.allowsKatanaAuth()) {
      localArrayList.add(new KatanaProxyLoginMethodHandler(this));
    }
    if (paramRequest.allowsFacebookLiteAuth()) {
      localArrayList.add(new FacebookLiteLoginMethodHandler(this));
    }
    if (paramRequest.allowsCustomTabAuth()) {
      localArrayList.add(new CustomTabLoginMethodHandler(this));
    }
    if (paramRequest.allowsWebViewAuth()) {
      localArrayList.add(new WebViewLoginMethodHandler(this));
    }
    if (paramRequest.allowsDeviceAuth()) {
      localArrayList.add(new DeviceAuthMethodHandler(this));
    }
    paramRequest = new LoginMethodHandler[localArrayList.size()];
    localArrayList.toArray(paramRequest);
    AppMethodBeat.o(96822);
    return paramRequest;
  }
  
  boolean getInProgress()
  {
    return (this.pendingRequest != null) && (this.currentHandler >= 0);
  }
  
  LoginClient.OnCompletedListener getOnCompletedListener()
  {
    return this.onCompletedListener;
  }
  
  public LoginClient.Request getPendingRequest()
  {
    return this.pendingRequest;
  }
  
  void notifyBackgroundProcessingStart()
  {
    AppMethodBeat.i(96835);
    if (this.backgroundProcessingListener != null) {
      this.backgroundProcessingListener.onBackgroundProcessingStarted();
    }
    AppMethodBeat.o(96835);
  }
  
  void notifyBackgroundProcessingStop()
  {
    AppMethodBeat.i(96836);
    if (this.backgroundProcessingListener != null) {
      this.backgroundProcessingListener.onBackgroundProcessingStopped();
    }
    AppMethodBeat.o(96836);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(96821);
    if (this.pendingRequest != null)
    {
      boolean bool = getCurrentHandler().onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(96821);
      return bool;
    }
    AppMethodBeat.o(96821);
    return false;
  }
  
  void setBackgroundProcessingListener(LoginClient.BackgroundProcessingListener paramBackgroundProcessingListener)
  {
    this.backgroundProcessingListener = paramBackgroundProcessingListener;
  }
  
  void setFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(96815);
    if (this.fragment != null)
    {
      paramFragment = new FacebookException("Can't set fragment once it is already set.");
      AppMethodBeat.o(96815);
      throw paramFragment;
    }
    this.fragment = paramFragment;
    AppMethodBeat.o(96815);
  }
  
  void setOnCompletedListener(LoginClient.OnCompletedListener paramOnCompletedListener)
  {
    this.onCompletedListener = paramOnCompletedListener;
  }
  
  void startOrContinueAuth(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96818);
    if (!getInProgress()) {
      authorize(paramRequest);
    }
    AppMethodBeat.o(96818);
  }
  
  boolean tryCurrentHandler()
  {
    AppMethodBeat.i(96828);
    LoginMethodHandler localLoginMethodHandler = getCurrentHandler();
    if ((localLoginMethodHandler.needsInternetPermission()) && (!checkInternetPermission()))
    {
      addLoggingExtra("no_internet_permission", "1", false);
      AppMethodBeat.o(96828);
      return false;
    }
    boolean bool = localLoginMethodHandler.tryAuthorize(this.pendingRequest);
    if (bool) {
      getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), localLoginMethodHandler.getNameForLogging());
    }
    for (;;)
    {
      AppMethodBeat.o(96828);
      return bool;
      getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), localLoginMethodHandler.getNameForLogging());
      addLoggingExtra("not_tried", localLoginMethodHandler.getNameForLogging(), true);
    }
  }
  
  void tryNextHandler()
  {
    AppMethodBeat.i(96824);
    if (this.currentHandler >= 0) {
      logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
    }
    while ((this.handlersToTry != null) && (this.currentHandler < this.handlersToTry.length - 1))
    {
      this.currentHandler += 1;
      if (tryCurrentHandler())
      {
        AppMethodBeat.o(96824);
        return;
      }
    }
    if (this.pendingRequest != null) {
      completeWithFailure();
    }
    AppMethodBeat.o(96824);
  }
  
  void validateSameFbidAndFinish(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96832);
    if (paramResult.token == null)
    {
      paramResult = new FacebookException("Can't validate without a token");
      AppMethodBeat.o(96832);
      throw paramResult;
    }
    AccessToken localAccessToken1 = AccessToken.getCurrentAccessToken();
    AccessToken localAccessToken2 = paramResult.token;
    if ((localAccessToken1 != null) && (localAccessToken2 != null)) {}
    try
    {
      if (localAccessToken1.getUserId().equals(localAccessToken2.getUserId())) {}
      for (paramResult = LoginClient.Result.createTokenResult(this.pendingRequest, paramResult.token);; paramResult = LoginClient.Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null))
      {
        complete(paramResult);
        AppMethodBeat.o(96832);
        return;
      }
      return;
    }
    catch (Exception paramResult)
    {
      complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Caught exception", paramResult.getMessage()));
      AppMethodBeat.o(96832);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96841);
    paramParcel.writeParcelableArray(this.handlersToTry, paramInt);
    paramParcel.writeInt(this.currentHandler);
    paramParcel.writeParcelable(this.pendingRequest, paramInt);
    Utility.writeStringMapToParcel(paramParcel, this.loggingExtras);
    Utility.writeStringMapToParcel(paramParcel, this.extraData);
    AppMethodBeat.o(96841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.LoginClient
 * JD-Core Version:    0.7.0.1
 */