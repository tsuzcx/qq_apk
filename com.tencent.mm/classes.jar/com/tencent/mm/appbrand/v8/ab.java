package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab
  extends z
{
  private static final ThreadLocal<ab> dpE;
  private final a drJ;
  
  static
  {
    AppMethodBeat.i(216935);
    dpE = new ThreadLocal();
    AppMethodBeat.o(216935);
  }
  
  private ab(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.drJ = parama;
  }
  
  public static ab a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(216933);
    if (dpE.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(216933);
      throw parama;
    }
    parama = new ab(parama, paramBoolean);
    dpE.set(parama);
    AppMethodBeat.o(216933);
    return parama;
  }
  
  protected final void XD()
  {
    AppMethodBeat.i(216934);
    super.XD();
    if (this.drJ != null) {
      this.drJ.XP();
    }
    AppMethodBeat.o(216934);
  }
  
  static abstract interface a
  {
    public abstract void XP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ab
 * JD-Core Version:    0.7.0.1
 */