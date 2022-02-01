package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime-ktx_release"}, k=1, mv={1, 4, 1})
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
  implements o
{
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194507);
    s.u(paramq, "source");
    s.u(parama, "event");
    Result.Companion localCompanion;
    if (parama == j.a.c(this.bIz))
    {
      this.bIy.removeObserver((p)this);
      parama = this.anM;
      paramq = this.$block$inlined;
      try
      {
        localCompanion = Result.Companion;
        paramq = Result.constructor-impl(paramq.invoke());
        parama.resumeWith(paramq);
        AppMethodBeat.o(194507);
        return;
      }
      finally
      {
        for (;;)
        {
          localCompanion = Result.Companion;
          paramq = Result.constructor-impl(ResultKt.createFailure(paramq));
        }
      }
    }
    if (parama == j.a.ON_DESTROY)
    {
      this.bIy.removeObserver((p)this);
      paramq = (d)this.anM;
      parama = (Throwable)new m();
      localCompanion = Result.Companion;
      paramq.resumeWith(Result.constructor-impl(ResultKt.createFailure(parama)));
    }
    AppMethodBeat.o(194507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.WithLifecycleStateKt.suspendWithStateAtLeastUnchecked..inlined.suspendCancellableCoroutine.lambda.1
 * JD-Core Version:    0.7.0.1
 */