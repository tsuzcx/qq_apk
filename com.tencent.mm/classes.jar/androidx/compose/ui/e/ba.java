package androidx.compose.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "value", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  extends s
{
  public final long value;
  
  private ba(long paramLong)
  {
    super((byte)0);
    this.value = paramLong;
  }
  
  public final void a(long paramLong, am paramam, float paramFloat)
  {
    AppMethodBeat.i(206021);
    kotlin.g.b.s.u(paramam, "p");
    paramam.setAlpha(1.0F);
    int i;
    if (paramFloat == 1.0F)
    {
      i = 1;
      if (i != 0) {
        break label86;
      }
    }
    label86:
    for (paramLong = z.g(this.value, z.ac(this.value) * paramFloat);; paramLong = this.value)
    {
      paramam.W(paramLong);
      if (paramam.sK() != null) {
        paramam.a(null);
      }
      AppMethodBeat.o(206021);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206024);
    if (this == paramObject)
    {
      AppMethodBeat.o(206024);
      return true;
    }
    if (!(paramObject instanceof ba))
    {
      AppMethodBeat.o(206024);
      return false;
    }
    if (!z.e(this.value, ((ba)paramObject).value))
    {
      AppMethodBeat.o(206024);
      return false;
    }
    AppMethodBeat.o(206024);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206029);
    int i = z.I(this.value);
    AppMethodBeat.o(206029);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206036);
    String str = "SolidColor(value=" + z.H(this.value) + ')';
    AppMethodBeat.o(206036);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ba
 * JD-Core Version:    0.7.0.1
 */