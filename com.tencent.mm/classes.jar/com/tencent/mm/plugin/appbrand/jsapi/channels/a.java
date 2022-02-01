package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  extends AppBrandProxyUIProcessTask
{
  private static final void a(a parama, Integer paramInteger)
  {
    AppMethodBeat.i(327857);
    s.u(parama, "this$0");
    s.s(paramInteger, "ret");
    parama.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EnterFinderResult(paramInteger.intValue()));
    AppMethodBeat.o(327857);
  }
  
  private static final void a(a parama, Object paramObject)
  {
    AppMethodBeat.i(327852);
    s.u(parama, "this$0");
    parama.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EnterFinderResult(0));
    AppMethodBeat.o(327852);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327877);
    if (!(paramProcessRequest instanceof EnterFinderRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
      AppMethodBeat.o(327877);
      return;
    }
    cn localcn = (cn)h.az(cn.class);
    if (localcn != null) {
      localcn.enterFinderUIFromMiniApp((Context)getActivityContext(), ((EnterFinderRequest)paramProcessRequest).rRG, new a..ExternalSyntheticLambda0(this), new a..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(327877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.a
 * JD-Core Version:    0.7.0.1
 */