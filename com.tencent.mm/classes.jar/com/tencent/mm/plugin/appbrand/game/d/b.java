package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.m.a;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private String appId;
  private int appVersion;
  private int dCv;
  private int lsj;
  private int lsk;
  n lsl;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, n paramn)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.dCv = paramQualitySessionRuntime.nJE;
    this.appVersion = paramQualitySessionRuntime.nLk;
    this.lsl = paramn;
  }
  
  public final void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    Log.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.lsl == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    n localn = this.lsl;
    int i;
    if (localn.nLJ == m.a.nLL) {
      i = 1;
    }
    for (;;)
    {
      this.lsj = i;
      this.lsk = this.lsl.lsk;
      if (paramBoolean)
      {
        if (this.lsl != null)
        {
          i = this.lsl.nLU;
          j = this.lsl.nLV;
          h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lsn.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj) });
        }
        if (this.lsl != null)
        {
          i = this.lsl.nLU;
          j = this.lsl.cvD;
          int k = this.lsl.cvE;
          int m = this.lsl.cvF;
          int n = this.lsl.nLT;
          h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lso.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk) });
          h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lss.eventId), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.lsk) });
          h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lst.eventId), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.lsk) });
          h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lsv.eventId), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.lsk) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj) });
        }
      }
      if (this.lsl == null) {
        break label1063;
      }
      i = this.lsl.nLU;
      int j = this.lsl.fps;
      h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lsm.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj) });
      j = (int)this.lsl.nLP;
      if (j == -1) {
        break;
      }
      h.CyF.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.lsw.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.lsk) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.lsw.eventId), Integer.valueOf(i), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj) });
      AppMethodBeat.o(45132);
      return;
      if (localn.nLJ == m.a.nLM) {
        i = 2;
      } else {
        i = 0;
      }
    }
    Log.e("MicroMsg.Kv_14959", "variance == -1!");
    label1063:
    AppMethodBeat.o(45132);
  }
  
  static enum a
  {
    int eventId;
    
    static
    {
      AppMethodBeat.i(45131);
      lsm = new a("FPS", 0, 1);
      lsn = new a("CPU", 1, 2);
      lso = new a("MEM", 2, 3);
      lsp = new a("DRAW_CALL", 3, 4);
      lsq = new a("TRIANGLE", 4, 5);
      lsr = new a("VERTEX", 5, 6);
      lss = new a("NATIVE_MEM", 6, 101);
      lst = new a("DALVIK_MEM", 7, 102);
      lsu = new a("OTHER_MEM", 8, 103);
      lsv = new a("MEM_DELTA", 9, 104);
      lsw = new a("VARIANCE_FPS", 10, 105);
      lsx = new a[] { lsm, lsn, lso, lsp, lsq, lsr, lss, lst, lsu, lsv, lsw };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */