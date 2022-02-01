package android.support.design.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a
{
  public static Animator a(c paramc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramc, c.b.jQ, c.a.jP, new c.d[] { new c.d(paramFloat1, paramFloat2, paramFloat3) });
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramc.getRevealInfo();
      if (localObject == null) {
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
      }
      float f = ((c.d)localObject).radius;
      paramc = ViewAnimationUtils.createCircularReveal((View)paramc, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator, paramc });
      return localObject;
    }
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.a
 * JD-Core Version:    0.7.0.1
 */