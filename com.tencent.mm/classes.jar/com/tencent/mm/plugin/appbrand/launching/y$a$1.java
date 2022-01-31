package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.u.k;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class y$a$1
  extends n
{
  y$a$1(y.a parama, int paramInt, k paramk, CountDownLatch paramCountDownLatch)
  {
    super(paramInt);
  }
  
  final String alJ()
  {
    return String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(y.a.a(this.gLm)), Integer.valueOf(y.a.b(this.gLm)) });
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.fWF.value = paramWxaPkgWrappingInfo;
    this.eeA.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.a.1
 * JD-Core Version:    0.7.0.1
 */