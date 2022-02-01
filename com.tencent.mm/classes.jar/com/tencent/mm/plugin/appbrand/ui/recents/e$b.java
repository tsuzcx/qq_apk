package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.r.c.b;
import com.tencent.mm.protocal.protobuf.chd;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class e$b
  extends j
  implements kotlin.g.a.m<ak, d<? super x>, Object>
{
  Object L$0;
  int label;
  Object oDA;
  private ak p$;
  Object pGq;
  Object pGr;
  Object rdb;
  int rdc;
  int rdd;
  
  e$b(e parame, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(278988);
    p.k(paramd, "completion");
    paramd = new b(this.rda, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(278988);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(278990);
    paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(278990);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(278986);
    a locala = a.aaAA;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(278986);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localObject1 = new com.tencent.mm.plugin.appbrand.r.c();
      this.L$0 = paramObject;
      this.label = 1;
      localObject2 = new n(kotlin.d.a.b.k(this), 1);
      ((n)localObject2).iQM();
      localObject4 = (kotlinx.coroutines.m)localObject2;
      localObject3 = new com.tencent.mm.plugin.appbrand.r.c.a((kotlinx.coroutines.m)localObject4, (com.tencent.mm.plugin.appbrand.r.c)localObject1);
      ((kotlinx.coroutines.m)localObject4).am((kotlin.g.a.b)new c.b((com.tencent.mm.plugin.appbrand.r.c.a)localObject3, (com.tencent.mm.plugin.appbrand.r.c)localObject1));
      localObject4 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject4, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject4).aGY().a(((com.tencent.mm.plugin.appbrand.r.c)localObject1).getType(), (com.tencent.mm.an.i)localObject3);
      localObject3 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject3, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject3).aGY().b((q)localObject1);
      localObject1 = ((n)localObject2).getResult();
      if (localObject1 == a.aaAA) {
        p.k(this, "frame");
      }
      if (localObject1 == locala)
      {
        AppMethodBeat.o(278986);
        return locala;
      }
      break;
    case 1: 
      localObject2 = (ak)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.an.c.a)localObject1;
      int i = ((com.tencent.mm.an.c.a)localObject1).errType;
      int j = ((com.tencent.mm.an.c.a)localObject1).errCode;
      localObject2 = ((com.tencent.mm.an.c.a)localObject1).errMsg;
      localObject3 = new aa.f();
      ((aa.f)localObject3).aaBC = ((chd)((com.tencent.mm.an.c.a)localObject1).lBJ);
      localObject4 = ((com.tencent.mm.an.c.a)localObject1).fzz;
      if (localObject4 == null)
      {
        paramObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.netscene.NetSceneGetWxaOrderInfo");
        AppMethodBeat.o(278986);
        throw paramObject;
      }
      localObject4 = (com.tencent.mm.plugin.appbrand.r.c)localObject4;
      if ((i != 0) || (j != 0))
      {
        new StringBuilder("NetSceneGetWxaOrderInfo error errType=").append(i).append(", errCode=").append(j).append(", errMsg=").append((String)localObject2);
        com.tencent.d.f.h.ioq();
        paramObject = x.aazN;
        AppMethodBeat.o(278986);
        return paramObject;
      }
      f localf = (f)bc.iRr();
      kotlin.g.a.m localm = (kotlin.g.a.m)new a((aa.f)localObject3, null, this);
      this.L$0 = paramObject;
      this.oDA = localObject1;
      this.rdc = i;
      this.rdd = j;
      this.pGq = localObject2;
      this.pGr = localObject3;
      this.rdb = localObject4;
      this.label = 2;
      if (kotlinx.coroutines.i.a(localf, localm, this) == locala)
      {
        AppMethodBeat.o(278986);
        return locala;
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(278986);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$1$1$1"})
  static final class a
    extends j
    implements kotlin.g.a.m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    a(aa.f paramf, d paramd, e.b paramb)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(272290);
      p.k(paramd, "completion");
      paramd = new a(this.rde, paramd, jdField_this);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(272290);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(272291);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(272291);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272289);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272289);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      jdField_this.rda.jO(((chd)this.rde.aaBC).ToC);
      paramObject = x.aazN;
      AppMethodBeat.o(272289);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.b
 * JD-Core Version:    0.7.0.1
 */