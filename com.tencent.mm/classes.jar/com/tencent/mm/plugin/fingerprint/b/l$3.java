package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.soter.a.a.a;

final class l$3
  implements ap.a
{
  l$3(l paraml, d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(41511);
    ab.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.isL) });
    l.b(this.mGo).rV(true);
    AppMethodBeat.o(41511);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.3
 * JD-Core Version:    0.7.0.1
 */