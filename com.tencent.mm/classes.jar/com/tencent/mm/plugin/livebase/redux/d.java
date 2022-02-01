package com.tencent.mm.plugin.livebase.redux;

import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.b.e;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livebase/redux/SyncReduxReducer;", "State", "Lcom/tencent/mm/plugin/livebase/redux/IReduxReducer;", "()V", "reduce", "Lkotlinx/coroutines/flow/Flow;", "lifecycleScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "state", "action", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Ljava/lang/Object;Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;)Lkotlinx/coroutines/flow/Flow;", "reduceSync", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;)Ljava/lang/Object;", "plugin-livebase_release"})
public abstract class d<State>
  implements b<State>
{
  public abstract State a(State paramState, a parama);
  
  public final kotlinx.coroutines.b.b<State> a(LifecycleScope paramLifecycleScope, State paramState, a parama)
  {
    p.k(paramLifecycleScope, "lifecycleScope");
    p.k(parama, "action");
    paramLifecycleScope = new n();
    paramLifecycleScope.offer(a(paramState, parama));
    return e.a((f)paramLifecycleScope);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livebase.redux.d
 * JD-Core Version:    0.7.0.1
 */