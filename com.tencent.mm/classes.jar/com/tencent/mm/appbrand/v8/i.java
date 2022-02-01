package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class i
  extends z
{
  private static final ThreadLocal<i> cYb;
  private final a cXZ;
  private boolean cYa;
  
  static
  {
    AppMethodBeat.i(144034);
    cYb = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.cXZ = parama;
    this.cYa = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(198687);
    if (cYb.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(198687);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    cYb.set(parama);
    AppMethodBeat.o(198687);
    return parama;
  }
  
  protected final boolean Nv()
  {
    AppMethodBeat.i(144028);
    if ((!this.cYa) && (super.Nv()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void Nw()
  {
    AppMethodBeat.i(144029);
    super.Nw();
    this.cYa = this.cXZ.Nu();
    AppMethodBeat.o(144029);
  }
  
  protected final void Nx()
  {
    AppMethodBeat.i(144030);
    super.Nx();
    if (this.cXZ != null) {
      this.cXZ.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void Ny()
  {
    AppMethodBeat.i(144031);
    if ((this.cXZ != null) && (!isPaused())) {
      this.cXZ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void Nz()
  {
    AppMethodBeat.i(144033);
    if (this.cXZ != null)
    {
      ad.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.cXZ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.cXZ != null) {
      this.cXZ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean Nu();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */