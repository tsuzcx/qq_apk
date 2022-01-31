package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class o$9
  implements Runnable
{
  o$9(o paramo, b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(135525);
    if (o.e(this.kLI) != o.d.kMn)
    {
      ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
      if (this.kLQ != null)
      {
        this.kLQ.a(-10086, -1001, "not in room", "");
        AppMethodBeat.o(135525);
        return;
      }
    }
    e locale = o.k(this.kLI);
    boolean bool = this.kLR;
    int i;
    if (locale.kJB != null)
    {
      locale.kJB.bB(bool);
      i = 1;
    }
    while (this.kLQ != null) {
      if (i != 0)
      {
        this.kLQ.a(0, 0, "ok", "");
        AppMethodBeat.o(135525);
        return;
        i = 0;
      }
      else
      {
        this.kLQ.a(-10086, -15, "set mute failed", "");
      }
    }
    AppMethodBeat.o(135525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.9
 * JD-Core Version:    0.7.0.1
 */