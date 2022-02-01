package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a
{
  public static int EFA = 1;
  public static String EFz;
  private static long enterTime;
  public static int fWQ;
  public static String iVe;
  public static int scene;
  
  public static void Bv(int paramInt)
  {
    AppMethodBeat.i(221064);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      h.IzE.a(20255, new Object[] { Integer.valueOf(scene), iVe, Integer.valueOf(fWQ), Integer.valueOf(0), EFz, Integer.valueOf(EFA), Integer.valueOf(paramInt), Long.valueOf(l) });
    }
    scene = 0;
    enterTime = -1L;
    iVe = null;
    fWQ = 0;
    EFz = null;
    EFA = 1;
    AppMethodBeat.o(221064);
  }
  
  public static void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(221058);
    scene = paramInt1;
    iVe = paramString;
    fWQ = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(221058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */