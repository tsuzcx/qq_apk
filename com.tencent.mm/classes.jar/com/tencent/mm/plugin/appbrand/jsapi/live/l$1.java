package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$1
  implements Runnable
{
  l$1(l paraml, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(96141);
    l.a(this.hNR, this.bHs);
    ab.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + this.bHs + ", orientation:" + l.a(this.hNR));
    l.a(this.hNR, this.bHs, l.a(this.hNR));
    AppMethodBeat.o(96141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l.1
 * JD-Core Version:    0.7.0.1
 */