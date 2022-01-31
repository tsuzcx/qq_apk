package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class cb
{
  private static long fnZ = 0L;
  
  public static long abp()
  {
    AppMethodBeat.i(58137);
    if (ah.brt())
    {
      g.RM();
      if (g.RJ().QU()) {}
    }
    else
    {
      AppMethodBeat.o(58137);
      return 0L;
    }
    try
    {
      long l = abq();
      AppMethodBeat.o(58137);
      return l;
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      AppMethodBeat.o(58137);
    }
    return 0L;
  }
  
  public static long abq()
  {
    AppMethodBeat.i(58139);
    long l2 = SystemClock.elapsedRealtime();
    g.RM();
    long l3 = g.RL().Ru().a(ac.a.yGp, l2);
    g.RM();
    long l1 = g.RL().Ru().a(ac.a.yGo, 0L);
    l2 = Math.max(0L, l2 - l3);
    ab.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + fnZ + " offset:" + l2);
    if (0L < l1)
    {
      AppMethodBeat.o(58139);
      return l2 + l1;
    }
    l1 = System.currentTimeMillis();
    AppMethodBeat.o(58139);
    return l1;
  }
  
  public static int abr()
  {
    AppMethodBeat.i(58140);
    int i = (int)(abq() / 1000L);
    AppMethodBeat.o(58140);
    return i;
  }
  
  public static void gy(long paramLong)
  {
    AppMethodBeat.i(58138);
    long l = SystemClock.elapsedRealtime();
    fnZ = Math.max(paramLong, fnZ);
    g.RM();
    g.RL().Ru().set(ac.a.yGo, Long.valueOf(fnZ));
    g.RM();
    g.RL().Ru().set(ac.a.yGp, Long.valueOf(l));
    ab.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", new Object[] { Long.valueOf(l), Long.valueOf(fnZ) });
    AppMethodBeat.o(58138);
  }
  
  public static long gz(long paramLong)
  {
    AppMethodBeat.i(58141);
    long l = abq() / 1000L;
    AppMethodBeat.o(58141);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cb
 * JD-Core Version:    0.7.0.1
 */