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

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class f$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  f$b(f paramf, h paramh, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(188074);
    paramObject = (d)new b(this.clz, this.clA, paramd);
    AppMethodBeat.o(188074);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(188066);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(188066);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.clz;
      Object localObject = this.clA;
      d locald = (d)this;
      this.label = 1;
      localObject = f.a(paramObject, (h)localObject, 0, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(188066);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (i)paramObject;
    if ((paramObject instanceof coil.j.f))
    {
      paramObject = ((coil.j.f)paramObject).throwable;
      AppMethodBeat.o(188066);
      throw paramObject;
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(188066);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.f.b
 * JD-Core Version:    0.7.0.1
 */