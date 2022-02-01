package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class b
{
  public static String openId;
  public static String sessionId;
  public static long startTime;
  public static int vGe;
  public static Set<String> vGf;
  public static int vGg;
  public static int vGh;
  public static int vGi;
  public static int vGj;
  public static int vGk;
  public static int vGl;
  public static int vGm;
  public static int vGn;
  public static String vuM;
  
  static
  {
    AppMethodBeat.i(163682);
    vGf = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    vuM = paramString2;
    vGi = paramInt1;
    vGj = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
  
  public static void tW(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!bu.isNullOrNil(openId)) && (!bu.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      g.yxI.f(18994, new Object[] { Integer.valueOf(paramInt), vuM, Integer.valueOf(0), Integer.valueOf(vGe), Integer.valueOf(vGf.size()), Integer.valueOf(vGg), Integer.valueOf(vGh), Integer.valueOf(vGi), Integer.valueOf(vGj), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(vGk), Integer.valueOf(vGl), Integer.valueOf(vGm), Integer.valueOf(vGn) });
      vuM = null;
      vGe = 0;
      vGf.clear();
      vGg = 0;
      vGh = 0;
      vGi = 0;
      vGj = 0;
      openId = null;
      startTime = 0L;
      vGk = 0;
      vGl = 0;
      vGm = 0;
      vGn = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */