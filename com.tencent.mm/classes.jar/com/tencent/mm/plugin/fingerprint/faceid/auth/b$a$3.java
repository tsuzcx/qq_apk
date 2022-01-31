package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$3
  implements Animation.AnimationListener
{
  b$a$3(b.a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.d("MicroMsg.WalletFaceIdDialog", "fail anim end");
    b.a.f(this.kkS);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.d("MicroMsg.WalletFaceIdDialog", "fail anim start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.a.3
 * JD-Core Version:    0.7.0.1
 */