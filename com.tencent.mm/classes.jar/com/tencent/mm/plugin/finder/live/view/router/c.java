package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.plugin.finder.live.component.u.a;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.plugin.ca;
import com.tencent.mm.plugin.finder.live.plugin.cu;
import com.tencent.mm.plugin.finder.live.plugin.di;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c.f;
import com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c.g;
import com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c.h;
import com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.e;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;)V", "livingUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "getLivingUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "setLivingUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;)V", "getStartUIC", "prepareToStart", "", "byMiniWin", "", "startToEnd", "plugin-finder_release"})
public abstract class c
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private HashMap _$_findViewCache;
  private com.tencent.mm.live.core.core.c.c liveCore;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a liveEndUIC;
  private e livePrepareUIC;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c livingUIC;
  
  public c(Context paramContext, Fragment paramFragment, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramFragment, paramAttributeSet);
    this.livePrepareUIC = new e((AppCompatActivity)paramContext);
    this.livingUIC = new com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c((AppCompatActivity)paramContext);
    this.liveEndUIC = new com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a((AppCompatActivity)paramContext);
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
  
  public final com.tencent.mm.live.core.core.c.c getLiveCore()
  {
    a.a locala = com.tencent.mm.live.core.core.c.a.kqk;
    return (com.tencent.mm.live.core.core.c.c)a.a.FC(getData().zey.getLiveId());
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a getLiveEndUIC()
  {
    return this.liveEndUIC;
  }
  
  protected final e getLivePrepareUIC()
  {
    return this.livePrepareUIC;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c getLivingUIC()
  {
    return this.livingUIC;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c getStartUIC()
  {
    return this.livingUIC;
  }
  
  public void prepareToStart(boolean paramBoolean)
  {
    com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c localc = this.livingUIC;
    if (localc != null)
    {
      localObject1 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
      com.tencent.mm.plugin.findersdk.f.b.hA(localc.TAG, "startLive ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEE())
        {
          localObject1 = com.tencent.mm.plugin.finder.live.model.ah.yhC;
          localObject1 = com.tencent.mm.plugin.finder.live.model.ah.getFinderLiveAssistant();
          if (localObject1 != null) {
            ((an)localObject1).dxY();
          }
        }
        localObject1 = localc.ycZ;
        if (localObject1 != null) {
          com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
        }
        localObject1 = localc.zkr;
        if (localObject1 != null) {
          ((ca)localObject1).dCn();
        }
        com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c.a(localc, true, false, 2);
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) {
          localc.dHs();
        }
        localObject1 = localc.ycZ;
        if (localObject1 != null) {
          b.b.a((com.tencent.mm.live.c.b)localObject1, b.c.kAn);
        }
        localObject1 = localc.zkp;
        if (localObject1 != null)
        {
          localObject1 = (View)((di)localObject1).knt.getRenderLayout();
          if (localObject1 != null) {
            ((View)localObject1).post((Runnable)new c.g(localc));
          }
        }
        localObject1 = localc.zjH;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject1).dAS();
        }
        localObject1 = localc.zkz;
        if (localObject1 != null) {
          ((cu)localObject1).po(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGP());
        }
        localObject1 = localc.ycZ;
        if (localObject1 != null) {
          b.b.a((com.tencent.mm.live.c.b)localObject1, b.c.kzj);
        }
        d.a(200L, (kotlin.g.a.a)new c.h(localc));
        Log.i(localc.TAG, "joinLiveByMiniWin audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ());
      }
    }
    else
    {
      return;
    }
    Object localObject1 = "joinLive " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).info();
    Log.i(localc.TAG, (String)localObject1);
    Object localObject2 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
    com.tencent.mm.plugin.findersdk.f.b.hA(localc.TAG, (String)localObject1);
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.kih;
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.SLN;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((bch)localObject1).kmi);
      label456:
      com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c.a(localc, l, (String)localObject2, (Integer)localObject1);
      localObject1 = ar.AIS;
      localObject2 = new StringBuilder();
      Object localObject3 = ar.AIS;
      localObject2 = ar.efV() + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      localObject3 = ap.AIh;
      ar.a((ar)localObject1, (String)localObject2, ap.efi().name, null, false, false, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfY, 28);
      localObject1 = m.yfw;
      m.dyw();
      localObject1 = am.yij;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
      p.k(localObject1, "anchorUserName");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label691;
      }
      Log.e("FinderLive.FinderLiveWatchTimeMgr", "joinLive anchorUserName nil");
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.component.u.ybO;
      u.a.Lh(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
      localObject1 = com.tencent.mm.plugin.finder.live.model.ah.yhC;
      localObject1 = com.tencent.mm.plugin.finder.live.model.ah.getFinderLiveAssistant();
      if (localObject1 == null) {
        break;
      }
      ((an)localObject1).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, 2, (kotlin.g.a.u)new c.f(localc));
      return;
      localObject1 = null;
      break label456;
      label691:
      am.dzT().put(localObject1, Long.valueOf(Util.nowSecond()));
    }
  }
  
  public final void setLiveCore(com.tencent.mm.live.core.core.c.c paramc)
  {
    this.liveCore = paramc;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a parama)
  {
    this.liveEndUIC = parama;
  }
  
  protected final void setLivePrepareUIC(e parame)
  {
    this.livePrepareUIC = parame;
  }
  
  public final void setLivingUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c paramc)
  {
    this.livingUIC = paramc;
  }
  
  public void startToEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.c
 * JD-Core Version:    0.7.0.1
 */