package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228382);
    if (!(paramProcessRequest instanceof EnterFinderRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsBase", "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
      AppMethodBeat.o(228382);
      return;
    }
    aj localaj = (aj)g.ah(aj.class);
    if (localaj != null)
    {
      localaj.enterFinderUIFromMiniApp((Context)bDF(), ((EnterFinderRequest)paramProcessRequest).lRv, (af.a)new a(this), (af.a)new b(this));
      AppMethodBeat.o(228382);
      return;
    }
    AppMethodBeat.o(228382);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements af.a<Object>
  {
    a(a parama) {}
    
    public final void bn(Object paramObject)
    {
      AppMethodBeat.i(228380);
      a.a(this.lRw, (AppBrandProxyUIProcessTask.ProcessResult)new EnterFinderResult(0));
      AppMethodBeat.o(228380);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
  static final class b<T>
    implements af.a<Integer>
  {
    b(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.a
 * JD-Core Version:    0.7.0.1
 */