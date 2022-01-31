package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletFaceIdDialog$a$2
  implements FrameAnimatorImageView.a
{
  WalletFaceIdDialog$a$2(WalletFaceIdDialog.a parama, int paramInt) {}
  
  public final void onStop()
  {
    AppMethodBeat.i(41397);
    WalletFaceIdDialog.a.d(this.mFH, this.mFI);
    AppMethodBeat.o(41397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.2
 * JD-Core Version:    0.7.0.1
 */