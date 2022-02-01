package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
public final class u$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  public u$b(u paramu, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(363543);
    paramObject = (d)new b(this.AVV, paramd);
    AppMethodBeat.o(363543);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(363539);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(363539);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    u.i(this.AVV);
    paramObject = this.AVV.finishLoadingMoreCallback;
    if (paramObject != null) {
      paramObject.invoke();
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(363539);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.b
 * JD-Core Version:    0.7.0.1
 */