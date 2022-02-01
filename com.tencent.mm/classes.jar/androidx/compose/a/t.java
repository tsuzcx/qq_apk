package androidx.compose.a;

import androidx.compose.a.a.aa;
import androidx.compose.a.a.at;
import androidx.compose.a.a.at.b;
import androidx.compose.runtime.bm;
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
import androidx.compose.ui.n.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/SlideModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "lazyAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "slideIn", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/Slide;", "slideOut", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getLazyAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSlideIn", "()Landroidx/compose/runtime/State;", "getSlideOut", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "targetValueByState", "targetState", "fullSize", "Landroidx/compose/ui/unit/IntSize;", "targetValueByState-oFUgxo0", "(Landroidx/compose/animation/EnterExitState;J)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class t
  implements n
{
  final at<i>.a<j, androidx.compose.a.a.m> TJ;
  final bm<s> TK;
  final bm<s> TL;
  final b<at.b<i>, aa<j>> TM;
  
  public t(at<i>.a<j, androidx.compose.a.a.m> paramat, bm<s> parambm1, bm<s> parambm2)
  {
    AppMethodBeat.i(203113);
    this.TJ = paramat;
    this.TK = parambm1;
    this.TL = parambm2;
    this.TM = ((b)new c(this));
    AppMethodBeat.o(203113);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203152);
    paramf = n.a.a((n)this, paramf);
    AppMethodBeat.o(203152);
    return paramf;
  }
  
  public final q a(r paramr, final o paramo, final long paramLong)
  {
    AppMethodBeat.i(203123);
    kotlin.g.b.s.u(paramr, "$receiver");
    kotlin.g.b.s.u(paramo, "measurable");
    paramo = paramo.aw(paramLong);
    paramLong = androidx.compose.ui.n.m.an(paramo.width, paramo.height);
    paramr = r.a.a(paramr, paramo.width, paramo.height, (b)new b(this, paramo, paramLong));
    AppMethodBeat.o(203123);
    return paramr;
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203131);
    paramR = n.a.a((n)this, paramR, paramm);
    AppMethodBeat.o(203131);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203144);
    boolean bool = n.a.a((n)this, paramb);
    AppMethodBeat.o(203144);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203138);
    paramR = n.a.b((n)this, paramR, paramm);
    AppMethodBeat.o(203138);
    return paramR;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<x.a, ah>
  {
    b(t paramt, x paramx, long paramLong)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "it", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<i, j>
    {
      a(t paramt, long paramLong)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<at.b<i>, aa<j>>
  {
    c(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.t
 * JD-Core Version:    0.7.0.1
 */