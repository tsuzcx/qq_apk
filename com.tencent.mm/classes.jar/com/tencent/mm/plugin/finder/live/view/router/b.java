package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;)V", "liveStartUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "getLiveStartUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "setLiveStartUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;)V", "getStartUIC", "liveEndWithAnimation", "", "prepareToStart", "byMiniWin", "", "startToEnd", "plugin-finder_release"})
public abstract class b
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private HashMap _$_findViewCache;
  private com.tencent.mm.live.core.core.trtc.a kHp;
  private e zbc;
  public c zbd;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a zbe;
  
  public b(Context paramContext, Fragment paramFragment)
  {
    super(paramContext, paramFragment, null);
    this.zbc = new e((AppCompatActivity)paramContext);
    this.zbd = new c((AppCompatActivity)paramContext);
    this.zbe = new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    return this.kHp;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a getLiveEndUIC()
  {
    return this.zbe;
  }
  
  protected final e getLivePrepareUIC()
  {
    return this.zbc;
  }
  
  public final c getLiveStartUIC()
  {
    return this.zbd;
  }
  
  public final c getStartUIC()
  {
    return this.zbd;
  }
  
  public final void prepareToStart(boolean paramBoolean)
  {
    c localc = this.zbd;
    if (paramBoolean)
    {
      Object localObject = localc.ycX;
      if (localObject != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject, false, 1, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
      b localb = localc.ycX;
      if (localb != null) {
        localb.statusChange(b.c.kyU, (Bundle)localObject);
      }
      localc.fw(true);
      return;
    }
    localc.dHl();
  }
  
  public final void setLiveCore(com.tencent.mm.live.core.core.trtc.a parama)
  {
    this.kHp = parama;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a parama)
  {
    p.k(parama, "<set-?>");
    this.zbe = parama;
  }
  
  protected final void setLivePrepareUIC(e parame)
  {
    p.k(parame, "<set-?>");
    this.zbc = parame;
  }
  
  protected final void setLiveStartUIC(c paramc)
  {
    p.k(paramc, "<set-?>");
    this.zbd = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.b
 * JD-Core Version:    0.7.0.1
 */