package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class as
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(47270);
    int i = com.tencent.mm.plugin.appbrand.report.h.Mt(paramString);
    ad.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(0) });
    com.tencent.mm.plugin.report.service.h.vKh.f(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.jqR), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0) });
    AppMethodBeat.o(47270);
  }
  
  public static enum b
  {
    final int jqR;
    
    static
    {
      AppMethodBeat.i(47269);
      kLA = new b("SYNC_GET_ATTRS", 0, 20);
      kLB = new b("SYNC_LAUNCH", 1, 21);
      kLC = new b("GET_DOWNLOAD_URL", 2, 22);
      kLD = new b[] { kLA, kLB, kLC };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.jqR = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.as
 * JD-Core Version:    0.7.0.1
 */