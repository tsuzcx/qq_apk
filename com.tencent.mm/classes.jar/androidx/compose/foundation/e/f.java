package androidx.compose.foundation.e;

import androidx.compose.ui.d.g;
import androidx.compose.ui.d.i;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.ak;
import androidx.compose.ui.e.ak.b;
import androidx.compose.ui.e.ak.c;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public f(b paramb1, b paramb2, b paramb3, b paramb4)
  {
    super(paramb1, paramb2, paramb3, paramb4);
    AppMethodBeat.i(203665);
    AppMethodBeat.o(203665);
  }
  
  public final ak a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, n paramn)
  {
    AppMethodBeat.i(203674);
    s.u(paramn, "layoutDirection");
    if (paramFloat1 + paramFloat2 + paramFloat3 + paramFloat4 == 0.0F) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramn = (ak)new ak.b(l.V(paramLong));
      AppMethodBeat.o(203674);
      return paramn;
    }
    g localg = l.V(paramLong);
    float f;
    label98:
    long l1;
    label118:
    long l2;
    if (paramn == n.beP)
    {
      f = paramFloat1;
      paramLong = androidx.compose.ui.d.b.v(f, f);
      if (paramn != n.beP) {
        break label211;
      }
      l1 = androidx.compose.ui.d.b.v(paramFloat2, paramFloat2);
      if (paramn != n.beP) {
        break label217;
      }
      paramFloat1 = paramFloat3;
      l2 = androidx.compose.ui.d.b.v(paramFloat1, paramFloat1);
      if (paramn != n.beP) {
        break label223;
      }
    }
    for (;;)
    {
      long l3 = androidx.compose.ui.d.b.v(paramFloat4, paramFloat4);
      s.u(localg, "rect");
      paramn = (ak)new ak.c(new i(localg.left, localg.top, localg.right, localg.bottom, paramLong, l1, l2, l3, (byte)0));
      AppMethodBeat.o(203674);
      return paramn;
      f = paramFloat2;
      break;
      label211:
      paramFloat2 = paramFloat1;
      break label98;
      label217:
      paramFloat1 = paramFloat4;
      break label118;
      label223:
      paramFloat4 = paramFloat3;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203690);
    if (this == paramObject)
    {
      AppMethodBeat.o(203690);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(203690);
      return false;
    }
    if (!s.p(mS(), ((f)paramObject).mS()))
    {
      AppMethodBeat.o(203690);
      return false;
    }
    if (!s.p(mT(), ((f)paramObject).mT()))
    {
      AppMethodBeat.o(203690);
      return false;
    }
    if (!s.p(mU(), ((f)paramObject).mU()))
    {
      AppMethodBeat.o(203690);
      return false;
    }
    if (!s.p(mV(), ((f)paramObject).mV()))
    {
      AppMethodBeat.o(203690);
      return false;
    }
    AppMethodBeat.o(203690);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203697);
    int i = mS().hashCode();
    int j = mT().hashCode();
    int k = mU().hashCode();
    int m = mV().hashCode();
    AppMethodBeat.o(203697);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203683);
    String str = "RoundedCornerShape(topStart = " + mS() + ", topEnd = " + mT() + ", bottomEnd = " + mU() + ", bottomStart = " + mV() + ')';
    AppMethodBeat.o(203683);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e.f
 * JD-Core Version:    0.7.0.1
 */