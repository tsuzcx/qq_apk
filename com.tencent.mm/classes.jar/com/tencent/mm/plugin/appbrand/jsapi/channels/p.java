package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class p
  extends AppBrandProxyUIProcessTask
{
  private static final void a(p paramp, Integer paramInteger)
  {
    AppMethodBeat.i(327890);
    s.u(paramp, "this$0");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", s.X("failedCallback#handleRequest#OpenChannelsRewardedVideoAdTask, errCode: ", paramInteger));
    s.s(paramInteger, "errCode");
    paramp.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new OpenChannelsRewardedVideoAdResult(paramInteger.intValue()));
    AppMethodBeat.o(327890);
  }
  
  private static final void a(p paramp, Object paramObject)
  {
    AppMethodBeat.i(327884);
    s.u(paramp, "this$0");
    if ((paramObject instanceof bzh))
    {
      paramObject = (bzh)paramObject;
      if (paramObject == null) {
        break label70;
      }
    }
    label70:
    for (int i = 0;; i = -1)
    {
      Log.i("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", s.X("succCallback#handleRequest#OpenChannelsRewardedVideoAdTask, errCode: ", Integer.valueOf(i)));
      paramp.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new OpenChannelsRewardedVideoAdResult(i, paramObject));
      AppMethodBeat.o(327884);
      return;
      paramObject = null;
      break;
    }
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327918);
    if (!(paramProcessRequest instanceof OpenChannelsRewardedVideoAdRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "handleRequest#OpenChannelsRewardedVideoAdTask, request is not OpenChannelsRewardedVideoAdRequest");
      AppMethodBeat.o(327918);
      return;
    }
    cn localcn = (cn)h.az(cn.class);
    if (localcn != null) {
      localcn.enterFinderUIFromMiniApp((Context)getActivityContext(), ((OpenChannelsRewardedVideoAdRequest)paramProcessRequest).rRR, new p..ExternalSyntheticLambda0(this), new p..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(327918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.p
 * JD-Core Version:    0.7.0.1
 */