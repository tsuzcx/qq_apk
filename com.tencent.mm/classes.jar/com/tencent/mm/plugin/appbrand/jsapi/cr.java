package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPublishWechatStateActivity;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "doSetTextStatus", "", "context", "Landroid/content/Context;", "publishTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusParams;", "didSetTextStatus", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusActionResultInfo;", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "prepareParams", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cr
  extends c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 1070;
  private static final String NAME = "publishWechatStateActivity";
  public static final a rAn;
  
  static
  {
    AppMethodBeat.i(325463);
    rAn = new a((byte)0);
    AppMethodBeat.o(325463);
  }
  
  private static final void a(kotlin.g.a.q paramq, PublishTextStatusResult paramPublishTextStatusResult)
  {
    AppMethodBeat.i(325460);
    s.u(paramq, "$didSetTextStatus");
    com.tencent.mm.plugin.textstatus.proto.q localq;
    if (paramPublishTextStatusResult.rBD != null)
    {
      localq = new com.tencent.mm.plugin.textstatus.proto.q();
      localq.parseFrom(paramPublishTextStatusResult.rBD);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.JsApiPublishWechatStateActivity", "onReceiveResult, publishTextStatus done," + paramPublishTextStatusResult.result + ' ' + paramPublishTextStatusResult.errMsg + ' ' + localq);
      paramq.invoke(Integer.valueOf(paramPublishTextStatusResult.result), paramPublishTextStatusResult.errMsg, localq);
      AppMethodBeat.o(325460);
      return;
      localq = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPublishWechatStateActivity$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "NAME", "", "getNAME$annotations", "PARAM_KEY_ACTIVITY_TOKEN", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "errmsg", "", "resultInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusActionResultInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.q<Integer, String, com.tencent.mm.plugin.textstatus.proto.q, ah>
  {
    b(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, cr paramcr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cr
 * JD-Core Version:    0.7.0.1
 */