package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.model.al;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.ad;
import com.tencent.mm.plugin.finder.live.plugin.ak;
import com.tencent.mm.plugin.finder.live.plugin.av;
import com.tencent.mm.plugin.finder.live.plugin.aw;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bg;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bs;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.cb;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cf;
import com.tencent.mm.plugin.finder.live.plugin.g;
import com.tencent.mm.plugin.finder.live.plugin.k;
import com.tencent.mm.plugin.finder.live.plugin.l;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.t;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.w;
import com.tencent.mm.plugin.finder.live.plugin.x;
import com.tencent.mm.plugin.finder.live.plugin.z;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.al;
import com.tencent.mm.plugin.finder.live.report.q.ap;
import com.tencent.mm.plugin.finder.live.report.q.az;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.i;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a.c;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.m;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.n;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.o;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.p;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.s;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.t;
import com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "liveMessageCallback", "Lkotlin/Function0;", "", "liveSlowMessageCallback", "activate", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "", "restart", "applyState", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "getLiveRole", "getRelativeLayoutId", "mount", "name", "needHideBgLayer", "notifyAudienceMicUserChange", "checkDiff", "notifyPKMicUserChange", "notifyRoomPKMicUserChange", "micData", "Lorg/json/JSONObject;", "forceUpdate", "screenSize", "Lkotlin/Pair;", "onAcceptBattleTimeout", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onApplyBattleTimeout", "onApplyMicPkTimeout", "onBackPress", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEventCallback", "errorCode", "param", "onRandomMatchTimeout", "onRandomMicAccept", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgApplyPkInfo;", "onRandomMicApply", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgNotifyApplyRandomMicInfo;", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "recoveryLocalVideo", "release", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.view.router.a
  implements com.tencent.mm.am.h
{
  private String TAG;
  private kotlin.g.a.a<kotlin.ah> liveMessageCallback;
  private kotlin.g.a.a<kotlin.ah> liveSlowMessageCallback;
  
  public b(MMActivity paramMMActivity, Fragment paramFragment)
  {
    super((Context)paramMMActivity, paramFragment);
    AppMethodBeat.i(357818);
    this.TAG = "Finder.LiveAnchorPluginLayout";
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this));
    this.liveSlowMessageCallback = ((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(357818);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(357874);
    kotlin.g.b.s.u(paramf, "data");
    super.activate(paramf, paramBoolean1, paramBoolean2);
    Log.i(this.TAG, "liveFinish:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcD + ",isFromFloat:" + paramBoolean1 + ", restart:" + paramBoolean2 + ",liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ",objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + ",nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId + ",username:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
    paramf = getLivePrepareUIC();
    Object localObject;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId == 0L)
    {
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqr = false;
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqs = false;
      paramf = paramf.CCb;
      if (paramf != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramf, com.tencent.mm.live.b.b.c.nch);
      }
    }
    for (;;)
    {
      paramf = al.CHU;
      al.q(name(), (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(357874);
      return;
      if (paramBoolean1)
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcD)
        {
          paramf = paramf.CCb;
          if (paramf != null) {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramf, com.tencent.mm.live.b.b.c.ncD);
          }
        }
        else
        {
          paramf = paramf.CCb;
          if (paramf != null) {
            paramf.prepareToStart(true);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        if (!com.tencent.mm.plugin.finder.live.model.aj.elx()) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).l(((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).jn(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN).getFinderObject());
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).EhX = true;
        paramf = paramf.CCb;
        if (paramf != null) {
          paramf.prepareToStart(false);
        }
      }
    }
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(358007);
    Object localObject1;
    Object localObject2;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyz())
    {
      a.hideLoadingLayer$default((a)this, false, 1, null);
      localObject1 = getLivePrepareUIC().EjT;
      if (localObject1 != null) {
        ((ad)localObject1).tO(0);
      }
      localObject1 = getLiveStartUIC();
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiO;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.y)localObject2).tO(0);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiP;
      if (localObject2 != null) {
        ((com.tencent.mm.live.b.y)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiQ;
      if (localObject2 != null) {
        ((cd)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiR;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).DcS;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiT;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiS;
      if (localObject2 != null) {
        ((bt)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiU;
      if (localObject2 != null) {
        ((bd)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiV;
      if (localObject2 != null) {
        ((bk)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiZ;
      if (localObject2 != null) {
        ((br)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Eja;
      if (localObject2 != null) {
        ((bz)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiN;
      if (localObject2 != null) {
        ((l)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiW;
      if (localObject2 != null) {
        ((az)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiX;
      if (localObject2 != null) {
        ((bg)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiY;
      if (localObject2 != null) {
        ((bq)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejc;
      if (localObject2 != null) {
        ((o)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejj;
      if (localObject2 != null) {
        ((av)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejk;
      if (localObject2 != null) {
        ((aw)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejb;
      if (localObject2 != null) {
        ((cf)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejd;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.i)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejf;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ba)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejh;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.d)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Eji;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejg;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.r)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejl;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.q)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejm;
      if (localObject2 != null) {
        ((bs)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejn;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.p)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejo;
      if (localObject2 != null) {
        ((bf)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejr;
      if (localObject2 != null) {
        ((be)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejp;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejq;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.bc)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejs;
      if (localObject2 != null) {
        ((cb)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjA;
      if (localObject2 != null) {
        ((ac)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjB;
      if (localObject2 != null) {
        ((bp)localObject2).tO(8);
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjE;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tO(8);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt())
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejt;
        if (localObject2 != null) {
          ((ab)localObject2).tO(0);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjC;
        if (localObject2 != null) {
          ((k)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjD;
        if (localObject2 != null) {
          ((n)localObject2).tO(8);
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjG;
        if (localObject1 != null) {
          ((ak)localObject1).tO(8);
        }
        localObject1 = getLiveEndUIC().EiK;
        if (localObject1 != null) {
          ((g)localObject1).tO(8);
        }
      }
    }
    do
    {
      super.applyState(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(358007);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejt;
      if (localObject2 == null) {
        break;
      }
      ((ab)localObject2).tO(8);
      break;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA())
      {
        a.hideLoadingLayer$default((a)this, false, 1, null);
        localObject1 = getLivePrepareUIC().EjT;
        if (localObject1 != null) {
          ((ad)localObject1).tO(8);
        }
        localObject1 = getLiveStartUIC();
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiP;
        if (localObject2 != null) {
          ((com.tencent.mm.live.b.y)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiQ;
        if (localObject2 != null) {
          ((cd)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiR;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).DcS;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiS;
        if (localObject2 != null) {
          ((bt)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiW;
        if (localObject2 != null) {
          ((az)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiX;
        if (localObject2 != null) {
          ((bg)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiY;
        if (localObject2 != null) {
          ((bq)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejc;
        if (localObject2 != null) {
          ((o)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiZ;
        if (localObject2 != null) {
          ((br)localObject2).tO(8);
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Eja;
        if (localObject2 != null) {
          ((bz)localObject2).tO(8);
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efn)
        {
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit = true");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efo;
          Integer localInteger = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efp;
          if ((localObject2 != null) && (localInteger != null))
          {
            l locall = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiN;
            if (locall != null) {
              locall.tO(0);
            }
            locall = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiN;
            if (locall != null) {
              locall.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, (bgq)localObject2, localInteger.intValue());
            }
          }
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiV;
          if (localObject2 != null) {
            ((bk)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejj;
          if (localObject2 != null) {
            ((av)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejk;
          if (localObject2 != null) {
            ((aw)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejb;
          if (localObject2 != null) {
            ((cf)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejd;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.i)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejf;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.ba)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejg;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.r)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejh;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.d)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Eji;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejl;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.q)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejm;
          if (localObject2 != null) {
            ((bs)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejn;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.p)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejo;
          if (localObject2 != null) {
            ((bf)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejr;
          if (localObject2 != null) {
            ((be)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Eju;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.u)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejv;
          if (localObject2 != null) {
            ((z)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejw;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.aa)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).CWq;
          if (localObject2 != null) {
            ((t)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejx;
          if (localObject2 != null) {
            ((v)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejy;
          if (localObject2 != null) {
            ((w)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejz;
          if (localObject2 != null) {
            ((x)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejp;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.h)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejq;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.bc)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejs;
          if (localObject2 != null) {
            ((cb)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).Ejt;
          if (localObject2 != null) {
            ((ab)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjA;
          if (localObject2 != null) {
            ((ac)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjB;
          if (localObject2 != null) {
            ((bp)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjC;
          if (localObject2 != null) {
            ((k)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjD;
          if (localObject2 != null) {
            ((n)localObject2).tO(8);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjE;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.s)localObject2).tO(8);
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EjG;
          if (localObject1 != null) {
            ((ak)localObject1).tO(8);
          }
          getLiveEndUIC().ezp();
          break;
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).TAG, "onLiveEnd: isLiveEndByForceQuit, but no cache errorPage");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiN;
          if (localObject2 != null)
          {
            ((l)localObject2).tO(8);
            continue;
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).EiN;
            if (localObject2 != null) {
              ((l)localObject2).tO(8);
            }
          }
        }
      }
    } while (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted());
    if (((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).lastLiveState != 2) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT == 2)) || ((com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcU, 32)) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32)) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a.hideLoadingLayer$default((a)this, false, 1, null);
      }
      localObject1 = getLivePrepareUIC().EjT;
      if (localObject1 != null) {
        ((ad)localObject1).tO(8);
      }
      getLiveStartUIC().ezx();
      localObject1 = getLiveEndUIC().EiK;
      if (localObject1 == null) {
        break;
      }
      ((g)localObject1).tO(8);
      break;
    }
  }
  
  public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    e.h localh = null;
    AppMethodBeat.i(357856);
    kotlin.g.b.s.u(paramf, "data");
    super.bindData(paramf);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("bindData liveData.isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()).append(" liveMicSetting:");
    paramf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
    if (paramf == null)
    {
      paramf = null;
      localStringBuilder = localStringBuilder.append(paramf).append(" liveMicSettingSwitch:");
      paramf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
      if (paramf != null) {
        break label204;
      }
    }
    label204:
    for (paramf = localh;; paramf = Long.valueOf(paramf.field_liveMicSettingSwitch))
    {
      Log.i(str, paramf);
      paramf = com.tencent.mm.live.core.core.a.b.mMo;
      setLiveCore(com.tencent.mm.live.core.core.a.b.a.bej());
      paramf = getLiveCore();
      if (paramf != null)
      {
        localh = e.h.mKY;
        paramf.setScene(e.h.bdj());
      }
      getLivePrepareUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      getLiveStartUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      getLiveEndUIC().a((com.tencent.mm.plugin.finder.live.view.router.a)this);
      AppMethodBeat.o(357856);
      return;
      paramf = Long.valueOf(paramf.field_liveMicSetting);
      break;
    }
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  public final int getRelativeLayoutId()
  {
    return p.f.Cdb;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(357971);
    super.mount();
    Object localObject = com.tencent.mm.plugin.finder.utils.bc.GkH;
    localObject = getLiveCore();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
      AppMethodBeat.o(357971);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.finder.utils.bc.f((com.tencent.mm.live.core.core.a.b)localObject);
    localObject = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.g(name(), this.liveMessageCallback);
    localObject = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.h(name(), this.liveSlowMessageCallback);
    com.tencent.mm.kernel.h.baD().mCm.a(3582, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3917, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3861, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3603, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).init();
    AppMethodBeat.o(357971);
  }
  
  public final String name()
  {
    AppMethodBeat.i(357902);
    String str = b.class.getSimpleName();
    kotlin.g.b.s.s(str, "FinderLiveAnchorPluginLa…ut::class.java.simpleName");
    AppMethodBeat.o(357902);
    return str;
  }
  
  public final void notifyAudienceMicUserChange(boolean paramBoolean)
  {
    AppMethodBeat.i(358179);
    super.notifyAudienceMicUserChange(paramBoolean);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(358179);
  }
  
  public final void notifyPKMicUserChange(boolean paramBoolean)
  {
    AppMethodBeat.i(358184);
    super.notifyPKMicUserChange(paramBoolean);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(358184);
  }
  
  public final boolean notifyRoomPKMicUserChange(JSONObject paramJSONObject, boolean paramBoolean, kotlin.r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(358190);
    paramBoolean = super.notifyRoomPKMicUserChange(paramJSONObject, paramBoolean, paramr);
    if (paramBoolean) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    }
    AppMethodBeat.o(358190);
    return paramBoolean;
  }
  
  public final void onAcceptBattleTimeout() {}
  
  public final void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(358049);
    kotlin.g.b.s.u(parama, "info");
    getLiveStartUIC();
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.onAcceptLiveMic(parama);
    Log.i(this.TAG, kotlin.g.b.s.X("onAcceptLiveMic info:", parama));
    AppMethodBeat.o(358049);
  }
  
  public final void onAcceptMicPkTimeout()
  {
    AppMethodBeat.i(358096);
    Log.i(this.TAG, "accept pk mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + ", curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy == 2)
    {
      com.tencent.mm.plugin.finder.live.plugin.q localq = localb.Ejl;
      if (localq != null) {
        localq.epp();
      }
      com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.a(localb);
    }
    AppMethodBeat.o(358096);
  }
  
  public final void onAcceptMicTimeout(String paramString)
  {
    AppMethodBeat.i(358086);
    Log.i(this.TAG, "accept mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " micId:" + paramString);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ayr(paramString)) {
      com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.a(localb, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ays(paramString));
    }
    AppMethodBeat.o(358086);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(358195);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(358195);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
        if (paramIntent == null)
        {
          ((com.tencent.mm.plugin.finder.live.report.r)localObject).DGa += 1L;
          AppMethodBeat.o(358195);
          return;
        }
        paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        if ((paramIntent == null) || (paramIntent.isEmpty()))
        {
          ((com.tencent.mm.plugin.finder.live.report.r)localObject).DGa += 1L;
          AppMethodBeat.o(358195);
          return;
        }
        ((com.tencent.mm.plugin.finder.live.report.r)localObject).DGa += paramIntent.size();
        AppMethodBeat.o(358195);
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
  
  public final void onApplyBattleTimeout()
  {
    AppMethodBeat.i(357949);
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).CCb;
    if (localObject2 != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject2, com.tencent.mm.live.b.b.c.nfg);
    }
    localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.c localc = q.c.DrF;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("type", Integer.valueOf(q.i.DsJ.type));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.model.i)localObject1).CES)
    {
      localJSONObject.putOpt("result", localObject1);
      localObject1 = kotlin.ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a(localc, localJSONObject.toString());
      AppMethodBeat.o(357949);
      return;
    }
  }
  
  public final void onApplyMicPkTimeout()
  {
    AppMethodBeat.i(358091);
    Log.i(this.TAG, "apply pk mic timeout, will auto cancel. curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + ", curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy == 2)
    {
      com.tencent.mm.plugin.finder.live.plugin.q localq = localb.Ejl;
      if (localq != null) {
        localq.epp();
      }
      localb.ao((kotlin.g.a.b)new b.m(localb));
    }
    AppMethodBeat.o(358091);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(357978);
    boolean bool = super.onBackPress();
    if (!bool)
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqP.mwI, "");
      com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.etj());
    }
    AppMethodBeat.o(357978);
    return bool;
  }
  
  public final void onBattleApply()
  {
    AppMethodBeat.i(357937);
    com.tencent.mm.plugin.finder.live.view.router.a locala = getLiveStartUIC().CCb;
    if (locala != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)locala, com.tencent.mm.live.b.b.c.neZ);
    }
    AppMethodBeat.o(357937);
  }
  
  public final void onBattleClose()
  {
    AppMethodBeat.i(357943);
    com.tencent.mm.plugin.finder.live.view.router.a locala = getLiveStartUIC().CCb;
    if (locala != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)locala, com.tencent.mm.live.b.b.c.nfc);
    }
    AppMethodBeat.o(357943);
  }
  
  public final void onBattleDismiss()
  {
    AppMethodBeat.i(357933);
    ac localac = getLiveStartUIC().EjA;
    if (localac != null) {
      localac.epM();
    }
    AppMethodBeat.o(357933);
  }
  
  public final void onBattleEnd()
  {
    AppMethodBeat.i(357923);
    Object localObject1 = getLiveStartUIC();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject1).CCb;
    if (localObject2 != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject2, com.tencent.mm.live.b.b.c.nfb);
    }
    localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.c localc = q.c.DrF;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("type", Integer.valueOf(q.i.DsK.type));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.model.i)localObject1).CES)
    {
      localJSONObject.putOpt("result", localObject1);
      localObject1 = kotlin.ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a(localc, localJSONObject.toString());
      AppMethodBeat.o(357923);
      return;
    }
  }
  
  public final void onBattleStart()
  {
    AppMethodBeat.i(357916);
    Object localObject = getLiveStartUIC();
    com.tencent.mm.plugin.finder.live.model.mic.b localb = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
    com.tencent.mm.plugin.finder.live.model.mic.b.eni();
    localObject = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCb;
    if (localObject != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject, com.tencent.mm.live.b.b.c.nfa);
    }
    AppMethodBeat.o(357916);
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(357889);
    kotlin.g.b.s.u(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = getLiveCore();
    if (paramString == null)
    {
      paramString = null;
      Log.i((String)localObject, paramString);
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(357889);
          return;
          paramString = paramString.mRB;
          if (paramString == null)
          {
            paramString = null;
            break;
          }
          paramString = Boolean.valueOf(paramString.isFloatMode());
          break;
          AppMethodBeat.o(357889);
          return;
        } while ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()));
        paramString = getLiveCore();
        if (paramString != null)
        {
          paramString = (com.tencent.mm.live.core.core.b)paramString;
          localObject = MMApplicationContext.getContext().getResources().getDrawable(p.g.mic_user_leave);
          kotlin.g.b.s.s(localObject, "getContext().resources.g…ble(R.raw.mic_user_leave)");
          paramString.G(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject));
        }
        if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.isEmpty()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv != null))
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
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp |= 0x2;
        paramString = com.tencent.mm.plugin.finder.live.util.u.DJC;
        com.tencent.mm.plugin.finder.live.util.u.ey("CALL_STATE_OFFHOOK", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
        paramString = getFinderLiveAssistant();
      } while (paramString == null);
      ap.a.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 2L, 0, null, 48);
      AppMethodBeat.o(357889);
      return;
    } while ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()));
    Log.i(this.TAG, "recoveryLocalVideo enableAudioMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt() + " audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DVR);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt())
    {
      paramString = getLiveCore();
      if (paramString != null)
      {
        paramString = (com.tencent.mm.live.core.core.b)paramString;
        localObject = getContext().getResources().getDrawable(p.d.live_audio_mode_frame);
        kotlin.g.b.s.s(localObject, "context.resources.getDra…le.live_audio_mode_frame)");
        paramString.G(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject));
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
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp &= 0xFFFFFFFD;
      paramString = com.tencent.mm.plugin.finder.live.util.u.DJC;
      com.tencent.mm.plugin.finder.live.util.u.ey("CALL_STATE_IDLE", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      paramString = getFinderLiveAssistant();
      if (paramString == null) {
        break;
      }
      ap.a.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 2L, 0, null, 48);
      break;
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
  
  public final void onCloseLiveMic(com.tencent.mm.live.model.f paramf)
  {
    AppMethodBeat.i(358040);
    kotlin.g.b.s.u(paramf, "info");
    Object localObject2 = getLiveStartUIC();
    kotlin.g.b.s.u(paramf, "info");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    Object localObject3;
    if ((localObject1 != null) && (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).sessionId, paramf.mXx)))
    {
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).TAG, "close mic pk. curLinkUser:" + localObject1 + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy);
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbD)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
        com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FT(null);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezc();
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza())
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).Ejl;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.q)localObject1).epp();
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).Ejm;
          if (localObject1 != null) {
            ((bs)localObject1).epp();
          }
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).ezu();
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).Ejp;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).eoT();
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyY, "", -1, -1);
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.c.DrF;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).putOpt("type", Integer.valueOf(q.i.DsL.type));
        ((JSONObject)localObject3).putOpt("result", Integer.valueOf(0));
        kotlin.ah localah = kotlin.ah.aiuX;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.c)localObject2, ((JSONObject)localObject3).toString());
      }
      Log.i(this.TAG, kotlin.g.b.s.X("onCloseLiveMic info:", paramf));
      AppMethodBeat.o(358040);
      return;
    }
    Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).TAG, "close mic. info:" + paramf + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    com.tencent.mm.ae.d.a((List)localObject1, (kotlin.g.a.b)new b.n(paramf));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
    kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
    com.tencent.mm.ae.d.a((List)localObject1, (kotlin.g.a.b)new b.o(paramf));
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject2).CCb;
      if (localObject1 != null)
      {
        localObject3 = (a)localObject1;
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject2).ngB;
        if (localObject1 != null) {
          break label513;
        }
        localObject1 = null;
        label485:
        a.notifyRoomPKMicUserChange$default((a)localObject3, (JSONObject)localObject1, false, null, 6, null);
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject2).Ejp;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).eoT();
      break;
      label513:
      localObject1 = ((com.tencent.mm.live.core.core.a.b)localObject1).bfi();
      break label485;
      localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject2).CCb;
      if (localObject1 != null) {
        a.notifyAudienceMicUserChange$default((a)localObject1, false, 1, null);
      }
    }
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle arg2)
  {
    AppMethodBeat.i(358166);
    Log.i(this.TAG, kotlin.g.b.s.X("sdk callback errorCode:", Integer.valueOf(paramInt)));
    ??? = com.tencent.mm.plugin.finder.utils.bc.GkH;
    ??? = getBuContext();
    ??? = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    kotlin.g.b.s.s(???, "getNetTypeString(MMAppli…tionContext.getContext())");
    com.tencent.mm.plugin.finder.utils.bc.c((com.tencent.mm.plugin.finder.live.model.context.a)???, (String)???);
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    ??? = e.g.mKv;
    label115:
    Object localObject5;
    label143:
    Object localObject6;
    if (paramInt == e.g.bcH())
    {
      if (??? == null)
      {
        ??? = "";
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
        if ((??? == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).EbD != true)) {
          break label459;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
          if (??? != null) {
            break label464;
          }
          ??? = null;
          if (Util.isEqual((String)???, ???))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 4;
            ??? = localb.Ejl;
            if (??? != null)
            {
              ((com.tencent.mm.plugin.finder.live.plugin.q)???).epp();
              ??? = kotlin.ah.aiuX;
            }
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
            {
              ??? = localb.CCb;
              if (??? != null)
              {
                a.notifyPKMicUserChange$default((a)???, false, 1, null);
                ??? = kotlin.ah.aiuX;
              }
            }
            ??? = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
            com.tencent.mm.plugin.finder.live.model.mic.b.enh();
            ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
            localObject5 = q.ap.DyW;
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
            if (??? != null) {
              break label474;
            }
          }
        }
      }
      label459:
      label464:
      label474:
      for (??? = null;; ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).username)
      {
        ((com.tencent.mm.plugin.finder.live.report.j)???).a((q.ap)localObject5, (String)???, q.az.DAn.type, q.al.Dyw.type);
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
          break label520;
        }
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
        kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
        synchronized ((Iterable)???)
        {
          ??? = ((Iterable)???).iterator();
          do
          {
            if (!((Iterator)???).hasNext()) {
              break;
            }
            localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
            localObject6 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          } while ((!com.tencent.mm.plugin.finder.live.utils.a.d((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5)) || (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).mXL, ???)));
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).eyb();
          localObject6 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
          com.tencent.mm.plugin.finder.live.model.mic.b.awI(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).sessionId);
        }
        ??? = ???.getString("live_user_id");
        if (??? == null)
        {
          ??? = "";
          break;
        }
        break;
        paramInt = 0;
        break label115;
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL;
        break label143;
      }
      ??? = kotlin.ah.aiuX;
      ??? = localb.CCb;
      if (??? != null)
      {
        a.notifyAudienceMicUserChange$default((a)???, false, 1, null);
        ??? = kotlin.ah.aiuX;
      }
      label520:
      Log.i(localb.TAG, "USER_VIDEO_AVAILABLE curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + ", curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + ", userId:" + ??? + ", selfId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF() + ", audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + ", isRoomPk:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM);
      AppMethodBeat.o(358166);
      return;
    }
    ??? = e.g.mKv;
    if (paramInt == e.g.bcM())
    {
      if (??? == null) {
        ??? = "";
      }
      for (;;)
      {
        Log.i(localb.TAG, "USER_VIDEO_DISABLE curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + ", curLinkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + ", userId:" + ??? + ", selfId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF() + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
        AppMethodBeat.o(358166);
        return;
        ??? = ???.getString("live_user_id");
        if (??? == null) {
          ??? = "";
        }
      }
    }
    ??? = e.g.mKv;
    if (paramInt == e.g.bcI())
    {
      if (??? == null)
      {
        ??? = "";
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
        if ((??? == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).EbD != true)) {
          break label1065;
        }
        paramInt = 1;
        label883:
        if (paramInt != 0)
        {
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
          if (??? != null) {
            break label1070;
          }
        }
      }
      label1065:
      label1070:
      for (??? = null;; ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL)
      {
        if (Util.isEqual((String)???, ???))
        {
          ??? = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
          com.tencent.mm.plugin.finder.live.model.mic.b.eng();
          localb.ao(null);
        }
        ??? = new ArrayList();
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        synchronized ((Iterable)???)
        {
          localObject5 = ((Iterable)???).iterator();
          do
          {
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject6 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject5).next();
          } while (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).mXL, ???));
          ((ArrayList)???).add(localObject6);
        }
        ??? = ???.getString("live_user_id");
        if (??? == null)
        {
          ??? = "";
          break;
        }
        break;
        paramInt = 0;
        break label883;
      }
      localObject5 = kotlin.ah.aiuX;
      if (!((Collection)???).isEmpty()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          localb.a((com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next(), null);
        }
      }
      ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
      kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
      com.tencent.mm.ae.d.a((List)???, (kotlin.g.a.b)new b.p(???));
      Log.i(localb.TAG, "EVENT_ROOM_USER_EXIT userId:" + ??? + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
      AppMethodBeat.o(358166);
      return;
    }
    ??? = e.g.mKv;
    boolean bool;
    if (paramInt == e.g.bcJ())
    {
      if (??? == null)
      {
        ??? = "";
        if (??? != null) {
          break label1462;
        }
        bool = false;
      }
      for (;;)
      {
        if (bool)
        {
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
          kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
          synchronized ((Iterable)???)
          {
            ??? = ???.iterator();
            do
            {
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
              localObject6 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            } while ((!com.tencent.mm.plugin.finder.live.utils.a.e((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5)) || (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).mXL, (String)???)));
            localObject5 = com.tencent.mm.plugin.finder.utils.ba.Gjt;
            com.tencent.mm.plugin.finder.utils.ba.fgM();
          }
          String str1 = ???.getString("live_user_id");
          if (str1 == null)
          {
            str1 = "";
            break;
          }
          break;
          label1462:
          bool = ???.getBoolean("live_media_enable");
          continue;
          ??? = kotlin.ah.aiuX;
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
          {
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
            kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
            synchronized ((Iterable)???)
            {
              ??? = ???.iterator();
              while (((Iterator)???).hasNext())
              {
                localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
                localObject6 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                if ((com.tencent.mm.plugin.finder.live.utils.a.e((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5)) && (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).mXL, str1)))
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).eyb();
                  localObject6 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
                  com.tencent.mm.plugin.finder.live.model.mic.b.awI(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).sessionId);
                }
              }
            }
            ??? = kotlin.ah.aiuX;
            ??? = localb.CCb;
            if (??? != null)
            {
              a.notifyAudienceMicUserChange$default((a)???, false, 1, null);
              ??? = kotlin.ah.aiuX;
            }
          }
        }
      }
      Log.i(localb.TAG, "EVENT_ROOM_USER_AUDIO_STATE linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceMicList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " userId:" + str2 + " enable:" + bool);
      AppMethodBeat.o(358166);
      return;
    }
    Object localObject3 = e.g.mKv;
    if (paramInt == e.g.bcN())
    {
      localb.ezs();
      AppMethodBeat.o(358166);
      return;
    }
    localObject3 = e.g.mKv;
    int i;
    if (paramInt == e.g.bcK())
    {
      localObject3 = localb.CCb;
      if (localObject3 != null)
      {
        i = ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkQuality();
        ??? = localb.ngB;
        if (??? != null) {
          break label1976;
        }
        ??? = null;
        if (??? != null) {
          break label2001;
        }
        ??? = e.o.mLz;
        paramInt = e.o.bdD();
        label1839:
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).setCurNetworkQuality(paramInt);
        ??? = e.o.mLz;
        if (i == e.o.bdF()) {
          break label2009;
        }
        paramInt = ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkQuality();
        ??? = e.o.mLz;
        if (paramInt != e.o.bdF()) {
          break label2009;
        }
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject3, com.tencent.mm.live.b.b.c.ncZ);
        label1884:
        i = ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkType();
        ??? = localb.ngB;
        if (??? != null) {
          break label2051;
        }
        paramInt = -1;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).setCurNetworkType(paramInt);
        if ((i == 0) && (((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkType() != 0) && (((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkType() != -1)) {
          com.tencent.mm.ui.base.aa.makeText((Context)localb.CCa, (CharSequence)localb.CCa.getResources().getString(p.h.Cmb), 0).show();
        }
        ??? = kotlin.ah.aiuX;
        ??? = kotlin.ah.aiuX;
        AppMethodBeat.o(358166);
        return;
        label1976:
        ??? = ???.mRB;
        if (??? == null)
        {
          ??? = null;
          break;
        }
        ??? = Integer.valueOf(???.mNT);
        break;
        label2001:
        paramInt = ???.intValue();
        break label1839;
        label2009:
        ??? = e.o.mLz;
        if (i != e.o.bdF()) {
          break label1884;
        }
        paramInt = ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).getCurNetworkQuality();
        ??? = e.o.mLz;
        if (paramInt == e.o.bdF()) {
          break label1884;
        }
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject3, com.tencent.mm.live.b.b.c.nda);
        break label1884;
        label2051:
        ??? = ???.mRB;
        if (??? == null) {
          paramInt = -1;
        } else {
          paramInt = ???.networkType;
        }
      }
    }
    localObject3 = e.g.mKv;
    if (paramInt == e.g.bcS())
    {
      localObject3 = localb.CCb;
      if (localObject3 != null)
      {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).statusChange(com.tencent.mm.live.b.b.c.ned, ???);
        localObject3 = kotlin.ah.aiuX;
      }
      localObject3 = localb.EiR;
      if (localObject3 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject3).ar(???);
        ??? = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(358166);
      return;
    }
    localObject3 = e.g.mKv;
    if (paramInt == e.g.bcZ()) {
      if (??? == null)
      {
        ??? = null;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        if (localObject3 == null) {
          break label2416;
        }
      }
    }
    for (;;)
    {
      synchronized ((Iterable)localObject3)
      {
        localObject5 = ((Iterable)???).iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label2403;
        }
        localObject6 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject5).next();
        if (??? != null) {
          break label2276;
        }
        paramInt = 0;
        localObject3 = localb.ngB;
        if (localObject3 != null) {
          break label2377;
        }
        i = 0;
        break label3769;
        label2243:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).EbG = bool;
      }
      ??? = ???.getParcelableArrayList("live_user_volume_info");
      break;
      for (;;)
      {
        label2276:
        synchronized ((Iterable)???)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label3780;
          }
          localObject3 = ((Iterator)???).next();
          bool = Util.isEqual(((UserVolumeInfo)localObject3).userId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).mXL);
          if (!bool) {
            continue;
          }
          localObject3 = (UserVolumeInfo)localObject3;
          if (localObject3 == null) {
            paramInt = 0;
          }
        }
        paramInt = ((UserVolumeInfo)localObject3).volume;
        break;
        label2377:
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).mRM;
        if (localObject3 == null)
        {
          i = 0;
        }
        else
        {
          i = ((com.tencent.mm.live.core.core.model.c)localObject3).mMI;
          break label3769;
          label2403:
          localObject3 = kotlin.ah.aiuX;
          localObject3 = kotlin.ah.aiuX;
          label2416:
          localObject3 = localb.Ejr;
          if (localObject3 != null) {
            ((be)localObject3).emv();
          }
          if (??? == null) {}
          for (??? = (List)new ArrayList();; ??? = (List)???)
          {
            localb.gZ(???);
            AppMethodBeat.o(358166);
            return;
          }
          localObject3 = e.g.mKv;
          if (paramInt == e.g.bda())
          {
            if (??? == null)
            {
              ??? = null;
              if (??? != null)
              {
                localObject3 = new com.tencent.mm.ad.i(???);
                ??? = e.r.mLO;
                ??? = ((com.tencent.mm.ad.i)localObject3).optString(e.r.getUserId());
                if (??? != null) {
                  break label2768;
                }
                ??? = "";
                label2522:
                ??? = e.r.mLO;
                i = ((com.tencent.mm.ad.i)localObject3).optInt(e.r.bdI());
                localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
                if (localObject3 != null) {
                  if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).mXL, ???))
                  {
                    ??? = com.tencent.mm.live.core.core.e.a.mKb;
                    bool = com.tencent.mm.ae.d.ee(i, com.tencent.mm.live.core.core.e.a.bcr());
                    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).AWE != bool)
                    {
                      ??? = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbH;
                      if ((??? != null) && (((CharSequence)???).length() != 0)) {
                        break label2771;
                      }
                    }
                  }
                }
              }
            }
            label2768:
            label2771:
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt == 0)
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).AWE = bool;
                ??? = localb.Ejo;
                if (??? != null)
                {
                  ((bf)???).awC(???);
                  ??? = kotlin.ah.aiuX;
                }
                ??? = localb.EiR;
                if (??? != null)
                {
                  ???.emx();
                  ??? = kotlin.ah.aiuX;
                }
                ??? = localb.EjA;
                if (??? != null)
                {
                  ???.CXf.Enq = bool;
                  ??? = kotlin.ah.aiuX;
                }
              }
              ??? = com.tencent.mm.live.core.core.e.a.mKb;
              bool = com.tencent.mm.ae.d.ee(i, com.tencent.mm.live.core.core.e.a.bcq());
              if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbG != bool)
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbG = bool;
                ??? = localb.EiR;
                if (??? != null)
                {
                  ???.emy();
                  ??? = kotlin.ah.aiuX;
                }
              }
              ??? = kotlin.ah.aiuX;
              ??? = kotlin.ah.aiuX;
              AppMethodBeat.o(358166);
              return;
              ??? = ???.getString("live_cdn_sei_msg");
              break;
              break label2522;
            }
          }
          localObject3 = e.g.mKv;
          label2858:
          label2869:
          label3142:
          label3166:
          label3175:
          label3180:
          int j;
          if (paramInt == e.g.bde())
          {
            localObject3 = localb.EiO;
            if ((localObject3 != null) && (((com.tencent.mm.plugin.finder.live.plugin.y)localObject3).epy() == true))
            {
              paramInt = 1;
              if (paramInt != 0) {
                break label2869;
              }
              localObject3 = localb.TAG;
              ??? = localb.EiO;
              if (??? != null) {
                break label2858;
              }
            }
            for (??? = null;; ??? = Boolean.valueOf(???.epy()))
            {
              Log.i((String)localObject3, kotlin.g.b.s.X("EVENT_ANCHOR_NOTIFY_CLOUD_MIXTURE_FOR_FINDER: render layout not ready:", ???));
              AppMethodBeat.o(358166);
              return;
              paramInt = 0;
              break;
            }
            if (??? == null)
            {
              ??? = null;
              if (!Util.isNullOrNil(???)) {
                break label3142;
              }
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
                break label3755;
              }
              Log.i(localb.TAG, "EVENT_ANCHOR_NOTIFY_CLOUD_MIXTURE_FOR_FINDER: linkMicInfo empty, linkMicInfo:" + ??? + ", roomPk:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM);
              ??? = new JSONObject();
              Log.i(localb.TAG, kotlin.g.b.s.X("EVENT_ANCHOR_NOTIFY_CLOUD_MIXTURE_FOR_FINDER: micData:", ???));
              localObject6 = ???.optJSONArray("list");
              if (localObject6 != null) {
                break label3166;
              }
              paramInt = 0;
              label2986:
              if (paramInt != 0) {
                break label3214;
              }
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezc();
              localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
              kotlin.g.b.s.s(localObject3, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
              if (((Collection)localObject3).isEmpty()) {
                break label3175;
              }
            }
            for (paramInt = 1;; paramInt = 0)
            {
              for (;;)
              {
                if (paramInt == 0) {
                  break label3180;
                }
                Log.i(localb.TAG, kotlin.g.b.s.X("EVENT_ANCHOR_NOTIFY_CLOUD_MIXTURE_FOR_FINDER: audienceLinkMicUserList:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw));
                ??? = localb.CCb;
                if (??? != null) {
                  ???.setLastRoomPkMicUserList(null);
                }
                ??? = localb.CCb;
                if (??? != null)
                {
                  ???.notifyAudienceMicUserChange(false);
                  ??? = kotlin.ah.aiuX;
                }
                AppMethodBeat.o(358166);
                return;
                ??? = ???.getString("live_link_mic_info_in_anchor_sei_msg");
                break;
                try
                {
                  ??? = new JSONObject(???);
                }
                catch (JSONException ???)
                {
                  for (;;)
                  {
                    ??? = new JSONObject();
                  }
                }
              }
              paramInt = ((JSONArray)localObject6).length();
              break label2986;
            }
            localObject3 = localb.CCb;
            if (localObject3 != null) {
              a.notifyRoomPKMicUserChange$default((a)localObject3, ???, false, null, 6, null);
            }
            AppMethodBeat.o(358166);
            return;
            label3214:
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = true;
            paramInt = 1;
            ??? = new LinkedList();
            j = 0;
            if (localObject6 == null)
            {
              i = 0;
              if (i > 0) {
                paramInt = 1;
              }
            }
          }
          for (;;)
          {
            int k = j + 1;
            if (localObject6 == null)
            {
              ??? = null;
              label3270:
              if (??? != null) {
                break label3576;
              }
              localObject3 = null;
              label3278:
              localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
              kotlin.g.b.s.s(localObject5, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
            }
            for (;;)
            {
              synchronized ((Iterable)localObject5)
              {
                Iterator localIterator = ((Iterable)???).iterator();
                if (localIterator.hasNext())
                {
                  localObject5 = localIterator.next();
                  bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).mXL, (String)localObject3);
                  if (!bool) {
                    continue;
                  }
                  localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5;
                  if (localObject5 != null) {
                    break label3617;
                  }
                  ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
                  if (??? != null) {
                    break label3607;
                  }
                  ??? = null;
                  if (Util.isEqual((String)???, (String)localObject3)) {
                    break label3662;
                  }
                  Log.i(localb.TAG, kotlin.g.b.s.X("EVENT_ANCHOR_NOTIFY_CLOUD_MIXTURE_FOR_FINDER: can't find user info, userId:", localObject3));
                  paramInt = 0;
                  if (k < i) {
                    break label3762;
                  }
                  if (paramInt == 0) {
                    break label3755;
                  }
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.clear();
                  localObject3 = ((Iterable)???).iterator();
                  if (!((Iterator)localObject3).hasNext()) {
                    break label3728;
                  }
                  ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject3).next();
                  localObject5 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                  if (!com.tencent.mm.plugin.finder.live.utils.a.d((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???)) {
                    break label3678;
                  }
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).eyb();
                  localObject5 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
                  com.tencent.mm.plugin.finder.live.model.mic.b.awI(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).sessionId);
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).h((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???);
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).g((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???);
                  continue;
                  i = ((JSONArray)localObject6).length();
                  break;
                  ??? = ((JSONArray)localObject6).optJSONObject(j);
                  break label3270;
                  label3576:
                  localObject3 = ((JSONObject)???).optString("uId");
                  break label3278;
                }
                localObject5 = null;
              }
              label3607:
              ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL;
              continue;
              label3617:
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).EbD) {
                if (??? != null) {
                  break label3665;
                }
              }
              label3662:
              label3665:
              for (j = 0;; j = ((JSONObject)???).optInt("us"))
              {
                localObject3 = e.m.mLr;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).EbK = Boolean.valueOf(com.tencent.mm.ae.d.ee(j, e.m.bdz()));
                ((LinkedList)???).add(localObject5);
                break;
              }
              label3678:
              localObject5 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              if (com.tencent.mm.plugin.finder.live.utils.a.e((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???))
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).eyb();
                localObject5 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
                com.tencent.mm.plugin.finder.live.model.mic.b.awI(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).sessionId);
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).h((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???);
              }
            }
            label3728:
            localObject3 = localb.CCb;
            if (localObject3 != null) {
              a.notifyRoomPKMicUserChange$default((a)localObject3, ???, false, null, 6, null);
            }
            label3755:
            AppMethodBeat.o(358166);
            return;
            label3762:
            j = k;
          }
        }
        label3769:
        if (paramInt > i) {
          break label3786;
        }
        bool = true;
        break label2243;
        label3780:
        localObject3 = null;
      }
      label3786:
      bool = false;
    }
  }
  
  public final void onRandomMatchTimeout()
  {
    AppMethodBeat.i(358105);
    Log.i(this.TAG, kotlin.g.b.s.X("random match mic timeout, will auto cancel. curLinkState:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy)));
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy == 5)
    {
      bs localbs = localb.Ejm;
      if (localbs != null) {
        localbs.epp();
      }
      localb.ap((kotlin.g.a.b)new b.s(localb));
    }
    AppMethodBeat.o(358105);
  }
  
  public final void onRandomMicAccept(bdm parambdm, bdt parambdt)
  {
    AppMethodBeat.i(358079);
    kotlin.g.b.s.u(parambdm, "appMsg");
    kotlin.g.b.s.u(parambdt, "info");
    Log.i(this.TAG, kotlin.g.b.s.X("onRandomMicAccept info:", parambdt));
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    kotlin.g.b.s.u(parambdm, "appMsg");
    kotlin.g.b.s.u(parambdt, "info");
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.j localj = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    String str1 = parambdt.ZOj;
    Object localObject1 = parambdm.ZOb;
    Object localObject2;
    label101:
    Object localObject3;
    label115:
    String str2;
    int i;
    Object localObject4;
    label140:
    Object localObject5;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = parambdm.ZOb;
      if (localObject2 != null) {
        break label388;
      }
      localObject2 = null;
      localObject3 = parambdm.ZOb;
      if (localObject3 != null) {
        break label416;
      }
      localObject3 = null;
      str2 = parambdm.session_id;
      i = parambdt.ZOk;
      localObject4 = parambdm.ZOb;
      if (localObject4 != null) {
        break label444;
      }
      localObject4 = null;
      localObject5 = parambdm.ZOb;
      if (localObject5 != null) {
        break label472;
      }
      localObject5 = null;
    }
    for (;;)
    {
      parambdm = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, (String)localObject1, (String)localObject2, (String)localObject3, 2, str2, null, true, i, (FinderAuthInfo)localObject4, (String)localObject5, 0, 0, false, parambdt.ZOx, 0L, parambdm.ZOb, false, 899072);
      Log.i(localb.TAG, kotlin.g.b.s.X("onRandomMicAccept: accept anchor link mic pk. curPkUser:", parambdm));
      localObject1 = new bgh();
      localObject2 = new FinderContact();
      ((FinderContact)localObject2).username = parambdm.username;
      ((FinderContact)localObject2).nickname = parambdm.nickname;
      ((FinderContact)localObject2).headUrl = parambdm.headUrl;
      localObject3 = kotlin.ah.aiuX;
      ((bgh)localObject1).contact = ((FinderContact)localObject2);
      ((bgh)localObject1).ZOx = parambdm.EbH;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 2;
      localObject2 = localb.Ejm;
      if (localObject2 != null) {
        ((bs)localObject2).axi(parambdm.headUrl);
      }
      localObject2 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
      com.tencent.mm.plugin.finder.live.model.mic.b.enj();
      com.tencent.mm.ae.d.a(4000L, (kotlin.g.a.a)new b.t(localb, (bgh)localObject1, parambdm, parambdt));
      parambdt = kotlin.ah.aiuX;
      localj.Efv = parambdm;
      AppMethodBeat.o(358079);
      return;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).headUrl;
      break;
      label388:
      localObject2 = ((bgh)localObject2).contact;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label101;
      }
      localObject2 = ((FinderContact)localObject2).username;
      break label101;
      label416:
      localObject3 = ((bgh)localObject3).contact;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label115;
      }
      localObject3 = ((FinderContact)localObject3).nickname;
      break label115;
      label444:
      localObject4 = ((bgh)localObject4).contact;
      if (localObject4 == null)
      {
        localObject4 = null;
        break label140;
      }
      localObject4 = ((FinderContact)localObject4).authInfo;
      break label140;
      label472:
      localObject5 = ((bgh)localObject5).contact;
      if (localObject5 == null) {
        localObject5 = null;
      } else {
        localObject5 = ((FinderContact)localObject5).signature;
      }
    }
  }
  
  public final void onRandomMicApply(bem parambem)
  {
    AppMethodBeat.i(358062);
    kotlin.g.b.s.u(parambem, "info");
    Log.i(this.TAG, kotlin.g.b.s.X("onRandomMicApply info:", parambem));
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    kotlin.g.b.s.u(parambem, "info");
    bgh localbgh = parambem.ZOU;
    Object localObject2 = localb.TAG;
    Object localObject3 = new StringBuilder("onRandomMicApply: apply anchor link mic pk. toContact.username:");
    Object localObject1;
    if (localbgh == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", toContact.nickname:");
      if (localbgh != null) {
        break label346;
      }
      localObject1 = null;
      label96:
      Log.i((String)localObject2, localObject1);
      if (localbgh != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 2;
        localObject2 = localb.Ejm;
        if (localObject2 != null)
        {
          if (localbgh != null) {
            break label374;
          }
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      ((bs)localObject2).axi((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
      com.tencent.mm.plugin.finder.live.model.mic.b.enj();
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null)
      {
        long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
        l.k localk = l.k.mYO;
        ((ap)localObject1).a(l1, l2, (String)localObject2, (byte[])localObject3, l.k.bhG(), localbgh, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyG(), parambem.ZOn, (com.tencent.mm.plugin.finder.live.model.cgi.e.a)new b.u(localb, localbgh));
      }
      AppMethodBeat.o(358062);
      return;
      localObject1 = localbgh.contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label346:
      localObject1 = localbgh.contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label96;
      }
      localObject1 = ((FinderContact)localObject1).nickname;
      break label96;
      label374:
      localObject1 = localbgh.contact;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FinderContact)localObject1).headUrl;
      }
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(358112);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramp);
    AppMethodBeat.o(358112);
  }
  
  public final void release()
  {
    AppMethodBeat.i(358172);
    Log.i(this.TAG, "release");
    Object localObject = getLiveStartUIC();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject).checkMiniWindow();
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b)localObject).nmZ.stopTimer();
    localObject = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.bhj();
    localObject = al.CHU;
    al.eme();
    com.tencent.mm.kernel.h.baD().mCm.b(3582, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3917, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3861, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3603, (com.tencent.mm.am.h)this);
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eez == true))
      {
        i = 1;
        if (i != 0) {
          break label271;
        }
        localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.a(false, getMiniWinPermission(), null, getFinishActivityNotReleaseLive(), 5);
        localObject = getLiveCore();
        if (localObject == null) {
          break label266;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode())) {
          break label266;
        }
      }
    }
    label266:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (getMiniWinPermission()) || (getFinishActivityNotReleaseLive())) {
        break label279;
      }
      localObject = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
      com.tencent.mm.plugin.finder.live.model.mic.b.release();
      localObject = com.tencent.mm.live.model.p.mZf;
      com.tencent.mm.live.model.p.release();
      localObject = getLiveCore();
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.b)localObject).bci();
      }
      getLiveEndUIC().bkX();
      getBuContext().clear();
      AppMethodBeat.o(358172);
      return;
      i = 0;
      break;
    }
    label271:
    localObject = com.tencent.mm.live.core.core.a.b.mMo;
    com.tencent.mm.live.core.core.a.b.a.fF(true);
    label279:
    AppMethodBeat.o(358172);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(357837);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(357837);
  }
  
  public final void start()
  {
    AppMethodBeat.i(357962);
    super.start();
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b localb = getLiveStartUIC();
    com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b.b(localb);
    localb.startTimer();
    AppMethodBeat.o(357962);
  }
  
  public final void statusChange(com.tencent.mm.live.b.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(358023);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    Object localObject = getLivePrepareUIC();
    kotlin.g.b.s.u(paramc, "status");
    switch (com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      getLiveStartUIC().a(paramc, paramBundle);
      localObject = getLiveEndUIC();
      kotlin.g.b.s.u(paramc, "status");
      switch (com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a.a.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(358023);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).EjT;
      if (localObject == null) {
        break;
      }
      ((ad)localObject).tO(8);
      break;
      Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).TAG, "start live failed");
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()) {
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).EjT;
      if (localObject == null) {
        break;
      }
      ((ad)localObject).tO(8);
      break;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).EjT;
      if (localObject == null) {
        break;
      }
      ((ad)localObject).tO(8);
      break;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c)localObject).EjT;
      if (localObject == null) {
        break;
      }
      ((ad)localObject).tO(8);
      break;
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).EiK;
      if (paramc != null) {
        paramc.eoN();
      }
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL"))
      {
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.a(bool, (kotlin.g.a.s)new a.c((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject));
        }
        if (bool)
        {
          paramc = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramBundle = q.c.DrF;
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.putOpt("type", Integer.valueOf(q.i.DsM.type));
          localJSONObject.putOpt("result", Integer.valueOf(1));
          kotlin.ah localah = kotlin.ah.aiuX;
          paramc.a(paramBundle, localJSONObject.toString());
        }
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (paramc != null) {
          paramc.gt((Context)((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCa);
        }
        paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("live_status_flag", 0);
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.biU();
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).bkX();
        Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).TAG, kotlin.g.b.s.X("finish live is manual finish:", Boolean.valueOf(bool)));
        AppMethodBeat.o(358023);
        return;
      }
      paramc = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCa;
      label528:
      if ((paramc instanceof MMActivity))
      {
        paramc = (MMActivity)paramc;
        label492:
        if ((paramc == null) || (paramc.isFinishing() != true)) {
          break label600;
        }
        i = 1;
        label506:
        if (i == 0)
        {
          paramc = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCa;
          if (!(paramc instanceof MMActivity)) {
            break label605;
          }
          paramc = (MMActivity)paramc;
          if ((paramc == null) || (paramc.isDestroyed() != true)) {
            break label610;
          }
        }
      }
      label600:
      label605:
      label610:
      for (int i = 1; i != 0; i = 0)
      {
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.a(false, false, Boolean.FALSE, false, 11);
        paramc = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).ngB;
        if (paramc != null) {
          paramc.bci();
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).bkX();
        ((com.tencent.mm.plugin.finder.live.component.statecomponent.e)localObject).buContext.clear();
        AppMethodBeat.o(358023);
        return;
        paramc = null;
        break label492;
        i = 0;
        break label506;
        paramc = null;
        break label528;
      }
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).EiK;
      if (paramc != null) {
        paramc.tO(8);
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a)localObject).bkX();
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(357958);
    super.stop();
    getLiveStartUIC().checkMiniWindow();
    AppMethodBeat.o(357958);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.b
 * JD-Core Version:    0.7.0.1
 */