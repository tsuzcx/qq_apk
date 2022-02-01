package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(267922);
    if (!(paramProcessRequest instanceof EnterFinderRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
      AppMethodBeat.o(267922);
      return;
    }
    ak localak = (ak)h.ag(ak.class);
    if (localak != null)
    {
      localak.enterFinderUIFromMiniApp((Context)bPf(), ((EnterFinderRequest)paramProcessRequest).oNQ, (ag.a)new a(this), (ag.a)new b(this));
      AppMethodBeat.o(267922);
      return;
    }
    AppMethodBeat.o(267922);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements ag.a<Object>
  {
    a(a parama) {}
    
    public final void aH(Object paramObject)
    {
      AppMethodBeat.i(265669);
      a.a(this.oNR, (AppBrandProxyUIProcessTask.ProcessResult)new EnterFinderResult(0));
      AppMethodBeat.o(265669);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
  static final class b<T>
    implements ag.a<Integer>
  {
    b(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.a
 * JD-Core Version:    0.7.0.1
 */