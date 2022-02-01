package androidx.compose.b.a;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import androidx.compose.ui.d.k;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", "F", "FadeInDuration", "", "FadeOutDuration", "RadiusDuration", "getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "material-ripple_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final float akz;
  
  static
  {
    AppMethodBeat.i(201820);
    akz = g.ai(10.0F);
    AppMethodBeat.o(201820);
  }
  
  public static final float a(d paramd, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(201818);
    s.u(paramd, "$this$getRippleEndRadius");
    float f1 = e.M(f.x(k.Q(paramLong), k.R(paramLong))) / 2.0F;
    if (paramBoolean)
    {
      float f2 = paramd.w(akz);
      AppMethodBeat.o(201818);
      return f1 + f2;
    }
    AppMethodBeat.o(201818);
    return f1;
  }
  
  public static final float x(long paramLong)
  {
    AppMethodBeat.i(201812);
    float f = Math.max(k.Q(paramLong), k.R(paramLong));
    AppMethodBeat.o(201812);
    return f * 0.3F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.h
 * JD-Core Version:    0.7.0.1
 */