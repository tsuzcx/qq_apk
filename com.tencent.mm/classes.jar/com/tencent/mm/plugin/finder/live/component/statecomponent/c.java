package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onBindData", "", "plugin-finder_release"})
public abstract class c
  extends d
{
  public f data;
  private bid reportObj;
  public final AppCompatActivity ycV;
  public com.tencent.mm.plugin.finder.live.view.router.c ycZ;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    this.ycV = paramAppCompatActivity;
  }
  
  public void a(com.tencent.mm.plugin.finder.live.view.router.c paramc, bid parambid)
  {
    p.k(paramc, "baseRouter");
    this.data = paramc.getData();
    setBuContext(paramc.getBuContext());
    this.ycZ = paramc;
    this.reportObj = parambid;
  }
  
  protected final bid getReportObj()
  {
    return this.reportObj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.c
 * JD-Core Version:    0.7.0.1
 */