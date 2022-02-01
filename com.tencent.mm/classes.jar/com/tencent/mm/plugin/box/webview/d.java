package com.tencent.mm.plugin.box.webview;

import android.annotation.TargetApi;
import android.webkit.JavascriptInterface;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class d
{
  b som;
  
  public d(b paramb)
  {
    this.som = paramb;
  }
  
  @JavascriptInterface
  public void closePage()
  {
    AppMethodBeat.i(76362);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "closePage");
    this.som.dismiss();
    AppMethodBeat.o(76362);
  }
  
  public final void g(String paramString1, int paramInt, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(76363);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "onDataReady %s %s %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("requestId", paramString1);
      paramString2.put("ret", paramInt);
      paramString2.put("data", paramString3);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(76356);
          Object localObject = paramString2.toString();
          b localb = d.this.som;
          try
          {
            boolean bool = Util.isNullOrNil("requestCompleted");
            if (bool)
            {
              AppMethodBeat.o(76356);
              return;
            }
            String str = Util.nullAsNil((String)localObject);
            if ((!Util.isNullOrNil(str)) && (str.length() > 50)) {}
            for (localObject = str.substring(0, 50);; localObject = str)
            {
              Log.i("MicroMsg.Box.BoxJsEventNotifier", "notifyJsEvent %s %s", new Object[] { "requestCompleted", localObject });
              localObject = String.format("javascript:boxJSApi['%s'] && boxJSApi.%s(%s)", new Object[] { "requestCompleted", "requestCompleted", str });
              localb.cyu().evaluateJavascript((String)localObject, null);
              AppMethodBeat.o(76356);
              return;
            }
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Box.BoxJsEventNotifier", localException, "notifyJsEvent", new Object[0]);
            AppMethodBeat.o(76356);
          }
        }
      });
      AppMethodBeat.o(76363);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(76363);
    }
  }
  
  @JavascriptInterface
  public void log(String paramString)
  {
    AppMethodBeat.i(76361);
    try
    {
      paramString = new JSONObject(paramString);
      Log.i("MicroMsg.Box.BoxWebViewJSApi", "[%s][%s]", new Object[] { paramString.optString("level", ""), paramString.optString("msg", "") });
      AppMethodBeat.o(76361);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(76361);
    }
  }
  
  @JavascriptInterface
  public void openWeAppPage(String paramString)
  {
    AppMethodBeat.i(76359);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "openWeAppPage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.optString("userName", "");
      String str2 = paramString.optString("relativeURL", "");
      xw localxw = new xw();
      localxw.fWN.userName = str1;
      localxw.fWN.fWP = str2;
      localxw.fWN.scene = paramString.optInt("scene", 1000);
      EventCenter.instance.publish(localxw);
      AppMethodBeat.o(76359);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(76359);
    }
  }
  
  @JavascriptInterface
  public void reportKV(String paramString)
  {
    AppMethodBeat.i(76360);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "reportKV %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid", 0);
      paramString = paramString.optString("msg", "");
      f.Iyx.kvStat(i, paramString);
      AppMethodBeat.o(76360);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(76360);
    }
  }
  
  @JavascriptInterface
  public void request(String paramString)
  {
    AppMethodBeat.i(76357);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "request %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("requestId", "");
      localObject = ((JSONObject)localObject).optString("data", "");
      this.som.cyv().fq(paramString, (String)localObject);
      AppMethodBeat.o(76357);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(76357);
    }
  }
  
  @JavascriptInterface
  public void webviewUIReady()
  {
    AppMethodBeat.i(76358);
    Log.i("MicroMsg.Box.BoxWebViewJSApi", "webviewUIReady");
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76355);
        AppMethodBeat.o(76355);
      }
    });
    AppMethodBeat.o(76358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.d
 * JD-Core Version:    0.7.0.1
 */