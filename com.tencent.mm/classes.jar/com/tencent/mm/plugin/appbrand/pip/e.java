package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipFixLeak;", "", "()V", "resetWindowAndroid", "", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipManager;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e tJV;
  
  static
  {
    AppMethodBeat.i(319629);
    tJV = new e();
    AppMethodBeat.o(319629);
  }
  
  public static final void a(g paramg, c paramc)
  {
    AppMethodBeat.i(319621);
    s.u(paramg, "<this>");
    paramg = new LinkedList(paramg.tKf.values());
    s.s(paramg, "this.allPageScopedPipInfoStructs");
    paramg = ((Iterable)paramg).iterator();
    while (paramg.hasNext()) {
      ((a)paramg.next()).enm.a(paramc);
    }
    AppMethodBeat.o(319621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */