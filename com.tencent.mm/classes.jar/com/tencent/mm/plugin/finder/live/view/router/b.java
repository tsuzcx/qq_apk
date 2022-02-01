package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.statecomponent.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;)V", "liveStartUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "getLiveStartUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "setLiveStartUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;)V", "getStartUIC", "liveEndWithAnimation", "", "prepareToStart", "byMiniWin", "", "startToEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c DWd;
  public com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b DWe;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a DWf;
  private com.tencent.mm.live.core.core.trtc.a nkg;
  
  public b(Context paramContext, Fragment paramFragment)
  {
    super(paramContext, paramFragment, null);
    this.DWd = new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c((AppCompatActivity)paramContext);
    this.DWe = new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b((AppCompatActivity)paramContext);
    this.DWf = new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    return this.nkg;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a getLiveEndUIC()
  {
    return this.DWf;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c getLivePrepareUIC()
  {
    return this.DWd;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b getLiveStartUIC()
  {
    return this.DWe;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b getStartUIC()
  {
    return this.DWe;
  }
  
  public final void prepareToStart(boolean paramBoolean)
  {
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b localb = this.DWe;
    if (paramBoolean)
    {
      Object localObject1 = localb.CCe;
      if (localObject1 != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
      Object localObject2 = localb.CCe;
      if (localObject2 != null) {
        ((b)localObject2).statusChange(b.c.ncj, (Bundle)localObject1);
      }
      localb.ge(true);
      localObject2 = (q)localb.business(q.class);
      localObject1 = ((q)localb.buContext.business(q.class)).Eie;
      if ((localObject1 instanceof j))
      {
        localObject1 = (j)localObject1;
        if (localObject1 != null) {
          break label173;
        }
      }
      label173:
      for (long l = 0L;; l = ((j)localObject1).bUz())
      {
        ((q)localObject2).Eif = l;
        localObject1 = localb.CCe;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.a(localb.buContext, (com.tencent.mm.live.b.b)localObject1);
        }
        return;
        localObject1 = null;
        break;
      }
    }
    localb.ezs();
  }
  
  public final void setLiveCore(com.tencent.mm.live.core.core.trtc.a parama)
  {
    this.nkg = parama;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a parama)
  {
    s.u(parama, "<set-?>");
    this.DWf = parama;
  }
  
  protected final void setLivePrepareUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c paramc)
  {
    s.u(paramc, "<set-?>");
    this.DWd = paramc;
  }
  
  protected final void setLiveStartUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b paramb)
  {
    s.u(paramb, "<set-?>");
    this.DWe = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.b
 * JD-Core Version:    0.7.0.1
 */