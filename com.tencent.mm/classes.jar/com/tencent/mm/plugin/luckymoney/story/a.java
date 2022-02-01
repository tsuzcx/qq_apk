package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class a
{
  public static String openId;
  public static String sXK;
  public static String sessionId;
  public static long startTime;
  public static int tje;
  public static Set<String> tjf;
  public static int tjg;
  public static int tjh;
  public static int tji;
  public static int tjj;
  public static int tjk;
  public static int tjl;
  public static int tjm;
  public static int tjn;
  
  static
  {
    AppMethodBeat.i(163682);
    tjf = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    sXK = paramString2;
    tji = paramInt1;
    tjj = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
  
  public static void sw(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!bt.isNullOrNil(openId)) && (!bt.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      h.vKh.f(18994, new Object[] { Integer.valueOf(paramInt), sXK, Integer.valueOf(0), Integer.valueOf(tje), Integer.valueOf(tjf.size()), Integer.valueOf(tjg), Integer.valueOf(tjh), Integer.valueOf(tji), Integer.valueOf(tjj), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(tjk), Integer.valueOf(tjl), Integer.valueOf(tjm), Integer.valueOf(tjn) });
      sXK = null;
      tje = 0;
      tjf.clear();
      tjg = 0;
      tjh = 0;
      tji = 0;
      tjj = 0;
      openId = null;
      startTime = 0L;
      tjk = 0;
      tjl = 0;
      tjm = 0;
      tjn = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */