package androidx.compose.foundation.e;

import androidx.compose.ui.d.k;
import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/shape/PercentCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "percent", "", "(F)V", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  implements b
{
  private final float agH;
  
  public e(float paramFloat)
  {
    AppMethodBeat.i(203662);
    this.agH = 50.0F;
    if ((this.agH < 0.0F) || (this.agH > 100.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("The percent should be in the range of [0, 100]");
      AppMethodBeat.o(203662);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(203662);
  }
  
  public final float a(long paramLong, d paramd)
  {
    AppMethodBeat.i(203668);
    s.u(paramd, "density");
    float f1 = k.T(paramLong);
    float f2 = this.agH / 100.0F;
    AppMethodBeat.o(203668);
    return f1 * f2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203695);
    if (this == paramObject)
    {
      AppMethodBeat.o(203695);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(203695);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(Float.valueOf(this.agH), Float.valueOf(paramObject.agH)))
    {
      AppMethodBeat.o(203695);
      return false;
    }
    AppMethodBeat.o(203695);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203684);
    int i = Float.floatToIntBits(this.agH);
    AppMethodBeat.o(203684);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203678);
    String str = "CornerSize(size = " + this.agH + "%)";
    AppMethodBeat.o(203678);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.e
 * JD-Core Version:    0.7.0.1
 */