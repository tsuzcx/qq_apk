package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"})
public abstract class i
  extends d
  implements h
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
  public final void N(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getRuntime();
      if (localObject != null)
      {
        ((AppBrandRuntime)localObject).N(paramRunnable);
        return;
      }
      localObject = (i)this;
    } while ((!((i)localObject).aUm()) && (!((i)localObject).aUl()));
    ap.f(paramRunnable);
  }
  
  public abstract boolean aUl();
  
  public abstract boolean aUm();
  
  public JSONObject aUs()
  {
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    c(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    k.h(paramJSONObject, "obj");
    k.h(paramString, "key");
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)paramJSONObject, "put with key(" + paramString + ')', new Object[0]);
    }
  }
  
  public void d(JSONObject paramJSONObject)
  {
    k.h(paramJSONObject, "config");
    c(paramJSONObject, "platform", "android");
    c(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
    c(paramJSONObject, "brand", Build.BRAND);
    c(paramJSONObject, "model", Build.MODEL);
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "context.resources");
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
      localObject = (i)this;
    } while ((!((i)localObject).aUm()) && (!((i)localObject).aUl()));
    ap.n(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i
 * JD-Core Version:    0.7.0.1
 */