package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SuspendingPagingSourceFactory;", "Key", "", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "delegate", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;)V", "create", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "paging-common"}, k=1, mv={1, 4, 2})
public final class bl<Key, Value>
  implements kotlin.g.a.a<ay<Key, Value>>
{
  final al bRx;
  private final kotlin.g.a.a<ay<Key, Value>> bRy;
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class a
    extends k
    implements m<aq, d<? super ay<Key, Value>>, Object>
  {
    int label;
    
    a(bl parambl, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196651);
      s.u(paramd, "completion");
      paramObject = new a(this.bRz, paramd);
      AppMethodBeat.o(196651);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196658);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196658);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196645);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196645);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = bl.a(this.bRz).invoke();
      AppMethodBeat.o(196645);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bl
 * JD-Core Version:    0.7.0.1
 */