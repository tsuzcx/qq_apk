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
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class v
  extends ae
  implements n
{
  final t ado;
  
  public v(t paramt, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203892);
    this.ado = paramt;
    AppMethodBeat.o(203892);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203927);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203927);
    return paramf;
  }
  
  public final q a(final r paramr, o paramo, long paramLong)
  {
    AppMethodBeat.i(203903);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    if ((g.I(this.ado.a(paramr.getLayoutDirection()), g.ai(0.0F)) >= 0) && (g.I(this.ado.mC(), g.ai(0.0F)) >= 0) && (g.I(this.ado.b(paramr.getLayoutDirection()), g.ai(0.0F)) >= 0) && (g.I(this.ado.mD(), g.ai(0.0F)) >= 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramr = (Throwable)new IllegalArgumentException("Padding must be non-negative".toString());
      AppMethodBeat.o(203903);
      throw paramr;
    }
    i = paramr.v(this.ado.a(paramr.getLayoutDirection())) + paramr.v(this.ado.b(paramr.getLayoutDirection()));
    int j = paramr.v(this.ado.mC()) + paramr.v(this.ado.mD());
    paramo = paramo.aw(c.a(paramLong, -i, -j));
    paramr = r.a.a(paramr, c.g(paramLong, i + paramo.width), c.h(paramLong, paramo.height + j), (b)new a(paramo, paramr, this));
    AppMethodBeat.o(203903);
    return paramr;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203913);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203913);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203922);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203922);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203917);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203917);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203909);
    if ((paramObject instanceof v)) {}
    for (paramObject = (v)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203909);
      return false;
    }
    boolean bool = s.p(this.ado, paramObject.ado);
    AppMethodBeat.o(203909);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203907);
    int i = this.ado.hashCode();
    AppMethodBeat.o(203907);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<x.a, ah>
  {
    a(x paramx, r paramr, v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.v
 * JD-Core Version:    0.7.0.1
 */