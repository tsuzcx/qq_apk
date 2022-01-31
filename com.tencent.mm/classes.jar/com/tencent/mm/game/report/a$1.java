package com.tencent.mm.game.report;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, long paramLong) {}
  
  public final void run()
  {
    f localf = g.bx(this.val$appId, false);
    if ((localf != null) && (localf.ZH())) {
      h.nFQ.a(860L, this.dCo, this.dCp, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.game.report.a.1
 * JD-Core Version:    0.7.0.1
 */