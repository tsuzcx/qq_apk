package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class cl
{
  public static final cl jAr;
  
  static
  {
    AppMethodBeat.i(135576);
    jAr = new cl();
    AppMethodBeat.o(135576);
  }
  
  public static final aa i(c paramc)
  {
    AppMethodBeat.i(135574);
    if (paramc == null)
    {
      AppMethodBeat.o(135574);
      return null;
    }
    if ((paramc instanceof aa))
    {
      paramc = (aa)paramc;
      AppMethodBeat.o(135574);
      return paramc;
    }
    if ((paramc instanceof q))
    {
      paramc = ((q)paramc).getCurrentPageView();
      AppMethodBeat.o(135574);
      return paramc;
    }
    AppMethodBeat.o(135574);
    return null;
  }
  
  public static final q j(c paramc)
  {
    AppMethodBeat.i(135575);
    if (paramc == null)
    {
      AppMethodBeat.o(135575);
      return null;
    }
    if ((paramc instanceof aa))
    {
      paramc = ((aa)paramc).Du();
      AppMethodBeat.o(135575);
      return paramc;
    }
    if ((paramc instanceof q))
    {
      paramc = (q)paramc;
      AppMethodBeat.o(135575);
      return paramc;
    }
    AppMethodBeat.o(135575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cl
 * JD-Core Version:    0.7.0.1
 */