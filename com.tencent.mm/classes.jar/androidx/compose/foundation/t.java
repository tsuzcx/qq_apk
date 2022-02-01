package androidx.compose.foundation;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/ScrollingLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class t
  implements n
{
  final s ZK;
  final boolean ZL;
  final boolean isVertical;
  
  public t(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203529);
    this.ZK = params;
    this.ZL = paramBoolean1;
    this.isVertical = paramBoolean2;
    AppMethodBeat.o(203529);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203564);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203564);
    return paramf;
  }
  
  public final q a(androidx.compose.ui.h.r paramr, final o paramo, long paramLong)
  {
    AppMethodBeat.i(203540);
    kotlin.g.b.s.u(paramr, "$receiver");
    kotlin.g.b.s.u(paramo, "measurable");
    r.b(paramLong, this.isVertical);
    final int i;
    if (this.isVertical)
    {
      i = 2147483647;
      if (!this.isVertical) {
        break label161;
      }
    }
    label161:
    for (int j = androidx.compose.ui.n.b.aU(paramLong);; j = 2147483647)
    {
      paramo = paramo.aw(androidx.compose.ui.n.b.a(paramLong, 0, j, 0, i, 5));
      j = k.qv(paramo.width, androidx.compose.ui.n.b.aU(paramLong));
      int k = k.qv(paramo.height, androidx.compose.ui.n.b.aW(paramLong));
      int m = paramo.height;
      i = paramo.width - j;
      if (this.isVertical) {
        i = m - k;
      }
      paramr = r.a.a(paramr, j, k, (kotlin.g.a.b)new a(this, i, paramo));
      AppMethodBeat.o(203540);
      return paramr;
      i = androidx.compose.ui.n.b.aW(paramLong);
      break;
    }
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203545);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203545);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203558);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203558);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203553);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203553);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203573);
    if (this == paramObject)
    {
      AppMethodBeat.o(203573);
      return true;
    }
    if (!(paramObject instanceof t))
    {
      AppMethodBeat.o(203573);
      return false;
    }
    paramObject = (t)paramObject;
    if (!kotlin.g.b.s.p(this.ZK, paramObject.ZK))
    {
      AppMethodBeat.o(203573);
      return false;
    }
    if (this.ZL != paramObject.ZL)
    {
      AppMethodBeat.o(203573);
      return false;
    }
    if (this.isVertical != paramObject.isVertical)
    {
      AppMethodBeat.o(203573);
      return false;
    }
    AppMethodBeat.o(203573);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203568);
    String str = "ScrollingLayoutModifier(scrollerState=" + this.ZK + ", isReversed=" + this.ZL + ", isVertical=" + this.isVertical + ')';
    AppMethodBeat.o(203568);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<x.a, ah>
  {
    a(t paramt, int paramInt, x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.t
 * JD-Core Version:    0.7.0.1
 */