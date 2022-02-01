package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Map;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "getJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "apiName", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"})
public abstract class l
  extends g
  implements k
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
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
      localObject = (l)this;
    } while ((!((l)localObject).bsX()) && (!((l)localObject).bsW()));
    MMHandlerThread.postToMainThread(paramRunnable);
  }
  
  public final p Ze(String paramString)
  {
    kotlin.g.b.p.h(paramString, "apiName");
    return (p)this.lxp.get(paramString);
  }
  
  public abstract boolean bsW();
  
  public abstract boolean bsX();
  
  public JSONObject bte()
  {
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    c(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    kotlin.g.b.p.h(paramJSONObject, "obj");
    kotlin.g.b.p.h(paramString, "key");
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
  
  public void d(JSONObject paramJSONObject)
  {
    kotlin.g.b.p.h(paramJSONObject, "config");
    c(paramJSONObject, "platform", "android");
    c(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
    c(paramJSONObject, "brand", Build.BRAND);
    c(paramJSONObject, "model", Build.MODEL);
    Object localObject = getContext();
    kotlin.g.b.p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    kotlin.g.b.p.g(localObject, "context.resources");
    c(paramJSONObject, "pixelRatio", Float.valueOf(((Resources)localObject).getDisplayMetrics().density));
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).i(paramRunnable, paramLong);
        return;
      }
      localObject = (l)this;
    } while ((!((l)localObject).bsX()) && (!((l)localObject).bsW()));
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l
 * JD-Core Version:    0.7.0.1
 */