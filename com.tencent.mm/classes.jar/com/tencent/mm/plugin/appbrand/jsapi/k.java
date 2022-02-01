package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "getJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "apiName", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"})
public abstract class k
  extends f
  implements j
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
  public final void N(JSONObject paramJSONObject)
  {
    p.k(paramJSONObject, "__wxConfig");
    getJsRuntime().evaluateJavascript("var __wxConfig = ".concat(String.valueOf(paramJSONObject)), null);
  }
  
  public final void P(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).P(paramRunnable);
        return;
      }
      localObject = (k)this;
    } while ((!((k)localObject).bDV()) && (!((k)localObject).bDU()));
    MMHandlerThread.postToMainThread(paramRunnable);
  }
  
  public final o agR(String paramString)
  {
    p.k(paramString, "apiName");
    return (o)this.osc.get(paramString);
  }
  
  public abstract boolean bDU();
  
  public abstract boolean bDV();
  
  public JSONObject bEc()
  {
    JSONObject localJSONObject = new JSONObject();
    g(localJSONObject);
    c(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    p.k(paramJSONObject, "obj");
    p.k(paramString, "key");
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
  
  public void g(JSONObject paramJSONObject)
  {
    p.k(paramJSONObject, "config");
    c(paramJSONObject, "platform", "android");
    c(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
    c(paramJSONObject, "brand", Build.BRAND);
    c(paramJSONObject, "model", Build.MODEL);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "context.resources");
    c(paramJSONObject, "pixelRatio", Float.valueOf(((Resources)localObject).getDisplayMetrics().density));
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).h(paramRunnable, paramLong);
        return;
      }
      localObject = (k)this;
    } while ((!((k)localObject).bDV()) && (!((k)localObject).bDU()));
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k
 * JD-Core Version:    0.7.0.1
 */