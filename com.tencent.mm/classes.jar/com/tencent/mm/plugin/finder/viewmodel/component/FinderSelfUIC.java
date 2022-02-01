package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.a.b;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.a;
import com.tencent.mm.plugin.finder.report.live.s.ao;
import com.tencent.mm.plugin.finder.ui.FinderExposeUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "BANNER_TYPE_CREATOR_ENTRANCE", "", "getBANNER_TYPE_CREATOR_ENTRANCE", "()J", "BANNER_TYPE_FAV", "getBANNER_TYPE_FAV", "BANNER_TYPE_FINDER_MSG", "getBANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "()V", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FOLLOW", "getBANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "getBANNER_TYPE_LIKE", "BANNER_TYPE_LIVE_INCOME", "getBANNER_TYPE_LIVE_INCOME", "BANNER_TYPE_WX_MSG", "getBANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "getBANNER_TYPE_WX_PRIVATE_MESSAGE", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "dialogCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "(J)V", "finderCanPostNoContact", "Landroid/widget/TextView;", "finderLiveCanPostNoContact", "finderLivePosBtn", "Landroid/view/View;", "finderLivePostNewFeed", "finderPosBtn", "finderPostNewFeed", "finderRedPackEntrance", "hasExposeCreatorEntranceTips", "", "getHasExposeCreatorEntranceTips", "()Ljava/lang/String;", "setHasExposeCreatorEntranceTips", "(Ljava/lang/String;)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "setHasExposeFinderHiMsgTips", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeLiveEntranceTips", "getHasExposeLiveEntranceTips", "setHasExposeLiveEntranceTips", "hasExposeProfileEntranceTips", "getHasExposeProfileEntranceTips", "setHasExposeProfileEntranceTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "", "getHasReportFinderMsg", "()Z", "setHasReportFinderMsg", "(Z)V", "isEnableSendMsgEntrance", "isFromSnsPost", "isReportRedDotExpose", "lastFavTipsId", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "livePostUic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "Lkotlin/Lazy;", "myFinderUsername", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkTeenMode", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getEntranceType", "getLayoutId", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "initLiveRewardGainCell", "initPostBtn", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "plugin-finder_release"})
public final class FinderSelfUIC
  extends UIComponent
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.api.f
{
  private ProgressBar progressBar;
  long sTp;
  private bed udb;
  private HashMap<Integer, ddk> udg;
  private final kotlin.f vaj;
  String wAa;
  String wAb;
  String wAc;
  String wAd;
  String wAe;
  private boolean wAf;
  private final boolean wAg;
  private String wAh;
  private final int wyj;
  private final int wyk;
  private com.tencent.mm.ui.widget.a.e wyl;
  private String wzE;
  private boolean wzF;
  private com.tencent.mm.plugin.finder.ui.g wzG;
  private View wzH;
  private TextView wzI;
  private TextView wzJ;
  private View wzK;
  private TextView wzL;
  private TextView wzM;
  private View wzN;
  final long wzO;
  final long wzP;
  final long wzQ;
  final long wzR;
  final long wzS;
  final long wzT;
  final long wzU;
  final long wzV;
  final long wzW;
  boolean wzX;
  private boolean wzY;
  String wzZ;
  
  public FinderSelfUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255949);
    this.udg = new HashMap();
    this.wzO = 1L;
    this.wzP = 2L;
    this.wzQ = 3L;
    this.wzR = 4L;
    this.wzS = 5L;
    this.wzT = 8L;
    this.wzU = 9L;
    this.wzV = 6L;
    this.wzW = 7L;
    this.wzZ = "";
    this.wAa = "";
    this.wAb = "";
    this.wAc = "";
    this.wAd = "";
    this.wAe = "";
    this.wyj = 10001;
    this.wyk = 10002;
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dtG().value()).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.wAg = bool;
      this.vaj = kotlin.g.ah((kotlin.g.a.a)new ac(this));
      this.wAh = "";
      AppMethodBeat.o(255949);
      return;
    }
  }
  
  private final FinderLivePostBtnUIC dIC()
  {
    AppMethodBeat.i(255934);
    FinderLivePostBtnUIC localFinderLivePostBtnUIC = (FinderLivePostBtnUIC)this.vaj.getValue();
    AppMethodBeat.o(255934);
    return localFinderLivePostBtnUIC;
  }
  
  private final void dID()
  {
    AppMethodBeat.i(255938);
    Object localObject1 = this.udb;
    int i;
    boolean bool1;
    boolean bool2;
    long l;
    label86:
    boolean bool3;
    View localView;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((bed)localObject1).LNW;
      bool1 = com.tencent.mm.ac.d.cW(i, 1);
      localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
      p.g(localObject1, "MMKernel.service(ITeenModeService::class.java)");
      bool2 = ((com.tencent.mm.plugin.teenmode.a.b)localObject1).Vt();
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
      localObject1 = c.a.asG(com.tencent.mm.model.z.aUg());
      if (localObject1 == null) {
        break label270;
      }
      l = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_liveSwitchFlag;
      bool3 = com.tencent.mm.plugin.finder.utils.m.Ge(l);
      localView = findViewById(2131303401);
      localObject1 = new StringBuilder("initLiveIncomeCell FinderLive.entrance,xLab enable live:");
      localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject2 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.c.duS()).append(", server flag:");
      localObject1 = this.udb;
      if (localObject1 == null) {
        break label276;
      }
    }
    label270:
    label276:
    for (localObject1 = Integer.valueOf(((bed)localObject1).LNW);; localObject1 = null)
    {
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool1 + " rewardGainEnable:" + bool3);
      localObject1 = y.vXH;
      if (!y.dCM())
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if ((!com.tencent.mm.plugin.finder.storage.c.duS()) && (!bool1)) {
          break label282;
        }
      }
      if ((!bool3) || (bool2)) {
        break label282;
      }
      p.g(localView, "liveIncomeGroup");
      localView.setVisibility(0);
      localView.setOnClickListener((View.OnClickListener)new l(this));
      AppMethodBeat.o(255938);
      return;
      i = 0;
      break;
      l = 0L;
      break label86;
    }
    label282:
    p.g(localView, "liveIncomeGroup");
    localView.setVisibility(8);
    AppMethodBeat.o(255938);
  }
  
  private final void dIE()
  {
    AppMethodBeat.i(255939);
    Object localObject1 = this.udb;
    int i;
    if (localObject1 != null)
    {
      i = ((bed)localObject1).LNW;
      boolean bool = com.tencent.mm.ac.d.cW(i, 1);
      localObject1 = new StringBuilder("FinderLive.entrance,xLab enable live:");
      Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject2 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.c.duS()).append(", server flag:");
      localObject1 = this.udb;
      if (localObject1 == null) {
        break label464;
      }
      localObject1 = Integer.valueOf(((bed)localObject1).LNW);
      label74:
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool);
      localObject1 = y.vXH;
      if (!y.dCM())
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if ((!com.tencent.mm.plugin.finder.storage.c.duS()) && (!bool)) {
          break label469;
        }
      }
      localObject1 = findViewById(2131306045);
      p.g(localObject1, "findViewById<View>(R.id.postBtn_new)");
      this.wzH = ((View)localObject1);
      localObject1 = findViewById(2131301394);
      p.g(localObject1, "findViewById(R.id.finder_post_new_feed_new)");
      this.wzI = ((TextView)localObject1);
      localObject1 = findViewById(2131300785);
      p.g(localObject1, "findViewById(R.id.finder_can_post_no_contact_new)");
      this.wzJ = ((TextView)localObject1);
      this.wzK = findViewById(2131303246);
      this.wzL = ((TextView)findViewById(2131301241));
      this.wzM = ((TextView)findViewById(2131300783));
      localObject1 = findViewById(2131306043);
      p.g(localObject1, "findViewById<View>(R.id.postBtn)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(2131306058);
      p.g(localObject1, "findViewById<View>(R.id.post_container_new)");
      ((View)localObject1).setVisibility(0);
      localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().asW("FinderSelfLiveEntrance");
      localObject2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)localObject2).getRedDotManager().asX("FinderSelfLiveEntrance");
      Object localObject3 = this.wzK;
      if (localObject3 != null) {
        ((View)localObject3).setOnClickListener((View.OnClickListener)new m(this, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1));
      }
      localObject3 = h.tKR;
      localObject3 = h.tKR;
      h.a(h.daY(), (LifecycleOwner)getActivity(), (Observer)new n(this, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1));
    }
    for (;;)
    {
      localObject1 = this.wzH;
      if (localObject1 == null) {
        p.btv("finderPosBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new o(this));
      this.wzN = findViewById(2131306760);
      localObject1 = this.wzN;
      if (localObject1 == null) {
        break label579;
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(255939);
      return;
      i = 0;
      break;
      label464:
      localObject1 = null;
      break label74;
      label469:
      localObject1 = findViewById(2131306043);
      p.g(localObject1, "findViewById<View>(R.id.postBtn)");
      this.wzH = ((View)localObject1);
      localObject1 = findViewById(2131301393);
      p.g(localObject1, "findViewById(R.id.finder_post_new_feed)");
      this.wzI = ((TextView)localObject1);
      localObject1 = findViewById(2131300784);
      p.g(localObject1, "findViewById(R.id.finder_can_post_no_contact)");
      this.wzJ = ((TextView)localObject1);
      localObject1 = findViewById(2131306043);
      p.g(localObject1, "findViewById<View>(R.id.postBtn)");
      ((View)localObject1).setVisibility(0);
      localObject1 = findViewById(2131306058);
      p.g(localObject1, "findViewById<View>(R.id.post_container_new)");
      ((View)localObject1).setVisibility(8);
    }
    label579:
    AppMethodBeat.o(255939);
  }
  
  private final void dIF()
  {
    AppMethodBeat.i(255940);
    dID();
    dIE();
    this.wzE = com.tencent.mm.model.z.aUg();
    Log.i("SimpleUIComponent", "myFinderUser " + this.wzE);
    Object localObject1 = findViewById(2131302248);
    Object localObject2 = findViewById(2131305448);
    Object localObject3 = y.vXH;
    switch (y.dCL())
    {
    default: 
      Log.d("SimpleUIComponent", "not one of six state");
      localObject1 = this.udb;
      if (localObject1 != null)
      {
        if (((bed)localObject1).LNR > 0)
        {
          localObject2 = findViewById(2131303180);
          p.g(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lw(((bed)localObject1).LNR));
          localObject2 = findViewById(2131303180);
          p.g(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
          ((TextView)localObject2).setVisibility(0);
          label202:
          if (((bed)localObject1).LNS <= 0) {
            break label3111;
          }
          localObject2 = findViewById(2131300463);
          p.g(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lw(((bed)localObject1).LNS));
          localObject2 = findViewById(2131300463);
          p.g(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
          ((TextView)localObject2).setVisibility(0);
          label272:
          Log.i("SimpleUIComponent", "likeCount = " + ((bed)localObject1).LNR + ",favCount = " + ((bed)localObject1).LNS);
        }
      }
      else
      {
        localObject1 = this.wzI;
        if (localObject1 == null) {
          p.btv("finderPostNewFeed");
        }
        com.tencent.mm.ui.ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = this.wzL;
        if (localObject1 == null) {
          break label3141;
        }
      }
      break;
    }
    label1159:
    label1676:
    label1714:
    label3141:
    for (localObject1 = ((TextView)localObject1).getPaint();; localObject1 = null)
    {
      com.tencent.mm.ui.ao.a((Paint)localObject1, 0.8F);
      localObject1 = findViewById(2131301468);
      p.g(localObject1, "findViewById<View>(R.id.finder_self_account_state)");
      ((View)localObject1).setVisibility(0);
      localObject1 = getIntent();
      localObject2 = FinderSelfUI.vOh;
      if (((Intent)localObject1).getBooleanExtra(FinderSelfUI.dAe(), false))
      {
        localObject1 = this.wzH;
        if (localObject1 == null) {
          p.btv("finderPosBtn");
        }
        if (localObject1 != null) {
          ((View)localObject1).post((Runnable)new aj((View)localObject1));
        }
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.vOh;
        ((Intent)localObject1).removeExtra(FinderSelfUI.dAe());
      }
      AppMethodBeat.o(255940);
      return;
      p.g(localObject1, "hasContactContainer");
      p.g(localObject2, "noContactContainer");
      p.h(localObject1, "hasContactContainer");
      p.h(localObject2, "noContactContainer");
      Log.d("SimpleUIComponent", "账户无发表权限");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
      break;
      p.g(localObject1, "hasContactContainer");
      p.g(localObject2, "noContactContainer");
      p.h(localObject1, "hasContactContainer");
      p.h(localObject2, "noContactContainer");
      Log.d("SimpleUIComponent", "有发表权限但未创建账号");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject1 = findViewById(2131304964);
      p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(2131300731);
      p.g(localObject1, "findViewById<View>(R.id.finder_account_area)");
      ((View)localObject1).setVisibility(8);
      localObject1 = findViewById(2131307601);
      p.g(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject1).setVisibility(8);
      localObject1 = new z.a();
      localObject2 = getIntent();
      localObject3 = FinderSelfUI.vOh;
      ((z.a)localObject1).SYB = ((Intent)localObject2).getBooleanExtra(FinderSelfUI.dAe(), false);
      localObject2 = this.wzH;
      if (localObject2 == null) {
        p.btv("finderPosBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new c(this, (z.a)localObject1));
      if ((((z.a)localObject1).SYB) && (this.udb != null))
      {
        localObject1 = this.wzH;
        if (localObject1 == null) {
          p.btv("finderPosBtn");
        }
        ((View)localObject1).post((Runnable)new d(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.vOh;
        ((Intent)localObject1).removeExtra(FinderSelfUI.dAe());
      }
      localObject1 = h.tKR;
      localObject1 = h.tKR;
      h.a(h.daL(), (LifecycleOwner)getActivity(), (Observer)new e(this));
      localObject1 = this.wzK;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = findViewById(2131303401);
      p.g(localObject1, "findViewById<View>(R.id.live_income_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = y.vXH;
      if (!y.dCY()) {
        break;
      }
      localObject1 = y.vXH;
      if (y.dCZ()) {
        break;
      }
      localObject1 = findViewById(2131306760);
      p.g(localObject1, "findViewById<View>(R.id.red_pack)");
      ((View)localObject1).setVisibility(0);
      findViewById(2131306760).setOnClickListener((View.OnClickListener)new f(this));
      break;
      p.g(localObject1, "hasContactContainer");
      p.g(localObject2, "noContactContainer");
      p.h(localObject1, "hasContactContainer");
      p.h(localObject2, "noContactContainer");
      Log.d("SimpleUIComponent", "账户正常");
      localObject3 = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)localObject3).getRedDotManager().asV("TLCamera");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject3 = findViewById(2131300731);
      localObject1 = findViewById(2131304964);
      Object localObject4 = (ImageView)findViewById(2131300774);
      Object localObject5 = (TextView)findViewById(2131301379);
      localObject2 = (TextView)findViewById(2131301367);
      Object localObject6 = com.tencent.mm.plugin.finder.api.c.tsp;
      localObject6 = this.wzE;
      if (localObject6 == null) {
        p.hyc();
      }
      localObject6 = c.a.asG((String)localObject6);
      ImageView localImageView = (ImageView)findViewById(2131297096);
      Object localObject7;
      int i;
      label1392:
      final int j;
      label1634:
      label1779:
      long l1;
      boolean bool2;
      long l2;
      if (this.wAg)
      {
        localObject7 = findViewById(2131307601);
        p.g(localObject7, "findViewById<View>(R.id.sendMsgLayout)");
        ((View)localObject7).setVisibility(0);
        if (localObject6 != null)
        {
          localObject7 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject7 = com.tencent.mm.plugin.finder.loader.m.dka();
          com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject6).cXH());
          p.g(localObject4, "finderAvatar");
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject7).a(locala, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
          p.g(localObject5, "finderNickname");
          ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject6).getNickname()));
          com.tencent.mm.ui.ao.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
          localObject4 = y.vXH;
          p.g(localImageView, "authIcon");
          y.a(localImageView, ((com.tencent.mm.plugin.finder.api.g)localObject6).field_authInfo);
          localObject4 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject4, "MMKernel.storage()");
          i = ((com.tencent.mm.kernel.e)localObject4).azQ().getInt(ar.a.OlC, 0);
          if (i <= 0) {
            break label2133;
          }
          localObject4 = findViewById(2131300845);
          p.g(localObject4, "findViewById<View>(R.id.finder_follow_count)");
          ((View)localObject4).setVisibility(0);
          localObject4 = findViewById(2131300845);
          p.g(localObject4, "findViewById<TextView>(R.id.finder_follow_count)");
          ((TextView)localObject4).setText((CharSequence)getActivity().getResources().getString(2131759699, new Object[] { String.valueOf(i) }));
        }
        p.g(localObject3, "finderAccountArea");
        ((View)localObject3).setVisibility(0);
        p.g(localObject1, "finderMsgArea");
        ((View)localObject1).setVisibility(0);
        localObject4 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
        localObject4 = i.a.dbo();
        i = localObject4[0];
        int k = localObject4[1];
        int m = localObject4[2];
        j = localObject4[3];
        Log.i("SimpleUIComponent", "redDot check likeCount :" + i + " commentCount " + k + " followCount " + m + ' ');
        ((View)localObject3).setOnClickListener((View.OnClickListener)new ad(this));
        localObject3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
        localObject3 = ((PluginFinder)localObject3).getRedDotManager().asX("AuthorProfileNotify");
        localObject4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
        localObject4 = ((PluginFinder)localObject4).getRedDotManager().asW("AuthorProfileNotify");
        ((View)localObject1).setOnClickListener((View.OnClickListener)new ae(this, j, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject3, (bdo)localObject4));
        if (j <= 0) {
          break label2189;
        }
        p.g(localObject2, "finderMsg");
        ((TextView)localObject2).setVisibility(0);
        if (j <= 999) {
          break label2160;
        }
        localObject1 = (CharSequence)"999+";
        ((TextView)localObject2).setText((CharSequence)localObject1);
        if (!this.wzF)
        {
          this.wzF = true;
          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
            break label2172;
          }
          i = 0;
          if (j > 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
            localObject1 = FinderReporterUIC.wzC;
            localObject1 = FinderReporterUIC.a.fH((Context)getActivity());
            if (localObject1 == null) {
              break label2177;
            }
            localObject1 = ((FinderReporterUIC)localObject1).dIx();
            com.tencent.mm.plugin.finder.report.k.a("4", 1, 1, 5, i, j, null, null, 0L, (bbn)localObject1, 0, 0, 3520);
          }
          if ((localObject3 != null) && (localObject4 != null))
          {
            localObject1 = j.vft;
            localObject1 = FinderReporterUIC.wzC;
            localObject1 = FinderReporterUIC.a.fH((Context)getActivity());
            if (localObject1 == null) {
              break label2183;
            }
            localObject1 = ((FinderReporterUIC)localObject1).dIx();
            j.a("4", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject3, (bdo)localObject4, 1, (bbn)localObject1, 0, 0, 96);
          }
        }
        localObject1 = this.wzH;
        if (localObject1 == null) {
          p.btv("finderPosBtn");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new af(this));
        localObject1 = this.wzH;
        if (localObject1 == null) {
          p.btv("finderPosBtn");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.wzK;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.vOh;
        if (((Intent)localObject1).getBooleanExtra(FinderSelfUI.dAe(), false))
        {
          localObject1 = this.wzH;
          if (localObject1 == null) {
            p.btv("finderPosBtn");
          }
          ((View)localObject1).post((Runnable)new ag(this));
          localObject1 = getIntent();
          localObject2 = FinderSelfUI.vOh;
          ((Intent)localObject1).removeExtra(FinderSelfUI.dAe());
        }
        if (!this.wzY)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject1 = (Context)getActivity();
          l1 = this.sTp;
          bool2 = this.wzX;
          l2 = this.wzS;
          if (j <= 0) {
            break label2207;
          }
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.plugin.finder.report.k.a((Context)localObject1, l1, bool2, 1L, l2, bool1, j);
        this.wzY = true;
        localObject1 = y.vXH;
        if (y.dCY())
        {
          localObject1 = y.vXH;
          if (!y.dCZ())
          {
            localObject1 = y.vXH;
            if (!y.dDa())
            {
              localObject1 = y.vXH;
              y.dCW();
            }
          }
        }
        localObject1 = h.tKR;
        localObject1 = h.tKR;
        h.a(h.dba(), (LifecycleOwner)getActivity(), (Observer)new ah(this));
        Log.i("SimpleUIComponent", "show finder msg red, totalCount:".concat(String.valueOf(j)));
        break;
        localObject7 = findViewById(2131307601);
        p.g(localObject7, "findViewById<View>(R.id.sendMsgLayout)");
        ((View)localObject7).setVisibility(8);
        break label1159;
        label2133:
        localObject4 = findViewById(2131300845);
        p.g(localObject4, "findViewById<View>(R.id.finder_follow_count)");
        ((View)localObject4).setVisibility(8);
        break label1392;
        label2160:
        localObject1 = (CharSequence)String.valueOf(j);
        break label1634;
        label2172:
        i = 2;
        break label1676;
        localObject1 = null;
        break label1714;
        localObject1 = null;
        break label1779;
        p.g(localObject2, "finderMsg");
        ((TextView)localObject2).setVisibility(8);
        break label1796;
      }
      p.g(localObject1, "hasContactContainer");
      p.g(localObject2, "noContactContainer");
      p.h(localObject1, "hasContactContainer");
      p.h(localObject2, "noContactContainer");
      Log.d("SimpleUIComponent", "账户封禁");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject1 = findViewById(2131304964);
      p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = this.wzH;
      if (localObject1 == null) {
        p.btv("finderPosBtn");
      }
      ((View)localObject1).setVisibility(8);
      localObject1 = this.wzK;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a("");
      localObject3 = findViewById(2131300774);
      p.g(localObject3, "findViewById<ImageView>(R.id.finder_avatar_iv)");
      localObject3 = (ImageView)localObject3;
      localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject1 = findViewById(2131301379);
      p.g(localObject1, "findViewById<TextView>(R.id.finder_nick_tv)");
      ((TextView)localObject1).setText((CharSequence)getResources().getString(2131759483));
      localObject1 = findViewById(2131301479);
      p.g(localObject1, "findViewById<View>(R.id.finder_self_msg_tv)");
      ((View)localObject1).setVisibility(0);
      findViewById(2131300731).setOnClickListener((View.OnClickListener)new a(this));
      localObject1 = getIntent();
      localObject2 = FinderSelfUI.vOh;
      if (((Intent)localObject1).getBooleanExtra(FinderSelfUI.dAe(), false))
      {
        findViewById(2131300731).post((Runnable)new b(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.vOh;
        ((Intent)localObject1).removeExtra(FinderSelfUI.dAe());
      }
      localObject1 = findViewById(2131307601);
      p.g(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
      ((View)localObject1).setVisibility(8);
      break;
      p.g(localObject1, "hasContactContainer");
      p.g(localObject2, "noContactContainer");
      p.h(localObject1, "hasContactContainer");
      p.h(localObject2, "noContactContainer");
      Log.d("SimpleUIComponent", "账户审核中");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject5 = (ImageView)findViewById(2131300774);
      localObject3 = (TextView)findViewById(2131301379);
      localObject4 = (TextView)findViewById(2131301494);
      localObject1 = findViewById(2131304964);
      p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
      ((View)localObject1).setVisibility(8);
      localObject1 = this.wzH;
      if (localObject1 == null) {
        p.btv("finderPosBtn");
      }
      ((View)localObject1).setVisibility(8);
      localObject1 = this.wzK;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject6 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject1 = this.udb;
      if (localObject1 != null)
      {
        localObject1 = ((bed)localObject1).verifyInfo;
        if (localObject1 != null)
        {
          localObject2 = ((azn)localObject1).kog;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label2782;
          }
        }
      }
      localObject1 = "";
      label2782:
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      p.g(localObject5, "finderAvatar");
      localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      p.g(localObject3, "finderNickname");
      localObject2 = (Context)getActivity();
      localObject1 = this.udb;
      if (localObject1 != null)
      {
        localObject1 = ((bed)localObject1).verifyInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((azn)localObject1).LJq;; localObject1 = null)
      {
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1));
        com.tencent.mm.ui.ao.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
        p.g(localObject4, "finderState");
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText((CharSequence)getResources().getString(2131760533));
        localObject1 = findViewById(2131304964);
        p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
        ((View)localObject1).setVisibility(8);
        findViewById(2131300731).setOnClickListener((View.OnClickListener)new g(this));
        localObject1 = getIntent();
        localObject2 = FinderSelfUI.vOh;
        if ((((Intent)localObject1).getBooleanExtra(FinderSelfUI.dAe(), false)) && (this.udb != null))
        {
          findViewById(2131300731).post((Runnable)new h(this));
          localObject1 = getIntent();
          localObject2 = FinderSelfUI.vOh;
          ((Intent)localObject1).removeExtra(FinderSelfUI.dAe());
        }
        localObject1 = findViewById(2131307601);
        p.g(localObject1, "findViewById<View>(R.id.sendMsgLayout)");
        ((View)localObject1).setVisibility(8);
        break;
      }
      localObject2 = findViewById(2131303180);
      p.g(localObject2, "findViewById<TextView>(R.id.like_feed_count)");
      ((TextView)localObject2).setVisibility(8);
      break label202;
      localObject2 = findViewById(2131300463);
      p.g(localObject2, "findViewById<TextView>(R.id.fav_feed_count)");
      ((TextView)localObject2).setVisibility(8);
      break label272;
    }
  }
  
  private final void dIG()
  {
    AppMethodBeat.i(255947);
    Object localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.a((Context)getActivity(), this.sTp, this.wzX, 1L, this.wzO, false);
    localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
    localObject1 = (Context)getActivity();
    long l2 = this.sTp;
    boolean bool1 = this.wzX;
    long l3 = this.wzP;
    Object localObject2 = this.udb;
    long l1;
    label149:
    label239:
    int i;
    if (localObject2 != null)
    {
      l1 = ((bed)localObject2).LNR;
      com.tencent.mm.plugin.finder.report.k.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject1 = (Context)getActivity();
      l2 = this.sTp;
      bool1 = this.wzX;
      l3 = this.wzQ;
      localObject2 = this.udb;
      if (localObject2 == null) {
        break label523;
      }
      l1 = ((bed)localObject2).LNS;
      com.tencent.mm.plugin.finder.report.k.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a((Context)getActivity(), this.sTp, this.wzX, 1L, this.wzR, false);
      localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().asX("finder_private_msg_entrance");
      if (localObject1 == null) {
        break label528;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject1).atl("finder_private_msg_entrance");
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject2 = (Context)getActivity();
      l1 = this.sTp;
      boolean bool2 = this.wzX;
      l2 = this.wzV;
      if (localObject1 == null) {
        break label534;
      }
      bool1 = true;
      label278:
      if (localObject1 == null) {
        break label540;
      }
      i = ((bdo)localObject1).count;
      label289:
      com.tencent.mm.plugin.finder.report.k.a((Context)localObject2, l1, bool2, 1L, l2, bool1, i);
      l1 = dIH();
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject1 = (Context)getActivity();
      l2 = this.sTp;
      bool2 = this.wzX;
      l3 = this.wzW;
      if (l1 <= 0L) {
        break label545;
      }
      bool1 = true;
      label349:
      com.tencent.mm.plugin.finder.report.k.a((Context)localObject1, l2, bool2, 1L, l3, bool1, l1);
      localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().asW("CreatorCenter");
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject2 = (Context)getActivity();
      l1 = this.sTp;
      bool2 = this.wzX;
      l2 = this.wzT;
      if (localObject1 == null) {
        break label551;
      }
      bool1 = true;
      label435:
      com.tencent.mm.plugin.finder.report.k.a((Context)localObject2, l1, bool2, 1L, l2, bool1);
      localObject1 = findViewById(2131303401);
      p.g(localObject1, "it");
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
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((Context)getActivity(), this.sTp, false, 1L, this.wzU, false, 0L);
      }
      AppMethodBeat.o(255947);
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
  
  private static long dIH()
  {
    AppMethodBeat.i(255948);
    Object localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().asW("finder_wx_private_msg_entrance");
    if (localObject != null)
    {
      long l = ((bdo)localObject).count;
      AppMethodBeat.o(255948);
      return l;
    }
    AppMethodBeat.o(255948);
    return 0L;
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(255942);
    cd localcd = new cd(8);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localcd);
    AppMethodBeat.o(255942);
  }
  
  public final void a(apf paramapf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255944);
    p.h(paramapf, "cmdItem");
    Log.i("SimpleUIComponent", "cmdId " + paramapf.cmdId);
    switch (paramapf.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255944);
      return;
      dIF();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494623;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(255936);
    Object localObject;
    int i;
    boolean bool1;
    if (paramIntent != null)
    {
      localObject = FinderSelfUI.vOh;
      i = paramIntent.getIntExtra(FinderSelfUI.dAc(), 0);
      localObject = FinderSelfUI.vOh;
      if (paramInt1 != FinderSelfUI.dAa()) {
        break label144;
      }
      paramIntent = this.udb;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.LNS == i) {
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
      AppMethodBeat.o(255936);
      return;
      i = 0;
      break;
      label144:
      localObject = FinderSelfUI.vOh;
      if (paramInt1 == FinderSelfUI.dAb())
      {
        paramIntent = this.udb;
        bool1 = bool3;
        if (paramIntent != null)
        {
          bool1 = bool3;
          if (paramIntent.LNR == i) {
            bool1 = true;
          }
        }
        bool2 = true;
      }
      else
      {
        if ((paramInt1 == 10001) || (paramInt1 == 10000))
        {
          localObject = this.wyl;
          if (localObject != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject).bMo();
          }
          com.tencent.mm.plugin.finder.ui.g localg = this.wzG;
          if (localg != null)
          {
            String str = localg.TAG;
            StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
            if (paramIntent != null) {}
            for (localObject = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localObject = null)
            {
              Log.i(str, localObject);
              if ((paramInt1 == 10000) && (paramInt2 == -1))
              {
                if (paramIntent == null) {
                  break label352;
                }
                if (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1) {
                  localg.b(null);
                }
              }
              bool1 = true;
              bool2 = true;
              break;
            }
            label352:
            bool1 = true;
            bool2 = true;
            continue;
          }
        }
        bool1 = true;
        bool2 = true;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255935);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject1 = FinderSelfUI.vOh;
    this.wzX = paramBundle.getBooleanExtra(FinderSelfUI.dAd(), false);
    this.sTp = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.ah(aj.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((aj)paramBundle).getRedDotManager().asV("TLPersonalCenter");
    paramBundle = findViewById(2131302927);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new p(this));
    }
    paramBundle = findViewById(2131302928);
    localObject1 = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (!((ad)localObject1).dxX())
    {
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new u(this));
      }
    }
    paramBundle = findViewById(2131302926);
    localObject1 = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (!((ad)localObject1).dxX())
    {
      p.g(paramBundle, "jumpFav");
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener((View.OnClickListener)new v(this));
    }
    label529:
    Object localObject2;
    label647:
    int i;
    if (this.wAg)
    {
      paramBundle = com.tencent.mm.kernel.g.af(ad.class);
      p.g(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)paramBundle).dxX())
      {
        paramBundle = findViewById(2131302930);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = findViewById(2131302930);
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new w(this));
        }
        paramBundle = findViewById(2131303712);
        p.g(paramBundle, "findViewById(R.id.loading_progress_bar)");
        this.progressBar = ((ProgressBar)paramBundle);
        findViewById(2131302931).setOnClickListener((View.OnClickListener)new x(this));
        paramBundle = h.tKR;
        paramBundle = h.tKR;
        h.a(h.daS(), (LifecycleOwner)getActivity(), (Observer)new y(this));
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        paramBundle = ((PluginFinder)paramBundle).getRedDotManager().tJB;
        paramBundle.handler.post((Runnable)new a.b(paramBundle));
        if (!this.wAg) {
          break label1166;
        }
        findViewById(2131307601).setOnClickListener((View.OnClickListener)new z(this));
        paramBundle = findViewById(2131307601);
        p.g(paramBundle, "findViewById<View>(R.id.sendMsgLayout)");
        paramBundle.setVisibility(0);
        paramBundle = h.tKR;
        paramBundle = h.tKR;
        h.a(h.daV(), (LifecycleOwner)getActivity(), (Observer)new aa(this));
        paramBundle = h.tKR;
        paramBundle = h.tKR;
        h.a(h.daW(), (LifecycleOwner)getActivity(), (Observer)new ab(this));
        paramBundle = h.tKR;
        paramBundle = h.tKR;
        h.a(h.daM(), (LifecycleOwner)getActivity(), (Observer)new q(this));
        findViewById(2131302929).setOnClickListener((View.OnClickListener)new r(this));
        paramBundle = h.tKR;
        paramBundle = h.tKR;
        h.a(h.daZ(), (LifecycleOwner)getActivity(), (Observer)new s(this));
        localObject2 = new z.f();
        paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dwC().value()).intValue() != 2) {
          break label1190;
        }
        paramBundle = "https://channels.weixin.qq.com/mobile/creator_center.html";
        ((z.f)localObject2).SYG = paramBundle;
        paramBundle = y.vXH;
        if (y.dCM()) {
          u.makeText((Context)getContext(), (CharSequence)("creater url:" + (String)((z.f)localObject2).SYG), 1).show();
        }
        if (((CharSequence)((z.f)localObject2).SYG).length() <= 0) {
          break label1244;
        }
        i = 1;
        label725:
        if (i == 0) {
          break label1249;
        }
        paramBundle = findViewById(2131301402);
        p.g(paramBundle, "findViewById<View>(R.id.…_poster_service_entrance)");
        paramBundle.setVisibility(0);
        findViewById(2131301402).setOnClickListener((View.OnClickListener)new t(this, (z.f)localObject2));
        label772:
        dIE();
        dID();
        paramBundle = com.tencent.mm.kernel.g.af(ad.class);
        p.g(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad)paramBundle).dxX())
        {
          paramBundle = findViewById(2131302931);
          p.g(paramBundle, "findViewById<View>(R.id.jump_finder_wxmsg)");
          paramBundle.setVisibility(8);
          paramBundle = findViewById(2131301478);
          p.g(paramBundle, "findViewById<View>(R.id.finder_self_footer_root)");
          paramBundle.setVisibility(8);
          paramBundle = findViewById(2131302929);
          p.g(paramBundle, "findViewById<View>(R.id.jump_finder_management)");
          paramBundle.setVisibility(8);
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.f)this);
        com.tencent.mm.kernel.g.azz().a(3761, (com.tencent.mm.ak.i)this);
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().asW("TLCamera");
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().asX("TLCamera");
        paramBundle = y.vXH;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
            break label1276;
          }
          i = 0;
          label997:
          paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
          paramBundle = FinderReporterUIC.wzC;
          paramBundle = FinderReporterUIC.a.fH((Context)getActivity());
          if (paramBundle == null) {
            break label1281;
          }
          paramBundle = paramBundle.dIx();
          label1025:
          com.tencent.mm.plugin.finder.report.k.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
          paramBundle = j.vft;
          paramBundle = FinderReporterUIC.wzC;
          paramBundle = FinderReporterUIC.a.fH((Context)getActivity());
          if (paramBundle == null) {
            break label1286;
          }
        }
      }
    }
    label1281:
    label1286:
    for (paramBundle = paramBundle.dIx();; paramBundle = null)
    {
      j.a("4", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1, 1, paramBundle, 0, 0, 96);
      paramBundle = getIntent();
      localObject1 = FinderSelfUI.vOh;
      this.wAf = paramBundle.getBooleanExtra(FinderSelfUI.dAe(), false);
      this.wzG = dIC().dIm();
      dIC().wyn = ((kotlin.g.a.r)new ai(this));
      AppMethodBeat.o(255935);
      return;
      paramBundle = findViewById(2131302930);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label1166:
      paramBundle = findViewById(2131307601);
      p.g(paramBundle, "findViewById<View>(R.id.sendMsgLayout)");
      paramBundle.setVisibility(8);
      break label529;
      label1190:
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dwC().value()).intValue() == 1)
      {
        paramBundle = "https://finder-assistant-0.sparta.html5.qq.com/mobile/creator_center.html";
        break label647;
      }
      paramBundle = this.udb;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.LNX;
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break label647;
        }
      }
      paramBundle = "";
      break label647;
      label1244:
      i = 0;
      break label725;
      label1249:
      paramBundle = findViewById(2131301402);
      p.g(paramBundle, "findViewById<FrameLayout…_poster_service_entrance)");
      ((FrameLayout)paramBundle).setVisibility(8);
      break label772;
      label1276:
      i = 1;
      break label997;
      paramBundle = null;
      break label1025;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255946);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3761, (com.tencent.mm.ak.i)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.f)this);
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
    int i = i.a.dbo()[3];
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    if (i + ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlD, 0) <= 0)
    {
      localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().Iy(2);
    }
    localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().tJB.dat();
    localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().tJB.das();
    localObject = this.wzG;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.plugin.finder.ui.g)localObject).TAG, "destroy");
      com.tencent.mm.kernel.g.azz().b(5231, (com.tencent.mm.ak.i)localObject);
      AppMethodBeat.o(255946);
      return;
    }
    AppMethodBeat.o(255946);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(255937);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.finder.ui.g localg = this.wzG;
    if (localg != null)
    {
      p.h(paramArrayOfString, "permissions");
      p.h(paramArrayOfInt, "grantResults");
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
          localg.c(localg.vKV);
          AppMethodBeat.o(255937);
          return;
          i = 0;
          break;
        }
        label117:
        Log.i(localg.TAG, "FinderLive request permission " + paramInt + " failed");
      }
      AppMethodBeat.o(255937);
      return;
    }
    AppMethodBeat.o(255937);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255943);
    super.onResume();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
      AppMethodBeat.o(255943);
      throw ((Throwable)localObject);
    }
    ((com.tencent.mm.plugin.finder.extension.a)localObject).fX(45097, 1);
    this.wzE = com.tencent.mm.model.z.aUg();
    if (this.udb != null)
    {
      dIF();
      dIG();
      localObject = this.wzG;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.ui.g)localObject).a(this.udb);
      }
      localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().tJB;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(6);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(6);
      localObject = com.tencent.mm.plugin.finder.report.i.vfo;
      if (!this.wAf) {
        break label276;
      }
      i = 4;
      label170:
      com.tencent.mm.plugin.finder.report.i.H(true, i);
      localObject = this.wzK;
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label281;
      }
    }
    label276:
    label281:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vmk)
        {
          localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
          com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmu.hlf, "");
        }
      }
      AppMethodBeat.o(255943);
      return;
      if (Util.isNullOrNil(this.wzE))
      {
        localObject = this.progressBar;
        if (localObject == null) {
          p.btv("progressBar");
        }
        ((ProgressBar)localObject).setVisibility(0);
      }
      for (;;)
      {
        doPrepareUser();
        break;
        dIF();
      }
      i = 3;
      break label170;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(255945);
    Log.i("SimpleUIComponent", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramq instanceof cd))
    {
      paramString = this.progressBar;
      if (paramString == null) {
        p.btv("progressBar");
      }
      paramString.setVisibility(8);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.udb == null)
        {
          if (paramq == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
            AppMethodBeat.o(255945);
            throw paramString;
          }
          this.udb = ((cd)paramq).cZc();
          dIG();
        }
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
          AppMethodBeat.o(255945);
          throw paramString;
        }
        this.udb = ((cd)paramq).cZc();
        paramString = this.wzG;
        if (paramString != null) {
          paramString.a(this.udb);
        }
        dIF();
        AppMethodBeat.o(255945);
        return;
      }
      dIG();
      u.makeText((Context)getActivity(), 2131760430, 1).show();
    }
    AppMethodBeat.o(255945);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(255941);
    super.onStop();
    this.wzY = false;
    this.wzZ = "";
    this.wAa = "";
    this.wAb = "";
    this.wAc = "";
    this.wAd = "";
    this.wAe = "";
    AppMethodBeat.o(255941);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255897);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wAi.getIntent().putExtra("finder_username", FinderSelfUIC.i(this.wAi));
      this.wAi.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
      paramView = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wAi.getActivity(), this.wAi.getIntent(), 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.wAi.getActivity(), this.wAi.getIntent());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255897);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class aa<T>
    implements Observer<h.a>
  {
    aa(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class ab<T>
    implements Observer<h.a>
  {
    ab(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderLivePostBtnUIC>
  {
    ac(FinderSelfUIC paramFinderSelfUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255927);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().asW("ProfileEntrance");
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.k localk = ((PluginFinder)paramView).getRedDotManager().asX("ProfileEntrance");
      if ((localk != null) && (localObject != null))
      {
        paramView = j.vft;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView != null)
        {
          paramView = paramView.dIx();
          j.a("4", localk, (bdo)localObject, 2, paramView, 0, 0, 96);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().asV("ProfileEntrance");
        paramView = new Intent();
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = c.a.asG(com.tencent.mm.model.z.aUg());
        if (localObject == null) {
          p.hyc();
        }
        if (!((com.tencent.mm.plugin.finder.api.g)localObject).isBlock()) {
          break label301;
        }
        paramView.setClass((Context)this.wAi.getActivity(), FinderExposeUI.class);
        localObject = this.wAi.getActivity();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((AppCompatActivity)localObject).startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255927);
        return;
        paramView = null;
        break;
        label301:
        paramView.putExtra("finder_username", FinderSelfUIC.i(this.wAi));
        paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.wAi.getActivity(), paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.wAi.getActivity(), paramView);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(FinderSelfUIC paramFinderSelfUIC, int paramInt, com.tencent.mm.plugin.finder.extension.reddot.k paramk, bdo parambdo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255928);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      int i;
      if (j > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
          break label436;
        }
        i = 0;
        if (j > 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          int j = j;
          paramView = FinderReporterUIC.wzC;
          paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
          if (paramView == null) {
            break label441;
          }
          paramView = paramView.dIx();
          label109:
          com.tencent.mm.plugin.finder.report.k.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
        }
      }
      localObject = this.wAp;
      bdo localbdo = this.wAq;
      label181:
      boolean bool1;
      if ((localObject != null) && (localbdo != null))
      {
        paramView = j.vft;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView != null)
        {
          paramView = paramView.dIx();
          j.a("4", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, localbdo, 2, paramView, 0, 0, 96);
          paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
          p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)paramView).getRedDotManager().asV("AuthorProfileNotify");
        }
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.report.k.vfA;
        paramView = (Context)this.wAi.getActivity();
        long l1 = this.wAi.sTp;
        boolean bool2 = this.wAi.wzX;
        long l2 = this.wAi.wzS;
        if (j <= 0) {
          break label451;
        }
        bool1 = true;
        label272:
        com.tencent.mm.plugin.finder.report.k.a(paramView, l1, bool2, 2L, l2, bool1, j);
        paramView = new Intent();
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = c.a.asG(com.tencent.mm.model.z.aUg());
        if (localObject == null) {
          p.hyc();
        }
        if (!((com.tencent.mm.plugin.finder.api.g)localObject).isBlock()) {
          break label457;
        }
        paramView.setClass((Context)this.wAi.getActivity(), FinderExposeUI.class);
        localObject = this.wAi.getActivity();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((AppCompatActivity)localObject).startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255928);
        return;
        label436:
        i = 2;
        break;
        label441:
        paramView = null;
        break label109;
        paramView = null;
        break label181;
        label451:
        bool1 = false;
        break label272;
        label457:
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.wAi.getActivity(), paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.Y((Context)this.wAi.getActivity(), paramView);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class af
    implements View.OnClickListener
  {
    af(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255929);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderSelfUIC.e(this.wAi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255929);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ag
    implements Runnable
  {
    ag(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255930);
      FinderSelfUIC.g(this.wAi).performClick();
      AppMethodBeat.o(255930);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class ah<T>
    implements Observer<h.a>
  {
    ah(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, Integer, String, au, x>
  {
    ai(FinderSelfUIC paramFinderSelfUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class aj
    implements Runnable
  {
    aj(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(255933);
      this.tzy.performClick();
      AppMethodBeat.o(255933);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255898);
      this.wAi.findViewById(2131300731).performClick();
      AppMethodBeat.o(255898);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelfUIC paramFinderSelfUIC, z.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255899);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.report.i.vfo;
      int i;
      if (FinderSelfUIC.f(this.wAi))
      {
        i = 4;
        com.tencent.mm.plugin.finder.report.i.H(false, i);
        paramView = com.tencent.mm.plugin.finder.report.i.vfo;
        if (!FinderSelfUIC.f(this.wAi)) {
          break label449;
        }
        i = 4;
        label71:
        com.tencent.mm.plugin.finder.report.i.as(i, false);
        paramView = com.tencent.mm.plugin.finder.report.i.vfo;
        paramView = new StringBuilder();
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        com.tencent.mm.plugin.finder.report.i.auI(com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond());
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().asW("TLCamera");
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.k localk = ((PluginFinder)paramView).getRedDotManager().asX("TLCamera");
        paramView = y.vXH;
        if ((localObject != null) && (localk != null))
        {
          paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
            break label454;
          }
          i = 0;
          label206:
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          paramView = FinderReporterUIC.wzC;
          paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
          if (paramView == null) {
            break label459;
          }
          paramView = paramView.dIx();
          label237:
          com.tencent.mm.plugin.finder.report.k.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
          paramView = j.vft;
          paramView = FinderReporterUIC.wzC;
          paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
          if (paramView == null) {
            break label464;
          }
          paramView = paramView.dIx();
          label287:
          j.a("4", localk, (bdo)localObject, 2, paramView, 0, 0, 96);
        }
        paramView = com.tencent.mm.kernel.g.ah(aj.class);
        p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj)paramView).getRedDotManager().asV("TLCamera");
        paramView = y.vXH;
        if (y.an((Activity)this.wAi.getActivity()))
        {
          paramView = new Intent();
          if (!this.wAj.SYB) {
            break label469;
          }
          paramView.putExtra("key_create_scene", 4);
        }
      }
      for (;;)
      {
        paramView.putExtra("scene", 2);
        localObject = FinderSelfUIC.a(this.wAi);
        if (localObject != null) {
          paramView.putExtra("key_prepare_resp", ((bed)localObject).toByteArray());
        }
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.w((Context)this.wAi.getActivity(), paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255899);
        return;
        i = 3;
        break;
        label449:
        i = 3;
        break label71;
        label454:
        i = 1;
        break label206;
        label459:
        paramView = null;
        break label237;
        label464:
        paramView = null;
        break label287;
        label469:
        paramView.putExtra("key_create_scene", 1);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255900);
      FinderSelfUIC.g(this.wAi).performClick();
      AppMethodBeat.o(255900);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class e<T>
    implements Observer<h.a>
  {
    e(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255902);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderSelfRedPack");
      paramView = com.tencent.mm.kernel.g.ah(aj.class);
      p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)paramView).getRedDotManager().asV("FinderMyTabRedPack");
      paramView = com.tencent.mm.kernel.g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OmY, Boolean.TRUE);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.z((Context)this.wAi.getContext(), "wxb8f2d39684e3fe62", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255902);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255903);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = FinderSelfUIC.a(this.wAi);
      if (paramView != null)
      {
        localObject = y.vXH;
        if (y.an((Activity)this.wAi.getActivity())) {
          FinderSelfUIC.a(this.wAi, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255903);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255904);
      this.wAi.findViewById(2131300731).performClick();
      AppMethodBeat.o(255904);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements o.f
  {
    i(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(255905);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1001, 2131755822);
        paramm.kV(1002, 2131755831);
        com.tencent.mm.plugin.finder.utils.r localr = com.tencent.mm.plugin.finder.utils.r.vWn;
        com.tencent.mm.plugin.finder.utils.r.a(FinderSelfUIC.j(this.wAi), paramm);
      }
      AppMethodBeat.o(255905);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements o.g
  {
    j(FinderSelfUIC paramFinderSelfUIC, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255906);
      Intent localIntent = new Intent();
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        p.g(localIntent.putExtra("key_finder_post_router", 2), "intent.putExtra(Constant…uterUI.ROUTER_TAKE_PHOTO)");
      }
      do
      {
        for (;;)
        {
          localIntent.putExtra("key_finder_post_from", 5);
          localIntent.putExtra("key_finder_post_id", this.uPz);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.wAi.getActivity(), localIntent);
          AppMethodBeat.o(255906);
          return;
          if (paramMenuItem.getItemId() != 1002) {
            break;
          }
          p.g(localIntent.putExtra("key_finder_post_router", 3), "intent.putExtra(Constant…erUI.ROUTER_SELECT_PHOTO)");
        }
      } while (!FinderSelfUIC.j(this.wAi).containsKey(Integer.valueOf(paramMenuItem.getItemId())));
      com.tencent.mm.plugin.finder.utils.r localr = com.tencent.mm.plugin.finder.utils.r.vWn;
      com.tencent.mm.plugin.finder.utils.r.a((Context)this.wAi.getActivity(), (ddk)FinderSelfUIC.j(this.wAi).get(Integer.valueOf(paramMenuItem.getItemId())));
      paramMenuItem = com.tencent.mm.plugin.finder.report.i.vfo;
      if (FinderSelfUIC.f(this.wAi)) {}
      for (paramInt = 4;; paramInt = 3)
      {
        com.tencent.mm.plugin.finder.report.i.as(paramInt, false);
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class k
    implements e.b
  {
    public static final k wAk;
    
    static
    {
      AppMethodBeat.i(255908);
      wAk = new k();
      AppMethodBeat.o(255908);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(255907);
      com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Ks(6);
      AppMethodBeat.o(255907);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255909);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).bN((Context)this.wAi.getActivity(), "");
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, false, 2L, this.wAi.wzU, false, 0L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255909);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderSelfUIC paramFinderSelfUIC, com.tencent.mm.plugin.finder.extension.reddot.k paramk, bdo parambdo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255910);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      FinderSelfUIC.c(this.wAi).dIn();
      paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.dpl().a(s.ao.vqX);
      paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmv.hlf, "");
      paramView = FinderSelfUIC.d(this.wAi);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      localObject = this.wAl;
      bdo localbdo = this.wAm;
      if ((localObject != null) && (localbdo != null))
      {
        paramView = j.vft;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView == null) {
          break label260;
        }
      }
      label260:
      for (paramView = paramView.dIx();; paramView = null)
      {
        j.a("4", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, localbdo, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().asV("FinderSelfLiveEntrance");
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().e("FinderEntrance", new int[] { 1010 });
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().e("TLPersonalCenter", new int[] { 1010 });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255910);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<h.a>
  {
    n(FinderSelfUIC paramFinderSelfUIC, com.tencent.mm.plugin.finder.extension.reddot.k paramk, bdo parambdo) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255912);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderSelfUIC.e(this.wAi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255912);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255913);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wAi.getActivity(), paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.wAi.getActivity(), FinderFollowListUI.class);
      localObject = this.wAi.getActivity();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((AppCompatActivity)localObject).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzO, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255913);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class q<T>
    implements Observer<h.a>
  {
    q(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fD((Context)this.wAi.getActivity());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255915);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class s<T>
    implements Observer<h.a>
  {
    s(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(FinderSelfUIC paramFinderSelfUIC, z.f paramf) {}
    
    public final void onClick(View paramView)
    {
      boolean bool1 = false;
      AppMethodBeat.i(255917);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().asW("CreatorCenter");
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.k localk = ((PluginFinder)paramView).getRedDotManager().asX("CreatorCenter");
      if ((localk != null) && (localObject != null))
      {
        paramView = j.vft;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView == null) {
          break label269;
        }
      }
      label269:
      for (paramView = paramView.dIx();; paramView = null)
      {
        j.a("4", localk, (bdo)localObject, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.plugin.finder.report.k.vfA;
        paramView = (Context)this.wAi.getContext();
        long l1 = this.wAi.sTp;
        boolean bool2 = this.wAi.wzX;
        long l2 = this.wAi.wzT;
        if (localObject != null) {
          bool1 = true;
        }
        com.tencent.mm.plugin.finder.report.k.a(paramView, l1, bool2, 2L, l2, bool1);
        paramView = new Intent();
        paramView.putExtra("rawUrl", (String)this.wAn.SYG);
        com.tencent.mm.br.c.b((Context)this.wAi.getActivity(), "webview", ".ui.tools.WebViewUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255917);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      long l1 = 0L;
      AppMethodBeat.i(255918);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wAi.getActivity(), paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.wAi.getActivity(), FinderLikeFeedGridUI.class);
      paramView.putExtra("finder_username", com.tencent.mm.model.z.aUg());
      localObject = this.wAi.getActivity();
      FinderSelfUI.a locala = FinderSelfUI.vOh;
      ((AppCompatActivity)localObject).startActivityForResult(paramView, FinderSelfUI.dAb());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      paramView = (Context)this.wAi.getActivity();
      long l2 = this.wAi.sTp;
      boolean bool = this.wAi.wzX;
      long l3 = this.wAi.wzP;
      localObject = FinderSelfUIC.a(this.wAi);
      if (localObject != null) {
        l1 = ((bed)localObject).LNR;
      }
      com.tencent.mm.plugin.finder.report.k.a(paramView, l2, bool, 2L, l3, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255918);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255919);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramView).getRedDotManager().asW("Personal_Center_FavList_Entrance");
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)paramView).getRedDotManager().asX("Personal_Center_FavList_Entrance");
      paramView = y.vXH;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.k.vfA;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView == null) {
          break label296;
        }
        paramView = paramView.dIx();
        com.tencent.mm.plugin.finder.report.k.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
        paramView = j.vft;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
        if (paramView == null) {
          break label301;
        }
      }
      label296:
      label301:
      for (paramView = paramView.dIx();; paramView = null)
      {
        j.a("4", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ah(aj.class);
        p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj)paramView).getRedDotManager().asV("Personal_Center_FavList_Entrance");
        paramView = new Intent();
        localObject1 = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.wAi.getActivity(), paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject1 = this.wAi.getActivity();
        if (localObject1 != null) {
          break label306;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255919);
        throw paramView;
        paramView = null;
        break;
      }
      label306:
      localObject1 = (MMActivity)localObject1;
      localObject2 = FinderSelfUI.vOh;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)localObject1, paramView, FinderSelfUI.dAa());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      paramView = (Context)this.wAi.getActivity();
      long l2 = this.wAi.sTp;
      boolean bool = this.wAi.wzX;
      long l3 = this.wAi.wzQ;
      localObject1 = FinderSelfUIC.a(this.wAi);
      if (localObject1 != null) {}
      for (long l1 = ((bed)localObject1).LNS;; l1 = 0L)
      {
        com.tencent.mm.plugin.finder.report.k.a(paramView, l2, bool, 2L, l3, false, l1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255919);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255920);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fB((Context)this.wAi.getActivity());
      long l1 = FinderSelfUIC.dII();
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      paramView = (Context)this.wAi.getActivity();
      long l2 = this.wAi.sTp;
      boolean bool2 = this.wAi.wzX;
      long l3 = this.wAi.wzW;
      boolean bool1;
      com.tencent.mm.plugin.finder.extension.reddot.k localk;
      if (l1 > 0L)
      {
        bool1 = true;
        com.tencent.mm.plugin.finder.report.k.a(paramView, l2, bool2, 2L, l3, bool1, l1);
        paramView = com.tencent.mm.plugin.finder.report.d.vdp;
        com.tencent.mm.plugin.finder.report.d.dnF().R(2L, 0L);
        paramView = com.tencent.mm.plugin.finder.report.d.vdp;
        com.tencent.mm.plugin.finder.report.d.dnJ().vdE = FinderSelfUIC.dII();
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().asW("finder_wx_private_msg_entrance");
        paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localk = ((PluginFinder)paramView).getRedDotManager().asX("finder_wx_private_msg_entrance");
        if ((localObject != null) && (localk != null))
        {
          paramView = j.vft;
          paramView = FinderReporterUIC.wzC;
          paramView = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
          if (paramView == null) {
            break label284;
          }
        }
      }
      label284:
      for (paramView = paramView.dIx();; paramView = null)
      {
        j.a("4", localk, (bdo)localObject, 3, paramView, 0, 0, 96);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255920);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255921);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fu((Context)this.wAi.getActivity());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzR, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255921);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class y<T>
    implements Observer<h.a>
  {
    y(FinderSelfUIC paramFinderSelfUIC) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class z
    implements View.OnClickListener
  {
    z(FinderSelfUIC paramFinderSelfUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255923);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.k localk = ((PluginFinder)paramView).getRedDotManager().asX("finder_private_msg_entrance");
      if (localk != null)
      {
        paramView = localk.atl("finder_private_msg_entrance");
        if ((localk == null) || (localk.field_ctrInfo.type != 1007)) {
          break label275;
        }
        localObject = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, true, 0L);
        if (paramView != null)
        {
          localObject = j.vft;
          localObject = FinderReporterUIC.wzC;
          localObject = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
          if (localObject == null) {
            break label270;
          }
          localObject = ((FinderReporterUIC)localObject).dIx();
          label170:
          j.a("4", localk, paramView, 2, (bbn)localObject, 0, 0, 96);
        }
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.finder.report.d.vdp;
        com.tencent.mm.plugin.finder.report.d.dnF().R(1L, 0L);
        paramView = com.tencent.mm.kernel.g.ah(aj.class);
        p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj)paramView).getRedDotManager().asV("finder_private_msg_entrance");
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderConversationUI((Context)this.wAi.getActivity());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255923);
        return;
        paramView = null;
        break;
        label270:
        localObject = null;
        break label170;
        label275:
        if ((localk != null) && (localk.field_ctrInfo.type == 1006))
        {
          int i;
          if (paramView != null)
          {
            i = paramView.count;
            label303:
            localObject = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, true, i);
            if (paramView == null) {
              continue;
            }
            localObject = j.vft;
            localObject = FinderReporterUIC.wzC;
            localObject = FinderReporterUIC.a.fH((Context)this.wAi.getActivity());
            if (localObject == null) {
              break label404;
            }
          }
          label404:
          for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
          {
            j.a("4", localk, paramView, 3, (bbn)localObject, 0, 0, 96);
            break;
            i = 0;
            break label303;
          }
        }
        else
        {
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a((Context)this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, false, 0L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC
 * JD-Core Version:    0.7.0.1
 */