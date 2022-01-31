package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.protocal.c.ane;
import java.util.concurrent.CountDownLatch;

final class m$1
  implements j.d
{
  m$1(m paramm, k paramk, CountDownLatch paramCountDownLatch) {}
  
  public final void a(a.a<ane> parama)
  {
    if (!m.a(this.gKB))
    {
      m.b(this.gKB);
      this.gKB.alE();
    }
  }
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.gKA.value = paramWxaPkgWrappingInfo;
    this.eeA.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m.1
 * JD-Core Version:    0.7.0.1
 */