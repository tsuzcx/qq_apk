package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class m$1
  extends AnimatorListenerAdapter
{
  m$1(m paramm, ImageView paramImageView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ImageView.ScaleType localScaleType = (ImageView.ScaleType)this.sa.getTag(2131820665);
    this.sa.setScaleType(localScaleType);
    this.sa.setTag(2131820665, null);
    if (localScaleType == ImageView.ScaleType.MATRIX)
    {
      this.sa.setImageMatrix((Matrix)this.sa.getTag(2131820663));
      this.sa.setTag(2131820663, null);
    }
    paramAnimator.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.transition.m.1
 * JD-Core Version:    0.7.0.1
 */