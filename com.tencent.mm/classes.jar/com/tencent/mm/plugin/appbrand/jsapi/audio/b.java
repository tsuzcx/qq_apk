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
  private static volatile HandlerThread ozg;
  private static String ozh;
  private static AtomicInteger ozi;
  
  static
  {
    AppMethodBeat.i(145694);
    ozh = "app_brand_audio_player";
    lockObj = new Object();
    ozi = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void ab(Runnable paramRunnable)
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
      bPZ();
      mHandler.post(paramRunnable);
    }
  }
  
  public static void agY(String arg0)
  {
    AppMethodBeat.i(145692);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (ozi.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((ozg != null) && (ozg != null))
        {
          g.bBw(ozh);
          ozg.quit();
          ozg = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  private static void bPZ()
  {
    AppMethodBeat.i(145691);
    if (ozg == null)
    {
      Object localObject = com.tencent.e.c.d.il(ozh, 5);
      ozg = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(ozg.getLooper(), ozh);
      g.a(ozh, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new MMHandler(ozg.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (ozi.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        bPZ();
        AppMethodBeat.o(145690);
        return;
      }
    }
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */