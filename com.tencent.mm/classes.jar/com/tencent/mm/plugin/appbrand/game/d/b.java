package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  private int aDD;
  private String appId;
  private int dli;
  private int koA;
  private int koB;
  m koC;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, m paramm)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.dli = paramQualitySessionRuntime.myD;
    this.aDD = paramQualitySessionRuntime.mAf;
    this.koC = paramm;
  }
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    ae.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.koC == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    m localm = this.koC;
    int i;
    if (localm.mAE == l.a.mAG) {
      i = 1;
    }
    for (;;)
    {
      this.koA = i;
      this.koB = this.koC.koB;
      if (paramBoolean)
      {
        if (this.koC != null)
        {
          i = this.koC.mAP;
          j = this.koC.mAQ;
          g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koE.duP), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB) });
          ae.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB), Integer.valueOf(this.koA) });
        }
        if (this.koC != null)
        {
          i = this.koC.mAP;
          j = this.koC.cjG;
          int k = this.koC.cjH;
          int m = this.koC.cjI;
          int n = this.koC.mAO;
          g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koF.duP), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB) });
          g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koJ.duP), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.koB) });
          g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koK.duP), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.koB) });
          g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koM.duP), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.koB) });
          ae.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.koB), Integer.valueOf(this.koA) });
        }
      }
      if (this.koC == null) {
        break label1063;
      }
      i = this.koC.mAP;
      int j = this.koC.fps;
      g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koD.duP), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB) });
      ae.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB), Integer.valueOf(this.koA) });
      j = (int)this.koC.mAK;
      if (j == -1) {
        break;
      }
      g.yxI.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.koA), Integer.valueOf(a.koN.duP), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.koB) });
      ae.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.koN.duP), Integer.valueOf(i), Integer.valueOf(this.koB), Integer.valueOf(this.koA) });
      AppMethodBeat.o(45132);
      return;
      if (localm.mAE == l.a.mAH) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ae.e("MicroMsg.Kv_14959", "variance == -1!");
    label1063:
    AppMethodBeat.o(45132);
  }
  
  static enum a
  {
    int duP;
    
    static
    {
      AppMethodBeat.i(45131);
      koD = new a("FPS", 0, 1);
      koE = new a("CPU", 1, 2);
      koF = new a("MEM", 2, 3);
      koG = new a("DRAW_CALL", 3, 4);
      koH = new a("TRIANGLE", 4, 5);
      koI = new a("VERTEX", 5, 6);
      koJ = new a("NATIVE_MEM", 6, 101);
      koK = new a("DALVIK_MEM", 7, 102);
      koL = new a("OTHER_MEM", 8, 103);
      koM = new a("MEM_DELTA", 9, 104);
      koN = new a("VARIANCE_FPS", 10, 105);
      koO = new a[] { koD, koE, koF, koG, koH, koI, koJ, koK, koL, koM, koN };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.duP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */