package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.model.context.a.a;
import com.tencent.mm.ui.component.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "P", "Lcom/tencent/mm/ui/component/IModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveContext", "business", "T", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "reset", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<P extends f>
  extends af
{
  public a CBK;
  
  public c(a parama)
  {
    this.CBK = parama;
  }
  
  public final <T extends af> T business(Class<T> paramClass)
  {
    s.u(paramClass, "bu");
    a.a locala = a.CMm;
    paramClass = a.a.a((f)this.CBK).q(paramClass);
    s.s(paramClass, "LiveBuContext.of(liveContext).get(bu)");
    return paramClass;
  }
  
  public final void reset()
  {
    onCleared();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.c
 * JD-Core Version:    0.7.0.1
 */