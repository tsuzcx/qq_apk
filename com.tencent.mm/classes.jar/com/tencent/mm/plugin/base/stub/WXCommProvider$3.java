package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.im;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WXCommProvider$3
  implements Runnable
{
  WXCommProvider$3(WXCommProvider paramWXCommProvider, im paramim) {}
  
  public final void run()
  {
    AppMethodBeat.i(18164);
    if (!a.ymk.l(this.jMb)) {
      ab.e("MicroMsg.WXCommProvider", "handle scan result failed again");
    }
    AppMethodBeat.o(18164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.3
 * JD-Core Version:    0.7.0.1
 */