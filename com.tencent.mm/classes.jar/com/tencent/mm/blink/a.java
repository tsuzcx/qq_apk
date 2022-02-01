package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class a
{
  private static boolean gkA;
  private static long gkB;
  private static long gkC;
  private static long gkD;
  private static long gkE;
  private static byte gkF;
  public static final int[] gkd;
  public static final int[] gke;
  public static final int[] gkf;
  public static final int[] gkg;
  public static final int[] gkh;
  public static final int[] gki;
  public static final int[] gkj;
  public static final int[] gkk;
  public static final int[] gkl;
  public static final int[] gkm;
  public static final int[] gkn;
  public static final int[] gko;
  private static final int[] gkp;
  private static final int[] gkq;
  private static final int[] gkr;
  private static final int[] gks;
  private static final int[] gkt;
  private static final int[] gku;
  private static final int[] gkv;
  private static final int[] gkw;
  private static final ArrayList<long[]> gkx;
  private static final ArrayList<Object[]> gky;
  private static long gkz;
  
  static
  {
    AppMethodBeat.i(131814);
    gkd = new int[] { 0, 1, 2 };
    gke = new int[] { 3, 13, 23 };
    gkf = new int[] { 4, 14, 24 };
    gkg = new int[] { 5, 15, 25 };
    gkh = new int[] { 6, 16, 26 };
    gki = new int[] { 7, 17, 27 };
    gkj = new int[] { 8, 18, 28 };
    gkk = new int[] { 9, 19, 29 };
    gkl = new int[] { 63, 69, 75 };
    gkm = new int[] { 64, 70, 76 };
    gkn = new int[] { 65, 71, 77 };
    gko = new int[] { 66, 72, 78 };
    gkp = new int[] { 0 };
    gkq = new int[] { 3 };
    gkr = new int[] { 9 };
    gks = new int[] { 10 };
    gkt = new int[] { 11 };
    gku = new int[] { 12 };
    gkv = new int[] { 13 };
    gkw = new int[] { 14 };
    gkx = new ArrayList();
    gky = new ArrayList();
    gkz = 0L;
    gkA = false;
    gkB = 0L;
    gkC = 0L;
    gkD = 0L;
    gkE = 0L;
    gkF = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void CM(String paramString)
  {
    AppMethodBeat.i(131798);
    j.FT(paramString);
    AppMethodBeat.o(131798);
  }
  
  public static void WU()
  {
    AppMethodBeat.i(131804);
    nN(512);
    AppMethodBeat.o(131804);
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    s(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.f.a.zF)
    {
      s(paramArrayOfInt[1], paramLong);
      AppMethodBeat.o(131807);
      return;
    }
    s(paramArrayOfInt[2], paramLong);
    AppMethodBeat.o(131807);
  }
  
  public static void ajZ()
  {
    AppMethodBeat.i(258480);
    nN(512);
    gkA = false;
    AppMethodBeat.o(258480);
  }
  
  public static boolean aka()
  {
    AppMethodBeat.i(131809);
    if (!gkA)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = nN(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void akb()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - gkB;
    a(gkk, l);
    if (l <= 3000L)
    {
      a(gkl, 1L);
      a(gkd, 1L);
      l = SystemClock.elapsedRealtime() - gkC;
      b(gkq, l);
      if (l > 2000L) {
        break label181;
      }
      b(gkr, 1L);
    }
    for (;;)
    {
      b(gkp, 1L);
      gky.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(gkm, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(gkn, 1L);
        break;
      }
      a(gko, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(gks, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(gkt, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(gku, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(gkv, 1L);
      } else {
        b(gkw, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> akc()
  {
    return gkx;
  }
  
  public static ArrayList<Object[]> akd()
  {
    return gky;
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131808);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    gkx.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void gn(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((nN(512)) && (MMApplicationContext.getLaunchName().equals(paramString)))
    {
      gkA = true;
      Log.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  private static boolean nN(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((gkF & paramInt) == 0)
    {
      gkF = (byte)(gkF | paramInt);
      Log.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void nO(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (gkD == 0L)
    {
      Log.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - gkD;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (nN(1))
      {
        a(gke, l);
        gkD = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (nN(2))
        {
          a(gkf, l);
          gkD = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (nN(4))
          {
            a(gkg, l);
            gkD = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (nN(8))
            {
              a(gkh, l);
              gkD = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (nN(16))
              {
                yJ(l);
                a(gki, l);
                gkD = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (nN(32))
                {
                  yJ(l);
                  a(gkj, l);
                  gkD = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void q(String paramString, long paramLong)
  {
    AppMethodBeat.i(131797);
    j.q(paramString, paramLong);
    AppMethodBeat.o(131797);
  }
  
  public static void r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131796);
    j.r(paramLong1, paramLong2);
    AppMethodBeat.o(131796);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    gkx.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    gkx.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    gkB = paramLong1;
    gkC = paramLong2;
    gkD = gkB;
    gkE = gkC;
  }
  
  public static void yI(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      nN(512);
      gkA = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void yJ(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      ajZ();
    }
    AppMethodBeat.o(131811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */