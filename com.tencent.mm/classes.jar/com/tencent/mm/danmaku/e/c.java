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
  private static float cPs;
  private static final SimpleDateFormat gQI;
  private static final Date gQJ;
  private static final StringBuilder gQK;
  private static final Formatter gQL;
  
  static
  {
    AppMethodBeat.i(241760);
    gQI = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
    gQJ = new Date();
    gQK = new StringBuilder();
    gQL = new Formatter(gQK, Locale.getDefault());
    cPs = -1.0F;
    AppMethodBeat.o(241760);
  }
  
  public static int a(com.tencent.mm.danmaku.b.a parama1, com.tencent.mm.danmaku.b.a parama2)
  {
    AppMethodBeat.i(241757);
    if (parama1 == parama2)
    {
      AppMethodBeat.o(241757);
      return 0;
    }
    if (parama1 == null)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    if (parama1.equals(parama2))
    {
      AppMethodBeat.o(241757);
      return 0;
    }
    long l = parama1.getTime() - parama2.getTime();
    if (l > 0L)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    int i = parama1.asz() - parama2.asz();
    if (i > 0)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    i = parama1.asD() - parama2.asD();
    if (i > 0)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    i = parama1.asA() - parama2.asA();
    if (i > 0)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    l = parama1.adU() - parama2.adU();
    if (l > 0L)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    i = parama1.getType() - parama2.getType();
    if (i > 0)
    {
      AppMethodBeat.o(241757);
      return 1;
    }
    if (i < 0)
    {
      AppMethodBeat.o(241757);
      return -1;
    }
    AppMethodBeat.o(241757);
    return i;
  }
  
  public static int a(com.tencent.mm.danmaku.b.a parama1, com.tencent.mm.danmaku.b.a parama2, long paramLong)
  {
    AppMethodBeat.i(241756);
    if ((parama1.yZ(paramLong)) || (parama2.yZ(paramLong)))
    {
      AppMethodBeat.o(241756);
      return -1;
    }
    float[] arrayOfFloat1 = parama1.zc(parama1.asN());
    float[] arrayOfFloat2 = parama2.zc(parama1.asN());
    if ((arrayOfFloat1 == null) || (arrayOfFloat2 == null))
    {
      AppMethodBeat.o(241756);
      return -1;
    }
    int i = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / parama2.asv());
    arrayOfFloat1 = parama1.zc(parama1.asw());
    i = Math.max(i, (int)((parama2.zc(parama1.asw())[0] - arrayOfFloat1[2]) / parama2.asv()));
    AppMethodBeat.o(241756);
    return i;
  }
  
  public static int ao(float paramFloat)
  {
    AppMethodBeat.i(241759);
    if (cPs < 0.0F) {
      cPs = com.tencent.mm.danmaku.f.a.atr().getResources().getDisplayMetrics().density;
    }
    int i = (int)(cPs * paramFloat + 0.5F);
    AppMethodBeat.o(241759);
    return i;
  }
  
  public static boolean atm()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static String zg(long paramLong)
  {
    AppMethodBeat.i(241758);
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
      gQK.setLength(0);
      if (l2 > 0L)
      {
        str = gQL.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
        AppMethodBeat.o(241758);
        return str;
      }
      str = gQL.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      AppMethodBeat.o(241758);
      return str;
    }
    gQJ.setTime(paramLong);
    String str = gQI.format(gQJ);
    AppMethodBeat.o(241758);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.c
 * JD-Core Version:    0.7.0.1
 */