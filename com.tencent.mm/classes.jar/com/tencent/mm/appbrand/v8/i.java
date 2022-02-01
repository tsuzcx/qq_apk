package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class i
  extends z
{
  private static final ThreadLocal<i> cML;
  private final a cMJ;
  private boolean cMK;
  
  static
  {
    AppMethodBeat.i(144034);
    cML = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.cMJ = parama;
    this.cMK = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(200814);
    if (cML.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(200814);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    cML.set(parama);
    AppMethodBeat.o(200814);
    return parama;
  }
  
  protected final boolean LM()
  {
    AppMethodBeat.i(144028);
    if ((!this.cMK) && (super.LM()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void LN()
  {
    AppMethodBeat.i(144029);
    super.LN();
    this.cMK = this.cMJ.LL();
    AppMethodBeat.o(144029);
  }
  
  protected final void LO()
  {
    AppMethodBeat.i(144030);
    super.LO();
    if (this.cMJ != null) {
      this.cMJ.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void LP()
  {
    AppMethodBeat.i(144031);
    if ((this.cMJ != null) && (!isPaused())) {
      this.cMJ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void LQ()
  {
    AppMethodBeat.i(144033);
    if (this.cMJ != null)
    {
      ac.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.cMJ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.cMJ != null) {
      this.cMJ.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean LL();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */