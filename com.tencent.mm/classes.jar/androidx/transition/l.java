package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
{
  static PropertyValuesHolder a(Property<?, PointF> paramProperty, Path paramPath)
  {
    AppMethodBeat.i(192451);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramProperty = PropertyValuesHolder.ofObject(paramProperty, null, paramPath);
      AppMethodBeat.o(192451);
      return paramProperty;
    }
    paramProperty = PropertyValuesHolder.ofFloat(new k(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
    AppMethodBeat.o(192451);
    return paramProperty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.l
 * JD-Core Version:    0.7.0.1
 */