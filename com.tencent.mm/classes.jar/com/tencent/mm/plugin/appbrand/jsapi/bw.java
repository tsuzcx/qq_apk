package com.tencent.mm.plugin.appbrand.jsapi;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class bw
{
  public static final bw hAN;
  
  static
  {
    AppMethodBeat.i(141734);
    hAN = new bw();
    AppMethodBeat.o(141734);
  }
  
  public static final v l(c paramc)
  {
    AppMethodBeat.i(141732);
    if (paramc == null)
    {
      AppMethodBeat.o(141732);
      return null;
    }
    if ((paramc instanceof v))
    {
      paramc = (v)paramc;
      AppMethodBeat.o(141732);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      paramc = ((r)paramc).getCurrentPageView();
      AppMethodBeat.o(141732);
      return paramc;
    }
    AppMethodBeat.o(141732);
    return null;
  }
  
  public static final r m(c paramc)
  {
    AppMethodBeat.i(141733);
    if (paramc == null)
    {
      AppMethodBeat.o(141733);
      return null;
    }
    if ((paramc instanceof v))
    {
      paramc = ((v)paramc).ws();
      AppMethodBeat.o(141733);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      paramc = (r)paramc;
      AppMethodBeat.o(141733);
      return paramc;
    }
    AppMethodBeat.o(141733);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bw
 * JD-Core Version:    0.7.0.1
 */