package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$d
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$d(w<e> paramw, e parame, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237884);
    paramObject = (d)new d(this.ozg, this.ozh, paramd);
    AppMethodBeat.o(237884);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237879);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237879);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.ozg;
      e locale = this.ozh;
      d locald = (d)this;
      this.label = 1;
      if (paramObject.a(locale, locald) == locala)
      {
        AppMethodBeat.o(237879);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(237879);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.a.d
 * JD-Core Version:    0.7.0.1
 */