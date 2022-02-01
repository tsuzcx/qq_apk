package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsTopic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 1065;
  private static final String NAME = "openChannelsTopic";
  public static final a rRN;
  
  static
  {
    AppMethodBeat.i(327876);
    rRN = new a((byte)0);
    AppMethodBeat.o(327876);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, j paramj, EmptyResult paramEmptyResult)
  {
    AppMethodBeat.i(327871);
    s.u(paramj, "this$0");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsTopic", "onReceiveResult#IProcessResultReceiver");
    paramc.callback(paramInt, paramj.a(null, a.e.rVt, null));
    AppMethodBeat.o(327871);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsTopic$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.j
 * JD-Core Version:    0.7.0.1
 */