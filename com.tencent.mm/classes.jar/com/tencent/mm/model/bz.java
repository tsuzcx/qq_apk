package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class bz
{
  private static long dXU = 0L;
  
  public static long Is()
  {
    if (ae.cqV())
    {
      g.DQ();
      if (g.DN().Dc()) {
        break label21;
      }
    }
    for (;;)
    {
      return 0L;
      label21:
      long l1 = System.currentTimeMillis();
      try
      {
        g.DQ();
        Object localObject = g.DP().Dz().get(ac.a.uwf, null);
        if (localObject != null)
        {
          long l2 = bk.getLong(localObject.toString(), 0L);
          return l1 - l2;
        }
      }
      catch (Throwable localThrowable)
      {
        y.e("MicroMsg.TimeHelper", localThrowable.getMessage());
      }
    }
    return 0L;
  }
  
  public static long It()
  {
    long l2 = SystemClock.elapsedRealtime();
    g.DQ();
    long l3 = g.DP().Dz().a(ac.a.uwh, l2);
    g.DQ();
    long l1 = g.DP().Dz().a(ac.a.uwg, 0L);
    l2 = Math.max(0L, l2 - l3);
    y.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + dXU + " offset:" + l2);
    if (0L < l1) {
      return l2 + l1;
    }
    return System.currentTimeMillis();
  }
  
  public static void bE(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    dXU = Math.max(paramLong, dXU);
    g.DQ();
    g.DP().Dz().c(ac.a.uwg, Long.valueOf(dXU));
    g.DQ();
    g.DP().Dz().c(ac.a.uwh, Long.valueOf(l));
    y.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", new Object[] { Long.valueOf(l), Long.valueOf(dXU) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */