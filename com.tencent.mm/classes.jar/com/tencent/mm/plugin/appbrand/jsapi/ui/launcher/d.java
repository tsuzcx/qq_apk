package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import d.a.j;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d loH;
  
  static
  {
    AppMethodBeat.i(50723);
    loH = new d();
    AppMethodBeat.o(50723);
  }
  
  public static final List<m> bnr()
  {
    AppMethodBeat.i(50722);
    List localList = j.listOf(new com.tencent.mm.plugin.appbrand.jsapi.a[] { (com.tencent.mm.plugin.appbrand.jsapi.a)new API_openWeAppSearch(), (com.tencent.mm.plugin.appbrand.jsapi.a)new a(), (com.tencent.mm.plugin.appbrand.jsapi.a)new c(), (com.tencent.mm.plugin.appbrand.jsapi.a)new b() });
    AppMethodBeat.o(50722);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d
 * JD-Core Version:    0.7.0.1
 */