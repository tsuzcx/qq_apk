package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsRewardedVideoAd;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends c<e>
{
  private static final int CTRL_INDEX = 1001;
  private static final String NAME = "openChannelsRewardedVideoAd";
  public static final g.a oOa;
  
  static
  {
    AppMethodBeat.i(282905);
    oOa = new g.a((byte)0);
    AppMethodBeat.o(282905);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(282904);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, env is null");
      AppMethodBeat.o(282904);
      return;
    }
    if (parame.getContext() == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, context is null");
      parame.j(paramInt, agS("fail:internal error invalid android context"));
      AppMethodBeat.o(282904);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, data is null");
      parame.j(paramInt, agS("fail:invalid data"));
      AppMethodBeat.o(282904);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("action", "openChannelsRewardedVideoAd");
      localJSONObject.put("extInfo", paramJSONObject);
      paramJSONObject = localJSONObject.toString();
      p.j(paramJSONObject, "openChannelsParamsJsonObj.toString()");
      a.a(parame.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsRewardedVideoAdRequest(paramJSONObject), (AppBrandProxyUIProcessTask.b)new b(this, parame, paramInt));
      AppMethodBeat.o(282904);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, put fail since ".concat(String.valueOf(paramJSONObject)));
      parame.j(paramInt, agS("fail:internal error"));
      AppMethodBeat.o(282904);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<OpenChannelsRewardedVideoAdResult>
  {
    b(g paramg, e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.g
 * JD-Core Version:    0.7.0.1
 */