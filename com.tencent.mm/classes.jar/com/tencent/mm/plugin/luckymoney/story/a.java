package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a
{
  public static String KyE;
  public static int KyF = 1;
  private static String KyG;
  private static long enterTime;
  public static int icP;
  public static String lxj;
  public static int scene;
  
  public static void BI(int paramInt)
  {
    AppMethodBeat.i(284004);
    if (enterTime > 0L)
    {
      long l = (SystemClock.elapsedRealtime() - enterTime) / 1000L;
      h.OAn.b(20255, new Object[] { Integer.valueOf(scene), lxj, Integer.valueOf(icP), Integer.valueOf(0), KyE, Integer.valueOf(KyF), Integer.valueOf(paramInt), Long.valueOf(l), KyG });
    }
    scene = 0;
    enterTime = -1L;
    lxj = null;
    icP = 0;
    KyE = null;
    KyF = 1;
    KyG = "";
    AppMethodBeat.o(284004);
  }
  
  public static void aKH(String paramString)
  {
    KyG = paramString;
  }
  
  public static void s(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(283998);
    scene = paramInt1;
    lxj = paramString;
    icP = paramInt2;
    enterTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(283998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a
 * JD-Core Version:    0.7.0.1
 */