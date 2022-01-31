package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class z
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(131909);
    int i = e.ED(paramString);
    ab.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(0) });
    h.qsU.e(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.htj), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0) });
    AppMethodBeat.o(131909);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131905);
      ilR = new a("NONE", 0);
      ilS = new a("MISSING_PKG", 1);
      ilT = new a("NO_USE_RECENT", 2);
      ilU = new a("INVALID_FIELDS", 3);
      ilV = new a("VERSION_NOT_FOUND", 4);
      ilW = new a("PATH_NOT_FOUND", 5);
      ilX = new a("CMD_UPDATE_VERSION", 6);
      ilY = new a("ATTRS_NOT_FOUND", 7);
      ilZ = new a[] { ilR, ilS, ilT, ilU, ilV, ilW, ilX, ilY };
      AppMethodBeat.o(131905);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    final int htj;
    
    static
    {
      AppMethodBeat.i(131908);
      ima = new b("SYNC_GET_ATTRS", 0, 20);
      imb = new b("SYNC_LAUNCH", 1, 21);
      imc = new b("GET_DOWNLOAD_URL", 2, 22);
      imd = new b[] { ima, imb, imc };
      AppMethodBeat.o(131908);
    }
    
    private b(int paramInt)
    {
      this.htj = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */