package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient
  implements Parcelable
{
  public static final Parcelable.Creator<LoginClient> CREATOR;
  BackgroundProcessingListener backgroundProcessingListener;
  boolean checkedInternetPermission;
  int currentHandler;
  Map<String, String> extraData;
  Fragment fragment;
  LoginMethodHandler[] handlersToTry;
  Map<String, String> loggingExtras;
  private LoginLogger loginLogger;
  OnCompletedListener onCompletedListener;
  Request pendingRequest;
  
  static
  {
    AppMethodBeat.i(7866);
    CREATOR = new Parcelable.Creator()
    {
      public final LoginClient createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(7813);
        paramAnonymousParcel = new LoginClient(paramAnonymousParcel);
        AppMethodBeat.o(7813);
        return paramAnonymousParcel;
      }
      
      public final LoginClient[] newArray(int paramAnonymousInt)
      {
        return new LoginClient[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(7866);
  }
  
  public LoginClient(Parcel paramParcel)
  {
    AppMethodBeat.i(7864);
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
    this.pendingRequest = ((Request)paramParcel.readParcelable(Request.class.getClassLoader()));
    this.loggingExtras = Utility.readStringMapFromParcel(paramParcel);
    this.extraData = Utility.readStringMapFromParcel(paramParcel);
    AppMethodBeat.o(7864);
  }
  
  public LoginClient(Fragment paramFragment)
  {
    this.currentHandler = -1;
    this.fragment = paramFragment;
  }
  
  private void addLoggingExtra(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(7850);
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
    AppMethodBeat.o(7850);
  }
  
  private void completeWithFailure()
  {
    AppMethodBeat.i(7849);
    complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
    AppMethodBeat.o(7849);
  }
  
  static String getE2E()
  {
    AppMethodBeat.i(7863);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("init", System.currentTimeMillis());
      label24:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(7863);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
  
  private LoginLogger getLogger()
  {
    AppMethodBeat.i(7857);
    if ((this.loginLogger == null) || (!this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId()))) {
      this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
    }
    LoginLogger localLoginLogger = this.loginLogger;
    AppMethodBeat.o(7857);
    return localLoginLogger;
  }
  
  public static int getLoginRequestCode()
  {
    AppMethodBeat.i(7841);
    int i = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    AppMethodBeat.o(7841);
    return i;
  }
  
  private void logAuthorizationMethodComplete(String paramString, Result paramResult, Map<String, String> paramMap)
  {
    AppMethodBeat.i(7861);
    logAuthorizationMethodComplete(paramString, paramResult.code.getLoggingValue(), paramResult.errorMessage, paramResult.errorCode, paramMap);
    AppMethodBeat.o(7861);
  }
  
  private void logAuthorizationMethodComplete(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    AppMethodBeat.i(7862);
    if (this.pendingRequest == null)
    {
      getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", paramString1);
      AppMethodBeat.o(7862);
      return;
    }
    getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), paramString1, paramString2, paramString3, paramString4, paramMap);
    AppMethodBeat.o(7862);
  }
  
  private void notifyOnCompleteListener(Result paramResult)
  {
    AppMethodBeat.i(7858);
    if (this.onCompletedListener != null) {
      this.onCompletedListener.onCompleted(paramResult);
    }
    AppMethodBeat.o(7858);
  }
  
  void addExtraData(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(7851);
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
    AppMethodBeat.o(7851);
  }
  
  void authorize(Request paramRequest)
  {
    AppMethodBeat.i(7843);
    if (paramRequest == null)
    {
      AppMethodBeat.o(7843);
      return;
    }
    if (this.pendingRequest != null)
    {
      paramRequest = new FacebookException("Attempted to authorize while a request is pending.");
      AppMethodBeat.o(7843);
      throw paramRequest;
    }
    if ((AccessToken.isCurrentAccessTokenActive()) && (!checkInternetPermission()))
    {
      AppMethodBeat.o(7843);
      return;
    }
    this.pendingRequest = paramRequest;
    this.handlersToTry = getHandlersToTry(paramRequest);
    tryNextHandler();
    AppMethodBeat.o(7843);
  }
  
  void cancelCurrentHandler()
  {
    AppMethodBeat.i(7844);
    if (this.currentHandler >= 0) {
      getCurrentHandler().cancel();
    }
    AppMethodBeat.o(7844);
  }
  
  boolean checkInternetPermission()
  {
    AppMethodBeat.i(7847);
    if (this.checkedInternetPermission)
    {
      AppMethodBeat.o(7847);
      return true;
    }
    if (checkPermission("android.permission.INTERNET") != 0)
    {
      Object localObject = getActivity();
      String str = ((Activity)localObject).getString(2131757725);
      localObject = ((Activity)localObject).getString(2131757724);
      complete(Result.createErrorResult(this.pendingRequest, str, (String)localObject));
      AppMethodBeat.o(7847);
      return false;
    }
    this.checkedInternetPermission = true;
    AppMethodBeat.o(7847);
    return true;
  }
  
  int checkPermission(String paramString)
  {
    AppMethodBeat.i(7855);
    int i = getActivity().checkCallingOrSelfPermission(paramString);
    AppMethodBeat.o(7855);
    return i;
  }
  
  void complete(Result paramResult)
  {
    AppMethodBeat.i(7854);
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
    AppMethodBeat.o(7854);
  }
  
  void completeAndValidate(Result paramResult)
  {
    AppMethodBeat.i(7853);
    if ((paramResult.token != null) && (AccessToken.isCurrentAccessTokenActive()))
    {
      validateSameFbidAndFinish(paramResult);
      AppMethodBeat.o(7853);
      return;
    }
    complete(paramResult);
    AppMethodBeat.o(7853);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  FragmentActivity getActivity()
  {
    AppMethodBeat.i(7840);
    FragmentActivity localFragmentActivity = this.fragment.getActivity();
    AppMethodBeat.o(7840);
    return localFragmentActivity;
  }
  
  BackgroundProcessingListener getBackgroundProcessingListener()
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
  
  protected LoginMethodHandler[] getHandlersToTry(Request paramRequest)
  {
    AppMethodBeat.i(7846);
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
    AppMethodBeat.o(7846);
    return paramRequest;
  }
  
  boolean getInProgress()
  {
    return (this.pendingRequest != null) && (this.currentHandler >= 0);
  }
  
  OnCompletedListener getOnCompletedListener()
  {
    return this.onCompletedListener;
  }
  
  public Request getPendingRequest()
  {
    return this.pendingRequest;
  }
  
  void notifyBackgroundProcessingStart()
  {
    AppMethodBeat.i(7859);
    if (this.backgroundProcessingListener != null) {
      this.backgroundProcessingListener.onBackgroundProcessingStarted();
    }
    AppMethodBeat.o(7859);
  }
  
  void notifyBackgroundProcessingStop()
  {
    AppMethodBeat.i(7860);
    if (this.backgroundProcessingListener != null) {
      this.backgroundProcessingListener.onBackgroundProcessingStopped();
    }
    AppMethodBeat.o(7860);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(7845);
    if (this.pendingRequest != null)
    {
      boolean bool = getCurrentHandler().onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(7845);
      return bool;
    }
    AppMethodBeat.o(7845);
    return false;
  }
  
  void setBackgroundProcessingListener(BackgroundProcessingListener paramBackgroundProcessingListener)
  {
    this.backgroundProcessingListener = paramBackgroundProcessingListener;
  }
  
  void setFragment(Fragment paramFragment)
  {
    AppMethodBeat.i(7839);
    if (this.fragment != null)
    {
      paramFragment = new FacebookException("Can't set fragment once it is already set.");
      AppMethodBeat.o(7839);
      throw paramFragment;
    }
    this.fragment = paramFragment;
    AppMethodBeat.o(7839);
  }
  
  void setOnCompletedListener(OnCompletedListener paramOnCompletedListener)
  {
    this.onCompletedListener = paramOnCompletedListener;
  }
  
  void startOrContinueAuth(Request paramRequest)
  {
    AppMethodBeat.i(7842);
    if (!getInProgress()) {
      authorize(paramRequest);
    }
    AppMethodBeat.o(7842);
  }
  
  boolean tryCurrentHandler()
  {
    AppMethodBeat.i(7852);
    LoginMethodHandler localLoginMethodHandler = getCurrentHandler();
    if ((localLoginMethodHandler.needsInternetPermission()) && (!checkInternetPermission()))
    {
      addLoggingExtra("no_internet_permission", "1", false);
      AppMethodBeat.o(7852);
      return false;
    }
    boolean bool = localLoginMethodHandler.tryAuthorize(this.pendingRequest);
    if (bool) {
      getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), localLoginMethodHandler.getNameForLogging());
    }
    for (;;)
    {
      AppMethodBeat.o(7852);
      return bool;
      getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), localLoginMethodHandler.getNameForLogging());
      addLoggingExtra("not_tried", localLoginMethodHandler.getNameForLogging(), true);
    }
  }
  
  void tryNextHandler()
  {
    AppMethodBeat.i(7848);
    if (this.currentHandler >= 0) {
      logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
    }
    while ((this.handlersToTry != null) && (this.currentHandler < this.handlersToTry.length - 1))
    {
      this.currentHandler += 1;
      if (tryCurrentHandler())
      {
        AppMethodBeat.o(7848);
        return;
      }
    }
    if (this.pendingRequest != null) {
      completeWithFailure();
    }
    AppMethodBeat.o(7848);
  }
  
  void validateSameFbidAndFinish(Result paramResult)
  {
    AppMethodBeat.i(7856);
    if (paramResult.token == null)
    {
      paramResult = new FacebookException("Can't validate without a token");
      AppMethodBeat.o(7856);
      throw paramResult;
    }
    AccessToken localAccessToken1 = AccessToken.getCurrentAccessToken();
    AccessToken localAccessToken2 = paramResult.token;
    if ((localAccessToken1 != null) && (localAccessToken2 != null)) {}
    try
    {
      if (localAccessToken1.getUserId().equals(localAccessToken2.getUserId())) {}
      for (paramResult = Result.createTokenResult(this.pendingRequest, paramResult.token);; paramResult = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null))
      {
        complete(paramResult);
        AppMethodBeat.o(7856);
        return;
      }
      return;
    }
    catch (Exception paramResult)
    {
      complete(Result.createErrorResult(this.pendingRequest, "Caught exception", paramResult.getMessage()));
      AppMethodBeat.o(7856);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7865);
    paramParcel.writeParcelableArray(this.handlersToTry, paramInt);
    paramParcel.writeInt(this.currentHandler);
    paramParcel.writeParcelable(this.pendingRequest, paramInt);
    Utility.writeStringMapToParcel(paramParcel, this.loggingExtras);
    Utility.writeStringMapToParcel(paramParcel, this.extraData);
    AppMethodBeat.o(7865);
  }
  
  static abstract interface BackgroundProcessingListener
  {
    public abstract void onBackgroundProcessingStarted();
    
    public abstract void onBackgroundProcessingStopped();
  }
  
  public static abstract interface OnCompletedListener
  {
    public abstract void onCompleted(LoginClient.Result paramResult);
  }
  
  public static class Request
    implements Parcelable
  {
    public static final Parcelable.Creator<Request> CREATOR;
    private final String applicationId;
    private final String authId;
    private String authType;
    private final DefaultAudience defaultAudience;
    private String deviceAuthTargetUserId;
    private String deviceRedirectUriString;
    private boolean isRerequest;
    private final LoginBehavior loginBehavior;
    private Set<String> permissions;
    
    static
    {
      AppMethodBeat.i(7824);
      CREATOR = new Parcelable.Creator()
      {
        public final LoginClient.Request createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(7816);
          paramAnonymousParcel = new LoginClient.Request(paramAnonymousParcel, null);
          AppMethodBeat.o(7816);
          return paramAnonymousParcel;
        }
        
        public final LoginClient.Request[] newArray(int paramAnonymousInt)
        {
          return new LoginClient.Request[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(7824);
    }
    
    private Request(Parcel paramParcel)
    {
      AppMethodBeat.i(7822);
      this.isRerequest = false;
      Object localObject1 = paramParcel.readString();
      if (localObject1 != null)
      {
        localObject1 = LoginBehavior.valueOf((String)localObject1);
        this.loginBehavior = ((LoginBehavior)localObject1);
        localObject1 = new ArrayList();
        paramParcel.readStringList((List)localObject1);
        this.permissions = new HashSet((Collection)localObject1);
        String str = paramParcel.readString();
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = DefaultAudience.valueOf(str);
        }
        this.defaultAudience = ((DefaultAudience)localObject1);
        this.applicationId = paramParcel.readString();
        this.authId = paramParcel.readString();
        if (paramParcel.readByte() == 0) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.isRerequest = bool;
        this.deviceRedirectUriString = paramParcel.readString();
        this.authType = paramParcel.readString();
        this.deviceAuthTargetUserId = paramParcel.readString();
        AppMethodBeat.o(7822);
        return;
        localObject1 = null;
        break;
      }
    }
    
    Request(LoginBehavior paramLoginBehavior, Set<String> paramSet, DefaultAudience paramDefaultAudience, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(7819);
      this.isRerequest = false;
      this.loginBehavior = paramLoginBehavior;
      if (paramSet != null) {}
      for (;;)
      {
        this.permissions = paramSet;
        this.defaultAudience = paramDefaultAudience;
        this.authType = paramString1;
        this.applicationId = paramString2;
        this.authId = paramString3;
        AppMethodBeat.o(7819);
        return;
        paramSet = new HashSet();
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    String getApplicationId()
    {
      return this.applicationId;
    }
    
    String getAuthId()
    {
      return this.authId;
    }
    
    String getAuthType()
    {
      return this.authType;
    }
    
    DefaultAudience getDefaultAudience()
    {
      return this.defaultAudience;
    }
    
    String getDeviceAuthTargetUserId()
    {
      return this.deviceAuthTargetUserId;
    }
    
    String getDeviceRedirectUriString()
    {
      return this.deviceRedirectUriString;
    }
    
    LoginBehavior getLoginBehavior()
    {
      return this.loginBehavior;
    }
    
    Set<String> getPermissions()
    {
      return this.permissions;
    }
    
    boolean hasPublishPermission()
    {
      AppMethodBeat.i(7821);
      Iterator localIterator = this.permissions.iterator();
      while (localIterator.hasNext()) {
        if (LoginManager.isPublishPermission((String)localIterator.next()))
        {
          AppMethodBeat.o(7821);
          return true;
        }
      }
      AppMethodBeat.o(7821);
      return false;
    }
    
    boolean isRerequest()
    {
      return this.isRerequest;
    }
    
    void setAuthType(String paramString)
    {
      this.authType = paramString;
    }
    
    void setDeviceAuthTargetUserId(String paramString)
    {
      this.deviceAuthTargetUserId = paramString;
    }
    
    void setDeviceRedirectUriString(String paramString)
    {
      this.deviceRedirectUriString = paramString;
    }
    
    void setPermissions(Set<String> paramSet)
    {
      AppMethodBeat.i(7820);
      Validate.notNull(paramSet, "permissions");
      this.permissions = paramSet;
      AppMethodBeat.o(7820);
    }
    
    void setRerequest(boolean paramBoolean)
    {
      this.isRerequest = paramBoolean;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(7823);
      Object localObject1;
      if (this.loginBehavior != null)
      {
        localObject1 = this.loginBehavior.name();
        paramParcel.writeString((String)localObject1);
        paramParcel.writeStringList(new ArrayList(this.permissions));
        localObject1 = localObject2;
        if (this.defaultAudience != null) {
          localObject1 = this.defaultAudience.name();
        }
        paramParcel.writeString((String)localObject1);
        paramParcel.writeString(this.applicationId);
        paramParcel.writeString(this.authId);
        if (!this.isRerequest) {
          break label134;
        }
      }
      label134:
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.deviceRedirectUriString);
        paramParcel.writeString(this.authType);
        paramParcel.writeString(this.deviceAuthTargetUserId);
        AppMethodBeat.o(7823);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static class Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR;
    final Code code;
    final String errorCode;
    final String errorMessage;
    public Map<String, String> extraData;
    public Map<String, String> loggingExtras;
    final LoginClient.Request request;
    final AccessToken token;
    
    static
    {
      AppMethodBeat.i(7838);
      CREATOR = new Parcelable.Creator()
      {
        public final LoginClient.Result createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(7825);
          paramAnonymousParcel = new LoginClient.Result(paramAnonymousParcel, null);
          AppMethodBeat.o(7825);
          return paramAnonymousParcel;
        }
        
        public final LoginClient.Result[] newArray(int paramAnonymousInt)
        {
          return new LoginClient.Result[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(7838);
    }
    
    private Result(Parcel paramParcel)
    {
      AppMethodBeat.i(7836);
      this.code = Code.valueOf(paramParcel.readString());
      this.token = ((AccessToken)paramParcel.readParcelable(AccessToken.class.getClassLoader()));
      this.errorMessage = paramParcel.readString();
      this.errorCode = paramParcel.readString();
      this.request = ((LoginClient.Request)paramParcel.readParcelable(LoginClient.Request.class.getClassLoader()));
      this.loggingExtras = Utility.readStringMapFromParcel(paramParcel);
      this.extraData = Utility.readStringMapFromParcel(paramParcel);
      AppMethodBeat.o(7836);
    }
    
    Result(LoginClient.Request paramRequest, Code paramCode, AccessToken paramAccessToken, String paramString1, String paramString2)
    {
      AppMethodBeat.i(7831);
      Validate.notNull(paramCode, "code");
      this.request = paramRequest;
      this.token = paramAccessToken;
      this.errorMessage = paramString1;
      this.code = paramCode;
      this.errorCode = paramString2;
      AppMethodBeat.o(7831);
    }
    
    static Result createCancelResult(LoginClient.Request paramRequest, String paramString)
    {
      AppMethodBeat.i(7833);
      paramRequest = new Result(paramRequest, Code.CANCEL, null, paramString, null);
      AppMethodBeat.o(7833);
      return paramRequest;
    }
    
    static Result createErrorResult(LoginClient.Request paramRequest, String paramString1, String paramString2)
    {
      AppMethodBeat.i(7834);
      paramRequest = createErrorResult(paramRequest, paramString1, paramString2, null);
      AppMethodBeat.o(7834);
      return paramRequest;
    }
    
    static Result createErrorResult(LoginClient.Request paramRequest, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(7835);
      paramString1 = TextUtils.join(": ", Utility.asListNoNulls(new String[] { paramString1, paramString2 }));
      paramRequest = new Result(paramRequest, Code.ERROR, null, paramString1, paramString3);
      AppMethodBeat.o(7835);
      return paramRequest;
    }
    
    static Result createTokenResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
    {
      AppMethodBeat.i(7832);
      paramRequest = new Result(paramRequest, Code.SUCCESS, paramAccessToken, null, null);
      AppMethodBeat.o(7832);
      return paramRequest;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(7837);
      paramParcel.writeString(this.code.name());
      paramParcel.writeParcelable(this.token, paramInt);
      paramParcel.writeString(this.errorMessage);
      paramParcel.writeString(this.errorCode);
      paramParcel.writeParcelable(this.request, paramInt);
      Utility.writeStringMapToParcel(paramParcel, this.loggingExtras);
      Utility.writeStringMapToParcel(paramParcel, this.extraData);
      AppMethodBeat.o(7837);
    }
    
    static enum Code
    {
      private final String loggingValue;
      
      static
      {
        AppMethodBeat.i(7830);
        SUCCESS = new Code("SUCCESS", 0, "success");
        CANCEL = new Code("CANCEL", 1, "cancel");
        ERROR = new Code("ERROR", 2, "error");
        $VALUES = new Code[] { SUCCESS, CANCEL, ERROR };
        AppMethodBeat.o(7830);
      }
      
      private Code(String paramString)
      {
        this.loggingValue = paramString;
      }
      
      final String getLoggingValue()
      {
        return this.loggingValue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.LoginClient
 * JD-Core Version:    0.7.0.1
 */