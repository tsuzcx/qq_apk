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
  public static String openId;
  public static String sessionId;
  public static long startTime;
  public static int vkj;
  public static String yOW;
  public static int zbe;
  public static Set<String> zbf;
  public static int zbg;
  public static int zbh;
  public static int zbi;
  public static int zbj;
  public static int zbk;
  public static int zbl;
  public static int zbm;
  
  static
  {
    AppMethodBeat.i(163682);
    zbf = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    yOW = paramString2;
    zbi = paramInt1;
    zbj = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
  
  public static void xV(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!Util.isNullOrNil(openId)) && (!Util.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      h.CyF.a(18994, new Object[] { Integer.valueOf(paramInt), yOW, Integer.valueOf(0), Integer.valueOf(zbe), Integer.valueOf(zbf.size()), Integer.valueOf(zbg), Integer.valueOf(zbh), Integer.valueOf(zbi), Integer.valueOf(zbj), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(vkj), Integer.valueOf(zbk), Integer.valueOf(zbl), Integer.valueOf(zbm) });
      yOW = null;
      zbe = 0;
      zbf.clear();
      zbg = 0;
      zbh = 0;
      zbi = 0;
      zbj = 0;
      openId = null;
      startTime = 0L;
      vkj = 0;
      zbk = 0;
      zbl = 0;
      zbm = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */