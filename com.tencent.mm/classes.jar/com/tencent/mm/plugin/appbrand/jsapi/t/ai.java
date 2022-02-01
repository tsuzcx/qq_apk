package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 577;
  @Deprecated
  public static final String NAME = "showNavigationBar";
  private static final ai.a soF;
  
  static
  {
    AppMethodBeat.i(138290);
    soF = new ai.a((byte)0);
    AppMethodBeat.o(138290);
  }
  
  private static final void a(g paramg, int paramInt, ai paramai)
  {
    AppMethodBeat.i(327754);
    s.u(paramai, "this$0");
    ad localad;
    if ((paramg instanceof ad)) {
      localad = (ad)paramg;
    }
    while (localad == null)
    {
      s.u(paramai, "this$0");
      paramg.callback(paramInt, paramai.ZP("fail:page don't exist"));
      AppMethodBeat.o(327754);
      return;
      if ((paramg instanceof y)) {
        localad = ((y)paramg).getCurrentPageView();
      } else {
        localad = null;
      }
    }
    localad.cEQ();
    paramg.callback(paramInt, paramai.ZP("ok"));
    AppMethodBeat.o(327754);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.ai
 * JD-Core Version:    0.7.0.1
 */