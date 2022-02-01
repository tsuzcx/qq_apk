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
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "checkExposeTaskAdded", "", "getCheckExposeTaskAdded", "()Z", "setCheckExposeTaskAdded", "(Z)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "defaultCommentScene$delegate", "detailCommentScene", "getDetailCommentScene", "detailCommentScene$delegate", "distance", "doShowAfterEnter", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "feedContactChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "followChangeEvent", "followStatus", "fromAnimateKey", "fromImageUrl", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "isFromAd", "isPostingScene", "setPostingScene", "isShareClickReport", "isTipsFirstShown", "isTitleShowed", "loader", "localFeedId", "getLocalFeedId", "setLocalFeedId", "ninePatchId", "parentBottom", "getParentBottom", "parentBottom$delegate", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "popupTipsExposed", "getPopupTipsExposed", "setPopupTipsExposed", "popupTipsLayout", "Landroid/view/View;", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "reportUiType", "getReportUiType", "setReportUiType", "requestScene", "getRequestScene", "setRequestScene", "scene", "getScene", "setScene", "sessionID", "getSessionID", "setSessionID", "shareVideoFinish", "getShareVideoFinish", "setShareVideoFinish", "showFinderEntry", "showRelatedList", "getShowRelatedList", "setShowRelatedList", "staticTipsExposed", "getStaticTipsExposed", "setStaticTipsExposed", "staticTipsShowing", "getStaticTipsShowing", "setStaticTipsShowing", "tabType", "getTabType", "tabType$delegate", "tipsFirstShownCount", "tipsLayout", "tipsShownLimit", "tipsWording", "uiType", "getUiType", "setUiType", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "videoFinishListener", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1;", "viewCallback", "changeFollow", "", "changeFollowState", "isFollowed", "changeFollowView", "checkMoreTips", "checkPopupTipsInit", "checkStaticTipsExposed", "staticTipsTv", "convertActivityFromTranslucent", "finish", "fixActionBarStatus", "followUser", "getCommentScene", "getLayoutId", "getMenuStyle", "Lcom/tencent/mm/ui/MMActivityController$OptionMenuStyle;", "getMenuText", "getModel", "getPresenter", "getReportType", "getShareAnimationLayoutTop", "", "radio", "screenWidth", "screenHeight", "mediaH", "getViewBottomInWindow", "view", "getViewCallback", "handleFollowStateChange", "hideCoverAnimation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActivityCloseAnimation", "initData", "initFollow", "initOnCreate", "initSimilarTipsShownCount", "isAllowShowTips", "contact", "isHideStatusBar", "isOtherEnableFullScreenEnjoy", "isSupportNavigationSwipeBack", "isViewExposed", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "overlayStatusBar", "popupTips", "isFullScreen", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "setFollowStatus", "setTitleWithNickName", "nickName", "shouldPopupTips", "shareVideoHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "showFollowView", "showProgress", "ifShow", "showRetryTips", "unFollowUser", "Companion", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, j.b, k>
{
  private static final int vPC = 1;
  private static final int vPD = 0;
  private static final int vPE = 1;
  private static final int vPF = 2;
  public static final a vPG;
  final String TAG;
  private HashMap _$_findViewCache;
  String dRL;
  long feedId;
  int sQn;
  private int scene;
  private boolean tNP;
  private final kotlin.f tRX;
  private final kotlin.f tRY;
  private boolean tVm;
  private String tipsWording;
  private String tuI;
  private int tvu;
  private View uNf;
  private boolean vOG;
  private boolean vOJ;
  private k vOO;
  private j.b vOP;
  private FinderFeedShareRelativeListLoader vOQ;
  private int vOR;
  int vOS;
  private final kotlin.f vOT;
  private final kotlin.f vOU;
  private final int vOV;
  private boolean vOW;
  private int vOX;
  private BaseFinderFeed vOY;
  private boolean vOZ;
  private boolean vPA;
  private final ac vPB;
  private String vPa;
  private long vPb;
  private final kotlin.f vPc;
  boolean vPd;
  private boolean vPe;
  private boolean vPf;
  private boolean vPg;
  private View vPh;
  private boolean vPi;
  private int vPj;
  private hf vPk;
  private FinderContact vPl;
  private IListener<hf> vPm;
  private final kotlin.f vPn;
  private int vPo;
  private boolean vPp;
  private FrameLayout vPq;
  private FrameLayout vPr;
  private NinePatchCropImageView vPs;
  private int vPt;
  private long vPu;
  private ViewAnimHelper.ViewInfo vPv;
  private String vPw;
  private boolean vPx;
  private boolean vPy;
  private boolean vPz;
  
  static
  {
    AppMethodBeat.i(252780);
    vPG = new a((byte)0);
    vPC = 1;
    vPE = 1;
    vPF = 2;
    AppMethodBeat.o(252780);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(252779);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.vOS = 2;
    this.scene = 2;
    this.dRL = "";
    this.tRX = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.tRY = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.vOT = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.vOU = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.vOV = 3;
    this.vOW = true;
    this.vOG = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    this.tuI = "";
    this.vOZ = true;
    this.vPa = "";
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new ab(this));
    this.vPj = vPD;
    this.vPn = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.vPw = "";
    this.tipsWording = "";
    this.vPB = new ac(this);
    AppMethodBeat.o(252779);
  }
  
  private final boolean W(RecyclerView.v paramv)
  {
    AppMethodBeat.i(252763);
    if (paramv == null)
    {
      AppMethodBeat.o(252763);
      return false;
    }
    Object localObject = y.vXH;
    if (y.gr(getTabType(), dAh()))
    {
      paramv = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.dvL().value()).intValue() == 1) && (this.vPd) && (!this.vPe))
      {
        AppMethodBeat.o(252763);
        return true;
      }
      AppMethodBeat.o(252763);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((((Number)com.tencent.mm.plugin.finder.storage.c.dvL().value()).intValue() == 1) && (this.vPd) && (!this.vPf) && (!this.vPe) && (dAj() > 0))
    {
      int i = dAj();
      paramv = paramv.aus;
      p.g(paramv, "shareVideoHolder.itemView");
      if (i - ee(paramv) < this.vPo)
      {
        AppMethodBeat.o(252763);
        return true;
      }
    }
    AppMethodBeat.o(252763);
    return false;
  }
  
  private final void c(final FinderContact paramFinderContact)
  {
    AppMethodBeat.i(252755);
    if ((!this.tVm) || (paramFinderContact == null) || (Util.isEqual(paramFinderContact.username, z.aUg())) || (!((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry()))
    {
      AppMethodBeat.o(252755);
      return;
    }
    boolean bool = d(paramFinderContact);
    addTextOptionMenu(vPC, oB(bool), (MenuItem.OnMenuItemClickListener)new z(this, paramFinderContact), null, oC(bool));
    oA(bool);
    AppMethodBeat.o(252755);
  }
  
  private static boolean d(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(252757);
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
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
    boolean bool = com.tencent.mm.plugin.finder.api.c.a.asJ(paramFinderContact);
    AppMethodBeat.o(252757);
    return bool;
  }
  
  private final int dAh()
  {
    AppMethodBeat.i(252744);
    int i = ((Number)this.vOT.getValue()).intValue();
    AppMethodBeat.o(252744);
    return i;
  }
  
  private final int dAi()
  {
    AppMethodBeat.i(252745);
    int i = ((Number)this.vOU.getValue()).intValue();
    AppMethodBeat.o(252745);
    return i;
  }
  
  private final int dAj()
  {
    AppMethodBeat.i(252747);
    int i = ((Number)this.vPn.getValue()).intValue();
    AppMethodBeat.o(252747);
    return i;
  }
  
  private final void dAk()
  {
    AppMethodBeat.i(252754);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    label203:
    label227:
    View localView;
    label248:
    Object localObject4;
    if (this.vPh == null)
    {
      localObject1 = y.vXH;
      boolean bool = y.gr(getTabType(), dAh());
      if (bool)
      {
        localObject1 = this.vOQ;
        if (localObject1 == null) {
          p.btv("loader");
        }
        if (((FinderFeedShareRelativeListLoader)localObject1).getDataListJustForAdapter().size() < 2)
        {
          AppMethodBeat.o(252754);
          return;
        }
      }
      if (bool)
      {
        localObject1 = this.vOP;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject1 = ((b.b)localObject1).tLS.getRecyclerView().ch(0);
        if (localObject1 != null) {
          localObject1 = ((RecyclerView.v)localObject1).aus;
        }
      }
      while (localObject1 == null)
      {
        AppMethodBeat.o(252754);
        return;
        localObject1 = null;
        continue;
        localObject1 = getContentView();
      }
      localObject3 = ((View)localObject1).findViewById(2131304900);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((ViewStub)((View)localObject1).findViewById(2131304899)).inflate();
      }
      this.vPh = ((View)localObject2);
      localObject1 = this.vPh;
      if (localObject1 == null) {
        break label393;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131301491);
      localObject2 = this.vPh;
      if (localObject2 == null) {
        break label398;
      }
      localObject2 = ((View)localObject2).findViewById(2131304897);
      localObject3 = this.vPh;
      if (localObject3 == null) {
        break label403;
      }
      localObject3 = (WeImageView)((View)localObject3).findViewById(2131301490);
      localView = this.vPh;
      if (localView == null) {
        break label409;
      }
      localView = localView.findViewById(2131304898);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.b.vPH);
      }
      localObject4 = this.vPh;
      if (localObject4 != null) {
        ((View)localObject4).setVisibility(8);
      }
      if (localObject1 == null) {
        break label415;
      }
      localObject4 = ((TextView)localObject1).getPaint();
      label292:
      com.tencent.mm.ui.ao.a((Paint)localObject4, 0.8F);
      if (bool)
      {
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getResources().getColor(2131099844));
        }
        if (localObject3 != null) {
          ((WeImageView)localObject3).setIconColor(getResources().getColor(2131099844));
        }
      }
      if (!bool) {
        break label421;
      }
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(2131101287);
      }
      if (localView != null) {
        localView.setBackgroundResource(2131101287);
      }
    }
    for (;;)
    {
      this.vPo = com.tencent.mm.cb.a.fromDPToPix((Context)this, 104);
      AppMethodBeat.o(252754);
      return;
      label393:
      localObject1 = null;
      break;
      label398:
      localObject2 = null;
      break label203;
      label403:
      localObject3 = null;
      break label227;
      label409:
      localView = null;
      break label248;
      label415:
      localObject4 = null;
      break label292;
      label421:
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundResource(2131232664);
        }
      }
      else if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(2131232663);
      }
    }
  }
  
  private k dAm()
  {
    AppMethodBeat.i(252770);
    k localk = this.vOO;
    if (localk == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(252770);
    return localk;
  }
  
  private com.tencent.mm.plugin.finder.feed.model.f dcX()
  {
    AppMethodBeat.i(252743);
    com.tencent.mm.plugin.finder.feed.model.f localf = (com.tencent.mm.plugin.finder.feed.model.f)this.tRY.getValue();
    AppMethodBeat.o(252743);
    return localf;
  }
  
  private final void ec(View paramView)
  {
    AppMethodBeat.i(252764);
    if (paramView == null)
    {
      AppMethodBeat.o(252764);
      return;
    }
    boolean bool = ed(paramView);
    if ((!this.vPg) && (bool))
    {
      this.vPf = true;
      this.vPg = true;
      paramView = com.tencent.mm.plugin.finder.report.m.vfD;
      com.tencent.mm.plugin.finder.report.m.dof();
      paramView = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.plugin.finder.report.m.a(((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), 2, System.currentTimeMillis());
      AppMethodBeat.o(252764);
      return;
    }
    if (!bool) {
      this.vPg = false;
    }
    AppMethodBeat.o(252764);
  }
  
  private static boolean ed(View paramView)
  {
    AppMethodBeat.i(252765);
    if ((paramView.isShown()) && (paramView.getAlpha() > 0.0F) && (paramView.getGlobalVisibleRect(new Rect())))
    {
      AppMethodBeat.o(252765);
      return true;
    }
    AppMethodBeat.o(252765);
    return false;
  }
  
  private static int ee(View paramView)
  {
    AppMethodBeat.i(252766);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(252766);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(252766);
    return i + j;
  }
  
  private final void oA(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = vPF;; i = vPE)
    {
      this.vPj = i;
      return;
    }
  }
  
  private final String oB(boolean paramBoolean)
  {
    AppMethodBeat.i(252758);
    if (paramBoolean)
    {
      str = getContext().getString(2131759794);
      p.g(str, "context.getString(R.string.finder_followed)");
      AppMethodBeat.o(252758);
      return str;
    }
    String str = getContext().getString(2131759774);
    p.g(str, "context.getString(R.string.finder_follow)");
    AppMethodBeat.o(252758);
    return str;
  }
  
  private static t.b oC(boolean paramBoolean)
  {
    if (paramBoolean) {
      return t.b.OHj;
    }
    return t.b.OHi;
  }
  
  private final void oE(boolean paramBoolean)
  {
    AppMethodBeat.i(252762);
    dAk();
    Object localObject1 = this.vPh;
    if (localObject1 != null)
    {
      int i;
      Object localObject2;
      if (Util.isNullOrNil(this.tipsWording))
      {
        if (this.tVm)
        {
          i = 2131759743;
          localObject2 = getString(i);
          p.g(localObject2, "getString(if (isFromAd) …_feed_more_similar_feed2)");
          this.tipsWording = ((String)localObject2);
        }
      }
      else
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131301491);
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)this.tipsWording);
        }
        ((View)localObject1).setVisibility(0);
        i = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 112);
        if (!paramBoolean) {
          break label353;
        }
        localObject1 = this.vOP;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject2 = ((b.b)localObject1).tLS.getRecyclerView().ch(0);
        if (localObject2 == null) {
          break label342;
        }
        localObject1 = ((RecyclerView.v)localObject2).aus;
        if (localObject1 == null) {
          break label342;
        }
        localObject1 = ((View)localObject1).findViewById(2131300827);
        label163:
        if (localObject2 == null) {
          break label347;
        }
        localObject2 = ((RecyclerView.v)localObject2).aus;
        if (localObject2 == null) {
          break label347;
        }
        localObject2 = ((View)localObject2).findViewById(2131301467);
        label190:
        if (localObject1 != null)
        {
          ((View)localObject1).setTranslationY(((View)localObject1).getTranslationY() + i);
          localObject1 = ((View)localObject1).animate();
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-i);
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(260L);
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
            localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(-i);
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
      for (;;)
      {
        this.vPe = true;
        localObject1 = com.tencent.mm.plugin.finder.report.m.vfD;
        com.tencent.mm.plugin.finder.report.m.dof();
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.report.m.a(((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), 1, System.currentTimeMillis());
        AppMethodBeat.o(252762);
        return;
        i = 2131759740;
        break;
        label342:
        localObject1 = null;
        break label163;
        label347:
        localObject2 = null;
        break label190;
        label353:
        ((View)localObject1).setTranslationY(((View)localObject1).getTranslationY() + i);
        ((View)localObject1).animate().translationYBy(-i).setDuration(260L).start();
      }
    }
    AppMethodBeat.o(252762);
  }
  
  private final void oz(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(252756);
    boolean bool1;
    int i;
    if (!paramBoolean)
    {
      bool1 = true;
      oA(bool1);
      i = vPC;
      if (paramBoolean) {
        break label72;
      }
      bool1 = true;
      label30:
      updateOptionMenuText(i, oB(bool1));
      i = vPC;
      if (paramBoolean) {
        break label77;
      }
    }
    label72:
    label77:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      updateOptionMenuStyle(i, oC(paramBoolean));
      AppMethodBeat.o(252756);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252795);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252795);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252794);
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
    AppMethodBeat.o(252794);
    return localView1;
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return !this.vPp;
  }
  
  public final void dAl()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(252761);
    Object localObject3 = this.vOQ;
    if (localObject3 == null) {
      p.btv("loader");
    }
    if (((FinderFeedShareRelativeListLoader)localObject3).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(252761);
      return;
    }
    localObject3 = y.vXH;
    boolean bool = y.gr(getTabType(), dAh());
    localObject3 = this.vOP;
    if (localObject3 == null) {
      p.btv("viewCallback");
    }
    RecyclerView.v localv = ((b.b)localObject3).tLS.getRecyclerView().ch(0);
    if (!bool)
    {
      localObject1 = this.vOP;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject3 = ((b.b)localObject1).tLS.getRecyclerView().ch(1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        View localView = ((RecyclerView.v)localObject3).aus;
        localObject1 = localObject2;
        if (localView != null) {
          localObject1 = localView.findViewById(2131301491);
        }
      }
      ec((View)localObject1);
      localObject1 = localObject3;
    }
    if ((localv != null) && (W(localv)))
    {
      oE(bool);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.v)localObject1).aus;
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(4);
          AppMethodBeat.o(252761);
          return;
        }
      }
      AppMethodBeat.o(252761);
      return;
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).aus;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        AppMethodBeat.o(252761);
        return;
      }
    }
    AppMethodBeat.o(252761);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.d dcW()
  {
    AppMethodBeat.i(252742);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.tRX.getValue();
    AppMethodBeat.o(252742);
    return locald;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252777);
    super.finish();
    if (this.vPp) {
      overridePendingTransition(2130771986, 2130771986);
    }
    AppMethodBeat.o(252777);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(252774);
    if (dAi() != 0)
    {
      i = dAi();
      AppMethodBeat.o(252774);
      return i;
    }
    int i = dAh();
    AppMethodBeat.o(252774);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131494628;
  }
  
  public final int getTabType()
  {
    AppMethodBeat.i(252746);
    int i = ((Number)this.vPc.getValue()).intValue();
    AppMethodBeat.o(252746);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252749);
    Object localObject = y.vXH;
    if (y.gr(getTabType(), dAh()))
    {
      localObject = ak.setOf(new Class[] { FinderFullFeedGuideUIC.class, FinderHorizontalVideoPreviewUIC.class, FinderLikeGuideUIC.class });
      AppMethodBeat.o(252749);
      return localObject;
    }
    AppMethodBeat.o(252749);
    return null;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(252775);
    if (this.vPp)
    {
      AppMethodBeat.o(252775);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(252775);
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(252768);
    this.feedId = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.tuI = ((String)localObject1);
    Object localObject3 = new z.f();
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((z.f)localObject3).SYG = localObject1;
    this.sQn = getIntent().getIntExtra("report_scene", 0);
    this.tvu = getIntent().getIntExtra("key_reuqest_scene", -1);
    this.dRL = getIntent().getStringExtra("from_user");
    this.vOS = getIntent().getIntExtra("report_uitype", 2);
    this.tVm = getIntent().getBooleanExtra("is_from_ad", false);
    this.vOZ = getIntent().getBooleanExtra("key_need_related_list", true);
    this.vPa = getIntent().getStringExtra("key_session_id");
    this.vPb = getIntent().getLongExtra("feed_local_id", 0L);
    this.tNP = getIntent().getBooleanExtra("key_posting_scene", false);
    int i;
    if (this.feedId == 0L)
    {
      if (((CharSequence)this.tuI).length() != 0) {
        break label892;
      }
      i = 1;
      if ((i != 0) && (this.vPb == 0L))
      {
        Log.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
        finish();
      }
    }
    localObject1 = findViewById(2131307805);
    p.g(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.uNf = ((View)localObject1);
    localObject1 = y.vXH;
    if (!y.gr(getTabType(), dAh())) {
      dAk();
    }
    if (this.tVm) {
      this.vPm = ((IListener)new q(this));
    }
    localObject1 = findViewById(2131307828);
    p.g(localObject1, "findViewById(R.id.share_ui_content)");
    this.vPq = ((FrameLayout)localObject1);
    localObject1 = findViewById(2131307794);
    p.g(localObject1, "findViewById(R.id.share_anim_cover_layout)");
    this.vPr = ((FrameLayout)localObject1);
    localObject1 = findViewById(2131307795);
    p.g(localObject1, "findViewById(R.id.share_anim_image)");
    this.vPs = ((NinePatchCropImageView)localObject1);
    float f2;
    float f3;
    float f4;
    if (this.vPp)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this), 2131689494);
      f2 = (float)getIntent().getDoubleExtra("key_image_height_radio", 1.166666626930237D);
      f3 = getIntent().getFloatExtra("key_image_height", 0.0F);
      f4 = getIntent().getFloatExtra("key_image_width", 0.0F);
      localObject1 = y.vXH;
      if (y.gr(getTabType(), dAh())) {
        break label2961;
      }
      localObject1 = y.vXH;
      f2 = y.bj(f2);
    }
    label2961:
    for (;;)
    {
      localObject1 = (aj)com.tencent.mm.kernel.g.ah(aj.class);
      localObject2 = this.vPw;
      Object localObject4 = this.vPs;
      if (localObject4 == null) {
        p.btv("animCoverImage");
      }
      ((aj)localObject1).loadImage((String)localObject2, (ImageView)localObject4);
      localObject1 = au.az((Context)getContext());
      i = ((Point)localObject1).x;
      int j = ((Point)localObject1).y;
      localObject1 = this.vPs;
      if (localObject1 == null) {
        p.btv("animCoverImage");
      }
      localObject1 = ((NinePatchCropImageView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(i * f2));
      localObject2 = this.vPs;
      if (localObject2 == null) {
        p.btv("animCoverImage");
      }
      ((NinePatchCropImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject2 = this.vPs;
      if (localObject2 == null) {
        p.btv("animCoverImage");
      }
      ((NinePatchCropImageView)localObject2).setAlpha(0.0F);
      int k = ((ViewGroup.LayoutParams)localObject1).height;
      localObject1 = y.vXH;
      float f1;
      if (y.gr(getTabType(), dAh()))
      {
        localObject1 = y.vXH;
        if (y.bl(f2))
        {
          localObject1 = getContext();
          p.g(localObject1, "context");
          int m = (int)((AppCompatActivity)localObject1).getResources().getDimension(2131165280);
          if (i * f2 <= j - m * 2) {
            f1 = j / 2.0F - k / 2.0F - m / 2;
          }
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "[initData] enableAnimation heightRatio=" + f2 + " height=" + f3 + " width=" + f4 + " animationLayoutTop=" + f1);
        localObject1 = findViewById(2131307796);
        p.g(localObject1, "coverImageLayout");
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null) {
          break label957;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(252768);
        throw ((Throwable)localObject1);
        label892:
        i = 0;
        break;
        f1 = j / 2.0F - k / 2.0F;
        continue;
        f1 = j / 2.0F - k / 2.0F;
        continue;
        localObject1 = getContext();
        p.g(localObject1, "context");
        f1 = ((AppCompatActivity)localObject1).getResources().getDimension(2131165311);
      }
      label957:
      ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)f1);
      localObject2 = y.vXH;
      if (y.bk(f2))
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(252768);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = this.vPq;
      if (localObject1 == null) {
        p.btv("contentUI");
      }
      ((FrameLayout)localObject1).setVisibility(8);
      localObject1 = this.vPr;
      if (localObject1 == null) {
        p.btv("animCoverLayout");
      }
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = this.vPr;
      if (localObject1 == null) {
        p.btv("animCoverLayout");
      }
      ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.m.vPM);
      localObject1 = findViewById(2131307806);
      p.g(localObject1, "progressView");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(252768);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 18);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131307796);
      p.g(localObject1, "findViewById(R.id.share_animation_layout)");
      localObject1 = (AnimationLayout)localObject1;
      localObject2 = findViewById(2131301854);
      p.g(localObject2, "findViewById(R.id.gallery_bg)");
      localObject4 = getWindow();
      p.g(localObject4, "window");
      localObject4 = ((Window)localObject4).getDecorView();
      p.g(localObject4, "window.decorView");
      ViewAnimHelper.ViewInfo localViewInfo = this.vPv;
      Log.i(this.TAG, "runEnterAnimation " + localViewInfo + ", " + this.vPx);
      if ((localViewInfo != null) && (!this.vPx))
      {
        this.vPx = true;
        Log.i(this.TAG, "runEnterAnimation");
        ((AnimationLayout)localObject1).b((View)localObject2, (View)localObject4, localViewInfo, (Animator.AnimatorListener)new v(this, (View)localObject2), (ValueAnimator.AnimatorUpdateListener)new w(this));
      }
      boolean bool;
      if (this.feedId != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        localObject1 = e.a.Fy(this.feedId);
        if (localObject1 != null)
        {
          Log.i(this.TAG, "use cache cacheTime=" + com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + ' ' + "current=" + com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", cl.aWA() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
          if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (cl.aWA() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
          {
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            this.vOY = com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject1);
          }
          localObject1 = x.SXb;
        }
        if (this.vOY == null)
        {
          Log.d(this.TAG, "cache null.show progress");
          nK(true);
        }
        i = this.scene;
        localObject1 = (MMActivity)this;
        if (this.vOG) {
          break label2905;
        }
        bool = true;
        label1598:
        localObject1 = new k(i, (MMActivity)localObject1, bool, getTabType());
        ((j.a)localObject1).hFK = this.feedId;
        localObject2 = (String)((z.f)localObject3).SYG;
        p.h(localObject2, "<set-?>");
        ((j.a)localObject1).objectNonceId = ((String)localObject2);
        ((j.a)localObject1).tNO = this.vOY;
        localObject2 = this.tuI;
        p.h(localObject2, "<set-?>");
        ((j.a)localObject1).tNK = ((String)localObject2);
        ((j.a)localObject1).tNL = this.vOZ;
        ((j.a)localObject1).tNP = this.tNP;
        ((j.a)localObject1).tNM = ((kotlin.g.a.m)new h((k)localObject1, this, (z.f)localObject3));
        ((j.a)localObject1).tNN = ((kotlin.g.a.b)new i((k)localObject1, this, (z.f)localObject3));
        localObject2 = x.SXb;
        this.vOO = ((k)localObject1);
        localObject1 = (MMActivity)this;
        localObject2 = this.vOO;
        if (localObject2 == null) {
          p.btv("presenter");
        }
        this.vOP = new j.b((MMActivity)localObject1, (j.a)localObject2, this.scene, getCommentScene());
        if (this.sQn != 15) {
          break label2911;
        }
        i = 6;
      }
      for (;;)
      {
        this.tvu = i;
        long l = this.feedId;
        localObject1 = this.tuI;
        localObject2 = (String)((z.f)localObject3).SYG;
        i = getTabType();
        bool = this.tVm;
        j = this.tvu;
        localObject3 = this.vPa;
        localObject4 = com.tencent.mm.ui.component.a.PRN;
        localObject3 = new FinderFeedShareRelativeListLoader(l, (String)localObject1, (String)localObject2, i, bool, j, (String)localObject3, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), this.tNP);
        localObject2 = getIntent().getStringExtra("key_from_user_name");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        ((FinderFeedShareRelativeListLoader)localObject3).dYs = ((String)localObject1);
        localObject2 = getIntent().getStringExtra("key_to_user_name");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        ((FinderFeedShareRelativeListLoader)localObject3).dJw = ((String)localObject1);
        Log.i(((FinderFeedShareRelativeListLoader)localObject3).getTAG(), "fromUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).dYs + ",toUserName=" + ((FinderFeedShareRelativeListLoader)localObject3).dJw);
        ((FinderFeedShareRelativeListLoader)localObject3).fetchEndCallback = ((kotlin.g.a.b)new j(this));
        ((FinderFeedShareRelativeListLoader)localObject3).tVk = ((kotlin.g.a.b)new k(this));
        localObject1 = x.SXb;
        this.vOQ = ((FinderFeedShareRelativeListLoader)localObject3);
        if (this.sQn != 0) {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1278L, 14L, 1L, false);
        }
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        this.vOX = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.OlO, 0);
        Log.d(this.TAG, "tips first shown count by each feed: " + this.vOX);
        localObject1 = this.vOP;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        ((b.b)localObject1).tLS.getRecyclerView().post((Runnable)new n(this));
        localObject1 = this.vOP;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        ((b.b)localObject1).tLS.getRecyclerView().a((RecyclerView.l)new o(this));
        localObject1 = this.vOO;
        if (localObject1 == null) {
          p.btv("presenter");
        }
        ((k)localObject1).vQl = ((kotlin.g.a.b)new p(this));
        dcW().a(this.scene, getCommentScene(), (kotlin.g.a.b)new r(this));
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = getContext();
        p.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
        if (localObject1 != null)
        {
          localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dcW());
          }
        }
        dcX().e((kotlin.g.a.m)new s(this));
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = getContext();
        p.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
        if (localObject1 != null)
        {
          localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dcX());
          }
        }
        localObject1 = y.vXH;
        if (!y.gr(getTabType(), dAh())) {
          break label2940;
        }
        localObject1 = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(localObject1, "full_actionbar");
        ((FrameLayout)localObject1).setVisibility(0);
        ((LinearLayout)_$_findCachedViewById(2131297164)).setOnClickListener((View.OnClickListener)new t(this));
        localObject1 = (TextView)_$_findCachedViewById(2131301814);
        p.g(localObject1, "full_action_bar_title");
        ((TextView)localObject1).setVisibility(0);
        if (getTabType() == 10) {
          ((TextView)_$_findCachedViewById(2131301814)).setText(2131760615);
        }
        localObject1 = getWindow();
        p.g(localObject1, "window");
        localObject1 = ((Window)localObject1).getDecorView();
        p.g(localObject1, "window.decorView");
        ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
        localObject1 = getWindow();
        p.g(localObject1, "window");
        ((Window)localObject1).setStatusBarColor(0);
        getController().p((Activity)this, getResources().getColor(2131101287));
        com.tencent.mm.ui.b.e((Activity)this, false);
        localObject1 = getSupportActionBar();
        if (localObject1 != null)
        {
          ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
          ((ActionBar)localObject1).hide();
        }
        i = au.getStatusBarHeight((Context)this);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(localObject1, "full_actionbar");
        localObject1 = ((FrameLayout)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height += i;
        localObject2 = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(localObject2, "full_actionbar");
        ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((FrameLayout)_$_findCachedViewById(2131301815)).setPadding(0, i, 0, 0);
        getController().updataStatusBarIcon(true);
        setNavigationbarColor(-16777216);
        ((ImageView)_$_findCachedViewById(2131301854)).setBackgroundColor(getResources().getColor(2131100495));
        localObject1 = findViewById(2131307819);
        if (localObject1 == null) {
          break label2933;
        }
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131100495));
        AppMethodBeat.o(252768);
        return;
        if ((this.vPb == 0L) || (!this.tNP)) {
          break;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.a.FS(this.vPb);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        this.vOY = com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject1);
        localObject1 = x.SXb;
        break;
        label2905:
        bool = false;
        break label1598;
        label2911:
        if (this.tvu < 0) {
          i = 3;
        } else {
          i = this.tvu;
        }
      }
      label2933:
      AppMethodBeat.o(252768);
      return;
      label2940:
      if (!this.tVm) {
        setMMTitle(2131760633);
      }
      AppMethodBeat.o(252768);
      return;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    AppMethodBeat.i(252769);
    y localy = y.vXH;
    boolean bool = y.gr(getTabType(), dAh());
    AppMethodBeat.o(252769);
    return bool;
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(252748);
    y localy = y.vXH;
    boolean bool = y.gr(getTabType(), dAh());
    AppMethodBeat.o(252748);
    return bool;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(252776);
    if (this.vPp)
    {
      AppMethodBeat.o(252776);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(252776);
    return bool;
  }
  
  public final void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(252760);
    if (findViewById(2131307806) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(2131307806);
        p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(252760);
        return;
      }
      View localView = findViewById(2131307806);
      p.g(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(252760);
  }
  
  public final void oD(final boolean paramBoolean)
  {
    AppMethodBeat.i(252759);
    final z.f localf = new z.f();
    localf.SYG = findViewById(2131307047);
    if ((View)localf.SYG != null)
    {
      if (paramBoolean)
      {
        ((View)localf.SYG).setVisibility(0);
        ((View)localf.SYG).setOnClickListener((View.OnClickListener)new aa(this, paramBoolean, localf));
        AppMethodBeat.o(252759);
        return;
      }
      ((View)localf.SYG).setVisibility(8);
    }
    AppMethodBeat.o(252759);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(252778);
    if ((this.vPx) || (this.vPy))
    {
      AppMethodBeat.o(252778);
      return;
    }
    Object localObject2 = findViewById(2131307047);
    Object localObject1 = this.vPv;
    if (this.vPp)
    {
      View localView = this.uNf;
      if (localView == null) {
        p.btv("tipsLayout");
      }
      if (localView.getVisibility() != 0)
      {
        p.g(localObject2, "retryView");
        if ((((View)localObject2).getVisibility() != 0) && (localObject1 != null))
        {
          if (dAm().dAp()) {
            break label468;
          }
          localObject2 = this.vPq;
          if (localObject2 == null) {
            p.btv("contentUI");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = this.vPr;
          if (localObject2 == null) {
            p.btv("animCoverLayout");
          }
          ((FrameLayout)localObject2).setVisibility(0);
          if (this.vPt != 0)
          {
            localObject2 = this.vPs;
            if (localObject2 == null) {
              p.btv("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setBackground(null);
            localObject2 = this.vPs;
            if (localObject2 == null) {
              p.btv("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setNinePatchId(this.vPt);
            localObject2 = this.vPs;
            if (localObject2 == null) {
              p.btv("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).setAlpha(1.0F);
            localObject2 = this.vPs;
            if (localObject2 == null) {
              p.btv("animCoverImage");
            }
            ((NinePatchCropImageView)localObject2).lZ(((ViewAnimHelper.ViewInfo)localObject1).QMg.width(), ((ViewAnimHelper.ViewInfo)localObject1).QMg.height());
          }
          localObject2 = findViewById(2131307796);
          p.g(localObject2, "findViewById(R.id.share_animation_layout)");
          localObject2 = (AnimationLayout)localObject2;
          localView = findViewById(2131301854);
          p.g(localView, "findViewById(R.id.gallery_bg)");
          Object localObject3 = getWindow();
          p.g(localObject3, "window");
          localObject3 = ((Window)localObject3).getDecorView();
          p.g(localObject3, "window.decorView");
          Log.i(this.TAG, "runExitAnimation " + this.vPx + ", " + this.vPy);
          if ((this.vPx) || (this.vPy))
          {
            AppMethodBeat.o(252778);
            return;
          }
          this.vPy = true;
          localView.setVisibility(8);
          ((AnimationLayout)localObject2).a(localView, (View)localObject3, (ViewAnimHelper.ViewInfo)localObject1, (Animator.AnimatorListener)new x(this, findViewById(2131296366)), (ValueAnimator.AnimatorUpdateListener)new y(this, (AnimationLayout)localObject2));
          localObject1 = EventCenter.instance;
          localObject2 = new ic();
          ((ic)localObject2).dMI.key = this.vPu;
          ((EventCenter)localObject1).publish((IEvent)localObject2);
          AppMethodBeat.o(252778);
          return;
        }
      }
    }
    if (!dAm().dAp()) {
      finish();
    }
    label468:
    AppMethodBeat.o(252778);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252750);
    this.vPv = ((ViewAnimHelper.ViewInfo)getIntent().getParcelableExtra("key_view_info"));
    String str2 = getIntent().getStringExtra("key_image_url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.vPw = str1;
    this.vPt = getIntent().getIntExtra("key_nine_patch_id", 0);
    this.vPu = getIntent().getLongExtra("key_animate_id", 0L);
    if (dAh() == 38) {
      this.vOR = 2;
    }
    if ((this.vPv != null) && (!Util.isNullOrNil(this.vPw))) {
      this.vPp = true;
    }
    super.onCreate(paramBundle);
    AppMethodBeat.o(252750);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(252751);
    super.onCreateBeforeSetContentView();
    if (this.vPp)
    {
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        setTheme(2131821158);
        AppMethodBeat.o(252751);
        return;
      }
      setTheme(2131821159);
    }
    AppMethodBeat.o(252751);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252773);
    long l;
    int i;
    String str;
    if ((this.sQn != 0) && (!this.vOJ))
    {
      if (this.tVm)
      {
        localObject = com.tencent.mm.plugin.finder.report.k.vfA;
        l = this.feedId;
        i = this.sQn;
        str = this.dRL;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.report.k.a(l, i, 4L, (String)localObject, 0, 2);
        this.vOJ = true;
      }
    }
    else
    {
      dcW().onDetach();
      localObject = FinderReporterUIC.wzC;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = FinderReporterUIC.a.fH((Context)localObject);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dcW());
        }
      }
      dcX().onDetach();
      localObject = FinderReporterUIC.wzC;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = FinderReporterUIC.a.fH((Context)localObject);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dcX());
        }
      }
      localObject = h.veu;
      i = getTabType();
      localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this);
      if (localObject == null) {
        break label327;
      }
    }
    label327:
    for (Object localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      h.e(i, (bbn)localObject);
      localObject = this.vPm;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      super.onDestroy();
      AppMethodBeat.o(252773);
      return;
      com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
      l = this.feedId;
      i = this.sQn;
      str = this.dRL;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localk.a(l, i, (String)localObject, 0, 2);
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252753);
    super.onPause();
    this.vPB.dead();
    if (this.tVm)
    {
      localObject = this.vPm;
      if (localObject != null) {
        ((IListener)localObject).alive();
      }
    }
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    localObject = this.vOP;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    com.tencent.mm.plugin.finder.report.live.k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(252753);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252752);
    super.onResume();
    this.vPB.alive();
    boolean bool;
    int i;
    if (this.tVm)
    {
      localObject = this.vPm;
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
      bool = d(this.vPl);
      Log.i(this.TAG, "isFollowed: " + bool + " followStatus:" + this.vPj);
      if (this.vPk != null)
      {
        i = this.vPj;
        if (i != vPE) {
          break label233;
        }
        if (bool) {
          oz(false);
        }
        this.vPk = null;
      }
      if (this.vPj == vPD) {
        c(this.vPl);
      }
    }
    Object localObject = h.veu;
    h.Km(getTabType());
    switch (getCommentScene())
    {
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject = this.vOP;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      com.tencent.mm.plugin.finder.report.live.k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.vjf);
      AppMethodBeat.o(252752);
      return;
      label233:
      if ((i != vPF) || (bool)) {
        break;
      }
      oz(true);
      break;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.mf(true);
      continue;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.mf(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$Companion;", "", "()V", "FOLLOWED", "", "getFOLLOWED", "()I", "FOLLOW_MENU_ID", "getFOLLOW_MENU_ID", "INIT_FOLLOW", "getINIT_FOLLOW", "UNFOLLOWED", "getUNFOLLOWED", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class aa
    implements View.OnClickListener
  {
    aa(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, z.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252739);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vPI.nK(true);
      ((View)localf.SYG).setVisibility(8);
      FinderShareFeedRelUI.m(this.vPI).requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252739);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<Integer>
  {
    ab(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class ac
    extends IListener<hj>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    c(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Integer>
  {
    e(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f>
  {
    f(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252710);
      FinderShareFeedRelUI.r(this.vPI).setVisibility(8);
      this.vPJ.setAlpha(1.0F);
      FinderShareFeedRelUI.s(this.vPI);
      AppMethodBeat.o(252710);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$1"})
  static final class h
    extends q
    implements kotlin.g.a.m<Integer, String, x>
  {
    h(k paramk, FinderShareFeedRelUI paramFinderShareFeedRelUI, z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$2"})
  static final class i
    extends q
    implements kotlin.g.a.b<FinderObject, x>
  {
    i(k paramk, FinderShareFeedRelUI paramFinderShareFeedRelUI, z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$1"})
  static final class j
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    j(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$2"})
  static final class k
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    k(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252715);
      this.vPI.onBackPressed();
      AppMethodBeat.o(252715);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252718);
      FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
      AppMethodBeat.o(252718);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "visibleRect", "Landroid/graphics/Rect;", "getVisibleRect", "()Landroid/graphics/Rect;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.l
  {
    private float offset;
    private final Rect vPN;
    
    o()
    {
      AppMethodBeat.i(252720);
      this.offset = 100.0F;
      this.vPN = new Rect();
      AppMethodBeat.o(252720);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(252721);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(252721);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = null;
      View localView1 = null;
      AppMethodBeat.i(252719);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramRecyclerView, "recyclerView");
      if (FinderShareFeedRelUI.d(this.vPI).getDataListJustForAdapter().size() >= 2)
      {
        localObject1 = y.vXH;
        if (y.gr(this.vPI.getTabType(), FinderShareFeedRelUI.j(this.vPI))) {
          break label337;
        }
        localObject1 = FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().ch(1);
        if (localObject1 == null) {
          break label325;
        }
        localObject1 = ((RecyclerView.v)localObject1).aus;
        if (localObject1 == null) {
          break label331;
        }
        localObject2 = ((View)localObject1).findViewById(2131301491);
        label148:
        arrayOfInt = new int[2];
        if (localObject2 != null) {
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
        }
        localObject3 = FinderShareFeedRelUI.k(this.vPI);
        if (localObject3 != null) {
          localView1 = ((View)localObject3).findViewById(2131301491);
        }
        localObject3 = new int[2];
        if (localView1 != null) {
          localView1.getLocationOnScreen((int[])localObject3);
        }
        View localView2 = FinderShareFeedRelUI.k(this.vPI);
        if ((localView2 != null) && (localView2.getVisibility() == 0) && (localObject2 != null) && (localView1 != null) && (arrayOfInt[1] <= localObject3[1]))
        {
          localObject2 = FinderShareFeedRelUI.k(this.vPI);
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(8);
          }
          ((View)localObject1).setVisibility(0);
        }
        this.vPI.dAl();
      }
      label325:
      label331:
      label337:
      do
      {
        do
        {
          localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
          com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voB, String.valueOf(this.vPI.getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.vje);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(252719);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label148;
          localObject1 = FinderShareFeedRelUI.k(this.vPI);
        } while ((localObject1 == null) || (((View)localObject1).getVisibility() != 0));
        localView1 = FinderShareFeedRelUI.k(this.vPI);
      } while (localView1 == null);
      paramInt1 = com.tencent.mm.cb.a.fromDPToPix((Context)this.vPI.getContext(), 112);
      Object localObject3 = FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().ch(0);
      if (localObject3 != null)
      {
        localObject1 = ((RecyclerView.v)localObject3).aus;
        if (localObject1 == null) {}
      }
      for (Object localObject2 = ((View)localObject1).findViewById(2131300827);; localObject2 = null)
      {
        localObject1 = arrayOfInt;
        if (localObject3 != null)
        {
          localObject3 = ((RecyclerView.v)localObject3).aus;
          localObject1 = arrayOfInt;
          if (localObject3 != null) {
            localObject1 = ((View)localObject3).findViewById(2131301467);
          }
        }
        this.offset -= paramInt2 / 5.0F;
        this.offset = android.support.v4.b.a.j(this.offset, 100.0F);
        localView1.setAlpha(this.offset / 100.0F);
        if (this.offset > 0.0F) {
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<View, x>
  {
    p(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initFollow$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class q
    extends IListener<hf>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<Integer, bo>
  {
    r(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>>
  {
    s(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252726);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vPI.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252726);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<Integer>
  {
    u(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class v
    implements Animator.AnimatorListener
  {
    v(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252729);
      FinderShareFeedRelUI.n(this.vPI);
      FinderShareFeedRelUI.o(this.vPI).setVisibility(0);
      if (FinderShareFeedRelUI.p(this.vPI)) {
        FinderShareFeedRelUI.b(this.vPI);
      }
      Log.i(this.vPI.TAG, "runEnterAnimation end " + FinderShareFeedRelUI.p(this.vPI));
      AppMethodBeat.o(252729);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(252728);
      Log.i(this.vPI.TAG, "runEnterAnimation start");
      AppMethodBeat.o(252728);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(252730);
      this.vPJ.setVisibility(0);
      AppMethodBeat.o(252730);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class w
    implements ValueAnimator.AnimatorUpdateListener
  {
    w(FinderShareFeedRelUI paramFinderShareFeedRelUI) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(252731);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(252731);
        throw paramValueAnimator;
      }
      if ((((Float)paramValueAnimator).floatValue() > 0.1F) && (FinderShareFeedRelUI.q(this.vPI).getAlpha() < 0.9F)) {
        FinderShareFeedRelUI.q(this.vPI).setAlpha(1.0F);
      }
      AppMethodBeat.o(252731);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class x
    implements Animator.AnimatorListener
  {
    x(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(252735);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(252735);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(252734);
      p.h(paramAnimator, "animation");
      FinderShareFeedRelUI.q(this.vPI).postDelayed((Runnable)new a(this), 220L);
      this.vPI.overridePendingTransition(2130771986, 2130771986);
      Log.i(this.vPI.TAG, "runExitAnimation end");
      AppMethodBeat.o(252734);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(252736);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(252736);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(252733);
      p.h(paramAnimator, "animation");
      paramAnimator = this.vPO;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(0.0F);
      }
      Log.i(this.vPI.TAG, "runExitAnimation start");
      AppMethodBeat.o(252733);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderShareFeedRelUI.x paramx) {}
      
      public final void run()
      {
        AppMethodBeat.i(252732);
        this.vPP.vPI.finish();
        AppMethodBeat.o(252732);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class y
    implements ValueAnimator.AnimatorUpdateListener
  {
    y(FinderShareFeedRelUI paramFinderShareFeedRelUI, AnimationLayout paramAnimationLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(252737);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(252737);
        throw paramValueAnimator;
      }
      ((Float)paramValueAnimator).floatValue();
      FinderShareFeedRelUI.q(this.vPI).m(this.vPQ.GPe);
      FinderShareFeedRelUI.q(this.vPI).invalidate();
      AppMethodBeat.o(252737);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showFollowView$1$1", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "plugin-finder_release"})
  public static final class z
    implements MenuItem.OnMenuItemClickListener
  {
    z(FinderShareFeedRelUI paramFinderShareFeedRelUI, FinderContact paramFinderContact) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252738);
      FinderShareFeedRelUI.l(this.vPI);
      AppMethodBeat.o(252738);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */