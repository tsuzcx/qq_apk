package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class a
{
  private static final ArrayList<long[]> lqA;
  private static final ArrayList<Object[]> lqB;
  private static long lqC;
  private static boolean lqD;
  private static long lqE;
  private static long lqF;
  private static long lqG;
  private static long lqH;
  private static byte lqI;
  public static final int[] lqg;
  public static final int[] lqh;
  public static final int[] lqi;
  public static final int[] lqj;
  public static final int[] lqk;
  public static final int[] lql;
  public static final int[] lqm;
  public static final int[] lqn;
  public static final int[] lqo;
  public static final int[] lqp;
  public static final int[] lqq;
  public static final int[] lqr;
  private static final int[] lqs;
  private static final int[] lqt;
  private static final int[] lqu;
  private static final int[] lqv;
  private static final int[] lqw;
  private static final int[] lqx;
  private static final int[] lqy;
  private static final int[] lqz;
  
  static
  {
    AppMethodBeat.i(131814);
    lqg = new int[] { 0, 1, 2 };
    lqh = new int[] { 3, 13, 23 };
    lqi = new int[] { 4, 14, 24 };
    lqj = new int[] { 5, 15, 25 };
    lqk = new int[] { 6, 16, 26 };
    lql = new int[] { 7, 17, 27 };
    lqm = new int[] { 8, 18, 28 };
    lqn = new int[] { 9, 19, 29 };
    lqo = new int[] { 63, 69, 75 };
    lqp = new int[] { 64, 70, 76 };
    lqq = new int[] { 65, 71, 77 };
    lqr = new int[] { 66, 72, 78 };
    lqs = new int[] { 0 };
    lqt = new int[] { 3 };
    lqu = new int[] { 9 };
    lqv = new int[] { 10 };
    lqw = new int[] { 11 };
    lqx = new int[] { 12 };
    lqy = new int[] { 13 };
    lqz = new int[] { 14 };
    lqA = new ArrayList();
    lqB = new ArrayList();
    lqC = 0L;
    lqD = false;
    lqE = 0L;
    lqF = 0L;
    lqG = 0L;
    lqH = 0L;
    lqI = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void Ch(String paramString)
  {
    AppMethodBeat.i(131798);
    l.FC(paramString);
    AppMethodBeat.o(131798);
  }
  
  public static void O(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131796);
    l.O(paramLong1, paramLong2);
    AppMethodBeat.o(131796);
  }
  
  public static void P(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    lqA.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    lqA.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void R(long paramLong1, long paramLong2)
  {
    lqE = paramLong1;
    lqF = paramLong2;
    lqG = lqE;
    lqH = lqF;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    P(paramArrayOfInt[0], paramLong);
    P(paramArrayOfInt[1], paramLong);
    AppMethodBeat.o(131807);
  }
  
  public static void aDs()
  {
    AppMethodBeat.i(131804);
    qc(512);
    AppMethodBeat.o(131804);
  }
  
  public static void aJT()
  {
    AppMethodBeat.i(369548);
    qc(512);
    lqD = false;
    AppMethodBeat.o(369548);
  }
  
  public static boolean aJU()
  {
    AppMethodBeat.i(131809);
    if (!lqD)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = qc(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void aJV()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - lqE;
    a(lqn, l);
    if (l <= 3000L)
    {
      a(lqo, 1L);
      a(lqg, 1L);
      l = SystemClock.elapsedRealtime() - lqF;
      b(lqt, l);
      if (l > 2000L) {
        break label181;
      }
      b(lqu, 1L);
    }
    for (;;)
    {
      b(lqs, 1L);
      lqB.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(lqp, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(lqq, 1L);
        break;
      }
      a(lqr, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(lqv, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(lqw, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(lqx, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(lqy, 1L);
      } else {
        b(lqz, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> aJW()
  {
    return lqA;
  }
  
  public static ArrayList<Object[]> aJX()
  {
    return lqB;
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131808);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    lqA.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void ha(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      qc(512);
      lqD = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void hb(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      aJT();
    }
    AppMethodBeat.o(131811);
  }
  
  public static void iy(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((qc(512)) && (MMApplicationContext.getLaunchName().equals(paramString)))
    {
      lqD = true;
      Log.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  public static void o(String paramString, long paramLong)
  {
    AppMethodBeat.i(131797);
    l.o(paramString, paramLong);
    AppMethodBeat.o(131797);
  }
  
  private static boolean qc(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((lqI & paramInt) == 0)
    {
      lqI = (byte)(lqI | paramInt);
      Log.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void qd(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (lqG == 0L)
    {
      Log.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - lqG;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (qc(1))
      {
        a(lqh, l);
        lqG = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (qc(2))
        {
          a(lqi, l);
          lqG = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (qc(4))
          {
            a(lqj, l);
            lqG = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (qc(8))
            {
              a(lqk, l);
              lqG = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (qc(16))
              {
                hb(l);
                a(lql, l);
                lqG = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (qc(32))
                {
                  hb(l);
                  a(lqm, l);
                  lqG = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */