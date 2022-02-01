package com.tencent.mm.plugin.livebase.redux;

import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livebase/redux/IReduxReducer;", "State", "", "reduce", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "state", "action", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Ljava/lang/Object;Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;)Lkotlinx/coroutines/flow/Flow;", "plugin-livebase_release"})
public abstract interface b<State>
{
  public abstract kotlinx.coroutines.b.b<State> a(LifecycleScope paramLifecycleScope, State paramState, a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livebase.redux.b
 * JD-Core Version:    0.7.0.1
 */