package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import java.util.concurrent.CountDownLatch;

final class ai$c$1
  extends u
{
  ai$c$1(ai.c paramc, int paramInt, j paramj, CountDownLatch paramCountDownLatch)
  {
    super(paramInt);
  }
  
  final String aGZ()
  {
    return "Zstd";
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131967);
    this.hqf.value = paramWxaPkgWrappingInfo;
    this.fuC.countDown();
    AppMethodBeat.o(131967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.c.1
 * JD-Core Version:    0.7.0.1
 */