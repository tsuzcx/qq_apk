package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

final class b$a
  extends AppBrandPerformanceManager.a
{
  b$a(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(47978);
    this.lhD = paramo.CZ();
    AppMethodBeat.o(47978);
  }
  
  private com.tencent.magicbrush.a bkZ()
  {
    AppMethodBeat.i(47982);
    try
    {
      localObject1 = (b)com.tencent.mm.plugin.appbrand.a.CR(this.mAppId).aNe().Q(b.class);
      if (localObject1 == null) {
        break label48;
      }
      localObject1 = ((b)localObject1).getMagicBrush().cem.FO();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ad.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        Object localObject2 = null;
      }
    }
    AppMethodBeat.o(47982);
    return localObject1;
    label48:
    localObject1 = new com.tencent.luggage.game.d.a.a.c();
    AppMethodBeat.o(47982);
    throw ((Throwable)localObject1);
  }
  
  protected final void bkS()
  {
    AppMethodBeat.i(47979);
    super.bkS();
    if (this.lhD)
    {
      Object localObject = h.ccm;
      localObject = h.BB();
      c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).ccq);
      if (Build.VERSION.SDK_INT >= 23)
      {
        AppBrandPerformanceManager.a(this.chU, 105, ((h.a)localObject).ccz);
        c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).cct);
        c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).ccu);
        c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).ccv);
        c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).ccw);
        c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).ccx);
        c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).ccy);
        c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).ccs);
      }
      c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).ccr);
    }
    AppMethodBeat.o(47979);
  }
  
  protected final void bkT()
  {
    AppMethodBeat.i(47980);
    if (!this.lhD)
    {
      AppMethodBeat.o(47980);
      return;
    }
    if (this.chU.isDestroyed())
    {
      AppMethodBeat.o(47980);
      return;
    }
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
    if (localQualitySessionRuntime != null) {}
    for (int i = bt.iT(aj.getContext()) - localQualitySessionRuntime.ltI;; i = 2147483647)
    {
      if (i != 2147483647) {
        AppBrandPerformanceManager.a(this.chU, 103, i + "m");
      }
      AppMethodBeat.o(47980);
      return;
    }
  }
  
  protected final void bkU()
  {
    AppMethodBeat.i(47981);
    if (!this.lhD)
    {
      AppMethodBeat.o(47981);
      return;
    }
    Object localObject = bkZ();
    if (localObject == null)
    {
      AppMethodBeat.o(47981);
      return;
    }
    c.a(this.mAppId, "Game", "FPS_GAME_RT", ((com.tencent.magicbrush.a)localObject).coh);
    c.a(this.mAppId, "Game", "FPS_GAME_EX", ((com.tencent.magicbrush.a)localObject).coi);
    try
    {
      localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.CR(this.mAppId).aNe();
      int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().cem.FP();
      c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
      i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().cem.FQ();
      c.a(this.mAppId, "Game", "FPS_GAME_LOW", i);
      AppMethodBeat.o(47981);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47981);
    }
  }
  
  protected final void bkV()
  {
    AppMethodBeat.i(47983);
    if (!this.lhD)
    {
      AppMethodBeat.o(47983);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.CR(this.mAppId).aNe()).getMagicBrush().cem.FU();
      c.a(this.mAppId, "Game", "DRAW_CALLS", i);
      AppMethodBeat.o(47983);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47983);
    }
  }
  
  protected final void bkW()
  {
    AppMethodBeat.i(47984);
    if (!this.lhD)
    {
      AppMethodBeat.o(47984);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.CR(this.mAppId).aNe()).getMagicBrush().cem.FV();
      c.a(this.mAppId, "Game", "VERTEXES", i);
      AppMethodBeat.o(47984);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47984);
    }
  }
  
  protected final void bkX()
  {
    AppMethodBeat.i(47985);
    if (!this.lhD)
    {
      AppMethodBeat.o(47985);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.CR(this.mAppId).aNe()).getMagicBrush().cem.FW();
      c.a(this.mAppId, "Game", "TRIANGLES", i);
      AppMethodBeat.o(47985);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b.a
 * JD-Core Version:    0.7.0.1
 */