package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

final class j
{
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
    }
    return ObjectAnimator.ofFloat(paramT, new k(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.j
 * JD-Core Version:    0.7.0.1
 */