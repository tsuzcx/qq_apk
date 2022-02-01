package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 4, 2})
public final class g$a
  implements g<ae<T>>
{
  public g$a(g paramg, aq paramaq) {}
  
  public final Object a(h paramh, kotlin.d.d paramd)
  {
    AppMethodBeat.i(197218);
    paramh = this.bLp.a((h)new h()
    {
      public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
      {
        AppMethodBeat.i(196844);
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
                AppMethodBeat.i(196886);
                this.result = paramAnonymous2Object;
                this.label |= 0x80000000;
                paramAnonymous2Object = this.bLt.a(null, this);
                AppMethodBeat.o(196886);
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
            AppMethodBeat.o(196844);
            throw paramAnonymousObject;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        Object localObject2 = this.bLr;
        paramAnonymousObject = (av)paramAnonymousObject;
        paramAnonymousObject = new ae(jdField_this.bLq, paramAnonymousObject, (byte)0);
        paramAnonymousd.label = 1;
        if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
        {
          AppMethodBeat.o(196844);
          return localObject1;
          ResultKt.throwOnFailure(localObject2);
        }
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(196844);
        return paramAnonymousObject;
      }
    }, paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(197218);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(197218);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.g.a
 * JD-Core Version:    0.7.0.1
 */