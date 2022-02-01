package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.1;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  b$2(QualitySessionRuntime paramQualitySessionRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(48185);
    QualitySessionRuntime localQualitySessionRuntime = this.tRn;
    h.a locala = (h.a)d.b("MemoryInspector.getMemoryMB", new h.1(h.elJ));
    if (locala == null) {}
    for (int i = 0;; i = locala.elN)
    {
      localQualitySessionRuntime.tSr = i;
      AppMethodBeat.o(48185);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b.2
 * JD-Core Version:    0.7.0.1
 */