package com.tencent.mm.aj.c.a;

import androidx.compose.a.a.u;
import androidx.compose.a.v;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "rememberSnapperFlingBehavior", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperFlingBehavior;", "layoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "maximumFlingDistance", "Lkotlin/Function1;", "(Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperFlingBehavior;", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final e a(h paramh, u<Float> paramu, androidx.compose.a.a.g<Float> paramg, b<? super h, Float> paramb, androidx.compose.runtime.h paramh1, int paramInt)
  {
    AppMethodBeat.i(238851);
    s.u(paramh, "layoutInfo");
    paramh1.bx(1842353190);
    if ((paramInt & 0x2) != 0) {
      paramu = v.b(paramh1);
    }
    if ((paramInt & 0x4) != 0)
    {
      paramg = f.ohN;
      paramg = f.bzi();
    }
    if ((paramInt & 0x8) != 0)
    {
      paramb = f.ohN;
      paramb = f.bzj();
    }
    paramh1.bx(-3685570);
    int i = 0;
    Object localObject1;
    for (paramInt = 0; i < 4; paramInt = paramh1.G(localObject1) | paramInt)
    {
      localObject1 = new Object[] { paramh, paramu, paramg, paramb }[i];
      i += 1;
    }
    Object localObject2 = paramh1.or();
    if (paramInt == 0)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new e(paramh, paramb, paramu, paramg);
      paramh1.F(localObject1);
    }
    paramh1.od();
    paramh = (e)localObject1;
    paramh1.od();
    AppMethodBeat.o(238851);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.a.g
 * JD-Core Version:    0.7.0.1
 */