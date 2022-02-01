package androidx.paging.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.z;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/Multicaster;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "bufferSize", "", "source", "Lkotlinx/coroutines/flow/Flow;", "piggybackingDownstream", "", "onEach", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "keepUpstreamAlive", "(Lkotlinx/coroutines/CoroutineScope;ILkotlinx/coroutines/flow/Flow;ZLkotlin/jvm/functions/Function2;Z)V", "channelManager", "Landroidx/paging/multicast/ChannelManager;", "getChannelManager", "()Landroidx/paging/multicast/ChannelManager;", "channelManager$delegate", "Lkotlin/Lazy;", "flow", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/functions/Function2;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
public final class d<T>
{
  public final g<T> bLH;
  final boolean bSb;
  final m<T, kotlin.d.d<? super ah>, Object> bSc;
  final boolean bSd;
  private final kotlin.j bSp;
  final g<T> bSq;
  final aq scope;
  
  private d(aq paramaq, final int paramInt, g<? extends T> paramg, m<? super T, ? super kotlin.d.d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(197154);
    this.scope = paramaq;
    this.bSq = paramg;
    this.bSb = false;
    this.bSc = paramm;
    this.bSd = true;
    this.bSp = kotlin.k.a(kotlin.o.aiuF, (kotlin.g.a.a)new a(this, paramInt));
    this.bLH = kotlinx.coroutines.b.j.y((m)new b(this, null));
    AppMethodBeat.o(197154);
  }
  
  public final c<T> Ir()
  {
    AppMethodBeat.i(197174);
    c localc = (c)this.bSp.getValue();
    AppMethodBeat.o(197174);
    return localc;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/multicast/ChannelManager;", "T", "invoke"}, k=3, mv={1, 4, 2})
  static final class a
    extends u
    implements kotlin.g.a.a<c<T>>
  {
    a(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class b
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.b.h<? super T>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(197169);
      s.u(paramd, "completion");
      paramd = new b(this.bSr, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(197169);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(197175);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(197175);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197162);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197162);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.h)this.L$0;
        Object localObject = kotlinx.coroutines.a.k.a(2147483647, null, 6);
        localObject = kotlinx.coroutines.b.o.d(kotlinx.coroutines.b.j.y((m)new a(kotlinx.coroutines.b.o.a(kotlinx.coroutines.b.k.a((x)localObject), (m)new b(this, (kotlinx.coroutines.a.h)localObject, null)), null)), (q)new c(this, (kotlinx.coroutines.a.h)localObject, null));
        this.label = 1;
        if (((g)localObject).a(paramObject, this) == locala)
        {
          AppMethodBeat.o(197162);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(197162);
      return paramObject;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k=3, mv={1, 4, 2})
    public static final class a
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.b.h<? super T>, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      public a(g paramg, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(197122);
        paramd = new a(this.bSt, paramd);
        paramd.L$0 = paramObject;
        AppMethodBeat.o(197122);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(197129);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(197129);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197110);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(197110);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          final kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)this.L$0;
          paramObject = this.bSt;
          localh = (kotlinx.coroutines.b.h)new kotlinx.coroutines.b.h()
          {
            public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
            {
              AppMethodBeat.i(197144);
              Object localObject1;
              if ((paramAnonymousd instanceof 1))
              {
                localObject1 = (1)paramAnonymousd;
                if ((((1)localObject1).label & 0x80000000) != 0) {
                  ((1)localObject1).label += -2147483648;
                }
              }
              for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                  {
                    Object L$0;
                    int label;
                    
                    public final Object invokeSuspend(Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(197136);
                      this.result = paramAnonymous2Object;
                      this.label |= 0x80000000;
                      paramAnonymous2Object = this.bSv.a(null, this);
                      AppMethodBeat.o(197136);
                      return paramAnonymous2Object;
                    }
                  })
              {
                localObject2 = paramAnonymousd.result;
                localObject1 = kotlin.d.a.a.aiwj;
                switch (paramAnonymousd.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(197144);
                  throw paramAnonymousObject;
                }
              }
              ResultKt.throwOnFailure(localObject2);
              Object localObject2 = localh;
              paramAnonymousObject = (c.c.b.c)paramAnonymousObject;
              Object localObject3 = paramAnonymousObject.value;
              paramAnonymousd.L$0 = paramAnonymousObject;
              paramAnonymousd.label = 1;
              if (((kotlinx.coroutines.b.h)localObject2).a(localObject3, paramAnonymousd) == localObject1)
              {
                AppMethodBeat.o(197144);
                return localObject1;
                paramAnonymousObject = (c.c.b.c)paramAnonymousd.L$0;
                ResultKt.throwOnFailure(localObject2);
              }
              paramAnonymousObject.bSo.iC(ah.aiuX);
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(197144);
              return paramAnonymousObject;
            }
          };
          this.label = 1;
          if (paramObject.a(localh, this) == locala)
          {
            AppMethodBeat.o(197110);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(197110);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
    static final class b
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.b.h<? super c.c.b.c<T>>, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(d.b paramb, kotlinx.coroutines.a.h paramh, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(197112);
        s.u(paramd, "completion");
        paramObject = new b(this.bSw, this.aaM, paramd);
        AppMethodBeat.o(197112);
        return paramObject;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(197117);
        paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(197117);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197105);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(197105);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.bSw.bSr.Ir();
          Object localObject = (ab)this.aaM;
          this.label = 1;
          localObject = paramObject.bSa.b(new c.c.a((ab)localObject), this);
          paramObject = localObject;
          if (localObject != kotlin.d.a.a.aiwj) {
            paramObject = ah.aiuX;
          }
          if (paramObject == locala)
          {
            AppMethodBeat.o(197105);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(197105);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
    static final class c
      extends kotlin.d.b.a.k
      implements q<kotlinx.coroutines.b.h<? super T>, Throwable, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      c(d.b paramb, kotlinx.coroutines.a.h paramh, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
      {
        AppMethodBeat.i(197114);
        paramObject1 = (kotlinx.coroutines.b.h)paramObject1;
        paramObject2 = (kotlin.d.d)paramObject3;
        s.u(paramObject1, "$this$create");
        s.u(paramObject2, "continuation");
        paramObject1 = ((c)new c(this.bSw, this.aaM, paramObject2)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(197114);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197108);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(197108);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.bSw.bSr.Ir();
          Object localObject = (ab)this.aaM;
          this.label = 1;
          localObject = paramObject.bSa.b(new c.c.c((ab)localObject), this);
          paramObject = localObject;
          if (localObject != kotlin.d.a.a.aiwj) {
            paramObject = ah.aiuX;
          }
          if (paramObject == locala)
          {
            AppMethodBeat.o(197108);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(197108);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a.d
 * JD-Core Version:    0.7.0.1
 */