package androidx.compose.foundation.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"CircleShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCircleShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "RoundedCornerShape", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "RoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/RoundedCornerShape;", "topStart", "topEnd", "bottomEnd", "bottomStart", "RoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/RoundedCornerShape;", "", "percent", "", "topStartPercent", "topEndPercent", "bottomEndPercent", "bottomStartPercent", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final f agI;
  
  static
  {
    AppMethodBeat.i(203686);
    agI = a(c.mW());
    AppMethodBeat.o(203686);
  }
  
  public static final f G(float paramFloat)
  {
    AppMethodBeat.i(203672);
    f localf = a(c.F(paramFloat));
    AppMethodBeat.o(203672);
    return localf;
  }
  
  private static f a(b paramb)
  {
    AppMethodBeat.i(203666);
    s.u(paramb, "corner");
    paramb = new f(paramb, paramb, paramb, paramb);
    AppMethodBeat.o(203666);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.g
 * JD-Core Version:    0.7.0.1
 */