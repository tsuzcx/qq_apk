package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "requireUsername", "", "getRequireUsername", "()Z", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isParamValid", "extInfoJsonObj", "overrideErrMsg", "originErrMsg", "errCode", "preProcessExtInfo", "plugin-appbrand-integration_release"})
public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private final boolean oNT = true;
  
  public c()
  {
    com.tencent.mm.plugin.appbrand.permission.c.amg(getName());
  }
  
  public boolean X(JSONObject paramJSONObject)
  {
    p.k(paramJSONObject, "extInfoJsonObj");
    return true;
  }
  
  public boolean Y(JSONObject paramJSONObject)
  {
    p.k(paramJSONObject, "extInfoJsonObj");
    return true;
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, env is null");
      return;
    }
    if (parame.getContext() == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, context is null");
      parame.j(paramInt, agS("fail:internal error invalid android context"));
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, data is null");
      parame.j(paramInt, agS("fail:invalid data"));
      return;
    }
    if (this.oNT)
    {
      localObject = (CharSequence)paramJSONObject.optString("finderUserName");
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, finderUserName not found");
        parame.j(paramInt, agS("fail:invalid data"));
        return;
      }
    }
    if (!X(paramJSONObject))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, isParamValid return false");
      parame.j(paramInt, agS("fail:invalid data"));
      return;
    }
    try
    {
      paramJSONObject.put("action", getAction());
      paramJSONObject.put("sourceId", parame.getAppId());
      if (!Y(paramJSONObject))
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, preProcessExtInfo fail");
        parame.j(paramInt, agS("fail:internal error"));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put fail since ".concat(String.valueOf(paramJSONObject)));
      parame.j(paramInt, agS("fail:internal error"));
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("extInfo", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject).toString();
      p.j(paramJSONObject, "extInfoWrapperJsonObj.toString()");
      a.a(parame.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new EnterFinderRequest(paramJSONObject), (AppBrandProxyUIProcessTask.b)new a(this, parame, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "invoke, put extInfo fail since ".concat(String.valueOf(paramJSONObject)));
      parame.j(paramInt, agS("fail:internal error"));
    }
  }
  
  public String ch(String paramString, int paramInt)
  {
    p.k(paramString, "originErrMsg");
    return paramString;
  }
  
  public abstract String getAction();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class a<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<EnterFinderResult>
  {
    a(c paramc, e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.c
 * JD-Core Version:    0.7.0.1
 */