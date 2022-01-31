package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$a
  implements Runnable
{
  private com.tencent.mm.audio.b.c nNY = null;
  
  public c$a(c paramc, com.tencent.mm.audio.b.c paramc1)
  {
    this.nNY = paramc1;
  }
  
  public final void run()
  {
    AppMethodBeat.i(21814);
    ab.d("MicroMsg.IPCallRecorder", "do stopRecord");
    if (this.nNY != null)
    {
      this.nNY.Et();
      this.nNY = null;
      c localc = this.nNX;
      localc.nNT = 92;
      localc.nNU = true;
      localc.nNV = 0;
    }
    AppMethodBeat.o(21814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */