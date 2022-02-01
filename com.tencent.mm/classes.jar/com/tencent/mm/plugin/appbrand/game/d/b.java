package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private String appId;
  private int appVersion;
  private int hzw;
  private int rqP;
  private int rqQ;
  m rqR;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, m paramm)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.hzw = paramQualitySessionRuntime.tQx;
    this.appVersion = paramQualitySessionRuntime.tSh;
    this.rqR = paramm;
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    Log.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.rqR == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    m localm = this.rqR;
    int i;
    if (localm.tSH == l.a.tSJ) {
      i = 1;
    }
    for (;;)
    {
      this.rqP = i;
      this.rqQ = this.rqR.rqQ;
      if (paramBoolean)
      {
        if (this.rqR != null)
        {
          i = this.rqR.tSS;
          j = this.rqR.tST;
          h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rqT.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ), Integer.valueOf(this.rqP) });
        }
        if (this.rqR != null)
        {
          i = this.rqR.tSS;
          j = this.rqR.elN;
          int k = this.rqR.elO;
          int m = this.rqR.elP;
          int n = this.rqR.tSR;
          h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rqU.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
          h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rqY.eventId), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
          h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rqZ.eventId), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
          h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rrb.eventId), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.rqQ), Integer.valueOf(this.rqP) });
        }
      }
      if (this.rqR == null) {
        break label1063;
      }
      i = this.rqR.tSS;
      int j = this.rqR.fps;
      h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rqS.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ), Integer.valueOf(this.rqP) });
      j = (int)this.rqR.tSN;
      if (j == -1) {
        break;
      }
      h.OAn.b(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.rqP), Integer.valueOf(a.rrc.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.rqQ) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.rrc.eventId), Integer.valueOf(i), Integer.valueOf(this.rqQ), Integer.valueOf(this.rqP) });
      AppMethodBeat.o(45132);
      return;
      if (localm.tSH == l.a.tSK) {
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
      rqS = new a("FPS", 0, 1);
      rqT = new a("CPU", 1, 2);
      rqU = new a("MEM", 2, 3);
      rqV = new a("DRAW_CALL", 3, 4);
      rqW = new a("TRIANGLE", 4, 5);
      rqX = new a("VERTEX", 5, 6);
      rqY = new a("NATIVE_MEM", 6, 101);
      rqZ = new a("DALVIK_MEM", 7, 102);
      rra = new a("OTHER_MEM", 8, 103);
      rrb = new a("MEM_DELTA", 9, 104);
      rrc = new a("VARIANCE_FPS", 10, 105);
      rrd = new a[] { rqS, rqT, rqU, rqV, rqW, rqX, rqY, rqZ, rra, rrb, rrc };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */