package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.ai;

final class p$3
  implements Runnable
{
  p$3(p paramp, String paramString, c.a parama, ai paramai) {}
  
  public final void run()
  {
    if (s.sA(this.dol)) {
      s.a(this.dol, false, new p.3.1(this));
    }
    for (;;)
    {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          p.3.this.fQL.mnU.quit();
          return false;
        }
      });
      return;
      if (this.fQI != null) {
        this.fQI.b(this.fQJ.so(this.dol));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p.3
 * JD-Core Version:    0.7.0.1
 */