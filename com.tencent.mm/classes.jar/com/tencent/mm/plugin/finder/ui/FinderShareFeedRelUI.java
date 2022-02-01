package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "setDefaultCommentScene", "(I)V", "distance", "doShowAfterEnter", "", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "fromAnimateKey", "fromImageUrl", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "isShareClickReport", "isTipsFirstShown", "loader", "moreTipsLayout", "Landroid/view/View;", "ninePatchId", "parentBottom", "getParentBottom", "parentBottom$delegate", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "presenter", "reportScene", "getReportScene", "setReportScene", "scene", "getScene", "setScene", "sessionID", "getSessionID", "setSessionID", "showFinderEntry", "showRelatedList", "getShowRelatedList", "()Z", "setShowRelatedList", "(Z)V", "tabType", "getTabType", "setTabType", "tipsFirstShownCount", "tipsLayout", "tipsShownLimit", "tipsWording", "uiType", "getUiType", "setUiType", "viewCallback", "checkBottomTips", "", "convertActivityFromTranslucent", "finish", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewBottomInWindow", "view", "getViewCallback", "hideCoverAnimation", "initActivityCloseAnimation", "initData", "initOnCreate", "initSimilarTipsShownCount", "initTipsLayout", "isAllowShowTips", "isSupportNavigationSwipeBack", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onResume", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "showProgress", "ifShow", "showRetryTips", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, i.b, g>
{
  private boolean Odi;
  final String TAG;
  private HashMap _$_findViewCache;
  private long dtq;
  private int duh;
  String dyU;
  private final f rZk;
  int rgD;
  private boolean sHA;
  private int sHB;
  private BaseFinderFeed sHC;
  private String sHD;
  private View sHE;
  private final f sHF;
  private int sHG;
  private boolean sHH;
  private FrameLayout sHI;
  private FrameLayout sHJ;
  private NinePatchCropImageView sHK;
  private int sHL;
  private long sHM;
  private ViewAnimHelper.ViewInfo sHN;
  private String sHO;
  private boolean sHP;
  private boolean sHQ;
  private boolean sHR;
  private boolean sHS;
  private boolean sHl;
  private View sHn;
  private boolean sHp;
  private g sHu;
  private i.b sHv;
  private FinderFeedShareRelativeListLoader sHw;
  private int sHx;
  private int sHy;
  private final int sHz;
  private int scene;
  private String tipsWording;
  private String vMJ;
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(204239);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.scene = 2;
    this.dyU = "";
    this.rZk = d.g.O((d.g.a.a)new a(this));
    this.sHy = 25;
    this.sHz = 3;
    this.sHA = true;
    this.sHl = ((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry();
    this.sHD = "";
    this.Odi = true;
    this.vMJ = "";
    this.sHF = d.g.O((d.g.a.a)new m(this));
    this.sHO = "";
    this.tipsWording = "";
    AppMethodBeat.o(204239);
  }
  
  private final int cKt()
  {
    AppMethodBeat.i(204220);
    int i = ((Number)this.sHF.getValue()).intValue();
    AppMethodBeat.o(204220);
    return i;
  }
  
  private final boolean cKv()
  {
    AppMethodBeat.i(204227);
    if (this.sHA)
    {
      this.sHA = false;
      if (this.sHB <= this.sHz)
      {
        this.sHB += 1;
        localObject = com.tencent.mm.kernel.g.ajC();
        p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIh, Integer.valueOf(this.sHB));
      }
    }
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("isAllowShowTips: ");
    if (this.sHB <= this.sHz) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d((String)localObject, bool);
      if (this.sHB > this.sHz) {
        break;
      }
      AppMethodBeat.o(204227);
      return true;
    }
    AppMethodBeat.o(204227);
    return false;
  }
  
  private g cKw()
  {
    AppMethodBeat.i(204231);
    g localg = this.sHu;
    if (localg == null) {
      p.bcb("presenter");
    }
    AppMethodBeat.o(204231);
    return localg;
  }
  
  private static int ef(View paramView)
  {
    AppMethodBeat.i(204228);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(204228);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(204228);
    return i + j;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204250);
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
    AppMethodBeat.o(204250);
    return localView1;
  }
  
  public final int cAZ()
  {
    return this.sHy;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.d cBJ()
  {
    AppMethodBeat.i(204219);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.rZk.getValue();
    AppMethodBeat.o(204219);
    return locald;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final void cKu()
  {
    AppMethodBeat.i(204226);
    Object localObject1 = this.sHE;
    if (localObject1 == null) {
      p.bcb("moreTipsLayout");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.sHw;
    if (localObject1 == null) {
      p.bcb("loader");
    }
    if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(204226);
      return;
    }
    localObject1 = this.sHv;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    Object localObject2 = ((a.b)localObject1).rTF.getRecyclerView().ci(0);
    localObject1 = this.sHv;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject1 = ((a.b)localObject1).rTF.getRecyclerView().ci(1);
    if (localObject2 != null)
    {
      localObject2 = ((RecyclerView.w)localObject2).auu;
      p.g(localObject2, "firstItemView.itemView");
      int i = ef((View)localObject2);
      if ((cKt() > 0) && (cKt() - i < this.sHG))
      {
        if (cKv())
        {
          localObject2 = this.sHE;
          if (localObject2 == null) {
            p.bcb("moreTipsLayout");
          }
          ((View)localObject2).setVisibility(0);
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView.w)localObject1).auu;
            p.g(localObject1, "secondItemView.itemView");
            ((View)localObject1).setVisibility(4);
          }
        }
        AppMethodBeat.o(204226);
        return;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).auu;
      p.g(localObject1, "secondItemView.itemView");
      ((View)localObject1).setVisibility(0);
    }
    AppMethodBeat.o(204226);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return !this.sHH;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(204237);
    super.finish();
    if (this.sHH) {
      overridePendingTransition(2130771986, 2130771986);
    }
    AppMethodBeat.o(204237);
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(204235);
    if (this.sHH)
    {
      AppMethodBeat.o(204235);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(204235);
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(204230);
    this.dtq = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.sHD = ((String)localObject1);
    Object localObject3 = new y.f();
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((y.f)localObject3).MLV = localObject1;
    this.rgD = getIntent().getIntExtra("report_scene", 0);
    this.dyU = getIntent().getStringExtra("from_user");
    this.duh = getIntent().getIntExtra("tab_type", 0);
    this.Odi = getIntent().getBooleanExtra("key_need_related_list", true);
    this.vMJ = getIntent().getStringExtra("key_session_id");
    if (this.dtq == 0L)
    {
      if (((CharSequence)this.sHD).length() != 0) {
        break label786;
      }
      i = 1;
      if (i != 0)
      {
        ad.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
        finish();
      }
    }
    localObject1 = findViewById(2131304742);
    p.g(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.sHn = ((View)localObject1);
    localObject1 = findViewById(2131307871);
    p.g(localObject1, "findViewById(R.id.more_similar_feed_tip_layout)");
    this.sHE = ((View)localObject1);
    localObject1 = this.sHE;
    if (localObject1 == null) {
      p.bcb("moreTipsLayout");
    }
    localObject1 = (TextView)((View)localObject1).findViewById(2131307438);
    p.g(localObject1, "tipsTv");
    com.tencent.mm.ui.al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.sHE;
    if (localObject1 == null) {
      p.bcb("moreTipsLayout");
    }
    localObject1 = ((View)localObject1).findViewById(2131307869);
    if (com.tencent.mm.ui.al.isDarkMode()) {
      ((View)localObject1).setBackgroundResource(2131234883);
    }
    for (;;)
    {
      localObject1 = this.sHE;
      if (localObject1 == null) {
        p.bcb("moreTipsLayout");
      }
      ((View)localObject1).findViewById(2131307870).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.l.sHY);
      this.sHG = com.tencent.mm.cc.a.fromDPToPix((Context)this, 104);
      localObject1 = findViewById(2131308209);
      p.g(localObject1, "findViewById(R.id.share_ui_content)");
      this.sHI = ((FrameLayout)localObject1);
      localObject1 = findViewById(2131308204);
      p.g(localObject1, "findViewById(R.id.share_anim_cover_layout)");
      this.sHJ = ((FrameLayout)localObject1);
      localObject1 = findViewById(2131308205);
      p.g(localObject1, "findViewById(R.id.share_anim_image)");
      this.sHK = ((NinePatchCropImageView)localObject1);
      if (!this.sHH) {
        break label1012;
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new g(this), 2131689492);
      double d = getIntent().getDoubleExtra("key_image_height", 1.166666626930237D);
      localObject1 = (t)com.tencent.mm.kernel.g.ad(t.class);
      localObject2 = this.sHO;
      localObject4 = this.sHK;
      if (localObject4 == null) {
        p.bcb("animCoverImage");
      }
      ((t)localObject1).loadImage((String)localObject2, (ImageView)localObject4);
      localObject1 = this.sHK;
      if (localObject1 == null) {
        p.bcb("animCoverImage");
      }
      localObject1 = ((NinePatchCropImageView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDisplayMetrics().widthPixels;
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(d * ((ViewGroup.LayoutParams)localObject1).width));
      localObject2 = this.sHK;
      if (localObject2 == null) {
        p.bcb("animCoverImage");
      }
      ((NinePatchCropImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.sHK;
      if (localObject1 == null) {
        p.bcb("animCoverImage");
      }
      ((NinePatchCropImageView)localObject1).setAlpha(0.0F);
      localObject1 = this.sHI;
      if (localObject1 == null) {
        p.bcb("contentUI");
      }
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = this.sHJ;
      if (localObject1 == null) {
        p.bcb("animCoverLayout");
      }
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = this.sHJ;
      if (localObject1 == null) {
        p.bcb("animCoverLayout");
      }
      ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.h.sHX);
      localObject1 = findViewById(2131307978);
      p.g(localObject1, "progressView");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break label802;
      }
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(204230);
      throw ((Throwable)localObject1);
      label786:
      i = 0;
      break;
      ((View)localObject1).setBackgroundResource(2131234882);
    }
    label802:
    localObject2 = (FrameLayout.LayoutParams)localObject2;
    ((FrameLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 18);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = findViewById(2131308206);
    p.g(localObject1, "findViewById(R.id.share_animation_layout)");
    localObject1 = (AnimationLayout)localObject1;
    localObject2 = findViewById(2131300336);
    p.g(localObject2, "findViewById(R.id.gallery_bg)");
    Object localObject4 = getWindow();
    p.g(localObject4, "window");
    localObject4 = ((Window)localObject4).getDecorView();
    p.g(localObject4, "window.decorView");
    ViewAnimHelper.ViewInfo localViewInfo = this.sHN;
    ad.i(this.TAG, "runEnterAnimation " + localViewInfo + ", " + this.sHP);
    if ((localViewInfo != null) && (!this.sHP))
    {
      this.sHP = true;
      ad.i(this.TAG, "runEnterAnimation");
      ((AnimationLayout)localObject1).b((View)localObject2, (View)localObject4, localViewInfo, (Animator.AnimatorListener)new n(this, (View)localObject2), (ValueAnimator.AnimatorUpdateListener)new o(this));
    }
    label1012:
    if (this.dtq != 0L)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.data.d.szI;
      localObject1 = d.a.wT(this.dtq);
      if (localObject1 != null)
      {
        ad.i(this.TAG, "use cache cacheTime=" + i.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + ' ' + "current=" + i.formatTime("yyyy-MM-dd HH:mm:ss", cf.aCM() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
        if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (cf.aCM() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          this.sHC = b.a.j((FinderItem)localObject1);
        }
      }
    }
    if (this.sHC == null)
    {
      ad.d(this.TAG, "cache null.show progress");
      md(true);
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    boolean bool;
    if (!this.sHl)
    {
      bool = true;
      localObject1 = new g(i, (MMActivity)localObject1, bool, this.duh);
      ((i.a)localObject1).rIZ = this.dtq;
      localObject2 = (String)((y.f)localObject3).MLV;
      p.h(localObject2, "<set-?>");
      ((i.a)localObject1).objectNonceId = ((String)localObject2);
      ((i.a)localObject1).rQZ = this.sHC;
      localObject2 = this.sHD;
      p.h(localObject2, "<set-?>");
      ((i.a)localObject1).rVz = ((String)localObject2);
      ((i.a)localObject1).rVA = this.Odi;
      ((i.a)localObject1).rVB = ((m)new c((g)localObject1, this, (y.f)localObject3));
      ((i.a)localObject1).rVC = ((d.g.a.b)new d((g)localObject1, this, (y.f)localObject3));
      this.sHu = ((g)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.sHu;
      if (localObject2 == null) {
        p.bcb("presenter");
      }
      this.sHv = new i.b((MMActivity)localObject1, (i.a)localObject2, this.scene, cAZ());
      if (this.rgD != 15) {
        break label1916;
      }
    }
    label1916:
    for (i = 6;; i = 3)
    {
      long l = this.dtq;
      localObject1 = (String)((y.f)localObject3).MLV;
      int j = this.duh;
      localObject2 = this.vMJ;
      localObject3 = com.tencent.mm.ui.component.a.KiD;
      localObject3 = new FinderFeedShareRelativeListLoader(l, (String)localObject1, j, i, (String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
      localObject2 = getIntent().getStringExtra("key_from_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).dFE = ((String)localObject1);
      localObject2 = getIntent().getStringExtra("key_to_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).drf = ((String)localObject1);
      ad.i(((FinderFeedShareRelativeListLoader)localObject3).getTAG(), "fromUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).dFE + ",toUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).drf);
      ((FinderFeedShareRelativeListLoader)localObject3).fetchEndCallback = ((d.g.a.b)new e(this));
      ((FinderFeedShareRelativeListLoader)localObject3).sbq = ((d.g.a.b)new f(this));
      this.sHw = ((FinderFeedShareRelativeListLoader)localObject3);
      if (this.rgD != 0) {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1278L, 14L, 1L, false);
      }
      setMMTitle(2131759376);
      localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      this.sHB = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IIh, 0);
      ad.d(this.TAG, "tips first shown count by each feed: " + this.sHB);
      localObject1 = this.sHv;
      if (localObject1 == null) {
        p.bcb("viewCallback");
      }
      ((a.b)localObject1).rTF.getRecyclerView().a((RecyclerView.m)new i(this));
      localObject1 = this.sHu;
      if (localObject1 == null) {
        p.bcb("presenter");
      }
      ((g)localObject1).sIu = ((d.g.a.b)new j(this));
      cBJ().a(this.scene, cAZ(), (d.g.a.b)new k(this));
      localObject1 = FinderReporterUIC.tcM;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = FinderReporterUIC.a.eY((Context)localObject1);
      if (localObject1 == null) {
        break label1921;
      }
      localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
      if (localObject1 == null) {
        break label1921;
      }
      ((c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)cBJ());
      AppMethodBeat.o(204230);
      return;
      bool = false;
      break;
    }
    label1921:
    AppMethodBeat.o(204230);
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(204236);
    if (this.sHH)
    {
      AppMethodBeat.o(204236);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(204236);
    return bool;
  }
  
  public final void mc(final boolean paramBoolean)
  {
    AppMethodBeat.i(204224);
    final y.f localf = new y.f();
    localf.MLV = findViewById(2131304150);
    if ((View)localf.MLV != null)
    {
      if (paramBoolean)
      {
        ((View)localf.MLV).setVisibility(0);
        ((View)localf.MLV).setOnClickListener((View.OnClickListener)new r(this, paramBoolean, localf));
        AppMethodBeat.o(204224);
        return;
      }
      ((View)localf.MLV).setVisibility(8);
    }
    AppMethodBeat.o(204224);
  }
  
  public final void md(boolean paramBoolean)
  {
    AppMethodBeat.i(204225);
    if (findViewById(2131307978) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(2131307978);
        p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(204225);
        return;
      }
      View localView = findViewById(2131307978);
      p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(204225);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(204238);
    if ((this.sHP) || (this.sHQ))
    {
      AppMethodBeat.o(204238);
      return;
    }
    Object localObject2 = findViewById(2131304150);
    Object localObject1 = this.sHN;
    if (this.sHH)
    {
      View localView = this.sHn;
      if (localView == null) {
        p.bcb("tipsLayout");
      }
      if (localView.getVisibility() != 0)
      {
        p.g(localObject2, "retryView");
        if ((((View)localObject2).getVisibility() != 0) && (localObject1 != null))
        {
          if (cKw().cKy()) {
            break label468;
          }
          localObject2 = this.sHI;
          if (localObject2 == null) {
            p.bcb("contentUI");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = this.sHJ;
          if (localObject2 == null) {
            p.bcb("animCoverLayout");
          }
          ((FrameLayout)localObject2).setVisibility(0);
          if (this.sHL != 0)
          {
            localObject2 = this.sHK;
            if (localObject2 == null) {
              p.bcb("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setBackground(null);
            localObject2 = this.sHK;
            if (localObject2 == null) {
              p.bcb("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setNinePatchId(this.sHL);
            localObject2 = this.sHK;
            if (localObject2 == null) {
              p.bcb("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setAlpha(1.0F);
            localObject2 = this.sHK;
            if (localObject2 == null) {
              p.bcb("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).ku(((ViewAnimHelper.ViewInfo)localObject1).KUQ.width(), ((ViewAnimHelper.ViewInfo)localObject1).KUQ.height());
          }
          localObject2 = findViewById(2131308206);
          p.g(localObject2, "findViewById(R.id.share_animation_layout)");
          localObject2 = (AnimationLayout)localObject2;
          localView = findViewById(2131300336);
          p.g(localView, "findViewById(R.id.gallery_bg)");
          Object localObject3 = getWindow();
          p.g(localObject3, "window");
          localObject3 = ((Window)localObject3).getDecorView();
          p.g(localObject3, "window.decorView");
          ad.i(this.TAG, "runExitAnimation " + this.sHP + ", " + this.sHQ);
          if ((this.sHP) || (this.sHQ))
          {
            AppMethodBeat.o(204238);
            return;
          }
          this.sHQ = true;
          localView.setVisibility(8);
          ((AnimationLayout)localObject2).a(localView, (View)localObject3, (ViewAnimHelper.ViewInfo)localObject1, (Animator.AnimatorListener)new p(this, findViewById(2131296345)), (ValueAnimator.AnimatorUpdateListener)new q(this, (AnimationLayout)localObject2));
          localObject1 = com.tencent.mm.sdk.b.a.IbL;
          localObject2 = new ho();
          ((ho)localObject2).duc.key = this.sHM;
          ((com.tencent.mm.sdk.b.a)localObject1).l((com.tencent.mm.sdk.b.b)localObject2);
          AppMethodBeat.o(204238);
          return;
        }
      }
    }
    if (!cKw().cKy()) {
      finish();
    }
    label468:
    AppMethodBeat.o(204238);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204221);
    this.sHN = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("key_view_info"));
    String str2 = getIntent().getStringExtra("key_image_url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.sHO = str1;
    this.sHL = getIntent().getIntExtra("key_nine_patch_id", 0);
    this.sHM = getIntent().getLongExtra("key_animate_id", 0L);
    this.sHy = getIntent().getIntExtra("key_comment_scene", 25);
    if (this.sHy == 38) {
      this.sHx = 2;
    }
    if ((this.sHN != null) && (!bt.isNullOrNil(this.sHO))) {
      this.sHH = true;
    }
    super.onCreate(paramBundle);
    AppMethodBeat.o(204221);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(204222);
    super.onCreateBeforeSetContentView();
    if (this.sHH)
    {
      if (com.tencent.mm.ui.al.isDarkMode())
      {
        setTheme(2131821784);
        AppMethodBeat.o(204222);
        return;
      }
      setTheme(2131821785);
    }
    AppMethodBeat.o(204222);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204234);
    if ((this.rgD != 0) && (!this.sHp))
    {
      localObject = h.soM;
      long l = this.dtq;
      int i = this.rgD;
      String str = this.dyU;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      h.a(l, i, (String)localObject, 0, 2);
      this.sHp = true;
    }
    cBJ().onDetach();
    Object localObject = FinderReporterUIC.tcM;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.eY((Context)localObject);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)cBJ());
      }
    }
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ET(this.duh);
    super.onDestroy();
    AppMethodBeat.o(204234);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204223);
    super.onResume();
    com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.EP(this.duh);
    AppMethodBeat.o(204223);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    a(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221552);
      FinderShareFeedRelUI.n(this.sHT).setVisibility(8);
      this.sHU.setAlpha(1.0F);
      FinderShareFeedRelUI.o(this.sHT);
      AppMethodBeat.o(221552);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4$1"})
  static final class c
    extends q
    implements m<Integer, String, z>
  {
    c(g paramg, FinderShareFeedRelUI paramFinderShareFeedRelUI, y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4$2"})
  static final class d
    extends q
    implements d.g.a.b<FinderObject, z>
  {
    d(g paramg, FinderShareFeedRelUI paramFinderShareFeedRelUI, y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$1"})
  static final class e
    extends q
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.al>, z>
  {
    e(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$2"})
  static final class f
    extends q
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.al>, z>
  {
    f(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204198);
      this.sHT.onBackPressed();
      AppMethodBeat.o(204198);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class i
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204201);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      this.sHT.cKu();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(204201);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(204202);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(204202);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<View, z>
  {
    j(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    k(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<Integer>
  {
    m(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    n(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204209);
      FinderShareFeedRelUI.j(this.sHT);
      FinderShareFeedRelUI.k(this.sHT).setVisibility(0);
      if (FinderShareFeedRelUI.l(this.sHT)) {
        FinderShareFeedRelUI.b(this.sHT);
      }
      ad.i(this.sHT.TAG, "runEnterAnimation end " + FinderShareFeedRelUI.l(this.sHT));
      AppMethodBeat.o(204209);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(204208);
      ad.i(this.sHT.TAG, "runEnterAnimation start");
      AppMethodBeat.o(204208);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204210);
      this.sHU.setVisibility(0);
      AppMethodBeat.o(204210);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(204211);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(204211);
        throw paramValueAnimator;
      }
      if ((((Float)paramValueAnimator).floatValue() > 0.1F) && (FinderShareFeedRelUI.m(this.sHT).getAlpha() < 0.9F)) {
        FinderShareFeedRelUI.m(this.sHT).setAlpha(1.0F);
      }
      AppMethodBeat.o(204211);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(204215);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(204215);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204214);
      p.h(paramAnimator, "animation");
      FinderShareFeedRelUI.m(this.sHT).postDelayed((Runnable)new a(this), 400L);
      this.sHT.overridePendingTransition(2130771986, 2130771986);
      ad.i(this.sHT.TAG, "runExitAnimation end");
      AppMethodBeat.o(204214);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(204216);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(204216);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204213);
      p.h(paramAnimator, "animation");
      paramAnimator = this.sHZ;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(0.0F);
      }
      ad.i(this.sHT.TAG, "runExitAnimation start");
      AppMethodBeat.o(204213);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderShareFeedRelUI.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(204212);
        this.sIa.sHT.finish();
        AppMethodBeat.o(204212);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class q
    implements ValueAnimator.AnimatorUpdateListener
  {
    q(FinderShareFeedRelUI paramFinderShareFeedRelUI, AnimationLayout paramAnimationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(204217);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(204217);
        throw paramValueAnimator;
      }
      ((Float)paramValueAnimator).floatValue();
      FinderShareFeedRelUI.m(this.sHT).m(this.sIb.BUo);
      FinderShareFeedRelUI.m(this.sHT).invalidate();
      AppMethodBeat.o(204217);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class r
    implements View.OnClickListener
  {
    r(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, y.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204218);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sHT.md(true);
      ((View)localf.MLV).setVisibility(8);
      FinderShareFeedRelUI.h(this.sHT).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */