package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static volatile ai gij;
  private static String gik = "app_brand_audio_player";
  private static AtomicInteger gil = new AtomicInteger(0);
  private static Object lockObj = new Object();
  private static ah mHandler;
  
  private static void ahW()
  {
    if (gij == null)
    {
      gij = new ai(gik);
      h localh = new h(gij.mnU.getLooper(), gik);
      g.a(gik, localh);
    }
    mHandler = new ah(gij.mnU.getLooper());
  }
  
  public static void onCreate(String arg0)
  {
    y.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (gil.incrementAndGet() == 1) {
      synchronized (lockObj)
      {
        ahW();
        return;
      }
    }
  }
  
  public static void tP(String arg0)
  {
    y.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (gil.decrementAndGet() == 0) {
      synchronized (lockObj)
      {
        if ((gij != null) && (gij != null))
        {
          g.aeK(gik);
          gij.mnU.quit();
          gij = null;
          mHandler = null;
        }
        return;
      }
    }
  }
  
  public static void y(Runnable paramRunnable)
  {
    synchronized (lockObj)
    {
      if (mHandler != null)
      {
        mHandler.post(paramRunnable);
        return;
      }
      y.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
      ahW();
      mHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.b
 * JD-Core Version:    0.7.0.1
 */