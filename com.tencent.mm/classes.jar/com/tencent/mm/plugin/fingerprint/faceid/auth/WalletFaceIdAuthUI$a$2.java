package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletFaceIdAuthUI$a$2
  implements DialogInterface.OnClickListener
{
  WalletFaceIdAuthUI$a$2(WalletFaceIdAuthUI.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41369);
    WalletFaceIdAuthUI.a.a(this.mFo);
    AppMethodBeat.o(41369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a.2
 * JD-Core Version:    0.7.0.1
 */