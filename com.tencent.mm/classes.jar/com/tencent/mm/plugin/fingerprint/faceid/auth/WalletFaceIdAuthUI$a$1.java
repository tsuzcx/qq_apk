package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.y;

final class WalletFaceIdAuthUI$a$1
  implements a
{
  WalletFaceIdAuthUI$a$1(WalletFaceIdAuthUI.a parama) {}
  
  public final void ai(int paramInt, String paramString)
  {
    y.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.kkz.kkD.bka();
    this.kkz.aSs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */