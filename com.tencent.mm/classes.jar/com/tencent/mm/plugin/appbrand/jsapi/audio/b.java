package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static Object lockObj;
  private static MMHandler mHandler;
  private static volatile HandlerThread rCY;
  private static String rCZ;
  private static AtomicInteger rDa;
  
  static
  {
    AppMethodBeat.i(145694);
    rCZ = "app_brand_audio_player";
    lockObj = new Object();
    rDa = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void ZW(String arg0)
  {
    AppMethodBeat.i(145692);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (rDa.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((rCY != null) && (rCY != null))
        {
          g.bDQ(rCZ);
          rCY.quit();
          rCY = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  public static void ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(145693);
    synchronized (lockObj)
    {
      if (mHandler != null)
      {
        mHandler.post(paramRunnable);
        AppMethodBeat.o(145693);
        return;
      }
      Log.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      cqf();
      mHandler.post(paramRunnable);
    }
  }
  
  private static void cqf()
  {
    AppMethodBeat.i(145691);
    if (rCY == null)
    {
      Object localObject = com.tencent.threadpool.c.d.jx(rCZ, 5);
      rCY = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(rCY.getLooper(), rCZ);
      g.a(rCZ, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new MMHandler(rCY.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (rDa.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        cqf();
        AppMethodBeat.o(145690);
        return;
      }
    }
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */