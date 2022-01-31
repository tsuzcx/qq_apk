package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$6
  implements Runnable
{
  o$6(o paramo, o.a parama, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135522);
    int i = o.a(this.kLI, this.kLP);
    if (i == -9999)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
      o.b(this.kLI, this.kLQ);
      AppMethodBeat.o(135522);
      return;
    }
    if (this.kLQ != null)
    {
      if (i == 0)
      {
        this.kLQ.a(0, 0, "", "");
        AppMethodBeat.o(135522);
        return;
      }
      this.kLQ.a(-10086, -17, "exit failed", "");
    }
    AppMethodBeat.o(135522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.6
 * JD-Core Version:    0.7.0.1
 */