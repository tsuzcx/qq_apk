package com.tencent.mm.plugin.finder.nearby.service.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$b(a parama, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(339921);
    paramObject = (d)new b(this.ERs, paramd);
    AppMethodBeat.o(339921);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(339916);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(339916);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = b.EOI;
      paramObject = b.a.eFY();
      if (paramObject != null)
      {
        d locald = (d)this;
        this.label = 1;
        if (paramObject.af(locald) == locala)
        {
          AppMethodBeat.o(339916);
          return locala;
        }
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    a.a(this.ERs);
    paramObject = ah.aiuX;
    AppMethodBeat.o(339916);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.service.impl.a.b
 * JD-Core Version:    0.7.0.1
 */