package androidx.compose.a;

import androidx.compose.a.a.aa;
import androidx.compose.a.a.at;
import androidx.compose.a.a.at.a;
import androidx.compose.a.a.at.b;
import androidx.compose.runtime.bm;
import androidx.compose.ui.a;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.n.a;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/ExpandShrinkModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getAlignment", "()Landroidx/compose/runtime/State;", "currentAlignment", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getExpand", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getShrink", "getSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class o
  implements androidx.compose.ui.h.n
{
  private final at<i>.a<l, androidx.compose.a.a.m> Tp;
  private final at<i>.a<j, androidx.compose.a.a.m> Tq;
  final bm<e> Tr;
  final bm<e> Ts;
  final bm<a> Tt;
  a Tu;
  private final b<at.b<i>, aa<l>> Tv;
  
  public o(at<i>.a<l, androidx.compose.a.a.m> paramat, at<i>.a<j, androidx.compose.a.a.m> paramat1, bm<e> parambm1, bm<e> parambm2, bm<? extends a> parambm)
  {
    AppMethodBeat.i(203077);
    this.Tp = paramat;
    this.Tq = paramat1;
    this.Tr = parambm1;
    this.Ts = parambm2;
    this.Tt = parambm;
    this.Tv = ((b)new f(this));
    AppMethodBeat.o(203077);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203140);
    paramf = n.a.a((androidx.compose.ui.h.n)this, paramf);
    AppMethodBeat.o(203140);
    return paramf;
  }
  
  public final q a(r paramr, androidx.compose.ui.h.o paramo, final long paramLong)
  {
    AppMethodBeat.i(203096);
    s.u(paramr, "$receiver");
    s.u(paramo, "measurable");
    x localx = paramo.aw(paramLong);
    paramLong = androidx.compose.ui.n.m.an(localx.width, localx.height);
    long l1 = ((l)this.Tp.a(this.Tv, (b)new c(this, paramLong)).getValue()).avp;
    long l2 = ((j)this.Tq.a((b)d.TB, (b)new e(this, paramLong)).getValue()).avp;
    paramo = this.Tu;
    if (paramo == null)
    {
      paramo = null;
      if (paramo != null) {
        break label193;
      }
      paramo = j.beN;
    }
    label193:
    for (paramLong = j.su();; paramLong = paramo.avp)
    {
      paramr = r.a.a(paramr, l.bi(l1), l.bj(l1), (b)new b(localx, paramLong, l2));
      AppMethodBeat.o(203096);
      return paramr;
      paramo = j.bh(paramo.a(paramLong, l1, androidx.compose.ui.n.n.beP));
      break;
    }
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203106);
    paramR = n.a.a((androidx.compose.ui.h.n)this, paramR, paramm);
    AppMethodBeat.o(203106);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203127);
    boolean bool = n.a.a((androidx.compose.ui.h.n)this, paramb);
    AppMethodBeat.o(203127);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203116);
    paramR = n.a.b((androidx.compose.ui.h.n)this, paramR, paramm);
    AppMethodBeat.o(203116);
    return paramR;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<x.a, ah>
  {
    b(x paramx, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<i, l>
  {
    c(o paramo, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<at.b<i>, aa<j>>
  {
    public static final d TB;
    
    static
    {
      AppMethodBeat.i(203126);
      TB = new d();
      AppMethodBeat.o(203126);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "it", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<i, j>
  {
    e(o paramo, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<at.b<i>, aa<l>>
  {
    f(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.o
 * JD-Core Version:    0.7.0.1
 */