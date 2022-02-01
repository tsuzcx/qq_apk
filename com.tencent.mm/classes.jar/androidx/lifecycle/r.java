package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.cx;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleScope", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-runtime-ktx_release"}, k=2, mv={1, 4, 1})
public final class r
{
  public static final l g(q paramq)
  {
    AppMethodBeat.i(194385);
    s.u(paramq, "$this$lifecycleScope");
    paramq = paramq.getLifecycle();
    s.s(paramq, "lifecycle");
    s.u(paramq, "$this$coroutineScope");
    LifecycleCoroutineScopeImpl localLifecycleCoroutineScopeImpl;
    do
    {
      localLifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl)paramq.mInternalScopeRef.get();
      if (localLifecycleCoroutineScopeImpl != null)
      {
        paramq = (l)localLifecycleCoroutineScopeImpl;
        AppMethodBeat.o(194385);
        return paramq;
      }
      localLifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(paramq, cx.g(null).plus((f)bg.kCh().kCK()));
    } while (!paramq.mInternalScopeRef.compareAndSet(null, localLifecycleCoroutineScopeImpl));
    kotlinx.coroutines.j.a(localLifecycleCoroutineScopeImpl, (f)bg.kCh().kCK(), null, (m)new LifecycleCoroutineScopeImpl.a(localLifecycleCoroutineScopeImpl, null), 2);
    paramq = (l)localLifecycleCoroutineScopeImpl;
    AppMethodBeat.o(194385);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.r
 * JD-Core Version:    0.7.0.1
 */