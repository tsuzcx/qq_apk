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
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  Handler handler;
  final b qMN;
  QualitySessionRuntime qMO;
  private com.tencent.mm.plugin.appbrand.performance.f qMP;
  
  public f()
  {
    AppMethodBeat.i(48213);
    this.qMN = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int al(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.ntu.getStackSize();
      AppMethodBeat.o(48217);
      return i;
    }
    catch (Exception paramAppBrandRuntime)
    {
      AppMethodBeat.o(48217);
    }
    return 0;
  }
  
  public final void a(QualitySessionRuntime paramQualitySessionRuntime, int paramInt, f.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(48214);
    this.qMO = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.qMN, paramInt * 1000);
      b.a(this.qMN, parama);
      b.a(this.qMN, paramBoolean);
      this.handler.post(this.qMN);
    }
    this.qMP = new com.tencent.mm.plugin.appbrand.performance.f();
    this.qMP.mInterval = 200L;
    this.qMP.qzc = null;
    this.qMP.start();
    AppMethodBeat.o(48214);
  }
  
  final void a(f.a parama, boolean paramBoolean)
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
        if (this.qMO == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.qMO;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label566;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.nAH;
      }
      finally {}
      Object localObject2;
      n.a locala1 = new n.a();
      Object localObject3;
      if (parama == f.a.qMR)
      {
        localObject3 = com.tencent.luggage.game.c.h.ctP;
        localObject3 = com.tencent.luggage.game.c.h.OV();
        locala1.ctT = ((h.a)localObject3).ctT;
        locala1.qOh = (((h.a)localObject3).ctT - localQualitySessionRuntime.qNH);
        locala1.ctU = ((h.a)localObject3).ctU;
        locala1.ctV = ((h.a)localObject3).ctV;
        locala1.qOj = ((int)Math.round(h.qMX.qyJ.cfX()));
        locala1.qOm = ((h.a)localObject3).ctW;
        locala1.onh = al((AppBrandRuntime)localObject2);
        locala1.qOi = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.qNB));
        if (localQualitySessionRuntime.csz) {
          localObject3 = localQualitySessionRuntime.nAH;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((t)localObject3).bDA().R(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).cwf.Uw();
          locala1.fps = Math.round(locala.cLa);
          locala1.qOl = Math.round(locala.cLb);
          locala1.qOd = ((MBRuntime)localObject1).cwf.UA();
          locala1.qOf = ((MBRuntime)localObject1).cwf.UD();
          locala1.qOg = ((MBRuntime)localObject1).cwf.UE();
          locala1.qOe = ((MBRuntime)localObject1).cwf.UF();
          locala1.qNX = localQualitySessionRuntime.qNL.qNX;
          if (!((MBRuntime)localObject1).US().use_command_buffer) {
            break label702;
          }
        }
        if (localObject1 == null) {
          Log.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new n(locala1, (byte)0);
          break;
          locala1.ctT = -1;
          locala1.qOh = -1;
          locala1.ctU = -1;
          locala1.ctV = -1;
          locala1.qOj = -1;
          locala1.qOm = -1;
          break label167;
          a locala;
          i = 1;
          label434:
          locala1.qOk = i;
          locala1.qOn = ((MBRuntime)localObject1).US().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).cwf.Ux();
          locala1.qOo = ((d.a)localObject1).cLH;
          locala1.qOp = ((d.a)localObject1).cLI;
          locala1.cLc = ((d.a)localObject1).cLJ;
          locala1.cLd = ((d.a)localObject1).cLK;
          locala1.qOq = Math.round(((d.a)localObject1).cLe * 10000.0F);
        }
      }
      localObject1 = localQualitySessionRuntime.qNJ;
      if (((f)localObject1).qMP == null) {}
      for (i = 0;; i = (int)(((f)localObject1).qMP.mCurrentFps + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label566:
      if (!this.qMO.csz) {
        break label643;
      }
      if (!paramBoolean) {
        break;
      }
      b.cik();
      c.a(this.qMO.appId, (n)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.qMO, (n)localObject1);
    if (parama == f.a.qMR) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).hU(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label643:
      b.cik();
      c.a(this.qMO.appId, (n)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.qMO, (n)localObject1);
      if (parama == f.a.qMR) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).hU(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label702:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean cim()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/f:qMO	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      this.qMO = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.qMN);
        this.handler = null;
      }
      if (this.qMP != null)
      {
        this.qMP.stop();
        this.qMP = null;
      }
      AppMethodBeat.o(48215);
      return;
    }
    finally {}
  }
  
  final class b
    implements Runnable
  {
    private long fjz = 0L;
    private f.a qMT = null;
    private boolean qMU = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (f.this.qMO == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.qMT == null) {
        Log.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      f.this.a(this.qMT, this.qMU);
      f.this.handler.postDelayed(f.this.qMN, this.fjz);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */