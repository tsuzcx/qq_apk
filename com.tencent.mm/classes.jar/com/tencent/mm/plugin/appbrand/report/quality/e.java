package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.g.d;
import com.tencent.luggage.game.d.g.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.plugin.appbrand.service.c;

public final class e
{
  Handler handler;
  final e.b iIr;
  QualitySessionRuntime iIs;
  private f iIt;
  
  public e()
  {
    AppMethodBeat.i(132691);
    this.iIr = new e.b(this, (byte)0);
    AppMethodBeat.o(132691);
  }
  
  private static int H(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(132694);
    try
    {
      int i = parami.gPw.atH();
      AppMethodBeat.o(132694);
      return i;
    }
    catch (Exception parami)
    {
      AppMethodBeat.o(132694);
    }
    return 0;
  }
  
  public final void a(QualitySessionRuntime paramQualitySessionRuntime, int paramInt, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(143526);
    this.iIs = paramQualitySessionRuntime;
    if (this.handler == null)
    {
      this.handler = new Handler(Looper.getMainLooper());
      e.b.a(this.iIr, paramInt * 1000);
      e.b.a(this.iIr, parama);
      e.b.a(this.iIr, paramBoolean);
      this.handler.post(this.iIr);
    }
    if (!paramQualitySessionRuntime.bAa)
    {
      this.iIt = new f();
      this.iIt.mInterval = 200L;
      this.iIt.iAO = null;
      this.iIt.start();
    }
    AppMethodBeat.o(143526);
  }
  
  final void a(e.a parama, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool = true;
    label157:
    int i;
    for (;;)
    {
      QualitySessionRuntime localQualitySessionRuntime;
      try
      {
        AppMethodBeat.i(143527);
        if (this.iIs == null)
        {
          AppMethodBeat.o(143527);
          return;
        }
        localQualitySessionRuntime = this.iIs;
        if (localQualitySessionRuntime == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label453;
          }
          AppMethodBeat.o(143527);
          continue;
        }
        localObject2 = localQualitySessionRuntime.htX;
      }
      finally {}
      Object localObject2;
      i.a locala = new i.a();
      Object localObject3;
      if (parama == e.a.iIv)
      {
        localObject3 = com.tencent.luggage.game.d.g.bAQ;
        localObject3 = com.tencent.luggage.game.d.g.uL();
        locala.bAS = ((g.a)localObject3).bAS;
        locala.iJb = (((g.a)localObject3).bAS - localQualitySessionRuntime.iIL);
        locala.bAT = ((g.a)localObject3).bAT;
        locala.bAU = ((g.a)localObject3).bAU;
        locala.iJd = ((int)Math.round(g.iID.iAM.aKr()));
        locala.hsW = H((com.tencent.mm.plugin.appbrand.i)localObject2);
        locala.iJc = ((int)(System.currentTimeMillis() - localQualitySessionRuntime.iII));
        if (localQualitySessionRuntime.bAa) {
          localObject3 = localQualitySessionRuntime.htX;
        }
      }
      else
      {
        try
        {
          localObject2 = ((com.tencent.luggage.game.e.a.a.b)((o)localObject3).atU().x(com.tencent.luggage.game.e.a.a.b.class)).getMBRuntime();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            d.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject3 });
          }
          locala.fps = Math.round(((MBRuntime)localObject1).getInspector().getCurrentFps().bJg);
          locala.iIX = ((MBRuntime)localObject1).getInspector().yk();
          locala.iIZ = ((MBRuntime)localObject1).getInspector().ym();
          locala.iJa = ((MBRuntime)localObject1).getInspector().yn();
          locala.iIY = ((MBRuntime)localObject1).getInspector().yo();
          locala.iIS = localQualitySessionRuntime.iIP.iIS;
          if (!((MBRuntime)localObject1).getParams().use_command_buffer) {
            break label589;
          }
        }
        if (localObject1 == null) {
          d.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
        }
        for (;;)
        {
          localObject1 = new i(locala, (byte)0);
          break;
          locala.bAS = -1;
          locala.iJb = -1;
          locala.bAT = -1;
          locala.bAU = -1;
          locala.iJd = -1;
          break label157;
          i = 1;
          label401:
          locala.iJe = i;
        }
      }
      localObject1 = localQualitySessionRuntime.iIN;
      if (((e)localObject1).iIt == null) {}
      for (i = 0;; i = (int)(((e)localObject1).iIt.iBg + 0.5D))
      {
        locala.fps = i;
        break;
      }
      label453:
      if (!this.iIs.bAa) {
        break label530;
      }
      if (!paramBoolean) {
        break;
      }
      a.aLt();
      b.a(this.iIs.appId, (i)localObject1);
      AppMethodBeat.o(143527);
    }
    localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.iIs, (i)localObject1);
    if (parama == e.a.iIv) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).dV(paramBoolean);
      AppMethodBeat.o(143527);
      break;
      label530:
      a.aLt();
      b.a(this.iIs.appId, (i)localObject1);
      localObject1 = new com.tencent.mm.plugin.appbrand.game.d.b(this.iIs, (i)localObject1);
      if (parama == e.a.iIv) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((com.tencent.mm.plugin.appbrand.game.d.b)localObject1).dV(paramBoolean);
        AppMethodBeat.o(143527);
        break;
      }
      label589:
      i = 0;
      break label401;
    }
  }
  
  /* Error */
  public final boolean aLu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/mm/plugin/appbrand/report/quality/e:iIs	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
      AppMethodBeat.i(132692);
      d.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
      this.iIs = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacks(this.iIr);
        this.handler = null;
      }
      if (this.iIt != null)
      {
        this.iIt.stop();
        this.iIt = null;
      }
      AppMethodBeat.o(132692);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e
 * JD-Core Version:    0.7.0.1
 */