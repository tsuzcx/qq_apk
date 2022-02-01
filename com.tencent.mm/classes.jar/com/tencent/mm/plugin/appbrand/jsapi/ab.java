package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.g;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"})
public final class ab
  extends p
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final a jWF;
  
  static
  {
    AppMethodBeat.i(135573);
    jWF = new a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, q paramq, aa paramaa, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    k.h(paramq, "service");
    k.h(paramaa, "page");
    q("height", Integer.valueOf(g.vc(paramInt)));
    if (paramInteger != null) {
      q("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    g((c)paramq).beN();
    g((c)paramaa).beN();
    AppMethodBeat.o(135571);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */