package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    AppMethodBeat.i(201622);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramT = ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
      AppMethodBeat.o(201622);
      return paramT;
    }
    paramT = ObjectAnimator.ofFloat(paramT, new k(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
    AppMethodBeat.o(201622);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.j
 * JD-Core Version:    0.7.0.1
 */