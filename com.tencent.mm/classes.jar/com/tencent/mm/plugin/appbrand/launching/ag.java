package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(242960);
    int i = j.amB(paramString);
    Log.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    h.IzE.a(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.eventId), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(242960);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      pWj = new a("NONE", 0);
      pWk = new a("MISSING_PKG", 1);
      pWl = new a("NO_USE_RECENT", 2);
      pWm = new a("INVALID_FIELDS", 3);
      pWn = new a("VERSION_NOT_FOUND", 4);
      pWo = new a("PATH_NOT_FOUND", 5);
      pWp = new a("CMD_UPDATE_VERSION", 6);
      pWq = new a("ATTRS_NOT_FOUND", 7);
      pWr = new a[] { pWj, pWk, pWl, pWm, pWn, pWo, pWp, pWq };
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
      pWs = new b("SYNC_GET_ATTRS", 0, 20);
      pWt = new b("SYNC_LAUNCH", 1, 21);
      pWu = new b("GET_DOWNLOAD_URL", 2, 22);
      pWv = new b[] { pWs, pWt, pWu };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */