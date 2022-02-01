package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/CompositionScopedCoroutineScopeCanceller;", "Landroidx/compose/runtime/RememberObserver;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements az
{
  public final aq coroutineScope;
  
  public r(aq paramaq)
  {
    AppMethodBeat.i(202242);
    this.coroutineScope = paramaq;
    AppMethodBeat.o(202242);
  }
  
  public final void mJ() {}
  
  public final void mK()
  {
    AppMethodBeat.i(202256);
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(202256);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(202263);
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(202263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.r
 * JD-Core Version:    0.7.0.1
 */