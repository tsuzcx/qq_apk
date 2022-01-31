package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$1
  implements c
{
  b$a$1(b.a parama) {}
  
  public final void aR(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(b.a.b(this.kkS)) });
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.WalletFaceIdDialog", "identify success");
      b.a.a(this.kkS, paramInt2);
      b.a.b(this.kkS, paramInt2);
      return;
    }
    if (b.a.b(this.kkS) <= 0)
    {
      b.a.c(this.kkS);
      b.a.d(this.kkS);
      return;
    }
    b.a.e(this.kkS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.a.1
 * JD-Core Version:    0.7.0.1
 */