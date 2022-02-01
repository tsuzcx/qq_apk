package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;)V", "liveStartUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;", "getLiveStartUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;", "setLiveStartUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;)V", "getStartUIC", "liveEndWithAnimation", "", "prepareToStart", "byMiniWin", "", "startToEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private c DWa;
  public com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b DWb;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a DWc;
  private com.tencent.mm.live.core.core.a.b ngB;
  
  public a(Context paramContext, Fragment paramFragment)
  {
    super(paramContext, paramFragment, null);
    this.DWa = new c((AppCompatActivity)paramContext);
    this.DWb = new com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b((AppCompatActivity)paramContext);
    this.DWc = new com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final com.tencent.mm.live.core.core.a.b getLiveCore()
  {
    return this.ngB;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a getLiveEndUIC()
  {
    return this.DWc;
  }
  
  protected final c getLivePrepareUIC()
  {
    return this.DWa;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b getLiveStartUIC()
  {
    return this.DWb;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b getStartUIC()
  {
    return this.DWb;
  }
  
  public final void prepareToStart(boolean paramBoolean)
  {
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = this.DWb;
    if (paramBoolean)
    {
      localb.ezt();
      return;
    }
    localb.ezs();
  }
  
  public final void setLiveCore(com.tencent.mm.live.core.core.a.b paramb)
  {
    this.ngB = paramb;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a parama)
  {
    s.u(parama, "<set-?>");
    this.DWc = parama;
  }
  
  protected final void setLivePrepareUIC(c paramc)
  {
    s.u(paramc, "<set-?>");
    this.DWa = paramc;
  }
  
  protected final void setLiveStartUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b paramb)
  {
    s.u(paramb, "<set-?>");
    this.DWb = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.a
 * JD-Core Version:    0.7.0.1
 */