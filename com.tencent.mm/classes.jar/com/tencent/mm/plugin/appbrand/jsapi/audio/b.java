package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static volatile HandlerThread kbA;
  private static String kbB;
  private static AtomicInteger kbC;
  private static Object lockObj;
  private static ao mHandler;
  
  static
  {
    AppMethodBeat.i(145694);
    kbB = "app_brand_audio_player";
    lockObj = new Object();
    kbC = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void LP(String arg0)
  {
    AppMethodBeat.i(145692);
    ac.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (kbC.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((kbA != null) && (kbA != null))
        {
          g.aSa(kbB);
          kbA.quit();
          kbA = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  public static void X(Runnable paramRunnable)
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
      ac.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      beZ();
      mHandler.post(paramRunnable);
    }
  }
  
  private static void beZ()
  {
    AppMethodBeat.i(145691);
    if (kbA == null)
    {
      Object localObject = com.tencent.e.c.d.gA(kbB, 5);
      kbA = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(kbA.getLooper(), kbB);
      g.a(kbB, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new ao(kbA.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    ac.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (kbC.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        beZ();
        AppMethodBeat.o(145690);
        return;
      }
    }
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */