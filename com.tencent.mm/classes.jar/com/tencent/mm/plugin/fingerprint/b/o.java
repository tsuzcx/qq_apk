package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  implements l
{
  public final void a(a parama)
  {
    AppMethodBeat.i(41556);
    ab.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
    if (bo.isNullOrNil(x.uli.mGC))
    {
      ab.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
      parama.aC(-1, "no challenge");
      AppMethodBeat.o(41556);
      return;
    }
    parama.aC(0, "");
    AppMethodBeat.o(41556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */