package com.tencent.mm.danmaku.e;

import android.app.Application;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public final class c
{
  private static float cQj;
  private static final SimpleDateFormat jBb;
  private static final Date jBc;
  private static final StringBuilder jBd;
  private static final Formatter jBe;
  
  static
  {
    AppMethodBeat.i(290958);
    jBb = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
    jBc = new Date();
    jBd = new StringBuilder();
    jBe = new Formatter(jBd, Locale.getDefault());
    cQj = -1.0F;
    AppMethodBeat.o(290958);
  }
  
  public static String Fk(long paramLong)
  {
    AppMethodBeat.i(290955);
    if (paramLong < 86400000L)
    {
      paramLong /= 1000L;
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L % 60L;
      long l3 = paramLong / 3600L;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      jBd.setLength(0);
      if (l2 > 0L)
      {
        str = jBe.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
        AppMethodBeat.o(290955);
        return str;
      }
      str = jBe.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      AppMethodBeat.o(290955);
      return str;
    }
    jBc.setTime(paramLong);
    String str = jBb.format(jBc);
    AppMethodBeat.o(290955);
    return str;
  }
  
  public static int a(com.tencent.mm.danmaku.b.a parama1, com.tencent.mm.danmaku.b.a parama2)
  {
    AppMethodBeat.i(290953);
    if (parama1 == parama2)
    {
      AppMethodBeat.o(290953);
      return 0;
    }
    if (parama1 == null)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    if (parama1.equals(parama2))
    {
      AppMethodBeat.o(290953);
      return 0;
    }
    long l = parama1.getTime() - parama2.getTime();
    if (l > 0L)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    int i = parama1.azn() - parama2.azn();
    if (i > 0)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    i = parama1.azr() - parama2.azr();
    if (i > 0)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    i = parama1.azo() - parama2.azo();
    if (i > 0)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    l = parama1.aiJ() - parama2.aiJ();
    if (l > 0L)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    i = parama1.getType() - parama2.getType();
    if (i > 0)
    {
      AppMethodBeat.o(290953);
      return 1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(290953);
      return -1;
    }
    AppMethodBeat.o(290953);
    return i;
  }
  
  public static int a(com.tencent.mm.danmaku.b.a parama1, com.tencent.mm.danmaku.b.a parama2, long paramLong)
  {
    AppMethodBeat.i(290951);
    if ((parama1.Fd(paramLong)) || (parama2.Fd(paramLong)))
    {
      AppMethodBeat.o(290951);
      return -1;
    }
    float[] arrayOfFloat1 = parama1.Fg(parama1.azB());
    float[] arrayOfFloat2 = parama2.Fg(parama1.azB());
    if ((arrayOfFloat1 == null) || (arrayOfFloat2 == null))
    {
      AppMethodBeat.o(290951);
      return -1;
    }
    int i = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / parama2.azj());
    arrayOfFloat1 = parama1.Fg(parama1.azk());
    i = Math.max(i, (int)((parama2.Fg(parama1.azk())[0] - arrayOfFloat1[2]) / parama2.azj()));
    AppMethodBeat.o(290951);
    return i;
  }
  
  public static boolean aAc()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static int an(float paramFloat)
  {
    AppMethodBeat.i(290957);
    if (cQj < 0.0F) {
      cQj = com.tencent.mm.danmaku.f.a.aAh().getResources().getDisplayMetrics().density;
    }
    int i = (int)(cQj * paramFloat + 0.5F);
    AppMethodBeat.o(290957);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.c
 * JD-Core Version:    0.7.0.1
 */