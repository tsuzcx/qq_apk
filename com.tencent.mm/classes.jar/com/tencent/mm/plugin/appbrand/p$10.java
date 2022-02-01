package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.d.a;

final class p$10
  implements d.a
{
  p$10(p paramp) {}
  
  public final void onInterrupt(Object paramObject)
  {
    AppMethodBeat.i(316872);
    this.qtD.n("pageView onInterrupt %s, countdown", new Object[] { paramObject });
    this.qtD.qtx = null;
    this.qtD.cbU();
    AppMethodBeat.o(316872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.10
 * JD-Core Version:    0.7.0.1
 */