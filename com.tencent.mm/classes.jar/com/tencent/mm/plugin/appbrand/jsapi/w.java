package com.tencent.mm.plugin.appbrand.jsapi;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Companion", "luggage-wxa-app_release"})
public final class w
  extends p
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final w.a hxh;
  
  static
  {
    AppMethodBeat.i(87573);
    hxh = new w.a((byte)0);
    AppMethodBeat.o(87573);
  }
  
  public final void a(int paramInt, r paramr, v paramv, Integer paramInteger)
  {
    AppMethodBeat.i(87572);
    j.q(paramr, "service");
    j.q(paramv, "page");
    m("height", Integer.valueOf(g.pM(paramInt)));
    if (paramInteger != null) {
      m("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    i((c)paramr).aBz();
    i((c)paramv).aBz();
    AppMethodBeat.o(87572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w
 * JD-Core Version:    0.7.0.1
 */