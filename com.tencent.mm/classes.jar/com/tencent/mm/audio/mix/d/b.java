package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends i
{
  public k cfA;
  private j cfy;
  public boolean cfz = false;
  
  public b(j paramj, String paramString)
  {
    super(paramString);
    this.cfy = paramj;
  }
  
  public final boolean Dn()
  {
    return this.cfA == null;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(137050);
    this.cfA = paramk;
    this.cgd = System.currentTimeMillis();
    AppMethodBeat.o(137050);
  }
  
  public final void reset()
  {
    this.cfz = false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(137049);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.name });
    if (this.cfz)
    {
      AppMethodBeat.o(137049);
      return;
    }
    Process.setThreadPriority(-16);
    this.cfy.a(this.cfA);
    this.cfy.a(this);
    this.cfz = true;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.name });
    AppMethodBeat.o(137049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */