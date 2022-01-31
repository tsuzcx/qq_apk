package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class FaceReflectUI$3
  implements Animation.AnimationListener
{
  FaceReflectUI$3(FaceReflectUI paramFaceReflectUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.d("MicroMsg.FaceReflectUI", "beginLoadAnimation, AnimationEnd");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    y.d("MicroMsg.FaceReflectUI", "beginLoadAnimation, AnimationRepeat");
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.d("MicroMsg.FaceReflectUI", "beginLoadAnimation, AnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI.3
 * JD-Core Version:    0.7.0.1
 */