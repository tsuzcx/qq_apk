package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static Animator a(c paramc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(209082);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramc, c.b.dth, c.a.dtg, new c.d[] { new c.d(paramFloat1, paramFloat2, paramFloat3) });
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramc.getRevealInfo();
      if (localObject == null)
      {
        paramc = new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        AppMethodBeat.o(209082);
        throw paramc;
      }
      float f = ((c.d)localObject).radius;
      paramc = ViewAnimationUtils.createCircularReveal((View)paramc, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator, paramc });
      AppMethodBeat.o(209082);
      return localObject;
    }
    AppMethodBeat.o(209082);
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.a
 * JD-Core Version:    0.7.0.1
 */