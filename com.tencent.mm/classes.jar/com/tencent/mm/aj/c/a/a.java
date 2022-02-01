package com.tencent.mm.aj.c.a;

import androidx.compose.foundation.lazy.aa;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.n.g;
import androidx.compose.ui.platform.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "rememberLazyListSnapperLayoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/LazyListSnapperLayoutInfo;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapOffsetForItem", "Lkotlin/Function2;", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;", "Lkotlin/ParameterName;", "name", "layoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;", "item", "", "endContentPadding", "Landroidx/compose/ui/unit/Dp;", "rememberLazyListSnapperLayoutInfo-6a0pyJM", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;II)Lcom/tencent/mm/mm_compose/widget/page_snapper/LazyListSnapperLayoutInfo;", "rememberSnapperFlingBehavior", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperFlingBehavior;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "maximumFlingDistance", "Lkotlin/Function1;", "rememberSnapperFlingBehavior-osbwsH8", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperFlingBehavior;", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final b a(aa paramaa, m<? super h, ? super i, Integer> paramm, float paramFloat, androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(238859);
    s.u(paramaa, "lazyListState");
    paramh.bx(440266510);
    if ((paramInt & 0x2) != 0)
    {
      paramm = d.ohv;
      paramm = d.bzh();
    }
    if ((paramInt & 0x4) != 0) {
      paramFloat = g.ai(0.0F);
    }
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(paramaa);
    boolean bool2 = paramh.G(paramm);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!(bool1 | bool2))
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new b(paramaa, paramm, (byte)0);
      paramh.F(localObject1);
    }
    paramh.od();
    ((b)localObject1).uP(((androidx.compose.ui.n.d)paramh.a((p)u.yU())).v(paramFloat));
    paramaa = (b)localObject1;
    paramh.od();
    AppMethodBeat.o(238859);
    return paramaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.a.a
 * JD-Core Version:    0.7.0.1
 */