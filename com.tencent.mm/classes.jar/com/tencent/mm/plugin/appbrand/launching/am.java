package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class am
{
  static void a(b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(227090);
    int i = i.aeH(paramString);
    Log.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", new Object[] { paramb.name(), paramString, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    h.CyF.a(13886, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramb.eventId), "", "", Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(227090);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47266);
      mVG = new a("NONE", 0);
      mVH = new a("MISSING_PKG", 1);
      mVI = new a("NO_USE_RECENT", 2);
      mVJ = new a("INVALID_FIELDS", 3);
      mVK = new a("VERSION_NOT_FOUND", 4);
      mVL = new a("PATH_NOT_FOUND", 5);
      mVM = new a("CMD_UPDATE_VERSION", 6);
      mVN = new a("ATTRS_NOT_FOUND", 7);
      mVO = new a[] { mVG, mVH, mVI, mVJ, mVK, mVL, mVM, mVN };
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
      mVP = new b("SYNC_GET_ATTRS", 0, 20);
      mVQ = new b("SYNC_LAUNCH", 1, 21);
      mVR = new b("GET_DOWNLOAD_URL", 2, 22);
      mVS = new b[] { mVP, mVQ, mVR };
      AppMethodBeat.o(47269);
    }
    
    private b(int paramInt)
    {
      this.eventId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */