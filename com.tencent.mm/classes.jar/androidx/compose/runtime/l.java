package androidx.compose.runtime;

import androidx.compose.runtime.b.a.a.a.i;
import androidx.compose.runtime.g.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/CompositionContext;", "", "()V", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalScope$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class l
{
  public abstract void a(s params);
  
  public abstract void a(s params, kotlin.g.a.m<? super h, ? super Integer, ah> paramm);
  
  public abstract void b(s params);
  
  public void d(Set<a> paramSet)
  {
    kotlin.g.b.s.u(paramSet, "table");
  }
  
  public void n(h paramh)
  {
    kotlin.g.b.s.u(paramh, "composer");
  }
  
  public void o(h paramh)
  {
    kotlin.g.b.s.u(paramh, "composer");
  }
  
  public abstract int oU();
  
  public abstract boolean oV();
  
  public abstract f oW();
  
  public i<p<Object>, bm<Object>> oX()
  {
    return m.pc();
  }
  
  public void oY() {}
  
  public void oZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.l
 * JD-Core Version:    0.7.0.1
 */