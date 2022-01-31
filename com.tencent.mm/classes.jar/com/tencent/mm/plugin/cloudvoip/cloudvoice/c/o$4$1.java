package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$4$1
  implements Runnable
{
  o$4$1(o.4 param4, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(135516);
    if (o.e(this.kLM.kLI) != o.d.kMn)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current not in room");
      o.a(this.kLM.kLI, -1L);
      o.p(this.kLM.kLI);
      AppMethodBeat.o(135516);
      return;
    }
    if (o.q(this.kLM.kLI) != null) {
      o.q(this.kLM.kLI).a(-10087, this.val$errCode, "call end", o.o(this.kLM.kLI));
    }
    o.a(this.kLM.kLI, -1L);
    o.a(this.kLM.kLI, o.d.kMl);
    o.p(this.kLM.kLI);
    AppMethodBeat.o(135516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.4.1
 * JD-Core Version:    0.7.0.1
 */