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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class n
  extends AppBrandProxyUIProcessTask
{
  private static final void a(n paramn, Integer paramInteger)
  {
    AppMethodBeat.i(327893);
    s.u(paramn, "this$0");
    s.s(paramInteger, "ret");
    paramn.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new OpenChannelsLiveCollectionResult(paramInteger.intValue()));
    AppMethodBeat.o(327893);
  }
  
  private static final void a(n paramn, Object paramObject)
  {
    AppMethodBeat.i(327885);
    s.u(paramn, "this$0");
    paramn.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new OpenChannelsLiveCollectionResult(0));
    AppMethodBeat.o(327885);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327914);
    if (!(paramProcessRequest instanceof OpenChannelsLiveCollectionRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
      AppMethodBeat.o(327914);
      return;
    }
    cn localcn = (cn)h.az(cn.class);
    if (localcn != null) {
      localcn.enterFinderUIFromMiniApp((Context)getActivityContext(), ((OpenChannelsLiveCollectionRequest)paramProcessRequest).rRR, new n..ExternalSyntheticLambda0(this), new n..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(327914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.n
 * JD-Core Version:    0.7.0.1
 */