package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$7
  implements Runnable
{
  o$7(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(135523);
    if ((o.e(this.kLI) == o.d.kMl) && (!o.a(this.kLI)))
    {
      ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
      o.s(this.kLI);
    }
    AppMethodBeat.o(135523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.7
 * JD-Core Version:    0.7.0.1
 */