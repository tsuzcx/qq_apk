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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.extension.reddot.a.b;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderNewUIA;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.v;
import java.util.HashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "BANNER_TYPE_FAV", "", "getBANNER_TYPE_FAV", "()J", "BANNER_TYPE_FINDER_MSG", "getBANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FOLLOW", "getBANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "getBANNER_TYPE_LIKE", "BANNER_TYPE_WX_MSG", "getBANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "getBANNER_TYPE_WX_PRIVATE_MESSAGE", "TAG", "", "USER_STATE_ACCOUNT_FORBID", "", "getUSER_STATE_ACCOUNT_FORBID", "()I", "USER_STATE_ACCOUNT_REVIEW_ING", "getUSER_STATE_ACCOUNT_REVIEW_ING", "USER_STATE_ACCOUNT_SILIENT", "getUSER_STATE_ACCOUNT_SILIENT", "USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "getUSER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "USER_STATE_NORMAL", "getUSER_STATE_NORMAL", "USER_STATE_NO_POST_QUALITY", "getUSER_STATE_NO_POST_QUALITY", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "(J)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "()Ljava/lang/String;", "setHasExposeFinderHiMsgTips", "(Ljava/lang/String;)V", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "", "getHasReportFinderMsg", "()Z", "setHasReportFinderMsg", "(Z)V", "isEnableSendMsgEntrance", "isReportRedDotExpose", "lastFavTipsId", "myFinderUsername", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "Landroid/view/View;", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getLayoutId", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "Companion", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.finder.api.f
{
  private static final int sGG = 1;
  private static final int sGH = 2;
  private static final String sGI = "INNER_ITEM_COUNT";
  private static final String sGJ = "RED_DOT_EXIST_ON_ENTER";
  private static final String sGK = "key_from_sns_post";
  public static final a sGL;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private boolean sGA;
  String sGB;
  String sGC;
  String sGD;
  private final boolean sGE;
  private String sGF;
  private String sGk;
  private boolean sGl;
  private final int sGm;
  private final int sGn;
  private final int sGo;
  private final int sGp;
  private final int sGq;
  private final int sGr;
  final long sGs;
  final long sGt;
  final long sGu;
  final long sGv;
  final long sGw;
  final long sGx;
  final long sGy;
  boolean sGz;
  private asp shx;
  long snn;
  
  static
  {
    AppMethodBeat.i(204171);
    sGL = new a((byte)0);
    sGG = 1;
    sGH = 2;
    sGI = "INNER_ITEM_COUNT";
    sGJ = "RED_DOT_EXIST_ON_ENTER";
    sGK = "key_from_sns_post";
    AppMethodBeat.o(204171);
  }
  
  public FinderSelfUI()
  {
    AppMethodBeat.i(204170);
    this.TAG = "Finder.FinderSelfUI";
    this.sGm = 1;
    this.sGn = 2;
    this.sGo = 3;
    this.sGp = 4;
    this.sGq = 5;
    this.sGr = 6;
    this.sGs = 1L;
    this.sGt = 2L;
    this.sGu = 3L;
    this.sGv = 4L;
    this.sGw = 5L;
    this.sGx = 6L;
    this.sGy = 7L;
    this.sGB = "";
    this.sGC = "";
    this.sGD = "";
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cHS().value()).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.sGE = bool;
      this.sGF = "";
      AppMethodBeat.o(204170);
      return;
    }
  }
  
  private final void cKj()
  {
    AppMethodBeat.i(167591);
    this.sGk = u.aAu();
    ad.i(this.TAG, "myFinderUser " + this.sGk);
    Object localObject1 = findViewById(2131300680);
    Object localObject2 = findViewById(2131302875);
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cHB().value()).intValue();
    if (i != -1)
    {
      ad.d(this.TAG, "harcode user state = ".concat(String.valueOf(i)));
      if (i != this.sGm) {
        break label902;
      }
      d.g.b.p.g(localObject1, "hasContactContainer");
      d.g.b.p.g(localObject2, "noContactContainer");
      d.g.b.p.h(localObject1, "hasContactContainer");
      d.g.b.p.h(localObject2, "noContactContainer");
      ad.d(this.TAG, "账户无发表权限");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
      label161:
      localObject1 = this.shx;
      if (localObject1 != null)
      {
        if (((asp)localObject1).GqJ <= 0) {
          break label3007;
        }
        localObject2 = (TextView)_$_findCachedViewById(2131308142);
        d.g.b.p.g(localObject2, "like_feed_count");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FH(((asp)localObject1).GqJ));
        localObject2 = (TextView)_$_findCachedViewById(2131308142);
        d.g.b.p.g(localObject2, "like_feed_count");
        ((TextView)localObject2).setVisibility(0);
        label242:
        if (((asp)localObject1).GqK <= 0) {
          break label3037;
        }
        localObject2 = (TextView)_$_findCachedViewById(2131308103);
        d.g.b.p.g(localObject2, "fav_feed_count");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FH(((asp)localObject1).GqK));
        localObject2 = (TextView)_$_findCachedViewById(2131308103);
        d.g.b.p.g(localObject2, "fav_feed_count");
        ((TextView)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "likeCount = " + ((asp)localObject1).GqJ + ",favCount = " + ((asp)localObject1).GqK);
      localObject1 = (TextView)_$_findCachedViewById(2131307415);
      d.g.b.p.g(localObject1, "finder_post_new_feed");
      al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131307432);
      d.g.b.p.g(localObject1, "finder_self_account_state");
      ((LinearLayout)localObject1).setVisibility(0);
      if (getIntent().getBooleanExtra(sGK, false))
      {
        localObject1 = findViewById(2131307912);
        if (localObject1 != null) {
          ((View)localObject1).post((Runnable)new w((View)localObject1));
        }
        getIntent().removeExtra(sGK);
      }
      AppMethodBeat.o(167591);
      return;
      localObject3 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject3, "MMKernel.storage()");
      boolean bool1;
      label510:
      boolean bool2;
      if ((((com.tencent.mm.kernel.e)localObject3).ajl().getInt(al.a.IGO, 0) & 0x2) != 0)
      {
        bool1 = true;
        localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
        if ((!com.tencent.mm.plugin.finder.storage.b.cFK()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
          break label648;
        }
        bool2 = true;
        label539:
        localObject3 = (CharSequence)this.sGk;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label654;
        }
        i = 1;
        label565:
        if (i != 0) {
          break label659;
        }
      }
      label648:
      label654:
      label659:
      for (boolean bool3 = true;; bool3 = false)
      {
        ad.i(this.TAG, "[checkUserState] hasCreatedIdentity=" + bool3 + ", showPostEntry=" + bool2 + ", isReviewing=" + bool1);
        if (bool2) {
          break label665;
        }
        ad.i(this.TAG, "resultState = USER_STATE_NO_POST_QUALITY");
        i = this.sGm;
        break;
        bool1 = false;
        break label510;
        bool2 = false;
        break label539;
        i = 0;
        break label565;
      }
      label665:
      if (bool3)
      {
        localObject3 = c.rHn;
        localObject3 = u.aAu();
        d.g.b.p.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = c.a.agW((String)localObject3);
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        bool2 = ((com.tencent.mm.plugin.finder.api.g)localObject3).isBlock();
        localObject3 = c.rHn;
        localObject3 = u.aAu();
        d.g.b.p.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = c.a.agW((String)localObject3);
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        if (((com.tencent.mm.plugin.finder.api.g)localObject3).field_spamStatus == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ad.i(this.TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label820;
          }
          ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
          i = this.sGp;
          break;
        }
        label820:
        if (bool1)
        {
          ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
          i = this.sGr;
          break;
        }
        ad.i(this.TAG, "resultState = USER_STATE_NORMAL");
        i = this.sGo;
        break;
      }
      if (bool1)
      {
        ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
        i = this.sGq;
        break;
      }
      ad.i(this.TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
      i = this.sGn;
      break;
      label902:
      if (i == this.sGn)
      {
        d.g.b.p.g(localObject1, "hasContactContainer");
        d.g.b.p.g(localObject2, "noContactContainer");
        d.g.b.p.h(localObject1, "hasContactContainer");
        d.g.b.p.h(localObject2, "noContactContainer");
        ad.d(this.TAG, "有发表权限但未创建账号");
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
        findViewById(2131307912).setOnClickListener((View.OnClickListener)new c(this));
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
        com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czV(), (LifecycleOwner)this, (Observer)new d(this));
        break label161;
      }
      Object localObject4;
      Object localObject5;
      Object localObject6;
      label1331:
      label1844:
      label2229:
      label2235:
      if ((i == this.sGo) || (i == this.sGr))
      {
        d.g.b.p.g(localObject1, "hasContactContainer");
        d.g.b.p.g(localObject2, "noContactContainer");
        d.g.b.p.h(localObject1, "hasContactContainer");
        d.g.b.p.h(localObject2, "noContactContainer");
        ad.d(this.TAG, "账户正常");
        localObject3 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)localObject3).getRedDotManager().ahl("TLCamera");
        ((View)localObject2).setVisibility(8);
        ((View)localObject1).setVisibility(0);
        localObject3 = findViewById(2131307388);
        localObject1 = findViewById(2131307876);
        localObject4 = (ImageView)findViewById(2131299973);
        localObject5 = (TextView)findViewById(2131300016);
        localObject2 = (TextView)findViewById(2131307414);
        localObject6 = c.rHn;
        localObject6 = this.sGk;
        if (localObject6 == null) {
          d.g.b.p.gfZ();
        }
        localObject6 = c.a.agW((String)localObject6);
        ImageView localImageView = (ImageView)findViewById(2131296977);
        Object localObject7;
        final int k;
        final int m;
        label1879:
        label1900:
        long l1;
        long l2;
        if (this.sGE)
        {
          localObject7 = (FrameLayout)_$_findCachedViewById(2131308195);
          d.g.b.p.g(localObject7, "sendMsgLayout");
          ((FrameLayout)localObject7).setVisibility(0);
          if (localObject6 != null)
          {
            localObject7 = com.tencent.mm.plugin.finder.loader.i.sja;
            localObject7 = com.tencent.mm.plugin.finder.loader.i.cCC();
            com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject6).cxL());
            d.g.b.p.g(localObject4, "finderAvatar");
            com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
            ((com.tencent.mm.loader.d)localObject7).a(locala, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
            d.g.b.p.g(localObject5, "finderNickname");
            ((TextView)localObject5).setText((CharSequence)k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject6).VC()));
            al.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
            localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
            d.g.b.p.g(localImageView, "authIcon");
            com.tencent.mm.plugin.finder.utils.p.a(localImageView, ((com.tencent.mm.plugin.finder.api.g)localObject6).field_authInfo);
            localObject4 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject4, "MMKernel.storage()");
            i = ((com.tencent.mm.kernel.e)localObject4).ajl().getInt(al.a.IHV, 0);
            if (i <= 0) {
              break label2110;
            }
            localObject4 = (TextView)_$_findCachedViewById(2131307400);
            d.g.b.p.g(localObject4, "finder_follow_count");
            ((TextView)localObject4).setVisibility(0);
            localObject4 = (TextView)_$_findCachedViewById(2131307400);
            d.g.b.p.g(localObject4, "finder_follow_count");
            localObject5 = getContext();
            d.g.b.p.g(localObject5, "context");
            ((TextView)localObject4).setText((CharSequence)((AppCompatActivity)localObject5).getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(i) }));
          }
          d.g.b.p.g(localObject3, "finderAccountArea");
          ((View)localObject3).setVisibility(0);
          d.g.b.p.g(localObject1, "finderMsgArea");
          ((View)localObject1).setVisibility(0);
          localObject4 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
          localObject4 = d.a.czL();
          final int j = localObject4[0];
          k = localObject4[1];
          m = j + k;
          ad.i(this.TAG, "redDot check normalCount :" + j + " systemCount " + k);
          ((View)localObject3).setOnClickListener((View.OnClickListener)new s(this));
          localObject3 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
          localObject3 = ((PluginFinder)localObject3).getRedDotManager().ahn("AuthorProfileNotify");
          localObject4 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject4).getRedDotManager().ahm("AuthorProfileNotify");
          ((View)localObject1).setOnClickListener((View.OnClickListener)new t(this, m, j, k, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject3, (ase)localObject4));
          if (m <= 0) {
            break label2235;
          }
          d.g.b.p.g(localObject2, "finderMsg");
          ((TextView)localObject2).setVisibility(0);
          if (m <= 999) {
            break label2140;
          }
          localObject1 = (CharSequence)"999+";
          ((TextView)localObject2).setText((CharSequence)localObject1);
          if (!this.sGl)
          {
            this.sGl = true;
            localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
              break label2153;
            }
            i = 0;
            if (j <= 0) {
              break label2164;
            }
            localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
            localObject1 = FinderReporterUIC.tcM;
            localObject1 = FinderReporterUIC.a.eY((Context)this);
            if (localObject1 == null) {
              break label2158;
            }
            localObject1 = ((FinderReporterUIC)localObject1).cOu();
            com.tencent.mm.plugin.finder.report.h.a("4", 1, 1, 5, i, j, null, null, 0L, (aqy)localObject1, 0, 0, 3520);
            if ((localObject3 != null) && (localObject4 != null))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
              localObject1 = FinderReporterUIC.tcM;
              localObject1 = FinderReporterUIC.a.eY((Context)this);
              if (localObject1 == null) {
                break label2229;
              }
              localObject1 = ((FinderReporterUIC)localObject1).cOu();
              com.tencent.mm.plugin.finder.report.g.b("4", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject3, (ase)localObject4, 1, (aqy)localObject1, 0, 96);
            }
          }
          findViewById(2131307912).setOnClickListener((View.OnClickListener)new u(this));
          if (!this.sGA)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
            localObject1 = getContext();
            d.g.b.p.g(localObject1, "context");
            localObject1 = (Context)localObject1;
            l1 = this.snn;
            bool2 = this.sGz;
            l2 = this.sGw;
            if (m <= 0) {
              break label2253;
            }
          }
        }
        label2110:
        label2253:
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, l1, bool2, 1L, l2, bool1, m);
          this.sGA = true;
          ad.i(this.TAG, "show finder msg red, totalCount:".concat(String.valueOf(m)));
          break;
          localObject7 = (FrameLayout)_$_findCachedViewById(2131308195);
          d.g.b.p.g(localObject7, "sendMsgLayout");
          ((FrameLayout)localObject7).setVisibility(8);
          break label1331;
          localObject4 = (TextView)_$_findCachedViewById(2131307400);
          d.g.b.p.g(localObject4, "finder_follow_count");
          ((TextView)localObject4).setVisibility(8);
          break label1576;
          label2140:
          localObject1 = (CharSequence)String.valueOf(m);
          break label1802;
          label2153:
          i = 2;
          break label1844;
          label2158:
          localObject1 = null;
          break label1879;
          label2164:
          if (k <= 0) {
            break label1900;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
          localObject1 = FinderReporterUIC.tcM;
          localObject1 = FinderReporterUIC.a.eY((Context)this);
          if (localObject1 != null) {}
          for (localObject1 = ((FinderReporterUIC)localObject1).cOu();; localObject1 = null)
          {
            com.tencent.mm.plugin.finder.report.h.a("4", 4, 1, 5, i, k, null, null, 0L, (aqy)localObject1, 0, 0, 3520);
            break;
          }
          localObject1 = null;
          break label1941;
          d.g.b.p.g(localObject2, "finderMsg");
          ((TextView)localObject2).setVisibility(8);
          break label1957;
        }
      }
      label1576:
      if (i == this.sGp)
      {
        d.g.b.p.g(localObject1, "hasContactContainer");
        d.g.b.p.g(localObject2, "noContactContainer");
        d.g.b.p.h(localObject1, "hasContactContainer");
        d.g.b.p.h(localObject2, "noContactContainer");
        ad.d(this.TAG, "账户封禁");
        ((View)localObject2).setVisibility(8);
        ((View)localObject1).setVisibility(0);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
        d.g.b.p.g(localObject1, "msg_ll");
        ((FrameLayout)localObject1).setVisibility(8);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307912);
        d.g.b.p.g(localObject1, "postBtn");
        ((FrameLayout)localObject1).setVisibility(8);
        localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cCC();
        localObject2 = new com.tencent.mm.plugin.finder.loader.a("");
        localObject3 = (ImageView)_$_findCachedViewById(2131299973);
        d.g.b.p.g(localObject3, "finder_avatar_iv");
        localObject4 = com.tencent.mm.plugin.finder.loader.i.sja;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
        localObject1 = (TextView)_$_findCachedViewById(2131300016);
        d.g.b.p.g(localObject1, "finder_nick_tv");
        ((TextView)localObject1).setText((CharSequence)getResources().getString(2131764440));
        localObject1 = (TextView)_$_findCachedViewById(2131300067);
        d.g.b.p.g(localObject1, "finder_self_msg_tv");
        ((TextView)localObject1).setVisibility(0);
        ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new b(this));
        localObject1 = (FrameLayout)_$_findCachedViewById(2131308195);
        d.g.b.p.g(localObject1, "sendMsgLayout");
        ((FrameLayout)localObject1).setVisibility(8);
        break label161;
      }
      label1802:
      label1941:
      label1957:
      if (i == this.sGq)
      {
        d.g.b.p.g(localObject1, "hasContactContainer");
        d.g.b.p.g(localObject2, "noContactContainer");
        d.g.b.p.h(localObject1, "hasContactContainer");
        d.g.b.p.h(localObject2, "noContactContainer");
        ad.d(this.TAG, "账户审核中");
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
        localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject6 = com.tencent.mm.plugin.finder.loader.i.cCC();
        localObject1 = this.shx;
        if (localObject1 != null)
        {
          localObject1 = ((asp)localObject1).verifyInfo;
          if (localObject1 != null)
          {
            localObject2 = ((apx)localObject1).jna;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label2763;
            }
          }
        }
        localObject1 = "";
        label2763:
        localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
        d.g.b.p.g(localObject5, "finderAvatar");
        localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
        ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
        d.g.b.p.g(localObject3, "finderNickname");
        localObject2 = (Context)this;
        localObject1 = this.shx;
        if (localObject1 != null)
        {
          localObject1 = ((asp)localObject1).verifyInfo;
          if (localObject1 == null) {}
        }
        for (localObject1 = ((apx)localObject1).Gof;; localObject1 = null)
        {
          ((TextView)localObject3).setText((CharSequence)k.c((Context)localObject2, (CharSequence)localObject1));
          al.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          d.g.b.p.g(localObject4, "finderState");
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText((CharSequence)getResources().getString(2131759342));
          localObject1 = findViewById(2131307876);
          d.g.b.p.g(localObject1, "findViewById<View>(R.id.msg_ll)");
          ((View)localObject1).setVisibility(8);
          ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new e(this));
          localObject1 = (FrameLayout)_$_findCachedViewById(2131308195);
          d.g.b.p.g(localObject1, "sendMsgLayout");
          ((FrameLayout)localObject1).setVisibility(8);
          break;
        }
      }
      ad.d(this.TAG, "not one of six state");
      break label161;
      label3007:
      localObject2 = (TextView)_$_findCachedViewById(2131308142);
      d.g.b.p.g(localObject2, "like_feed_count");
      ((TextView)localObject2).setVisibility(8);
      break label242;
      label3037:
      localObject2 = (TextView)_$_findCachedViewById(2131308103);
      d.g.b.p.g(localObject2, "fav_feed_count");
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  private final void cKk()
  {
    AppMethodBeat.i(204168);
    Object localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
    localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, this.snn, this.sGz, 1L, this.sGs);
    localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
    localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    long l2 = this.snn;
    boolean bool1 = this.sGz;
    long l3 = this.sGt;
    Object localObject2 = this.shx;
    long l1;
    label184:
    boolean bool2;
    label285:
    label336:
    int i;
    if (localObject2 != null)
    {
      l1 = ((asp)localObject2).GqJ;
      com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      l2 = this.snn;
      bool1 = this.sGz;
      l3 = this.sGu;
      localObject2 = this.shx;
      if (localObject2 == null) {
        break label446;
      }
      l1 = ((asp)localObject2).GqK;
      com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, l2, bool1, 1L, l3, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, this.snn, this.sGz, 1L, this.sGv);
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().ahn("finder_private_msg_entrance");
      if (localObject1 == null) {
        break label451;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).ahq("finder_private_msg_entrance");
      localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      l1 = this.snn;
      bool2 = this.sGz;
      l2 = this.sGx;
      if (localObject1 == null) {
        break label457;
      }
      bool1 = true;
      if (localObject1 == null) {
        break label463;
      }
      i = ((ase)localObject1).count;
      label347:
      com.tencent.mm.plugin.finder.report.h.a((Context)localObject2, l1, bool2, 1L, l2, bool1, i);
      l1 = cKl();
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      l2 = this.snn;
      bool2 = this.sGz;
      l3 = this.sGy;
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
      com.tencent.mm.plugin.finder.report.h.a((Context)localObject1, l2, bool2, 1L, l3, bool1, l1);
      AppMethodBeat.o(204168);
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
  
  private static long cKl()
  {
    AppMethodBeat.i(204169);
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().ahm("finder_wx_private_msg_entrance");
    if (localObject != null)
    {
      long l = ((ase)localObject).count;
      AppMethodBeat.o(204169);
      return l;
    }
    AppMethodBeat.o(204169);
    return 0L;
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(204167);
    ax localax = new ax(8);
    com.tencent.mm.kernel.g.aiU().b((n)localax);
    AppMethodBeat.o(204167);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204175);
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
    AppMethodBeat.o(204175);
    return localView1;
  }
  
  public final void a(alo paramalo)
  {
    AppMethodBeat.i(167593);
    d.g.b.p.h(paramalo, "cmdItem");
    ad.i(this.TAG, "cmdId " + paramalo.cmdId);
    switch (paramalo.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(167593);
      return;
      cKj();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494106;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167590);
    findViewById(2131301238).setOnClickListener((View.OnClickListener)new i(this));
    findViewById(2131301239).setOnClickListener((View.OnClickListener)new k(this));
    findViewById(2131307484).setOnClickListener((View.OnClickListener)new l(this));
    if (this.sGE)
    {
      localObject = (LinearLayout)_$_findCachedViewById(2131308138);
      d.g.b.p.g(localObject, "jump_finder_private_msg");
      ((LinearLayout)localObject).setVisibility(0);
      ((LinearLayout)_$_findCachedViewById(2131308138)).setOnClickListener((View.OnClickListener)new m(this));
    }
    for (;;)
    {
      localObject = findViewById(2131301509);
      d.g.b.p.g(localObject, "findViewById(R.id.loading_progress_bar)");
      this.progressBar = ((ProgressBar)localObject);
      findViewById(2131307912).setOnClickListener((View.OnClickListener)new n(this));
      findViewById(2131307485).setOnClickListener((View.OnClickListener)new o(this));
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cAa(), (LifecycleOwner)this, (Observer)new p(this));
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().rRV;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.post((Runnable)new a.b((com.tencent.mm.plugin.finder.extension.reddot.a)localObject));
      if (!this.sGE) {
        break;
      }
      ((FrameLayout)_$_findCachedViewById(2131308195)).setOnClickListener((View.OnClickListener)new q(this));
      localObject = (FrameLayout)_$_findCachedViewById(2131308195);
      d.g.b.p.g(localObject, "sendMsgLayout");
      ((FrameLayout)localObject).setVisibility(0);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cAd(), (LifecycleOwner)this, (Observer)new r(this));
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cAe(), (LifecycleOwner)this, (Observer)new j(this));
      AppMethodBeat.o(167590);
      return;
      localObject = (LinearLayout)_$_findCachedViewById(2131308138);
      d.g.b.p.g(localObject, "jump_finder_private_msg");
      ((LinearLayout)localObject).setVisibility(8);
    }
    Object localObject = (FrameLayout)_$_findCachedViewById(2131308195);
    d.g.b.p.g(localObject, "sendMsgLayout");
    ((FrameLayout)localObject).setVisibility(8);
    AppMethodBeat.o(167590);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(204165);
    boolean bool1;
    if (paramIntent != null)
    {
      paramInt2 = paramIntent.getIntExtra(sGI, 0);
      if (paramInt1 != sGG) {
        break label132;
      }
      paramIntent = this.shx;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.GqK == paramInt2) {
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
        ad.i(this.TAG, "ifFavCountEquals = " + bool2 + ",ifLikeCountEquals = " + bool1);
        doPrepareUser();
      }
      AppMethodBeat.o(204165);
      return;
      paramInt2 = 0;
      break;
      label132:
      if (paramInt1 == sGH)
      {
        paramIntent = this.shx;
        bool1 = bool3;
        if (paramIntent != null)
        {
          bool1 = bool3;
          if (paramIntent.GqJ == paramInt2) {
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
    setBackBtn((MenuItem.OnMenuItemClickListener)new v(this));
    this.sGz = getIntent().getBooleanExtra(sGJ, false);
    this.snn = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((com.tencent.mm.plugin.i.a.t)paramBundle).getRedDotManager().ahl("TLPersonalCenter");
    initView();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.aiU().a(3761, (com.tencent.mm.al.f)this);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ase localase = ((PluginFinder)paramBundle).getRedDotManager().ahm("TLCamera");
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramBundle).getRedDotManager().ahn("TLCamera");
    paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
    int i;
    if ((localase != null) && (locali != null))
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
        break label309;
      }
      i = 0;
      paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
      paramBundle = FinderReporterUIC.tcM;
      paramBundle = FinderReporterUIC.a.eY((Context)this);
      if (paramBundle == null) {
        break label314;
      }
      paramBundle = paramBundle.cOu();
      label243:
      com.tencent.mm.plugin.finder.report.h.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
      paramBundle = com.tencent.mm.plugin.finder.report.g.soH;
      paramBundle = FinderReporterUIC.tcM;
      paramBundle = FinderReporterUIC.a.eY((Context)this);
      if (paramBundle == null) {
        break label319;
      }
    }
    label309:
    label314:
    label319:
    for (paramBundle = paramBundle.cOu();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.g.b("4", locali, localase, 1, paramBundle, 0, 96);
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
    com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.f)this);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIB, 0);
    localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIC, 0);
    localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    if (i + j + ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IHW, 0) <= 0)
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)localObject).getRedDotManager(), 2);
    }
    localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().rRV.czE();
    localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().rRV.czD();
    AppMethodBeat.o(167595);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167592);
    super.onResume();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
      AppMethodBeat.o(167592);
      throw ((Throwable)localObject);
    }
    ((com.tencent.mm.plugin.finder.extension.a)localObject).fI(12329, 1);
    this.sGk = u.aAu();
    if (this.shx != null)
    {
      cKj();
      cKk();
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().rRV;
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.removeMessages(6);
      ((com.tencent.mm.plugin.finder.extension.reddot.a)localObject).handler.sendEmptyMessage(6);
      AppMethodBeat.o(167592);
      return;
    }
    if (bt.isNullOrNil(this.sGk))
    {
      localObject = this.progressBar;
      if (localObject == null) {
        d.g.b.p.bcb("progressBar");
      }
      ((ProgressBar)localObject).setVisibility(0);
    }
    for (;;)
    {
      doPrepareUser();
      break;
      cKj();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167594);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.progressBar;
    if (paramString == null) {
      d.g.b.p.bcb("progressBar");
    }
    paramString.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.shx == null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
          AppMethodBeat.o(167594);
          throw paramString;
        }
        this.shx = ((ax)paramn).cyJ();
        cKk();
      }
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167594);
        throw paramString;
      }
      this.shx = ((ax)paramn).cyJ();
      cKj();
      AppMethodBeat.o(167594);
      return;
    }
    cKk();
    com.tencent.mm.ui.base.t.makeText((Context)this, 2131759307, 1).show();
    AppMethodBeat.o(167594);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(204166);
    super.onStop();
    this.sGA = false;
    this.sGB = "";
    this.sGC = "";
    this.sGD = "";
    AppMethodBeat.o(204166);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI$Companion;", "", "()V", "ENTER_FAV_UI_REQ_CODE", "", "getENTER_FAV_UI_REQ_CODE", "()I", "ENTER_LIKE_UI_REQ_CODE", "getENTER_LIKE_UI_REQ_CODE", "INNER_ITEM_COUNT", "", "getINNER_ITEM_COUNT", "()Ljava/lang/String;", "KEY_FROM_SNS_POST", "getKEY_FROM_SNS_POST", "RED_DOT_EXIST_ON_ENTER", "getRED_DOT_EXIST_ON_ENTER", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204144);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      this.sGM.getIntent().putExtra("finder_username", FinderSelfUI.e(this.sGM));
      this.sGM.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
      paramView = FinderReporterUIC.tcM;
      paramView = (Context)this.sGM;
      localObject = this.sGM.getIntent();
      d.g.b.p.g(localObject, "intent");
      FinderReporterUIC.a.a(paramView, (Intent)localObject, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.sGM, this.sGM.getIntent());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204144);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204145);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.ai(3, false);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().ahm("TLCamera");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().ahn("TLCamera");
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      int i;
      if ((localObject != null) && (locali != null))
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
          break label334;
        }
        i = 0;
        paramView = com.tencent.mm.plugin.finder.report.h.soM;
        paramView = FinderReporterUIC.tcM;
        paramView = FinderReporterUIC.a.eY((Context)this.sGM);
        if (paramView == null) {
          break label339;
        }
        paramView = paramView.cOu();
        label157:
        com.tencent.mm.plugin.finder.report.h.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
        paramView = com.tencent.mm.plugin.finder.report.g.soH;
        paramView = FinderReporterUIC.tcM;
        paramView = FinderReporterUIC.a.eY((Context)this.sGM);
        if (paramView == null) {
          break label344;
        }
      }
      label334:
      label339:
      label344:
      for (paramView = paramView.cOu();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.g.b("4", locali, (ase)localObject, 2, paramView, 0, 96);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().ahl("TLCamera");
        paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)this.sGM))
        {
          paramView = new Intent();
          paramView.putExtra("scene", 2);
          localObject = FinderSelfUI.a(this.sGM);
          if (localObject != null) {
            paramView.putExtra("key_prepare_resp", ((asp)localObject).toByteArray());
          }
          localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.w((Context)this.sGM, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204145);
        return;
        i = 1;
        break;
        paramView = null;
        break label157;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class d<T>
    implements Observer<g.a>
  {
    d(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204147);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = FinderSelfUI.a(this.sGM);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)this.sGM)) {
          FinderSelfUI.a(this.sGM, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204147);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    public static final f sGN;
    
    static
    {
      AppMethodBeat.i(204149);
      sGN = new f();
      AppMethodBeat.o(204149);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(204148);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(1001, 2131755747);
        paraml.jI(1002, 2131755754);
      }
      AppMethodBeat.o(204148);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(FinderSelfUI paramFinderSelfUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(204150);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.sgR);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.sGM, localIntent);
        AppMethodBeat.o(204150);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h sGO;
    
    static
    {
      AppMethodBeat.i(204152);
      sGO = new h();
      AppMethodBeat.o(204152);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(204151);
      com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.EW(6);
      AppMethodBeat.o(204151);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167583);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a((Context)this.sGM, paramView, 0L, 0, false, 124);
      FinderSelfUI.a(this.sGM, FinderFollowListUI.class, paramView);
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      paramView = this.sGM.getContext();
      d.g.b.p.g(paramView, "context");
      com.tencent.mm.plugin.finder.report.h.a((Context)paramView, this.sGM.snn, this.sGM.sGz, 2L, this.sGM.sGs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167583);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<g.a>
  {
    j(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      long l1 = 0L;
      AppMethodBeat.i(167584);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a((Context)this.sGM, paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.sGM, FinderNewUIA.class);
      paramView.putExtra("finder_username", u.aAu());
      localObject = this.sGM;
      FinderSelfUI.a locala = FinderSelfUI.sGL;
      ((FinderSelfUI)localObject).startActivityForResult(paramView, FinderSelfUI.cKo());
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      paramView = this.sGM.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      long l2 = this.sGM.snn;
      boolean bool = this.sGM.sGz;
      long l3 = this.sGM.sGt;
      localObject = FinderSelfUI.a(this.sGM);
      if (localObject != null) {
        l1 = ((asp)localObject).GqJ;
      }
      com.tencent.mm.plugin.finder.report.h.a(paramView, l2, bool, 2L, l3, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167584);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204154);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramView).getRedDotManager().ahm("FinderFirstFav");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)paramView).getRedDotManager().ahn("FinderFirstFav");
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      label179:
      long l2;
      boolean bool;
      long l3;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.h.soM;
        paramView = FinderReporterUIC.tcM;
        paramView = FinderReporterUIC.a.eY((Context)this.sGM);
        if (paramView != null)
        {
          paramView = paramView.cOu();
          com.tencent.mm.plugin.finder.report.h.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
          paramView = com.tencent.mm.plugin.finder.report.g.soH;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sGM);
          if (paramView == null) {
            break label387;
          }
          paramView = paramView.cOu();
          com.tencent.mm.plugin.finder.report.g.b("4", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ase)localObject1, 2, paramView, 0, 96);
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().ahl("FinderFirstFav");
        paramView = new Intent();
        localObject1 = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.sGM, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
        localObject1 = (MMActivity)this.sGM;
        localObject2 = FinderSelfUI.sGL;
        com.tencent.mm.plugin.finder.utils.a.c((MMActivity)localObject1, paramView, FinderSelfUI.cKn());
        paramView = com.tencent.mm.plugin.finder.report.h.soM;
        paramView = this.sGM.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = (Context)paramView;
        l2 = this.sGM.snn;
        bool = this.sGM.sGz;
        l3 = this.sGM.sGu;
        localObject1 = FinderSelfUI.a(this.sGM);
        if (localObject1 == null) {
          break label392;
        }
      }
      label387:
      label392:
      for (long l1 = ((asp)localObject1).GqK;; l1 = 0L)
      {
        com.tencent.mm.plugin.finder.report.h.a(paramView, l2, bool, 2L, l3, false, l1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204154);
        return;
        paramView = null;
        break;
        paramView = null;
        break label179;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204155);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.eW((Context)this.sGM);
      long l1 = FinderSelfUI.cKm();
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      paramView = this.sGM.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      long l2 = this.sGM.snn;
      boolean bool2 = this.sGM.sGz;
      long l3 = this.sGM.sGy;
      boolean bool1;
      com.tencent.mm.plugin.finder.extension.reddot.i locali;
      if (l1 > 0L)
      {
        bool1 = true;
        com.tencent.mm.plugin.finder.report.h.a(paramView, l2, bool2, 2L, l3, bool1, l1);
        paramView = com.tencent.mm.plugin.finder.report.b.snk;
        com.tencent.mm.plugin.finder.report.b.cDj().N(2L, 0L);
        paramView = com.tencent.mm.plugin.finder.report.b.snk;
        com.tencent.mm.plugin.finder.report.b.cDn().snA = FinderSelfUI.cKm();
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().ahm("finder_wx_private_msg_entrance");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locali = ((PluginFinder)paramView).getRedDotManager().ahn("finder_wx_private_msg_entrance");
        if ((localObject != null) && (locali != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.g.soH;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sGM);
          if (paramView == null) {
            break label285;
          }
        }
      }
      label285:
      for (paramView = paramView.cOu();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.g.b("4", locali, (ase)localObject, 3, paramView, 0, 96);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204155);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204156);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderSelfUI.b(this.sGM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204156);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204157);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.eQ((Context)this.sGM);
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      paramView = this.sGM.getContext();
      d.g.b.p.g(paramView, "context");
      com.tencent.mm.plugin.finder.report.h.a((Context)paramView, this.sGM.snn, this.sGM.sGz, 2L, this.sGM.sGv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204157);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class p<T>
    implements Observer<g.a>
  {
    p(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204159);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().ahn("finder_private_msg_entrance");
      if (locali != null)
      {
        paramView = locali.ahq("finder_private_msg_entrance");
        if ((locali == null) || (locali.field_ctrInfo.type != 1007)) {
          break label276;
        }
        localObject = com.tencent.mm.plugin.finder.report.h.soM;
        localObject = this.sGM.getContext();
        d.g.b.p.g(localObject, "context");
        com.tencent.mm.plugin.finder.report.h.a((Context)localObject, this.sGM.snn, this.sGM.sGz, 2L, this.sGM.sGx, true, 0L);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.g.soH;
          localObject = FinderReporterUIC.tcM;
          localObject = FinderReporterUIC.a.eY((Context)this.sGM);
          if (localObject == null) {
            break label271;
          }
          localObject = ((FinderReporterUIC)localObject).cOu();
          label175:
          com.tencent.mm.plugin.finder.report.g.b("4", locali, paramView, 2, (aqy)localObject, 0, 96);
        }
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.finder.report.b.snk;
        com.tencent.mm.plugin.finder.report.b.cDj().N(1L, 0L);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramView).getRedDotManager().ahl("finder_private_msg_entrance");
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).enterFinderConversationUI((Context)this.sGM);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204159);
        return;
        paramView = null;
        break;
        label271:
        localObject = null;
        break label175;
        label276:
        if ((locali != null) && (locali.field_ctrInfo.type == 1006))
        {
          int i;
          if (paramView != null)
          {
            i = paramView.count;
            label304:
            localObject = com.tencent.mm.plugin.finder.report.h.soM;
            localObject = this.sGM.getContext();
            d.g.b.p.g(localObject, "context");
            com.tencent.mm.plugin.finder.report.h.a((Context)localObject, this.sGM.snn, this.sGM.sGz, 2L, this.sGM.sGx, true, i);
            if (paramView == null) {
              continue;
            }
            localObject = com.tencent.mm.plugin.finder.report.g.soH;
            localObject = FinderReporterUIC.tcM;
            localObject = FinderReporterUIC.a.eY((Context)this.sGM);
            if (localObject == null) {
              break label409;
            }
          }
          label409:
          for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
          {
            com.tencent.mm.plugin.finder.report.g.b("4", locali, paramView, 3, (aqy)localObject, 0, 96);
            break;
            i = 0;
            break label304;
          }
        }
        else
        {
          paramView = com.tencent.mm.plugin.finder.report.h.soM;
          paramView = this.sGM.getContext();
          d.g.b.p.g(paramView, "context");
          com.tencent.mm.plugin.finder.report.h.a((Context)paramView, this.sGM.snn, this.sGM.sGz, 2L, this.sGM.sGx, false, 0L);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class r<T>
    implements Observer<g.a>
  {
    r(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204161);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      localObject = c.rHn;
      localObject = u.aAu();
      d.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      localObject = c.a.agW((String)localObject);
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      if (((com.tencent.mm.plugin.finder.api.g)localObject).isBlock())
      {
        paramView.setClass((Context)this.sGM.getContext(), FinderExposeUI.class);
        localObject = this.sGM;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204161);
        return;
        paramView.putExtra("finder_username", FinderSelfUI.e(this.sGM));
        paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.sGM, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.sGM, paramView);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(FinderSelfUI paramFinderSelfUI, int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.finder.extension.reddot.i parami, ase paramase) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204162);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      int i;
      int j;
      label106:
      label125:
      boolean bool1;
      if (m > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
        {
          i = 0;
          if (j <= 0) {
            break label493;
          }
          paramView = com.tencent.mm.plugin.finder.report.h.soM;
          j = j;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sGM);
          if (paramView == null) {
            break label488;
          }
          paramView = paramView.cOu();
          com.tencent.mm.plugin.finder.report.h.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
        }
      }
      else
      {
        com.tencent.mm.plugin.finder.extension.reddot.i locali = this.sGS;
        localObject = this.sGT;
        if ((locali != null) && (localObject != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.g.soH;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sGM);
          if (paramView == null) {
            break label560;
          }
          paramView = paramView.cOu();
          label175:
          com.tencent.mm.plugin.finder.report.g.b("4", locali, (ase)localObject, 2, paramView, 0, 96);
          paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
          paramView = ((PluginFinder)paramView).getRedDotManager().ahm("NotificitionCenterNotify");
          if (paramView == null) {
            break label565;
          }
          ((ase)localObject).count = paramView.count;
        }
        label227:
        paramView = com.tencent.mm.plugin.finder.report.h.soM;
        paramView = this.sGM.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = (Context)paramView;
        long l1 = this.sGM.snn;
        boolean bool2 = this.sGM.sGz;
        long l2 = this.sGM.sGw;
        if (m <= 0) {
          break label593;
        }
        bool1 = true;
        label287:
        com.tencent.mm.plugin.finder.report.h.a(paramView, l1, bool2, 2L, l2, bool1, m);
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().ahl("ProfileEntrance");
        paramView = new Intent();
        localObject = c.rHn;
        localObject = u.aAu();
        d.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
        localObject = c.a.agW((String)localObject);
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        if (!((com.tencent.mm.plugin.finder.api.g)localObject).isBlock()) {
          break label599;
        }
        paramView.setClass((Context)this.sGM.getContext(), FinderExposeUI.class);
        localObject = this.sGM;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204162);
        return;
        i = 2;
        break;
        label488:
        paramView = null;
        break label106;
        label493:
        if (k <= 0) {
          break label125;
        }
        paramView = com.tencent.mm.plugin.finder.report.h.soM;
        j = k;
        paramView = FinderReporterUIC.tcM;
        paramView = FinderReporterUIC.a.eY((Context)this.sGM);
        if (paramView != null) {}
        for (paramView = paramView.cOu();; paramView = null)
        {
          com.tencent.mm.plugin.finder.report.h.a("4", 4, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
          break;
        }
        label560:
        paramView = null;
        break label175;
        label565:
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().ahl("AuthorProfileNotify");
        break label227;
        label593:
        bool1 = false;
        break label287;
        label599:
        localObject = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.sGM, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.U((Context)this.sGM, paramView);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204163);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderSelfUI.b(this.sGM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204163);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class v
    implements MenuItem.OnMenuItemClickListener
  {
    v(FinderSelfUI paramFinderSelfUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167585);
      this.sGM.onBackPressed();
      AppMethodBeat.o(167585);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(204164);
      this.rMp.performClick();
      AppMethodBeat.o(204164);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */