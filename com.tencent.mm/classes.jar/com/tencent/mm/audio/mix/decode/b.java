package com.tencent.mm.audio.mix.decode;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends j
{
  private k fnO;
  public boolean fnP = false;
  public l fnQ;
  
  public b(k paramk, String paramString)
  {
    super(paramString);
    this.fnO = paramk;
  }
  
  public final boolean adC()
  {
    return this.fnQ == null;
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(136798);
    this.fnQ = paraml;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.fnP = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.fnP)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.fnO.a(this.fnQ);
    this.fnO.a(this);
    this.fnP = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.b
 * JD-Core Version:    0.7.0.1
 */