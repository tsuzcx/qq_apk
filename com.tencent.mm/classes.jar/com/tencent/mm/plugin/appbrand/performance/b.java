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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends AppBrandPerformanceManager
{
  public static void I(o paramo)
  {
    AppMethodBeat.i(47986);
    String str = paramo.mAppId;
    ac.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)lHs.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof a))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new a(paramo);
      lHs.put(str.hashCode(), localObject);
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
      this.lHw = paramo.CC();
      AppMethodBeat.o(47978);
    }
    
    private com.tencent.magicbrush.a brO()
    {
      AppMethodBeat.i(47982);
      try
      {
        localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.a.GU(this.mAppId).aTU().Q(com.tencent.luggage.game.d.a.a.b.class);
        if (localObject1 == null) {
          break label48;
        }
        localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().cbj.Fx();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          ac.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
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
    
    protected final void brH()
    {
      AppMethodBeat.i(47979);
      super.brH();
      if (this.lHw)
      {
        Object localObject = h.bZj;
        localObject = h.Bf();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).bZn);
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppBrandPerformanceManager.a(this.ceP, 105, ((h.a)localObject).bZw);
          c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).bZq);
          c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).bZr);
          c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).bZs);
          c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).bZt);
          c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).bZu);
          c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).bZv);
          c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).bZp);
        }
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).bZo);
      }
      AppMethodBeat.o(47979);
    }
    
    protected final void brI()
    {
      AppMethodBeat.i(47980);
      if (!this.lHw)
      {
        AppMethodBeat.o(47980);
        return;
      }
      if (this.ceP.isDestroyed())
      {
        AppMethodBeat.o(47980);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = bs.je(ai.getContext()) - localQualitySessionRuntime.lVC;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.ceP, 103, i + "m");
        }
        AppMethodBeat.o(47980);
        return;
      }
    }
    
    protected final void brJ()
    {
      AppMethodBeat.i(47981);
      if (!this.lHw)
      {
        AppMethodBeat.o(47981);
        return;
      }
      Object localObject = brO();
      if (localObject == null)
      {
        AppMethodBeat.o(47981);
        return;
      }
      c.a(this.mAppId, "Game", "FPS_GAME_RT", ((com.tencent.magicbrush.a)localObject).clj);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", ((com.tencent.magicbrush.a)localObject).clk);
      try
      {
        localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.GU(this.mAppId).aTU();
        int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().cbj.Fz();
        c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
        i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).getMagicBrush().cbj.FA();
        c.a(this.mAppId, "Game", "FPS_GAME_LOW", i);
        AppMethodBeat.o(47981);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47981);
      }
    }
    
    protected final void brK()
    {
      AppMethodBeat.i(47983);
      if (!this.lHw)
      {
        AppMethodBeat.o(47983);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.GU(this.mAppId).aTU()).getMagicBrush().cbj.FE();
        c.a(this.mAppId, "Game", "DRAW_CALLS", i);
        AppMethodBeat.o(47983);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47983);
      }
    }
    
    protected final void brL()
    {
      AppMethodBeat.i(47984);
      if (!this.lHw)
      {
        AppMethodBeat.o(47984);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.GU(this.mAppId).aTU()).getMagicBrush().cbj.FF();
        c.a(this.mAppId, "Game", "VERTEXES", i);
        AppMethodBeat.o(47984);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47984);
      }
    }
    
    protected final void brM()
    {
      AppMethodBeat.i(47985);
      if (!this.lHw)
      {
        AppMethodBeat.o(47985);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.GU(this.mAppId).aTU()).getMagicBrush().cbj.FG();
        c.a(this.mAppId, "Game", "TRIANGLES", i);
        AppMethodBeat.o(47985);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        AppMethodBeat.o(47985);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */