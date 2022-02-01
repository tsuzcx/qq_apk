package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"})
public final class ab
  extends p
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final a kul;
  
  static
  {
    AppMethodBeat.i(135573);
    kul = new a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, r paramr, z paramz, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    d.g.b.p.h(paramr, "service");
    d.g.b.p.h(paramz, "page");
    p("height", Integer.valueOf(g.vM(paramInt)));
    if (paramInteger != null) {
      p("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    g((c)paramr).bja();
    g((c)paramz).bja();
    AppMethodBeat.o(135571);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */