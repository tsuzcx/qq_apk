package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hx;
import com.tencent.mm.autogen.a.ib;
import com.tencent.mm.autogen.a.jl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.o;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.plugin.finder.viewmodel.component.w;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.r;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "animView", "Landroid/view/View;", "authContent", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "checkExposeTaskAdded", "", "getCheckExposeTaskAdded", "()Z", "setCheckExposeTaskAdded", "(Z)V", "checkedDeepEnjoy", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "deepEnjoyTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "defaultClickTabContextId", "getDefaultClickTabContextId", "defaultClickTabContextId$delegate", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "defaultCommentScene$delegate", "detailCommentScene", "getDetailCommentScene", "detailCommentScene$delegate", "dismissEntranceRunnable", "Ljava/lang/Runnable;", "dismissPopupTipsRunnable", "distance", "doShowAfterEnter", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "enterAnimImageUrl", "exitAnimImageUrl", "feedContactChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "finderFeedSnsAdHandler", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "followChangeEvent", "followStatus", "forceFullScreen", "fromAnimateKey", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "guideBarItem", "Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "initFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFromAd", "isPostingScene", "setPostingScene", "isShareClickReport", "isTitleShowed", "lastY", "", "getLastY", "()F", "setLastY", "(F)V", "loader", "localFeedId", "getLocalFeedId", "setLocalFeedId", "mediaType", "ninePatchId", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "popupEntranceExposed", "getPopupEntranceExposed", "setPopupEntranceExposed", "popupEntranceLayout", "popupTipsExposed", "getPopupTipsExposed", "setPopupTipsExposed", "popupTipsLayout", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "reportUiType", "getReportUiType", "setReportUiType", "requestScene", "getRequestScene", "setRequestScene", "scene", "getScene", "setScene", "seekLayoutId", "sessionID", "getSessionID", "setSessionID", "shareVideoFinish", "getShareVideoFinish", "setShareVideoFinish", "showFinderEntry", "showRelatedList", "getShowRelatedList", "setShowRelatedList", "staticTipsExposed", "getStaticTipsExposed", "setStaticTipsExposed", "staticTipsShowing", "getStaticTipsShowing", "setStaticTipsShowing", "tabType", "getTabType", "tabType$delegate", "tipsLayout", "tipsWording", "touchSlop", "uiType", "getUiType", "setUiType", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "videoFinishListener", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1;", "viewCallback", "changeFollow", "", "changeFollowState", "isFollowed", "changeFollowView", "checkPopupEntranceInit", "checkPopupTipsInit", "checkSeek", "convertActivityFromTranslucent", "dismissEntrance", "dismissLayout", "view", "heightDp", "duration", "offset", "onDismiss", "Lkotlin/Function0;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "finish", "fixActionBarStatus", "followUser", "getCommentScene", "getLayoutId", "getMenuStyle", "Lcom/tencent/mm/ui/MMActivityController$OptionMenuStyle;", "getMenuText", "getModel", "getPresenter", "getReportType", "getViewCallback", "handleFollowStateChange", "handlePopupViews", "hideCoverAnimation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActivityCloseAnimation", "initData", "initFollow", "initOnCreate", "isFinderClose", "extStatus", "contact", "isHideStatusBar", "isShowGuideNotAllow", "isShowGuideScene", "isSupportNavigationSwipeBack", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "openFinderEntrance", "overlayStatusBar", "popupEntrance", "popupTips", "pullDown", "delayTime", "pullDownOtherViews", "height", "pullUpOtherViews", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "setFollowStatus", "setTitleWithNickName", "nickName", "shouldPopupEntrance", "shareVideoHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shouldPopupTips", "shouldShowGuideNext", "shouldShowSideGuide", "showFollowView", "showGuideNext", "showProgress", "ifShow", "showRetryTips", "showSideGuide", "unFollowUser", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, j.b, j>
{
  public static final a FUE;
  private String ABC;
  private int ACA;
  private boolean AVa;
  private final int AVt;
  private FinderContact AVu;
  private final kotlin.j Bae;
  private final kotlin.j Baf;
  private boolean Bgc;
  private bbm Bgp;
  private View EBQ;
  private boolean FUA;
  private boolean FUC;
  private j FUF;
  private j.b FUG;
  private FinderFeedShareRelativeListLoader FUH;
  private int FUI;
  int FUJ;
  private final kotlin.j FUK;
  private final kotlin.j FUL;
  private final kotlin.j FUM;
  private BaseFinderFeed FUN;
  private boolean FUO;
  private String FUP;
  private long FUQ;
  boolean FUR;
  private boolean FUS;
  private boolean FUT;
  private View FUU;
  private View FUV;
  private boolean FUW;
  private int FUX;
  private hx FUY;
  private FinderObject FUZ;
  private boolean FVa;
  private IListener<hx> FVb;
  private o FVc;
  private int FVd;
  private boolean FVe;
  private FrameLayout FVf;
  private FrameLayout FVg;
  private NinePatchCropImageView FVh;
  private int FVi;
  private long FVj;
  private ViewAnimHelper.ViewInfo FVk;
  private String FVl;
  private String FVm;
  private boolean FVn;
  private boolean FVo;
  private boolean FVp;
  private boolean FVq;
  private boolean FVr;
  private String FVs;
  private com.tencent.threadpool.i.d<?> FVt;
  private final videoFinishListener.1 FVu;
  private Runnable FVv;
  private View FVw;
  private Runnable FVx;
  private final kotlin.j Fqc;
  final String TAG;
  private float cxN;
  private final int doK;
  long feedId;
  String hQQ;
  private int mediaType;
  private int scene;
  private String tipsWording;
  int ybL;
  
  static
  {
    AppMethodBeat.i(347537);
    FUE = new a((byte)0);
    AppMethodBeat.o(347537);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(347055);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.FUJ = 2;
    this.scene = 2;
    this.hQQ = "";
    this.Bae = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Baf = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.FUK = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.FUL = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.FUM = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.FUA = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    this.ABC = "";
    this.FUO = true;
    this.FUP = "";
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new ab(this));
    this.FVl = "";
    this.FVm = "";
    this.tipsWording = "";
    this.FVs = "";
    this.AVt = e.e.finder_seek_bar_footer_layout;
    this.FVu = new IListener(com.tencent.mm.app.f.hfK) {};
    this.cxN = -1.0F;
    this.doK = ViewConfiguration.getTouchSlop();
    AppMethodBeat.o(347055);
  }
  
  private final boolean R(RecyclerView.v paramv)
  {
    AppMethodBeat.i(347181);
    if (paramv == null)
    {
      AppMethodBeat.o(347181);
      return false;
    }
    paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVv().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(347181);
      return false;
    }
    if ((this.Bgp != null) && (!this.Bgc))
    {
      paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eUW().bmg()).intValue() == 1) && (this.FUR) && (!this.FUT))
      {
        AppMethodBeat.o(347181);
        return true;
      }
    }
    AppMethodBeat.o(347181);
    return false;
  }
  
  private final boolean S(RecyclerView.v paramv)
  {
    AppMethodBeat.i(347188);
    if (paramv == null)
    {
      AppMethodBeat.o(347188);
      return false;
    }
    paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVv().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(347188);
      return false;
    }
    paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUW().bmg()).intValue() == 0)
    {
      paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUV().bmg()).intValue() == 1)
      {
        paramv = com.tencent.mm.plugin.finder.storage.d.FAy;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.eUY().bmg()).intValue() == 1) && (this.FUR) && (!this.FUS))
        {
          AppMethodBeat.o(347188);
          return true;
        }
      }
    }
    AppMethodBeat.o(347188);
    return false;
  }
  
  private static final Map a(FinderShareFeedRelUI paramFinderShareFeedRelUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(370742);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramString = paramFinderShareFeedRelUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!org.apache.commons.c.i.hm(paramString)) {
        break label222;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label222:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = kotlin.v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = kotlin.v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = kotlin.v.Y("finder_tab_context_id", localObject1);
      paramString = kotlin.v.Y("extra_info", paramString);
      paramFinderShareFeedRelUI = paramFinderShareFeedRelUI.getIntent();
      if (paramFinderShareFeedRelUI == null) {}
      for (paramFinderShareFeedRelUI = localObject2;; paramFinderShareFeedRelUI = paramFinderShareFeedRelUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderShareFeedRelUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, kotlin.v.Y("enter_source_info", String.valueOf(paramFinderShareFeedRelUI)) });
        AppMethodBeat.o(370742);
        return paramFinderShareFeedRelUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private final void a(float paramFloat1, long paramLong, float paramFloat2)
  {
    View localView = null;
    AppMethodBeat.i(347116);
    Object localObject2 = this.FUG;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    Object localObject3 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label268;
      }
      localObject2 = null;
      label63:
      if (localObject3 != null) {
        break label299;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramFloat1);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      float f = paramFloat1;
      if (paramFloat2 > 0.0F) {
        f = paramFloat1 + paramFloat2;
      }
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(f);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(f);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      AppMethodBeat.o(347116);
      return;
      localObject1 = ((RecyclerView.v)localObject3).caK;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((View)localObject1).findViewById(e.e.finder_feed_full_footer_layout);
      break;
      label268:
      localObject2 = ((RecyclerView.v)localObject3).caK;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label63;
      }
      localObject2 = ((View)localObject2).findViewById(e.e.finder_seek_bar_footer_layout);
      break label63;
      label299:
      localObject3 = ((RecyclerView.v)localObject3).caK;
      if (localObject3 != null) {
        localView = ((View)localObject3).findViewById(e.e.fake_float_play_icon);
      }
    }
  }
  
  private final void a(View paramView, int paramInt, long paramLong, float paramFloat, final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(347101);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramInt = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), paramInt);
      a(paramInt, paramLong, paramFloat);
      ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.translationYBy(paramInt);
          if (localViewPropertyAnimator != null)
          {
            localViewPropertyAnimator = localViewPropertyAnimator.setDuration(paramLong);
            if (localViewPropertyAnimator != null)
            {
              paramView = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new h(paramView, parama));
              if (paramView != null) {
                paramView.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(347101);
  }
  
  private static final void a(FinderShareFeedRelUI paramFinderShareFeedRelUI, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(370744);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderShareFeedRelUI = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(370744);
      throw paramFinderShareFeedRelUI;
    }
    if (((Float)paramValueAnimator).floatValue() > 0.1F)
    {
      NinePatchCropImageView localNinePatchCropImageView = paramFinderShareFeedRelUI.FVh;
      paramValueAnimator = localNinePatchCropImageView;
      if (localNinePatchCropImageView == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        paramValueAnimator = null;
      }
      if (paramValueAnimator.getAlpha() < 0.9F)
      {
        paramFinderShareFeedRelUI = paramFinderShareFeedRelUI.FVh;
        if (paramFinderShareFeedRelUI != null) {
          break label116;
        }
        kotlin.g.b.s.bIx("animCoverImage");
        paramFinderShareFeedRelUI = localObject;
      }
    }
    label116:
    for (;;)
    {
      paramFinderShareFeedRelUI.setAlpha(1.0F);
      AppMethodBeat.o(370744);
      return;
    }
  }
  
  private static final void a(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView1, View paramView2)
  {
    AppMethodBeat.i(370737);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderShareFeedRelUI);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramFinderShareFeedRelUI.pZ(true);
    paramView1.setVisibility(8);
    paramView1 = paramFinderShareFeedRelUI.FUF;
    paramFinderShareFeedRelUI = paramView1;
    if (paramView1 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      paramFinderShareFeedRelUI = null;
    }
    paramFinderShareFeedRelUI.requestRefresh();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370737);
  }
  
  private static final void a(FinderShareFeedRelUI paramFinderShareFeedRelUI, FinderLinearLayoutManager paramFinderLinearLayoutManager, final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(370745);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    kotlin.g.b.s.u(paramRecyclerView, "$it");
    final long l = paramFinderShareFeedRelUI.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
    if (l > 0L) {
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(paramFinderLinearLayoutManager, paramRecyclerView, l));
    }
    AppMethodBeat.o(370745);
  }
  
  private static final void a(final FinderShareFeedRelUI paramFinderShareFeedRelUI, ViewAnimHelper.ViewInfo paramViewInfo)
  {
    AppMethodBeat.i(370746);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    Object localObject = paramFinderShareFeedRelUI.findViewById(e.e.share_animation_layout);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.share_animation_layout)");
    localObject = (AnimationLayout)localObject;
    View localView1 = paramFinderShareFeedRelUI.findViewById(e.e.gallery_bg);
    kotlin.g.b.s.s(localView1, "findViewById(R.id.gallery_bg)");
    View localView2 = paramFinderShareFeedRelUI.getWindow().getDecorView();
    kotlin.g.b.s.s(localView2, "window.decorView");
    Log.i(paramFinderShareFeedRelUI.TAG, "runExitAnimation " + paramFinderShareFeedRelUI.FVn + ", " + paramFinderShareFeedRelUI.FVo);
    if ((paramFinderShareFeedRelUI.FVn) || (paramFinderShareFeedRelUI.FVo))
    {
      AppMethodBeat.o(370746);
      return;
    }
    paramFinderShareFeedRelUI.FVo = true;
    localView1.setVisibility(8);
    View localView3 = paramFinderShareFeedRelUI.findViewById(e.e.full_actionbar);
    if (localView3 != null) {
      localView3.setVisibility(8);
    }
    if (paramFinderShareFeedRelUI.efA() != 0) {
      paramFinderShareFeedRelUI.setNavigationbarColor(paramFinderShareFeedRelUI.efA());
    }
    ((AnimationLayout)localObject).a(localView1, localView2, paramViewInfo, (Animator.AnimatorListener)new w(paramFinderShareFeedRelUI.findViewById(e.e.action_bar_container), paramFinderShareFeedRelUI), FinderShareFeedRelUI..ExternalSyntheticLambda1.INSTANCE);
    paramViewInfo = new jl();
    paramViewInfo.hLb.key = paramFinderShareFeedRelUI.FVj;
    paramViewInfo.publish();
    AppMethodBeat.o(370746);
  }
  
  private static final boolean a(FinderShareFeedRelUI paramFinderShareFeedRelUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347244);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramFinderShareFeedRelUI.onBackPressed();
    AppMethodBeat.o(347244);
    return true;
  }
  
  private static final void b(FinderShareFeedRelUI paramFinderShareFeedRelUI)
  {
    AppMethodBeat.i(347258);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    j.b localb = paramFinderShareFeedRelUI.FUG;
    paramFinderShareFeedRelUI = localb;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      paramFinderShareFeedRelUI = null;
    }
    paramFinderShareFeedRelUI.ATx.getRecyclerView().setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
    AppMethodBeat.o(347258);
  }
  
  private static final void b(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView)
  {
    AppMethodBeat.i(347273);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderShareFeedRelUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    long l = com.tencent.mm.model.z.bAR();
    int i;
    int j;
    label277:
    label345:
    int k;
    if ((0x0 & l) != 0L)
    {
      i = 1;
      if (i != 0)
      {
        l = 0xFFFFFFFF & l;
        h.baE().ban().B(147457, Long.valueOf(l));
        Log.i(paramFinderShareFeedRelUI.TAG, kotlin.g.b.s.X("openFinderEntrance extstatus:", Long.valueOf(l)));
        paramView = new cas();
        paramView.aajJ = 57;
        paramView.NkL = 1;
        ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d((com.tencent.mm.plugin.messenger.foundation.a.a.k.b)new k.a(23, (com.tencent.mm.bx.a)paramView));
        Log.d(paramFinderShareFeedRelUI.TAG, "openFinderEntrance switch functionId:" + paramView.aajJ + " to " + paramView.NkL);
      }
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      switch (((Number)com.tencent.mm.plugin.finder.storage.d.eUU().bmg()).intValue())
      {
      case 1: 
      default: 
        i = 1;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        j = 18;
        localObject1 = paramFinderShareFeedRelUI.getString(e.h.finder_bottom_popup_entrance_default_wording);
        kotlin.g.b.s.s(localObject1, "getString(R.string.finde…entrance_default_wording)");
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        bui localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramFinderShareFeedRelUI).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
        localObject2 = com.tencent.mm.plugin.finder.report.ac.Fsk;
        com.tencent.mm.plugin.finder.report.ac.eNa();
        l = com.tencent.mm.model.cn.bDv();
        localObject2 = paramFinderShareFeedRelUI.Bgp;
        if (localObject2 == null)
        {
          localObject2 = paramFinderShareFeedRelUI.Bgp;
          if (localObject2 != null) {
            break label617;
          }
          k = 0;
          label359:
          com.tencent.mm.plugin.finder.report.ac.a(localbui, 2, l, 0, 2, (String)localObject1, Integer.valueOf(k), null, 128);
          paramFinderShareFeedRelUI.finish();
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(i).a(d.d.GKM);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra(paramView, true);
          ((Intent)localObject1).putExtra("KEY_FROM_SHARE_REL", true);
          ((Intent)localObject1).putExtra("KEY_TARGET_TAB_TYPE", 4);
          paramView = paramFinderShareFeedRelUI.Bgp;
          if (paramView != null) {
            break label627;
          }
          paramView = null;
          label462:
          ((Intent)localObject1).putExtra("KEY_GUIDE_BAR_OBJ_ID", (Serializable)paramView);
          paramView = localbui.zIO;
          if (paramView != null) {
            break label638;
          }
          i = -1;
        }
        break;
      }
    }
    for (;;)
    {
      if ((i > 0) && (j > 0)) {
        ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(i, 9, j, (Intent)localObject1);
      }
      paramView = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMN();
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.a((Context)paramFinderShareFeedRelUI, (Intent)localObject1, 1, false, 8);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347273);
      return;
      i = 0;
      break;
      i = 4;
      paramView = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
      j = 19;
      break label277;
      i = 3;
      paramView = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
      j = 17;
      break label277;
      localObject2 = ((bbm)localObject2).title;
      if (localObject2 == null) {
        break label345;
      }
      localObject1 = localObject2;
      break label345;
      label617:
      k = ((bbm)localObject2).ZMe;
      break label359;
      label627:
      paramView = Long.valueOf(paramView.object_id);
      break label462;
      label638:
      paramView = kotlin.n.n.a((CharSequence)paramView, new char[] { '-' }, 0, 6);
      if (paramView == null)
      {
        i = -1;
      }
      else
      {
        paramView = (String)paramView.get(0);
        if (paramView == null) {
          i = -1;
        } else {
          i = Integer.parseInt(paramView);
        }
      }
    }
  }
  
  private final void c(float paramFloat, long paramLong)
  {
    View localView = null;
    AppMethodBeat.i(347196);
    Object localObject2 = this.FUG;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    Object localObject3 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label265;
      }
      localObject2 = null;
      label63:
      if (localObject3 != null) {
        break label297;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((View)localObject1).setTranslationY(((View)localObject1).getTranslationY() + paramFloat);
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-paramFloat);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-paramFloat);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-paramFloat);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      AppMethodBeat.o(347196);
      return;
      localObject1 = ((RecyclerView.v)localObject3).caK;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((View)localObject1).findViewById(e.e.finder_feed_full_footer_layout);
      break;
      label265:
      localObject2 = ((RecyclerView.v)localObject3).caK;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label63;
      }
      localObject2 = ((View)localObject2).findViewById(this.AVt);
      break label63;
      label297:
      localObject3 = ((RecyclerView.v)localObject3).caK;
      if (localObject3 != null) {
        localView = ((View)localObject3).findViewById(e.e.fake_float_play_icon);
      }
    }
  }
  
  private static final void c(FinderShareFeedRelUI paramFinderShareFeedRelUI)
  {
    AppMethodBeat.i(370738);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramFinderShareFeedRelUI.fbW();
    AppMethodBeat.o(370738);
  }
  
  private static final void c(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView)
  {
    AppMethodBeat.i(370740);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderShareFeedRelUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramFinderShareFeedRelUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370740);
  }
  
  private static final void d(FinderShareFeedRelUI paramFinderShareFeedRelUI)
  {
    AppMethodBeat.i(370739);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    a(paramFinderShareFeedRelUI, paramFinderShareFeedRelUI.FUV);
    AppMethodBeat.o(370739);
  }
  
  private static final void d(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView)
  {
    AppMethodBeat.i(370741);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderShareFeedRelUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    paramView = bb.FuK;
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramView = as.a.hu((Context)paramFinderShareFeedRelUI);
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.fou())
    {
      bb.a(paramView, "button_create_float_frame", 1);
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramFinderShareFeedRelUI = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramFinderShareFeedRelUI).q(w.class);
      kotlin.g.b.s.s(paramFinderShareFeedRelUI, "UICProvider.of(this).get…allNormalUIC::class.java)");
      w.a((w)paramFinderShareFeedRelUI);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370741);
      return;
    }
  }
  
  private static final void e(ValueAnimator paramValueAnimator) {}
  
  private static final void e(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView)
  {
    AppMethodBeat.i(370747);
    kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
    kotlin.g.b.s.u(paramView, "$view");
    paramFinderShareFeedRelUI.a(paramView, 168, 300L, com.tencent.mm.cd.a.fromDPToPix((Context)paramFinderShareFeedRelUI.getContext(), 24), (kotlin.g.a.a)new u(paramFinderShareFeedRelUI));
    AppMethodBeat.o(370747);
  }
  
  private com.tencent.mm.plugin.findersdk.a.as ecM()
  {
    AppMethodBeat.i(347058);
    com.tencent.mm.plugin.findersdk.a.as localas = (com.tencent.mm.plugin.findersdk.a.as)this.Baf.getValue();
    AppMethodBeat.o(347058);
    return localas;
  }
  
  private static boolean f(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(347142);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    if (paramFinderContact == null) {
      paramFinderContact = "";
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.plugin.finder.api.d.a.a(paramFinderContact, null, false, false, 14);
      AppMethodBeat.o(347142);
      return bool;
      localObject = paramFinderContact.username;
      paramFinderContact = (FinderContact)localObject;
      if (localObject == null) {
        paramFinderContact = "";
      }
    }
  }
  
  private final int fbS()
  {
    AppMethodBeat.i(347063);
    int i = ((Number)this.FUK.getValue()).intValue();
    AppMethodBeat.o(347063);
    return i;
  }
  
  private final int fbT()
  {
    AppMethodBeat.i(347068);
    int i = ((Number)this.FUL.getValue()).intValue();
    AppMethodBeat.o(347068);
    return i;
  }
  
  private final void fbU()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347083);
    if (this.FUU == null)
    {
      j.b localb = this.FUG;
      localObject1 = localb;
      if (localb == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
      if (localObject1 != null) {
        break label91;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label99;
      }
    }
    label91:
    label99:
    for (Object localObject1 = localObject2;; localObject1 = ((ViewStub)((View)localObject1).findViewById(e.e.finder_popup_entrance_layout)).inflate())
    {
      this.FUU = ((View)localObject1);
      localObject1 = this.FUU;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new FinderShareFeedRelUI..ExternalSyntheticLambda5(this));
      }
      AppMethodBeat.o(347083);
      return;
      localObject1 = ((RecyclerView.v)localObject1).caK;
      break;
    }
  }
  
  private final void fbV()
  {
    AppMethodBeat.i(347090);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label161:
    label172:
    View localView;
    if (this.FUV == null)
    {
      localObject2 = this.FUH;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("loader");
        localObject1 = null;
      }
      if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
      {
        AppMethodBeat.o(347090);
        return;
      }
      localObject2 = this.FUG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((RecyclerView.v)localObject1).caK)
      {
        AppMethodBeat.o(347090);
        return;
      }
      localObject3 = ((View)localObject1).findViewById(e.e.more_similar_parent);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((ViewStub)((View)localObject1).findViewById(e.e.more_similar_feed_tip_layout)).inflate();
      }
      this.FUV = ((View)localObject2);
      localObject1 = this.FUV;
      if (localObject1 != null) {
        break label315;
      }
      localObject1 = null;
      localObject2 = this.FUV;
      if (localObject2 != null) {
        break label329;
      }
      localObject2 = null;
      localObject3 = this.FUV;
      if (localObject3 != null) {
        break label340;
      }
      localObject3 = null;
      localView = this.FUV;
      if (localView != null) {
        break label354;
      }
      localView = null;
      label186:
      if (localView != null) {
        localView.setOnClickListener(FinderShareFeedRelUI..ExternalSyntheticLambda7.INSTANCE);
      }
      localObject4 = this.FUV;
      if (localObject4 != null) {
        ((View)localObject4).setVisibility(8);
      }
      if (localObject1 != null) {
        break label367;
      }
    }
    label315:
    label329:
    label340:
    label354:
    label367:
    for (Object localObject4 = null;; localObject4 = ((TextView)localObject1).getPaint())
    {
      aw.a((Paint)localObject4, 0.8F);
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.White));
      }
      if (localObject3 != null) {
        ((WeImageView)localObject3).setIconColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.White));
      }
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(com.tencent.mm.plugin.finder.e.b.transparent);
      }
      if (localView != null) {
        localView.setBackgroundResource(com.tencent.mm.plugin.finder.e.b.transparent);
      }
      this.FVd = com.tencent.mm.cd.a.fromDPToPix((Context)this, 104);
      AppMethodBeat.o(347090);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.finder_similar_feed_tv);
      break;
      localObject2 = ((View)localObject2).findViewById(e.e.more_similar_bg_view);
      break label161;
      localObject3 = (WeImageView)((View)localObject3).findViewById(e.e.finder_similar_feed_iv);
      break label172;
      localView = localView.findViewById(e.e.more_similar_eat_click_view);
      break label186;
    }
  }
  
  private final void fbW()
  {
    AppMethodBeat.i(347096);
    Object localObject = this.FUU;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      a(this, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 80));
      ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.setDuration(300L);
          if (localViewPropertyAnimator != null)
          {
            localObject = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new g((View)localObject));
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
    }
    AppMethodBeat.o(347096);
  }
  
  private final void fbY()
  {
    AppMethodBeat.i(347164);
    fbU();
    View localView = this.FUU;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l;
    if (localView != null)
    {
      localObject1 = this.Bgp;
      if (localObject1 != null)
      {
        ((TextView)localView.findViewById(e.e.wording_tv)).setText((CharSequence)((bbm)localObject1).title);
        localObject2 = localView.findViewById(e.e.avatar_3_iv);
        kotlin.g.b.s.s(localObject2, "layout.findViewById(R.id.avatar_3_iv)");
        localObject2 = (ImageView)localObject2;
        localObject3 = localView.findViewById(e.e.avatar_2_iv);
        kotlin.g.b.s.s(localObject3, "layout.findViewById(R.id.avatar_2_iv)");
        localObject3 = (ImageView)localObject3;
        Object localObject4 = localView.findViewById(e.e.avatar_1_iv);
        kotlin.g.b.s.s(localObject4, "layout.findViewById(R.id.avatar_1_iv)");
        localObject2 = kotlin.a.p.listOf(new ImageView[] { localObject2, localObject3, (ImageView)localObject4 });
        localObject1 = new ArrayList((Collection)((bbm)localObject1).ZMd);
        kotlin.a.p.oJ((List)localObject1);
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject3 = (ImageView)localObject3;
          Object localObject5 = (bco)kotlin.a.p.ae((List)localObject1, i);
          if (localObject5 != null)
          {
            localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject4 = com.tencent.mm.plugin.finder.loader.p.eCr();
            localObject5 = new com.tencent.mm.plugin.finder.loader.b(((bco)localObject5).nVs);
            com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((com.tencent.mm.loader.d)localObject4).a(localObject5, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
            i = j;
          }
          else
          {
            ((ImageView)localObject3).setVisibility(8);
            i = j;
          }
        }
      }
      localView.setAlpha(0.0F);
      localView.setVisibility(0);
      c(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 80), 300L);
      localView.animate().alpha(1.0F).setDuration(300L).start();
      this.FUT = true;
      localObject1 = getString(e.h.finder_bottom_popup_entrance_default_wording);
      kotlin.g.b.s.s(localObject1, "getString(R.string.finde…entrance_default_wording)");
      localObject2 = com.tencent.mm.plugin.finder.report.ac.Fsk;
      com.tencent.mm.plugin.finder.report.ac.eNa();
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
      l = com.tencent.mm.model.cn.bDv();
      localObject2 = this.Bgp;
      if (localObject2 != null) {
        break label501;
      }
      localObject2 = this.Bgp;
      if (localObject2 != null) {
        break label520;
      }
    }
    label520:
    for (int i = 0;; i = ((bbm)localObject2).ZMe)
    {
      com.tencent.mm.plugin.finder.report.ac.a((bui)localObject3, 1, l, 0, 2, (String)localObject1, Integer.valueOf(i), null, 128);
      localView.removeCallbacks(this.FVv);
      this.FVv = new FinderShareFeedRelUI..ExternalSyntheticLambda12(this);
      localView.postDelayed(this.FVv, 10000L);
      AppMethodBeat.o(347164);
      return;
      label501:
      localObject2 = ((bbm)localObject2).title;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      break;
    }
  }
  
  private final void fbZ()
  {
    AppMethodBeat.i(347175);
    fbV();
    View localView = this.FUV;
    if (localView != null) {
      if (Util.isNullOrNil(this.tipsWording)) {
        if (!this.Bgc) {
          break label170;
        }
      }
    }
    label170:
    for (int i = e.h.finder_feed_more_user_feed;; i = e.h.finder_feed_more_similar_feed2)
    {
      Object localObject = getString(i);
      kotlin.g.b.s.s(localObject, "getString(if (isFromAd) …_feed_more_similar_feed2)");
      this.tipsWording = ((String)localObject);
      localObject = (TextView)localView.findViewById(e.e.finder_similar_feed_tv);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)this.tipsWording);
      }
      localView.setVisibility(0);
      c(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 112), 260L);
      this.FUS = true;
      localObject = com.tencent.mm.plugin.finder.report.ac.Fsk;
      com.tencent.mm.plugin.finder.report.ac.eNa();
      com.tencent.mm.plugin.finder.report.ac.aw((Context)this, 1);
      localView.removeCallbacks(this.FVx);
      this.FVx = new FinderShareFeedRelUI..ExternalSyntheticLambda10(this);
      localView.postDelayed(this.FVx, 3000L);
      AppMethodBeat.o(347175);
      return;
    }
  }
  
  private j fca()
  {
    AppMethodBeat.i(347203);
    j localj = this.FUF;
    if (localj == null)
    {
      kotlin.g.b.s.bIx("presenter");
      AppMethodBeat.o(347203);
      return null;
    }
    AppMethodBeat.o(347203);
    return localj;
  }
  
  private j.b fcb()
  {
    AppMethodBeat.i(347209);
    j.b localb = this.FUG;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      AppMethodBeat.o(347209);
      return null;
    }
    AppMethodBeat.o(347209);
    return localb;
  }
  
  private final boolean fcc()
  {
    AppMethodBeat.i(347211);
    int i = getCommentScene();
    if ((i == 25) || (i == 38))
    {
      AppMethodBeat.o(347211);
      return true;
    }
    AppMethodBeat.o(347211);
    return false;
  }
  
  private final boolean fcd()
  {
    AppMethodBeat.i(347220);
    FinderFeedShareRelativeListLoader localFinderFeedShareRelativeListLoader = this.FUH;
    Object localObject = localFinderFeedShareRelativeListLoader;
    if (localFinderFeedShareRelativeListLoader == null)
    {
      kotlin.g.b.s.bIx("loader");
      localObject = null;
    }
    localObject = ((FinderFeedShareRelativeListLoader)localObject).getDataList().get(0);
    int i;
    if ((localObject instanceof BaseFinderFeed))
    {
      localObject = (BaseFinderFeed)localObject;
      if (localObject != null) {
        break label73;
      }
      i = 0;
    }
    for (;;)
    {
      if ((i & 0x100) == 0) {
        break label109;
      }
      AppMethodBeat.o(347220);
      return true;
      localObject = null;
      break;
      label73:
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = ((FinderItem)localObject).getFeedObject();
        if (localObject == null) {
          i = 0;
        } else {
          i = ((FinderObject)localObject).permissionFlag;
        }
      }
    }
    label109:
    AppMethodBeat.o(347220);
    return false;
  }
  
  private final boolean fce()
  {
    AppMethodBeat.i(347226);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXz().bmg()).intValue() == 1)
    {
      FinderFeedShareRelativeListLoader localFinderFeedShareRelativeListLoader = this.FUH;
      localObject = localFinderFeedShareRelativeListLoader;
      if (localFinderFeedShareRelativeListLoader == null)
      {
        kotlin.g.b.s.bIx("loader");
        localObject = null;
      }
      if ((((FinderFeedShareRelativeListLoader)localObject).getDataList().size() > 1) && (fcc()) && (!fcd()))
      {
        AppMethodBeat.o(347226);
        return true;
      }
    }
    AppMethodBeat.o(347226);
    return false;
  }
  
  private final void fcf()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347232);
    Object localObject3 = this.FUH;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("loader");
      localObject1 = null;
    }
    localObject1 = ((FinderFeedShareRelativeListLoader)localObject1).getDataList().get(1);
    if ((localObject1 instanceof BaseFinderFeed))
    {
      localObject1 = (BaseFinderFeed)localObject1;
      if (localObject1 != null) {
        break label70;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label92;
      }
      AppMethodBeat.o(347232);
      return;
      localObject1 = null;
      break;
      label70:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FinderItem)localObject1).getFeedObject();
      }
    }
    label92:
    localObject3 = com.tencent.mm.ui.component.k.aeZF;
    com.tencent.mm.plugin.finder.share.a locala = (com.tencent.mm.plugin.finder.share.a)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.share.a.class);
    localObject3 = this.FUG;
    if (localObject3 == null) {
      kotlin.g.b.s.bIx("viewCallback");
    }
    for (;;)
    {
      locala.a((FinderObject)localObject1, localObject2.ATx.getRecyclerView(), (kotlin.g.a.b)new y(this), (m)new z(this), (kotlin.g.a.b)new aa(this));
      locala.ePA();
      AppMethodBeat.o(347232);
      return;
      localObject2 = localObject3;
    }
  }
  
  private final boolean fcg()
  {
    AppMethodBeat.i(347237);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eXA().bmg()).intValue() == 1) && (fcc()) && (!fcd()))
    {
      localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.fgl())
      {
        AppMethodBeat.o(347237);
        return true;
      }
    }
    AppMethodBeat.o(347237);
    return false;
  }
  
  private final void fch()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347240);
    LinkedList localLinkedList = new LinkedList();
    Object localObject3 = this.FUH;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("loader");
      localObject1 = null;
    }
    localObject3 = ((FinderFeedShareRelativeListLoader)localObject1).getDataList().iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (cc)((Iterator)localObject3).next();
        if ((localObject1 instanceof BaseFinderFeed))
        {
          localObject1 = (BaseFinderFeed)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if (localObject1 != null)
            {
              localObject1 = ((FinderItem)localObject1).getFeedObject();
              if (localObject1 != null) {
                localLinkedList.add(localObject1);
              }
            }
          }
          if (i < 5) {
            break label201;
          }
        }
      }
      else if (localLinkedList.size() > 0)
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = (com.tencent.mm.plugin.finder.share.b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.share.b.class);
        ((com.tencent.mm.plugin.finder.share.b)localObject3).hw((List)localLinkedList);
        localObject1 = this.FUG;
        if (localObject1 != null) {
          break label198;
        }
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      label198:
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.share.b)localObject3).C(((b.b)localObject1).ATx.getRecyclerView());
        AppMethodBeat.o(347240);
        return;
        localObject1 = null;
        break;
      }
      label201:
      i += 1;
    }
  }
  
  private static final void gJ(View paramView)
  {
    AppMethodBeat.i(347249);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347249);
  }
  
  private static final void gK(View paramView)
  {
    AppMethodBeat.i(347280);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347280);
  }
  
  private int getTabType()
  {
    AppMethodBeat.i(347075);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(347075);
    return i;
  }
  
  private final void h(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(347124);
    if ((!this.Bgc) || (paramFinderContact == null) || (Util.isEqual(paramFinderContact.username, com.tencent.mm.model.z.bAW())) || (!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry()))
    {
      AppMethodBeat.o(347124);
      return;
    }
    boolean bool = f(paramFinderContact);
    addTextOptionMenu(1, ul(bool), (MenuItem.OnMenuItemClickListener)new x(this), null, um(bool));
    uk(bool);
    AppMethodBeat.o(347124);
  }
  
  private final void uj(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(347131);
    if (!paramBoolean)
    {
      bool1 = true;
      uk(bool1);
      if (paramBoolean) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = true;; bool1 = false)
    {
      updateOptionMenuText(1, ul(bool1));
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      updateOptionMenuStyle(1, um(bool1));
      AppMethodBeat.o(347131);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void uk(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      this.FUX = i;
      return;
    }
  }
  
  private final String ul(boolean paramBoolean)
  {
    AppMethodBeat.i(347150);
    if (paramBoolean)
    {
      str = getContext().getString(e.h.finder_followed);
      kotlin.g.b.s.s(str, "context.getString(R.string.finder_followed)");
      AppMethodBeat.o(347150);
      return str;
    }
    String str = getContext().getString(e.h.finder_follow);
    kotlin.g.b.s.s(str, "context.getString(R.string.finder_follow)");
    AppMethodBeat.o(347150);
    return str;
  }
  
  private static y.b um(boolean paramBoolean)
  {
    if (paramBoolean) {
      return y.b.adEY;
    }
    return y.b.adEX;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean convertActivityFromTranslucent()
  {
    return !this.FVe;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(347647);
    kotlin.g.b.s.u(paramMotionEvent, "event");
    View localView = this.FUV;
    int i;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localView = this.FUU;
        if ((localView == null) || (localView.getVisibility() != 0)) {
          break label113;
        }
        i = j;
        label63:
        if (i == 0) {}
      }
      else
      {
        switch (paramMotionEvent.getAction())
        {
        }
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(347647);
      return bool;
      i = 0;
      break;
      label113:
      i = 0;
      break label63;
      this.cxN = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY() - this.cxN;
      localView = this.FUV;
      if ((localView != null) && (localView.getVisibility() == 0) && (f > 0.0F) && (f > this.doK)) {
        a(this, this.FUV);
      }
      localView = this.FUU;
      if ((localView != null) && (localView.getVisibility() == 0) && (f > 0.0F) && (f > this.doK)) {
        fbW();
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.i ecL()
  {
    AppMethodBeat.i(347613);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.Bae.getValue();
    AppMethodBeat.o(347613);
    return locali;
  }
  
  public final int edC()
  {
    return 2;
  }
  
  public final void fbX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347665);
    FinderFeedShareRelativeListLoader localFinderFeedShareRelativeListLoader = this.FUH;
    Object localObject1 = localFinderFeedShareRelativeListLoader;
    if (localFinderFeedShareRelativeListLoader == null)
    {
      kotlin.g.b.s.bIx("loader");
      localObject1 = null;
    }
    if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(347665);
      return;
    }
    localObject1 = this.FUG;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
      if (localObject1 == null) {
        break label169;
      }
      if ((!this.FUR) || (!fce())) {
        break;
      }
      fcf();
      AppMethodBeat.o(347665);
      return;
    }
    if ((this.FUR) && (fcg()))
    {
      fch();
      AppMethodBeat.o(347665);
      return;
    }
    if (R((RecyclerView.v)localObject1))
    {
      fbY();
      AppMethodBeat.o(347665);
      return;
    }
    if (S((RecyclerView.v)localObject1))
    {
      fbZ();
      AppMethodBeat.o(347665);
      return;
    }
    label169:
    AppMethodBeat.o(347665);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(347778);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    if (((com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.v.class)).onInterceptFinish())
    {
      AppMethodBeat.o(347778);
      return;
    }
    Object localObject2;
    if (this.FUF != null)
    {
      localObject2 = this.FUF;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      if (((j)localObject1).FVY) {
        setResult(-1);
      }
    }
    super.finish();
    if (this.FVe)
    {
      int i = com.tencent.mm.plugin.finder.e.a.anim_not_change;
      overridePendingTransition(i, i);
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    com.tencent.mm.plugin.finder.ui.sharerel.c localc = (com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class);
    if (localc.fdc())
    {
      bzh localbzh = new bzh();
      localbzh.aaix = localc.FYq;
      localObject1 = localc.FYa;
      if (localObject1 == null)
      {
        localObject1 = "";
        localbzh.aaiy = ((String)localObject1);
        Log.i(localc.TAG, "doCallback " + localbzh.aaix + ", " + localbzh.aaiy);
        localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.FYu;
        localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.fdf();
        if (localObject1 != null) {
          ((ca.a)localObject1).onCallback(localbzh);
        }
        localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.FYu;
        com.tencent.mm.plugin.finder.ui.sharerel.d.a(null);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.FYu;
      com.tencent.mm.plugin.finder.ui.sharerel.d.a(null);
      AppMethodBeat.o(347778);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.ui.sharerel.b)localObject1).FYm.toString();
      kotlin.g.b.s.s(localObject2, "feedbackJsonArray.toString()");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.FYu;
      localObject1 = com.tencent.mm.plugin.finder.ui.sharerel.d.fdf();
      if (localObject1 != null) {
        ((ca.a)localObject1).onCallback(new bzh());
      }
    }
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(347751);
    if (fbT() != 0)
    {
      i = fbT();
      AppMethodBeat.o(347751);
      return i;
    }
    int i = fbS();
    AppMethodBeat.o(347751);
    return i;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_share_feed_detail_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347620);
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.plugin.finder.viewmodel.component.ac.class, ag.class, ae.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, com.tencent.mm.plugin.finder.viewmodel.component.ah.class, com.tencent.mm.plugin.finder.ui.sharerel.c.class, az.class, com.tencent.mm.plugin.finder.viewmodel.component.f.class, com.tencent.mm.plugin.finder.viewmodel.component.c.class, com.tencent.mm.plugin.finder.share.a.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.e.class, com.tencent.mm.plugin.finder.share.b.class, w.class });
    AppMethodBeat.o(347620);
    return localSet;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(347761);
    if (this.FVe)
    {
      AppMethodBeat.o(347761);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(347761);
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(347723);
    this.feedId = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.ABC = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    Object localObject3;
    int i;
    label266:
    label310:
    boolean bool1;
    label368:
    Object localObject4;
    if (localObject2 == null)
    {
      localObject2 = "";
      this.ybL = getIntent().getIntExtra("report_scene", 0);
      this.ACA = getIntent().getIntExtra("key_reuqest_scene", -1);
      this.hQQ = getIntent().getStringExtra("from_user");
      this.FUJ = getIntent().getIntExtra("report_uitype", 2);
      localObject3 = getIntent().getStringExtra("KEY_AUTHORIZATION_CONTENT");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      this.FVs = ((String)localObject1);
      this.Bgc = getIntent().getBooleanExtra("is_from_ad", false);
      this.FUO = getIntent().getBooleanExtra("key_need_related_list", true);
      this.FUP = getIntent().getStringExtra("key_session_id");
      this.FUQ = getIntent().getLongExtra("feed_local_id", 0L);
      this.AVa = getIntent().getBooleanExtra("key_posting_scene", false);
      if (this.feedId == 0L)
      {
        if (((CharSequence)this.ABC).length() != 0) {
          break label3198;
        }
        i = 1;
        if ((i != 0) && (this.FUQ == 0L))
        {
          Log.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
          finish();
        }
      }
      if (((CharSequence)this.FVs).length() <= 0) {
        break label3203;
      }
      i = 1;
      label483:
      Object localObject5;
      if (i != 0)
      {
        localObject1 = (com.tencent.mm.plugin.finder.viewmodel.teenmode.e)component(com.tencent.mm.plugin.finder.viewmodel.teenmode.e.class);
        ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject1).bizKey = kotlin.g.b.s.X("finder_feedId_", com.tencent.mm.ae.d.hF(this.feedId));
        localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXW().bmg()).intValue() != 1) {
          break label3208;
        }
        bool1 = true;
        boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        boolean bool3 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).jdMethod_do(4, ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject1).bizKey);
        Log.i("MicroMsg.FinderTeenModeTempAuthMgr", "bizKey:" + ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject1).bizKey + ", open:" + bool1 + ", isTeenMode:" + bool2 + ", hasAuthorization:" + bool3);
        if ((!bool1) || (!bool2) || (bool3)) {
          break label3214;
        }
        i = 1;
        if (i != 0)
        {
          localObject3 = (com.tencent.mm.plugin.finder.viewmodel.teenmode.e)component(com.tencent.mm.plugin.finder.viewmodel.teenmode.e.class);
          localObject4 = this.FVs;
          kotlin.g.b.s.u(localObject4, "authContent");
          localObject1 = com.tencent.mm.message.k.b.Hf(Util.processXml((String)localObject4));
          if (localObject1 != null) {
            break label3219;
          }
          localObject1 = null;
          label531:
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("<fromusr>").append(com.tencent.mm.model.z.bAM()).append("</fromusr>");
          ((StringBuilder)localObject5).append("<type>49</type>");
          ((StringBuilder)localObject5).append("<content>").append(Util.escapeStringForXml((String)localObject4)).append("</content>");
          localObject4 = ((StringBuilder)localObject5).toString();
          kotlin.g.b.s.s(localObject4, "sb.toString()");
          localObject5 = (com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class);
          Activity localActivity = (Activity)((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject3).getActivity();
          String str1 = ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject3).bizKey;
          String str2 = ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject3).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_title);
          Resources localResources = ((com.tencent.mm.plugin.finder.viewmodel.teenmode.e)localObject3).getResources();
          i = e.h.finder_teen_mode_guardian_temp_req_msg_subtitle;
          if (localObject1 != null) {
            break label3235;
          }
          localObject1 = "";
          label670:
          ((com.tencent.mm.plugin.teenmode.a.d)localObject5).a(localActivity, 10013, 4, str1, str2, localResources.getString(i, new Object[] { localObject1 }), (String)localObject4, true, null);
        }
      }
      localObject1 = findViewById(e.e.share_feed_detail_tips_layout);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
      this.EBQ = ((View)localObject1);
      if (this.Bgc) {
        this.FVb = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
      }
      localObject1 = findViewById(e.e.share_ui_content);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.share_ui_content)");
      this.FVf = ((FrameLayout)localObject1);
      localObject1 = findViewById(e.e.share_anim_cover_layout);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.share_anim_cover_layout)");
      this.FVg = ((FrameLayout)localObject1);
      localObject1 = findViewById(e.e.share_anim_image);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.share_anim_image)");
      this.FVh = ((NinePatchCropImageView)localObject1);
      if (this.FVe)
      {
        if (this.mediaType == 2)
        {
          localObject3 = this.FVh;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("animCoverImage");
            localObject1 = null;
          }
          ((NinePatchCropImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        setBackBtn(new FinderShareFeedRelUI..ExternalSyntheticLambda2(this), e.g.actionbar_icon_dark_close);
        float f = (float)getIntent().getDoubleExtra("key_image_height_radio", 1.166666626930237D);
        localObject4 = (com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
        localObject5 = this.FVl;
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.findersdk.a.cn)localObject4).loadImage((String)localObject5, (ImageView)localObject1);
        localObject1 = bf.bf((Context)getContext());
        i = ((Point)localObject1).x;
        i = ((Point)localObject1).y;
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        ((NinePatchCropImageView)localObject1).setAlpha(0.0F);
        localObject4 = (AnimationLayout)findViewById(e.e.share_animation_layout);
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        localObject5 = (View)localObject4;
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        com.tencent.mm.plugin.finder.utils.av.a((View)localObject5, (View)localObject1, f, i, "initData", this.feedId);
        localObject3 = this.FVf;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("contentUI");
          localObject1 = null;
        }
        ((FrameLayout)localObject1).setVisibility(8);
        localObject3 = this.FVg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverLayout");
          localObject1 = null;
        }
        ((FrameLayout)localObject1).setVisibility(0);
        localObject3 = this.FVg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverLayout");
          localObject1 = null;
        }
        ((FrameLayout)localObject1).setOnClickListener(FinderShareFeedRelUI..ExternalSyntheticLambda8.INSTANCE);
        kotlin.g.b.s.s(localObject4, "coverImageLayout");
        localObject1 = findViewById(e.e.gallery_bg);
        kotlin.g.b.s.s(localObject1, "findViewById(R.id.gallery_bg)");
        localObject3 = getWindow().getDecorView();
        kotlin.g.b.s.s(localObject3, "window.decorView");
        localObject5 = this.FVk;
        Log.i(this.TAG, "runEnterAnimation " + localObject5 + ", " + this.FVn);
        if ((localObject5 != null) && (!this.FVn))
        {
          this.FVn = true;
          Log.i(this.TAG, "runEnterAnimation");
          ((AnimationLayout)localObject4).b((View)localObject1, (View)localObject3, (ViewAnimHelper.ViewInfo)localObject5, (Animator.AnimatorListener)new v(this, (View)localObject1), new FinderShareFeedRelUI..ExternalSyntheticLambda0(this));
        }
      }
      if (this.feedId == 0L) {
        break label3279;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      localObject1 = com.tencent.mm.plugin.finder.storage.data.e.a.jn(this.feedId);
      if (localObject1 != null)
      {
        Log.i(this.TAG, "use cache cacheTime=" + com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + " current=" + com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", com.tencent.mm.model.cn.bDw() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
        if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (com.tencent.mm.model.cn.bDw() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
        {
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          this.FUN = com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject1);
        }
        localObject1 = kotlin.ah.aiuX;
        localObject1 = kotlin.ah.aiuX;
      }
      label1507:
      if (this.FUN != null) {
        break label3341;
      }
      Log.i(this.TAG, "cache null.show progress");
      pZ(true);
      label1529:
      i = this.scene;
      localObject1 = (MMActivity)this;
      if (this.FUA) {
        break label3349;
      }
      bool1 = true;
      label1550:
      int j = getTabType();
      localObject3 = com.tencent.mm.plugin.finder.feed.logic.d.Beq;
      localObject1 = new j(i, (MMActivity)localObject1, bool1, j, com.tencent.mm.plugin.finder.feed.logic.d.Oa(this.ybL));
      ((j.a)localObject1).hKN = this.feedId;
      ((j)localObject1).setObjectNonceId((String)localObject2);
      ((j.a)localObject1).AUZ = this.FUN;
      localObject3 = this.ABC;
      kotlin.g.b.s.u(localObject3, "<set-?>");
      ((j.a)localObject1).AUV = ((String)localObject3);
      if ((!this.FUO) || (((bw)h.ax(bw.class)).aBu())) {
        break label3355;
      }
      bool1 = true;
      label1655:
      ((j.a)localObject1).AUW = bool1;
      ((j.a)localObject1).AVa = this.AVa;
      ((j.a)localObject1).AUX = ((m)new l(this, (j)localObject1));
      ((j.a)localObject1).AUY = ((kotlin.g.a.b)new m(this, (j)localObject1));
      localObject3 = kotlin.ah.aiuX;
      this.FUF = ((j)localObject1);
      localObject3 = this.FUF;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      ((j)localObject1).FVU = Long.valueOf(this.feedId);
      localObject3 = this.FUF;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      ((j)localObject1).FVV = fbS();
      localObject4 = (MMActivity)this;
      localObject3 = this.FUF;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      this.FUG = new j.b((MMActivity)localObject4, (j.a)localObject1, this.scene, getCommentScene());
      if (this.ybL != 15) {
        break label3361;
      }
      i = 6;
      label1855:
      this.ACA = i;
      long l = this.feedId;
      localObject1 = this.ABC;
      i = getTabType();
      bool1 = this.Bgc;
      j = this.ACA;
      localObject3 = this.FUP;
      localObject4 = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = new FinderFeedShareRelativeListLoader(l, (String)localObject1, (String)localObject2, i, bool1, j, (String)localObject3, ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), this.AVa);
      localObject2 = getIntent().getStringExtra("key_from_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.s.u(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).hYg = ((String)localObject1);
      localObject2 = getIntent().getStringExtra("key_to_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.s.u(localObject1, "<set-?>");
      ((FinderFeedShareRelativeListLoader)localObject3).hHa = ((String)localObject1);
      Log.i(((FinderFeedShareRelativeListLoader)localObject3).getTAG(), "fromUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).hYg + ",toUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).hHa);
      localObject1 = getIntent();
      kotlin.g.b.s.s(localObject1, "intent");
      ((FinderFeedShareRelativeListLoader)localObject3).initFromCache((Intent)localObject1);
      localObject1 = ((FinderFeedShareRelativeListLoader)localObject3).getCache();
      if (localObject1 != null)
      {
        localObject2 = (Collection)((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label3381;
        }
        i = 1;
        label2128:
        if (i != 0) {
          break label3386;
        }
        i = 1;
        label2134:
        if (i == 0) {
          break label3391;
        }
        label2138:
        if (localObject1 != null)
        {
          ((FinderFeedShareRelativeListLoader)localObject3).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new n(this, (FinderFeedShareRelativeListLoader)localObject3));
          localObject1 = kotlin.ah.aiuX;
          localObject1 = kotlin.ah.aiuX;
        }
      }
      ((FinderFeedShareRelativeListLoader)localObject3).fetchEndCallback = ((kotlin.g.a.b)new o(this));
      ((FinderFeedShareRelativeListLoader)localObject3).Bge = ((kotlin.g.a.b)new p(this));
      localObject1 = kotlin.ah.aiuX;
      this.FUH = ((FinderFeedShareRelativeListLoader)localObject3);
      if (this.ybL != 0) {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 14L, 1L, false);
      }
      if (this.Bgc)
      {
        this.FVc = new o((MMActivity)this);
        localObject1 = this.FVc;
        if (localObject1 != null)
        {
          ((o)localObject1).q(fcb().ATx.getRecyclerView());
          localObject1 = kotlin.ah.aiuX;
        }
      }
      localObject2 = this.FUG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      ((b.b)localObject1).ATx.getRecyclerView().post(new FinderShareFeedRelUI..ExternalSyntheticLambda11(this));
      localObject2 = this.FUG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)new q(this));
      localObject1 = this.FUF;
      if (localObject1 != null) {
        break label3397;
      }
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
      label2398:
      ((j)localObject1).FVS = ((kotlin.g.a.b)new k(this));
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = (w)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(w.class);
      localObject2 = this.FUH;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("loader");
        localObject1 = null;
      }
      ((w)localObject3).GPY = ((BaseFinderFeedLoader)localObject1);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = (w)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(w.class);
      if (localObject2 != null)
      {
        localObject1 = getIntent().getExtras();
        if (localObject1 != null) {
          break label3400;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      ((w)localObject2).BtW = ((Bundle)localObject1);
      localObject1 = kotlin.ah.aiuX;
      localObject1 = kotlin.ah.aiuX;
      ecL().a(this.scene, getCommentScene(), (kotlin.g.a.b)new r(this));
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)ecL());
        }
      }
      localObject3 = ecM();
      localObject4 = (m)new s(this);
      localObject2 = this.FUG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.findersdk.a.as)localObject3).a((m)localObject4, ((b.b)localObject1).ATx.getRecyclerView());
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a(ecM().edV());
        }
      }
      ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
      ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderShareFeedRelUI..ExternalSyntheticLambda3(this));
      ((FrameLayout)findViewById(e.e.float_ball_btn_layout)).setVisibility(0);
      ((FrameLayout)findViewById(e.e.float_ball_btn_layout)).setOnClickListener(new FinderShareFeedRelUI..ExternalSyntheticLambda4(this));
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
      if (getTabType() == 10) {
        ((TextView)findViewById(e.e.full_action_bar_title)).setText(e.h.finder_tab_lbs);
      }
      localObject1 = getWindow().getDecorView();
      kotlin.g.b.s.s(localObject1, "window.decorView");
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
      getWindow().setStatusBarColor(0);
      getController().s((Activity)this, getResources().getColor(com.tencent.mm.plugin.finder.e.b.transparent));
      com.tencent.mm.ui.c.h((Activity)this, false);
      localObject1 = getSupportActionBar();
      if (localObject1 != null)
      {
        ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
        ((ActionBar)localObject1).hide();
      }
      i = bf.getStatusBarHeight((Context)this);
      ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
      getController().updataStatusBarIcon(true);
      setNavigationbarColor(-16777216);
      ((ImageView)findViewById(e.e.gallery_bg)).setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.full_black));
      localObject1 = findViewById(e.e.share_rl_container);
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.full_black));
      }
      localObject1 = com.tencent.mm.plugin.finder.feed.logic.d.Beq;
      if (com.tencent.mm.plugin.finder.feed.logic.d.Oa(this.ybL))
      {
        localObject1 = com.tencent.mm.plugin.finder.feed.logic.d.Beq;
        com.tencent.mm.plugin.finder.feed.logic.d.a(this);
      }
      localObject1 = (WeImageView)findViewById(e.e.backBtnIv);
      if (localObject1 != null) {
        ((WeImageView)localObject1).setIconColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_5));
      }
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgA);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderShareFeedRelUI..ExternalSyntheticLambda9(this));
      AppMethodBeat.o(347723);
      return;
      break;
      label3198:
      i = 0;
      break label266;
      label3203:
      i = 0;
      break label310;
      label3208:
      bool1 = false;
      break label368;
      label3214:
      i = 0;
      break label483;
      label3219:
      localObject1 = (com.tencent.mm.plugin.findersdk.a.f)((com.tencent.mm.message.k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.f.class);
      break label531;
      label3235:
      localObject1 = ((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label670;
      }
      localObject3 = ((bvl)localObject1).desc;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label670;
      }
      localObject1 = "";
      break label670;
      label3279:
      if ((this.FUQ == 0L) || (!this.AVa)) {
        break label1507;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(this.FUQ);
      if (localObject1 == null) {
        break label1507;
      }
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      this.FUN = com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject1);
      localObject1 = kotlin.ah.aiuX;
      localObject1 = kotlin.ah.aiuX;
      break label1507;
      label3341:
      pZ(false);
      break label1529;
      label3349:
      bool1 = false;
      break label1550;
      label3355:
      bool1 = false;
      break label1655;
      label3361:
      if (this.ACA < 0)
      {
        i = 3;
        break label1855;
      }
      i = this.ACA;
      break label1855;
      label3381:
      i = 0;
      break label2128;
      label3386:
      i = 0;
      break label2134;
      label3391:
      localObject1 = null;
      break label2138;
      label3397:
      break label2398;
      label3400:
      ((Bundle)localObject1).remove("key_view_info");
      ((Bundle)localObject1).remove("key_image_url");
      ((Bundle)localObject1).remove("key_nine_patch_id");
      ((Bundle)localObject1).remove("key_animate_id");
      localObject3 = kotlin.ah.aiuX;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(347767);
    if (this.FVe)
    {
      AppMethodBeat.o(347767);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(347767);
    return bool;
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347789);
    Object localObject1 = ((Iterable)getUiComponents()).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((UIComponent)((Iterator)localObject1).next()).onBackPressed())
      {
        AppMethodBeat.o(347789);
        return;
      }
    }
    if ((this.FVn) || (this.FVo) || (this.FVp))
    {
      AppMethodBeat.o(347789);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    if (((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).onBackPressed())
    {
      AppMethodBeat.o(347789);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    if (((com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.v.class)).onBackPressed())
    {
      AppMethodBeat.o(347789);
      return;
    }
    if ((this.FUR) && (fcg()))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.share.b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.share.b.class)).FzP;
      if (localObject1 != null) {
        ((RoundCornerRelativeLayout)localObject1).setVisibility(8);
      }
    }
    Object localObject4 = findViewById(e.e.retry_layout);
    ViewAnimHelper.ViewInfo localViewInfo = this.FVk;
    Object localObject3;
    float f;
    if (this.FVe)
    {
      localObject3 = this.EBQ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("tipsLayout");
        localObject1 = null;
      }
      if ((((View)localObject1).getVisibility() != 0) && (((View)localObject4).getVisibility() != 0) && (localViewInfo != null))
      {
        if (fca().fcn()) {
          break label718;
        }
        localObject3 = this.FVf;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("contentUI");
          localObject1 = null;
        }
        ((FrameLayout)localObject1).setVisibility(8);
        localObject3 = this.FVg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverLayout");
          localObject1 = null;
        }
        ((FrameLayout)localObject1).setVisibility(0);
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        ((NinePatchCropImageView)localObject1).setAlpha(1.0F);
        localObject4 = (com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
        String str = this.FVm;
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.findersdk.a.cn)localObject4).loadImage(str, (ImageView)localObject1);
        f = (float)getIntent().getDoubleExtra("key_image_height_radio", 1.166666626930237D);
        if (this.mediaType != 2) {
          break label725;
        }
        localObject3 = this.FVh;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("animCoverImage");
          localObject1 = null;
        }
        ((NinePatchCropImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        int i = localViewInfo.agcX.height();
        int j = localViewInfo.agcX.width();
        if ((j <= 0) || (i <= 0)) {
          break label725;
        }
        f = i * 1.0F / j;
      }
    }
    label718:
    label725:
    for (;;)
    {
      localObject3 = this.FVh;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        localObject1 = null;
      }
      localObject4 = ((NinePatchCropImageView)localObject1).getLayoutParams();
      f = androidx.core.b.a.g(f, 1.0F, 1.333333F);
      localObject3 = this.FVh;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        localObject1 = null;
      }
      ((ViewGroup.LayoutParams)localObject4).height = kotlin.h.a.eH(((NinePatchCropImageView)localObject1).getLayoutParams().width * f);
      localObject3 = this.FVh;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        localObject1 = null;
      }
      ((NinePatchCropImageView)localObject1).requestLayout();
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)FinderShareFeedRelUI.t.FVD);
      localObject1 = this.FVh;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((NinePatchCropImageView)localObject1).post(new FinderShareFeedRelUI..ExternalSyntheticLambda15(this, localViewInfo));
        AppMethodBeat.o(347789);
        return;
      }
      if (!fca().fcn()) {
        finish();
      }
      AppMethodBeat.o(347789);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347624);
    this.FVa = getIntent().getBooleanExtra("KEY_FORCE_FULLSCREEN", false);
    this.FVk = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("key_view_info"));
    String str2 = getIntent().getStringExtra("key_image_url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.FVl = str1;
    str2 = getIntent().getStringExtra("key_image_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.FVm = str1;
    this.mediaType = getIntent().getIntExtra("key_share_media_type", 0);
    str2 = getIntent().getStringExtra("key_image_full_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.FVi = getIntent().getIntExtra("key_nine_patch_id", 0);
    this.FVj = getIntent().getLongExtra("key_animate_id", 0L);
    if (fbS() == 38) {
      this.FUI = 2;
    }
    int i;
    if (((CharSequence)str1).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.i(this.TAG, "[onCreate] has fromImageFullUrl");
        this.FVl = str1;
      }
      if (((CharSequence)this.FVl).length() != 0) {
        break label280;
      }
      i = 1;
      label229:
      if ((i == 0) && (getIntent().getIntExtra("business_type", 0) != 1)) {
        break label285;
      }
      this.FVe = false;
      overridePendingTransition(com.tencent.mm.plugin.finder.e.a.slide_right_in, com.tencent.mm.plugin.finder.e.a.slide_left_out);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      AppMethodBeat.o(347624);
      return;
      i = 0;
      break;
      label280:
      i = 0;
      break label229;
      label285:
      if ((this.FVk != null) && (!Util.isNullOrNil(this.FVl))) {
        this.FVe = true;
      }
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(347630);
    super.onCreateBeforeSetContentView();
    if (this.FVe)
    {
      if (aw.isDarkMode())
      {
        setTheme(e.i.MMTheme_Holo_FinderDarkTransparent);
        AppMethodBeat.o(347630);
        return;
      }
      setTheme(e.i.MMTheme_Holo_FinderLightTransparent);
    }
    AppMethodBeat.o(347630);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347744);
    Object localObject1 = this.FVx;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.FVw;
      if (localObject2 != null) {
        ((View)localObject2).removeCallbacks((Runnable)localObject1);
      }
    }
    localObject1 = this.FVt;
    if (localObject1 != null) {
      ((com.tencent.threadpool.i.d)localObject1).cancel(false);
    }
    long l;
    int i;
    if ((this.ybL != 0) && (!this.FUC))
    {
      if (!this.Bgc) {
        break label491;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.feedId;
      i = this.ybL;
      localObject1 = this.hQQ;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.finder.report.z.a(l, i, 4L, (String)localObject2, 0, 2, null, (String)localObject1);
        this.FUC = true;
      }
    }
    else
    {
      ecL().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)ecL());
        }
      }
      ecM().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b(ecM().edV());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      i = getTabType();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this);
      if (localObject1 != null) {
        break label605;
      }
    }
    label605:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.s.e(i, (bui)localObject1);
      localObject1 = this.FVb;
      if (localObject1 != null) {
        ((IListener)localObject1).dead();
      }
      localObject1 = this.FVc;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject2 = getContext();
        kotlin.g.b.s.s(localObject2, "context");
        localObject2 = as.a.hu((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = ((bn)localObject2).Vm(-1);
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject2).b(((com.tencent.mm.plugin.finder.feed.n)localObject1).AVq);
          }
        }
        ((o)localObject1).onDetach();
      }
      this.FVc = null;
      super.onDestroy();
      AppMethodBeat.o(347744);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bui)localObject1).zIO;
      break;
      label491:
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.feedId;
      i = this.ybL;
      localObject1 = this.hQQ;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.report.z.a(l, i, (String)localObject2, 0, 2, (String)localObject1);
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou();
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((bui)localObject1).zIO;
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(347640);
    super.onPause();
    this.FVu.dead();
    if (this.Bgc)
    {
      localObject = this.FVb;
      if (localObject != null) {
        ((IListener)localObject).alive();
      }
    }
    ce localce = (ce)h.ax(ce.class);
    j.b localb = this.FUG;
    Object localObject = localb;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject = null;
    }
    localce.b(((b.b)localObject).ATx.getRecyclerView(), q.w.DwQ, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.live.report.d.Dng);
    AppMethodBeat.o(347640);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347637);
    super.onResume();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    com.tencent.mm.plugin.finder.ui.sharerel.c localc = (com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class);
    Object localObject3 = this.FUF;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    localc.FUF = ((j)localObject1);
    this.FVu.alive();
    boolean bool;
    if (this.Bgc)
    {
      localObject1 = this.FVb;
      if (localObject1 != null) {
        ((IListener)localObject1).dead();
      }
      bool = f(this.AVu);
      Log.i(this.TAG, "isFollowed: " + bool + " followStatus:" + this.FUX);
      if (this.FUY == null) {}
    }
    switch (this.FUX)
    {
    default: 
      this.FUY = null;
      if (this.FUX == 0) {
        h(this.AVu);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.St(getTabType());
      switch (getCommentScene())
      {
      default: 
        label236:
        localObject3 = (ce)h.ax(ce.class);
        localObject1 = this.FUG;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject1 = localObject2;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      ((ce)localObject3).b(((b.b)localObject1).ATx.getRecyclerView(), q.w.DwQ, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.live.report.d.Dnf);
      AppMethodBeat.o(347637);
      return;
      if (!bool) {
        break;
      }
      uj(false);
      break;
      if (bool) {
        break;
      }
      uj(true);
      break;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oS(true);
      break label236;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oS(false);
      break label236;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(347659);
    if (findViewById(e.e.share_feed_progress) != null)
    {
      if (paramBoolean)
      {
        findViewById(e.e.share_feed_progress).setVisibility(0);
        AppMethodBeat.o(347659);
        return;
      }
      findViewById(e.e.share_feed_progress).setVisibility(8);
    }
    AppMethodBeat.o(347659);
  }
  
  public final void un(boolean paramBoolean)
  {
    AppMethodBeat.i(347656);
    Log.i(this.TAG, kotlin.g.b.s.X("showRetryTips ifShow:", Boolean.valueOf(paramBoolean)));
    View localView = findViewById(e.e.retry_layout);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        localView.setOnClickListener(new FinderShareFeedRelUI..ExternalSyntheticLambda6(this, localView));
        AppMethodBeat.o(347656);
        return;
      }
      localView.setVisibility(8);
    }
    AppMethodBeat.o(347656);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$Companion;", "", "()V", "FOLLOWED", "", "FOLLOW_MENU_ID", "INIT_FOLLOW", "REQUEST_NO_INTEREST", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "UNFOLLOWED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements kotlin.g.a.b<View, kotlin.ah>
  {
    aa(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends u
    implements kotlin.g.a.a<Integer>
  {
    ab(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(FinderLinearLayoutManager paramFinderLinearLayoutManager, RecyclerView paramRecyclerView, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    c(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    d(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$dismissEntrance$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.finder.animation.a
  {
    g(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(347323);
      this.DjW.setVisibility(4);
      AppMethodBeat.o(347323);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$dismissLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends com.tencent.mm.plugin.finder.animation.a
  {
    h(View paramView, kotlin.g.a.a<kotlin.ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(347349);
      this.DjW.setVisibility(4);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(347349);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.as>
  {
    i(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animator.AnimatorListener
  {
    j(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(347326);
      FrameLayout localFrameLayout = FinderShareFeedRelUI.q(this.FVy);
      paramAnimator = localFrameLayout;
      if (localFrameLayout == null)
      {
        kotlin.g.b.s.bIx("animCoverLayout");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(8);
      this.FVA.setAlpha(1.0F);
      FinderShareFeedRelUI.r(this.FVy);
      AppMethodBeat.o(347326);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "itemView", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<View, kotlin.ah>
  {
    k(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errcode", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements m<Integer, String, kotlin.ah>
  {
    l(FinderShareFeedRelUI paramFinderShareFeedRelUI, j paramj)
    {
      super();
    }
    
    private static final void C(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347585);
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      FinderShareFeedRelUI.o(paramFinderShareFeedRelUI);
      AppMethodBeat.o(347585);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<FinderObject, kotlin.ah>
  {
    m(FinderShareFeedRelUI paramFinderShareFeedRelUI, j paramj)
    {
      super();
    }
    
    private static final void C(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347514);
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      FinderShareFeedRelUI.o(paramFinderShareFeedRelUI);
      AppMethodBeat.o(347514);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    n(FinderShareFeedRelUI paramFinderShareFeedRelUI, FinderFeedShareRelativeListLoader paramFinderFeedShareRelativeListLoader) {}
    
    private static final void a(FinderLinearLayoutManager paramFinderLinearLayoutManager, FinderFeedShareRelativeListLoader paramFinderFeedShareRelativeListLoader, FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347501);
      kotlin.g.b.s.u(paramFinderLinearLayoutManager, "$layoutManager");
      kotlin.g.b.s.u(paramFinderFeedShareRelativeListLoader, "$this_apply");
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      paramFinderLinearLayoutManager.bo(paramFinderFeedShareRelativeListLoader.getInitPos(), 0);
      FinderShareFeedRelUI.w(paramFinderShareFeedRelUI);
      AppMethodBeat.o(347501);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(347517);
      Object localObject2 = FinderShareFeedRelUI.g(this.FVy);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView();
      localObject2 = this.FVC;
      FinderShareFeedRelUI localFinderShareFeedRelUI = this.FVy;
      RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject1).getLayoutManager();
      if (localLayoutManager == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(347517);
        throw ((Throwable)localObject1);
      }
      ((RecyclerView)localObject1).post(new FinderShareFeedRelUI.n..ExternalSyntheticLambda0((FinderLinearLayoutManager)localLayoutManager, (FinderFeedShareRelativeListLoader)localObject2, localFinderShareFeedRelUI));
      AppMethodBeat.o(347517);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<IResponse<cc>, kotlin.ah>
  {
    o(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
    
    private static final void C(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347505);
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      if (!paramFinderShareFeedRelUI.FUR)
      {
        paramFinderShareFeedRelUI.FUR = true;
        paramFinderShareFeedRelUI.fbX();
      }
      AppMethodBeat.o(347505);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<IResponse<cc>, kotlin.ah>
  {
    p(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    extends RecyclerView.l
  {
    private float offset = 100.0F;
    
    q(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(347515);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(347515);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      View localView1 = null;
      AppMethodBeat.i(347509);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      Object localObject2 = FinderShareFeedRelUI.e(this.FVy);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("loader");
        localObject1 = null;
      }
      View localView2;
      FinderShareFeedRelUI localFinderShareFeedRelUI;
      if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() >= 2)
      {
        localObject1 = FinderShareFeedRelUI.f(this.FVy);
        if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
          break label422;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          localView2 = FinderShareFeedRelUI.f(this.FVy);
          if (localView2 != null)
          {
            localFinderShareFeedRelUI = this.FVy;
            paramInt1 = com.tencent.mm.cd.a.fromDPToPix((Context)localFinderShareFeedRelUI.getContext(), 112);
            localObject2 = FinderShareFeedRelUI.g(localFinderShareFeedRelUI);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("viewCallback");
              localObject1 = null;
            }
            localObject2 = ((b.b)localObject1).ATx.getRecyclerView().fU(0);
            if (localObject2 != null) {
              break label427;
            }
            localObject1 = null;
            label204:
            if (localObject2 != null) {
              break label458;
            }
          }
        }
      }
      for (;;)
      {
        this.offset -= paramInt2 / 5.0F;
        this.offset = androidx.core.b.a.g(this.offset, 0.0F, 100.0F);
        localView2.setAlpha(this.offset / 100.0F);
        if ((localView2.getVisibility() == 0) && (this.offset <= 0.0F))
        {
          localView2.setVisibility(4);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).animate();
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramInt1);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(260L);
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
          if (localView1 != null)
          {
            localObject1 = localView1.animate();
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramInt1);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(260L);
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
        ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwQ, String.valueOf(this.FVy.getCommentScene()), com.tencent.mm.plugin.finder.live.report.d.Dne);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(347509);
        return;
        label422:
        paramInt1 = 0;
        break;
        label427:
        localObject1 = ((RecyclerView.v)localObject2).caK;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label204;
        }
        localObject1 = ((View)localObject1).findViewById(e.e.finder_feed_full_footer_layout);
        break label204;
        label458:
        localObject2 = ((RecyclerView.v)localObject2).caK;
        if (localObject2 != null) {
          localView1 = ((View)localObject2).findViewById(FinderShareFeedRelUI.h(localFinderShareFeedRelUI));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<Integer, cc>
  {
    r(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    s(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    u(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements Animator.AnimatorListener
  {
    v(FinderShareFeedRelUI paramFinderShareFeedRelUI, View paramView) {}
    
    private static final void D(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347452);
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      FinderShareFeedRelUI.o(paramFinderShareFeedRelUI);
      AppMethodBeat.o(347452);
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(347472);
      FinderShareFeedRelUI.l(this.FVy);
      FrameLayout localFrameLayout = FinderShareFeedRelUI.m(this.FVy);
      paramAnimator = localFrameLayout;
      if (localFrameLayout == null)
      {
        kotlin.g.b.s.bIx("contentUI");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(0);
      if (FinderShareFeedRelUI.n(this.FVy))
      {
        paramAnimator = FinderShareFeedRelUI.m(this.FVy);
        if (paramAnimator != null) {
          break label116;
        }
        kotlin.g.b.s.bIx("contentUI");
        paramAnimator = localObject;
      }
      label116:
      for (;;)
      {
        paramAnimator.post(new FinderShareFeedRelUI.v..ExternalSyntheticLambda0(this.FVy));
        Log.i(this.FVy.TAG, kotlin.g.b.s.X("runEnterAnimation end ", Boolean.valueOf(FinderShareFeedRelUI.n(this.FVy))));
        AppMethodBeat.o(347472);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(347460);
      Log.i(this.FVy.TAG, "runEnterAnimation start");
      AppMethodBeat.o(347460);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(347483);
      this.FVA.setVisibility(0);
      AppMethodBeat.o(347483);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    implements Animator.AnimatorListener
  {
    w(View paramView, FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    private static final void D(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      AppMethodBeat.i(347451);
      kotlin.g.b.s.u(paramFinderShareFeedRelUI, "this$0");
      paramFinderShareFeedRelUI.finish();
      AppMethodBeat.o(347451);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(347476);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(347476);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(347469);
      kotlin.g.b.s.u(paramAnimator, "animation");
      NinePatchCropImageView localNinePatchCropImageView = FinderShareFeedRelUI.p(paramFinderShareFeedRelUI);
      paramAnimator = localNinePatchCropImageView;
      if (localNinePatchCropImageView == null)
      {
        kotlin.g.b.s.bIx("animCoverImage");
        paramAnimator = null;
      }
      paramAnimator.postDelayed(new FinderShareFeedRelUI.w..ExternalSyntheticLambda0(paramFinderShareFeedRelUI), 220L);
      paramAnimator = paramFinderShareFeedRelUI;
      int i = com.tencent.mm.plugin.finder.e.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      Log.i(paramFinderShareFeedRelUI.TAG, "runExitAnimation end");
      AppMethodBeat.o(347469);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(347480);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(347480);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(347459);
      kotlin.g.b.s.u(paramAnimator, "animation");
      paramAnimator = this.FVE;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(0.0F);
      }
      Log.i(paramFinderShareFeedRelUI.TAG, "runExitAnimation start");
      AppMethodBeat.o(347459);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showFollowView$1$1", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements MenuItem.OnMenuItemClickListener
  {
    x(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(347444);
      FinderShareFeedRelUI.A(this.FVy);
      AppMethodBeat.o(347444);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.b<View, kotlin.ah>
  {
    y(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "delayTime", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements m<View, Long, kotlin.ah>
  {
    z(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */