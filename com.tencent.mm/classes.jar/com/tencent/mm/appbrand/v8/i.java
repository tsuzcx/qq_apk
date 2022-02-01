package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i
  extends z
{
  private static final ThreadLocal<i> dpE;
  private final a dpC;
  private boolean dpD;
  
  static
  {
    AppMethodBeat.i(144034);
    dpE = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.dpC = parama;
    this.dpD = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(216888);
    if (dpE.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(216888);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    dpE.set(parama);
    AppMethodBeat.o(216888);
    return parama;
  }
  
  protected final boolean XC()
  {
    AppMethodBeat.i(144028);
    if ((!this.dpD) && (super.XC()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void XD()
  {
    AppMethodBeat.i(144029);
    super.XD();
    this.dpD = this.dpC.XB();
    AppMethodBeat.o(144029);
  }
  
  protected final void XE()
  {
    AppMethodBeat.i(216889);
    super.XE();
    this.dpD = this.dpC.XB();
    AppMethodBeat.o(216889);
  }
  
  protected final void XF()
  {
    AppMethodBeat.i(144030);
    super.XF();
    if (this.dpC != null) {
      this.dpC.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void XG()
  {
    AppMethodBeat.i(144031);
    if ((this.dpC != null) && (!isPaused())) {
      this.dpC.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void XH()
  {
    AppMethodBeat.i(144033);
    if (this.dpC != null)
    {
      Log.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.dpC.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.dpC != null) {
      this.dpC.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean XB();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */