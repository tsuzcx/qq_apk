package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletFaceIdAuthUI$c$1
  implements a
{
  WalletFaceIdAuthUI$c$1(WalletFaceIdAuthUI.c paramc) {}
  
  public final void ai(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
      this.kkE.kkD.a(new com.tencent.mm.plugin.wallet_core.c.y(null, 19), false, false);
      paramString = h.nFQ;
      if (this.kkE.aSp() == 1) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramString.f(15817, new Object[] { Integer.valueOf(paramInt) });
        h.nFQ.h(916L, 1L, 1L);
        return;
      }
    }
    this.kkE.kkD.bka();
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
    this.kkE.kkD.Dg(this.kkE.kkD.getString(a.i.faceid_open_fail));
    h.nFQ.h(916L, 2L, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c.1
 * JD-Core Version:    0.7.0.1
 */