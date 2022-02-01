package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$l$1
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  c$l$1(d<? super 1> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360795);
    paramObject = (d)new 1(paramd);
    AppMethodBeat.o(360795);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(360786);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360786);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (d)this;
      this.label = 1;
      if (bb.ax(paramObject) == locala)
      {
        AppMethodBeat.o(360786);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = new f();
    AppMethodBeat.o(360786);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c.l.1
 * JD-Core Version:    0.7.0.1
 */