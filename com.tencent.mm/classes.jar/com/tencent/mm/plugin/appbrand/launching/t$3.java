package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class t$3
  extends o.c
{
  t$3(t paramt, j paramj, CountDownLatch paramCountDownLatch) {}
  
  public final void a(a.a<ast> parama)
  {
    AppMethodBeat.i(131871);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule without lib url result errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(parama.errCode), parama.errMsg });
    AppMethodBeat.o(131871);
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131872);
    if (paramWxaPkgWrappingInfo != null) {
      this.ilr.value = paramWxaPkgWrappingInfo;
    }
    this.val$latch.countDown();
    if (paramWxaPkgWrappingInfo != null) {}
    for (paramWxaPkgWrappingInfo = paramWxaPkgWrappingInfo.toString();; paramWxaPkgWrappingInfo = "null")
    {
      ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule without codeLib pkgInfo :%s", new Object[] { paramWxaPkgWrappingInfo });
      AppMethodBeat.o(131872);
      return;
    }
  }
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131873);
    if (paramWxaPkgWrappingInfo != null)
    {
      t.oG(4);
      AppMethodBeat.o(131873);
      return;
    }
    t.oG(5);
    AppMethodBeat.o(131873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t.3
 * JD-Core Version:    0.7.0.1
 */