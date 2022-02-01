package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class i
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(282675);
    if (!(paramProcessRequest instanceof OpenChannelsCreateContactRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "handleRequest#OpenChannelsCreateContactTask, request is not OpenChannelsCreateContactRequest");
      AppMethodBeat.o(282675);
      return;
    }
    paramProcessRequest = (ak)h.ag(ak.class);
    if (paramProcessRequest != null)
    {
      paramProcessRequest.openChannelsCreateContact((Activity)bPf(), (ag.a)new a(this));
      AppMethodBeat.o(282675);
      return;
    }
    AppMethodBeat.o(282675);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Boolean;)V"})
  static final class a<T>
    implements ag.a<Boolean>
  {
    a(i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.i
 * JD-Core Version:    0.7.0.1
 */