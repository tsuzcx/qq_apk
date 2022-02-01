package androidx.compose.ui.e;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class r
  extends androidx.compose.ui.platform.ae
  implements n
{
  private final b<ae, ah> awy;
  
  public r(b<? super ae, ah> paramb, b<? super ad, ah> paramb1)
  {
    super(paramb1);
    AppMethodBeat.i(205943);
    this.awy = paramb;
    AppMethodBeat.o(205943);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(205981);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(205981);
    return paramf;
  }
  
  public final q a(androidx.compose.ui.h.r paramr, o paramo, long paramLong)
  {
    AppMethodBeat.i(205954);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    paramo = paramo.aw(paramLong);
    paramr = androidx.compose.ui.h.r.a.a(paramr, paramo.width, paramo.height, (b)new a(paramo, this));
    AppMethodBeat.o(205954);
    return paramr;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205967);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(205967);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205978);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(205978);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205972);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(205972);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205957);
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(205957);
      return false;
    }
    boolean bool = s.p(this.awy, ((r)paramObject).awy);
    AppMethodBeat.o(205957);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205960);
    int i = this.awy.hashCode();
    AppMethodBeat.o(205960);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205963);
    String str = "BlockGraphicsLayerModifier(block=" + this.awy + ')';
    AppMethodBeat.o(205963);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<x.a, ah>
  {
    a(x paramx, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.r
 * JD-Core Version:    0.7.0.1
 */