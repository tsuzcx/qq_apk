package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.a;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.performance.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  Handler handler;
  final b nKB;
  QualitySessionRuntime nKC;
  private com.tencent.mm.plugin.appbrand.performance.f nKD;
  
  public f()
  {
    AppMethodBeat.i(48213);
    this.nKB = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int al(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.kAl.getStackSize();
      AppMethodBeat.o(48217);
      return i;
    }
    catch (Exception paramAppBrandRuntime)
    {
      AppMethodBeat.o(48217);
    }
    return 0;
  }
  
  public final void a(QualitySessionRuntime paramQualitySessionRuntime, int paramInt, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(48214);
    this.nKC = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.nKB, paramInt * 1000);
      b.a(this.nKB, parama);
      b.a(this.nKB, paramBoolean);
      this.handler.post(this.nKB);
    }
    this.nKD = new com.tencent.mm.plugin.appbrand.performance.f();
    this.nKD.mInterval = 200L;
    this.nKD.nwI = null;
    this.nKD.start();
    AppMethodBeat.o(48214);
  }
  
  final void a(a parama, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool = true;
    label167:
    int i;
    for (;;)
    {
      QualitySessionRuntime localQualitySessionRuntime;
      try
      {
        AppMethodBeat.i(48216);
        if (this.nKC == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.nKC;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label529;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.kGW;
      }
      finally {}
      Object localObject2;
      n.a locala1 = new n.a();
      Object localObject3;
      if (parama == a.nKF)
      {
        localObject3 = com.tencent.luggage.game.c.h.cvz;
        localObject3 = com.tencent.luggage.game.c.h.Md();
        locala1.cvD = ((h.a)localObject3).cvD;
        locala1.nLT = (((h.a)localObject3).cvD - localQualitySessionRuntime.nLu);
        locala1.cvE = ((h.a)localObject3).cvE;
        locala1.cvF = ((h.a)localObject3).cvF;
        locala1.nLV = ((int)Math.round(h.nKL.nwG.bSU()));
        locala1.nLY = ((h.a)localObject3).cvG;
        locala1.lsk = al((AppBrandRuntime)localObject2);
        locala1.nLU = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.nLo));
        if (localQualitySessionRuntime.cuy) {
          localObject3 = localQualitySessionRuntime.kGW;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((q)localObject3).bsE().S(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).cxx.QP();
          locala1.fps = Math.round(locala.cKu);
          locala1.nLX = Math.round(locala.cKv);
          locala1.nLP = ((MBRuntime)localObject1).cxx.QT();
          locala1.nLR = ((MBRuntime)localObject1).cxx.QW();
          locala1.nLS = ((MBRuntime)localObject1).cxx.QX();
          locala1.nLQ = ((MBRuntime)localObject1).cxx.QY();
          locala1.nLJ = localQualitySessionRuntime.nLy.nLJ;
          if (!((MBRuntime)localObject1).Rk().use_command_buffer) {
            break label665;
          }
        }
        if (localObject1 == null) {
          Log.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new n(locala1, (byte)0);
          break;
          locala1.cvD = -1;
          locala1.nLT = -1;
          locala1.cvE = -1;
          locala1.cvF = -1;
          locala1.nLV = -1;
          locala1.nLY = -1;
          break label167;
          a locala;
          i = 1;
          label434:
          locala1.nLW = i;
          locala1.nLZ = ((MBRuntime)localObject1).Rk().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).cxx.QQ();
          locala1.nMa = ((d.a)localObject1).cKY;
          locala1.nMb = ((d.a)localObject1).cKZ;
        }
      }
      localObject1 = localQualitySessionRuntime.nLw;
      if (((f)localObject1).nKD == null) {}
      for (i = 0;; i = (int)(((f)localObject1).nKD.nxa + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label529:
      if (!this.nKC.cuy) {
        break label606;
      }
      if (!paramBoolean) {
        break;
      }
      b.bUZ();
      c.a(this.nKC.appId, (n)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.nKC, (n)localObject1);
    if (parama == a.nKF) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).hd(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label606:
      b.bUZ();
      c.a(this.nKC.appId, (n)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.nKC, (n)localObject1);
      if (parama == a.nKF) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).hd(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label665:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean bVb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/f:nKC	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	f
    //   12	7	1	bool	boolean
    //   6	2	2	localQualitySessionRuntime	QualitySessionRuntime
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final void destroy()
  {
    try
    {
      AppMethodBeat.i(48215);
      Log.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
      this.nKC = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.nKB);
        this.handler = null;
      }
      if (this.nKD != null)
      {
        this.nKD.stop();
        this.nKD = null;
      }
      AppMethodBeat.o(48215);
      return;
    }
    finally {}
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48211);
      nKE = new a("Light", 0);
      nKF = new a("Full", 1);
      nKG = new a[] { nKE, nKF };
      AppMethodBeat.o(48211);
    }
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    private long dqS = 0L;
    private f.a nKH = null;
    private boolean nKI = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (f.this.nKC == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.nKH == null) {
        Log.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      f.this.a(this.nKH, this.nKI);
      f.this.handler.postDelayed(f.this.nKB, this.dqS);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */