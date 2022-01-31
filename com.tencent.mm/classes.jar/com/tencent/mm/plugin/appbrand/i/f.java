package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;

final class f
  extends d
{
  private final c cbC;
  private final l ijm;
  private final int ijn;
  
  public f(l paraml, int paramInt)
  {
    this.cbC = paraml.cbC;
    this.ijm = paraml;
    this.ijn = paramInt;
  }
  
  public final int aGA()
  {
    return this.ijn;
  }
  
  protected final c aGx()
  {
    return this.cbC;
  }
  
  protected final l aGy()
  {
    return this.ijm;
  }
  
  public final boolean aGz()
  {
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(113942);
    com.tencent.luggage.g.d.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
    AppMethodBeat.o(113942);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(113943);
    com.tencent.luggage.g.d.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
    AppMethodBeat.o(113943);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(113941);
    this.ijm.a(this.ijn, paramh);
    AppMethodBeat.o(113941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.f
 * JD-Core Version:    0.7.0.1
 */