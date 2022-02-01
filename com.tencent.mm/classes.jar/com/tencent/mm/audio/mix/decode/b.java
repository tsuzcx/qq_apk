package com.tencent.mm.audio.mix.decode;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends j
{
  private k hrZ;
  public boolean hsa = false;
  public l hsb;
  
  public b(k paramk, String paramString)
  {
    super(paramString);
    this.hrZ = paramk;
  }
  
  public final boolean aFA()
  {
    return this.hsb == null;
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(136798);
    this.hsb = paraml;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.hsa = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.hsa)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.hrZ.a(this.hsb);
    this.hrZ.a(this);
    this.hsa = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.b
 * JD-Core Version:    0.7.0.1
 */