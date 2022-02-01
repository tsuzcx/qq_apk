package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicBoolean;

final class o$a
  implements Runnable
{
  private final AtomicBoolean jzL;
  
  o$a()
  {
    AppMethodBeat.i(43871);
    this.jzL = new AtomicBoolean(false);
    AppMethodBeat.o(43871);
  }
  
  public final void run()
  {
    AppMethodBeat.i(43872);
    if (!this.jzL.getAndSet(true))
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
      this.val$runnable.run();
    }
    AppMethodBeat.o(43872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a
 * JD-Core Version:    0.7.0.1
 */