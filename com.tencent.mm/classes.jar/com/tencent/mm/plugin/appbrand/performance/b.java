package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.luggage.game.d.g;
import com.tencent.luggage.game.d.g.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends AppBrandPerformanceManager
{
  public static void p(o paramo)
  {
    AppMethodBeat.i(132500);
    String str = paramo.mAppId;
    ab.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)iAH.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof a))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new a(paramo);
      iAH.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(132500);
  }
  
  static final class a
    extends AppBrandPerformanceManager.a
  {
    a(o paramo)
    {
      super();
      AppMethodBeat.i(132492);
      this.iAL = paramo.vY();
      AppMethodBeat.o(132492);
    }
    
    private a.a aKp()
    {
      AppMethodBeat.i(132496);
      try
      {
        localObject1 = (com.tencent.luggage.game.e.a.a.b)com.tencent.mm.plugin.appbrand.a.xL(this.mAppId).atU().x(com.tencent.luggage.game.e.a.a.b.class);
        if (localObject1 == null) {
          break label45;
        }
        localObject1 = ((com.tencent.luggage.game.e.a.a.b)localObject1).getMBRuntime().getCurrentFps();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
          Object localObject2 = null;
        }
      }
      AppMethodBeat.o(132496);
      return localObject1;
      label45:
      localObject1 = new com.tencent.luggage.game.e.a.a.c();
      AppMethodBeat.o(132496);
      throw ((Throwable)localObject1);
    }
    
    protected final void aKi()
    {
      AppMethodBeat.i(132493);
      super.aKi();
      if (this.iAL)
      {
        Object localObject = g.bAQ;
        localObject = g.uL();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((g.a)localObject).bAT);
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((g.a)localObject).bAU);
      }
      AppMethodBeat.o(132493);
    }
    
    protected final void aKj()
    {
      AppMethodBeat.i(132494);
      if (!this.iAL)
      {
        AppMethodBeat.o(132494);
        return;
      }
      if (this.bEZ.mFinished)
      {
        AppMethodBeat.o(132494);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = bo.hp(ah.getContext()) - localQualitySessionRuntime.iIL;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.bEZ, 103, i + "m");
        }
        AppMethodBeat.o(132494);
        return;
      }
    }
    
    protected final void aKk()
    {
      AppMethodBeat.i(132495);
      if (!this.iAL)
      {
        AppMethodBeat.o(132495);
        return;
      }
      a.a locala = aKp();
      if (locala == null)
      {
        AppMethodBeat.o(132495);
        return;
      }
      c.a(this.mAppId, "Game", "FPS_GAME_RT", locala.bJg);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", locala.bJh);
      AppMethodBeat.o(132495);
    }
    
    protected final void aKl()
    {
      AppMethodBeat.i(132497);
      if (!this.iAL)
      {
        AppMethodBeat.o(132497);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.b)com.tencent.mm.plugin.appbrand.a.xL(this.mAppId).atU()).aAr().getInspector().ym();
        c.a(this.mAppId, "Game", "DRAW_CALLS", i);
        AppMethodBeat.o(132497);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(132497);
      }
    }
    
    protected final void aKm()
    {
      AppMethodBeat.i(132498);
      if (!this.iAL)
      {
        AppMethodBeat.o(132498);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.b)com.tencent.mm.plugin.appbrand.a.xL(this.mAppId).atU()).aAr().getInspector().yn();
        c.a(this.mAppId, "Game", "VERTEXES", i);
        AppMethodBeat.o(132498);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(132498);
      }
    }
    
    protected final void aKn()
    {
      AppMethodBeat.i(132499);
      if (!this.iAL)
      {
        AppMethodBeat.o(132499);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.b)com.tencent.mm.plugin.appbrand.a.xL(this.mAppId).atU()).aAr().getInspector().yo();
        c.a(this.mAppId, "Game", "TRIANGLES", i);
        AppMethodBeat.o(132499);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(132499);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */