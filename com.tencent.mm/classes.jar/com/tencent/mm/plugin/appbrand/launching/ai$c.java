package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class ai$c
  implements Callable<WxaPkgWrappingInfo>
{
  private final ast imB;
  private final int imE;
  
  private ai$c(ai paramai, int paramInt, ast paramast)
  {
    this.imE = paramInt;
    this.imB = paramast;
  }
  
  final WxaPkgWrappingInfo aHi()
  {
    AppMethodBeat.i(131968);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new j();
    ai.c.1 local1 = new ai.c.1(this, this.imC.hcr, (j)localObject, localCountDownLatch);
    if (!be.a(this.imB.xhL, this.imC.appId, this.imE, 0, local1))
    {
      AppMethodBeat.o(131968);
      return null;
    }
    try
    {
      localCountDownLatch.await();
      localObject = (WxaPkgWrappingInfo)((j)localObject).value;
      AppMethodBeat.o(131968);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "doZstdJob semaphore exp ", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.c
 * JD-Core Version:    0.7.0.1
 */