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
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.g;
import androidx.compose.ui.n.g.a;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/SizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "equals", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ad
  extends ae
  implements n
{
  private final boolean aeb;
  private final float maxHeight;
  private final float maxWidth;
  private final float minHeight;
  private final float minWidth;
  
  private ad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, kotlin.g.a.b<? super androidx.compose.ui.platform.ad, ah> paramb)
  {
    super(paramb);
    this.minWidth = paramFloat1;
    this.minHeight = paramFloat2;
    this.maxWidth = paramFloat3;
    this.maxHeight = paramFloat4;
    this.aeb = true;
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203865);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203865);
    return paramf;
  }
  
  public final q a(r paramr, o paramo, long paramLong)
  {
    int n = 0;
    AppMethodBeat.i(203825);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    Object localObject = (d)paramr;
    float f = this.maxWidth;
    g.a locala = g.beI;
    int j;
    int k;
    label134:
    int i;
    if (!g.G(f, g.Ch()))
    {
      j = ((d)localObject).v(((g)k.d(g.al(this.maxWidth), g.al(g.ai(0.0F)))).value);
      f = this.maxHeight;
      locala = g.beI;
      if (g.G(f, g.Ch())) {
        break label382;
      }
      k = ((d)localObject).v(((g)k.d(g.al(this.maxHeight), g.al(g.ai(0.0F)))).value);
      f = this.minWidth;
      locala = g.beI;
      if (g.G(f, g.Ch())) {
        break label395;
      }
      i = k.qu(k.qv(((d)localObject).v(this.minWidth), j), 0);
      if (i == 2147483647) {
        break label389;
      }
    }
    long l;
    for (;;)
    {
      f = this.minHeight;
      locala = g.beI;
      m = n;
      if (!g.G(f, g.Ch()))
      {
        int i1 = k.qu(k.qv(((d)localObject).v(this.minHeight), k), 0);
        m = n;
        if (i1 != 2147483647) {
          m = i1;
        }
      }
      l = c.k(i, j, m, k);
      if (!this.aeb) {
        break label401;
      }
      paramLong = c.k(k.bQ(androidx.compose.ui.n.b.aT(l), androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aU(paramLong)), k.bQ(androidx.compose.ui.n.b.aU(l), androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aU(paramLong)), k.bQ(androidx.compose.ui.n.b.aV(l), androidx.compose.ui.n.b.aV(paramLong), androidx.compose.ui.n.b.aW(paramLong)), k.bQ(androidx.compose.ui.n.b.aW(l), androidx.compose.ui.n.b.aV(paramLong), androidx.compose.ui.n.b.aW(paramLong)));
      paramo = paramo.aw(paramLong);
      paramr = r.a.a(paramr, paramo.width, paramo.height, (kotlin.g.a.b)new ad.a(paramo));
      AppMethodBeat.o(203825);
      return paramr;
      j = 2147483647;
      break;
      label382:
      k = 2147483647;
      break label134;
      label389:
      i = 0;
      continue;
      label395:
      i = 0;
    }
    label401:
    f = this.minWidth;
    localObject = g.beI;
    if (!g.G(f, g.Ch()))
    {
      i = androidx.compose.ui.n.b.aT(l);
      label430:
      f = this.maxWidth;
      localObject = g.beI;
      if (g.G(f, g.Ch())) {
        break label549;
      }
      j = androidx.compose.ui.n.b.aU(l);
      label459:
      f = this.minHeight;
      localObject = g.beI;
      if (g.G(f, g.Ch())) {
        break label566;
      }
      k = androidx.compose.ui.n.b.aV(l);
      label488:
      f = this.maxHeight;
      localObject = g.beI;
      if (g.G(f, g.Ch())) {
        break label583;
      }
    }
    label549:
    label566:
    label583:
    for (int m = androidx.compose.ui.n.b.aW(l);; m = k.qu(androidx.compose.ui.n.b.aW(paramLong), androidx.compose.ui.n.b.aV(l)))
    {
      paramLong = c.k(i, j, k, m);
      break;
      i = k.qv(androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aU(l));
      break label430;
      j = k.qu(androidx.compose.ui.n.b.aU(paramLong), androidx.compose.ui.n.b.aT(l));
      break label459;
      k = k.qv(androidx.compose.ui.n.b.aV(paramLong), androidx.compose.ui.n.b.aW(l));
      break label488;
    }
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203848);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203848);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203860);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203860);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203854);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203854);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203836);
    if (!(paramObject instanceof ad))
    {
      AppMethodBeat.o(203836);
      return false;
    }
    if ((g.G(this.minWidth, ((ad)paramObject).minWidth)) && (g.G(this.minHeight, ((ad)paramObject).minHeight)) && (g.G(this.maxWidth, ((ad)paramObject).maxWidth)) && (g.G(this.maxHeight, ((ad)paramObject).maxHeight)) && (this.aeb == ((ad)paramObject).aeb))
    {
      AppMethodBeat.o(203836);
      return true;
    }
    AppMethodBeat.o(203836);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203843);
    int i = g.ah(this.minWidth);
    int j = g.ah(this.minHeight);
    int k = g.ah(this.maxWidth);
    int m = g.ah(this.maxHeight);
    AppMethodBeat.o(203843);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.ad
 * JD-Core Version:    0.7.0.1
 */