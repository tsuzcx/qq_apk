package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class co
{
  public static final co kyy;
  
  static
  {
    AppMethodBeat.i(135576);
    kyy = new co();
    AppMethodBeat.o(135576);
  }
  
  public static final z i(c paramc)
  {
    AppMethodBeat.i(135574);
    if (paramc == null)
    {
      AppMethodBeat.o(135574);
      return null;
    }
    if ((paramc instanceof z))
    {
      paramc = (z)paramc;
      AppMethodBeat.o(135574);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      paramc = ((r)paramc).getCurrentPageView();
      AppMethodBeat.o(135574);
      return paramc;
    }
    AppMethodBeat.o(135574);
    return null;
  }
  
  public static final r j(c paramc)
  {
    AppMethodBeat.i(135575);
    if (paramc == null)
    {
      AppMethodBeat.o(135575);
      return null;
    }
    if ((paramc instanceof z))
    {
      paramc = ((z)paramc).Ey();
      AppMethodBeat.o(135575);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      paramc = (r)paramc;
      AppMethodBeat.o(135575);
      return paramc;
    }
    AppMethodBeat.o(135575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.co
 * JD-Core Version:    0.7.0.1
 */