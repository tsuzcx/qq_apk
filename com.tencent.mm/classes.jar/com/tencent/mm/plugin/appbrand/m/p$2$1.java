package com.tencent.mm.plugin.appbrand.m;

import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class p$2$1
  implements NsdManager.ResolveListener
{
  p$2$1(p.2 param2, CountDownLatch paramCountDownLatch) {}
  
  public final void onResolveFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt)
  {
    AppMethodBeat.i(108267);
    this.itE.itC.c(new p.c(paramNsdServiceInfo));
    this.itD.countDown();
    AppMethodBeat.o(108267);
  }
  
  public final void onServiceResolved(NsdServiceInfo paramNsdServiceInfo)
  {
    AppMethodBeat.i(108268);
    this.itE.itC.d(new p.c(paramNsdServiceInfo));
    this.itD.countDown();
    AppMethodBeat.o(108268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.p.2.1
 * JD-Core Version:    0.7.0.1
 */