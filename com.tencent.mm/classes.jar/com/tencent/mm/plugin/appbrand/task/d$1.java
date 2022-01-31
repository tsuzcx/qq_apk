package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.i.r;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements Runnable
{
  d$1(f paramf) {}
  
  public final void run()
  {
    d.aoG().startTime = SystemClock.elapsedRealtime();
    y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
    ai.Fd(-2);
    try
    {
      WxaCommLibRuntimeReader.mT();
      r.alA();
      if (this.fAK == f.hbV)
      {
        d.tf();
        d.IV();
        y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[wagame] misc preload done");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      y.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "skip preload runtime, load CommLib get exception %s", new Object[] { localThrowable });
      d.access$100();
      return;
    }
    d.anZ();
    if (u.aaE())
    {
      d.aoH();
      y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
      return;
    }
    u.a(new d.1.1(this, System.currentTimeMillis()));
    y.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d.1
 * JD-Core Version:    0.7.0.1
 */