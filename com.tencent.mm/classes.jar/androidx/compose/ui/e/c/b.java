package androidx.compose.ui.e.c;

import androidx.compose.ui.d.k;
import androidx.compose.ui.d.k.a;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/painter/ColorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "getColor-0d7_KjU", "()J", "J", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  private final long aAD;
  private float alpha;
  private aa auz;
  private final long ayn;
  
  private b(long paramLong)
  {
    AppMethodBeat.i(205952);
    this.ayn = paramLong;
    this.alpha = 1.0F;
    k.a locala = k.avA;
    this.aAD = k.sw();
    AppMethodBeat.o(205952);
  }
  
  protected final boolean S(float paramFloat)
  {
    this.alpha = paramFloat;
    return true;
  }
  
  protected final void b(e parame)
  {
    AppMethodBeat.i(205958);
    s.u(parame, "<this>");
    e.b.a(parame, this.ayn, 0L, 0L, this.alpha, null, this.auz, 0, 86);
    AppMethodBeat.o(205958);
  }
  
  protected final boolean c(aa paramaa)
  {
    this.auz = paramaa;
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205964);
    if (this == paramObject)
    {
      AppMethodBeat.o(205964);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(205964);
      return false;
    }
    if (!z.e(this.ayn, ((b)paramObject).ayn))
    {
      AppMethodBeat.o(205964);
      return false;
    }
    AppMethodBeat.o(205964);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205970);
    int i = z.I(this.ayn);
    AppMethodBeat.o(205970);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205973);
    String str = "ColorPainter(color=" + z.H(this.ayn) + ')';
    AppMethodBeat.o(205973);
    return str;
  }
  
  public final long uM()
  {
    return this.aAD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.c.b
 * JD-Core Version:    0.7.0.1
 */