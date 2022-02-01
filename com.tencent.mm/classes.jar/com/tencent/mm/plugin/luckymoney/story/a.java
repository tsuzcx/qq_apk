package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a
{
  public static int ecL;
  private static long enterTime;
  public static String gqV;
  public static int scene;
  public static String zbc;
  public static int zbd = 1;
  
  public static void m(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213350);
    scene = paramInt1;
    gqV = paramString;
    ecL = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(213350);
  }
  
  public static void xV(int paramInt)
  {
    AppMethodBeat.i(213351);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      h.CyF.a(20255, new Object[] { Integer.valueOf(scene), gqV, Integer.valueOf(ecL), Integer.valueOf(0), zbc, Integer.valueOf(zbd), Integer.valueOf(paramInt), Long.valueOf(l) });
    }
    scene = 0;
    enterTime = -1L;
    gqV = null;
    ecL = 0;
    zbc = null;
    zbd = 1;
    AppMethodBeat.o(213351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */