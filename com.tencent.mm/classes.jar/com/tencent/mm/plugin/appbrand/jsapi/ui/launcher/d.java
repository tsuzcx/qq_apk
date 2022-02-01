package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d syR;
  
  static
  {
    AppMethodBeat.i(50723);
    syR = new d();
    AppMethodBeat.o(50723);
  }
  
  public static final List<com.tencent.mm.plugin.appbrand.jsapi.p> cuU()
  {
    AppMethodBeat.i(50722);
    List localList = kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.c[] { (com.tencent.mm.plugin.appbrand.jsapi.c)new API_openWeAppSearch(), (com.tencent.mm.plugin.appbrand.jsapi.c)new a(), (com.tencent.mm.plugin.appbrand.jsapi.c)new c(), (com.tencent.mm.plugin.appbrand.jsapi.c)new b() });
    AppMethodBeat.o(50722);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d
 * JD-Core Version:    0.7.0.1
 */