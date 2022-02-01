package androidx.core.g.b;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static Interpolator a(Path paramPath)
  {
    AppMethodBeat.i(195622);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramPath = new PathInterpolator(paramPath);
      AppMethodBeat.o(195622);
      return paramPath;
    }
    paramPath = new a(paramPath);
    AppMethodBeat.o(195622);
    return paramPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.b.b
 * JD-Core Version:    0.7.0.1
 */