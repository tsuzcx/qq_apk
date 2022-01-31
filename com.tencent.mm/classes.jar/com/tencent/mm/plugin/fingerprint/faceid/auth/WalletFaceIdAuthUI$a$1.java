package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdAuthUI$a$1
  implements a
{
  WalletFaceIdAuthUI$a$1(WalletFaceIdAuthUI.a parama) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41368);
    ab.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.mFo.mFs.hideProgress();
    if (paramInt == 0)
    {
      this.mFo.byL();
      AppMethodBeat.o(41368);
      return;
    }
    this.mFo.mFs.Oj(this.mFo.mFs.getString(2131297666));
    AppMethodBeat.o(41368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */