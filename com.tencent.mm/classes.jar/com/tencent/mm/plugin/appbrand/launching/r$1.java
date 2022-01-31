package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import java.util.concurrent.CountDownLatch;

final class r$1
  extends o.c
{
  r$1(r paramr, j paramj, CountDownLatch paramCountDownLatch) {}
  
  public final void a(a.a<ast> parama)
  {
    AppMethodBeat.i(131829);
    r.a(this.ils);
    AppMethodBeat.o(131829);
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131828);
    this.ilr.value = paramWxaPkgWrappingInfo;
    this.fuC.countDown();
    AppMethodBeat.o(131828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r.1
 * JD-Core Version:    0.7.0.1
 */