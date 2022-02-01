package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class b
{
  public static String openId;
  public static String sessionId;
  public static long startTime;
  public static String ufX;
  public static int urA;
  public static int urB;
  public static int urC;
  public static int urD;
  public static int urE;
  public static int urF;
  public static int urG;
  public static int urx;
  public static Set<String> ury;
  public static int urz;
  
  static
  {
    AppMethodBeat.i(163682);
    ury = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    ufX = paramString2;
    urB = paramInt1;
    urC = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
  
  public static void tn(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!bs.isNullOrNil(openId)) && (!bs.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      h.wUl.f(18994, new Object[] { Integer.valueOf(paramInt), ufX, Integer.valueOf(0), Integer.valueOf(urx), Integer.valueOf(ury.size()), Integer.valueOf(urz), Integer.valueOf(urA), Integer.valueOf(urB), Integer.valueOf(urC), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(urD), Integer.valueOf(urE), Integer.valueOf(urF), Integer.valueOf(urG) });
      ufX = null;
      urx = 0;
      ury.clear();
      urz = 0;
      urA = 0;
      urB = 0;
      urC = 0;
      openId = null;
      startTime = 0L;
      urD = 0;
      urE = 0;
      urF = 0;
      urG = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */