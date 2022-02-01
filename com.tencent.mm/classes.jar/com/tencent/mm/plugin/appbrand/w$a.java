package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class w$a
  implements Runnable
{
  private final AtomicBoolean evq;
  
  w$a()
  {
    AppMethodBeat.i(43871);
    this.evq = new AtomicBoolean(false);
    AppMethodBeat.o(43871);
  }
  
  public final void run()
  {
    AppMethodBeat.i(43872);
    if (!this.evq.getAndSet(true))
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
      this.val$runnable.run();
    }
    AppMethodBeat.o(43872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a
 * JD-Core Version:    0.7.0.1
 */