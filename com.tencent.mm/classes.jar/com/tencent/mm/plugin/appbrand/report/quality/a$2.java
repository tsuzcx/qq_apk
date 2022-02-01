package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.1;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements Runnable
{
  a$2(QualitySessionRuntime paramQualitySessionRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(48185);
    QualitySessionRuntime localQualitySessionRuntime = this.lsC;
    h.a locala = (h.a)c.a("MemoryInspector.getMemoryMB", new h.1(h.ccm));
    if (locala == null) {}
    for (int i = 0;; i = locala.ccp)
    {
      localQualitySessionRuntime.ltI = i;
      AppMethodBeat.o(48185);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a.2
 * JD-Core Version:    0.7.0.1
 */