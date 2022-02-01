package com.tencent.mm.mj_template.album_template.multi_template.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>"}, k=3, mv={1, 5, 1}, xi=48)
final class d$c
  extends k
  implements q<String, Boolean, d<? super Boolean>, Object>
{
  int label;
  
  d$c(d<? super c> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(240685);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(240685);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = Boolean.FALSE;
    AppMethodBeat.o(240685);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.a.d.c
 * JD-Core Version:    0.7.0.1
 */