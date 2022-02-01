package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.b.a;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.model.h.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.bb;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bi;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.bs;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.plugin.cn;
import com.tencent.mm.plugin.finder.live.plugin.cp;
import com.tencent.mm.plugin.finder.live.plugin.cr;
import com.tencent.mm.plugin.finder.live.plugin.ct;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.bd;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.s.s;
import com.tencent.mm.plugin.finder.live.report.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.b;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c.i;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c.j;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.rtmp.TXLivePlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "liveMessageCallback", "Lkotlin/Function0;", "", "getLiveMessageCallback", "()Lkotlin/jvm/functions/Function0;", "setLiveMessageCallback", "(Lkotlin/jvm/functions/Function0;)V", "activate", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "", "restart", "applyState", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "isCurLive", "getLiveRole", "getRelativeLayoutId", "mount", "name", "needHideBgLayer", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPress", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "onLiveEventCallback", "errorCode", "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "release", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.live.view.router.b
  implements i
{
  private String TAG;
  private HashMap _$_findViewCache;
  private kotlin.g.a.a<x> liveMessageCallback;
  
  public c(MMActivity paramMMActivity, Fragment paramFragment)
  {
    super((Context)paramMMActivity, paramFragment);
    AppMethodBeat.i(274761);
    this.TAG = "FinderLiveAnchorSecondaryPluginLayout";
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(274761);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(274766);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(274766);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(274764);
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
    AppMethodBeat.o(274764);
    return localView1;
  }
  
  public final void activate(f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(274745);
    kotlin.g.b.p.k(paramf, "data");
    super.activate(paramf, paramBoolean1, paramBoolean2);
    Log.i(this.TAG, "liveFinish:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfi + ",isFromFloat:" + paramBoolean1 + ", restart:" + paramBoolean2 + ",liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ",objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk + ",nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId + ",username:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
    paramf = getLivePrepareUIC();
    if (paramBoolean1) {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfi)
      {
        paramf = paramf.ycX;
        if (paramf != null) {
          b.b.a(paramf, b.c.kzn);
        }
      }
    }
    for (;;)
    {
      paramf = aj.yif;
      aj.j(name(), (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(274745);
      return;
      paramf = paramf.ycX;
      if (paramf != null)
      {
        paramf.prepareToStart(true);
        continue;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ != null)
        {
          FinderObject localFinderObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
          if ((localFinderObject == null) || (localFinderObject.id != 0L)) {}
        }
        else
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().MH(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk).getFinderObject();
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziF = true;
        paramf = paramf.ycX;
        if (paramf != null) {
          paramf.prepareToStart(false);
        }
      }
    }
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(274755);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN())
    {
      a.hideLoadingLayer$default(this, false, 1, null);
      getLivePrepareUIC();
      localObject1 = getLiveStartUIC();
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjc;
      if (localObject2 != null) {
        ((as)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjd;
      if (localObject2 != null) {
        ((cr)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zje;
      if (localObject2 != null) {
        ((at)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).ysG;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjf;
      if (localObject2 != null) {
        ((cd)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjj;
      if (localObject2 != null) {
        ((bi)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjk;
      if (localObject2 != null) {
        ((bt)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjo;
      if (localObject2 != null) {
        ((o)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjl;
      if (localObject2 != null) {
        ((cj)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjm;
      if (localObject2 != null) {
        ((cl)localObject2).tU(8);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhe)
      {
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit = true");
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhf;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhg;
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
          if (localObject4 != null) {
            ((n)localObject4).tU(0);
          }
          localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
          if (localObject4 != null) {
            ((n)localObject4).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, (aze)localObject2, ((Integer)localObject3).intValue());
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zji;
          if (localObject2 != null) {
            ((by)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjn;
          if (localObject2 != null) {
            ((ct)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjq;
          if (localObject2 != null) {
            ((bk)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjr;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjs;
          if (localObject2 != null) {
            ((bb)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjt;
          if (localObject2 != null) {
            ((bd)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjx;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjB;
          if (localObject2 != null) {
            ((af)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zki;
          if (localObject2 != null) {
            ((cn)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjJ;
          if (localObject2 != null) {
            ((cc)localObject2).tU(8);
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjy;
          if (localObject1 != null) {
            ((bo)localObject1).tU(8);
          }
          localObject1 = getLiveEndUIC();
          if ((paramBundle == null) || (!paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL")) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy))
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1).ziW;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).N((kotlin.g.a.a)new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.a((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1));
            }
          }
        }
      }
    }
    for (;;)
    {
      super.applyState(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(274755);
      return;
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit, but no cache errorPage");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
      if (localObject2 == null) {
        break;
      }
      ((n)localObject2).tU(8);
      break;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
      if (localObject2 == null) {
        break;
      }
      ((n)localObject2).tU(8);
      break;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())
      {
        int i;
        if (((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).lastLiveState != 3) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv == 3)) || ((com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfw, 32)) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 32))))
        {
          i = 1;
          label787:
          if (i != 0) {
            a.hideLoadingLayer$default(this, false, 1, null);
          }
          getLivePrepareUIC();
          localObject1 = getLiveStartUIC();
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjd;
          if (localObject2 != null) {
            cr.a((cr)localObject2, null, false, 3);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjc;
          if (localObject2 != null) {
            ((as)localObject2).tU(0);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjd;
          if (localObject2 != null) {
            ((cr)localObject2).tU(0);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zje;
          if (localObject2 != null) {
            ((at)localObject2).tU(0);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).ysG;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(0);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjk;
          if (localObject2 != null) {
            ((bt)localObject2).tU(0);
          }
          if (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 512)) {
            break label1294;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjo;
          if (localObject2 != null) {
            ((o)localObject2).tU(8);
          }
          label961:
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjf;
          if (localObject2 != null) {
            ((cd)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
          if (localObject2 != null) {
            ((n)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjj;
          if (localObject2 != null) {
            ((bi)localObject2).tU(0);
          }
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB) {
            break label1315;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjl;
          if (localObject2 != null) {
            ((cj)localObject2).tU(0);
          }
          label1052:
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zje;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.live.c.a)localObject2).kiF;
            if (localObject2 != null) {
              ((ViewGroup)localObject2).post((Runnable)new c.i((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1));
            }
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjx;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).dAr();
          }
          if (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 524288)) {
            break label1400;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycX;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).forceScreenToPortrait();
          }
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy) {
            break label1337;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycX;
          if (localObject2 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
            localObject4 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycV.getResources().getString(b.j.finder_live_pauseing_tips);
            kotlin.g.b.p.j(localObject4, "context.resources.getStr…inder_live_pauseing_tips)");
            String str = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycV.getResources().getString(b.j.finder_live_pause_mini_game_action);
            kotlin.g.b.p.j(str, "context.resources.getStr…e_pause_mini_game_action)");
            ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).showTipWithBlurBgAction((String)localObject3, (String)localObject4, str, (kotlin.g.a.a)new c.k((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1));
          }
        }
        for (;;)
        {
          localObject1 = getLiveEndUIC().ziW;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tU(8);
          break;
          i = 0;
          break label787;
          label1294:
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjo;
          if (localObject2 == null) {
            break label961;
          }
          ((o)localObject2).tU(0);
          break label961;
          label1315:
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjl;
          if (localObject2 == null) {
            break label1052;
          }
          ((cj)localObject2).tU(8);
          break label1052;
          label1337:
          localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycX;
          if (localObject2 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
            localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycV.getResources().getString(b.j.finder_live_anchor_exception);
            kotlin.g.b.p.j(localObject1, "context.resources.getStr…er_live_anchor_exception)");
            ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).showBlurBgWithTimeCount((String)localObject3, (String)localObject1);
            continue;
            label1400:
            if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 32))
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycX;
              if (localObject2 != null)
              {
                localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
                localObject4 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).ycV.getResources().getString(b.j.finder_live_living_exception_tip_network);
                kotlin.g.b.p.j(localObject4, "context.resources.getStr…ng_exception_tip_network)");
                ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).showTipWithBlurBg((String)localObject3, (String)localObject4);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjo;
              if (localObject2 != null) {
                ((o)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjm;
              if (localObject2 != null) {
                ((cl)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjl;
              if (localObject2 != null) {
                ((cj)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjj;
              if (localObject2 != null) {
                ((bi)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).ysG;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zji;
              if (localObject2 != null) {
                ((by)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjr;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjx;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjB;
              if (localObject2 != null) {
                ((af)localObject2).tU(8);
              }
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zki;
              if (localObject2 != null) {
                ((cn)localObject2).tU(8);
              }
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjJ;
              if (localObject1 != null) {
                ((cc)localObject1).tU(8);
              }
            }
          }
        }
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGM())
      {
        a.hideLoadingLayer$default(this, false, 1, null);
        getLivePrepareUIC();
        localObject1 = getLiveStartUIC();
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjc;
        if (localObject2 != null) {
          ((as)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjd;
        if (localObject2 != null) {
          ((cr)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zje;
        if (localObject2 != null) {
          ((at)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).ysG;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjg;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.l)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjf;
        if (localObject2 != null) {
          ((cd)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjh;
        if (localObject2 != null) {
          ((bq)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zji;
        if (localObject2 != null) {
          ((by)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjl;
        if (localObject2 != null) {
          ((cj)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjm;
        if (localObject2 != null) {
          ((cl)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zja;
        if (localObject2 != null) {
          ((n)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjj;
        if (localObject2 != null) {
          ((bi)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjk;
        if (localObject2 != null) {
          ((bt)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjo;
        if (localObject2 != null) {
          ((o)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjn;
        if (localObject2 != null) {
          ((ct)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjq;
        if (localObject2 != null) {
          ((bk)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjr;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjs;
        if (localObject2 != null) {
          ((bb)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjt;
        if (localObject2 != null) {
          ((bd)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjx;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjB;
        if (localObject2 != null) {
          ((af)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zki;
        if (localObject2 != null) {
          ((cn)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjJ;
        if (localObject2 != null) {
          ((cc)localObject2).tU(8);
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).zjy;
        if (localObject1 != null) {
          ((bo)localObject1).tU(8);
        }
        localObject1 = getLiveEndUIC().ziW;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tU(8);
        }
      }
    }
  }
  
  public final void bindData(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(274744);
    kotlin.g.b.p.k(paramf, "data");
    super.bindData(paramf, paramBoolean);
    paramf = com.tencent.mm.live.core.core.b.a.knj;
    setLiveCore((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.b.a.a.aLu());
    paramf = getLiveCore();
    if (paramf != null)
    {
      e.g localg = e.g.kkm;
      paramf.setScene(e.g.aKt());
    }
    getLivePrepareUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    getLiveStartUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    getLiveEndUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    AppMethodBeat.o(274744);
  }
  
  protected final kotlin.g.a.a<x> getLiveMessageCallback()
  {
    return this.liveMessageCallback;
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  public final int getRelativeLayoutId()
  {
    return b.g.finder_live_anchor_secondary_device_ui;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(274753);
    super.mount();
    Object localObject = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.d(name(), this.liveMessageCallback);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3861, (i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3603, (i)this);
    AppMethodBeat.o(274753);
  }
  
  public final String name()
  {
    AppMethodBeat.i(274747);
    String str = c.class.getSimpleName();
    kotlin.g.b.p.j(str, "FinderLiveAnchorSecondar…ut::class.java.simpleName");
    AppMethodBeat.o(274747);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(274760);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(274760);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = k.yBj;
        paramIntent = k.dDm().yDw;
        paramIntent.yNz += 1L;
        AppMethodBeat.o(274760);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = k.yBj;
          paramIntent = k.dDm().yDw;
          paramIntent.yNy += 1L;
        }
      }
    }
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(274754);
    boolean bool = super.onBackPress();
    if (!bool)
    {
      k localk = k.yBj;
      k.t(s.a.yDV.jWO, "");
      localk = k.yBj;
      k.a(k.dDk());
    }
    AppMethodBeat.o(274754);
    return bool;
  }
  
  public final void onBattleApply() {}
  
  public final void onBattleClose() {}
  
  public final void onBattleDismiss() {}
  
  public final void onBattleEnd() {}
  
  public final void onBattleStart() {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(274746);
    kotlin.g.b.p.k(paramString, "incomingNumber");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = getLiveCore();
    if (paramString != null)
    {
      paramString = paramString.knA;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        Log.i(str, paramString);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(274746);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(274746);
      return;
      setManualClosed(true);
      b.b.a(this, b.c.kyV);
    }
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(274758);
    Log.i(this.TAG, "sdk callback errorCode:".concat(String.valueOf(paramInt)));
    Object localObject3 = com.tencent.mm.plugin.finder.utils.aq.AIJ;
    localObject3 = getBuContext();
    Object localObject4 = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    kotlin.g.b.p.j(localObject4, "NetStatusUtil.getNetType…tionContext.getContext())");
    com.tencent.mm.plugin.finder.utils.aq.b((com.tencent.mm.plugin.finder.live.model.context.a)localObject3, (String)localObject4);
    localObject3 = getLiveStartUIC();
    localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJU())
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).dHl();
      AppMethodBeat.o(274758);
      return;
    }
    localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJR())
    {
      paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
      if (paramBundle != null)
      {
        paramBundle = Integer.valueOf(paramBundle.getCurNetworkQuality());
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (localObject2 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).kHp;
          if (localObject4 == null) {
            break label321;
          }
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).knA;
          if (localObject4 == null) {
            break label321;
          }
          paramInt = ((com.tencent.mm.live.core.core.model.h)localObject4).kmJ;
          label167:
          ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).setCurNetworkQuality(paramInt);
        }
        localObject2 = e.m.kkI;
        paramInt = e.m.aKJ();
        if (paramBundle != null) {
          break label333;
        }
        label186:
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (localObject2 == null) {
          break label341;
        }
        paramInt = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).getCurNetworkQuality();
        localObject2 = e.m.kkI;
        if (paramInt != e.m.aKJ()) {
          break label341;
        }
        paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (paramBundle != null) {
          b.b.a(paramBundle, b.c.kzJ);
        }
        label233:
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null) {
          paramBundle = Integer.valueOf(((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).getCurNetworkType());
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).kHp;
          if (localObject2 == null) {
            break label408;
          }
          localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knA;
          if (localObject2 == null) {
            break label408;
          }
        }
      }
      label408:
      for (paramInt = ((com.tencent.mm.live.core.core.model.h)localObject2).networkType;; paramInt = -1)
      {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).setCurNetworkType(paramInt);
        if (paramBundle != null) {
          break label413;
        }
        AppMethodBeat.o(274758);
        return;
        paramBundle = null;
        break;
        label321:
        localObject4 = e.m.kkI;
        paramInt = e.m.aKH();
        break label167;
        label333:
        if (paramBundle.intValue() != paramInt) {
          break label186;
        }
        label341:
        localObject2 = e.m.kkI;
        paramInt = e.m.aKJ();
        if ((paramBundle == null) || (paramBundle.intValue() != paramInt)) {
          break label233;
        }
        paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (paramBundle != null)
        {
          paramInt = paramBundle.getCurNetworkQuality();
          paramBundle = e.m.kkI;
          if (paramInt == e.m.aKJ()) {
            break label233;
          }
        }
        paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if (paramBundle == null) {
          break label233;
        }
        b.b.a(paramBundle, b.c.kzK);
        break label233;
      }
      label413:
      if (paramBundle.intValue() == 0)
      {
        paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
        if ((paramBundle == null) || (paramBundle.getCurNetworkType() != 0))
        {
          paramBundle = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycX;
          if ((paramBundle == null) || (paramBundle.getCurNetworkType() != -1))
          {
            w.makeText((Context)((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycV, (CharSequence)((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject3).ycV.getResources().getString(b.j.finder_live_living_with_cellular), 0).show();
            AppMethodBeat.o(274758);
          }
        }
      }
    }
    else
    {
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aKd())
      {
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).TAG, "param:".concat(String.valueOf(paramBundle)));
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (paramBundle != null) {}
        for (paramInt = paramBundle.getInt("EVT_PARAM1");; paramInt = 0)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).videoWidth = paramInt;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          paramInt = i;
          if (paramBundle != null) {
            paramInt = paramBundle.getInt("EVT_PARAM2");
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).videoHeight = paramInt;
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).TAG, "videoWidth:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoWidth + ",videoHeight:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoHeight);
          ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).dHs();
          AppMethodBeat.o(274758);
          return;
        }
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aKi())
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject3).zki;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (paramBundle != null) {
            localObject1 = paramBundle.getString("live_cdn_sei_msg");
          }
          ((cn)localObject3).aCw((String)localObject1);
          AppMethodBeat.o(274758);
          return;
        }
      }
    }
    AppMethodBeat.o(274758);
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(274757);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    AppMethodBeat.o(274757);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(274750);
    super.pause();
    AppMethodBeat.o(274750);
  }
  
  public final void release()
  {
    AppMethodBeat.i(274759);
    Log.i(this.TAG, "release");
    Object localObject1 = getLiveStartUIC();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).checkMiniWindow();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c)localObject1).kKL.stopTimer();
    localObject1 = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.aNy();
    localObject1 = aj.yif;
    aj.dzR();
    localObject1 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject1, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject1).aGY().b(3861, (i)this);
    localObject1 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject1, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject1).aGY().b(3603, (i)this);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfi)
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgC)
        {
          com.tencent.mm.plugin.gamelive.d locald = (com.tencent.mm.plugin.gamelive.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.d.class);
          Context localContext = getContext();
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.CqZ;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgA;
          localObject1 = Boolean.FALSE;
          locald.a(localContext, (String)localObject2, i, (Boolean)localObject1, (Boolean)localObject1, Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId));
        }
        localObject1 = ah.yhC;
        ah.a(false, getMiniWinPermission(), null, 5);
        localObject1 = getLiveCore();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
          if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject1).isFloatMode()) && (!getMiniWinPermission()))
          {
            localObject1 = com.tencent.mm.live.b.p.kvF;
            com.tencent.mm.live.b.p.release();
            localObject1 = getLiveCore();
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.trtc.a)localObject1).aJB();
            }
            getBuContext().clear();
          }
        }
      }
      Object localObject2 = getLiveCore();
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.live.core.core.c.c)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.live.core.core.c.c)localObject1;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.c.c)localObject1).fi(false);
        AppMethodBeat.o(274759);
        return;
      }
      AppMethodBeat.o(274759);
      return;
    }
    localObject1 = getLiveCore();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if (localObject1 != null)
      {
        if ((((com.tencent.mm.live.core.core.model.h)localObject1).isFloatMode()) || (getMiniWinPermission())) {
          break label465;
        }
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfB)
        {
          localObject1 = ah.yhC;
          ah.a(false, getMiniWinPermission(), Boolean.FALSE, 1);
          getBuContext().clear();
        }
        localObject1 = getLiveCore();
        if (localObject1 == null) {
          break label465;
        }
        ((com.tencent.mm.live.core.core.trtc.a)localObject1).aJB();
        AppMethodBeat.o(274759);
        return;
      }
    }
    AppMethodBeat.o(274759);
    return;
    label465:
    AppMethodBeat.o(274759);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(274749);
    super.resume();
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).kHp;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knA;
      if ((localObject2 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject2).kmv))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).kHp;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).aJz();
          AppMethodBeat.o(274749);
          return;
        }
        AppMethodBeat.o(274749);
        return;
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.b)localObject1).kHp;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.model.h)localObject1).kmv = false;
        AppMethodBeat.o(274749);
        return;
      }
    }
    AppMethodBeat.o(274749);
  }
  
  protected final void setLiveMessageCallback(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274743);
    kotlin.g.b.p.k(parama, "<set-?>");
    this.liveMessageCallback = parama;
    AppMethodBeat.o(274743);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(274742);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(274742);
  }
  
  public final void start()
  {
    AppMethodBeat.i(274752);
    super.start();
    getLiveStartUIC().startTimer();
    AppMethodBeat.o(274752);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(274756);
    kotlin.g.b.p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    getLivePrepareUIC();
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.e.a(paramc);
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c localc = getLiveStartUIC();
    kotlin.g.b.p.k(paramc, "status");
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int i;
    boolean bool;
    label403:
    label547:
    label709:
    label1147:
    Object localObject2;
    switch (com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      for (;;)
      {
        localObject1 = getLiveEndUIC();
        kotlin.g.b.p.k(paramc, "status");
        switch (com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b.$EnumSwitchMapping$0[paramc.ordinal()])
        {
        default: 
          AppMethodBeat.o(274756);
          return;
          Log.i(localc.TAG, "start live failed");
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN())
          {
            localObject1 = localc.zjf;
            if (localObject1 != null) {
              ((cd)localObject1).tU(8);
            }
            localObject1 = localc.ycX;
            if (localObject1 != null)
            {
              localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
              localObject4 = localc.ycV.getResources().getString(b.j.live_local_network_error_tip);
              kotlin.g.b.p.j(localObject4, "context.resources.getStr…_local_network_error_tip)");
              ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).showTipWithBlurBg((String)localObject3, (String)localObject4);
            }
          }
          localObject1 = k.yBj;
          k.t(s.a.yDM.jWO, String.valueOf(s.bd.yKR.type));
          localObject1 = k.yBj;
          if (paramBundle != null) {}
          for (i = paramBundle.getInt("live_user_exit_reason", 0);; i = 0)
          {
            k.setErrorCode(i);
            localObject1 = k.yBj;
            k.b(s.s.yGI);
            break;
          }
          if (paramBundle != null)
          {
            bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW");
            localObject3 = localc.TAG;
            localObject4 = new StringBuilder("checkFinderObject id:");
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
            if (localObject1 == null) {
              break label640;
            }
            localObject1 = Long.valueOf(((FinderObject)localObject1).id);
            Log.i((String)localObject3, localObject1 + ", nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ != null)
            {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
              if ((localObject1 == null) || (((FinderObject)localObject1).id != 0L)) {
                break label709;
              }
            }
            if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId)) {
              break label709;
            }
            localObject1 = new bid();
            localObject3 = ah.yhC;
            localObject3 = ah.dwh();
            if (localObject3 == null) {
              break label646;
            }
            localObject3 = ((g)localObject3).xVT;
            if (localObject3 == null) {
              break label646;
            }
            i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject3).xkX;
            ((bid)localObject1).fGo = i;
            localObject3 = ah.yhC;
            localObject3 = ah.dwh();
            if (localObject3 == null) {
              break label651;
            }
            localObject3 = ((g)localObject3).xVT;
            if (localObject3 == null) {
              break label651;
            }
          }
          for (i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject3).xkX;; i = 0)
          {
            ((bid)localObject1).xkX = i;
            localObject3 = (com.tencent.mm.plugin.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.c.class);
            localObject4 = localc.ycV;
            if (localObject4 != null) {
              break label656;
            }
            paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(274756);
            throw paramc;
            bool = false;
            break;
            localObject1 = null;
            break label403;
            i = 0;
            break label547;
          }
          com.tencent.mm.plugin.c.a.a((com.tencent.mm.plugin.c)localObject3, (MMActivity)localObject4, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, "", (bid)localObject1, (kotlin.g.a.b)new com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c.a(localc));
          localObject1 = ah.yhC;
          ah.Lo(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
          localObject1 = localc.kHp;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).aJC();
          }
          localc.startTimer();
          localObject1 = localc.zjq;
          if (localObject1 != null) {
            ((bk)localObject1).dBS();
          }
          localObject1 = localc.zjy;
          if (localObject1 != null) {
            ((bo)localObject1).dBY();
          }
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB)
          {
            localObject1 = localc.zjx;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).dAr();
            }
            localObject1 = localc.zjl;
            if (localObject1 != null) {
              ((cj)localObject1).tU(0);
            }
            localObject1 = ah.yhC;
            localObject1 = ah.getFinderLiveAssistant();
            if (localObject1 != null)
            {
              localObject3 = localc.ycV;
              if (localObject3 == null)
              {
                paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(274756);
                throw paramc;
              }
              localObject3 = (MMActivity)localObject3;
              long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
              long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
              localObject4 = z.bdh();
              kotlin.g.b.p.j(localObject4, "ConfigStorageLogic.getMyFinderUsername()");
              ((an)localObject1).a((MMActivity)localObject3, l1, l2, (String)localObject4, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, (kotlin.g.a.b)new c.j(localc));
            }
          }
          localObject1 = k.yBj;
          if (!k.dDm().yDy)
          {
            localObject1 = k.yBj;
            k.t(s.a.yDM.jWO, String.valueOf(s.bd.yKS.type));
            localObject1 = k.yBj;
            k.a(s.c.yEi, "");
          }
          localObject1 = localc.zki;
          if (localObject1 != null) {
            ((cn)localObject1).dAH();
          }
          if (bool)
          {
            localObject1 = localc.zjt;
            if (localObject1 != null) {
              ((bd)localObject1).dBJ();
            }
          }
          Log.i(localc.TAG, "START_LIVE byMiniWin:".concat(String.valueOf(bool)));
          continue;
          localObject1 = localc.kHp;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).aJB();
          }
          localObject1 = localc.ycX;
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).finish();
            continue;
            if (paramBundle != null)
            {
              localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true));
              if (paramBundle == null) {
                break label1327;
              }
              i = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);
              if (paramBundle != null) {
                paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 0);
              }
              localObject3 = localc.kHp;
              if (localObject3 != null)
              {
                localObject3 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knA;
                if ((localObject3 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject3).isFloatMode()))
                {
                  localObject3 = localc.kHp;
                  if (localObject3 != null)
                  {
                    localObject4 = (Context)localc.ycV;
                    if (localObject1 == null) {
                      break label1332;
                    }
                  }
                }
              }
            }
            for (bool = ((Boolean)localObject1).booleanValue();; bool = true)
            {
              b.a.a((com.tencent.mm.live.core.core.b)localObject3, (Context)localObject4, bool, false, i, 0, null, 48);
              if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 524288))
              {
                localObject1 = ah.yhC;
                ah.dzy();
              }
              localObject1 = ah.yhC;
              ah.dzC();
              localObject1 = k.yBj;
              localObject1 = k.dDm().yDw;
              ((u)localObject1).yNx += 1L;
              break;
              localObject1 = null;
              break label1147;
              i = 0;
              break label1160;
            }
            localObject1 = localc.kHp;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
              if (localObject1 != null)
              {
                ((com.tencent.mm.live.core.core.model.h)localObject1).kmA = h.e.kmW;
                continue;
                if (paramBundle != null)
                {
                  localObject3 = paramBundle.getByteArray("PARAM_FINDER_LIVE_TOP_COMMENT");
                  if (localObject3 != null)
                  {
                    localObject1 = new bbd();
                    ((bbd)localObject1).parseFrom((byte[])localObject3);
                    localObject3 = new ArrayList();
                    ((ArrayList)localObject3).add(localObject1);
                    localObject1 = localc.zjn;
                    if (localObject1 != null) {
                      ((ct)localObject1).ep((List)localObject3);
                    }
                    localObject1 = k.yBj;
                    localObject1 = k.dDm().yDw;
                    ((u)localObject1).yNI += 1L;
                  }
                }
              }
            }
          }
          break;
        }
      }
    case 8: 
      Log.i(localc.TAG, "param:".concat(String.valueOf(paramBundle)));
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EVT_PARAM1");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).videoWidth = i;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (paramBundle == null) {
          break label1692;
        }
        i = paramBundle.getInt("EVT_PARAM2");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).videoHeight = i;
        Log.i(localc.TAG, "videoWidth:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoWidth + ",videoHeight:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoHeight);
        localObject1 = localc.zkh;
        if (localObject1 != null)
        {
          localObject1 = ((cp)localObject1).kjc;
          if (localObject1 != null)
          {
            localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            localObject3 = localc.buContext;
            localObject4 = localc.ycX;
            if (localObject4 == null) {
              break label1697;
            }
          }
        }
      }
      for (bool = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject4).isLandscape();; bool = false)
      {
        ((TXLivePlayer)localObject1).setRenderMode(com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject3, bool));
        localc.dHs();
        break;
        i = 0;
        break label1517;
        i = 0;
        break label1547;
      }
    case 9: 
      label640:
      label646:
      label651:
      label656:
      label1327:
      label1332:
      label1517:
      if (paramBundle != null)
      {
        localObject3 = paramBundle.getByteArray("PARAM_FINDER_LIVE_ERROR_PAGE");
        if (localObject3 != null) {
          localObject1 = new aze();
        }
      }
      for (;;)
      {
        try
        {
          label1160:
          label1547:
          label1692:
          label1697:
          ((aze)localObject1).parseFrom((byte[])localObject3);
          if (paramBundle == null) {
            break label1842;
          }
          localObject3 = paramBundle.getString("PARAM_FINDER_LIVE_FACE_VERIFY_URL");
          if (paramBundle == null) {
            break label1848;
          }
          localObject4 = paramBundle.getString("PARAM_FINDER_LIVE_USERNAME");
          n localn = localc.zja;
          if (localn != null) {
            localn.a((String)localObject3, (String)localObject4, (aze)localObject1);
          }
          localObject1 = localc.zja;
          if (localObject1 == null) {
            break;
          }
          ((n)localObject1).tU(0);
        }
        catch (Throwable localThrowable1)
        {
          Log.e(localc.TAG, "statusChange:", new Object[] { localThrowable1 });
          localObject2 = null;
          continue;
        }
        localObject2 = null;
        continue;
        label1842:
        localObject3 = null;
        continue;
        label1848:
        localObject4 = null;
      }
    }
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getByteArray("PARAM_FINDER_LIVE_ERROR_PAGE");
      if (localObject3 != null) {
        localObject2 = new aze();
      }
    }
    aze localaze;
    for (;;)
    {
      try
      {
        ((aze)localObject2).parseFrom((byte[])localObject3);
        if (paramBundle == null) {
          break label2558;
        }
        i = paramBundle.getInt("PARAM_FINDER_LIVE_ERROR_CODE");
        localObject3 = localc.ycX;
        if (localObject3 != null) {
          a.hideLoadingLayer$default((a)localObject3, false, 1, null);
        }
        localObject3 = localc.zjc;
        if (localObject3 != null) {
          ((as)localObject3).tU(8);
        }
        localObject3 = localc.zjd;
        if (localObject3 != null) {
          ((cr)localObject3).tU(8);
        }
        localObject3 = localc.zje;
        if (localObject3 != null) {
          ((at)localObject3).tU(8);
        }
        localObject3 = localc.zjf;
        if (localObject3 != null) {
          ((cd)localObject3).tU(8);
        }
        localObject3 = localc.ysG;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject3).tU(8);
        }
        localObject3 = localc.zjg;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.l)localObject3).tU(8);
        }
        localObject3 = localc.zjh;
        if (localObject3 != null) {
          ((bq)localObject3).tU(8);
        }
        localObject3 = localc.zji;
        if (localObject3 != null) {
          ((by)localObject3).tU(8);
        }
        localObject3 = localc.zjj;
        if (localObject3 != null) {
          ((bi)localObject3).tU(8);
        }
        localObject3 = localc.zjk;
        if (localObject3 != null) {
          ((bt)localObject3).tU(8);
        }
        localObject3 = localc.zjn;
        if (localObject3 != null) {
          ((ct)localObject3).tU(8);
        }
        localObject3 = localc.zjo;
        if (localObject3 != null) {
          ((o)localObject3).tU(8);
        }
        localObject3 = localc.zjl;
        if (localObject3 != null) {
          ((cj)localObject3).tU(8);
        }
        localObject3 = localc.zjm;
        if (localObject3 != null) {
          ((cl)localObject3).tU(8);
        }
        localObject3 = localc.zju;
        if (localObject3 != null) {
          ((r)localObject3).tU(8);
        }
        localObject3 = localc.zjv;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.q)localObject3).tU(8);
        }
        localObject3 = localc.zjw;
        if (localObject3 != null) {
          ((bs)localObject3).tU(8);
        }
        localObject3 = localc.zjp;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.j)localObject3).tU(8);
        }
        localObject3 = localc.zjs;
        if (localObject3 != null) {
          ((bb)localObject3).tU(8);
        }
        localObject3 = localc.zjt;
        if (localObject3 != null) {
          ((bd)localObject3).tU(8);
        }
        localObject3 = localc.zjx;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject3).tU(8);
        }
        localObject3 = localc.zjJ;
        if (localObject3 != null) {
          ((cc)localObject3).tU(8);
        }
        if (paramc != b.c.kAw) {
          break label2563;
        }
        localObject3 = localc.zja;
        if (localObject3 != null) {
          ((n)localObject3).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, (aze)localObject2, i);
        }
        if (localc.zja != null)
        {
          Log.i(localc.TAG, "live end by force quit!");
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhe = true;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhf = ((aze)localObject2);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhg = Integer.valueOf(i);
        }
        localObject2 = localc.zja;
        if (localObject2 != null) {
          ((n)localObject2).tU(0);
        }
        localObject2 = localc.kHp;
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject2).sV(4);
        }
        localObject2 = ah.yhC;
        localObject2 = ah.getFinderLiveAssistant();
        if (localObject2 != null) {
          ((an)localObject2).dxV();
        }
        localObject2 = aj.yif;
        aj.dzR();
        localObject2 = ah.yhC;
        ah.aPh();
      }
      catch (Throwable localThrowable2)
      {
        Log.e(localc.TAG, "statusChange:", new Object[] { localThrowable2 });
        localaze = null;
        continue;
      }
      localaze = null;
      continue;
      label2558:
      i = 0;
      continue;
      label2563:
      localObject3 = localc.zja;
      if (localObject3 != null) {
        ((n)localObject3).b(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, localaze, i);
      }
    }
    paramc = localaze.ziW;
    if (paramc != null) {
      paramc.dAp();
    }
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL");
      label2626:
      Log.i(localaze.TAG, "finish live is manual finish:" + bool + ", liveData.business(LiveCommonSlice::class.java).externalPost:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localaze.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy);
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localaze.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy) {
        break label2775;
      }
      paramc = ah.yhC;
      paramc = ah.getFinderLiveAssistant();
      if (paramc != null) {
        paramc.a(true, (kotlin.g.a.s)new a.b(localaze));
      }
      paramc = ah.yhC;
      paramc = ah.getFinderLiveAssistant();
      if (paramc != null) {
        paramc.dxV();
      }
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.aal().putInt("live_status_flag", 0);
      paramc = ah.yhC;
      ah.aPh();
    }
    for (;;)
    {
      localaze.aRk();
      break;
      bool = false;
      break label2626;
      label2775:
      paramc = ah.yhC;
      paramc = ah.getFinderLiveAssistant();
      if (paramc != null) {
        paramc.dxV();
      }
      paramc = ah.yhC;
      ah.aPh();
      if (bool)
      {
        paramc = localaze.ycX;
        if (paramc != null) {
          b.b.a(paramc, b.c.kyW);
        }
      }
      Log.i(localaze.TAG, "quit but not close");
      AppMethodBeat.o(274756);
      return;
      if (paramBundle != null) {}
      for (bool = paramBundle.getBoolean("PARAM_LIVE_MINI_WINDOW_AUTO"); bool; bool = false)
      {
        paramc = ah.yhC;
        ah.a(false, false, Boolean.FALSE, 3);
        paramc = localaze.kHp;
        if (paramc != null) {
          paramc.aJB();
        }
        localaze.aRk();
        localaze.buContext.clear();
        AppMethodBeat.o(274756);
        return;
      }
      paramc = localaze.ziW;
      if (paramc != null) {
        paramc.tU(8);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(274751);
    super.stop();
    getLiveStartUIC().checkMiniWindow();
    AppMethodBeat.o(274751);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.c
 * JD-Core Version:    0.7.0.1
 */