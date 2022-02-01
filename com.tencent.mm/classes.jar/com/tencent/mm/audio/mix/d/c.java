package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.decode.j;
import com.tencent.mm.audio.mix.h.b;

public final class c
  extends j
{
  public g hsQ;
  public com.tencent.mm.audio.mix.g.c hsR;
  public boolean hsa = false;
  
  public c(g paramg, String paramString)
  {
    super(paramString);
    this.hsQ = paramg;
  }
  
  public final void b(com.tencent.mm.audio.mix.g.c paramc)
  {
    AppMethodBeat.i(236208);
    this.hsR = paramc;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(236208);
  }
  
  public final void reset()
  {
    this.hsa = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(236205);
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s", new Object[] { this.name });
    if (this.hsa)
    {
      this.hsQ.a(this);
      AppMethodBeat.o(236205);
      return;
    }
    Process.setThreadPriority(10);
    this.hsQ.a(this.hsR);
    this.hsQ.a(this);
    this.hsa = true;
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(236205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */