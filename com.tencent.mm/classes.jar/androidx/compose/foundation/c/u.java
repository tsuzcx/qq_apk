package androidx.compose.foundation.c;

import androidx.compose.ui.n.g;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements t
{
  private final float adl;
  private final float adm;
  private final float bottom;
  private final float top;
  
  private u(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.adl = paramFloat1;
    this.top = paramFloat2;
    this.adm = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  public final float a(n paramn)
  {
    AppMethodBeat.i(203973);
    s.u(paramn, "layoutDirection");
    if (paramn == n.beP)
    {
      f = this.adl;
      AppMethodBeat.o(203973);
      return f;
    }
    float f = this.adm;
    AppMethodBeat.o(203973);
    return f;
  }
  
  public final float b(n paramn)
  {
    AppMethodBeat.i(203993);
    s.u(paramn, "layoutDirection");
    if (paramn == n.beP)
    {
      f = this.adm;
      AppMethodBeat.o(203993);
      return f;
    }
    float f = this.adl;
    AppMethodBeat.o(203993);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204019);
    if (!(paramObject instanceof u))
    {
      AppMethodBeat.o(204019);
      return false;
    }
    if ((g.G(this.adl, ((u)paramObject).adl)) && (g.G(this.top, ((u)paramObject).top)) && (g.G(this.adm, ((u)paramObject).adm)) && (g.G(this.bottom, ((u)paramObject).bottom)))
    {
      AppMethodBeat.o(204019);
      return true;
    }
    AppMethodBeat.o(204019);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204027);
    int i = g.ah(this.adl);
    int j = g.ah(this.top);
    int k = g.ah(this.adm);
    int m = g.ah(this.bottom);
    AppMethodBeat.o(204027);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final float mC()
  {
    return this.top;
  }
  
  public final float mD()
  {
    return this.bottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204033);
    String str = "PaddingValues(start=" + g.ak(this.adl) + ", top=" + g.ak(this.top) + ", end=" + g.ak(this.adm) + ", bottom=" + g.ak(this.bottom);
    AppMethodBeat.o(204033);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.u
 * JD-Core Version:    0.7.0.1
 */