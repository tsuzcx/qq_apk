package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class o$5$1
  implements Runnable
{
  o$5$1(o.5 param5, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(135520);
    if (o.e(this.kLO.kLI) != o.d.kMn)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: onSpeakerListChanged but not in room!");
      AppMethodBeat.o(135520);
      return;
    }
    if (o.r(this.kLO.kLI) != null) {
      o.r(this.kLO.kLI).a(0, 0, "on talklist change", this.kLN);
    }
    AppMethodBeat.o(135520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.5.1
 * JD-Core Version:    0.7.0.1
 */