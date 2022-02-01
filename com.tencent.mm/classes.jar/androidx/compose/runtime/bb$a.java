package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bb$a
  extends k
  implements m<aq, d<? super R>, Object>
{
  int label;
  
  bb$a(kotlin.g.a.b<? super Long, ? extends R> paramb, d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(202326);
    paramObject = (d)new a(this.Vb, paramd);
    AppMethodBeat.o(202326);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(202316);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(202316);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (d)this;
      this.label = 1;
      if (bb.e(16L, paramObject) == locala)
      {
        AppMethodBeat.o(202316);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = this.Vb.invoke(kotlin.d.b.a.b.BF(System.nanoTime()));
    AppMethodBeat.o(202316);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.bb.a
 * JD-Core Version:    0.7.0.1
 */