package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.am;
import java.util.concurrent.CountDownLatch;

final class aj$a$2
  extends aj.a.a
{
  aj$a$2(aj.a parama, aj.c paramc, am paramam, k paramk, CountDownLatch paramCountDownLatch)
  {
    super(paramc);
  }
  
  final void b(m paramm)
  {
    if (this.fDN != null) {
      this.fDN.stopTimer();
    }
    this.fDL.value = paramm;
    this.eeA.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.a.2
 * JD-Core Version:    0.7.0.1
 */