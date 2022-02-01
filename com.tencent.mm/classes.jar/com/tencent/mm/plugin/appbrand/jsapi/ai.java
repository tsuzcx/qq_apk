package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends s
{
  public static final int CTRL_INDEX = 590;
  public static final String NAME = "onKeyboardHeightChange";
  public static final ai.a rwT;
  
  static
  {
    AppMethodBeat.i(135573);
    rwT = new ai.a((byte)0);
    AppMethodBeat.o(135573);
  }
  
  public final void a(int paramInt, y paramy, ad paramad)
  {
    AppMethodBeat.i(325544);
    kotlin.g.b.s.u(paramy, "service");
    kotlin.g.b.s.u(paramad, "page");
    a(this, paramInt, paramy, paramad);
    AppMethodBeat.o(325544);
  }
  
  public final void a(int paramInt, y paramy, ad paramad, Integer paramInteger)
  {
    AppMethodBeat.i(135571);
    kotlin.g.b.s.u(paramy, "service");
    kotlin.g.b.s.u(paramad, "page");
    w("height", Integer.valueOf(i.DA(paramInt)));
    if (paramInteger != null) {
      w("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    h((f)paramy).cpV();
    h((f)paramad).cpV();
    AppMethodBeat.o(135571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */