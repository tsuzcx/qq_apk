package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class df
{
  public static final df lCR;
  
  static
  {
    AppMethodBeat.i(135576);
    lCR = new df();
    AppMethodBeat.o(135576);
  }
  
  public static final ac i(f paramf)
  {
    AppMethodBeat.i(135574);
    if (paramf == null)
    {
      AppMethodBeat.o(135574);
      return null;
    }
    if ((paramf instanceof ac))
    {
      paramf = (ac)paramf;
      AppMethodBeat.o(135574);
      return paramf;
    }
    if ((paramf instanceof s))
    {
      paramf = ((s)paramf).getCurrentPageView();
      AppMethodBeat.o(135574);
      return paramf;
    }
    AppMethodBeat.o(135574);
    return null;
  }
  
  public static final s j(f paramf)
  {
    AppMethodBeat.i(135575);
    if (paramf == null)
    {
      AppMethodBeat.o(135575);
      return null;
    }
    if ((paramf instanceof ac))
    {
      paramf = ((ac)paramf).NY();
      AppMethodBeat.o(135575);
      return paramf;
    }
    if ((paramf instanceof s))
    {
      paramf = (s)paramf;
      AppMethodBeat.o(135575);
      return paramf;
    }
    AppMethodBeat.o(135575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.df
 * JD-Core Version:    0.7.0.1
 */