package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, b.a(this.jSg).getHeight());
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setRepeatMode(2);
    localTranslateAnimation.setRepeatCount(-1);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(-1);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setRepeatCount(-1);
    b.b(this.jSg).startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.b.1
 * JD-Core Version:    0.7.0.1
 */