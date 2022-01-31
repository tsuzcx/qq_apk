package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.f;

final class b$1
  implements Runnable
{
  b$1(f paramf, AppBrandPreloadProfiler paramAppBrandPreloadProfiler) {}
  
  public final void run()
  {
    Looper.myQueue().addIdleHandler(new b.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b.1
 * JD-Core Version:    0.7.0.1
 */