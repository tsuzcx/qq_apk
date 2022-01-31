package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class FaceReflectUI$4
  implements Animation.AnimationListener
{
  FaceReflectUI$4(FaceReflectUI paramFaceReflectUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.d("MicroMsg.FaceReflectUI", "reflectLoadAnimation, AnimationEnd");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.d("MicroMsg.FaceReflectUI", "reflectLoadAnimation, AnimationStart");
    FaceReflectUI.c(this.jXT).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI.4
 * JD-Core Version:    0.7.0.1
 */