package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class dh
{
  public static final dh oyt;
  
  static
  {
    AppMethodBeat.i(135576);
    oyt = new dh();
    AppMethodBeat.o(135576);
  }
  
  public static final ad k(e parame)
  {
    AppMethodBeat.i(135574);
    if (parame == null)
    {
      AppMethodBeat.o(135574);
      return null;
    }
    if ((parame instanceof ad))
    {
      parame = (ad)parame;
      AppMethodBeat.o(135574);
      return parame;
    }
    if ((parame instanceof v))
    {
      parame = ((v)parame).getCurrentPageView();
      AppMethodBeat.o(135574);
      return parame;
    }
    AppMethodBeat.o(135574);
    return null;
  }
  
  public static final v l(e parame)
  {
    AppMethodBeat.i(135575);
    if (parame == null)
    {
      AppMethodBeat.o(135575);
      return null;
    }
    if ((parame instanceof ad))
    {
      parame = ((ad)parame).QW();
      AppMethodBeat.o(135575);
      return parame;
    }
    if ((parame instanceof v))
    {
      parame = (v)parame;
      AppMethodBeat.o(135575);
      return parame;
    }
    AppMethodBeat.o(135575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dh
 * JD-Core Version:    0.7.0.1
 */