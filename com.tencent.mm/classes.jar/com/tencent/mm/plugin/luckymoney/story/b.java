package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class b
{
  public static int ACR;
  public static String KlA;
  public static int KyH;
  public static Set<String> KyI;
  public static int KyJ;
  public static int KyK;
  public static int KyL;
  public static int KyM;
  public static int KyN;
  public static int KyO;
  public static int KyP;
  public static String openId;
  public static String sessionId;
  public static long startTime;
  
  static
  {
    AppMethodBeat.i(163682);
    KyI = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void BI(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!Util.isNullOrNil(openId)) && (!Util.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      h.OAn.b(18994, new Object[] { Integer.valueOf(paramInt), KlA, Integer.valueOf(0), Integer.valueOf(KyH), Integer.valueOf(KyI.size()), Integer.valueOf(KyJ), Integer.valueOf(KyK), Integer.valueOf(KyL), Integer.valueOf(KyM), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(ACR), Integer.valueOf(KyN), Integer.valueOf(KyO), Integer.valueOf(KyP) });
      KlA = null;
      KyH = 0;
      KyI.clear();
      KyJ = 0;
      KyK = 0;
      KyL = 0;
      KyM = 0;
      openId = null;
      startTime = 0L;
      ACR = 0;
      KyN = 0;
      KyO = 0;
      KyP = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
  
  public static void n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    KlA = paramString2;
    KyL = paramInt1;
    KyM = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */