package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$17
  implements RatingBar.OnRatingBarChangeListener
{
  public f$17(f paramf) {}
  
  public final void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(49881);
    Object localObject1 = this.oqB;
    if (!((f)localObject1).GfH)
    {
      ((f)localObject1).GfH = true;
      ((f)localObject1).akp((int)paramFloat);
      Object localObject2 = ObjectAnimator.ofFloat(((f)localObject1).oqv, "alpha", new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject2).addListener(new f.6((f)localObject1));
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(((f)localObject1).Iab, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.addListener(new f.7((f)localObject1));
      paramRatingBar = new AnimatorSet();
      paramRatingBar.playTogether(new Animator[] { localObject2, localObjectAnimator });
      paramRatingBar.setDuration(200L);
      paramRatingBar.setInterpolator(new AccelerateInterpolator());
      localObject2 = ObjectAnimator.ofFloat(((f)localObject1).Iaa, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).addListener(new f.8((f)localObject1));
      localObjectAnimator = ObjectAnimator.ofFloat(((f)localObject1).Iac, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.addListener(new f.9((f)localObject1));
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObjectAnimator });
      ((AnimatorSet)localObject1).setDuration(200L);
      ((AnimatorSet)localObject1).setInterpolator(new AccelerateInterpolator());
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playSequentially(new Animator[] { paramRatingBar, localObject1 });
      ((AnimatorSet)localObject2).start();
      AppMethodBeat.o(49881);
      return;
    }
    ((f)localObject1).akp((int)paramFloat);
    if (paramFloat < 1.0F) {
      ((f)localObject1).HZZ.setRating(1.0F);
    }
    AppMethodBeat.o(49881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.17
 * JD-Core Version:    0.7.0.1
 */