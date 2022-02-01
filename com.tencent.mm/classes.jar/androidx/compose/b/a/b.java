package androidx.compose.b.a;

import androidx.compose.a.a.i;
import androidx.compose.foundation.b.g.b;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.f.t;
import androidx.compose.ui.e.b.c;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.y;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends l
  implements az
{
  private final boolean ajS;
  private final bm<z> ajT;
  private final bm<f> ajU;
  final t<g.b, g> akc;
  private final float radius;
  
  private b(boolean paramBoolean, float paramFloat, bm<z> parambm, bm<f> parambm1)
  {
    super(paramBoolean, parambm1);
    AppMethodBeat.i(201841);
    this.ajS = paramBoolean;
    this.radius = paramFloat;
    this.ajT = parambm;
    this.ajU = parambm1;
    this.akc = bj.ql();
    AppMethodBeat.o(201841);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(201868);
    s.u(paramb, "interaction");
    paramb = (g)this.akc.get(paramb);
    if (paramb != null) {
      paramb.finish();
    }
    AppMethodBeat.o(201868);
  }
  
  public final void a(final g.b paramb, aq paramaq)
  {
    AppMethodBeat.i(201860);
    s.u(paramb, "interaction");
    s.u(paramaq, "scope");
    Object localObject = ((Map)this.akc).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Map.Entry)((Iterator)localObject).next()).getValue()).finish();
    }
    if (this.ajS) {}
    for (localObject = androidx.compose.ui.d.e.N(paramb.abI);; localObject = null)
    {
      localObject = new g((androidx.compose.ui.d.e)localObject, this.radius, this.ajS, (byte)0);
      ((Map)this.akc).put(paramb, localObject);
      j.a(paramaq, null, null, (m)new a((g)localObject, this, paramb, null), 3);
      AppMethodBeat.o(201860);
      return;
    }
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(201854);
    s.u(paramc, "<this>");
    long l1 = ((z)this.ajT.getValue()).value;
    paramc.uK();
    a((androidx.compose.ui.e.b.e)paramc, this.radius, l1);
    androidx.compose.ui.e.b.e locale = (androidx.compose.ui.e.b.e)paramc;
    Iterator localIterator = ((Map)this.akc).entrySet().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)((Map.Entry)localIterator.next()).getValue();
      float f1 = ((f)this.ajU.getValue()).akn;
      int i;
      label128:
      long l3;
      if (f1 == 0.0F)
      {
        i = 1;
        if (i != 0) {
          break label651;
        }
        l3 = z.g(l1, f1);
        s.u(locale, "$receiver");
        if (localg.akp == null) {
          localg.akp = Float.valueOf(h.x(locale.sf()));
        }
        if (localg.akq == null)
        {
          if (!Float.isNaN(localg.radius)) {
            break label653;
          }
          paramc = Float.valueOf(h.a((androidx.compose.ui.n.d)locale, localg.ajS, locale.sf()));
          label217:
          localg.akq = paramc;
        }
        if (localg.ako == null) {
          localg.ako = androidx.compose.ui.d.e.N(locale.sx());
        }
        if (localg.akr == null) {
          localg.akr = androidx.compose.ui.d.e.N(androidx.compose.ui.d.f.x(androidx.compose.ui.d.k.Q(locale.sf()) / 2.0F, androidx.compose.ui.d.k.R(locale.sf()) / 2.0F));
        }
        if ((!((Boolean)((bm)localg.akx).getValue()).booleanValue()) || (((Boolean)((bm)localg.akw).getValue()).booleanValue())) {
          break label672;
        }
      }
      float f2;
      long l2;
      label651:
      label653:
      label672:
      for (f1 = 1.0F;; f1 = ((Number)localg.aks.TV.getValue()).floatValue())
      {
        paramc = localg.akp;
        s.checkNotNull(paramc);
        f2 = paramc.floatValue();
        paramc = localg.akq;
        s.checkNotNull(paramc);
        f2 = androidx.compose.ui.o.a.lerp(f2, paramc.floatValue(), ((Number)localg.akt.TV.getValue()).floatValue());
        paramc = localg.ako;
        s.checkNotNull(paramc);
        float f3 = androidx.compose.ui.d.e.F(paramc.avp);
        paramc = localg.akr;
        s.checkNotNull(paramc);
        f3 = androidx.compose.ui.o.a.lerp(f3, androidx.compose.ui.d.e.F(paramc.avp), ((Number)localg.aku.TV.getValue()).floatValue());
        paramc = localg.ako;
        s.checkNotNull(paramc);
        float f4 = androidx.compose.ui.d.e.G(paramc.avp);
        paramc = localg.akr;
        s.checkNotNull(paramc);
        l2 = androidx.compose.ui.d.f.x(f3, androidx.compose.ui.o.a.lerp(f4, androidx.compose.ui.d.e.G(paramc.avp), ((Number)localg.aku.TV.getValue()).floatValue()));
        l3 = z.g(l3, z.ac(l3) * f1);
        if (!localg.ajS) {
          break label693;
        }
        f1 = androidx.compose.ui.d.k.Q(locale.sf());
        f3 = androidx.compose.ui.d.k.R(locale.sf());
        paramc = y.awI;
        i = y.tu();
        paramc = locale.uG();
        long l4 = paramc.sf();
        paramc.uH().sz();
        paramc.uI().a(0.0F, 0.0F, f1, f3, i);
        e.b.a(locale, l3, f2, l2, 0.0F, null, 0, 120);
        paramc.uH().restore();
        paramc.ao(l4);
        break;
        i = 0;
        break label128;
        break;
        paramc = Float.valueOf(locale.w(localg.radius));
        break label217;
      }
      label693:
      e.b.a(locale, l3, f2, l2, 0.0F, null, 0, 120);
    }
    AppMethodBeat.o(201854);
  }
  
  public final void mJ() {}
  
  public final void mK()
  {
    AppMethodBeat.i(201879);
    this.akc.clear();
    AppMethodBeat.o(201879);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(201883);
    this.akc.clear();
    AppMethodBeat.o(201883);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(g paramg, b paramb, g.b paramb1, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(201817);
      paramObject = (kotlin.d.d)new a(this.akd, jdField_this, paramb, paramd);
      AppMethodBeat.o(201817);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201805);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201805);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.akd;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        paramObject = paramObject.b(locald);
        if (paramObject == locala)
        {
          AppMethodBeat.o(201805);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        jdField_this.akc.remove(paramb);
        paramObject = ah.aiuX;
        AppMethodBeat.o(201805);
        return paramObject;
      }
      finally
      {
        jdField_this.akc.remove(paramb);
        AppMethodBeat.o(201805);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.b
 * JD-Core Version:    0.7.0.1
 */