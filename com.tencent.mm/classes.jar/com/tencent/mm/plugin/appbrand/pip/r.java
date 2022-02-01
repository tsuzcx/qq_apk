package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipFixLeak;", "", "()V", "resetWindowAndroid", "", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipManager;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "luggage-wxa-app_release"})
public final class r
{
  public static final r rrE;
  
  static
  {
    AppMethodBeat.i(292935);
    rrE = new r();
    AppMethodBeat.o(292935);
  }
  
  public static final void a(f paramf, c paramc)
  {
    AppMethodBeat.i(292934);
    p.k(paramf, "$this$resetWindowAndroid");
    paramf = paramf.bIy();
    p.j(paramf, "this.allPageScopedPipInfoStructs");
    paramf = ((Iterable)paramf).iterator();
    while (paramf.hasNext())
    {
      ad localad = ((a)paramf.next()).cvo;
      p.j(localad, "it.mPageView");
      localad.b(paramc);
    }
    AppMethodBeat.o(292934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.r
 * JD-Core Version:    0.7.0.1
 */