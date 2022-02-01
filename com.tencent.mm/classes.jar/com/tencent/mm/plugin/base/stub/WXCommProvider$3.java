package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

final class WXCommProvider$3
  implements Runnable
{
  WXCommProvider$3(WXCommProvider paramWXCommProvider, jo paramjo) {}
  
  public final void run()
  {
    AppMethodBeat.i(22245);
    if (!a.GpY.l(this.nnl)) {
      ac.e("MicroMsg.WXCommProvider", "handle scan result failed again");
    }
    AppMethodBeat.o(22245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.3
 * JD-Core Version:    0.7.0.1
 */