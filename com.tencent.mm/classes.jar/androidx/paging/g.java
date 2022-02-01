package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cachedIn", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tracker", "Landroidx/paging/ActiveFlowTracker;", "paging-common"}, k=2, mv={1, 4, 2})
public final class g
{
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "it", "Landroidx/paging/PagingData;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  public static final class c
    extends k
    implements m<av<T>, d<? super ah>, Object>
  {
    int label;
    
    public c(d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(197244);
      s.u(paramd, "completion");
      paramObject = new c(paramd);
      AppMethodBeat.o(197244);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(197250);
      paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(197250);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197241);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197241);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(197241);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.paging.g
 * JD-Core Version:    0.7.0.1
 */