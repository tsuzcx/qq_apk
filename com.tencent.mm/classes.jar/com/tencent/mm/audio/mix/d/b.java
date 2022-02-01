package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends i
{
  private j cRS;
  public boolean cRT = false;
  public k cRU;
  
  public b(j paramj, String paramString)
  {
    super(paramString);
    this.cRS = paramj;
  }
  
  public final boolean MU()
  {
    return this.cRU == null;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(136798);
    this.cRU = paramk;
    this.cSx = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.cRT = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.cRT)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.cRS.a(this.cRU);
    this.cRS.a(this);
    this.cRT = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */