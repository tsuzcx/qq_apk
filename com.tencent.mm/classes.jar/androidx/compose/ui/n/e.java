package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  implements d
{
  private final float density;
  private final float fontScale;
  
  public e(float paramFloat1, float paramFloat2)
  {
    this.density = paramFloat1;
    this.fontScale = paramFloat2;
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(204721);
    float f = d.a.a(this, paramInt);
    AppMethodBeat.o(204721);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204731);
    if (this == paramObject)
    {
      AppMethodBeat.o(204731);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(204731);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(Float.valueOf(this.density), Float.valueOf(paramObject.density)))
    {
      AppMethodBeat.o(204731);
      return false;
    }
    if (!s.p(Float.valueOf(this.fontScale), Float.valueOf(paramObject.fontScale)))
    {
      AppMethodBeat.o(204731);
      return false;
    }
    AppMethodBeat.o(204731);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204728);
    int i = Float.floatToIntBits(this.density);
    int j = Float.floatToIntBits(this.fontScale);
    AppMethodBeat.o(204728);
    return i * 31 + j;
  }
  
  public final float mn()
  {
    return this.density;
  }
  
  public final float mo()
  {
    return this.fontScale;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(204718);
    float f = d.a.a(this, paramLong);
    AppMethodBeat.o(204718);
    return f;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204725);
    String str = "DensityImpl(density=" + this.density + ", fontScale=" + this.fontScale + ')';
    AppMethodBeat.o(204725);
    return str;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(204706);
    int i = d.a.b(this, paramFloat);
    AppMethodBeat.o(204706);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(204710);
    paramFloat = d.a.a(this, paramFloat);
    AppMethodBeat.o(204710);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(204714);
    long l = d.a.c(this, paramFloat);
    AppMethodBeat.o(204714);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.e
 * JD-Core Version:    0.7.0.1
 */