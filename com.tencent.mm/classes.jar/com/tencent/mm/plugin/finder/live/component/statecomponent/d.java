package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.lifecycle.x;
import com.tencent.mm.plugin.finder.live.model.context.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "()V", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-finder_release"})
public abstract class d
{
  public a buContext = new a("from StateComponent");
  
  public final <T extends x> T business(Class<T> paramClass)
  {
    p.k(paramClass, "bu");
    return this.buContext.business(paramClass);
  }
  
  public final void setBuContext(a parama)
  {
    p.k(parama, "<set-?>");
    this.buContext = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.d
 * JD-Core Version:    0.7.0.1
 */