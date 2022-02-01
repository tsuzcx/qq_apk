package androidx.compose.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/BiasAlignment$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "bias", "", "(F)V", "align", "", "size", "space", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  implements a.c
{
  private final float atW;
  
  public b$b(float paramFloat)
  {
    this.atW = paramFloat;
  }
  
  public final int Y(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204320);
    paramInt1 = a.eH((paramInt2 - paramInt1) / 2.0F * (1.0F + this.atW));
    AppMethodBeat.o(204320);
    return paramInt1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204333);
    if (this == paramObject)
    {
      AppMethodBeat.o(204333);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(204333);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(Float.valueOf(this.atW), Float.valueOf(paramObject.atW)))
    {
      AppMethodBeat.o(204333);
      return false;
    }
    AppMethodBeat.o(204333);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204330);
    int i = Float.floatToIntBits(this.atW);
    AppMethodBeat.o(204330);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204326);
    String str = "Vertical(bias=" + this.atW + ')';
    AppMethodBeat.o(204326);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.b.b
 * JD-Core Version:    0.7.0.1
 */