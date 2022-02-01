package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d mvo;
  
  static
  {
    AppMethodBeat.i(50723);
    mvo = new d();
    AppMethodBeat.o(50723);
  }
  
  public static final List<p> bIV()
  {
    AppMethodBeat.i(50722);
    List localList = j.listOf(new com.tencent.mm.plugin.appbrand.jsapi.d[] { (com.tencent.mm.plugin.appbrand.jsapi.d)new API_openWeAppSearch(), (com.tencent.mm.plugin.appbrand.jsapi.d)new a(), (com.tencent.mm.plugin.appbrand.jsapi.d)new c(), (com.tencent.mm.plugin.appbrand.jsapi.d)new b() });
    AppMethodBeat.o(50722);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d
 * JD-Core Version:    0.7.0.1
 */