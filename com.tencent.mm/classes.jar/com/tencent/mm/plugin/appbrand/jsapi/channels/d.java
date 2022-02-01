package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCreateContact;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 985;
  private static final String NAME = "openChannelsCreateContact";
  public static final d.a oNV;
  
  static
  {
    AppMethodBeat.i(273099);
    oNV = new d.a((byte)0);
    AppMethodBeat.o(273099);
  }
  
  public d()
  {
    AppMethodBeat.i(273098);
    com.tencent.mm.plugin.appbrand.permission.c.amg("openChannelsCreateContact");
    AppMethodBeat.o(273098);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(273096);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "invoke, env is null");
      AppMethodBeat.o(273096);
      return;
    }
    paramJSONObject = parame.getContext();
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "invoke, context is null");
      parame.j(paramInt, agS("fail:internal error invalid android context"));
      AppMethodBeat.o(273096);
      return;
    }
    a.a(paramJSONObject, (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsCreateContactRequest(), (AppBrandProxyUIProcessTask.b)b.oNW);
    parame.j(paramInt, agS("ok"));
    AppMethodBeat.o(273096);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<EmptyResult>
  {
    public static final b oNW;
    
    static
    {
      AppMethodBeat.i(264865);
      oNW = new b();
      AppMethodBeat.o(264865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.d
 * JD-Core Version:    0.7.0.1
 */