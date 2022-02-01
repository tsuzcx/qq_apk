package androidx.compose.a;

import androidx.compose.a.a.aa;
import androidx.compose.a.a.aj;
import androidx.compose.a.a.aq;
import androidx.compose.a.a.at;
import androidx.compose.a.a.at.b;
import androidx.compose.a.a.au;
import androidx.compose.a.a.aw;
import androidx.compose.a.a.ay;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.ad;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"defaultOffsetAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/unit/IntOffset;", "defaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "clip", "", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final aq<androidx.compose.ui.n.j> Ta;
  private static final aq<androidx.compose.ui.n.l> Tb;
  
  static
  {
    AppMethodBeat.i(203149);
    Ta = androidx.compose.a.a.h.a(0.0F, 0.0F, androidx.compose.ui.n.j.bh(androidx.compose.a.a.bj.b(androidx.compose.ui.n.j.beN)), 3);
    Tb = androidx.compose.a.a.h.a(0.0F, 0.0F, androidx.compose.ui.n.l.bk(androidx.compose.a.a.bj.b(androidx.compose.ui.n.l.beO)), 3);
    AppMethodBeat.o(203149);
  }
  
  public static final k a(b<? super Integer, Integer> paramb, aa<androidx.compose.ui.n.j> paramaa)
  {
    AppMethodBeat.i(203088);
    kotlin.g.b.s.u(paramb, "initialOffsetY");
    kotlin.g.b.s.u(paramaa, "animationSpec");
    paramb = (b)new h(paramb);
    kotlin.g.b.s.u(paramb, "initialOffset");
    kotlin.g.b.s.u(paramaa, "animationSpec");
    paramb = (k)new l(new w(null, new s(paramb, paramaa), null, 5));
    AppMethodBeat.o(203088);
    return paramb;
  }
  
  public static final f a(at<i> paramat, k paramk, final m paramm, androidx.compose.runtime.h paramh, int paramInt)
  {
    float f3 = 1.0F;
    AppMethodBeat.i(203114);
    kotlin.g.b.s.u(paramat, "<this>");
    kotlin.g.b.s.u(paramk, "enter");
    kotlin.g.b.s.u(paramm, "exit");
    paramh.bx(1657234972);
    f localf = androidx.compose.ui.e.a(androidx.compose.ui.e.a((f)f.aud, (q)new g(paramat, androidx.compose.runtime.bj.b(paramk.lx().TR, paramh), androidx.compose.runtime.bj.b(paramm.lx().TR, paramh))), (q)new e(paramat, androidx.compose.runtime.bj.b(paramk.lx().TS, paramh), androidx.compose.runtime.bj.b(paramm.lx().TS, paramh)));
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramat);
    Object localObject2 = paramh.or();
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = androidx.compose.runtime.bj.T(Boolean.FALSE);
      paramh.F(localObject1);
    }
    paramh.od();
    Object localObject1 = (an)localObject1;
    if (paramat.Wd.lN() == paramat.lO()) {
      a((an)localObject1, false);
    }
    float f2;
    for (;;)
    {
      if (((Boolean)((bm)localObject1).getValue()).booleanValue())
      {
        paramh.bx(1657236134);
        localObject1 = (q)new c(paramk, paramm);
        paramInt = paramInt & 0xE | 0x180;
        paramh.bx(1399888299);
        localObject2 = ay.a(kotlin.g.b.m.aiwV);
        paramh.bx(1847721878);
        Object localObject3 = (i)paramat.Wd.lN();
        paramh.bx(-9524285);
        float f1;
        switch (a.$EnumSwitchMapping$0[localObject3.ordinal()])
        {
        default: 
          paramat = new kotlin.p();
          AppMethodBeat.o(203114);
          throw paramat;
          if ((paramk.lx().TQ != null) || (paramm.lx().TQ != null)) {
            a((an)localObject1, true);
          }
          break;
        case 1: 
          f1 = 1.0F;
        case 2: 
        case 3: 
          for (;;)
          {
            paramh.od();
            localObject3 = (i)paramat.lO();
            paramh.bx(-9524285);
            f2 = f3;
            switch (a.$EnumSwitchMapping$0[localObject3.ordinal()])
            {
            default: 
              paramat = new kotlin.p();
              AppMethodBeat.o(203114);
              throw paramat;
              localObject3 = paramk.lx().TQ;
              if (localObject3 == null)
              {
                f1 = 1.0F;
              }
              else
              {
                f1 = ((p)localObject3).alpha;
                continue;
                localObject3 = paramm.lx().TQ;
                if (localObject3 == null) {
                  f1 = 1.0F;
                } else {
                  f1 = ((p)localObject3).alpha;
                }
              }
              break;
            }
          }
          paramk = paramk.lx().TQ;
          if (paramk == null)
          {
            f2 = f3;
            paramh.od();
            paramat = au.a(paramat, Float.valueOf(f1), Float.valueOf(f2), (aa)((q)localObject1).invoke(paramat.lR(), paramh, Integer.valueOf((paramInt & 0xE | paramInt << 3 & 0x380 | paramInt << 3 & 0x1C00 | paramInt << 3 & 0xE000) >> 3 & 0x70)), (aw)localObject2, "alpha", paramh);
            paramh.od();
            paramh.od();
            paramat = ad.b(localf, (b)new b(paramat));
            paramh.od();
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramh.od();
      AppMethodBeat.o(203114);
      return paramat;
      f2 = paramk.alpha;
      break;
      paramk = paramm.lx().TQ;
      f2 = f3;
      if (paramk == null) {
        break;
      }
      f2 = paramk.alpha;
      break;
      paramh.bx(1657236970);
      paramh.od();
      paramat = localf;
    }
  }
  
  private static final void a(an<Boolean> paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(203122);
    paraman.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(203122);
  }
  
  public static final m b(b<? super Integer, Integer> paramb, aa<androidx.compose.ui.n.j> paramaa)
  {
    AppMethodBeat.i(203094);
    kotlin.g.b.s.u(paramb, "targetOffsetY");
    kotlin.g.b.s.u(paramaa, "animationSpec");
    paramb = (b)new i(paramb);
    kotlin.g.b.s.u(paramb, "targetOffset");
    kotlin.g.b.s.u(paramaa, "animationSpec");
    paramb = (m)new n(new w(null, new s(paramb, paramaa), null, 5));
    AppMethodBeat.o(203094);
    return paramb;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<ae, ah>
  {
    b(bm<Float> parambm)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<at.b<i>, androidx.compose.runtime.h, Integer, aa<Float>>
  {
    c(k paramk, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<androidx.compose.ui.n.l, androidx.compose.ui.n.l>
  {
    public static final d Tc;
    
    static
    {
      AppMethodBeat.i(203168);
      Tc = new d();
      AppMethodBeat.o(203168);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<f, androidx.compose.runtime.h, Integer, f>
  {
    e(at<i> paramat, bm<e> parambm1, bm<e> parambm2)
    {
      super();
    }
    
    private static final void b(an<Boolean> paraman, boolean paramBoolean)
    {
      AppMethodBeat.i(203174);
      paraman.setValue(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(203174);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<androidx.compose.ui.n.l, androidx.compose.ui.n.l>
  {
    public static final f Tf;
    
    static
    {
      AppMethodBeat.i(203182);
      Tf = new f();
      AppMethodBeat.o(203182);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements q<f, androidx.compose.runtime.h, Integer, f>
  {
    g(at<i> paramat, bm<s> parambm1, bm<s> parambm2)
    {
      super();
    }
    
    private static final void b(an<Boolean> paraman, boolean paramBoolean)
    {
      AppMethodBeat.i(203179);
      paraman.setValue(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(203179);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "it", "Landroidx/compose/ui/unit/IntSize;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<androidx.compose.ui.n.l, androidx.compose.ui.n.j>
  {
    h(b<? super Integer, Integer> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "it", "Landroidx/compose/ui/unit/IntSize;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<androidx.compose.ui.n.l, androidx.compose.ui.n.j>
  {
    i(b<? super Integer, Integer> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.j
 * JD-Core Version:    0.7.0.1
 */