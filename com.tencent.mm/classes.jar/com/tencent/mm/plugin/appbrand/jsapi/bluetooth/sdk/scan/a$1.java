package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(94285);
    if (!this.hHn.hHj.get())
    {
      AppMethodBeat.o(94285);
      return;
    }
    if ((this.hHn.hHm != null) && (this.hHn.hHk.size() > 0))
    {
      this.hHn.hHm.aI(this.hHn.hHk);
      this.hHn.hHk.clear();
    }
    this.hHn.mHandler.postDelayed(this.hHn.hHl, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.eAS);
    AppMethodBeat.o(94285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.1
 * JD-Core Version:    0.7.0.1
 */