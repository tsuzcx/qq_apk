package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "requireUsername", "", "getRequireUsername", "()Z", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isParamValid", "extInfoJsonObj", "preProcessExtInfo", "plugin-appbrand-integration_release"})
public abstract class c
  extends d<f>
{
  private final boolean lRy = true;
  
  public boolean T(JSONObject paramJSONObject)
  {
    p.h(paramJSONObject, "extInfoJsonObj");
    return true;
  }
  
  public boolean U(JSONObject paramJSONObject)
  {
    p.h(paramJSONObject, "extInfoJsonObj");
    return true;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, env is null");
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, context is null");
      paramf.i(paramInt, Zf("fail:internal error invalid android context"));
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:invalid data"));
      return;
    }
    if (this.lRy)
    {
      localObject = (CharSequence)paramJSONObject.optString("finderUserName");
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, finderUserName not found");
        paramf.i(paramInt, Zf("fail:invalid data"));
        return;
      }
    }
    if (!T(paramJSONObject))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, isParamValid return false");
      paramf.i(paramInt, Zf("fail:invalid data"));
      return;
    }
    try
    {
      paramJSONObject.put("action", getAction());
      paramJSONObject.put("sourceId", paramf.getAppId());
      if (!U(paramJSONObject))
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, preProcessExtInfo fail");
        paramf.i(paramInt, Zf("fail:internal error"));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put fail since ".concat(String.valueOf(paramJSONObject)));
      paramf.i(paramInt, Zf("fail:internal error"));
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("extInfo", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject).toString();
      p.g(paramJSONObject, "extInfoWrapperJsonObj.toString()");
      a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new EnterFinderRequest(paramJSONObject), (AppBrandProxyUIProcessTask.b)new a(this, paramf, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put extInfo fail since ".concat(String.valueOf(paramJSONObject)));
      paramf.i(paramInt, Zf("fail:internal error"));
    }
  }
  
  public abstract String getAction();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class a<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<EnterFinderResult>
  {
    a(c paramc, f paramf, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.c
 * JD-Core Version:    0.7.0.1
 */