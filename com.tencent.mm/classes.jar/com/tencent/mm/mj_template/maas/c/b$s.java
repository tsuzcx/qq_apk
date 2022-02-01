package com.tencent.mm.mj_template.maas.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k=3, mv={1, 5, 1}, xi=48)
final class b$s
  extends k
  implements m<h<? super Float>, d<? super ah>, Object>
{
  int label;
  
  b$s(d<? super s> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(239934);
    paramObject = (d)new s(paramd);
    AppMethodBeat.o(239934);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(239926);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(239926);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(239926);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.c.b.s
 * JD-Core Version:    0.7.0.1
 */