package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

final class q
{
  private static final t rh = new r();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      rh = new s();
      return;
    }
  }
  
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    return rh.a(paramT, paramProperty, paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.q
 * JD-Core Version:    0.7.0.1
 */