package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"PendingApplyNoModifications", "", "recomposeCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/ControlledComposition;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/coroutines/CoroutineContext;", "Composition", "Landroidx/compose/runtime/Composition;", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "ControlledComposition", "simulateHotReload", "", "context", "addValue", "K", "V", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "key", "value", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final Object anI;
  
  static
  {
    AppMethodBeat.i(202274);
    anI = new Object();
    AppMethodBeat.o(202274);
  }
  
  public static final k a(d<?> paramd, l paraml)
  {
    AppMethodBeat.i(202260);
    s.u(paramd, "applier");
    s.u(paraml, "parent");
    paramd = (k)new n(paraml, paramd, (byte)0);
    AppMethodBeat.o(202260);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.o
 * JD-Core Version:    0.7.0.1
 */