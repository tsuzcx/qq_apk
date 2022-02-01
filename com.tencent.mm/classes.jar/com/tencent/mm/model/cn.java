package com.tencent.mm.model;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class cn
{
  private static final Object lock;
  private static volatile boolean onA;
  private static long onB;
  private static long onC;
  
  static
  {
    AppMethodBeat.i(241985);
    onA = false;
    onB = -1L;
    onC = -1L;
    lock = new Object();
    AppMethodBeat.o(241985);
  }
  
  public static long bDu()
  {
    AppMethodBeat.i(132281);
    if ((MMApplicationContext.isMainProcess()) && (h.baF().mDv))
    {
      h.baF();
      if (h.baC().aZN()) {}
    }
    else
    {
      Log.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = bDw();
      AppMethodBeat.o(132281);
      return l;
    }
    finally
    {
      Log.e("MicroMsg.TimeHelper", localObject.getMessage());
      AppMethodBeat.o(132281);
    }
    return 0L;
  }
  
  public static long bDv()
  {
    AppMethodBeat.i(369590);
    long l = bDw();
    AppMethodBeat.o(369590);
    return l;
  }
  
  public static long bDw()
  {
    AppMethodBeat.i(162133);
    if (onA) {
      synchronized (lock)
      {
        l1 = Math.max(0L, SystemClock.elapsedRealtime() - onC);
        long l2 = onB;
        AppMethodBeat.o(162133);
        return l1 + l2;
      }
    }
    long l1 = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l1;
  }
  
  public static long bDx()
  {
    AppMethodBeat.i(241982);
    long l1;
    try
    {
      l1 = SystemClock.elapsedRealtime();
      long l2 = MultiProcessMMKV.getMMKV("time").getLong("client_server_elapsed_time_long", l1);
      long l3 = MultiProcessMMKV.getMMKV("time").getLong("client_server_time_long", 0L);
      long l4 = Math.max(0L, l1 - l2);
      Log.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] lastServerTime:" + l3 + " curElapsedRealTime: " + l1 + " SyncServerTime:" + l2 + " offset:" + l4);
      if (0L < l3)
      {
        AppMethodBeat.o(241982);
        return l3 + l4;
      }
      l1 = System.currentTimeMillis();
      AppMethodBeat.o(241982);
      return l1;
    }
    finally
    {
      Log.e("MicroMsg.TimeHelper", "getCurrentServerTimeNoMMProcess %s", new Object[] { localObject.getMessage() });
      l1 = System.currentTimeMillis();
      AppMethodBeat.o(241982);
    }
    return l1;
  }
  
  public static int getSyncServerTimeSecond()
  {
    AppMethodBeat.i(132284);
    int i = (int)(bDw() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static void iw(long paramLong)
  {
    AppMethodBeat.i(132282);
    synchronized (lock)
    {
      if (!onA)
      {
        onB = paramLong;
        onC = SystemClock.elapsedRealtime();
        onA = true;
        ??? = h.baE().ban();
        ((aq)???).set(at.a.acRv, Long.valueOf(onB));
        ((aq)???).set(at.a.acRw, Long.valueOf(onC));
        MultiProcessMMKV.getMMKV("time").edit().putLong("client_server_time_long", onB);
        MultiProcessMMKV.getMMKV("time").edit().putLong("client_server_elapsed_time_long", onC);
        AppMethodBeat.o(132282);
        return;
      }
      onB = Math.max(paramLong, bDw());
    }
  }
  
  public static long secondsToNow(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = bDw() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cn
 * JD-Core Version:    0.7.0.1
 */