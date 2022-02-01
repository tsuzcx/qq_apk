package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"})
public final class af
  extends r
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final af.a osT;
  
  static
  {
    AppMethodBeat.i(135573);
    osT = new af.a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, v paramv, ad paramad, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    p.k(paramv, "service");
    p.k(paramad, "page");
    o("height", Integer.valueOf(g.Dg(paramInt)));
    if (paramInteger != null) {
      o("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    i((e)paramv).bPO();
    i((e)paramad).bPO();
    AppMethodBeat.o(135571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af
 * JD-Core Version:    0.7.0.1
 */