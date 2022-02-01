package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static volatile HandlerThread jBe;
  private static String jBf;
  private static AtomicInteger jBg;
  private static Object lockObj;
  private static ap mHandler;
  
  static
  {
    AppMethodBeat.i(145694);
    jBf = "app_brand_audio_player";
    lockObj = new Object();
    jBg = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void HL(String arg0)
  {
    AppMethodBeat.i(145692);
    ad.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (jBg.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((jBe != null) && (jBe != null))
        {
          g.aMy(jBf);
          jBe.quit();
          jBe = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  public static void V(Runnable paramRunnable)
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
      ad.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      aYc();
      mHandler.post(paramRunnable);
    }
  }
  
  private static void aYc()
  {
    AppMethodBeat.i(145691);
    if (jBe == null)
    {
      Object localObject = com.tencent.e.c.d.gw(jBf, 5);
      jBe = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(jBe.getLooper(), jBf);
      g.a(jBf, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new ap(jBe.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    ad.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (jBg.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        aYc();
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