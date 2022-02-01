package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i
  extends z
{
  private static final ThreadLocal<i> fil;
  private final a fij;
  private boolean fik;
  
  static
  {
    AppMethodBeat.i(144034);
    fil = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.fij = parama;
    this.fik = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(262216);
    if (fil.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(262216);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    fil.set(parama);
    AppMethodBeat.o(262216);
    return parama;
  }
  
  protected final boolean acf()
  {
    AppMethodBeat.i(144028);
    if ((!this.fik) && (super.acf()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void acg()
  {
    AppMethodBeat.i(144029);
    super.acg();
    this.fik = this.fij.ace();
    AppMethodBeat.o(144029);
  }
  
  protected final void ach()
  {
    AppMethodBeat.i(262218);
    super.ach();
    this.fik = this.fij.ace();
    AppMethodBeat.o(262218);
  }
  
  protected final void aci()
  {
    AppMethodBeat.i(144030);
    super.aci();
    if (this.fij != null) {
      this.fij.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void acj()
  {
    AppMethodBeat.i(144031);
    if ((this.fij != null) && (!isPaused())) {
      this.fij.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void ack()
  {
    AppMethodBeat.i(144033);
    if (this.fij != null)
    {
      Log.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.fij.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.fij != null) {
      this.fij.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean ace();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */