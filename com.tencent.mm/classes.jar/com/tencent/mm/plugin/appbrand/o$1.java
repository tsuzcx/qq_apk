package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import d.g.b.p;

final class o$1
  implements b
{
  private HandOffMP jzA;
  
  o$1(o paramo)
  {
    AppMethodBeat.i(174653);
    this.jzA = com.tencent.mm.plugin.appbrand.k.a.t(this.jzB);
    AppMethodBeat.o(174653);
  }
  
  public final void KG(String paramString)
  {
    AppMethodBeat.i(174654);
    HandOffMP localHandOffMP = this.jzA;
    p.h(paramString, "<set-?>");
    localHandOffMP.uDT = paramString;
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.jzA);
    AppMethodBeat.o(174654);
  }
  
  public final void aXn()
  {
    AppMethodBeat.i(174655);
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(this.jzA.key);
    AppMethodBeat.o(174655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.1
 * JD-Core Version:    0.7.0.1
 */