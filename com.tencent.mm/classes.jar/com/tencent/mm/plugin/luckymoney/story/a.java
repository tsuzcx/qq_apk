package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a
{
  public static int dxw;
  private static long enterTime;
  public static String frx;
  public static int scene;
  public static String urv;
  public static int urw = 1;
  
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(207107);
    scene = paramInt1;
    frx = paramString;
    dxw = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(207107);
  }
  
  public static void tn(int paramInt)
  {
    AppMethodBeat.i(207108);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      h.wUl.f(20255, new Object[] { Integer.valueOf(scene), frx, Integer.valueOf(dxw), Integer.valueOf(0), urv, Integer.valueOf(urw), Integer.valueOf(paramInt), Long.valueOf(l) });
    }
    scene = 0;
    enterTime = -1L;
    frx = null;
    dxw = 0;
    urv = null;
    urw = 1;
    AppMethodBeat.o(207108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */