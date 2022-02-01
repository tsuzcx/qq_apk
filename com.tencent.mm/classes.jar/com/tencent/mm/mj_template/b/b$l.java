package com.tencent.mm.mj_template.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.fxr;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$l
  extends k
  implements m<aq, d<? super fxr>, Object>
{
  int label;
  
  b$l(String paramString, int paramInt, d<? super l> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(239574);
    paramObject = (d)new l(this.oad, this.ofW, paramd);
    AppMethodBeat.o(239574);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(239569);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(239569);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = a.ofK;
      Object localObject = this.oad;
      int i = this.ofW;
      d locald = (d)this;
      this.label = 1;
      localObject = paramObject.a((String)localObject, i, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(239569);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (css)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(239569);
      return null;
    }
    paramObject = paramObject.aayM;
    AppMethodBeat.o(239569);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.b.b.l
 * JD-Core Version:    0.7.0.1
 */