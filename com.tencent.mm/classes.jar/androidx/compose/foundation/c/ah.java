package androidx.compose.foundation.c;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.c;
import androidx.compose.ui.n.l;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/WrapContentModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "equals", "other", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ah
  extends ae
  implements androidx.compose.ui.h.n
{
  private final j acN;
  private final boolean aee;
  private final m<l, androidx.compose.ui.n.n, androidx.compose.ui.n.j> aef;
  private final Object aeg;
  
  public ah(j paramj, boolean paramBoolean, m<? super l, ? super androidx.compose.ui.n.n, androidx.compose.ui.n.j> paramm, Object paramObject, kotlin.g.a.b<? super ad, kotlin.ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203803);
    this.acN = paramj;
    this.aee = false;
    this.aef = paramm;
    this.aeg = paramObject;
    AppMethodBeat.o(203803);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203861);
    paramf = n.a.a((androidx.compose.ui.h.n)this, paramf);
    AppMethodBeat.o(203861);
    return paramf;
  }
  
  public final q a(final r paramr, final o paramo, long paramLong)
  {
    int m = 2147483647;
    final int j = 0;
    AppMethodBeat.i(203817);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    final int i;
    label47:
    int k;
    if (this.acN != j.acJ)
    {
      i = 0;
      if (this.acN == j.acK) {
        break label179;
      }
      if ((this.acN == j.acJ) || (!this.aee)) {
        break label188;
      }
      k = 2147483647;
      label68:
      if ((this.acN == j.acK) || (!this.aee)) {
        break label197;
      }
    }
    for (;;)
    {
      paramo = paramo.aw(c.k(i, k, j, m));
      i = k.bQ(paramo.width, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aU(paramLong));
      j = k.bQ(paramo.height, androidx.compose.ui.n.b.aV(paramLong), androidx.compose.ui.n.b.aW(paramLong));
      paramr = r.a.a(paramr, i, j, (kotlin.g.a.b)new a(this, i, paramo, j, paramr));
      AppMethodBeat.o(203817);
      return paramr;
      i = androidx.compose.ui.n.b.aT(paramLong);
      break;
      label179:
      j = androidx.compose.ui.n.b.aV(paramLong);
      break label47;
      label188:
      k = androidx.compose.ui.n.b.aU(paramLong);
      break label68;
      label197:
      m = androidx.compose.ui.n.b.aW(paramLong);
    }
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203845);
    paramR = n.a.a((androidx.compose.ui.h.n)this, paramR, paramm);
    AppMethodBeat.o(203845);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203856);
    boolean bool = n.a.a((androidx.compose.ui.h.n)this, paramb);
    AppMethodBeat.o(203856);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203852);
    paramR = n.a.b((androidx.compose.ui.h.n)this, paramR, paramm);
    AppMethodBeat.o(203852);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203823);
    if (!(paramObject instanceof ah))
    {
      AppMethodBeat.o(203823);
      return false;
    }
    if ((this.acN == ((ah)paramObject).acN) && (this.aee == ((ah)paramObject).aee) && (s.p(this.aeg, ((ah)paramObject).aeg)))
    {
      AppMethodBeat.o(203823);
      return true;
    }
    AppMethodBeat.o(203823);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203834);
    int i = this.acN.hashCode();
    int j = e..ExternalSyntheticBackport0.m(this.aee);
    int k = this.aeg.hashCode();
    AppMethodBeat.o(203834);
    return (i * 31 + j) * 31 + k;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<x.a, kotlin.ah>
  {
    a(ah paramah, int paramInt1, x paramx, int paramInt2, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.ah
 * JD-Core Version:    0.7.0.1
 */