package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffMP;

final class p$1
  implements b
{
  private HandOffMP jCD;
  
  p$1(p paramp)
  {
    AppMethodBeat.i(174653);
    this.jCD = com.tencent.mm.plugin.appbrand.k.a.u(this.jCE);
    AppMethodBeat.o(174653);
  }
  
  public final void Lf(String paramString)
  {
    AppMethodBeat.i(174654);
    this.jCD.aoi(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.jCD);
    AppMethodBeat.o(174654);
  }
  
  public final void Lg(String paramString)
  {
    AppMethodBeat.i(221990);
    this.jCD.aoi(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.jCD);
    AppMethodBeat.o(221990);
  }
  
  public final void aXI()
  {
    AppMethodBeat.i(174655);
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(this.jCD.key);
    AppMethodBeat.o(174655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.1
 * JD-Core Version:    0.7.0.1
 */