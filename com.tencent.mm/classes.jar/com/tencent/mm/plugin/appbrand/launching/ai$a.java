package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class ai$a
  implements Callable<WxaPkgWrappingInfo>
{
  private final int imA;
  private final ast imB;
  private final int imz;
  
  private ai$a(ai paramai, int paramInt1, int paramInt2, ast paramast)
  {
    this.imz = paramInt1;
    this.imA = paramInt2;
    this.imB = paramast;
  }
  
  private WxaPkgWrappingInfo aHh()
  {
    AppMethodBeat.i(131959);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new j();
    ai.a.1 local1 = new ai.a.1(this, this.imC.hcr, (j)localObject, localCountDownLatch);
    if (!p.a(this.imC.appId, this.imz, this.imA, this.imB.cyc, local1))
    {
      AppMethodBeat.o(131959);
      return null;
    }
    try
    {
      localCountDownLatch.await();
      localObject = (WxaPkgWrappingInfo)((j)localObject).value;
      AppMethodBeat.o(131959);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "downloadIncremental semaphore exp ", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.a
 * JD-Core Version:    0.7.0.1
 */