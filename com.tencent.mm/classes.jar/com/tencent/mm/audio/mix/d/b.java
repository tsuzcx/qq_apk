package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends i
{
  private j ddi;
  public boolean ddj = false;
  public k ddk;
  
  public b(j paramj, String paramString)
  {
    super(paramString);
    this.ddi = paramj;
  }
  
  public final boolean OD()
  {
    return this.ddk == null;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(136798);
    this.ddk = paramk;
    this.ddN = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.ddj = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.ddj)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.ddi.a(this.ddk);
    this.ddi.a(this);
    this.ddj = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */