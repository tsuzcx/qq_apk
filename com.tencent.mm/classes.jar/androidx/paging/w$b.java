package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "Value", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
final class w$b
  extends k
  implements kotlin.g.a.m<aq, d<? super ay.b.b<Key, Value>>, Object>
{
  int label;
  
  w$b(w paramw, ah.f paramf, ay.a parama, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196853);
    s.u(paramd, "completion");
    paramObject = new b(this.bNd, this.bNe, this.bNf, paramd);
    AppMethodBeat.o(196853);
    return paramObject;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196857);
    paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(196857);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(196845);
    Object localObject3 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196845);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.bNd.bNb;
      localObject2 = (m.f)this.bNe.aqH;
      this.label = 1;
      localObject2 = paramObject.a((m.f)localObject2, this);
      paramObject = localObject2;
      if (localObject2 == localObject3)
      {
        AppMethodBeat.o(196845);
        return localObject3;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    Object localObject2 = (m.a)paramObject;
    localObject3 = ((m.a)localObject2).bMf;
    if ((((m.a)localObject2).bMf.isEmpty()) && ((this.bNf instanceof ay.a.c)))
    {
      paramObject = null;
      if ((!((m.a)localObject2).bMf.isEmpty()) || (!(this.bNf instanceof ay.a.a))) {
        break label204;
      }
    }
    for (;;)
    {
      paramObject = new ay.b.b((List)localObject3, paramObject, localObject1, ((m.a)localObject2).bMi, ((m.a)localObject2).bMj);
      AppMethodBeat.o(196845);
      return paramObject;
      paramObject = ((m.a)localObject2).bMg;
      break;
      label204:
      localObject1 = ((m.a)localObject2).bMh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.w.b
 * JD-Core Version:    0.7.0.1
 */