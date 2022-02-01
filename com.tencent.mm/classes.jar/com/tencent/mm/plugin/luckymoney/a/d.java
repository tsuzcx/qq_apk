package com.tencent.mm.plugin.luckymoney.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.UUID;

public final class d
{
  public static boolean BqB = false;
  public static String EsX;
  public static String sessionId;
  public static long startTime;
  
  public static void Bv(int paramInt)
  {
    AppMethodBeat.i(168792);
    if (Util.isNullOrNil(sessionId))
    {
      AppMethodBeat.o(168792);
      return;
    }
    if ((!BqB) && ((paramInt == 9) || (paramInt == 10) || (paramInt == 11)))
    {
      AppMethodBeat.o(168792);
      return;
    }
    if ((paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      BqB = false;
    }
    long l1 = SystemClock.elapsedRealtime() / 1000L;
    long l2 = startTime;
    h.IzE.a(18889, new Object[] { Integer.valueOf(paramInt), sessionId, Long.valueOf(l1 - l2), EsX });
    AppMethodBeat.o(168792);
  }
  
  public static void aNz(String paramString)
  {
    EsX = paramString;
  }
  
  public static void bRC()
  {
    AppMethodBeat.i(168791);
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(168791);
  }
  
  public static void resetSession()
  {
    sessionId = null;
    EsX = null;
    startTime = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.d
 * JD-Core Version:    0.7.0.1
 */