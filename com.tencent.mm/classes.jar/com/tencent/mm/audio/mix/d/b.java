package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends j
{
  private k dvg;
  public boolean dvh = false;
  public l dvi;
  
  public b(k paramk, String paramString)
  {
    super(paramString);
    this.dvg = paramk;
  }
  
  public final boolean YT()
  {
    return this.dvi == null;
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(136798);
    this.dvi = paraml;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.dvh = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.dvh)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.dvg.a(this.dvi);
    this.dvg.a(this);
    this.dvh = true;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */