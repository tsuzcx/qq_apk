package com.tencent.mm.mj_template.sns.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
final class b$c
  extends k
  implements m<String, d<? super Boolean>, Object>
{
  int label;
  
  b$c(d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(240295);
    paramObject = (d)new c(paramd);
    AppMethodBeat.o(240295);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(240292);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(240292);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = Boolean.FALSE;
    AppMethodBeat.o(240292);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */