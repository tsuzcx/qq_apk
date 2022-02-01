package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private int aAS;
  private String appId;
  private int dbs;
  private int jqD;
  private int jqE;
  m jqF;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, m paramm)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.dbs = paramQualitySessionRuntime.lrW;
    this.aAS = paramQualitySessionRuntime.lty;
    this.jqF = paramm;
  }
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    ad.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.jqF == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    m localm = this.jqF;
    int i;
    if (localm.ltY == l.a.lua) {
      i = 1;
    }
    for (;;)
    {
      this.jqD = i;
      this.jqE = this.jqF.jqE;
      if (paramBoolean)
      {
        if (this.jqF != null)
        {
          i = this.jqF.luj;
          j = this.jqF.luk;
          h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqH.jqR), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE) });
          ad.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE), Integer.valueOf(this.jqD) });
        }
        if (this.jqF != null)
        {
          i = this.jqF.luj;
          j = this.jqF.ccp;
          int k = this.jqF.ccq;
          int m = this.jqF.ccr;
          int n = this.jqF.lui;
          h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqI.jqR), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE) });
          h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqM.jqR), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.jqE) });
          h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqN.jqR), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.jqE) });
          h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqP.jqR), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.jqE) });
          ad.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.jqE), Integer.valueOf(this.jqD) });
        }
      }
      if (this.jqF == null) {
        break label1063;
      }
      i = this.jqF.luj;
      int j = this.jqF.fps;
      h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqG.jqR), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE) });
      ad.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE), Integer.valueOf(this.jqD) });
      j = (int)this.jqF.lue;
      if (j == -1) {
        break;
      }
      h.vKh.f(14959, new Object[] { this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.jqD), Integer.valueOf(a.jqQ.jqR), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jqE) });
      ad.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.jqQ.jqR), Integer.valueOf(i), Integer.valueOf(this.jqE), Integer.valueOf(this.jqD) });
      AppMethodBeat.o(45132);
      return;
      if (localm.ltY == l.a.lub) {
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
    int jqR;
    
    static
    {
      AppMethodBeat.i(45131);
      jqG = new a("FPS", 0, 1);
      jqH = new a("CPU", 1, 2);
      jqI = new a("MEM", 2, 3);
      jqJ = new a("DRAW_CALL", 3, 4);
      jqK = new a("TRIANGLE", 4, 5);
      jqL = new a("VERTEX", 5, 6);
      jqM = new a("NATIVE_MEM", 6, 101);
      jqN = new a("DALVIK_MEM", 7, 102);
      jqO = new a("OTHER_MEM", 8, 103);
      jqP = new a("MEM_DELTA", 9, 104);
      jqQ = new a("VARIANCE_FPS", 10, 105);
      jqS = new a[] { jqG, jqH, jqI, jqJ, jqK, jqL, jqM, jqN, jqO, jqP, jqQ };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.jqR = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */