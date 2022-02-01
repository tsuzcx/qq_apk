package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  extends AppBrandPerformanceManager
{
  public static void F(t paramt)
  {
    AppMethodBeat.i(47986);
    String str = paramt.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)qyE.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof b))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new b(paramt);
      qyE.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
  
  static final class b
    extends AppBrandPerformanceManager.a
  {
    b(t paramt)
    {
      super();
      AppMethodBeat.i(47978);
      this.qyI = paramt.Qv();
      AppMethodBeat.o(47978);
    }
    
    private a cfV()
    {
      AppMethodBeat.i(47982);
      try
      {
        localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.d.abA(this.mAppId).bDA().R(com.tencent.luggage.game.d.a.a.b.class);
        if (localObject1 == null) {
          break label48;
        }
        localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().cwf.Uw();
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
    
    protected final void cfN()
    {
      AppMethodBeat.i(47979);
      super.cfN();
      if (this.qyI)
      {
        Object localObject = h.ctP;
        localObject = h.OV();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).ctU);
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppBrandPerformanceManager.a(this.cBh, 105, ((h.a)localObject).cud);
          c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).ctX);
          c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).ctY);
          c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).ctZ);
          c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).cua);
          c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).cub);
          c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).cuc);
          c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).ctW);
        }
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).ctV);
      }
      AppMethodBeat.o(47979);
    }
    
    protected final void cfO()
    {
      AppMethodBeat.i(47980);
      if (!this.qyI)
      {
        AppMethodBeat.o(47980);
        return;
      }
      if (this.cBh.ntU.get())
      {
        AppMethodBeat.o(47980);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = Util.getSelfMemInMB(MMApplicationContext.getContext()) - localQualitySessionRuntime.qNH;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.cBh, 103, i + "m");
        }
        AppMethodBeat.o(47980);
        return;
      }
    }
    
    protected final void cfP()
    {
      AppMethodBeat.i(47981);
      if (!this.qyI)
      {
        AppMethodBeat.o(47981);
        return;
      }
      Object localObject = cfV();
      if (localObject == null)
      {
        AppMethodBeat.o(47981);
        return;
      }
      AppBrandPerformanceManager.a(this.cBh, 303, Math.round(((a)localObject).cLa) + " fps");
      c.a(this.mAppId, "Game", "FPS_GAME_RT", ((a)localObject).cLa);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", ((a)localObject).cLb);
      c.a(this.mAppId, "Game", "JANK", ((a)localObject).cLc);
      c.a(this.mAppId, "Game", "BIG_JANK", ((a)localObject).cLd);
      c.a(this.mAppId, "Game", "STUTTER", ((a)localObject).cLe);
      try
      {
        localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.abA(this.mAppId).bDA();
        int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).bOs().cwf.Uy();
        c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
        i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).bOs().cwf.Uz();
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
    
    protected final void cfQ()
    {
      AppMethodBeat.i(47983);
      if (!this.qyI)
      {
        AppMethodBeat.o(47983);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.abA(this.mAppId).bDA()).bOs().cwf.UD();
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
    
    protected final void cfR()
    {
      AppMethodBeat.i(47984);
      if (!this.qyI)
      {
        AppMethodBeat.o(47984);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.abA(this.mAppId).bDA()).bOs().cwf.UE();
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
    
    protected final void cfS()
    {
      AppMethodBeat.i(47985);
      if (!this.qyI)
      {
        AppMethodBeat.o(47985);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.d.abA(this.mAppId).bDA()).bOs().cwf.UF();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */