package androidx.compose.b.a;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.compose.foundation.b.g.b;
import androidx.compose.runtime.an;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/material/ripple/RippleContainer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "onInvalidateRipple", "Lkotlin/Function0;", "", "F", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "rippleRadius", "", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "resetHostView", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends l
  implements az
{
  private final boolean ajS;
  private final bm<z> ajT;
  private final bm<f> ajU;
  private final i ajV;
  private final an ajW;
  final an ajX;
  private long ajY;
  private int ajZ;
  private final kotlin.g.a.a<ah> aka;
  private final float radius;
  
  private a(boolean paramBoolean, float paramFloat, bm<z> parambm, bm<f> parambm1, i parami)
  {
    super(paramBoolean, parambm1);
    AppMethodBeat.i(201851);
    this.ajS = paramBoolean;
    this.radius = paramFloat;
    this.ajT = parambm;
    this.ajU = parambm1;
    this.ajV = parami;
    this.ajW = bj.T(null);
    this.ajX = bj.T(Boolean.TRUE);
    parambm = androidx.compose.ui.d.k.avA;
    this.ajY = androidx.compose.ui.d.k.su();
    this.ajZ = -1;
    this.aka = ((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(201851);
  }
  
  private final void dispose()
  {
    AppMethodBeat.i(201862);
    this.ajV.a(this);
    AppMethodBeat.o(201862);
  }
  
  private final k nC()
  {
    AppMethodBeat.i(201857);
    k localk = (k)((bm)this.ajW).getValue();
    AppMethodBeat.o(201857);
    return localk;
  }
  
  final void a(k paramk)
  {
    AppMethodBeat.i(201878);
    this.ajW.setValue(paramk);
    AppMethodBeat.o(201878);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(201913);
    s.u(paramb, "interaction");
    paramb = nC();
    if (paramb != null) {
      paramb.setRippleState(false);
    }
    AppMethodBeat.o(201913);
  }
  
  public final void a(g.b paramb, aq paramaq)
  {
    AppMethodBeat.i(201906);
    s.u(paramb, "interaction");
    s.u(paramaq, "scope");
    Object localObject2 = this.ajV;
    s.u(this, "<this>");
    paramaq = ((i)localObject2).akD.b(this);
    Object localObject1;
    Object localObject3;
    if (paramaq != null)
    {
      boolean bool = this.ajS;
      long l1 = this.ajY;
      int i = this.ajZ;
      long l2 = ((z)this.ajT.getValue()).value;
      float f = ((f)this.ajU.getValue()).akn;
      localObject1 = this.aka;
      s.u(paramb, "interaction");
      s.u(localObject1, "onInvalidateRipple");
      if ((paramaq.akI == null) || (!s.p(Boolean.valueOf(bool), paramaq.akJ)))
      {
        localObject2 = new q(bool);
        paramaq.setBackground((Drawable)localObject2);
        localObject3 = ah.aiuX;
        paramaq.akI = ((q)localObject2);
        paramaq.akJ = Boolean.valueOf(bool);
      }
      localObject2 = paramaq.akI;
      s.checkNotNull(localObject2);
      paramaq.aka = ((kotlin.g.a.a)localObject1);
      paramaq.a(l1, i, l2, f);
      if (!bool) {
        break label497;
      }
      ((q)localObject2).setHotspot(androidx.compose.ui.d.e.F(paramb.abI), androidx.compose.ui.d.e.G(paramb.abI));
    }
    for (;;)
    {
      paramaq.setRippleState(true);
      a(paramaq);
      AppMethodBeat.o(201906);
      return;
      localObject1 = (k)p.oG(((i)localObject2).akC);
      paramaq = (aq)localObject1;
      if (localObject1 == null)
      {
        if (((i)localObject2).akE <= p.oE(((i)localObject2).akB)) {
          break label403;
        }
        paramaq = ((i)localObject2).getContext();
        s.s(paramaq, "context");
        paramaq = new k(paramaq);
        ((i)localObject2).addView((View)paramaq);
        ((Collection)((i)localObject2).akB).add(paramaq);
        label326:
        if (((i)localObject2).akE >= ((i)localObject2).akA - 1) {
          break label488;
        }
      }
      label403:
      label488:
      for (((i)localObject2).akE += 1;; ((i)localObject2).akE = 0)
      {
        localObject1 = ((i)localObject2).akD;
        s.u(this, "indicationInstance");
        s.u(paramaq, "rippleHostView");
        ((j)localObject1).akF.put(this, paramaq);
        ((j)localObject1).akG.put(paramaq, this);
        break;
        localObject1 = (k)((i)localObject2).akB.get(((i)localObject2).akE);
        paramaq = ((i)localObject2).akD;
        s.u(localObject1, "rippleHostView");
        localObject3 = (a)paramaq.akG.get(localObject1);
        paramaq = (aq)localObject1;
        if (localObject3 == null) {
          break label326;
        }
        ((a)localObject3).a(null);
        ((i)localObject2).akD.c((a)localObject3);
        ((k)localObject1).nG();
        paramaq = (aq)localObject1;
        break label326;
      }
      label497:
      ((q)localObject2).setHotspot(((q)localObject2).getBounds().centerX(), ((q)localObject2).getBounds().centerY());
    }
  }
  
  public final void b(androidx.compose.ui.e.b.c paramc)
  {
    AppMethodBeat.i(201894);
    s.u(paramc, "<this>");
    this.ajY = paramc.sf();
    if (Float.isNaN(this.radius)) {}
    for (int i = kotlin.h.a.eH(h.a((androidx.compose.ui.n.d)paramc, this.ajS, paramc.sf()));; i = paramc.v(this.radius))
    {
      this.ajZ = i;
      long l = ((z)this.ajT.getValue()).value;
      float f = ((f)this.ajU.getValue()).akn;
      paramc.uK();
      a((androidx.compose.ui.e.b.e)paramc, this.radius, l);
      androidx.compose.ui.e.u localu = ((androidx.compose.ui.e.b.e)paramc).uG().uH();
      nD();
      k localk = nC();
      if (localk != null)
      {
        localk.a(paramc.sf(), this.ajZ, l, f);
        localk.draw(androidx.compose.ui.e.c.a(localu));
      }
      AppMethodBeat.o(201894);
      return;
    }
  }
  
  public final void mJ() {}
  
  public final void mK()
  {
    AppMethodBeat.i(201924);
    dispose();
    AppMethodBeat.o(201924);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(201928);
    dispose();
    AppMethodBeat.o(201928);
  }
  
  final boolean nD()
  {
    AppMethodBeat.i(201885);
    boolean bool = ((Boolean)((bm)this.ajX).getValue()).booleanValue();
    AppMethodBeat.o(201885);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.a
 * JD-Core Version:    0.7.0.1
 */