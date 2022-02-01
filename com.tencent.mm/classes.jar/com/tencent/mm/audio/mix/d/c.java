package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.decode.j;
import com.tencent.mm.audio.mix.h.b;

public final class c
  extends j
{
  public boolean fnP = false;
  public g foG;
  public com.tencent.mm.audio.mix.g.c foH;
  
  public c(g paramg, String paramString)
  {
    super(paramString);
    this.foG = paramg;
  }
  
  public final void b(com.tencent.mm.audio.mix.g.c paramc)
  {
    AppMethodBeat.i(257301);
    this.foH = paramc;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(257301);
  }
  
  public final void reset()
  {
    this.fnP = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(257298);
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s", new Object[] { this.name });
    if (this.fnP)
    {
      this.foG.a(this);
      AppMethodBeat.o(257298);
      return;
    }
    Process.setThreadPriority(10);
    this.foG.a(this.foH);
    this.foG.a(this);
    this.fnP = true;
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(257298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */