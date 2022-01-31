package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;

public final class d
{
  private static com.tencent.mm.plugin.clean.c.a.b kGD;
  private static long kGI;
  private static long kGJ;
  private static final ak kGR;
  private static HashSet<String> kGS;
  private static ArrayList<b> kGT;
  private static int kGU;
  private static long kGs;
  private static long kGt;
  
  static
  {
    AppMethodBeat.i(18699);
    kGR = new ak();
    kGJ = 0L;
    kGI = 0L;
    kGt = 0L;
    kGs = 0L;
    kGU = 0;
    AppMethodBeat.o(18699);
  }
  
  public static void a(com.tencent.mm.plugin.clean.c.a.b paramb)
  {
    kGD = paramb;
  }
  
  public static void b(HashSet<String> paramHashSet)
  {
    kGS = paramHashSet;
  }
  
  public static com.tencent.mm.plugin.clean.c.a.b bgO()
  {
    boolean bool = true;
    AppMethodBeat.i(18695);
    if (kGD == null) {}
    for (;;)
    {
      ab.d("MicroMsg.CleanLogic", "getThreadController threadController is null? %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.clean.c.a.b localb = kGD;
      AppMethodBeat.o(18695);
      return localb;
      bool = false;
    }
  }
  
  public static HashSet<String> bgP()
  {
    return kGS;
  }
  
  public static ArrayList<b> bgQ()
  {
    return kGT;
  }
  
  public static long bgR()
  {
    return kGJ;
  }
  
  public static long bgS()
  {
    return kGs;
  }
  
  public static long bgT()
  {
    return kGt;
  }
  
  public static long bgU()
  {
    return kGI;
  }
  
  public static final void bgV()
  {
    AppMethodBeat.i(18697);
    ab.i("MicroMsg.CleanLogic", "startCleanDataNow");
    kGR.removeCallbacksAndMessages(null);
    kGJ = 0L;
    kGI = 0L;
    u(null);
    kGU = 0;
    AppMethodBeat.o(18697);
  }
  
  public static final void bgW()
  {
    AppMethodBeat.i(18698);
    ab.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
    kGR.removeCallbacksAndMessages(null);
    kGR.postDelayed(new d.1(), 300000L);
    AppMethodBeat.o(18698);
  }
  
  public static final void bgX()
  {
    kGU += 1;
  }
  
  public static final void bgY()
  {
    kGU -= 1;
  }
  
  public static void iq(long paramLong)
  {
    kGJ = paramLong;
  }
  
  public static void ir(long paramLong)
  {
    kGs = paramLong;
  }
  
  public static void is(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = 0L;
    }
    kGt = l;
  }
  
  public static void it(long paramLong)
  {
    kGI = paramLong;
  }
  
  public static void u(ArrayList<b> paramArrayList)
  {
    boolean bool = true;
    AppMethodBeat.i(18696);
    if (paramArrayList == null) {}
    for (;;)
    {
      ab.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.valueOf(bool) });
      kGT = paramArrayList;
      AppMethodBeat.o(18696);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */