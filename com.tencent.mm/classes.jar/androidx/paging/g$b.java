package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 4, 2})
public final class g$b
  implements g<av<T>>
{
  public g$b(g paramg) {}
  
  public final Object a(h paramh, kotlin.d.d paramd)
  {
    AppMethodBeat.i(197224);
    paramh = this.bLp.a((h)new h()
    {
      public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
      {
        AppMethodBeat.i(197088);
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
                AppMethodBeat.i(196944);
                this.result = paramAnonymous2Object;
                this.label |= 0x80000000;
                paramAnonymous2Object = this.bLv.a(null, this);
                AppMethodBeat.o(196944);
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
            AppMethodBeat.o(197088);
            throw paramAnonymousObject;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        Object localObject2 = this.bLr;
        paramAnonymousObject = (ae)paramAnonymousObject;
        paramAnonymousObject = new av(paramAnonymousObject.bNG.bLe, paramAnonymousObject.bNH.bQk);
        paramAnonymousd.label = 1;
        if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
        {
          AppMethodBeat.o(197088);
          return localObject1;
          ResultKt.throwOnFailure(localObject2);
        }
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(197088);
        return paramAnonymousObject;
      }
    }, paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(197224);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(197224);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.g.b
 * JD-Core Version:    0.7.0.1
 */