package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class FaceActionUI$7
  implements Animation.AnimationListener
{
  FaceActionUI$7(FaceActionUI paramFaceActionUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(104246);
    ad.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
    ad.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
    AppMethodBeat.o(104246);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(104247);
    ad.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationStart");
    AppMethodBeat.o(104247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.7
 * JD-Core Version:    0.7.0.1
 */