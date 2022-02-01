package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.a;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  Handler handler;
  final b tRx;
  QualitySessionRuntime tRy;
  private f tRz;
  
  public e()
  {
    AppMethodBeat.i(48213);
    this.tRx = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int az(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.qsc.getStackSize();
      AppMethodBeat.o(48217);
      return i;
    }
    catch (Exception paramAppBrandRuntime)
    {
      AppMethodBeat.o(48217);
    }
    return 0;
  }
  
  public final void a(QualitySessionRuntime paramQualitySessionRuntime, int paramInt, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(48214);
    this.tRy = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.tRx, paramInt * 1000);
      b.a(this.tRx, parama);
      b.a(this.tRx, paramBoolean);
      this.handler.post(this.tRx);
    }
    this.tRz = new f();
    this.tRz.mInterval = 200L;
    this.tRz.tDX = null;
    this.tRz.start();
    AppMethodBeat.o(48214);
  }
  
  final void a(e.a parama, boolean paramBoolean)
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
        if (this.tRy == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.tRy;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label566;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.qxC;
      }
      finally {}
      Object localObject2;
      m.a locala1 = new m.a();
      Object localObject3;
      if (parama == e.a.tRB)
      {
        localObject3 = h.elJ;
        localObject3 = h.apd();
        locala1.elN = ((h.a)localObject3).elN;
        locala1.tSR = (((h.a)localObject3).elN - localQualitySessionRuntime.tSr);
        locala1.elO = ((h.a)localObject3).elO;
        locala1.elP = ((h.a)localObject3).elP;
        locala1.tST = ((int)Math.round(g.tRH.tDE.cGJ()));
        locala1.tSW = ((h.a)localObject3).elQ;
        locala1.rqQ = az((AppBrandRuntime)localObject2);
        locala1.tSS = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.tSl));
        if (localQualitySessionRuntime.ekt) {
          localObject3 = localQualitySessionRuntime.qxC;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((w)localObject3).ccO().aa(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).eod.auZ();
          locala1.fps = Math.round(locala.eGw);
          locala1.tSV = Math.round(locala.eGx);
          locala1.tSN = ((MBRuntime)localObject1).eod.avd();
          locala1.tSP = ((MBRuntime)localObject1).eod.avg();
          locala1.tSQ = ((MBRuntime)localObject1).eod.avh();
          locala1.tSO = ((MBRuntime)localObject1).eod.avi();
          locala1.tSH = localQualitySessionRuntime.tSv.tSH;
          if (!((MBRuntime)localObject1).avv().use_command_buffer) {
            break label702;
          }
        }
        if (localObject1 == null) {
          Log.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new m(locala1, (byte)0);
          break;
          locala1.elN = -1;
          locala1.tSR = -1;
          locala1.elO = -1;
          locala1.elP = -1;
          locala1.tST = -1;
          locala1.tSW = -1;
          break label167;
          a locala;
          i = 1;
          label434:
          locala1.tSU = i;
          locala1.tSX = ((MBRuntime)localObject1).avv().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).eod.ava();
          locala1.tSY = ((d.a)localObject1).eHb;
          locala1.tSZ = ((d.a)localObject1).eHc;
          locala1.eGy = ((d.a)localObject1).eHd;
          locala1.eGz = ((d.a)localObject1).eHe;
          locala1.tTa = Math.round(((d.a)localObject1).eGA * 10000.0F);
        }
      }
      localObject1 = localQualitySessionRuntime.tSt;
      if (((e)localObject1).tRz == null) {}
      for (i = 0;; i = (int)(((e)localObject1).tRz.mCurrentFps + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label566:
      if (!this.tRy.ekt) {
        break label643;
      }
      if (!paramBoolean) {
        break;
      }
      b.cJb();
      c.a(this.tRy.appId, (m)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.tRy, (m)localObject1);
    if (parama == e.a.tRB) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).iT(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label643:
      b.cJb();
      c.a(this.tRy.appId, (m)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.tRy, (m)localObject1);
      if (parama == e.a.tRB) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).iT(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label702:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean cJd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/e:tRy	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
    //   0	27	0	this	e
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
      this.tRy = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.tRx);
        this.handler = null;
      }
      if (this.tRz != null)
      {
        this.tRz.stop();
        this.tRz = null;
      }
      AppMethodBeat.o(48215);
      return;
    }
    finally {}
  }
  
  final class b
    implements Runnable
  {
    private long hnM = 0L;
    private e.a tRD = null;
    private boolean tRE = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (e.this.tRy == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.tRD == null) {
        Log.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      e.this.a(this.tRD, this.tRE);
      e.this.handler.postDelayed(e.this.tRx, this.hnM);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */