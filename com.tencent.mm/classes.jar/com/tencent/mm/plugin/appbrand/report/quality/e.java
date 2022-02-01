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
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  Handler handler;
  final b mzu;
  QualitySessionRuntime mzv;
  private f mzw;
  
  public e()
  {
    AppMethodBeat.i(48213);
    this.mzu = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int ak(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.jzy.getStackSize();
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
    this.mzv = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.mzu, paramInt * 1000);
      b.a(this.mzu, parama);
      b.a(this.mzu, paramBoolean);
      this.handler.post(this.mzu);
    }
    this.mzw = new f();
    this.mzw.mInterval = 200L;
    this.mzw.mmk = null;
    this.mzw.start();
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
        if (this.mzv == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.mzv;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label529;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.jFm;
      }
      finally {}
      Object localObject2;
      m.a locala1 = new m.a();
      Object localObject3;
      if (parama == a.mzy)
      {
        localObject3 = h.cjD;
        localObject3 = h.CH();
        locala1.cjG = ((h.a)localObject3).cjG;
        locala1.mAO = (((h.a)localObject3).cjG - localQualitySessionRuntime.mAp);
        locala1.cjH = ((h.a)localObject3).cjH;
        locala1.cjI = ((h.a)localObject3).cjI;
        locala1.mAQ = ((int)Math.round(g.mzG.mmi.bwL()));
        locala1.mAT = ((h.a)localObject3).cjJ;
        locala1.koB = ak((AppBrandRuntime)localObject2);
        locala1.mAP = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.mAj));
        if (localQualitySessionRuntime.ciE) {
          localObject3 = localQualitySessionRuntime.jFm;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((p)localObject3).aXz().Q(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).clC.GX();
          locala1.fps = Math.round(locala.cwp);
          locala1.mAS = Math.round(locala.cwq);
          locala1.mAK = ((MBRuntime)localObject1).clC.Hb();
          locala1.mAM = ((MBRuntime)localObject1).clC.He();
          locala1.mAN = ((MBRuntime)localObject1).clC.Hf();
          locala1.mAL = ((MBRuntime)localObject1).clC.Hg();
          locala1.mAE = localQualitySessionRuntime.mAt.mAE;
          if (!((MBRuntime)localObject1).Hs().use_command_buffer) {
            break label665;
          }
        }
        if (localObject1 == null) {
          ae.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new m(locala1, (byte)0);
          break;
          locala1.cjG = -1;
          locala1.mAO = -1;
          locala1.cjH = -1;
          locala1.cjI = -1;
          locala1.mAQ = -1;
          locala1.mAT = -1;
          break label167;
          com.tencent.magicbrush.a locala;
          i = 1;
          label434:
          locala1.mAR = i;
          locala1.mAU = ((MBRuntime)localObject1).Hs().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).clC.GY();
          locala1.mAV = ((c.a)localObject1).cwQ;
          locala1.mAW = ((c.a)localObject1).cwR;
        }
      }
      localObject1 = localQualitySessionRuntime.mAr;
      if (((e)localObject1).mzw == null) {}
      for (i = 0;; i = (int)(((e)localObject1).mzw.mmA + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label529:
      if (!this.mzv.ciE) {
        break label606;
      }
      if (!paramBoolean) {
        break;
      }
      a.byG();
      b.a(this.mzv.appId, (m)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.mzv, (m)localObject1);
    if (parama == a.mzy) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gg(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label606:
      a.byG();
      b.a(this.mzv.appId, (m)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.mzv, (m)localObject1);
      if (parama == a.mzy) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gg(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label665:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean byI()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/e:mzv	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      ae.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
      this.mzv = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.mzu);
        this.handler = null;
      }
      if (this.mzw != null)
      {
        this.mzw.stop();
        this.mzw = null;
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
      mzx = new a("Light", 0);
      mzy = new a("Full", 1);
      mzz = new a[] { mzx, mzy };
      AppMethodBeat.o(48211);
    }
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    private long dao = 0L;
    private e.a mzA = null;
    private boolean mzB = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (e.this.mzv == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.mzA == null) {
        ae.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      e.this.a(this.mzA, this.mzB);
      e.this.handler.postDelayed(e.this.mzu, this.dao);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */