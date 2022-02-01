package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.cb;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Landroidx/paging/SimpleProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
final class h$a
  extends k
  implements m<bh<T>, d<? super ah>, Object>
{
  int label;
  
  h$a(cb paramcb, m paramm, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196893);
    s.u(paramd, "completion");
    paramd = new a(this.bLx, this.VV, paramd);
    paramd.L$0 = paramObject;
    AppMethodBeat.o(196893);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196896);
    paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(196896);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(196889);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196889);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (bh)this.L$0;
      this.bLx.bh((b)new u(paramObject) {});
      m localm = this.VV;
      this.label = 1;
      if (localm.invoke(paramObject, this) == locala)
      {
        AppMethodBeat.o(196889);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(196889);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.h.a
 * JD-Core Version:    0.7.0.1
 */