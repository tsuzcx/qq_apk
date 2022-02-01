package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class r
  extends AppBrandProxyUIProcessTask
{
  private static final void a(r paramr, Integer paramInteger)
  {
    AppMethodBeat.i(327898);
    s.u(paramr, "this$0");
    Log.i("MicroMsg.AppBrand.JsApiReserveChannelsLive", s.X("onCallback#successCallback, state: ", paramInteger));
    s.s(paramInteger, "state");
    paramr.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new ReserveChannelsLiveResult(true, paramInteger.intValue()));
    AppMethodBeat.o(327898);
  }
  
  private static final void b(r paramr, Integer paramInteger)
  {
    AppMethodBeat.i(327910);
    s.u(paramr, "this$0");
    Log.i("MicroMsg.AppBrand.JsApiReserveChannelsLive", s.X("onCallback#failCallback, errCode: ", paramInteger));
    s.s(paramInteger, "errCode");
    paramr.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new ReserveChannelsLiveResult(false, paramInteger.intValue()));
    AppMethodBeat.o(327910);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327929);
    if (!(paramProcessRequest instanceof ReserveChannelsLiveRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiReserveChannelsLive", "handleRequest#ReserveChannelsLiveTask, request is not ReserveChannelsLiveRequest");
      AppMethodBeat.o(327929);
      return;
    }
    cn localcn = (cn)h.az(cn.class);
    if (localcn != null) {
      localcn.reserveChannelsLive((Activity)getActivityContext(), ((ReserveChannelsLiveRequest)paramProcessRequest).rRQ, new r..ExternalSyntheticLambda1(this), new r..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(327929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.r
 * JD-Core Version:    0.7.0.1
 */