package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.FutureTask;

final class ag$1
  implements d
{
  ag$1(ag paramag, FutureTask paramFutureTask) {}
  
  public final void a(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(131949);
    if (this.imv == paramRunnable) {
      this.imw.ims = bo.aoy();
    }
    AppMethodBeat.o(131949);
  }
  
  public final void b(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(131950);
    if (this.imv == paramRunnable)
    {
      this.imw.imt = bo.aoy();
      this.imw.imu = (this.imw.imt - this.imw.ims);
    }
    AppMethodBeat.o(131950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag.1
 * JD-Core Version:    0.7.0.1
 */