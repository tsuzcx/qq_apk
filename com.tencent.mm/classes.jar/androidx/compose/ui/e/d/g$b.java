package androidx.compose.ui.e.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "", "x", "", "y", "(FF)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "reset", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g$b
{
  float x = 0.0F;
  float y = 0.0F;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206450);
    if (this == paramObject)
    {
      AppMethodBeat.o(206450);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(206450);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
    {
      AppMethodBeat.o(206450);
      return false;
    }
    if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
    {
      AppMethodBeat.o(206450);
      return false;
    }
    AppMethodBeat.o(206450);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206442);
    int i = Float.floatToIntBits(this.x);
    int j = Float.floatToIntBits(this.y);
    AppMethodBeat.o(206442);
    return i * 31 + j;
  }
  
  public final void reset()
  {
    this.x = 0.0F;
    this.y = 0.0F;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206439);
    String str = "PathPoint(x=" + this.x + ", y=" + this.y + ')';
    AppMethodBeat.o(206439);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.e.d.g.b
 * JD-Core Version:    0.7.0.1
 */