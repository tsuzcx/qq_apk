package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Debug.MemoryInfo;
import android.os.Handler;
import com.tencent.mm.h.b.a.al;
import com.tencent.mm.h.b.a.al.a;
import com.tencent.mm.h.b.a.al.b;
import com.tencent.mm.plugin.appbrand.game.a.a;
import com.tencent.mm.plugin.appbrand.game.c.e.a;
import com.tencent.mm.plugin.appbrand.game.j;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.performance.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;
import java.util.List;

public final class c
{
  final c.a gZY = new c.a(this, (byte)0);
  QualitySessionRuntime gZZ;
  d haa;
  Handler handler;
  
  private static int v(i parami)
  {
    try
    {
      int i = parami.fyl.ZW();
      return i;
    }
    catch (Exception parami) {}
    return 0;
  }
  
  /* Error */
  public final boolean aow()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/mm/plugin/appbrand/report/quality/c:gZZ	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
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
    //   0	27	0	this	c
    //   12	7	1	bool	boolean
    //   6	2	2	localQualitySessionRuntime	QualitySessionRuntime
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  final void wn()
  {
    for (;;)
    {
      Object localObject7;
      label187:
      label369:
      int j;
      try
      {
        Object localObject2 = this.gZZ;
        if (localObject2 == null) {
          return;
        }
        localObject7 = this.gZZ;
        if (localObject7 == null)
        {
          localObject2 = null;
          if (localObject2 == null) {
            continue;
          }
          a.aov();
          localObject6 = a.wg(this.gZZ.appId);
          if (localObject6 != null)
          {
            localObject7 = new al();
            ((al)localObject7).ckG = ((QualitySessionRuntime)localObject6).appId;
            ((al)localObject7).ckF = ((QualitySessionRuntime)localObject6).gKi;
            ((al)localObject7).cmP = al.a.eM(((QualitySessionRuntime)localObject6).ham);
            ((al)localObject7).cmQ = al.b.eN(((QualitySessionRuntime)localObject6).apptype);
            ((al)localObject7).ckH = ((QualitySessionRuntime)localObject6).han;
            ((al)localObject7).cic = ((QualitySessionRuntime)localObject6).scene;
            ((al)localObject7).uZ();
            ((al)localObject7).va();
            ((al)localObject7).uY();
            ((al)localObject7).cmR = ((g)localObject2).fps;
            ((al)localObject7).cmS = ((g)localObject2).haw;
            if (((g)localObject2).fZD != a.a.fZE) {
              break label1985;
            }
            i = 1;
            ((al)localObject7).cna = i;
            ((al)localObject7).cnb = ((g)localObject2).hax;
            ((al)localObject7).cnc = ((g)localObject2).hay;
            ((al)localObject7).cnd = ((g)localObject2).haz;
            ((al)localObject7).cmW = ((g)localObject2).haj;
            ((al)localObject7).cmX = ((g)localObject2).hak;
            ((al)localObject7).cmU = ((g)localObject2).hai;
            ((al)localObject7).cmV = ((g)localObject2).haA;
            ((al)localObject7).cmY = (((g)localObject2).haB / 1000);
            ((al)localObject7).cmZ = ((g)localObject2).gbv;
            ((al)localObject7).cmT = ((g)localObject2).haC;
            ((al)localObject7).QX();
          }
          if (!this.gZZ.gJp) {
            continue;
          }
          localObject2 = new com.tencent.mm.plugin.appbrand.game.c.e(this.gZZ, (g)localObject2);
          if (((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw == null) {
            continue;
          }
          localObject6 = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw;
          if (((g)localObject6).fZD != a.a.fZE) {
            break label2002;
          }
          i = 1;
          ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu = i;
          ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.gbv;
          if (((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw != null)
          {
            i = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haB;
            j = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haC;
            h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gby.gbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
            y.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu) });
          }
          if (((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw != null)
          {
            i = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haB;
            j = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.hai;
            int k = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haj;
            int m = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.hak;
            int n = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haA;
            h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbz.gbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
            h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbD.gbI), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
            h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbE.gbI), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
            h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbG.gbI), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
            y.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu) });
          }
          if (((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw == null) {
            continue;
          }
          i = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haB;
          j = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.fps;
          h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbx.gbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
          y.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu) });
          j = ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbw.haw;
          if (j == -1) {
            break label2019;
          }
          h.nFQ.f(14959, new Object[] { ((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).cau), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).bFu), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu), Integer.valueOf(e.a.gbH.gbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv) });
          y.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(e.a.gbH.gbI), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbv), Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.c.e)localObject2).gbu) });
          continue;
        }
        localObject4 = ((QualitySessionRuntime)localObject7).gaS;
      }
      finally {}
      Object localObject4;
      Object localObject6 = new g.a();
      Object localObject8 = f.hag;
      localObject8 = new f.a();
      Debug.MemoryInfo localMemoryInfo = f.aoy();
      if (localMemoryInfo == null) {}
      for (;;)
      {
        for (;;)
        {
          ((g.a)localObject6).hai = ((f.a)localObject8).hai;
          ((g.a)localObject6).haA = (((f.a)localObject8).hai - ((QualitySessionRuntime)localObject7).has);
          ((g.a)localObject6).haj = ((f.a)localObject8).haj;
          ((g.a)localObject6).hak = ((f.a)localObject8).hak;
          ((g.a)localObject6).gbv = v((i)localObject4);
          ((g.a)localObject6).haB = ((int)(System.currentTimeMillis() - ((QualitySessionRuntime)localObject7).hap));
          ((g.a)localObject6).haC = ((int)Math.round(e.hae.gWg.anI()));
          if (!((n)localObject4).ZH()) {
            break label1939;
          }
          localObject8 = ((QualitySessionRuntime)localObject7).gaS;
          try
          {
            localObject4 = ((n)localObject8).aad().getCurrentPage().getCurrentPageView();
            if (!(localObject4 instanceof com.tencent.mm.plugin.appbrand.game.page.f)) {
              break label2031;
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.game.page.f)localObject4).gcy.getMBRenderer();
            label1621:
            if ((localObject4 != null) && (((com.tencent.mm.plugin.appbrand.game.a)localObject4).fZC != null)) {
              break label1742;
            }
            com.tencent.luggage.j.c.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
            label1643:
            localObject4 = new g((g.a)localObject6, (byte)0);
          }
          catch (Exception localException)
          {
            com.tencent.luggage.j.c.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", localException, "get QualityEvent of WAGame but fail. [%s]", new Object[] { localObject8 });
            break label2031;
          }
        }
        ((f.a)localObject8).hai = (localMemoryInfo.getTotalPss() / 1024);
        ((f.a)localObject8).haj = (localMemoryInfo.nativePss / 1024);
        ((f.a)localObject8).hak = (localMemoryInfo.dalvikPss / 1024);
        ((f.a)localObject8).hal = (localMemoryInfo.otherPss / 1024);
      }
      label1742:
      ((g.a)localObject6).fps = ((int)(localException.fZC.gbN + 0.5D));
      Object localObject5 = localException.fZC;
      if (((com.tencent.mm.plugin.appbrand.game.c.f)localObject5).gbP != null) {
        if (((com.tencent.mm.plugin.appbrand.game.c.f)localObject5).gbP.size() <= 0) {
          break label2037;
        }
      }
      for (;;)
      {
        Object localObject1;
        ((g.a)localObject6).haw = ((int)(localObject1 + 0.5D));
        ((g.a)localObject6).fZD = ((QualitySessionRuntime)localObject7).hav.fZD;
        break label1643;
        i = ((com.tencent.mm.plugin.appbrand.game.c.f)localObject5).gbP.size();
        localObject8 = (Double[])Arrays.copyOf(((com.tencent.mm.plugin.appbrand.game.c.f)localObject5).gbP.toArray(new Double[0]), i);
        ((com.tencent.mm.plugin.appbrand.game.c.f)localObject5).gbP.clear();
        if ((localObject8 != null) && (localObject8.length > 0))
        {
          double d2 = com.tencent.mm.plugin.appbrand.game.c.g.a((Double[])localObject8);
          d1 = 0.0D;
          j = localObject8.length;
          i = 0;
          while (i < j)
          {
            double d3 = localObject8[i].doubleValue() - d2;
            d1 += d3 * d3;
            i += 1;
          }
          d1 /= j;
          continue;
          label1939:
          localObject5 = ((QualitySessionRuntime)localObject7).hau;
          if (((c)localObject5).haa == null) {}
          for (i = 0;; i = (int)(((c)localObject5).haa.gWz + 0.5D))
          {
            ((g.a)localObject6).fps = i;
            break;
          }
          label1985:
          if (((g)localObject5).fZD != a.a.fZF) {
            break label2051;
          }
          i = 2;
          break label187;
          label2002:
          if (((g)localObject6).fZD != a.a.fZF) {
            break label2057;
          }
          i = 2;
          break label369;
          label2019:
          y.e("MicroMsg.Kv_14959", "variance == -1!");
          break;
          label2031:
          localObject5 = null;
          break label1621;
          label2037:
          d1 = -1.0D;
          continue;
        }
        double d1 = -1.0D;
      }
      label2051:
      int i = 0;
      continue;
      label2057:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */