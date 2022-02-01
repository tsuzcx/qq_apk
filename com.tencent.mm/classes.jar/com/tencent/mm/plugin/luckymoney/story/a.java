package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class a
{
  public static int dKW;
  private static long enterTime;
  public static String fLJ;
  public static int scene;
  public static String vGc;
  public static int vGd = 1;
  
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189848);
    scene = paramInt1;
    fLJ = paramString;
    dKW = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(189848);
  }
  
  public static void tW(int paramInt)
  {
    AppMethodBeat.i(189849);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      g.yxI.f(20255, new Object[] { Integer.valueOf(scene), fLJ, Integer.valueOf(dKW), Integer.valueOf(0), vGc, Integer.valueOf(vGd), Integer.valueOf(paramInt), Long.valueOf(l) });
    }
    scene = 0;
    enterTime = -1L;
    fLJ = null;
    dKW = 0;
    vGc = null;
    vGd = 1;
    AppMethodBeat.o(189849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */