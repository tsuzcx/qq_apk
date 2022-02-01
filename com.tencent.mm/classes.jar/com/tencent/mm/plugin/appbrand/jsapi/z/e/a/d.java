package com.tencent.mm.plugin.appbrand.jsapi.z.e.a;

import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.i.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"CAST_BUTTON_CLICKED", "", "CAST_BUTTON_SHOW", "CAST_URL_CHANGE", "DEVICE_BUTTON_CLICKED", "EXIT_BUTTON_CLICKED", "HELP_BUTTON_CLICKED", "RECONNECT_BUTTON_CLICKED", "SWITCH_BUTTON_CLICKED", "getAppBrandRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "luggage-xweb-ext_release"})
public final class d
{
  public static final AppBrandRuntime B(a parama)
  {
    AppMethodBeat.i(139683);
    k.h(parama, "$this$getAppBrandRuntime");
    if (!(parama instanceof b))
    {
      parama = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139683);
      throw parama;
    }
    parama = ((b)parama).CM();
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.d))
    {
      parama = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139683);
      throw parama;
    }
    parama = ((com.tencent.mm.plugin.appbrand.d)parama).getRuntime();
    k.g(parama, "component.runtime");
    AppMethodBeat.o(139683);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.a.d
 * JD-Core Version:    0.7.0.1
 */