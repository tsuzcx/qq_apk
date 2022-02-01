package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class au
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(47270);
    a(paramb, paramString, paramInt1, paramInt2, paramInt3, paramLong, 0);
    AppMethodBeat.o(47270);
  }
  
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(188619);
    int i = h.Ui(paramString);
    ad.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    g.yhR.f(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.dtK), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(188619);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      lJY = new a("NONE", 0);
      lJZ = new a("MISSING_PKG", 1);
      lKa = new a("NO_USE_RECENT", 2);
      lKb = new a("INVALID_FIELDS", 3);
      lKc = new a("VERSION_NOT_FOUND", 4);
      lKd = new a("PATH_NOT_FOUND", 5);
      lKe = new a("CMD_UPDATE_VERSION", 6);
      lKf = new a("ATTRS_NOT_FOUND", 7);
      lKg = new a[] { lJY, lJZ, lKa, lKb, lKc, lKd, lKe, lKf };
      AppMethodBeat.o(47266);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    final int dtK;
    
    static
    {
      AppMethodBeat.i(47269);
      lKh = new b("SYNC_GET_ATTRS", 0, 20);
      lKi = new b("SYNC_LAUNCH", 1, 21);
      lKj = new b("GET_DOWNLOAD_URL", 2, 22);
      lKk = new b[] { lKh, lKi, lKj };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.dtK = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */