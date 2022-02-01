package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.autogen.a.hx;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.if.a;
import com.tencent.mm.autogen.a.iu;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.cg;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.search.data.SearchHotWordListParcelable;
import com.tencent.mm.plugin.finder.search.data.SearchHotWordListParcelable.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.upload.action.l.a;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.EllipsizedTextView;
import com.tencent.mm.plugin.finder.view.FadeOutLinearLayout;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.FlowTextMixView;
import com.tencent.mm.plugin.finder.view.SimpleTouchableLayout;
import com.tencent.mm.plugin.finder.view.SimpleTouchableLayout.b;
import com.tencent.mm.plugin.finder.view.SimpleTouchableLayout.d;
import com.tencent.mm.plugin.finder.view.SimpleTouchableLayout.f;
import com.tencent.mm.plugin.finder.view.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ax;
import com.tencent.mm.plugin.finder.viewmodel.component.ax.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ax.h;
import com.tencent.mm.plugin.finder.viewmodel.component.x;
import com.tencent.mm.plugin.finder.viewmodel.component.y.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.d;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "_2dp", "", "avatarRectControl", "countDown", "displayHeight", "getDisplayHeight", "()I", "displayHeight$delegate", "Lkotlin/Lazy;", "isFromAd", "()Z", "isFromAd$delegate", "isRealNameLike", "isSelfFlag", "isSelfFlag$delegate", "isShowAtTip", "isShowAtTip$delegate", "lastLikeClickTime", "", "lastShareClickTime", "linkColor", "navigationBarHeight", "getNavigationBarHeight", "navigationBarHeight$delegate", "rect", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getSafeMode", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "getTabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1;", "adjustOpLayoutPadding", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "adjustSeekLayout", "bindAwesomeLayout", "position", "calculateMediaLayoutParams", "item", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "canLike", "canShareShow", "checkJumpProfile", "entranceType", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkScrollToNextFeed", "checkShowFollowLayout", "needAnim", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "checkShowFollowLikeLayout", "checkShowShareSnsLayout", "checkTextStatusGuide", "composeSpan", "ssbSpan", "Landroid/text/SpannableStringBuilder;", "campaignSpan", "Landroid/text/SpannableString;", "lastSpan", "convertMedia", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "createShareTipHeader", "Landroid/view/View;", "tipText", "", "createStarFloatIcon", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "source", "formatDesc", "incCount", "suffix", "descTv", "Landroid/widget/TextView;", "getCampaignText", "textView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isWithEllipse", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "getTipsView", "handlePreviewStatus", "hidePrivateLikeTips", "isExistAdFollow", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "isNewsObject", "isOnlyShowDesc", "isShowRealNameRecommendLayout", "jumpBizProfile", "bizUsername", "jumpProfile", "likeAvatarAnimator", "likeCount", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "e", "Landroid/view/MotionEvent;", "likeRefreshSnsAd", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "loadLinkIcon", "adLinkIcon", "Landroid/widget/ImageView;", "adFailLinkIcon", "iconUrl", "onAttachedToRecyclerView", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onClickToShare", "it", "from", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Landroid/view/View;I)V", "onCreateViewHolder", "onDeepEnjoyMedia", "onDetachedFromRecyclerView", "onFocusFeedCenter", "onHafEnjoyMedia", "onMediaClick", "view", "onMediaDoubleClick", "onMediaLongClick", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Landroid/view/View;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "onPostFinished", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "onTenSecEnjoy", "onUnFocusFeedCenter", "isFromScroll", "onVideoPause", "ev", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "onVideoRealPlay", "onViewRecycled", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "blinkDuration", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;IIZJ)V", "optSearchHotWord", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "hotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectHotWordInfo;", "realAdjustSeekLayout", "banner", "seekLayout", "seekBar", "refreshAdDetail", "payloadType", "adItem", "Lcom/tencent/mm/plugin/finder/feed/model/AdSnsCache;", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/plugin/finder/feed/model/AdSnsCache;)V", "refreshAdFollow", "refreshAdJumperViews", "refreshAtFeedTip", "refreshAwesomeIv", "isLike", "isPrivate", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshCommentLayout", "refreshCreationBySameTemplateStatus", "refreshDescContent", "refreshDescPanel", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "refreshFav", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFinderLivingStatusView", "refreshFollowState", "refreshForwardCount", "refreshForwardIcon", "refreshFriendFollowCount", "refreshFullGuideTips", "refreshGuideHotLayout", "refreshHotComment", "refreshHotSearch", "refreshLivingIcon", "refreshMoreBtn", "refreshNewsLayout", "userName", "refreshNickname", "refreshPostProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshPostRecommendLayout", "refreshPrivateIcon", "refreshRead", "refreshRealNameRecommendLayout", "refeshByClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ZI)V", "refreshRecommendLayout", "refreshRingtoneDesc", "refreshSeekbarLayout", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ZZ)V", "refreshSelfScene", "refreshSnsAd", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshStar", "refreshWording", "report21464", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportAdClickAction", "iconType", "id", "clickPosX", "clickPosY", "reportMention", "eventCode", "reportSnsAdBind", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "setGroupLikeIcon", "imageView", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "isFloatIcon", "setLinkIconFail", "adFailIcon", "showAtFeedTip", "isShow", "showSelfFeedLikeTips", "starAnimator", "vibrate", "Companion", "StateListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderFeedFullConvert<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.f<T>
{
  public static final b AIg = new b((byte)0);
  private final com.tencent.mm.plugin.finder.feed.i AIh;
  private long AIi;
  private long AIj;
  private final HashSet<StateListener<T>> AIk;
  private final kotlin.j AIl;
  final kotlin.j AIm;
  private final kotlin.j AIn;
  private final kotlin.j AIo;
  private final kotlin.j AIp;
  private final kotlin.j AIq;
  private final float AIr;
  private final boolean AIs;
  private final boolean AIt;
  private final uiLifecycleObserver.1 AIu;
  final int hJx;
  private final int linkColor;
  RecyclerView mkw;
  private int qaN;
  private Rect rect;
  private boolean safeMode;
  
  public FinderFeedFullConvert(final com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    this.AIh = parami;
    this.safeMode = paramBoolean;
    this.hJx = paramInt;
    this.AIi = -1L;
    this.AIj = -1L;
    this.AIk = new HashSet();
    this.AIl = kotlin.k.cm((kotlin.g.a.a)FinderFeedFullConvert.e.AIE);
    this.AIm = kotlin.k.cm((kotlin.g.a.a)FinderFeedFullConvert.i.AIF);
    this.AIn = kotlin.k.cm((kotlin.g.a.a)new ac(this));
    this.AIo = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.AIp = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new g(this));
    parami = this.AIh.getActivity();
    if (parami != null)
    {
      parami = parami.getContext();
      if (parami != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject = as.a.hu((Context)parami);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).Vm(this.hJx);
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)new a(this, parami));
          }
        }
      }
    }
    this.linkColor = Color.parseColor("#DEE9FF");
    this.AIr = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2.0F);
    this.rect = new Rect();
    parami = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eRV().bmg()).intValue() == 1)
    {
      paramBoolean = true;
      this.AIs = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eRW().bmg()).intValue() != 1) {
        break label333;
      }
    }
    label333:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.AIt = paramBoolean;
      this.AIu = new com.tencent.mm.plugin.finder.life.b()
      {
        public final void onCreate(q paramAnonymousq)
        {
          AppMethodBeat.i(350160);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          AppMethodBeat.o(350160);
        }
        
        public final void onDestroy(q paramAnonymousq)
        {
          AppMethodBeat.i(350181);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          paramAnonymousq = ((Iterable)FinderFeedFullConvert.d(this.AIw)).iterator();
          while (paramAnonymousq.hasNext()) {
            ((FinderFeedFullConvert.StateListener)paramAnonymousq.next()).dead();
          }
          FinderFeedFullConvert.d(this.AIw).clear();
          AppMethodBeat.o(350181);
        }
        
        public final void onPause(q paramAnonymousq)
        {
          AppMethodBeat.i(350175);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          AppMethodBeat.o(350175);
        }
        
        public final void onResume(q paramAnonymousq)
        {
          AppMethodBeat.i(350171);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          AppMethodBeat.o(350171);
        }
        
        public final void onStart(q paramAnonymousq)
        {
          AppMethodBeat.i(350166);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          AppMethodBeat.o(350166);
        }
        
        public final void onStop(q paramAnonymousq)
        {
          AppMethodBeat.i(350176);
          kotlin.g.b.s.u(paramAnonymousq, "var1");
          AppMethodBeat.o(350176);
        }
      };
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final int a(boolean paramBoolean1, boolean paramBoolean2, BaseFinderFeed paramBaseFinderFeed)
  {
    if (this.AIh.ebw())
    {
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1) {
        return e.g.finder_outlined_like_private;
      }
      return e.g.finder_filled_like_private;
    }
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.n(paramBaseFinderFeed.contact))
    {
      if (paramBoolean1) {
        return e.g.finder_filled_like_lock;
      }
      return e.g.finder_outlined_like_lock;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return e.g.finder_filled_like_lock;
      }
      return e.g.finder_full_like;
    }
    return e.g.finder_full_like_outlined;
  }
  
  private static final Map a(BaseFinderFeed paramBaseFinderFeed, String paramString)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramString = com.tencent.mm.plugin.finder.upload.action.c.GcH;
    if (com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {}
    for (paramBaseFinderFeed = "fav";; paramBaseFinderFeed = "unfav") {
      return kotlin.a.ak.l(kotlin.v.Y("action_type", paramBaseFinderFeed));
    }
  }
  
  private static final void a(View paramView, com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramView, "$it");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView.setTag(Boolean.FALSE);
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    paramView = as.a.hu(paramView);
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.fou())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
      z localz = z.FrZ;
      z.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", paramView, 0L, null, 96);
      paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      paramView = (emx)a.a.c(paramView, 14, emx.class);
      if (paramView != null)
      {
        paramView.lsO = 1;
        paramView.Qmp = ((int)(SystemClock.elapsedRealtime() - paramView.startTime));
        paramView.scene = 1;
      }
      paramView = com.tencent.mm.pluginsdk.j.a.XUW;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      com.tencent.mm.pluginsdk.j.a.ly(paramView);
      paramView = an.GhR;
      an.a.TX(0);
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      paramView = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramView).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramView != null) {
        paramView.O(paramj);
      }
      return;
    }
  }
  
  private static final void a(View paramView, com.tencent.mm.view.recyclerview.j paramj, int paramInt1, int paramInt2, FinderFeedFullConvert paramFinderFeedFullConvert)
  {
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    int i = paramView.getHeight();
    paramInt1 = KeyBoardUtil.getKeyBordHeightPx(paramj.context) - paramInt1 + i;
    Log.i("Finder.FeedFullConvert", "[openCommentDrawer] offset=" + paramInt1 + " itemBottom=" + paramInt2 + " recyclerViewBottom=" + paramFinderFeedFullConvert.rect.bottom + " editLayoutHeight=" + i);
    if (paramInt1 > 0)
    {
      paramView = paramFinderFeedFullConvert.AIh.getVideoCore().GpZ;
      if (paramView != null) {
        FinderVideoAutoPlayManager.a(paramView, "openCommentDrawer", true);
      }
      paramj.getRecyclerView().br(0, paramInt1);
    }
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramView = paramFinderFeedFullConvert.AIh.getActivity();
    if (paramView != null)
    {
      paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eXD()) {
        break label116;
      }
    }
    label116:
    for (paramFinderFeedFullConvert = ".ui.FinderHomeAffinityUI";; paramFinderFeedFullConvert = ".ui.FinderHomeUI")
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.k((Activity)paramView, paramFinderFeedFullConvert);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    if (paramBaseFinderFeed.feedObject.getId() != 0L)
    {
      paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      if (com.tencent.mm.plugin.finder.storage.logic.d.a.qs(paramBaseFinderFeed.feedObject.getId()))
      {
        paramFinderFeedFullConvert = new hy();
        paramFinderFeedFullConvert.hJo.id = paramBaseFinderFeed.feedObject.getId();
        paramFinderFeedFullConvert.publish();
        Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("deleteItem by id ", Long.valueOf(paramBaseFinderFeed.feedObject.getId())));
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      if (paramBaseFinderFeed.feedObject.getLocalId() >= 0L)
      {
        paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(paramBaseFinderFeed.feedObject.getLocalId());
        paramView = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        if (com.tencent.mm.plugin.finder.storage.logic.d.a.qu(paramBaseFinderFeed.feedObject.getLocalId()))
        {
          ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishStatApi().tl(paramBaseFinderFeed.feedObject.isLongVideo());
          if (paramFinderFeedFullConvert != null)
          {
            paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.report.v.FrN;
            com.tencent.mm.plugin.finder.report.v.i(paramBaseFinderFeed.feedObject);
          }
          if (paramBaseFinderFeed.feedObject.isLongVideo()) {
            ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishStatApi().eLb();
          }
          paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
          com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOm(), paramBaseFinderFeed.feedObject);
          paramFinderFeedFullConvert = new hy();
          paramFinderFeedFullConvert.hJo.localId = paramBaseFinderFeed.feedObject.getLocalId();
          paramFinderFeedFullConvert.publish();
          Log.i("Finder.FeedFullConvert", "deleteItem by localId " + paramBaseFinderFeed.feedObject.getLocalId() + ", posting:true");
        }
      }
    }
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    if (a(paramBaseFinderFeed)) {
      a(paramFinderFeedFullConvert, paramj, paramBaseFinderFeed, false, 0L, 0, 4, paramFinderFeedFullConvert.dXz(), 0L, 312);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.ui.base.s params)
  {
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    if (params.jmw())
    {
      kotlin.g.b.s.s(paramBaseFinderFeed, "item");
      if (!b(paramBaseFinderFeed)) {
        break label62;
      }
    }
    label62:
    for (paramFinderFeedFullConvert = paramj.context.getResources().getString(e.h.finder_awesome_ground_title_news);; paramFinderFeedFullConvert = paramj.context.getResources().getString(e.h.finder_awesome_ground_title))
    {
      params.c(10003, (CharSequence)paramFinderFeedFullConvert);
      return;
    }
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    if (paramMenuItem.getItemId() == 10003) {
      paramFinderFeedFullConvert.a(paramj, 1, true, null);
    }
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    a(paramj, 5);
    if (paramj.KJ() == 0)
    {
      paramFinderFeedFullConvert = com.tencent.mm.ui.component.k.aeZF;
      paramFinderFeedFullConvert = paramj.context;
      kotlin.g.b.s.s(paramFinderFeedFullConvert, "holder.context");
      paramFinderFeedFullConvert = ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq(paramFinderFeedFullConvert).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).FYa;
      if (paramFinderFeedFullConvert != null)
      {
        paramFinderFeedFullConvert.fdb();
        paramFinderFeedFullConvert.aBh("headimage");
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    localObject = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject);
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    com.tencent.mm.plugin.finder.storage.d.Tl(2);
    a(paramFinderFeedFullConvert, paramj, paramBaseFinderFeed, true, 0L, ((Rect)localObject).top - com.tencent.mm.view.d.e(paramj.context, 16.0F), paramInt, false, 0L, 408);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    a(paramFinderFeedFullConvert, paramj, paramBaseFinderFeed, false, 0L, 0, 0, paramFinderFeedFullConvert.dXz(), 0L, 376);
    if (paramj.KJ() == 0)
    {
      paramFinderFeedFullConvert = com.tencent.mm.ui.component.k.aeZF;
      paramFinderFeedFullConvert = paramj.context;
      kotlin.g.b.s.s(paramFinderFeedFullConvert, "holder.context");
      paramFinderFeedFullConvert = ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq(paramFinderFeedFullConvert).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).FYa;
      if (paramFinderFeedFullConvert != null)
      {
        paramFinderFeedFullConvert.fdb();
        paramFinderFeedFullConvert.aBh("comment");
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, FinderMediaBanner paramFinderMediaBanner, View paramView1, View paramView2)
  {
    int j = 0;
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderMediaBanner, "$banner");
    kotlin.g.b.s.u(paramView1, "$seekLayout");
    kotlin.g.b.s.u(paramView2, "$seekBar");
    View localView1 = (View)paramFinderMediaBanner;
    paramFinderFeedFullConvert = paramj.UH(e.e.footer_op_layout);
    Object localObject;
    View localView2;
    int m;
    if (paramFinderFeedFullConvert != null)
    {
      localObject = (ViewGroup)paramj.UH(e.e.finder_feed_full_footer_layout);
      if (localObject != null)
      {
        localView2 = paramj.UH(e.e.finder_feed_wording_attribute_layout);
        if (localView2 != null)
        {
          m = ((ViewGroup)localObject).getChildCount();
          if (m <= 0) {}
        }
      }
    }
    int k;
    label143:
    label333:
    label343:
    label476:
    for (int i = 0;; i = k)
    {
      k = i + 1;
      paramFinderMediaBanner = ((ViewGroup)localObject).getChildAt(i);
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if (paramFinderMediaBanner.getVisibility() == 0) {
        if (paramFinderMediaBanner.getAlpha() == 0.0F)
        {
          i = 1;
          if (i != 0) {
            break label333;
          }
          paramFinderFeedFullConvert = paramFinderMediaBanner;
          localObject = new int[2];
          paramFinderMediaBanner = new int[2];
          arrayOfInt1 = new int[2];
          arrayOfInt2 = new int[2];
          paramj.caK.getLocationInWindow((int[])localObject);
          localView1.getLocationInWindow(paramFinderMediaBanner);
          paramFinderMediaBanner[0] -= localObject[0];
          paramFinderMediaBanner[1] -= localObject[1];
          paramFinderFeedFullConvert.getLocationInWindow(arrayOfInt1);
          arrayOfInt1[0] -= localObject[0];
          arrayOfInt1[1] -= localObject[1];
          localView2.getLocationInWindow(arrayOfInt2);
          arrayOfInt2[0] -= localObject[0];
          arrayOfInt2[1] -= localObject[1];
          if (localView2.getVisibility() != 0) {
            break label343;
          }
          i = j;
          if (localView2.getAlpha() == 0.0F) {
            i = 1;
          }
          if (i != 0) {
            break label343;
          }
        }
      }
      for (i = Math.min(arrayOfInt1[1], arrayOfInt2[1]);; i = arrayOfInt1[1])
      {
        paramFinderFeedFullConvert = paramView1.getLayoutParams();
        if (paramFinderFeedFullConvert != null) {
          break label352;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        i = 0;
        break;
        if (k < m) {
          break label476;
        }
        break label143;
      }
      label352:
      paramFinderFeedFullConvert = (FrameLayout.LayoutParams)paramFinderFeedFullConvert;
      j = paramFinderFeedFullConvert.topMargin;
      k = paramView2.getHeight();
      m = paramView1.getHeight();
      if (paramFinderMediaBanner[1] + localView1.getHeight() + paramView1.getHeight() > i) {
        k = (int)paramj.context.getResources().getDimension(e.c.Edge_A);
      }
      for (paramFinderFeedFullConvert.topMargin = (i - paramView1.getHeight() - k);; paramFinderFeedFullConvert.topMargin = ((int)paramj.context.getResources().getDimension(e.c.Edge_1_5_A) + (paramFinderMediaBanner[1] + localView1.getHeight() - (m - k))))
      {
        if (paramFinderFeedFullConvert.topMargin != j) {
          paramView1.requestLayout();
        }
        return;
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, FinderFeedFullConvert paramFinderFeedFullConvert, BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramBaseFinderFeed);
    localb.sc(paramInt);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    Log.i("Finder.FeedFullConvert", "refreshAdDetail onClick");
    if (paramb != null)
    {
      a(2, paramBaseFinderFeed.feedObject.getId(), paramInt, paramj);
      paramFinderFeedFullConvert = ((com.tencent.mm.plugin.sns.c.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.e.class)).aWg(paramb.uxInfo);
      ((com.tencent.mm.plugin.sns.c.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.e.class)).a(paramb.Bev, paramFinderFeedFullConvert, "", 30);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static void a(T paramT, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 10)
    {
      iu localiu = new iu();
      localiu.hKq.feedId = paramT.feedObject.getId();
      localiu.hKq.position = paramInt1;
      localiu.hKq.actionType = 40001;
      localiu.publish();
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().fy(paramBaseFinderFeed.feedObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final void a(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    int j = 0;
    Object localObject1 = (EllipsizedTextView)paramj.caK.findViewById(e.e.nickname);
    ((EllipsizedTextView)localObject1).setText((CharSequence)paramT.feedObject.getNickNameSpan());
    Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.y.GQb;
    y.a.X(paramj);
    localObject2 = paramj.UH(e.e.little_follow_tv);
    Object localObject3 = paramj.UH(e.e.finder_living_icon);
    int k = (int)paramj.context.getResources().getDimension(e.c.Edge_3A);
    int i;
    if (((View)localObject2).getVisibility() == 0)
    {
      i = k + (int)paramj.context.getResources().getDimension(e.c.Edge_3A);
      ((EllipsizedTextView)localObject1).setExtraEllipsizeWidth(i);
      localObject2 = paramT.contact;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.finder.utils.av.GiL;
        localObject3 = paramj.UH(e.e.auth_icon);
        kotlin.g.b.s.s(localObject3, "holder.getView(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.av.a((ImageView)localObject3, ((m)localObject2).field_authInfo, 0, com.tencent.mm.plugin.finder.api.c.a((m)localObject2, false), 4);
      }
      ((EllipsizedTextView)localObject1).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda15(paramj, this));
      localObject1 = paramT.contact;
      if (localObject1 != null) {
        break label290;
      }
      i = 0;
      label189:
      paramj = (ViewGroup)paramj.caK.findViewById(e.e.feed_header_content);
      if (paramj != null)
      {
        paramj.setTag(e.e.finder_accessibility_nickname_tag, paramT.feedObject.getNickNameSpan());
        k = e.e.finder_accessibility_auth_icon_type_tag;
        paramT = paramT.contact;
        if (paramT != null) {
          break label299;
        }
      }
    }
    for (;;)
    {
      paramj.setTag(k, Integer.valueOf(j));
      paramj.setTag(e.e.finder_accessibility_follow_count_tag, Integer.valueOf(i));
      return;
      i = k;
      if (((View)localObject3).getVisibility() != 0) {
        break;
      }
      i = k + (int)paramj.context.getResources().getDimension(e.c.Edge_5A);
      break;
      label290:
      i = ((m)localObject1).field_friendFollowCount;
      break label189;
      label299:
      paramT = paramT.field_authInfo;
      if (paramT != null) {
        j = paramT.authIconType;
      }
    }
  }
  
  private final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    Object localObject4 = (TextView)paramj.UH(e.e.like_count_tv);
    Object localObject5 = (LinearLayout)paramj.UH(e.e.awesome_icon_container);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    boolean bool2 = com.tencent.mm.plugin.finder.utils.aw.n(paramBaseFinderFeed.contact);
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
    Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.h.TA(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
    label153:
    label248:
    boolean bool1;
    if (this.AIh.ebw())
    {
      com.tencent.mm.ui.aw.e((Paint)((TextView)localObject4).getPaint());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject1 = com.tencent.mm.plugin.finder.utils.r.TR(com.tencent.mm.plugin.finder.upload.action.l.fek().v(paramBaseFinderFeed.feedObject.getFeedObject()));
      kotlin.g.b.s.s(localObject1, "formatPosterOpNumberNew(…m.feedObject.feedObject))");
      if (localObject5 != null) {
        ((LinearLayout)localObject5).setTag(e.e.finder_accessibility_like_count_tag, localObject1);
      }
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (paramBoolean1)
      {
        if (!(paramBaseFinderFeed instanceof BaseFinderFeed)) {
          break label546;
        }
        localObject1 = paramBaseFinderFeed;
        f(paramj, (BaseFinderFeed)localObject1);
      }
      localObject1 = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
      if (localObject1 != null) {
        ((FinderFullSeekBarLayout)localObject1).AUZ = paramBaseFinderFeed;
      }
      if (paramBaseFinderFeed.isDeepEnjoy)
      {
        localObject1 = paramj.CSA;
        kotlin.g.b.s.s(localObject1, "holder.getAssociatedObject()");
        b(paramj, (BaseFinderFeed)localObject1);
      }
      localObject4 = (WeImageView)paramj.UH(e.e.icon_feed_like);
      if (!paramBoolean1) {
        break label564;
      }
      if (!paramBoolean2) {
        break label552;
      }
      ((WeImageView)localObject4).setTag(Integer.valueOf(2));
      localObject1 = paramj.context.getResources();
      bool1 = paramBoolean2;
      label261:
      localObject1 = com.tencent.mm.svg.a.a.i((Resources)localObject1, a(true, bool1, paramBaseFinderFeed));
      if ((!paramBoolean2) || (!paramBoolean1) || (bool2)) {
        break label669;
      }
      ((WeImageView)localObject4).setLayerPaint(null);
      ((WeImageView)localObject4).setIconColor(0);
      kotlin.g.b.s.s(localObject4, "awesomeIv");
      a((WeImageView)localObject4, (brk)localObject3, false);
    }
    for (;;)
    {
      if (paramBaseFinderFeed.isPreview) {
        ((WeImageView)localObject4).setIconColor(com.tencent.mm.cd.a.w(paramj.context, com.tencent.mm.plugin.finder.e.b.finder_btn_fullscreen_disable_color));
      }
      return;
      if (paramInt > 0)
      {
        if (!this.AIh.ebw()) {}
        for (int i = 2;; i = 1)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.r.ip(i, paramInt);
          kotlin.g.b.s.s(localObject1, "formatNumber(\n          …keCount\n                )");
          if (localObject5 != null) {
            ((LinearLayout)localObject5).setTag(e.e.finder_accessibility_like_count_tag, localObject1);
          }
          com.tencent.mm.ui.aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          break;
        }
      }
      if (localObject3 != null)
      {
        localObject1 = (CharSequence)((brk)localObject3).ZZB;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          paramInt = 1;
          label460:
          if (paramInt == 0) {
            break label522;
          }
        }
      }
      else
      {
        localObject1 = paramj.context.getString(e.h.finder_like_count_text);
        kotlin.g.b.s.s(localObject1, "{\n                    ho…t_text)\n                }");
      }
      for (;;)
      {
        if (localObject5 != null) {
          ((LinearLayout)localObject5).setTag(e.e.finder_accessibility_like_count_tag, "0");
        }
        com.tencent.mm.ui.aw.e((Paint)((TextView)localObject4).getPaint());
        break;
        paramInt = 0;
        break label460;
        label522:
        localObject2 = ((brk)localObject3).ZZB;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label546:
      localObject1 = null;
      break label153;
      label552:
      ((WeImageView)localObject4).setTag(Integer.valueOf(1));
      break label248;
      label564:
      ((WeImageView)localObject4).setTag(Integer.valueOf(0));
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1)
      {
        localObject1 = paramj.context.getResources();
        if ((paramBoolean2) && (paramBoolean1)) {}
        for (bool1 = true;; bool1 = false)
        {
          localObject1 = com.tencent.mm.svg.a.a.i((Resources)localObject1, a(false, bool1, paramBaseFinderFeed));
          break;
        }
      }
      localObject1 = paramj.context.getResources();
      if ((paramBoolean2) && (paramBoolean1))
      {
        bool1 = true;
        break label261;
      }
      bool1 = false;
      break label261;
      label669:
      if ((localObject3 == null) || (bool2) || (paramBoolean2) || (this.AIh.ebw())) {
        break label888;
      }
      if (paramBoolean1)
      {
        localObject2 = ((brk)localObject3).ZZx;
        label706:
        ((WeImageView)localObject4).setLayerPaint(null);
        ((WeImageView)localObject4).setIconColor(0);
        localObject3 = (CharSequence)localObject2;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label791;
        }
        paramInt = 1;
        label743:
        if (paramInt == 0) {
          break label819;
        }
        if (paramBoolean1) {
          break label797;
        }
        ((WeImageView)localObject4).setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
      }
      for (;;)
      {
        ((WeImageView)localObject4).setImageDrawable((Drawable)localObject1);
        break;
        localObject2 = ((brk)localObject3).ZZE;
        break label706;
        label791:
        paramInt = 0;
        break label743;
        label797:
        ((WeImageView)localObject4).setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
      }
      label819:
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExY);
      ((com.tencent.mm.loader.b.e)localObject1).noM = e.d.finder_filled_hot_like_white_small;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().a(new com.tencent.mm.plugin.finder.loader.s((String)localObject2, com.tencent.mm.plugin.finder.storage.v.FKY), (com.tencent.mm.loader.b.e)localObject1);
      kotlin.g.b.s.s(localObject4, "awesomeIv");
      ((com.tencent.mm.loader.a.b)localObject1).d((ImageView)localObject4);
    }
    label888:
    ((WeImageView)localObject4).setLayerPaint(null);
    ((WeImageView)localObject4).setIconColor(0);
    if (localObject3 == null)
    {
      localObject2 = null;
      label908:
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label1010;
      }
      paramInt = 1;
      label933:
      if ((paramInt == 0) && (!this.AIh.ebw()) && (!bool2)) {
        break label1038;
      }
      if ((paramBoolean1) && (!this.AIh.ebw())) {
        break label1016;
      }
      ((WeImageView)localObject4).setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
    }
    for (;;)
    {
      ((WeImageView)localObject4).setImageDrawable((Drawable)localObject1);
      break;
      localObject2 = ((brk)localObject3).ZZE;
      break label908;
      label1010:
      paramInt = 0;
      break label933;
      label1016:
      ((WeImageView)localObject4).setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
    }
    label1038:
    localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExY);
    ((com.tencent.mm.loader.b.e)localObject2).noM = e.d.finder_filled_hot_like_white_small;
    localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject5 = com.tencent.mm.plugin.finder.loader.p.eCl();
    if (localObject3 == null) {}
    for (localObject1 = null;; localObject1 = ((brk)localObject3).ZZE)
    {
      localObject1 = ((com.tencent.mm.loader.d)localObject5).a(new com.tencent.mm.plugin.finder.loader.s((String)localObject1, com.tencent.mm.plugin.finder.storage.v.FKY), (com.tencent.mm.loader.b.e)localObject2);
      kotlin.g.b.s.s(localObject4, "awesomeIv");
      ((com.tencent.mm.loader.a.b)localObject1).d((ImageView)localObject4);
      break;
    }
  }
  
  private static final void a(brm parambrm, FinderItem paramFinderItem, FinderFeedFullConvert paramFinderFeedFullConvert, String paramString, com.tencent.mm.view.recyclerview.j paramj, View paramView1, View paramView2)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambrm);
    localb.cH(paramFinderItem);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramString);
    localb.cH(paramj);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambrm, "$this_apply");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramView1, "$this_apply$1");
    long l1 = 0L;
    long l2;
    label242:
    long l3;
    if (parambrm.ZZL > 0)
    {
      l2 = 1L;
      paramView2 = new Intent();
      paramView2.putExtra("key_topic_type", parambrm.ZZK);
      paramView2.putExtra("key_topic_title", parambrm.xUk);
      paramView2.putExtra("KEY_TOPIC_ID", parambrm.ADo);
      paramView1 = parambrm.ZZM;
      if (paramView1 != null) {
        paramView2.putExtra("KEY_HOT_TOPIC_BUFFER", paramView1.Op);
      }
      paramView2.putExtra("key_hot_topic_type", parambrm.ZZK);
      if (paramFinderItem == null)
      {
        paramView1 = null;
        paramView2.putExtra("KEY_CLICK_FEED_ID", (Serializable)paramView1);
        if (paramFinderItem != null) {
          break label452;
        }
        paramView1 = null;
        paramView2.putExtra("key_ref_object_id", (Serializable)paramView1);
        paramView2.putExtra("KEY_TAB_TYPE", paramFinderFeedFullConvert.hJx);
        paramFinderFeedFullConvert = paramString;
        if (paramString == null) {
          paramFinderFeedFullConvert = "";
        }
        paramView2.putExtra("key_from_user", paramFinderFeedFullConvert);
        paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramFinderFeedFullConvert = paramj.context;
        kotlin.g.b.s.s(paramFinderFeedFullConvert, "holder.context");
        as.a.a(paramFinderFeedFullConvert, paramView2, 0L, 0, false, 124);
        paramFinderFeedFullConvert = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramString = paramj.context;
        kotlin.g.b.s.s(paramString, "holder.context");
        paramFinderFeedFullConvert.n(paramString, paramView2);
        label341:
        paramFinderFeedFullConvert = z.FrZ;
        if (paramFinderItem != null) {
          break label527;
        }
        l1 = 0L;
        label352:
        l3 = parambrm.ADo;
        paramFinderItem = parambrm.xUk;
        parambrm = paramFinderItem;
        if (paramFinderItem == null) {
          parambrm = "";
        }
        paramFinderItem = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramFinderItem = paramj.context;
        kotlin.g.b.s.s(paramFinderItem, "holder.context");
        paramFinderItem = as.a.hu(paramFinderItem);
        if (paramFinderItem != null) {
          break label551;
        }
      }
    }
    label527:
    label551:
    for (int i = 0;; i = paramFinderItem.AJo)
    {
      z.a(l1, 2L, l3, parambrm, l2, i);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      paramView1 = Long.valueOf(paramFinderItem.getId());
      break;
      label452:
      paramView1 = Long.valueOf(paramFinderItem.getId());
      break label242;
      paramString = paramj.CSA;
      kotlin.g.b.s.s(paramString, "holder.getAssociatedObject()");
      boolean bool = paramFinderFeedFullConvert.c((BaseFinderFeed)paramString);
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("[refreshNewsLayout] hot news not support jump! isShowRealNameRecommendLayout=", Boolean.valueOf(bool)));
      l2 = l1;
      if (!bool) {
        break label341;
      }
      paramView1.setVisibility(8);
      l2 = l1;
      break label341;
      paramFinderItem = paramFinderItem.getFeedObject();
      if (paramFinderItem == null)
      {
        l1 = 0L;
        break label352;
      }
      l1 = paramFinderItem.id;
      break label352;
    }
  }
  
  private static final void a(byy parambyy, com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.mj_template.api.d paramd, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambyy);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderFeedFullConvert);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    if (parambyy == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    paramView = com.tencent.mm.plugin.finder.report.bb.FuK;
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramj = paramj.context;
    kotlin.g.b.s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    int i;
    if (paramj == null)
    {
      paramj = null;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("templateId", parambyy.id);
      localObject1 = parambyy.id;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((JSONObject)localObject2).put("shooting_templateid", paramView);
      paramView = ah.aiuX;
      com.tencent.mm.plugin.finder.report.bb.a(paramj, "shoot_same_video", true, (JSONObject)localObject2);
      paramFinderFeedFullConvert = paramFinderFeedFullConvert.AIh.getActivity();
      if (paramFinderFeedFullConvert != null) {
        switch (parambyy.type)
        {
        default: 
          i = -1;
        }
      }
    }
    for (;;)
    {
      paramj = (Activity)paramFinderFeedFullConvert;
      paramFinderFeedFullConvert = paramFinderFeedFullConvert.getIntent();
      paramFinderFeedFullConvert.putExtra("key_maas_entrance", 4);
      paramView = ah.aiuX;
      kotlin.g.b.s.s(paramFinderFeedFullConvert, "activity.intent.apply {\n…ED)\n                    }");
      paramd.creationBySameTemplate(paramj, parambyy, paramFinderFeedFullConvert, i);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      paramj = paramj.fou();
      break;
      i = 15;
      continue;
      i = 12;
    }
  }
  
  private final void a(WeImageView paramWeImageView, brk parambrk, boolean paramBoolean)
  {
    if (parambrk == null)
    {
      parambrk = null;
      localObject = (CharSequence)parambrk;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label111;
      }
    }
    label111:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label117;
      }
      int j = e.g.icons_filled_like_group;
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.AIh.ebw()) {
          i = e.g.finder_filled_like_private;
        }
      }
      paramWeImageView.setImageDrawable(com.tencent.mm.svg.a.a.i(paramWeImageView.getContext().getResources(), i));
      paramWeImageView.setIconColor(paramWeImageView.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
      return;
      parambrk = parambrk.ZZC;
      break;
    }
    label117:
    Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
    parambrk = new com.tencent.mm.plugin.finder.loader.s(parambrk, com.tencent.mm.plugin.finder.storage.v.FKY);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(parambrk, paramWeImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
  }
  
  private static void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = (BaseFinderFeed)paramj.CSA;
    Object localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject3 = paramj.context;
    kotlin.g.b.s.s(localObject3, "holder.context");
    localObject3 = as.a.hu((Context)localObject3);
    if (localObject3 == null) {
      i = 0;
    }
    while (((i == 1) && (((BaseFinderFeed)localObject1).feedObject.getBizInfo() == null)) || (i == 8) || (i == 120))
    {
      Log.i("Finder.FeedFullConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
      paramj = paramj.context;
      if (paramj == null)
      {
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject3).AJo;
      }
      else
      {
        ((Activity)paramj).finish();
        return;
      }
    }
    localObject1 = ((BaseFinderFeed)localObject1).feedObject.getBizInfo();
    if (localObject1 == null)
    {
      localObject1 = null;
      label131:
      if (localObject1 != null) {
        break label459;
      }
      localObject3 = (BaseFinderFeed)paramj.CSA;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = paramj.context;
      kotlin.g.b.s.s(localObject1, "holder.context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null) {
        break label817;
      }
    }
    Object localObject4;
    label817:
    for (int i = 0;; i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).AJo)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", ((BaseFinderFeed)localObject3).feedObject.getUserName());
      ((Intent)localObject1).putExtra("finder_read_feed_id", ((BaseFinderFeed)localObject3).feedObject.getId());
      if ((!(paramj.context instanceof FinderShareFeedRelUI)) && (!(paramj.context instanceof FinderShareFeedDetailUI)) && (!(paramj.context instanceof FinderMsgFeedDetailUI))) {
        ((Intent)localObject1).putExtra("KEY_FROM_TIMELINE", true);
      }
      ((Intent)localObject1).putExtra("key_entrance_type", paramInt);
      localObject4 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject4 = paramj.context;
      kotlin.g.b.s.s(localObject4, "holder.context");
      as.a.a((Context)localObject4, (Intent)localObject1, ((BaseFinderFeed)localObject3).bZA(), 1, false, 64);
      localObject4 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      kotlin.g.b.s.s(localObject3, "item");
      ((ce)localObject4).a((BaseFinderFeed)localObject3, paramj.KJ(), String.valueOf(i));
      localObject4 = com.tencent.mm.plugin.finder.utils.a.GfO;
      Object localObject5 = paramj.context;
      kotlin.g.b.s.s(localObject5, "holder.context");
      ((com.tencent.mm.plugin.finder.utils.a)localObject4).enterFinderProfileUI((Context)localObject5, (Intent)localObject1);
      if (!(paramj.context instanceof MMActivity)) {
        break label909;
      }
      localObject1 = z.FrZ;
      z.a(paramj, ((BaseFinderFeed)localObject3).bZA(), ((BaseFinderFeed)localObject3).feedObject);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = paramj.context;
      if (localObject1 != null) {
        break label825;
      }
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      localObject3 = ((pu)localObject1).ADE;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (((CharSequence)localObject1).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label466;
        }
        Log.e("Finder.FeedFullConvert", "jumpBizProfile: biz username is null");
        localObject1 = ah.aiuX;
        break label131;
        label459:
        break;
      }
      label466:
      localObject3 = (BaseFinderFeed)paramj.CSA;
      localObject4 = new Intent();
      localObject5 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject5 = paramj.context;
      kotlin.g.b.s.s(localObject5, "holder.context");
      as.a.a((Context)localObject5, (Intent)localObject4, ((BaseFinderFeed)localObject3).bZA(), 1, false, 64);
      ((Intent)localObject4).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject4).putExtra("Contact_Scene", 213);
      ((Intent)localObject4).putExtra("biz_profile_enter_from_finder", true);
      ((Intent)localObject4).putExtra("force_get_contact", true);
      ((Intent)localObject4).putExtra("key_use_new_contact_profile", true);
      ((Intent)localObject4).putExtra("finder_feed_id", ((BaseFinderFeed)localObject3).bZA());
      ((Intent)localObject4).putExtra("biz_profile_tab_type", 1);
      ((Intent)localObject4).putExtra("Contact_Scene_Note", ((BaseFinderFeed)localObject3).feedObject.getFeedObject().sessionBuffer);
      com.tencent.mm.br.c.b(paramj.context, "profile", ".ui.ContactInfoUI", (Intent)localObject4);
      if ((paramj.context instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramj.context;
        if (localObject1 == null) {
          throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(holder.co…rReporterUIC::class.java)");
        localObject1 = ((bn)localObject1).foy();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).dYj().nd(((BaseFinderFeed)localObject3).bZA());
        }
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("finderusername", ((BaseFinderFeed)localObject3).feedObject.getUserName());
      localObject3 = z.FrZ;
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "kvJson.toString()");
      localObject3 = kotlin.n.n.bV((String)localObject1, ",", ";");
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = paramj.context;
      kotlin.g.b.s.s(localObject1, "holder.context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou())
      {
        z.b(1, "link_avatar_profile", (String)localObject3, (bui)localObject1);
        break;
      }
    }
    label825:
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(holder.co…rReporterUIC::class.java)");
    localObject1 = ((bn)localObject1).foy();
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.a)localObject1).dYj().nd(((BaseFinderFeed)localObject3).bZA());
      localObject4 = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      if (paramj == null)
      {
        localObject1 = null;
        ((com.tencent.mm.plugin.datareport.a.b)localObject4).a("view_clk", localObject1, null, 24617);
      }
    }
    else
    {
      label909:
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("finderusername", ((BaseFinderFeed)localObject3).feedObject.getUserName());
      localObject3 = z.FrZ;
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "kvJson.toString()");
      localObject1 = kotlin.n.n.bV((String)localObject1, ",", ";");
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label1014;
      }
    }
    label1014:
    for (paramj = localObject2;; paramj = paramj.fou())
    {
      z.b(1, "link_avatar_profile", (String)localObject1, paramj);
      return;
      localObject1 = (ImageView)paramj.UH(e.e.avatar_iv);
      break;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt1, T paramT, int paramInt2)
  {
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = paramj.context;
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    com.tencent.mm.plugin.findersdk.a.as localas = ((com.tencent.mm.plugin.findersdk.a.ar)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).cq(com.tencent.mm.plugin.findersdk.a.ar.class)).eiJ();
    localObject = localas.nE(paramT.feedObject.getId());
    if ((localObject instanceof com.tencent.mm.plugin.finder.feed.model.b)) {}
    for (localObject = (com.tencent.mm.plugin.finder.feed.model.b)localObject;; localObject = null)
    {
      g localg = g.GfZ;
      if ((!g.io(paramT.feedObject.getFeedObject().adFlag, 2)) && (localObject != null)) {
        localas.nF(paramT.feedObject.getId());
      }
      a(paramj, paramInt1, paramT, paramInt2, (com.tencent.mm.plugin.finder.feed.model.b)localObject);
      b(paramj, paramInt1, paramT, paramInt2, (com.tencent.mm.plugin.finder.feed.model.b)localObject);
      return;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt1, T paramT, int paramInt2, com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    Object localObject1 = g.GfZ;
    boolean bool = g.io(paramT.feedObject.getFeedObject().adFlag, 2);
    int i;
    ViewGroup localViewGroup;
    if (paramb == null)
    {
      i = 0;
      Log.i("Finder.FeedFullConvert", "refreshAdFollow position:" + paramInt1 + " adapterPos: " + paramj.KJ() + " payloadType:" + paramInt2 + " adType:" + i);
      localViewGroup = (ViewGroup)paramj.UH(e.e.finder_ad_feed_hint_container);
      localObject1 = paramj.caK.findViewById(e.e.finder_feed_full_footer_layout);
      if (localObject1 != null)
      {
        Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("finder_feed_full_footer_layout  translationY :", Float.valueOf(((View)localObject1).getTranslationY())));
        if (dXx()) {
          ((View)localObject1).setTranslationY(0.0F);
        }
      }
      localObject1 = paramj.caK.findViewById(e.e.finder_seek_bar_footer_layout);
      if (localObject1 != null)
      {
        Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("finder_seek_bar_footer_layout  translationY :", Float.valueOf(((View)localObject1).getTranslationY())));
        if (dXx()) {
          ((View)localObject1).setTranslationY(0.0F);
        }
      }
      if (localViewGroup != null)
      {
        Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("adTipContainer translationY :", Float.valueOf(localViewGroup.getTranslationY())));
        if (dXx()) {
          localViewGroup.setTranslationY(0.0F);
        }
      }
      if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz())) {
        break label284;
      }
      if (localViewGroup != null) {
        localViewGroup.setVisibility(8);
      }
    }
    label390:
    label396:
    label399:
    for (;;)
    {
      return;
      i = paramb.type;
      break;
      label284:
      if ((dXx()) && (paramInt1 == 0) && (bool) && (i == 8)) {
        break label401;
      }
      localObject1 = this.AIh;
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.ui.j))
      {
        localObject1 = (com.tencent.mm.plugin.finder.ui.j)localObject1;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.ui.j)localObject1).FVZ != true)) {
          break label390;
        }
        i = 1;
        label345:
        if (i != 0) {
          break label401;
        }
        if ((paramb == null) || (paramb.type != 9)) {
          break label396;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) || (localViewGroup == null)) {
          break label399;
        }
        localViewGroup.setVisibility(8);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label345;
      }
    }
    label401:
    paramb = this.AIh;
    label440:
    label448:
    Object localObject2;
    if ((paramb instanceof com.tencent.mm.plugin.finder.ui.j))
    {
      paramb = (com.tencent.mm.plugin.finder.ui.j)paramb;
      if (paramb != null) {
        paramb.fcm();
      }
      if (localViewGroup != null) {
        break label706;
      }
      paramb = null;
      if (localViewGroup != null) {
        break label722;
      }
      localObject1 = null;
      localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      String str = paramT.feedObject.field_username;
      localObject2 = paramT.feedObject.getBizInfo();
      if (localObject2 != null) {
        break label738;
      }
      localObject2 = null;
      label479:
      if (com.tencent.mm.plugin.finder.api.d.a.a(str, (String)localObject2, false, false, 12)) {
        break label756;
      }
      if (localViewGroup != null) {
        localViewGroup.setVisibility(0);
      }
      localObject2 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject2 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
      bool = ((Boolean)((kotlin.r)localObject2).bsC).booleanValue();
      ((Boolean)((kotlin.r)localObject2).bsD).booleanValue();
      if (localViewGroup != null)
      {
        localObject2 = paramj.context;
        if ((!bool) && (paramInt2 != 3)) {
          break label748;
        }
        i = e.d.finder_ad_feed_hint_finish_bg;
        label576:
        localViewGroup.setBackground(((Context)localObject2).getDrawable(i));
      }
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(8);
      }
      if (paramb != null) {
        paramb.setText(e.h.finder_follow);
      }
      if (paramb != null) {
        paramb.setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
      }
      if (localViewGroup != null) {
        localViewGroup.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda20(paramj, paramT, this, paramInt1));
      }
      paramb = paramj.caK.findViewById(e.e.follow_btn);
      if (paramb != null) {
        paramb.setVisibility(4);
      }
      paramj.caK.requestLayout();
    }
    label706:
    label722:
    label738:
    label748:
    label881:
    for (;;)
    {
      a(paramT, paramInt1, paramInt2);
      n(paramj);
      return;
      paramb = null;
      break;
      paramb = (TextView)localViewGroup.findViewById(e.e.finder_ad_feed_focus_text);
      break label440;
      localObject1 = (WeImageView)localViewGroup.findViewById(e.e.finder_ad_feed_focus_icon);
      break label448;
      localObject2 = ((pu)localObject2).ADE;
      break label479;
      i = e.d.finder_feed_ad_rel_sns_bg;
      break label576;
      label756:
      if ((paramInt2 == 1) || (paramInt2 == 6))
      {
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
      }
      else
      {
        if ((paramInt2 == 2) && (paramInt1 == 0))
        {
          if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label881;
            }
            if (paramb != null) {
              paramb.setText(e.h.has_follow_tip);
            }
            if (paramb != null) {
              paramb.setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_3));
            }
            localViewGroup.setBackground(paramj.context.getDrawable(e.d.finder_feed_ad_rel_sns_bg));
            localViewGroup.setOnClickListener(null);
            break;
          }
        }
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramj.caK.findViewById(e.e.finder_at_feed_tip_container);
    TextView localTextView = (TextView)paramj.caK.findViewById(e.e.finder_at_show_feed_btn);
    if (localLinearLayout != null)
    {
      if ((!paramBoolean) || (!dXy()) || (paramBaseFinderFeed.feedObject.getMentionListSelected() != 3)) {
        break label112;
      }
      localLinearLayout.setVisibility(0);
      localTextView.setText((CharSequence)localLinearLayout.getContext().getResources().getString(e.h.finder_at_show_feed_tip_confirm_text));
      if (localTextView != null) {
        localTextView.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda18(paramj, paramBaseFinderFeed, localTextView, localLinearLayout, this, paramInt));
      }
    }
    return;
    label112:
    localLinearLayout.setVisibility(8);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, DialogInterface paramDialogInterface)
  {
    kotlin.g.b.s.u(paramj, "$holder");
    paramDialogInterface = (BaseFinderFeed)paramj.CSA;
    long l;
    com.tencent.mm.plugin.report.service.h localh;
    if (!paramDialogInterface.feedObject.isPostFinish())
    {
      l = 0L;
      paramDialogInterface = com.tencent.mm.ae.d.hF(l);
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label110;
      }
    }
    label110:
    for (paramj = null;; paramj = paramj.zIO)
    {
      localh.b(21180, new Object[] { paramj, paramDialogInterface, Integer.valueOf(0), com.tencent.mm.plugin.sns.data.t.heR() });
      return;
      l = paramDialogInterface.feedObject.getId();
      break;
    }
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, DialogInterface paramDialogInterface, int paramInt)
  {
    int j = 1;
    int i = 1;
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramDialogInterface = (BaseFinderFeed)paramj.CSA;
    long l;
    if (!paramDialogInterface.feedObject.isPostFinish())
    {
      l = 0L;
      String str = com.tencent.mm.ae.d.hF(l);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label211;
      }
      paramj = null;
      label81:
      localh.b(21180, new Object[] { paramj, str, Integer.valueOf(1), com.tencent.mm.plugin.sns.data.t.heR() });
      paramj = paramFinderFeedFullConvert.AIh.getActivity();
      if (paramj == null) {
        break label219;
      }
      paramj = paramj.getIntent();
      if ((paramj == null) || (paramj.getBooleanExtra("key_form_sns", false) != true)) {
        break label219;
      }
      paramInt = 1;
      label152:
      if (paramInt == 0) {
        break label224;
      }
      paramInt = i;
    }
    for (;;)
    {
      paramj = an.GhR;
      paramFinderFeedFullConvert = paramFinderFeedFullConvert.AIh.getActivity();
      kotlin.g.b.s.checkNotNull(paramFinderFeedFullConvert);
      paramFinderFeedFullConvert = (AppCompatActivity)paramFinderFeedFullConvert;
      kotlin.g.b.s.s(paramDialogInterface, "currItem");
      an.a.a(paramj, paramFinderFeedFullConvert, paramDialogInterface, 5, paramInt, 4);
      return;
      l = paramDialogInterface.feedObject.getId();
      break;
      label211:
      paramj = paramj.zIO;
      break label81;
      label219:
      paramInt = 0;
      break label152;
      label224:
      paramj = paramFinderFeedFullConvert.AIh.getActivity();
      if (paramj != null)
      {
        paramj = paramj.getIntent();
        if ((paramj == null) || (paramj.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) != true)) {}
      }
      for (paramInt = j;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label276;
        }
        paramInt = 2;
        break;
      }
      label276:
      paramInt = 0;
    }
  }
  
  private static void a(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    Object localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
    if ((com.tencent.mm.plugin.finder.utils.av.F(paramT.feedObject.getFeedObject())) && ((paramT.bZB() == 4) || (paramT.bZB() == 2)))
    {
      paramT = paramj.UH(e.e.share_icon_container);
      if (paramT != null)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        paramj = paramj.context;
        if (paramj == null) {
          throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        paramj = (com.tencent.mm.plugin.finder.viewmodel.component.ba)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramj).q(com.tencent.mm.plugin.finder.viewmodel.component.ba.class);
        kotlin.g.b.s.u(paramT, "anchor");
        int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZJ, 0);
        if (i < 3)
        {
          paramj = new com.tencent.mm.plugin.finder.view.u((Context)paramj.getContext(), (byte)0);
          paramj.GDz = -1L;
          int j = e.h.finder_text_status_setting_tips;
          paramj.DMt.setText((CharSequence)paramj.context.getString(j));
          paramj.gX(paramT);
          paramj.dUX();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZJ, Integer.valueOf(i + 1));
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, T paramT, int paramInt)
  {
    View localView = paramj.UH(e.e.feed_like_comment_edu_layout);
    if ((paramT.showCommentEdu) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz()))
    {
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (localView != null) {
        localView.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda10(this, paramj, paramT, paramInt));
      }
    }
    while (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView1, View paramView2)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramView2 = com.tencent.mm.plugin.finder.report.bb.FuK;
    paramView2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramView2 = paramj.context;
    kotlin.g.b.s.s(paramView2, "holder.context");
    paramView2 = as.a.hu(paramView2);
    if (paramView2 == null) {}
    for (paramView2 = null;; paramView2 = paramView2.fou())
    {
      com.tencent.mm.plugin.finder.report.bb.a(paramView2, "follow_like", false, paramBaseFinderFeed.bZA());
      paramj.UH(e.e.awesome_icon_container).callOnClick();
      paramView1.animate().alpha(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new x(paramView1)).start();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
  
  private static final void a(final com.tencent.mm.view.recyclerview.j paramj, final BaseFinderFeed paramBaseFinderFeed, TextView paramTextView, final LinearLayout paramLinearLayout, final FinderFeedFullConvert paramFinderFeedFullConvert, final int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramTextView);
    localb.cH(paramLinearLayout);
    localb.cH(paramFinderFeedFullConvert);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramLinearLayout, "$this_apply");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramView = com.tencent.mm.plugin.finder.model.ba.EDs;
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    com.tencent.mm.plugin.finder.model.ba.a(paramView, paramBaseFinderFeed.feedObject.getId(), 0, (kotlin.g.a.b)new ab(paramTextView, paramLinearLayout, paramBaseFinderFeed, paramj, paramFinderFeedFullConvert, paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, FinderFeedFullConvert paramFinderFeedFullConvert, int paramInt, View paramView)
  {
    Object localObject1 = null;
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramFinderFeedFullConvert);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramView = com.tencent.mm.plugin.finder.report.bb.FuK;
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    paramView = as.a.hu(paramView);
    if (paramView == null)
    {
      paramView = null;
      com.tencent.mm.plugin.finder.report.bb.a(paramView, "follow", false, paramBaseFinderFeed.bZA());
      a(3, paramBaseFinderFeed.feedObject.getId(), paramInt, paramj);
      paramView = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject2 = paramBaseFinderFeed.feedObject.field_username;
      paramView = paramBaseFinderFeed.feedObject.getBizInfo();
      if (paramView != null) {
        break label336;
      }
    }
    label336:
    for (paramView = localObject1;; paramView = paramView.ADE)
    {
      if (!com.tencent.mm.plugin.finder.api.d.a.a((String)localObject2, paramView, false, false, 12))
      {
        paramFinderFeedFullConvert.AIh.f(paramBaseFinderFeed);
        paramFinderFeedFullConvert.a(paramj, 0, paramBaseFinderFeed, 2);
        paramBaseFinderFeed = new iu();
        paramBaseFinderFeed.hKq.actionType = 10000;
        paramBaseFinderFeed.hKq.feedId = ((BaseFinderFeed)paramj.CSA).bZA();
        paramBaseFinderFeed.publish();
      }
      if (paramj.KJ() == 0)
      {
        paramBaseFinderFeed = com.tencent.mm.ui.component.k.aeZF;
        paramj = paramj.context;
        kotlin.g.b.s.s(paramj, "holder.context");
        ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq(paramj).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).fcZ();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      paramView = paramView.fou();
      break;
    }
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, FinderFeedFullConvert paramFinderFeedFullConvert, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramj = paramj.context;
    if ((paramj instanceof Activity))
    {
      paramj = (Activity)paramj;
      if (paramj != null) {
        break label161;
      }
    }
    label161:
    for (paramj = null;; paramj = (FinderLikeDrawer)paramj.findViewById(e.e.finder_feed_friend_like_drawer))
    {
      kotlin.g.b.s.checkNotNull(paramj);
      paramFinderFeedFullConvert = paramBaseFinderFeed.feedObject;
      kotlin.g.b.s.u(paramBaseFinderFeed, "item");
      paramj.a(paramFinderFeedFullConvert, paramBaseFinderFeed.likeBuffer);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      paramj = null;
      break;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, final T paramT, boolean paramBoolean)
  {
    if ((!((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry()) || (paramT.isPreview)) {
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("checkShowFollowLayout: check finderEntry failed, or isPreview = ", Boolean.valueOf(paramT.isPreview)));
    }
    label58:
    label213:
    label230:
    label490:
    for (;;)
    {
      return;
      Object localObject1 = paramT.contact;
      int i;
      if (localObject1 == null)
      {
        i = 2;
        Object localObject2 = new StringBuilder("[checkShowLittleFollowLayout] tabType=").append(this.hJx).append(" liveStatus=").append(i).append(" id=").append(com.tencent.mm.ae.d.hF(paramT.bZA())).append(" nickname=");
        localObject1 = paramT.contact;
        if (localObject1 != null) {
          break label318;
        }
        localObject1 = null;
        label124:
        Log.i("Finder.FeedFullConvert", localObject1);
        localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject2 = paramT.feedObject.field_username;
        localObject1 = paramT.feedObject.getBizInfo();
        if (localObject1 != null) {
          break label328;
        }
        localObject1 = null;
        if (com.tencent.mm.plugin.finder.api.d.a.a((String)localObject2, (String)localObject1, false, false, 12)) {
          break label336;
        }
        if (!dXx()) {
          break label486;
        }
        localObject1 = this.AIh;
        if (!(localObject1 instanceof com.tencent.mm.plugin.finder.ui.j)) {
          break label338;
        }
        localObject1 = (com.tencent.mm.plugin.finder.ui.j)localObject1;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.ui.j)localObject1).FVZ != true)) {
          break label344;
        }
        i = 1;
        if (i == 0) {
          break label350;
        }
        Log.i("Finder.FeedFullConvert", "isExistAdFollow: is all feed show ad follow btn");
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label490;
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        ((com.tencent.mm.plugin.finder.viewmodel.component.y)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.y.class)).a(paramj, paramT.bZA(), paramBoolean, (kotlin.g.a.a)new c(paramj, paramT, this));
        return;
        i = ((m)localObject1).field_liveStatus;
        break label58;
        localObject1 = ((m)localObject1).getNickname();
        break label124;
        localObject1 = ((pu)localObject1).ADE;
        break label171;
        break;
        localObject1 = null;
        break label213;
        i = 0;
        break label230;
        localObject1 = g.GfZ;
        if (g.io(paramT.feedObject.getFeedObject().adFlag, 2))
        {
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          localObject1 = paramj.context;
          if (localObject1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          }
          localObject1 = ((com.tencent.mm.plugin.findersdk.a.ar)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject1).cq(com.tencent.mm.plugin.findersdk.a.ar.class)).eiJ().nE(paramT.feedObject.getId());
          if ((localObject1 instanceof com.tencent.mm.plugin.finder.feed.model.b)) {}
          for (localObject1 = (com.tencent.mm.plugin.finder.feed.model.b)localObject1;; localObject1 = null)
          {
            if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.feed.model.b)localObject1).type != 8)) {
              break label480;
            }
            i = 1;
            break;
          }
          i = 0;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, FinderItem paramFinderItem, String paramString)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (paramFinderItem == null)
    {
      localObject1 = null;
      StringBuilder localStringBuilder = new StringBuilder("showNewsIndicator objectType: ");
      if (paramFinderItem != null) {
        break label224;
      }
      localObject2 = null;
      label29:
      localStringBuilder = localStringBuilder.append(localObject2).append(" size:");
      if (localObject1 != null) {
        break label254;
      }
      localObject2 = null;
      label52:
      Log.i("Finder.FeedFullConvert", localObject2);
      if (localObject1 == null) {
        break label608;
      }
      localObject2 = ((LinkedList)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (brm)((Iterator)localObject2).next();
      } while ((localObject1 == null) || (((brm)localObject1).ZZK != 5));
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramFinderItem = localObject3;
        if (paramFinderItem == null)
        {
          Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic null let");
          paramFinderItem = paramj.UH(e.e.finder_feed_item_of_news);
          if (paramFinderItem != null) {
            paramFinderItem.setVisibility(8);
          }
          paramFinderItem = paramj.UH(e.e.finder_feed_item_of_news_title);
          if (paramFinderItem != null) {
            paramFinderItem.setVisibility(8);
          }
          n(paramj);
        }
        return;
        localObject1 = paramFinderItem.getFeedObject();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObject)localObject1).hotTopics;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((brn)localObject1).topics;
        break;
        label224:
        localObject2 = paramFinderItem.getFeedObject();
        if (localObject2 == null)
        {
          localObject2 = null;
          break label29;
        }
        localObject2 = Integer.valueOf(((FinderObject)localObject2).objectType);
        break label29;
        label254:
        localObject2 = Integer.valueOf(((LinkedList)localObject1).size());
        break label52;
      }
      Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic " + ((brm)localObject1).ADo + ' ' + ((brm)localObject1).xUk + ' ' + ((brm)localObject1).ZZL);
      if ((paramj.context instanceof FinderShareFeedRelUI))
      {
        Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic ui is FinderShareFeedRelUI block");
        paramFinderItem = paramj.UH(e.e.finder_feed_item_of_news);
        if (paramFinderItem != null) {
          paramFinderItem.setVisibility(8);
        }
        paramFinderItem = paramj.UH(e.e.finder_feed_item_of_news_title);
        if (paramFinderItem != null) {
          paramFinderItem.setVisibility(8);
        }
        n(paramj);
        return;
      }
      localObject2 = (TextView)paramj.UH(e.e.feed_item_news_title);
      if (localObject2 != null)
      {
        if (((brm)localObject1).ZZL <= 0) {
          break label589;
        }
        ((TextView)localObject2).setTextColor(((TextView)localObject2).getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_stream_link_color));
      }
      for (;;)
      {
        ((TextView)localObject2).setBackgroundResource(e.d.finder_feed_full_item_news_bg);
        localObject2 = (WeImageView)paramj.UH(e.e.finder_profile_auth_arrow);
        if (localObject2 != null) {
          ((WeImageView)localObject2).setIconColor(((WeImageView)localObject2).getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_3));
        }
        localObject2 = paramj.UH(e.e.finder_feed_item_of_news);
        if (localObject2 != null)
        {
          ((View)localObject2).setVisibility(0);
          n(paramj);
          ((View)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda13((brm)localObject1, paramFinderItem, this, paramString, paramj, (View)localObject2));
        }
        paramFinderItem = (TextView)paramj.UH(e.e.feed_item_news_title);
        if (paramFinderItem != null)
        {
          paramString = kotlin.g.b.s.X(paramFinderItem.getContext().getResources().getString(e.h.finder_news_feed_title_prefix), ((brm)localObject1).xUk);
          paramFinderItem.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString));
        }
        paramFinderItem = (TextView)paramj.UH(e.e.feed_item_news_tag_text);
        if (paramFinderItem != null) {
          paramFinderItem.setVisibility(8);
        }
        paramFinderItem = (FinderItem)localObject1;
        break;
        label589:
        ((TextView)localObject2).setTextColor(((TextView)localObject2).getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_5));
      }
      label608:
      localObject1 = null;
    }
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderFullSeekBarLayout);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "$seekBarLayout");
    localObject1 = (List)new ArrayList();
    paramView = paramj.UH(e.e.finder_feed_full_footer_layout);
    if (paramView != null) {
      ((List)localObject1).add(paramView);
    }
    ((List)localObject1).add(paramFinderFullSeekBarLayout.getSeekLayout());
    paramView = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof FinderThumbPlayerProxy)) {
        break label178;
      }
      paramView = (FinderThumbPlayerProxy)paramView;
    }
    for (;;)
    {
      if (paramView != null)
      {
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        paramj = paramj.context;
        if (paramj == null)
        {
          throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
          paramView = paramView.getVideoView();
          break;
          label178:
          paramView = null;
          continue;
        }
        paramj = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramj).q(com.tencent.mm.plugin.finder.viewmodel.component.av.class);
        kotlin.g.b.s.s(paramj, "UICProvider.of(holder.co…edControlUIC::class.java)");
        com.tencent.mm.plugin.finder.viewmodel.component.av.a((com.tencent.mm.plugin.finder.viewmodel.component.av)paramj, (List)localObject1, paramView, 0, false, (kotlin.g.a.a)new q(paramFinderFullSeekBarLayout), 12);
      }
    }
    paramFinderFullSeekBarLayout.fiN();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, String paramString, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.bx.b paramb1, FinderFeedFullConvert paramFinderFeedFullConvert, bro parambro, com.tencent.mm.bx.b paramb2, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramb1);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(parambro);
    localb.cH(paramb2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramString, "$topicName");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramFinderFeedFullConvert = new Intent();
    paramFinderFeedFullConvert.putExtra("key_search_query", paramString);
    paramFinderFeedFullConvert.putExtra("key_search_is_from_feed_list", true);
    paramFinderFeedFullConvert.putExtra("key_search_feed_id", paramBaseFinderFeed.feedObject.getId());
    if (paramb1 != null) {
      paramFinderFeedFullConvert.putExtra("key_search_session_buffer", paramb1.toByteArray());
    }
    paramString = parambro.ZZP;
    int i;
    if ((paramString != null) && (paramString.size() == 0))
    {
      i = 1;
      if (i != 0) {
        break label329;
      }
      paramString = SearchHotWordListParcelable.CREATOR;
    }
    label329:
    for (paramString = SearchHotWordListParcelable.a.a(parambro.ZZO, 0, (List)parambro.ZZP);; paramString = null)
    {
      if (paramString != null) {
        paramFinderFeedFullConvert.putExtra("key_search_hot_word_info", (Parcelable)paramString);
      }
      if (paramb2 != null) {
        paramFinderFeedFullConvert.putExtra("key_search_hot_word_buffer", paramb2.toByteArray());
      }
      paramFinderFeedFullConvert.putExtra("key_entrance_type", 8);
      paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.b(paramj, null, paramFinderFeedFullConvert);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(boolean[] paramArrayOfBoolean, FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramArrayOfBoolean);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramArrayOfBoolean, "$starOnTouchDownCalled");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    if (paramArrayOfBoolean[0] != 0)
    {
      paramArrayOfBoolean[0] = false;
      if (paramFinderFeedFullConvert.AIh.ebw()) {
        break label280;
      }
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onClickStar: ", Integer.valueOf(paramj.KJ())));
      paramFinderFeedFullConvert.c(paramj, 0);
      paramFinderFeedFullConvert = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      paramArrayOfBoolean = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {
        break label273;
      }
      paramArrayOfBoolean = "fav";
      label180:
      paramFinderFeedFullConvert.a("view_clk", paramView, kotlin.a.ak.l(kotlin.v.Y("action_type", paramArrayOfBoolean)), 24617);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_fav", "<FeedFav>");
      paramArrayOfBoolean = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_fav", paramArrayOfBoolean);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_fav");
      break;
      label273:
      paramArrayOfBoolean = "unfav";
      break label180;
      label280:
      paramArrayOfBoolean = com.tencent.mm.ui.component.k.aeZF;
      paramArrayOfBoolean = paramj.context;
      kotlin.g.b.s.s(paramArrayOfBoolean, "holder.context");
      paramArrayOfBoolean = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramArrayOfBoolean).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramArrayOfBoolean != null)
      {
        kotlin.g.b.s.u(paramj, "holder");
        if (paramArrayOfBoolean.GNM.contains(Integer.valueOf(1))) {
          if (paramArrayOfBoolean.GNL == 1) {
            paramArrayOfBoolean.a(paramj, 0, true);
          } else if (paramArrayOfBoolean.GNL == 0) {
            paramArrayOfBoolean.a(paramj, 1, true);
          }
        }
      }
    }
  }
  
  private static final void a(boolean[] paramArrayOfBoolean, com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramArrayOfBoolean);
    localb.cH(paramj);
    localb.cH(paramFinderFeedFullConvert);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramArrayOfBoolean, "$likeOnTouchDownCalled");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    long l1;
    if (paramArrayOfBoolean[0] != 0)
    {
      paramArrayOfBoolean[0] = false;
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onClickLike:", Integer.valueOf(paramj.KJ())));
      paramArrayOfBoolean = (BaseFinderFeed)paramj.CSA;
      localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.E(paramArrayOfBoolean.feedObject.getFeedObject()))
      {
        if (paramFinderFeedFullConvert.AIh.ebw()) {
          break label430;
        }
        l1 = SystemClock.elapsedRealtime();
        long l2 = l1 - paramFinderFeedFullConvert.AIi;
        if (41L > l2) {
          break label402;
        }
        if (l2 >= 300L) {
          break label397;
        }
        paramInt = 1;
        label193:
        if ((paramInt == 0) || (paramFinderFeedFullConvert.qaN >= 5)) {
          break label407;
        }
        paramFinderFeedFullConvert.qaN += 1;
        paramFinderFeedFullConvert.AIi = l1;
        paramInt = 0;
        label223:
        if (paramInt != 0)
        {
          paramFinderFeedFullConvert.a(paramj, 1, false, null);
          paramArrayOfBoolean = (BaseFinderFeed)paramj.CSA;
          paramj = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
          paramArrayOfBoolean = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramArrayOfBoolean.feedObject.getFeedObject());
          boolean bool = ((Boolean)paramArrayOfBoolean.bsC).booleanValue();
          ((Boolean)paramArrayOfBoolean.bsD).booleanValue();
          paramj = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
          if (!bool) {
            break label423;
          }
        }
      }
    }
    label397:
    label402:
    label407:
    label423:
    for (paramArrayOfBoolean = "like";; paramArrayOfBoolean = "unlike")
    {
      paramj.a("view_clk", paramView, kotlin.a.ak.l(kotlin.v.Y("action_type", paramArrayOfBoolean)), 24617);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_like", "<FeedLike>");
      paramArrayOfBoolean = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_like", paramArrayOfBoolean);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_like");
      break;
      paramInt = 0;
      break label193;
      paramInt = 0;
      break label193;
      paramFinderFeedFullConvert.qaN = 0;
      paramFinderFeedFullConvert.AIi = l1;
      paramInt = 1;
      break label223;
    }
    label430:
    paramFinderFeedFullConvert = (BaseFinderFeed)paramj.CSA;
    paramArrayOfBoolean = paramj.context;
    if ((paramArrayOfBoolean instanceof Activity))
    {
      paramArrayOfBoolean = (Activity)paramArrayOfBoolean;
      label455:
      if (paramArrayOfBoolean != null) {
        break label482;
      }
    }
    label482:
    for (paramArrayOfBoolean = null;; paramArrayOfBoolean = (FinderLikeDrawer)paramArrayOfBoolean.findViewById(e.e.finder_feed_all_like_drawer))
    {
      kotlin.g.b.s.checkNotNull(paramArrayOfBoolean);
      paramArrayOfBoolean.a(paramFinderFeedFullConvert.feedObject, null);
      break;
      paramArrayOfBoolean = null;
      break label455;
    }
  }
  
  private static final boolean a(View paramView1, final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.view.recyclerview.j paramj, View paramView2)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new r(paramView1, paramBaseFinderFeed, paramj));
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return true;
  }
  
  private static boolean a(T paramT)
  {
    kotlin.g.b.s.u(paramT, "item");
    com.tencent.mm.plugin.finder.utils.av localav = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (!com.tencent.mm.plugin.finder.utils.av.e(paramT)) {}
    while ((paramT.feedObject.isPostFinish()) || ((!paramT.feedObject.isPostFailed()) && ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().aaPw >= 100)))) {
      return true;
    }
    return false;
  }
  
  private final boolean a(com.tencent.mm.view.recyclerview.j paramj, int paramInt, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((kotlin.r)localObject1).bsC).booleanValue();
    boolean bool3 = ((Boolean)((kotlin.r)localObject1).bsD).booleanValue();
    WeImageView localWeImageView;
    Object localObject2;
    label135:
    label148:
    label234:
    boolean bool2;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label714;
      }
      kotlin.g.b.s.s(localBaseFinderFeed, "item");
      a(paramj, localBaseFinderFeed);
      View localView = paramj.UH(e.e.icon_feed_like);
      localWeImageView = i(paramj);
      localWeImageView.setLayerPaint(null);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.h.TA(localBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (localObject2 != null) {
        break label536;
      }
      localObject1 = "";
      if (!paramBoolean) {
        break label546;
      }
      a(localWeImageView, (brk)localObject2, true);
      localObject1 = com.tencent.mm.plugin.finder.view.animation.c.GGo;
      com.tencent.mm.plugin.finder.view.animation.c.h((View)localWeImageView, paramMotionEvent);
      paramMotionEvent = com.tencent.mm.plugin.finder.view.animation.c.GGo;
      kotlin.g.b.s.s(localView, "likeIcon");
      com.tencent.mm.plugin.finder.view.animation.c.hd(localView);
      if ((paramInt == 2) || (paramBoolean)) {
        j(paramj);
      }
      paramMotionEvent = paramj.UH(e.e.finder_self_feed_like_tips_layout);
      if (paramMotionEvent != null) {
        paramMotionEvent.setVisibility(8);
      }
      localBaseFinderFeed.isDeepEnjoy = true;
      a(paramj, localBaseFinderFeed, true);
      k(paramj);
      if (!bool1) {
        break label760;
      }
      bool2 = false;
      label242:
      paramMotionEvent = this.AIh;
      kotlin.g.b.s.s(localBaseFinderFeed, "item");
      paramMotionEvent.a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      paramMotionEvent = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.l.fek().v(localBaseFinderFeed.feedObject.getFeedObject()), paramj);
      paramMotionEvent = com.tencent.mm.plugin.finder.utils.av.GiL;
      if ((com.tencent.mm.plugin.finder.utils.av.q(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label767;
        }
        paramMotionEvent = localBaseFinderFeed.feedObject.getFeedObject();
        paramMotionEvent.incFriendLikeCount += 1;
      }
      label344:
      paramMotionEvent = new if();
      paramMotionEvent.hJB.id = localBaseFinderFeed.bZA();
      paramMotionEvent.hJB.type = 4;
      localObject1 = paramMotionEvent.hJB;
      if ((!bool1) || (!paramBoolean)) {
        break label797;
      }
      paramInt = 2;
      label393:
      ((if.a)localObject1).hJE = paramInt;
      paramMotionEvent.publish();
      paramMotionEvent = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramMotionEvent = paramj.context;
      kotlin.g.b.s.s(paramMotionEvent, "holder.context");
      paramMotionEvent = as.a.hu(paramMotionEvent);
      if (paramMotionEvent != null)
      {
        paramMotionEvent = ((bn)paramMotionEvent).foy();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.dYj();
          if (paramMotionEvent != null)
          {
            if (!bool1) {
              break label812;
            }
            paramMotionEvent.nb(localBaseFinderFeed.bZA());
          }
        }
      }
    }
    for (;;)
    {
      if ((bool1) && (paramj.KJ() == 0))
      {
        paramMotionEvent = com.tencent.mm.ui.component.k.aeZF;
        paramj = paramj.context;
        kotlin.g.b.s.s(paramj, "holder.context");
        ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq(paramj).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).fda();
      }
      return bool1;
      bool1 = false;
      break;
      label536:
      localObject1 = ((brk)localObject2).ZZx;
      break label135;
      label546:
      localObject2 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (com.tencent.mm.plugin.finder.utils.aw.n(localBaseFinderFeed.contact))
      {
        localWeImageView.setImageDrawable(com.tencent.mm.ui.bb.m(paramj.context, e.g.finder_filled_like_lock, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90)));
        break label148;
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label683;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, com.tencent.mm.plugin.finder.storage.v.FKY);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExY));
        break;
      }
      label683:
      localWeImageView.setImageDrawable(com.tencent.mm.ui.bb.m(paramj.context, e.g.finder_full_like, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90)));
      break label148;
      label714:
      paramMotionEvent = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUg().bmg()).intValue() != 1) {
        break label234;
      }
      localBaseFinderFeed.showCommentEdu = false;
      kotlin.g.b.s.s(localBaseFinderFeed, "item");
      a(paramj, localBaseFinderFeed, 1);
      break label234;
      label760:
      bool2 = bool3;
      break label242;
      label767:
      if (bool3) {
        break label344;
      }
      paramMotionEvent = localBaseFinderFeed.feedObject.getFeedObject();
      paramMotionEvent.incFriendLikeCount -= 1;
      break label344;
      label797:
      if (bool1)
      {
        paramInt = 1;
        break label393;
      }
      paramInt = 0;
      break label393;
      label812:
      paramMotionEvent.nc(localBaseFinderFeed.bZA());
    }
  }
  
  private static final boolean a(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramFinderFeedFullConvert);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXL().bmg()).intValue() == 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return true;
    }
    paramView = (BaseFinderFeed)paramj.CSA;
    localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
    if ((com.tencent.mm.plugin.finder.utils.av.E(paramView.feedObject.getFeedObject())) && (!paramFinderFeedFullConvert.AIh.ebw()))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTw().bmg()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (!com.tencent.mm.plugin.finder.utils.aw.n(paramView.contact))
        {
          Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onLongClick Private Like:", Integer.valueOf(paramj.KJ())));
          localObject = (ImageView)paramj.UH(e.e.icon_feed_like);
          if (((((ImageView)localObject).getTag() instanceof Integer)) && (kotlin.g.b.s.p(((ImageView)localObject).getTag(), Integer.valueOf(0))))
          {
            localObject = new com.tencent.mm.ui.widget.a.f(paramj.context, 1, true);
            ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new FinderFeedFullConvert..ExternalSyntheticLambda36(paramFinderFeedFullConvert, paramView, paramj);
            ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new FinderFeedFullConvert..ExternalSyntheticLambda37(paramFinderFeedFullConvert, paramj, paramInt);
            ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
          }
        }
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return true;
  }
  
  private static final boolean a(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = paramj.context;
    if (paramView == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    paramView = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramView).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    kotlin.g.b.s.s(paramView, "UICProvider.of(holder.co…rReporterUIC::class.java)");
    paramView = ((bn)paramView).foy();
    if (paramView != null) {
      paramView.dYj().no(paramj.caN);
    }
    if (paramFinderFeedFullConvert.hJx == 4) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return bool;
    }
  }
  
  private static final boolean a(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBaseFinderFeed);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramView = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    if (paramView == null) {
      paramView = null;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = paramj.context;
      if (localObject1 != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      paramView = paramView.getPlayInfo();
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.EEv;
      }
    }
    localObject1 = (com.tencent.mm.plugin.finder.viewmodel.component.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.k.class);
    localObject2 = paramj.context;
    kotlin.g.b.s.s(localObject2, "holder.context");
    ((com.tencent.mm.plugin.finder.viewmodel.component.k)localObject1).a((Context)localObject2, paramBaseFinderFeed, paramView, paramj);
    paramj.getRecyclerView().requestLayout();
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return true;
  }
  
  private static final boolean a(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
  {
    kotlin.g.b.s.u(paramArrayOfBoolean, "$starOnTouchDownCalled");
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return false;
    case 0: 
    case 5: 
      paramArrayOfBoolean[0] = true;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_fav", "<FeedFav>");
      return false;
    }
    com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_fav", paramMotionEvent);
    com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_fav");
    return false;
  }
  
  private static final void aO(kotlin.g.a.a parama)
  {
    kotlin.g.b.s.u(parama, "$anim");
    parama.invoke();
  }
  
  private static final Map b(com.tencent.mm.view.recyclerview.j paramj, String paramString)
  {
    Object localObject = null;
    kotlin.g.b.s.u(paramj, "$holder");
    paramString = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramString = paramj.context;
    kotlin.g.b.s.s(paramString, "holder.context");
    paramString = as.a.hu(paramString);
    kotlin.r localr1;
    label71:
    kotlin.r localr2;
    label107:
    kotlin.r localr3;
    if (paramString == null)
    {
      paramString = null;
      localr1 = kotlin.v.Y("session_id", paramString);
      paramString = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramString = paramj.context;
      kotlin.g.b.s.s(paramString, "holder.context");
      paramString = as.a.hu(paramString);
      if (paramString != null) {
        break label223;
      }
      paramString = null;
      localr2 = kotlin.v.Y("finder_context_id", paramString);
      paramString = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramString = paramj.context;
      kotlin.g.b.s.s(paramString, "holder.context");
      paramString = as.a.hu(paramString);
      if (paramString != null) {
        break label231;
      }
      paramString = null;
      localr3 = kotlin.v.Y("finder_tab_context_id", paramString);
      paramString = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramString = paramj.context;
      kotlin.g.b.s.s(paramString, "holder.context");
      paramString = as.a.hu(paramString);
      if (paramString != null) {
        break label239;
      }
      paramString = null;
      label143:
      paramString = kotlin.v.Y("enter_extra_info", paramString);
      as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label247;
      }
    }
    label223:
    label231:
    label239:
    label247:
    for (paramj = localObject;; paramj = paramj.zIE)
    {
      return kotlin.a.ak.e(new kotlin.r[] { localr1, localr2, localr3, paramString, kotlin.v.Y("enter_source_info", paramj) });
      paramString = paramString.sessionId;
      break;
      paramString = paramString.zIO;
      break label71;
      paramString = paramString.zIB;
      break label107;
      paramString = paramString.extraInfo;
      break label143;
    }
  }
  
  private static final void b(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    localObject = paramj.CSA;
    kotlin.g.b.s.s(localObject, "holder.getAssociatedObject()");
    localObject = (BaseFinderFeed)localObject;
    kotlin.g.b.s.s(paramView, "it");
    paramFinderFeedFullConvert.a(paramj, (BaseFinderFeed)localObject, paramView, 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final void b(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramj.UH(e.e.share_icon_container);
    g(paramj);
    Object localObject = paramj.UH(e.e.footer_op_layout);
    int j;
    int m;
    int i;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(e.e.share_count_tv);
      if (localObject != null)
      {
        j = paramT.feedObject.getForwardCount();
        com.tencent.mm.plugin.finder.upload.action.c.a locala = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        int k = com.tencent.mm.plugin.finder.upload.action.c.fee().t(paramT.feedObject.getFeedObject());
        m = paramT.feedObject.getFeedObject().wx_status_ref_count;
        paramT = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label256;
        }
        i = j + k + m;
        Log.i("Finder.FeedFullConvert", "[refreshForwardCount] count=" + i + " originForward=" + j + " favCount=" + k + " statusRefCount=" + m);
        if ((i <= 0) && (!this.AIh.ebw())) {
          break label271;
        }
        if (this.AIh.ebw()) {
          break label265;
        }
        j = 2;
        label204:
        paramT = com.tencent.mm.plugin.finder.utils.r.ip(j, i);
        kotlin.g.b.s.s(paramT, "formatNumber(\n          …rdCount\n                )");
        if (localLinearLayout != null) {
          localLinearLayout.setTag(e.e.finder_accessibility_forward_count_tag, paramT);
        }
        com.tencent.mm.ui.aw.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText((CharSequence)paramT);
      return;
      label256:
      i = j + m;
      break;
      label265:
      j = 1;
      break label204;
      label271:
      paramT = paramj.context.getString(e.h.finder_share_icon_text);
      kotlin.g.b.s.s(paramT, "holder.context.getString…g.finder_share_icon_text)");
      if (localLinearLayout != null) {
        localLinearLayout.setTag(e.e.finder_accessibility_forward_count_tag, "0");
      }
      com.tencent.mm.ui.aw.e((Paint)((TextView)localObject).getPaint());
    }
  }
  
  private static final void b(FinderPostProgressView paramFinderPostProgressView, ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
    paramFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramFinderPostProgressView.invalidate();
  }
  
  private final void b(com.tencent.mm.view.recyclerview.j paramj, int paramInt1, T paramT, int paramInt2, com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    int j = 0;
    Object localObject1 = g.GfZ;
    boolean bool = g.io(paramT.feedObject.getFeedObject().adFlag, 2);
    ViewGroup localViewGroup;
    if (paramb == null)
    {
      i = 0;
      localViewGroup = (ViewGroup)paramj.UH(e.e.finder_ad_feed_hint_container);
      if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz())) {
        break label91;
      }
      if (localViewGroup != null) {
        localViewGroup.setVisibility(8);
      }
    }
    label91:
    do
    {
      return;
      i = paramb.type;
      break;
      if ((dXx()) && (paramInt1 == 0) && (bool) && (i == 9)) {
        break label180;
      }
    } while (i == 8);
    paramj = this.AIh;
    if ((paramj instanceof com.tencent.mm.plugin.finder.ui.j)) {}
    for (paramj = (com.tencent.mm.plugin.finder.ui.j)paramj;; paramj = null)
    {
      paramInt1 = j;
      if (paramj != null)
      {
        paramInt1 = j;
        if (paramj.FVZ == true) {
          paramInt1 = 1;
        }
      }
      if ((paramInt1 != 0) || (localViewGroup == null)) {
        break;
      }
      localViewGroup.setVisibility(8);
      return;
    }
    label180:
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
    bool = ((Boolean)((kotlin.r)localObject1).bsC).booleanValue();
    ((Boolean)((kotlin.r)localObject1).bsD).booleanValue();
    if (localViewGroup != null)
    {
      localObject1 = paramj.context.getResources();
      if (((paramInt2 != 0) && (paramInt2 != 10)) || (bool)) {
        break label313;
      }
    }
    label313:
    for (int i = e.d.finder_feed_ad_rel_sns_bg;; i = e.d.finder_ad_feed_hint_finish_bg)
    {
      localViewGroup.setBackground(((Resources)localObject1).getDrawable(i));
      switch (paramInt2)
      {
      default: 
        a(paramT, paramInt1, paramInt2);
        n(paramj);
        return;
      }
    }
    label329:
    WeImageView localWeImageView;
    if (localViewGroup == null)
    {
      localObject1 = null;
      if (localViewGroup != null) {
        break label449;
      }
      localWeImageView = null;
      label337:
      if (localViewGroup != null) {
        localViewGroup.setVisibility(0);
      }
      if (localObject1 != null)
      {
        if (paramb != null) {
          break label465;
        }
        localObject2 = null;
        label361:
        if (Util.isNullOrNil((String)localObject2)) {
          break label485;
        }
        if (paramb != null) {
          break label475;
        }
        localObject2 = null;
        label377:
        kotlin.g.b.s.checkNotNull(localObject2);
      }
    }
    label449:
    label465:
    label475:
    label485:
    for (Object localObject2 = (CharSequence)localObject2;; localObject2 = (CharSequence)paramj.context.getString(e.h.finder_ad_feed_know_more_hint))
    {
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (localWeImageView != null) {
        localWeImageView.setVisibility(0);
      }
      if (localViewGroup == null) {
        break;
      }
      localViewGroup.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda11(paramb, this, paramT, paramInt1, paramj));
      break;
      localObject1 = (TextView)localViewGroup.findViewById(e.e.finder_ad_feed_focus_text);
      break label329;
      localWeImageView = (WeImageView)localViewGroup.findViewById(e.e.finder_ad_feed_focus_icon);
      break label337;
      localObject2 = paramb.hBr;
      break label361;
      localObject2 = paramb.hBr;
      break label377;
    }
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert paramFinderFeedFullConvert, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    if (paramj.KJ() == 0)
    {
      paramFinderFeedFullConvert = com.tencent.mm.ui.component.k.aeZF;
      paramFinderFeedFullConvert = paramj.context;
      kotlin.g.b.s.s(paramFinderFeedFullConvert, "holder.context");
      paramFinderFeedFullConvert = ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq(paramFinderFeedFullConvert).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).FYa;
      if (paramFinderFeedFullConvert != null)
      {
        paramFinderFeedFullConvert.fdb();
        paramFinderFeedFullConvert.aBh("nickname");
      }
    }
    a(paramj, -1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.j paramj, final T paramT)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i;
    boolean bool;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVq().bmg()).intValue() == 1)
    {
      i = 1;
      localObject = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
      bool = ((Boolean)((kotlin.r)localObject).bsC).booleanValue();
      ((Boolean)((kotlin.r)localObject).bsD).booleanValue();
      StringBuilder localStringBuilder = new StringBuilder("[checkShowFollowLikeLayout] isLike=").append(bool).append(" tabType=").append(this.hJx).append(" id=").append(com.tencent.mm.ae.d.hF(paramT.bZA())).append(" nickname=");
      localObject = paramT.contact;
      if (localObject != null) {
        break label160;
      }
      localObject = null;
      label134:
      Log.i("Finder.FeedFullConvert", localObject);
      if (i != 0) {
        break label170;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label160:
      localObject = ((m)localObject).getNickname();
      break label134;
      label170:
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVP().bmg()).intValue() == 1) {}
      for (localObject = paramj.UH(e.e.follow_like_big_layout); (((View)localObject).getVisibility() != 0) && (!bool) && (c(paramT)); localObject = paramj.UH(e.e.follow_like_layout))
      {
        ((View)localObject).setVisibility(0);
        ((View)localObject).setAlpha(0.0F);
        ((View)localObject).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new d((View)localObject, paramj, paramT)).start();
        return;
      }
    }
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    localObject = paramj.context;
    kotlin.g.b.s.s(localObject, "holder.context");
    paramView = paramBaseFinderFeed.contact;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getUsername())
    {
      new ag((Context)localObject, paramView, paramj.KJ(), paramBaseFinderFeed.feedObject.isLiveFeed()).vc(true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramFinderFullSeekBarLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderFullSeekBarLayout, "$seekBarLayout");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = paramj.context;
    if (paramView == null) {
      throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }
    paramView = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramView).q(x.class);
    kotlin.g.b.s.s(paramView, "UICProvider.of(holder.co…tMiniViewUIC::class.java)");
    paramView = (x)paramView;
    localObject = new ca(((BaseFinderFeed)paramj.CSA).feedObject.getFeedObject());
    paramj = paramj.getRecyclerView();
    kotlin.g.b.s.s(paramj, "holder.recyclerView");
    x.a(paramView, (ca)localObject, paramj);
    paramFinderFullSeekBarLayout.fiN();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static boolean b(T paramT)
  {
    return paramT.feedObject.getFeedObject().objectType == 1;
  }
  
  private static final boolean b(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
  {
    kotlin.g.b.s.u(paramArrayOfBoolean, "$likeOnTouchDownCalled");
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return false;
    case 0: 
    case 5: 
      paramArrayOfBoolean[0] = true;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_like", "<FeedLike>");
      return false;
    }
    com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_like", paramMotionEvent);
    com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_like");
    return false;
  }
  
  private static final Map c(com.tencent.mm.view.recyclerview.j paramj, String paramString)
  {
    kotlin.g.b.s.u(paramj, "$holder");
    paramj = (BaseFinderFeed)paramj.CSA;
    paramString = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    paramj = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramj.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)paramj.bsC).booleanValue();
    boolean bool2 = ((Boolean)paramj.bsD).booleanValue();
    if (bool1)
    {
      paramj = "like";
      paramString = kotlin.v.Y("action_type", paramj);
      if (!bool2) {
        break label108;
      }
    }
    label108:
    for (paramj = "private";; paramj = "no_private")
    {
      return kotlin.a.ak.e(new kotlin.r[] { paramString, kotlin.v.Y("is_Private", paramj) });
      paramj = "unlike";
      break;
    }
  }
  
  private static final void c(FinderFeedFullConvert paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedFullConvert);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    localObject = paramj.CSA;
    kotlin.g.b.s.s(localObject, "holder.getAssociatedObject()");
    localObject = (BaseFinderFeed)localObject;
    kotlin.g.b.s.s(paramView, "it");
    paramFinderFeedFullConvert.a(paramj, (BaseFinderFeed)localObject, paramView, 2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final void c(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    int j = 1;
    TextView localTextView = (TextView)paramj.UH(e.e.comment_count_tv);
    View localView = paramj.UH(e.e.comment_icon_container);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1)
    {
      i = 1;
      localObject = (ImageView)paramj.UH(e.e.icon_feed_comment);
      if (!paramT.feedObject.isCommentClose()) {
        break label219;
      }
      com.tencent.mm.plugin.finder.utils.av localav = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!com.tencent.mm.plugin.finder.utils.av.Iz(paramT.feedObject.field_username)) {
        break label219;
      }
      if (i == 0) {
        break label208;
      }
      ((ImageView)localObject).setImageResource(e.g.icon_outlined_close_comment);
    }
    for (;;)
    {
      localView.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda9(this, paramj, paramT));
      int k = paramT.feedObject.getCommentCount();
      if ((k <= 0) && (!this.AIh.ebw())) {
        break label245;
      }
      i = j;
      if (!this.AIh.ebw()) {
        i = 2;
      }
      localTextView.setText((CharSequence)com.tencent.mm.plugin.finder.utils.r.ip(i, k));
      kotlin.g.b.s.s(localTextView, "seeAllCommentsTv");
      com.tencent.mm.plugin.finder.utils.i.setTextBold(localTextView);
      if (localView != null) {
        localView.setTag(e.e.finder_accessibility_comment_count_tag, localTextView.getText());
      }
      return;
      i = 0;
      break;
      label208:
      ((ImageView)localObject).setImageResource(e.g.icon_filled_close_comment);
      continue;
      label219:
      if (i != 0) {
        ((ImageView)localObject).setImageResource(e.g.finder_full_comment_outlined);
      } else {
        ((ImageView)localObject).setImageResource(e.g.finder_full_comment);
      }
    }
    label245:
    paramT = localTextView.getContext().getString(e.h.finder_comment_count_text);
    kotlin.g.b.s.s(paramT, "seeAllCommentsTv.context…inder_comment_count_text)");
    localTextView.setText((CharSequence)paramT);
    if (localView != null) {
      localView.setTag(e.e.finder_accessibility_comment_count_tag, "0");
    }
    kotlin.g.b.s.s(localTextView, "seeAllCommentsTv");
    com.tencent.mm.plugin.finder.utils.i.w(localTextView);
  }
  
  private final void c(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (!com.tencent.mm.plugin.finder.utils.av.D(localBaseFinderFeed.feedObject.getFeedObject()))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        paramj = paramj.context.getString(e.h.finder_private_ban_fav);
        kotlin.g.b.s.s(paramj, "holder.context.getString…g.finder_private_ban_fav)");
        com.tencent.mm.plugin.finder.utils.av.aO((Context)localObject1, paramj);
      }
    }
    label312:
    label698:
    label739:
    for (;;)
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = paramj.context;
      kotlin.g.b.s.s(localObject1, "holder.context");
      paramj = paramj.context.getString(e.h.finder_private_ban_fav2);
      kotlin.g.b.s.s(paramj, "holder.context.getString….finder_private_ban_fav2)");
      com.tencent.mm.plugin.finder.utils.av.aO((Context)localObject1, paramj);
      return;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      boolean bool;
      Object localObject2;
      if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(localBaseFinderFeed.feedObject.getFeedObject()))
      {
        bool = true;
        this.AIh.a(localBaseFinderFeed.feedObject, bool, paramj, paramInt);
        if (bool)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eTy().bmg()).intValue() == 1)
          {
            localObject2 = (TextView)paramj.UH(e.e.fav_snake_bar);
            if (localObject2 != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
              if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
                break label659;
              }
              localObject1 = (CharSequence)paramj.context.getString(e.h.finder_fav_snake_bar_tips);
              label254:
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
            if (localObject2 != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.view.animation.b.GGl;
              com.tencent.mm.plugin.finder.view.animation.b.hd((View)localObject2);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
            break label677;
          }
          localObject1 = (WeImageView)paramj.UH(e.e.icon_feed_star_first);
          WeImageView localWeImageView = new WeImageView(paramj.context);
          localWeImageView.setVisibility(4);
          paramInt = (int)paramj.context.getResources().getDimension(e.c.Edge_6_5_A);
          localObject2 = new FrameLayout.LayoutParams(paramInt, paramInt);
          ((FrameLayout.LayoutParams)localObject2).gravity = 17;
          ah localah = ah.aiuX;
          localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localWeImageView.setImageResource(e.g.finder_full_fav);
          localWeImageView.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.orange_100));
          localObject2 = paramj.UH(e.e.media_container);
          if (!(localObject2 instanceof ViewGroup)) {
            break label692;
          }
          localObject2 = (ViewGroup)localObject2;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).addView((View)localWeImageView);
          }
          localWeImageView.setLayerPaint(null);
          localWeImageView.setImageDrawable(com.tencent.mm.ui.bb.m(paramj.context, e.g.finder_full_fav, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.orange_100)));
          localObject2 = com.tencent.mm.plugin.finder.view.animation.c.GGo;
          com.tencent.mm.plugin.finder.view.animation.c.h((View)localWeImageView, null);
          localObject2 = com.tencent.mm.plugin.finder.view.animation.c.GGo;
          kotlin.g.b.s.s(localObject1, "starIcon");
          com.tencent.mm.plugin.finder.view.animation.c.hd((View)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1)
          {
            localBaseFinderFeed.isDeepEnjoy = true;
            kotlin.g.b.s.s(localBaseFinderFeed, "item");
            a(paramj, localBaseFinderFeed, true);
          }
        }
        if (!bool) {
          break label698;
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        localObject1 = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq((Context)localObject1).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.viewmodel.component.l)localObject1).a(paramj, 1, true);
        }
      }
      for (;;)
      {
        if ((!this.safeMode) || (!bool)) {
          break label739;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label741;
        }
        aa.makeText(paramj.context, e.h.finder_no_finder_user_fav_toast, 0).show();
        return;
        bool = false;
        break;
        localObject1 = (CharSequence)paramj.context.getString(e.h.finder_fav_snake_bar_tips2);
        break label254;
        localObject1 = (WeImageView)paramj.UH(e.e.icon_feed_star);
        break label312;
        localObject2 = null;
        break label429;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        if ((com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.nq((Context)localObject1).cp(com.tencent.mm.plugin.finder.viewmodel.component.v.class) != null) {
          com.tencent.mm.plugin.finder.viewmodel.component.v.V(paramj);
        }
      }
    }
    label429:
    label692:
    label741:
    aa.makeText(paramj.context, e.h.finder_no_finder_user_fav_toast2, 0).show();
    label659:
    label677:
    return;
  }
  
  private final boolean c(T paramT)
  {
    Object localObject = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    localObject = com.tencent.mm.plugin.finder.upload.action.l.fek().x(paramT.feedObject.getFeedObject());
    l.a locala = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    int i = com.tencent.mm.plugin.finder.upload.action.l.fek().w(paramT.feedObject.getFeedObject());
    if ((this.AIs) && (!Util.isNullOrNil((List)localObject)) && (i > 0) && (!this.AIh.ebw()))
    {
      localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (!com.tencent.mm.plugin.finder.utils.aw.n(paramT.contact)) {
        return true;
      }
    }
    return false;
  }
  
  private final void d(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    int j = 0;
    if (this.AIs)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      if (!Util.isNullOrNil((List)com.tencent.mm.plugin.finder.upload.action.l.fek().x(paramT.feedObject.getFeedObject())))
      {
        paramj.pt(e.e.recommend_reason_layout, 8);
        n(paramj);
        return;
      }
    }
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = paramj.context;
    kotlin.g.b.s.s(localObject, "holder.context");
    localObject = as.a.hu((Context)localObject);
    if (localObject == null) {}
    for (int i = 0;; i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).AJo) {
      switch (i)
      {
      default: 
        paramj.pt(e.e.recommend_reason_layout, 8);
        n(paramj);
        return;
      }
    }
    paramj.pt(e.e.recommend_reason_layout, 0);
    n(paramj);
    int k = paramT.feedObject.getFeedObject().recommendType;
    localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label509;
      }
      localObject = (TextView)paramj.UH(e.e.recommend_reason_tv);
      ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.White));
      com.tencent.mm.ui.aw.a((Paint)((TextView)localObject).getPaint(), 0.1F);
      ((TextView)localObject).setTextSize(1, 15.0F);
      paramT = com.tencent.mm.pluginsdk.ui.span.p.g(paramj.context, (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize());
      k = paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_2);
      paramj = paramj.context.getResources();
      if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
        break label473;
      }
    }
    label473:
    for (i = com.tencent.mm.plugin.finder.e.b.hot_tab_stream_link_color;; i = com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8)
    {
      int m = paramj.getColor(i);
      paramj = (com.tencent.mm.pluginsdk.ui.span.t[])paramT.getSpans(0, paramT.length(), com.tencent.mm.pluginsdk.ui.span.t.class);
      if (paramj == null) {
        break label480;
      }
      int n = paramj.length;
      i = j;
      while (i < n)
      {
        paramj[i].setColor(m, k);
        i += 1;
      }
      i = 0;
      break;
    }
    label480:
    paramj = ah.aiuX;
    ((TextView)localObject).setText((CharSequence)paramT);
    ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s());
    return;
    label509:
    Log.w("Finder.FeedFullConvert", "hide recommend layout type=" + k + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    paramj.pt(e.e.recommend_reason_layout, 8);
    n(paramj);
  }
  
  private static void d(com.tencent.mm.view.recyclerview.j paramj)
  {
    Object localObject = ((Iterable)kotlin.a.p.listOf(new Integer[] { Integer.valueOf(e.e.icon_feed_star_frame_first), Integer.valueOf(e.e.icon_feed_share_frame), Integer.valueOf(e.e.icon_feed_star_frame), Integer.valueOf(e.e.icon_feed_like_frame), Integer.valueOf(e.e.icon_feed_comment_frame) })).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FrameLayout localFrameLayout = (FrameLayout)paramj.UH(((Number)((Iterator)localObject).next()).intValue());
      if (localFrameLayout != null)
      {
        com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1) {}
        for (i = com.tencent.mm.cd.a.fromDPToPix(paramj.context, 10);; i = com.tencent.mm.cd.a.fromDPToPix(paramj.context, 14))
        {
          localFrameLayout.setPadding(i, 0, i, 0);
          break;
        }
      }
    }
    localObject = (FrameLayout)paramj.UH(e.e.icon_feed_comment_frame);
    int j = com.tencent.mm.cd.a.fromDPToPix(paramj.context, 16);
    if (localObject == null) {}
    for (int i = 0;; i = ((FrameLayout)localObject).getPaddingEnd())
    {
      paramj = paramj.UH(e.e.right_option_layout);
      if (paramj == null) {
        return;
      }
      localObject = paramj.getLayoutParams();
      if (localObject != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(j - i);
    paramj.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void d(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    if ((!this.AIh.ebw()) || (!paramT.feedObject.isPostFinish()))
    {
      paramj = paramj.UH(e.e.feed_self_scene_footer);
      if (paramj != null) {
        paramj.setVisibility(8);
      }
    }
    label186:
    do
    {
      return;
      Object localObject = (FlowTextMixView)paramj.UH(e.e.feed_self_scene_footer);
      if (localObject != null) {
        ((FlowTextMixView)localObject).setMaxWidth(kotlin.h.a.eH(paramj.context.getResources().getDisplayMetrics().widthPixels / 1.6F));
      }
      localObject = paramj.UH(e.e.feed_self_scene_footer);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = paramj.UH(e.e.full_friend_follow_count);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = paramj.UH(e.e.feedHeaderBar);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      if (paramT.feedObject.getPrivate_flag() == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label186;
        }
        paramj = paramj.UH(e.e.only_self_can_see_layout);
        if (paramj == null) {
          break;
        }
        paramj.setVisibility(0);
        return;
      }
      paramj = paramj.UH(e.e.only_self_can_see_layout);
    } while (paramj == null);
    paramj.setVisibility(8);
  }
  
  private boolean dXx()
  {
    return ((Boolean)this.AIo.getValue()).booleanValue();
  }
  
  private boolean dXy()
  {
    return ((Boolean)this.AIp.getValue()).booleanValue();
  }
  
  private void e(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramT, "item");
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (com.tencent.mm.plugin.finder.utils.av.e(paramT)) {
      if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().aaPw >= 100)) {
        if (paramT.isFinishPostSoon)
        {
          f(paramT, paramj);
          paramT.isFinishPostSoon = false;
        }
      }
    }
    label313:
    do
    {
      return;
      localObject1 = paramj.UH(e.e.finder_post_footer_layout);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = paramj.UH(e.e.footer_op_layout);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      Object localObject2 = (FinderPostProgressView)paramj.UH(e.e.post_upload_progress);
      ((FinderPostProgressView)localObject2).setBackColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_1));
      Object localObject3 = paramj.UH(e.e.post_uploading_layout);
      View localView2 = paramj.UH(e.e.post_fail_layout);
      TextView localTextView = (TextView)paramj.UH(e.e.fail_desc_tv);
      localObject1 = paramj.UH(e.e.post_retry_layout);
      View localView1 = paramj.UH(e.e.post_del_layout);
      localView1.setVisibility(0);
      if (paramT.feedObject.isPostFailed())
      {
        localView2.setVisibility(0);
        ((View)localObject3).setVisibility(8);
        if (!paramT.feedObject.isPostFailedCanRetry())
        {
          ((View)localObject1).setVisibility(8);
          if (!paramT.feedObject.isPostNoAuth()) {
            break label313;
          }
          localTextView.setText((CharSequence)Html.fromHtml(paramj.context.getResources().getString(e.h.finder_post_tip_failed_no_auth)));
          localTextView.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda3(this));
          ((View)localObject1).setVisibility(0);
        }
      }
      for (;;)
      {
        localView1.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda4(this, paramT));
        ((View)localObject1).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda12(paramT));
        return;
        ((View)localObject1).setVisibility(0);
        break;
        if (paramT.feedObject.isEventClosed())
        {
          localTextView.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_post_tip_failed_event_closed));
        }
        else if (paramT.feedObject.isEventExpired())
        {
          localTextView.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_post_tip_failed_event_expired));
        }
        else
        {
          localTextView.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_item_post_fail));
          continue;
          localView2.setVisibility(8);
          ((View)localObject3).setVisibility(0);
          ((View)localObject1).setVisibility(8);
          localObject3 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().aaPw });
          ((ValueAnimator)localObject3).addUpdateListener(new FinderFeedFullConvert..ExternalSyntheticLambda0((FinderPostProgressView)localObject2));
          localObject2 = ((ValueAnimator)localObject3).setDuration(400L);
          if (localObject2 != null) {
            ((ValueAnimator)localObject2).start();
          }
          paramj.tag = localObject3;
        }
      }
      paramT = paramj.UH(e.e.finder_post_footer_layout);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = paramj.UH(e.e.footer_op_layout);
    } while (paramT == null);
    paramT.setVisibility(0);
  }
  
  private final void e(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() == 1)
    {
      localObject1 = paramj.UH(e.e.star_icon_container);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
        break label90;
      }
      localObject1 = paramj.UH(e.e.star_icon_container_first);
      label72:
      if (localObject1 != null) {
        break label102;
      }
    }
    label272:
    label430:
    label942:
    for (;;)
    {
      return;
      localObject1 = paramj.UH(e.e.star_icon_container_first);
      break;
      label90:
      localObject1 = paramj.UH(e.e.star_icon_container);
      break label72;
      label102:
      if (!(this instanceof r)) {
        ((View)localObject1).setVisibility(0);
      }
      Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
          break label665;
        }
        localObject2 = paramj.UH(e.e.star_icon_container_first);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      int i;
      label480:
      String str;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1)
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.D(paramT.feedObject.getFeedObject())) {
          break label705;
        }
        i = com.tencent.mm.cd.a.w(paramj.context, com.tencent.mm.plugin.finder.e.b.finder_btn_fullscreen_disable_color);
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() == 0)
        {
          ((TextView)paramj.UH(e.e.star_count_tv)).setTextColor(i);
          paramj.UH(e.e.star_icon_container).setEnabled(false);
        }
      }
      else
      {
        localObject2 = new boolean[1];
        localObject2[0] = 0;
        ((View)localObject1).setOnTouchListener(new FinderFeedFullConvert..ExternalSyntheticLambda32((boolean[])localObject2));
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(localObject1, "finder_feed_fav");
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(localObject1, 8, 24617);
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(localObject1, new FinderFeedFullConvert..ExternalSyntheticLambda33(paramT));
        ((View)localObject1).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda24((boolean[])localObject2, this, paramj, paramT));
        localObject2 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        int j = com.tencent.mm.plugin.finder.upload.action.c.fee().t(paramT.feedObject.getFeedObject());
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
          break label799;
        }
        localObject2 = (TextView)paramj.UH(e.e.star_count_tv_first);
        if (localObject2 != null)
        {
          com.tencent.mm.ui.aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
          if ((j <= 0) && (!this.AIh.ebw())) {
            break label819;
          }
          if (this.AIh.ebw()) {
            break label814;
          }
          i = 2;
          str = com.tencent.mm.plugin.finder.utils.r.ip(i, j);
          kotlin.g.b.s.s(str, "formatNumber(\n          …arCount\n                )");
          ((View)localObject1).setTag(e.e.finder_accessibility_star_count_tag, str);
          label506:
          ((TextView)localObject2).setText((CharSequence)str);
        }
        localObject2 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        boolean bool = com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramT.feedObject.getFeedObject());
        paramT = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 1) {
          break label864;
        }
        paramT = (WeImageView)paramj.UH(e.e.icon_feed_star_first);
        label567:
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() != 1) || (bool)) {
          break label878;
        }
        localObject2 = com.tencent.mm.svg.a.a.i(paramj.context.getResources(), e.g.finder_icons_outlined_star2);
        label608:
        if (!((View)localObject1).isEnabled()) {
          break label920;
        }
        if ((!bool) || (this.AIh.ebw())) {
          break label896;
        }
        if (paramT != null) {
          paramT.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.orange_100));
        }
      }
      for (;;)
      {
        if (paramT == null) {
          break label942;
        }
        paramT.setImageDrawable((Drawable)localObject2);
        return;
        localObject2 = paramj.UH(e.e.star_icon_container);
        break;
        ((TextView)paramj.UH(e.e.star_count_tv_first)).setTextColor(i);
        paramj.UH(e.e.star_icon_container_first).setEnabled(false);
        break label272;
        label705:
        if (paramT.isPreview) {
          break label272;
        }
        i = com.tencent.mm.cd.a.w(paramj.context, com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8);
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() == 0)
        {
          ((TextView)paramj.UH(e.e.star_count_tv)).setTextColor(i);
          paramj.UH(e.e.star_icon_container).setEnabled(true);
          break label272;
        }
        ((TextView)paramj.UH(e.e.star_count_tv_first)).setTextColor(i);
        paramj.UH(e.e.star_icon_container_first).setEnabled(true);
        break label272;
        localObject2 = (TextView)paramj.UH(e.e.star_count_tv);
        break label430;
        i = 1;
        break label480;
        label819:
        str = paramj.context.getString(e.h.finder_star_icon_text);
        kotlin.g.b.s.s(str, "holder.context.getString…ng.finder_star_icon_text)");
        ((View)localObject1).setTag(e.e.finder_accessibility_star_count_tag, "0");
        com.tencent.mm.ui.aw.e((Paint)((TextView)localObject2).getPaint());
        break label506;
        label864:
        paramT = (WeImageView)paramj.UH(e.e.icon_feed_star);
        break label567;
        label878:
        localObject2 = com.tencent.mm.svg.a.a.i(paramj.context.getResources(), e.g.finder_icons_filled_star);
        break label608;
        if (paramT != null)
        {
          paramT.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
          continue;
          if (paramT != null) {
            paramT.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.finder_btn_fullscreen_disable_color));
          }
        }
      }
    }
  }
  
  private final void f(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    if ((dXx()) && (paramT != null)) {
      a(paramj, 0, paramT, 3);
    }
  }
  
  private static final void fr(View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void fs(View paramView)
  {
    kotlin.g.b.s.u(paramView, "$tips");
    paramView.setVisibility(8);
  }
  
  private static void g(com.tencent.mm.view.recyclerview.j paramj)
  {
    paramj = (ImageView)paramj.UH(e.e.icon_feed_share);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1)
    {
      paramj.setImageResource(e.g.finder_full_share_outlined);
      return;
    }
    paramj.setImageResource(e.g.finder_full_share);
  }
  
  private static void h(com.tencent.mm.view.recyclerview.j paramj)
  {
    paramj.UH(e.e.fav_icon_container).setVisibility(8);
  }
  
  private final void h(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    View localView = paramj.UH(e.e.icon_feed_self_more_btn);
    if (localView != null)
    {
      int i;
      Object localObject;
      if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().aaPw >= 100))
      {
        i = 1;
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject = paramj.context;
        kotlin.g.b.s.s(localObject, "holder.context");
        localObject = as.a.hu((Context)localObject);
        if (localObject != null) {
          break label181;
        }
      }
      label181:
      for (int j = 0;; j = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).AJo)
      {
        if (this.AIh.ebw())
        {
          localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
          if (com.tencent.mm.plugin.finder.utils.av.e(paramT)) {
            break label119;
          }
        }
        label119:
        if (((!dXy()) && (j != 21) && (j != 2)) || (paramT.feedObject.isLiveFeed()) || (i == 0)) {
          break label206;
        }
        localView.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda7(this, paramj));
        i = bf.getStatusBarHeight(paramj.context);
        paramj = localView.getLayoutParams();
        if (paramj != null) {
          break label191;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        i = 0;
        break;
      }
      label191:
      ((FrameLayout.LayoutParams)paramj).topMargin = i;
      localView.setVisibility(0);
    }
    return;
    label206:
    localView.setVisibility(8);
  }
  
  private static WeImageView i(com.tencent.mm.view.recyclerview.j paramj)
  {
    WeImageView localWeImageView = new WeImageView(paramj.context);
    localWeImageView.setVisibility(4);
    int i = (int)paramj.context.getResources().getDimension(e.c.Edge_6_5_A);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    ah localah = ah.aiuX;
    localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localWeImageView.setImageResource(e.g.finder_full_like);
    localWeImageView.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
    paramj = paramj.UH(e.e.media_container);
    if ((paramj instanceof ViewGroup)) {}
    for (paramj = (ViewGroup)paramj;; paramj = null)
    {
      if (paramj != null) {
        paramj.addView((View)localWeImageView);
      }
      return localWeImageView;
    }
  }
  
  private static void j(com.tencent.mm.view.recyclerview.j paramj)
  {
    paramj.caK.performHapticFeedback(0, 3);
  }
  
  private static void o(com.tencent.mm.view.recyclerview.j paramj)
  {
    paramj = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
    if (paramj != null) {
      paramj.fiN();
    }
  }
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.mkw = paramRecyclerView;
  }
  
  public void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramj.caK.getLayoutParams().width = -1;
    paramj.caK.getLayoutParams().height = -1;
    paramRecyclerView.getLayoutParams().height = -1;
    paramRecyclerView.getLayoutParams().width = -1;
    Object localObject1 = paramRecyclerView.getParent();
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject1).getLayoutParams().width = -1;
    paramRecyclerView = paramRecyclerView.getParent();
    if (paramRecyclerView == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)paramRecyclerView).getLayoutParams().height = -1;
    paramRecyclerView = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    paramRecyclerView.setIndicatorStyle(MediaBanner.d.agHl);
    paramRecyclerView.setNeedSpaceView(false);
    paramRecyclerView.removeView((View)paramRecyclerView.GBo);
    paramRecyclerView = new FinderFeedFullConvert..ExternalSyntheticLambda6(this, paramj);
    Object localObject2 = (TextView)paramj.caK.findViewById(e.e.nickname);
    localObject1 = (FlowTextMixView)paramj.caK.findViewById(e.e.flow_text_mix_view);
    com.tencent.mm.ui.aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
    localObject2 = paramj.context;
    if (localObject2 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    ((FlowTextMixView)localObject1).setMaxWidth((int)(((Activity)localObject2).getBaseContext().getResources().getDisplayMetrics().widthPixels * 0.36F));
    localObject1 = (ImageView)paramj.UH(e.e.avatar_iv);
    ((ImageView)localObject1).setOnClickListener(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYi().bmg()).intValue() > 0) {
      ((ImageView)localObject1).setOnLongClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda28(paramj, this));
    }
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(localObject1, "finder_feed_avatar");
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(localObject1, 8, 24617);
    paramRecyclerView = (NeatTextView)paramj.UH(e.e.text_content);
    localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    kotlin.g.b.s.s(paramRecyclerView, "contentTv");
    paramRecyclerView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.l(paramRecyclerView, com.tencent.mm.plugin.finder.utils.av.gS((View)paramRecyclerView)));
    paramRecyclerView = new StateListener(this, paramj);
    paramj.caK.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
    paramRecyclerView.alive();
    this.AIk.add(paramRecyclerView);
    localObject1 = paramj.UH(e.e.footer_op_layout);
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(FinderFeedFullConvert..ExternalSyntheticLambda26.INSTANCE);
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.read_count_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      localObject2 = (TextView)((View)localObject1).findViewById(e.e.fav_count_tv);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setTextSize(1, 12.0F);
        paramRecyclerView = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label721;
        }
      }
    }
    label721:
    for (paramRecyclerView = (CharSequence)paramj.context.getString(e.h.finder_fav_icon_text);; paramRecyclerView = (CharSequence)paramj.context.getString(e.h.finder_fav_icon_text2))
    {
      ((TextView)localObject2).setText(paramRecyclerView);
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.share_count_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.like_count_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.star_count_tv_first);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.star_count_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)((View)localObject1).findViewById(e.e.comment_count_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)paramj.UH(e.e.little_follow_tv);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 10.0F);
      }
      paramRecyclerView = paramj.UH(e.e.star_icon_container_first);
      if (paramRecyclerView != null) {
        paramRecyclerView.setVisibility(8);
      }
      paramRecyclerView = paramj.UH(e.e.star_icon_container);
      if (paramRecyclerView != null) {
        paramRecyclerView.setVisibility(8);
      }
      d(paramj);
      return;
    }
  }
  
  protected void a(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    kotlin.g.b.s.u(parama, "ev");
    Object localObject1 = this.mkw;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        break label52;
      }
    }
    label52:
    for (localObject1 = (WxRecyclerAdapter)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label58;
      }
      return;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break;
    }
    label58:
    localObject1 = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, parama.feedId);
    Object localObject2;
    final ah.f localf;
    if (localObject1 != null)
    {
      localObject2 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
      if (localObject2 != null)
      {
        localf = new ah.f();
        localf.aqH = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.guide_hot_layout_parent);
        parama = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eWK().bmg()).intValue() != 1) {
          break label854;
        }
        parama = this.AIh;
        if (!(parama instanceof bg)) {
          break label682;
        }
        parama = (bg)parama;
        if (parama == null) {
          break label942;
        }
        parama = (MMFinderFragment)parama.AZg;
        if (parama == null) {
          break label942;
        }
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      }
    }
    label289:
    label293:
    label682:
    label940:
    label942:
    for (boolean bool = ((ab)com.tencent.mm.ui.component.k.y((Fragment)parama).q(ab.class)).fnI();; bool = false)
    {
      parama = ((BaseFinderFeed)localObject2).streamDivider;
      if ((parama != null) && (parama.aadB == 10))
      {
        i = 1;
        label216:
        if ((i == 0) || (bool)) {
          break label749;
        }
        if (localf.aqH == null)
        {
          parama = (ViewStub)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e._feed_full_guide_hot_layout_vs);
          if (parama != null) {
            break label692;
          }
          parama = null;
          label250:
          localf.aqH = parama;
        }
        parama = ((BaseFinderFeed)localObject2).streamDivider;
        if (parama != null)
        {
          parama = parama.wording;
          if (parama != null)
          {
            if (((CharSequence)parama).length() <= 0) {
              break label700;
            }
            i = 1;
            if (i == 0) {
              break label705;
            }
            if (parama != null)
            {
              localObject1 = (View)localf.aqH;
              if (localObject1 != null) {
                break label710;
              }
              localObject1 = null;
              label315:
              if (localObject1 != null) {
                ((TextView)localObject1).setText((CharSequence)parama);
              }
            }
          }
        }
        parama = (View)localf.aqH;
        if (parama != null) {
          parama.setVisibility(0);
        }
        ((View)localf.aqH).setTranslationX(0.0F);
        if (!((BaseFinderFeed)localObject2).isHasShowGuideHot)
        {
          parama = (View)localf.aqH;
          if (parama != null) {
            break label726;
          }
          parama = null;
          label382:
          if (!(parama instanceof View)) {
            break label734;
          }
          parama = (View)parama;
          if (parama != null) {
            ((View)localf.aqH).setTranslationX(parama.getContext().getResources().getDisplayMetrics().widthPixels);
          }
          parama = (kotlin.g.a.a)new v((BaseFinderFeed)localObject2, localf);
          if (((View)localf.aqH).getHeight() > 0) {
            break label739;
          }
          ((View)localf.aqH).post(new FinderFeedFullConvert..ExternalSyntheticLambda42(parama));
        }
        label472:
        parama = this.AIh;
        if (!(parama instanceof bg)) {
          break label876;
        }
        parama = (bg)parama;
        label489:
        if (parama != null)
        {
          parama = (MMFinderFragment)parama.AZg;
          if ((parama != null) && ((parama instanceof FinderHomeTabFragment)) && (((FinderHomeTabFragment)parama).hJx == 1))
          {
            localObject1 = com.tencent.mm.ui.component.k.aeZF;
            ((ab)com.tencent.mm.ui.component.k.y((Fragment)parama).q(ab.class)).t((BaseFinderFeed)localObject2);
          }
        }
        parama = this.AIh.getActivity();
        if (parama != null) {
          break label881;
        }
        parama = "";
        label567:
        localObject1 = com.tencent.mm.plugin.findersdk.a.n.Hcg;
        if (!kotlin.g.b.s.p(com.tencent.mm.plugin.findersdk.a.n.frC(), parama)) {
          break;
        }
        if (((CharSequence)parama).length() <= 0) {
          break label937;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label940;
        }
        localObject1 = com.tencent.mm.plugin.findersdk.a.n.Hcg;
        com.tencent.mm.plugin.findersdk.a.n.aDc("");
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        long l = System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.findersdk.a.n.Hcg;
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(23669, new Object[] { parama, "feed_play", Long.valueOf(l - com.tencent.mm.plugin.findersdk.a.n.frE()), "", Integer.valueOf(1), Integer.valueOf(1) });
        return;
        parama = null;
        break;
        i = 0;
        break label216;
        label692:
        parama = parama.inflate();
        break label250;
        label700:
        i = 0;
        break label289;
        label705:
        parama = null;
        break label293;
        label710:
        localObject1 = (TextView)((View)localObject1).findViewById(e.e.guide_hot_tips_tv);
        break label315;
        label726:
        parama = parama.getParent();
        break label382;
        label734:
        parama = null;
        break label394;
        label739:
        parama.invoke();
        break label472;
        label749:
        parama = (View)localf.aqH;
        if (parama != null)
        {
          parama = parama.animate();
          if (parama != null) {
            parama.cancel();
          }
        }
        parama = (View)localf.aqH;
        if (parama == null)
        {
          parama = null;
          if (!(parama instanceof View)) {
            break label849;
          }
        }
        label849:
        for (parama = (View)parama;; parama = null)
        {
          if (parama != null)
          {
            parama = parama.animate();
            if (parama != null) {
              parama.cancel();
            }
          }
          parama = (View)localf.aqH;
          if (parama == null) {
            break;
          }
          parama.setVisibility(8);
          break;
          parama = parama.getParent();
          break label790;
        }
        label854:
        parama = (View)localf.aqH;
        if (parama == null) {
          break label472;
        }
        parama.setVisibility(8);
        break label472;
        label876:
        parama = null;
        break label489;
        label881:
        parama = parama.getContext();
        if (parama == null)
        {
          parama = "";
          break label567;
        }
        parama = parama.getIntent();
        if (parama == null)
        {
          parama = "";
          break label567;
        }
        localObject1 = parama.getStringExtra("KEY_TASK_ID");
        parama = (com.tencent.mm.plugin.finder.event.c.a)localObject1;
        if (localObject1 != null) {
          break label567;
        }
        parama = "";
        break label567;
      }
      break;
    }
  }
  
  public void a(T paramT, final com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean, int paramInt)
  {
    kotlin.g.b.s.u(paramT, "item");
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    Object localObject2 = com.tencent.mm.plugin.finder.upload.action.l.fek().x(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    int m = com.tencent.mm.plugin.finder.upload.action.l.fek().w(paramT.feedObject.getFeedObject());
    if (!c(paramT))
    {
      Log.i("Finder.FeedFullConvert", "[refreshRealNameRecommendLayout] tabType:" + this.hJx + ", " + Util.isNullOrNil((List)localObject2) + ", " + m + ' ' + this.AIs);
      paramT = paramj.UH(e.e.real_name_recommend_layout);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVP().bmg()).intValue() == 1)
      {
        paramT = paramj.UH(e.e.follow_like_big_layout);
        paramT.setVisibility(8);
        n(paramj);
      }
    }
    final float f;
    boolean bool;
    do
    {
      return;
      paramT = paramj.UH(e.e.follow_like_layout);
      break;
      if (!this.AIt) {
        break label468;
      }
      f = 0.1F;
      bool = this.AIt;
      localObject1 = paramj.UH(e.e.real_name_recommend_layout);
    } while (localObject1 == null);
    ((View)localObject1).setVisibility(0);
    Object localObject3 = (List)new ArrayList();
    ((List)localObject3).add(paramj.UH(e.e.friend_avatar_1));
    ((List)localObject3).add(paramj.UH(e.e.friend_avatar_2));
    ((List)localObject3).add(paramj.UH(e.e.friend_avatar_3));
    Object localObject4 = (List)new ArrayList();
    Object localObject5 = (FrameLayout)paramj.UH(e.e.friend_avatar_1_layout);
    Object localObject6 = (FrameLayout)paramj.UH(e.e.friend_avatar_2_layout);
    FrameLayout localFrameLayout = (FrameLayout)paramj.UH(e.e.friend_avatar_3_layout);
    Object localObject7 = (FrameLayout)paramj.UH(e.e.friend_avatar_layout_extra);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVP().bmg()).intValue() == 1) {}
    int i;
    int j;
    for (localObject1 = kotlin.v.Y(Integer.valueOf((int)paramj.context.getResources().getDimension(e.c.Edge_4_5_A)), Integer.valueOf((int)paramj.context.getResources().getDimension(e.c.Edge_4A)));; localObject1 = kotlin.v.Y(Integer.valueOf((int)paramj.context.getResources().getDimension(e.c.Edge_3A)), Integer.valueOf((int)paramj.context.getResources().getDimension(e.c.Edge_2_5_A))))
    {
      i = ((Number)((kotlin.r)localObject1).bsC).intValue();
      j = ((Number)((kotlin.r)localObject1).bsD).intValue();
      if (!this.AIt) {
        break label868;
      }
      localObject1 = ((FrameLayout)localObject5).getLayoutParams();
      if (localObject1 != null) {
        break label518;
      }
      throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      label468:
      f = 0.5F;
      break;
    }
    label518:
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).width = i;
    ((FrameLayout.LayoutParams)localObject1).height = i;
    ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((FrameLayout)localObject6).getLayoutParams();
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).leftMargin = i;
    ((FrameLayout.LayoutParams)localObject1).width = i;
    ((FrameLayout.LayoutParams)localObject1).height = i;
    ((FrameLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = localFrameLayout.getLayoutParams();
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).leftMargin = (i * 2);
    ((FrameLayout.LayoutParams)localObject1).width = i;
    ((FrameLayout.LayoutParams)localObject1).height = i;
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((FrameLayout)localObject7).getLayoutParams();
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).width = i;
    ((FrameLayout.LayoutParams)localObject1).height = i;
    ((FrameLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject7 = ((List)localObject3).iterator();
    if (((Iterator)localObject7).hasNext())
    {
      ImageView localImageView = (ImageView)((Iterator)localObject7).next();
      if (localImageView == null) {}
      for (localObject1 = null;; localObject1 = localImageView.getLayoutParams())
      {
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).width = j;
        }
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = j;
        }
        if (localImageView == null) {
          break;
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    localObject7 = paramj.UH(e.e.friend_avatar_extra);
    label868:
    int k;
    label1187:
    label1210:
    int n;
    if (localObject7 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = j;
      }
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).height = j;
      }
      if (localObject7 != null) {
        ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      ((List)localObject4).add(localObject5);
      ((List)localObject4).add(localObject6);
      ((List)localObject4).add(localFrameLayout);
      localObject1 = (RoundLinearLayout)paramj.UH(e.e.bg_color_layout1);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        ((RoundLinearLayout)localObject1).getChildAt(0).setBackground(null);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = (RoundLinearLayout)paramj.UH(e.e.bg_color_layout2);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        ((RoundLinearLayout)localObject1).getChildAt(0).setBackground(null);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = (RoundLinearLayout)paramj.UH(e.e.bg_color_layout3);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        ((RoundLinearLayout)localObject1).getChildAt(0).setBackground(null);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = (RoundLinearLayout)paramj.UH(e.e.friend_avatar_extra_layout);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = ah.aiuX;
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
      ((kotlin.g.a.a)new z((List)localObject3, (kotlin.g.a.a)new y(paramBoolean, ((Boolean)((kotlin.r)localObject1).bsC).booleanValue(), ((Boolean)((kotlin.r)localObject1).bsD).booleanValue(), (LinkedList)localObject2), this, (LinkedList)localObject2, (List)localObject4, paramj, f)).invoke();
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!bool) {
        break label1998;
      }
      if (((LinkedList)localObject2).size() > 3) {
        break label1926;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = (FinderCommentInfo)kotlin.a.p.oN((List)localObject2);
      if (localObject1 != null) {
        break label1879;
      }
      localObject1 = "";
      localObject2 = (FinderCommentInfo)kotlin.a.p.oN((List)localObject2);
      if (localObject2 != null) {
        break label1902;
      }
      localObject2 = "";
      localObject1 = com.tencent.mm.plugin.finder.utils.av.ip((String)localObject1, (String)localObject2);
      localObject3 = com.tencent.mm.plugin.finder.utils.av.aBy((String)localObject1);
      localObject1 = (TextView)paramj.UH(e.e.real_name_recommend_nickname);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
        com.tencent.mm.ui.aw.a((Paint)((TextView)localObject1).getPaint(), 0.1F);
        ((TextView)localObject1).setTextSize(1, 15.0F);
        ((TextView)localObject1).setText((CharSequence)"");
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject2 = (TextView)paramj.UH(e.e.real_name_recommend_desc);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
      com.tencent.mm.ui.aw.a((Paint)((TextView)localObject2).getPaint(), 0.1F);
      ((TextView)localObject2).setTextSize(1, 15.0F);
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramBoolean = com.tencent.mm.plugin.finder.utils.av.q(paramT);
      k = paramT.feedObject.getFeedObject().incFriendLikeCount;
      n = m - k;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.h.TA(paramT.feedObject.getFeedObject().objectType);
      bool = b(paramT);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWf().bmg()).intValue() != 2) {
        break label2070;
      }
      i = 1;
      label1443:
      if (m > 1) {
        break label2084;
      }
      if (localObject4 == null)
      {
        if (bool) {
          break label2076;
        }
        localObject1 = paramj.context.getString(e.h.finder_real_name_recommend_desc2);
        label1471:
        kotlin.g.b.s.s(localObject1, "{\n                    if…      }\n                }");
      }
      kotlin.g.b.s.s(paramj.context.getString(e.h.finder_acc_real_name_recommend_desc2), "holder.context.getString…eal_name_recommend_desc2)");
      i = 1;
      if (m > 1) {
        break label2275;
      }
      localObject1 = paramj.context.getString(e.h.finder_acc_real_name_recommend_desc2);
      kotlin.g.b.s.s(localObject1, "{\n                holder…mend_desc2)\n            }");
      label1524:
      localObject5 = new cg();
      kotlin.g.b.s.s(localObject2, "descTv");
      localObject6 = paramj.context;
      kotlin.g.b.s.s(localObject6, "holder.context");
      if ((k <= 0) || (!paramBoolean)) {
        break label2316;
      }
      j = k;
      label1568:
      cg.a((cg)localObject5, paramInt, (TextView)localObject2, (Context)localObject6, (String)localObject3, bool, m, j, (brk)localObject4, paramBoolean, i, paramT.feedObject.getId());
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVq().bmg()).intValue() != 1) {
        break label2322;
      }
      paramInt = 1;
      label1623:
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVP().bmg()).intValue() != 1) {
        break label2328;
      }
      localObject2 = paramj.UH(e.e.follow_like_big_layout);
      label1653:
      if (paramInt == 0) {
        break label2355;
      }
      localObject4 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject4 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
      bool = ((Boolean)((kotlin.r)localObject4).bsC).booleanValue();
      ((Boolean)((kotlin.r)localObject4).bsD).booleanValue();
      if ((paramT.isDeepEnjoy) && (!bool)) {
        break label2340;
      }
      ((View)localObject2).setVisibility(8);
      label1722:
      ((View)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda17(paramj, paramT, (View)localObject2));
      label1738:
      localObject2 = (ViewGroup)paramj.UH(e.e.real_name_recommend_list);
      if (localObject2 != null)
      {
        ((ViewGroup)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda19(paramj, paramT, this));
        paramT = ah.aiuX;
      }
      if ((k <= 0) || (!paramBoolean)) {
        break label2365;
      }
    }
    label1926:
    label2070:
    label2076:
    label2084:
    label2232:
    label2365:
    for (paramT = paramj.context.getString(e.h.finder_new_friend_like, new Object[] { Integer.valueOf(k) });; paramT = "")
    {
      kotlin.g.b.s.s(paramT, "if(incCount > 0 && isMsg…         \"\"\n            }");
      if (localObject2 != null)
      {
        ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_nickname_tag, localObject3);
        ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_content_desc_tag, localObject1);
        ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_content_suffix_tag, paramT);
        paramT = ah.aiuX;
        paramT = ah.aiuX;
      }
      n(paramj);
      paramT = ah.aiuX;
      paramT = ah.aiuX;
      return;
      localObject1 = ((View)localObject7).getLayoutParams();
      break;
      label1879:
      localObject1 = ((FinderCommentInfo)localObject1).username;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label1187;
      }
      break label1187;
      label1902:
      localObject3 = ((FinderCommentInfo)localObject2).nickname;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label1210;
      }
      localObject2 = "";
      break label1210;
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = ((FinderCommentInfo)((LinkedList)localObject2).get(2)).username;
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject3 = ((FinderCommentInfo)((LinkedList)localObject2).get(2)).nickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.av.ip((String)localObject1, (String)localObject2);
        break;
      }
      label1998:
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = ((FinderCommentInfo)((LinkedList)localObject2).get(0)).username;
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject3 = ((FinderCommentInfo)((LinkedList)localObject2).get(0)).nickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.av.ip((String)localObject1, (String)localObject2);
        break;
      }
      i = 0;
      break label1443;
      localObject1 = "";
      break label1471;
      if (localObject4 != null)
      {
        localObject1 = (CharSequence)((brk)localObject4).ZZs;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          j = 1;
          label2117:
          if (j == 0) {
            break label2232;
          }
        }
      }
      else
      {
        if (bool) {
          break label2202;
        }
        localObject1 = paramj.context.getString(e.h.finder_real_name_recommend_desc1, new Object[] { String.valueOf(n + k) });
        label2154:
        kotlin.g.b.s.s(localObject1, "{\n                    if…      }\n                }");
      }
      for (;;)
      {
        kotlin.g.b.s.s(paramj.context.getString(e.h.finder_acc_real_name_recommend_desc1, new Object[] { String.valueOf(n + k) }), "holder.context.getString…t + incCount).toString())");
        break;
        j = 0;
        break label2117;
        localObject1 = paramj.context.getString(e.h.finder_real_name_recommend_desc2_news_1, new Object[] { String.valueOf(n + k) });
        break label2154;
        if ((!bool) || (i == 0))
        {
          localObject1 = ((brk)localObject4).ZZs;
          if (localObject1 != null) {
            kotlin.n.n.m((String)localObject1, "$$", String.valueOf(n + k), true);
          }
        }
      }
      label2275:
      i = 2;
      localObject1 = paramj.context.getString(e.h.finder_acc_real_name_recommend_desc1, new Object[] { String.valueOf(n + k) });
      kotlin.g.b.s.s(localObject1, "{\n                type =…toString())\n            }");
      break label1524;
      j = 0;
      break label1568;
      paramInt = 0;
      break label1623;
      localObject2 = paramj.UH(e.e.follow_like_layout);
      break label1653;
      ((View)localObject2).setVisibility(0);
      ((View)localObject2).setAlpha(1.0F);
      break label1722;
      ((View)localObject2).setVisibility(8);
      break label1738;
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt1, int paramInt2, int paramInt3)
  {
    kotlin.g.b.s.u(paramj, "holder");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    Object localObject2 = new StringBuilder("[onDeepEnjoyMedia] ");
    Object localObject1 = localBaseFinderFeed.contact;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FeedFullConvert", localObject1 + " position=" + paramInt1 + " type=" + paramInt2 + " source=" + paramInt3 + " feedId=" + com.tencent.mm.ae.d.hF(localBaseFinderFeed.bZA()));
      if (!this.AIh.ebw()) {
        break label130;
      }
    }
    label130:
    do
    {
      return;
      localObject1 = ((m)localObject1).getNickname();
      break;
      switch (paramInt3)
      {
      case 1: 
      default: 
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        localObject1 = (com.tencent.mm.plugin.finder.feed.component.e)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.feed.component.e.class);
        kotlin.g.b.s.s(localBaseFinderFeed, "item");
        localObject2 = paramj.caK;
        kotlin.g.b.s.s(localObject2, "holder.itemView");
        ((com.tencent.mm.plugin.finder.feed.component.e)localObject1).b(localBaseFinderFeed, (View)localObject2);
      }
    } while (localBaseFinderFeed.isDeepEnjoy);
    localBaseFinderFeed.isDeepEnjoy = true;
    a(paramj, localBaseFinderFeed, true);
    b(paramj, localBaseFinderFeed);
    a(localBaseFinderFeed, paramj);
    k(paramj);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = paramj.context;
    kotlin.g.b.s.s(localObject1, "holder.context");
    localObject1 = (com.tencent.mm.plugin.finder.feed.component.e)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.feed.component.e.class);
    paramj = paramj.caK;
    kotlin.g.b.s.s(paramj, "holder.itemView");
    ((com.tencent.mm.plugin.finder.feed.component.e)localObject1).c(localBaseFinderFeed, paramj);
    return;
    kotlin.g.b.s.s(localBaseFinderFeed, "item");
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    label354:
    boolean bool1;
    label391:
    label407:
    label435:
    label456:
    boolean bool2;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVv().bmg()).intValue() == 1)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label729;
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = paramj.context;
      kotlin.g.b.s.s(localObject1, "holder.context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null) {
        break label731;
      }
      paramInt1 = 0;
      localObject1 = paramj.getRecyclerView().getAdapter();
      if (localObject1 != null) {
        break label740;
      }
      paramInt2 = 0;
      localObject1 = this.AIh.ebA();
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.view.f)localObject1).fkp() != true)) {
        break label749;
      }
      bool1 = true;
      localObject1 = paramj.context;
      if (!(localObject1 instanceof Activity)) {
        break label755;
      }
      localObject1 = (Activity)localObject1;
      if (localObject1 == null) {
        break label761;
      }
      localObject1 = (FinderLikeDrawer)((Activity)localObject1).findViewById(e.e.finder_feed_friend_like_drawer);
      if ((localObject1 == null) || (((FinderLikeDrawer)localObject1).fkp() != true)) {
        break label761;
      }
      bool2 = true;
      label491:
      localObject1 = paramj.UH(e.e.share_icon_container);
      if (localObject1 != null) {
        break label767;
      }
    }
    label729:
    label731:
    label740:
    label749:
    label755:
    label761:
    label767:
    for (boolean bool3 = false;; bool3 = kotlin.g.b.s.p(((View)localObject1).getTag(), Boolean.TRUE))
    {
      Log.i("Finder.FeedFullConvert", "[checkScrollToNextFeed] isDrawerOpen=" + bool1 + " isLikeDrawerOpen=" + bool2 + " isShowBottomSheet=" + bool3 + " position=" + paramj.KJ() + " itemCount=" + paramInt2 + " commentScene=" + paramInt1);
      if ((bool3) || (bool1) || (bool2) || (paramj.KJ() + 1 >= paramInt2) || (paramj.KJ() < 0) || ((paramInt1 != 38) && (paramInt1 != 25))) {
        break;
      }
      localObject1 = paramj.getRecyclerView();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramj.KJ() + 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      break;
      paramInt1 = 0;
      break label354;
      break;
      paramInt1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).AJo;
      break label391;
      paramInt2 = ((RecyclerView.a)localObject1).getItemCount();
      break label407;
      bool1 = false;
      break label435;
      localObject1 = null;
      break label456;
      bool2 = false;
      break label491;
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject = (BaseFinderFeed)paramj.CSA;
    FinderFullSeekBarLayout localFinderFullSeekBarLayout = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
    if (localFinderFullSeekBarLayout != null)
    {
      boolean bool = localFinderFullSeekBarLayout.hLy;
      Log.i("Finder.FeedFullConvert", "[onUnFocusFeedCenter] tabType=" + this.hJx + " pos=" + paramInt1 + " isInSeekMode=" + localFinderFullSeekBarLayout.Gnn + " isPlaying=" + bool + " id=" + com.tencent.mm.ae.d.hF(((BaseFinderFeed)localObject).bZA()));
      if ((localFinderFullSeekBarLayout.Gnn) && (bool)) {
        localFinderFullSeekBarLayout.aCk("onUnFocusFeedCenter");
      }
      localFinderFullSeekBarLayout.fiN();
    }
    localObject = paramj.UH(e.e.finder_self_feed_like_tips_layout);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (paramBoolean) {
      l(paramj);
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, View paramView, MotionEvent paramMotionEvent)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramMotionEvent, "e");
    Object localObject2 = (BaseFinderFeed)paramj.CSA;
    if (!((BaseFinderFeed)localObject2).feedObject.isPostFinish()) {}
    Object localObject1;
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.AIh.ebw()) || (((BaseFinderFeed)localObject2).isPreview));
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      } while (!com.tencent.mm.plugin.finder.utils.av.E(((BaseFinderFeed)localObject2).feedObject.getFeedObject()));
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.fek().u(((BaseFinderFeed)localObject2).feedObject.getFeedObject());
      bool1 = ((Boolean)((kotlin.r)localObject1).bsC).booleanValue();
      bool2 = ((Boolean)((kotlin.r)localObject1).bsD).booleanValue();
    } while ((bool1) && (bool2));
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("feed_like_double_tap", paramView, null, 24617);
    if (bool1)
    {
      localObject1 = i(paramj);
      paramView = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      paramView = com.tencent.mm.plugin.finder.storage.logic.h.TA(((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectType);
      int i;
      if (paramView == null)
      {
        paramView = "";
        Object localObject3 = (CharSequence)paramView;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label308;
        }
        i = 1;
        label222:
        if (i != 0) {
          break label314;
        }
        paramj = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramj = com.tencent.mm.plugin.finder.loader.p.eCl();
        paramView = new com.tencent.mm.plugin.finder.loader.s(paramView, com.tencent.mm.plugin.finder.storage.v.FKY);
        localObject2 = (ImageView)localObject1;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramj.a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExY));
      }
      for (;;)
      {
        paramj = com.tencent.mm.plugin.finder.view.animation.c.GGo;
        com.tencent.mm.plugin.finder.view.animation.c.h((View)localObject1, paramMotionEvent);
        return;
        if (com.tencent.mm.ui.aw.isDarkMode())
        {
          paramView = paramView.ZZx;
          break;
        }
        paramView = paramView.ZZy;
        break;
        label308:
        i = 0;
        break label222;
        label314:
        paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (com.tencent.mm.plugin.finder.utils.aw.n(((BaseFinderFeed)localObject2).contact)) {
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.ui.bb.m(paramj.context, e.g.finder_filled_like_lock, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90)));
        } else {
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.ui.bb.m(paramj.context, e.g.finder_full_like, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90)));
        }
      }
    }
    a(paramj, 2, false, paramMotionEvent);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, View paramView, T paramT)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramT, "item");
    Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("[onMediaLongClick] feedId=", com.tencent.mm.ae.d.hF(paramT.bZA())));
    if ((a(paramT)) && ((paramT.bZB() == 4) || (paramT.bZB() == 2)) && (!paramT.isPreview))
    {
      paramView.performHapticFeedback(0, 2);
      a(paramj, paramT, paramView, 3);
    }
  }
  
  public abstract void a(com.tencent.mm.view.recyclerview.j paramj, T paramT, int paramInt1, int paramInt2);
  
  public void a(final com.tencent.mm.view.recyclerview.j paramj, final T paramT, final int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramT, "item");
    paramT.feedObject.setReplaceLongVideoToNormal(true);
    Object localObject1 = (Collection)paramList;
    int i;
    int j;
    label264:
    boolean bool1;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = ((Iterable)paramList).iterator();
        i = 1;
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1204;
        }
        paramList = ((Iterator)localObject1).next();
        if ((paramList instanceof kotlin.r))
        {
          paramList = (kotlin.r)paramList;
          boolean bool2;
          long l;
          switch (((Number)paramList.bsC).intValue())
          {
          case 26: 
          case 5: 
          case 7: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 20: 
          case 21: 
          case 22: 
          default: 
            j = 0;
            paramList = ah.aiuX;
            i = j;
            continue;
            i = 0;
            break;
          case 1: 
            c(paramT, paramj);
            break;
          case 2: 
            e(paramT, paramj);
            break;
          case 11: 
            c(paramT, paramj);
            break;
          case 9: 
            b(paramT, paramj);
            break;
          case 10: 
            paramList = paramT.feedObject;
            paramList.setForwardCount(paramList.getForwardCount() + 1);
            b(paramT, paramj);
            break;
          case 12: 
            c(paramT, paramj);
            b(paramT, paramj);
            paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
            paramList = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
            bool1 = ((Boolean)paramList.bsC).booleanValue();
            bool2 = ((Boolean)paramList.bsD).booleanValue();
            paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
            a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.l.fek().v(paramT.feedObject.getFeedObject()), paramj);
            break;
          case 3: 
            paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
            paramList = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
            bool1 = ((Boolean)paramList.bsC).booleanValue();
            bool2 = ((Boolean)paramList.bsD).booleanValue();
            paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
            a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.l.fek().v(paramT.feedObject.getFeedObject()), paramj);
            a(paramT, paramj, true, paramInt1);
            d(paramT, paramj);
            paramList = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
            if ((bool1) && (bool2)) {}
            for (bool1 = true;; bool1 = false)
            {
              paramList.uw(bool1);
              break;
            }
          case 4: 
            e(paramj, paramT);
            h(paramj);
            break;
          case 6: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.autogen.events.FeedUpdateEvent");
            }
            paramList = (if)paramList;
            if (paramList.hJB.hJD == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramT.showCommentEdu = bool1;
              if (paramT.feedObject.isCommentClose()) {
                break;
              }
              a(paramj, paramT, paramList.hJB.hJC);
              break;
            }
          case 8: 
            a(paramj, paramT.feedObject, Boolean.TRUE);
            g(paramj, paramT);
            break;
          case 23: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            a(paramj, paramInt1, paramT, ((Boolean)paramList).booleanValue());
            break;
          case 24: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            a(paramj, paramInt1, paramT, ((Integer)paramList).intValue());
            break;
          case 25: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            a(paramj, paramInt1, paramT, ((Integer)paramList).intValue());
            break;
          case 27: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            a(paramj, paramInt1, paramT, ((Integer)paramList).intValue());
            break;
          case 28: 
            paramList = paramList.bsD;
            if (paramList == null) {
              throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            a(paramj, paramInt1, paramT, ((Integer)paramList).intValue());
            break;
          case 29: 
            l(paramj);
            break;
          case 30: 
            paramList = paramj.CSA;
            kotlin.g.b.s.s(paramList, "holder.getAssociatedObject()");
            c(paramj, (BaseFinderFeed)paramList);
            break;
          case 31: 
            paramList = paramList.bsD;
            if ((paramList instanceof if)) {}
            for (paramList = (if)paramList;; paramList = null)
            {
              j = i;
              if (paramList == null) {
                break label264;
              }
              l = paramList.hJB.hJI;
              if (paramList.hJB.hJF != 1) {
                break label1043;
              }
              localObject2 = com.tencent.mm.ui.component.k.aeZF;
              localObject2 = paramj.context;
              kotlin.g.b.s.s(localObject2, "holder.context");
              localObject2 = (com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.nq((Context)localObject2).cp(com.tencent.mm.plugin.finder.viewmodel.component.v.class);
              if (localObject2 == null) {
                break;
              }
              ((com.tencent.mm.plugin.finder.viewmodel.component.v)localObject2).a((cc)paramT, paramj, l, paramList.hJB.hJE);
              paramList = ah.aiuX;
              break;
            }
            paramList = com.tencent.mm.ui.component.k.aeZF;
            paramList = paramj.context;
            kotlin.g.b.s.s(paramList, "holder.context");
            if ((com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.v.class) == null) {
              continue;
            }
            com.tencent.mm.plugin.finder.viewmodel.component.v.a((cc)paramT, paramj, l);
            paramList = ah.aiuX;
            break;
          case 32: 
            label1043:
            paramList = paramList.bsD;
            if ((paramList instanceof if)) {}
            for (paramList = (if)paramList;; paramList = null)
            {
              j = i;
              if (paramList == null) {
                break label264;
              }
              l = paramList.hJB.hJI;
              paramList = com.tencent.mm.ui.component.k.aeZF;
              paramList = paramj.context;
              kotlin.g.b.s.s(paramList, "holder.context");
              if ((com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.v.class) == null) {
                break;
              }
              com.tencent.mm.plugin.finder.viewmodel.component.v.b((cc)paramT, paramj, l);
              paramList = ah.aiuX;
              break;
            }
          }
        }
        i = 0;
      }
      label1204:
      if (i != 0) {
        return;
      }
    }
    if (!paramBoolean) {
      a(paramj, paramT, paramInt1, paramInt2);
    }
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.caK, "finder_feed_item_view");
    localObject1 = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
    Object localObject2 = paramj.caK;
    Object localObject3 = kotlin.v.Y("feed_id", com.tencent.mm.ae.d.hF(paramT.feedObject.getFeedObject().id));
    Object localObject4 = kotlin.v.Y("session_buffer", paramT.feedObject.getFeedObject().sessionBuffer);
    paramList = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramList = paramj.context;
    kotlin.g.b.s.s(paramList, "holder.context");
    paramList = as.a.hu(paramList);
    if (paramList == null)
    {
      paramList = null;
      label1335:
      ((com.tencent.mm.plugin.datareport.a.b)localObject1).a(localObject2, kotlin.a.ak.e(new kotlin.r[] { localObject3, localObject4, kotlin.v.Y("comment_scene", paramList), kotlin.v.Y("finder_username", paramT.feedObject.getFeedObject().username), kotlin.v.Y("media_type", Integer.valueOf(paramT.feedObject.getMediaType())), kotlin.v.Y("long_video_id", com.tencent.mm.ae.d.hF(paramT.bZA())), kotlin.v.Y("feed_display_type", Integer.valueOf(1)) }));
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(paramj.caK, new FinderFeedFullConvert..ExternalSyntheticLambda35(paramj));
      paramj.caK.findViewById(e.e.item_mask).setAlpha(0.0F);
      c(paramj, paramT);
      l(paramj);
      if (paramT.isPreview)
      {
        paramInt2 = com.tencent.mm.cd.a.w(paramj.context, com.tencent.mm.plugin.finder.e.b.finder_btn_fullscreen_disable_color);
        paramj.UH(e.e.avatar_iv).setEnabled(false);
        paramj.UH(e.e.nickname).setEnabled(false);
        paramList = (ViewGroup)paramj.UH(e.e.finder_seek_bar_footer_layout);
        localObject1 = paramj.UH(e.e.footer_op_layout);
        if (localObject1 != null)
        {
          ((TextView)((View)localObject1).findViewById(e.e.share_count_tv)).setTextColor(paramInt2);
          ((WeImageView)((View)localObject1).findViewById(e.e.icon_feed_share)).setIconColor(paramInt2);
          ((View)localObject1).findViewById(e.e.share_icon_container).setEnabled(false);
          ((TextView)((View)localObject1).findViewById(e.e.like_count_tv)).setTextColor(paramInt2);
          com.tencent.mm.svg.a.a.i(paramj.context.getResources(), e.g.finder_full_like);
          ((WeImageView)((View)localObject1).findViewById(e.e.icon_feed_like)).setIconColor(paramInt2);
          ((View)localObject1).findViewById(e.e.awesome_icon_container).setEnabled(false);
          ((TextView)((View)localObject1).findViewById(e.e.comment_count_tv)).setTextColor(paramInt2);
          ((WeImageView)((View)localObject1).findViewById(e.e.icon_feed_comment)).setIconColor(paramInt2);
          ((View)localObject1).findViewById(e.e.comment_icon_container).setEnabled(false);
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 1)
          {
            localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eXK().bmg()).intValue() != 0) {
              break label4204;
            }
            ((TextView)((View)localObject1).findViewById(e.e.star_count_tv)).setTextColor(paramInt2);
            ((WeImageView)((View)localObject1).findViewById(e.e.icon_feed_star)).setIconColor(paramInt2);
            ((View)localObject1).findViewById(e.e.star_icon_container).setEnabled(false);
          }
          label1790:
          if (paramList != null) {
            break label4251;
          }
          paramList = null;
          label1798:
          if (paramList != null) {
            paramList.setVisibility(4);
          }
          paramj.UH(e.e.text_content).setEnabled(false);
        }
      }
      a(paramj, paramT.feedObject, Boolean.FALSE);
      g(paramj, paramT);
      if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz())) {
        break label4264;
      }
      label1862:
      paramList = paramT.feedObject.getFeedObject().objectDesc;
      if (paramList != null) {
        break label4317;
      }
      localObject1 = null;
      label1882:
      localObject3 = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
      if (localObject1 != null) {
        break label4327;
      }
      paramList = null;
      label1901:
      paramList = (CharSequence)paramList;
      if ((paramList != null) && (paramList.length() != 0)) {
        break label4337;
      }
      paramInt2 = 1;
      label1926:
      if (paramInt2 == 0)
      {
        if (localObject1 != null) {
          break label4343;
        }
        paramList = "";
        label1941:
        ((com.tencent.mm.mj_template.api.d)localObject3).preloadTemplateInfo(paramList, true);
      }
      localObject2 = paramj.UH(e.e.finder_feed_creation_by_same_template);
      if (localObject2 != null)
      {
        if (localObject1 != null) {
          break label4367;
        }
        paramList = null;
        label1973:
        paramList = (CharSequence)paramList;
        if ((paramList != null) && (paramList.length() != 0)) {
          break label4377;
        }
        paramInt2 = 1;
        label1998:
        if (paramInt2 != 0) {
          break label4485;
        }
        paramList = ((com.tencent.mm.mj_template.api.d)localObject3).getFinderMaasConfig();
        localObject4 = paramT.feedObject.getFeedObject().objectDesc;
        if (localObject4 != null) {
          break label4383;
        }
        paramInt2 = 0;
        label2032:
        localObject4 = paramT.feedObject.getFeedObject().objectDesc;
        if (localObject4 != null) {
          break label4429;
        }
        i = 0;
        label2052:
        if (localObject1 != null) {
          break label4475;
        }
        j = -1;
        label2060:
        if (!paramList.ah(paramInt2, i, j)) {
          break label4485;
        }
        paramList = com.tencent.mm.plugin.finder.utils.af.Ghj;
        if (!com.tencent.mm.plugin.finder.utils.af.iq(paramj.hashCode(), 64)) {
          break label4485;
        }
        paramInt2 = 0;
        label2096:
        ((View)localObject2).setVisibility(paramInt2);
        if (((View)localObject2).getVisibility() == 0) {
          com.tencent.mm.view.f.a((View)localObject2, (com.tencent.mm.view.e.b)new t((byy)localObject1, paramj));
        }
        ((View)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda14((byy)localObject1, paramj, this, (com.tencent.mm.mj_template.api.d)localObject3));
        paramList = com.tencent.mm.plugin.finder.utils.af.Ghj;
        com.tencent.mm.plugin.finder.utils.af.a(paramj, ((View)localObject2).getVisibility(), 64);
      }
      paramList = paramT.contact;
      if (paramList != null) {
        break label4492;
      }
      paramList = null;
      label2177:
      localObject1 = (CharSequence)paramList;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label4502;
      }
      paramInt2 = 1;
      label2202:
      if (paramInt2 == 0) {
        break label5276;
      }
      paramList = paramT.feedObject.getFeedObject().contact;
      if (paramList != null) {
        break label4508;
      }
      paramList = null;
    }
    label2331:
    label4508:
    label5276:
    for (;;)
    {
      label2227:
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramList = new com.tencent.mm.plugin.finder.loader.b(paramList);
      localObject2 = paramj.UH(e.e.avatar_iv);
      kotlin.g.b.s.s(localObject2, "holder.getView(R.id.avatar_iv)");
      localObject2 = (ImageView)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject2 = (NeatTextView)paramj.UH(e.e.text_content);
      if ((a(paramT)) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
      {
        paramBoolean = true;
        paramInt2 = paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_2);
        i = paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8);
        j = paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.transparent);
        paramList = com.tencent.mm.plugin.finder.utils.as.GiG;
        localObject1 = paramT.feedObject.getDescriptionFullSpan();
        paramList = (List<Object>)localObject1;
        if (localObject1 == null) {
          paramList = new SpannableString((CharSequence)"");
        }
        com.tencent.mm.plugin.finder.utils.as.a(paramList, paramBoolean, this.linkColor, paramInt2, i, j, this.AIr);
        paramList = com.tencent.mm.plugin.finder.utils.ar.Giw;
        paramList = paramj.context;
        kotlin.g.b.s.s(paramList, "holder.context");
        paramList = com.tencent.mm.plugin.finder.utils.ar.a(paramList, paramT, this.AIh.ebw());
        localObject1 = (SpannableString)paramList.aiuN;
        if (((CharSequence)localObject1).length() != 0) {
          break label4524;
        }
        paramInt2 = 1;
        label2497:
        if (paramInt2 == 0) {
          break label4530;
        }
        if (localObject2 != null) {
          ((NeatTextView)localObject2).setVisibility(8);
        }
        label2514:
        c(paramT, paramj);
        localObject1 = paramj.UH(e.e.full_warn_container);
        paramList = (List<Object>)localObject1;
        if (localObject1 == null)
        {
          paramList = (ViewStub)paramj.UH(e.e.finder_feed_full_warn_vs);
          if (paramList != null) {
            break label4756;
          }
          paramList = null;
        }
        label2558:
        if (paramList != null)
        {
          if (paramT.feedObject.getFeedObject().warnFlag == 0) {
            break label4766;
          }
          paramList.setVisibility(0);
          paramList = (TextView)paramj.UH(e.e.full_warn_word);
          if (paramList != null) {
            paramList.setText((CharSequence)paramT.feedObject.getFeedObject().warnWording);
          }
          paramList = ah.aiuX;
          paramList = ah.aiuX;
        }
        label2617:
        paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
        paramList = com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramT.feedObject.getFeedObject());
        paramBoolean = ((Boolean)paramList.bsC).booleanValue();
        bool1 = ((Boolean)paramList.bsD).booleanValue();
        paramList = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
        a(paramT, paramBoolean, bool1, com.tencent.mm.plugin.finder.upload.action.l.fek().v(paramT.feedObject.getFeedObject()), paramj);
        paramList = paramj.UH(e.e.awesome_icon_container);
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        paramList.setOnTouchListener(new FinderFeedFullConvert..ExternalSyntheticLambda31((boolean[])localObject1));
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramList, "finder_feed_like");
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(paramList, 8, 24617);
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(paramList, new FinderFeedFullConvert..ExternalSyntheticLambda34(paramj));
        paramList.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda25((boolean[])localObject1, paramj, this, paramInt1));
        paramList.setOnLongClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda29(paramj, this, paramInt1));
        paramList.setHapticFeedbackEnabled(false);
        paramList = paramj.caK;
        if (!(paramList instanceof SimpleTouchableLayout)) {
          break label4776;
        }
        paramList = (SimpleTouchableLayout)paramList;
        label2857:
        if (paramList != null)
        {
          paramList.setEnableScale(false);
          paramList.setOnDoubleClickListener((SimpleTouchableLayout.b)new j(paramj, this, paramInt1));
          paramList.setOnSingleClickListener((SimpleTouchableLayout.f)new k(this, paramj));
          paramList.setOnLongClickListener((SimpleTouchableLayout.d)new l(this, paramj));
          paramList = ah.aiuX;
          paramList = ah.aiuX;
        }
        paramList = (FinderMediaBanner)paramj.UH(e.e.media_banner);
        if (paramList != null)
        {
          ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramList, "finder_feed_media_banner");
          paramList.setOnSingleClickListener((HardTouchableLayout.g)new m(paramj, this));
          paramList.setOnDoubleClickListener((HardTouchableLayout.b)new n(paramj, this, paramInt1));
          paramList.setOnLongClickListener((HardTouchableLayout.d)new o(this, paramj));
          paramList = ah.aiuX;
          paramList = ah.aiuX;
        }
        paramList = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
        if (paramList != null)
        {
          paramList.setOnPrivateLikeClickListener((kotlin.g.a.a)new p(paramT, this, paramj, paramInt1));
          paramList.a(this.AIh.ebw(), paramT);
          paramList.getPlayCtrlBtn().setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda21(paramj, paramList));
          paramList.getMiniWindowBtn().setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda22(paramj, paramList));
          paramList = ah.aiuX;
          paramList = ah.aiuX;
        }
        paramList = paramj.UH(e.e.finder_post_footer_layout);
        if (paramList != null) {
          paramList.setVisibility(8);
        }
        paramList = paramj.UH(e.e.footer_op_layout);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = paramj.UH(e.e.share_icon_container);
        if (paramList != null)
        {
          paramList.setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda8(this, paramj));
          paramList = ah.aiuX;
        }
        paramj.UH(e.e.share_icon_container).setOnLongClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda30(paramj, paramT));
        paramList = paramj.UH(e.e.star_icon_container_first);
        paramList.setOnLongClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda27(paramList, paramT, paramj));
        localObject1 = paramT.feedObject;
        paramList = paramT.contact;
        if (paramList != null) {
          break label4782;
        }
        paramList = null;
        label3263:
        a(paramj, (FinderItem)localObject1, paramList);
        a(paramT, paramj, false, paramInt1);
        d(paramT, paramj);
        paramList = com.tencent.mm.plugin.finder.utils.av.GiL;
        if ((com.tencent.mm.plugin.finder.utils.av.e(paramT)) && (paramT.showShareSns))
        {
          paramT.showShareSns = false;
          paramList = new e.a(paramj.context);
          paramList.aEO(e.h.finder_feed_shahre_to_sns_dialog_msg);
          paramList.NC(false);
          paramList.ND(true);
          paramList.aES(e.h.finder_feed_shahre_to_sns_dialog_negative_btn);
          paramList.aER(e.h.finder_feed_shahre_to_sns_dialog_positive_btn).c(new FinderFeedFullConvert..ExternalSyntheticLambda2(paramj, this));
          paramList.e(new FinderFeedFullConvert..ExternalSyntheticLambda1(paramj));
          paramList.jHH().show();
        }
        b(paramT, paramj);
        if (!paramT.feedObject.isPrivate()) {
          break label4792;
        }
        paramList = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (!com.tencent.mm.plugin.finder.utils.av.e(paramT)) {
          break label4792;
        }
        paramList = paramj.UH(e.e.feed_private_tips_divider);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = paramj.UH(e.e.feed_private_tips);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        e(paramT, paramj);
        localObject1 = paramj.UH(e.e.finder_feed_full_item_post_recommend_layout);
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(8);
          paramList = paramT.feedObject.getFeedObject().publisher_info;
          if (paramList != null)
          {
            localObject2 = (RoundLinearLayout)((View)localObject1).findViewById(e.e.post_avatar_layout);
            if (localObject2 != null) {
              ((RoundLinearLayout)localObject2).setRadius(0.1F);
            }
            ((View)localObject1).setVisibility(0);
            localObject2 = (TextView)((View)localObject1).findViewById(e.e.post_author);
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(((View)localObject1).getContext(), (CharSequence)((View)localObject1).getContext().getResources().getString(e.h.finder_xx_post_title, new Object[] { paramList.nickname })));
            }
            localObject1 = (ImageView)((View)localObject1).findViewById(e.e.post_avatar);
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
              localObject2 = com.tencent.mm.plugin.finder.loader.p.eCr();
              paramList = new com.tencent.mm.plugin.finder.loader.b(paramList.mdQ);
              localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
              ((com.tencent.mm.loader.d)localObject2).a(paramList, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExN));
            }
          }
        }
        k(paramj);
        d(paramj, paramT);
        h(paramj);
        e(paramj, paramT);
        paramList = paramj.UH(e.e.read_icon_container);
        localObject1 = (WeImageView)paramj.UH(e.e.icon_feed_read);
        if (this.AIh.ebw()) {
          break label4837;
        }
        paramList.setVisibility(8);
        if (paramT.isShowGuideTips != 1) {
          break label4945;
        }
        localObject1 = paramj.UH(e.e.guide_layout_parent);
        paramList = (List<Object>)localObject1;
        if (localObject1 == null) {
          paramList = ((ViewStub)paramj.UH(e.e._feed_full_guide_layout_vs)).inflate();
        }
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        label3780:
        a(paramT, paramj);
        h(paramj, paramT);
        a(paramj, paramInt1, paramT, true);
        a(paramj, paramInt1, paramT, 0);
        paramList = com.tencent.mm.plugin.finder.storage.d.FAy;
        paramInt2 = ((Number)com.tencent.mm.plugin.finder.storage.d.eUu().bmg()).intValue();
        paramList = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramList = paramj.context;
        kotlin.g.b.s.s(paramList, "holder.context");
        paramList = as.a.hu(paramList);
        if (paramList != null) {
          break label4969;
        }
        paramInt1 = 0;
        localObject2 = paramj.UH(e.e.finder_feed_item_of_hot_search);
        if ((paramInt2 == 1) && (paramInt1 != 23) && (paramInt1 != 6) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz()))
        {
          paramList = com.tencent.mm.plugin.finder.utils.af.Ghj;
          if (com.tencent.mm.plugin.finder.utils.af.iq(paramj.hashCode(), 32)) {
            break label4978;
          }
        }
        Log.i("Finder.FeedFullConvert", "hot search not enable");
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
      }
      for (;;)
      {
        paramList = com.tencent.mm.ui.component.k.aeZF;
        paramList = paramj.context;
        kotlin.g.b.s.s(paramList, "holder.context");
        paramList = (com.tencent.mm.plugin.finder.viewmodel.component.v)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.v.class);
        if (paramList != null) {
          paramList.a((cc)paramT, paramj, this.AIh.ebw(), (kotlin.g.a.b)new aa(this));
        }
        paramList = com.tencent.mm.ui.component.k.aeZF;
        paramList = paramj.context;
        kotlin.g.b.s.s(paramList, "holder.context");
        paramList = (com.tencent.mm.plugin.finder.viewmodel.component.s)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.s.class);
        if (paramList != null)
        {
          localObject1 = (cc)paramT;
          this.AIh.ebw();
          paramList.a((cc)localObject1, paramj, (kotlin.g.a.b)new w(this, paramj, paramT));
        }
        paramT = com.tencent.mm.ui.component.k.aeZF;
        paramT = paramj.context;
        kotlin.g.b.s.s(paramT, "holder.context");
        paramT = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramT).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
        if (paramT != null) {
          paramT.c(paramj, this.AIh.ebw());
        }
        paramT = com.tencent.mm.ui.component.k.aeZF;
        paramT = paramj.context;
        kotlin.g.b.s.s(paramT, "holder.context");
        paramT = (com.tencent.mm.plugin.finder.viewmodel.component.u)com.tencent.mm.ui.component.k.nq(paramT).cp(com.tencent.mm.plugin.finder.viewmodel.component.u.class);
        if (paramT == null) {
          break;
        }
        kotlin.g.b.s.u(paramj, "holder");
        paramT.U(paramj);
        return;
        paramList = Integer.valueOf(paramList.AJo);
        break label1335;
        label4204:
        ((TextView)((View)localObject1).findViewById(e.e.star_count_tv_first)).setTextColor(paramInt2);
        ((WeImageView)((View)localObject1).findViewById(e.e.icon_feed_star_first)).setIconColor(paramInt2);
        ((View)localObject1).findViewById(e.e.star_icon_container_first).setEnabled(false);
        break label1790;
        paramList = paramList.findViewById(e.e.awesome_ground_layout);
        break label1798;
        label4264:
        paramList = com.tencent.mm.ui.component.k.aeZF;
        paramList = paramj.context;
        kotlin.g.b.s.s(paramList, "holder.context");
        paramList = com.tencent.mm.ui.component.k.nq(paramList).q(com.tencent.mm.plugin.finder.feed.component.e.class);
        kotlin.g.b.s.s(paramList, "UICProvider.of(holder.co…eedJumperUIC::class.java)");
        com.tencent.mm.plugin.finder.feed.component.f.a((com.tencent.mm.plugin.finder.feed.component.f)paramList, paramT, paramj);
        break label1862;
        label4317:
        localObject1 = paramList.video_tmpl_info;
        break label1882;
        label4327:
        paramList = ((byy)localObject1).id;
        break label1901;
        label4337:
        paramInt2 = 0;
        break label1926;
        label4343:
        localObject2 = ((byy)localObject1).id;
        paramList = (List<Object>)localObject2;
        if (localObject2 != null) {
          break label1941;
        }
        paramList = "";
        break label1941;
        paramList = ((byy)localObject1).id;
        break label1973;
        paramInt2 = 0;
        break label1998;
        label4383:
        localObject4 = ((FinderObjectDesc)localObject4).video_tmpl_info;
        if (localObject4 == null)
        {
          paramInt2 = 0;
          break label2032;
        }
        localObject4 = ((byy)localObject4).aahY;
        if (localObject4 == null)
        {
          paramInt2 = 0;
          break label2032;
        }
        paramInt2 = ((fxe)localObject4).abME;
        break label2032;
        label4429:
        localObject4 = ((FinderObjectDesc)localObject4).video_tmpl_info;
        if (localObject4 == null)
        {
          i = 0;
          break label2052;
        }
        localObject4 = ((byy)localObject4).aahY;
        if (localObject4 == null)
        {
          i = 0;
          break label2052;
        }
        i = ((fxe)localObject4).abMF;
        break label2052;
        label4475:
        j = ((byy)localObject1).type;
        break label2060;
        paramInt2 = 8;
        break label2096;
        paramList = paramList.amx();
        break label2177;
        paramInt2 = 0;
        break label2202;
        paramList = paramList.headUrl;
        break label2227;
        paramBoolean = false;
        break label2331;
        label4524:
        paramInt2 = 0;
        break label2497;
        label4530:
        ((NeatTextView)localObject2).br(0.0F, 1.2F);
        if (localObject2 != null) {
          ((NeatTextView)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda5(this, paramT, paramj));
        }
        if (!((Boolean)paramList.bsC).booleanValue())
        {
          if (localObject2 != null) {
            ((NeatTextView)localObject2).setEllipsize(null);
          }
          label4584:
          if (localObject2 != null) {
            ((NeatTextView)localObject2).setMaxLines(((Number)paramList.bsD).intValue());
          }
          if (localObject2 != null) {
            ((NeatTextView)localObject2).setVisibility(0);
          }
          paramT.feedObject.getTopicClickExtra().contextRef = new WeakReference(paramj.context);
          if (localObject2 != null) {
            ((NeatTextView)localObject2).aZ((CharSequence)localObject1);
          }
          if (((CharSequence)paramList.aiuN).length() <= 0) {
            break label4750;
          }
        }
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label4754;
          }
          localObject1 = com.tencent.mm.plugin.finder.topic.a.FNS;
          kotlin.g.b.s.s(localObject2, "contentTv");
          com.tencent.mm.plugin.finder.topic.a.a((View)localObject2, (SpannableString)paramList.aiuN, paramT.bZA());
          localObject1 = com.tencent.mm.plugin.finder.report.ak.FtG;
          com.tencent.mm.plugin.finder.report.ak.a((View)localObject2, (SpannableString)paramList.aiuN, paramT);
          break;
          if (localObject2 == null) {
            break label4584;
          }
          ((NeatTextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          break label4584;
        }
        break label2514;
        paramList = paramList.inflate();
        break label2558;
        label4766:
        paramList.setVisibility(8);
        break label2617;
        label4776:
        paramList = null;
        break label2857;
        label4782:
        paramList = paramList.getUsername();
        break label3263;
        label4792:
        paramList = paramj.UH(e.e.feed_private_tips_divider);
        if (paramList != null) {
          paramList.setVisibility(8);
        }
        paramList = paramj.UH(e.e.feed_private_tips);
        if (paramList == null) {
          break label3466;
        }
        paramList.setVisibility(8);
        break label3466;
        label4837:
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1) {
          ((WeImageView)localObject1).oR(e.g.icons_outlined_eyes_on, com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_3);
        }
        for (;;)
        {
          paramList.setVisibility(0);
          paramList = com.tencent.mm.plugin.finder.utils.r.TR(paramT.feedObject.getReadCount());
          localObject1 = (TextView)paramj.UH(e.e.read_count_tv);
          if (localObject1 == null) {
            break;
          }
          com.tencent.mm.ui.aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)paramList);
          break;
          ((WeImageView)localObject1).oR(e.g.icons_filled_eyes_on, com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_3);
        }
        label4945:
        paramList = paramj.UH(e.e.guide_layout_parent);
        if (paramList == null) {
          break label3780;
        }
        paramList.setVisibility(8);
        break label3780;
        label4969:
        paramInt1 = paramList.AJo;
        break label3860;
        label4978:
        localObject3 = paramT.feedObject.getFinderObject().hotWordInfo;
        if (localObject3 == null)
        {
          paramList = null;
          if (paramList == null) {
            break label5261;
          }
          paramList = ((bro)localObject3).ZZO;
          if (paramList != null) {
            break label5207;
          }
          paramList = null;
          if (Util.isNullOrNil(paramList)) {
            break label5261;
          }
          paramList = ((bro)localObject3).ZZO;
          if (paramList != null) {
            break label5217;
          }
          paramList = null;
          label5041:
          Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("hotWordInfo: ", paramList));
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(0);
          }
          paramList = ((bro)localObject3).ZZO;
          if (paramList != null) {
            break label5227;
          }
          paramList = "";
          label5083:
          localObject1 = ((bro)localObject3).ZZO;
          if (localObject1 != null) {
            break label5251;
          }
        }
        for (localObject1 = null;; localObject1 = ((bux)localObject1).ZRe)
        {
          localObject4 = ((bro)localObject3).ZZQ;
          TextView localTextView = (TextView)paramj.UH(e.e.feed_item_hot_search_title);
          if (localObject2 != null) {
            ((View)localObject2).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda23(paramj, paramList, paramT, (com.tencent.mm.bx.b)localObject1, this, (bro)localObject3, (com.tencent.mm.bx.b)localObject4));
          }
          if (localTextView == null) {
            break;
          }
          com.tencent.mm.ui.aw.a((Paint)localTextView.getPaint(), 0.8F);
          localTextView.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_hot_search_feed_title_prefix, new Object[] { paramList }));
          break;
          paramList = ((bro)localObject3).ZZO;
          break label4998;
          label5207:
          paramList = paramList.aacq;
          break label5018;
          label5217:
          paramList = paramList.aacq;
          break label5041;
          label5227:
          localObject1 = paramList.aacq;
          paramList = (List<Object>)localObject1;
          if (localObject1 != null) {
            break label5083;
          }
          paramList = "";
          break label5083;
        }
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
      }
    }
  }
  
  protected void a(com.tencent.mm.view.recyclerview.j paramj, T paramT, View paramView, int paramInt)
  {
    int j = 1;
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramT, "item");
    kotlin.g.b.s.u(paramView, "it");
    Object localObject1 = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999702);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.AIj;
    if (41L <= l2) {
      if (l2 < 300L)
      {
        i = 1;
        if (i == 0) {
          break label102;
        }
        this.AIj = l1;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label114;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      label102:
      this.AIj = l1;
    }
    label114:
    if (paramj.KJ() == 0)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = paramj.context;
      kotlin.g.b.s.s(localObject1, "holder.context");
      localObject1 = ((com.tencent.mm.plugin.finder.ui.sharerel.c)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.ui.sharerel.c.class)).FYa;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.ui.sharerel.b)localObject1).fdb();
        ((com.tencent.mm.plugin.finder.ui.sharerel.b)localObject1).aBh("forward");
      }
    }
    localObject1 = paramT.feedObject.getFeedObject().tips_info;
    boolean bool;
    label220:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      if ((Util.isNullOrNil((String)localObject1)) || (!paramT.feedObject.isNotShare())) {
        break label639;
      }
      bool = true;
      localObject2 = new com.tencent.mm.ui.widget.a.f(paramj.context, 0, bool);
      if (bool)
      {
        View localView = com.tencent.mm.ui.af.mU(paramj.context).inflate(e.f.finder_share_tip_header, null);
        TextView localTextView = (TextView)localView.findViewById(e.e.finder_share_tip_header_text);
        if (localTextView != null)
        {
          com.tencent.mm.ui.aw.a((Paint)localTextView.getPaint(), 0.8F);
          localTextView.setText((CharSequence)localObject1);
        }
        kotlin.g.b.s.s(localView, "headerView");
        ((com.tencent.mm.ui.widget.a.f)localObject2).af(localView, true);
      }
      ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = this.AIh.a(paramT, (com.tencent.mm.ui.widget.a.f)localObject2, paramInt);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAz = this.AIh.a(paramT, (com.tencent.mm.ui.widget.a.f)localObject2, paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAC = this.AIh.a(paramT, paramInt, paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject2).agem = this.AIh.a(paramT, paramInt, paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAx = this.AIh.a(paramT, (com.tencent.mm.ui.widget.a.f)localObject2);
      ((com.tencent.mm.ui.widget.a.f)localObject2).agen = this.AIh.a(paramT, paramInt, paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject2).ageo = this.AIh.a((com.tencent.mm.ui.widget.a.f)localObject2, paramT, paramj);
      paramView.setTag(Boolean.TRUE);
      localObject1 = z.FrZ;
      z.a(paramj, paramT.bZA(), paramT.feedObject);
      ((com.tencent.mm.ui.widget.a.f)localObject2).aeLi = new FinderFeedFullConvert..ExternalSyntheticLambda38(paramView, paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject2).dDn();
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      paramView = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramView).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramView != null) {
        paramView.N(paramj);
      }
      o(paramj);
      paramView = com.tencent.mm.plugin.finder.report.bb.FuK;
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label645;
      }
      paramj = null;
      label558:
      paramView = new JSONObject();
      paramView.put("feedid", com.tencent.mm.ae.d.hF(paramT.bZA()));
      if (paramInt != 1) {
        break label653;
      }
    }
    label645:
    label653:
    for (paramInt = j;; paramInt = 2)
    {
      paramView.put("from_action", paramInt);
      paramT = ah.aiuX;
      com.tencent.mm.plugin.finder.report.bb.a(paramj, "channel_feedcard_moreActionPanel", false, paramView);
      return;
      localObject2 = ((bxp)localObject1).aagp;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label639:
      bool = false;
      break label220;
      paramj = paramj.fou();
      break label558;
    }
  }
  
  protected void a(final com.tencent.mm.view.recyclerview.j paramj, final T paramT, boolean paramBoolean1, long paramLong1, au paramau, int paramInt1, int paramInt2, boolean paramBoolean2, long paramLong2)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramT, "item");
    com.tencent.mm.plugin.finder.view.f localf = this.AIh.ebA();
    Object localObject2 = new ah.d();
    Object localObject1;
    if (paramBoolean1) {
      if (paramInt1 >= 0)
      {
        paramj.getRecyclerView().getGlobalVisibleRect(this.rect);
        int i = this.rect.bottom;
        if (localf != null) {
          break label186;
        }
        localObject1 = null;
        label72:
        if (localObject1 != null) {
          ((View)localObject1).postDelayed(new FinderFeedFullConvert..ExternalSyntheticLambda40((View)localObject1, paramj, i - paramInt1, paramInt1, this), 200L);
        }
      }
    }
    for (;;)
    {
      localObject1 = new s(this, paramT, paramj, (ah.d)localObject2);
      if (!(paramj.context instanceof MMActivity)) {
        break label439;
      }
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = paramj.context;
      if (localObject2 != null) {
        break label372;
      }
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      this.rect.setEmpty();
      paramj.caK.getGlobalVisibleRect(this.rect);
      paramInt1 = this.rect.bottom;
      break;
      label186:
      localObject1 = localf.AUv;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label72;
      }
      localObject1 = ((FinderCommentDrawer)localObject1).getFooterLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label72;
      }
      localObject1 = ((FrameLayout)localObject1).findViewById(e.e.comment_et_layout);
      break label72;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTg().bmg()).intValue() == 1)
      {
        paramj.getRecyclerView().JO();
        paramj.caK.findViewById(e.e.media_banner).getGlobalVisibleRect(this.rect);
        paramInt1 = this.rect.top;
        paramj.getRecyclerView().getGlobalVisibleRect(this.rect);
        ((ah.d)localObject2).aixb = (paramInt1 - this.rect.top);
        Log.d("Finder.FeedFullConvert", "[openCommentDrawer] offset=" + ((ah.d)localObject2).aixb + ' ' + paramj.getRecyclerView());
        paramj.getRecyclerView().br(0, ((ah.d)localObject2).aixb);
      }
    }
    label372:
    localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject2).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    kotlin.g.b.s.s(localObject2, "UICProvider.of(holder.co…rReporterUIC::class.java)");
    localObject2 = ((bn)localObject2).foy();
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.event.a)localObject2).dYj();
      if (localObject2 != null) {
        ((a.b)localObject2).na(paramT.bZA());
      }
    }
    label439:
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.AIh.ebw())
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
      bool1 = bool2;
      if (!com.tencent.mm.plugin.finder.utils.av.e(paramT))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        bool1 = bool2;
        if (com.tencent.mm.plugin.finder.utils.aw.n(paramT.contact))
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          com.tencent.mm.plugin.finder.storage.d.Tl(2);
          bool1 = true;
        }
      }
    }
    if (localf != null)
    {
      paramT = paramT.feedObject;
      if (paramLong1 == 0L) {
        break label596;
      }
    }
    label596:
    for (bool2 = true;; bool2 = false)
    {
      localf.a(paramT, paramBoolean1, paramLong1, bool2, true, paramau, bool1, paramInt2, (CommentDrawerContract.CloseDrawerCallback)localObject1, paramBoolean2, paramLong2);
      paramT = com.tencent.mm.ui.component.k.aeZF;
      paramT = paramj.context;
      kotlin.g.b.s.s(paramT, "holder.context");
      paramT = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramT).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramT != null) {
        paramT.N(paramj);
      }
      o(paramj);
      return;
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    int j = 2;
    kotlin.g.b.s.u(paramj, "holder");
    FinderFeedLiveNoticeView localFinderFeedLiveNoticeView = (FinderFeedLiveNoticeView)paramj.UH(e.e.finder_feed_live_notice_view);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.af.Ghj;
    if (!com.tencent.mm.plugin.finder.utils.af.iq(paramj.hashCode(), 8))
    {
      if (localFinderFeedLiveNoticeView != null) {
        localFinderFeedLiveNoticeView.setVisibility(8);
      }
      return;
    }
    label61:
    int i;
    if (paramFinderItem == null)
    {
      localObject1 = "";
      if (localFinderFeedLiveNoticeView == null) {
        break label200;
      }
      if (kotlin.g.b.s.p(paramBoolean, Boolean.FALSE)) {
        localFinderFeedLiveNoticeView.setVisibility(8);
      }
      if (paramFinderItem != null) {
        break label202;
      }
      i = j;
    }
    for (;;)
    {
      if (i != 1)
      {
        paramBoolean = com.tencent.mm.plugin.finder.utils.av.GiL;
        paramBoolean = paramj.context;
        kotlin.g.b.s.s(paramBoolean, "holder.context");
        if ((com.tencent.mm.plugin.finder.utils.av.a(paramBoolean, paramFinderItem)) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!dXz()))
        {
          Object localObject2;
          if ((paramj.context instanceof MMActivity))
          {
            paramBoolean = com.tencent.mm.ui.component.k.aeZF;
            paramBoolean = paramj.context;
            if (paramBoolean == null)
            {
              throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              localObject2 = paramFinderItem.getUserName();
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label61;
              }
              localObject1 = "";
              break label61;
              label200:
              break;
              label202:
              paramBoolean = paramFinderItem.getFeedObject();
              i = j;
              if (paramBoolean == null) {
                continue;
              }
              paramBoolean = paramBoolean.contact;
              i = j;
              if (paramBoolean == null) {
                continue;
              }
              i = paramBoolean.liveStatus;
              continue;
            }
            paramBoolean = ((com.tencent.mm.plugin.findersdk.a.ar)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramBoolean).cq(com.tencent.mm.plugin.findersdk.a.ar.class)).eiJ().avW((String)localObject1);
            if (paramBoolean != null) {
              break label325;
            }
            paramBoolean = null;
          }
          for (;;)
          {
            if (paramBoolean == null)
            {
              if (localFinderFeedLiveNoticeView.getVisibility() != 0) {
                break label471;
              }
              Log.i("Finder.FeedFullConvert", "notice info no cache ,request again");
              paramBoolean = com.tencent.mm.ui.component.k.aeZF;
              paramBoolean = paramj.context;
              if (paramBoolean == null)
              {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                paramBoolean = null;
                break;
                label325:
                localObject2 = paramj.context;
                kotlin.g.b.s.s(localObject2, "holder.context");
                localFinderFeedLiveNoticeView.a((Context)localObject2, paramBoolean, (String)localObject1);
                paramBoolean = ah.aiuX;
                continue;
              }
              localObject1 = ((com.tencent.mm.plugin.findersdk.a.ar)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramBoolean).cq(com.tencent.mm.plugin.findersdk.a.ar.class)).eiJ();
              if (paramFinderItem != null) {
                break label424;
              }
              paramBoolean = null;
              if (paramFinderItem != null) {
                break label449;
              }
              paramFinderItem = null;
              label394:
              ((com.tencent.mm.plugin.findersdk.a.as)localObject1).a(paramBoolean, paramFinderItem);
            }
          }
        }
      }
    }
    for (;;)
    {
      n(paramj);
      paramFinderItem = com.tencent.mm.plugin.finder.utils.af.Ghj;
      com.tencent.mm.plugin.finder.utils.af.a(paramj, localFinderFeedLiveNoticeView.getVisibility(), 8);
      return;
      label424:
      paramBoolean = paramFinderItem.getFeedObject();
      if (paramBoolean == null)
      {
        paramBoolean = null;
        break;
      }
      paramBoolean = Long.valueOf(paramBoolean.id);
      break;
      label449:
      paramFinderItem = paramFinderItem.getFeedObject();
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label394;
      }
      paramFinderItem = paramFinderItem.objectNonceId;
      break label394;
      label471:
      localFinderFeedLiveNoticeView.setVisibility(8);
      continue;
      localFinderFeedLiveNoticeView.setVisibility(8);
    }
  }
  
  public boolean a(com.tencent.mm.view.recyclerview.j paramj, View paramView, FinderObject paramFinderObject)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramFinderObject, "finderObj");
    n(paramj);
    paramView = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
    if (paramView != null)
    {
      paramView.fiI();
      if (!paramView.Gnn) {
        break label93;
      }
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      paramView = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramView).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramView != null) {
        paramView.N(paramj);
      }
    }
    for (;;)
    {
      return false;
      label93:
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = paramj.context;
      kotlin.g.b.s.s(paramView, "holder.context");
      paramView = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramView).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramView != null) {
        paramView.O(paramj);
      }
    }
  }
  
  protected void b(com.tencent.mm.plugin.finder.event.c.a parama)
  {
    kotlin.g.b.s.u(parama, "ev");
  }
  
  public void b(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    Object localObject2 = null;
    kotlin.g.b.s.u(paramj, "holder");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    StringBuilder localStringBuilder = new StringBuilder("[onHafEnjoyMedia] ");
    Object localObject1 = localBaseFinderFeed.contact;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FeedFullConvert", localObject1 + " position=" + paramInt + " feedId=" + com.tencent.mm.ae.d.hF(localBaseFinderFeed.bZA()));
      if (!localBaseFinderFeed.isHalfEnjoy) {
        break label102;
      }
    }
    label102:
    do
    {
      do
      {
        return;
        localObject1 = ((m)localObject1).getNickname();
        break;
        localBaseFinderFeed.isHalfEnjoy = true;
        localObject1 = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
        kotlin.g.b.s.s(localBaseFinderFeed, "item");
        kotlin.g.b.s.u(localBaseFinderFeed, "feed");
        paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
      } while ((((Number)com.tencent.mm.plugin.finder.storage.d.eWp().bmg()).intValue() != 0) || (!localBaseFinderFeed.feedObject.isPostFinish()) || (!localBaseFinderFeed.feedObject.isLongVideo()));
      paramj = (dji)kotlin.a.p.oL((List)localBaseFinderFeed.feedObject.getLongVideoMediaList());
      if (paramj != null) {
        break label357;
      }
      paramj = localObject2;
      if (paramj == null) {
        break label374;
      }
      paramInt = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZH, 0);
    } while (paramInt >= 3);
    label201:
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acZH, Integer.valueOf(paramInt + 1));
    paramj = ((FinderFullSeekBarLayout)localObject1).Gno;
    if (paramj != null) {
      paramj.cancel(false);
    }
    ((FinderFullSeekBarLayout)localObject1).aCk("checkShowHorizontalHint");
    ((FinderFullSeekBarLayout)localObject1).getHorizontalHint().setAlpha(0.0F);
    ((FinderFullSeekBarLayout)localObject1).getHorizontalHint().setVisibility(0);
    ((FinderFullSeekBarLayout)localObject1).getHorizontalHint().animate().alpha(1.0F).setDuration(300L).start();
    ((FinderFullSeekBarLayout)localObject1).getHorizontalHint().postDelayed(((FinderFullSeekBarLayout)localObject1).GmZ, 5000L);
    if (Settings.System.getInt(((FinderFullSeekBarLayout)localObject1).getContext().getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (paramInt = e.h.finder_feed_long_video_horizontal_hint;; paramInt = e.h.finder_feed_long_video_horizontal_hint_2)
    {
      ((TextView)((FinderFullSeekBarLayout)localObject1).getHorizontalHint().findViewById(e.e.horizontal_hint_tv)).setText(paramInt);
      return;
      label357:
      if (paramj.height > paramj.width) {
        break;
      }
      paramj = ah.aiuX;
      break label201;
      label374:
      break;
    }
  }
  
  public void c(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramT, "item");
    Object localObject2 = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    if (paramT.feedObject.isLongVideo()) {}
    Object localObject1;
    float f;
    for (LinkedList localLinkedList = paramT.feedObject.getLongVideoMediaList();; localLinkedList = paramT.feedObject.getMediaList())
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = (View)localObject2;
      localObject2 = (View)((FinderMediaBanner)localObject2).getPagerView();
      com.tencent.mm.plugin.finder.utils.av localav = com.tencent.mm.plugin.finder.utils.av.GiL;
      f = com.tencent.mm.plugin.finder.utils.av.hI((List)localLinkedList);
      paramj = paramj.getRecyclerView().getParent().getParent();
      if (paramj != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
    int i = ((View)paramj).getBottom();
    paramj = paramT.contact;
    if (paramj == null) {}
    for (paramj = null;; paramj = paramj.getNickname())
    {
      com.tencent.mm.plugin.finder.utils.av.a((View)localObject1, (View)localObject2, f, i, paramj, paramT.bZA());
      return;
    }
  }
  
  public boolean dXz()
  {
    return false;
  }
  
  public void e(RecyclerView paramRecyclerView)
  {
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    this.mkw = null;
  }
  
  public void e(com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramj, "holder");
    y.a locala = com.tencent.mm.plugin.finder.viewmodel.component.y.GQb;
    y.a.X(paramj);
  }
  
  public void f(T paramT, com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramT, "item");
    kotlin.g.b.s.u(paramj, "holder");
    Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("[onPostFinished] feed=", com.tencent.mm.ae.d.hF(paramT.bZA())));
    n(paramj);
    h(paramj, paramT);
    d(paramj, paramT);
    paramj.UH(e.e.full_seek_bar_layout);
    Object localObject = paramj.UH(e.e.finder_post_footer_layout);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramj.UH(e.e.footer_op_layout);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
    if (localObject != null) {
      ((FinderFullSeekBarLayout)localObject).a(this.AIh.ebw(), paramT);
    }
    localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (com.tencent.mm.plugin.finder.utils.av.ffV()) {}
    do
    {
      do
      {
        return;
        localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      } while (com.tencent.mm.plugin.finder.utils.aw.n(paramT.contact));
      paramT = com.tencent.mm.plugin.finder.storage.d.FAy;
    } while (com.tencent.mm.plugin.finder.storage.d.eSE() >= 3);
    paramT = paramj.UH(e.e.finder_self_feed_like_tips_layout);
    if (paramT == null) {
      paramT = ((ViewStub)paramj.UH(e.e.finder_self_feed_like_tips_layout_view_stub)).inflate();
    }
    for (;;)
    {
      paramT.setVisibility(0);
      paramT.setAlpha(0.0F);
      if (paramT == null) {
        break;
      }
      paramj = (TextView)paramT.findViewById(e.e.finder_self_feed_like_bubble_tips_tv);
      if (paramj != null) {
        paramj.setText(e.h.finder_feed_self_like_tips);
      }
      paramT.animate().setDuration(300L).alpha(1.0F).start();
      paramT.postDelayed(new FinderFeedFullConvert..ExternalSyntheticLambda39(paramT), 5000L);
      return;
    }
  }
  
  public void f(com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramj, "holder");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    StringBuilder localStringBuilder = new StringBuilder("[onTenSecEnjoy] ");
    Object localObject = localBaseFinderFeed.contact;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((m)localObject).getNickname())
    {
      Log.i("Finder.FeedFullConvert", localObject + " position=" + paramj.KJ() + " feedId=" + com.tencent.mm.ae.d.hF(localBaseFinderFeed.bZA()));
      if (!localBaseFinderFeed.isTenSecEnjoy) {
        break;
      }
      return;
    }
    localBaseFinderFeed.isTenSecEnjoy = true;
    kotlin.g.b.s.s(localBaseFinderFeed, "item");
    a(paramj, localBaseFinderFeed, true);
    a(localBaseFinderFeed, paramj);
  }
  
  public void g(com.tencent.mm.view.recyclerview.j paramj, T paramT)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramT, "item");
    Object localObject1 = paramT.contact;
    if (localObject1 == null) {}
    Object localObject2;
    for (int i = 2;; i = ((m)localObject1).field_liveStatus)
    {
      localObject1 = paramj.UH(e.e.finder_feed_living_status);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.af.Ghj;
        if (com.tencent.mm.plugin.finder.utils.af.iq(paramj.hashCode(), 4)) {
          break;
        }
        ((View)localObject1).setVisibility(8);
      }
      return;
    }
    if (i == 1) {}
    for (i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      localObject2 = paramj.UH(e.e.living_text);
      kotlin.g.b.s.s(localObject2, "holder.getView<TextView>(R.id.living_text)");
      com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject2);
      ((View)localObject1).setOnClickListener(new FinderFeedFullConvert..ExternalSyntheticLambda16(paramj, paramT));
      n(paramj);
      paramT = com.tencent.mm.plugin.finder.utils.af.Ghj;
      com.tencent.mm.plugin.finder.utils.af.a(paramj, ((View)localObject1).getVisibility(), 4);
      return;
    }
  }
  
  public final int getDisplayHeight()
  {
    return ((Number)this.AIl.getValue()).intValue();
  }
  
  public void k(com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject2 = (TextView)paramj.UH(e.e.full_friend_follow_count);
    Object localObject1 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject1 = paramj.context;
    kotlin.g.b.s.s(localObject1, "holder.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject1, 12.0F);
    if (localObject2 != null) {
      ((TextView)localObject2).setTextSize(1, f);
    }
    final FlowTextMixView localFlowTextMixView = (FlowTextMixView)paramj.caK.findViewById(e.e.flow_text_mix_view);
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    kotlin.g.b.s.s(localFlowTextMixView, "flowTextMixView");
    localObject1 = (View)localFlowTextMixView;
    paramj = (kotlin.g.a.a)new u(paramj, localFlowTextMixView, (TextView)localObject2, this);
    kotlin.g.b.s.u(localObject1, "<this>");
    kotlin.g.b.s.u(paramj, "call");
    paramj = new com.tencent.mm.ae.d.a(paramj, (View)localObject1);
    ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)paramj);
    localObject2 = new d.b(paramj, (View)localObject1);
    paramj = ((View)localObject1).getTag(g.a.actions);
    if ((paramj instanceof View.OnAttachStateChangeListener)) {}
    for (paramj = (View.OnAttachStateChangeListener)paramj;; paramj = null)
    {
      if (paramj != null) {
        ((View)localObject1).removeOnAttachStateChangeListener(paramj);
      }
      ((View)localObject1).addOnAttachStateChangeListener((View.OnAttachStateChangeListener)localObject2);
      ((View)localObject1).setTag(g.a.actions, localObject2);
      return;
    }
  }
  
  public void l(com.tencent.mm.view.recyclerview.j paramj)
  {
    Object localObject1 = null;
    kotlin.g.b.s.u(paramj, "holder");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    Object localObject2 = (FrameLayout)paramj.UH(e.e.feedHeaderBar);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.y.GQb;
      long l = localBaseFinderFeed.bZA();
      kotlin.g.b.s.u(paramj, "holder");
      kotlin.g.b.s.u(localObject2, "feedHeaderBar");
      localObject3 = ((FrameLayout)localObject2).findViewById(e.e.follow_btn_icon);
      if (((View)localObject3).getVisibility() != 0)
      {
        ((View)localObject3).setVisibility(0);
        localObject3 = (TextView)((FrameLayout)localObject2).findViewById(e.e.follow_btn_tv);
        ((TextView)localObject3).setText(e.h.to_follow_tip);
        ((TextView)localObject3).setTextColor(-1);
        localObject3 = ((FrameLayout)localObject2).findViewById(e.e.follow_btn);
        ((View)localObject3).setBackground(((FrameLayout)localObject2).getContext().getDrawable(e.d.finder_feed_follow_btn_bg));
        ((View)localObject3).setPadding(((View)localObject3).getResources().getDimensionPixelOffset(e.c.Edge_A), ((View)localObject3).getPaddingTop(), ((View)localObject3).getResources().getDimensionPixelOffset(e.c.finder_1_25_A), ((View)localObject3).getPaddingBottom());
      }
      localObject3 = ((FrameLayout)localObject2).findViewById(e.e.follow_btn);
      ((View)localObject3).setVisibility(4);
      ((View)localObject3).setOnClickListener(null);
      ((EllipsizedTextView)((FrameLayout)localObject2).findViewById(e.e.nickname)).setTextSize(0, ((FrameLayout)localObject2).getContext().getResources().getDimension(e.c.GroupTitleTextSize));
      localObject2 = (FadeOutLinearLayout)((FrameLayout)localObject2).findViewById(e.e.content_layout);
      if (localObject2 != null) {
        ((FadeOutLinearLayout)localObject2).ax(0, l);
      }
    }
    localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject2 = paramj.context;
    kotlin.g.b.s.s(localObject2, "holder.context");
    localObject2 = as.a.hu((Context)localObject2);
    int i;
    pu localpu;
    label345:
    boolean bool;
    if (localObject2 == null)
    {
      i = 0;
      localObject2 = (TextView)paramj.UH(e.e.little_follow_tv);
      ((TextView)localObject2).setTextSize(0, com.tencent.mm.cd.a.bs(((TextView)localObject2).getContext(), e.c.CaptionTextSize));
      localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject3 = localBaseFinderFeed.feedObject.field_username;
      localpu = localBaseFinderFeed.feedObject.getBizInfo();
      if (localpu != null) {
        break label405;
      }
      bool = com.tencent.mm.plugin.finder.api.d.a.a((String)localObject3, (String)localObject1, false, false, 12);
      if (!this.safeMode) {
        break label415;
      }
      paramj.pt(e.e.little_follow_tv, 8);
    }
    for (;;)
    {
      if ((!localBaseFinderFeed.isDeepEnjoy) && (!bool)) {
        ((TextView)localObject2).setVisibility(8);
      }
      return;
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).AJo;
      break;
      label405:
      localObject1 = localpu.ADE;
      break label345;
      label415:
      if ((this.hJx != 3) && (bool) && (i != 1))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        kotlin.g.b.s.s(localBaseFinderFeed, "item");
        if (!com.tencent.mm.plugin.finder.utils.av.e(localBaseFinderFeed))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setAlpha(1.0F);
          ((TextView)localObject2).setText((CharSequence)((TextView)localObject2).getContext().getResources().getString(e.h.has_follow_tip));
          ((TextView)localObject2).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_5));
          ((TextView)localObject2).setBackgroundResource(e.d.finder_full_has_follow_btn_shape);
          continue;
        }
      }
      if (!bool)
      {
        ((TextView)localObject2).setVisibility(8);
        if (localBaseFinderFeed.isDeepEnjoy)
        {
          kotlin.g.b.s.s(localBaseFinderFeed, "item");
          a(paramj, localBaseFinderFeed, false);
        }
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
    }
  }
  
  public void m(com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramj, "holder");
    super.m(paramj);
    com.tencent.mm.plugin.finder.utils.af localaf = com.tencent.mm.plugin.finder.utils.af.Ghj;
    com.tencent.mm.plugin.finder.utils.af.m(paramj);
  }
  
  public void n(com.tencent.mm.view.recyclerview.j paramj)
  {
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWp().bmg()).intValue() == 0)
    {
      localObject = (FinderMediaBanner)paramj.UH(e.e.media_banner);
      if (localObject != null) {
        break label42;
      }
    }
    label42:
    View localView1;
    View localView2;
    do
    {
      do
      {
        return;
        localView1 = paramj.UH(e.e.finder_seek_bar_footer_layout);
      } while (localView1 == null);
      localView2 = localView1.findViewById(e.e.preview_full_seek_bar);
    } while (localView2 == null);
    localView2.post(new FinderFeedFullConvert..ExternalSyntheticLambda41(this, paramj, (FinderMediaBanner)localObject, localView1, localView2));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class StateListener<T extends BaseFinderFeed>
    extends IListener<hx>
    implements View.OnAttachStateChangeListener
  {
    final FinderFeedFullConvert<T> AIy;
    final com.tencent.mm.view.recyclerview.j AIz;
    
    public StateListener(FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
      AppMethodBeat.i(350533);
      this.AIy = paramFinderFeedFullConvert;
      this.AIz = paramj;
      if ((this.AIz.context instanceof MMActivity))
      {
        paramFinderFeedFullConvert = this.AIz.context;
        if (paramFinderFeedFullConvert == null)
        {
          paramFinderFeedFullConvert = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(350533);
          throw paramFinderFeedFullConvert;
        }
        ((MMActivity)paramFinderFeedFullConvert).getLifecycle().addObserver((androidx.lifecycle.p)FinderFeedFullConvert.b(this.AIy));
      }
      AppMethodBeat.o(350533);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(350546);
      kotlin.g.b.s.u(paramView, "v");
      AppMethodBeat.o(350546);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(350539);
      kotlin.g.b.s.u(paramView, "v");
      AppMethodBeat.o(350539);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(FinderFeedFullConvert.StateListener<T> paramStateListener, hx paramhx)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$1$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private long AIv;
    private final MMHandler mRi;
    
    a(FinderFeedFullConvert<T> paramFinderFeedFullConvert, AppCompatActivity paramAppCompatActivity)
    {
      AppMethodBeat.i(350288);
      this.mRi = new MMHandler(Looper.getMainLooper());
      AppMethodBeat.o(350288);
    }
    
    private static final void a(WxRecyclerAdapter paramWxRecyclerAdapter, com.tencent.mm.plugin.finder.event.base.b paramb, FinderFeedFullConvert paramFinderFeedFullConvert)
    {
      AppMethodBeat.i(350292);
      kotlin.g.b.s.u(paramWxRecyclerAdapter, "$adapter");
      kotlin.g.b.s.u(paramb, "$ev");
      kotlin.g.b.s.u(paramFinderFeedFullConvert, "this$0");
      paramWxRecyclerAdapter = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)paramWxRecyclerAdapter, ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv);
      if (paramWxRecyclerAdapter != null) {
        paramFinderFeedFullConvert.a(paramWxRecyclerAdapter, paramWxRecyclerAdapter.KJ(), paramWxRecyclerAdapter.caO, 2);
      }
      AppMethodBeat.o(350292);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      int i = 1;
      AppMethodBeat.i(350319);
      kotlin.g.b.s.u(paramb, "ev");
      Object localObject1 = this.AIw.mkw;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          break label66;
        }
      }
      label66:
      for (localObject1 = (WxRecyclerAdapter)localObject1;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label72;
        }
        AppMethodBeat.o(350319);
        return;
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        break;
      }
      label72:
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 2))
      {
        paramb = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId);
        if (paramb != null)
        {
          localObject1 = this.AIw;
          if ((BaseFinderFeed)paramb.CSA != null) {
            ((FinderFeedFullConvert)localObject1).a(paramb, paramb.KJ(), paramb.caO, 0);
          }
          AppMethodBeat.o(350319);
        }
      }
      else
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 3))
        {
          localObject1 = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId);
          i = ((com.tencent.mm.plugin.finder.event.c.a)paramb).total;
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (i > com.tencent.mm.plugin.finder.storage.d.eRl())
          {
            i = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
            localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if ((i >= com.tencent.mm.plugin.finder.storage.d.eRl() / 2) && (localObject1 != null))
            {
              localObject2 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
              if (localObject2 != null)
              {
                localObject3 = this.AIw;
                i = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
                localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
                if ((i >= com.tencent.mm.plugin.finder.storage.d.eRl()) && (!((BaseFinderFeed)localObject2).isDeepEnjoy))
                {
                  Log.i("Finder.FeedFullConvert", "onEventHappen: VIDEO_PROGRESS mega video total = " + ((com.tencent.mm.plugin.finder.event.c.a)paramb).total + ", offset = " + ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset + ", feedId=" + com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId));
                  ((FinderFeedFullConvert)localObject3).a((com.tencent.mm.view.recyclerview.j)localObject1, ((com.tencent.mm.view.recyclerview.j)localObject1).KJ(), ((RecyclerView.v)localObject1).caO, 1);
                }
                if (!((BaseFinderFeed)localObject2).isHalfEnjoy)
                {
                  Log.i("Finder.FeedFullConvert", "onEventHappen: VIDEO_PROGRESS half enjoy mega video total = " + ((com.tencent.mm.plugin.finder.event.c.a)paramb).total + ", offset = " + ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset + ", feedId=" + com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId));
                  ((FinderFeedFullConvert)localObject3).b((com.tencent.mm.view.recyclerview.j)localObject1, ((com.tencent.mm.view.recyclerview.j)localObject1).KJ());
                }
              }
            }
          }
          i = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if ((i >= com.tencent.mm.plugin.finder.storage.d.eRm()) && (localObject1 != null))
          {
            localObject2 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
            if (localObject2 != null)
            {
              localObject3 = this.AIw;
              if (!((BaseFinderFeed)localObject2).isTenSecEnjoy)
              {
                Log.i("Finder.FeedFullConvert", "onEventHappen: VIDEO_PROGRESS ten sec enjoy offset = " + ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset + ", feedId=" + com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId));
                ((FinderFeedFullConvert)localObject3).f((com.tencent.mm.view.recyclerview.j)localObject1);
              }
              AppMethodBeat.o(350319);
            }
          }
        }
        else
        {
          if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 1))
          {
            this.AIw.a((com.tencent.mm.plugin.finder.event.c.a)paramb);
            AppMethodBeat.o(350319);
            return;
          }
          if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 11))
          {
            this.AIw.b((com.tencent.mm.plugin.finder.event.c.a)paramb);
            AppMethodBeat.o(350319);
            return;
          }
          boolean bool;
          if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6))
          {
            localObject2 = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv);
            if (localObject2 != null)
            {
              localObject4 = this.AIw;
              localObject3 = parami;
              if (((FinderFeedFullConvert)localObject4).hJx == 4)
              {
                localObject4 = ax.GUF;
                if (ax.a.hv((Context)localObject3) != null) {
                  ax.Y((com.tencent.mm.view.recyclerview.j)localObject2);
                }
                if (this.AIv != ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv)
                {
                  localObject4 = ax.GUF;
                  localObject3 = ax.a.hv((Context)localObject3);
                  if (localObject3 != null)
                  {
                    kotlin.g.b.s.u(localObject2, "holder");
                    if (((com.tencent.mm.view.recyclerview.j)localObject2).KJ() != ((ax)localObject3).GUG) {
                      break label1004;
                    }
                    bool = true;
                    ((ax)localObject3).GUH = bool;
                    ((ax)localObject3).GUI = false;
                    ((ax)localObject3).mRi.removeCallbacksAndMessages(null);
                    ax.d((com.tencent.mm.view.recyclerview.j)localObject2, (kotlin.g.a.b)new ax.h((ax)localObject3, (com.tencent.mm.view.recyclerview.j)localObject2));
                  }
                }
              }
            }
            if (this.AIv != ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv)
            {
              localObject2 = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, this.AIv);
              if (localObject2 != null)
              {
                localObject3 = this.AIw;
                if (!(((com.tencent.mm.view.recyclerview.j)localObject2).CSA instanceof com.tencent.mm.plugin.finder.model.y)) {
                  break label1009;
                }
                Log.e("Finder.FeedFullConvert", kotlin.g.b.s.X("FinderFeedLiveList info:lastCenterFeedId:", Long.valueOf(this.AIv)));
              }
              label882:
              this.AIv = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv;
              localObject2 = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv);
              if (localObject2 != null)
              {
                localObject3 = this.AIw;
                ((FinderFeedFullConvert)localObject3).n((com.tencent.mm.view.recyclerview.j)localObject2);
                ((FinderFeedFullConvert)localObject3).e((com.tencent.mm.view.recyclerview.j)localObject2);
              }
            }
            this.mRi.removeCallbacksAndMessages(null);
            localObject2 = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOy;
            if ((localObject2 == null) || (((FeedData)localObject2).getMediaType() != 2)) {}
          }
          for (;;)
          {
            if (i != 0)
            {
              this.mRi.postDelayed(new FinderFeedFullConvert.a..ExternalSyntheticLambda0((WxRecyclerAdapter)localObject1, paramb, this.AIw), 10000L);
              AppMethodBeat.o(350319);
              return;
              label1004:
              bool = false;
              break;
              label1009:
              ((FinderFeedFullConvert)localObject3).a((com.tencent.mm.view.recyclerview.j)localObject2, ((com.tencent.mm.view.recyclerview.j)localObject2).KJ(), ((RecyclerView.v)localObject2).caO, true);
              break label882;
              i = 0;
              continue;
              if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 10))
              {
                paramb = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv);
                if (paramb != null)
                {
                  localObject1 = this.AIw;
                  if ((paramb.CSA instanceof com.tencent.mm.plugin.finder.model.y))
                  {
                    Log.e("Finder.FeedFullConvert", kotlin.g.b.s.X("FinderFeedLiveList info:lastCenterFeedId:", Long.valueOf(this.AIv)));
                    AppMethodBeat.o(350319);
                    return;
                  }
                  ((FinderFeedFullConvert)localObject1).a(paramb, paramb.KJ(), paramb.caO, false);
                  AppMethodBeat.o(350319);
                }
              }
              else if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.j)) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).type == 1))
              {
                paramb = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, ((com.tencent.mm.plugin.finder.event.base.j)paramb).feedId);
                if (paramb != null)
                {
                  localObject1 = com.tencent.mm.ui.component.k.aeZF;
                  localObject1 = paramb.context;
                  kotlin.g.b.s.s(localObject1, "holder.context");
                  localObject1 = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq((Context)localObject1).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
                  if (localObject1 != null) {
                    ((com.tencent.mm.plugin.finder.viewmodel.component.l)localObject1).M(paramb);
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(350319);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(350335);
      kotlin.g.b.s.u(paramc, "dispatcher");
      kotlin.g.b.s.u(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) || ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) || ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j)))
      {
        AppMethodBeat.o(350335);
        return true;
      }
      AppMethodBeat.o(350335);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(350324);
      super.onRelease();
      this.mRi.removeCallbacksAndMessages(null);
      AppMethodBeat.o(350324);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.view.recyclerview.j, ah>
  {
    aa(FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    ab(TextView paramTextView, LinearLayout paramLinearLayout, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert<T> paramFinderFeedFullConvert, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    ac(FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$Companion;", "", "()V", "DOUBLE_TAP_MIN_TIME", "", "DOUBLE_TAP_TIMEOUT", "MAX_COUNTDOWN", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "payloadsAdFinishPlay", "payloadsAdFlagChanged", "payloadsAdFollowChanged", "payloadsAdMutualChanged", "payloadsAdSnsNotify", "payloadsAttachInfo", "payloadsCommentEdu", "payloadsDeleteWording", "payloadsExposeInfoType", "payloadsFavInfoType", "payloadsFollowFail", "payloadsLiveNotice", "payloadsLiveStatus", "payloadsPlayMusic", "payloadsPostEnd", "payloadsProgressType", "payloadsRefreshAddForward", "payloadsRefreshComment", "payloadsRefreshForward", "payloadsRefreshLike", "payloadsRefreshOpCount", "payloadsRefreshWording", "payloadsResizeBanner", "payloadsShowAtTip", "payloadsStopMusic", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(com.tencent.mm.view.recyclerview.j paramj, T paramT, FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$checkShowFollowLikeLayout$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.animation.a
  {
    d(View paramView, com.tencent.mm.view.recyclerview.j paramj, T paramT) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(350287);
      this.AID.setAlpha(1.0F);
      paramAnimator = com.tencent.mm.plugin.finder.report.bb.FuK;
      paramAnimator = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramAnimator = paramj.context;
      kotlin.g.b.s.s(paramAnimator, "holder.context");
      paramAnimator = as.a.hu(paramAnimator);
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.fou())
      {
        com.tencent.mm.plugin.finder.report.bb.a(paramAnimator, "follow_like", true, paramT.bZA());
        AppMethodBeat.o(350287);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    f(FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    g(FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    h(FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$4$1", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements SimpleTouchableLayout.b
  {
    j(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert<T> paramFinderFeedFullConvert, int paramInt) {}
    
    public final boolean a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(350261);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onDoubleClick ", this.wHm.CSA));
      jdField_this.a(this.wHm, paramView, paramMotionEvent);
      AppMethodBeat.o(350261);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$4$2", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements SimpleTouchableLayout.f
  {
    k(FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final boolean b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(350265);
      kotlin.g.b.s.u(paramView, "view");
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(350265);
        return false;
      }
      this.AIw.a(paramj, paramView, ((BaseFinderFeed)paramj.CSA).feedObject.getFeedObject());
      AppMethodBeat.o(350265);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$4$3", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements SimpleTouchableLayout.d
  {
    l(FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final void ft(View paramView)
    {
      AppMethodBeat.i(350249);
      kotlin.g.b.s.u(paramView, "view");
      FinderFeedFullConvert localFinderFeedFullConvert = this.AIw;
      com.tencent.mm.view.recyclerview.j localj = paramj;
      Object localObject = paramj.CSA;
      kotlin.g.b.s.s(localObject, "holder.getAssociatedObject<T>()");
      localFinderFeedFullConvert.a(localj, paramView, (BaseFinderFeed)localObject);
      AppMethodBeat.o(350249);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$5$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements HardTouchableLayout.g
  {
    m(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert<T> paramFinderFeedFullConvert) {}
    
    public final void fu(View paramView)
    {
      AppMethodBeat.i(350244);
      kotlin.g.b.s.u(paramView, "view");
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onSingleClickListener onMediaClick  ", this.wHm.CSA));
      jdField_this.a(this.wHm, paramView, ((BaseFinderFeed)this.wHm.CSA).feedObject.getFeedObject());
      AppMethodBeat.o(350244);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$5$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements HardTouchableLayout.b
  {
    n(com.tencent.mm.view.recyclerview.j paramj, FinderFeedFullConvert<T> paramFinderFeedFullConvert, int paramInt) {}
    
    public final void c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(350236);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("onDoubleClick ", this.wHm.CSA));
      jdField_this.a(this.wHm, paramView, paramMotionEvent);
      AppMethodBeat.o(350236);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$5$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements HardTouchableLayout.d
  {
    o(FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final void ft(View paramView)
    {
      AppMethodBeat.i(350232);
      kotlin.g.b.s.u(paramView, "view");
      FinderFeedFullConvert localFinderFeedFullConvert = this.AIw;
      com.tencent.mm.view.recyclerview.j localj = paramj;
      Object localObject = paramj.CSA;
      kotlin.g.b.s.s(localObject, "holder.getAssociatedObject<T>()");
      localFinderFeedFullConvert.a(localj, paramView, (BaseFinderFeed)localObject);
      AppMethodBeat.o(350232);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    p(T paramT, FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    q(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    r(View paramView, T paramT, com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
    
    private static final boolean a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, View paramView)
    {
      AppMethodBeat.i(350226);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramBaseFinderFeed);
      localb.cH(paramj);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$9$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
      kotlin.g.b.s.u(paramj, "$holder");
      paramView = FeedData.Companion;
      paramView = (dji)kotlin.a.p.oK((List)FeedData.a.l(paramBaseFinderFeed).getMediaList());
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = paramj.context;
      if (localObject == null)
      {
        paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(350226);
        throw paramBaseFinderFeed;
      }
      com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(com.tencent.mm.plugin.finder.viewmodel.component.k.class);
      localObject = paramj.context;
      kotlin.g.b.s.s(localObject, "holder.context");
      com.tencent.mm.plugin.finder.viewmodel.component.k.a((Context)localObject, paramView, paramBaseFinderFeed.feedObject.getFeedObject(), paramj);
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$9$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(350226);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements CommentDrawerContract.CloseDrawerCallback
  {
    s(FinderFeedFullConvert<T> paramFinderFeedFullConvert, T paramT, com.tencent.mm.view.recyclerview.j paramj, ah.d paramd) {}
    
    public final void z(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.t> paramList)
    {
      AppMethodBeat.i(350210);
      kotlin.g.b.s.u(paramList, "data");
      FinderFeedFullConvert.a(this.AIw, paramT, paramj);
      paramList = FinderFeedFullConvert.a(this.AIw).getVideoCore().GpZ;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (FinderFeedFullConvert.a(this.AIw).ebw()) {
        ((TextView)paramj.UH(e.e.comment_count_tv)).setText((CharSequence)com.tencent.mm.plugin.finder.utils.r.ip(1, paramT.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTg().bmg()).intValue() == 1) {
        paramj.getRecyclerView().br(0, -this.AII.aixb);
      }
      paramList = com.tencent.mm.ui.component.k.aeZF;
      paramList = paramj.context;
      kotlin.g.b.s.s(paramList, "holder.context");
      paramList = (com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.l.class);
      if (paramList != null) {
        paramList.O(paramj);
      }
      paramList = com.tencent.mm.ui.component.k.aeZF;
      paramList = paramj.context;
      kotlin.g.b.s.s(paramList, "holder.context");
      paramList = (com.tencent.mm.plugin.finder.viewmodel.component.s)com.tencent.mm.ui.component.k.nq(paramList).cp(com.tencent.mm.plugin.finder.viewmodel.component.s.class);
      if (paramList != null)
      {
        kotlin.g.b.s.u(paramj, "holder");
        if (paramList.GPn)
        {
          paramList.fnz();
          paramList.GPn = false;
        }
      }
      AppMethodBeat.o(350210);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCreationBySameTemplateStatus$1$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    extends com.tencent.mm.view.e.b
  {
    t(byy parambyy, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      bui localbui = null;
      AppMethodBeat.i(350213);
      kotlin.g.b.s.u(paramView, "view");
      label72:
      JSONObject localJSONObject;
      byy localbyy;
      if (paramBoolean)
      {
        paramView = this.AIJ;
        if (paramView != null) {
          break label141;
        }
        paramView = null;
        Log.i("Finder.FeedFullConvert", kotlin.g.b.s.X("creation same tag exposed ", paramView));
        paramView = com.tencent.mm.plugin.finder.report.bb.FuK;
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramView = paramj.context;
        kotlin.g.b.s.s(paramView, "holder.context");
        paramView = as.a.hu(paramView);
        if (paramView != null) {
          break label149;
        }
        localJSONObject = new JSONObject();
        localbyy = this.AIJ;
        if (localbyy != null) {
          break label158;
        }
        paramView = "";
        label95:
        localJSONObject.put("templateId", paramView);
        if (localbyy != null) {
          break label179;
        }
        paramView = "";
      }
      for (;;)
      {
        localJSONObject.put("shooting_templateid", paramView);
        paramView = ah.aiuX;
        com.tencent.mm.plugin.finder.report.bb.a(localbui, "shoot_same_video", false, localJSONObject);
        AppMethodBeat.o(350213);
        return;
        label141:
        paramView = paramView.id;
        break;
        label149:
        localbui = paramView.fou();
        break label72;
        label158:
        String str = localbyy.id;
        paramView = str;
        if (str != null) {
          break label95;
        }
        paramView = "";
        break label95;
        label179:
        str = localbyy.id;
        paramView = str;
        if (str == null) {
          paramView = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    u(com.tencent.mm.view.recyclerview.j paramj, FlowTextMixView paramFlowTextMixView, TextView paramTextView, FinderFeedFullConvert<T> paramFinderFeedFullConvert)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    v(T paramT, ah.f<View> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.b<FinderCommentInfo, ah>
  {
    w(FinderFeedFullConvert<T> paramFinderFeedFullConvert, com.tencent.mm.view.recyclerview.j paramj, T paramT)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$5$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    extends com.tencent.mm.plugin.finder.animation.a
  {
    x(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(350182);
      this.AID.setVisibility(8);
      this.AID.setAlpha(1.0F);
      AppMethodBeat.o(350182);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    y(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, LinkedList<FinderCommentInfo> paramLinkedList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    z(List<ImageView> paramList, kotlin.g.a.a<Boolean> parama, FinderFeedFullConvert<T> paramFinderFeedFullConvert, LinkedList<FinderCommentInfo> paramLinkedList, List<View> paramList1, com.tencent.mm.view.recyclerview.j paramj, float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderFeedFullConvert
 * JD-Core Version:    0.7.0.1
 */