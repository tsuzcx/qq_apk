package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends AppBrandPerformanceManager
{
  public static void E(q paramq)
  {
    AppMethodBeat.i(47986);
    String str = paramq.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)nwB.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof b))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new b(paramq);
      nwB.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
  
  public static enum a
  {
    private volatile HandlerThread mThread;
    
    static
    {
      AppMethodBeat.i(227353);
      nwM = new a("INST");
      nwN = new a[] { nwM };
      AppMethodBeat.o(227353);
    }
    
    private a() {}
    
    public final HandlerThread bSR()
    {
      AppMethodBeat.i(227352);
      if (this.mThread == null) {}
      try
      {
        if (this.mThread == null)
        {
          this.mThread = com.tencent.f.c.d.bqr("MicroMsg.AppBrandPerformanceManager.DumpTraceThread");
          this.mThread.start();
        }
        HandlerThread localHandlerThread = this.mThread;
        AppMethodBeat.o(227352);
        return localHandlerThread;
      }
      finally
      {
        AppMethodBeat.o(227352);
      }
    }
  }
  
  static final class b
    extends AppBrandPerformanceManager.a
  {
    b(q paramq)
    {
      super();
      AppMethodBeat.i(47978);
      this.nwF = paramq.NA();
      AppMethodBeat.o(47978);
    }
    
    private com.tencent.magicbrush.a bSS()
    {
      AppMethodBeat.i(47982);
      try
      {
        localObject1 = (com.tencent.luggage.game.d.a.a.b)com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE().S(com.tencent.luggage.game.d.a.a.b.class);
        if (localObject1 == null) {
          break label48;
        }
        localObject1 = ((com.tencent.luggage.game.d.a.a.b)localObject1).getMagicBrush().cxx.QP();
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
    
    protected final void bSK()
    {
      AppMethodBeat.i(47979);
      super.bSK();
      if (this.nwF)
      {
        Object localObject = h.cvz;
        localObject = h.Md();
        c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", ((h.a)localObject).cvE);
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppBrandPerformanceManager.a(this.cBE, 105, ((h.a)localObject).cvN);
          c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", ((h.a)localObject).cvH);
          c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", ((h.a)localObject).cvI);
          c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", ((h.a)localObject).cvJ);
          c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", ((h.a)localObject).cvK);
          c.a(this.mAppId, "Hardware", "CODE_MEMORY", ((h.a)localObject).cvL);
          c.a(this.mAppId, "Hardware", "STACK_MEMORY", ((h.a)localObject).cvM);
          c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", ((h.a)localObject).cvG);
        }
        c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", ((h.a)localObject).cvF);
      }
      AppMethodBeat.o(47979);
    }
    
    protected final void bSL()
    {
      AppMethodBeat.i(47980);
      if (!this.nwF)
      {
        AppMethodBeat.o(47980);
        return;
      }
      if (this.cBE.isDestroyed())
      {
        AppMethodBeat.o(47980);
        return;
      }
      QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
      if (localQualitySessionRuntime != null) {}
      for (int i = Util.getSelfMemInMB(MMApplicationContext.getContext()) - localQualitySessionRuntime.nLu;; i = 2147483647)
      {
        if (i != 2147483647) {
          AppBrandPerformanceManager.a(this.cBE, 103, i + "m");
        }
        AppMethodBeat.o(47980);
        return;
      }
    }
    
    protected final void bSM()
    {
      AppMethodBeat.i(47981);
      if (!this.nwF)
      {
        AppMethodBeat.o(47981);
        return;
      }
      Object localObject = bSS();
      if (localObject == null)
      {
        AppMethodBeat.o(47981);
        return;
      }
      c.a(this.mAppId, "Game", "FPS_GAME_RT", ((com.tencent.magicbrush.a)localObject).cKu);
      c.a(this.mAppId, "Game", "FPS_GAME_EX", ((com.tencent.magicbrush.a)localObject).cKv);
      try
      {
        localObject = (com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE();
        int i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).bCX().cxx.QR();
        c.a(this.mAppId, "Game", "FPS_GAME_LAG", i);
        i = ((com.tencent.mm.plugin.appbrand.game.c)localObject).bCX().cxx.QS();
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
    
    protected final void bSN()
    {
      AppMethodBeat.i(47983);
      if (!this.nwF)
      {
        AppMethodBeat.o(47983);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QW();
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
    
    protected final void bSO()
    {
      AppMethodBeat.i(47984);
      if (!this.nwF)
      {
        AppMethodBeat.o(47984);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QX();
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
    
    protected final void bSP()
    {
      AppMethodBeat.i(47985);
      if (!this.nwF)
      {
        AppMethodBeat.o(47985);
        return;
      }
      try
      {
        int i = ((com.tencent.mm.plugin.appbrand.game.c)com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QY();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */