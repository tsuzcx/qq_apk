package androidx.compose.foundation;

import androidx.compose.ui.b.h;
import androidx.compose.ui.b.h.a;
import androidx.compose.ui.d.g;
import androidx.compose.ui.d.k;
import androidx.compose.ui.e.ak;
import androidx.compose.ui.e.ak.a;
import androidx.compose.ui.e.ak.b;
import androidx.compose.ui.e.ak.c;
import androidx.compose.ui.e.al;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.au;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.b.c;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.a;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f.c;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/Background;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "equals", "", "other", "", "hashCode", "", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  extends ae
  implements h
{
  private final z XI;
  private final androidx.compose.ui.e.s XJ;
  private final ay XK;
  private k XL;
  private n XM;
  private ak XN;
  private final float alpha;
  
  private a(z paramz, androidx.compose.ui.e.s params, float paramFloat, ay paramay, kotlin.g.a.b<? super ad, ah> paramb)
  {
    super(paramb);
    this.XI = paramz;
    this.XJ = params;
    this.alpha = paramFloat;
    this.XK = paramay;
  }
  
  public final androidx.compose.ui.f a(androidx.compose.ui.f paramf)
  {
    AppMethodBeat.i(203656);
    paramf = h.a.a((h)this, paramf);
    AppMethodBeat.o(203656);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203643);
    paramR = h.a.a((h)this, paramR, paramm);
    AppMethodBeat.o(203643);
    return paramR;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(203623);
    kotlin.g.b.s.u(paramc, "<this>");
    Object localObject1;
    long l;
    if (this.XK == au.tM())
    {
      localObject1 = this.XI;
      if (localObject1 != null)
      {
        l = ((z)localObject1).value;
        e.b.a((e)paramc, l, 0L, 0L, 0.0F, null, null, 0, 126);
      }
      localObject1 = this.XJ;
      if (localObject1 != null) {
        e.b.a((e)paramc, (androidx.compose.ui.e.s)localObject1, 0L, 0L, this.alpha, null, 0, 118);
      }
      paramc.uK();
      AppMethodBeat.o(203623);
      return;
    }
    label138:
    e locale;
    Object localObject2;
    Object localObject3;
    int i;
    label242:
    float f1;
    Object localObject4;
    if ((k.e(paramc.sf(), this.XL)) && (paramc.getLayoutDirection() == this.XM))
    {
      localObject1 = this.XN;
      kotlin.g.b.s.checkNotNull(localObject1);
      if (this.XI != null)
      {
        locale = (e)paramc;
        l = this.XI.value;
        localObject2 = (androidx.compose.ui.e.b.f)androidx.compose.ui.e.b.i.aAu;
        localObject3 = e.aAr;
        i = e.a.uL();
        kotlin.g.b.s.u(locale, "$this$drawOutline");
        kotlin.g.b.s.u(localObject1, "outline");
        kotlin.g.b.s.u(localObject2, "style");
        if (!(localObject1 instanceof ak.b)) {
          break label407;
        }
        localObject3 = ((ak.b)localObject1).axL;
        locale.a(l, al.d((g)localObject3), al.e((g)localObject3), 1.0F, (androidx.compose.ui.e.b.f)localObject2, null, i);
      }
      if (this.XJ != null)
      {
        locale = (e)paramc;
        localObject2 = this.XJ;
        f1 = this.alpha;
        localObject3 = (androidx.compose.ui.e.b.f)androidx.compose.ui.e.b.i.aAu;
        localObject4 = e.aAr;
        i = e.a.uL();
        kotlin.g.b.s.u(locale, "$this$drawOutline");
        kotlin.g.b.s.u(localObject1, "outline");
        kotlin.g.b.s.u(localObject2, "brush");
        kotlin.g.b.s.u(localObject3, "style");
        if (!(localObject1 instanceof ak.b)) {
          break label532;
        }
        localObject4 = ((ak.b)localObject1).axL;
        locale.a((androidx.compose.ui.e.s)localObject2, al.d((g)localObject4), al.e((g)localObject4), f1, (androidx.compose.ui.e.b.f)localObject3, null, i);
      }
    }
    for (;;)
    {
      this.XN = ((ak)localObject1);
      this.XL = k.U(paramc.sf());
      break;
      localObject1 = this.XK.a(paramc.sf(), paramc.getLayoutDirection(), (d)paramc);
      break label138;
      label407:
      if ((localObject1 instanceof ak.c))
      {
        localObject3 = ((ak.c)localObject1).axN;
        if (localObject3 != null)
        {
          locale.a((ao)localObject3, l, 1.0F, (androidx.compose.ui.e.b.f)localObject2, null, i);
          break label242;
        }
        localObject3 = ((ak.c)localObject1).axM;
        f1 = androidx.compose.ui.d.a.F(((androidx.compose.ui.d.i)localObject3).avy);
        locale.a(l, al.c((androidx.compose.ui.d.i)localObject3), al.d((androidx.compose.ui.d.i)localObject3), androidx.compose.ui.d.b.v(f1, f1), (androidx.compose.ui.e.b.f)localObject2, 1.0F, null, i);
        break label242;
      }
      if ((localObject1 instanceof ak.a))
      {
        AppMethodBeat.o(203623);
        throw null;
      }
      paramc = new p();
      AppMethodBeat.o(203623);
      throw paramc;
      label532:
      if (!(localObject1 instanceof ak.c)) {
        break label627;
      }
      localObject4 = ((ak.c)localObject1).axN;
      if (localObject4 != null)
      {
        locale.a((ao)localObject4, (androidx.compose.ui.e.s)localObject2, f1, (androidx.compose.ui.e.b.f)localObject3, null, i);
      }
      else
      {
        localObject4 = ((ak.c)localObject1).axM;
        float f2 = androidx.compose.ui.d.a.F(((androidx.compose.ui.d.i)localObject4).avy);
        locale.a((androidx.compose.ui.e.s)localObject2, al.c((androidx.compose.ui.d.i)localObject4), al.d((androidx.compose.ui.d.i)localObject4), androidx.compose.ui.d.b.v(f2, f2), f1, (androidx.compose.ui.e.b.f)localObject3, null, i);
      }
    }
    label627:
    if ((localObject1 instanceof ak.a))
    {
      AppMethodBeat.o(203623);
      throw null;
    }
    paramc = new p();
    AppMethodBeat.o(203623);
    throw paramc;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203651);
    boolean bool = h.a.a((h)this, paramb);
    AppMethodBeat.o(203651);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203649);
    paramR = h.a.b((h)this, paramR, paramm);
    AppMethodBeat.o(203649);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203636);
    if ((paramObject instanceof a)) {}
    for (paramObject = (a)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203636);
      return false;
    }
    if ((kotlin.g.b.s.p(this.XI, paramObject.XI)) && (kotlin.g.b.s.p(this.XJ, paramObject.XJ)))
    {
      if (this.alpha == paramObject.alpha) {}
      for (int i = 1; (i != 0) && (kotlin.g.b.s.p(this.XK, paramObject.XK)); i = 0)
      {
        AppMethodBeat.o(203636);
        return true;
      }
    }
    AppMethodBeat.o(203636);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(203631);
    Object localObject = this.XI;
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.XJ;
      if (localObject != null) {
        break label85;
      }
    }
    for (;;)
    {
      int k = Float.floatToIntBits(this.alpha);
      int m = this.XK.hashCode();
      AppMethodBeat.o(203631);
      return ((i * 31 + j) * 31 + k) * 31 + m;
      i = z.I(((z)localObject).value);
      break;
      label85:
      j = ((androidx.compose.ui.e.s)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203640);
    String str = "Background(color=" + this.XI + ", brush=" + this.XJ + ", alpha = " + this.alpha + ", shape=" + this.XK + ')';
    AppMethodBeat.o(203640);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a
 * JD-Core Version:    0.7.0.1
 */