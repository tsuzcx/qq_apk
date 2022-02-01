package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "getJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "apiName", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class l
  extends g
  implements k
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
  public final void V(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    label55:
    for (;;)
    {
      return;
      Object localObject = getRuntime();
      if (localObject == null) {}
      for (localObject = null;; localObject = ah.aiuX)
      {
        if (localObject != null) {
          break label55;
        }
        localObject = (l)this;
        if ((!((l)localObject).asZ()) && (!((l)localObject).cdi())) {
          break;
        }
        MMHandlerThread.postToMainThread(paramRunnable);
        return;
        ((AppBrandRuntime)localObject).i(paramRunnable, 0L);
      }
    }
  }
  
  public final void Y(JSONObject paramJSONObject)
  {
    s.u(paramJSONObject, "__wxConfig");
    s.u(paramJSONObject, "__wxConfig");
    getJsRuntime().evaluateJavascript(s.X("var __wxConfig = ", paramJSONObject), null);
  }
  
  public final p ZO(String paramString)
  {
    s.u(paramString, "apiName");
    return (p)this.rvW.get(paramString);
  }
  
  public abstract boolean asZ();
  
  public abstract boolean cdi();
  
  public JSONObject cdo()
  {
    JSONObject localJSONObject = new JSONObject();
    f(localJSONObject);
    d(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public final void d(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    s.u(paramJSONObject, "obj");
    s.u(paramString, "key");
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramJSONObject, "put with key(" + paramString + ')', new Object[0]);
    }
  }
  
  public void f(JSONObject paramJSONObject)
  {
    s.u(paramJSONObject, "config");
    d(paramJSONObject, "platform", "android");
    d(paramJSONObject, "system", s.X("Android ", Build.VERSION.RELEASE));
    d(paramJSONObject, "brand", Build.BRAND);
    d(paramJSONObject, "model", q.aPo());
    d(paramJSONObject, "pixelRatio", Float.valueOf(getContext().getResources().getDisplayMetrics().density));
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {}
    label65:
    for (;;)
    {
      return;
      Object localObject = getRuntime();
      if (localObject == null) {}
      for (localObject = null;; localObject = ah.aiuX)
      {
        if (localObject != null) {
          break label65;
        }
        localObject = (l)this;
        if ((!((l)localObject).asZ()) && (!((l)localObject).cdi())) {
          break;
        }
        MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
        return;
        ((AppBrandRuntime)localObject).i(paramRunnable, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l
 * JD-Core Version:    0.7.0.1
 */