package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab
  extends z
{
  private static final ThreadLocal<ab> hmy;
  private final a hoI;
  
  static
  {
    AppMethodBeat.i(238624);
    hmy = new ThreadLocal();
    AppMethodBeat.o(238624);
  }
  
  private ab(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.hoI = parama;
  }
  
  public static ab a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(238617);
    if (hmy.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(238617);
      throw parama;
    }
    parama = new ab(parama, paramBoolean);
    hmy.set(parama);
    AppMethodBeat.o(238617);
    return parama;
  }
  
  protected final void aEf()
  {
    AppMethodBeat.i(238627);
    super.aEf();
    if (this.hoI != null) {
      this.hoI.aEv();
    }
    AppMethodBeat.o(238627);
  }
  
  static abstract interface a
  {
    public abstract void aEv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ab
 * JD-Core Version:    0.7.0.1
 */