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
  public static int EFB;
  public static Set<String> EFC;
  public static int EFD;
  public static int EFE;
  public static int EFF;
  public static int EFG;
  public static int EFH;
  public static int EFI;
  public static int EFJ;
  public static String EsU;
  public static String openId;
  public static String sessionId;
  public static long startTime;
  public static int xbJ;
  
  static
  {
    AppMethodBeat.i(163682);
    EFC = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void Bv(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!Util.isNullOrNil(openId)) && (!Util.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      h.IzE.a(18994, new Object[] { Integer.valueOf(paramInt), EsU, Integer.valueOf(0), Integer.valueOf(EFB), Integer.valueOf(EFC.size()), Integer.valueOf(EFD), Integer.valueOf(EFE), Integer.valueOf(EFF), Integer.valueOf(EFG), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(xbJ), Integer.valueOf(EFH), Integer.valueOf(EFI), Integer.valueOf(EFJ) });
      EsU = null;
      EFB = 0;
      EFC.clear();
      EFD = 0;
      EFE = 0;
      EFF = 0;
      EFG = 0;
      openId = null;
      startTime = 0L;
      xbJ = 0;
      EFH = 0;
      EFI = 0;
      EFJ = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    EsU = paramString2;
    EFF = paramInt1;
    EFG = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */