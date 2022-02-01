package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.handoff.model.HandOffMP;

final class t$12
  implements b
{
  private HandOffMP nwZ;
  
  t$12(t paramt)
  {
    AppMethodBeat.i(280408);
    this.nwZ = com.tencent.mm.plugin.appbrand.k.a.z(this.nwQ);
    AppMethodBeat.o(280408);
  }
  
  public final void abX(String paramString)
  {
    AppMethodBeat.i(280409);
    this.nwZ.setAppEntryPage(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.nwZ);
    AppMethodBeat.o(280409);
  }
  
  public final void bDR()
  {
    AppMethodBeat.i(280410);
    ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).del(this.nwZ.getKey());
    AppMethodBeat.o(280410);
  }
  
  public final void bd(String paramString, int paramInt)
  {
    AppMethodBeat.i(280411);
    this.nwZ.setHandOffType(paramInt);
    this.nwZ.setAppEntryPage(paramString);
    ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).f(this.nwZ);
    AppMethodBeat.o(280411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.12
 * JD-Core Version:    0.7.0.1
 */