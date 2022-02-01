package com.tencent.mm.plugin.finder.live.component.statecomponent;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.live.view.router.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "onBindData", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends e
{
  private final j Bld;
  public final AppCompatActivity CCa;
  public b CCe;
  private f data;
  public com.tencent.mm.live.core.core.trtc.a nkg;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    this.CCa = paramAppCompatActivity;
    this.Bld = k.cm((kotlin.g.a.a)new a(this));
  }
  
  public void a(b paramb)
  {
    s.u(paramb, "baseRouter");
    setBuContext(paramb.getBuContext());
    this.nkg = paramb.getLiveCore();
    this.CCe = paramb;
    this.data = paramb.getData();
  }
  
  public final bui getContextObj()
  {
    return (bui)this.Bld.getValue();
  }
  
  public final f getData()
  {
    return this.data;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<bui>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.c
 * JD-Core Version:    0.7.0.1
 */