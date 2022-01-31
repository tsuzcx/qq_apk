package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdAuthUI$b$1
  implements a
{
  WalletFaceIdAuthUI$b$1(WalletFaceIdAuthUI.b paramb) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41377);
    ab.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.mFp.mFs.hideProgress();
    if (paramInt == 0)
    {
      this.mFp.mFs.mFl.setEnabled(true);
      AppMethodBeat.o(41377);
      return;
    }
    this.mFp.mFs.Oj(this.mFp.mFs.getString(2131297666));
    AppMethodBeat.o(41377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.b.1
 * JD-Core Version:    0.7.0.1
 */