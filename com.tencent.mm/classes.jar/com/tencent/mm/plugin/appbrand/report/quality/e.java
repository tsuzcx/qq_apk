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
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  Handler handler;
  final b lUH;
  QualitySessionRuntime lUI;
  private f lUJ;
  
  public e()
  {
    AppMethodBeat.i(48213);
    this.lUH = new b((byte)0);
    AppMethodBeat.o(48213);
  }
  
  private static int aq(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48217);
    try
    {
      int i = paramAppBrandRuntime.jdt.getStackSize();
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
    this.lUI = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      b.a(this.lUH, paramInt * 1000);
      b.a(this.lUH, parama);
      b.a(this.lUH, paramBoolean);
      this.handler.post(this.lUH);
    }
    this.lUJ = new f();
    this.lUJ.mInterval = 200L;
    this.lUJ.lHz = null;
    this.lUJ.start();
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
        if (this.lUI == null)
        {
          AppMethodBeat.o(48216);
          return;
        }
        localQualitySessionRuntime = this.lUI;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label529;
          }
          AppMethodBeat.o(48216);
          continue;
        }
        localObject2 = localQualitySessionRuntime.jPl;
      }
      finally {}
      Object localObject2;
      m.a locala1 = new m.a();
      Object localObject3;
      if (parama == a.lUL)
      {
        localObject3 = h.bZj;
        localObject3 = h.Bf();
        locala1.bZm = ((h.a)localObject3).bZm;
        locala1.lWc = (((h.a)localObject3).bZm - localQualitySessionRuntime.lVC);
        locala1.bZn = ((h.a)localObject3).bZn;
        locala1.bZo = ((h.a)localObject3).bZo;
        locala1.lWe = ((int)Math.round(g.lUT.lHx.brQ()));
        locala1.lWh = ((h.a)localObject3).bZp;
        locala1.jQW = aq((AppBrandRuntime)localObject2);
        locala1.lWd = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.lVw));
        if (localQualitySessionRuntime.bYk) {
          localObject3 = localQualitySessionRuntime.jPl;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.d.a.a.b)((o)localObject3).aTU().Q(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala = ((MBRuntime)localObject1).cbj.Fx();
          locala1.fps = Math.round(locala.clj);
          locala1.lWg = Math.round(locala.clk);
          locala1.lVY = ((MBRuntime)localObject1).cbj.FB();
          locala1.lWa = ((MBRuntime)localObject1).cbj.FE();
          locala1.lWb = ((MBRuntime)localObject1).cbj.FF();
          locala1.lVZ = ((MBRuntime)localObject1).cbj.FG();
          locala1.lVS = localQualitySessionRuntime.lVG.lVS;
          if (!((MBRuntime)localObject1).FS().use_command_buffer) {
            break label665;
          }
        }
        if (localObject1 == null) {
          ac.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new m(locala1, (byte)0);
          break;
          locala1.bZm = -1;
          locala1.lWc = -1;
          locala1.bZn = -1;
          locala1.bZo = -1;
          locala1.lWe = -1;
          locala1.lWh = -1;
          break label167;
          com.tencent.magicbrush.a locala;
          i = 1;
          label434:
          locala1.lWf = i;
          locala1.lWi = ((MBRuntime)localObject1).FS().cmd_pool_type;
          localObject1 = ((MBRuntime)localObject1).cbj.Fy();
          locala1.lWj = ((c.a)localObject1).clK;
          locala1.lWk = ((c.a)localObject1).clL;
        }
      }
      localObject1 = localQualitySessionRuntime.lVE;
      if (((e)localObject1).lUJ == null) {}
      for (i = 0;; i = (int)(((e)localObject1).lUJ.lHQ + 0.5D))
      {
        locala1.fps = i;
        break;
      }
      label529:
      if (!this.lUI.bYk) {
        break label606;
      }
      if (!paramBoolean) {
        break;
      }
      a.btI();
      b.a(this.lUI.appId, (m)localObject1);
      AppMethodBeat.o(48216);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.lUI, (m)localObject1);
    if (parama == a.lUL) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gd(paramBoolean);
      AppMethodBeat.o(48216);
      break;
      label606:
      a.btI();
      b.a(this.lUI.appId, (m)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.lUI, (m)localObject1);
      if (parama == a.lUL) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).gd(paramBoolean);
        AppMethodBeat.o(48216);
        break;
      }
      label665:
      i = 0;
      break label434;
    }
  }
  
  /* Error */
  public final boolean btK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mm/plugin/appbrand/report/quality/e:lUI	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      ac.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
      this.lUI = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.lUH);
        this.handler = null;
      }
      if (this.lUJ != null)
      {
        this.lUJ.stop();
        this.lUJ = null;
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
      lUK = new a("Light", 0);
      lUL = new a("Full", 1);
      lUM = new a[] { lUK, lUL };
      AppMethodBeat.o(48211);
    }
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    private long cOa = 0L;
    private e.a lUN = null;
    private boolean lUO = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48212);
      if (e.this.lUI == null)
      {
        AppMethodBeat.o(48212);
        return;
      }
      if (this.lUN == null) {
        ac.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
      }
      e.this.a(this.lUN, this.lUO);
      e.this.handler.postDelayed(e.this.lUH, this.cOa);
      AppMethodBeat.o(48212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */