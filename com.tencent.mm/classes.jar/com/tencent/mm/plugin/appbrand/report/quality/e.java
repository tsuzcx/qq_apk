package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.game.c.h.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  Handler handler;
  final b lsN;
  QualitySessionRuntime lsO;
  private f lsP;
  
  public e()
  {
    AppMethodBeat.i(48213);
    this.lsN = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int aq(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.iDt.getStackSize();
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
    this.lsO = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.lsN, paramInt * 1000);
      b.a(this.lsN, parama);
      b.a(this.lsN, paramBoolean);
      this.handler.post(this.lsN);
    }
    this.lsP = new f();
    this.lsP.mInterval = 200L;
    this.lsP.lhG = null;
    this.lsP.start();
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
        if (this.lsO == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.lsO;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label525;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.joZ;
      }
      finally {}
      Object localObject2;
      m.a locala1 = new m.a();
      Object localObject3;
      if (parama == e.a.lsR)
      {
        localObject3 = h.ccm;
        localObject3 = h.BB();
        locala1.ccp = ((h.a)localObject3).ccp;
        locala1.lui = (((h.a)localObject3).ccp - localQualitySessionRuntime.ltI);
        locala1.ccq = ((h.a)localObject3).ccq;
        locala1.ccr = ((h.a)localObject3).ccr;
        locala1.luk = ((int)Math.round(g.lsZ.lhE.blb()));
        locala1.lun = ((h.a)localObject3).ccs;
        locala1.jqE = aq((AppBrandRuntime)localObject2);
        locala1.luj = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.ltC));
        if (localQualitySessionRuntime.cbn) {
          localObject3 = localQualitySessionRuntime.joZ;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((o)localObject3).aNe().Q(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).cem.FO();
          locala1.fps = Math.round(locala.coh);
          locala1.lum = Math.round(locala.coi);
          locala1.lue = ((MBRuntime)localObject1).cem.FR();
          locala1.lug = ((MBRuntime)localObject1).cem.FU();
          locala1.luh = ((MBRuntime)localObject1).cem.FV();
          locala1.luf = ((MBRuntime)localObject1).cem.FW();
          locala1.ltY = localQualitySessionRuntime.ltM.ltY;
          if (!((MBRuntime)localObject1).Gg().use_command_buffer) {
            break label661;
          }
        }
        if (localObject1 == null) {
          ad.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new m(locala1, (byte)0);
          break;
          locala1.ccp = -1;
          locala1.lui = -1;
          locala1.ccq = -1;
          locala1.ccr = -1;
          locala1.luk = -1;
          locala1.lun = -1;
          break label167;
          com.tencent.magicbrush.a locala;
          i = 1;
          label434:
          locala1.lul = i;
          locala1.luo = ((MBRuntime)localObject1).Gg().cmd_pool_type;
          locala1.lup = ((MBRuntime)localObject1).cem.FP();
          locala1.luq = ((MBRuntime)localObject1).cem.FQ();
        }
      }
      localObject1 = localQualitySessionRuntime.ltK;
      if (((e)localObject1).lsP == null) {}
      for (i = 0;; i = (int)(((e)localObject1).lsP.lhY + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label525:
      if (!this.lsO.cbn) {
        break label602;
      }
      if (!paramBoolean) {
        break;
      }
      a.bmM();
      b.a(this.lsO.appId, (m)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.lsO, (m)localObject1);
    if (parama == e.a.lsR) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).fH(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label602:
      a.bmM();
      b.a(this.lsO.appId, (m)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.lsO, (m)localObject1);
      if (parama == e.a.lsR) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).fH(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label661:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean bmO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/e:lsO	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      this.lsO = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.lsN);
        this.handler = null;
      }
      if (this.lsP != null)
      {
        this.lsP.stop();
        this.lsP = null;
      }
      AppMethodBeat.o(48215);
      return;
    }
    finally {}
  }
  
  final class b
    implements Runnable
  {
    private long cQF = 0L;
    private e.a lsT = null;
    private boolean lsU = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (e.this.lsO == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.lsT == null) {
        ad.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      e.this.a(this.lsT, this.lsU);
      e.this.handler.postDelayed(e.this.lsN, this.cQF);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */