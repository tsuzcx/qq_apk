package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

final class v
{
  private static final y so = new w();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      so = new x();
      return;
    }
  }
  
  static PropertyValuesHolder a(Property<?, PointF> paramProperty, Path paramPath)
  {
    return so.a(paramProperty, paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.v
 * JD-Core Version:    0.7.0.1
 */