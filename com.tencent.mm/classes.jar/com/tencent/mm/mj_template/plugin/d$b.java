package com.tencent.mm.mj_template.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.fxr;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$b
  extends k
  implements m<aq, d<? super fxr>, Object>
{
  int label;
  
  d$b(r<String, Long> paramr, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(239629);
    paramObject = (d)new b(this.odD, paramd);
    AppMethodBeat.o(239629);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(239626);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(239626);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.mj_template.b.a.ofK;
      Object localObject = (String)this.odD.bsC;
      d locald = (d)this;
      this.label = 1;
      localObject = paramObject.a((String)localObject, 4, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(239626);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (css)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(239626);
      return null;
    }
    paramObject = paramObject.aayM;
    AppMethodBeat.o(239626);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.plugin.d.b
 * JD-Core Version:    0.7.0.1
 */