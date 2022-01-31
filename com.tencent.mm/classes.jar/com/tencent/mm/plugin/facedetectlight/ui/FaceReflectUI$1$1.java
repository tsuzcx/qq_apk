package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

final class FaceReflectUI$1$1
  implements Runnable
{
  FaceReflectUI$1$1(FaceReflectUI.1 param1) {}
  
  public final void run()
  {
    Object localObject = (ViewGroup.MarginLayoutParams)FaceReflectUI.c(this.jXU.jXT).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(FaceReflectUI.b(this.jXU.jXT).getWidth() * 0.8D));
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(FaceReflectUI.b(this.jXU.jXT).getWidth() * 0.8D));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(FaceReflectUI.b(this.jXU.jXT).getHeight() * 0.4D - FaceReflectUI.b(this.jXU.jXT).getWidth() * 0.4D));
    FaceReflectUI.c(this.jXU.jXT).setLayoutParams((ViewGroup.LayoutParams)localObject);
    FaceReflectUI.c(this.jXU.jXT).setVisibility(0);
    FaceReflectUI.d(this.jXU.jXT).setVisibility(0);
    FaceReflectUI.e(this.jXU.jXT).setVisibility(0);
    localObject = this.jXU.jXT;
    y.i("MicroMsg.FaceReflectUI", "beginLoadAnimation()");
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setAnimationListener(new FaceReflectUI.3((FaceReflectUI)localObject));
    ((FaceReflectUI)localObject).jXQ.startAnimation(localRotateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI.1.1
 * JD-Core Version:    0.7.0.1
 */