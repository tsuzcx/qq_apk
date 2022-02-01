package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i
  extends z
{
  private static final ThreadLocal<i> hmy;
  private final a hmw;
  private boolean hmx;
  
  static
  {
    AppMethodBeat.i(144034);
    hmy = new ThreadLocal();
    AppMethodBeat.o(144034);
  }
  
  private i(a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.hmw = parama;
    this.hmx = true;
  }
  
  public static i a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(238650);
    if (hmy.get() != null)
    {
      parama = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(238650);
      throw parama;
    }
    parama = new i(parama, paramBoolean);
    hmy.set(parama);
    AppMethodBeat.o(238650);
    return parama;
  }
  
  protected final boolean aEe()
  {
    AppMethodBeat.i(144028);
    if ((!this.hmx) && (super.aEe()))
    {
      AppMethodBeat.o(144028);
      return true;
    }
    AppMethodBeat.o(144028);
    return false;
  }
  
  protected final void aEf()
  {
    AppMethodBeat.i(144029);
    super.aEf();
    this.hmx = this.hmw.aEd();
    AppMethodBeat.o(144029);
  }
  
  protected final void aEg()
  {
    AppMethodBeat.i(238667);
    super.aEg();
    this.hmx = this.hmw.aEd();
    AppMethodBeat.o(238667);
  }
  
  protected final void aEh()
  {
    AppMethodBeat.i(144030);
    super.aEh();
    if (this.hmw != null) {
      this.hmw.closeUVLoop();
    }
    AppMethodBeat.o(144030);
  }
  
  protected final void aEi()
  {
    AppMethodBeat.i(144031);
    if ((this.hmw != null) && (!isPaused())) {
      this.hmw.wakeUpUVLoop();
    }
    AppMethodBeat.o(144031);
  }
  
  protected final void aEj()
  {
    AppMethodBeat.i(144033);
    if (this.hmw != null)
    {
      Log.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.hmw.wakeUpUVLoop();
    }
    AppMethodBeat.o(144033);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(144032);
    if (this.hmw != null) {
      this.hmw.wakeUpUVLoop();
    }
    AppMethodBeat.o(144032);
  }
  
  static abstract interface a
  {
    public abstract boolean aEd();
    
    public abstract void closeUVLoop();
    
    public abstract void wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */