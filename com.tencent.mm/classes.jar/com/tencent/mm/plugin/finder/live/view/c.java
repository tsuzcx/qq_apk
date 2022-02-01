package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.al;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ar;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ak;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.av;
import com.tencent.mm.plugin.finder.live.plugin.aw;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bg;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.ca;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cf;
import com.tencent.mm.plugin.finder.live.plugin.g;
import com.tencent.mm.plugin.finder.live.plugin.l;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.z;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.util.m;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.b;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.d;
import com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "liveMessageCallback", "Lkotlin/Function0;", "", "getLiveMessageCallback", "()Lkotlin/jvm/functions/Function0;", "setLiveMessageCallback", "(Lkotlin/jvm/functions/Function0;)V", "liveSlowMessageCallback", "getLiveSlowMessageCallback", "setLiveSlowMessageCallback", "activate", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "", "restart", "applyState", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "getLiveRole", "getRelativeLayoutId", "mount", "name", "needHideBgLayer", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPress", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEventCallback", "errorCode", "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "release", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.view.router.b
  implements com.tencent.mm.am.h
{
  private String TAG;
  private kotlin.g.a.a<kotlin.ah> liveMessageCallback;
  private kotlin.g.a.a<kotlin.ah> liveSlowMessageCallback;
  
  public c(MMActivity paramMMActivity, Fragment paramFragment)
  {
    super((Context)paramMMActivity, paramFragment);
    AppMethodBeat.i(357829);
    this.TAG = "FinderLiveAnchorSecondaryPluginLayout";
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this));
    this.liveSlowMessageCallback = ((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(357829);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(357903);
    kotlin.g.b.s.u(paramf, "data");
    super.activate(paramf, paramBoolean1, paramBoolean2);
    Log.i(this.TAG, "liveFinish:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcD + ",isFromFloat:" + paramBoolean1 + ", restart:" + paramBoolean2 + ",liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ",objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + ",nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId + ",username:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
    paramf = getLivePrepareUIC();
    if (paramBoolean1)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcD)
      {
        paramf = paramf.CCe;
        if (paramf != null) {
          b.b.a((com.tencent.mm.live.b.b)paramf, b.c.ncD);
        }
      }
      for (;;)
      {
        paramf = al.CHU;
        al.q(name(), (kotlin.g.a.a)new a(this));
        AppMethodBeat.o(357903);
        return;
        paramf = paramf.CCe;
        if (paramf != null) {
          paramf.prepareToStart(true);
        }
      }
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco != null)
    {
      FinderObject localFinderObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if ((localFinderObject == null) || (localFinderObject.id != 0L)) {
        break label365;
      }
    }
    label365:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).l(((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).jn(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN).getFinderObject());
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).EhX = true;
      paramf = paramf.CCe;
      if (paramf == null) {
        break;
      }
      paramf.prepareToStart(false);
      break;
    }
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(358038);
    Object localObject1;
    Object localObject2;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA())
    {
      a.hideLoadingLayer$default((a)this, false, 1, null);
      getLivePrepareUIC();
      localObject1 = getLiveStartUIC();
      localObject2 = m.DJb;
      m.l(((com.tencent.mm.plugin.finder.live.component.statecomponent.e)localObject1).buContext);
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiP;
      if (localObject2 != null) {
        ((y)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiQ;
      if (localObject2 != null) {
        ((cd)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiR;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiY;
      if (localObject2 != null) {
        ((bq)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).DcS;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiS;
      if (localObject2 != null) {
        ((bt)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiW;
      if (localObject2 != null) {
        ((az)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiX;
      if (localObject2 != null) {
        ((bg)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejc;
      if (localObject2 != null) {
        ((o)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiZ;
      if (localObject2 != null) {
        ((br)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Eja;
      if (localObject2 != null) {
        ((bz)localObject2).tO(8);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efn)
      {
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit = true");
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efo;
        Integer localInteger = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efp;
        if ((localObject2 != null) && (localInteger != null))
        {
          l locall = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiN;
          if (locall != null) {
            locall.tO(0);
          }
          locall = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiN;
          if (locall != null) {
            locall.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, (bgq)localObject2, localInteger.intValue());
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiV;
          if (localObject2 != null) {
            ((bk)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejb;
          if (localObject2 != null) {
            ((cf)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejf;
          if (localObject2 != null) {
            ((ba)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejg;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.r)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejh;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.d)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Eji;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjY;
          if (localObject2 != null) {
            ((at)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejj;
          if (localObject2 != null) {
            ((av)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejk;
          if (localObject2 != null) {
            ((aw)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejp;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejt;
          if (localObject2 != null) {
            ((ab)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjW;
          if (localObject2 != null) {
            ((ca)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjB;
          if (localObject2 != null) {
            ((bp)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjE;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejv;
          if (localObject2 != null) {
            ((z)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejq;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.bc)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjC;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.k)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjD;
          if (localObject2 != null) {
            ((n)localObject2).tO(8);
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjG;
          if (localObject1 != null) {
            ((ak)localObject1).tO(8);
          }
          localObject1 = getLiveEndUIC();
          if ((paramBundle == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE")))
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1).EiK;
            if (localObject2 != null) {
              ((g)localObject2).bh((kotlin.g.a.a)new a.b((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a)localObject1));
            }
          }
        }
      }
    }
    for (;;)
    {
      super.applyState(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(358038);
      return;
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit, but no cache errorPage");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiN;
      if (localObject2 == null) {
        break;
      }
      ((l)localObject2).tO(8);
      break;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiN;
      if (localObject2 == null) {
        break;
      }
      ((l)localObject2).tO(8);
      break;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted())
      {
        if (((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).lastLiveState != 2) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT == 2)) || ((com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcU, 32)) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32)))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            a.hideLoadingLayer$default((a)this, false, 1, null);
          }
          getLivePrepareUIC();
          getLiveStartUIC().ezx();
          localObject1 = getLiveEndUIC().EiK;
          if (localObject1 == null) {
            break;
          }
          ((g)localObject1).tO(8);
          break;
        }
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyz())
      {
        a.hideLoadingLayer$default((a)this, false, 1, null);
        getLivePrepareUIC();
        localObject1 = getLiveStartUIC();
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiP;
        if (localObject2 != null) {
          ((y)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiQ;
        if (localObject2 != null) {
          ((cd)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiR;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiY;
        if (localObject2 != null) {
          ((bq)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).DcS;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiT;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiS;
        if (localObject2 != null) {
          ((bt)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiU;
        if (localObject2 != null) {
          ((bd)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiV;
        if (localObject2 != null) {
          ((bk)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiZ;
        if (localObject2 != null) {
          ((br)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Eja;
        if (localObject2 != null) {
          ((bz)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiN;
        if (localObject2 != null) {
          ((l)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiW;
        if (localObject2 != null) {
          ((az)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EiX;
        if (localObject2 != null) {
          ((bg)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejc;
        if (localObject2 != null) {
          ((o)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejb;
        if (localObject2 != null) {
          ((cf)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejf;
        if (localObject2 != null) {
          ((ba)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejg;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.r)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejh;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.d)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Eji;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjY;
        if (localObject2 != null) {
          ((at)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejj;
        if (localObject2 != null) {
          ((av)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejk;
        if (localObject2 != null) {
          ((aw)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejt;
        if (localObject2 != null) {
          ((ab)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjW;
        if (localObject2 != null) {
          ((ca)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjB;
        if (localObject2 != null) {
          ((bp)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjE;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejv;
        if (localObject2 != null) {
          ((z)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).Ejq;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.bc)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjC;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.k)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjD;
        if (localObject2 != null) {
          ((n)localObject2).tO(8);
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjG;
        if (localObject1 != null) {
          ((ak)localObject1).tO(8);
        }
        localObject1 = getLiveEndUIC().EiK;
        if (localObject1 != null) {
          ((g)localObject1).tO(8);
        }
      }
    }
  }
  
  public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    AppMethodBeat.i(357888);
    kotlin.g.b.s.u(paramf, "data");
    super.bindData(paramf);
    paramf = com.tencent.mm.live.core.core.e.a.mRf;
    setLiveCore((com.tencent.mm.live.core.core.trtc.a)a.a.beN());
    paramf = getLiveCore();
    if (paramf != null)
    {
      e.h localh = e.h.mKY;
      paramf.setScene(e.h.bdj());
    }
    getLivePrepareUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    getLiveStartUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    getLiveEndUIC().a((com.tencent.mm.plugin.finder.live.view.router.b)this);
    AppMethodBeat.o(357888);
  }
  
  protected final kotlin.g.a.a<kotlin.ah> getLiveMessageCallback()
  {
    return this.liveMessageCallback;
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  protected final kotlin.g.a.a<kotlin.ah> getLiveSlowMessageCallback()
  {
    return this.liveSlowMessageCallback;
  }
  
  public final int getRelativeLayoutId()
  {
    return p.f.CcZ;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(357998);
    super.mount();
    com.tencent.mm.live.model.j localj = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.g(name(), this.liveMessageCallback);
    localj = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.h(name(), this.liveSlowMessageCallback);
    com.tencent.mm.kernel.h.baD().mCm.a(3861, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3603, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).init();
    AppMethodBeat.o(357998);
  }
  
  public final String name()
  {
    AppMethodBeat.i(357924);
    String str = c.class.getSimpleName();
    kotlin.g.b.s.s(str, "FinderLiveAnchorSecondar…ut::class.java.simpleName");
    AppMethodBeat.o(357924);
    return str;
  }
  
  public final void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(357961);
    kotlin.g.b.s.u(parama, "info");
    Log.i(this.TAG, kotlin.g.b.s.X("onAcceptLiveMic acceptInfo:", parama));
    getLiveStartUIC().ezC();
    AppMethodBeat.o(357961);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(358152);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(358152);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramIntent = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
        paramIntent.DGa += 1L;
        AppMethodBeat.o(358152);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramIntent = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
          paramIntent.DFZ += 1L;
        }
      }
    }
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(358009);
    boolean bool = super.onBackPress();
    if (!bool)
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqP.mwI, "");
      com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.etj());
    }
    AppMethodBeat.o(358009);
    return bool;
  }
  
  public final void onBattleApply() {}
  
  public final void onBattleClose() {}
  
  public final void onBattleDismiss() {}
  
  public final void onBattleEnd() {}
  
  public final void onBattleStart() {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(357913);
    kotlin.g.b.s.u(paramString, "incomingNumber");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = getLiveCore();
    if (paramString == null)
    {
      paramString = localObject;
      Log.i(str, paramString);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(357913);
      return;
      com.tencent.mm.live.core.core.model.i locali = paramString.mRB;
      paramString = localObject;
      if (locali == null) {
        break;
      }
      paramString = Boolean.valueOf(locali.isFloatMode());
      break;
      AppMethodBeat.o(357913);
      return;
      setManualClosed(true);
      b.b.a((com.tencent.mm.live.b.b)this, b.c.nck);
    }
  }
  
  public final void onCloseLiveMic(com.tencent.mm.live.model.f paramf)
  {
    AppMethodBeat.i(357965);
    kotlin.g.b.s.u(paramf, "info");
    Log.i(this.TAG, "onCloseLiveMic closeInfo:" + paramf + " curLinkMicUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
    AppMethodBeat.o(357965);
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(358128);
    Log.i(this.TAG, kotlin.g.b.s.X("sdk callback errorCode:", Integer.valueOf(paramInt)));
    Object localObject1 = com.tencent.mm.plugin.finder.utils.bc.GkH;
    localObject1 = getBuContext();
    ??? = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    kotlin.g.b.s.s(???, "getNetTypeString(MMAppli…tionContext.getContext())");
    com.tencent.mm.plugin.finder.utils.bc.c((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (String)???);
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b localb = getLiveStartUIC();
    localObject1 = e.g.mKv;
    if (paramInt == e.g.bcN())
    {
      localb.ezs();
      AppMethodBeat.o(358128);
      return;
    }
    localObject1 = e.g.mKv;
    label136:
    label148:
    label167:
    label223:
    label235:
    Object localObject3;
    label290:
    label315:
    label323:
    label332:
    label460:
    Object localObject4;
    label413:
    label421:
    label423:
    label434:
    boolean bool;
    label558:
    int i;
    label654:
    label939:
    int j;
    label1156:
    label1427:
    label1582:
    label1737:
    label1761:
    label1790:
    label2943:
    int k;
    if (paramInt == e.g.bcK())
    {
      paramBundle = localb.CCe;
      if (paramBundle == null)
      {
        localObject1 = null;
        ??? = localb.CCe;
        if (??? != null)
        {
          paramBundle = localb.nkg;
          if (paramBundle != null) {
            break label290;
          }
          paramBundle = null;
          if (paramBundle != null) {
            break label315;
          }
          paramBundle = e.o.mLz;
          paramInt = e.o.bdD();
          ((com.tencent.mm.plugin.finder.live.view.router.b)???).setCurNetworkQuality(paramInt);
        }
        paramBundle = e.o.mLz;
        paramInt = e.o.bdF();
        if (localObject1 != null) {
          break label323;
        }
        paramBundle = localb.CCe;
        if (paramBundle == null) {
          break label413;
        }
        paramInt = paramBundle.getCurNetworkQuality();
        paramBundle = e.o.mLz;
        if (paramInt != e.o.bdF()) {
          break label413;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label332;
        }
        paramBundle = localb.CCe;
        if (paramBundle != null)
        {
          b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.ncZ);
          paramBundle = kotlin.ah.aiuX;
        }
        paramBundle = localb.CCe;
        if (paramBundle != null) {
          break label423;
        }
        paramBundle = null;
        localObject1 = localb.CCe;
        if (localObject1 != null)
        {
          ??? = localb.nkg;
          if (??? != null) {
            break label434;
          }
          paramInt = -1;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).setCurNetworkType(paramInt);
        if (paramBundle != null) {
          break label460;
        }
        AppMethodBeat.o(358128);
        return;
        localObject1 = Integer.valueOf(paramBundle.getCurNetworkQuality());
        break;
        paramBundle = paramBundle.mRB;
        if (paramBundle == null)
        {
          paramBundle = null;
          break label136;
        }
        paramBundle = Integer.valueOf(paramBundle.mNT);
        break label136;
        paramInt = paramBundle.intValue();
        break label148;
        if (((Integer)localObject1).intValue() != paramInt) {
          break label167;
        }
        paramBundle = e.o.mLz;
        paramInt = e.o.bdF();
        if ((localObject1 == null) || (((Integer)localObject1).intValue() != paramInt)) {
          break label223;
        }
        paramBundle = localb.CCe;
        if (paramBundle != null)
        {
          paramInt = paramBundle.getCurNetworkQuality();
          paramBundle = e.o.mLz;
          if (paramInt != e.o.bdF()) {}
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label421;
          }
          paramBundle = localb.CCe;
          if (paramBundle == null) {
            break label223;
          }
          b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.nda);
          paramBundle = kotlin.ah.aiuX;
          break label223;
          paramInt = 0;
          break;
        }
        break label223;
        paramBundle = Integer.valueOf(paramBundle.getCurNetworkType());
        break label235;
        ??? = ((com.tencent.mm.live.core.core.trtc.a)???).mRB;
        if (??? == null) {
          paramInt = -1;
        } else {
          paramInt = ((com.tencent.mm.live.core.core.model.i)???).networkType;
        }
      }
      if (paramBundle.intValue() == 0)
      {
        paramBundle = localb.CCe;
        if ((paramBundle != null) && (paramBundle.getCurNetworkType() == 0))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label3779;
          }
          paramBundle = localb.CCe;
          if ((paramBundle == null) || (paramBundle.getCurNetworkType() != -1)) {
            break label558;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label3779;
          }
          aa.makeText((Context)localb.CCa, (CharSequence)localb.CCa.getResources().getString(p.h.Cmb), 0).show();
          AppMethodBeat.o(358128);
          return;
          paramInt = 0;
          break;
        }
      }
    }
    else
    {
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bcW())
      {
        localObject1 = localb.CCe;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).statusChange(b.c.ndo, paramBundle);
          paramBundle = kotlin.ah.aiuX;
        }
        AppMethodBeat.o(358128);
        return;
      }
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bdb())
      {
        localObject1 = localb.EjW;
        if (localObject1 != null) {
          if (paramBundle != null) {
            break label654;
          }
        }
        for (paramBundle = null;; paramBundle = paramBundle.getString("live_cdn_sei_msg"))
        {
          ((ca)localObject1).axm(paramBundle);
          paramBundle = kotlin.ah.aiuX;
          AppMethodBeat.o(358128);
          return;
        }
      }
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bcY())
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
        {
          Log.i(localb.TAG, "EVENT_CDN_SEI_MESSAGE_LINK_MIC: roomPk = true, skip");
          AppMethodBeat.o(358128);
          return;
        }
        if (paramBundle == null) {
          paramBundle = null;
        }
        while (paramBundle != null)
        {
          localObject1 = new dlg();
          ??? = (com.tencent.mm.bx.a)localObject1;
          localObject3 = kotlin.n.d.UTF_8;
          if (paramBundle == null)
          {
            paramBundle = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(358128);
            throw paramBundle;
            paramBundle = paramBundle.getString("live_cdn_sei_msg");
          }
          else
          {
            paramBundle = paramBundle.getBytes((Charset)localObject3);
            kotlin.g.b.s.s(paramBundle, "(this as java.lang.String).getBytes(charset)");
            try
            {
              ((com.tencent.mm.bx.a)???).parseFrom(paramBundle);
              paramBundle = kotlin.ah.aiuX;
              Log.i(localb.TAG, "EVENT_CDN_SEI_MESSAGE_LINK_MIC micSEIMsg.infos:" + ((dlg)localObject1).ToF + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
              paramBundle = (Collection)((dlg)localObject1).ToF;
              if ((paramBundle == null) || (paramBundle.isEmpty()))
              {
                paramInt = 1;
                if (paramInt == 0) {
                  break label939;
                }
                paramBundle = localb.CCe;
                if (paramBundle == null) {
                  break;
                }
                b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.neD);
                paramBundle = kotlin.ah.aiuX;
                AppMethodBeat.o(358128);
              }
            }
            catch (Exception paramBundle)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
                continue;
                paramInt = 0;
              }
              paramBundle = localb.CCe;
              if (paramBundle != null)
              {
                b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.neC);
                paramBundle = kotlin.ah.aiuX;
              }
              localb.ehm();
              ??? = new ah.a();
              ((ah.a)???).aiwY = true;
              localObject3 = new LinkedList();
              paramBundle = ((dlg)localObject1).ToF;
              kotlin.g.b.s.s(paramBundle, "micSEIMsg.infos");
              localObject4 = ((Iterable)paramBundle).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                ??? = (dlh)((Iterator)localObject4).next();
                paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
                kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
                synchronized ((Iterable)paramBundle)
                {
                  ??? = ((Iterable)???).iterator();
                  for (;;)
                  {
                    if (((Iterator)???).hasNext())
                    {
                      paramBundle = ((Iterator)???).next();
                      bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle).mXL, ((dlh)???).YRR);
                      if (bool)
                      {
                        paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle;
                        if (paramBundle != null) {
                          break label1156;
                        }
                        ((ah.a)???).aiwY = false;
                        break;
                      }
                    }
                  }
                  paramBundle = null;
                }
                paramInt = ((dlh)???).aaRl;
                ??? = e.m.mLr;
                paramBundle.EbG = com.tencent.mm.ae.d.ee(paramInt, e.m.bdw());
                ((LinkedList)localObject3).add(paramBundle);
              }
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.j((ah.a)???, (dlg)localObject1, localb, (LinkedList)localObject3));
              paramBundle = kotlin.ah.aiuX;
            }
          }
        }
        AppMethodBeat.o(358128);
        return;
      }
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bda())
      {
        if (paramBundle == null)
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject1 = new com.tencent.mm.ad.i((String)localObject1);
            ??? = e.r.mLO;
            ??? = ((com.tencent.mm.ad.i)localObject1).optString(e.r.getUserId());
            if (??? != null) {
              break label2530;
            }
            ??? = "";
            label1280:
            localObject3 = e.r.mLO;
            i = ((com.tencent.mm.ad.i)localObject1).optInt(e.r.bdI());
            localObject3 = e.r.mLO;
            paramInt = ((com.tencent.mm.ad.i)localObject1).optInt(e.r.bdJ());
            localObject3 = e.r.mLO;
            j = ((com.tencent.mm.ad.i)localObject1).optInt(e.r.bdK());
            localObject3 = e.r.mLO;
            long l1 = ((com.tencent.mm.ad.i)localObject1).optLong(e.r.bdL());
            if (!Util.isEqual((String)???, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw)) {
              break label2533;
            }
            long l2 = cn.bDv();
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfI = kotlin.k.k.bR(l2 - l1, 0L);
            Log.d(localb.TAG, "anchorServerTime:" + l1 + " myServerTime:" + l2);
            localObject3 = localb.TAG;
            localObject4 = new StringBuilder("notityAnchorInfoBySei anchorUserId:").append(???).append(" lastAudioMode:").append(localb.CuM).append(" lastScreenShareMode:").append(localb.CuN).append("userStatus:").append(i).append(" songId:").append(paramInt).append(", playStatus:").append(j).append(" coverUrl:");
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
            if (localObject1 != null) {
              break label2552;
            }
            localObject1 = null;
            label1539:
            Log.i((String)localObject3, localObject1);
            if (??? != null)
            {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr;
              if (localObject1 != null) {
                break label2598;
              }
              localObject1 = null;
              if (Util.isEqual((String)???, (String)localObject1))
              {
                localObject1 = e.a.mKb;
                bool = com.tencent.mm.ae.d.ee(i, e.a.bcs());
                if (localb.CuN != bool)
                {
                  localb.CuN = bool;
                  if (!bool) {
                    break label2608;
                  }
                  localObject1 = localb.nkg;
                  if (localObject1 != null)
                  {
                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                    if (localObject1 != null) {
                      ((com.tencent.mm.live.core.core.model.i)localObject1).mNQ = true;
                    }
                  }
                  localObject1 = localb.EjV;
                  if (localObject1 != null)
                  {
                    localObject1 = ((cc)localObject1).mJG;
                    if (localObject1 != null) {
                      ((com.tencent.mm.live.core.core.c.b)localObject1).setRenderMode(1);
                    }
                  }
                  localb.CuM = false;
                  localObject1 = localb.Ejt;
                  if (localObject1 != null) {
                    ((ab)localObject1).tO(4);
                  }
                }
                localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
                if (localObject1 != null) {
                  break label2727;
                }
                localObject1 = null;
                localObject3 = (CharSequence)localObject1;
                if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                  break label2773;
                }
                paramInt = 1;
                if (paramInt == 0) {
                  break label3798;
                }
                localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
                if (localObject1 != null) {
                  break label2778;
                }
                localObject1 = "";
                localObject3 = e.a.mKb;
                bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
                if (localb.CuM != bool)
                {
                  localObject1 = (CharSequence)localObject1;
                  if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                    break label2868;
                  }
                  paramInt = 1;
                  label1838:
                  if (paramInt == 0)
                  {
                    localb.CuM = bool;
                    localObject1 = e.a.mKb;
                    bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
                    if (!bool) {
                      break label2873;
                    }
                    localObject1 = localb.nkg;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                      if (localObject1 != null) {
                        ((com.tencent.mm.live.core.core.model.i)localObject1).bev();
                      }
                    }
                    label1897:
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", bool);
                    ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", localb.CuN);
                    localObject3 = localb.CCe;
                    if (localObject3 != null) {
                      ((com.tencent.mm.plugin.finder.live.view.router.b)localObject3).statusChange(b.c.neR, (Bundle)localObject1);
                    }
                  }
                }
                localObject1 = localb.EiR;
                if (localObject1 != null)
                {
                  localObject3 = e.a.mKb;
                  if (com.tencent.mm.ae.d.ee(i, e.a.bcq())) {
                    break label2905;
                  }
                  bool = true;
                  label1981:
                  ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).qJ(bool);
                }
              }
            }
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
            if (localObject1 != null)
            {
              if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL, (String)???))
              {
                localObject3 = e.a.mKb;
                bool = com.tencent.mm.ae.d.ee(i, e.a.bcr());
                if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).AWE != bool)
                {
                  localObject3 = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbH;
                  if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                    break label2911;
                  }
                  paramInt = 1;
                  label2073:
                  if (paramInt == 0)
                  {
                    ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).AWE = bool;
                    localObject3 = localb.Ejo;
                    if (localObject3 != null)
                    {
                      ((bf)localObject3).awC(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL);
                      localObject3 = kotlin.ah.aiuX;
                    }
                    localObject3 = localb.EiR;
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject3).emx();
                      localObject3 = kotlin.ah.aiuX;
                    }
                  }
                }
                localObject3 = e.a.mKb;
                bool = com.tencent.mm.ae.d.ee(i, e.a.bcq());
                if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbG != bool)
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbG = bool;
                  localObject1 = localb.EiR;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).emy();
                    localObject1 = kotlin.ah.aiuX;
                  }
                }
              }
              localObject1 = kotlin.ah.aiuX;
              localObject1 = kotlin.ah.aiuX;
            }
            if (((String)???).equals(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw))
            {
              paramBundle = paramBundle.getString("live_link_mic_info_in_anchor_sei_msg");
              if (!Util.isNullOrNil(paramBundle)) {
                break label2916;
              }
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
                break label3779;
              }
              Log.i(localb.TAG, "EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: linkMicInfo empty, linkMicInfo:" + paramBundle + ", roomPk:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM);
              localObject1 = new JSONObject();
              Log.d(localb.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: micData:", localObject1));
              ??? = ((JSONObject)localObject1).optJSONArray("list");
              if (??? != null) {
                break label2943;
              }
              paramInt = 0;
              label2342:
              if (paramInt != 0) {
                break label3021;
              }
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezc();
              paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
              kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
              if (((Collection)paramBundle).isEmpty()) {
                break label2952;
              }
              paramInt = 1;
              label2426:
              if (paramInt == 0) {
                break label2957;
              }
              Log.i(localb.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: audienceLinkMicUserList:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw));
              paramBundle = localb.CCe;
              if (paramBundle != null) {
                paramBundle.setLastRoomPkMicUserList(null);
              }
              paramBundle = localb.CCe;
              if (paramBundle != null)
              {
                paramBundle.notifyAudienceMicUserChange(false);
                paramBundle = kotlin.ah.aiuX;
              }
              paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 2);
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            paramBundle = kotlin.ah.aiuX;
            paramBundle = kotlin.ah.aiuX;
            AppMethodBeat.o(358128);
            return;
            localObject1 = paramBundle.getString("live_cdn_sei_msg");
            break;
            label2530:
            break label1280;
            label2533:
            Log.d(localb.TAG, kotlin.g.b.s.X("anchorId is invalid, maybe is in pk link mic. ", ???));
            break label1427;
            label2552:
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1539;
            }
            localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1539;
            }
            localObject1 = ((bgk)localObject1).EcY;
            break label1539;
            label2598:
            localObject1 = ((dix)localObject1).aaOw;
            break label1582;
            label2608:
            localObject1 = localb.nkg;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
              if (localObject1 != null) {
                ((com.tencent.mm.live.core.core.model.i)localObject1).mNQ = false;
              }
            }
            localObject1 = localb.EjV;
            if (localObject1 != null)
            {
              localObject1 = ((cc)localObject1).mJG;
              if (localObject1 != null)
              {
                localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                localObject3 = localb.buContext;
                localObject4 = localb.CCe;
                if (localObject4 != null) {
                  break label2717;
                }
              }
            }
            label2717:
            for (bool = false;; bool = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject4).isLandscape())
            {
              ((com.tencent.mm.live.core.core.c.b)localObject1).setRenderMode(com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject3, bool, localb.CuN));
              localb.CuM = false;
              break;
            }
            label2727:
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1737;
            }
            localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1737;
            }
            localObject1 = ((bgk)localObject1).EcY;
            break label1737;
            label2773:
            paramInt = 0;
            break label1761;
            label2778:
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = "";
              break label1790;
            }
            localObject1 = ((FinderObjectDesc)localObject1).media;
            if (localObject1 == null)
            {
              localObject1 = "";
              break label1790;
            }
            localObject1 = (FinderMedia)kotlin.a.p.oL((List)localObject1);
            if (localObject1 == null)
            {
              localObject1 = "";
              break label1790;
            }
            localObject3 = ((FinderMedia)localObject1).url;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break label1790;
            }
            localObject1 = "";
            break label1790;
            label2868:
            paramInt = 0;
            break label1838;
            label2873:
            localObject1 = localb.nkg;
            if (localObject1 == null) {
              break label1897;
            }
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
            if (localObject1 == null) {
              break label1897;
            }
            ((com.tencent.mm.live.core.core.model.i)localObject1).bew();
            break label1897;
            label2905:
            bool = false;
            break label1981;
            label2911:
            paramInt = 0;
            break label2073;
            try
            {
              label2916:
              paramBundle = new JSONObject(paramBundle);
              localObject1 = paramBundle;
            }
            catch (JSONException paramBundle)
            {
              for (;;)
              {
                paramBundle = new JSONObject();
              }
            }
          }
          paramInt = ((JSONArray)???).length();
          break label2342;
          label2952:
          paramInt = 0;
          break label2426;
          label2957:
          paramBundle = localb.CCe;
          if (paramBundle != null)
          {
            b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.neD);
            paramBundle = kotlin.ah.aiuX;
          }
          paramBundle = localb.CCe;
          if (paramBundle != null) {
            a.notifyRoomPKMicUserChange$default((a)paramBundle, (JSONObject)localObject1, false, null, 6, null);
          }
          paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          com.tencent.mm.plugin.finder.live.model.aj.a(3, (JSONObject)localObject1, false, 4);
          continue;
          label3021:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = true;
          paramBundle = localb.CCe;
          if (paramBundle != null)
          {
            b.b.a((com.tencent.mm.live.b.b)paramBundle, b.c.neC);
            paramBundle = kotlin.ah.aiuX;
          }
          paramInt = 1;
          ??? = new LinkedList();
          j = 0;
          if (??? == null)
          {
            i = 0;
            label3081:
            if (i <= 0) {
              break label3793;
            }
            paramBundle = null;
            paramInt = 1;
            label3089:
            k = j + 1;
            if (??? != null) {
              break label3333;
            }
            ??? = null;
            label3103:
            if (??? != null) {
              break label3345;
            }
            localObject3 = null;
            label3111:
            localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
            kotlin.g.b.s.s(localObject4, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
          }
          for (;;)
          {
            synchronized ((Iterable)localObject4)
            {
              Iterator localIterator = ((Iterable)???).iterator();
              if (localIterator.hasNext())
              {
                localObject4 = localIterator.next();
                bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL, (String)localObject3);
                if (!bool) {
                  continue;
                }
                localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4;
                if (localObject4 != null) {
                  break label3376;
                }
                Log.i(localb.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: can't find user info, userId:", localObject3));
                paramInt = 0;
                if (k < i) {
                  break label3786;
                }
                label3232:
                localb.ehm();
                if (paramInt == 0) {
                  break;
                }
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = paramBundle;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.clear();
                paramBundle = ((Iterable)???).iterator();
                if (!paramBundle.hasNext()) {
                  break label3461;
                }
                ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle.next();
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).g((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???);
                continue;
                i = ((JSONArray)???).length();
                break label3081;
                label3333:
                ??? = ((JSONArray)???).optJSONObject(j);
                break label3103;
                label3345:
                localObject3 = ((JSONObject)???).optString("uId");
                break label3111;
              }
              localObject4 = null;
            }
            label3376:
            if (??? == null) {}
            for (j = 0;; j = ((JSONObject)???).optInt("us"))
            {
              ??? = e.m.mLr;
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbG = com.tencent.mm.ae.d.ee(j, e.m.bdw());
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbD) {
                break label3429;
              }
              paramBundle = (Bundle)localObject4;
              break;
            }
            label3429:
            ??? = e.m.mLr;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbK = Boolean.valueOf(com.tencent.mm.ae.d.ee(j, e.m.bdz()));
            ((LinkedList)???).add(localObject4);
          }
          label3461:
          paramBundle = localb.CCe;
          if (paramBundle != null) {
            a.notifyRoomPKMicUserChange$default((a)paramBundle, (JSONObject)localObject1, false, null, 6, null);
          }
          paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          com.tencent.mm.plugin.finder.live.model.aj.a(3, (JSONObject)localObject1, false, 4);
        }
      }
      else
      {
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcZ()) {
          if (paramBundle == null)
          {
            paramBundle = null;
            label3519:
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          }
        }
      }
    }
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        localObject3 = ((Iterable)???).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label3767;
        }
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject3).next();
        if (paramBundle != null) {
          break label3640;
        }
        paramInt = 0;
        label3590:
        localObject1 = localb.nkg;
        if (localObject1 != null) {
          break label3741;
        }
        i = 0;
        break label3801;
        label3607:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbG = bool;
      }
      paramBundle = paramBundle.getParcelableArrayList("live_user_volume_info");
      break label3519;
      for (;;)
      {
        label3640:
        synchronized ((Iterable)paramBundle)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label3812;
          }
          localObject1 = ((Iterator)???).next();
          bool = Util.isEqual(((UserVolumeInfo)localObject1).userId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL);
          if (!bool) {
            continue;
          }
          localObject1 = (UserVolumeInfo)localObject1;
          if (localObject1 == null) {
            paramInt = 0;
          }
        }
        paramInt = ((UserVolumeInfo)localObject1).volume;
        break label3590;
        label3741:
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRM;
        if (localObject1 == null)
        {
          i = 0;
        }
        else
        {
          i = ((com.tencent.mm.live.core.core.model.c)localObject1).mMI;
          break label3801;
          label3767:
          paramBundle = kotlin.ah.aiuX;
          localb.ehm();
          label3779:
          AppMethodBeat.o(358128);
          return;
          label3786:
          j = k;
          break label3089;
          label3793:
          paramBundle = null;
          break label3232;
          label3798:
          break;
        }
        label3801:
        if (paramInt > i) {
          break label3818;
        }
        bool = true;
        break label3607;
        label3812:
        localObject1 = null;
      }
      label3818:
      bool = false;
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(358064);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramp);
    AppMethodBeat.o(358064);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(357981);
    super.pause();
    AppMethodBeat.o(357981);
  }
  
  public final void release()
  {
    int i = 1;
    AppMethodBeat.i(358147);
    Log.i(this.TAG, "release");
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
    com.tencent.mm.plugin.finder.live.model.mic.b.release();
    localObject1 = getLiveStartUIC();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).checkMiniWindow();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).nmZ.stopTimer();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).CuM = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).CuN = false;
    localObject1 = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.bhj();
    localObject1 = al.CHU;
    al.eme();
    com.tencent.mm.kernel.h.baD().mCm.b(3861, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3603, (com.tencent.mm.am.h)this);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcD)
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eey)
        {
          com.tencent.mm.plugin.gamelive.c localc = (com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.c.class);
          Context localContext = getContext();
          Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeu;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.Idh;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
          int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eev;
          localObject2 = Boolean.FALSE;
          localc.a(localContext, (String)localObject1, j, (Boolean)localObject2, (Boolean)localObject2, Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.a(false, getMiniWinPermission(), null, getFinishActivityNotReleaseLive(), 5);
        localObject1 = getLiveCore();
        if (localObject1 == null) {
          break label382;
        }
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode())) {
          break label382;
        }
        if ((i != 0) && (!getMiniWinPermission()) && (!getFinishActivityNotReleaseLive()))
        {
          localObject1 = com.tencent.mm.live.model.p.mZf;
          com.tencent.mm.live.model.p.release();
          localObject1 = getLiveCore();
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).bci();
          }
          getBuContext().clear();
        }
      }
      localObject1 = getLiveCore();
      if ((localObject1 instanceof com.tencent.mm.live.core.core.f.d)) {}
      for (localObject1 = (com.tencent.mm.live.core.core.f.d)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label492;
        }
        ((com.tencent.mm.live.core.core.f.d)localObject1).fO(false);
        AppMethodBeat.o(358147);
        return;
        label382:
        i = 0;
        break;
      }
    }
    localObject1 = getLiveCore();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode())) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!getMiniWinPermission()) && (!getFinishActivityNotReleaseLive()))
      {
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda)
        {
          localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          com.tencent.mm.plugin.finder.live.model.aj.a(false, getMiniWinPermission(), Boolean.FALSE, getFinishActivityNotReleaseLive(), 1);
          getBuContext().clear();
        }
        localObject1 = getLiveCore();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).bci();
        }
      }
      label492:
      AppMethodBeat.o(358147);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(357974);
    super.resume();
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.c)localObject1).nkg;
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
      if ((localObject2 != null) && (!((com.tencent.mm.live.core.core.model.i)localObject2).mNF))
      {
        i = 1;
        if (i == 0) {
          break label91;
        }
        localObject2 = ar.CIh;
        ar.emj();
        localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.c)localObject1).nkg;
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject2).bcg();
        }
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b)localObject1).EjY;
      if (localObject1 != null) {
        ((at)localObject1).onResume();
      }
      AppMethodBeat.o(357974);
      return;
      i = 0;
      break;
      label91:
      localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.c)localObject1).nkg;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.core.model.i)localObject2).mNF = false;
        }
      }
    }
  }
  
  protected final void setLiveMessageCallback(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(357860);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.liveMessageCallback = parama;
    AppMethodBeat.o(357860);
  }
  
  protected final void setLiveSlowMessageCallback(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(357876);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.liveSlowMessageCallback = parama;
    AppMethodBeat.o(357876);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(357849);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(357849);
  }
  
  public final void start()
  {
    AppMethodBeat.i(357991);
    super.start();
    getLiveStartUIC().startTimer();
    AppMethodBeat.o(357991);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(358055);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    getLivePrepareUIC();
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c.c(paramc);
    getLiveStartUIC().a(paramc, paramBundle);
    com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a locala = getLiveEndUIC();
    kotlin.g.b.s.u(paramc, "status");
    boolean bool1;
    switch (com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(358055);
      return;
    case 1: 
      paramc = locala.CCe;
      if (paramc != null) {
        paramc.setMiniWinPermission(false);
      }
      paramc = locala.EiK;
      if (paramc != null) {
        paramc.eoN();
      }
      if (paramBundle == null)
      {
        bool1 = false;
        label139:
        Log.i(locala.TAG, "finish live is manual finish:" + bool1 + ", liveData.business(LiveCommonSlice::class.java).externalPost:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet);
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
          break label302;
        }
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.a(true, (kotlin.g.a.s)new a.c(locala));
        }
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.gt((Context)locala.CCa);
        }
        paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("live_status_flag", 0);
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.biU();
      }
      break;
    }
    for (;;)
    {
      locala.bkX();
      break;
      bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL");
      break label139;
      label302:
      if (paramBundle == null) {}
      for (;;)
      {
        if (bool2)
        {
          paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
          if (paramc != null) {
            paramc.a(bool1, (kotlin.g.a.s)new a.d(locala));
          }
        }
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.gt((Context)locala.CCa);
        }
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.biU();
        if (!bool2)
        {
          paramc = locala.CCe;
          if (paramc != null) {
            b.b.a((com.tencent.mm.live.b.b)paramc, b.c.ncl);
          }
        }
        Log.i(locala.TAG, kotlin.g.b.s.X("close secondary live,realCloseLive = ", Boolean.valueOf(bool2)));
        AppMethodBeat.o(358055);
        return;
        bool2 = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
      }
      paramc = locala.CCa;
      if ((paramc instanceof MMActivity))
      {
        paramc = (MMActivity)paramc;
        label458:
        if ((paramc == null) || (paramc.isFinishing() != true)) {
          break label566;
        }
        i = 1;
        label472:
        if (i == 0)
        {
          paramc = locala.CCa;
          if (!(paramc instanceof MMActivity)) {
            break label571;
          }
          paramc = (MMActivity)paramc;
          label494:
          if ((paramc == null) || (paramc.isDestroyed() != true)) {
            break label576;
          }
        }
      }
      label566:
      label571:
      label576:
      for (int i = 1; i != 0; i = 0)
      {
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.a(false, false, Boolean.FALSE, false, 11);
        paramc = locala.nkg;
        if (paramc != null) {
          paramc.bci();
        }
        locala.bkX();
        locala.buContext.clear();
        AppMethodBeat.o(358055);
        return;
        paramc = null;
        break label458;
        i = 0;
        break label472;
        paramc = null;
        break label494;
      }
      paramc = locala.EiK;
      if (paramc != null) {
        paramc.tO(8);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(357986);
    super.stop();
    getLiveStartUIC().checkMiniWindow();
    AppMethodBeat.o(357986);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    a(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.c
 * JD-Core Version:    0.7.0.1
 */