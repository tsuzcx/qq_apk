package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends AppBrandPerformanceManager
{
  public static void z(o paramo)
  {
    AppMethodBeat.i(47986);
    String str = paramo.mAppId;
    ad.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)mhe.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof a))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new a(paramo);
      mhe.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
  
  static final class a
    extends AppBrandPerformanceManager.a
  {
    a(o paramo)
    {
      super();
      AppMethodBeat.i(47978);
      this.mhi = paramo.Eb();
      AppMethodBeat.o(47978);
    }
    
    private com.tencent.magicbrush.a bvS()
    {
      AppMethodBeat.i(47982);
      try
      {
        localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.a.Kj(this.mAppId).aXe().Q(com.tencent.luggage.game.d.a.a.b.class);
        if (localObject1 == null) {
          break label48;
        }
        localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().clA.GR();
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
    
    protected final void bvL()
    {
      AppMethodBeat.i(47979);
      super.bvL();
      if (this.mhi)
      {
        Object localObject = h.cjB;
        localObject = h.CE();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).cjF);
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppBrandPerformanceManager.a(this.cpg, 105, ((h.a)localObject).cjO);
          c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).cjI);
          c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).cjJ);
          c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).cjK);
          c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).cjL);
          c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).cjM);
          c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).cjN);
          c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).cjH);
        }
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).cjG);
      }
      AppMethodBeat.o(47979);
    }
    
    protected final void bvM()
    {
      AppMethodBeat.i(47980);
      if (!this.mhi)
      {
        AppMethodBeat.o(47980);
        return;
      }
      if (this.cpg.isDestroyed())
      {
        AppMethodBeat.o(47980);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = bt.jo(aj.getContext()) - localQualitySessionRuntime.mvs;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.cpg, 103, i + "m");
        }
        AppMethodBeat.o(47980);
        return;
      }
    }
    
    protected final void bvN()
    {
      AppMethodBeat.i(47981);
      if (!this.mhi)
      {
        AppMethodBeat.o(47981);
        return;
      }
      Object localObject = bvS();
      if (localObject == null)
      {
        AppMethodBeat.o(47981);
        return;
      }
      c.a(this.mAppId, "Game", "FPS_GAME_RT", ((com.tencent.magicbrush.a)localObject).cvL);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", ((com.tencent.magicbrush.a)localObject).cvM);
      try
      {
        localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.Kj(this.mAppId).aXe();
        int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().clA.GT();
        c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
        i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().clA.GU();
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
    
    protected final void bvO()
    {
      AppMethodBeat.i(47983);
      if (!this.mhi)
      {
        AppMethodBeat.o(47983);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.Kj(this.mAppId).aXe()).getMagicBrush().clA.GY();
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
    
    protected final void bvP()
    {
      AppMethodBeat.i(47984);
      if (!this.mhi)
      {
        AppMethodBeat.o(47984);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.Kj(this.mAppId).aXe()).getMagicBrush().clA.GZ();
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
    
    protected final void bvQ()
    {
      AppMethodBeat.i(47985);
      if (!this.mhi)
      {
        AppMethodBeat.o(47985);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.Kj(this.mAppId).aXe()).getMagicBrush().clA.Ha();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */