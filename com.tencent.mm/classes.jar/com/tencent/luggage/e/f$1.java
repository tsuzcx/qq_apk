package com.tencent.luggage.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

final class f$1
  implements Runnable
{
  boolean done = false;
  
  f$1(f paramf, boolean paramBoolean, e parame) {}
  
  public final void run()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    Object localObject2;
    ObjectAnimator localObjectAnimator;
    Object localObject3;
    if ((this.biA.bir.peek() != null) && (this.biy))
    {
      localObject1 = (e)this.biA.bir.peek();
      localObject2 = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F, -(((e)localObject1).getContentView().getWidth() * 0.25F) });
      ((ObjectAnimator)localObject2).setDuration(250L);
      localObjectAnimator = ObjectAnimator.ofFloat(((e)localObject1).getContentView(), "translationX", new float[] { 0.0F });
      localObjectAnimator.setDuration(0L);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject2, localObjectAnimator });
      ((e)localObject1).a((Animator)localObject3, null);
      ((e)this.biA.bir.peek()).pZ();
    }
    this.biz.getContentView().bringToFront();
    this.biz.getContentView().setVisibility(0);
    this.biz.pX();
    Object localObject1 = new f.1.1(this);
    if (this.biy)
    {
      localObject2 = this.biz;
      localObjectAnimator = ObjectAnimator.ofFloat(((e)localObject2).getContentView(), "translationX", new float[] { ((e)localObject2).getContentView().getWidth(), 0.0F });
      localObjectAnimator.setDuration(250L);
      localObject3 = ObjectAnimator.ofFloat(((e)localObject2).getContentView(), "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject3).setDuration(166L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localObject3 });
      ((e)localObject2).a(localAnimatorSet, (Runnable)localObject1);
      return;
    }
    ((Runnable)localObject1).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.e.f.1
 * JD-Core Version:    0.7.0.1
 */