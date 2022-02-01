package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", "z", "(FFF)V", "sum", "(FFFF)V", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "toXyz", "", "toXyz$ui_graphics_release", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  final float x;
  final float y;
  
  public m(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206178);
    if (this == paramObject)
    {
      AppMethodBeat.o(206178);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(206178);
      return false;
    }
    paramObject = (m)paramObject;
    if (!s.p(Float.valueOf(this.x), Float.valueOf(paramObject.x)))
    {
      AppMethodBeat.o(206178);
      return false;
    }
    if (!s.p(Float.valueOf(this.y), Float.valueOf(paramObject.y)))
    {
      AppMethodBeat.o(206178);
      return false;
    }
    AppMethodBeat.o(206178);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206173);
    int i = Float.floatToIntBits(this.x);
    int j = Float.floatToIntBits(this.y);
    AppMethodBeat.o(206173);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206169);
    String str = "WhitePoint(x=" + this.x + ", y=" + this.y + ')';
    AppMethodBeat.o(206169);
    return str;
  }
  
  public final float[] uF()
  {
    return new float[] { this.x / this.y, 1.0F, (1.0F - this.x - this.y) / this.y };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.m
 * JD-Core Version:    0.7.0.1
 */