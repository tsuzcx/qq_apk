package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private long iXK;
  private long iXL;
  private k.a iXM;
  
  public k() {}
  
  public k(long paramLong, k.a parama)
  {
    this.iXK = paramLong;
    this.iXM = parama;
  }
  
  private boolean aOa()
  {
    AppMethodBeat.i(126636);
    if (System.currentTimeMillis() - this.iXL < this.iXK)
    {
      AppMethodBeat.o(126636);
      return true;
    }
    AppMethodBeat.o(126636);
    return false;
  }
  
  public final boolean l(Object... paramVarArgs)
  {
    AppMethodBeat.i(126637);
    if (aOa())
    {
      AppMethodBeat.o(126637);
      return false;
    }
    if (this.iXM == null)
    {
      AppMethodBeat.o(126637);
      return false;
    }
    boolean bool = this.iXM.j(paramVarArgs);
    if (bool) {
      this.iXL = System.currentTimeMillis();
    }
    AppMethodBeat.o(126637);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.k
 * JD-Core Version:    0.7.0.1
 */