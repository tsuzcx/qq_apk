package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.a.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d ibu;
  
  static
  {
    AppMethodBeat.i(143902);
    ibu = new d();
    AppMethodBeat.o(143902);
  }
  
  public static final List<m> aEK()
  {
    AppMethodBeat.i(143901);
    List localList = j.listOf(new com.tencent.mm.plugin.appbrand.jsapi.a[] { (com.tencent.mm.plugin.appbrand.jsapi.a)new API_openWeAppSearch(), (com.tencent.mm.plugin.appbrand.jsapi.a)new a(), (com.tencent.mm.plugin.appbrand.jsapi.a)new c(), (com.tencent.mm.plugin.appbrand.jsapi.a)new b() });
    AppMethodBeat.o(143901);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d
 * JD-Core Version:    0.7.0.1
 */