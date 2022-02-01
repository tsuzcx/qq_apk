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
  private static volatile HandlerThread lDE;
  private static String lDF;
  private static AtomicInteger lDG;
  private static Object lockObj;
  private static MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(145694);
    lDF = "app_brand_audio_player";
    lockObj = new Object();
    lDG = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void Z(Runnable paramRunnable)
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
      bEz();
      mHandler.post(paramRunnable);
    }
  }
  
  public static void Zl(String arg0)
  {
    AppMethodBeat.i(145692);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (lDG.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((lDE != null) && (lDE != null))
        {
          g.boG(lDF);
          lDE.quit();
          lDE = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  private static void bEz()
  {
    AppMethodBeat.i(145691);
    if (lDE == null)
    {
      Object localObject = com.tencent.f.c.d.hB(lDF, 5);
      lDE = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(lDE.getLooper(), lDF);
      g.a(lDF, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new MMHandler(lDE.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (lDG.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        bEz();
        AppMethodBeat.o(145690);
        return;
      }
    }
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */