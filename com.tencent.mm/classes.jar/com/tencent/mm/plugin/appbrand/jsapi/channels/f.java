package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsPostPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends c<e>
{
  private static final int CTRL_INDEX = 984;
  private static final String NAME = "openChannelsPostPage";
  public static final a oNY;
  
  static
  {
    AppMethodBeat.i(280920);
    oNY = new a((byte)0);
    AppMethodBeat.o(280920);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(280919);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsPostPage", "invoke, env is null");
      AppMethodBeat.o(280919);
      return;
    }
    paramJSONObject = parame.getContext();
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsPostPage", "invoke, context is null");
      parame.j(paramInt, agS("fail:internal error invalid android context"));
      AppMethodBeat.o(280919);
      return;
    }
    a.a(paramJSONObject, (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsPostPageRequest(), (AppBrandProxyUIProcessTask.b)b.oNZ);
    parame.j(paramInt, agS("ok"));
    AppMethodBeat.o(280919);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsPostPage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<EmptyResult>
  {
    public static final b oNZ;
    
    static
    {
      AppMethodBeat.i(284171);
      oNZ = new b();
      AppMethodBeat.o(284171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.f
 * JD-Core Version:    0.7.0.1
 */