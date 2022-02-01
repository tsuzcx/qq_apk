package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class h$1
  extends AnimatorListenerAdapter
{
  h$1(ImageView paramImageView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ImageView.ScaleType localScaleType = (ImageView.ScaleType)this.Bq.getTag(2131304287);
    this.Bq.setScaleType(localScaleType);
    this.Bq.setTag(2131304287, null);
    if (localScaleType == ImageView.ScaleType.MATRIX)
    {
      this.Bq.setImageMatrix((Matrix)this.Bq.getTag(2131304283));
      this.Bq.setTag(2131304283, null);
    }
    paramAnimator.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.h.1
 * JD-Core Version:    0.7.0.1
 */