package com.tencent.mm.plugin.finder.live.view.router;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.plugin.finder.live.component.aj.a;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b.b;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.u;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;)V", "liveEndUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "getLiveEndUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "setLiveEndUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;)V", "livePrepareUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "getLivePrepareUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "setLivePrepareUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;)V", "livingUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "getLivingUIC", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "setLivingUIC", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;)V", "getPrepareUIC", "getStartUIC", "prepareToStart", "", "byMiniWin", "", "startToEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private com.tencent.mm.live.core.core.f.d liveCore;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a liveEndUIC;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c livePrepareUIC;
  private com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b livingUIC;
  
  public c(Context paramContext, Fragment paramFragment, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramFragment, paramAttributeSet);
    this.livePrepareUIC = new com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c((AppCompatActivity)paramContext);
    this.livingUIC = new com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b((AppCompatActivity)paramContext);
    this.liveEndUIC = new com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final com.tencent.mm.live.core.core.f.d getLiveCore()
  {
    a.a locala = com.tencent.mm.live.core.core.f.a.mUf;
    return (com.tencent.mm.live.core.core.f.d)a.a.hH(getData().Ebr.liveId);
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a getLiveEndUIC()
  {
    return this.liveEndUIC;
  }
  
  protected final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c getLivePrepareUIC()
  {
    return this.livePrepareUIC;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b getLivingUIC()
  {
    return this.livingUIC;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c getPrepareUIC()
  {
    return this.livePrepareUIC;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b getStartUIC()
  {
    return this.livingUIC;
  }
  
  public void prepareToStart(boolean paramBoolean)
  {
    boolean bool = true;
    com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b localb = this.livingUIC;
    if (localb != null)
    {
      localObject1 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      com.tencent.mm.plugin.findersdk.f.b.iz(localb.TAG, s.X("startLive ", Boolean.valueOf(paramBoolean)));
      if (!paramBoolean) {
        break label84;
      }
      localb.ezt();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
      localObject2 = localb.CCg;
      if (localObject2 != null) {
        ((c)localObject2).statusChange(b.c.ncj, (Bundle)localObject1);
      }
    }
    return;
    label84:
    Object localObject1 = "joinLive " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).info() + ",liveMode:" + ((e)localb.business(e.class)).EcR;
    Log.i(localb.TAG, (String)localObject1);
    Object localObject2 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
    com.tencent.mm.plugin.findersdk.f.b.iz(localb.TAG, (String)localObject1);
    localObject1 = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
    label175:
    long l;
    label215:
    label217:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      localObject2 = (e)localb.business(e.class);
      if ((l != 0L) && (localObject1 != null)) {
        break label689;
      }
      paramBoolean = false;
      ((e)localObject2).EeM = paramBoolean;
      Log.i(localb.TAG, "initGiftEffectEnable giftEffectOffLiveId:" + localObject1 + " curLiveId:" + l);
      localObject1 = localb.getLiveCore();
      if (localObject1 != null) {
        break label704;
      }
      paramBoolean = false;
      label271:
      if (paramBoolean)
      {
        localObject1 = localb.EjV;
        if (localObject1 != null)
        {
          localObject2 = ((cc)localObject1).getLiveCore();
          if (localObject2 != null) {
            ((com.tencent.mm.live.core.core.f.d)localObject2).setMute(false);
          }
          Log.i(((cc)localObject1).TAG, s.X("txLivePlayer, mute:", Boolean.FALSE));
        }
      }
      localObject1 = bd.Gli;
      localObject2 = s.X(bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      localObject3 = bb.GjM;
      bd.a((bd)localObject1, (String)localObject2, bb.fhf().name, null, false, false, ((e)localb.business(e.class)).EdO, 28);
      localObject1 = q.CFU;
      q.ekN();
      localObject1 = ao.CIe;
      localObject1 = ((e)localb.business(e.class)).mIC;
      s.u(localObject1, "anchorUserName");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label730;
      }
      Log.e("FinderLive.FinderLiveWatchTimeMgr", "joinLive anchorUserName nil");
      label443:
      localObject1 = com.tencent.mm.plugin.finder.live.component.aj.CzY;
      aj.a.nU(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((bn)com.tencent.mm.ui.component.k.d(localb.CCa).cq(bn.class)).foA();
      if (localObject1 != null) {
        break label750;
      }
      localObject1 = "";
    }
    label689:
    label704:
    label730:
    label750:
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = ((bn)com.tencent.mm.ui.component.k.d(localb.CCa).cq(bn.class)).foz();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.live.report.k.rO((String)localObject1, (String)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null) {
        ((ap)localObject1).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, 2, (u)new b.b(new SoftReference(localb), localb.TAG));
      }
      localObject1 = localb.CCg;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.business.a)((c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.business.a.class);
      if (localObject1 == null) {
        break;
      }
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.business.a.TAG, "markJoinStatusWaitResp");
      ((com.tencent.mm.plugin.finder.live.viewmodel.business.a)localObject1).DZT = com.tencent.mm.plugin.finder.live.viewmodel.business.a.DZV;
      return;
      localObject1 = Long.valueOf(((MultiProcessMMKV)localObject1).getLong("VISITOR_GIFT_EFFECT_OFF_LIVE_ID", 0L));
      break label175;
      if (l != ((Long)localObject1).longValue()) {
        break label215;
      }
      paramBoolean = bool;
      break label217;
      localObject1 = ((com.tencent.mm.live.core.core.f.d)localObject1).mUn;
      if (localObject1 == null)
      {
        paramBoolean = false;
        break label271;
      }
      paramBoolean = ((com.tencent.mm.live.core.core.d)localObject1).isPlaying();
      break label271;
      ao.emf().put(localObject1, Long.valueOf(Util.nowSecond()));
      break label443;
    }
  }
  
  public final void setLiveCore(com.tencent.mm.live.core.core.f.d paramd)
  {
    this.liveCore = paramd;
  }
  
  protected final void setLiveEndUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a parama)
  {
    this.liveEndUIC = parama;
  }
  
  protected final void setLivePrepareUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c paramc)
  {
    this.livePrepareUIC = paramc;
  }
  
  protected final void setLivingUIC(com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b paramb)
  {
    this.livingUIC = paramb;
  }
  
  public void startToEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.router.c
 * JD-Core Version:    0.7.0.1
 */