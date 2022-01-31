package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static volatile al hBA;
  private static String hBB;
  private static AtomicInteger hBC;
  private static Object lockObj;
  private static ak mHandler;
  
  static
  {
    AppMethodBeat.i(137714);
    hBB = "app_brand_audio_player";
    lockObj = new Object();
    hBC = new AtomicInteger(0);
    AppMethodBeat.o(137714);
  }
  
  public static void BP(String arg0)
  {
    AppMethodBeat.i(137712);
    ab.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (hBC.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((hBA != null) && (hBA != null))
        {
          g.avC(hBB);
          hBA.oNc.quit();
          hBA = null;
          mHandler = null;
        }
        AppMethodBeat.o(137712);
        return;
      }
    }
    AppMethodBeat.o(137712);
  }
  
  public static void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(137713);
    synchronized (lockObj)
    {
      if (mHandler != null)
      {
        mHandler.post(paramRunnable);
        AppMethodBeat.o(137713);
        return;
      }
      ab.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      aBN();
      mHandler.post(paramRunnable);
    }
  }
  
  private static void aBN()
  {
    AppMethodBeat.i(137711);
    if (hBA == null)
    {
      hBA = new al(hBB);
      h localh = new h(hBA.oNc.getLooper(), hBB);
      g.a(hBB, localh);
    }
    mHandler = new ak(hBA.oNc.getLooper());
    AppMethodBeat.o(137711);
  }
  
  public static void onCreate(String arg0)
  {
    AppMethodBeat.i(137710);
    ab.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (hBC.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        aBN();
        AppMethodBeat.o(137710);
        return;
      }
    }
    AppMethodBeat.o(137710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */