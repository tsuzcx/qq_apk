package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final boolean O(long paramLong)
  {
    AppMethodBeat.i(205553);
    float f = e.F(paramLong);
    if ((!Float.isInfinite(f)) && (!Float.isNaN(f)))
    {
      i = 1;
      if (i == 0) {
        break label72;
      }
      f = e.G(paramLong);
      if ((Float.isInfinite(f)) || (Float.isNaN(f))) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label72;
      }
      AppMethodBeat.o(205553);
      return true;
      i = 0;
      break;
    }
    label72:
    AppMethodBeat.o(205553);
    return false;
  }
  
  public static final long x(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205546);
    long l = e.J(Float.floatToIntBits(paramFloat1) << 32 | Float.floatToIntBits(paramFloat2) & 0xFFFFFFFF);
    AppMethodBeat.o(205546);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.f
 * JD-Core Version:    0.7.0.1
 */