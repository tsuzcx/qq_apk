package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class i
  extends z
{
  private static final ThreadLocal<i> cPq;
  private final a cPo;
  private boolean cPp;
  
  static
  {
    AppMethodBeat.i(144034);
    cPq = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.cPo = parama;
    this.cPp = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(193488);
    if (cPq.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(193488);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    cPq.set(parama);
    AppMethodBeat.o(193488);
    return parama;
  }
  
  protected final boolean LO()
  {
    AppMethodBeat.i(144028);
    if ((!this.cPp) && (super.LO()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void LP()
  {
    AppMethodBeat.i(144029);
    super.LP();
    this.cPp = this.cPo.LN();
    AppMethodBeat.o(144029);
  }
  
  protected final void LQ()
  {
    AppMethodBeat.i(144030);
    super.LQ();
    if (this.cPo != null) {
      this.cPo.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void LR()
  {
    AppMethodBeat.i(144031);
    if ((this.cPo != null) && (!isPaused())) {
      this.cPo.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void LS()
  {
    AppMethodBeat.i(144033);
    if (this.cPo != null)
    {
      ad.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.cPo.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.cPo != null) {
      this.cPo.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean LN();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */