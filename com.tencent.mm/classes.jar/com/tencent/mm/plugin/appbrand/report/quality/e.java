package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  Handler handler;
  final b mux;
  QualitySessionRuntime muy;
  private f muz;
  
  public e()
  {
    AppMethodBeat.i(48213);
    this.mux = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int ak(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.jwC.getStackSize();
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
    this.muy = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.mux, paramInt * 1000);
      b.a(this.mux, parama);
      b.a(this.mux, paramBoolean);
      this.handler.post(this.mux);
    }
    this.muz = new f();
    this.muz.mInterval = 200L;
    this.muz.mhl = null;
    this.muz.start();
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
        if (this.muy == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.muy;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label529;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.jCo;
      }
      finally {}
      Object localObject2;
      m.a locala1 = new m.a();
      Object localObject3;
      if (parama == e.a.muB)
      {
        localObject3 = h.cjB;
        localObject3 = h.CE();
        locala1.cjE = ((h.a)localObject3).cjE;
        locala1.mvR = (((h.a)localObject3).cjE - localQualitySessionRuntime.mvs);
        locala1.cjF = ((h.a)localObject3).cjF;
        locala1.cjG = ((h.a)localObject3).cjG;
        locala1.mvT = ((int)Math.round(g.muJ.mhj.bvU()));
        locala1.mvW = ((h.a)localObject3).cjH;
        locala1.kll = ak((AppBrandRuntime)localObject2);
        locala1.mvS = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.mvm));
        if (localQualitySessionRuntime.ciC) {
          localObject3 = localQualitySessionRuntime.jCo;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((o)localObject3).aXe().Q(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).clA.GR();
          locala1.fps = Math.round(locala.cvL);
          locala1.mvV = Math.round(locala.cvM);
          locala1.mvN = ((MBRuntime)localObject1).clA.GV();
          locala1.mvP = ((MBRuntime)localObject1).clA.GY();
          locala1.mvQ = ((MBRuntime)localObject1).clA.GZ();
          locala1.mvO = ((MBRuntime)localObject1).clA.Ha();
          locala1.mvH = localQualitySessionRuntime.mvw.mvH;
          if (!((MBRuntime)localObject1).Hm().use_command_buffer) {
            break label665;
          }
        }
        if (localObject1 == null) {
          ad.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new m(locala1, (byte)0);
          break;
          locala1.cjE = -1;
          locala1.mvR = -1;
          locala1.cjF = -1;
          locala1.cjG = -1;
          locala1.mvT = -1;
          locala1.mvW = -1;
          break label167;
          com.tencent.magicbrush.a locala;
          i = 1;
          label434:
          locala1.mvU = i;
          locala1.mvX = ((MBRuntime)localObject1).Hm().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).clA.GS();
          locala1.mvY = ((c.a)localObject1).cwm;
          locala1.mvZ = ((c.a)localObject1).cwn;
        }
      }
      localObject1 = localQualitySessionRuntime.mvu;
      if (((e)localObject1).muz == null) {}
      for (i = 0;; i = (int)(((e)localObject1).muz.mhB + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label529:
      if (!this.muy.ciC) {
        break label606;
      }
      if (!paramBoolean) {
        break;
      }
      a.bxN();
      b.a(this.muy.appId, (m)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.muy, (m)localObject1);
    if (parama == e.a.muB) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gi(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label606:
      a.bxN();
      b.a(this.muy.appId, (m)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.muy, (m)localObject1);
      if (parama == e.a.muB) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gi(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label665:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean bxP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/e:muy	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      ad.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
      this.muy = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.mux);
        this.handler = null;
      }
      if (this.muz != null)
      {
        this.muz.stop();
        this.muz = null;
      }
      AppMethodBeat.o(48215);
      return;
    }
    finally {}
  }
  
  final class b
    implements Runnable
  {
    private long cZq = 0L;
    private e.a muD = null;
    private boolean muE = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (e.this.muy == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.muD == null) {
        ad.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      e.this.a(this.muD, this.muE);
      e.this.handler.postDelayed(e.this.mux, this.cZq);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */