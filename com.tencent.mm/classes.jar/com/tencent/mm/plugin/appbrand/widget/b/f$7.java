package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$7
  implements RatingBar.OnRatingBarChangeListener
{
  public f$7(f paramf) {}
  
  public final void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(134259);
    Object localObject1 = this.jjB;
    if (!((f)localObject1).jju)
    {
      ((f)localObject1).jju = true;
      ((f)localObject1).qn((int)paramFloat);
      Object localObject2 = ObjectAnimator.ofFloat(((f)localObject1).jjw, "alpha", new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject2).addListener(new f.12((f)localObject1));
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(((f)localObject1).jjA, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.addListener(new f.2((f)localObject1));
      paramRatingBar = new AnimatorSet();
      paramRatingBar.playTogether(new Animator[] { localObject2, localObjectAnimator });
      paramRatingBar.setDuration(200L);
      paramRatingBar.setInterpolator(new AccelerateInterpolator());
      localObject2 = ObjectAnimator.ofFloat(((f)localObject1).jjy, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).addListener(new f.3((f)localObject1));
      localObjectAnimator = ObjectAnimator.ofFloat(((f)localObject1).jjz, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.addListener(new f.4((f)localObject1));
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObjectAnimator });
      ((AnimatorSet)localObject1).setDuration(200L);
      ((AnimatorSet)localObject1).setInterpolator(new AccelerateInterpolator());
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playSequentially(new Animator[] { paramRatingBar, localObject1 });
      ((AnimatorSet)localObject2).start();
      AppMethodBeat.o(134259);
      return;
    }
    ((f)localObject1).qn((int)paramFloat);
    if (paramFloat < 1.0F) {
      ((f)localObject1).jjx.setRating(1.0F);
    }
    AppMethodBeat.o(134259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.7
 * JD-Core Version:    0.7.0.1
 */