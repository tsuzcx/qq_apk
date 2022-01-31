package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookSDKJSInterface
{
  private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
  private static final String PROTOCOL = "fbmq-0.1";
  public static final String TAG;
  private Context context;
  
  static
  {
    AppMethodBeat.i(71987);
    TAG = FacebookSDKJSInterface.class.getSimpleName();
    AppMethodBeat.o(71987);
  }
  
  public FacebookSDKJSInterface(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Bundle jsonStringToBundle(String paramString)
  {
    AppMethodBeat.i(71985);
    try
    {
      paramString = jsonToBundle(new JSONObject(paramString));
      AppMethodBeat.o(71985);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new Bundle();
      AppMethodBeat.o(71985);
    }
    return paramString;
  }
  
  private static Bundle jsonToBundle(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71984);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, paramJSONObject.getString(str));
    }
    AppMethodBeat.o(71984);
    return localBundle;
  }
  
  @JavascriptInterface
  public String getProtocol()
  {
    return "fbmq-0.1";
  }
  
  @JavascriptInterface
  public void sendEvent(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71986);
    if (paramString1 == null)
    {
      Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
      AppMethodBeat.o(71986);
      return;
    }
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(this.context);
    paramString3 = jsonStringToBundle(paramString3);
    paramString3.putString("_fb_pixel_referral_id", paramString1);
    localAppEventsLogger.logEvent(paramString2, paramString3);
    AppMethodBeat.o(71986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.FacebookSDKJSInterface
 * JD-Core Version:    0.7.0.1
 */