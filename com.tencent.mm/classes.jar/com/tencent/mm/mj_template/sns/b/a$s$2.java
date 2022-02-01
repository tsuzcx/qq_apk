package com.tencent.mm.mj_template.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.q;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
final class a$s$2
  extends k
  implements q<h<? super Float>, Throwable, d<? super ah>, Object>
{
  int label;
  
  a$s$2(kotlin.g.a.a<ah> parama, d<? super 2> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(240221);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(240221);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    Log.printErrStackTrace("MicroMsg.SnsTemplate.TemplateControlUIC", (Throwable)this.L$0, "maas error", new Object[0]);
    this.ofJ.invoke();
    paramObject = ah.aiuX;
    AppMethodBeat.o(240221);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.b.a.s.2
 * JD-Core Version:    0.7.0.1
 */