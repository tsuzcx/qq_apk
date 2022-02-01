package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSetTextStatus;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "doSetTextStatus", "", "context", "Landroid/content/Context;", "setTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "didSetTextStatus", "Lkotlin/Function0;", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "prepareParams", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class da
  extends c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 1014;
  private static final String NAME = "publishWeChatState";
  public static final a rAG;
  
  static
  {
    AppMethodBeat.i(325478);
    rAG = new a((byte)0);
    AppMethodBeat.o(325478);
  }
  
  private static final void a(a parama, EmptyResult paramEmptyResult)
  {
    AppMethodBeat.i(325471);
    s.u(parama, "$didSetTextStatus");
    Log.i("MicroMsg.AppBrand.JsApiSetTextStatus", "onReceiveResult, setTextStatus done");
    parama.invoke();
    AppMethodBeat.o(325471);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSetTextStatus$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "NAME", "", "getNAME$annotations", "PARAM_KEY_ACTIVITY_ID", "PARAM_KEY_BACKGROUND_URL", "PARAM_KEY_ENTER_PATH", "PARAM_KEY_ICON_ID", "PARAM_KEY_TEXT_DESC", "PARAM_KEY_VERIFY_INFO", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, da paramda)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.da
 * JD-Core Version:    0.7.0.1
 */