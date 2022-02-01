package com.tencent.mm.audio.mix.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;

public final class c
  extends j
{
  public g dvX;
  public com.tencent.mm.audio.mix.h.c dvY;
  public boolean dvh = false;
  
  public c(g paramg, String paramString)
  {
    super(paramString);
    this.dvX = paramg;
  }
  
  public final void b(com.tencent.mm.audio.mix.h.c paramc)
  {
    AppMethodBeat.i(198119);
    this.dvY = paramc;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(198119);
  }
  
  public final void reset()
  {
    this.dvh = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(198118);
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s", new Object[] { this.name });
    if (this.dvh)
    {
      this.dvX.a(this);
      AppMethodBeat.o(198118);
      return;
    }
    Process.setThreadPriority(10);
    this.dvX.a(this.dvY);
    this.dvX.a(this);
    this.dvh = true;
    b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(198118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.c
 * JD-Core Version:    0.7.0.1
 */