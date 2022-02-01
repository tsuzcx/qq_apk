package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol
{
  private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
  public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
  public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
  public static final String DIALOG_PARAM_APP_ID = "app_id";
  public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
  public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
  public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
  public static final String DIALOG_PARAM_DISPLAY = "display";
  public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
  public static final String DIALOG_PARAM_E2E = "e2e";
  public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
  public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
  public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
  public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
  public static final String DIALOG_PARAM_SCOPE = "scope";
  public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
  public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
  public static final String DIALOG_PARAM_STATE = "state";
  public static final String DIALOG_PATH = "dialog/";
  public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
  public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
  public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
  public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request";
  public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
  public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
  public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
  public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
  public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
  public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
  private static final String GRAPH_API_VERSION = "v3.2";
  private static final String GRAPH_URL_FORMAT = "https://graph.%s";
  private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
  private static final String TAG;
  public static final String errorConnectionFailure = "CONNECTION_FAILURE";
  public static final Collection<String> errorsProxyAuthDisabled;
  public static final Collection<String> errorsUserCanceled;
  
  static
  {
    AppMethodBeat.i(17916);
    TAG = ServerProtocol.class.getName();
    errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[] { "service_disabled", "AndroidAuthKillSwitchException" });
    errorsUserCanceled = Utility.unmodifiableCollection(new String[] { "access_denied", "OAuthAccessDeniedException" });
    AppMethodBeat.o(17916);
  }
  
  public static final String getDefaultAPIVersion()
  {
    return "v3.2";
  }
  
  public static final String getDialogAuthority()
  {
    AppMethodBeat.i(17912);
    String str = String.format("m.%s", new Object[] { FacebookSdk.getFacebookDomain() });
    AppMethodBeat.o(17912);
    return str;
  }
  
  public static final String getGraphUrlBase()
  {
    AppMethodBeat.i(17913);
    String str = String.format("https://graph.%s", new Object[] { FacebookSdk.getFacebookDomain() });
    AppMethodBeat.o(17913);
    return str;
  }
  
  public static final String getGraphVideoUrlBase()
  {
    AppMethodBeat.i(17914);
    String str = String.format("https://graph-video.%s", new Object[] { FacebookSdk.getFacebookDomain() });
    AppMethodBeat.o(17914);
    return str;
  }
  
  public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(17915);
    Object localObject = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
    if (Utility.isNullOrEmpty((String)localObject))
    {
      AppMethodBeat.o(17915);
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("android_key_hash", (String)localObject);
    localBundle.putString("app_id", FacebookSdk.getApplicationId());
    localBundle.putInt("version", paramInt);
    localBundle.putString("display", "touch");
    localObject = new Bundle();
    ((Bundle)localObject).putString("action_id", paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    try
    {
      paramBundle = BundleJSONConverter.convertToJSON((Bundle)localObject);
      paramString = BundleJSONConverter.convertToJSON(paramString);
      if ((paramBundle == null) || (paramString == null))
      {
        AppMethodBeat.o(17915);
        return null;
      }
      localBundle.putString("bridge_args", paramBundle.toString());
      localBundle.putString("method_args", paramString.toString());
      paramString = localBundle;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- ".concat(String.valueOf(paramString)));
        paramString = null;
      }
    }
    AppMethodBeat.o(17915);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.ServerProtocol
 * JD-Core Version:    0.7.0.1
 */