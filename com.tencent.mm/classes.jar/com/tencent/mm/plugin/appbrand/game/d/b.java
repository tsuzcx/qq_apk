package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.h.a;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  private String appId;
  private int bDc;
  private int cmE;
  private int hsV;
  private int hsW;
  i hsX;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, i parami)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.cmE = paramQualitySessionRuntime.iIF;
    this.bDc = paramQualitySessionRuntime.iIG;
    this.hsX = parami;
  }
  
  public final void dV(boolean paramBoolean)
  {
    AppMethodBeat.i(143147);
    ab.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.hsX == null)
    {
      AppMethodBeat.o(143147);
      return;
    }
    i locali = this.hsX;
    int i;
    if (locali.iIS == h.a.iIU) {
      i = 1;
    }
    for (;;)
    {
      this.hsV = i;
      this.hsW = this.hsX.hsW;
      if (paramBoolean)
      {
        if (this.hsX != null)
        {
          i = this.hsX.iJc;
          j = this.hsX.iJd;
          h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hsZ.htj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW) });
          ab.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW), Integer.valueOf(this.hsV) });
        }
        if (this.hsX != null)
        {
          i = this.hsX.iJc;
          j = this.hsX.bAS;
          int k = this.hsX.bAT;
          int m = this.hsX.bAU;
          int n = this.hsX.iJb;
          h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hta.htj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW) });
          h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hte.htj), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.hsW) });
          h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.htf.htj), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.hsW) });
          h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hth.htj), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.hsW) });
          ab.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.hsW), Integer.valueOf(this.hsV) });
        }
      }
      if (this.hsX == null) {
        break label1063;
      }
      i = this.hsX.iJc;
      int j = this.hsX.fps;
      h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hsY.htj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW) });
      ab.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW), Integer.valueOf(this.hsV) });
      j = (int)this.hsX.iIX;
      if (j == -1) {
        break;
      }
      h.qsU.e(14959, new Object[] { this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.hsV), Integer.valueOf(a.hti.htj), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.hsW) });
      ab.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.hti.htj), Integer.valueOf(i), Integer.valueOf(this.hsW), Integer.valueOf(this.hsV) });
      AppMethodBeat.o(143147);
      return;
      if (locali.iIS == h.a.iIV) {
        i = 2;
      } else {
        i = 0;
      }
    }
    ab.e("MicroMsg.Kv_14959", "variance == -1!");
    label1063:
    AppMethodBeat.o(143147);
  }
  
  static enum a
  {
    int htj;
    
    static
    {
      AppMethodBeat.i(130189);
      hsY = new a("FPS", 0, 1);
      hsZ = new a("CPU", 1, 2);
      hta = new a("MEM", 2, 3);
      htb = new a("DRAW_CALL", 3, 4);
      htc = new a("TRIANGLE", 4, 5);
      htd = new a("VERTEX", 5, 6);
      hte = new a("NATIVE_MEM", 6, 101);
      htf = new a("DALVIK_MEM", 7, 102);
      htg = new a("OTHER_MEM", 8, 103);
      hth = new a("MEM_DELTA", 9, 104);
      hti = new a("VARIANCE_FPS", 10, 105);
      htk = new a[] { hsY, hsZ, hta, htb, htc, htd, hte, htf, htg, hth, hti };
      AppMethodBeat.o(130189);
    }
    
    private a(int paramInt)
    {
      this.htj = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */