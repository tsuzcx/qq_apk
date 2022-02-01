package com.tencent.mm.plugin.luckymoney.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.UUID;

public final class d
{
  public static String sessionId;
  public static long startTime;
  public static String vuP;
  public static boolean vuQ = false;
  
  public static void apW(String paramString)
  {
    vuP = paramString;
  }
  
  public static void bkx()
  {
    AppMethodBeat.i(168791);
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(168791);
  }
  
  public static void resetSession()
  {
    sessionId = null;
    vuP = null;
    startTime = -1L;
  }
  
  public static void tW(int paramInt)
  {
    AppMethodBeat.i(168792);
    if (bu.isNullOrNil(sessionId))
    {
      AppMethodBeat.o(168792);
      return;
    }
    if ((!vuQ) && ((paramInt == 9) || (paramInt == 10) || (paramInt == 11)))
    {
      AppMethodBeat.o(168792);
      return;
    }
    if ((paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      vuQ = false;
    }
    long l1 = SystemClock.elapsedRealtime() / 1000L;
    long l2 = startTime;
    g.yxI.f(18889, new Object[] { Integer.valueOf(paramInt), sessionId, Long.valueOf(l1 - l2), vuP });
    AppMethodBeat.o(168792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.d
 * JD-Core Version:    0.7.0.1
 */