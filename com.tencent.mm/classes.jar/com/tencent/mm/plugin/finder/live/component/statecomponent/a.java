package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;)V", "onBindData", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends e
{
  private final j Bld;
  public final AppCompatActivity CCa;
  public com.tencent.mm.plugin.finder.live.view.router.a CCb;
  public b ngB;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    this.CCa = paramAppCompatActivity;
    this.Bld = k.cm((kotlin.g.a.a)new a(this));
  }
  
  public static ap getFinderLiveAssistant()
  {
    aj localaj = aj.CGT;
    return aj.getFinderLiveAssistant();
  }
  
  public void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    s.u(parama, "baseRouter");
    setBuContext(parama.getBuContext());
    this.ngB = parama.getLiveCore();
    this.CCb = parama;
  }
  
  public final com.tencent.mm.plugin.finder.live.view.router.a ejl()
  {
    return this.CCb;
  }
  
  public final bui getContextObj()
  {
    return (bui)this.Bld.getValue();
  }
  
  public final b getLiveCore()
  {
    return this.ngB;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<bui>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.a
 * JD-Core Version:    0.7.0.1
 */