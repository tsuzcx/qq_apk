package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class a$1
  implements Runnable
{
  a$1(String paramString, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(141090);
    f localf = g.bZ(this.val$appId, false);
    if ((localf != null) && (localf.vY())) {
      h.qsU.idkeyStat(860L, this.kZs, this.kZt, false);
    }
    AppMethodBeat.o(141090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a.1
 * JD-Core Version:    0.7.0.1
 */