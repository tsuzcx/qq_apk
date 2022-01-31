package android.support.v4.view.b;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class f
{
  public static Interpolator c(Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new PathInterpolator(paramPath);
    }
    return new e(paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.b.f
 * JD-Core Version:    0.7.0.1
 */