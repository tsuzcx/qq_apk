package coil;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a;
import kotlin.d.f.c;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;

@Metadata(d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$f
  extends a
  implements CoroutineExceptionHandler
{
  public f$f(CoroutineExceptionHandler.a parama, f paramf)
  {
    super((f.c)parama);
    AppMethodBeat.i(187862);
    AppMethodBeat.o(187862);
  }
  
  public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(187871);
    paramf = this.clz.cli;
    if (paramf != null) {
      coil.util.f.a(paramf, "RealImageLoader", paramThrowable);
    }
    AppMethodBeat.o(187871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.f.f
 * JD-Core Version:    0.7.0.1
 */