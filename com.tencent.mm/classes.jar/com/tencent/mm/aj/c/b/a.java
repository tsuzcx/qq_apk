package com.tencent.mm.aj.c.b;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import androidx.compose.ui.g.b.a.a;
import androidx.compose.ui.g.b.g;
import androidx.compose.ui.n.r;
import androidx.compose.ui.n.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/pager/ConsumeFlingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "consumeHorizontal", "", "consumeVertical", "(ZZ)V", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  implements androidx.compose.ui.g.b.a
{
  private final boolean ohR;
  private final boolean ohS;
  
  public a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ohR = paramBoolean1;
    this.ohS = paramBoolean2;
  }
  
  public final long a(long paramLong1, long paramLong2, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(238793);
    Object localObject = g.aKL;
    if (g.C(paramInt, g.wh()))
    {
      boolean bool1 = this.ohR;
      boolean bool2 = this.ohS;
      if (bool1) {}
      for (float f1 = e.F(paramLong2);; f1 = 0.0F)
      {
        if (bool2) {
          f2 = e.G(paramLong2);
        }
        paramLong1 = f.x(f1, f2);
        AppMethodBeat.o(238793);
        return paramLong1;
      }
    }
    localObject = e.avo;
    paramLong1 = e.su();
    AppMethodBeat.o(238793);
    return paramLong1;
  }
  
  public final Object a(long paramLong1, long paramLong2, d<? super r> paramd)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(238799);
    boolean bool1 = this.ohR;
    boolean bool2 = this.ohS;
    if (bool1) {}
    for (float f1 = r.F(paramLong2);; f1 = 0.0F)
    {
      if (bool2) {
        f2 = r.G(paramLong2);
      }
      paramd = r.bs(s.K(f1, f2));
      AppMethodBeat.o(238799);
      return paramd;
    }
  }
  
  public final Object a(long paramLong, d<? super r> paramd)
  {
    AppMethodBeat.i(238809);
    paramd = a.a.vT();
    AppMethodBeat.o(238809);
    return paramd;
  }
  
  public final long b(long paramLong, int paramInt)
  {
    AppMethodBeat.i(238803);
    paramLong = a.a.a(this);
    AppMethodBeat.o(238803);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.b.a
 * JD-Core Version:    0.7.0.1
 */