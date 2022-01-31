package com.tencent.mm.plugin.appbrand.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.report.b.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements b.a
{
  a$1(a parama, i parami) {}
  
  public final void dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143088);
    if (this.gQE == null)
    {
      ab.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
      AppMethodBeat.o(143088);
      return;
    }
    if (((c)a.a(this.hrX)).getRuntime().mFinished)
    {
      ab.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
      AppMethodBeat.o(143088);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      String str = ((c)a.b(this.hrX)).getAppId();
      b localb = a.c(this.hrX);
      this.gQE.wY();
      com.tencent.mm.plugin.appbrand.report.quality.a.a(str, localb);
      AppMethodBeat.o(143088);
      return;
    }
    ab.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
    AppMethodBeat.o(143088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.1
 * JD-Core Version:    0.7.0.1
 */