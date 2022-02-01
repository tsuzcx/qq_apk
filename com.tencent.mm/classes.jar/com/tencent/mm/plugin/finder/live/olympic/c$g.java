package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.a;
import com.tencent.mm.plugin.finder.utils.bi;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctu;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$g
  extends k
  implements m<aq, d<? super Object>, Object>
{
  Object L$0;
  int label;
  
  c$g(d<? super g> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360365);
    paramObject = (d)new g(paramd);
    AppMethodBeat.o(360365);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(360357);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360357);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    try
    {
      paramObject = com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.CPi;
      Object localObject = bi.GlP;
      localObject = new ctt();
      d locald = (d)this;
      this.L$0 = paramObject;
      this.label = 1;
      paramObject = bi.a((ctt)localObject, locald);
      localObject = paramObject;
      if (paramObject == locala)
      {
        AppMethodBeat.o(360357);
        return locala;
        ResultKt.throwOnFailure(paramObject);
        localObject = paramObject;
      }
      localObject = (ctu)localObject;
      if (localObject == null) {}
      for (paramObject = null; paramObject == null; paramObject = ((ctu)localObject).YGh)
      {
        AppMethodBeat.o(360357);
        return null;
      }
      paramObject = ((ctu)localObject).YGh;
      s.checkNotNull(paramObject);
      s.s(paramObject, "respose.torch_cert!!");
      paramObject = new com.tencent.mm.plugin.finder.live.olympic.certificate.data.a(a.a.a(paramObject), ((ctu)localObject).YGi);
      AppMethodBeat.o(360357);
      return paramObject;
    }
    catch (o paramObject)
    {
      AppMethodBeat.o(360357);
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c.g
 * JD-Core Version:    0.7.0.1
 */