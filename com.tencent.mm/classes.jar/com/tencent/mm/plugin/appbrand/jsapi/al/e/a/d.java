package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.h.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"CAST_BUTTON_CLICKED", "", "CAST_BUTTON_SHOW", "CAST_URL_CHANGE", "DEVICE_BUTTON_CLICKED", "EXIT_BUTTON_CLICKED", "HELP_BUTTON_CLICKED", "RECONNECT_BUTTON_CLICKED", "SWITCH_BUTTON_CLICKED", "getAppBrandRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "luggage-xweb-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final AppBrandRuntime B(a parama)
  {
    AppMethodBeat.i(139683);
    s.u(parama, "<this>");
    if (!(parama instanceof b))
    {
      parama = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139683);
      throw parama;
    }
    parama = ((b)parama).rot;
    if (!(parama instanceof g))
    {
      parama = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139683);
      throw parama;
    }
    parama = ((g)parama).getRuntime();
    s.s(parama, "component.runtime");
    AppMethodBeat.o(139683);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.d
 * JD-Core Version:    0.7.0.1
 */