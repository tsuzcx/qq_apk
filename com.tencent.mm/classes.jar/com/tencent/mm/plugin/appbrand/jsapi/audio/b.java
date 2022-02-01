package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static volatile HandlerThread kzl;
  private static String kzm;
  private static AtomicInteger kzn;
  private static Object lockObj;
  private static aq mHandler;
  
  static
  {
    AppMethodBeat.i(145694);
    kzm = "app_brand_audio_player";
    lockObj = new Object();
    kzn = new AtomicInteger(0);
    AppMethodBeat.o(145694);
  }
  
  public static void PR(String arg0)
  {
    AppMethodBeat.i(145692);
    ae.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (kzn.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((kzl != null) && (kzl != null))
        {
          g.aZB(kzm);
          kzl.quit();
          kzl = null;
          mHandler = null;
        }
        AppMethodBeat.o(145692);
        return;
      }
    }
    AppMethodBeat.o(145692);
  }
  
  public static void U(Runnable paramRunnable)
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
      ae.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      bjl();
      mHandler.post(paramRunnable);
    }
  }
  
  private static void bjl()
  {
    AppMethodBeat.i(145691);
    if (kzl == null)
    {
      Object localObject = com.tencent.e.c.d.hh(kzm, 5);
      kzl = (HandlerThread)localObject;
      ((HandlerThread)localObject).start();
      localObject = new h(kzl.getLooper(), kzm);
      g.a(kzm, (com.tencent.mm.vending.h.d)localObject);
    }
    mHandler = new aq(kzl.getLooper());
    AppMethodBeat.o(145691);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(145690);
    ae.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (kzn.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        bjl();
        AppMethodBeat.o(145690);
        return;
      }
    }
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */