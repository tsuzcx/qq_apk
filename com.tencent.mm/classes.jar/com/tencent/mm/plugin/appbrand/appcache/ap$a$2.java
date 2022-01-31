package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.CountDownLatch;

final class ap$a$2
  extends ap.a.a
{
  ap$a$2(ap.a parama, ap.c paramc, ap paramap, j paramj, CountDownLatch paramCountDownLatch)
  {
    super(paramc);
  }
  
  final void b(m paramm)
  {
    AppMethodBeat.i(59484);
    if (this.gWd != null) {
      this.gWd.stopTimer();
    }
    this.gWb.value = paramm;
    this.fuC.countDown();
    AppMethodBeat.o(59484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.a.2
 * JD-Core Version:    0.7.0.1
 */