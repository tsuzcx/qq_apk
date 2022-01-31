package com.tencent.mm.plugin.appbrand.jsapi;

import a.f.b.j;
import a.l;
import android.os.Build.VERSION;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "generateWxConfig", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"})
public abstract class i
  extends d
  implements h
{
  private final String TAG = "AppBrandComponentWxaSharedKT";
  
  public final void A(Runnable paramRunnable)
  {
    com.tencent.mm.plugin.appbrand.i locali = getRuntime();
    if (locali != null) {
      locali.A(paramRunnable);
    }
  }
  
  public JSONObject auh()
  {
    JSONObject localJSONObject = new JSONObject();
    e(localJSONObject);
    b(localJSONObject, "preload", Boolean.TRUE);
    return localJSONObject;
  }
  
  public final void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    j.q(paramJSONObject, "obj");
    j.q(paramString, "key");
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.luggage.g.d.printErrStackTrace(this.TAG, (Throwable)paramJSONObject, "put with key(" + paramString + ')', new Object[0]);
    }
  }
  
  public void e(JSONObject paramJSONObject)
  {
    j.q(paramJSONObject, "config");
    b(paramJSONObject, "platform", "android");
    b(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
  }
  
  public final void k(Runnable paramRunnable, long paramLong)
  {
    com.tencent.mm.plugin.appbrand.i locali = getRuntime();
    if (locali != null) {
      locali.k(paramRunnable, paramLong);
    }
  }
  
  public JSONObject wE()
  {
    JSONObject localJSONObject = new JSONObject();
    e(localJSONObject);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i
 * JD-Core Version:    0.7.0.1
 */