package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "onBindData", "", "plugin-finder_release"})
public abstract class b
  extends d
{
  public com.tencent.mm.live.core.core.trtc.a kHp;
  private final f xLj;
  public final AppCompatActivity ycV;
  public com.tencent.mm.plugin.finder.live.view.router.b ycX;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    this.ycV = paramAppCompatActivity;
    this.xLj = g.ar((kotlin.g.a.a)new a(this));
  }
  
  public void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    p.k(paramb, "baseRouter");
    setBuContext(paramb.getBuContext());
    this.kHp = paramb.getLiveCore();
    this.ycX = paramb;
  }
  
  public final bid getContextObj()
  {
    return (bid)this.xLj.getValue();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<bid>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.b
 * JD-Core Version:    0.7.0.1
 */