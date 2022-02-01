package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(148332);
    ae.e("MicroMsg.SceneVoice.Recorder", "start record timeout");
    g.yxI.idkeyStat(357L, 51L, 1L, true);
    if (!h.Qa())
    {
      if (d.FFK) {
        g.yxI.g("Record", "start record timeout", null);
      }
      g.yxI.idkeyStat(357L, 52L, 1L, true);
    }
    h.Qb();
    AppMethodBeat.o(148332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.4
 * JD-Core Version:    0.7.0.1
 */