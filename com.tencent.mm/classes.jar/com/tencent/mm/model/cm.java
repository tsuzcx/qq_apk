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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class cm
{
  private static final Object lock;
  private static volatile boolean lwb;
  private static long lwc;
  private static long lwd;
  
  static
  {
    AppMethodBeat.i(196262);
    lwb = false;
    lwc = -1L;
    lwd = -1L;
    lock = new Object();
    AppMethodBeat.o(196262);
  }
  
  public static void Gm(long paramLong)
  {
    AppMethodBeat.i(132282);
    synchronized (lock)
    {
      if (!lwb)
      {
        lwc = paramLong;
        lwd = SystemClock.elapsedRealtime();
        lwb = true;
        ??? = h.aHG().aHp();
        ((ao)???).set(ar.a.VpT, Long.valueOf(lwc));
        ((ao)???).set(ar.a.VpU, Long.valueOf(lwd));
        MultiProcessMMKV.getMMKV("time").edit().putLong("client_server_time_long", lwc);
        MultiProcessMMKV.getMMKV("time").edit().putLong("client_server_elapsed_time_long", lwd);
        AppMethodBeat.o(132282);
        return;
      }
      lwc = Math.max(paramLong, bfE());
    }
  }
  
  public static long bfC()
  {
    AppMethodBeat.i(132281);
    if ((MMApplicationContext.isMainProcess()) && (h.aHH().kdm))
    {
      h.aHH();
      if (h.aHE().aGM()) {}
    }
    else
    {
      Log.i("MicroMsg.TimeHelper", "account error");
      AppMethodBeat.o(132281);
      return 0L;
    }
    try
    {
      long l = bfE();
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
  
  public static long bfD()
  {
    AppMethodBeat.i(292854);
    long l = bfE();
    AppMethodBeat.o(292854);
    return l;
  }
  
  public static long bfE()
  {
    AppMethodBeat.i(162133);
    if (lwb) {
      synchronized (lock)
      {
        l1 = Math.max(0L, SystemClock.elapsedRealtime() - lwd);
        long l2 = lwc;
        AppMethodBeat.o(162133);
        return l1 + l2;
      }
    }
    long l1 = System.currentTimeMillis();
    AppMethodBeat.o(162133);
    return l1;
  }
  
  public static int bfF()
  {
    AppMethodBeat.i(132284);
    int i = (int)(bfE() / 1000L);
    AppMethodBeat.o(132284);
    return i;
  }
  
  public static long bfG()
  {
    AppMethodBeat.i(196260);
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
        AppMethodBeat.o(196260);
        return l3 + l4;
      }
      l1 = System.currentTimeMillis();
      AppMethodBeat.o(196260);
      return l1;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.TimeHelper", "getCurrentServerTimeNoMMProcess %s", new Object[] { localThrowable.getMessage() });
      l1 = System.currentTimeMillis();
      AppMethodBeat.o(196260);
    }
    return l1;
  }
  
  public static long secondsToNow(long paramLong)
  {
    AppMethodBeat.i(132285);
    long l = bfE() / 1000L;
    AppMethodBeat.o(132285);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cm
 * JD-Core Version:    0.7.0.1
 */