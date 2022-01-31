package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class ai$a$1
  extends u
{
  ai$a$1(ai.a parama, int paramInt, j paramj, CountDownLatch paramCountDownLatch)
  {
    super(paramInt);
  }
  
  final String aGZ()
  {
    AppMethodBeat.i(131957);
    String str = String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(ai.a.a(this.imD)), Integer.valueOf(ai.a.b(this.imD)) });
    AppMethodBeat.o(131957);
    return str;
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131958);
    this.hqf.value = paramWxaPkgWrappingInfo;
    this.fuC.countDown();
    AppMethodBeat.o(131958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.a.1
 * JD-Core Version:    0.7.0.1
 */