package com.tencent.mm.plugin.appbrand.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.task.e;

final class a$1
  implements p.a
{
  a$1(a parama, boolean paramBoolean, String paramString) {}
  
  public final void onInitialized()
  {
    AppMethodBeat.i(45048);
    com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
    if (this.kko) {}
    for (e locale = e.myh;; locale = null)
    {
      b.a(locale, this.val$appId, a.a(this.kkp), d.mqM);
      AppMethodBeat.o(45048);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.1
 * JD-Core Version:    0.7.0.1
 */