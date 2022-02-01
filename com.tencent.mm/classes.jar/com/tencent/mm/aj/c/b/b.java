package com.tencent.mm.aj.c.b;

import androidx.compose.a.v;
import androidx.compose.foundation.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c.a.a;
import com.tencent.mm.aj.c.a.d;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/pager/PagerDefaults;", "", "()V", "singlePageFlingDistance", "Lkotlin/Function1;", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;", "", "getSinglePageFlingDistance$annotations", "getSinglePageFlingDistance", "()Lkotlin/jvm/functions/Function1;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "state", "Lcom/tencent/mm/mm_compose/widget/pager/PagerState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "maximumFlingDistance", "endContentPadding", "Landroidx/compose/ui/unit/Dp;", "flingBehavior-FJfuzF0", "(Lcom/tencent/mm/mm_compose/widget/pager/PagerState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ohT;
  private static final kotlin.g.a.b<com.tencent.mm.aj.c.a.h, Float> ohU;
  
  static
  {
    AppMethodBeat.i(238806);
    ohT = new b();
    ohU = (kotlin.g.a.b)a.ohV;
    AppMethodBeat.o(238806);
  }
  
  public static i a(f paramf, float paramFloat, androidx.compose.runtime.h paramh)
  {
    AppMethodBeat.i(238802);
    s.u(paramf, "state");
    paramh.bx(-453249965);
    androidx.compose.a.a.u localu = v.b(paramh);
    Object localObject1 = com.tencent.mm.aj.c.a.f.ohN;
    localObject1 = com.tencent.mm.aj.c.a.f.bzi();
    kotlin.g.a.b localb = ohU;
    paramf = paramf.afi;
    Object localObject2 = d.ohv;
    localObject2 = d.bzg();
    s.u(paramf, "lazyListState");
    paramh.bx(1842353178);
    paramf = com.tencent.mm.aj.c.a.g.a((com.tencent.mm.aj.c.a.h)a.a(paramf, (m)localObject2, paramFloat, paramh, 0), localu, (androidx.compose.a.a.g)localObject1, localb, paramh, 0);
    paramh.od();
    paramh.od();
    paramf = (i)paramf;
    AppMethodBeat.o(238802);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "layoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.aj.c.a.h, Float>
  {
    public static final a ohV;
    
    static
    {
      AppMethodBeat.i(238789);
      ohV = new a();
      AppMethodBeat.o(238789);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.b.b
 * JD-Core Version:    0.7.0.1
 */