package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class cf
{
  private static boolean hIt = false;
  private static long hIu = 0L;
  
  public static long aCK()
  {
    AppMethodBeat.i(132281);
    if ((aj.cnC()) && (g.ajD().gBW))
    {
      g.ajD();
      if (g.ajA().aiK()) {}
    }
    else
    {
      ad.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = aCL();
      AppMethodBeat.o(132281);
      return l;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      AppMethodBeat.o(132281);
    }
    return 0L;
  }
  
  public static long aCL()
  {
    AppMethodBeat.i(132283);
    long l2 = SystemClock.elapsedRealtime();
    g.ajD();
    long l3 = g.ajC().ajl().a(al.a.Izf, l2);
    g.ajD();
    long l1 = g.ajC().ajl().a(al.a.Ize, 0L);
    l2 = Math.max(0L, l2 - l3);
    ad.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + hIu + " offset:" + l2);
    if (0L < l1)
    {
      AppMethodBeat.o(132283);
      return l2 + l1;
    }
    l1 = System.currentTimeMillis();
    AppMethodBeat.o(132283);
    return l1;
  }
  
  public static long aCM()
  {
    AppMethodBeat.i(162133);
    if (hIt)
    {
      l = aCL();
      AppMethodBeat.o(162133);
      return l;
    }
    long l = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l;
  }
  
  public static int aCN()
  {
    AppMethodBeat.i(132284);
    int i = (int)(aCL() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static void rL(long paramLong)
  {
    AppMethodBeat.i(132282);
    long l = SystemClock.elapsedRealtime();
    hIu = Math.max(paramLong, hIu);
    g.ajD();
    g.ajC().ajl().set(al.a.Ize, Long.valueOf(hIu));
    g.ajD();
    g.ajC().ajl().set(al.a.Izf, Long.valueOf(l));
    ad.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", new Object[] { Long.valueOf(l), Long.valueOf(hIu) });
    hIt = true;
    AppMethodBeat.o(132282);
  }
  
  public static long rM(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = aCL() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cf
 * JD-Core Version:    0.7.0.1
 */