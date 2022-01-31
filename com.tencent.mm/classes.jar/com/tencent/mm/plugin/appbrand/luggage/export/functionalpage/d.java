package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;

public final class d
  extends com.tencent.mm.plugin.appbrand.service.c
  implements m
{
  private volatile l ioA;
  
  public final l aBq()
  {
    AppMethodBeat.i(132118);
    l locall = new l(this);
    this.ioA = locall;
    AppMethodBeat.o(132118);
    return locall;
  }
  
  public final l aHz()
  {
    return this.ioA;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(132120);
    ((j)super.getRuntime()).ioI.a(this, paramInt, paramString);
    AppMethodBeat.o(132120);
  }
  
  public final void tW() {}
  
  public final i wB()
  {
    AppMethodBeat.i(132119);
    com.tencent.mm.plugin.appbrand.i.c localc = new com.tencent.mm.plugin.appbrand.i.c();
    AppMethodBeat.o(132119);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d
 * JD-Core Version:    0.7.0.1
 */