package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;

public final class d
{
  private static long iBB;
  private static long iBC;
  private static final ah iBK = new ah();
  private static HashSet<String> iBL;
  private static ArrayList<b> iBM;
  private static int iBN = 0;
  private static long iBl;
  private static long iBm;
  private static com.tencent.mm.plugin.clean.c.a.b iBw;
  
  static
  {
    iBC = 0L;
    iBB = 0L;
    iBm = 0L;
    iBl = 0L;
  }
  
  public static void a(com.tencent.mm.plugin.clean.c.a.b paramb)
  {
    iBw = paramb;
  }
  
  public static com.tencent.mm.plugin.clean.c.a.b aDO()
  {
    boolean bool = true;
    if (iBw == null) {}
    for (;;)
    {
      y.d("MicroMsg.CleanLogic", "getThreadController threadController is null? %b", new Object[] { Boolean.valueOf(bool) });
      return iBw;
      bool = false;
    }
  }
  
  public static HashSet<String> aDP()
  {
    return iBL;
  }
  
  public static ArrayList<b> aDQ()
  {
    return iBM;
  }
  
  public static long aDR()
  {
    return iBC;
  }
  
  public static long aDS()
  {
    return iBl;
  }
  
  public static long aDT()
  {
    return iBm;
  }
  
  public static long aDU()
  {
    return iBB;
  }
  
  public static final void aDV()
  {
    y.i("MicroMsg.CleanLogic", "startCleanDataNow");
    iBK.removeCallbacksAndMessages(null);
    iBC = 0L;
    iBB = 0L;
    p(null);
    iBN = 0;
  }
  
  public static final void aDW()
  {
    y.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
    iBK.removeCallbacksAndMessages(null);
    iBK.postDelayed(new d.1(), 300000L);
  }
  
  public static final void aDX()
  {
    iBN += 1;
  }
  
  public static final void aDY()
  {
    iBN -= 1;
  }
  
  public static void b(HashSet<String> paramHashSet)
  {
    iBL = paramHashSet;
  }
  
  public static void cU(long paramLong)
  {
    iBC = paramLong;
  }
  
  public static void cV(long paramLong)
  {
    iBl = paramLong;
  }
  
  public static void cW(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = 0L;
    }
    iBm = l;
  }
  
  public static void cX(long paramLong)
  {
    iBB = paramLong;
  }
  
  public static void p(ArrayList<b> paramArrayList)
  {
    boolean bool = true;
    if (paramArrayList == null) {}
    for (;;)
    {
      y.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.valueOf(bool) });
      iBM = paramArrayList;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */