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
  private int fvc;
  private int ong;
  private int onh;
  n oni;
  
  public b(QualitySessionRuntime paramQualitySessionRuntime, n paramn)
  {
    this.appId = paramQualitySessionRuntime.appId;
    this.fvc = paramQualitySessionRuntime.qLQ;
    this.appVersion = paramQualitySessionRuntime.qNx;
    this.oni = paramn;
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(45132);
    Log.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.oni == null)
    {
      AppMethodBeat.o(45132);
      return;
    }
    n localn = this.oni;
    int i;
    if (localn.qNX == m.a.qNZ) {
      i = 1;
    }
    for (;;)
    {
      this.ong = i;
      this.onh = this.oni.onh;
      if (paramBoolean)
      {
        if (this.oni != null)
        {
          i = this.oni.qOi;
          j = this.oni.qOj;
          h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.onk.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh), Integer.valueOf(this.ong) });
        }
        if (this.oni != null)
        {
          i = this.oni.qOi;
          j = this.oni.ctT;
          int k = this.oni.ctU;
          int m = this.oni.ctV;
          int n = this.oni.qOh;
          h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.onl.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh) });
          h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.onp.eventId), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.onh) });
          h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.onq.eventId), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.onh) });
          h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.ons.eventId), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.onh) });
          Log.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(this.onh), Integer.valueOf(this.ong) });
        }
      }
      if (this.oni == null) {
        break label1063;
      }
      i = this.oni.qOi;
      int j = this.oni.fps;
      h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.onj.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh), Integer.valueOf(this.ong) });
      j = (int)this.oni.qOd;
      if (j == -1) {
        break;
      }
      h.IzE.a(14959, new Object[] { this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.ong), Integer.valueOf(a.ont.eventId), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.onh) });
      Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(a.ont.eventId), Integer.valueOf(i), Integer.valueOf(this.onh), Integer.valueOf(this.ong) });
      AppMethodBeat.o(45132);
      return;
      if (localn.qNX == m.a.qOa) {
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
      onj = new a("FPS", 0, 1);
      onk = new a("CPU", 1, 2);
      onl = new a("MEM", 2, 3);
      onm = new a("DRAW_CALL", 3, 4);
      onn = new a("TRIANGLE", 4, 5);
      ono = new a("VERTEX", 5, 6);
      onp = new a("NATIVE_MEM", 6, 101);
      onq = new a("DALVIK_MEM", 7, 102);
      onr = new a("OTHER_MEM", 8, 103);
      ons = new a("MEM_DELTA", 9, 104);
      ont = new a("VARIANCE_FPS", 10, 105);
      onu = new a[] { onj, onk, onl, onm, onn, ono, onp, onq, onr, ons, ont };
      AppMethodBeat.o(45131);
    }
    
    private a(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.b
 * JD-Core Version:    0.7.0.1
 */