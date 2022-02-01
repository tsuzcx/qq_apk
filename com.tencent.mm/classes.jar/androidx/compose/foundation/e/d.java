package androidx.compose.foundation.e;

import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  implements b
{
  private final float size;
  
  private d(float paramFloat)
  {
    this.size = paramFloat;
  }
  
  public final float a(long paramLong, androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(203677);
    s.u(paramd, "density");
    float f = paramd.w(this.size);
    AppMethodBeat.o(203677);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203699);
    if (this == paramObject)
    {
      AppMethodBeat.o(203699);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(203699);
      return false;
    }
    paramObject = (d)paramObject;
    if (!g.G(this.size, paramObject.size))
    {
      AppMethodBeat.o(203699);
      return false;
    }
    AppMethodBeat.o(203699);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203691);
    int i = g.ah(this.size);
    AppMethodBeat.o(203691);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203685);
    String str = "CornerSize(size = " + this.size + ".dp)";
    AppMethodBeat.o(203685);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.d
 * JD-Core Version:    0.7.0.1
 */