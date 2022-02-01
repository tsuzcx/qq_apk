package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final long v(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205520);
    long l = a.J(Float.floatToIntBits(paramFloat1) << 32 | Float.floatToIntBits(paramFloat2) & 0xFFFFFFFF);
    AppMethodBeat.o(205520);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.b
 * JD-Core Version:    0.7.0.1
 */