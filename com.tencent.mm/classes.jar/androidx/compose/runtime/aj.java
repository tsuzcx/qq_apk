package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bq;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/LaunchedEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "parentCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "task", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "job", "Lkotlinx/coroutines/Job;", "scope", "Lkotlin/jvm/functions/Function2;", "onAbandoned", "onForgotten", "onRemembered", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  implements az
{
  private final m<aq, d<? super ah>, Object> aor;
  private cb job;
  private final aq scope;
  
  public aj(f paramf, m<? super aq, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(201904);
    this.aor = paramm;
    this.scope = ar.d(paramf);
    AppMethodBeat.o(201904);
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(201910);
    cb localcb = this.job;
    if (localcb != null) {
      localcb.a(bq.i("Old job was still running!", null));
    }
    this.job = j.a(this.scope, null, null, this.aor, 3);
    AppMethodBeat.o(201910);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(201920);
    cb localcb = this.job;
    if (localcb != null) {
      localcb.a(null);
    }
    this.job = null;
    AppMethodBeat.o(201920);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(201926);
    cb localcb = this.job;
    if (localcb != null) {
      localcb.a(null);
    }
    this.job = null;
    AppMethodBeat.o(201926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.aj
 * JD-Core Version:    0.7.0.1
 */