package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class m
  implements o
{
  public final void a(ImageView paramImageView)
  {
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    paramImageView.setTag(2131820665, localScaleType);
    if (localScaleType == ImageView.ScaleType.MATRIX) {
      paramImageView.setTag(2131820663, paramImageView.getImageMatrix());
    }
    for (;;)
    {
      paramImageView.setImageMatrix(p.ow);
      return;
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  public final void a(ImageView paramImageView, Animator paramAnimator)
  {
    paramAnimator.addListener(new m.1(this, paramImageView));
  }
  
  public final void a(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.m
 * JD-Core Version:    0.7.0.1
 */