package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

final class as
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(47270);
    int i = g.QC(paramString);
    ac.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(0) });
    h.wUl.f(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.jRj), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0) });
    AppMethodBeat.o(47270);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      lmN = new a("NONE", 0);
      lmO = new a("MISSING_PKG", 1);
      lmP = new a("NO_USE_RECENT", 2);
      lmQ = new a("INVALID_FIELDS", 3);
      lmR = new a("VERSION_NOT_FOUND", 4);
      lmS = new a("PATH_NOT_FOUND", 5);
      lmT = new a("CMD_UPDATE_VERSION", 6);
      lmU = new a("ATTRS_NOT_FOUND", 7);
      lmV = new a[] { lmN, lmO, lmP, lmQ, lmR, lmS, lmT, lmU };
      AppMethodBeat.o(47266);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    final int jRj;
    
    static
    {
      AppMethodBeat.i(47269);
      lmW = new b("SYNC_GET_ATTRS", 0, 20);
      lmX = new b("SYNC_LAUNCH", 1, 21);
      lmY = new b("GET_DOWNLOAD_URL", 2, 22);
      lmZ = new b[] { lmW, lmX, lmY };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.jRj = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.as
 * JD-Core Version:    0.7.0.1
 */