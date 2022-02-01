package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d ptN;
  
  static
  {
    AppMethodBeat.i(50723);
    ptN = new d();
    AppMethodBeat.o(50723);
  }
  
  public static final List<o> bUE()
  {
    AppMethodBeat.i(50722);
    List localList = j.listOf(new com.tencent.mm.plugin.appbrand.jsapi.c[] { (com.tencent.mm.plugin.appbrand.jsapi.c)new API_openWeAppSearch(), (com.tencent.mm.plugin.appbrand.jsapi.c)new a(), (com.tencent.mm.plugin.appbrand.jsapi.c)new c(), (com.tencent.mm.plugin.appbrand.jsapi.c)new b() });
    AppMethodBeat.o(50722);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d
 * JD-Core Version:    0.7.0.1
 */