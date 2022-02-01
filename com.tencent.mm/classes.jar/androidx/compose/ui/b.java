package androidx.compose.ui;

import androidx.compose.ui.n.k;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/BiasAlignment;", "Landroidx/compose/ui/Alignment;", "horizontalBias", "", "verticalBias", "(FF)V", "getHorizontalBias", "()F", "getVerticalBias", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Horizontal", "Vertical", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private final float atU;
  private final float atV;
  
  public b(float paramFloat1, float paramFloat2)
  {
    this.atU = paramFloat1;
    this.atV = paramFloat2;
  }
  
  public final long a(long paramLong1, long paramLong2, n paramn)
  {
    AppMethodBeat.i(204790);
    s.u(paramn, "layoutDirection");
    float f2 = (l.bi(paramLong2) - l.bi(paramLong1)) / 2.0F;
    float f3 = (l.bj(paramLong2) - l.bj(paramLong1)) / 2.0F;
    if (paramn == n.beP) {}
    for (float f1 = this.atU;; f1 = -1.0F * this.atU)
    {
      float f4 = this.atV;
      paramLong1 = k.am(kotlin.h.a.eH((f1 + 1.0F) * f2), kotlin.h.a.eH((f4 + 1.0F) * f3));
      AppMethodBeat.o(204790);
      return paramLong1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204816);
    if (this == paramObject)
    {
      AppMethodBeat.o(204816);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(204816);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(Float.valueOf(this.atU), Float.valueOf(paramObject.atU)))
    {
      AppMethodBeat.o(204816);
      return false;
    }
    if (!s.p(Float.valueOf(this.atV), Float.valueOf(paramObject.atV)))
    {
      AppMethodBeat.o(204816);
      return false;
    }
    AppMethodBeat.o(204816);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204808);
    int i = Float.floatToIntBits(this.atU);
    int j = Float.floatToIntBits(this.atV);
    AppMethodBeat.o(204808);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204798);
    String str = "BiasAlignment(horizontalBias=" + this.atU + ", verticalBias=" + this.atV + ')';
    AppMethodBeat.o(204798);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/BiasAlignment$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "bias", "", "(F)V", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a.b
  {
    private final float atW;
    
    public a(float paramFloat)
    {
      this.atW = paramFloat;
    }
    
    public final int a(int paramInt1, int paramInt2, n paramn)
    {
      AppMethodBeat.i(204328);
      s.u(paramn, "layoutDirection");
      float f2 = (paramInt2 - paramInt1) / 2.0F;
      if (paramn == n.beP) {}
      for (float f1 = this.atW;; f1 = -1.0F * this.atW)
      {
        paramInt1 = kotlin.h.a.eH((f1 + 1.0F) * f2);
        AppMethodBeat.o(204328);
        return paramInt1;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204353);
      if (this == paramObject)
      {
        AppMethodBeat.o(204353);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(204353);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Float.valueOf(this.atW), Float.valueOf(paramObject.atW)))
      {
        AppMethodBeat.o(204353);
        return false;
      }
      AppMethodBeat.o(204353);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(204345);
      int i = Float.floatToIntBits(this.atW);
      AppMethodBeat.o(204345);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204336);
      String str = "Horizontal(bias=" + this.atW + ')';
      AppMethodBeat.o(204336);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b
 * JD-Core Version:    0.7.0.1
 */