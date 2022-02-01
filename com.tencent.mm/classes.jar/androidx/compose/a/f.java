package androidx.compose.a;

import androidx.compose.a.a.aw;
import androidx.compose.a.a.n;
import androidx.compose.ui.e.a.c;
import androidx.compose.ui.e.z;
import androidx.compose.ui.e.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"ColorToVector", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "Lkotlin/ParameterName;", "name", "colorSpace", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "InverseM1", "", "M1", "VectorConverter", "Landroidx/compose/ui/graphics/Color$Companion;", "getVectorConverter", "(Landroidx/compose/ui/graphics/Color$Companion;)Lkotlin/jvm/functions/Function1;", "multiplyColumn", "", "column", "", "x", "y", "z", "matrix", "animation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final b<c, aw<z, n>> SJ = (b)a.SM;
  private static final float[] SK = { 0.8040574F, 0.02689346F, 0.0458654F, 0.3188387F, 0.9319606F, 0.2629981F, -0.1141942F, 0.05105356F, 0.8399981F };
  private static final float[] SL = { 1.248501F, -0.03285693F, -0.05788311F, -0.4833189F, 1.104451F, -0.319407F, 0.1991037F, -0.07159331F, 1.202023F };
  
  public static final b<c, aw<z, n>> a(z.a parama)
  {
    AppMethodBeat.i(203041);
    s.u(parama, "<this>");
    parama = SJ;
    AppMethodBeat.o(203041);
    return parama;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<c, aw<z, n>>
  {
    public static final a SM;
    
    static
    {
      AppMethodBeat.i(203012);
      SM = new a();
      AppMethodBeat.o(203012);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.f
 * JD-Core Version:    0.7.0.1
 */