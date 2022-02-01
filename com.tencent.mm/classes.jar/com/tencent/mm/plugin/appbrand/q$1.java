package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.handoff.model.HandOffMP;

final class q$1
  implements b
{
  private HandOffMP kDD;
  
  q$1(q paramq)
  {
    AppMethodBeat.i(174653);
    this.kDD = com.tencent.mm.plugin.appbrand.k.a.y(this.kDE);
    AppMethodBeat.o(174653);
  }
  
  public final void Uo(String paramString)
  {
    AppMethodBeat.i(174654);
    this.kDD.setAppEntryPage(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.kDD);
    AppMethodBeat.o(174654);
  }
  
  public final void aK(String paramString, int paramInt)
  {
    AppMethodBeat.i(226178);
    this.kDD.setHandOffType(paramInt);
    this.kDD.setAppEntryPage(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(this.kDD);
    AppMethodBeat.o(226178);
  }
  
  public final void bsP()
  {
    AppMethodBeat.i(174655);
    ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).del(this.kDD.getKey());
    AppMethodBeat.o(174655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.1
 * JD-Core Version:    0.7.0.1
 */