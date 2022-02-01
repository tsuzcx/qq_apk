package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.o;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.plugin.finder.viewmodel.component.y;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.view.e.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "checkExposeTaskAdded", "", "getCheckExposeTaskAdded", "()Z", "setCheckExposeTaskAdded", "(Z)V", "checkedDeepEnjoy", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "defaultClickTabContextId", "getDefaultClickTabContextId", "defaultClickTabContextId$delegate", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "defaultCommentScene$delegate", "detailCommentScene", "getDetailCommentScene", "detailCommentScene$delegate", "dismissEntranceRunnable", "Ljava/lang/Runnable;", "dismissPopupTipsRunnable", "distance", "doShowAfterEnter", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "enterAnimImageUrl", "exitAnimImageUrl", "feedContactChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "finderFeedSnsAdHandler", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "finderReport21874", "Lcom/tencent/mm/plugin/finder/report/FinderReport21874;", "followChangeEvent", "followStatus", "forceFullScreen", "fromAnimateKey", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "guideBarItem", "Lcom/tencent/mm/protocal/protobuf/FinderGuideBarItem;", "initFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isFromAd", "isPostingScene", "setPostingScene", "isShareClickReport", "isTipsFirstShown", "isTitleShowed", "lastY", "", "getLastY", "()F", "setLastY", "(F)V", "loader", "localFeedId", "getLocalFeedId", "setLocalFeedId", "ninePatchId", "parentBottom", "getParentBottom", "parentBottom$delegate", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "popupEntranceExposed", "getPopupEntranceExposed", "setPopupEntranceExposed", "popupEntranceLayout", "Landroid/view/View;", "popupTipsExposed", "getPopupTipsExposed", "setPopupTipsExposed", "popupTipsLayout", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "reportUiType", "getReportUiType", "setReportUiType", "requestScene", "getRequestScene", "setRequestScene", "scene", "getScene", "setScene", "seekLayoutId", "sessionID", "getSessionID", "setSessionID", "shareVideoFinish", "getShareVideoFinish", "setShareVideoFinish", "showFinderEntry", "showRelatedList", "getShowRelatedList", "setShowRelatedList", "staticTipsExposed", "getStaticTipsExposed", "setStaticTipsExposed", "staticTipsShowing", "getStaticTipsShowing", "setStaticTipsShowing", "tabType", "getTabType", "tabType$delegate", "tipsFirstShownCount", "tipsLayout", "tipsShownLimit", "tipsWording", "touchSlop", "uiType", "getUiType", "setUiType", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "videoFinishListener", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1;", "viewCallback", "changeFollow", "", "changeFollowState", "isFollowed", "changeFollowView", "checkPopupEntranceInit", "checkPopupTipsInit", "checkSeek", "checkStaticTipsExposed", "staticTipsTv", "convertActivityFromTranslucent", "dismissEntrance", "dismissPopupTipsLayout", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "finish", "fixActionBarStatus", "followUser", "getCommentScene", "getLayoutId", "getMenuStyle", "Lcom/tencent/mm/ui/MMActivityController$OptionMenuStyle;", "getMenuText", "getModel", "getPresenter", "getReportType", "getViewBottomInWindow", "view", "getViewCallback", "handleFollowStateChange", "handlePopupViews", "hideCoverAnimation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActivityCloseAnimation", "initData", "initFollow", "initOnCreate", "initSimilarTipsShownCount", "isAllowShowTips", "isFinderClose", "extStatus", "contact", "isHideStatusBar", "isOtherEnableFullScreenEnjoy", "isSupportNavigationSwipeBack", "isViewExposed", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "openFinderEntrance", "overlayStatusBar", "popupEntrance", "popupTips", "isFullScreen", "pullDownOtherViews", "height", "duration", "pullUpOtherViews", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "setFollowStatus", "setTitleWithNickName", "nickName", "shouldPopupEntrance", "shareVideoHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shouldPopupTips", "showFollowView", "showProgress", "ifShow", "showRetryTips", "unFollowUser", "Companion", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, j.b, i>
{
  private static final int AwA = 2;
  public static final a AwB;
  private static final int Awx = 1;
  private static final int Awy = 0;
  private static final int Awz = 1;
  private i AvA;
  private j.b AvB;
  private FinderFeedShareRelativeListLoader AvC;
  private int AvD;
  int AvE;
  private final kotlin.f AvF;
  private final kotlin.f AvG;
  private final kotlin.f AvH;
  private final int AvI;
  private boolean AvJ;
  private int AvK;
  private BaseFinderFeed AvL;
  private boolean AvM;
  private String AvN;
  private long AvO;
  boolean AvP;
  private boolean AvQ;
  private boolean AvR;
  private boolean AvS;
  private boolean AvT;
  private View AvU;
  private View AvV;
  private boolean AvW;
  private int AvX;
  private hm AvY;
  private FinderObject AvZ;
  private boolean Avs;
  private boolean Avv;
  private boolean Awa;
  private IListener<hm> Awb;
  private com.tencent.mm.plugin.finder.feed.p Awc;
  private com.tencent.mm.plugin.finder.report.m Awd;
  private final kotlin.f Awe;
  private int Awf;
  private boolean Awg;
  private FrameLayout Awh;
  private FrameLayout Awi;
  private NinePatchCropImageView Awj;
  private int Awk;
  private long Awl;
  private ViewAnimHelper.ViewInfo Awm;
  private String Awn;
  private String Awo;
  private boolean Awp;
  private boolean Awq;
  private boolean Awr;
  private boolean Aws;
  private boolean Awt;
  private final ak Awu;
  private Runnable Awv;
  private Runnable Aww;
  final String TAG;
  private HashMap _$_findViewCache;
  private float aCb;
  private final int bvH;
  String fLi;
  long feedId;
  private int scene;
  private String tipsWording;
  int wwk;
  private final kotlin.f xCQ;
  private final kotlin.f xCR;
  private boolean xGX;
  private awb xHl;
  private String xcr;
  private int xdc;
  private boolean xxP;
  private final int xyt;
  private FinderContact xyu;
  private final kotlin.f zVl;
  private View zzB;
  
  static
  {
    AppMethodBeat.i(278091);
    AwB = new a((byte)0);
    Awx = 1;
    Awz = 1;
    AwA = 2;
    AppMethodBeat.o(278091);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(278090);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.AvE = 2;
    this.scene = 2;
    this.fLi = "";
    this.xCQ = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xCR = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.AvF = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.AvG = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.AvH = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.AvI = 3;
    this.AvJ = true;
    this.Avs = ((com.tencent.mm.plugin.findersdk.a.ak)h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).showFinderEntry();
    this.xcr = "";
    this.AvM = true;
    this.AvN = "";
    this.zVl = kotlin.g.ar((kotlin.g.a.a)new aj(this));
    this.AvX = Awy;
    this.Awd = new com.tencent.mm.plugin.finder.report.m((Context)this);
    this.Awe = kotlin.g.ar((kotlin.g.a.a)new aa(this));
    this.Awn = "";
    this.Awo = "";
    this.tipsWording = "";
    this.xyt = b.f.finder_seek_bar_footer_layout;
    this.Awu = new ak(this);
    this.aCb = -1.0F;
    this.bvH = ViewConfiguration.getTouchSlop();
    AppMethodBeat.o(278090);
  }
  
  private final boolean W(RecyclerView.v paramv)
  {
    AppMethodBeat.i(278068);
    if (paramv == null)
    {
      AppMethodBeat.o(278068);
      return false;
    }
    paramv = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWK().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(278068);
      return false;
    }
    if ((this.xHl != null) && (!this.xGX))
    {
      paramv = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.hd(getTabType(), eaZ()))
      {
        paramv = com.tencent.mm.plugin.finder.storage.d.AjH;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWm().aSr()).intValue() == 1) && (this.AvP) && (!this.AvR))
        {
          AppMethodBeat.o(278068);
          return true;
        }
      }
    }
    AppMethodBeat.o(278068);
    return false;
  }
  
  private final boolean X(RecyclerView.v paramv)
  {
    AppMethodBeat.i(278069);
    if (paramv == null)
    {
      AppMethodBeat.o(278069);
      return false;
    }
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWK().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(278069);
      return false;
    }
    if (isOtherEnableFullScreenEnjoy())
    {
      paramv = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWm().aSr()).intValue() == 0)
      {
        paramv = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dWl().aSr()).intValue() == 1)
        {
          paramv = com.tencent.mm.plugin.finder.storage.d.AjH;
          if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWo().aSr()).intValue() == 1) && (this.AvP) && (!this.AvQ))
          {
            AppMethodBeat.o(278069);
            return true;
          }
        }
      }
      AppMethodBeat.o(278069);
      return false;
    }
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWl().aSr()).intValue() == 1)
    {
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWn().aSr()).intValue() == 1) && (this.AvP) && (!this.AvS) && (!this.AvQ) && (ebc() > 0))
      {
        int i = ebc();
        paramv = paramv.amk;
        kotlin.g.b.p.j(paramv, "shareVideoHolder.itemView");
        if (i - eK(paramv) < this.Awf)
        {
          AppMethodBeat.o(278069);
          return true;
        }
      }
    }
    AppMethodBeat.o(278069);
    return false;
  }
  
  private final void b(float paramFloat, long paramLong)
  {
    View localView = null;
    AppMethodBeat.i(278057);
    Object localObject1 = this.AvB;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    Object localObject2 = ((b.b)localObject1).xvJ.getRecyclerView().cK(0);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() == 1)
    {
      localObject1 = localView;
      if (localObject2 != null)
      {
        localObject2 = ((RecyclerView.v)localObject2).amk;
        localObject1 = localView;
        if (localObject2 != null) {
          localObject1 = ((View)localObject2).findViewById(b.f.content_option_layout);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramFloat);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null)
            {
              ((ViewPropertyAnimator)localObject1).start();
              AppMethodBeat.o(278057);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(278057);
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = ((RecyclerView.v)localObject2).amk;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(b.f.finder_feed_full_footer_layout);
        if (localObject2 == null) {
          break label321;
        }
        localView = ((RecyclerView.v)localObject2).amk;
        if (localView == null) {
          break label321;
        }
      }
    }
    label321:
    for (localView = localView.findViewById(b.f.finder_seek_bar_footer_layout);; localView = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramFloat);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      if (localView == null) {
        break label327;
      }
      localObject1 = localView.animate();
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramFloat);
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
      if (localObject1 == null) {
        break label327;
      }
      ((ViewPropertyAnimator)localObject1).start();
      AppMethodBeat.o(278057);
      return;
      localObject1 = null;
      break;
    }
    label327:
    AppMethodBeat.o(278057);
  }
  
  private final void c(float paramFloat, long paramLong)
  {
    View localView = null;
    AppMethodBeat.i(278070);
    Object localObject1 = this.AvB;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    Object localObject2 = ((b.b)localObject1).xvJ.getRecyclerView().cK(0);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXx().aSr()).intValue() == 1)
    {
      localObject1 = localView;
      if (localObject2 != null)
      {
        localObject2 = ((RecyclerView.v)localObject2).amk;
        localObject1 = localView;
        if (localObject2 != null) {
          localObject1 = ((View)localObject2).findViewById(b.f.content_option_layout);
        }
      }
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
            if (localObject1 != null)
            {
              ((ViewPropertyAnimator)localObject1).start();
              AppMethodBeat.o(278070);
              return;
            }
          }
        }
        AppMethodBeat.o(278070);
      }
    }
    else
    {
      if (localObject2 != null)
      {
        localObject1 = ((RecyclerView.v)localObject2).amk;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(b.f.finder_feed_full_footer_layout);
          if (localObject2 == null) {
            break label349;
          }
          localView = ((RecyclerView.v)localObject2).amk;
          if (localView == null) {
            break label349;
          }
        }
      }
      label349:
      for (localView = localView.findViewById(this.xyt);; localView = null)
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
        if (localView == null) {
          break label355;
        }
        localObject1 = localView.animate();
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-paramFloat);
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(paramLong);
        if (localObject1 == null) {
          break label355;
        }
        ((ViewPropertyAnimator)localObject1).start();
        AppMethodBeat.o(278070);
        return;
        localObject1 = null;
        break;
      }
    }
    label355:
    AppMethodBeat.o(278070);
  }
  
  private static boolean c(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(278061);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
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
    boolean bool = d.a.aAN(paramFinderContact);
    AppMethodBeat.o(278061);
    return bool;
  }
  
  private com.tencent.mm.plugin.finder.feed.model.k dtz()
  {
    AppMethodBeat.i(278033);
    com.tencent.mm.plugin.finder.feed.model.k localk = (com.tencent.mm.plugin.finder.feed.model.k)this.xCR.getValue();
    AppMethodBeat.o(278033);
    return localk;
  }
  
  private final void e(final FinderContact paramFinderContact)
  {
    AppMethodBeat.i(278059);
    if ((!this.xGX) || (paramFinderContact == null) || (Util.isEqual(paramFinderContact.username, z.bdh())) || (!((com.tencent.mm.plugin.findersdk.a.ak)h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).showFinderEntry()))
    {
      AppMethodBeat.o(278059);
      return;
    }
    boolean bool = c(paramFinderContact);
    addTextOptionMenu(Awx, qO(bool), (MenuItem.OnMenuItemClickListener)new ah(this, paramFinderContact), null, qP(bool));
    qN(bool);
    AppMethodBeat.o(278059);
  }
  
  private final void eI(View paramView)
  {
    AppMethodBeat.i(278071);
    if (paramView == null)
    {
      AppMethodBeat.o(278071);
      return;
    }
    boolean bool = eJ(paramView);
    if ((!this.AvT) && (bool))
    {
      this.AvS = true;
      this.AvT = true;
      paramView = com.tencent.mm.plugin.finder.report.q.zWJ;
      com.tencent.mm.plugin.finder.report.q.dPF();
      paramView = com.tencent.mm.ui.component.g.Xox;
      com.tencent.mm.plugin.finder.report.q.a(((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), 2, cm.bfD());
      AppMethodBeat.o(278071);
      return;
    }
    if (!bool) {
      this.AvT = false;
    }
    AppMethodBeat.o(278071);
  }
  
  private static boolean eJ(View paramView)
  {
    AppMethodBeat.i(278072);
    if ((paramView.isShown()) && (paramView.getAlpha() > 0.0F) && (paramView.getGlobalVisibleRect(new Rect())))
    {
      AppMethodBeat.o(278072);
      return true;
    }
    AppMethodBeat.o(278072);
    return false;
  }
  
  private static int eK(View paramView)
  {
    AppMethodBeat.i(278074);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(278074);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(278074);
    return i + j;
  }
  
  private final int eaZ()
  {
    AppMethodBeat.i(278035);
    int i = ((Number)this.AvF.getValue()).intValue();
    AppMethodBeat.o(278035);
    return i;
  }
  
  private final int eba()
  {
    AppMethodBeat.i(278036);
    int i = ((Number)this.AvG.getValue()).intValue();
    AppMethodBeat.o(278036);
    return i;
  }
  
  private final String ebb()
  {
    AppMethodBeat.i(278038);
    String str = (String)this.AvH.getValue();
    AppMethodBeat.o(278038);
    return str;
  }
  
  private final int ebc()
  {
    AppMethodBeat.i(278040);
    int i = ((Number)this.Awe.getValue()).intValue();
    AppMethodBeat.o(278040);
    return i;
  }
  
  private final void ebd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(278052);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if ((com.tencent.mm.plugin.finder.utils.aj.hd(getTabType(), eaZ())) && (this.AvU == null))
    {
      localObject1 = this.AvB;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject1 = ((b.b)localObject1).xvJ.getRecyclerView().cK(0);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.v)localObject1).amk;
        if (localObject1 == null) {
          break label128;
        }
      }
      label128:
      for (localObject1 = ((ViewStub)((View)localObject1).findViewById(b.f.finder_popup_entrance_layout)).inflate();; localObject1 = localObject2)
      {
        this.AvU = ((View)localObject1);
        localObject1 = this.AvU;
        if (localObject1 == null) {
          break label133;
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(278052);
        return;
        localObject1 = null;
        break;
      }
    }
    label133:
    AppMethodBeat.o(278052);
  }
  
  private final void ebe()
  {
    AppMethodBeat.i(278053);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    label192:
    label216:
    View localView;
    label237:
    Object localObject4;
    if (this.AvV == null)
    {
      boolean bool = isOtherEnableFullScreenEnjoy();
      if (bool)
      {
        localObject1 = this.AvC;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("loader");
        }
        if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
        {
          AppMethodBeat.o(278053);
          return;
        }
      }
      if (bool)
      {
        localObject1 = this.AvB;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        localObject1 = ((b.b)localObject1).xvJ.getRecyclerView().cK(0);
        if (localObject1 != null) {
          localObject1 = ((RecyclerView.v)localObject1).amk;
        }
      }
      while (localObject1 == null)
      {
        AppMethodBeat.o(278053);
        return;
        localObject1 = null;
        continue;
        localObject1 = getContentView();
      }
      localObject3 = ((View)localObject1).findViewById(b.f.more_similar_parent);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((ViewStub)((View)localObject1).findViewById(b.f.more_similar_feed_tip_layout)).inflate();
      }
      this.AvV = ((View)localObject2);
      localObject1 = this.AvV;
      if (localObject1 == null) {
        break label382;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.finder_similar_feed_tv);
      localObject2 = this.AvV;
      if (localObject2 == null) {
        break label387;
      }
      localObject2 = ((View)localObject2).findViewById(b.f.more_similar_bg_view);
      localObject3 = this.AvV;
      if (localObject3 == null) {
        break label392;
      }
      localObject3 = (WeImageView)((View)localObject3).findViewById(b.f.finder_similar_feed_iv);
      localView = this.AvV;
      if (localView == null) {
        break label398;
      }
      localView = localView.findViewById(b.f.more_similar_eat_click_view);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.c.AwD);
      }
      localObject4 = this.AvV;
      if (localObject4 != null) {
        ((View)localObject4).setVisibility(8);
      }
      if (localObject1 == null) {
        break label404;
      }
      localObject4 = ((TextView)localObject1).getPaint();
      label281:
      ar.a((Paint)localObject4, 0.8F);
      if (bool)
      {
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getResources().getColor(b.c.White));
        }
        if (localObject3 != null) {
          ((WeImageView)localObject3).setIconColor(getResources().getColor(b.c.White));
        }
      }
      if (!bool) {
        break label410;
      }
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(b.c.transparent);
      }
      if (localView != null) {
        localView.setBackgroundResource(b.c.transparent);
      }
    }
    for (;;)
    {
      this.Awf = com.tencent.mm.ci.a.fromDPToPix((Context)this, 104);
      AppMethodBeat.o(278053);
      return;
      label382:
      localObject1 = null;
      break;
      label387:
      localObject2 = null;
      break label192;
      label392:
      localObject3 = null;
      break label216;
      label398:
      localView = null;
      break label237;
      label404:
      localObject4 = null;
      break label281;
      label410:
      if (ar.isDarkMode())
      {
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundResource(com.tencent.mm.plugin.finder.b.e.finder_more_similar_bg_dark);
        }
      }
      else if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(com.tencent.mm.plugin.finder.b.e.finder_more_similar_bg);
      }
    }
  }
  
  private final void ebf()
  {
    AppMethodBeat.i(278055);
    Object localObject = this.AvU;
    if (localObject != null)
    {
      if (((View)localObject).getVisibility() == 0)
      {
        b(com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 80), 300L);
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
          if (localViewPropertyAnimator != null)
          {
            localViewPropertyAnimator = localViewPropertyAnimator.setDuration(300L);
            if (localViewPropertyAnimator != null)
            {
              localObject = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new i((View)localObject));
              if (localObject != null)
              {
                ((ViewPropertyAnimator)localObject).start();
                AppMethodBeat.o(278055);
                return;
              }
            }
          }
        }
      }
      AppMethodBeat.o(278055);
      return;
    }
    AppMethodBeat.o(278055);
  }
  
  private final void ebg()
  {
    AppMethodBeat.i(278056);
    Object localObject = this.AvV;
    if (localObject != null)
    {
      if (((View)localObject).getVisibility() == 0)
      {
        int i = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 112);
        b(i, 260L);
        ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
          if (localViewPropertyAnimator != null)
          {
            localViewPropertyAnimator = localViewPropertyAnimator.translationYBy(i);
            if (localViewPropertyAnimator != null)
            {
              localViewPropertyAnimator = localViewPropertyAnimator.setDuration(260L);
              if (localViewPropertyAnimator != null)
              {
                localObject = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new j((View)localObject));
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(278056);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(278056);
      return;
    }
    AppMethodBeat.o(278056);
  }
  
  private final void ebi()
  {
    AppMethodBeat.i(278066);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.hd(getTabType(), eaZ()))
    {
      AppMethodBeat.o(278066);
      return;
    }
    ebd();
    View localView = this.AvU;
    if (localView != null)
    {
      localObject1 = this.xHl;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = localView.findViewById(b.f.wording_tv);
        kotlin.g.b.p.j(localObject2, "layout.findViewById<TextView>(R.id.wording_tv)");
        ((TextView)localObject2).setText((CharSequence)((awb)localObject1).title);
        localObject2 = localView.findViewById(b.f.avatar_3_iv);
        kotlin.g.b.p.j(localObject2, "layout.findViewById(R.id.avatar_3_iv)");
        localObject2 = (ImageView)localObject2;
        localObject3 = localView.findViewById(b.f.avatar_2_iv);
        kotlin.g.b.p.j(localObject3, "layout.findViewById(R.id.avatar_2_iv)");
        localObject3 = (ImageView)localObject3;
        localObject4 = localView.findViewById(b.f.avatar_1_iv);
        kotlin.g.b.p.j(localObject4, "layout.findViewById(R.id.avatar_1_iv)");
        localObject2 = kotlin.a.j.listOf(new ImageView[] { localObject2, localObject3, (ImageView)localObject4 });
        localObject1 = new ArrayList((Collection)((awb)localObject1).SIu);
        kotlin.a.j.ln((List)localObject1);
        localObject2 = ((Iterable)localObject2).iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            kotlin.a.j.iBO();
          }
          localObject3 = (ImageView)localObject3;
          Object localObject5 = (awr)kotlin.a.j.M((List)localObject1, i);
          if (localObject5 != null)
          {
            localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject4 = com.tencent.mm.plugin.finder.loader.t.dJj();
            localObject5 = new com.tencent.mm.plugin.finder.loader.e(((awr)localObject5).lqp);
            com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject4).a(localObject5, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
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
      c(com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 80), 300L);
      localView.animate().alpha(1.0F).setDuration(300L).start();
      this.AvR = true;
      Object localObject2 = getString(b.j.finder_bottom_popup_entrance_default_wording);
      kotlin.g.b.p.j(localObject2, "getString(R.string.finde…entrance_default_wording)");
      localObject1 = com.tencent.mm.plugin.finder.report.q.zWJ;
      com.tencent.mm.plugin.finder.report.q.dPF();
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      Object localObject4 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      long l = cm.bfD();
      localObject1 = this.xHl;
      if (localObject1 != null)
      {
        localObject3 = ((awb)localObject1).title;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = localObject2;
      }
      localObject2 = this.xHl;
      if (localObject2 != null) {}
      for (localObject2 = Integer.valueOf(((awb)localObject2).SIv);; localObject2 = Integer.valueOf(0))
      {
        com.tencent.mm.plugin.finder.report.q.a((bid)localObject4, 1, l, 0, 2, (String)localObject1, (Integer)localObject2);
        localView.removeCallbacks(this.Awv);
        this.Awv = ((Runnable)new ab(this));
        localView.postDelayed(this.Awv, 10000L);
        AppMethodBeat.o(278066);
        return;
      }
    }
    AppMethodBeat.o(278066);
  }
  
  private i ebj()
  {
    AppMethodBeat.i(278078);
    i locali = this.AvA;
    if (locali == null) {
      kotlin.g.b.p.bGy("presenter");
    }
    AppMethodBeat.o(278078);
    return locali;
  }
  
  private j.b ebk()
  {
    AppMethodBeat.i(278080);
    j.b localb = this.AvB;
    if (localb == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    AppMethodBeat.o(278080);
    return localb;
  }
  
  private int getTabType()
  {
    AppMethodBeat.i(278039);
    int i = ((Number)this.zVl.getValue()).intValue();
    AppMethodBeat.o(278039);
    return i;
  }
  
  private final void qM(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(278060);
    boolean bool1;
    int i;
    if (!paramBoolean)
    {
      bool1 = true;
      qN(bool1);
      i = Awx;
      if (paramBoolean) {
        break label72;
      }
      bool1 = true;
      label30:
      updateOptionMenuText(i, qO(bool1));
      i = Awx;
      if (paramBoolean) {
        break label77;
      }
    }
    label72:
    label77:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      updateOptionMenuStyle(i, qP(paramBoolean));
      AppMethodBeat.o(278060);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
    }
  }
  
  private final void qN(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = AwA;; i = Awz)
    {
      this.AvX = i;
      return;
    }
  }
  
  private final String qO(boolean paramBoolean)
  {
    AppMethodBeat.i(278062);
    if (paramBoolean)
    {
      str = getContext().getString(b.j.finder_followed);
      kotlin.g.b.p.j(str, "context.getString(R.string.finder_followed)");
      AppMethodBeat.o(278062);
      return str;
    }
    String str = getContext().getString(b.j.finder_follow);
    kotlin.g.b.p.j(str, "context.getString(R.string.finder_follow)");
    AppMethodBeat.o(278062);
    return str;
  }
  
  private static w.b qP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return w.b.WaD;
    }
    return w.b.WaC;
  }
  
  private final void qR(final boolean paramBoolean)
  {
    AppMethodBeat.i(278067);
    ebe();
    View localView = this.AvV;
    if (localView != null)
    {
      int i;
      Object localObject;
      if (Util.isNullOrNil(this.tipsWording))
      {
        if (this.xGX)
        {
          i = b.j.finder_feed_more_user_feed;
          localObject = getString(i);
          kotlin.g.b.p.j(localObject, "getString(if (isFromAd) …_feed_more_similar_feed2)");
          this.tipsWording = ((String)localObject);
        }
      }
      else
      {
        localObject = (TextView)localView.findViewById(b.f.finder_similar_feed_tv);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tipsWording);
        }
        localView.setVisibility(0);
        i = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 112);
        if (!paramBoolean) {
          break label217;
        }
        c(i, 260L);
      }
      for (;;)
      {
        this.AvQ = true;
        localObject = com.tencent.mm.plugin.finder.report.q.zWJ;
        com.tencent.mm.plugin.finder.report.q.dPF();
        localObject = com.tencent.mm.ui.component.g.Xox;
        com.tencent.mm.plugin.finder.report.q.a(((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), 1, cm.bfD());
        localView.removeCallbacks(this.Aww);
        this.Aww = ((Runnable)new ac(this, paramBoolean));
        localView.postDelayed(this.Aww, 3000L);
        AppMethodBeat.o(278067);
        return;
        i = b.j.finder_feed_more_similar_feed2;
        break;
        label217:
        localView.setTranslationY(localView.getTranslationY() + i);
        localView.animate().translationYBy(-i).setDuration(260L).start();
      }
    }
    AppMethodBeat.o(278067);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278116);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278116);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278115);
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
    AppMethodBeat.o(278115);
    return localView1;
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return !this.Awg;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(278054);
    kotlin.g.b.p.k(paramMotionEvent, "event");
    View localView;
    if (isOtherEnableFullScreenEnjoy())
    {
      localView = this.AvV;
      if ((localView == null) || (localView.getVisibility() != 0))
      {
        localView = this.AvU;
        if ((localView == null) || (localView.getVisibility() != 0)) {}
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
      AppMethodBeat.o(278054);
      return bool;
      this.aCb = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY() - this.aCb;
      localView = this.AvV;
      if ((localView != null) && (localView.getVisibility() == 0) && (f > 0.0F) && (f > this.bvH)) {
        ebg();
      }
      localView = this.AvU;
      if ((localView != null) && (localView.getVisibility() == 0) && (f > 0.0F) && (f > this.bvH)) {
        ebf();
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.i dty()
  {
    AppMethodBeat.i(278031);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.xCQ.getValue();
    AppMethodBeat.o(278031);
    return locali;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void ebh()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(278065);
    Object localObject3 = this.AvC;
    if (localObject3 == null) {
      kotlin.g.b.p.bGy("loader");
    }
    if (((FinderFeedShareRelativeListLoader)localObject3).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(278065);
      return;
    }
    boolean bool = isOtherEnableFullScreenEnjoy();
    localObject3 = this.AvB;
    if (localObject3 == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    RecyclerView.v localv = ((b.b)localObject3).xvJ.getRecyclerView().cK(0);
    if (!bool)
    {
      localObject1 = this.AvB;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject3 = ((b.b)localObject1).xvJ.getRecyclerView().cK(1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        View localView = ((RecyclerView.v)localObject3).amk;
        localObject1 = localObject2;
        if (localView != null) {
          localObject1 = localView.findViewById(b.f.finder_similar_feed_tv);
        }
      }
      eI((View)localObject1);
      localObject1 = localObject3;
    }
    if (localv != null)
    {
      if (W(localv))
      {
        ebi();
        AppMethodBeat.o(278065);
        return;
      }
      if (X(localv))
      {
        qR(bool);
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.v)localObject1).amk;
          if (localObject1 != null)
          {
            ((View)localObject1).setVisibility(4);
            AppMethodBeat.o(278065);
            return;
          }
        }
        AppMethodBeat.o(278065);
        return;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).amk;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        AppMethodBeat.o(278065);
        return;
      }
    }
    AppMethodBeat.o(278065);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(278087);
    super.finish();
    if (this.Awg)
    {
      int i = com.tencent.mm.plugin.finder.b.a.anim_not_change;
      overridePendingTransition(i, i);
    }
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    com.tencent.mm.plugin.finder.ui.sharerel.c localc = (com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.ui.sharerel.c.class);
    if (localc.ebU())
    {
      blq localblq = new blq();
      localblq.SWH = localc.Azb;
      localObject = localc.AyN;
      if (localObject != null)
      {
        String str = ((com.tencent.mm.plugin.finder.ui.sharerel.b)localObject).AyW.toString();
        kotlin.g.b.p.j(str, "feedbackJsonArray.toString()");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localblq.SWI = ((String)localObject);
      Log.i(localc.TAG, "doCallback " + localblq.SWH + ", " + localblq.SWI);
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.Azi;
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.ebX();
      if (localObject != null) {
        ((ag.a)localObject).aH(localblq);
      }
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.Azi;
      com.tencent.mm.plugin.finder.ui.sharerel.d.a(null);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.Azi;
      com.tencent.mm.plugin.finder.ui.sharerel.d.a(null);
      AppMethodBeat.o(278087);
      return;
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.Azi;
      localObject = com.tencent.mm.plugin.finder.ui.sharerel.d.ebX();
      if (localObject != null) {
        ((ag.a)localObject).aH(new blq());
      }
    }
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(278083);
    if (eba() != 0)
    {
      i = eba();
      AppMethodBeat.o(278083);
      return i;
    }
    int i = eaZ();
    AppMethodBeat.o(278083);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_share_feed_detail_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(278042);
    if (isOtherEnableFullScreenEnjoy())
    {
      Set localSet = kotlin.a.ak.setOf(new Class[] { y.class, ab.class, al.class, ac.class, com.tencent.mm.plugin.finder.ui.sharerel.c.class, an.class });
      AppMethodBeat.o(278042);
      return localSet;
    }
    AppMethodBeat.o(278042);
    return null;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(278084);
    if (this.Awg)
    {
      AppMethodBeat.o(278084);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(278084);
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(278076);
    this.feedId = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xcr = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("feed_object_nonceId");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.wwk = getIntent().getIntExtra("report_scene", 0);
      this.xdc = getIntent().getIntExtra("key_reuqest_scene", -1);
      this.fLi = getIntent().getStringExtra("from_user");
      this.AvE = getIntent().getIntExtra("report_uitype", 2);
      this.xGX = getIntent().getBooleanExtra("is_from_ad", false);
      this.AvM = getIntent().getBooleanExtra("key_need_related_list", true);
      this.AvN = getIntent().getStringExtra("key_session_id");
      this.AvO = getIntent().getLongExtra("feed_local_id", 0L);
      this.xxP = getIntent().getBooleanExtra("key_posting_scene", false);
      if (this.feedId == 0L) {
        if (((CharSequence)this.xcr).length() != 0) {
          break label367;
        }
      }
      label367:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (this.AvO == 0L))
        {
          Log.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
          finish();
        }
        localObject2 = findViewById(b.f.share_feed_detail_tips_layout);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.share_feed_detail_tips_layout)");
        this.zzB = ((View)localObject2);
        if (!isOtherEnableFullScreenEnjoy()) {
          ebe();
        }
        if (this.xGX) {
          this.Awb = ((IListener)new v(this));
        }
        localObject2 = findViewById(b.f.share_feed_progress);
        kotlin.g.b.p.j(localObject2, "progressView");
        localObject3 = ((View)localObject2).getLayoutParams();
        if (localObject3 != null) {
          break;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(278076);
        throw ((Throwable)localObject1);
      }
      Object localObject3 = (FrameLayout.LayoutParams)localObject3;
      i = ax.getStatusBarHeight(((View)localObject2).getContext());
      int j = ax.ew(((View)localObject2).getContext());
      ((FrameLayout.LayoutParams)localObject3).topMargin = (com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 48) + (j + i));
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = findViewById(b.f.share_ui_content);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.share_ui_content)");
      this.Awh = ((FrameLayout)localObject2);
      localObject2 = findViewById(b.f.share_anim_cover_layout);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.share_anim_cover_layout)");
      this.Awi = ((FrameLayout)localObject2);
      localObject2 = findViewById(b.f.share_anim_image);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.share_anim_image)");
      this.Awj = ((NinePatchCropImageView)localObject2);
      Object localObject4;
      if (this.Awg)
      {
        setBackBtn((MenuItem.OnMenuItemClickListener)new q(this), b.i.actionbar_icon_dark_close);
        float f = (float)getIntent().getDoubleExtra("key_image_height_radio", 1.166666626930237D);
        localObject2 = (com.tencent.mm.plugin.findersdk.a.ak)h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        localObject3 = this.Awn;
        localObject4 = this.Awj;
        if (localObject4 == null) {
          kotlin.g.b.p.bGy("animCoverImage");
        }
        ((com.tencent.mm.plugin.findersdk.a.ak)localObject2).loadImage((String)localObject3, (ImageView)localObject4);
        localObject2 = ax.au((Context)getContext());
        i = ((Point)localObject2).x;
        i = ((Point)localObject2).y;
        localObject2 = this.Awj;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("animCoverImage");
        }
        ((NinePatchCropImageView)localObject2).setAlpha(0.0F);
        localObject2 = (AnimationLayout)findViewById(b.f.share_animation_layout);
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject3 = (View)localObject2;
        localObject4 = this.Awj;
        if (localObject4 == null) {
          kotlin.g.b.p.bGy("animCoverImage");
        }
        com.tencent.mm.plugin.finder.utils.aj.a((View)localObject3, (View)localObject4, f, i, "initData", this.feedId);
        localObject3 = this.Awh;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("contentUI");
        }
        ((FrameLayout)localObject3).setVisibility(8);
        localObject3 = this.Awi;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("animCoverLayout");
        }
        ((FrameLayout)localObject3).setVisibility(0);
        localObject3 = this.Awi;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("animCoverLayout");
        }
        ((FrameLayout)localObject3).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.s.AwM);
        kotlin.g.b.p.j(localObject2, "coverImageLayout");
        localObject3 = findViewById(b.f.gallery_bg);
        kotlin.g.b.p.j(localObject3, "findViewById(R.id.gallery_bg)");
        localObject4 = getWindow();
        kotlin.g.b.p.j(localObject4, "window");
        localObject4 = ((Window)localObject4).getDecorView();
        kotlin.g.b.p.j(localObject4, "window.decorView");
        ViewAnimHelper.ViewInfo localViewInfo = this.Awm;
        Log.i(this.TAG, "runEnterAnimation " + localViewInfo + ", " + this.Awp);
        if ((localViewInfo != null) && (!this.Awp))
        {
          this.Awp = true;
          Log.i(this.TAG, "runEnterAnimation");
          ((AnimationLayout)localObject2).b((View)localObject3, (View)localObject4, localViewInfo, (Animator.AnimatorListener)new ad(this, (View)localObject3), (ValueAnimator.AnimatorUpdateListener)new ae(this));
        }
      }
      boolean bool;
      if (this.feedId != 0L)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        localObject2 = e.a.MH(this.feedId);
        if (localObject2 != null)
        {
          Log.i(this.TAG, "use cache cacheTime=" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject2).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject2).getTimestamps() + ' ' + "current=" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", cm.bfE() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject2).getFeedObject().urlValidDuration + 's');
          if ((((FinderItem)localObject2).getTimestamps() <= 0L) || (cm.bfE() < ((FinderItem)localObject2).getTimestamps() + ((FinderItem)localObject2).getFeedObject().urlValidDuration * 1000L))
          {
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            this.AvL = c.a.a((FinderItem)localObject2);
          }
        }
        if (this.AvL == null)
        {
          Log.d(this.TAG, "cache null.show progress");
          pW(true);
        }
        i = this.scene;
        localObject2 = (MMActivity)this;
        if (this.Avs) {
          break label2554;
        }
        bool = true;
        label1158:
        localObject2 = new i(i, (MMActivity)localObject2, bool, getTabType(), isOtherEnableFullScreenEnjoy(), this.wwk);
        ((j.a)localObject2).xbk = this.feedId;
        ((i)localObject2).setObjectNonceId((String)localObject1);
        ((j.a)localObject2).xxO = this.AvL;
        localObject3 = this.xcr;
        kotlin.g.b.p.k(localObject3, "<set-?>");
        ((j.a)localObject2).xxK = ((String)localObject3);
        ((j.a)localObject2).xxL = this.AvM;
        ((j.a)localObject2).xxP = this.xxP;
        ((j.a)localObject2).xxM = ((kotlin.g.a.m)new m((i)localObject2, this, (String)localObject1));
        ((j.a)localObject2).xxN = ((kotlin.g.a.b)new n((i)localObject2, this, (String)localObject1));
        this.AvA = ((i)localObject2);
        localObject2 = (MMActivity)this;
        localObject3 = this.AvA;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("presenter");
        }
        this.AvB = new j.b((MMActivity)localObject2, (j.a)localObject3, this.scene, getCommentScene());
        if (this.wwk != 15) {
          break label2560;
        }
        i = 6;
        label1355:
        this.xdc = i;
        long l = this.feedId;
        localObject2 = this.xcr;
        i = getTabType();
        bool = this.xGX;
        j = this.xdc;
        localObject3 = this.AvN;
        localObject4 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = new FinderFeedShareRelativeListLoader(l, (String)localObject2, (String)localObject1, i, bool, j, (String)localObject3, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), this.xxP);
        localObject2 = getIntent().getStringExtra("key_from_user_name");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        kotlin.g.b.p.k(localObject1, "<set-?>");
        ((FinderFeedShareRelativeListLoader)localObject3).fSj = ((String)localObject1);
        localObject2 = getIntent().getStringExtra("key_to_user_name");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        kotlin.g.b.p.k(localObject1, "<set-?>");
        ((FinderFeedShareRelativeListLoader)localObject3).fCl = ((String)localObject1);
        Log.i(((FinderFeedShareRelativeListLoader)localObject3).getTAG(), "fromUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).fSj + ",toUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).fCl);
        ((FinderFeedShareRelativeListLoader)localObject3).fetchEndCallback = ((kotlin.g.a.b)new o(this));
        ((FinderFeedShareRelativeListLoader)localObject3).xGV = ((kotlin.g.a.b)new p(this));
        this.AvC = ((FinderFeedShareRelativeListLoader)localObject3);
        if (this.wwk != 0) {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1278L, 14L, 1L, false);
        }
        if (this.xGX)
        {
          this.Awc = new com.tencent.mm.plugin.finder.feed.p((MMActivity)this);
          localObject1 = this.Awc;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.feed.p)localObject1).m(ebk().xvJ.getRecyclerView());
          }
        }
        localObject1 = h.aHG();
        kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
        this.AvK = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VAJ, 0);
        Log.d(this.TAG, "tips first shown count by each feed: " + this.AvK);
        localObject1 = this.AvB;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        ((b.b)localObject1).xvJ.getRecyclerView().post((Runnable)new t(this));
        localObject1 = this.AvB;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)new u(this));
        localObject1 = this.AvA;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("presenter");
        }
        ((i)localObject1).Axj = ((kotlin.g.a.b)new r(this));
        dty().a(this.scene, getCommentScene(), (kotlin.g.a.b)new w(this));
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = getContext();
        kotlin.g.b.p.j(localObject1, "context");
        localObject1 = aj.a.fZ((Context)localObject1);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dty());
          }
        }
        localObject2 = dtz();
        localObject3 = (kotlin.g.a.m)new x(this);
        localObject1 = this.AvB;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        if (localObject1 == null) {
          break label2580;
        }
        localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();
        label1978:
        ((com.tencent.mm.plugin.finder.feed.model.k)localObject2).a((kotlin.g.a.m)localObject3, (RecyclerView)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = getContext();
        kotlin.g.b.p.j(localObject1, "context");
        localObject1 = aj.a.fZ((Context)localObject1);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dtz());
          }
        }
        if (!isOtherEnableFullScreenEnjoy()) {
          break label2586;
        }
        localObject1 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        kotlin.g.b.p.j(localObject1, "full_actionbar");
        ((FrameLayout)localObject1).setVisibility(0);
        ((LinearLayout)_$_findCachedViewById(b.f.back_button)).setOnClickListener((View.OnClickListener)new y(this));
        localObject1 = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
        kotlin.g.b.p.j(localObject1, "full_action_bar_title");
        ((TextView)localObject1).setVisibility(0);
        if (getTabType() == 10) {
          ((TextView)_$_findCachedViewById(b.f.full_action_bar_title)).setText(b.j.finder_tab_lbs);
        }
        localObject1 = getWindow();
        kotlin.g.b.p.j(localObject1, "window");
        localObject1 = ((Window)localObject1).getDecorView();
        kotlin.g.b.p.j(localObject1, "window.decorView");
        ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
        localObject1 = getWindow();
        kotlin.g.b.p.j(localObject1, "window");
        ((Window)localObject1).setStatusBarColor(0);
        getController().q((Activity)this, getResources().getColor(b.c.transparent));
        com.tencent.mm.ui.c.f((Activity)this, false);
        localObject1 = getSupportActionBar();
        if (localObject1 != null)
        {
          ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
          ((ActionBar)localObject1).hide();
        }
        i = ax.getStatusBarHeight((Context)this);
        localObject1 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        kotlin.g.b.p.j(localObject1, "full_actionbar");
        localObject1 = ((FrameLayout)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height += i;
        localObject2 = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        kotlin.g.b.p.j(localObject2, "full_actionbar");
        ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((FrameLayout)_$_findCachedViewById(b.f.full_actionbar)).setPadding(0, i, 0, 0);
        getController().updataStatusBarIcon(true);
        setNavigationbarColor(-16777216);
        ((ImageView)_$_findCachedViewById(b.f.gallery_bg)).setBackgroundColor(getResources().getColor(b.c.full_black));
        localObject1 = findViewById(b.f.share_rl_container);
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundColor(getResources().getColor(b.c.full_black));
        }
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
        if (com.tencent.mm.plugin.finder.feed.logic.d.MD(this.wwk))
        {
          localObject1 = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
          com.tencent.mm.plugin.finder.feed.logic.d.a(this);
        }
        localObject1 = (WeImageView)findViewById(b.f.backBtnIv);
        if (localObject1 == null) {
          break label2603;
        }
        ((WeImageView)localObject1).setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
        AppMethodBeat.o(278076);
        return;
        if ((this.AvO == 0L) || (!this.xxP)) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        localObject2 = c.a.MS(this.AvO);
        if (localObject2 == null) {
          break;
        }
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        this.AvL = c.a.a((FinderItem)localObject2);
        break;
        label2554:
        bool = false;
        break label1158;
        label2560:
        if (this.xdc < 0)
        {
          i = 3;
          break label1355;
        }
        i = this.xdc;
        break label1355;
        label2580:
        localObject1 = null;
        break label1978;
        label2586:
        if (!this.xGX) {
          setMMTitle(b.j.finder_title);
        }
      }
      label2603:
      AppMethodBeat.o(278076);
      return;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(278077);
    boolean bool = isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(278077);
    return bool;
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(278041);
    if (!this.Awa)
    {
      com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.hd(getTabType(), eaZ())) {}
    }
    else
    {
      AppMethodBeat.o(278041);
      return true;
    }
    AppMethodBeat.o(278041);
    return false;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(278085);
    if (this.Awg)
    {
      AppMethodBeat.o(278085);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(278085);
    return bool;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(278089);
    if ((this.Awp) || (this.Awq))
    {
      AppMethodBeat.o(278089);
      return;
    }
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    if (((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).onBackPressed())
    {
      AppMethodBeat.o(278089);
      return;
    }
    Object localObject2 = findViewById(b.f.retry_tip);
    localObject1 = this.Awm;
    if (this.Awg)
    {
      Object localObject3 = this.zzB;
      if (localObject3 == null) {
        kotlin.g.b.p.bGy("tipsLayout");
      }
      if (((View)localObject3).getVisibility() != 0)
      {
        kotlin.g.b.p.j(localObject2, "retryView");
        if ((((View)localObject2).getVisibility() != 0) && (localObject1 != null))
        {
          if (ebj().ebm()) {
            break label565;
          }
          localObject2 = this.Awh;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("contentUI");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = this.Awi;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("animCoverLayout");
          }
          ((FrameLayout)localObject2).setVisibility(0);
          localObject2 = this.Awj;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("animCoverImage");
          }
          ((NinePatchCropImageView)localObject2).setAlpha(1.0F);
          localObject2 = (com.tencent.mm.plugin.findersdk.a.ak)h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
          localObject3 = this.Awo;
          NinePatchCropImageView localNinePatchCropImageView = this.Awj;
          if (localNinePatchCropImageView == null) {
            kotlin.g.b.p.bGy("animCoverImage");
          }
          ((com.tencent.mm.plugin.findersdk.a.ak)localObject2).loadImage((String)localObject3, (ImageView)localNinePatchCropImageView);
          float f = (float)getIntent().getDoubleExtra("key_image_height_radio", 1.166666626930237D);
          localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() == 0)
          {
            localObject2 = this.Awj;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            localObject2 = ((NinePatchCropImageView)localObject2).getLayoutParams();
            f = androidx.core.b.a.c(f, 1.0F, 1.333333F);
            localObject3 = this.Awj;
            if (localObject3 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.dm(f * ((NinePatchCropImageView)localObject3).getLayoutParams().width);
          }
          for (;;)
          {
            localObject2 = this.Awj;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).requestLayout();
            localObject2 = this.Awj;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).post((Runnable)new z(this, (ViewAnimHelper.ViewInfo)localObject1));
            AppMethodBeat.o(278089);
            return;
            localObject2 = this.Awj;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            localObject2 = ((NinePatchCropImageView)localObject2).getLayoutParams();
            localObject3 = this.Awj;
            if (localObject3 == null) {
              kotlin.g.b.p.bGy("animCoverImage");
            }
            ((ViewGroup.LayoutParams)localObject2).height = ((NinePatchCropImageView)localObject3).getLayoutParams().width;
            if (this.Awk != 0)
            {
              localObject2 = this.Awj;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("animCoverImage");
              }
              ((NinePatchCropImageView)localObject2).setBackground(null);
              localObject2 = this.Awj;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("animCoverImage");
              }
              ((NinePatchCropImageView)localObject2).setNinePatchId(this.Awk);
              localObject2 = this.Awj;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("animCoverImage");
              }
              ((NinePatchCropImageView)localObject2).setAlpha(1.0F);
              localObject2 = this.Awj;
              if (localObject2 == null) {
                kotlin.g.b.p.bGy("animCoverImage");
              }
              ((NinePatchCropImageView)localObject2).nq(((ViewAnimHelper.ViewInfo)localObject1).YkY.width(), ((ViewAnimHelper.ViewInfo)localObject1).YkY.height());
            }
          }
        }
      }
    }
    if (!ebj().ebm()) {
      finish();
    }
    label565:
    AppMethodBeat.o(278089);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278046);
    this.Awa = getIntent().getBooleanExtra("KEY_FORCE_FULLSCREEN", false);
    this.Awm = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("key_view_info"));
    String str2 = getIntent().getStringExtra("key_image_url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.Awn = str1;
    str2 = getIntent().getStringExtra("key_image_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.Awo = str1;
    str2 = getIntent().getStringExtra("key_image_full_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.Awk = getIntent().getIntExtra("key_nine_patch_id", 0);
    this.Awl = getIntent().getLongExtra("key_animate_id", 0L);
    if (eaZ() == 38) {
      this.AvD = 2;
    }
    int i;
    if (isOtherEnableFullScreenEnjoy())
    {
      if (((CharSequence)str1).length() <= 0) {
        break label274;
      }
      i = 1;
      if (i != 0)
      {
        Log.i(this.TAG, "[onCreate] has fromImageFullUrl");
        this.Awn = str1;
      }
    }
    if (isOtherEnableFullScreenEnjoy())
    {
      if (((CharSequence)this.Awn).length() != 0) {
        break label279;
      }
      i = 1;
      label228:
      if (i != 0) {}
    }
    else
    {
      if (getIntent().getIntExtra("business_type", 0) != 1) {
        break label284;
      }
    }
    this.Awg = false;
    overridePendingTransition(com.tencent.mm.plugin.finder.b.a.slide_right_in, com.tencent.mm.plugin.finder.b.a.slide_left_out);
    for (;;)
    {
      super.onCreate(paramBundle);
      AppMethodBeat.o(278046);
      return;
      label274:
      i = 0;
      break;
      label279:
      i = 0;
      break label228;
      label284:
      if ((this.Awm != null) && (!Util.isNullOrNil(this.Awn))) {
        this.Awg = true;
      }
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(278048);
    super.onCreateBeforeSetContentView();
    if (this.Awg)
    {
      if (ar.isDarkMode())
      {
        setTheme(b.k.MMTheme_Holo_FinderDarkTransparent);
        AppMethodBeat.o(278048);
        return;
      }
      setTheme(b.k.MMTheme_Holo_FinderLightTransparent);
    }
    AppMethodBeat.o(278048);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278082);
    long l;
    int i;
    Object localObject2;
    if ((this.wwk != 0) && (!this.Avv))
    {
      if (this.xGX)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        l = this.feedId;
        i = this.wwk;
        localObject2 = this.fLi;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.report.n.a(l, i, 4L, (String)localObject1, 0, 2);
        this.Avv = true;
      }
    }
    else
    {
      dty().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = getContext();
      kotlin.g.b.p.j(localObject1, "context");
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)dty());
        }
      }
      dtz().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = getContext();
      kotlin.g.b.p.j(localObject1, "context");
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)dtz());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
      i = getTabType();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ((Context)this);
      if (localObject1 == null) {
        break label404;
      }
    }
    label404:
    for (Object localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
    {
      com.tencent.mm.plugin.finder.report.j.e(i, (bid)localObject1);
      localObject1 = this.Awb;
      if (localObject1 != null) {
        ((IListener)localObject1).dead();
      }
      localObject1 = this.Awc;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject2 = getContext();
        kotlin.g.b.p.j(localObject2, "context");
        localObject2 = aj.a.fZ((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2);
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject2).b(((o)localObject1).xyq);
          }
        }
        ((com.tencent.mm.plugin.finder.feed.p)localObject1).onDetach();
      }
      this.Awc = null;
      super.onDestroy();
      AppMethodBeat.o(278082);
      return;
      com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
      l = this.feedId;
      i = this.wwk;
      localObject2 = this.fLi;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localn.a(l, i, (String)localObject1, 0, 2);
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(278050);
    super.onPause();
    this.Awu.dead();
    if (this.xGX)
    {
      localObject = this.Awb;
      if (localObject != null) {
        ((IListener)localObject).alive();
      }
    }
    com.tencent.mm.plugin.finder.report.m.b(this.Awd, getCommentScene(), ebb());
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.AvB;
    if (localObject == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    com.tencent.mm.plugin.finder.live.report.k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.live.report.c.yAj);
    AppMethodBeat.o(278050);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(278049);
    super.onResume();
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = (com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.ui.sharerel.c.class);
    i locali = this.AvA;
    if (locali == null) {
      kotlin.g.b.p.bGy("presenter");
    }
    ((com.tencent.mm.plugin.finder.ui.sharerel.c)localObject).AvA = locali;
    this.Awu.alive();
    boolean bool;
    int i;
    if (this.xGX)
    {
      localObject = this.Awb;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      bool = c(this.xyu);
      Log.i(this.TAG, "isFollowed: " + bool + " followStatus:" + this.AvX);
      if (this.AvY != null)
      {
        i = this.AvX;
        if (i != Awz) {
          break label292;
        }
        if (bool) {
          qM(false);
        }
        this.AvY = null;
      }
      if (this.AvX == Awy) {
        e(this.xyu);
      }
    }
    localObject = com.tencent.mm.plugin.finder.report.j.zVy;
    com.tencent.mm.plugin.finder.report.j.Pq(getTabType());
    switch (getCommentScene())
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.m.a(this.Awd, getCommentScene(), ebb());
      localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
      localObject = this.AvB;
      if (localObject == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      com.tencent.mm.plugin.finder.live.report.k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.live.report.c.yAi);
      AppMethodBeat.o(278049);
      return;
      label292:
      if ((i != AwA) || (bool)) {
        break;
      }
      qM(true);
      break;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ns(true);
      continue;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ns(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(278064);
    if (findViewById(b.f.share_feed_progress) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(b.f.share_feed_progress);
        kotlin.g.b.p.j(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(278064);
        return;
      }
      View localView = findViewById(b.f.share_feed_progress);
      kotlin.g.b.p.j(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(278064);
  }
  
  public final void qQ(final boolean paramBoolean)
  {
    AppMethodBeat.i(278063);
    final aa.f localf = new aa.f();
    localf.aaBC = findViewById(b.f.retry_tip);
    if ((View)localf.aaBC != null)
    {
      if (paramBoolean)
      {
        ((View)localf.aaBC).setVisibility(0);
        ((View)localf.aaBC).setOnClickListener((View.OnClickListener)new ai(this, paramBoolean, localf));
        AppMethodBeat.o(278063);
        return;
      }
      ((View)localf.aaBC).setVisibility(8);
    }
    AppMethodBeat.o(278063);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$Companion;", "", "()V", "FOLLOWED", "", "getFOLLOWED", "()I", "FOLLOW_MENU_ID", "getFOLLOW_MENU_ID", "INIT_FOLLOW", "getINIT_FOLLOW", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "UNFOLLOWED", "getUNFOLLOWED", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    aa(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$popupEntrance$1$2"})
  static final class ab
    implements Runnable
  {
    ab(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(288674);
      FinderShareFeedRelUI.t(this.AwC);
      AppMethodBeat.o(288674);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$popupTips$1$2"})
  static final class ac
    implements Runnable
  {
    ac(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(289770);
      FinderShareFeedRelUI.u(this.AwC);
      AppMethodBeat.o(289770);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class ad
    implements Animator.AnimatorListener
  {
    ad(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285436);
      FinderShareFeedRelUI.v(this.AwC);
      FinderShareFeedRelUI.w(this.AwC).setVisibility(0);
      if (FinderShareFeedRelUI.x(this.AwC)) {
        FinderShareFeedRelUI.w(this.AwC).post((Runnable)new a(this));
      }
      Log.i(this.AwC.TAG, "runEnterAnimation end " + FinderShareFeedRelUI.x(this.AwC));
      AppMethodBeat.o(285436);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(285435);
      Log.i(this.AwC.TAG, "runEnterAnimation start");
      AppMethodBeat.o(285435);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(285437);
      this.AwF.setVisibility(0);
      AppMethodBeat.o(285437);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderShareFeedRelUI.ad paramad) {}
      
      public final void run()
      {
        AppMethodBeat.i(265765);
        FinderShareFeedRelUI.c(this.AwP.AwC);
        AppMethodBeat.o(265765);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class ae
    implements ValueAnimator.AnimatorUpdateListener
  {
    ae(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(277759);
      kotlin.g.b.p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(277759);
        throw paramValueAnimator;
      }
      if ((((Float)paramValueAnimator).floatValue() > 0.1F) && (FinderShareFeedRelUI.y(this.AwC).getAlpha() < 0.9F)) {
        FinderShareFeedRelUI.y(this.AwC).setAlpha(1.0F);
      }
      AppMethodBeat.o(277759);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class af
    implements Animator.AnimatorListener
  {
    af(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(292053);
      kotlin.g.b.p.k(paramAnimator, "animation");
      AppMethodBeat.o(292053);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(292052);
      kotlin.g.b.p.k(paramAnimator, "animation");
      FinderShareFeedRelUI.y(this.AwC).postDelayed((Runnable)new a(this), 220L);
      paramAnimator = this.AwC;
      int i = com.tencent.mm.plugin.finder.b.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      Log.i(this.AwC.TAG, "runExitAnimation end");
      AppMethodBeat.o(292052);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(292054);
      kotlin.g.b.p.k(paramAnimator, "animation");
      AppMethodBeat.o(292054);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(292051);
      kotlin.g.b.p.k(paramAnimator, "animation");
      paramAnimator = this.AwQ;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(0.0F);
      }
      Log.i(this.AwC.TAG, "runExitAnimation start");
      AppMethodBeat.o(292051);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderShareFeedRelUI.af paramaf) {}
      
      public final void run()
      {
        AppMethodBeat.i(262415);
        this.AwR.AwC.finish();
        AppMethodBeat.o(262415);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showFollowView$1$1", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "plugin-finder_release"})
  public static final class ah
    implements MenuItem.OnMenuItemClickListener
  {
    ah(FinderShareFeedRelUI paramFinderShareFeedRelUI, FinderContact paramFinderContact) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(269416);
      FinderShareFeedRelUI.r(this.AwC);
      AppMethodBeat.o(269416);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class ai
    implements View.OnClickListener
  {
    ai(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, aa.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285343);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.AwC.pW(true);
      ((View)localf.aaBC).setVisibility(8);
      FinderShareFeedRelUI.s(this.AwC).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285343);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aj
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    aj(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class ak
    extends IListener<hq>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246139);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupEntranceInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      long l = z.bde();
      if (FinderShareFeedRelUI.MY(l)) {
        FinderShareFeedRelUI.a(this.AwC, l);
      }
      paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
      int i;
      Object localObject2;
      switch (((Number)com.tencent.mm.plugin.finder.storage.d.dWk().aSr()).intValue())
      {
      case 1: 
      default: 
        j = 1;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        i = 18;
        localObject2 = this.AwC.getString(b.j.finder_bottom_popup_entrance_default_wording);
        kotlin.g.b.p.j(localObject2, "getString(R.string.finde…entrance_default_wording)");
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        bid localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.AwC).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
        localObject1 = com.tencent.mm.plugin.finder.report.q.zWJ;
        com.tencent.mm.plugin.finder.report.q.dPF();
        l = cm.bfD();
        localObject1 = FinderShareFeedRelUI.o(this.AwC);
        if (localObject1 != null)
        {
          String str = ((awb)localObject1).title;
          localObject1 = str;
          if (str != null) {}
        }
        else
        {
          localObject1 = localObject2;
        }
        localObject2 = FinderShareFeedRelUI.o(this.AwC);
        if (localObject2 != null)
        {
          localObject2 = Integer.valueOf(((awb)localObject2).SIv);
          label227:
          com.tencent.mm.plugin.finder.report.q.a(localbid, 2, l, 0, 2, (String)localObject1, (Integer)localObject2);
          this.AwC.finish();
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(j).a(com.tencent.mm.plugin.finder.viewmodel.b.e.BgO);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra(paramView, true);
          ((Intent)localObject1).putExtra("KEY_FROM_SHARE_REL", true);
          paramView = FinderShareFeedRelUI.o(this.AwC);
          if (paramView == null) {
            break label488;
          }
          paramView = Long.valueOf(paramView.object_id);
          label322:
          ((Intent)localObject1).putExtra("KEY_GUIDE_BAR_OBJ_ID", (Serializable)paramView);
          paramView = localbid.wmL;
          if (paramView == null) {
            break label493;
          }
          paramView = kotlin.n.n.b((CharSequence)paramView, new char[] { '-' });
          if (paramView == null) {
            break label493;
          }
          paramView = (String)paramView.get(0);
          if (paramView == null) {
            break label493;
          }
        }
        break;
      }
      label488:
      label493:
      for (int j = Integer.parseInt(paramView);; j = -1)
      {
        if ((j > 0) && (i > 0)) {
          ((com.tencent.mm.plugin.findersdk.a.ak)h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(j, 9, i, (Intent)localObject1);
        }
        paramView = com.tencent.mm.plugin.finder.report.j.zVy;
        com.tencent.mm.plugin.finder.report.j.dPt();
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.AwC, (Intent)localObject1, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupEntranceInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246139);
        return;
        j = 4;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
        i = 19;
        break;
        j = 3;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
        i = 17;
        break;
        localObject2 = Integer.valueOf(0);
        break label227;
        paramView = null;
        break label322;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkSeek$1$1"})
  static final class d
    implements Runnable
  {
    d(FinderLinearLayoutManager paramFinderLinearLayoutManager, RecyclerView paramRecyclerView, FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(270036);
      final long l = this.AwC.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
      if (l > 0L) {
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new kotlin.g.b.q(l) {});
      }
      AppMethodBeat.o(270036);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    e(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    f(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    g(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    h(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$dismissEntrance$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.plugin.finder.animation.a
  {
    i(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287112);
      this.kJS.setVisibility(4);
      AppMethodBeat.o(287112);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$dismissPopupTipsLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.finder.animation.a
  {
    j(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291237);
      this.kJS.setVisibility(4);
      AppMethodBeat.o(291237);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.k>
  {
    k(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class l
    implements Animator.AnimatorListener
  {
    l(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(270029);
      FinderShareFeedRelUI.z(this.AwC).setVisibility(8);
      this.AwF.setAlpha(1.0F);
      FinderShareFeedRelUI.A(this.AwC);
      AppMethodBeat.o(270029);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$1"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Integer, String, x>
  {
    m(i parami, FinderShareFeedRelUI paramFinderShareFeedRelUI, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$2"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<FinderObject, x>
  {
    n(i parami, FinderShareFeedRelUI paramFinderShareFeedRelUI, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    o(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$2"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    p(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(282426);
      this.AwC.onBackPressed();
      AppMethodBeat.o(282426);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.b<View, x>
  {
    r(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(288705);
      FinderShareFeedRelUI.k(this.AwC).xvJ.getRecyclerView().setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
      AppMethodBeat.o(288705);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class u
    extends RecyclerView.l
  {
    private float offset = 100.0F;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(289932);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(289932);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = null;
      View localView1 = null;
      AppMethodBeat.i(289930);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      if (FinderShareFeedRelUI.e(this.AwC).getDataListJustForAdapter().size() >= 2)
      {
        if (this.AwC.isOtherEnableFullScreenEnjoy()) {
          break label324;
        }
        localObject1 = FinderShareFeedRelUI.k(this.AwC).xvJ.getRecyclerView().cK(1);
        if (localObject1 == null) {
          break label312;
        }
        localObject1 = ((RecyclerView.v)localObject1).amk;
        if (localObject1 == null) {
          break label318;
        }
        localObject2 = ((View)localObject1).findViewById(b.f.finder_similar_feed_tv);
        label134:
        arrayOfInt = new int[2];
        if (localObject2 != null) {
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
        }
        localObject3 = FinderShareFeedRelUI.p(this.AwC);
        if (localObject3 != null) {
          localView1 = ((View)localObject3).findViewById(b.f.finder_similar_feed_tv);
        }
        localObject3 = new int[2];
        if (localView1 != null) {
          localView1.getLocationOnScreen((int[])localObject3);
        }
        View localView2 = FinderShareFeedRelUI.p(this.AwC);
        if ((localView2 != null) && (localView2.getVisibility() == 0) && (localObject2 != null) && (localView1 != null) && (arrayOfInt[1] <= localObject3[1]))
        {
          localObject2 = FinderShareFeedRelUI.p(this.AwC);
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(8);
          }
          ((View)localObject1).setVisibility(0);
        }
        this.AwC.ebh();
      }
      label312:
      label318:
      label324:
      do
      {
        do
        {
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
          com.tencent.mm.plugin.finder.live.report.k.b(paramRecyclerView, s.t.yGO, String.valueOf(this.AwC.getCommentScene()), com.tencent.mm.plugin.finder.live.report.c.yAh);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(289930);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label134;
          localObject1 = FinderShareFeedRelUI.p(this.AwC);
        } while ((localObject1 == null) || (((View)localObject1).getVisibility() != 0));
        localView1 = FinderShareFeedRelUI.p(this.AwC);
      } while (localView1 == null);
      paramInt1 = com.tencent.mm.ci.a.fromDPToPix((Context)this.AwC.getContext(), 112);
      Object localObject3 = FinderShareFeedRelUI.k(this.AwC).xvJ.getRecyclerView().cK(0);
      if (localObject3 != null)
      {
        localObject1 = ((RecyclerView.v)localObject3).amk;
        if (localObject1 == null) {}
      }
      for (Object localObject2 = ((View)localObject1).findViewById(b.f.finder_feed_full_footer_layout);; localObject2 = null)
      {
        localObject1 = arrayOfInt;
        if (localObject3 != null)
        {
          localObject3 = ((RecyclerView.v)localObject3).amk;
          localObject1 = arrayOfInt;
          if (localObject3 != null) {
            localObject1 = ((View)localObject3).findViewById(FinderShareFeedRelUI.q(this.AwC));
          }
        }
        this.offset -= paramInt2 / 5.0F;
        this.offset = androidx.core.b.a.c(this.offset, 0.0F, 100.0F);
        localView1.setAlpha(this.offset / 100.0F);
        if ((localView1.getVisibility() != 0) || (this.offset > 0.0F)) {
          break;
        }
        localView1.setVisibility(4);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).animate();
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).translationYBy(paramInt1);
            if (localObject2 != null)
            {
              localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(260L);
              if (localObject2 != null) {
                ((ViewPropertyAnimator)localObject2).start();
              }
            }
          }
        }
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((View)localObject1).animate();
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramInt1);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(260L);
        if (localObject1 == null) {
          break;
        }
        ((ViewPropertyAnimator)localObject1).start();
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initFollow$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class v
    extends IListener<hm>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, bu>
  {
    w(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Integer, Integer, LinkedList<bu>>
  {
    x(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269272);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.AwC.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269272);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(FinderShareFeedRelUI paramFinderShareFeedRelUI, ViewAnimHelper.ViewInfo paramViewInfo) {}
    
    public final void run()
    {
      AppMethodBeat.i(279623);
      FinderShareFeedRelUI localFinderShareFeedRelUI = this.AwC;
      Object localObject1 = this.AwC.findViewById(b.f.share_animation_layout);
      kotlin.g.b.p.j(localObject1, "findViewById(R.id.share_animation_layout)");
      localObject1 = (AnimationLayout)localObject1;
      View localView = this.AwC.findViewById(b.f.gallery_bg);
      kotlin.g.b.p.j(localView, "findViewById(R.id.gallery_bg)");
      Object localObject2 = this.AwC.getWindow();
      kotlin.g.b.p.j(localObject2, "window");
      localObject2 = ((Window)localObject2).getDecorView();
      kotlin.g.b.p.j(localObject2, "window.decorView");
      FinderShareFeedRelUI.a(localFinderShareFeedRelUI, (AnimationLayout)localObject1, localView, (View)localObject2, this.AwN);
      AppMethodBeat.o(279623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */