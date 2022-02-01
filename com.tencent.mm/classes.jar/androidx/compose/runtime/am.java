package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"monotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/CoroutineContext;", "getMonotonicFrameClock$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getMonotonicFrameClock", "(Lkotlin/coroutines/CoroutineContext;)Landroidx/compose/runtime/MonotonicFrameClock;", "withFrameMillis", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeMillis", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withFrameNanos", "(Landroidx/compose/runtime/MonotonicFrameClock;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class am
{
  public static final al a(f paramf)
  {
    AppMethodBeat.i(201898);
    s.u(paramf, "<this>");
    paramf = (al)paramf.get((f.c)al.aot);
    if (paramf == null)
    {
      paramf = (Throwable)new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.".toString());
      AppMethodBeat.o(201898);
      throw paramf;
    }
    AppMethodBeat.o(201898);
    return paramf;
  }
  
  public static final <R> Object b(b<? super Long, ? extends R> paramb, d<? super R> paramd)
  {
    AppMethodBeat.i(201890);
    paramb = a(paramd.getContext()).b(paramb, paramd);
    AppMethodBeat.o(201890);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.am
 * JD-Core Version:    0.7.0.1
 */