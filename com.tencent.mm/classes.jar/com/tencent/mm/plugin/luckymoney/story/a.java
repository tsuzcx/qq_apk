package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class a
{
  public static int dJI;
  private static long enterTime;
  public static String fJG;
  public static int scene;
  public static String vtY;
  public static int vtZ = 1;
  
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(199013);
    scene = paramInt1;
    fJG = paramString;
    dJI = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(199013);
  }
  
  public static void tQ(int paramInt)
  {
    AppMethodBeat.i(199014);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      g.yhR.f(20255, new Object[] { Integer.valueOf(scene), fJG, Integer.valueOf(dJI), Integer.valueOf(0), vtY, Integer.valueOf(vtZ), Integer.valueOf(paramInt), Long.valueOf(l) });
    }
    scene = 0;
    enterTime = -1L;
    fJG = null;
    dJI = 0;
    vtY = null;
    vtZ = 1;
    AppMethodBeat.o(199014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */