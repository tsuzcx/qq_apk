package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.g;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"})
public final class ab
  extends p
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final ab.a kqW;
  
  static
  {
    AppMethodBeat.i(135573);
    kqW = new ab.a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, q paramq, aa paramaa, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    d.g.b.p.h(paramq, "service");
    d.g.b.p.h(paramaa, "page");
    p("height", Integer.valueOf(g.vH(paramInt)));
    if (paramInteger != null) {
      p("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    g((c)paramq).bir();
    g((c)paramaa).bir();
    AppMethodBeat.o(135571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */