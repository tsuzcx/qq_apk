package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements Runnable
{
  j$1(j paramj, o paramo, i.c paramc, e.b paramb) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(128955);
    o localo = this.gQq;
    i.c localc = this.gQr;
    e.b localb = this.gQs;
    int i = j;
    if (!localo.mFinished)
    {
      if (!localo.mInitialized) {
        break label59;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        this.gQr.tT();
      }
      AppMethodBeat.o(128955);
      return;
      label59:
      i = j;
      if (e.aLM())
      {
        g localg = g.c(localo.atS());
        i = j;
        if (localg == g.iKS)
        {
          ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, entered, reason[%s], appId[%s]", new Object[] { localb.name(), localo.mAppId });
          QualitySessionRuntime localQualitySessionRuntime = a.EM(localo.mAppId);
          if (localQualitySessionRuntime != null) {
            localQualitySessionRuntime.iIQ = true;
          }
          e.a(localg, new j.a(localb, localo, localc), true, null);
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.1
 * JD-Core Version:    0.7.0.1
 */