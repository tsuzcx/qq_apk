package com.tencent.mm.live.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class LiveUIA$b
  extends j
  implements m<ak, d<? super x>, Object>
{
  int label;
  private ak p$;
  
  LiveUIA$b(LiveUIA paramLiveUIA, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(191956);
    p.k(paramd, "completion");
    paramd = new b(this.kIs, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(191956);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191957);
    paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(191957);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(191950);
    a locala = a.aaAA;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(191950);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    b.a((Activity)this.kIs, null);
    this.kIs.getSwipeBackLayout().Hp(true);
    paramObject = x.aazN;
    AppMethodBeat.o(191950);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA.b
 * JD-Core Version:    0.7.0.1
 */