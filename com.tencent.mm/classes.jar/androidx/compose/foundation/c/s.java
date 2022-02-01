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
import androidx.compose.ui.n.c;
import androidx.compose.ui.n.g;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/PaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "getRtlAware", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "equals", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class s
  extends ae
  implements n
{
  final boolean acV;
  final float adl;
  private final float adm;
  private final float bottom;
  final float top;
  
  private s(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203934);
    this.adl = paramFloat1;
    this.top = paramFloat2;
    this.adm = paramFloat3;
    this.bottom = paramFloat4;
    this.acV = true;
    if (this.adl < 0.0F)
    {
      paramFloat1 = this.adl;
      paramb = g.beI;
      if (!g.G(paramFloat1, g.Ch())) {}
    }
    else if (this.top < 0.0F)
    {
      paramFloat1 = this.top;
      paramb = g.beI;
      if (!g.G(paramFloat1, g.Ch())) {}
    }
    else if (this.adm < 0.0F)
    {
      paramFloat1 = this.adm;
      paramb = g.beI;
      if (!g.G(paramFloat1, g.Ch())) {}
    }
    else
    {
      i = j;
      if (this.bottom < 0.0F)
      {
        paramFloat1 = this.bottom;
        paramb = g.beI;
        if (!g.G(paramFloat1, g.Ch())) {
          break label194;
        }
      }
    }
    label194:
    for (int i = j; i == 0; i = 0)
    {
      paramb = (Throwable)new IllegalArgumentException("Padding must be non-negative".toString());
      AppMethodBeat.o(203934);
      throw paramb;
    }
    AppMethodBeat.o(203934);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203983);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203983);
    return paramf;
  }
  
  public final q a(final r paramr, final o paramo, long paramLong)
  {
    AppMethodBeat.i(203944);
    kotlin.g.b.s.u(paramr, "$receiver");
    kotlin.g.b.s.u(paramo, "measurable");
    int i = paramr.v(this.adl) + paramr.v(this.adm);
    int j = paramr.v(this.top) + paramr.v(this.bottom);
    paramo = paramo.aw(c.a(paramLong, -i, -j));
    paramr = r.a.a(paramr, c.g(paramLong, i + paramo.width), c.h(paramLong, paramo.height + j), (b)new a(this, paramo, paramr));
    AppMethodBeat.o(203944);
    return paramr;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203964);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203964);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203976);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203976);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203971);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203971);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203958);
    if ((paramObject instanceof s)) {}
    for (paramObject = (s)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203958);
      return false;
    }
    if ((g.G(this.adl, paramObject.adl)) && (g.G(this.top, paramObject.top)) && (g.G(this.adm, paramObject.adm)) && (g.G(this.bottom, paramObject.bottom)) && (this.acV == paramObject.acV))
    {
      AppMethodBeat.o(203958);
      return true;
    }
    AppMethodBeat.o(203958);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203951);
    int i = g.ah(this.adl);
    int j = g.ah(this.top);
    int k = g.ah(this.adm);
    int m = g.ah(this.bottom);
    int n = e..ExternalSyntheticBackport0.m(this.acV);
    AppMethodBeat.o(203951);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<x.a, ah>
  {
    a(s params, x paramx, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.s
 * JD-Core Version:    0.7.0.1
 */