package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.extension.reddot.a.b;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderNewUIA;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "BANNER_TYPE_FAV", "", "getBANNER_TYPE_FAV", "()J", "BANNER_TYPE_FINDER_MSG", "getBANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FOLLOW", "getBANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "getBANNER_TYPE_LIKE", "BANNER_TYPE_WX_MSG", "getBANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "getBANNER_TYPE_WX_PRIVATE_MESSAGE", "TAG", "", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "(J)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "()Ljava/lang/String;", "setHasExposeFinderHiMsgTips", "(Ljava/lang/String;)V", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeProfileEntranceTips", "getHasExposeProfileEntranceTips", "setHasExposeProfileEntranceTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "", "getHasReportFinderMsg", "()Z", "setHasReportFinderMsg", "(Z)V", "isEnableSendMsgEntrance", "isFromSnsPost", "isReportRedDotExpose", "lastFavTipsId", "myFinderUsername", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "Landroid/view/View;", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getLayoutId", "", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "Companion", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.finder.api.f
{
  private static final int sRB = 1;
  private static final int sRC = 2;
  private static final String sRD = "INNER_ITEM_COUNT";
  private static final String sRE = "RED_DOT_EXIST_ON_ENTER";
  private static final String sRF = "key_from_sns_post";
  public static final FinderSelfUI.a sRG;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private String sRA;
  private String sRj;
  private boolean sRk;
  final long sRl;
  final long sRm;
  final long sRn;
  final long sRo;
  final long sRp;
  final long sRq;
  final long sRr;
  boolean sRs;
  private boolean sRt;
  String sRu;
  String sRv;
  String sRw;
  String sRx;
  private boolean sRy;
  private final boolean sRz;
  private atf sqs;
  long sxe;
  
  static
  {
    AppMethodBeat.i(204772);
    sRG = new FinderSelfUI.a((byte)0);
    sRB = 1;
    sRC = 2;
    sRD = "INNER_ITEM_COUNT";
    sRE = "RED_DOT_EXIST_ON_ENTER";
    sRF = "key_from_sns_post";
    AppMethodBeat.o(204772);
  }
  
  public FinderSelfUI()
  {
    AppMethodBeat.i(204771);
    this.TAG = "Finder.FinderSelfUI";
    this.sRl = 1L;
    this.sRm = 2L;
    this.sRn = 3L;
    this.sRo = 4L;
    this.sRp = 5L;
    this.sRq = 6L;
    this.sRr = 7L;
    this.sRu = "";
    this.sRv = "";
    this.sRw = "";
    this.sRx = "";
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJP().value()).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.sRz = bool;
      this.sRA = "";
      AppMethodBeat.o(204771);
      return;
    }
  }
  
  private final void cMM()
  {
    AppMethodBeat.i(167591);
    this.sRj = com.tencent.mm.model.v.aAK();
    ae.i(this.TAG, "myFinderUser " + this.sRj);
    Object localObject1 = findViewById(2131300680);
    Object localObject2 = findViewById(2131302875);
    Object localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
    switch (com.tencent.mm.plugin.finder.utils.p.cOn())
    {
    default: 
      ae.d(this.TAG, "not one of six state");
      localObject1 = this.sqs;
      if (localObject1 != null)
      {
        if (((atf)localObject1).GKh <= 0) {
          break label2703;
        }
        localObject2 = (TextView)_$_findCachedViewById(2131308142);
        d.g.b.p.g(localObject2, "like_feed_count");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gf(((atf)localObject1).GKh));
        localObject2 = (TextView)_$_findCachedViewById(2131308142);
        d.g.b.p.g(localObject2, "like_feed_count");
        ((TextView)localObject2).setVisibility(0);
        label195:
        if (((atf)localObject1).GKi <= 0) {
          break label2733;
        }
        localObject2 = (TextView)_$_findCachedViewById(2131308103);
        d.g.b.p.g(localObject2, "fav_feed_count");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gf(((atf)localObject1).GKi));
        localObject2 = (TextView)_$_findCachedViewById(2131308103);
        d.g.b.p.g(localObject2, "fav_feed_count");
        ((TextView)localObject2).setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      ae.i(this.TAG, "likeCount = " + ((atf)localObject1).GKh + ",favCount = " + ((atf)localObject1).GKi);
      localObject1 = (TextView)_$_findCachedViewById(2131307415);
      d.g.b.p.g(localObject1, "finder_post_new_feed");
      al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131307432);
      d.g.b.p.g(localObject1, "finder_self_account_state");
      ((LinearLayout)localObject1).setVisibility(0);
      AppMethodBeat.o(167591);
      return;
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ae.d(this.TAG, "账户无发表权限");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
      break;
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ae.d(this.TAG, "有发表权限但未创建账号");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
      d.g.b.p.g(localObject1, "msg_ll");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307388);
      d.g.b.p.g(localObject1, "finder_account_area");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131308195);
      d.g.b.p.g(localObject1, "sendMsgLayout");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = findViewById(2131307912);
      ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      if ((getIntent().getBooleanExtra(sRF, false)) && (this.sqs != null))
      {
        ((View)localObject1).post((Runnable)new FinderSelfUI.e((View)localObject1));
        getIntent().removeExtra(sRF);
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBz(), (LifecycleOwner)this, (Observer)new f(this));
      break;
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ae.d(this.TAG, "账户正常");
      localObject3 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      d.g.b.p.g(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
      ((com.tencent.mm.plugin.i.a.t)localObject3).getRedDotManager().aih("TLCamera");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject3 = findViewById(2131307388);
      localObject1 = findViewById(2131307876);
      Object localObject4 = (ImageView)findViewById(2131299973);
      Object localObject5 = (TextView)findViewById(2131300016);
      localObject2 = (TextView)findViewById(2131307414);
      Object localObject6 = c.rPy;
      localObject6 = this.sRj;
      if (localObject6 == null) {
        d.g.b.p.gkB();
      }
      localObject6 = c.a.ahT((String)localObject6);
      ImageView localImageView = (ImageView)findViewById(2131296977);
      Object localObject7;
      label890:
      int i;
      label1135:
      final int k;
      final int m;
      label1361:
      label1403:
      long l1;
      label1438:
      label1459:
      label1500:
      label1517:
      boolean bool2;
      long l2;
      if (this.sRz)
      {
        localObject7 = (FrameLayout)_$_findCachedViewById(2131308195);
        d.g.b.p.g(localObject7, "sendMsgLayout");
        ((FrameLayout)localObject7).setVisibility(0);
        if (localObject6 != null)
        {
          localObject7 = com.tencent.mm.plugin.finder.loader.i.srW;
          localObject7 = com.tencent.mm.plugin.finder.loader.i.cEo();
          com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject6).czm());
          d.g.b.p.g(localObject4, "finderAvatar");
          com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
          ((com.tencent.mm.loader.d)localObject7).a(locala, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
          d.g.b.p.g(localObject5, "finderNickname");
          ((TextView)localObject5).setText((CharSequence)k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject6).VK()));
          al.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
          localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
          d.g.b.p.g(localImageView, "authIcon");
          com.tencent.mm.plugin.finder.utils.p.a(localImageView, ((com.tencent.mm.plugin.finder.api.g)localObject6).field_authInfo);
          localObject4 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject4, "MMKernel.storage()");
          i = ((com.tencent.mm.kernel.e)localObject4).ajA().getInt(am.a.Jcy, 0);
          if (i <= 0) {
            break label1730;
          }
          localObject4 = (TextView)_$_findCachedViewById(2131307400);
          d.g.b.p.g(localObject4, "finder_follow_count");
          ((TextView)localObject4).setVisibility(0);
          localObject4 = (TextView)_$_findCachedViewById(2131307400);
          d.g.b.p.g(localObject4, "finder_follow_count");
          localObject5 = getContext();
          d.g.b.p.g(localObject5, "context");
          ((TextView)localObject4).setText((CharSequence)((AppCompatActivity)localObject5).getResources().getString(2131759206, new Object[] { String.valueOf(i) }));
        }
        d.g.b.p.g(localObject3, "finderAccountArea");
        ((View)localObject3).setVisibility(0);
        d.g.b.p.g(localObject1, "finderMsgArea");
        ((View)localObject1).setVisibility(0);
        localObject4 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        localObject4 = d.a.cBp();
        final int j = localObject4[0];
        k = localObject4[1];
        m = j + k;
        ae.i(this.TAG, "redDot check normalCount :" + j + " systemCount " + k);
        ((View)localObject3).setOnClickListener((View.OnClickListener)new w(this));
        localObject3 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
        localObject3 = ((PluginFinder)localObject3).getRedDotManager().aij("AuthorProfileNotify");
        localObject4 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
        localObject4 = ((PluginFinder)localObject4).getRedDotManager().aii("AuthorProfileNotify");
        ((View)localObject1).setOnClickListener((View.OnClickListener)new x(this, m, j, k, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject3, (ast)localObject4));
        if (m <= 0) {
          break label1855;
        }
        d.g.b.p.g(localObject2, "finderMsg");
        ((TextView)localObject2).setVisibility(0);
        if (m <= 999) {
          break label1760;
        }
        localObject1 = (CharSequence)"999+";
        ((TextView)localObject2).setText((CharSequence)localObject1);
        if (!this.sRk)
        {
          this.sRk = true;
          localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
            break label1773;
          }
          i = 0;
          if (j <= 0) {
            break label1784;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
          localObject1 = FinderReporterUIC.tnG;
          localObject1 = FinderReporterUIC.a.fc((Context)this);
          if (localObject1 == null) {
            break label1778;
          }
          localObject1 = ((FinderReporterUIC)localObject1).cQZ();
          com.tencent.mm.plugin.finder.report.i.a("4", 1, 1, 5, i, j, null, null, 0L, (arn)localObject1, 0, 0, 3520);
          if ((localObject3 != null) && (localObject4 != null))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.h.syO;
            localObject1 = FinderReporterUIC.tnG;
            localObject1 = FinderReporterUIC.a.fc((Context)this);
            if (localObject1 == null) {
              break label1849;
            }
            localObject1 = ((FinderReporterUIC)localObject1).cQZ();
            com.tencent.mm.plugin.finder.report.h.a("4", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject3, (ast)localObject4, 1, (arn)localObject1, 0, 0, 96);
          }
        }
        localObject1 = findViewById(2131307912);
        ((View)localObject1).setOnClickListener((View.OnClickListener)new FinderSelfUI.y(this));
        d.g.b.p.g(localObject1, "postBtn");
        ((View)localObject1).setVisibility(0);
        if (getIntent().getBooleanExtra(sRF, false))
        {
          ((View)localObject1).post((Runnable)new FinderSelfUI.z((View)localObject1));
          getIntent().removeExtra(sRF);
        }
        if (!this.sRt)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
          localObject1 = getContext();
          d.g.b.p.g(localObject1, "context");
          localObject1 = (Context)localObject1;
          l1 = this.sxe;
          bool2 = this.sRs;
          l2 = this.sRp;
          if (m <= 0) {
            break label1873;
          }
        }
      }
      label1730:
      label1873:
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, l1, bool2, 1L, l2, bool1, m);
        this.sRt = true;
        ae.i(this.TAG, "show finder msg red, totalCount:".concat(String.valueOf(m)));
        break;
        localObject7 = (FrameLayout)_$_findCachedViewById(2131308195);
        d.g.b.p.g(localObject7, "sendMsgLayout");
        ((FrameLayout)localObject7).setVisibility(8);
        break label890;
        localObject4 = (TextView)_$_findCachedViewById(2131307400);
        d.g.b.p.g(localObject4, "finder_follow_count");
        ((TextView)localObject4).setVisibility(8);
        break label1135;
        label1760:
        localObject1 = (CharSequence)String.valueOf(m);
        break label1361;
        label1773:
        i = 2;
        break label1403;
        label1778:
        localObject1 = null;
        break label1438;
        label1784:
        if (k <= 0) {
          break label1459;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
        localObject1 = FinderReporterUIC.tnG;
        localObject1 = FinderReporterUIC.a.fc((Context)this);
        if (localObject1 != null) {}
        for (localObject1 = ((FinderReporterUIC)localObject1).cQZ();; localObject1 = null)
        {
          com.tencent.mm.plugin.finder.report.i.a("4", 4, 1, 5, i, k, null, null, 0L, (arn)localObject1, 0, 0, 3520);
          break;
        }
        localObject1 = null;
        break label1500;
        d.g.b.p.g(localObject2, "finderMsg");
        ((TextView)localObject2).setVisibility(8);
        break label1517;
      }
      label1849:
      label1855:
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ae.d(this.TAG, "账户封禁");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
      d.g.b.p.g(localObject1, "msg_ll");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307912);
      d.g.b.p.g(localObject1, "postBtn");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a("");
      localObject3 = (ImageView)_$_findCachedViewById(2131299973);
      d.g.b.p.g(localObject3, "finder_avatar_iv");
      localObject4 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      localObject1 = (TextView)_$_findCachedViewById(2131300016);
      d.g.b.p.g(localObject1, "finder_nick_tv");
      ((TextView)localObject1).setText((CharSequence)getResources().getString(2131764440));
      localObject1 = (TextView)_$_findCachedViewById(2131300067);
      d.g.b.p.g(localObject1, "finder_self_msg_tv");
      ((TextView)localObject1).setVisibility(0);
      ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new FinderSelfUI.b(this));
      if (getIntent().getBooleanExtra(sRF, false))
      {
        ((FrameLayout)_$_findCachedViewById(2131307388)).post((Runnable)new c(this));
        getIntent().removeExtra(sRF);
      }
      localObject1 = (FrameLayout)_$_findCachedViewById(2131308195);
      d.g.b.p.g(localObject1, "sendMsgLayout");
      ((FrameLayout)localObject1).setVisibility(8);
      break;
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ae.d(this.TAG, "账户审核中");
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      localObject5 = (ImageView)findViewById(2131299973);
      localObject3 = (TextView)findViewById(2131300016);
      localObject4 = (TextView)findViewById(2131300073);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
      d.g.b.p.g(localObject1, "msg_ll");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131307912);
      d.g.b.p.g(localObject1, "postBtn");
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject6 = com.tencent.mm.plugin.finder.loader.i.cEo();
      localObject1 = this.sqs;
      if (localObject1 != null)
      {
        localObject1 = ((atf)localObject1).verifyInfo;
        if (localObject1 != null)
        {
          localObject2 = ((aqk)localObject1).jpU;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label2416;
          }
        }
      }
      localObject1 = "";
      label2416:
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      d.g.b.p.g(localObject5, "finderAvatar");
      localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      d.g.b.p.g(localObject3, "finderNickname");
      localObject2 = (Context)this;
      localObject1 = this.sqs;
      if (localObject1 != null)
      {
        localObject1 = ((atf)localObject1).verifyInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((aqk)localObject1).GHl;; localObject1 = null)
      {
        ((TextView)localObject3).setText((CharSequence)k.c((Context)localObject2, (CharSequence)localObject1));
        al.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
        d.g.b.p.g(localObject4, "finderState");
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText((CharSequence)getResources().getString(2131759342));
        localObject1 = findViewById(2131307876);
        d.g.b.p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
        ((View)localObject1).setVisibility(8);
        ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new g(this));
        if ((getIntent().getBooleanExtra(sRF, false)) && (this.sqs != null))
        {
          ((FrameLayout)_$_findCachedViewById(2131307388)).post((Runnable)new h(this));
          getIntent().removeExtra(sRF);
        }
        localObject1 = (FrameLayout)_$_findCachedViewById(2131308195);
        d.g.b.p.g(localObject1, "sendMsgLayout");
        ((FrameLayout)localObject1).setVisibility(8);
        break;
      }
      label2703:
      localObject2 = (TextView)_$_findCachedViewById(2131308142);
      d.g.b.p.g(localObject2, "like_feed_count");
      ((TextView)localObject2).setVisibility(8);
      break label195;
      label2733:
      localObject2 = (TextView)_$_findCachedViewById(2131308103);
      d.g.b.p.g(localObject2, "fav_feed_count");
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  private final void cMN()
  {
    AppMethodBeat.i(204769);
    Object localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
    localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, this.sxe, this.sRs, 1L, this.sRl);
    localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
    localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    long l2 = this.sxe;
    boolean bool1 = this.sRs;
    long l3 = this.sRm;
    Object localObject2 = this.sqs;
    long l1;
    label184:
    boolean bool2;
    label285:
    label336:
    int i;
    if (localObject2 != null)
    {
      l1 = ((atf)localObject2).GKh;
      com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      l2 = this.sxe;
      bool1 = this.sRs;
      l3 = this.sRn;
      localObject2 = this.sqs;
      if (localObject2 == null) {
        break label446;
      }
      l1 = ((atf)localObject2).GKi;
      com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, this.sxe, this.sRs, 1L, this.sRo);
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().aij("finder_private_msg_entrance");
      if (localObject1 == null) {
        break label451;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).aim("finder_private_msg_entrance");
      localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      l1 = this.sxe;
      bool2 = this.sRs;
      l2 = this.sRq;
      if (localObject1 == null) {
        break label457;
      }
      bool1 = true;
      if (localObject1 == null) {
        break label463;
      }
      i = ((ast)localObject1).count;
      label347:
      com.tencent.mm.plugin.finder.report.i.a((Context)localObject2, l1, bool2, 1L, l2, bool1, i);
      l1 = cMO();
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      l2 = this.sxe;
      bool2 = this.sRs;
      l3 = this.sRr;
      if (l1 <= 0L) {
        break label468;
      }
    }
    label446:
    label451:
    label457:
    label463:
    label468:
    for (bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.report.i.a((Context)localObject1, l2, bool2, 1L, l3, bool1, l1);
      AppMethodBeat.o(204769);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label184;
      localObject1 = null;
      break label285;
      bool1 = false;
      break label336;
      i = 0;
      break label347;
    }
  }
  
  private static long cMO()
  {
    AppMethodBeat.i(204770);
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().aii("finder_wx_private_msg_entrance");
    if (localObject != null)
    {
      long l = ((ast)localObject).count;
      AppMethodBeat.o(204770);
      return l;
    }
    AppMethodBeat.o(204770);
    return 0L;
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(204768);
    ay localay = new ay(8);
    com.tencent.mm.kernel.g.ajj().b((n)localay);
    AppMethodBeat.o(204768);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204776);
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
    AppMethodBeat.o(204776);
    return localView1;
  }
  
  public final void a(ama paramama)
  {
    AppMethodBeat.i(167593);
    d.g.b.p.h(paramama, "cmdItem");
    ae.i(this.TAG, "cmdId " + paramama.cmdId);
    switch (paramama.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(167593);
      return;
      cMM();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494106;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167590);
    findViewById(2131301238).setOnClickListener((View.OnClickListener)new l(this));
    findViewById(2131301239).setOnClickListener((View.OnClickListener)new o(this));
    findViewById(2131307484).setOnClickListener((View.OnClickListener)new p(this));
    Object localObject;
    if (this.sRz)
    {
      localObject = (LinearLayout)_$_findCachedViewById(2131308138);
      d.g.b.p.g(localObject, "jump_finder_private_msg");
      ((LinearLayout)localObject).setVisibility(0);
      ((LinearLayout)_$_findCachedViewById(2131308138)).setOnClickListener((View.OnClickListener)new q(this));
      localObject = findViewById(2131301509);
      d.g.b.p.g(localObject, "findViewById(R.id.loading_progress_bar)");
      this.progressBar = ((ProgressBar)localObject);
      findViewById(2131307912).setOnClickListener((View.OnClickListener)new FinderSelfUI.r(this));
      findViewById(2131307485).setOnClickListener((View.OnClickListener)new s(this));
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBG(), (LifecycleOwner)this, (Observer)new t(this));
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().sax;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.post((Runnable)new a.b((com.tencent.mm.plugin.finder.extension.reddot.a)localObject));
      if (!this.sRz) {
        break label436;
      }
      ((FrameLayout)_$_findCachedViewById(2131308195)).setOnClickListener((View.OnClickListener)new u(this));
      localObject = (FrameLayout)_$_findCachedViewById(2131308195);
      d.g.b.p.g(localObject, "sendMsgLayout");
      ((FrameLayout)localObject).setVisibility(0);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBJ(), (LifecycleOwner)this, (Observer)new v(this));
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBK(), (LifecycleOwner)this, (Observer)new m(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBA(), (LifecycleOwner)this, (Observer)new n(this));
      AppMethodBeat.o(167590);
      return;
      localObject = (LinearLayout)_$_findCachedViewById(2131308138);
      d.g.b.p.g(localObject, "jump_finder_private_msg");
      ((LinearLayout)localObject).setVisibility(8);
      break;
      label436:
      localObject = (FrameLayout)_$_findCachedViewById(2131308195);
      d.g.b.p.g(localObject, "sendMsgLayout");
      ((FrameLayout)localObject).setVisibility(8);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(204766);
    boolean bool1;
    if (paramIntent != null)
    {
      paramInt2 = paramIntent.getIntExtra(sRD, 0);
      if (paramInt1 != sRB) {
        break label132;
      }
      paramIntent = this.sqs;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.GKi == paramInt2) {
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
        ae.i(this.TAG, "ifFavCountEquals = " + bool2 + ",ifLikeCountEquals = " + bool1);
        doPrepareUser();
      }
      AppMethodBeat.o(204766);
      return;
      paramInt2 = 0;
      break;
      label132:
      if (paramInt1 == sRC)
      {
        paramIntent = this.sqs;
        bool1 = bool3;
        if (paramIntent != null)
        {
          bool1 = bool3;
          if (paramIntent.GKh == paramInt2) {
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
    AppMethodBeat.i(167589);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderSelfUI.aa(this));
    this.sRs = getIntent().getBooleanExtra(sRE, false);
    this.sxe = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((com.tencent.mm.plugin.i.a.t)paramBundle).getRedDotManager().aih("TLPersonalCenter");
    initView();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.ajj().a(3761, (com.tencent.mm.ak.f)this);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ast localast = ((PluginFinder)paramBundle).getRedDotManager().aii("TLCamera");
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramBundle).getRedDotManager().aij("TLCamera");
    paramBundle = com.tencent.mm.plugin.finder.utils.p.sXz;
    int i;
    if ((localast != null) && (locali != null))
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
        break label325;
      }
      i = 0;
      paramBundle = com.tencent.mm.plugin.finder.report.i.syT;
      paramBundle = FinderReporterUIC.tnG;
      paramBundle = FinderReporterUIC.a.fc((Context)this);
      if (paramBundle == null) {
        break label330;
      }
      paramBundle = paramBundle.cQZ();
      label243:
      com.tencent.mm.plugin.finder.report.i.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
      paramBundle = com.tencent.mm.plugin.finder.report.h.syO;
      paramBundle = FinderReporterUIC.tnG;
      paramBundle = FinderReporterUIC.a.fc((Context)this);
      if (paramBundle == null) {
        break label335;
      }
    }
    label325:
    label330:
    label335:
    for (paramBundle = paramBundle.cQZ();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.h.a("4", locali, localast, 1, paramBundle, 0, 0, 96);
      this.sRy = getIntent().getBooleanExtra(sRF, false);
      AppMethodBeat.o(167589);
      return;
      i = 1;
      break;
      paramBundle = null;
      break label243;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167595);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.f)this);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jde, 0);
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jdf, 0);
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    if (i + j + ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jcz, 0) <= 0)
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)localObject).getRedDotManager(), 2);
    }
    localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().sax.cBi();
    localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().sax.cBh();
    AppMethodBeat.o(167595);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167592);
    super.onResume();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
      AppMethodBeat.o(167592);
      throw ((Throwable)localObject);
    }
    ((com.tencent.mm.plugin.finder.extension.a)localObject).fG(12329, 1);
    this.sRj = com.tencent.mm.model.v.aAK();
    if (this.sqs != null)
    {
      cMM();
      cMN();
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().sax;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(6);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(6);
      localObject = com.tencent.mm.plugin.finder.report.g.syJ;
      if (!this.sRy) {
        break label208;
      }
    }
    label208:
    for (int i = 4;; i = 3)
    {
      com.tencent.mm.plugin.finder.report.g.G(true, i);
      AppMethodBeat.o(167592);
      return;
      if (bu.isNullOrNil(this.sRj))
      {
        localObject = this.progressBar;
        if (localObject == null) {
          d.g.b.p.bdF("progressBar");
        }
        ((ProgressBar)localObject).setVisibility(0);
      }
      for (;;)
      {
        doPrepareUser();
        break;
        cMM();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167594);
    ae.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.progressBar;
    if (paramString == null) {
      d.g.b.p.bdF("progressBar");
    }
    paramString.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.sqs == null)
      {
        if (paramn == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
          AppMethodBeat.o(167594);
          throw paramString;
        }
        this.sqs = ((ay)paramn).cAk();
        cMN();
      }
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167594);
        throw paramString;
      }
      this.sqs = ((ay)paramn).cAk();
      cMM();
      AppMethodBeat.o(167594);
      return;
    }
    cMN();
    com.tencent.mm.ui.base.t.makeText((Context)this, 2131759307, 1).show();
    AppMethodBeat.o(167594);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(204767);
    super.onStop();
    this.sRt = false;
    this.sRu = "";
    this.sRv = "";
    this.sRw = "";
    this.sRx = "";
    AppMethodBeat.o(204767);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderSelfUI paramFinderSelfUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204742);
      ((FrameLayout)this.sRH._$_findCachedViewById(2131307388)).performClick();
      AppMethodBeat.o(204742);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204743);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.report.g.syJ;
      int i;
      label71:
      com.tencent.mm.plugin.finder.extension.reddot.i locali;
      if (FinderSelfUI.e(this.sRH))
      {
        i = 4;
        com.tencent.mm.plugin.finder.report.g.G(false, i);
        paramView = com.tencent.mm.plugin.finder.report.g.syJ;
        if (!FinderSelfUI.e(this.sRH)) {
          break label417;
        }
        i = 4;
        com.tencent.mm.plugin.finder.report.g.am(i, false);
        paramView = com.tencent.mm.plugin.finder.report.g.syJ;
        paramView = new StringBuilder();
        d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
        com.tencent.mm.plugin.finder.report.g.aiK(com.tencent.mm.kernel.a.aiF() + '_' + bu.fpO());
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().aii("TLCamera");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locali = ((PluginFinder)paramView).getRedDotManager().aij("TLCamera");
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        if ((localObject != null) && (locali != null))
        {
          paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
            break label422;
          }
          i = 0;
          label206:
          paramView = com.tencent.mm.plugin.finder.report.i.syT;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label427;
          }
          paramView = paramView.cQZ();
          label234:
          com.tencent.mm.plugin.finder.report.i.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
          paramView = com.tencent.mm.plugin.finder.report.h.syO;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label432;
          }
        }
      }
      label417:
      label422:
      label427:
      label432:
      for (paramView = paramView.cQZ();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.h.a("4", locali, (ast)localObject, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().aih("TLCamera");
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.aq((Activity)this.sRH))
        {
          paramView = new Intent();
          paramView.putExtra("scene", 2);
          localObject = FinderSelfUI.a(this.sRH);
          if (localObject != null) {
            paramView.putExtra("key_prepare_resp", ((atf)localObject).toByteArray());
          }
          localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.w((Context)this.sRH, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204743);
        return;
        i = 3;
        break;
        i = 3;
        break label71;
        i = 1;
        break label206;
        paramView = null;
        break label234;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class f<T>
    implements Observer<g.a>
  {
    f(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204746);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = FinderSelfUI.a(this.sRH);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.aq((Activity)this.sRH)) {
          FinderSelfUI.a(this.sRH, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204746);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderSelfUI paramFinderSelfUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204747);
      ((FrameLayout)this.sRH._$_findCachedViewById(2131307388)).performClick();
      AppMethodBeat.o(204747);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.e
  {
    j(FinderSelfUI paramFinderSelfUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(204750);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.spL);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.sRH, localIntent);
        AppMethodBeat.o(204750);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class k
    implements e.b
  {
    public static final k sRK;
    
    static
    {
      AppMethodBeat.i(204752);
      sRK = new k();
      AppMethodBeat.o(204752);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(204751);
      com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fs(6);
      AppMethodBeat.o(204751);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167583);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new Intent();
      localObject = FinderReporterUIC.tnG;
      FinderReporterUIC.a.a((Context)this.sRH, paramView, 0L, 0, false, 124);
      FinderSelfUI.a(this.sRH, FinderFollowListUI.class, paramView);
      paramView = com.tencent.mm.plugin.finder.report.i.syT;
      paramView = this.sRH.getContext();
      d.g.b.p.g(paramView, "context");
      com.tencent.mm.plugin.finder.report.i.a((Context)paramView, this.sRH.sxe, this.sRH.sRs, 2L, this.sRH.sRl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167583);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<g.a>
  {
    m(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<g.a>
  {
    n(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      long l1 = 0L;
      AppMethodBeat.i(167584);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new Intent();
      localObject = FinderReporterUIC.tnG;
      FinderReporterUIC.a.a((Context)this.sRH, paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.sRH, FinderNewUIA.class);
      paramView.putExtra("finder_username", com.tencent.mm.model.v.aAK());
      localObject = this.sRH;
      FinderSelfUI.a locala = FinderSelfUI.sRG;
      ((FinderSelfUI)localObject).startActivityForResult(paramView, FinderSelfUI.cMR());
      paramView = com.tencent.mm.plugin.finder.report.i.syT;
      paramView = this.sRH.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      long l2 = this.sRH.sxe;
      boolean bool = this.sRH.sRs;
      long l3 = this.sRH.sRm;
      localObject = FinderSelfUI.a(this.sRH);
      if (localObject != null) {
        l1 = ((atf)localObject).GKh;
      }
      com.tencent.mm.plugin.finder.report.i.a(paramView, l2, bool, 2L, l3, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167584);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204755);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramView).getRedDotManager().aii("FinderFirstFav");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)paramView).getRedDotManager().aij("FinderFirstFav");
      paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
      label179:
      long l2;
      boolean bool;
      long l3;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        paramView = FinderReporterUIC.tnG;
        paramView = FinderReporterUIC.a.fc((Context)this.sRH);
        if (paramView != null)
        {
          paramView = paramView.cQZ();
          com.tencent.mm.plugin.finder.report.i.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
          paramView = com.tencent.mm.plugin.finder.report.h.syO;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label388;
          }
          paramView = paramView.cQZ();
          com.tencent.mm.plugin.finder.report.h.a("4", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ast)localObject1, 2, paramView, 0, 0, 96);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().aih("FinderFirstFav");
        paramView = new Intent();
        localObject1 = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.sRH, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        localObject1 = (MMActivity)this.sRH;
        localObject2 = FinderSelfUI.sRG;
        com.tencent.mm.plugin.finder.utils.a.c((MMActivity)localObject1, paramView, FinderSelfUI.cMQ());
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        paramView = this.sRH.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = (Context)paramView;
        l2 = this.sRH.sxe;
        bool = this.sRH.sRs;
        l3 = this.sRH.sRn;
        localObject1 = FinderSelfUI.a(this.sRH);
        if (localObject1 == null) {
          break label393;
        }
      }
      label388:
      label393:
      for (long l1 = ((atf)localObject1).GKi;; l1 = 0L)
      {
        com.tencent.mm.plugin.finder.report.i.a(paramView, l2, bool, 2L, l3, false, l1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204755);
        return;
        paramView = null;
        break;
        paramView = null;
        break label179;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204756);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.fa((Context)this.sRH);
      long l1 = FinderSelfUI.cMP();
      paramView = com.tencent.mm.plugin.finder.report.i.syT;
      paramView = this.sRH.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      long l2 = this.sRH.sxe;
      boolean bool2 = this.sRH.sRs;
      long l3 = this.sRH.sRr;
      boolean bool1;
      com.tencent.mm.plugin.finder.extension.reddot.i locali;
      if (l1 > 0L)
      {
        bool1 = true;
        com.tencent.mm.plugin.finder.report.i.a(paramView, l2, bool2, 2L, l3, bool1, l1);
        paramView = com.tencent.mm.plugin.finder.report.b.sxb;
        com.tencent.mm.plugin.finder.report.b.cFb().M(2L, 0L);
        paramView = com.tencent.mm.plugin.finder.report.b.sxb;
        com.tencent.mm.plugin.finder.report.b.cFf().sxr = FinderSelfUI.cMP();
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().aii("finder_wx_private_msg_entrance");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locali = ((PluginFinder)paramView).getRedDotManager().aij("finder_wx_private_msg_entrance");
        if ((localObject != null) && (locali != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.h.syO;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label286;
          }
        }
      }
      label286:
      for (paramView = paramView.cQZ();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.h.a("4", locali, (ast)localObject, 3, paramView, 0, 0, 96);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204756);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204758);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.eU((Context)this.sRH);
      paramView = com.tencent.mm.plugin.finder.report.i.syT;
      paramView = this.sRH.getContext();
      d.g.b.p.g(paramView, "context");
      com.tencent.mm.plugin.finder.report.i.a((Context)paramView, this.sRH.sxe, this.sRH.sRs, 2L, this.sRH.sRo);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204758);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class t<T>
    implements Observer<g.a>
  {
    t(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204760);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().aij("finder_private_msg_entrance");
      if (locali != null)
      {
        paramView = locali.aim("finder_private_msg_entrance");
        if ((locali == null) || (locali.field_ctrInfo.type != 1007)) {
          break label277;
        }
        localObject = com.tencent.mm.plugin.finder.report.i.syT;
        localObject = this.sRH.getContext();
        d.g.b.p.g(localObject, "context");
        com.tencent.mm.plugin.finder.report.i.a((Context)localObject, this.sRH.sxe, this.sRH.sRs, 2L, this.sRH.sRq, true, 0L);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.h.syO;
          localObject = FinderReporterUIC.tnG;
          localObject = FinderReporterUIC.a.fc((Context)this.sRH);
          if (localObject == null) {
            break label272;
          }
          localObject = ((FinderReporterUIC)localObject).cQZ();
          label175:
          com.tencent.mm.plugin.finder.report.h.a("4", locali, paramView, 2, (arn)localObject, 0, 0, 96);
        }
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.finder.report.b.sxb;
        com.tencent.mm.plugin.finder.report.b.cFb().M(1L, 0L);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().aih("finder_private_msg_entrance");
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).enterFinderConversationUI((Context)this.sRH);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204760);
        return;
        paramView = null;
        break;
        label272:
        localObject = null;
        break label175;
        label277:
        if ((locali != null) && (locali.field_ctrInfo.type == 1006))
        {
          int i;
          if (paramView != null)
          {
            i = paramView.count;
            label305:
            localObject = com.tencent.mm.plugin.finder.report.i.syT;
            localObject = this.sRH.getContext();
            d.g.b.p.g(localObject, "context");
            com.tencent.mm.plugin.finder.report.i.a((Context)localObject, this.sRH.sxe, this.sRH.sRs, 2L, this.sRH.sRq, true, i);
            if (paramView == null) {
              continue;
            }
            localObject = com.tencent.mm.plugin.finder.report.h.syO;
            localObject = FinderReporterUIC.tnG;
            localObject = FinderReporterUIC.a.fc((Context)this.sRH);
            if (localObject == null) {
              break label411;
            }
          }
          label411:
          for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
          {
            com.tencent.mm.plugin.finder.report.h.a("4", locali, paramView, 3, (arn)localObject, 0, 0, 96);
            break;
            i = 0;
            break label305;
          }
        }
        else
        {
          paramView = com.tencent.mm.plugin.finder.report.i.syT;
          paramView = this.sRH.getContext();
          d.g.b.p.g(paramView, "context");
          com.tencent.mm.plugin.finder.report.i.a((Context)paramView, this.sRH.sxe, this.sRH.sRs, 2L, this.sRH.sRq, false, 0L);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class v<T>
    implements Observer<g.a>
  {
    v(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204762);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().aii("ProfileEntrance");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().aij("ProfileEntrance");
      if ((locali != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.h.syO;
        paramView = FinderReporterUIC.tnG;
        paramView = FinderReporterUIC.a.fc((Context)this.sRH);
        if (paramView != null)
        {
          paramView = paramView.cQZ();
          com.tencent.mm.plugin.finder.report.h.a("4", locali, (ast)localObject, 2, paramView, 0, 0, 96);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aih("ProfileEntrance");
        paramView = new Intent();
        localObject = c.rPy;
        localObject = c.a.ahT(com.tencent.mm.model.v.aAK());
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (!((com.tencent.mm.plugin.finder.api.g)localObject).isBlock()) {
          break label295;
        }
        paramView.setClass((Context)this.sRH.getContext(), FinderExposeUI.class);
        localObject = this.sRH;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204762);
        return;
        paramView = null;
        break;
        label295:
        paramView.putExtra("finder_username", FinderSelfUI.f(this.sRH));
        paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.sRH, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.sRH, paramView);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(FinderSelfUI paramFinderSelfUI, int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.finder.extension.reddot.i parami, ast paramast) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204763);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      int i;
      int j;
      label106:
      label125:
      boolean bool1;
      if (m > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
        {
          i = 0;
          if (j <= 0) {
            break label459;
          }
          paramView = com.tencent.mm.plugin.finder.report.i.syT;
          j = j;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label454;
          }
          paramView = paramView.cQZ();
          com.tencent.mm.plugin.finder.report.i.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
        }
      }
      else
      {
        com.tencent.mm.plugin.finder.extension.reddot.i locali = this.sRO;
        localObject = this.sRP;
        if ((locali != null) && (localObject != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.h.syO;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.sRH);
          if (paramView == null) {
            break label526;
          }
          paramView = paramView.cQZ();
          label175:
          com.tencent.mm.plugin.finder.report.h.a("4", locali, (ast)localObject, 2, paramView, 0, 0, 96);
          paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
          paramView = ((PluginFinder)paramView).getRedDotManager().aii("NotificitionCenterNotify");
          if (paramView == null) {
            break label531;
          }
          ((ast)localObject).count = paramView.count;
        }
        label228:
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        paramView = this.sRH.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = (Context)paramView;
        long l1 = this.sRH.sxe;
        boolean bool2 = this.sRH.sRs;
        long l2 = this.sRH.sRp;
        if (m <= 0) {
          break label559;
        }
        bool1 = true;
        label288:
        com.tencent.mm.plugin.finder.report.i.a(paramView, l1, bool2, 2L, l2, bool1, m);
        paramView = new Intent();
        localObject = c.rPy;
        localObject = c.a.ahT(com.tencent.mm.model.v.aAK());
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (!((com.tencent.mm.plugin.finder.api.g)localObject).isBlock()) {
          break label565;
        }
        paramView.setClass((Context)this.sRH.getContext(), FinderExposeUI.class);
        localObject = this.sRH;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204763);
        return;
        i = 2;
        break;
        label454:
        paramView = null;
        break label106;
        label459:
        if (k <= 0) {
          break label125;
        }
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        j = k;
        paramView = FinderReporterUIC.tnG;
        paramView = FinderReporterUIC.a.fc((Context)this.sRH);
        if (paramView != null) {}
        for (paramView = paramView.cQZ();; paramView = null)
        {
          com.tencent.mm.plugin.finder.report.i.a("4", 4, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
          break;
        }
        label526:
        paramView = null;
        break label175;
        label531:
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aih("AuthorProfileNotify");
        break label228;
        label559:
        bool1 = false;
        break label288;
        label565:
        localObject = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.sRH, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.U((Context)this.sRH, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */