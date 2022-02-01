package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.p;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.an.a;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ad;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.bb;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bi;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bs;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.plugin.co;
import com.tencent.mm.plugin.finder.live.plugin.cr;
import com.tencent.mm.plugin.finder.live.plugin.ct;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.plugin.z;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.aa;
import com.tencent.mm.plugin.finder.live.report.s.ae;
import com.tencent.mm.plugin.finder.live.report.s.ao;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.s.g;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a.a;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a.b;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.j;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "liveMessageCallback", "Lkotlin/Function0;", "", "activate", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "", "restart", "applyState", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "isInitPos", "getLiveRole", "getRelativeLayoutId", "mount", "name", "needHideBgLayer", "notifyAudienceMicUserChange", "notifyPKMicUserChange", "onAcceptBattleTimeout", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onApplyBattleTimeout", "onApplyMicPkTimeout", "onBackPress", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEventCallback", "errorCode", "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "recoveryLocalVideo", "release", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.live.view.router.a
  implements com.tencent.mm.an.i
{
  private String TAG;
  private HashMap _$_findViewCache;
  private kotlin.g.a.a<kotlin.x> liveMessageCallback;
  
  public b(MMActivity paramMMActivity, Fragment paramFragment)
  {
    super((Context)paramMMActivity, paramFragment);
    AppMethodBeat.i(225588);
    this.TAG = "Finder.LiveAnchorPluginLayout";
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(225588);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(225592);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(225592);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(225591);
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
    AppMethodBeat.o(225591);
    return localView1;
  }
  
  public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(225464);
    kotlin.g.b.p.k(paramf, "data");
    super.activate(paramf, paramBoolean1, paramBoolean2);
    Log.i(this.TAG, "liveFinish:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfi + ",isFromFloat:" + paramBoolean1 + ", restart:" + paramBoolean2 + ",liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ",objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk + ",nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId + ",username:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
    paramf = getLivePrepareUIC();
    Object localObject;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId == 0L)
    {
      localObject = k.yBj;
      k.dDm().yDx = false;
      localObject = k.yBj;
      k.dDm().yDy = false;
      paramf = paramf.ycU;
      if (paramf != null) {
        com.tencent.mm.live.c.b.b.a(paramf, com.tencent.mm.live.c.b.c.kyS);
      }
    }
    for (;;)
    {
      paramf = com.tencent.mm.plugin.finder.live.model.aj.yif;
      com.tencent.mm.plugin.finder.live.model.aj.j(name(), (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(225464);
      return;
      if (paramBoolean1)
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfi)
        {
          paramf = paramf.ycU;
          if (paramf != null) {
            com.tencent.mm.live.c.b.b.a(paramf, com.tencent.mm.live.c.b.c.kzn);
          }
        }
        else
        {
          paramf = paramf.ycU;
          if (paramf != null) {
            paramf.prepareToStart(true);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.live.model.ah.yhC;
        if (!com.tencent.mm.plugin.finder.live.model.ah.dzq()) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().MH(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk).getFinderObject();
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziF = true;
        paramf = paramf.ycU;
        if (paramf != null) {
          paramf.prepareToStart(false);
        }
      }
    }
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(225534);
    Object localObject1;
    Object localObject2;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGM())
    {
      a.hideLoadingLayer$default(this, false, 1, null);
      localObject1 = getLivePrepareUIC().zke;
      if (localObject1 != null) {
        ((al)localObject1).tU(0);
      }
      localObject1 = getLiveStartUIC();
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjb;
      if (localObject2 != null) {
        ((ab)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjc;
      if (localObject2 != null) {
        ((as)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjd;
      if (localObject2 != null) {
        ((cr)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zje;
      if (localObject2 != null) {
        ((at)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).ysG;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjg;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.l)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjf;
      if (localObject2 != null) {
        ((cd)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjh;
      if (localObject2 != null) {
        ((bq)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zji;
      if (localObject2 != null) {
        ((by)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjl;
      if (localObject2 != null) {
        ((cj)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjm;
      if (localObject2 != null) {
        ((cl)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
      if (localObject2 != null) {
        ((n)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjj;
      if (localObject2 != null) {
        ((bi)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjk;
      if (localObject2 != null) {
        ((bt)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjo;
      if (localObject2 != null) {
        ((o)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjs;
      if (localObject2 != null) {
        ((bb)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjt;
      if (localObject2 != null) {
        ((bd)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjn;
      if (localObject2 != null) {
        ((ct)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjp;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjq;
      if (localObject2 != null) {
        ((bk)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjr;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zju;
      if (localObject2 != null) {
        ((r)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjv;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.q)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjw;
      if (localObject2 != null) {
        ((bs)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjz;
      if (localObject2 != null) {
        ((br)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjy;
      if (localObject2 != null) {
        ((bo)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjA;
      if (localObject2 != null) {
        ((co)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjH;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjI;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjJ;
      if (localObject2 != null) {
        ((cc)localObject2).tU(8);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGH())
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjB;
        if (localObject1 != null) {
          ((af)localObject1).tU(0);
        }
        localObject1 = getLiveEndUIC().ziW;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tU(8);
        }
      }
    }
    Object localObject3;
    Object localObject4;
    label1664:
    label1717:
    do
    {
      for (;;)
      {
        super.applyState(paramInt1, paramInt2, paramBundle);
        AppMethodBeat.o(225534);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjB;
        if (localObject1 == null) {
          break;
        }
        ((af)localObject1).tU(8);
        break;
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()) {
          break label1717;
        }
        a.hideLoadingLayer$default(this, false, 1, null);
        localObject1 = getLivePrepareUIC().zke;
        if (localObject1 != null) {
          ((al)localObject1).tU(8);
        }
        localObject1 = getLiveStartUIC();
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjc;
        if (localObject2 != null) {
          ((as)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjd;
        if (localObject2 != null) {
          ((cr)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zje;
        if (localObject2 != null) {
          ((at)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).ysG;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjf;
        if (localObject2 != null) {
          ((cd)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjj;
        if (localObject2 != null) {
          ((bi)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjk;
        if (localObject2 != null) {
          ((bt)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjo;
        if (localObject2 != null) {
          ((o)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjl;
        if (localObject2 != null) {
          ((cj)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjm;
        if (localObject2 != null) {
          ((cl)localObject2).tU(8);
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhe)
        {
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit = true");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhf;
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhg;
          if ((localObject2 != null) && (localObject3 != null))
          {
            localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
            if (localObject4 != null) {
              ((n)localObject4).tU(0);
            }
            localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
            if (localObject4 != null) {
              ((n)localObject4).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, (aze)localObject2, ((Integer)localObject3).intValue());
            }
          }
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zji;
          if (localObject2 != null) {
            ((by)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjs;
          if (localObject2 != null) {
            ((bb)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjt;
          if (localObject2 != null) {
            ((bd)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjn;
          if (localObject2 != null) {
            ((ct)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjp;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjq;
          if (localObject2 != null) {
            ((bk)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjr;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zju;
          if (localObject2 != null) {
            ((r)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjv;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.q)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjw;
          if (localObject2 != null) {
            ((bs)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjz;
          if (localObject2 != null) {
            ((br)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjC;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.u)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjD;
          if (localObject2 != null) {
            ((ad)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).ynx;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.t)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjE;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.w)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjF;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.x)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjG;
          if (localObject2 != null) {
            ((z)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjy;
          if (localObject2 != null) {
            ((bo)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjA;
          if (localObject2 != null) {
            ((co)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjB;
          if (localObject2 != null) {
            ((af)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjH;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tU(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjI;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tU(8);
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjJ;
          if (localObject1 != null) {
            ((cc)localObject1).tU(8);
          }
          localObject1 = getLiveEndUIC();
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhe) {
            break label1664;
          }
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1).TAG, "finish live by force quit, hide normal end page");
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1).ziW;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tU(8);
          break;
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit, but no cache errorPage");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
          if (localObject2 != null)
          {
            ((n)localObject2).tU(8);
            continue;
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
            if (localObject2 != null) {
              ((n)localObject2).tU(8);
            }
          }
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1).ziW;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).N((kotlin.g.a.a)new a.a((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1));
        }
        com.tencent.e.h.ZvG.bf((Runnable)new a.b((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject1));
      }
    } while (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted());
    int i;
    if (((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).lastLiveState != 3) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv == 3)) || ((com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfw, 32)) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 32))))
    {
      i = 1;
      label1807:
      if (i != 0) {
        a.hideLoadingLayer$default(this, false, 1, null);
      }
      localObject1 = getLivePrepareUIC().zke;
      if (localObject1 != null) {
        ((al)localObject1).tU(8);
      }
      localObject1 = getLiveStartUIC();
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjd;
      if (localObject2 != null) {
        cr.a((cr)localObject2, null, false, 3);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjb;
      if (localObject2 != null) {
        ((ab)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjc;
      if (localObject2 != null) {
        ((as)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjd;
      if (localObject2 != null) {
        ((cr)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zje;
      if (localObject2 != null) {
        ((at)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).ysG;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjk;
      if (localObject2 != null) {
        ((bt)localObject2).tU(0);
      }
      if (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 512)) {
        break label2758;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjo;
      if (localObject2 != null) {
        ((o)localObject2).tU(8);
      }
      label2015:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zju;
      if (localObject2 != null) {
        ((r)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjf;
      if (localObject2 != null) {
        ((cd)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjp;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zja;
      if (localObject2 != null) {
        ((n)localObject2).tU(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjj;
      if (localObject2 != null) {
        ((bi)localObject2).tU(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjg;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.l)localObject2).tU(0);
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB) {
        break label2779;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjl;
      if (localObject2 != null) {
        ((cj)localObject2).tU(0);
      }
      label2161:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zje;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.c.a)localObject2).kiF;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).post((Runnable)new c.l((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1));
        }
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhz == null) {
        break label2801;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjH;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tU(0);
      }
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).dAr();
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjE;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.w)localObject2).dAH();
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjF;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.x)localObject2).dAM();
      }
      if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 32))
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycU;
        if (localObject2 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
          localObject4 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycV.getResources().getString(b.j.finder_live_living_exception_tip_network);
          kotlin.g.b.p.j(localObject4, "context.resources.getStr…ng_exception_tip_network)");
          ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).showTipWithBlurBg((String)localObject3, (String)localObject4);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjF;
        if (localObject2 != null)
        {
          Log.i(((com.tencent.mm.plugin.finder.live.plugin.x)localObject2).TAG, "hide!");
          ((com.tencent.mm.plugin.finder.live.plugin.x)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjo;
        if (localObject2 != null) {
          ((o)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjm;
        if (localObject2 != null) {
          ((cl)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjl;
        if (localObject2 != null) {
          ((cj)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjj;
        if (localObject2 != null) {
          ((bi)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).ysG;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zji;
        if (localObject2 != null) {
          ((by)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjr;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zju;
        if (localObject2 != null) {
          ((r)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjI;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjH;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tU(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjJ;
        if (localObject2 != null) {
          ((cc)localObject2).tU(8);
        }
      }
      localObject2 = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLastRewardInfoStorage().aCI(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId));
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgH.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgH.addAll((Collection)localObject2);
      }
      localObject1 = getLiveEndUIC().ziW;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tU(8);
      break;
      i = 0;
      break label1807;
      label2758:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjo;
      if (localObject2 == null) {
        break label2015;
      }
      ((o)localObject2).tU(0);
      break label2015;
      label2779:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjl;
      if (localObject2 == null) {
        break label2161;
      }
      ((cj)localObject2).tU(8);
      break label2161;
      label2801:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjH;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tU(8);
      }
    }
  }
  
  public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean)
  {
    e.g localg = null;
    AppMethodBeat.i(225451);
    kotlin.g.b.p.k(paramf, "data");
    super.bindData(paramf, paramBoolean);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("bindData liveData.isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()).append(" liveMicSetting:");
    paramf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
    if (paramf != null) {}
    for (paramf = Long.valueOf(paramf.field_liveMicSetting);; paramf = null)
    {
      localStringBuilder = localStringBuilder.append(paramf).append(" liveMicSettingSwitch:");
      com.tencent.mm.plugin.finder.api.i locali = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
      paramf = localg;
      if (locali != null) {
        paramf = Long.valueOf(locali.field_liveMicSettingSwitch);
      }
      Log.i(str, paramf);
      paramf = com.tencent.mm.live.core.core.a.b.klq;
      setLiveCore(com.tencent.mm.live.core.core.a.b.b.aLh());
      paramf = getLiveCore();
      if (paramf != null)
      {
        localg = e.g.kkm;
        paramf.setScene(e.g.aKt());
      }
      getLivePrepareUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      getLiveStartUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      getLiveEndUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      AppMethodBeat.o(225451);
      return;
    }
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  public final int getRelativeLayoutId()
  {
    return b.g.finder_live_anchor_ui;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(225502);
    super.mount();
    Object localObject = com.tencent.mm.plugin.finder.utils.aq.AIJ;
    localObject = getLiveCore();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
      AppMethodBeat.o(225502);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.finder.utils.aq.f((com.tencent.mm.live.core.core.a.b)localObject);
    localObject = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.d(name(), this.liveMessageCallback);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3582, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3917, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3861, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3603, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(225502);
  }
  
  public final String name()
  {
    AppMethodBeat.i(225482);
    String str = b.class.getSimpleName();
    kotlin.g.b.p.j(str, "FinderLiveAnchorPluginLa…ut::class.java.simpleName");
    AppMethodBeat.o(225482);
    return str;
  }
  
  public final void notifyAudienceMicUserChange()
  {
    AppMethodBeat.i(225585);
    super.notifyAudienceMicUserChange();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(225585);
  }
  
  public final void notifyPKMicUserChange()
  {
    AppMethodBeat.i(225586);
    super.notifyPKMicUserChange();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(225586);
  }
  
  public final void onAcceptBattleTimeout() {}
  
  public final void onAcceptLiveMic(com.tencent.mm.live.b.a parama)
  {
    AppMethodBeat.i(225560);
    kotlin.g.b.p.k(parama, "info");
    Log.i(this.TAG, "onAcceptLiveMic info:".concat(String.valueOf(parama)));
    AppMethodBeat.o(225560);
  }
  
  public final void onAcceptMicPkTimeout()
  {
    AppMethodBeat.i(225569);
    Log.i(this.TAG, "accept pk mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + ", curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c localc = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn == 2)
    {
      r localr = localc.zju;
      if (localr != null) {
        localr.dAG();
      }
      com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.a(localc);
    }
    AppMethodBeat.o(225569);
  }
  
  public final void onAcceptMicTimeout(String paramString)
  {
    AppMethodBeat.i(225563);
    Log.i(this.TAG, "accept mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + " micId:" + paramString);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c localc = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).aCZ(paramString)) {
      com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.a(localc, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).aDa(paramString));
    }
    AppMethodBeat.o(225563);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(225587);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225587);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = k.yBj;
        localObject = k.dDm().yDw;
        if (paramIntent == null)
        {
          ((com.tencent.mm.plugin.finder.live.report.u)localObject).yNz += 1L;
          AppMethodBeat.o(225587);
          return;
        }
        paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        if ((paramIntent == null) || (paramIntent.isEmpty()))
        {
          ((com.tencent.mm.plugin.finder.live.report.u)localObject).yNz += 1L;
          AppMethodBeat.o(225587);
          return;
        }
        ((com.tencent.mm.plugin.finder.live.report.u)localObject).yNz += paramIntent.size();
        AppMethodBeat.o(225587);
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
  
  public final void onApplyBattleTimeout()
  {
    AppMethodBeat.i(225497);
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycU;
    if (localObject2 != null) {
      com.tencent.mm.live.c.b.b.a((com.tencent.mm.live.c.b)localObject2, com.tencent.mm.live.c.b.c.kBG);
    }
    localObject2 = k.yBj;
    localObject2 = s.c.yEH;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("type", Integer.valueOf(s.g.yFk.type));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhz;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yeu;; localObject1 = null)
    {
      localJSONObject.putOpt("result", localObject1);
      k.a((s.c)localObject2, localJSONObject.toString());
      AppMethodBeat.o(225497);
      return;
    }
  }
  
  public final void onApplyMicPkTimeout()
  {
    AppMethodBeat.i(225567);
    Log.i(this.TAG, "apply pk mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + ", curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c localc = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn == 2)
    {
      r localr = localc.zju;
      if (localr != null) {
        localr.dAG();
      }
      com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.a(localc);
    }
    AppMethodBeat.o(225567);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(225507);
    boolean bool = super.onBackPress();
    if (!bool)
    {
      k localk = k.yBj;
      k.t(s.a.yDV.jWO, "");
      localk = k.yBj;
      k.a(k.dDk());
    }
    AppMethodBeat.o(225507);
    return bool;
  }
  
  public final void onBattleApply()
  {
    AppMethodBeat.i(225494);
    com.tencent.mm.plugin.finder.live.view.router.a locala = getLiveStartUIC().ycU;
    if (locala != null)
    {
      com.tencent.mm.live.c.b.b.a(locala, com.tencent.mm.live.c.b.c.kBz);
      AppMethodBeat.o(225494);
      return;
    }
    AppMethodBeat.o(225494);
  }
  
  public final void onBattleClose()
  {
    AppMethodBeat.i(225495);
    com.tencent.mm.plugin.finder.live.view.router.a locala = getLiveStartUIC().ycU;
    if (locala != null)
    {
      com.tencent.mm.live.c.b.b.a(locala, com.tencent.mm.live.c.b.c.kBC);
      AppMethodBeat.o(225495);
      return;
    }
    AppMethodBeat.o(225495);
  }
  
  public final void onBattleDismiss()
  {
    AppMethodBeat.i(225492);
    com.tencent.mm.plugin.finder.live.plugin.ah localah = getLiveStartUIC().zjH;
    if (localah != null)
    {
      localah.dAV();
      AppMethodBeat.o(225492);
      return;
    }
    AppMethodBeat.o(225492);
  }
  
  public final void onBattleEnd()
  {
    AppMethodBeat.i(225491);
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycU;
    if (localObject2 != null) {
      com.tencent.mm.live.c.b.b.a((com.tencent.mm.live.c.b)localObject2, com.tencent.mm.live.c.b.c.kBB);
    }
    localObject2 = k.yBj;
    localObject2 = s.c.yEH;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("type", Integer.valueOf(s.g.yFl.type));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhz;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yeu;; localObject1 = null)
    {
      localJSONObject.putOpt("result", localObject1);
      k.a((s.c)localObject2, localJSONObject.toString());
      AppMethodBeat.o(225491);
      return;
    }
  }
  
  public final void onBattleStart()
  {
    AppMethodBeat.i(225485);
    Object localObject = getLiveStartUIC();
    com.tencent.mm.plugin.finder.live.model.mic.b localb = com.tencent.mm.plugin.finder.live.model.mic.b.ykC;
    com.tencent.mm.plugin.finder.live.model.mic.b.dAk();
    localObject = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).ycU;
    if (localObject != null)
    {
      com.tencent.mm.live.c.b.b.a((com.tencent.mm.live.c.b)localObject, com.tencent.mm.live.c.b.c.kBA);
      AppMethodBeat.o(225485);
      return;
    }
    AppMethodBeat.o(225485);
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(225479);
    kotlin.g.b.p.k(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = getLiveCore();
    if (paramString != null)
    {
      paramString = paramString.knA;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        Log.i((String)localObject, paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(225479);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(225479);
        return;
      } while ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()));
      paramString = getLiveCore();
      if (paramString != null)
      {
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getDrawable(b.e.mic_user_leave);
        kotlin.g.b.p.j(localObject, "MMApplicationContext.get….drawable.mic_user_leave)");
        paramString.y(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject));
      }
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm.isEmpty()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl != null))
      {
        paramString = getLiveCore();
        if (paramString != null) {
          paramString.muteLocalVideo(true);
        }
        paramString = getLiveCore();
        if (paramString != null) {
          paramString.muteLocalAudio(true);
        }
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa |= 0x2;
      paramString = getFinderLiveAssistant();
      if (paramString != null)
      {
        an.a.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, null, 24);
        AppMethodBeat.o(225479);
        return;
      }
      AppMethodBeat.o(225479);
      return;
    } while ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()));
    Log.i(this.TAG, "recoveryLocalVideo enableAudioMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGH() + " audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgo);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGH())
    {
      paramString = getLiveCore();
      if (paramString != null)
      {
        localObject = getContext();
        kotlin.g.b.p.j(localObject, "context");
        localObject = ((Context)localObject).getResources().getDrawable(b.e.live_audio_mode_frame);
        kotlin.g.b.p.j(localObject, "context.resources.getDra…le.live_audio_mode_frame)");
        paramString.y(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject));
      }
      paramString = getLiveCore();
      if (paramString != null) {
        paramString.muteLocalVideo(true);
      }
      paramString = getLiveCore();
      if (paramString != null) {
        paramString.muteLocalAudio(false);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa &= 0xFFFFFFFD;
      paramString = getFinderLiveAssistant();
      if (paramString == null) {
        break;
      }
      an.a.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, null, 24);
      AppMethodBeat.o(225479);
      return;
      paramString = getLiveCore();
      if (paramString != null) {
        paramString.muteLocalVideo(false);
      }
      paramString = getLiveCore();
      if (paramString != null) {
        paramString.muteLocalAudio(false);
      }
    }
  }
  
  public final void onCloseLiveMic(com.tencent.mm.live.b.f paramf)
  {
    AppMethodBeat.i(225557);
    kotlin.g.b.p.k(paramf, "info");
    Object localObject1 = getLiveStartUIC();
    kotlin.g.b.p.k(paramf, "info");
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
    if ((localObject2 != null) && (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).sessionId, paramf.ktE)))
    {
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).TAG, "close mic pk. curLinkUser:" + localObject2 + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn);
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).zeF)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl = null;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).dHf())
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zju;
          if (localObject2 != null) {
            ((r)localObject2).dAG();
          }
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).notifyPKMicUserChange();
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).dAu();
        }
        localObject1 = k.yBj;
        k.a(s.ae.yIi, "", -1, -1);
        localObject1 = k.yBj;
        localObject1 = s.c.yEH;
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).putOpt("type", Integer.valueOf(s.g.yFm.type));
        ((JSONObject)localObject2).putOpt("result", Integer.valueOf(0));
        k.a((s.c)localObject1, ((JSONObject)localObject2).toString());
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "onCloseLiveMic info:".concat(String.valueOf(paramf)));
      AppMethodBeat.o(225557);
      return;
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).TAG, "close mic. info:" + paramf + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm);
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
      kotlin.g.b.p.j(localObject2, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      com.tencent.mm.ae.d.a((List)localObject2, (kotlin.g.a.b)new c.j(paramf));
      localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).ycU;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).notifyAudienceMicUserChange();
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject1).zjx;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).dAu();
      }
    }
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle arg2)
  {
    AppMethodBeat.i(225577);
    Log.i(this.TAG, "sdk callback errorCode:".concat(String.valueOf(paramInt)));
    ??? = com.tencent.mm.plugin.finder.utils.aq.AIJ;
    ??? = getBuContext();
    Object localObject3 = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    kotlin.g.b.p.j(localObject3, "NetStatusUtil.getNetType…tionContext.getContext())");
    com.tencent.mm.plugin.finder.utils.aq.b((com.tencent.mm.plugin.finder.live.model.context.a)???, (String)localObject3);
    localObject3 = getLiveStartUIC();
    ??? = e.e.kjZ;
    Object localObject5;
    Object localObject6;
    label416:
    label422:
    label613:
    boolean bool;
    label775:
    label972:
    Object localObject2;
    label1187:
    int i;
    if (paramInt == e.e.aJO())
    {
      if (??? != null)
      {
        ??? = ???.getString("live_user_id");
        if (??? != null) {}
      }
      else
      {
        ??? = "";
        kotlin.g.b.p.j(???, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
        if ((??? != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).zeF == true))
        {
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
          if (??? == null) {
            break label416;
          }
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktR;
          if (Util.isEqual((String)???, ???))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn = 4;
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zju;
            if (??? != null)
            {
              ((r)???).dAG();
              ??? = kotlin.x.aazN;
            }
            ??? = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycU;
            if (??? != null)
            {
              ((com.tencent.mm.plugin.finder.live.view.router.a)???).notifyPKMicUserChange();
              ??? = kotlin.x.aazN;
            }
            ??? = com.tencent.mm.plugin.finder.live.model.mic.b.ykC;
            com.tencent.mm.plugin.finder.live.model.mic.b.dAj();
            ??? = k.yBj;
            ??? = s.ae.yIg;
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
            if (??? == null) {
              break label422;
            }
          }
        }
        for (??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).username;; ??? = null)
        {
          k.a((s.ae)???, (String)???, s.ao.yJv.type, s.aa.yHH.type);
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
          kotlin.g.b.p.j(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          synchronized ((Iterable)???)
          {
            ??? = ((Iterable)???).iterator();
            do
            {
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
              localObject6 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            } while ((!com.tencent.mm.plugin.finder.live.utils.a.d((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5)) || (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).ktR, ???)));
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).dGD();
            localObject6 = com.tencent.mm.plugin.finder.live.model.mic.b.ykC;
            com.tencent.mm.plugin.finder.live.model.mic.b.aCk(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).sessionId);
          }
          ??? = null;
          break;
        }
        ??? = kotlin.x.aazN;
        ??? = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycU;
        if (??? != null)
        {
          ((com.tencent.mm.plugin.finder.live.view.router.a)???).notifyAudienceMicUserChange();
          ??? = kotlin.x.aazN;
        }
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).TAG, "USER_VIDEO_AVAILABLE curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn + ", curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + ", userId:" + ??? + ", selfId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU() + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm);
        AppMethodBeat.o(225577);
      }
    }
    else
    {
      ??? = e.e.kjZ;
      if (paramInt == e.e.aJT())
      {
        if (??? != null)
        {
          ??? = ???.getString("live_user_id");
          if (??? != null) {}
        }
        else
        {
          ??? = "";
          kotlin.g.b.p.j(???, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).TAG, "USER_VIDEO_DISABLE curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn + ", curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + ", userId:" + ??? + ", selfId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU() + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm);
          AppMethodBeat.o(225577);
        }
      }
      else
      {
        ??? = e.e.kjZ;
        if (paramInt == e.e.aJP())
        {
          if (??? != null)
          {
            ??? = ???.getString("live_user_id");
            if (??? != null) {}
          }
          else
          {
            ??? = "";
            kotlin.g.b.p.j(???, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
            if ((??? != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).zeF == true))
            {
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
              if (??? == null) {
                break label972;
              }
            }
            for (??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktR;; ??? = null)
            {
              if (Util.isEqual((String)???, ???))
              {
                ??? = com.tencent.mm.plugin.finder.live.model.mic.b.ykC;
                com.tencent.mm.plugin.finder.live.model.mic.b.dAi();
                ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).L(null);
              }
              ??? = new ArrayList();
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
              kotlin.g.b.p.j(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
              synchronized ((Iterable)???)
              {
                localObject5 = ((Iterable)???).iterator();
                do
                {
                  if (!((Iterator)localObject5).hasNext()) {
                    break;
                  }
                  localObject6 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject5).next();
                } while (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).ktR, ???));
                ((ArrayList)???).add(localObject6);
              }
            }
            localObject5 = kotlin.x.aazN;
            if (!((Collection)???).isEmpty()) {}
            for (paramInt = 1; paramInt != 0; paramInt = 0)
            {
              ??? = ((Iterable)???).iterator();
              while (((Iterator)???).hasNext()) {
                ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).a((com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next(), null);
              }
            }
            Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).TAG, "EVENT_ROOM_USER_EXIT userId:" + ??? + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm);
            AppMethodBeat.o(225577);
          }
        }
        else
        {
          ??? = e.e.kjZ;
          if (paramInt == e.e.aJQ())
          {
            if (??? != null)
            {
              ??? = ???.getString("live_user_id");
              if (??? != null) {}
            }
            else
            {
              ??? = "";
              kotlin.g.b.p.j(???, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
              if (??? != null) {
                bool = ???.getBoolean("live_media_enable");
              }
              while (bool)
              {
                ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
                kotlin.g.b.p.j(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
                synchronized ((Iterable)???)
                {
                  ??? = ???.iterator();
                  do
                  {
                    if (!((Iterator)???).hasNext()) {
                      break;
                    }
                    localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
                    localObject6 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
                  } while ((!com.tencent.mm.plugin.finder.live.utils.a.e((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5)) || (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).ktR, (String)???)));
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).dGD();
                  localObject6 = com.tencent.mm.plugin.finder.live.model.mic.b.ykC;
                  com.tencent.mm.plugin.finder.live.model.mic.b.aCk(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).sessionId);
                  localObject5 = ao.AGX;
                  ao.eeQ();
                }
                bool = false;
                continue;
                ??? = kotlin.x.aazN;
                ??? = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycU;
                if (??? != null)
                {
                  ???.notifyAudienceMicUserChange();
                  ??? = kotlin.x.aazN;
                }
              }
              Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).TAG, "EVENT_ROOM_USER_AUDIO_STATE linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm + " userId:" + str + " enable:" + bool);
              AppMethodBeat.o(225577);
            }
          }
          else
          {
            localObject2 = e.e.kjZ;
            if (paramInt == e.e.aJU())
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).dHl();
              AppMethodBeat.o(225577);
              return;
            }
            localObject2 = e.e.kjZ;
            if (paramInt == e.e.aJR())
            {
              ??? = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycU;
              if (??? != null)
              {
                i = ???.getCurNetworkQuality();
                localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).kDk;
                if (localObject2 != null)
                {
                  localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knA;
                  if (localObject2 != null)
                  {
                    paramInt = ((com.tencent.mm.live.core.core.model.h)localObject2).kmJ;
                    ???.setCurNetworkQuality(paramInt);
                    localObject2 = e.m.kkI;
                    if (i == e.m.aKJ()) {
                      break label1720;
                    }
                    paramInt = ???.getCurNetworkQuality();
                    localObject2 = e.m.kkI;
                    if (paramInt != e.m.aKJ()) {
                      break label1720;
                    }
                    com.tencent.mm.live.c.b.b.a(???, com.tencent.mm.live.c.b.c.kzJ);
                    label1606:
                    i = ???.getCurNetworkType();
                    localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).kDk;
                    if (localObject2 == null) {
                      break label1759;
                    }
                    localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knA;
                    if (localObject2 == null) {
                      break label1759;
                    }
                  }
                }
                label1720:
                label1759:
                for (paramInt = ((com.tencent.mm.live.core.core.model.h)localObject2).networkType;; paramInt = -1)
                {
                  ???.setCurNetworkType(paramInt);
                  if ((i == 0) && (???.getCurNetworkType() != 0) && (???.getCurNetworkType() != -1)) {
                    com.tencent.mm.ui.base.w.makeText((Context)((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycV, (CharSequence)((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycV.getResources().getString(b.j.finder_live_living_with_cellular), 0).show();
                  }
                  ??? = kotlin.x.aazN;
                  AppMethodBeat.o(225577);
                  return;
                  localObject2 = e.m.kkI;
                  paramInt = e.m.aKH();
                  break;
                  localObject2 = e.m.kkI;
                  if (i != e.m.aKJ()) {
                    break label1606;
                  }
                  paramInt = ???.getCurNetworkQuality();
                  localObject2 = e.m.kkI;
                  if (paramInt == e.m.aKJ()) {
                    break label1606;
                  }
                  com.tencent.mm.live.c.b.b.a(???, com.tencent.mm.live.c.b.c.kzK);
                  break label1606;
                }
              }
              AppMethodBeat.o(225577);
              return;
            }
            localObject2 = e.e.kjZ;
            if (paramInt == e.e.aJZ())
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).ycU;
              if (localObject2 != null)
              {
                ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).statusChange(com.tencent.mm.live.c.b.c.kAG, ???);
                ??? = kotlin.x.aazN;
                AppMethodBeat.o(225577);
                return;
              }
              AppMethodBeat.o(225577);
              return;
            }
            localObject2 = e.e.kjZ;
            if (paramInt == e.e.aKg()) {
              if (??? != null)
              {
                ??? = ???.getParcelableArrayList("live_user_volume_info");
                label1846:
                localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
                if (localObject2 == null) {
                  break label2084;
                }
                synchronized ((Iterable)localObject2)
                {
                  localObject5 = ((Iterable)???).iterator();
                  label1886:
                  if (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject5).next();
                    if (??? == null) {
                      break label2477;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ???.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          bool = Util.isEqual(((UserVolumeInfo)localObject2).userId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).ktR);
          if (!bool) {
            continue;
          }
          localObject2 = (UserVolumeInfo)localObject2;
          if (localObject2 == null) {
            break label2477;
          }
          paramInt = ((UserVolumeInfo)localObject2).volume;
          localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject3).kDk;
          if (localObject2 == null) {
            break label2482;
          }
          localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knK;
          if (localObject2 == null) {
            break label2482;
          }
          i = ((com.tencent.mm.live.core.core.model.b)localObject2).klD;
          break label2466;
          label2026:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).zeI = bool;
          break label1886;
          ??? = finally;
          AppMethodBeat.o(225577);
          throw ???;
          ??? = null;
          break label1846;
        }
        localObject2 = null;
      }
      localObject2 = kotlin.x.aazN;
      localObject2 = kotlin.x.aazN;
      label2084:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zjz;
      if (localObject2 != null) {
        ((br)localObject2).dCc();
      }
      if (??? != null) {}
      for (??? = (List)???;; ??? = (List)new ArrayList())
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).ex(???);
        AppMethodBeat.o(225577);
        return;
      }
      localObject2 = e.e.kjZ;
      if (paramInt == e.e.aKh()) {
        if (??? != null)
        {
          ??? = ???.getString("live_cdn_sei_msg");
          if (??? == null) {
            break label2444;
          }
          localObject2 = new com.tencent.mm.ad.i(???);
          ??? = e.p.kkW;
          ??? = ((com.tencent.mm.ad.i)localObject2).optString(e.p.getUserId());
          if (??? != null) {
            break label2451;
          }
          ??? = "";
        }
      }
      label2432:
      label2444:
      label2451:
      for (;;)
      {
        ??? = e.p.kkW;
        i = ((com.tencent.mm.ad.i)localObject2).optInt(e.p.aKM());
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
        if (localObject2 != null)
        {
          if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).ktR, ???))
          {
            ??? = e.a.kjw;
            bool = com.tencent.mm.ae.d.dr(i, e.a.aJH());
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).xzt != bool)
            {
              ??? = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).zeJ;
              if ((??? != null) && (((CharSequence)???).length() != 0)) {
                break label2432;
              }
            }
          }
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0)
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).xzt = bool;
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zjw;
              if (??? != null)
              {
                ((bs)???).aCt(???);
                ??? = kotlin.x.aazN;
              }
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zje;
              if (??? != null)
              {
                ???.dBq();
                ??? = kotlin.x.aazN;
              }
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zjH;
              if (??? != null)
              {
                ???.yof.zmN = bool;
                ??? = kotlin.x.aazN;
              }
            }
            ??? = e.a.kjw;
            bool = com.tencent.mm.ae.d.dr(i, e.a.aJG());
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).zeI != bool)
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).zeI = bool;
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject3).zje;
              if (??? != null)
              {
                ???.dBr();
                ??? = kotlin.x.aazN;
              }
            }
            ??? = kotlin.x.aazN;
            AppMethodBeat.o(225577);
            return;
            ??? = null;
            break;
          }
        }
        AppMethodBeat.o(225577);
        return;
        AppMethodBeat.o(225577);
        return;
      }
      break label1187;
      break label775;
      break label613;
      break;
      for (;;)
      {
        label2466:
        if (paramInt > i) {
          break label2487;
        }
        bool = true;
        break label2026;
        label2477:
        paramInt = 0;
        break;
        label2482:
        i = 0;
      }
      label2487:
      bool = false;
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(225570);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    AppMethodBeat.o(225570);
  }
  
  public final void release()
  {
    AppMethodBeat.i(225582);
    Log.i(this.TAG, "release");
    Object localObject = getLiveStartUIC();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).checkMiniWindow();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).kKL.stopTimer();
    localObject = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.aNy();
    localObject = com.tencent.mm.plugin.finder.live.model.aj.yif;
    com.tencent.mm.plugin.finder.live.model.aj.dzR();
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3582, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3917, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3861, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3603, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgB == true)) {}
    }
    else
    {
      localObject = com.tencent.mm.plugin.finder.live.model.ah.yhC;
      com.tencent.mm.plugin.finder.live.model.ah.a(false, getMiniWinPermission(), null, 5);
      localObject = getLiveCore();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
        if (localObject != null)
        {
          if ((((com.tencent.mm.live.core.core.model.h)localObject).isFloatMode()) || (getMiniWinPermission())) {
            break label282;
          }
          localObject = com.tencent.mm.live.b.p.kvF;
          com.tencent.mm.live.b.p.release();
          localObject = getLiveCore();
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.b)localObject).aJB();
          }
          getLiveEndUIC().aRk();
          getBuContext().clear();
          AppMethodBeat.o(225582);
          return;
        }
      }
      AppMethodBeat.o(225582);
      return;
    }
    localObject = com.tencent.mm.live.core.core.a.b.klq;
    com.tencent.mm.live.core.core.a.b.b.eV(true);
    label282:
    AppMethodBeat.o(225582);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(225447);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(225447);
  }
  
  public final void start()
  {
    AppMethodBeat.i(225500);
    super.start();
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c localc = getLiveStartUIC();
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.b(localc);
    localc.startTimer();
    AppMethodBeat.o(225500);
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(225549);
    kotlin.g.b.p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    Object localObject = getLivePrepareUIC();
    kotlin.g.b.p.k(paramc, "status");
    switch (com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      getLiveStartUIC().a(paramc, paramBundle);
      localObject = getLiveEndUIC();
      kotlin.g.b.p.k(paramc, "status");
      switch (com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(225549);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).zke;
      if (localObject == null) {
        break;
      }
      ((al)localObject).tU(8);
      break;
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).TAG, "start live failed");
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()) {
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).zke;
      if (localObject == null) {
        break;
      }
      ((al)localObject).tU(8);
      break;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).zke;
      if (localObject == null) {
        break;
      }
      ((al)localObject).tU(8);
      break;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e)localObject).zke;
      if (localObject == null) {
        break;
      }
      ((al)localObject).tU(8);
      break;
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).ziW;
      if (paramc != null) {
        paramc.dAp();
      }
      if (paramBundle != null) {}
      for (boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL");; bool = false)
      {
        paramc = com.tencent.mm.plugin.finder.live.model.ah.yhC;
        paramc = com.tencent.mm.plugin.finder.live.model.ah.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.a(bool, (kotlin.g.a.s)new a.c((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject));
        }
        if (bool)
        {
          paramc = k.yBj;
          paramc = s.c.yEH;
          paramBundle = new JSONObject();
          paramBundle.putOpt("type", Integer.valueOf(s.g.yFn.type));
          paramBundle.putOpt("result", Integer.valueOf(1));
          k.a(paramc, paramBundle.toString());
        }
        paramc = com.tencent.mm.plugin.finder.live.model.ah.yhC;
        paramc = com.tencent.mm.plugin.finder.live.model.ah.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.dxV();
        }
        paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.aal().putInt("live_status_flag", 0);
        paramc = com.tencent.mm.plugin.finder.live.model.ah.yhC;
        com.tencent.mm.plugin.finder.live.model.ah.aPh();
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).aRk();
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).TAG, "finish live is manual finish:".concat(String.valueOf(bool)));
        AppMethodBeat.o(225549);
        return;
      }
      if (paramBundle != null) {}
      for (bool = paramBundle.getBoolean("PARAM_LIVE_MINI_WINDOW_AUTO"); bool; bool = false)
      {
        paramc = com.tencent.mm.plugin.finder.live.model.ah.yhC;
        com.tencent.mm.plugin.finder.live.model.ah.a(false, false, null, 7);
        paramc = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).kDk;
        if (paramc != null) {
          paramc.aJB();
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).aRk();
        ((com.tencent.mm.plugin.finder.live.component.statecomponent.d)localObject).buContext.clear();
        AppMethodBeat.o(225549);
        return;
      }
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).ziW;
      if (paramc != null) {
        paramc.tU(8);
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).aRk();
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(225498);
    super.stop();
    getLiveStartUIC().checkMiniWindow();
    AppMethodBeat.o(225498);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.b
 * JD-Core Version:    0.7.0.1
 */