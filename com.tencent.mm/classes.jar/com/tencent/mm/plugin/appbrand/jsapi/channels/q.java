package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327897);
    if (!(paramProcessRequest instanceof OpenChannelsTopicRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsTopic", "handleRequest#OpenChannelsTopicTask, request is not OpenChannelsTopicRequest");
      AppMethodBeat.o(327897);
      return;
    }
    cn localcn = (cn)h.az(cn.class);
    if (localcn != null) {
      localcn.enterFinderTopicUI((Context)getActivityContext(), ((OpenChannelsTopicRequest)paramProcessRequest).rRR);
    }
    finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
    AppMethodBeat.o(327897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.q
 * JD-Core Version:    0.7.0.1
 */