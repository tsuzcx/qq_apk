package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

abstract class t$a
  implements o.b
{
  private int ilv = 0;
  
  private t$a(t paramt) {}
  
  public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    t.a(this.ilC);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", aGY() + " progress=" + paramWxaPkgLoadProgress.progress);
    long l = aGX();
    if (l == 0L) {
      t.b(this.ilC).set(100);
    }
    for (;;)
    {
      this.ilv = paramWxaPkgLoadProgress.progress;
      t.c(this.ilC);
      return;
      t.b(this.ilC).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.ilv) / (float)l));
    }
  }
  
  abstract long aGX();
  
  abstract String aGY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t.a
 * JD-Core Version:    0.7.0.1
 */