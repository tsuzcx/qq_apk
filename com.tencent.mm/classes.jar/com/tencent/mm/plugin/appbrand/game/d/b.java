package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private int aDD;
  private String appId;
  private int dkg;
  private int klk;
  private int kll;
  m klm;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, m paramm)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.dkg = paramQualitySessionRuntime.mtG;
    this.aDD = paramQualitySessionRuntime.mvi;
    this.klm = paramm;
  }
  
  public final void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    ad.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.klm == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    m localm = this.klm;
    int i;
    if (localm.mvH == l.a.mvJ) {
      i = 1;
    }
    for (;;)
    {
      this.klk = i;
      this.kll = this.klm.kll;
      if (paramBoolean)
      {
        if (this.klm != null)
        {
          i = this.klm.mvS;
          j = this.klm.mvT;
          g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klo.dtK), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll) });
          ad.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll), Integer.valueOf(this.klk) });
        }
        if (this.klm != null)
        {
          i = this.klm.mvS;
          j = this.klm.cjE;
          int k = this.klm.cjF;
          int m = this.klm.cjG;
          int n = this.klm.mvR;
          g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klp.dtK), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll) });
          g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klt.dtK), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.kll) });
          g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klu.dtK), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.kll) });
          g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klw.dtK), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.kll) });
          ad.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.kll), Integer.valueOf(this.klk) });
        }
      }
      if (this.klm == null) {
        break label1063;
      }
      i = this.klm.mvS;
      int j = this.klm.fps;
      g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.kln.dtK), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll) });
      ad.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll), Integer.valueOf(this.klk) });
      j = (int)this.klm.mvN;
      if (j == -1) {
        break;
      }
      g.yhR.f(14959, new Object[] { this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.klk), Integer.valueOf(a.klx.dtK), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kll) });
      ad.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.klx.dtK), Integer.valueOf(i), Integer.valueOf(this.kll), Integer.valueOf(this.klk) });
      AppMethodBeat.o(45132);
      return;
      if (localm.mvH == l.a.mvK) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ad.e("MicroMsg.Kv_14959", "variance == -1!");
    label1063:
    AppMethodBeat.o(45132);
  }
  
  static enum a
  {
    int dtK;
    
    static
    {
      AppMethodBeat.i(45131);
      kln = new a("FPS", 0, 1);
      klo = new a("CPU", 1, 2);
      klp = new a("MEM", 2, 3);
      klq = new a("DRAW_CALL", 3, 4);
      klr = new a("TRIANGLE", 4, 5);
      kls = new a("VERTEX", 5, 6);
      klt = new a("NATIVE_MEM", 6, 101);
      klu = new a("DALVIK_MEM", 7, 102);
      klv = new a("OTHER_MEM", 8, 103);
      klw = new a("MEM_DELTA", 9, 104);
      klx = new a("VARIANCE_FPS", 10, 105);
      kly = new a[] { kln, klo, klp, klq, klr, kls, klt, klu, klv, klw, klx };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.dtK = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */