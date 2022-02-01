package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"})
public final class af
  extends s
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final a lyf;
  
  static
  {
    AppMethodBeat.i(135573);
    lyf = new a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.appbrand.s params, ac paramac, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    p.h(params, "service");
    p.h(paramac, "page");
    p("height", Integer.valueOf(g.zB(paramInt)));
    if (paramInteger != null) {
      p("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    g((f)params).bEo();
    g((f)paramac).bEo();
    AppMethodBeat.o(135571);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af
 * JD-Core Version:    0.7.0.1
 */