package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.x;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ConflatedEventBus;", "T", "", "initialValue", "(Ljava/lang/Object;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "send", "", "data", "paging-common"}, k=1, mv={1, 4, 2})
public final class k<T>
{
  private final x<r<Integer, T>> bLG;
  final g<T> bLH;
  
  private k()
  {
    AppMethodBeat.i(197053);
    this.bLG = kotlinx.coroutines.b.ah.ji(new r(Integer.valueOf(-2147483648), null));
    this.bLH = ((g)new a((g)this.bLG));
    AppMethodBeat.o(197053);
  }
  
  public final void send(T paramT)
  {
    AppMethodBeat.i(197068);
    s.u(paramT, "data");
    this.bLG.setValue(new r(Integer.valueOf(((Number)((r)this.bLG.getValue()).bsC).intValue() + 1), paramT));
    AppMethodBeat.o(197068);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$6", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1"}, k=1, mv={1, 4, 2})
  public static final class a
    implements g<T>
  {
    public a(g paramg) {}
    
    public final Object a(h paramh, kotlin.d.d paramd)
    {
      AppMethodBeat.i(196894);
      paramh = this.bLp.a((h)new h()
      {
        public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
        {
          AppMethodBeat.i(196788);
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
                int label;
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(197006);
                  this.result = paramAnonymous2Object;
                  this.label |= 0x80000000;
                  paramAnonymous2Object = this.bLJ.a(null, this);
                  AppMethodBeat.o(197006);
                  return paramAnonymous2Object;
                }
              })
          {
            localObject2 = paramAnonymousd.result;
            localObject1 = a.aiwj;
            switch (paramAnonymousd.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196788);
              throw paramAnonymousObject;
            }
          }
          ResultKt.throwOnFailure(localObject2);
          Object localObject2 = this.bLr;
          paramAnonymousObject = ((r)paramAnonymousObject).bsD;
          if (paramAnonymousObject == null) {}
          for (;;)
          {
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(196788);
            return paramAnonymousObject;
            paramAnonymousd.label = 1;
            if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
            {
              AppMethodBeat.o(196788);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
          }
        }
      }, paramd);
      if (paramh == a.aiwj)
      {
        AppMethodBeat.o(196894);
        return paramh;
      }
      paramh = kotlin.ah.aiuX;
      AppMethodBeat.o(196894);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.k
 * JD-Core Version:    0.7.0.1
 */