package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.lifecycle.af;
import com.tencent.mm.plugin.finder.live.model.context.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "()V", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
{
  public a buContext = new a("from StateComponent");
  
  public final <T extends af> T business(Class<T> paramClass)
  {
    s.u(paramClass, "bu");
    return this.buContext.business(paramClass);
  }
  
  public final void setBuContext(a parama)
  {
    s.u(parama, "<set-?>");
    this.buContext = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.e
 * JD-Core Version:    0.7.0.1
 */