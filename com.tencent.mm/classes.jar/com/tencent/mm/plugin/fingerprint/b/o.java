package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  implements k
{
  public final void a(a parama)
  {
    y.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
    if (bk.bl(s.qyz.klM))
    {
      y.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
      parama.ai(-1, "no challenge");
      return;
    }
    parama.ai(0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */