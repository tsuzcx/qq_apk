package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class ce
{
  private static boolean gPB = false;
  private static long gPC = 0L;
  
  public static long asQ()
  {
    AppMethodBeat.i(132281);
    if (aj.cbv())
    {
      g.afC();
      if (g.afz().aeI()) {}
    }
    else
    {
      ad.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = asR();
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
  
  public static long asR()
  {
    AppMethodBeat.i(132283);
    long l2 = SystemClock.elapsedRealtime();
    g.afC();
    long l3 = g.afB().afk().a(ae.a.FoY, l2);
    g.afC();
    long l1 = g.afB().afk().a(ae.a.FoX, 0L);
    l2 = Math.max(0L, l2 - l3);
    ad.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + gPC + " offset:" + l2);
    if (0L < l1)
    {
      AppMethodBeat.o(132283);
      return l2 + l1;
    }
    l1 = System.currentTimeMillis();
    AppMethodBeat.o(132283);
    return l1;
  }
  
  public static long asS()
  {
    AppMethodBeat.i(162133);
    if (gPB)
    {
      l = asR();
      AppMethodBeat.o(162133);
      return l;
    }
    long l = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l;
  }
  
  public static int asT()
  {
    AppMethodBeat.i(132284);
    int i = (int)(asR() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static void lY(long paramLong)
  {
    AppMethodBeat.i(132282);
    long l = SystemClock.elapsedRealtime();
    gPC = Math.max(paramLong, gPC);
    g.afC();
    g.afB().afk().set(ae.a.FoX, Long.valueOf(gPC));
    g.afC();
    g.afB().afk().set(ae.a.FoY, Long.valueOf(l));
    ad.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", new Object[] { Long.valueOf(l), Long.valueOf(gPC) });
    gPB = true;
    AppMethodBeat.o(132282);
  }
  
  public static long lZ(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = asR() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ce
 * JD-Core Version:    0.7.0.1
 */