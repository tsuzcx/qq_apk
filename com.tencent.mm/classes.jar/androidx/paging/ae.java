package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.o;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/MulticastedPagingData;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "parent", "Landroidx/paging/PagingData;", "tracker", "Landroidx/paging/ActiveFlowTracker;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V", "accumulated", "Landroidx/paging/CachedPageEventFlow;", "getParent", "()Landroidx/paging/PagingData;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getTracker", "()Landroidx/paging/ActiveFlowTracker;", "asPagingData", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
final class ae<T>
{
  final f<T> bNG;
  final av<T> bNH;
  final d bNI;
  private final aq scope;
  
  private ae(aq paramaq, av<T> paramav)
  {
    AppMethodBeat.i(196695);
    this.scope = paramaq;
    this.bNH = paramav;
    this.bNI = null;
    this.bNG = new f(o.d(o.a(this.bNH.bLH, (m)new a(this, null)), (q)new b(this, null)), this.scope);
    AppMethodBeat.o(196695);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class a
    extends k
    implements m<h<? super ag<T>>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(ae paramae, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196757);
      s.u(paramd, "completion");
      paramObject = new a(this.bNJ, paramd);
      AppMethodBeat.o(196757);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196762);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196762);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196749);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196749);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.bNJ.bNI;
        if (paramObject != null)
        {
          d.a locala1 = d.a.bKJ;
          this.label = 1;
          if (paramObject.HD() == locala)
          {
            AppMethodBeat.o(196749);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(196749);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class b
    extends k
    implements q<h<? super ag<T>>, Throwable, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(ae paramae, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      AppMethodBeat.i(196668);
      paramObject1 = (h)paramObject1;
      paramObject2 = (kotlin.d.d)paramObject3;
      s.u(paramObject1, "$this$create");
      s.u(paramObject2, "continuation");
      paramObject1 = ((b)new b(this.bNJ, paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196668);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196663);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196663);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.bNJ.bNI;
        if (paramObject != null)
        {
          d.a locala1 = d.a.bKJ;
          this.label = 1;
          if (paramObject.HE() == locala)
          {
            AppMethodBeat.o(196663);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(196663);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ae
 * JD-Core Version:    0.7.0.1
 */