package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.mm.plugin.finder.live.model.context.a.a;
import com.tencent.mm.ui.component.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "P", "Lcom/tencent/mm/ui/component/IModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveContext", "business", "T", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "reset", "", "plugin-finder-base_release"})
public abstract class a<P extends c>
  extends x
{
  public com.tencent.mm.plugin.finder.live.model.context.a zeV;
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    this.zeV = parama;
  }
  
  public final <T extends x> T business(Class<T> paramClass)
  {
    p.k(paramClass, "bu");
    a.a locala = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paramClass = a.a.a((c)this.zeV).i(paramClass);
    p.j(paramClass, "LiveBuContext.of(liveContext).get(bu)");
    return paramClass;
  }
  
  public final void reset()
  {
    onCleared();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.a
 * JD-Core Version:    0.7.0.1
 */