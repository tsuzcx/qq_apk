package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceActionUI$8
  implements Animation.AnimationListener
{
  FaceActionUI$8(FaceActionUI paramFaceActionUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(104246);
    Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
    Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
    AppMethodBeat.o(104246);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(104247);
    Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationStart");
    AppMethodBeat.o(104247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.8
 * JD-Core Version:    0.7.0.1
 */