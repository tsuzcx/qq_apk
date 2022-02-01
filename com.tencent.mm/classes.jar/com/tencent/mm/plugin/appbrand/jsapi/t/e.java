package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ad.7;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 578;
  @Deprecated
  public static final String NAME = "hideNavigationBar";
  private static final e.a snL;
  
  static
  {
    AppMethodBeat.i(138286);
    snL = new e.a((byte)0);
    AppMethodBeat.o(138286);
  }
  
  private static final void a(g paramg, int paramInt, e parame)
  {
    AppMethodBeat.i(327723);
    s.u(parame, "this$0");
    ad localad;
    if ((paramg instanceof ad)) {
      localad = (ad)paramg;
    }
    while (localad == null)
    {
      s.u(parame, "this$0");
      paramg.callback(paramInt, parame.ZP("fail:page don't exist"));
      AppMethodBeat.o(327723);
      return;
      if ((paramg instanceof y)) {
        localad = ((y)paramg).getCurrentPageView();
      } else {
        localad = null;
      }
    }
    localad.V(new ad.7(localad));
    paramg.callback(paramInt, parame.ZP("ok"));
    AppMethodBeat.o(327723);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e
 * JD-Core Version:    0.7.0.1
 */