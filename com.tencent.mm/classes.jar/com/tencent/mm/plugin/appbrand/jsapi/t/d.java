package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 684;
  @Deprecated
  public static final String NAME = "hideHomeButton";
  private static final d.a snK;
  
  static
  {
    AppMethodBeat.i(327738);
    snK = new d.a((byte)0);
    AppMethodBeat.o(327738);
  }
  
  private static final void a(ad paramad, g paramg, int paramInt, d paramd)
  {
    AppMethodBeat.i(327734);
    s.u(paramd, "this$0");
    if (paramad.cEC() == null) {
      paramad.cEY();
    }
    for (;;)
    {
      s.checkNotNull(paramg);
      paramg.callback(paramInt, paramd.ZP("ok"));
      AppMethodBeat.o(327734);
      return;
      paramad.cEZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.d
 * JD-Core Version:    0.7.0.1
 */