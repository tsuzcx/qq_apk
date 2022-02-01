package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
public final class g$f
  extends k
  implements q<h<? super av<T>>, Throwable, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  public g$f(d paramd, kotlin.d.d paramd1)
  {
    super(3, paramd1);
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(197210);
    paramObject1 = (h)paramObject1;
    paramObject2 = (kotlin.d.d)paramObject3;
    s.u(paramObject1, "$this$create");
    s.u(paramObject2, "continuation");
    paramObject1 = ((f)new f(this.bLw, paramObject2)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(197210);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(197200);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(197200);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.bLw;
      if (paramObject != null)
      {
        d.a locala1 = d.a.bKI;
        this.label = 1;
        if (paramObject.HE() == locala)
        {
          AppMethodBeat.o(197200);
          return locala;
        }
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(197200);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.g.f
 * JD-Core Version:    0.7.0.1
 */