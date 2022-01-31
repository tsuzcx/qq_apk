package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.a;

final class WalletFaceIdAuthUI$c$1
  implements a
{
  WalletFaceIdAuthUI$c$1(WalletFaceIdAuthUI.c paramc) {}
  
  public final void aC(int paramInt, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(41384);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
      this.mFt.mFs.doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 19), false);
      paramString = h.qsU;
      paramInt = i;
      if (this.mFt.byI() == 1) {
        paramInt = 1;
      }
      paramString.e(15817, new Object[] { Integer.valueOf(paramInt) });
      h.qsU.cT(916, 1);
      AppMethodBeat.o(41384);
      return;
    }
    this.mFt.mFs.hideProgress();
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
    this.mFt.mFs.Oj(this.mFt.mFs.getString(2131299650));
    h.qsU.cT(916, 2);
    AppMethodBeat.o(41384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c.1
 * JD-Core Version:    0.7.0.1
 */