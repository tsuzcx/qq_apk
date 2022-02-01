package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private int aBM;
  private String appId;
  private int cYO;
  private int jQV;
  private int jQW;
  m jQX;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, m paramm)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.cYO = paramQualitySessionRuntime.lTR;
    this.aBM = paramQualitySessionRuntime.lVs;
    this.jQX = paramm;
  }
  
  public final void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    ac.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.jQX == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    m localm = this.jQX;
    int i;
    if (localm.lVS == l.a.lVU) {
      i = 1;
    }
    for (;;)
    {
      this.jQV = i;
      this.jQW = this.jQX.jQW;
      if (paramBoolean)
      {
        if (this.jQX != null)
        {
          i = this.jQX.lWd;
          j = this.jQX.lWe;
          h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jQZ.jRj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW) });
          ac.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW), Integer.valueOf(this.jQV) });
        }
        if (this.jQX != null)
        {
          i = this.jQX.lWd;
          j = this.jQX.bZm;
          int k = this.jQX.bZn;
          int m = this.jQX.bZo;
          int n = this.jQX.lWc;
          h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jRa.jRj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW) });
          h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jRe.jRj), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.jQW) });
          h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jRf.jRj), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.jQW) });
          h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jRh.jRj), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.jQW) });
          ac.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.jQW), Integer.valueOf(this.jQV) });
        }
      }
      if (this.jQX == null) {
        break label1063;
      }
      i = this.jQX.lWd;
      int j = this.jQX.fps;
      h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jQY.jRj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW) });
      ac.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW), Integer.valueOf(this.jQV) });
      j = (int)this.jQX.lVY;
      if (j == -1) {
        break;
      }
      h.wUl.f(14959, new Object[] { this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.jQV), Integer.valueOf(a.jRi.jRj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.jQW) });
      ac.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.jRi.jRj), Integer.valueOf(i), Integer.valueOf(this.jQW), Integer.valueOf(this.jQV) });
      AppMethodBeat.o(45132);
      return;
      if (localm.lVS == l.a.lVV) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ac.e("MicroMsg.Kv_14959", "variance == -1!");
    label1063:
    AppMethodBeat.o(45132);
  }
  
  static enum a
  {
    int jRj;
    
    static
    {
      AppMethodBeat.i(45131);
      jQY = new a("FPS", 0, 1);
      jQZ = new a("CPU", 1, 2);
      jRa = new a("MEM", 2, 3);
      jRb = new a("DRAW_CALL", 3, 4);
      jRc = new a("TRIANGLE", 4, 5);
      jRd = new a("VERTEX", 5, 6);
      jRe = new a("NATIVE_MEM", 6, 101);
      jRf = new a("DALVIK_MEM", 7, 102);
      jRg = new a("OTHER_MEM", 8, 103);
      jRh = new a("MEM_DELTA", 9, 104);
      jRi = new a("VARIANCE_FPS", 10, 105);
      jRk = new a[] { jQY, jQZ, jRa, jRb, jRc, jRd, jRe, jRf, jRg, jRh, jRi };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.jRj = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */