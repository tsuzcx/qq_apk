package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "setDefaultCommentScene", "(I)V", "detailCommentScene", "getDetailCommentScene", "setDetailCommentScene", "distance", "doShowAfterEnter", "", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "feedContactChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "followChangeEvent", "followStatus", "fromAnimateKey", "fromImageUrl", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "isFromAd", "isShareClickReport", "isTipsFirstShown", "isTitleShowed", "loader", "moreTipsLayout", "Landroid/view/View;", "ninePatchId", "parentBottom", "getParentBottom", "parentBottom$delegate", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "presenter", "reportScene", "getReportScene", "setReportScene", "requestScene", "getRequestScene", "setRequestScene", "scene", "getScene", "setScene", "sessionID", "getSessionID", "setSessionID", "showFinderEntry", "showRelatedList", "getShowRelatedList", "()Z", "setShowRelatedList", "(Z)V", "tabType", "getTabType", "setTabType", "tipsFirstShownCount", "tipsLayout", "tipsShownLimit", "tipsWording", "uiType", "getUiType", "setUiType", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "viewCallback", "changeFollow", "", "changeFollowState", "isFollowed", "changeFollowView", "checkBottomTips", "convertActivityFromTranslucent", "finish", "followUser", "getCommentScene", "getLayoutId", "getMenuStyle", "Lcom/tencent/mm/ui/MMActivityController$OptionMenuStyle;", "getMenuText", "getModel", "getPresenter", "getReportType", "getViewBottomInWindow", "view", "getViewCallback", "handleFollowStateChange", "hideCoverAnimation", "initActivityCloseAnimation", "initData", "initFollow", "initOnCreate", "initSimilarTipsShownCount", "initTipsLayout", "isAllowShowTips", "contact", "isSupportNavigationSwipeBack", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "setFollowStatus", "setTitleWithNickName", "nickName", "showFollowView", "showProgress", "ifShow", "showRetryTips", "unFollowUser", "Companion", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, i.b, g>
{
  private static final int sSZ = 1;
  private static final int sTa = 0;
  private static final int sTb = 1;
  private static final int sTc = 2;
  public static final FinderShareFeedRelUI.a sTd;
  final String TAG;
  private HashMap _$_findViewCache;
  long duw;
  private int dvm;
  String dzZ;
  private int rRE;
  private String rRi;
  int roH;
  private boolean sSA;
  private int sSB;
  private BaseFinderFeed sSC;
  private boolean sSD;
  private String sSE;
  private View sSF;
  private boolean sSG;
  private int sSH;
  private hb sSI;
  private FinderContact sSJ;
  private com.tencent.mm.sdk.b.c<hb> sSK;
  private final d.f sSL;
  private int sSM;
  private boolean sSN;
  private FrameLayout sSO;
  private FrameLayout sSP;
  private NinePatchCropImageView sSQ;
  private int sSR;
  private long sSS;
  private ViewAnimHelper.ViewInfo sST;
  private String sSU;
  private boolean sSV;
  private boolean sSW;
  private boolean sSX;
  private boolean sSY;
  private boolean sSk;
  private View sSm;
  private boolean sSo;
  private g sSt;
  private i.b sSu;
  private FinderFeedShareRelativeListLoader sSv;
  private int sSw;
  private int sSx;
  private int sSy;
  private final int sSz;
  private int scene;
  private final d.f shW;
  private boolean ski;
  private String tipsWording;
  
  static
  {
    AppMethodBeat.i(204854);
    sTd = new FinderShareFeedRelUI.a((byte)0);
    sSZ = 1;
    sTb = 1;
    sTc = 2;
    AppMethodBeat.o(204854);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(204853);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.scene = 2;
    this.dzZ = "";
    this.shW = d.g.O((d.g.a.a)new b(this));
    this.sSx = 25;
    this.sSz = 3;
    this.sSA = true;
    this.sSk = ((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry();
    this.rRi = "";
    this.sSD = true;
    this.sSE = "";
    this.sSH = sTa;
    this.sSL = d.g.O((d.g.a.a)new o(this));
    this.sSU = "";
    this.tipsWording = "";
    AppMethodBeat.o(204853);
  }
  
  private final void c(final FinderContact paramFinderContact)
  {
    AppMethodBeat.i(204834);
    if ((!this.ski) || (paramFinderContact == null) || (bu.lX(paramFinderContact.username, com.tencent.mm.model.v.aAK())) || (!((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry()))
    {
      AppMethodBeat.o(204834);
      return;
    }
    boolean bool = d(paramFinderContact);
    addTextOptionMenu(sSZ, mf(bool), (MenuItem.OnMenuItemClickListener)new t(this, paramFinderContact), null, mg(bool));
    me(bool);
    AppMethodBeat.o(204834);
  }
  
  private final int cMX()
  {
    AppMethodBeat.i(204829);
    int i = ((Number)this.sSL.getValue()).intValue();
    AppMethodBeat.o(204829);
    return i;
  }
  
  private final boolean cMZ()
  {
    AppMethodBeat.i(204841);
    if (this.sSA)
    {
      this.sSA = false;
      if (this.sSB <= this.sSz)
      {
        this.sSB += 1;
        localObject = com.tencent.mm.kernel.g.ajR();
        p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcK, Integer.valueOf(this.sSB));
      }
    }
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("isAllowShowTips: ");
    if (this.sSB <= this.sSz) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d((String)localObject, bool);
      if (this.sSB > this.sSz) {
        break;
      }
      AppMethodBeat.o(204841);
      return true;
    }
    AppMethodBeat.o(204841);
    return false;
  }
  
  private g cNa()
  {
    AppMethodBeat.i(204845);
    g localg = this.sSt;
    if (localg == null) {
      p.bdF("presenter");
    }
    AppMethodBeat.o(204845);
    return localg;
  }
  
  private static boolean d(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(204836);
    Object localObject = com.tencent.mm.plugin.finder.api.c.rPy;
    if (paramFinderContact != null)
    {
      localObject = paramFinderContact.username;
      paramFinderContact = (FinderContact)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramFinderContact = "";
    }
    boolean bool = c.a.ahW(paramFinderContact);
    AppMethodBeat.o(204836);
    return bool;
  }
  
  private static int ef(View paramView)
  {
    AppMethodBeat.i(204842);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(204842);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(204842);
    return i + j;
  }
  
  private final void md(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(204835);
    boolean bool1;
    int i;
    if (!paramBoolean)
    {
      bool1 = true;
      me(bool1);
      i = sSZ;
      if (paramBoolean) {
        break label72;
      }
      bool1 = true;
      label30:
      updateOptionMenuText(i, mf(bool1));
      i = sSZ;
      if (paramBoolean) {
        break label77;
      }
    }
    label72:
    label77:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      updateOptionMenuStyle(i, mg(paramBoolean));
      AppMethodBeat.o(204835);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
    }
  }
  
  private final void me(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = sTc;; i = sTb)
    {
      this.sSH = i;
      return;
    }
  }
  
  private final String mf(boolean paramBoolean)
  {
    AppMethodBeat.i(204837);
    if (paramBoolean)
    {
      str = getContext().getString(2131767061);
      p.g(str, "context.getString(R.string.finder_followed)");
      AppMethodBeat.o(204837);
      return str;
    }
    String str = getContext().getString(2131759228);
    p.g(str, "context.getString(R.string.finder_follow)");
    AppMethodBeat.o(204837);
    return str;
  }
  
  private static s.b mg(boolean paramBoolean)
  {
    if (paramBoolean) {
      return s.b.JwP;
    }
    return s.b.JwO;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204868);
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
    AppMethodBeat.o(204868);
    return localView1;
  }
  
  public final int cCL()
  {
    if (this.sSy != 0) {
      return this.sSy;
    }
    return this.sSx;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.d cDv()
  {
    AppMethodBeat.i(204828);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.shW.getValue();
    AppMethodBeat.o(204828);
    return locald;
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(204840);
    Object localObject1 = this.sSF;
    if (localObject1 == null) {
      p.bdF("moreTipsLayout");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.sSv;
    if (localObject1 == null) {
      p.bdF("loader");
    }
    if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(204840);
      return;
    }
    localObject1 = this.sSu;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    Object localObject2 = ((a.b)localObject1).scj.getRecyclerView().ci(0);
    localObject1 = this.sSu;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject1 = ((a.b)localObject1).scj.getRecyclerView().ci(1);
    if (localObject2 != null)
    {
      localObject2 = ((RecyclerView.w)localObject2).auu;
      p.g(localObject2, "firstItemView.itemView");
      int i = ef((View)localObject2);
      if ((cMX() > 0) && (cMX() - i < this.sSM))
      {
        if (cMZ())
        {
          localObject2 = this.sSF;
          if (localObject2 == null) {
            p.bdF("moreTipsLayout");
          }
          ((View)localObject2).setVisibility(0);
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView.w)localObject1).auu;
            p.g(localObject1, "secondItemView.itemView");
            ((View)localObject1).setVisibility(4);
          }
        }
        AppMethodBeat.o(204840);
        return;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).auu;
      p.g(localObject1, "secondItemView.itemView");
      ((View)localObject1).setVisibility(0);
    }
    AppMethodBeat.o(204840);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return !this.sSN;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(204851);
    super.finish();
    if (this.sSN) {
      overridePendingTransition(2130771986, 2130771986);
    }
    AppMethodBeat.o(204851);
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(204849);
    if (this.sSN)
    {
      AppMethodBeat.o(204849);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(204849);
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(204844);
    this.duw = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.rRi = ((String)localObject1);
    Object localObject3 = new y.f();
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((y.f)localObject3).NiY = localObject1;
    this.roH = getIntent().getIntExtra("report_scene", 0);
    this.rRE = getIntent().getIntExtra("key_reuqest_scene", -1);
    this.dzZ = getIntent().getStringExtra("from_user");
    this.dvm = getIntent().getIntExtra("tab_type", 0);
    this.ski = getIntent().getBooleanExtra("is_from_ad", false);
    this.sSD = getIntent().getBooleanExtra("key_need_related_list", true);
    this.sSE = getIntent().getStringExtra("key_session_id");
    int i;
    if (this.duw == 0L)
    {
      if (((CharSequence)this.rRi).length() != 0) {
        break label840;
      }
      i = 1;
      if (i != 0)
      {
        ae.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
        finish();
      }
    }
    localObject1 = findViewById(2131304742);
    p.g(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.sSm = ((View)localObject1);
    localObject1 = findViewById(2131307871);
    p.g(localObject1, "findViewById(R.id.more_similar_feed_tip_layout)");
    this.sSF = ((View)localObject1);
    localObject1 = this.sSF;
    if (localObject1 == null) {
      p.bdF("moreTipsLayout");
    }
    localObject1 = (TextView)((View)localObject1).findViewById(2131307438);
    p.g(localObject1, "tipsTv");
    al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.sSF;
    if (localObject1 == null) {
      p.bdF("moreTipsLayout");
    }
    localObject1 = ((View)localObject1).findViewById(2131307869);
    if (al.isDarkMode()) {
      ((View)localObject1).setBackgroundResource(2131234883);
    }
    for (;;)
    {
      localObject1 = this.sSF;
      if (localObject1 == null) {
        p.bdF("moreTipsLayout");
      }
      ((View)localObject1).findViewById(2131307870).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.n.sTj);
      this.sSM = com.tencent.mm.cb.a.fromDPToPix((Context)this, 104);
      if (this.ski) {
        this.sSK = ((com.tencent.mm.sdk.b.c)new FinderShareFeedRelUI.l(this));
      }
      localObject1 = findViewById(2131308209);
      p.g(localObject1, "findViewById(R.id.share_ui_content)");
      this.sSO = ((FrameLayout)localObject1);
      localObject1 = findViewById(2131308204);
      p.g(localObject1, "findViewById(R.id.share_anim_cover_layout)");
      this.sSP = ((FrameLayout)localObject1);
      localObject1 = findViewById(2131308205);
      p.g(localObject1, "findViewById(R.id.share_anim_image)");
      this.sSQ = ((NinePatchCropImageView)localObject1);
      if (!this.sSN) {
        break label1066;
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new h(this), 2131689492);
      double d = getIntent().getDoubleExtra("key_image_height", 1.166666626930237D);
      localObject1 = (t)com.tencent.mm.kernel.g.ad(t.class);
      localObject2 = this.sSU;
      localObject4 = this.sSQ;
      if (localObject4 == null) {
        p.bdF("animCoverImage");
      }
      ((t)localObject1).loadImage((String)localObject2, (ImageView)localObject4);
      localObject1 = this.sSQ;
      if (localObject1 == null) {
        p.bdF("animCoverImage");
      }
      localObject1 = ((NinePatchCropImageView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDisplayMetrics().widthPixels;
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(d * ((ViewGroup.LayoutParams)localObject1).width));
      localObject2 = this.sSQ;
      if (localObject2 == null) {
        p.bdF("animCoverImage");
      }
      ((NinePatchCropImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.sSQ;
      if (localObject1 == null) {
        p.bdF("animCoverImage");
      }
      ((NinePatchCropImageView)localObject1).setAlpha(0.0F);
      localObject1 = this.sSO;
      if (localObject1 == null) {
        p.bdF("contentUI");
      }
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = this.sSP;
      if (localObject1 == null) {
        p.bdF("animCoverLayout");
      }
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = this.sSP;
      if (localObject1 == null) {
        p.bdF("animCoverLayout");
      }
      ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.i.sTi);
      localObject1 = findViewById(2131307978);
      p.g(localObject1, "progressView");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break label856;
      }
      localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(204844);
      throw ((Throwable)localObject1);
      label840:
      i = 0;
      break;
      ((View)localObject1).setBackgroundResource(2131234882);
    }
    label856:
    localObject2 = (FrameLayout.LayoutParams)localObject2;
    ((FrameLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 18);
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
    ViewAnimHelper.ViewInfo localViewInfo = this.sST;
    ae.i(this.TAG, "runEnterAnimation " + localViewInfo + ", " + this.sSV);
    if ((localViewInfo != null) && (!this.sSV))
    {
      this.sSV = true;
      ae.i(this.TAG, "runEnterAnimation");
      ((AnimationLayout)localObject1).b((View)localObject2, (View)localObject4, localViewInfo, (Animator.AnimatorListener)new p(this, (View)localObject2), (ValueAnimator.AnimatorUpdateListener)new FinderShareFeedRelUI.q(this));
    }
    label1066:
    boolean bool;
    if (!this.ski)
    {
      setMMTitle(2131759376);
      if (this.duw != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
        localObject1 = d.a.xk(this.duw);
        if (localObject1 != null)
        {
          ae.i(this.TAG, "use cache cacheTime=" + com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + ' ' + "current=" + com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ch.aDc() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
          if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (ch.aDc() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
          {
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            this.sSC = b.a.j((FinderItem)localObject1);
          }
        }
      }
      if (this.sSC == null)
      {
        ae.d(this.TAG, "cache null.show progress");
        mi(true);
      }
      i = this.scene;
      localObject1 = (MMActivity)this;
      if (this.sSk) {
        break label2009;
      }
      bool = true;
      label1302:
      localObject1 = new g(i, (MMActivity)localObject1, bool, this.dvm);
      ((i.a)localObject1).rRn = this.duw;
      localObject2 = (String)((y.f)localObject3).NiY;
      p.h(localObject2, "<set-?>");
      ((i.a)localObject1).objectNonceId = ((String)localObject2);
      ((i.a)localObject1).rZB = this.sSC;
      localObject2 = this.rRi;
      p.h(localObject2, "<set-?>");
      ((i.a)localObject1).sef = ((String)localObject2);
      ((i.a)localObject1).seg = this.sSD;
      ((i.a)localObject1).seh = ((m)new d((g)localObject1, this, (y.f)localObject3));
      ((i.a)localObject1).sei = ((d.g.a.b)new e((g)localObject1, this, (y.f)localObject3));
      this.sSt = ((g)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.sSt;
      if (localObject2 == null) {
        p.bdF("presenter");
      }
      this.sSu = new i.b((MMActivity)localObject1, (i.a)localObject2, this.scene, cCL());
      if (this.roH != 15) {
        break label2015;
      }
      i = 6;
    }
    for (;;)
    {
      this.rRE = i;
      long l = this.duw;
      localObject1 = this.rRi;
      localObject2 = (String)((y.f)localObject3).NiY;
      i = this.dvm;
      bool = this.ski;
      int j = this.rRE;
      localObject3 = this.sSE;
      localObject4 = com.tencent.mm.ui.component.a.KEX;
      localObject3 = new FinderFeedShareRelativeListLoader(l, (String)localObject1, (String)localObject2, i, bool, j, (String)localObject3, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
      localObject2 = getIntent().getStringExtra("key_from_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).dGJ = ((String)localObject1);
      localObject2 = getIntent().getStringExtra("key_to_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).dsk = ((String)localObject1);
      ae.i(((FinderFeedShareRelativeListLoader)localObject3).getTAG(), "fromUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).dGJ + ",toUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).dsk);
      ((FinderFeedShareRelativeListLoader)localObject3).fetchEndCallback = ((d.g.a.b)new f(this));
      ((FinderFeedShareRelativeListLoader)localObject3).skg = ((d.g.a.b)new FinderShareFeedRelUI.g(this));
      this.sSv = ((FinderFeedShareRelativeListLoader)localObject3);
      if (this.roH != 0) {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1278L, 14L, 1L, false);
      }
      localObject1 = com.tencent.mm.kernel.g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      this.sSB = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.JcK, 0);
      ae.d(this.TAG, "tips first shown count by each feed: " + this.sSB);
      localObject1 = this.sSu;
      if (localObject1 == null) {
        p.bdF("viewCallback");
      }
      ((a.b)localObject1).scj.getRecyclerView().a((RecyclerView.m)new FinderShareFeedRelUI.j(this));
      localObject1 = this.sSt;
      if (localObject1 == null) {
        p.bdF("presenter");
      }
      ((g)localObject1).sTG = ((d.g.a.b)new k(this));
      cDv().a(this.scene, cCL(), (d.g.a.b)new m(this));
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = FinderReporterUIC.a.fc((Context)localObject1);
      if (localObject1 == null) {
        break label2035;
      }
      localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
      if (localObject1 == null) {
        break label2035;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)cDv());
      AppMethodBeat.o(204844);
      return;
      setMMTitle("");
      break;
      label2009:
      bool = false;
      break label1302;
      label2015:
      if (this.rRE < 0) {
        i = 3;
      } else {
        i = this.rRE;
      }
    }
    label2035:
    AppMethodBeat.o(204844);
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(204850);
    if (this.sSN)
    {
      AppMethodBeat.o(204850);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(204850);
    return bool;
  }
  
  public final void mh(final boolean paramBoolean)
  {
    AppMethodBeat.i(204838);
    final y.f localf = new y.f();
    localf.NiY = findViewById(2131304150);
    if ((View)localf.NiY != null)
    {
      if (paramBoolean)
      {
        ((View)localf.NiY).setVisibility(0);
        ((View)localf.NiY).setOnClickListener((View.OnClickListener)new u(this, paramBoolean, localf));
        AppMethodBeat.o(204838);
        return;
      }
      ((View)localf.NiY).setVisibility(8);
    }
    AppMethodBeat.o(204838);
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(204839);
    if (findViewById(2131307978) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(2131307978);
        p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(204839);
        return;
      }
      View localView = findViewById(2131307978);
      p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(204839);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(204852);
    if ((this.sSV) || (this.sSW))
    {
      AppMethodBeat.o(204852);
      return;
    }
    Object localObject2 = findViewById(2131304150);
    Object localObject1 = this.sST;
    if (this.sSN)
    {
      View localView = this.sSm;
      if (localView == null) {
        p.bdF("tipsLayout");
      }
      if (localView.getVisibility() != 0)
      {
        p.g(localObject2, "retryView");
        if ((((View)localObject2).getVisibility() != 0) && (localObject1 != null))
        {
          if (cNa().cNc()) {
            break label468;
          }
          localObject2 = this.sSO;
          if (localObject2 == null) {
            p.bdF("contentUI");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = this.sSP;
          if (localObject2 == null) {
            p.bdF("animCoverLayout");
          }
          ((FrameLayout)localObject2).setVisibility(0);
          if (this.sSR != 0)
          {
            localObject2 = this.sSQ;
            if (localObject2 == null) {
              p.bdF("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setBackground(null);
            localObject2 = this.sSQ;
            if (localObject2 == null) {
              p.bdF("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setNinePatchId(this.sSR);
            localObject2 = this.sSQ;
            if (localObject2 == null) {
              p.bdF("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setAlpha(1.0F);
            localObject2 = this.sSQ;
            if (localObject2 == null) {
              p.bdF("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).kB(((ViewAnimHelper.ViewInfo)localObject1).Lro.width(), ((ViewAnimHelper.ViewInfo)localObject1).Lro.height());
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
          ae.i(this.TAG, "runExitAnimation " + this.sSV + ", " + this.sSW);
          if ((this.sSV) || (this.sSW))
          {
            AppMethodBeat.o(204852);
            return;
          }
          this.sSW = true;
          localView.setVisibility(8);
          ((AnimationLayout)localObject2).a(localView, (View)localObject3, (ViewAnimHelper.ViewInfo)localObject1, (Animator.AnimatorListener)new r(this, findViewById(2131296345)), (ValueAnimator.AnimatorUpdateListener)new FinderShareFeedRelUI.s(this, (AnimationLayout)localObject2));
          localObject1 = com.tencent.mm.sdk.b.a.IvT;
          localObject2 = new hp();
          ((hp)localObject2).dvh.key = this.sSS;
          ((com.tencent.mm.sdk.b.a)localObject1).l((com.tencent.mm.sdk.b.b)localObject2);
          AppMethodBeat.o(204852);
          return;
        }
      }
    }
    if (!cNa().cNc()) {
      finish();
    }
    label468:
    AppMethodBeat.o(204852);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204830);
    this.sST = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("key_view_info"));
    String str2 = getIntent().getStringExtra("key_image_url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.sSU = str1;
    this.sSR = getIntent().getIntExtra("key_nine_patch_id", 0);
    this.sSS = getIntent().getLongExtra("key_animate_id", 0L);
    this.sSx = getIntent().getIntExtra("key_comment_scene", 25);
    this.sSy = getIntent().getIntExtra("key_detail_comment_scene", 0);
    if (this.sSx == 38) {
      this.sSw = 2;
    }
    if ((this.sST != null) && (!bu.isNullOrNil(this.sSU))) {
      this.sSN = true;
    }
    super.onCreate(paramBundle);
    AppMethodBeat.o(204830);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(204831);
    super.onCreateBeforeSetContentView();
    if (this.sSN)
    {
      if (al.isDarkMode())
      {
        setTheme(2131821784);
        AppMethodBeat.o(204831);
        return;
      }
      setTheme(2131821785);
    }
    AppMethodBeat.o(204831);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204848);
    Object localObject;
    long l;
    int i;
    String str;
    if ((this.roH != 0) && (!this.sSo))
    {
      if (!this.ski) {
        break label183;
      }
      localObject = com.tencent.mm.plugin.finder.report.i.syT;
      l = this.duw;
      i = this.roH;
      str = this.dzZ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.i.a(l, i, 4L, (String)localObject, 0, 2);
    }
    for (;;)
    {
      this.sSo = true;
      cDv().onDetach();
      localObject = FinderReporterUIC.tnG;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = FinderReporterUIC.a.fc((Context)localObject);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)cDv());
        }
      }
      localObject = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fp(this.dvm);
      localObject = this.sSK;
      if (localObject != null) {
        ((com.tencent.mm.sdk.b.c)localObject).dead();
      }
      super.onDestroy();
      AppMethodBeat.o(204848);
      return;
      label183:
      localObject = com.tencent.mm.plugin.finder.report.i.syT;
      l = this.duw;
      i = this.roH;
      str = this.dzZ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.i.a(l, i, (String)localObject, 0, 2);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204833);
    super.onPause();
    if (this.ski)
    {
      com.tencent.mm.sdk.b.c localc = this.sSK;
      if (localc != null)
      {
        localc.alive();
        AppMethodBeat.o(204833);
        return;
      }
    }
    AppMethodBeat.o(204833);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204832);
    super.onResume();
    Object localObject;
    boolean bool;
    int i;
    if (this.ski)
    {
      localObject = this.sSK;
      if (localObject != null) {
        ((com.tencent.mm.sdk.b.c)localObject).dead();
      }
      bool = d(this.sSJ);
      ae.i("mylog", "isFollowed: " + bool + " followStatus:" + this.sSH);
      if (this.sSI != null)
      {
        i = this.sSH;
        if (i != sTb) {
          break label143;
        }
        if (bool) {
          md(false);
        }
      }
    }
    for (;;)
    {
      this.sSI = null;
      if (this.sSH == sTa) {
        c(this.sSJ);
      }
      localObject = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fl(this.dvm);
      AppMethodBeat.o(204832);
      return;
      label143:
      if ((i == sTc) && (!bool)) {
        md(true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    b(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204800);
      FinderShareFeedRelUI.q(this.sTe).setVisibility(8);
      this.sTf.setAlpha(1.0F);
      FinderShareFeedRelUI.r(this.sTe);
      AppMethodBeat.o(204800);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4$1"})
  static final class d
    extends q
    implements m<Integer, String, z>
  {
    d(g paramg, FinderShareFeedRelUI paramFinderShareFeedRelUI, y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4$2"})
  static final class e
    extends q
    implements d.g.a.b<FinderObject, z>
  {
    e(g paramg, FinderShareFeedRelUI paramFinderShareFeedRelUI, y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$1"})
  static final class f
    extends q
    implements d.g.a.b<IResponse<am>, z>
  {
    f(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204805);
      this.sTe.onBackPressed();
      AppMethodBeat.o(204805);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
  static final class k
    extends q
    implements d.g.a.b<View, z>
  {
    k(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    m(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements d.g.a.a<Integer>
  {
    o(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    p(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204817);
      FinderShareFeedRelUI.m(this.sTe);
      FinderShareFeedRelUI.n(this.sTe).setVisibility(0);
      if (FinderShareFeedRelUI.o(this.sTe)) {
        FinderShareFeedRelUI.b(this.sTe);
      }
      ae.i(this.sTe.TAG, "runEnterAnimation end " + FinderShareFeedRelUI.o(this.sTe));
      AppMethodBeat.o(204817);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(204816);
      ae.i(this.sTe.TAG, "runEnterAnimation start");
      AppMethodBeat.o(204816);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204818);
      this.sTf.setVisibility(0);
      AppMethodBeat.o(204818);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    r(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(204823);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(204823);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204822);
      p.h(paramAnimator, "animation");
      FinderShareFeedRelUI.p(this.sTe).postDelayed((Runnable)new a(this), 400L);
      this.sTe.overridePendingTransition(2130771986, 2130771986);
      ae.i(this.sTe.TAG, "runExitAnimation end");
      AppMethodBeat.o(204822);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(204824);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(204824);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204821);
      p.h(paramAnimator, "animation");
      paramAnimator = this.sTk;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(0.0F);
      }
      ae.i(this.sTe.TAG, "runExitAnimation start");
      AppMethodBeat.o(204821);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderShareFeedRelUI.r paramr) {}
      
      public final void run()
      {
        AppMethodBeat.i(204820);
        this.sTl.sTe.finish();
        AppMethodBeat.o(204820);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showFollowView$1$1", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "plugin-finder_release"})
  public static final class t
    implements MenuItem.OnMenuItemClickListener
  {
    t(FinderShareFeedRelUI paramFinderShareFeedRelUI, FinderContact paramFinderContact) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204826);
      FinderShareFeedRelUI.k(this.sTe);
      AppMethodBeat.o(204826);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class u
    implements View.OnClickListener
  {
    u(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, y.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204827);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sTe.mi(true);
      ((View)localf.NiY).setVisibility(8);
      FinderShareFeedRelUI.l(this.sTe).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */