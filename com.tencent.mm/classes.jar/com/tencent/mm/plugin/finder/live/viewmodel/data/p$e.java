package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class p$e
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  p$e(p paramp, d<? super e> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(371601);
    paramd = new e(this.akfV, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(371601);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(371595);
    a locala = a.aiwj;
    Object localObject2;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(371595);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      if (!ar.a(paramObject)) {
        break label235;
      }
      localObject1 = this.akfV.akfM;
      localObject2 = (d)this;
      this.L$0 = paramObject;
      this.label = 1;
      localObject2 = ((p.d)localObject1).aF((d)localObject2);
      localObject1 = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(371595);
        return locala;
      }
    case 1: 
      localObject2 = (aq)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
      localObject1 = (p.c)localObject1;
      if (!((p.c)localObject1).akfT) {
        break label235;
      }
      long l = Math.max(((p.c)localObject1).akfU, this.akfV.akfN);
      localObject1 = (d)this;
      this.L$0 = paramObject;
      this.label = 2;
      if (bb.e(l, (d)localObject1) != locala) {
        break label246;
      }
      AppMethodBeat.o(371595);
      return locala;
    }
    Object localObject1 = (aq)this.L$0;
    ResultKt.throwOnFailure(paramObject);
    paramObject = localObject1;
    label235:
    label246:
    for (;;)
    {
      break;
      paramObject = ah.aiuX;
      AppMethodBeat.o(371595);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.p.e
 * JD-Core Version:    0.7.0.1
 */