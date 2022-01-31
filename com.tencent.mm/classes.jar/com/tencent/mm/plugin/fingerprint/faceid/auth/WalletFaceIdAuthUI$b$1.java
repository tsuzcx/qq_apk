package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.widget.Button;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.y;

final class WalletFaceIdAuthUI$b$1
  implements a
{
  WalletFaceIdAuthUI$b$1(WalletFaceIdAuthUI.b paramb) {}
  
  public final void ai(int paramInt, String paramString)
  {
    y.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.kkA.kkD.bka();
    if (paramInt == 0)
    {
      this.kkA.kkD.kkw.setEnabled(true);
      return;
    }
    this.kkA.kkD.Dg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.b.1
 * JD-Core Version:    0.7.0.1
 */