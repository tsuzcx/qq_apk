package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdDialog$2
  implements View.OnClickListener
{
  WalletFaceIdDialog$2(WalletFaceIdDialog paramWalletFaceIdDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41394);
    ab.d("MicroMsg.WalletFaceIdDialog", "click right btn");
    paramView = WalletFaceIdDialog.a(this.mFA);
    ab.i("MicroMsg.WalletFaceIdDialog", "click right btn");
    WalletFaceIdDialog localWalletFaceIdDialog = paramView.mFB;
    localWalletFaceIdDialog.mFv.setEnabled(false);
    localWalletFaceIdDialog.kRB.setText(2131299645);
    paramView.byQ();
    AppMethodBeat.o(41394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.2
 * JD-Core Version:    0.7.0.1
 */