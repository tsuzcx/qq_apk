package com.tencent.mm.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
  extends w
{
  private static final ThreadLocal<j> cbv;
  private final a cbt;
  private boolean cbu;
  
  static
  {
    AppMethodBeat.i(113827);
    cbv = new ThreadLocal();
    AppMethodBeat.o(113827);
  }
  
  private j(a parama)
  {
    this.cbt = parama;
    this.cbu = true;
  }
  
  public static j a(a parama)
  {
    AppMethodBeat.i(113822);
    if (cbv.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(113822);
      throw parama;
    }
    parama = new j(parama);
    cbv.set(parama);
    AppMethodBeat.o(113822);
    return parama;
  }
  
  protected final boolean Cq()
  {
    AppMethodBeat.i(113823);
    if ((!this.cbu) && (super.Cq()))
    {
      AppMethodBeat.o(113823);
      return true;
    }
    AppMethodBeat.o(113823);
    return false;
  }
  
  protected final void Cr()
  {
    AppMethodBeat.i(113824);
    super.Cr();
    this.cbu = this.cbt.Cp();
    AppMethodBeat.o(113824);
  }
  
  protected final void Cs()
  {
    AppMethodBeat.i(113825);
    super.Cs();
    if (this.cbt != null) {
      this.cbt.closeUVLoop();
    }
    AppMethodBeat.o(113825);
  }
  
  protected final void Ct()
  {
    AppMethodBeat.i(113826);
    if ((this.cbt != null) && (!isPaused())) {
      this.cbt.wakeUpUVLoop();
    }
    AppMethodBeat.o(113826);
  }
  
  static abstract interface a
  {
    public abstract boolean Cp();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.j
 * JD-Core Version:    0.7.0.1
 */