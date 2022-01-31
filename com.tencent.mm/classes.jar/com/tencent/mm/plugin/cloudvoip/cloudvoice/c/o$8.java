package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$8
  implements Runnable
{
  o$8(o paramo, b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(135524);
    if (o.e(this.kLI) != o.d.kMn)
    {
      ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
      if (this.kLQ != null)
      {
        this.kLQ.a(-10086, -1001, "not in room", "");
        AppMethodBeat.o(135524);
        return;
      }
    }
    o.k(this.kLI).kJN = this.kLR;
    if (this.kLQ != null) {
      this.kLQ.a(0, 0, "ok", "");
    }
    AppMethodBeat.o(135524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.8
 * JD-Core Version:    0.7.0.1
 */