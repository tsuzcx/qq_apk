package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class k
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(273767);
    if (!(paramProcessRequest instanceof OpenChannelsRewardedVideoAdRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "handleRequest#OpenChannelsRewardedVideoAdTask, request is not OpenChannelsRewardedVideoAdRequest");
      AppMethodBeat.o(273767);
      return;
    }
    ak localak = (ak)h.ag(ak.class);
    if (localak != null)
    {
      localak.enterFinderUIFromMiniApp((Context)bPf(), ((OpenChannelsRewardedVideoAdRequest)paramProcessRequest).oOe, (ag.a)new a(this), (ag.a)new b(this));
      AppMethodBeat.o(273767);
      return;
    }
    AppMethodBeat.o(273767);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "rawOpenResult", "", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements ag.a<Object>
  {
    a(k paramk) {}
    
    public final void aH(Object paramObject)
    {
      AppMethodBeat.i(282485);
      if (!(paramObject instanceof blq)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (blq)paramObject;
        if (paramObject != null) {}
        for (int i = 0;; i = -1)
        {
          Log.i("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "succCallback#handleRequest#OpenChannelsRewardedVideoAdTask, errCode: ".concat(String.valueOf(i)));
          k.a(this.oOg, (AppBrandProxyUIProcessTask.ProcessResult)new OpenChannelsRewardedVideoAdResult(i, paramObject));
          AppMethodBeat.o(282485);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
  static final class b<T>
    implements ag.a<Integer>
  {
    b(k paramk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.k
 * JD-Core Version:    0.7.0.1
 */