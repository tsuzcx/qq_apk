package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

final class l
{
  private static final o rc = new m();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      rc = new n();
      return;
    }
  }
  
  static void a(ImageView paramImageView)
  {
    rc.a(paramImageView);
  }
  
  static void a(ImageView paramImageView, Animator paramAnimator)
  {
    rc.a(paramImageView, paramAnimator);
  }
  
  static void a(ImageView paramImageView, Matrix paramMatrix)
  {
    rc.a(paramImageView, paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.l
 * JD-Core Version:    0.7.0.1
 */