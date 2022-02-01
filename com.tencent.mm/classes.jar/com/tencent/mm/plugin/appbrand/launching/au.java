package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

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
    AppMethodBeat.i(222778);
    int i = h.US(paramString);
    ae.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    g.yxI.f(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.duP), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(222778);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      lOy = new a("NONE", 0);
      lOz = new a("MISSING_PKG", 1);
      lOA = new a("NO_USE_RECENT", 2);
      lOB = new a("INVALID_FIELDS", 3);
      lOC = new a("VERSION_NOT_FOUND", 4);
      lOD = new a("PATH_NOT_FOUND", 5);
      lOE = new a("CMD_UPDATE_VERSION", 6);
      lOF = new a("ATTRS_NOT_FOUND", 7);
      lOG = new a[] { lOy, lOz, lOA, lOB, lOC, lOD, lOE, lOF };
      AppMethodBeat.o(47266);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    final int duP;
    
    static
    {
      AppMethodBeat.i(47269);
      lOH = new b("SYNC_GET_ATTRS", 0, 20);
      lOI = new b("SYNC_LAUNCH", 1, 21);
      lOJ = new b("GET_DOWNLOAD_URL", 2, 22);
      lOK = new b[] { lOH, lOI, lOJ };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.duP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */