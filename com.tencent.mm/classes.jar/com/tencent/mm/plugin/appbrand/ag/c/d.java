package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/FallbackThumbContainerFormatInferer;", "Lcom/tencent/mm/plugin/appbrand/video/thumb/IThumbContainerFormatInferer;", "()V", "isHls", "", "srcHolder", "Lcom/tencent/mm/plugin/appbrand/video/thumb/SrcHolder;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
{
  public static final d utr;
  
  static
  {
    AppMethodBeat.i(317875);
    utr = new d();
    AppMethodBeat.o(317875);
  }
  
  public static boolean a(e parame)
  {
    AppMethodBeat.i(317869);
    s.u(parame, "srcHolder");
    b localb = b.sEI;
    boolean bool = b.aco(parame.hqM);
    AppMethodBeat.o(317869);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.d
 * JD-Core Version:    0.7.0.1
 */