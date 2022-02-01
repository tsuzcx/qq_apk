package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"})
public abstract class i
  extends d
  implements h
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
  public final void M(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).M(paramRunnable);
        return;
      }
      localObject = (i)this;
    } while ((!((i)localObject).aXv()) && (!((i)localObject).aXu()));
    aq.f(paramRunnable);
  }
  
  public JSONObject aXD()
  {
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    c(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public abstract boolean aXu();
  
  public abstract boolean aXv();
  
  public final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    p.h(paramJSONObject, "obj");
    p.h(paramString, "key");
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)paramJSONObject, "put with key(" + paramString + ')', new Object[0]);
    }
  }
  
  public void d(JSONObject paramJSONObject)
  {
    p.h(paramJSONObject, "config");
    c(paramJSONObject, "platform", "android");
    c(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
    c(paramJSONObject, "brand", Build.BRAND);
    c(paramJSONObject, "model", Build.MODEL);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    c(paramJSONObject, "pixelRatio", Float.valueOf(((Resources)localObject).getDisplayMetrics().density));
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).j(paramRunnable, paramLong);
        return;
      }
      localObject = (i)this;
    } while ((!((i)localObject).aXv()) && (!((i)localObject).aXu()));
    aq.o(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i
 * JD-Core Version:    0.7.0.1
 */