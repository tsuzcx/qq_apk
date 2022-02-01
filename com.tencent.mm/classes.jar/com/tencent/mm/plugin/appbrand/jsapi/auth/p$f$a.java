package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.car_license_plate.a.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class p$f$a
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  p$f$a(String paramString, g paramg, boolean paramBoolean, kotlin.d.d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(326743);
    paramObject = (kotlin.d.d)new a(this.rGM, this.rCg, this.rGN, paramd);
    AppMethodBeat.o(326743);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(326740);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(326740);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    try
    {
      paramObject = this.rGM;
      Object localObject = this.rCg.getAppId();
      s.s(localObject, "env.appId");
      paramObject = new f(paramObject, (String)localObject, this.rGN);
      localObject = (kotlin.d.d)this;
      this.label = 1;
      paramObject = paramObject.U((kotlin.d.d)localObject);
      if (paramObject != locala) {
        break label122;
      }
      AppMethodBeat.o(326740);
      return locala;
    }
    catch (com.tencent.mm.plugin.car_license_plate.a.d paramObject)
    {
      label122:
      break label122;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(326740);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.p.f.a
 * JD-Core Version:    0.7.0.1
 */