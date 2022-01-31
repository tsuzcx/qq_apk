package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.u.k;
import java.util.concurrent.CountDownLatch;

final class m$2
  implements j.c
{
  m$2(m paramm, k paramk, CountDownLatch paramCountDownLatch) {}
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.gKC.value = paramWxaPkgWrappingInfo;
    this.eeA.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m.2
 * JD-Core Version:    0.7.0.1
 */