package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdDialog$a$3
  implements Animation.AnimationListener
{
  WalletFaceIdDialog$a$3(WalletFaceIdDialog.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(41399);
    ab.d("MicroMsg.WalletFaceIdDialog", "fail anim end");
    WalletFaceIdDialog.a.e(this.mFH);
    AppMethodBeat.o(41399);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(41398);
    ab.d("MicroMsg.WalletFaceIdDialog", "fail anim start");
    AppMethodBeat.o(41398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.3
 * JD-Core Version:    0.7.0.1
 */