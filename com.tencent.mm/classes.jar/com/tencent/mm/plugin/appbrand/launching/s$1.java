package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;

final class s$1
  extends o.c
{
  s$1(s params, CountDownLatch paramCountDownLatch, String paramString, int paramInt) {}
  
  public final void a(a.a<ast> parama)
  {
    AppMethodBeat.i(131844);
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib url result errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(parama.errCode), parama.errMsg });
    AppMethodBeat.o(131844);
  }
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131845);
    if (paramWxaPkgWrappingInfo != null) {
      ((j)this.ilz.ilw.get(paramWxaPkgWrappingInfo.cqq)).value = paramWxaPkgWrappingInfo;
    }
    this.val$latch.countDown();
    if (paramWxaPkgWrappingInfo != null) {}
    for (paramWxaPkgWrappingInfo = paramWxaPkgWrappingInfo.toString();; paramWxaPkgWrappingInfo = "null")
    {
      ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib pkgInfo :%s", new Object[] { paramWxaPkgWrappingInfo });
      g.dTg().i(new a() {}).dQo();
      AppMethodBeat.o(131845);
      return;
    }
  }
  
  public final void aGU()
  {
    AppMethodBeat.i(131841);
    s.a(this.ilz, 3);
    AppMethodBeat.o(131841);
  }
  
  public final void aGV()
  {
    AppMethodBeat.i(131842);
    s.a(this.ilz, 4);
    AppMethodBeat.o(131842);
  }
  
  public final void aGW()
  {
    AppMethodBeat.i(131843);
    s.a(this.ilz, 2);
    AppMethodBeat.o(131843);
  }
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131846);
    if (paramWxaPkgWrappingInfo != null)
    {
      s.oF(0);
      AppMethodBeat.o(131846);
      return;
    }
    s.oF(1);
    AppMethodBeat.o(131846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s.1
 * JD-Core Version:    0.7.0.1
 */