package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab
  extends z
{
  private static final ThreadLocal<ab> fil;
  private final a fkv;
  
  static
  {
    AppMethodBeat.i(262259);
    fil = new ThreadLocal();
    AppMethodBeat.o(262259);
  }
  
  private ab(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.fkv = parama;
  }
  
  public static ab a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(262255);
    if (fil.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(262255);
      throw parama;
    }
    parama = new ab(parama, paramBoolean);
    fil.set(parama);
    AppMethodBeat.o(262255);
    return parama;
  }
  
  protected final void acg()
  {
    AppMethodBeat.i(262257);
    super.acg();
    if (this.fkv != null) {
      this.fkv.acv();
    }
    AppMethodBeat.o(262257);
  }
  
  static abstract interface a
  {
    public abstract void acv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ab
 * JD-Core Version:    0.7.0.1
 */