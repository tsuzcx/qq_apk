package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class ce
{
  private static boolean hqb = false;
  private static long hqc = 0L;
  
  public static long azH()
  {
    AppMethodBeat.i(132281);
    if (ai.ciE())
    {
      g.agS();
      if (g.agP().afY()) {}
    }
    else
    {
      ac.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = azI();
      AppMethodBeat.o(132281);
      return l;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      AppMethodBeat.o(132281);
    }
    return 0L;
  }
  
  public static long azI()
  {
    AppMethodBeat.i(132283);
    long l2 = SystemClock.elapsedRealtime();
    g.agS();
    long l3 = g.agR().agA().a(ah.a.GMN, l2);
    g.agS();
    long l1 = g.agR().agA().a(ah.a.GMM, 0L);
    l2 = Math.max(0L, l2 - l3);
    ac.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + hqc + " offset:" + l2);
    if (0L < l1)
    {
      AppMethodBeat.o(132283);
      return l2 + l1;
    }
    l1 = System.currentTimeMillis();
    AppMethodBeat.o(132283);
    return l1;
  }
  
  public static long azJ()
  {
    AppMethodBeat.i(162133);
    if (hqb)
    {
      l = azI();
      AppMethodBeat.o(162133);
      return l;
    }
    long l = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l;
  }
  
  public static int azK()
  {
    AppMethodBeat.i(132284);
    int i = (int)(azI() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static void pM(long paramLong)
  {
    AppMethodBeat.i(132282);
    long l = SystemClock.elapsedRealtime();
    hqc = Math.max(paramLong, hqc);
    g.agS();
    g.agR().agA().set(ah.a.GMM, Long.valueOf(hqc));
    g.agS();
    g.agR().agA().set(ah.a.GMN, Long.valueOf(l));
    ac.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", new Object[] { Long.valueOf(l), Long.valueOf(hqc) });
    hqb = true;
    AppMethodBeat.o(132282);
  }
  
  public static long pN(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = azI() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ce
 * JD-Core Version:    0.7.0.1
 */