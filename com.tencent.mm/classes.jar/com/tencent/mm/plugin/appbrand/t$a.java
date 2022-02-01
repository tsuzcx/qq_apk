package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class t$a
  implements Runnable
{
  private final AtomicBoolean nwY;
  
  t$a()
  {
    AppMethodBeat.i(43871);
    this.nwY = new AtomicBoolean(false);
    AppMethodBeat.o(43871);
  }
  
  public final void run()
  {
    AppMethodBeat.i(43872);
    if (!this.nwY.getAndSet(true))
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
      this.val$runnable.run();
    }
    AppMethodBeat.o(43872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */