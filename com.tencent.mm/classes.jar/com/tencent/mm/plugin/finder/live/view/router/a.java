package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ah;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.g;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.h;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;)V", "liveStartUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;", "getLiveStartUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;", "setLiveStartUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;)V", "getStartUIC", "liveEndWithAnimation", "", "prepareToStart", "byMiniWin", "", "startToEnd", "plugin-finder_release"})
public abstract class a
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private HashMap _$_findViewCache;
  private b kDk;
  private e zaZ;
  public c zba;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a zbb;
  
  public a(Context paramContext, Fragment paramFragment)
  {
    super(paramContext, paramFragment, null);
    this.zaZ = new e((AppCompatActivity)paramContext);
    this.zba = new c((AppCompatActivity)paramContext);
    this.zbb = new com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a((AppCompatActivity)paramContext);
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
  
  public final b getLiveCore()
  {
    return this.kDk;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a getLiveEndUIC()
  {
    return this.zbb;
  }
  
  protected final e getLivePrepareUIC()
  {
    return this.zaZ;
  }
  
  public final c getLiveStartUIC()
  {
    return this.zba;
  }
  
  public final c getStartUIC()
  {
    return this.zba;
  }
  
  public final void prepareToStart(boolean paramBoolean)
  {
    c localc = this.zba;
    if (paramBoolean)
    {
      Object localObject = localc.ycU;
      if (localObject != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject, false, 1, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
      a locala = localc.ycU;
      if (locala != null) {
        locala.statusChange(b.c.kyU, (Bundle)localObject);
      }
      localObject = localc.kDk;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
        if ((localObject != null) && (((h)localObject).kmG == true))
        {
          localObject = localc.zjb;
          if (localObject != null) {
            ((ab)localObject).dAQ();
          }
        }
      }
      localObject = localc.zjb;
      if (localObject != null)
      {
        localObject = (ViewGroup)((ab)localObject).knt.getRenderLayout();
        if (localObject != null) {
          ((ViewGroup)localObject).post((Runnable)new c.g(localc));
        }
      }
      localObject = localc.zjH;
      if (localObject != null) {
        ((ah)localObject).dAS();
      }
      d.a(200L, (kotlin.g.a.a)new c.h(localc));
      return;
    }
    localc.dHl();
  }
  
  public final void setLiveCore(b paramb)
  {
    this.kDk = paramb;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a parama)
  {
    p.k(parama, "<set-?>");
    this.zbb = parama;
  }
  
  protected final void setLivePrepareUIC(e parame)
  {
    p.k(parame, "<set-?>");
    this.zaZ = parame;
  }
  
  protected final void setLiveStartUIC(c paramc)
  {
    p.k(paramc, "<set-?>");
    this.zba = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.a
 * JD-Core Version:    0.7.0.1
 */