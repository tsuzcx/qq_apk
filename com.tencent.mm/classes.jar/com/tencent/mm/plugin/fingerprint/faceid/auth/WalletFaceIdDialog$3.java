package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdDialog$3
  implements FrameAnimatorImageView.a
{
  WalletFaceIdDialog$3(WalletFaceIdDialog paramWalletFaceIdDialog) {}
  
  public final void onStop()
  {
    AppMethodBeat.i(41395);
    ab.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
    WalletFaceIdDialog.b(this.mFA).a(2130838786, null);
    AppMethodBeat.o(41395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.3
 * JD-Core Version:    0.7.0.1
 */