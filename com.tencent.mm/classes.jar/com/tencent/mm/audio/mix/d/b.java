package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends i
{
  private j dek;
  public boolean del = false;
  public k dem;
  
  public b(j paramj, String paramString)
  {
    super(paramString);
    this.dek = paramj;
  }
  
  public final boolean OB()
  {
    return this.dem == null;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(136798);
    this.dem = paramk;
    this.deP = System.currentTimeMillis();
    AppMethodBeat.o(136798);
  }
  
  public final void reset()
  {
    this.del = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136797);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.del)
    {
      AppMethodBeat.o(136797);
      return;
    }
    Process.setThreadPriority(-16);
    this.dek.a(this.dem);
    this.dek.a(this);
    this.del = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(136797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */