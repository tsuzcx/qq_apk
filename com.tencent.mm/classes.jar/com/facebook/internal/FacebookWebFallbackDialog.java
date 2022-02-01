package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog
  extends WebDialog
{
  private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
  private static final String TAG;
  private boolean waitingForDialogToClose;
  
  static
  {
    AppMethodBeat.i(7670);
    TAG = FacebookWebFallbackDialog.class.getName();
    AppMethodBeat.o(7670);
  }
  
  private FacebookWebFallbackDialog(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1);
    AppMethodBeat.i(7666);
    setExpectedRedirectUrl(paramString2);
    AppMethodBeat.o(7666);
  }
  
  public static FacebookWebFallbackDialog newInstance(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(7665);
    WebDialog.initDefaultTheme(paramContext);
    paramContext = new FacebookWebFallbackDialog(paramContext, paramString1, paramString2);
    AppMethodBeat.o(7665);
    return paramContext;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(7668);
    WebView localWebView = getWebView();
    if ((!isPageFinished()) || (isListenerCalled()) || (localWebView == null) || (!localWebView.isShown()))
    {
      super.cancel();
      AppMethodBeat.o(7668);
      return;
    }
    if (this.waitingForDialogToClose)
    {
      AppMethodBeat.o(7668);
      return;
    }
    this.waitingForDialogToClose = true;
    localWebView.loadUrl("javascript:".concat(String.valueOf("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();")));
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(7664);
        FacebookWebFallbackDialog.access$001(FacebookWebFallbackDialog.this);
        AppMethodBeat.o(7664);
      }
    }, 1500L);
    AppMethodBeat.o(7668);
  }
  
  protected Bundle parseResponseUri(String paramString)
  {
    AppMethodBeat.i(7667);
    Bundle localBundle = Utility.parseUrlQueryString(Uri.parse(paramString).getQuery());
    paramString = localBundle.getString("bridge_args");
    localBundle.remove("bridge_args");
    if (!Utility.isNullOrEmpty(paramString)) {}
    try
    {
      localBundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
      String str = localBundle.getString("method_results");
      localBundle.remove("method_results");
      if (!Utility.isNullOrEmpty(str))
      {
        paramString = str;
        if (Utility.isNullOrEmpty(str)) {
          paramString = "{}";
        }
      }
    }
    catch (JSONException paramString)
    {
      try
      {
        localBundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
        localBundle.remove("version");
        localBundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
        AppMethodBeat.o(7667);
        return localBundle;
        paramString = paramString;
        Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.FacebookWebFallbackDialog
 * JD-Core Version:    0.7.0.1
 */