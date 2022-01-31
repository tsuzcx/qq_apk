package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

abstract class s$a
  implements o.b
{
  private int ilv = 0;
  
  private s$a(s params) {}
  
  public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    s.a(this.ilz);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", aGY() + " progress=" + paramWxaPkgLoadProgress.progress);
    long l = aGX();
    if (l == 0L) {
      s.b(this.ilz).set(100);
    }
    for (;;)
    {
      this.ilv = paramWxaPkgLoadProgress.progress;
      s.c(this.ilz);
      return;
      s.b(this.ilz).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.ilv) / (float)l));
    }
  }
  
  abstract long aGX();
  
  abstract String aGY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s.a
 * JD-Core Version:    0.7.0.1
 */