package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class a
{
  public static final int[] dgA = { 65, 71, 77 };
  public static final int[] dgB = { 66, 72, 78 };
  private static final int[] dgC = { 0 };
  private static final int[] dgD = { 3 };
  private static final int[] dgE = { 9 };
  private static final int[] dgF = { 10 };
  private static final int[] dgG = { 11 };
  private static final int[] dgH = { 12 };
  private static final int[] dgI = { 13 };
  private static final int[] dgJ = { 14 };
  private static final ArrayList<long[]> dgK = new ArrayList();
  private static final ArrayList<Object[]> dgL = new ArrayList();
  private static long dgM = 0L;
  private static boolean dgN = false;
  private static long dgO = 0L;
  private static long dgP = 0L;
  private static long dgQ = 0L;
  private static long dgR = 0L;
  private static byte dgS = 0;
  public static final int[] dgq = { 0, 1, 2 };
  public static final int[] dgr = { 3, 13, 23 };
  public static final int[] dgs = { 4, 14, 24 };
  public static final int[] dgt = { 5, 15, 25 };
  public static final int[] dgu = { 6, 16, 26 };
  public static final int[] dgv = { 7, 17, 27 };
  public static final int[] dgw = { 8, 18, 28 };
  public static final int[] dgx = { 9, 19, 29 };
  public static final int[] dgy = { 63, 69, 75 };
  public static final int[] dgz = { 64, 70, 76 };
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    y.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    m(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.g.a.pg)
    {
      m(paramArrayOfInt[1], paramLong);
      return;
    }
    m(paramArrayOfInt[2], paramLong);
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    y.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    dgK.add(new long[] { 910L, l, paramLong });
  }
  
  public static void bj(long paramLong)
  {
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      fO(512);
      dgN = false;
    }
  }
  
  private static void bk(long paramLong)
  {
    if (paramLong > 10000L) {
      vB();
    }
  }
  
  public static void cr(String paramString)
  {
    if ((fO(512)) && (ae.cqP().equals(paramString)))
    {
      dgN = true;
      y.i("MicroMsg.BlinkStartup", "report this time");
    }
  }
  
  public static void el(String paramString)
  {
    k.el(paramString);
  }
  
  private static boolean fO(int paramInt)
  {
    if ((dgS & paramInt) == 0)
    {
      dgS = (byte)(dgS | paramInt);
      y.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      return true;
    }
    return false;
  }
  
  public static void fP(int paramInt)
  {
    if (dgQ == 0L) {
      y.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                l = System.currentTimeMillis() - dgQ;
                switch (paramInt)
                {
                default: 
                  return;
                }
              } while (!fO(1));
              a(dgr, l);
              dgQ = System.currentTimeMillis();
              return;
            } while (!fO(2));
            a(dgs, l);
            dgQ = System.currentTimeMillis();
            return;
          } while (!fO(4));
          a(dgt, l);
          dgQ = System.currentTimeMillis();
          return;
        } while (!fO(8));
        a(dgu, l);
        dgQ = System.currentTimeMillis();
        return;
      } while (!fO(16));
      bk(l);
      a(dgv, l);
      dgQ = System.currentTimeMillis();
      return;
    } while (!fO(32));
    bk(l);
    a(dgw, l);
    dgQ = System.currentTimeMillis();
  }
  
  public static void h(String paramString, long paramLong)
  {
    k.h(paramString, paramLong);
  }
  
  public static void l(long paramLong1, long paramLong2)
  {
    k.l(paramLong1, paramLong2);
  }
  
  public static void m(long paramLong1, long paramLong2)
  {
    dgK.add(new long[] { 709L, paramLong1, paramLong2 });
  }
  
  public static void n(long paramLong1, long paramLong2)
  {
    dgK.add(new long[] { 783L, paramLong1, paramLong2 });
  }
  
  public static void o(long paramLong1, long paramLong2)
  {
    dgO = paramLong1;
    dgP = paramLong2;
    dgQ = dgO;
    dgR = dgP;
  }
  
  public static void tg()
  {
    fO(512);
  }
  
  public static void vA()
  {
    if (fO(1024))
    {
      n(1L, System.currentTimeMillis() - dgM);
      n(2L, 1L);
    }
  }
  
  public static void vB()
  {
    fO(512);
    dgN = false;
  }
  
  public static boolean vC()
  {
    if (!dgN) {
      return false;
    }
    return fO(256);
  }
  
  public static void vD()
  {
    long l = System.currentTimeMillis() - dgO;
    a(dgx, l);
    if (l <= 3000L)
    {
      a(dgy, 1L);
      a(dgq, 1L);
      l = SystemClock.elapsedRealtime() - dgP;
      b(dgD, l);
      if (l > 2000L) {
        break label171;
      }
      b(dgE, 1L);
    }
    for (;;)
    {
      b(dgC, 1L);
      dgL.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(dgz, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(dgA, 1L);
        break;
      }
      a(dgB, 1L);
      break;
      label171:
      if ((l > 2000L) && (l <= 4000L)) {
        b(dgF, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(dgG, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(dgH, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(dgI, 1L);
      } else {
        b(dgJ, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> vE()
  {
    return dgK;
  }
  
  public static ArrayList<Object[]> vF()
  {
    return dgL;
  }
  
  public static void vz()
  {
    dgM = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */