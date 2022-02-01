package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;

public final class a
{
  public static final int[] fkI;
  public static final int[] fkJ;
  public static final int[] fkK;
  public static final int[] fkL;
  public static final int[] fkM;
  public static final int[] fkN;
  public static final int[] fkO;
  public static final int[] fkP;
  public static final int[] fkQ;
  public static final int[] fkR;
  public static final int[] fkS;
  public static final int[] fkT;
  private static final int[] fkU;
  private static final int[] fkV;
  private static final int[] fkW;
  private static final int[] fkX;
  private static final int[] fkY;
  private static final int[] fkZ;
  private static final int[] fla;
  private static final int[] flb;
  private static final ArrayList<long[]> flc;
  private static final ArrayList<Object[]> fld;
  private static long fle;
  private static boolean flf;
  private static long flg;
  private static long flh;
  private static long fli;
  private static long flj;
  private static byte flk;
  
  static
  {
    AppMethodBeat.i(131814);
    fkI = new int[] { 0, 1, 2 };
    fkJ = new int[] { 3, 13, 23 };
    fkK = new int[] { 4, 14, 24 };
    fkL = new int[] { 5, 15, 25 };
    fkM = new int[] { 6, 16, 26 };
    fkN = new int[] { 7, 17, 27 };
    fkO = new int[] { 8, 18, 28 };
    fkP = new int[] { 9, 19, 29 };
    fkQ = new int[] { 63, 69, 75 };
    fkR = new int[] { 64, 70, 76 };
    fkS = new int[] { 65, 71, 77 };
    fkT = new int[] { 66, 72, 78 };
    fkU = new int[] { 0 };
    fkV = new int[] { 3 };
    fkW = new int[] { 9 };
    fkX = new int[] { 10 };
    fkY = new int[] { 11 };
    fkZ = new int[] { 12 };
    fla = new int[] { 13 };
    flb = new int[] { 14 };
    flc = new ArrayList();
    fld = new ArrayList();
    fle = 0L;
    flf = false;
    flg = 0L;
    flh = 0L;
    fli = 0L;
    flj = 0L;
    flk = 0;
    AppMethodBeat.o(131814);
  }
  
  public static void Le()
  {
    AppMethodBeat.i(131804);
    kl(512);
    AppMethodBeat.o(131804);
  }
  
  public static void TK()
  {
    AppMethodBeat.i(131801);
    fle = System.currentTimeMillis();
    AppMethodBeat.o(131801);
  }
  
  public static void TL()
  {
    AppMethodBeat.i(131802);
    if (kl(1024))
    {
      s(1L, System.currentTimeMillis() - fle);
      s(2L, 1L);
    }
    AppMethodBeat.o(131802);
  }
  
  public static void TM()
  {
    AppMethodBeat.i(210300);
    kl(512);
    flf = false;
    AppMethodBeat.o(210300);
  }
  
  public static boolean TN()
  {
    AppMethodBeat.i(131809);
    if (!flf)
    {
      AppMethodBeat.o(131809);
      return false;
    }
    boolean bool = kl(256);
    AppMethodBeat.o(131809);
    return bool;
  }
  
  public static void TO()
  {
    AppMethodBeat.i(131813);
    long l = System.currentTimeMillis() - flg;
    a(fkP, l);
    if (l <= 3000L)
    {
      a(fkQ, 1L);
      a(fkI, 1L);
      l = SystemClock.elapsedRealtime() - flh;
      b(fkV, l);
      if (l > 2000L) {
        break label181;
      }
      b(fkW, 1L);
    }
    for (;;)
    {
      b(fkU, 1L);
      fld.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(131813);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(fkR, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(fkS, 1L);
        break;
      }
      a(fkT, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(fkX, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(fkY, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(fkZ, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(fla, 1L);
      } else {
        b(flb, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> TP()
  {
    return flc;
  }
  
  public static ArrayList<Object[]> TQ()
  {
    return fld;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(131807);
    ac.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    r(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.f.a.xF)
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
    ac.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    flc.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(131808);
  }
  
  public static void ez(String paramString)
  {
    AppMethodBeat.i(131803);
    if ((kl(512)) && (ai.eUV().equals(paramString)))
    {
      flf = true;
      ac.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(131803);
  }
  
  private static boolean kl(int paramInt)
  {
    AppMethodBeat.i(131810);
    if ((flk & paramInt) == 0)
    {
      flk = (byte)(flk | paramInt);
      ac.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(131810);
      return true;
    }
    AppMethodBeat.o(131810);
    return false;
  }
  
  public static void km(int paramInt)
  {
    AppMethodBeat.i(131812);
    if (fli == 0L)
    {
      ac.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(131812);
      return;
    }
    long l = System.currentTimeMillis() - fli;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131812);
      return;
      if (kl(1))
      {
        a(fkJ, l);
        fli = System.currentTimeMillis();
        AppMethodBeat.o(131812);
        return;
        if (kl(2))
        {
          a(fkK, l);
          fli = System.currentTimeMillis();
          AppMethodBeat.o(131812);
          return;
          if (kl(4))
          {
            a(fkL, l);
            fli = System.currentTimeMillis();
            AppMethodBeat.o(131812);
            return;
            if (kl(8))
            {
              a(fkM, l);
              fli = System.currentTimeMillis();
              AppMethodBeat.o(131812);
              return;
              if (kl(16))
              {
                oE(l);
                a(fkN, l);
                fli = System.currentTimeMillis();
                AppMethodBeat.o(131812);
                return;
                if (kl(32))
                {
                  oE(l);
                  a(fkO, l);
                  fli = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void oD(long paramLong)
  {
    AppMethodBeat.i(131805);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      kl(512);
      flf = false;
    }
    AppMethodBeat.o(131805);
  }
  
  private static void oE(long paramLong)
  {
    AppMethodBeat.i(131811);
    if (paramLong > 10000L) {
      TM();
    }
    AppMethodBeat.o(131811);
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
  
  public static void r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131799);
    flc.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(131799);
  }
  
  public static void rp(String paramString)
  {
    AppMethodBeat.i(131798);
    j.uk(paramString);
    AppMethodBeat.o(131798);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131800);
    flc.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(131800);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    flg = paramLong1;
    flh = paramLong2;
    fli = flg;
    flj = flh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */