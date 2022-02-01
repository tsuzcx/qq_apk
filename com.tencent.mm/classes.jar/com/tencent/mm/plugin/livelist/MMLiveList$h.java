package com.tencent.mm.plugin.livelist;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class MMLiveList$h
  extends kotlin.d.b.a.j
  implements m<ak, d<? super x>, Object>
{
  int label;
  private ak p$;
  
  MMLiveList$h(MMLiveList paramMMLiveList, b paramb, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(217664);
    p.k(paramd, "completion");
    paramd = new h(this.EhS, this.jFa, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(217664);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(217666);
    paramObject1 = ((h)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(217666);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(217661);
    a locala = a.aaAA;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(217661);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    kotlin.a.j.lm((List)MMLiveList.a(this.EhS));
    this.jFa.invoke(MMLiveList.a(this.EhS));
    paramObject = x.aazN;
    AppMethodBeat.o(217661);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.MMLiveList.h
 * JD-Core Version:    0.7.0.1
 */