package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.extension.reddot.a.e;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.bc;
import com.tencent.mm.plugin.finder.live.ui.livepost.c.c;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.ui.FinderExposeUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI.a;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "BANNER_TYPE_CREATOR_ENTRANCE", "", "getBANNER_TYPE_CREATOR_ENTRANCE", "()J", "BANNER_TYPE_FAV", "getBANNER_TYPE_FAV", "BANNER_TYPE_FINDER_MSG", "getBANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "()V", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FOLLOW", "getBANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "getBANNER_TYPE_LIKE", "BANNER_TYPE_LIVE_INCOME", "getBANNER_TYPE_LIVE_INCOME", "BANNER_TYPE_WX_MSG", "getBANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "getBANNER_TYPE_WX_PRIVATE_MESSAGE", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "autoShow", "", "getAutoShow", "()Z", "setAutoShow", "(Z)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "dialogCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "(J)V", "finderCanPostNoContact", "Landroid/widget/TextView;", "finderLiveCanPostNoContact", "finderLivePosBtn", "Landroid/view/View;", "finderLivePostNewFeed", "finderPosBtn", "finderPostNewFeed", "finderRedPackEntrance", "hasExposeCreatorEntranceTips", "", "getHasExposeCreatorEntranceTips", "()Ljava/lang/String;", "setHasExposeCreatorEntranceTips", "(Ljava/lang/String;)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "setHasExposeFinderHiMsgTips", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeLiveEntranceTips", "getHasExposeLiveEntranceTips", "setHasExposeLiveEntranceTips", "hasExposeLiveIncomeEntranceTips", "getHasExposeLiveIncomeEntranceTips", "setHasExposeLiveIncomeEntranceTips", "hasExposeProfileEntranceTips", "getHasExposeProfileEntranceTips", "setHasExposeProfileEntranceTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "getHasReportFinderMsg", "setHasReportFinderMsg", "isEnableSendMsgEntrance", "isFromSnsPost", "isReportRedDotExpose", "lastFavTipsId", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "livePostUic", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "Lkotlin/Lazy;", "myFinderUsername", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkAutoShowPost", "checkTeenMode", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getEntranceType", "getLayoutId", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "initLiveRewardGainCell", "initPostBtn", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "plugin-finder_release"})
public final class ak
  extends UIComponent
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.api.h
{
  String AJE;
  private TextView BnA;
  private TextView BnB;
  private View BnC;
  private TextView BnD;
  private TextView BnE;
  private View BnF;
  final long BnG;
  final long BnH;
  final long BnI;
  final long BnJ;
  final long BnK;
  final long BnL;
  final long BnM;
  final long BnN;
  final long BnO;
  boolean BnP;
  private boolean BnQ;
  String BnR;
  String BnS;
  String BnT;
  String BnU;
  String BnV;
  String BnW;
  private boolean BnX;
  private final boolean BnY;
  private boolean BnZ;
  private String Bnw;
  private boolean Bnx;
  private com.tencent.mm.plugin.finder.live.ui.livepost.c Bny;
  private View Bnz;
  private String Boa;
  private ProgressBar progressBar;
  private ble wZz;
  long wzm;
  private HashMap<Integer, dna> xSN;
  private final kotlin.f zQr;
  private final int zdW;
  private final int zdX;
  
  public ak(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287413);
    this.xSN = new HashMap();
    this.BnG = 1L;
    this.BnH = 2L;
    this.BnI = 3L;
    this.BnJ = 4L;
    this.BnK = 5L;
    this.BnL = 8L;
    this.BnM = 9L;
    this.BnN = 6L;
    this.BnO = 7L;
    this.BnR = "";
    this.BnS = "";
    this.BnT = "";
    this.BnU = "";
    this.BnV = "";
    this.BnW = "";
    this.AJE = "";
    this.zdW = 10001;
    this.zdX = 10002;
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUP().aSr()).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.BnY = bool;
      this.zQr = kotlin.g.ar((kotlin.g.a.a)new af(this));
      this.Boa = "";
      AppMethodBeat.o(287413);
      return;
    }
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(287404);
    ch localch = new ch(8);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localch);
    AppMethodBeat.o(287404);
  }
  
  private final void dvZ()
  {
    AppMethodBeat.i(287410);
    Object localObject1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("post"))
    {
      AppMethodBeat.o(287410);
      return;
    }
    localObject1 = new StringBuilder();
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject1 = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
    int i = eli();
    Object localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.fE((Context)getActivity());
    localObject2 = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.av(i, false);
    localObject2 = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.aEb((String)localObject1);
    localObject2 = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.R(false, i);
    localObject2 = com.tencent.mm.ui.component.g.Xox;
    if (!((com.tencent.mm.plugin.finder.live.ui.post.d)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.live.ui.post.d.class)).a((kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this)))
    {
      AppMethodBeat.o(287410);
      return;
    }
    localObject2 = new com.tencent.mm.ui.widget.a.e((Context)getActivity(), 1, true);
    View localView = ad.kS((Context)getActivity()).inflate(b.g.finder_sheet_header, null);
    Object localObject5 = (TextView)localView.findViewById(b.f.nickname);
    Object localObject3 = (ImageView)localView.findViewById(b.f.avatar);
    Object localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject4 = d.a.aAK(com.tencent.mm.model.z.bdh());
    if (localObject4 != null)
    {
      p.j(localObject5, "nicknameTv");
      ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject4).getNickname()));
      localObject5 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject5 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject4 = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject4).field_avatarUrl);
      p.j(localObject3, "avatarIv");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject5).a(localObject4, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    }
    localObject3 = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.aEa((String)localObject1);
    ((com.tencent.mm.ui.widget.a.e)localObject2).Z(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.f)new k(this));
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.g)new l(this, (String)localObject1));
    ((com.tencent.mm.ui.widget.a.e)localObject2).b((com.tencent.mm.ui.widget.a.e.b)m.Boe);
    ((com.tencent.mm.ui.widget.a.e)localObject2).eik();
    AppMethodBeat.o(287410);
  }
  
  private final com.tencent.mm.plugin.finder.live.viewmodel.component.d ele()
  {
    AppMethodBeat.i(287394);
    com.tencent.mm.plugin.finder.live.viewmodel.component.d locald = (com.tencent.mm.plugin.finder.live.viewmodel.component.d)this.zQr.getValue();
    AppMethodBeat.o(287394);
    return locald;
  }
  
  private final void elf()
  {
    AppMethodBeat.i(287398);
    Object localObject1 = this.wZz;
    int i;
    boolean bool1;
    boolean bool2;
    long l;
    label86:
    boolean bool3;
    View localView;
    boolean bool4;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((ble)localObject1).SWk;
      bool1 = com.tencent.mm.ae.d.dr(i, 1);
      localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(localObject1, "MMKernel.service(ITeenModeService::class.java)");
      bool2 = ((com.tencent.mm.plugin.teenmode.a.b)localObject1).ZM();
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject1 = d.a.aAK(com.tencent.mm.model.z.bdh());
      if (localObject1 == null) {
        break label330;
      }
      l = ((com.tencent.mm.plugin.finder.api.i)localObject1).field_liveSwitchFlag;
      bool3 = com.tencent.mm.plugin.finder.live.utils.a.LI(l);
      localView = findViewById(b.f.live_income_ll);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      bool4 = com.tencent.mm.plugin.finder.utils.aj.edY();
      localObject1 = new StringBuilder("initLiveIncomeCell FinderLive.entrance,xLab enable live:");
      localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
      localObject2 = ((StringBuilder)localObject1).append(com.tencent.c.a.a.a.a.a.imJ()).append(", hasAccount:").append(bool4).append(", server flag:");
      localObject1 = this.wZz;
      if (localObject1 == null) {
        break label336;
      }
    }
    label330:
    label336:
    for (localObject1 = Integer.valueOf(((ble)localObject1).SWk);; localObject1 = null)
    {
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool1 + " rewardGainEnable:" + bool3);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.eej())
      {
        localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
        if ((!com.tencent.c.a.a.a.a.a.imJ()) && (!bool1)) {
          break label342;
        }
      }
      if ((!bool3) || (bool2) || (bool4)) {
        break label342;
      }
      p.j(localView, "liveIncomeGroup");
      localView.setVisibility(0);
      localView.setOnClickListener((View.OnClickListener)new n(this));
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drl(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new o(this));
      AppMethodBeat.o(287398);
      return;
      i = 0;
      break;
      l = 0L;
      break label86;
    }
    label342:
    p.j(localView, "liveIncomeGroup");
    localView.setVisibility(8);
    AppMethodBeat.o(287398);
  }
  
  private final void elg()
  {
    AppMethodBeat.i(287399);
    Object localObject1 = this.wZz;
    int i;
    if (localObject1 != null)
    {
      i = ((ble)localObject1).SWk;
      boolean bool = com.tencent.mm.ae.d.dr(i, 1);
      localObject1 = new StringBuilder("FinderLive.entrance,xLab enable live:");
      Object localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
      localObject2 = ((StringBuilder)localObject1).append(com.tencent.c.a.a.a.a.a.imJ()).append(", server flag:");
      localObject1 = this.wZz;
      if (localObject1 == null) {
        break label464;
      }
      localObject1 = Integer.valueOf(((ble)localObject1).SWk);
      label74:
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.eej())
      {
        localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
        if ((!com.tencent.c.a.a.a.a.a.imJ()) && (!bool)) {
          break label469;
        }
      }
      localObject1 = findViewById(b.f.postBtn_new);
      p.j(localObject1, "findViewById<View>(R.id.postBtn_new)");
      this.Bnz = ((View)localObject1);
      localObject1 = findViewById(b.f.finder_post_new_feed_new);
      p.j(localObject1, "findViewById(R.id.finder_post_new_feed_new)");
      this.BnA = ((TextView)localObject1);
      localObject1 = findViewById(b.f.finder_can_post_no_contact_new);
      p.j(localObject1, "findViewById(R.id.finder_can_post_no_contact_new)");
      this.BnB = ((TextView)localObject1);
      this.BnC = findViewById(b.f.livePostBtn);
      this.BnD = ((TextView)findViewById(b.f.finder_live_post_new_feed));
      this.BnE = ((TextView)findViewById(b.f.finder_can_post_live_no_contact));
      localObject1 = findViewById(b.f.postBtn);
      p.j(localObject1, "findViewById<View>(R.id.postBtn)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(b.f.post_container_new);
      p.j(localObject1, "findViewById<View>(R.id.post_container_new)");
      ((View)localObject1).setVisibility(0);
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().aBe("FinderSelfLiveEntrance");
      localObject2 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)localObject2).getRedDotManager().aBf("FinderSelfLiveEntrance");
      Object localObject3 = this.BnC;
      if (localObject3 != null) {
        ((View)localObject3).setOnClickListener((View.OnClickListener)new p(this, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1));
      }
      localObject3 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject3 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drc(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new q(this, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1));
    }
    for (;;)
    {
      localObject1 = this.Bnz;
      if (localObject1 == null) {
        p.bGy("finderPosBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new r(this));
      this.BnF = findViewById(b.f.red_pack);
      localObject1 = this.BnF;
      if (localObject1 == null) {
        break label579;
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(287399);
      return;
      i = 0;
      break;
      label464:
      localObject1 = null;
      break label74;
      label469:
      localObject1 = findViewById(b.f.postBtn);
      p.j(localObject1, "findViewById<View>(R.id.postBtn)");
      this.Bnz = ((View)localObject1);
      localObject1 = findViewById(b.f.finder_post_new_feed);
      p.j(localObject1, "findViewById(R.id.finder_post_new_feed)");
      this.BnA = ((TextView)localObject1);
      localObject1 = findViewById(b.f.finder_can_post_no_contact);
      p.j(localObject1, "findViewById(R.id.finder_can_post_no_contact)");
      this.BnB = ((TextView)localObject1);
      localObject1 = findViewById(b.f.postBtn);
      p.j(localObject1, "findViewById<View>(R.id.postBtn)");
      ((View)localObject1).setVisibility(0);
      localObject1 = findViewById(b.f.post_container_new);
      p.j(localObject1, "findViewById<View>(R.id.post_container_new)");
      ((View)localObject1).setVisibility(8);
    }
    label579:
    AppMethodBeat.o(287399);
  }
  
  private final void elh()
  {
    AppMethodBeat.i(287401);
    this.Bnw = com.tencent.mm.model.z.bdh();
    Log.i("SimpleUIComponent", "myFinderUser " + this.Bnw);
    elf();
    elg();
    Object localObject2 = findViewById(b.f.has_contact_container);
    Object localObject1 = findViewById(b.f.no_contact_container);
    Object localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    switch (com.tencent.mm.plugin.finder.utils.aj.eei())
    {
    default: 
      Log.d("SimpleUIComponent", "not one of six state");
      localObject1 = this.wZz;
      if (localObject1 != null)
      {
        if (((ble)localObject1).SWf > 0)
        {
          localObject2 = findViewById(b.f.like_feed_count);
          p.j(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
          ((TextView)localObject2).setText((CharSequence)m.QG(((ble)localObject1).SWf));
          localObject2 = findViewById(b.f.like_feed_count);
          p.j(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
          ((TextView)localObject2).setVisibility(0);
          label198:
          if (((ble)localObject1).SWg <= 0) {
            break label1957;
          }
          localObject2 = findViewById(b.f.fav_feed_count);
          p.j(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
          ((TextView)localObject2).setText((CharSequence)m.QG(((ble)localObject1).SWg));
          localObject2 = findViewById(b.f.fav_feed_count);
          p.j(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
          ((TextView)localObject2).setVisibility(0);
          label266:
          Log.i("SimpleUIComponent", "likeCount = " + ((ble)localObject1).SWf + ",favCount = " + ((ble)localObject1).SWg);
        }
      }
      else
      {
        localObject1 = this.BnA;
        if (localObject1 == null) {
          p.bGy("finderPostNewFeed");
        }
        ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = this.BnD;
        if (localObject1 == null) {
          break label1987;
        }
      }
      break;
    }
    label1957:
    label1987:
    for (localObject1 = ((TextView)localObject1).getPaint();; localObject1 = null)
    {
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = findViewById(b.f.finder_self_account_state);
      p.j(localObject1, "findViewById<View>(R.id.finder_self_account_state)");
      ((View)localObject1).setVisibility(0);
      localObject1 = getIntent();
      localObject2 = FinderSelfUI.Avb;
      if (((Intent)localObject1).getBooleanExtra(FinderSelfUI.eaV(), false))
      {
        localObject1 = this.Bnz;
        if (localObject1 == null) {
          p.bGy("finderPosBtn");
        }
        if (localObject1 != null) {
          ((View)localObject1).post((Runnable)new al((View)localObject1));
        }
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.Avb;
        ((Intent)localObject1).removeExtra(FinderSelfUI.eaV());
      }
      Log.i("SimpleUIComponent", "[checkAutoShowPost] autoShow" + this.BnZ);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      int i = com.tencent.mm.plugin.finder.utils.aj.eei();
      if ((!this.BnZ) || ((i != 3) && (i != 6))) {
        break label1992;
      }
      dvZ();
      Log.i("SimpleUIComponent", "[checkAutoShowPost] has autoShow post bottom sheet ,set false");
      this.BnZ = false;
      AppMethodBeat.o(287401);
      return;
      p.j(localObject2, "hasContactContainer");
      p.j(localObject1, "noContactContainer");
      p.k(localObject2, "hasContactContainer");
      p.k(localObject1, "noContactContainer");
      localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      boolean bool = com.tencent.mm.plugin.finder.utils.aj.eeu();
      Log.d("SimpleUIComponent", "账户无发表权限,isForeign:".concat(String.valueOf(bool)));
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(8);
      if (!bool) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dXM().aSr()).intValue() != 0) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)getActivity().getString(b.j.finder_oversea_no_quality_tips));
      break;
      p.j(localObject2, "hasContactContainer");
      p.j(localObject1, "noContactContainer");
      p.k(localObject2, "hasContactContainer");
      p.k(localObject1, "noContactContainer");
      localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      bool = com.tencent.mm.plugin.finder.utils.aj.eeu();
      Log.d("SimpleUIComponent", "有发表权限但未创建账号,isForign = ".concat(String.valueOf(bool)));
      if (bool)
      {
        localObject3 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXM().aSr()).intValue() == 0)
        {
          ((View)localObject1).setVisibility(0);
          ((View)localObject2).setVisibility(8);
          ((TextView)localObject1).setText((CharSequence)getActivity().getString(b.j.finder_oversea_no_quality_tips));
          break;
        }
      }
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      localObject1 = findViewById(b.f.msg_ll);
      p.j(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(b.f.finder_account_area);
      p.j(localObject1, "findViewById<View>(R.id.finder_account_area)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(b.f.sendMsgLayout);
      p.j(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(b.f.finder_poster_entrance);
      p.j(localObject1, "findViewById<View>(R.id.finder_poster_entrance)");
      ((View)localObject1).setVisibility(8);
      localObject1 = new aa.a();
      localObject2 = getIntent();
      localObject3 = FinderSelfUI.Avb;
      ((aa.a)localObject1).aaBx = ((Intent)localObject2).getBooleanExtra(FinderSelfUI.eaV(), false);
      localObject2 = this.Bnz;
      if (localObject2 == null) {
        p.bGy("finderPosBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new c(this, (aa.a)localObject1));
      if ((((aa.a)localObject1).aaBx) && (this.wZz != null))
      {
        localObject1 = this.Bnz;
        if (localObject1 == null) {
          p.bGy("finderPosBtn");
        }
        ((View)localObject1).post((Runnable)new d(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.Avb;
        ((Intent)localObject1).removeExtra(FinderSelfUI.eaV());
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqP(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new e(this));
      localObject1 = this.BnC;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dre(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new f(this));
      break;
      p.j(localObject2, "hasContactContainer");
      p.j(localObject1, "noContactContainer");
      l((View)localObject2, (View)localObject1);
      break;
      p.j(localObject2, "hasContactContainer");
      p.j(localObject1, "noContactContainer");
      p.k(localObject2, "hasContactContainer");
      p.k(localObject1, "noContactContainer");
      Log.d("SimpleUIComponent", "账户封禁");
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      localObject1 = findViewById(b.f.msg_ll);
      p.j(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(b.f.finder_poster_entrance);
      p.j(localObject1, "findViewById<View>(R.id.finder_poster_entrance)");
      ((View)localObject1).setVisibility(8);
      localObject1 = this.Bnz;
      if (localObject1 == null) {
        p.bGy("finderPosBtn");
      }
      ((View)localObject1).setVisibility(8);
      localObject1 = this.BnC;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject2 = new com.tencent.mm.plugin.finder.loader.e("");
      localObject3 = findViewById(b.f.finder_avatar_iv);
      p.j(localObject3, "findViewById<ImageView>(R.id.finder_avatar_iv)");
      localObject3 = (ImageView)localObject3;
      Object localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = findViewById(b.f.finder_nick_tv);
      p.j(localObject1, "findViewById<TextView>(R.id.finder_nick_tv)");
      ((TextView)localObject1).setText((CharSequence)getResources().getString(b.j.finder_account_forbid));
      localObject1 = findViewById(b.f.finder_self_msg_tv);
      p.j(localObject1, "findViewById<View>(R.id.finder_self_msg_tv)");
      ((View)localObject1).setVisibility(0);
      findViewById(b.f.finder_account_area).setOnClickListener((View.OnClickListener)new a(this));
      localObject1 = getIntent();
      localObject2 = FinderSelfUI.Avb;
      if (((Intent)localObject1).getBooleanExtra(FinderSelfUI.eaV(), false))
      {
        findViewById(b.f.finder_account_area).post((Runnable)new b(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.Avb;
        ((Intent)localObject1).removeExtra(FinderSelfUI.eaV());
      }
      localObject1 = findViewById(b.f.sendMsgLayout);
      p.j(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject1).setVisibility(8);
      break;
      p.j(localObject2, "hasContactContainer");
      p.j(localObject1, "noContactContainer");
      p.k(localObject2, "hasContactContainer");
      p.k(localObject1, "noContactContainer");
      Log.d("SimpleUIComponent", "账户审核中");
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      ImageView localImageView = (ImageView)findViewById(b.f.finder_avatar_iv);
      localObject3 = (TextView)findViewById(b.f.finder_nick_tv);
      localObject4 = (TextView)findViewById(b.f.finder_state_tv);
      localObject1 = findViewById(b.f.msg_ll);
      p.j(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = this.Bnz;
      if (localObject1 == null) {
        p.bGy("finderPosBtn");
      }
      ((View)localObject1).setVisibility(8);
      localObject1 = this.BnC;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = findViewById(b.f.finder_poster_entrance);
      p.j(localObject1, "findViewById<View>(R.id.finder_poster_entrance)");
      ((View)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      com.tencent.mm.loader.d locald = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject1 = this.wZz;
      if (localObject1 != null)
      {
        localObject1 = ((ble)localObject1).verifyInfo;
        if (localObject1 != null)
        {
          localObject2 = ((bfm)localObject1).nfY;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1647;
          }
        }
      }
      localObject1 = "";
      label1647:
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1, u.AlO);
      p.j(localImageView, "finderAvatar");
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      locald.a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      p.j(localObject3, "finderNickname");
      localObject2 = (Context)getActivity();
      localObject1 = this.wZz;
      if (localObject1 != null)
      {
        localObject1 = ((ble)localObject1).verifyInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bfm)localObject1).SQh;; localObject1 = null)
      {
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1));
        ar.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
        p.j(localObject4, "finderState");
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText((CharSequence)getResources().getString(b.j.finder_self_contact_reviewing));
        localObject1 = findViewById(b.f.msg_ll);
        p.j(localObject1, "findViewById<View>(R.id.msg_ll)");
        ((View)localObject1).setVisibility(8);
        findViewById(b.f.finder_account_area).setOnClickListener((View.OnClickListener)new g(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.Avb;
        if ((((Intent)localObject1).getBooleanExtra(FinderSelfUI.eaV(), false)) && (this.wZz != null))
        {
          findViewById(b.f.finder_account_area).post((Runnable)new h(this));
          localObject1 = getIntent();
          localObject2 = FinderSelfUI.Avb;
          ((Intent)localObject1).removeExtra(FinderSelfUI.eaV());
        }
        localObject1 = findViewById(b.f.sendMsgLayout);
        p.j(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
        ((View)localObject1).setVisibility(8);
        break;
      }
      localObject2 = findViewById(b.f.like_feed_count);
      p.j(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
      ((TextView)localObject2).setVisibility(8);
      break label198;
      localObject2 = findViewById(b.f.fav_feed_count);
      p.j(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
      ((TextView)localObject2).setVisibility(8);
      break label266;
    }
    label1992:
    Log.i("SimpleUIComponent", "[checkAutoShowPost] not autoShow");
    AppMethodBeat.o(287401);
  }
  
  private final int eli()
  {
    AppMethodBeat.i(287409);
    com.tencent.mm.plugin.finder.activity.b localb = com.tencent.mm.plugin.finder.activity.b.wWK;
    if (!com.tencent.mm.plugin.finder.activity.b.b(null, 5))
    {
      if (this.BnX)
      {
        AppMethodBeat.o(287409);
        return 4;
      }
      AppMethodBeat.o(287409);
      return 3;
    }
    AppMethodBeat.o(287409);
    return 9;
  }
  
  private final void elj()
  {
    AppMethodBeat.i(287411);
    Object localObject1 = n.zWF;
    n.a((Context)getActivity(), this.wzm, this.BnP, 1L, this.BnG, false);
    localObject1 = n.zWF;
    localObject1 = (Context)getActivity();
    long l2 = this.wzm;
    boolean bool1 = this.BnP;
    long l3 = this.BnH;
    Object localObject2 = this.wZz;
    long l1;
    label149:
    label239:
    int i;
    if (localObject2 != null)
    {
      l1 = ((ble)localObject2).SWf;
      n.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = n.zWF;
      localObject1 = (Context)getActivity();
      l2 = this.wzm;
      bool1 = this.BnP;
      l3 = this.BnI;
      localObject2 = this.wZz;
      if (localObject2 == null) {
        break label523;
      }
      l1 = ((ble)localObject2).SWg;
      n.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = n.zWF;
      n.a((Context)getActivity(), this.wzm, this.BnP, 1L, this.BnJ, false);
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().aBf("finder_private_msg_entrance");
      if (localObject1 == null) {
        break label528;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).aBy("finder_private_msg_entrance");
      localObject2 = n.zWF;
      localObject2 = (Context)getActivity();
      l1 = this.wzm;
      boolean bool2 = this.BnP;
      l2 = this.BnN;
      if (localObject1 == null) {
        break label534;
      }
      bool1 = true;
      label278:
      if (localObject1 == null) {
        break label540;
      }
      i = ((bkn)localObject1).count;
      label289:
      n.a((Context)localObject2, l1, bool2, 1L, l2, bool1, i);
      l1 = elk();
      localObject1 = n.zWF;
      localObject1 = (Context)getActivity();
      l2 = this.wzm;
      bool2 = this.BnP;
      l3 = this.BnO;
      if (l1 <= 0L) {
        break label545;
      }
      bool1 = true;
      label349:
      n.a((Context)localObject1, l2, bool2, 1L, l3, bool1, l1);
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().aBe("CreatorCenter");
      localObject2 = n.zWF;
      localObject2 = (Context)getActivity();
      l1 = this.wzm;
      bool2 = this.BnP;
      l2 = this.BnL;
      if (localObject1 == null) {
        break label551;
      }
      bool1 = true;
      label435:
      n.a((Context)localObject2, l1, bool2, 1L, l2, bool1);
      localObject1 = findViewById(b.f.live_income_ll);
      p.j(localObject1, "it");
      if (((View)localObject1).getVisibility() != 0) {
        break label557;
      }
      i = 1;
      label475:
      if (i == 0) {
        break label562;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = n.zWF;
        n.a((Context)getActivity(), this.wzm, false, 1L, this.BnM, false, 0L);
      }
      AppMethodBeat.o(287411);
      return;
      l1 = 0L;
      break;
      label523:
      l1 = 0L;
      break label149;
      label528:
      localObject1 = null;
      break label239;
      label534:
      bool1 = false;
      break label278;
      label540:
      i = 0;
      break label289;
      label545:
      bool1 = false;
      break label349;
      label551:
      bool1 = false;
      break label435;
      label557:
      i = 0;
      break label475;
      label562:
      localObject1 = null;
    }
  }
  
  private static long elk()
  {
    AppMethodBeat.i(287412);
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().aBe("finder_wx_private_msg_entrance");
    if (localObject != null)
    {
      long l = ((bkn)localObject).count;
      AppMethodBeat.o(287412);
      return l;
    }
    AppMethodBeat.o(287412);
    return 0L;
  }
  
  private void l(final View paramView1, View paramView2)
  {
    AppMethodBeat.i(287402);
    p.k(paramView1, "hasContactContainer");
    p.k(paramView2, "noContactContainer");
    Log.d("SimpleUIComponent", "账户正常");
    Object localObject1 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
    p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
    ((com.tencent.mm.plugin.findersdk.a.ak)localObject1).getRedDotManager().aBd("TLCamera");
    paramView2.setVisibility(8);
    paramView1.setVisibility(0);
    Object localObject2 = findViewById(b.f.finder_account_area);
    paramView2 = findViewById(b.f.msg_ll);
    Object localObject3 = findViewById(b.f.finder_poster_entrance);
    Object localObject4 = (ImageView)findViewById(b.f.finder_avatar_iv);
    TextView localTextView = (TextView)findViewById(b.f.finder_nick_tv);
    localObject1 = (TextView)findViewById(b.f.finder_msg_tv);
    Object localObject5 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject5 = this.Bnw;
    if (localObject5 == null) {
      p.iCn();
    }
    localObject5 = d.a.aAK((String)localObject5);
    ImageView localImageView = (ImageView)findViewById(b.f.auth_icon);
    Object localObject6;
    int i;
    label443:
    int k;
    final int j;
    label723:
    boolean bool1;
    if (this.BnY)
    {
      localObject6 = findViewById(b.f.sendMsgLayout);
      p.j(localObject6, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject6).setVisibility(0);
      if (localObject5 != null)
      {
        localObject6 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject6 = com.tencent.mm.plugin.finder.loader.t.dJh();
        com.tencent.mm.plugin.finder.loader.e locale = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject5).Mm(), u.AlO);
        p.j(localObject4, "finderAvatar");
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject6).a(locale, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        p.j(localTextView, "finderNickname");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject5).getNickname()));
        ar.a((Paint)localTextView.getPaint(), 0.8F);
        localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        p.j(localImageView, "authIcon");
        com.tencent.mm.plugin.finder.utils.aj.a(localImageView, ((com.tencent.mm.plugin.finder.api.i)localObject5).field_authInfo);
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        i = ((com.tencent.mm.kernel.f)localObject4).aHp().getInt(ar.a.VAx, 0);
        if (i <= 0) {
          break label1281;
        }
        localObject4 = findViewById(b.f.finder_follow_count);
        p.j(localObject4, "findViewById<View>(R.id.finder_follow_count)");
        ((View)localObject4).setVisibility(0);
        localObject4 = findViewById(b.f.finder_follow_count);
        p.j(localObject4, "findViewById<TextView>(R.id.finder_follow_count)");
        ((TextView)localObject4).setText((CharSequence)getActivity().getResources().getString(b.j.finder_fans, new Object[] { String.valueOf(i) }));
      }
      p.j(localObject2, "finderAccountArea");
      ((View)localObject2).setVisibility(0);
      p.j(paramView2, "finderMsgArea");
      paramView2.setVisibility(0);
      p.j(localObject3, "finderPosterEntrance");
      ((View)localObject3).setVisibility(0);
      localObject4 = com.tencent.mm.plugin.finder.utils.x.AEe;
      com.tencent.mm.plugin.finder.utils.x.a((ViewGroup)localObject3, (androidx.lifecycle.l)getActivity());
      localObject3 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      localObject3 = i.a.drx();
      i = localObject3[0];
      k = localObject3[1];
      int m = localObject3[2];
      j = localObject3[3];
      Log.i("SimpleUIComponent", "redDot check likeCount :" + i + " commentCount " + k + " followCount " + m + ' ');
      ((View)localObject2).setOnClickListener((View.OnClickListener)new ah(this));
      localObject2 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)localObject2).getRedDotManager().aBf("AuthorProfileNotify");
      localObject3 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
      localObject3 = ((PluginFinder)localObject3).getRedDotManager().aBe("AuthorProfileNotify");
      paramView2.setOnClickListener((View.OnClickListener)new ai(this, j, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject3));
      if (j <= 0) {
        break label1336;
      }
      p.j(localObject1, "finderMsg");
      ((TextView)localObject1).setVisibility(0);
      if (j <= 999) {
        break label1308;
      }
      paramView2 = (CharSequence)"· · ·";
      ((TextView)localObject1).setText(paramView2);
      ((TextView)localObject1).setBackgroundResource(com.tencent.mm.ui.tools.w.bj((Context)getContext(), j));
      float f = com.tencent.mm.ci.a.aZ((Context)getActivity(), b.d.unReadCountTextSize);
      ((TextView)localObject1).setTextSize(0, com.tencent.mm.ci.a.km((Context)getActivity()) * f);
      if (!this.Bnx)
      {
        this.Bnx = true;
        paramView2 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
          break label1320;
        }
        i = 0;
        label814:
        if (j > 0)
        {
          paramView2 = n.zWF;
          paramView2 = aj.Bnu;
          paramView2 = aj.a.fZ((Context)getActivity());
          if (paramView2 == null) {
            break label1326;
          }
          paramView2 = paramView2.ekY();
          label847:
          n.a("4", 1, 1, 5, i, j, null, null, 0L, paramView2, 0, 0, 3520);
        }
        if ((localObject2 != null) && (localObject3 != null))
        {
          paramView2 = com.tencent.mm.plugin.finder.report.l.zWx;
          paramView2 = aj.Bnu;
          paramView2 = aj.a.fZ((Context)getActivity());
          if (paramView2 == null) {
            break label1331;
          }
          paramView2 = paramView2.ekY();
          label907:
          com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject3, 1, paramView2, 0, 0, null, 224);
        }
      }
      label925:
      paramView2 = this.Bnz;
      if (paramView2 == null) {
        p.bGy("finderPosBtn");
      }
      paramView2.setOnClickListener((View.OnClickListener)new aj(this));
      paramView2 = this.Bnz;
      if (paramView2 == null) {
        p.bGy("finderPosBtn");
      }
      paramView2.setVisibility(0);
      paramView2 = this.BnC;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = getIntent();
      localObject1 = FinderSelfUI.Avb;
      if (paramView2.getBooleanExtra(FinderSelfUI.eaV(), false))
      {
        paramView2 = this.Bnz;
        if (paramView2 == null) {
          p.bGy("finderPosBtn");
        }
        paramView2.post((Runnable)new ak(this));
        paramView2 = getIntent();
        localObject1 = FinderSelfUI.Avb;
        paramView2.removeExtra(FinderSelfUI.eaV());
      }
      if (!this.BnQ)
      {
        paramView2 = n.zWF;
        paramView2 = (Context)getActivity();
        long l1 = this.wzm;
        boolean bool2 = this.BnP;
        long l2 = this.BnK;
        if (j <= 0) {
          break label1354;
        }
        bool1 = true;
        label1103:
        n.a(paramView2, l1, bool2, 1L, l2, bool1, j);
        this.BnQ = true;
      }
      Log.i("SimpleUIComponent", "show finder msg red, totalCount:".concat(String.valueOf(j)));
      localObject1 = this.Bnw;
      if (localObject1 == null) {
        break label1472;
      }
      paramView2 = (TextView)findViewById(b.f.finder_self_state_txt);
      localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject1 = d.a.aAP((String)localObject1);
      if (localObject1 == null) {
        break label1465;
      }
      if (((d.a.a)localObject1).wZR != 1) {
        break label1435;
      }
      i = 0;
      j = ((LinearLayout)paramView1).getChildCount();
      label1201:
      if (i >= j) {
        break label1399;
      }
      localObject1 = ((LinearLayout)paramView1).getChildAt(i);
      if (localObject1 != null)
      {
        k = ((View)localObject1).getId();
        if (k != b.f.finder_account_area) {
          break label1360;
        }
        ((View)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      i += 1;
      break label1201;
      localObject6 = findViewById(b.f.sendMsgLayout);
      p.j(localObject6, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject6).setVisibility(8);
      break;
      label1281:
      localObject4 = findViewById(b.f.finder_follow_count);
      p.j(localObject4, "findViewById<View>(R.id.finder_follow_count)");
      ((View)localObject4).setVisibility(8);
      break label443;
      label1308:
      paramView2 = (CharSequence)String.valueOf(j);
      break label723;
      label1320:
      i = 2;
      break label814;
      label1326:
      paramView2 = null;
      break label847;
      label1331:
      paramView2 = null;
      break label907;
      label1336:
      p.j(localObject1, "finderMsg");
      ((TextView)localObject1).setVisibility(8);
      break label925;
      label1354:
      bool1 = false;
      break label1103;
      label1360:
      if (k == b.f.post_container_new) {
        ((View)localObject1).setVisibility(8);
      } else {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new ag(paramView2, this, paramView1));
      }
    }
    label1399:
    p.j(paramView2, "finderState");
    paramView2.setVisibility(0);
    paramView2.setText((CharSequence)getActivity().getString(b.j.finder_account_in_logout_status_in_selfui));
    AppMethodBeat.o(287402);
    return;
    label1435:
    p.j(paramView2, "finderState");
    paramView2.setText((CharSequence)"");
    paramView2.setVisibility(8);
    AppMethodBeat.o(287402);
    return;
    label1465:
    AppMethodBeat.o(287402);
    return;
    label1472:
    AppMethodBeat.o(287402);
  }
  
  public final void a(aqt paramaqt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287406);
    p.k(paramaqt, "cmdItem");
    Log.i("SimpleUIComponent", "cmdId " + paramaqt.cmdId);
    switch (paramaqt.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287406);
      return;
      elh();
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_self_pref;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(287396);
    boolean bool1;
    if (paramIntent != null)
    {
      FinderSelfUI.a locala = FinderSelfUI.Avb;
      paramInt2 = paramIntent.getIntExtra(FinderSelfUI.eaT(), 0);
      paramIntent = FinderSelfUI.Avb;
      if (paramInt1 != FinderSelfUI.eaR()) {
        break label140;
      }
      paramIntent = this.wZz;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.SWg == paramInt2) {
          bool1 = true;
        }
      }
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      if ((!bool2) || (!bool1))
      {
        Log.i("SimpleUIComponent", "ifFavCountEquals = " + bool2 + ",ifLikeCountEquals = " + bool1);
        doPrepareUser();
      }
      AppMethodBeat.o(287396);
      return;
      paramInt2 = 0;
      break;
      label140:
      paramIntent = FinderSelfUI.Avb;
      if (paramInt1 == FinderSelfUI.eaS())
      {
        paramIntent = this.wZz;
        bool1 = bool3;
        if (paramIntent != null)
        {
          bool1 = bool3;
          if (paramIntent.SWf == paramInt2) {
            bool1 = true;
          }
        }
        bool2 = true;
      }
      else
      {
        bool1 = true;
        bool2 = true;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287395);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject1 = FinderSelfUI.Avb;
    this.BnP = paramBundle.getBooleanExtra(FinderSelfUI.eaU(), false);
    this.wzm = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
    p.j(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((com.tencent.mm.plugin.findersdk.a.ak)paramBundle).getRedDotManager().aBd("TLPersonalCenter");
    paramBundle = findViewById(b.f.jump_finder_follow);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new s(this));
    }
    paramBundle = findViewById(b.f.jump_finder_liked);
    localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (!((ae)localObject1).dYT())
    {
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new x(this));
      }
    }
    paramBundle = findViewById(b.f.jump_finder_fav);
    localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (!((ae)localObject1).dYT())
    {
      p.j(paramBundle, "jumpFav");
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener((View.OnClickListener)new y(this));
    }
    label529:
    Object localObject2;
    label647:
    int i;
    if (this.BnY)
    {
      paramBundle = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)paramBundle).dYT())
      {
        paramBundle = findViewById(b.f.jump_finder_private_msg);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = findViewById(b.f.jump_finder_private_msg);
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new z(this));
        }
        paramBundle = findViewById(b.f.loading_progress_bar);
        p.j(paramBundle, "findViewById(R.id.loading_progress_bar)");
        this.progressBar = ((ProgressBar)paramBundle);
        findViewById(b.f.jump_finder_wxmsg).setOnClickListener((View.OnClickListener)new aa(this));
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqW(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new ab(this));
        paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        paramBundle = ((PluginFinder)paramBundle).getRedDotManager().xsM;
        paramBundle.handler.post((Runnable)new a.e(paramBundle));
        if (!this.BnY) {
          break label1171;
        }
        findViewById(b.f.sendMsgLayout).setOnClickListener((View.OnClickListener)new ac(this));
        paramBundle = findViewById(b.f.sendMsgLayout);
        p.j(paramBundle, "findViewById<View>(R.id.sendMsgLayout)");
        paramBundle.setVisibility(0);
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqZ(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new ad(this));
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dra(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new ae(this));
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqQ(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new t(this));
        findViewById(b.f.jump_finder_management).setOnClickListener((View.OnClickListener)new u(this));
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drd(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new v(this));
        localObject2 = new aa.f();
        paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dWP().aSr()).intValue() != 2) {
          break label1195;
        }
        paramBundle = "https://channels.weixin.qq.com/mobile/creator_center.html";
        ((aa.f)localObject2).aaBC = paramBundle;
        paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.eej()) {
          com.tencent.mm.ui.base.w.makeText((Context)getContext(), (CharSequence)("creater url:" + (String)((aa.f)localObject2).aaBC), 1).show();
        }
        if (((CharSequence)((aa.f)localObject2).aaBC).length() <= 0) {
          break label1249;
        }
        i = 1;
        label725:
        if (i == 0) {
          break label1254;
        }
        paramBundle = findViewById(b.f.finder_poster_service_entrance);
        p.j(paramBundle, "findViewById<View>(R.id.…_poster_service_entrance)");
        paramBundle.setVisibility(0);
        findViewById(b.f.finder_poster_service_entrance).setOnClickListener((View.OnClickListener)new w(this, (aa.f)localObject2));
        label772:
        elg();
        elf();
        paramBundle = com.tencent.mm.kernel.h.ae(ae.class);
        p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ae)paramBundle).dYT())
        {
          paramBundle = findViewById(b.f.jump_finder_wxmsg);
          p.j(paramBundle, "findViewById<View>(R.id.jump_finder_wxmsg)");
          paramBundle.setVisibility(8);
          paramBundle = findViewById(b.f.finder_self_footer_root);
          p.j(paramBundle, "findViewById<View>(R.id.finder_self_footer_root)");
          paramBundle.setVisibility(8);
          paramBundle = findViewById(b.f.jump_finder_management);
          p.j(paramBundle, "findViewById<View>(R.id.jump_finder_management)");
          paramBundle.setVisibility(8);
        }
        ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.h)this);
        com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
        paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().aBe("TLCamera");
        paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().aBf("TLCamera");
        paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
            break label1281;
          }
          i = 0;
          label997:
          paramBundle = n.zWF;
          paramBundle = aj.Bnu;
          paramBundle = aj.a.fZ((Context)getActivity());
          if (paramBundle == null) {
            break label1286;
          }
          paramBundle = paramBundle.ekY();
          label1025:
          n.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
          paramBundle = com.tencent.mm.plugin.finder.report.l.zWx;
          paramBundle = aj.Bnu;
          paramBundle = aj.a.fZ((Context)getActivity());
          if (paramBundle == null) {
            break label1291;
          }
        }
      }
    }
    label1281:
    label1286:
    label1291:
    for (paramBundle = paramBundle.ekY();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1, 1, paramBundle, 0, 0, null, 224);
      paramBundle = getIntent();
      localObject1 = FinderSelfUI.Avb;
      this.BnX = paramBundle.getBooleanExtra(FinderSelfUI.eaV(), false);
      this.Bny = ele().dGx();
      paramBundle = getIntent();
      localObject1 = FinderSelfUI.Avb;
      this.BnZ = paramBundle.getBooleanExtra(FinderSelfUI.eaW(), false);
      AppMethodBeat.o(287395);
      return;
      paramBundle = findViewById(b.f.jump_finder_private_msg);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label1171:
      paramBundle = findViewById(b.f.sendMsgLayout);
      p.j(paramBundle, "findViewById<View>(R.id.sendMsgLayout)");
      paramBundle.setVisibility(8);
      break label529;
      label1195:
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWP().aSr()).intValue() == 1)
      {
        paramBundle = "https://finder-assistant-0.sparta.html5.qq.com/mobile/creator_center.html";
        break label647;
      }
      paramBundle = this.wZz;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.SWl;
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break label647;
        }
      }
      paramBundle = "";
      break label647;
      label1249:
      i = 0;
      break label725;
      label1254:
      paramBundle = findViewById(b.f.finder_poster_service_entrance);
      p.j(paramBundle, "findViewById<FrameLayout…_poster_service_entrance)");
      ((FrameLayout)paramBundle).setVisibility(8);
      break label772;
      i = 1;
      break label997;
      paramBundle = null;
      break label1025;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287408);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.h)this);
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
    int i = i.a.drx()[3];
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    i += ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAy, 0);
    Log.i("SimpleUIComponent", "onDestroy : ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().Mp(2);
    }
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().xsM.dqt();
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().xsM.dqs();
    localObject = this.Bny;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.plugin.finder.live.ui.livepost.c)localObject).TAG, "destroy");
      com.tencent.mm.kernel.h.aGY().b(5231, (com.tencent.mm.an.i)localObject);
      AppMethodBeat.o(287408);
      return;
    }
    AppMethodBeat.o(287408);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(287397);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.finder.live.ui.livepost.c localc = this.Bny;
    if (localc != null)
    {
      p.k(paramArrayOfString, "permissions");
      p.k(paramArrayOfInt, "grantResults");
      if ((paramInt == 16) || (paramInt == 80))
      {
        if (paramArrayOfInt.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label111;
          }
        }
        label111:
        for (int i = j;; i = 0)
        {
          if ((i == 0) || (paramArrayOfInt[0] != 0)) {
            break label117;
          }
          localc.c(localc.yOv);
          AppMethodBeat.o(287397);
          return;
          i = 0;
          break;
        }
        label117:
        Log.i(localc.TAG, "FinderLive request permission " + paramInt + " failed");
        paramArrayOfString = localc.fDf.getResources().getString(b.j.finder_live_permission_warning_title);
        p.j(paramArrayOfString, "context.resources.getStr…permission_warning_title)");
        paramArrayOfInt = localc.fDf.getResources().getString(b.j.finder_live_permission_warning_content);
        p.j(paramArrayOfInt, "context.resources.getStr…rmission_warning_content)");
        String str = localc.fDf.getResources().getString(b.j.finder_live_permission_warning_action);
        p.j(str, "context.resources.getStr…ermission_warning_action)");
        new f.a((Context)localc.fDf).aR((CharSequence)paramArrayOfString).bBl(paramArrayOfInt).bBp(str).icD().b((f.c)new c.c(localc)).show();
      }
      AppMethodBeat.o(287397);
      return;
    }
    AppMethodBeat.o(287397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287405);
    super.onResume();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
      AppMethodBeat.o(287405);
      throw ((Throwable)localObject);
    }
    ((com.tencent.mm.plugin.finder.extension.c)localObject).gu(110633, 1);
    this.Bnw = com.tencent.mm.model.z.bdh();
    if (this.wZz != null)
    {
      elh();
      elj();
      localObject = this.Bny;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.ui.livepost.c)localObject).a(this.wZz);
      }
      localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().xsM;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(6);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(6);
      localObject = com.tencent.mm.plugin.finder.report.k.zWs;
      if (!this.BnX) {
        break label296;
      }
      i = 4;
      label170:
      com.tencent.mm.plugin.finder.report.k.R(true, i);
      localObject = this.BnC;
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label301;
      }
    }
    label296:
    label301:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
        if (!com.tencent.mm.plugin.finder.live.report.k.dDm().yDx)
        {
          localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
          com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDJ.jWO, "");
        }
      }
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.aBk("ProfileEntrance");
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.aBk("CreateFinderEntrance");
      AppMethodBeat.o(287405);
      return;
      if (Util.isNullOrNil(this.Bnw))
      {
        localObject = this.progressBar;
        if (localObject == null) {
          p.bGy("progressBar");
        }
        ((ProgressBar)localObject).setVisibility(0);
      }
      for (;;)
      {
        doPrepareUser();
        break;
        elh();
      }
      i = 3;
      break label170;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(287407);
    Log.i("SimpleUIComponent", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramq instanceof ch))
    {
      Object localObject = this.progressBar;
      if (localObject == null) {
        p.bGy("progressBar");
      }
      ((ProgressBar)localObject).setVisibility(8);
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.live.ui.post.d)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.live.ui.post.d.class)).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.wZz == null)
        {
          if (paramq == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
            AppMethodBeat.o(287407);
            throw paramString;
          }
          this.wZz = ((ch)paramq).dnR();
          elj();
        }
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
          AppMethodBeat.o(287407);
          throw paramString;
        }
        this.wZz = ((ch)paramq).dnR();
        paramString = this.Bny;
        if (paramString != null) {
          paramString.a(this.wZz);
        }
        elh();
        AppMethodBeat.o(287407);
        return;
      }
      elj();
      com.tencent.mm.ui.base.w.makeText((Context)getActivity(), b.j.finder_prepare_user_failed, 1).show();
    }
    AppMethodBeat.o(287407);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(287403);
    super.onStop();
    this.BnQ = false;
    this.BnR = "";
    this.BnS = "";
    this.BnT = "";
    this.BnU = "";
    this.BnV = "";
    this.BnW = "";
    AppMethodBeat.o(287403);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229731);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bob.getIntent().putExtra("finder_username", ak.d(this.Bob));
      this.Bob.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
      paramView = aj.Bnu;
      aj.a.a((Context)this.Bob.getActivity(), this.Bob.getIntent(), 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.Bob.getActivity(), this.Bob.getIntent());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229731);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aa
    implements View.OnClickListener
  {
    aa(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256767);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fG((Context)this.Bob.getActivity());
      paramView = n.zWF;
      n.a((Context)this.Bob.getActivity(), this.Bob.wzm, this.Bob.BnP, 2L, this.Bob.BnJ, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256767);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class ab<T>
    implements androidx.lifecycle.s<h.a>
  {
    ab(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285661);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)paramView).getRedDotManager().aBf("finder_private_msg_entrance");
      if (locall != null)
      {
        paramView = locall.aBy("finder_private_msg_entrance");
        if ((locall == null) || (locall.field_ctrInfo.type != 1007)) {
          break label277;
        }
        localObject = n.zWF;
        n.a((Context)this.Bob.getActivity(), this.Bob.wzm, this.Bob.BnP, 2L, this.Bob.BnN, true, 0L);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.l.zWx;
          localObject = aj.Bnu;
          localObject = aj.a.fZ((Context)this.Bob.getActivity());
          if (localObject == null) {
            break label272;
          }
          localObject = ((aj)localObject).ekY();
          label170:
          com.tencent.mm.plugin.finder.report.l.a("4", locall, paramView, 2, (bid)localObject, 0, 0, null, 224);
        }
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.finder.report.d.zUg;
        com.tencent.mm.plugin.finder.report.d.dPc().W(1L, 0L);
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        p.j(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.findersdk.a.ak)paramView).getRedDotManager().aBd("finder_private_msg_entrance");
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderConversationUI((Context)this.Bob.getActivity());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285661);
        return;
        paramView = null;
        break;
        label272:
        localObject = null;
        break label170;
        label277:
        if ((locall != null) && (locall.field_ctrInfo.type == 1006))
        {
          int i;
          if (paramView != null)
          {
            i = paramView.count;
            label305:
            localObject = n.zWF;
            n.a((Context)this.Bob.getActivity(), this.Bob.wzm, this.Bob.BnP, 2L, this.Bob.BnN, true, i);
            if (paramView == null) {
              continue;
            }
            localObject = com.tencent.mm.plugin.finder.report.l.zWx;
            localObject = aj.Bnu;
            localObject = aj.a.fZ((Context)this.Bob.getActivity());
            if (localObject == null) {
              break label408;
            }
          }
          label408:
          for (localObject = ((aj)localObject).ekY();; localObject = null)
          {
            com.tencent.mm.plugin.finder.report.l.a("4", locall, paramView, 3, (bid)localObject, 0, 0, null, 224);
            break;
            i = 0;
            break label305;
          }
        }
        else
        {
          paramView = n.zWF;
          n.a((Context)this.Bob.getActivity(), this.Bob.wzm, this.Bob.BnP, 2L, this.Bob.BnN, false, 0L);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class ad<T>
    implements androidx.lifecycle.s<h.a>
  {
    ad(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class ae<T>
    implements androidx.lifecycle.s<h.a>
  {
    ae(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
  static final class af
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.viewmodel.component.d>
  {
    af(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$7$1$1$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$$special$$inlined$let$lambda$2"})
  static final class ag
    implements View.OnClickListener
  {
    ag(TextView paramTextView, ak paramak, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(268368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      new f.a((Context)jdField_this.getActivity()).aR((CharSequence)"").bBl(jdField_this.getActivity().getString(b.j.finder_account_in_logout_status_dialog_tips)).ayp(b.j.finder_account_in_logout_confirm).HL(true).b(null).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268368);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(ak paramak) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(286360);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramView).getRedDotManager().aBe("ProfileEntrance");
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)paramView).getRedDotManager().aBf("ProfileEntrance");
      if ((localObject2 != null) && (localObject1 != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView != null)
        {
          paramView = paramView.ekY();
          com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1, 2, paramView, 0, 0, null, 224);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aBd("ProfileEntrance");
        paramView = new Intent();
        localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject1 = d.a.aAK(com.tencent.mm.model.z.bdh());
        if (localObject1 == null) {
          p.iCn();
        }
        if (!((com.tencent.mm.plugin.finder.api.i)localObject1).isBlock()) {
          break label303;
        }
        paramView.setClass((Context)this.Bob.getActivity(), FinderExposeUI.class);
        localObject1 = this.Bob.getActivity();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramView.aFh(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((AppCompatActivity)localObject1).startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286360);
        return;
        paramView = null;
        break;
        label303:
        localObject2 = new kotlin.g.b.q(paramView)
        {
          public final void invoke()
          {
            AppMethodBeat.i(276494);
            paramView.putExtra("finder_username", ak.d(this.Bok.Bob));
            paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
            Object localObject = aj.Bnu;
            aj.a.a((Context)this.Bok.Bob.getActivity(), paramView, 0L, 0, false, 124);
            localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.Bok.Bob.getActivity(), paramView);
            AppMethodBeat.o(276494);
          }
        };
        paramView = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject1 = ak.d(this.Bob);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        paramView = d.a.aAP(paramView);
        if (paramView != null)
        {
          if (paramView.wZR == 1)
          {
            paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
            localObject2 = (Context)this.Bob.getActivity();
            localObject1 = ak.d(this.Bob);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            com.tencent.mm.plugin.finder.utils.a.aE((Context)localObject2, paramView);
          }
          else
          {
            ((1)localObject2).invoke();
          }
        }
        else {
          ((1)localObject2).invoke();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ai
    implements View.OnClickListener
  {
    ai(ak paramak, int paramInt, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278311);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      int i;
      if (j > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
          break label438;
        }
        i = 0;
        if (j > 0)
        {
          paramView = n.zWF;
          int j = j;
          paramView = aj.Bnu;
          paramView = aj.a.fZ((Context)this.Bob.getActivity());
          if (paramView == null) {
            break label443;
          }
          paramView = paramView.ekY();
          label109:
          n.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
        }
      }
      localObject = this.Bom;
      bkn localbkn = this.Bon;
      label181:
      boolean bool1;
      if ((localObject != null) && (localbkn != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView != null)
        {
          paramView = paramView.ekY();
          com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject, localbkn, 2, paramView, 0, 0, null, 224);
          paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)paramView).getRedDotManager().aBd("AuthorProfileNotify");
        }
      }
      else
      {
        paramView = n.zWF;
        paramView = (Context)this.Bob.getActivity();
        long l1 = this.Bob.wzm;
        boolean bool2 = this.Bob.BnP;
        long l2 = this.Bob.BnK;
        if (j <= 0) {
          break label453;
        }
        bool1 = true;
        label274:
        n.a(paramView, l1, bool2, 2L, l2, bool1, j);
        paramView = new Intent();
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject = d.a.aAK(com.tencent.mm.model.z.bdh());
        if (localObject == null) {
          p.iCn();
        }
        if (!((com.tencent.mm.plugin.finder.api.i)localObject).isBlock()) {
          break label459;
        }
        paramView.setClass((Context)this.Bob.getActivity(), FinderExposeUI.class);
        localObject = this.Bob.getActivity();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((AppCompatActivity)localObject).startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(278311);
        return;
        label438:
        i = 2;
        break;
        label443:
        paramView = null;
        break label109;
        paramView = null;
        break label181;
        label453:
        bool1 = false;
        break label274;
        label459:
        localObject = aj.Bnu;
        aj.a.a((Context)this.Bob.getActivity(), paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.Y((Context)this.Bob.getActivity(), paramView);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291663);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ak.g(this.Bob);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291663);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ak
    implements Runnable
  {
    ak(ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(266964);
      ak.i(this.Bob).performClick();
      AppMethodBeat.o(266964);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class al
    implements Runnable
  {
    al(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(264864);
      this.kJS.performClick();
      AppMethodBeat.o(264864);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(276728);
      this.Bob.findViewById(b.f.finder_account_area).performClick();
      AppMethodBeat.o(276728);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ak paramak, aa.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287668);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.report.k.zWs;
      int i;
      if (ak.h(this.Bob))
      {
        i = 4;
        com.tencent.mm.plugin.finder.report.k.R(false, i);
        paramView = com.tencent.mm.plugin.finder.report.k.zWs;
        if (!ak.h(this.Bob)) {
          break label422;
        }
        i = 4;
        label71:
        com.tencent.mm.plugin.finder.report.k.av(i, false);
        paramView = com.tencent.mm.plugin.finder.report.k.zWs;
        paramView = new StringBuilder();
        p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
        com.tencent.mm.plugin.finder.report.k.aEb(com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond());
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().aBe("TLCamera");
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)paramView).getRedDotManager().aBf("TLCamera");
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if ((localObject != null) && (locall != null))
        {
          paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
            break label427;
          }
          i = 0;
          label206:
          paramView = n.zWF;
          paramView = aj.Bnu;
          paramView = aj.a.fZ((Context)this.Bob.getActivity());
          if (paramView == null) {
            break label432;
          }
          paramView = paramView.ekY();
          label237:
          n.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
          paramView = com.tencent.mm.plugin.finder.report.l.zWx;
          paramView = aj.Bnu;
          paramView = aj.a.fZ((Context)this.Bob.getActivity());
          if (paramView == null) {
            break label437;
          }
          paramView = paramView.ekY();
          label287:
          com.tencent.mm.plugin.finder.report.l.a("4", locall, (bkn)localObject, 2, paramView, 0, 0, null, 224);
        }
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        p.j(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.findersdk.a.ak)paramView).getRedDotManager().aBd("TLCamera");
        paramView = new Intent();
        if (!this.Boc.aaBx) {
          break label442;
        }
        paramView.putExtra("key_create_scene", 4);
      }
      for (;;)
      {
        localObject = ak.a(this.Bob);
        if (localObject != null) {
          paramView.putExtra("key_prepare_resp", ((ble)localObject).toByteArray());
        }
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.w((Context)this.Bob.getActivity(), paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287668);
        return;
        i = 3;
        break;
        label422:
        i = 3;
        break label71;
        label427:
        i = 1;
        break label206;
        label432:
        paramView = null;
        break label237;
        label437:
        paramView = null;
        break label287;
        label442:
        paramView.putExtra("key_create_scene", 2);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(272562);
      ak.i(this.Bob).performClick();
      AppMethodBeat.o(272562);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements androidx.lifecycle.s<h.a>
  {
    e(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements androidx.lifecycle.s<h.a>
  {
    f(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279772);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = ak.a(this.Bob);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.at((Activity)this.Bob.getActivity())) {
          ak.a(this.Bob, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279772);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(274656);
      this.Bob.findViewById(b.f.finder_account_area).performClick();
      AppMethodBeat.o(274656);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    i(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    j(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements q.f
  {
    k(ak paramak) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      Object localObject1 = null;
      AppMethodBeat.i(287268);
      p.j(paramo, "it");
      Object localObject2;
      if (paramo.hJO())
      {
        paramo.mn(1001, b.j.app_field_mmsight);
        paramo.mn(1002, b.j.app_field_select_new_pic);
        localObject2 = ab.AEA;
        ab.a(ak.k(this.Bob), paramo, this.Bob.getContext());
      }
      paramo = n.zWF;
      paramo = aj.Bnu;
      paramo = aj.a.fZ((Context)this.Bob.getContext());
      if (paramo != null) {}
      for (paramo = paramo.ekY();; paramo = null)
      {
        n.b(0, "post_acionsheet_camera", "", paramo);
        paramo = n.zWF;
        paramo = aj.Bnu;
        localObject2 = aj.a.fZ((Context)this.Bob.getContext());
        paramo = localObject1;
        if (localObject2 != null) {
          paramo = ((aj)localObject2).ekY();
        }
        n.b(0, "post_actionsheet_album", "", paramo);
        AppMethodBeat.o(287268);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(ak paramak, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      ab localab = null;
      AppMethodBeat.i(285658);
      Intent localIntent = new Intent();
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001)
      {
        localIntent.putExtra("key_finder_post_router", 2);
        paramMenuItem = n.zWF;
        paramMenuItem = aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.Bob.getContext());
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.ekY();
          n.b(1, "post_acionsheet_camera", "", paramMenuItem);
        }
      }
      label203:
      do
      {
        for (;;)
        {
          localIntent.putExtra("key_finder_post_from", 5);
          localIntent.putExtra("key_finder_post_id", this.xNP);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.Bob.getActivity(), localIntent);
          AppMethodBeat.o(285658);
          return;
          paramMenuItem = null;
          break;
          if (paramMenuItem.getItemId() != 1002) {
            break label203;
          }
          localIntent.putExtra("key_finder_post_router", 3);
          paramMenuItem = n.zWF;
          paramMenuItem = aj.Bnu;
          aj localaj = aj.a.fZ((Context)this.Bob.getContext());
          paramMenuItem = localab;
          if (localaj != null) {
            paramMenuItem = localaj.ekY();
          }
          n.b(1, "post_actionsheet_album", "", paramMenuItem);
        }
      } while (!ak.k(this.Bob).containsKey(Integer.valueOf(paramMenuItem.getItemId())));
      localab = ab.AEA;
      ab.a((Context)this.Bob.getActivity(), (dna)ak.k(this.Bob).get(Integer.valueOf(paramMenuItem.getItemId())));
      paramMenuItem = com.tencent.mm.plugin.finder.report.k.zWs;
      if (ak.h(this.Bob)) {}
      for (paramInt = 4;; paramInt = 3)
      {
        com.tencent.mm.plugin.finder.report.k.av(paramInt, false);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class m
    implements com.tencent.mm.ui.widget.a.e.b
  {
    public static final m Boe;
    
    static
    {
      AppMethodBeat.i(277686);
      Boe = new m();
      AppMethodBeat.o(277686);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(277685);
      com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.Pw(6);
      AppMethodBeat.o(277685);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289096);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().aBe("FinderLiveIncomeEntrance");
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)paramView).getRedDotManager().aBf("FinderLiveIncomeEntrance");
      int i;
      if ((localObject != null) && (locall != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView != null)
        {
          paramView = paramView.ekY();
          com.tencent.mm.plugin.finder.report.l.a("4", locall, (bkn)localObject, 2, paramView, 0, 0, null, 224);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        p.j(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.findersdk.a.ak)paramView).getRedDotManager().aBd("FinderLiveIncomeEntrance");
        paramView = (CharSequence)ak.d(this.Bob);
        if ((paramView != null) && (paramView.length() != 0)) {
          break label294;
        }
        i = 1;
        label195:
        if (i == 0) {
          break label310;
        }
        paramView = new Intent();
        localObject = FinderSelfUI.Avb;
        if (!paramView.getBooleanExtra(FinderSelfUI.eaV(), false)) {
          break label299;
        }
        paramView.putExtra("key_create_scene", 4);
        label230:
        localObject = ak.a(this.Bob);
        if (localObject != null) {
          paramView.putExtra("key_prepare_resp", ((ble)localObject).toByteArray());
        }
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.w((Context)this.Bob.getActivity(), paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289096);
        return;
        paramView = null;
        break;
        label294:
        i = 0;
        break label195;
        label299:
        paramView.putExtra("key_create_scene", 2);
        break label230;
        label310:
        ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).bY((Context)this.Bob.getActivity(), "");
        paramView = n.zWF;
        n.a((Context)this.Bob.getActivity(), this.Bob.wzm, false, 2L, this.Bob.BnM, false, 0L);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class o<T>
    implements androidx.lifecycle.s<h.a>
  {
    o(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(ak paramak, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274661);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      ak.e(this.Bob).dGy();
      paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
      com.tencent.mm.plugin.finder.live.report.k.dDm().a(s.bc.yKN);
      paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
      com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDK.jWO, "");
      paramView = ak.f(this.Bob);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      localObject = this.Bof;
      bkn localbkn = this.Bog;
      if ((localObject != null) && (localbkn != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView == null) {
          break label262;
        }
      }
      label262:
      for (paramView = paramView.ekY();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject, localbkn, 2, paramView, 0, 0, null, 224);
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aBd("FinderSelfLiveEntrance");
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().d("FinderEntrance", new int[] { 1010 });
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().d("TLPersonalCenter", new int[] { 1010 });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274661);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class q<T>
    implements androidx.lifecycle.s<h.a>
  {
    q(ak paramak, com.tencent.mm.plugin.finder.extension.reddot.l paraml, bkn parambkn) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291234);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ak.g(this.Bob);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291234);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270635);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      localObject = aj.Bnu;
      aj.a.a((Context)this.Bob.getActivity(), paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.Bob.getActivity(), FinderFollowListUI.class);
      localObject = this.Bob.getActivity();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((AppCompatActivity)localObject).startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = n.zWF;
      n.a((Context)this.Bob.getActivity(), this.Bob.wzm, this.Bob.BnP, 2L, this.Bob.BnG, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270635);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class t<T>
    implements androidx.lifecycle.s<h.a>
  {
    t(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271990);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fQ((Context)this.Bob.getActivity());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271990);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class v<T>
    implements androidx.lifecycle.s<h.a>
  {
    v(ak paramak) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(ak paramak, aa.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229274);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().aBe("CreatorCenter");
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)paramView).getRedDotManager().aBf("CreatorCenter");
      long l1;
      boolean bool2;
      long l2;
      if ((locall != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView != null)
        {
          paramView = paramView.ekY();
          com.tencent.mm.plugin.finder.report.l.a("4", locall, (bkn)localObject, 2, paramView, 0, 0, null, 224);
        }
      }
      else
      {
        paramView = n.zWF;
        paramView = (Context)this.Bob.getContext();
        l1 = this.Bob.wzm;
        bool2 = this.Bob.BnP;
        l2 = this.Bob.BnL;
        if (localObject == null) {
          break label276;
        }
      }
      label276:
      for (boolean bool1 = true;; bool1 = false)
      {
        n.a(paramView, l1, bool2, 2L, l2, bool1);
        paramView = new Intent();
        paramView.putExtra("rawUrl", (String)this.Boh.aaBC);
        com.tencent.mm.by.c.b((Context)this.Bob.getActivity(), "webview", ".ui.tools.WebViewUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229274);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      long l1 = 0L;
      AppMethodBeat.i(277829);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      localObject = aj.Bnu;
      aj.a.a((Context)this.Bob.getActivity(), paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.Bob.getActivity(), FinderLikeFeedGridUI.class);
      paramView.putExtra("finder_username", com.tencent.mm.model.z.bdh());
      localObject = this.Bob.getActivity();
      FinderSelfUI.a locala = FinderSelfUI.Avb;
      ((AppCompatActivity)localObject).startActivityForResult(paramView, FinderSelfUI.eaS());
      paramView = n.zWF;
      paramView = (Context)this.Bob.getActivity();
      long l2 = this.Bob.wzm;
      boolean bool = this.Bob.BnP;
      long l3 = this.Bob.BnH;
      localObject = ak.a(this.Bob);
      if (localObject != null) {
        l1 = ((ble)localObject).SWf;
      }
      n.a(paramView, l2, bool, 2L, l3, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277829);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(268166);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramView).getRedDotManager().aBe("Personal_Center_FavList_Entrance");
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)paramView).getRedDotManager().aBf("Personal_Center_FavList_Entrance");
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramView = n.zWF;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView == null) {
          break label298;
        }
        paramView = paramView.ekY();
        n.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
        paramView = com.tencent.mm.plugin.finder.report.l.zWx;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.Bob.getActivity());
        if (paramView == null) {
          break label303;
        }
      }
      label298:
      label303:
      for (paramView = paramView.ekY();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.l.a("4", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1, 2, paramView, 0, 0, null, 224);
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        p.j(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.findersdk.a.ak)paramView).getRedDotManager().aBd("Personal_Center_FavList_Entrance");
        paramView = new Intent();
        localObject1 = aj.Bnu;
        aj.a.a((Context)this.Bob.getActivity(), paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject1 = this.Bob.getActivity();
        if (localObject1 != null) {
          break label308;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(268166);
        throw paramView;
        paramView = null;
        break;
      }
      label308:
      localObject1 = (MMActivity)localObject1;
      localObject2 = FinderSelfUI.Avb;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)localObject1, paramView, FinderSelfUI.eaR());
      paramView = n.zWF;
      paramView = (Context)this.Bob.getActivity();
      long l2 = this.Bob.wzm;
      boolean bool = this.Bob.BnP;
      long l3 = this.Bob.BnI;
      localObject1 = ak.a(this.Bob);
      if (localObject1 != null) {}
      for (long l1 = ((ble)localObject1).SWg;; l1 = 0L)
      {
        n.a(paramView, l2, bool, 2L, l3, false, l1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(268166);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class z
    implements View.OnClickListener
  {
    z(ak paramak) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291656);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fN((Context)this.Bob.getActivity());
      long l1 = ak.ell();
      paramView = n.zWF;
      paramView = (Context)this.Bob.getActivity();
      long l2 = this.Bob.wzm;
      boolean bool2 = this.Bob.BnP;
      long l3 = this.Bob.BnO;
      boolean bool1;
      com.tencent.mm.plugin.finder.extension.reddot.l locall;
      if (l1 > 0L)
      {
        bool1 = true;
        n.a(paramView, l2, bool2, 2L, l3, bool1, l1);
        paramView = com.tencent.mm.plugin.finder.report.d.zUg;
        com.tencent.mm.plugin.finder.report.d.dPc().W(2L, 0L);
        paramView = com.tencent.mm.plugin.finder.report.d.zUg;
        com.tencent.mm.plugin.finder.report.d.dPg().zUv = ak.ell();
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().aBe("finder_wx_private_msg_entrance");
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locall = ((PluginFinder)paramView).getRedDotManager().aBf("finder_wx_private_msg_entrance");
        if ((localObject != null) && (locall != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.l.zWx;
          paramView = aj.Bnu;
          paramView = aj.a.fZ((Context)this.Bob.getActivity());
          if (paramView == null) {
            break label286;
          }
        }
      }
      label286:
      for (paramView = paramView.ekY();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.l.a("4", locall, (bkn)localObject, 3, paramView, 0, 0, null, 224);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291656);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ak
 * JD-Core Version:    0.7.0.1
 */