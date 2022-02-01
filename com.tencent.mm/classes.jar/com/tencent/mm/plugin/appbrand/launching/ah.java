package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class ah
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(320658);
    int i = j.afN(paramString);
    Log.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    h.OAn.b(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.eventId), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(320658);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      taY = new a("NONE", 0);
      taZ = new a("MISSING_PKG", 1);
      tba = new a("NO_USE_RECENT", 2);
      tbb = new a("INVALID_FIELDS", 3);
      tbc = new a("VERSION_NOT_FOUND", 4);
      tbd = new a("PATH_NOT_FOUND", 5);
      tbe = new a("CMD_UPDATE_VERSION", 6);
      tbf = new a("ATTRS_NOT_FOUND", 7);
      tbg = new a[] { taY, taZ, tba, tbb, tbc, tbd, tbe, tbf };
      AppMethodBeat.o(47266);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    final int eventId;
    
    static
    {
      AppMethodBeat.i(47269);
      tbh = new b("SYNC_GET_ATTRS", 0, 20);
      tbi = new b("SYNC_LAUNCH", 1, 21);
      tbj = new b("GET_DOWNLOAD_URL", 2, 22);
      tbk = new b[] { tbh, tbi, tbj };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah
 * JD-Core Version:    0.7.0.1
 */