package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger
{
  static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
  static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
  static final String EVENT_EXTRAS_FAILURE = "failure";
  static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
  static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
  static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
  static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
  static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
  static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
  static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
  static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
  static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
  static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
  static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
  static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
  static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
  static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
  static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
  static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
  static final String EVENT_PARAM_CHALLENGE = "7_challenge";
  static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
  static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
  static final String EVENT_PARAM_EXTRAS = "6_extras";
  static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
  static final String EVENT_PARAM_METHOD = "3_method";
  static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
  static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
  static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
  private final AppEventsLogger appEventsLogger;
  private String applicationId;
  private String facebookVersion;
  
  LoginLogger(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96857);
    this.applicationId = paramString;
    this.appEventsLogger = AppEventsLogger.newLogger(paramContext, paramString);
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageInfo("com.facebook.katana", 0);
        if (paramContext != null) {
          this.facebookVersion = paramContext.versionName;
        }
      }
      AppMethodBeat.o(96857);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(96857);
    }
  }
  
  static Bundle newAuthorizationLoggingBundle(String paramString)
  {
    AppMethodBeat.i(96858);
    Bundle localBundle = new Bundle();
    localBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
    localBundle.putString("0_auth_logger_id", paramString);
    localBundle.putString("3_method", "");
    localBundle.putString("2_result", "");
    localBundle.putString("5_error_message", "");
    localBundle.putString("4_error_code", "");
    localBundle.putString("6_extras", "");
    AppMethodBeat.o(96858);
    return localBundle;
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public void logAuthorizationMethodComplete(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96862);
    paramString1 = newAuthorizationLoggingBundle(paramString1);
    if (paramString3 != null) {
      paramString1.putString("2_result", paramString3);
    }
    if (paramString4 != null) {
      paramString1.putString("5_error_message", paramString4);
    }
    if (paramString5 != null) {
      paramString1.putString("4_error_code", paramString5);
    }
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.putString("6_extras", new JSONObject(paramMap).toString());
    }
    paramString1.putString("3_method", paramString2);
    this.appEventsLogger.logSdkEvent("fb_mobile_login_method_complete", null, paramString1);
    AppMethodBeat.o(96862);
  }
  
  public void logAuthorizationMethodNotTried(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96863);
    paramString1 = newAuthorizationLoggingBundle(paramString1);
    paramString1.putString("3_method", paramString2);
    this.appEventsLogger.logSdkEvent("fb_mobile_login_method_not_tried", null, paramString1);
    AppMethodBeat.o(96863);
  }
  
  public void logAuthorizationMethodStart(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    paramString1 = newAuthorizationLoggingBundle(paramString1);
    paramString1.putString("3_method", paramString2);
    this.appEventsLogger.logSdkEvent("fb_mobile_login_method_start", null, paramString1);
    AppMethodBeat.o(96861);
  }
  
  public void logCompleteLogin(String paramString, Map<String, String> paramMap1, LoginClient.Result.Code paramCode, Map<String, String> paramMap2, Exception paramException)
  {
    AppMethodBeat.i(96860);
    Bundle localBundle = newAuthorizationLoggingBundle(paramString);
    if (paramCode != null) {
      localBundle.putString("2_result", paramCode.getLoggingValue());
    }
    if ((paramException != null) && (paramException.getMessage() != null)) {
      localBundle.putString("5_error_message", paramException.getMessage());
    }
    if (!paramMap1.isEmpty()) {}
    for (paramString = new JSONObject(paramMap1);; paramString = null)
    {
      paramMap1 = paramString;
      if (paramMap2 != null)
      {
        if (paramString != null) {
          break label184;
        }
        paramString = new JSONObject();
      }
      label184:
      for (;;)
      {
        try
        {
          paramMap1 = paramMap2.entrySet().iterator();
          if (paramMap1.hasNext())
          {
            paramCode = (Map.Entry)paramMap1.next();
            paramString.put((String)paramCode.getKey(), paramCode.getValue());
            continue;
            if (paramMap1 == null) {}
          }
        }
        catch (JSONException paramMap1)
        {
          paramMap1 = paramString;
        }
        for (;;)
        {
          localBundle.putString("6_extras", paramMap1.toString());
          this.appEventsLogger.logSdkEvent("fb_mobile_login_complete", null, localBundle);
          AppMethodBeat.o(96860);
          return;
          paramMap1 = paramString;
        }
      }
    }
  }
  
  public void logLoginStatusError(String paramString, Exception paramException)
  {
    AppMethodBeat.i(96867);
    paramString = newAuthorizationLoggingBundle(paramString);
    paramString.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
    paramString.putString("5_error_message", paramException.toString());
    this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, paramString);
    AppMethodBeat.o(96867);
  }
  
  public void logLoginStatusFailure(String paramString)
  {
    AppMethodBeat.i(96866);
    paramString = newAuthorizationLoggingBundle(paramString);
    paramString.putString("2_result", "failure");
    this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, paramString);
    AppMethodBeat.o(96866);
  }
  
  public void logLoginStatusStart(String paramString)
  {
    AppMethodBeat.i(96864);
    paramString = newAuthorizationLoggingBundle(paramString);
    this.appEventsLogger.logSdkEvent("fb_mobile_login_status_start", null, paramString);
    AppMethodBeat.o(96864);
  }
  
  public void logLoginStatusSuccess(String paramString)
  {
    AppMethodBeat.i(96865);
    paramString = newAuthorizationLoggingBundle(paramString);
    paramString.putString("2_result", LoginClient.Result.Code.SUCCESS.getLoggingValue());
    this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, paramString);
    AppMethodBeat.o(96865);
  }
  
  public void logStartLogin(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96859);
    Bundle localBundle = newAuthorizationLoggingBundle(paramRequest.getAuthId());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("login_behavior", paramRequest.getLoginBehavior().toString());
      localJSONObject.put("request_code", LoginClient.getLoginRequestCode());
      localJSONObject.put("permissions", TextUtils.join(",", paramRequest.getPermissions()));
      localJSONObject.put("default_audience", paramRequest.getDefaultAudience().toString());
      localJSONObject.put("isReauthorize", paramRequest.isRerequest());
      if (this.facebookVersion != null) {
        localJSONObject.put("facebookVersion", this.facebookVersion);
      }
      localBundle.putString("6_extras", localJSONObject.toString());
    }
    catch (JSONException paramRequest)
    {
      label116:
      break label116;
    }
    this.appEventsLogger.logSdkEvent("fb_mobile_login_start", null, localBundle);
    AppMethodBeat.o(96859);
  }
  
  public void logUnexpectedError(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96868);
    logUnexpectedError(paramString1, paramString2, "");
    AppMethodBeat.o(96868);
  }
  
  public void logUnexpectedError(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96869);
    Bundle localBundle = newAuthorizationLoggingBundle("");
    localBundle.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
    localBundle.putString("5_error_message", paramString2);
    localBundle.putString("3_method", paramString3);
    this.appEventsLogger.logSdkEvent(paramString1, null, localBundle);
    AppMethodBeat.o(96869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.LoginLogger
 * JD-Core Version:    0.7.0.1
 */