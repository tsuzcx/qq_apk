package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.u.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
final class f$b
  extends k
  implements m<h<? super ae<? extends ag<T>>>, d<? super ah>, Object>
{
  int label;
  
  f$b(f paramf, g paramg, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196843);
    s.u(paramd, "completion");
    paramd = new b(this.bLf, this.bLo, paramd);
    paramd.L$0 = paramObject;
    AppMethodBeat.o(196843);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196849);
    paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(196849);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(196837);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196837);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (h)this.L$0;
      if (this.bLf.bLc.compareAndSet(false, true))
      {
        g localg = (g)new u.c(this.bLo);
        this.label = 1;
        if (localg.a(paramObject, this) == locala)
        {
          AppMethodBeat.o(196837);
          return locala;
        }
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(196837);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.paging.f.b
 * JD-Core Version:    0.7.0.1
 */