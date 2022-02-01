package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class i
  extends z
{
  private static final ThreadLocal<i> cYZ;
  private final a cYX;
  private boolean cYY;
  
  static
  {
    AppMethodBeat.i(144034);
    cYZ = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.cYX = parama;
    this.cYY = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(194168);
    if (cYZ.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(194168);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    cYZ.set(parama);
    AppMethodBeat.o(194168);
    return parama;
  }
  
  protected final boolean Nq()
  {
    AppMethodBeat.i(144028);
    if ((!this.cYY) && (super.Nq()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void Nr()
  {
    AppMethodBeat.i(144029);
    super.Nr();
    this.cYY = this.cYX.Np();
    AppMethodBeat.o(144029);
  }
  
  protected final void Ns()
  {
    AppMethodBeat.i(194169);
    super.Ns();
    this.cYY = this.cYX.Np();
    AppMethodBeat.o(194169);
  }
  
  protected final void Nt()
  {
    AppMethodBeat.i(144030);
    super.Nt();
    if (this.cYX != null) {
      this.cYX.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void Nu()
  {
    AppMethodBeat.i(144031);
    if ((this.cYX != null) && (!isPaused())) {
      this.cYX.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void Nv()
  {
    AppMethodBeat.i(144033);
    if (this.cYX != null)
    {
      ae.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.cYX.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.cYX != null) {
      this.cYX.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean Np();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */