package androidx.compose.foundation.c;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.g;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/OffsetModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRtlAware", "()Z", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends ae
  implements n
{
  final boolean acV;
  final float x;
  final float y;
  
  private p(float paramFloat1, float paramFloat2, b<? super ad, ah> paramb)
  {
    super(paramb);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.acV = true;
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204037);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(204037);
    return paramf;
  }
  
  public final q a(final r paramr, final o paramo, long paramLong)
  {
    AppMethodBeat.i(203966);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    paramo = paramo.aw(paramLong);
    paramr = r.a.a(paramr, paramo.width, paramo.height, (b)new a(this, paramo, paramr));
    AppMethodBeat.o(203966);
    return paramr;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204011);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(204011);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204030);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(204030);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204023);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(204023);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203977);
    if (this == paramObject)
    {
      AppMethodBeat.o(203977);
      return true;
    }
    if ((paramObject instanceof p)) {}
    for (paramObject = (p)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203977);
      return false;
    }
    if ((g.G(this.x, paramObject.x)) && (g.G(this.y, paramObject.y)) && (this.acV == paramObject.acV))
    {
      AppMethodBeat.o(203977);
      return true;
    }
    AppMethodBeat.o(203977);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203986);
    int i = g.ah(this.x);
    int j = g.ah(this.y);
    int k = e..ExternalSyntheticBackport0.m(this.acV);
    AppMethodBeat.o(203986);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203997);
    String str = "OffsetModifier(x=" + g.ak(this.x) + ", y=" + g.ak(this.y) + ", rtlAware=" + this.acV + ')';
    AppMethodBeat.o(203997);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<x.a, ah>
  {
    a(p paramp, x paramx, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.p
 * JD-Core Version:    0.7.0.1
 */