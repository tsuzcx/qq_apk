package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;

public final class a
{
  public static final int[] fCP;
  public static final int[] fCQ;
  public static final int[] fCR;
  public static final int[] fCS;
  public static final int[] fCT;
  public static final int[] fCU;
  public static final int[] fCV;
  public static final int[] fCW;
  public static final int[] fCX;
  public static final int[] fCY;
  public static final int[] fCZ;
  public static final int[] fDa;
  private static final int[] fDb;
  private static final int[] fDc;
  private static final int[] fDd;
  private static final int[] fDe;
  private static final int[] fDf;
  private static final int[] fDg;
  private static final int[] fDh;
  private static final int[] fDi;
  private static final ArrayList<long[]> fDj;
  private static final ArrayList<Object[]> fDk;
  private static long fDl;
  private static boolean fDm;
  private static long fDn;
  private static long fDo;
  private static long fDp;
  private static long fDq;
  private static byte fDr;
  
  static
  {
    AppMethodBeat.i(131814);
    fCP = new int[] { 0, 1, 2 };
    fCQ = new int[] { 3, 13, 23 };
    fCR = new int[] { 4, 14, 24 };
    fCS = new int[] { 5, 15, 25 };
    fCT = new int[] { 6, 16, 26 };
    fCU = new int[] { 7, 17, 27 };
    fCV = new int[] { 8, 18, 28 };
    fCW = new int[] { 9, 19, 29 };
    fCX = new int[] { 63, 69, 75 };
    fCY = new int[] { 64, 70, 76 };
    fCZ = new int[] { 65, 71, 77 };
    fDa = new int[] { 66, 72, 78 };
    fDb = new int[] { 0 };
    fDc = new int[] { 3 };
    fDd = new int[] { 9 };
    fDe = new int[] { 10 };
    fDf = new int[] { 11 };
    fDg = new int[] { 12 };
    fDh = new int[] { 13 };
    fDi = new int[] { 14 };
    fDj = new ArrayList();
    fDk = new ArrayList();
    fDl = 0L;
    fDm = false;
    fDn = 0L;
    fDo = 0L;
    fDp = 0L;
    fDq = 0L;
    fDr = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void MM()
  {
    AppMethodBeat.i(131804);
    kI(512);
    AppMethodBeat.o(131804);
  }
  
  public static void Wb()
  {
    AppMethodBeat.i(131801);
    fDl = System.currentTimeMillis();
    AppMethodBeat.o(131801);
  }
  
  public static void Wc()
  {
    AppMethodBeat.i(131802);
    if (kI(1024))
    {
      s(1L, System.currentTimeMillis() - fDl);
      s(2L, 1L);
    }
    AppMethodBeat.o(131802);
  }
  
  public static void Wd()
  {
    AppMethodBeat.i(221707);
    kI(512);
    fDm = false;
    AppMethodBeat.o(221707);
  }
  
  public static boolean We()
  {
    AppMethodBeat.i(131809);
    if (!fDm)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = kI(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void Wf()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - fDn;
    a(fCW, l);
    if (l <= 3000L)
    {
      a(fCX, 1L);
      a(fCP, 1L);
      l = SystemClock.elapsedRealtime() - fDo;
      b(fDc, l);
      if (l > 2000L) {
        break label181;
      }
      b(fDd, 1L);
    }
    for (;;)
    {
      b(fDb, 1L);
      fDk.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(fCY, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(fCZ, 1L);
        break;
      }
      a(fDa, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(fDe, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(fDf, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(fDg, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(fDh, 1L);
      } else {
        b(fDi, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> Wg()
  {
    return fDj;
  }
  
  public static ArrayList<Object[]> Wh()
  {
    return fDk;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    ad.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    r(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.f.a.zz)
    {
      r(paramArrayOfInt[1], paramLong);
      AppMethodBeat.o(131807);
      return;
    }
    r(paramArrayOfInt[2], paramLong);
    AppMethodBeat.o(131807);
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131808);
    ad.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    fDj.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void fu(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((kI(512)) && (aj.fkA().equals(paramString)))
    {
      fDm = true;
      ad.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  private static boolean kI(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((fDr & paramInt) == 0)
    {
      fDr = (byte)(fDr | paramInt);
      ad.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void kJ(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (fDp == 0L)
    {
      ad.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - fDp;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (kI(1))
      {
        a(fCQ, l);
        fDp = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (kI(2))
        {
          a(fCR, l);
          fDp = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (kI(4))
          {
            a(fCS, l);
            fDp = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (kI(8))
            {
              a(fCT, l);
              fDp = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (kI(16))
              {
                qE(l);
                a(fCU, l);
                fDp = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (kI(32))
                {
                  qE(l);
                  a(fCV, l);
                  fDp = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(131797);
    j.p(paramString, paramLong);
    AppMethodBeat.o(131797);
  }
  
  public static void q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131796);
    j.q(paramLong1, paramLong2);
    AppMethodBeat.o(131796);
  }
  
  public static void qD(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      kI(512);
      fDm = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void qE(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      Wd();
    }
    AppMethodBeat.o(131811);
  }
  
  public static void r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    fDj.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    fDj.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    fDn = paramLong1;
    fDo = paramLong2;
    fDp = fDn;
    fDq = fDo;
  }
  
  public static void ub(String paramString)
  {
    AppMethodBeat.i(131798);
    j.xa(paramString);
    AppMethodBeat.o(131798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */