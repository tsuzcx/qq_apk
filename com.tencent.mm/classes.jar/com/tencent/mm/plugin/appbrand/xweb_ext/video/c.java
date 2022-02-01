package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public class c
  implements a
{
  private static c uUD;
  private Set<String> uUE;
  
  private c()
  {
    AppMethodBeat.i(50025);
    this.uUE = new HashSet();
    AppMethodBeat.o(50025);
  }
  
  public static c cTF()
  {
    AppMethodBeat.i(50026);
    if (uUD == null) {}
    try
    {
      if (uUD == null)
      {
        localc = new c();
        uUD = localc;
        return localc;
      }
      c localc = uUD;
      AppMethodBeat.o(50026);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(50026);
    }
  }
  
  public final void Bi(int paramInt)
  {
    AppMethodBeat.i(50027);
    Log.i("MicroMsg.SameLayer.VideoReporter", "startProxyResult, reason:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt >= 0)
    {
      h.OAn.idkeyStat(1234L, 16L, 1L, false);
      AppMethodBeat.o(50027);
      return;
    }
    if (paramInt == -1)
    {
      h.OAn.idkeyStat(1234L, 17L, 1L, false);
      AppMethodBeat.o(50027);
      return;
    }
    if (paramInt == -2) {
      h.OAn.idkeyStat(1234L, 18L, 1L, false);
    }
    AppMethodBeat.o(50027);
  }
  
  public final void L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50029);
    Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadError, uuid:%s, url:%s, code:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.uUE.add(paramString1);
    if (paramInt == -101)
    {
      h.OAn.idkeyStat(1234L, 27L, 1L, false);
      AppMethodBeat.o(50029);
      return;
    }
    if (paramInt == -102)
    {
      h.OAn.idkeyStat(1234L, 28L, 1L, false);
      AppMethodBeat.o(50029);
      return;
    }
    if (paramInt == -103)
    {
      h.OAn.idkeyStat(1234L, 29L, 1L, false);
      AppMethodBeat.o(50029);
      return;
    }
    if (paramInt == -104)
    {
      h.OAn.idkeyStat(1234L, 30L, 1L, false);
      AppMethodBeat.o(50029);
      return;
    }
    if (paramInt == -105) {
      h.OAn.idkeyStat(1234L, 31L, 1L, false);
    }
    AppMethodBeat.o(50029);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(50033);
    Log.i("MicroMsg.SameLayer.VideoReporter", "downloadResult, videoUuid:%s, sourceUrl:%s, priority:%s, rangeStart:%s, rangeEnd:%s, totalLength:%s, contentType:%s, requestMethod:%s, speed:%s, retCode:%s, subRetCode:%s, responseCode:%s, costTime:%s, message:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2), paramString3, Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(paramInt3), paramString4 });
    h.OAn.b(18693, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong7), Integer.valueOf(paramInt3), Long.valueOf(paramLong5), Long.valueOf(paramLong6), paramString4, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2), paramString3, Long.valueOf(paramLong4) });
    AppMethodBeat.o(50033);
  }
  
  public final void cvW()
  {
    AppMethodBeat.i(50031);
    h.OAn.idkeyStat(1234L, 36L, 1L, false);
    AppMethodBeat.o(50031);
  }
  
  public final void et(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50028);
    Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadStart, uuid:%s, url:%s", new Object[] { paramString1, paramString2 });
    h.OAn.idkeyStat(1234L, 26L, 1L, false);
    AppMethodBeat.o(50028);
  }
  
  public final void eu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50030);
    Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadEnd, uuid:%s, url:%s", new Object[] { paramString1, paramString2 });
    if (!this.uUE.contains(paramString1))
    {
      h.OAn.idkeyStat(1234L, 32L, 1L, false);
      AppMethodBeat.o(50030);
      return;
    }
    this.uUE.remove(paramString1);
    AppMethodBeat.o(50030);
  }
  
  public final void jL(long paramLong)
  {
    AppMethodBeat.i(50032);
    h.OAn.idkeyStat(1234L, 37L, paramLong, false);
    AppMethodBeat.o(50032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.c
 * JD-Core Version:    0.7.0.1
 */