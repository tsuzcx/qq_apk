package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.d.a;

final class k$4
  implements d.a
{
  k$4(k paramk) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(43810);
    this.jxR.o("pageView onInterrupt %s, countdown", new Object[] { paramObject });
    this.jxR.jxL = null;
    this.jxR.aWr();
    AppMethodBeat.o(43810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.4
 * JD-Core Version:    0.7.0.1
 */