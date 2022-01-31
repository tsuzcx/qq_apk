package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdDialog$1
  implements View.OnClickListener
{
  WalletFaceIdDialog$1(WalletFaceIdDialog paramWalletFaceIdDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41393);
    ab.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
    paramView = WalletFaceIdDialog.a(this.mFA);
    ab.i("MicroMsg.WalletFaceIdDialog", "click left btn");
    if (paramView.mFF) {
      paramView.onAuthFail(-1);
    }
    for (;;)
    {
      this.mFA.dismiss();
      AppMethodBeat.o(41393);
      return;
      paramView.onAuthCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.1
 * JD-Core Version:    0.7.0.1
 */