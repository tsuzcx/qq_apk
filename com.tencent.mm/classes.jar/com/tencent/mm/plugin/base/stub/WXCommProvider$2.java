package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WXCommProvider$2
  implements ap.a
{
  WXCommProvider$2(WXCommProvider paramWXCommProvider) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(18163);
    if ((a.ymk != null) && (a.ymk.aq(fd.class))) {
      synchronized (WXCommProvider.access$000())
      {
        ab.i("MicroMsg.WXCommProvider", "The lock was released.");
        WXCommProvider.aMv();
        WXCommProvider.access$000().notifyAll();
        AppMethodBeat.o(18163);
        return false;
      }
    }
    AppMethodBeat.o(18163);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.2
 * JD-Core Version:    0.7.0.1
 */