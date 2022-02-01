package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z.a;
import com.tencent.mm.plugin.textstatus.proto.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ae
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(325549);
    if (!(paramProcessRequest instanceof DoPublishTextStatusRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiPublishWechatStateActivity", "handleRequest, request is not DoSetTextStatusRequest");
      AppMethodBeat.o(325549);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiPublishWechatStateActivity", "handleRequest, publishTextStatus");
    z.a locala = new z.a();
    String str = ((DoPublishTextStatusRequest)paramProcessRequest).rwP.token;
    locala.ThX.ToC = str;
    paramProcessRequest = s.X(((DoPublishTextStatusRequest)paramProcessRequest).rwP.appId, "@weapp");
    locala.ThX.ToB = paramProcessRequest;
    paramProcessRequest = locala.ThX;
    ((n)h.ax(n.class)).a((Context)getActivityContext(), paramProcessRequest, (y)new a(this));
    AppMethodBeat.o(325549);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusTask$handleRequest$1", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;", "onFinishAction", "", "result", "", "errMsg", "", "resultInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusActionResultInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements y
  {
    a(ae paramae) {}
    
    public final void onFinishAction(int paramInt, String paramString, q paramq)
    {
      AppMethodBeat.i(325675);
      ae localae = this.rwQ;
      PublishTextStatusResult localPublishTextStatusResult = new PublishTextStatusResult();
      localPublishTextStatusResult.result = paramInt;
      localPublishTextStatusResult.errMsg = paramString;
      if (paramq == null) {}
      for (paramString = null;; paramString = paramq.toByteArray())
      {
        localPublishTextStatusResult.rBD = paramString;
        paramString = ah.aiuX;
        ae.a(localae, (AppBrandProxyUIProcessTask.ProcessResult)localPublishTextStatusResult);
        AppMethodBeat.o(325675);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae
 * JD-Core Version:    0.7.0.1
 */