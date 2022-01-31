package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a.a;

final class l$3
  implements am.a
{
  l$3(l paraml, c paramc) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.gQW) });
    l.b(this.klA).oj(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l.3
 * JD-Core Version:    0.7.0.1
 */