package androidx.compose.ui.b;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.d.k;
import androidx.compose.ui.d.k.a;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.g;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.j;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/PainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "equals", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class l
  extends ae
  implements h, n
{
  private final androidx.compose.ui.a SF;
  private final float alpha;
  private final androidx.compose.ui.e.c.c auw;
  private final boolean aux;
  private final androidx.compose.ui.h.d auy;
  private final aa auz;
  
  public l(androidx.compose.ui.e.c.c paramc, boolean paramBoolean, androidx.compose.ui.a parama, androidx.compose.ui.h.d paramd, float paramFloat, aa paramaa, kotlin.g.a.b<? super androidx.compose.ui.platform.ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(204861);
    this.auw = paramc;
    this.aux = paramBoolean;
    this.SF = parama;
    this.auy = paramd;
    this.alpha = paramFloat;
    this.auz = paramaa;
    AppMethodBeat.o(204861);
  }
  
  private static boolean D(long paramLong)
  {
    AppMethodBeat.i(204877);
    k.a locala = k.avA;
    if (!k.e(paramLong, k.sw()))
    {
      float f = k.Q(paramLong);
      if ((!Float.isInfinite(f)) && (!Float.isNaN(f))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204877);
        return true;
      }
    }
    AppMethodBeat.o(204877);
    return false;
  }
  
  private static boolean E(long paramLong)
  {
    AppMethodBeat.i(204884);
    k.a locala = k.avA;
    if (!k.e(paramLong, k.sw()))
    {
      float f = k.R(paramLong);
      if ((!Float.isInfinite(f)) && (!Float.isNaN(f))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204884);
        return true;
      }
    }
    AppMethodBeat.o(204884);
    return false;
  }
  
  private final boolean sg()
  {
    AppMethodBeat.i(204868);
    if (this.aux)
    {
      long l = this.auw.uM();
      k.a locala = k.avA;
      if (l != k.sw()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204868);
        return true;
      }
    }
    AppMethodBeat.o(204868);
    return false;
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204929);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(204929);
    return paramf;
  }
  
  public final q a(r paramr, o paramo, long paramLong)
  {
    int k = 1;
    AppMethodBeat.i(204892);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    int i;
    if ((androidx.compose.ui.n.b.aX(paramLong)) && (androidx.compose.ui.n.b.aY(paramLong)))
    {
      i = 1;
      if ((!androidx.compose.ui.n.b.aZ(paramLong)) || (!androidx.compose.ui.n.b.ba(paramLong))) {
        break label133;
      }
    }
    label133:
    for (int j = 1;; j = 0)
    {
      if (((sg()) || (i == 0)) && (j == 0)) {
        break label139;
      }
      paramLong = androidx.compose.ui.n.b.a(paramLong, androidx.compose.ui.n.b.aU(paramLong), 0, androidx.compose.ui.n.b.aW(paramLong), 0, 10);
      paramo = paramo.aw(paramLong);
      paramr = r.a.a(paramr, paramo.width, paramo.height, (kotlin.g.a.b)new l.a(paramo));
      AppMethodBeat.o(204892);
      return paramr;
      i = 0;
      break;
    }
    label139:
    long l1 = this.auw.uM();
    if (D(l1))
    {
      i = kotlin.h.a.eH(k.Q(l1));
      label166:
      if (!E(l1)) {
        break label263;
      }
      j = kotlin.h.a.eH(k.R(l1));
      label184:
      i = androidx.compose.ui.n.c.g(paramLong, i);
      j = androidx.compose.ui.n.c.h(paramLong, j);
      l1 = androidx.compose.ui.d.l.z(i, j);
      if (sg()) {
        break label272;
      }
    }
    for (;;)
    {
      paramLong = androidx.compose.ui.n.b.a(paramLong, androidx.compose.ui.n.c.g(paramLong, kotlin.h.a.eH(k.Q(l1))), 0, androidx.compose.ui.n.c.h(paramLong, kotlin.h.a.eH(k.R(l1))), 0, 10);
      break;
      i = androidx.compose.ui.n.b.aT(paramLong);
      break label166;
      label263:
      j = androidx.compose.ui.n.b.aV(paramLong);
      break label184;
      label272:
      float f1;
      label292:
      float f2;
      label312:
      long l2;
      if (!D(this.auw.uM()))
      {
        f1 = k.Q(l1);
        if (E(this.auw.uM())) {
          break label396;
        }
        f2 = k.R(l1);
        l2 = androidx.compose.ui.d.l.z(f1, f2);
        if (k.Q(l1) != 0.0F) {
          break label411;
        }
        i = 1;
        label334:
        if (i != 0) {
          break label423;
        }
        if (k.R(l1) != 0.0F) {
          break label417;
        }
      }
      label396:
      label411:
      label417:
      for (i = k;; i = 0)
      {
        if (i != 0) {
          break label423;
        }
        l1 = androidx.compose.ui.h.ad.p(l2, this.auy.l(l2, l1));
        break;
        f1 = k.Q(this.auw.uM());
        break label292;
        f2 = k.R(this.auw.uM());
        break label312;
        i = 0;
        break label334;
      }
      label423:
      k.a locala = k.avA;
      l1 = k.su();
    }
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204917);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(204917);
    return paramR;
  }
  
  public final void a(androidx.compose.ui.e.b.c paramc)
  {
    AppMethodBeat.i(204900);
    s.u(paramc, "<this>");
    long l1 = this.auw.uM();
    float f1;
    float f2;
    label50:
    int i;
    if (D(l1))
    {
      f1 = k.Q(l1);
      if (!E(l1)) {
        break label283;
      }
      f2 = k.R(l1);
      l1 = androidx.compose.ui.d.l.z(f1, f2);
      if (k.Q(paramc.sf()) != 0.0F) {
        break label296;
      }
      i = 1;
      label74:
      if (i != 0) {
        break label308;
      }
      if (k.R(paramc.sf()) != 0.0F) {
        break label302;
      }
      i = 1;
      label96:
      if (i != 0) {
        break label308;
      }
    }
    for (l1 = androidx.compose.ui.h.ad.p(l1, this.auy.l(l1, paramc.sf()));; l1 = k.su())
    {
      long l2 = this.SF.a(androidx.compose.ui.n.m.an(kotlin.h.a.eH(k.Q(l1)), kotlin.h.a.eH(k.R(l1))), androidx.compose.ui.n.m.an(kotlin.h.a.eH(k.Q(paramc.sf())), kotlin.h.a.eH(k.R(paramc.sf()))), paramc.getLayoutDirection());
      f1 = j.bf(l2);
      f2 = j.bg(l2);
      paramc = (e)paramc;
      paramc.uG().uI().A(f1, f2);
      this.auw.a(paramc, l1, this.alpha, this.auz);
      paramc.uG().uI().A(-f1, -f2);
      AppMethodBeat.o(204900);
      return;
      f1 = k.Q(paramc.sf());
      break;
      label283:
      f2 = k.R(paramc.sf());
      break label50;
      label296:
      i = 0;
      break label74;
      label302:
      i = 0;
      break label96;
      label308:
      k.a locala = k.avA;
    }
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204925);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(204925);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204923);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(204923);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204908);
    if ((paramObject instanceof l)) {}
    for (paramObject = (l)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(204908);
      return false;
    }
    if ((s.p(this.auw, paramObject.auw)) && (this.aux == paramObject.aux) && (s.p(this.SF, paramObject.SF)) && (s.p(this.auy, paramObject.auy)))
    {
      if (this.alpha == paramObject.alpha) {}
      for (int i = 1; (i != 0) && (s.p(this.auz, paramObject.auz)); i = 0)
      {
        AppMethodBeat.o(204908);
        return true;
      }
    }
    AppMethodBeat.o(204908);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204903);
    int j = this.auw.hashCode();
    int k = e..ExternalSyntheticBackport0.m(this.aux);
    int m = this.SF.hashCode();
    int n = this.auy.hashCode();
    int i1 = Float.floatToIntBits(this.alpha);
    aa localaa = this.auz;
    if (localaa == null) {}
    for (int i = 0;; i = localaa.hashCode())
    {
      AppMethodBeat.o(204903);
      return i + ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204912);
    String str = "PainterModifier(painter=" + this.auw + ", sizeToIntrinsics=" + this.aux + ", alignment=" + this.SF + ", alpha=" + this.alpha + ", colorFilter=" + this.auz + ')';
    AppMethodBeat.o(204912);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.l
 * JD-Core Version:    0.7.0.1
 */