package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
final class at$b
  extends k
  implements b<d<? super ay<Key, Value>>, Object>
{
  int label;
  
  at$b(kotlin.g.a.a parama, d paramd)
  {
    super(1, paramd);
  }
  
  public final d<ah> create(d<?> paramd)
  {
    AppMethodBeat.i(196648);
    s.u(paramd, "completion");
    paramd = new b(this.bQh, paramd);
    AppMethodBeat.o(196648);
    return paramd;
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(196653);
    paramObject = ((b)create((d)paramObject)).invokeSuspend(ah.aiuX);
    AppMethodBeat.o(196653);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(196640);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196640);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.bQh.invoke();
    AppMethodBeat.o(196640);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.paging.at.b
 * JD-Core Version:    0.7.0.1
 */