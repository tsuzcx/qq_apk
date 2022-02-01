package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApiEx;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "privateData", "invokeContext", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
  implements d<f>
{
  public final void a(dh<f> paramdh)
  {
    s.u(paramdh, "invokeContext");
    f localf = paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    a(localf, localJSONObject, paramdh.qxU, i);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt) {}
  
  public abstract void a(f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.c
 * JD-Core Version:    0.7.0.1
 */