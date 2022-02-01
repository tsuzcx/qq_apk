package androidx.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlinx.coroutines.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/concurrent/futures/ToContinuation;", "T", "Ljava/lang/Runnable;", "futureToObserve", "Lcom/google/common/util/concurrent/ListenableFuture;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getFutureToObserve", "()Lcom/google/common/util/concurrent/ListenableFuture;", "run", "", "concurrent-futures-ktx"}, k=1, mv={1, 1, 16})
final class f<T>
  implements Runnable
{
  private final com.google.b.b.a.f<T> bge;
  private final p<T> bgf;
  
  public f(com.google.b.b.a.f<T> paramf, p<? super T> paramp)
  {
    AppMethodBeat.i(195290);
    this.bge = paramf;
    this.bgf = paramp;
    AppMethodBeat.o(195290);
  }
  
  public final void run()
  {
    AppMethodBeat.i(195297);
    if (this.bge.isCancelled())
    {
      this.bgf.P(null);
      AppMethodBeat.o(195297);
      return;
    }
    try
    {
      localObject = this.bgf;
      Result.Companion localCompanion1 = Result.Companion;
      ((p)localObject).resumeWith(Result.constructor-impl(a.b((Future)this.bge)));
      AppMethodBeat.o(195297);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      Object localObject = (kotlin.d.d)this.bgf;
      Throwable localThrowable = d.a(localExecutionException);
      Result.Companion localCompanion2 = Result.Companion;
      ((kotlin.d.d)localObject).resumeWith(Result.constructor-impl(ResultKt.createFailure(localThrowable)));
      AppMethodBeat.o(195297);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.c.a.f
 * JD-Core Version:    0.7.0.1
 */