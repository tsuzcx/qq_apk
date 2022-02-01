package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class d
  extends c<g>
{
  public static final int CTRL_INDEX = 684;
  public static final String NAME = "hideHomeButton";
  @Deprecated
  public static final d.a pis;
  
  static
  {
    AppMethodBeat.i(209072);
    pis = new d.a((byte)0);
    AppMethodBeat.o(209072);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, ad paramad, g paramg, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(209122);
      if (this.piu.cdY() == null) {
        this.piu.cev();
      }
      for (;;)
      {
        g localg = this.owL;
        if (localg == null) {
          p.iCn();
        }
        localg.j(this.otk, this.pit.agS("ok"));
        AppMethodBeat.o(209122);
        return;
        this.piu.cew();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d
 * JD-Core Version:    0.7.0.1
 */