package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class af$1
  extends k
  implements m<aq, d<? super kotlin.ah>, Object>
{
  Object Uf;
  int label;
  
  af$1(af paramaf, d<? super 1> paramd)
  {
    super(2, paramd);
  }
  
  public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(352608);
    paramd = new 1(this.Czs, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(352608);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(352601);
    Object localObject3 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(352601);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject1 = (aq)this.L$0;
      paramObject = this.Czs;
    }
    try
    {
      localObject2 = Result.Companion;
      localObject2 = (com.tencent.mm.am.b)new com.tencent.mm.plugin.finder.live.model.cgi.ah("", (byte)0);
      this.L$0 = localObject1;
      this.Uf = paramObject;
      this.label = 1;
      localObject2 = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject2, this);
      if (localObject2 != localObject3) {
        break label279;
      }
      AppMethodBeat.o(352601);
      return localObject3;
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        int i;
        localObject1 = Result.Companion;
        paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
      }
    }
    localObject2 = (af)this.Uf;
    localObject3 = (aq)this.L$0;
    ResultKt.throwOnFailure(paramObject);
    localObject1 = paramObject;
    paramObject = localObject2;
    localObject2 = localObject1;
    localObject1 = localObject3;
    localObject2 = (bhz)localObject2;
    cg.g(((aq)localObject1).getCoroutineContext());
    localObject1 = ((bhz)localObject2).ZRg;
    if (localObject1 == null) {
      i = 0;
    }
    for (;;)
    {
      if (i > 0) {
        af.g(paramObject);
      }
      paramObject = Result.constructor-impl(kotlin.ah.aiuX);
      paramObject = Result.exceptionOrNull-impl(paramObject);
      if (paramObject != null) {
        Log.printErrStackTrace(this.Czs.TAG, paramObject, "", new Object[0]);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(352601);
      return paramObject;
      localObject1 = ((bok)localObject1).ZWH;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = ((LinkedList)localObject1).size();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.af.1
 * JD-Core Version:    0.7.0.1
 */