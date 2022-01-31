package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;

final class FaceReflectUI$5
  implements Runnable
{
  FaceReflectUI$5(FaceReflectUI paramFaceReflectUI, Animation paramAnimation) {}
  
  public final void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceReflectUI.h(this.jXT).getLayoutParams();
    localMarginLayoutParams.width = ((int)(FaceReflectUI.b(this.jXT).getWidth() * 0.7D));
    localMarginLayoutParams.height = ((int)(FaceReflectUI.b(this.jXT).getWidth() * 0.7D));
    localMarginLayoutParams.topMargin = ((int)(FaceReflectUI.b(this.jXT).getHeight() * 0.4D - FaceReflectUI.b(this.jXT).getWidth() * 0.35D));
    FaceReflectUI.h(this.jXT).setLayoutParams(localMarginLayoutParams);
    FaceReflectUI.h(this.jXT).setVisibility(0);
    FaceReflectUI.h(this.jXT).startAnimation(this.jXV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI.5
 * JD-Core Version:    0.7.0.1
 */