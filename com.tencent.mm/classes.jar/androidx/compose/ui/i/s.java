package androidx.compose.ui.i;

import androidx.compose.ui.e.am;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.a;
import androidx.compose.ui.h.g;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedLayoutNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/LayoutModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/LayoutModifier;)V", "modifierState", "Landroidx/compose/runtime/MutableState;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "getWrappedByCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "modifierFromState", "onModifierChanged", "", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends b<n>
{
  public static final s.a aPT;
  private static final am aPV;
  private androidx.compose.runtime.an<n> aPU;
  
  static
  {
    AppMethodBeat.i(204489);
    aPT = new s.a((byte)0);
    am localam = androidx.compose.ui.e.i.sN();
    Object localObject = z.awK;
    localam.W(z.ty());
    localam.setStrokeWidth(1.0F);
    localObject = androidx.compose.ui.e.an.axO;
    localam.cC(androidx.compose.ui.e.an.tH());
    aPV = localam;
    AppMethodBeat.o(204489);
  }
  
  public s(j paramj, n paramn)
  {
    super(paramj, (f.c)paramn);
    AppMethodBeat.i(204480);
    AppMethodBeat.o(204480);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(204510);
    kotlin.g.b.s.u(parama, "alignmentLine");
    if (xT().wL().containsKey(parama))
    {
      parama = (Integer)xT().wL().get(parama);
      if (parama == null)
      {
        AppMethodBeat.o(204510);
        return -2147483648;
      }
      i = parama.intValue();
      AppMethodBeat.o(204510);
      return i;
    }
    int i = this.aNN.b(parama);
    if (i == -2147483648)
    {
      AppMethodBeat.o(204510);
      return -2147483648;
    }
    av(true);
    a(xV(), this.zIndex, xS());
    av(false);
    if ((parama instanceof g))
    {
      j = androidx.compose.ui.n.j.bg(this.aNN.xV());
      AppMethodBeat.o(204510);
      return i + j;
    }
    int j = androidx.compose.ui.n.j.bf(this.aNN.xV());
    AppMethodBeat.o(204510);
    return i + j;
  }
  
  public final androidx.compose.ui.h.x aw(long paramLong)
  {
    AppMethodBeat.i(204497);
    j localj = (j)this;
    localj.ay(paramLong);
    a(((n)wb()).a(this.aNN.xh(), (o)this.aNN, paramLong));
    androidx.compose.ui.h.x localx = (androidx.compose.ui.h.x)this;
    x localx1 = localj.aPu;
    if (localx1 != null) {
      localx1.aI(localj.aMV);
    }
    AppMethodBeat.o(204497);
    return localx;
  }
  
  protected final void c(u paramu)
  {
    AppMethodBeat.i(204516);
    kotlin.g.b.s.u(paramu, "canvas");
    this.aNN.e(paramu);
    if (i.q(this.aOb).getShowLayoutBounds()) {
      a(paramu, aPV);
    }
    AppMethodBeat.o(204516);
  }
  
  public final void vV()
  {
    AppMethodBeat.i(204503);
    super.vV();
    androidx.compose.runtime.an localan = this.aPU;
    if (localan != null) {
      localan.setValue(wb());
    }
    AppMethodBeat.o(204503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.s
 * JD-Core Version:    0.7.0.1
 */