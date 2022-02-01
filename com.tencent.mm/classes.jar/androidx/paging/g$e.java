package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
public final class g$e
  extends k
  implements m<h<? super av<T>>, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  public g$e(d paramd, kotlin.d.d paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(197204);
    s.u(paramd, "completion");
    paramObject = new e(this.bLw, paramd);
    AppMethodBeat.o(197204);
    return paramObject;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(197212);
    paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(197212);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(197194);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(197194);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.bLw;
      if (paramObject != null)
      {
        d.a locala1 = d.a.bKI;
        this.label = 1;
        if (paramObject.HD() == locala)
        {
          AppMethodBeat.o(197194);
          return locala;
        }
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(197194);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.g.e
 * JD-Core Version:    0.7.0.1
 */