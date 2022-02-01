package androidx.compose.ui.e;

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
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "J", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class az
  extends androidx.compose.ui.platform.ae
  implements n
{
  private final boolean SI;
  private final ay XK;
  private final float alpha;
  private final b<ae, ah> awy;
  private final float ayc;
  private final float ayd;
  private final float aye;
  private final float ayf;
  private final float ayg;
  private final float ayh;
  private final float ayi;
  private final long ayj;
  private final float scaleX;
  private final float scaleY;
  
  private az(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, long paramLong, ay paramay, boolean paramBoolean, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(206165);
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.alpha = paramFloat3;
    this.ayc = paramFloat4;
    this.ayd = paramFloat5;
    this.aye = paramFloat6;
    this.ayf = paramFloat7;
    this.ayg = paramFloat8;
    this.ayh = paramFloat9;
    this.ayi = paramFloat10;
    this.ayj = paramLong;
    this.XK = paramay;
    this.SI = paramBoolean;
    this.awy = ((b)new a(this));
    AppMethodBeat.o(206165);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(206266);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(206266);
    return paramf;
  }
  
  public final q a(r paramr, o paramo, long paramLong)
  {
    AppMethodBeat.i(206234);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    paramo = paramo.aw(paramLong);
    paramr = r.a.a(paramr, paramo.width, paramo.height, (b)new b(paramo, this));
    AppMethodBeat.o(206234);
    return paramr;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(206257);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(206257);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(206262);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(206262);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(206260);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(206260);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206248);
    if ((paramObject instanceof az)) {}
    for (paramObject = (az)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(206248);
      return false;
    }
    if (this.scaleX == paramObject.scaleX)
    {
      i = 1;
      if (i == 0) {
        break label309;
      }
      if (this.scaleY != paramObject.scaleY) {
        break label264;
      }
      i = 1;
      label65:
      if (i == 0) {
        break label309;
      }
      if (this.alpha != paramObject.alpha) {
        break label269;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label309;
      }
      if (this.ayc != paramObject.ayc) {
        break label274;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label309;
      }
      if (this.ayd != paramObject.ayd) {
        break label279;
      }
      i = 1;
      label119:
      if (i == 0) {
        break label309;
      }
      if (this.aye != paramObject.aye) {
        break label284;
      }
      i = 1;
      label137:
      if (i == 0) {
        break label309;
      }
      if (this.ayf != paramObject.ayf) {
        break label289;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label309;
      }
      if (this.ayg != paramObject.ayg) {
        break label294;
      }
      i = 1;
      label173:
      if (i == 0) {
        break label309;
      }
      if (this.ayh != paramObject.ayh) {
        break label299;
      }
      i = 1;
      label191:
      if (i == 0) {
        break label309;
      }
      if (this.ayi != paramObject.ayi) {
        break label304;
      }
    }
    label264:
    label269:
    label274:
    label279:
    label284:
    label289:
    label294:
    label299:
    label304:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!be.e(this.ayj, paramObject.ayj)) || (!s.p(this.XK, paramObject.XK)) || (this.SI != paramObject.SI)) {
        break label309;
      }
      AppMethodBeat.o(206248);
      return true;
      i = 0;
      break;
      i = 0;
      break label65;
      i = 0;
      break label83;
      i = 0;
      break label101;
      i = 0;
      break label119;
      i = 0;
      break label137;
      i = 0;
      break label155;
      i = 0;
      break label173;
      i = 0;
      break label191;
    }
    label309:
    AppMethodBeat.o(206248);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206241);
    int i = Float.floatToIntBits(this.scaleX);
    int j = Float.floatToIntBits(this.scaleY);
    int k = Float.floatToIntBits(this.alpha);
    int m = Float.floatToIntBits(this.ayc);
    int n = Float.floatToIntBits(this.ayd);
    int i1 = Float.floatToIntBits(this.aye);
    int i2 = Float.floatToIntBits(this.ayf);
    int i3 = Float.floatToIntBits(this.ayg);
    int i4 = Float.floatToIntBits(this.ayh);
    int i5 = Float.floatToIntBits(this.ayi);
    int i6 = be.I(this.ayj);
    int i7 = this.XK.hashCode();
    int i8 = e..ExternalSyntheticBackport0.m(this.SI);
    AppMethodBeat.o(206241);
    return (((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206254);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SimpleGraphicsLayerModifier(scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha = ").append(this.alpha).append(", translationX=").append(this.ayc).append(", translationY=").append(this.ayd).append(", shadowElevation=").append(this.aye).append(", rotationX=").append(this.ayf).append(", rotationY=").append(this.ayg).append(", rotationZ=").append(this.ayh).append(", cameraDistance=").append(this.ayi).append(", transformOrigin=").append(be.H(this.ayj)).append(", shape=");
    ((StringBuilder)localObject).append(this.XK).append(", clip=").append(this.SI).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(206254);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<ae, ah>
  {
    a(az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<x.a, ah>
  {
    b(x paramx, az paramaz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.az
 * JD-Core Version:    0.7.0.1
 */