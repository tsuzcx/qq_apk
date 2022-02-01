package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class ch
{
  private static volatile boolean hLl;
  private static long hLm;
  private static long hLn;
  private static final Object lock;
  
  static
  {
    AppMethodBeat.i(193549);
    hLl = false;
    hLm = -1L;
    hLn = -1L;
    lock = new Object();
    AppMethodBeat.o(193549);
  }
  
  public static long aDa()
  {
    AppMethodBeat.i(132281);
    if ((ak.coh()) && (g.ajS().gED))
    {
      g.ajS();
      if (g.ajP().aiZ()) {}
    }
    else
    {
      ae.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = aDc();
      AppMethodBeat.o(132281);
      return l;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      AppMethodBeat.o(132281);
    }
    return 0L;
  }
  
  public static long aDb()
  {
    AppMethodBeat.i(224419);
    long l = aDc();
    AppMethodBeat.o(224419);
    return l;
  }
  
  public static long aDc()
  {
    AppMethodBeat.i(162133);
    if (hLl) {
      synchronized (lock)
      {
        l1 = Math.max(0L, SystemClock.elapsedRealtime() - hLn);
        long l2 = hLm;
        AppMethodBeat.o(162133);
        return l1 + l2;
      }
    }
    long l1 = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l1;
  }
  
  public static int aDd()
  {
    AppMethodBeat.i(132284);
    int i = (int)(aDc() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static void rY(long paramLong)
  {
    AppMethodBeat.i(132282);
    synchronized (lock)
    {
      if (!hLl)
      {
        hLm = paramLong;
        hLn = SystemClock.elapsedRealtime();
        hLl = true;
        ??? = g.ajR().ajA();
        ((aj)???).set(am.a.ITC, Long.valueOf(hLm));
        ((aj)???).set(am.a.ITD, Long.valueOf(hLn));
        AppMethodBeat.o(132282);
        return;
      }
      hLm = Math.max(paramLong, aDc());
    }
  }
  
  public static long rZ(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = aDc() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ch
 * JD-Core Version:    0.7.0.1
 */