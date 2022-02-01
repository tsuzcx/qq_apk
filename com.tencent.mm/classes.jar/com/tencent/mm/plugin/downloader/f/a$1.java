package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;

final class a$1
  implements Runnable
{
  a$1(String paramString, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(89073);
    g localg = com.tencent.mm.pluginsdk.model.app.h.cX(this.val$appId, false);
    if ((localg != null) && (localg.NA())) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(860L, this.qJB, this.qJC, false);
    }
    AppMethodBeat.o(89073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a.1
 * JD-Core Version:    0.7.0.1
 */