package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.car_license_plate.a.f;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class p$e$a
  extends j
  implements m<ak, kotlin.d.d<? super x>, Object>
{
  Object L$0;
  int label;
  private ak p$;
  
  p$e$a(p.e parame, String paramString, kotlin.d.d paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(281822);
    p.k(paramd, "completion");
    paramd = new a(this.oDx, this.oDy, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(281822);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(281824);
    paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(281824);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(281821);
    a locala = a.aaAA;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(281821);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
    }
    try
    {
      Object localObject = this.oDy;
      String str = this.oDx.owL.getAppId();
      p.j(str, "env.appId");
      localObject = new f((String)localObject, str);
      this.L$0 = paramObject;
      this.label = 1;
      paramObject = ((f)localObject).c(this);
      if (paramObject != locala) {
        break label129;
      }
      AppMethodBeat.o(281821);
      return locala;
    }
    catch (com.tencent.mm.plugin.car_license_plate.a.d paramObject)
    {
      label129:
      break label129;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = x.aazN;
    AppMethodBeat.o(281821);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.p.e.a
 * JD-Core Version:    0.7.0.1
 */