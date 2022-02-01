package androidx.compose.foundation.c;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.c;
import androidx.compose.ui.n.g;
import androidx.compose.ui.n.g.a;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/UnspecifiedConstraintsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class af
  extends ae
  implements n
{
  private final float minHeight;
  private final float minWidth;
  
  private af(float paramFloat1, float paramFloat2, kotlin.g.a.b<? super ad, ah> paramb)
  {
    super(paramb);
    this.minWidth = paramFloat1;
    this.minHeight = paramFloat2;
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203855);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203855);
    return paramf;
  }
  
  public final q a(r paramr, o paramo, long paramLong)
  {
    AppMethodBeat.i(203812);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    float f = this.minWidth;
    g.a locala = g.beI;
    int i;
    int k;
    if ((!g.G(f, g.Ch())) && (androidx.compose.ui.n.b.aT(paramLong) == 0))
    {
      i = k.qu(k.qv(paramr.v(this.minWidth), androidx.compose.ui.n.b.aU(paramLong)), 0);
      k = androidx.compose.ui.n.b.aU(paramLong);
      f = this.minHeight;
      locala = g.beI;
      if ((g.G(f, g.Ch())) || (androidx.compose.ui.n.b.aV(paramLong) != 0)) {
        break label187;
      }
    }
    label187:
    for (int j = k.qu(k.qv(paramr.v(this.minHeight), androidx.compose.ui.n.b.aW(paramLong)), 0);; j = androidx.compose.ui.n.b.aV(paramLong))
    {
      paramo = paramo.aw(c.k(i, k, j, androidx.compose.ui.n.b.aW(paramLong)));
      paramr = r.a.a(paramr, paramo.width, paramo.height, (kotlin.g.a.b)new af.a(paramo));
      AppMethodBeat.o(203812);
      return paramr;
      i = androidx.compose.ui.n.b.aT(paramLong);
      break;
    }
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203839);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203839);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203850);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203850);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203846);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203846);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203819);
    if (!(paramObject instanceof af))
    {
      AppMethodBeat.o(203819);
      return false;
    }
    if ((g.G(this.minWidth, ((af)paramObject).minWidth)) && (g.G(this.minHeight, ((af)paramObject).minHeight)))
    {
      AppMethodBeat.o(203819);
      return true;
    }
    AppMethodBeat.o(203819);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203826);
    int i = g.ah(this.minWidth);
    int j = g.ah(this.minHeight);
    AppMethodBeat.o(203826);
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.af
 * JD-Core Version:    0.7.0.1
 */