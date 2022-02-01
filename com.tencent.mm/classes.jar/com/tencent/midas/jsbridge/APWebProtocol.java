package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class APWebProtocol
{
  public static String URL_KEY_HEAD_CONTROL = "midasheader";
  public static String URL_KEY_HEAD_TITLE = "midastitle";
  public static String WEBACTION_CLOSE;
  public static String WEBACTION_GETCGIEXTEND = "getCgiExtend";
  public static String WEBACTION_HEAD;
  
  static
  {
    WEBACTION_CLOSE = "closeWeb";
    WEBACTION_HEAD = "setHead";
  }
  
  protected static void AnalyzeWebEntry(Activity paramActivity, Object paramObject, IAPWebPage paramIAPWebPage, String paramString)
  {
    AppMethodBeat.i(217070);
    HashMap localHashMap = APPluginUtils.url2Map(paramString);
    localHashMap.get("page");
    String str = (String)localHashMap.get("action");
    localHashMap.get("saveNumber");
    localHashMap.get("saveType");
    paramString = (String)localHashMap.get("callback");
    if (WEBACTION_GETCGIEXTEND.equals(str))
    {
      paramIAPWebPage = APPluginDataInterface.singleton().getReserv();
      APLog.d("APWebResultPage", "sendCgiExtends() callback=" + paramString + ", extendStr=" + paramIAPWebPage);
      paramActivity = paramIAPWebPage;
      if (TextUtils.isEmpty(paramIAPWebPage)) {}
    }
    try
    {
      paramActivity = URLEncoder.encode(paramIAPWebPage, "UTF-8");
      H5CallBack(paramObject, paramString, paramActivity);
      AppMethodBeat.o(217070);
      return;
      if (WEBACTION_CLOSE.equals(str))
      {
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.webclose", "", "");
        paramObject = new APMidasResponse();
        paramObject.resultCode = 100;
        paramObject.resultMsg = "关闭";
        APMidasPayHelper.midasCallBack(paramObject);
        if (paramActivity != null) {
          paramActivity.finish();
        }
        AppMethodBeat.o(217070);
        return;
      }
      if (WEBACTION_HEAD.equals(str)) {
        try
        {
          paramIAPWebPage.initHead(paramActivity, (String)localHashMap.get(URL_KEY_HEAD_CONTROL), (String)localHashMap.get(URL_KEY_HEAD_TITLE));
          AppMethodBeat.o(217070);
          return;
        }
        catch (Exception paramActivity) {}
      }
      AppMethodBeat.o(217070);
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity = paramIAPWebPage;
      }
    }
  }
  
  public static void H5CallBack(Object paramObject, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(217082);
    for (;;)
    {
      try
      {
        localObject = new JSONTokener(paramString2).nextValue();
        if (localObject == null) {
          if (i == 0) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      try
      {
        paramString2 = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](%s);", new Object[] { paramString1, paramString1, paramString2 });
        APLog.i("callback", paramString1);
        APLog.i("cb", paramString2);
        if ((paramObject instanceof android.webkit.WebView))
        {
          ((android.webkit.WebView)paramObject).loadUrl("javascript:".concat(String.valueOf(paramString2)));
          AppMethodBeat.o(217082);
          return;
          if ((localObject instanceof JSONObject))
          {
            i = 1;
            continue;
          }
          boolean bool = localObject instanceof JSONArray;
          if (!bool) {
            continue;
          }
          i = 1;
          continue;
          paramString2 = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](\"%s\");", new Object[] { paramString1, paramString1, paramString2 });
          continue;
        }
        if ((paramObject instanceof com.tencent.smtt.sdk.WebView)) {
          ((com.tencent.smtt.sdk.WebView)paramObject).loadUrl("javascript:".concat(String.valueOf(paramString2)));
        }
        AppMethodBeat.o(217082);
        return;
      }
      catch (Exception paramObject)
      {
        APLog.d("H5CallBack", "H5CallBack() ex = " + paramObject.toString());
        AppMethodBeat.o(217082);
        return;
      }
    }
  }
  
  protected static boolean hookH5Method(Activity paramActivity, android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult, IAPWebViewCallback paramIAPWebViewCallback)
  {
    AppMethodBeat.i(217042);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http://unipay.sdk.android/?")))
    {
      paramIAPWebViewCallback.WebChromeClientJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(217042);
      return true;
    }
    AppMethodBeat.o(217042);
    return false;
  }
  
  protected static boolean hookH5Method(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView, String paramString1, String paramString2, com.tencent.smtt.export.external.interfaces.JsResult paramJsResult, IAPX5WebViewCallback paramIAPX5WebViewCallback)
  {
    AppMethodBeat.i(217052);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http://unipay.sdk.android/?")))
    {
      paramIAPX5WebViewCallback.WebChromeClientJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(217052);
      return true;
    }
    AppMethodBeat.o(217052);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APWebProtocol
 * JD-Core Version:    0.7.0.1
 */