package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.g.a.m;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1", "androidx/paging/PagingDataTransforms$transform$$inlined$map$6"}, k=1, mv={1, 4, 2})
public final class ax$a
  implements g<ag<T>>
{
  public ax$a(g paramg, m paramm) {}
  
  public final Object a(h paramh, kotlin.d.d paramd)
  {
    AppMethodBeat.i(196617);
    paramh = this.bLp.a((h)new h()
    {
      public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
      {
        AppMethodBeat.i(196911);
        if ((paramAnonymousd instanceof 1))
        {
          localObject1 = (1)paramAnonymousd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        a locala;
        for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
            {
              Object L$0;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(196940);
                this.result = paramAnonymous2Object;
                this.label |= 0x80000000;
                paramAnonymous2Object = this.bQI.a(null, this);
                AppMethodBeat.o(196940);
                return paramAnonymous2Object;
              }
            })
        {
          localObject2 = paramAnonymousd.result;
          locala = a.aiwj;
          switch (paramAnonymousd.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(196911);
            throw paramAnonymousObject;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        Object localObject1 = this.bLr;
        paramAnonymousObject = (ag)paramAnonymousObject;
        Object localObject2 = jdField_this.bQG;
        paramAnonymousd.L$0 = localObject1;
        paramAnonymousd.label = 1;
        paramAnonymousObject = paramAnonymousObject.b((m)localObject2, paramAnonymousd);
        if (paramAnonymousObject == locala)
        {
          AppMethodBeat.o(196911);
          return locala;
          localObject1 = (h)paramAnonymousd.L$0;
          ResultKt.throwOnFailure(localObject2);
          paramAnonymousObject = localObject2;
        }
        for (;;)
        {
          paramAnonymousd.L$0 = null;
          paramAnonymousd.label = 2;
          if (((h)localObject1).a(paramAnonymousObject, paramAnonymousd) == locala)
          {
            AppMethodBeat.o(196911);
            return locala;
            ResultKt.throwOnFailure(localObject2);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(196911);
          return paramAnonymousObject;
        }
      }
    }, paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(196617);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(196617);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ax.a
 * JD-Core Version:    0.7.0.1
 */