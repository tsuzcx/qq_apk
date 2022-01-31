package com.tencent.mm.blink;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

public final class a
{
  public static final int[] dXC;
  public static final int[] dXD;
  public static final int[] dXE;
  public static final int[] dXF;
  public static final int[] dXG;
  public static final int[] dXH;
  public static final int[] dXI;
  public static final int[] dXJ;
  public static final int[] dXK;
  public static final int[] dXL;
  public static final int[] dXM;
  public static final int[] dXN;
  private static final int[] dXO;
  private static final int[] dXP;
  private static final int[] dXQ;
  private static final int[] dXR;
  private static final int[] dXS;
  private static final int[] dXT;
  private static final int[] dXU;
  private static final int[] dXV;
  private static final ArrayList<long[]> dXW;
  private static final ArrayList<Object[]> dXX;
  private static long dXY;
  private static boolean dXZ;
  private static long dYa;
  private static long dYb;
  private static long dYc;
  private static long dYd;
  private static byte dYe;
  
  static
  {
    AppMethodBeat.i(57701);
    dXC = new int[] { 0, 1, 2 };
    dXD = new int[] { 3, 13, 23 };
    dXE = new int[] { 4, 14, 24 };
    dXF = new int[] { 5, 15, 25 };
    dXG = new int[] { 6, 16, 26 };
    dXH = new int[] { 7, 17, 27 };
    dXI = new int[] { 8, 18, 28 };
    dXJ = new int[] { 9, 19, 29 };
    dXK = new int[] { 63, 69, 75 };
    dXL = new int[] { 64, 70, 76 };
    dXM = new int[] { 65, 71, 77 };
    dXN = new int[] { 66, 72, 78 };
    dXO = new int[] { 0 };
    dXP = new int[] { 3 };
    dXQ = new int[] { 9 };
    dXR = new int[] { 10 };
    dXS = new int[] { 11 };
    dXT = new int[] { 12 };
    dXU = new int[] { 13 };
    dXV = new int[] { 14 };
    dXW = new ArrayList();
    dXX = new ArrayList();
    dXY = 0L;
    dXZ = false;
    dYa = 0L;
    dYb = 0L;
    dYc = 0L;
    dYd = 0L;
    dYe = 0;
    AppMethodBeat.o(57701);
  }
  
  public static void BK()
  {
    AppMethodBeat.i(57691);
    ic(512);
    AppMethodBeat.o(57691);
  }
  
  public static void HI()
  {
    AppMethodBeat.i(57688);
    dXY = System.currentTimeMillis();
    AppMethodBeat.o(57688);
  }
  
  public static void HJ()
  {
    AppMethodBeat.i(57689);
    if (ic(1024))
    {
      u(1L, System.currentTimeMillis() - dXY);
      u(2L, 1L);
    }
    AppMethodBeat.o(57689);
  }
  
  public static void HK()
  {
    AppMethodBeat.i(156836);
    ic(512);
    dXZ = false;
    AppMethodBeat.o(156836);
  }
  
  public static boolean HL()
  {
    AppMethodBeat.i(57696);
    if (!dXZ)
    {
      AppMethodBeat.o(57696);
      return false;
    }
    boolean bool = ic(256);
    AppMethodBeat.o(57696);
    return bool;
  }
  
  public static void HM()
  {
    AppMethodBeat.i(57700);
    long l = System.currentTimeMillis() - dYa;
    a(dXJ, l);
    if (l <= 3000L)
    {
      a(dXK, 1L);
      a(dXC, 1L);
      l = SystemClock.elapsedRealtime() - dYb;
      b(dXP, l);
      if (l > 2000L) {
        break label181;
      }
      b(dXQ, 1L);
    }
    for (;;)
    {
      b(dXO, 1L);
      dXX.add(new Object[] { Integer.valueOf(15854), { Long.valueOf(l) } });
      AppMethodBeat.o(57700);
      return;
      if ((l > 3000L) && (l <= 6000L))
      {
        a(dXL, 1L);
        break;
      }
      if ((l > 6000L) && (l <= 10000L))
      {
        a(dXM, 1L);
        break;
      }
      a(dXN, 1L);
      break;
      label181:
      if ((l > 2000L) && (l <= 4000L)) {
        b(dXR, 1L);
      } else if ((l > 4000L) && (l <= 6000L)) {
        b(dXS, 1L);
      } else if ((l > 6000L) && (l <= 8000L)) {
        b(dXT, 1L);
      } else if ((l > 8000L) && (l <= 10000L)) {
        b(dXU, 1L);
      } else {
        b(dXV, 1L);
      }
    }
  }
  
  public static ArrayList<long[]> HN()
  {
    return dXW;
  }
  
  public static ArrayList<Object[]> HO()
  {
    return dXX;
  }
  
  private static void a(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(57694);
    ab.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    t(paramArrayOfInt[0], paramLong);
    if (com.tencent.mm.f.a.qd)
    {
      t(paramArrayOfInt[1], paramLong);
      AppMethodBeat.o(57694);
      return;
    }
    t(paramArrayOfInt[2], paramLong);
    AppMethodBeat.o(57694);
  }
  
  private static void b(int[] paramArrayOfInt, long paramLong)
  {
    AppMethodBeat.i(57695);
    ab.i("MicroMsg.BlinkStartup", "%s %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(paramLong) });
    long l = paramArrayOfInt[0];
    dXW.add(new long[] { 910L, l, paramLong });
    AppMethodBeat.o(57695);
  }
  
  public static void dD(String paramString)
  {
    AppMethodBeat.i(57690);
    if ((ic(512)) && (ah.dsN().equals(paramString)))
    {
      dXZ = true;
      ab.i("MicroMsg.BlinkStartup", "report this time");
    }
    AppMethodBeat.o(57690);
  }
  
  public static void fT(long paramLong)
  {
    AppMethodBeat.i(57692);
    if (System.currentTimeMillis() - paramLong > 200L)
    {
      ic(512);
      dXZ = false;
    }
    AppMethodBeat.o(57692);
  }
  
  private static void fU(long paramLong)
  {
    AppMethodBeat.i(57698);
    if (paramLong > 10000L) {
      HK();
    }
    AppMethodBeat.o(57698);
  }
  
  private static boolean ic(int paramInt)
  {
    AppMethodBeat.i(57697);
    if ((dYe & paramInt) == 0)
    {
      dYe = (byte)(dYe | paramInt);
      ab.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(57697);
      return true;
    }
    AppMethodBeat.o(57697);
    return false;
  }
  
  public static void id(int paramInt)
  {
    AppMethodBeat.i(57699);
    if (dYc == 0L)
    {
      ab.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
      AppMethodBeat.o(57699);
      return;
    }
    long l = System.currentTimeMillis() - dYc;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(57699);
      return;
      if (ic(1))
      {
        a(dXD, l);
        dYc = System.currentTimeMillis();
        AppMethodBeat.o(57699);
        return;
        if (ic(2))
        {
          a(dXE, l);
          dYc = System.currentTimeMillis();
          AppMethodBeat.o(57699);
          return;
          if (ic(4))
          {
            a(dXF, l);
            dYc = System.currentTimeMillis();
            AppMethodBeat.o(57699);
            return;
            if (ic(8))
            {
              a(dXG, l);
              dYc = System.currentTimeMillis();
              AppMethodBeat.o(57699);
              return;
              if (ic(16))
              {
                fU(l);
                a(dXH, l);
                dYc = System.currentTimeMillis();
                AppMethodBeat.o(57699);
                return;
                if (ic(32))
                {
                  fU(l);
                  a(dXI, l);
                  dYc = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void ks(String paramString)
  {
    AppMethodBeat.i(57685);
    j.ks(paramString);
    AppMethodBeat.o(57685);
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(57684);
    j.p(paramString, paramLong);
    AppMethodBeat.o(57684);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(57683);
    j.s(paramLong1, paramLong2);
    AppMethodBeat.o(57683);
  }
  
  public static void t(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(57686);
    dXW.add(new long[] { 709L, paramLong1, paramLong2 });
    AppMethodBeat.o(57686);
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(57687);
    dXW.add(new long[] { 783L, paramLong1, paramLong2 });
    AppMethodBeat.o(57687);
  }
  
  public static void v(long paramLong1, long paramLong2)
  {
    dYa = paramLong1;
    dYb = paramLong2;
    dYc = dYa;
    dYd = dYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.a
 * JD-Core Version:    0.7.0.1
 */