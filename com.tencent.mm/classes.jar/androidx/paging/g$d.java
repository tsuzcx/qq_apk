package androidx.paging;

import androidx.paging.a.c;
import androidx.paging.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/MulticastedPagingData;", "T", "", "prev", "next", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
public final class g$d
  extends k
  implements q<ae<T>, ae<T>, kotlin.d.d<? super ae<T>>, Object>
{
  int label;
  
  public g$d(kotlin.d.d paramd)
  {
    super(3, paramd);
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(197206);
    paramObject1 = (ae)paramObject1;
    paramObject2 = (ae)paramObject2;
    paramObject3 = (kotlin.d.d)paramObject3;
    s.u(paramObject1, "prev");
    s.u(paramObject2, "next");
    s.u(paramObject3, "continuation");
    paramObject3 = new d(paramObject3);
    paramObject3.L$0 = paramObject1;
    paramObject3.Uf = paramObject2;
    paramObject1 = ((d)paramObject3).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(197206);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(197197);
    a locala = a.aiwj;
    Object localObject;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(197197);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (ae)this.L$0;
      ae localae = (ae)this.Uf;
      this.L$0 = localae;
      this.label = 1;
      localObject = paramObject.bNG.bLd.Ir().bSa.n(this);
      paramObject = localObject;
      if (localObject != a.aiwj) {
        paramObject = ah.aiuX;
      }
      localObject = paramObject;
      if (paramObject != a.aiwj) {
        localObject = ah.aiuX;
      }
      paramObject = localObject;
      if (localObject != a.aiwj) {
        paramObject = ah.aiuX;
      }
      localObject = paramObject;
      if (paramObject != a.aiwj) {
        localObject = ah.aiuX;
      }
      paramObject = localae;
      if (localObject == locala)
      {
        AppMethodBeat.o(197197);
        return locala;
      }
      break;
    case 1: 
      localObject = (ae)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject;
    }
    AppMethodBeat.o(197197);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.g.d
 * JD-Core Version:    0.7.0.1
 */