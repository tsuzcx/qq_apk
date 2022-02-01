package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class a
{
  public static final int[] fET;
  public static final int[] fEU;
  public static final int[] fEV;
  public static final int[] fEW;
  public static final int[] fEX;
  public static final int[] fEY;
  public static final int[] fEZ;
  public static final int[] fFa;
  public static final int[] fFb;
  public static final int[] fFc;
  public static final int[] fFd;
  public static final int[] fFe;
  private static final int[] fFf;
  private static final int[] fFg;
  private static final int[] fFh;
  private static final int[] fFi;
  private static final int[] fFj;
  private static final int[] fFk;
  private static final int[] fFl;
  private static final int[] fFm;
  private static final ArrayList<long[]> fFn;
  private static final ArrayList<Object[]> fFo;
  private static long fFp;
  private static boolean fFq;
  private static long fFr;
  private static long fFs;
  private static long fFt;
  private static long fFu;
  private static byte fFv;
  
  static
  {
    AppMethodBeat.i(131814);
    fET = new int[] { 0, 1, 2 };
    fEU = new int[] { 3, 13, 23 };
    fEV = new int[] { 4, 14, 24 };
    fEW = new int[] { 5, 15, 25 };
    fEX = new int[] { 6, 16, 26 };
    fEY = new int[] { 7, 17, 27 };
    fEZ = new int[] { 8, 18, 28 };
    fFa = new int[] { 9, 19, 29 };
    fFb = new int[] { 63, 69, 75 };
    fFc = new int[] { 64, 70, 76 };
    fFd = new int[] { 65, 71, 77 };
    fFe = new int[] { 66, 72, 78 };
    fFf = new int[] { 0 };
    fFg = new int[] { 3 };
    fFh = new int[] { 9 };
    fFi = new int[] { 10 };
    fFj = new int[] { 11 };
    fFk = new int[] { 12 };
    fFl = new int[] { 13 };
    fFm = new int[] { 14 };
    fFn = new ArrayList();
    fFo = new ArrayList();
    fFp = 0L;
    fFq = false;
    fFr = 0L;
    fFs = 0L;
    fFt = 0L;
    fFu = 0L;
    fFv = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void MH()
  {
    AppMethodBeat.i(131804);
    kK(512);
    AppMethodBeat.o(131804);
  }
  
  public static void Wj()
  {
    AppMethodBeat.i(131801);
    fFp = System.currentTimeMillis();
    AppMethodBeat.o(131801);
  }
  
  public static void Wk()
  {
    AppMethodBeat.i(131802);
    if (kK(1024))
    {
      s(1L, System.currentTimeMillis() - fFp);
      s(2L, 1L);
    }
    AppMethodBeat.o(131802);
  }
  
  public static void Wl()
  {
    AppMethodBeat.i(224415);
    kK(512);
    fFq = false;
    AppMethodBeat.o(224415);
  }
  
  public static boolean Wm()
  {
    AppMethodBeat.i(131809);
    if (!fFq)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = kK(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void Wn()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - fFr;
    a(fFa, l);
    if (l <= 3000L)
    {
      a(fFb, 1L);
      a(fET, 1L);
      l = SystemClock.elapsedRealtime() - fFs;
      b(fFg, l);
      if (l > 2000L) {
        break label181;
      }
      b(fFh, 1L);
    }
    for (;;)
    {
      b(fFf, 1L);
      fFo.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(fFc, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(fFd, 1L);
        break;
      }
      a(fFe, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(fFi, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(fFj, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(fFk, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(fFl, 1L);
      } else {
        b(fFm, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> Wo()
  {
    return fFn;
  }
  
  public static ArrayList<Object[]> Wp()
  {
    return fFo;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    ae.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
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
    ae.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    fFn.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void fA(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((kK(512)) && (ak.fou().equals(paramString)))
    {
      fFq = true;
      ae.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  private static boolean kK(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((fFv & paramInt) == 0)
    {
      fFv = (byte)(fFv | paramInt);
      ae.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void kL(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (fFt == 0L)
    {
      ae.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - fFt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (kK(1))
      {
        a(fEU, l);
        fFt = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (kK(2))
        {
          a(fEV, l);
          fFt = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (kK(4))
          {
            a(fEW, l);
            fFt = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (kK(8))
            {
              a(fEX, l);
              fFt = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (kK(16))
              {
                qR(l);
                a(fEY, l);
                fFt = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (kK(32))
                {
                  qR(l);
                  a(fEZ, l);
                  fFt = System.currentTimeMillis();
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
  
  public static void qQ(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      kK(512);
      fFq = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void qR(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      Wl();
    }
    AppMethodBeat.o(131811);
  }
  
  public static void r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    fFn.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    fFn.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    fFr = paramLong1;
    fFs = paramLong2;
    fFt = fFr;
    fFu = fFs;
  }
  
  public static void uw(String paramString)
  {
    AppMethodBeat.i(131798);
    j.xJ(paramString);
    AppMethodBeat.o(131798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */