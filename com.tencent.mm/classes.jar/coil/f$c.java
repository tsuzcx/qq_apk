package coil;

import coil.j.h;
import coil.j.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class f$c
  extends k
  implements m<aq, d<? super i>, Object>
{
  int label;
  
  f$c(f paramf, h paramh, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(188071);
    paramObject = (d)new c(this.clz, this.clA, paramd);
    AppMethodBeat.o(188071);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(188063);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(188063);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.clz;
      Object localObject = this.clA;
      d locald = (d)this;
      this.label = 1;
      localObject = f.a(paramObject, (h)localObject, 1, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(188063);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    AppMethodBeat.o(188063);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.f.c
 * JD-Core Version:    0.7.0.1
 */