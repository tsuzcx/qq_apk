package androidx.compose.ui.e.d;

import androidx.compose.ui.e.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "()I", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "", "other", "hashCode", "", "Builder", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.b aAX;
  public final float aAY;
  public final float aAZ;
  public final float aBa;
  public final float aBb;
  final m aBc;
  public final long aBd;
  public final int aBe;
  public final String name;
  
  static
  {
    AppMethodBeat.i(206423);
    aAX = new d.b((byte)0);
    AppMethodBeat.o(206423);
  }
  
  private d(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, m paramm, long paramLong, int paramInt)
  {
    this.name = paramString;
    this.aAY = paramFloat1;
    this.aAZ = paramFloat2;
    this.aBa = paramFloat3;
    this.aBb = paramFloat4;
    this.aBc = paramm;
    this.aBd = paramLong;
    this.aBe = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206428);
    if (this == paramObject)
    {
      AppMethodBeat.o(206428);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!s.p(this.name, ((d)paramObject).name))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!g.G(this.aAY, ((d)paramObject).aAY))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!g.G(this.aAZ, ((d)paramObject).aAZ))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (this.aBa == ((d)paramObject).aBa) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (this.aBb == ((d)paramObject).aBb) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!s.p(this.aBc, ((d)paramObject).aBc))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!z.e(this.aBd, ((d)paramObject).aBd))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    if (!p.C(this.aBe, ((d)paramObject).aBe))
    {
      AppMethodBeat.o(206428);
      return false;
    }
    AppMethodBeat.o(206428);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206433);
    int i = this.name.hashCode();
    int j = g.ah(this.aAY);
    int k = g.ah(this.aAZ);
    int m = Float.floatToIntBits(this.aBa);
    int n = Float.floatToIntBits(this.aBb);
    int i1 = this.aBc.hashCode();
    int i2 = z.I(this.aBd);
    int i3 = p.cG(this.aBe);
    AppMethodBeat.o(206433);
    return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.d
 * JD-Core Version:    0.7.0.1
 */