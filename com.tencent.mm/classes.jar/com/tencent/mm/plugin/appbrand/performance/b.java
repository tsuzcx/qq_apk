package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.luggage.sdk.d.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends AppBrandPerformanceManager
{
  public static void A(p paramp)
  {
    AppMethodBeat.i(47986);
    String str = paramp.mAppId;
    ae.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)mmd.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof a))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new a(paramp);
      mmd.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
  
  static final class a
    extends AppBrandPerformanceManager.a
  {
    a(p paramp)
    {
      super();
      AppMethodBeat.i(47978);
      this.mmh = paramp.Ee();
      AppMethodBeat.o(47978);
    }
    
    private com.tencent.magicbrush.a bwJ()
    {
      AppMethodBeat.i(47982);
      try
      {
        localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.a.KI(this.mAppId).aXz().Q(com.tencent.luggage.game.d.a.a.b.class);
        if (localObject1 == null) {
          break label48;
        }
        localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().clC.GX();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          ae.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
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
    
    protected final void bwC()
    {
      AppMethodBeat.i(47979);
      super.bwC();
      if (this.mmh)
      {
        Object localObject = h.cjD;
        localObject = h.CH();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).cjH);
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppBrandPerformanceManager.a(this.cpk, 105, ((h.a)localObject).cjQ);
          c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).cjK);
          c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).cjL);
          c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).cjM);
          c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).cjN);
          c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).cjO);
          c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).cjP);
          c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).cjJ);
        }
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).cjI);
      }
      AppMethodBeat.o(47979);
    }
    
    protected final void bwD()
    {
      AppMethodBeat.i(47980);
      if (!this.mmh)
      {
        AppMethodBeat.o(47980);
        return;
      }
      if (this.cpk.isDestroyed())
      {
        AppMethodBeat.o(47980);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = bu.ju(ak.getContext()) - localQualitySessionRuntime.mAp;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.cpk, 103, i + "m");
        }
        AppMethodBeat.o(47980);
        return;
      }
    }
    
    protected final void bwE()
    {
      AppMethodBeat.i(47981);
      if (!this.mmh)
      {
        AppMethodBeat.o(47981);
        return;
      }
      Object localObject = bwJ();
      if (localObject == null)
      {
        AppMethodBeat.o(47981);
        return;
      }
      c.a(this.mAppId, "Game", "FPS_GAME_RT", ((com.tencent.magicbrush.a)localObject).cwp);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", ((com.tencent.magicbrush.a)localObject).cwq);
      try
      {
        localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.KI(this.mAppId).aXz();
        int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().clC.GZ();
        c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
        i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().clC.Ha();
        c.a(this.mAppId, "Game", "FPS_GAME_LOW", i);
        AppMethodBeat.o(47981);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47981);
      }
    }
    
    protected final void bwF()
    {
      AppMethodBeat.i(47983);
      if (!this.mmh)
      {
        AppMethodBeat.o(47983);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.KI(this.mAppId).aXz()).getMagicBrush().clC.He();
        c.a(this.mAppId, "Game", "DRAW_CALLS", i);
        AppMethodBeat.o(47983);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47983);
      }
    }
    
    protected final void bwG()
    {
      AppMethodBeat.i(47984);
      if (!this.mmh)
      {
        AppMethodBeat.o(47984);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.KI(this.mAppId).aXz()).getMagicBrush().clC.Hf();
        c.a(this.mAppId, "Game", "VERTEXES", i);
        AppMethodBeat.o(47984);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47984);
      }
    }
    
    protected final void bwH()
    {
      AppMethodBeat.i(47985);
      if (!this.mmh)
      {
        AppMethodBeat.o(47985);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.KI(this.mAppId).aXz()).getMagicBrush().clC.Hg();
        c.a(this.mAppId, "Game", "TRIANGLES", i);
        AppMethodBeat.o(47985);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47985);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */