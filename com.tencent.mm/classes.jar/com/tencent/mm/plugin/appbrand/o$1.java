package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import d.g.b.k;

final class o$1
  implements b
{
  private HandOffMP jgB;
  
  o$1(o paramo)
  {
    AppMethodBeat.i(174653);
    this.jgB = com.tencent.mm.plugin.appbrand.l.a.C(this.jgC);
    AppMethodBeat.o(174653);
  }
  
  public final void Hu(String paramString)
  {
    AppMethodBeat.i(174654);
    HandOffMP localHandOffMP = this.jgB;
    k.h(paramString, "<set-?>");
    localHandOffMP.tBk = paramString;
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.jgB);
    AppMethodBeat.o(174654);
  }
  
  public final void aUf()
  {
    AppMethodBeat.i(174655);
    ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(this.jgB.key);
    AppMethodBeat.o(174655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.1
 * JD-Core Version:    0.7.0.1
 */