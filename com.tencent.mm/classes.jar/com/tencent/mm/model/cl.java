package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class cl
{
  private static volatile boolean iFZ;
  private static long iGa;
  private static long iGb;
  private static final Object lock;
  
  static
  {
    AppMethodBeat.i(196998);
    iFZ = false;
    iGa = -1L;
    iGb = -1L;
    lock = new Object();
    AppMethodBeat.o(196998);
  }
  
  public static void Af(long paramLong)
  {
    AppMethodBeat.i(132282);
    synchronized (lock)
    {
      if (!iFZ)
      {
        iGa = paramLong;
        iGb = SystemClock.elapsedRealtime();
        iFZ = true;
        ??? = g.aAh().azQ();
        ((ao)???).set(ar.a.ObQ, Long.valueOf(iGa));
        ((ao)???).set(ar.a.ObR, Long.valueOf(iGb));
        AppMethodBeat.o(132282);
        return;
      }
      iGa = Math.max(paramLong, aWA());
    }
  }
  
  public static long aWA()
  {
    AppMethodBeat.i(162133);
    if (iFZ) {
      synchronized (lock)
      {
        l1 = Math.max(0L, SystemClock.elapsedRealtime() - iGb);
        long l2 = iGa;
        AppMethodBeat.o(162133);
        return l1 + l2;
      }
    }
    long l1 = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l1;
  }
  
  public static int aWB()
  {
    AppMethodBeat.i(132284);
    int i = (int)(aWA() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static long aWy()
  {
    AppMethodBeat.i(132281);
    if ((MMApplicationContext.isMainProcess()) && (g.aAi().hrr))
    {
      g.aAi();
      if (g.aAf().azp()) {}
    }
    else
    {
      Log.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = aWA();
      AppMethodBeat.o(132281);
      return l;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      AppMethodBeat.o(132281);
    }
    return 0L;
  }
  
  public static long aWz()
  {
    AppMethodBeat.i(258484);
    long l = aWA();
    AppMethodBeat.o(258484);
    return l;
  }
  
  public static long secondsToNow(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = aWA() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cl
 * JD-Core Version:    0.7.0.1
 */