package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$b
  extends AppBrandPerformanceManager.a
{
  b$b(w paramw)
  {
    super(paramw);
    AppMethodBeat.i(47978);
    this.tDD = paramw.aqJ();
    AppMethodBeat.o(47978);
  }
  
  private a cGH()
  {
    AppMethodBeat.i(47982);
    try
    {
      localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.d.Uc(this.mAppId).ccO().aa(com.tencent.luggage.game.d.a.a.b.class);
      if (localObject1 == null) {
        break label48;
      }
      localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().eod.auZ();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        Object localObject2 = null;
      }
    }
    AppMethodBeat.o(47982);
    return localObject1;
    label48:
    localObject1 = new com.tencent.luggage.game.d.a.a.d();
    AppMethodBeat.o(47982);
    throw ((Throwable)localObject1);
  }
  
  protected final void cGA()
  {
    AppMethodBeat.i(47979);
    super.cGA();
    if (this.tDD)
    {
      Object localObject = h.elJ;
      localObject = h.apd();
      c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).elO);
      if (Build.VERSION.SDK_INT >= 23)
      {
        AppBrandPerformanceManager.a(this.etN, 105, ((h.a)localObject).elX);
        c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).elR);
        c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).elS);
        c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).elT);
        c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).elU);
        c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).elV);
        c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).elW);
        c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).elQ);
      }
      c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).elP);
    }
    AppMethodBeat.o(47979);
  }
  
  protected final void cGB()
  {
    AppMethodBeat.i(47980);
    if (!this.tDD)
    {
      AppMethodBeat.o(47980);
      return;
    }
    if (this.etN.qsE.get())
    {
      AppMethodBeat.o(47980);
      return;
    }
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
    if (localQualitySessionRuntime != null) {}
    for (int i = Util.getSelfMemInMB(MMApplicationContext.getContext()) - localQualitySessionRuntime.tSr;; i = 2147483647)
    {
      if (i != 2147483647) {
        AppBrandPerformanceManager.a(this.etN, 103, i + "m");
      }
      AppMethodBeat.o(47980);
      return;
    }
  }
  
  protected final void cGC()
  {
    AppMethodBeat.i(47981);
    if (!this.tDD)
    {
      AppMethodBeat.o(47981);
      return;
    }
    Object localObject = cGH();
    if (localObject == null)
    {
      AppMethodBeat.o(47981);
      return;
    }
    AppBrandPerformanceManager.a(this.etN, 303, Math.round(((a)localObject).eGw) + " fps");
    c.a(this.mAppId, "Game", "FPS_GAME_RT", ((a)localObject).eGw);
    c.a(this.mAppId, "Game", "FPS_GAME_EX", ((a)localObject).eGx);
    c.a(this.mAppId, "Game", "JANK", ((a)localObject).eGy);
    c.a(this.mAppId, "Game", "BIG_JANK", ((a)localObject).eGz);
    c.a(this.mAppId, "Game", "STUTTER", ((a)localObject).eGA);
    try
    {
      localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.Uc(this.mAppId).ccO();
      int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).coI().eod.avb();
      c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
      i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).coI().eod.avc();
      c.a(this.mAppId, "Game", "FPS_GAME_LOW", i);
      AppMethodBeat.o(47981);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47981);
    }
  }
  
  protected final void cGD()
  {
    AppMethodBeat.i(47983);
    if (!this.tDD)
    {
      AppMethodBeat.o(47983);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.Uc(this.mAppId).ccO()).coI().eod.avg();
      c.a(this.mAppId, "Game", "DRAW_CALLS", i);
      AppMethodBeat.o(47983);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47983);
    }
  }
  
  protected final void cGE()
  {
    AppMethodBeat.i(47984);
    if (!this.tDD)
    {
      AppMethodBeat.o(47984);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.Uc(this.mAppId).ccO()).coI().eod.avh();
      c.a(this.mAppId, "Game", "VERTEXES", i);
      AppMethodBeat.o(47984);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47984);
    }
  }
  
  protected final void cGF()
  {
    AppMethodBeat.i(47985);
    if (!this.tDD)
    {
      AppMethodBeat.o(47985);
      return;
    }
    try
    {
      int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.Uc(this.mAppId).ccO()).coI().eod.avi();
      c.a(this.mAppId, "Game", "TRIANGLES", i);
      AppMethodBeat.o(47985);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
      AppMethodBeat.o(47985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b.b
 * JD-Core Version:    0.7.0.1
 */