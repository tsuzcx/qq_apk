package com.tencent.mm.plugin.finder.nearby.service.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqr;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$c
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$c(boolean paramBoolean, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(339948);
    paramd = new c(this.ERt, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(339948);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(339935);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(339935);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      paramObject = new com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.c((kotlin.g.a.a)new u(this.ERt) {}, (cb)paramObject.getCoroutineContext().get((f.c)cb.ajws));
      d locald = (d)this;
      this.label = 1;
      if (paramObject.X(locald) == locala)
      {
        AppMethodBeat.o(339935);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(339935);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.service.impl.a.c
 * JD-Core Version:    0.7.0.1
 */