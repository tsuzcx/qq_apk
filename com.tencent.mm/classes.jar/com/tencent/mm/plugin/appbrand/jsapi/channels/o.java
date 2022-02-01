package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class o
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327886);
    if (!(paramProcessRequest instanceof OpenChannelsPostPageRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsPostPage", "handleRequest#OpenChannelsPostPageTask, request is not OpenChannelsPostPageRequest");
      AppMethodBeat.o(327886);
      return;
    }
    paramProcessRequest = (cn)h.az(cn.class);
    if (paramProcessRequest != null) {
      paramProcessRequest.openChannelsPostPage((Activity)getActivityContext());
    }
    finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
    AppMethodBeat.o(327886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.o
 * JD-Core Version:    0.7.0.1
 */