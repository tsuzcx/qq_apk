package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class s$3
  extends o.c
{
  s$3(s params, j paramj, CountDownLatch paramCountDownLatch) {}
  
  public final void a(a.a<ast> parama)
  {
    AppMethodBeat.i(131849);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule without lib url result errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(parama.errCode), parama.errMsg });
    AppMethodBeat.o(131849);
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131850);
    if (paramWxaPkgWrappingInfo != null) {
      this.ilr.value = paramWxaPkgWrappingInfo;
    }
    this.val$latch.countDown();
    if (paramWxaPkgWrappingInfo != null) {}
    for (paramWxaPkgWrappingInfo = paramWxaPkgWrappingInfo.toString();; paramWxaPkgWrappingInfo = "null")
    {
      ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule without codeLib pkgInfo :%s", new Object[] { paramWxaPkgWrappingInfo });
      AppMethodBeat.o(131850);
      return;
    }
  }
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131851);
    if (paramWxaPkgWrappingInfo != null)
    {
      s.oF(2);
      AppMethodBeat.o(131851);
      return;
    }
    s.oF(3);
    AppMethodBeat.o(131851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s.3
 * JD-Core Version:    0.7.0.1
 */