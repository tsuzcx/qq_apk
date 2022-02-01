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
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/FillModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;FLkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class k
  extends ae
  implements n
{
  private final j acN;
  private final float acO;
  
  public k(j paramj, float paramFloat, kotlin.g.a.b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203956);
    this.acN = paramj;
    this.acO = 1.0F;
    AppMethodBeat.o(203956);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204015);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(204015);
    return paramf;
  }
  
  public final q a(r paramr, o paramo, long paramLong)
  {
    AppMethodBeat.i(203970);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    int j;
    int i;
    int m;
    int k;
    if ((androidx.compose.ui.n.b.aX(paramLong)) && (this.acN != j.acJ))
    {
      j = kotlin.k.k.bQ(a.eH(androidx.compose.ui.n.b.aU(paramLong) * this.acO), androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aU(paramLong));
      i = j;
      if ((!androidx.compose.ui.n.b.aY(paramLong)) || (this.acN == j.acK)) {
        break label175;
      }
      m = kotlin.k.k.bQ(a.eH(androidx.compose.ui.n.b.aW(paramLong) * this.acO), androidx.compose.ui.n.b.aV(paramLong), androidx.compose.ui.n.b.aW(paramLong));
      k = m;
    }
    for (;;)
    {
      paramo = paramo.aw(c.k(j, i, k, m));
      paramr = r.a.a(paramr, paramo.width, paramo.height, (kotlin.g.a.b)new k.a(paramo));
      AppMethodBeat.o(203970);
      return paramr;
      j = androidx.compose.ui.n.b.aT(paramLong);
      i = androidx.compose.ui.n.b.aU(paramLong);
      break;
      label175:
      k = androidx.compose.ui.n.b.aV(paramLong);
      m = androidx.compose.ui.n.b.aW(paramLong);
    }
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203991);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203991);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204007);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(204007);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203998);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203998);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (((paramObject instanceof k)) && (this.acN == ((k)paramObject).acN))
    {
      if (this.acO == ((k)paramObject).acO) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203984);
    int i = this.acN.hashCode();
    int j = Float.floatToIntBits(this.acO);
    AppMethodBeat.o(203984);
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.k
 * JD-Core Version:    0.7.0.1
 */