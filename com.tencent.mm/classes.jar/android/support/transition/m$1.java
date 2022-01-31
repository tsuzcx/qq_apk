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
    ImageView.ScaleType localScaleType = (ImageView.ScaleType)this.rd.getTag(z.a.save_scale_type);
    this.rd.setScaleType(localScaleType);
    this.rd.setTag(z.a.save_scale_type, null);
    if (localScaleType == ImageView.ScaleType.MATRIX)
    {
      this.rd.setImageMatrix((Matrix)this.rd.getTag(z.a.save_image_matrix));
      this.rd.setTag(z.a.save_image_matrix, null);
    }
    paramAnimator.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.m.1
 * JD-Core Version:    0.7.0.1
 */