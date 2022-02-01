package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.l;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"NULL", "", "simpleFlatMapLatest", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "simpleMapLatest", "simpleRunningReduce", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleScan", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleTransformLatest", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "paging-common"}, k=2, mv={1, 4, 2})
public final class r
{
  private static final Object bfF;
  
  static
  {
    AppMethodBeat.i(197097);
    bfF = new Object();
    AppMethodBeat.o(197097);
  }
  
  public static final <T, R> g<R> a(g<? extends T> paramg, final q<? super R, ? super T, ? super kotlin.d.d<? super R>, ? extends Object> paramq)
  {
    AppMethodBeat.i(197087);
    s.u(paramg, "$this$simpleScan");
    s.u(paramq, "operation");
    paramg = j.y((m)new b(paramg, null, paramq, null));
    AppMethodBeat.o(197087);
    return paramg;
  }
  
  public static final <T> g<T> b(g<? extends T> paramg, final q<? super T, ? super T, ? super kotlin.d.d<? super T>, ? extends Object> paramq)
  {
    AppMethodBeat.i(197090);
    s.u(paramg, "$this$simpleRunningReduce");
    s.u(paramq, "operation");
    paramg = j.y((m)new a(paramg, paramq, null));
    AppMethodBeat.o(197090);
    return paramg;
  }
  
  public static final <T, R> g<R> c(g<? extends T> paramg, final q<? super h<? super R>, ? super T, ? super kotlin.d.d<? super ah>, ? extends Object> paramq)
  {
    AppMethodBeat.i(197094);
    s.u(paramg, "$this$simpleTransformLatest");
    s.u(paramq, "transform");
    paramg = bg.d((m)new c(paramg, paramq, null));
    AppMethodBeat.o(197094);
    return paramg;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class a
    extends k
    implements m<h<? super T>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(g paramg, q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196787);
      s.u(paramd, "completion");
      paramd = new a(this.bMA, paramq, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196787);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196797);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196797);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196776);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196776);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        final h localh = (h)this.L$0;
        final ah.f localf = new ah.f();
        localf.aqH = r.HI();
        paramObject = this.bMA;
        localh = (h)new a(this, localh, localf);
        this.label = 1;
        if (paramObject.a(localh, this) == locala)
        {
          AppMethodBeat.o(196776);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(196776);
      return paramObject;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 4, 2})
    public static final class a
      implements h<T>
    {
      public a(r.a parama, h paramh, ah.f paramf) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(196583);
        kotlin.d.b.a.d local1;
        if ((paramd instanceof 1))
        {
          local1 = (1)paramd;
          if ((local1.label & 0x80000000) != 0) {
            local1.label += -2147483648;
          }
        }
        Object localObject1;
        a locala;
        for (;;)
        {
          localObject1 = local1.result;
          locala = a.aiwj;
          switch (local1.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(196583);
            throw paramObject;
            local1 = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              Object Uf;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(197199);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.bMF.a(null, this);
                AppMethodBeat.o(197199);
                return paramAnonymousObject;
              }
            };
          }
        }
        ResultKt.throwOnFailure(localObject1);
        paramd = localf;
        if (localf.aqH == r.HI())
        {
          localObject1 = paramObject;
          paramObject = this;
          paramd.aqH = localObject1;
          paramd = localh;
          paramObject = localf.aqH;
          local1.L$0 = null;
          local1.Uf = null;
          local1.label = 2;
          if (paramd.a(paramObject, local1) == locala)
          {
            AppMethodBeat.o(196583);
            return locala;
          }
        }
        else
        {
          localObject1 = this.bMC.bMB;
          Object localObject2 = localf.aqH;
          local1.L$0 = this;
          local1.Uf = paramd;
          local1.label = 1;
          localObject1 = ((q)localObject1).invoke(localObject2, paramObject, local1);
          if (localObject1 != locala) {
            break label300;
          }
          AppMethodBeat.o(196583);
          return locala;
          paramd = (ah.f)local1.Uf;
          paramObject = (a)local1.L$0;
          ResultKt.throwOnFailure(localObject1);
        }
        for (;;)
        {
          break;
          ResultKt.throwOnFailure(localObject1);
          paramObject = ah.aiuX;
          AppMethodBeat.o(196583);
          return paramObject;
          label300:
          paramObject = this;
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class b
    extends k
    implements m<h<? super R>, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    int label;
    
    b(g paramg, Object paramObject, q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196783);
      s.u(paramd, "completion");
      paramd = new b(this.bMG, this.bMH, paramq, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196783);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196790);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196790);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(196777);
      a locala = a.aiwj;
      final h localh;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196777);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localh = (h)this.L$0;
        paramObject = new ah.f();
        paramObject.aqH = this.bMH;
        localObject = paramObject.aqH;
        this.L$0 = localh;
        this.Uf = paramObject;
        this.label = 1;
        if (localh.a(localObject, this) == locala)
        {
          AppMethodBeat.o(196777);
          return locala;
        }
        break;
      case 1: 
        localObject = (ah.f)this.Uf;
        localh = (h)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      for (;;)
      {
        localObject = this.bMG;
        paramObject = (h)new a(this, localh, paramObject);
        this.L$0 = null;
        this.Uf = null;
        this.label = 2;
        if (((g)localObject).a(paramObject, this) == locala)
        {
          AppMethodBeat.o(196777);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(196777);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 4, 2})
    public static final class a
      implements h<T>
    {
      public a(r.b paramb, h paramh, ah.f paramf) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(196918);
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        a locala;
        for (paramd = (kotlin.d.d)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              Object Uf;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(196892);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.bMJ.a(null, this);
                AppMethodBeat.o(196892);
                return paramAnonymousObject;
              }
            })
        {
          localObject3 = paramd.result;
          locala = a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(196918);
            throw paramObject;
          }
        }
        ResultKt.throwOnFailure(localObject3);
        Object localObject2 = paramObject;
        Object localObject1 = this.bMI.bMB;
        Object localObject3 = paramObject.aqH;
        paramd.L$0 = this;
        paramd.Uf = localObject2;
        paramd.label = 1;
        localObject1 = ((q)localObject1).invoke(localObject3, paramObject, paramd);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(196918);
          return locala;
          localObject1 = (ah.f)paramd.Uf;
          paramObject = (a)paramd.L$0;
          ResultKt.throwOnFailure(localObject3);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
        for (;;)
        {
          ((ah.f)localObject2).aqH = localObject1;
          localObject1 = localh;
          paramObject = paramObject.aqH;
          paramd.L$0 = null;
          paramd.Uf = null;
          paramd.label = 2;
          if (((h)localObject1).a(paramObject, paramd) == locala)
          {
            AppMethodBeat.o(196918);
            return locala;
            ResultKt.throwOnFailure(localObject3);
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(196918);
          return paramObject;
          paramObject = this;
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Landroidx/paging/SimpleProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class c
    extends k
    implements m<bh<R>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(g paramg, q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196744);
      s.u(paramd, "completion");
      paramd = new c(this.bMK, paramq, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196744);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196751);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196751);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196736);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196736);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject = (bh)this.L$0;
        paramObject = this.bMK;
        localObject = (m)new k(new i((ab)localObject), null)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(196847);
            s.u(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.bMM, this.bMN, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            AppMethodBeat.o(196847);
            return paramAnonymousd;
          }
          
          public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(196851);
            paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(ah.aiuX);
            AppMethodBeat.o(196851);
            return paramAnonymousObject1;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(196838);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196838);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = this.L$0;
              q localq = this.bMM.bML;
              i locali = this.bMN;
              this.label = 1;
              if (localq.invoke(locali, paramAnonymousObject, this) == locala)
              {
                AppMethodBeat.o(196838);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(196838);
            return paramAnonymousObject;
          }
        };
        this.label = 1;
        if (l.a(paramObject, (m)localObject, this) == locala)
        {
          AppMethodBeat.o(196736);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(196736);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.r
 * JD-Core Version:    0.7.0.1
 */