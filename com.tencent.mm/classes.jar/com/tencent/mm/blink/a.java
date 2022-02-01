package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class a
{
  private static final int[] iOA;
  private static final int[] iOB;
  private static final int[] iOC;
  private static final int[] iOD;
  private static final ArrayList<long[]> iOE;
  private static final ArrayList<Object[]> iOF;
  private static long iOG;
  private static boolean iOH;
  private static long iOI;
  private static long iOJ;
  private static long iOK;
  private static long iOL;
  private static byte iOM;
  public static final int[] iOk;
  public static final int[] iOl;
  public static final int[] iOm;
  public static final int[] iOn;
  public static final int[] iOo;
  public static final int[] iOp;
  public static final int[] iOq;
  public static final int[] iOr;
  public static final int[] iOs;
  public static final int[] iOt;
  public static final int[] iOu;
  public static final int[] iOv;
  private static final int[] iOw;
  private static final int[] iOx;
  private static final int[] iOy;
  private static final int[] iOz;
  
  static
  {
    AppMethodBeat.i(131814);
    iOk = new int[] { 0, 1, 2 };
    iOl = new int[] { 3, 13, 23 };
    iOm = new int[] { 4, 14, 24 };
    iOn = new int[] { 5, 15, 25 };
    iOo = new int[] { 6, 16, 26 };
    iOp = new int[] { 7, 17, 27 };
    iOq = new int[] { 8, 18, 28 };
    iOr = new int[] { 9, 19, 29 };
    iOs = new int[] { 63, 69, 75 };
    iOt = new int[] { 64, 70, 76 };
    iOu = new int[] { 65, 71, 77 };
    iOv = new int[] { 66, 72, 78 };
    iOw = new int[] { 0 };
    iOx = new int[] { 3 };
    iOy = new int[] { 9 };
    iOz = new int[] { 10 };
    iOA = new int[] { 11 };
    iOB = new int[] { 12 };
    iOC = new int[] { 13 };
    iOD = new int[] { 14 };
    iOE = new ArrayList();
    iOF = new ArrayList();
    iOG = 0L;
    iOH = false;
    iOI = 0L;
    iOJ = 0L;
    iOK = 0L;
    iOL = 0L;
    iOM = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void EJ(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      qc(512);
      iOH = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void EK(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      apV();
    }
    AppMethodBeat.o(131811);
  }
  
  public static void JB(String paramString)
  {
    AppMethodBeat.i(131798);
    l.MT(paramString);
    AppMethodBeat.o(131798);
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    s(paramArrayOfInt[0], paramLong);
    s(paramArrayOfInt[1], paramLong);
    AppMethodBeat.o(131807);
  }
  
  public static void abx()
  {
    AppMethodBeat.i(131804);
    qc(512);
    AppMethodBeat.o(131804);
  }
  
  public static void apV()
  {
    AppMethodBeat.i(292849);
    qc(512);
    iOH = false;
    AppMethodBeat.o(292849);
  }
  
  public static boolean apW()
  {
    AppMethodBeat.i(131809);
    if (!iOH)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = qc(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void apX()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - iOI;
    a(iOr, l);
    if (l <= 3000L)
    {
      a(iOs, 1L);
      a(iOk, 1L);
      l = SystemClock.elapsedRealtime() - iOJ;
      b(iOx, l);
      if (l > 2000L) {
        break label181;
      }
      b(iOy, 1L);
    }
    for (;;)
    {
      b(iOw, 1L);
      iOF.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(iOt, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(iOu, 1L);
        break;
      }
      a(iOv, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(iOz, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(iOA, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(iOB, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(iOC, 1L);
      } else {
        b(iOD, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> apY()
  {
    return iOE;
  }
  
  public static ArrayList<Object[]> apZ()
  {
    return iOF;
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131808);
    Log.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    iOE.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void gX(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((qc(512)) && (MMApplicationContext.getLaunchName().equals(paramString)))
    {
      iOH = true;
      Log.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  public static void n(String paramString, long paramLong)
  {
    AppMethodBeat.i(131797);
    l.n(paramString, paramLong);
    AppMethodBeat.o(131797);
  }
  
  private static boolean qc(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((iOM & paramInt) == 0)
    {
      iOM = (byte)(iOM | paramInt);
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
    if (iOK == 0L)
    {
      Log.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - iOK;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (qc(1))
      {
        a(iOl, l);
        iOK = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (qc(2))
        {
          a(iOm, l);
          iOK = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (qc(4))
          {
            a(iOn, l);
            iOK = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (qc(8))
            {
              a(iOo, l);
              iOK = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (qc(16))
              {
                EK(l);
                a(iOp, l);
                iOK = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (qc(32))
                {
                  EK(l);
                  a(iOq, l);
                  iOK = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131796);
    l.r(paramLong1, paramLong2);
    AppMethodBeat.o(131796);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    iOE.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    iOE.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    iOI = paramLong1;
    iOJ = paramLong2;
    iOK = iOI;
    iOL = iOJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */