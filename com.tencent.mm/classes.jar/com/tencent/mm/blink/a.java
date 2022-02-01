package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;

public final class a
{
  private static final int[] fhA;
  private static final int[] fhB;
  private static final int[] fhC;
  private static final int[] fhD;
  private static final int[] fhE;
  private static final int[] fhF;
  private static final int[] fhG;
  private static final ArrayList<long[]> fhH;
  private static final ArrayList<Object[]> fhI;
  private static long fhJ;
  private static boolean fhK;
  private static long fhL;
  private static long fhM;
  private static long fhN;
  private static long fhO;
  private static byte fhP;
  public static final int[] fhn;
  public static final int[] fho;
  public static final int[] fhp;
  public static final int[] fhq;
  public static final int[] fhr;
  public static final int[] fhs;
  public static final int[] fht;
  public static final int[] fhu;
  public static final int[] fhv;
  public static final int[] fhw;
  public static final int[] fhx;
  public static final int[] fhy;
  private static final int[] fhz;
  
  static
  {
    AppMethodBeat.i(131814);
    fhn = new int[] { 0, 1, 2 };
    fho = new int[] { 3, 13, 23 };
    fhp = new int[] { 4, 14, 24 };
    fhq = new int[] { 5, 15, 25 };
    fhr = new int[] { 6, 16, 26 };
    fhs = new int[] { 7, 17, 27 };
    fht = new int[] { 8, 18, 28 };
    fhu = new int[] { 9, 19, 29 };
    fhv = new int[] { 63, 69, 75 };
    fhw = new int[] { 64, 70, 76 };
    fhx = new int[] { 65, 71, 77 };
    fhy = new int[] { 66, 72, 78 };
    fhz = new int[] { 0 };
    fhA = new int[] { 3 };
    fhB = new int[] { 9 };
    fhC = new int[] { 10 };
    fhD = new int[] { 11 };
    fhE = new int[] { 12 };
    fhF = new int[] { 13 };
    fhG = new int[] { 14 };
    fhH = new ArrayList();
    fhI = new ArrayList();
    fhJ = 0L;
    fhK = false;
    fhL = 0L;
    fhM = 0L;
    fhN = 0L;
    fhO = 0L;
    fhP = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void Lg()
  {
    AppMethodBeat.i(131804);
    ko(512);
    AppMethodBeat.o(131804);
  }
  
  public static void SQ()
  {
    AppMethodBeat.i(131801);
    fhJ = System.currentTimeMillis();
    AppMethodBeat.o(131801);
  }
  
  public static void SR()
  {
    AppMethodBeat.i(131802);
    if (ko(1024))
    {
      w(1L, System.currentTimeMillis() - fhJ);
      w(2L, 1L);
    }
    AppMethodBeat.o(131802);
  }
  
  public static void SS()
  {
    AppMethodBeat.i(202259);
    ko(512);
    fhK = false;
    AppMethodBeat.o(202259);
  }
  
  public static boolean ST()
  {
    AppMethodBeat.i(131809);
    if (!fhK)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = ko(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void SU()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - fhL;
    a(fhu, l);
    if (l <= 3000L)
    {
      a(fhv, 1L);
      a(fhn, 1L);
      l = SystemClock.elapsedRealtime() - fhM;
      b(fhA, l);
      if (l > 2000L) {
        break label181;
      }
      b(fhB, 1L);
    }
    for (;;)
    {
      b(fhz, 1L);
      fhI.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(fhw, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(fhx, 1L);
        break;
      }
      a(fhy, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(fhC, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(fhD, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(fhE, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(fhF, 1L);
      } else {
        b(fhG, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> SV()
  {
    return fhH;
  }
  
  public static ArrayList<Object[]> SW()
  {
    return fhI;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    ad.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    v(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.f.a.wH)
    {
      v(paramArrayOfInt[1], paramLong);
      AppMethodBeat.o(131807);
      return;
    }
    v(paramArrayOfInt[2], paramLong);
    AppMethodBeat.o(131807);
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131808);
    ad.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    fhH.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void eJ(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((ko(512)) && (aj.eFB().equals(paramString)))
    {
      fhK = true;
      ad.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  private static boolean ko(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((fhP & paramInt) == 0)
    {
      fhP = (byte)(fhP | paramInt);
      ad.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void kp(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (fhN == 0L)
    {
      ad.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - fhN;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (ko(1))
      {
        a(fho, l);
        fhN = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (ko(2))
        {
          a(fhp, l);
          fhN = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (ko(4))
          {
            a(fhq, l);
            fhN = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (ko(8))
            {
              a(fhr, l);
              fhN = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (ko(16))
              {
                lc(l);
                a(fhs, l);
                fhN = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (ko(32))
                {
                  lc(l);
                  a(fht, l);
                  fhN = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void lb(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      ko(512);
      fhK = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void lc(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      SS();
    }
    AppMethodBeat.o(131811);
  }
  
  public static void oj(String paramString)
  {
    AppMethodBeat.i(131798);
    j.qV(paramString);
    AppMethodBeat.o(131798);
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(131797);
    j.p(paramString, paramLong);
    AppMethodBeat.o(131797);
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131796);
    j.u(paramLong1, paramLong2);
    AppMethodBeat.o(131796);
  }
  
  public static void v(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    fhH.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void w(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    fhH.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void x(long paramLong1, long paramLong2)
  {
    fhL = paramLong1;
    fhM = paramLong2;
    fhN = fhL;
    fhO = fhM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */