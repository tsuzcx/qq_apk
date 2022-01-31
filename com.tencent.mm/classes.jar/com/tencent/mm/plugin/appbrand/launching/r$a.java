package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

abstract class r$a
  implements o.b
{
  private int ilv = 0;
  
  private r$a(r paramr) {}
  
  public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    r.a(this.ils);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", aGY() + " progress=" + paramWxaPkgLoadProgress.progress);
    long l = aGX();
    if (l == 0L) {
      r.b(this.ils).set(100);
    }
    for (;;)
    {
      this.ilv = paramWxaPkgLoadProgress.progress;
      r.c(this.ils);
      return;
      r.b(this.ils).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.ilv) / (float)l));
    }
  }
  
  abstract long aGX();
  
  abstract String aGY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r.a
 * JD-Core Version:    0.7.0.1
 */