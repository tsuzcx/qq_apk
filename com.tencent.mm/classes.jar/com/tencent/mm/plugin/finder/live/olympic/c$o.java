package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.a;
import com.tencent.mm.plugin.finder.utils.bi;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.fsf;
import com.tencent.mm.protocal.protobuf.fsg;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$o
  extends kotlin.d.b.a.k
  implements m<aq, d<? super Object>, Object>
{
  Object L$0;
  int label;
  
  c$o(boolean paramBoolean1, boolean paramBoolean2, String paramString, d<? super o> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360391);
    paramObject = (d)new o(this.CNC, this.CND, this.CNE, paramd);
    AppMethodBeat.o(360391);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(360385);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360385);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    try
    {
      paramObject = com.tencent.mm.ui.component.k.aeZF;
      Object localObject2 = (g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class);
      paramObject = com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.CPi;
      Object localObject1 = bi.GlP;
      localObject1 = new fsf();
      boolean bool1 = this.CNC;
      boolean bool2 = this.CND;
      String str = this.CNE;
      ((fsf)localObject1).longitude = ((Number)((g)localObject2).dUh().bsC).floatValue();
      ((fsf)localObject1).latitude = ((Number)((g)localObject2).dUh().bsD).floatValue();
      if (bool1)
      {
        bool1 = true;
        ((fsf)localObject1).abOW = bool1;
        if (!bool2) {
          break label234;
        }
      }
      label234:
      for (bool1 = true;; bool1 = false)
      {
        ((fsf)localObject1).abOV = bool1;
        ((fsf)localObject1).name = str;
        localObject2 = ah.aiuX;
        localObject2 = (d)this;
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = bi.a((fsf)localObject1, (d)localObject2);
        localObject1 = paramObject;
        if (paramObject != locala) {
          break label246;
        }
        AppMethodBeat.o(360385);
        return locala;
        bool1 = false;
        break;
      }
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      label246:
      localObject1 = (fsg)localObject1;
      if (localObject1 == null) {}
      for (paramObject = null; paramObject == null; paramObject = ((fsg)localObject1).YGh)
      {
        AppMethodBeat.o(360385);
        return null;
      }
      paramObject = ((fsg)localObject1).YGh;
      s.checkNotNull(paramObject);
      s.s(paramObject, "respose.torch_cert!!");
      paramObject = new com.tencent.mm.plugin.finder.live.olympic.certificate.data.a(a.a.a(paramObject), ((fsg)localObject1).YGi);
      AppMethodBeat.o(360385);
      return paramObject;
    }
    catch (o paramObject)
    {
      AppMethodBeat.o(360385);
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c.o
 * JD-Core Version:    0.7.0.1
 */