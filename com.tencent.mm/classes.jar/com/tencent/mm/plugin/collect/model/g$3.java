package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(40936);
    if ((g.a(this.kNf) != null) && (g.b(this.kNf)) && (g.c(this.kNf) == null))
    {
      ab.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
      h.qsU.idkeyStat(699L, 1L, 1L, false);
    }
    AppMethodBeat.o(40936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.3
 * JD-Core Version:    0.7.0.1
 */