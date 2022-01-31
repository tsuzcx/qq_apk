package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletFaceIdAuthUI$2
  implements DialogInterface.OnClickListener
{
  WalletFaceIdAuthUI$2(WalletFaceIdAuthUI paramWalletFaceIdAuthUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41367);
    WalletFaceIdAuthUI.a(this.mFn).byG();
    AppMethodBeat.o(41367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.2
 * JD-Core Version:    0.7.0.1
 */