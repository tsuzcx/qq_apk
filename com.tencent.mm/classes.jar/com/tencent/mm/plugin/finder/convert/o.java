package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.upload.action.j.a;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.d;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
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
import kotlin.g.b.z.a;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "avatarRectControl", "displayHeight", "getDisplayHeight", "()I", "displayHeight$delegate", "Lkotlin/Lazy;", "isFromAd", "()Z", "isFromAd$delegate", "isRealNameLike", "navigationBarHeight", "getNavigationBarHeight", "navigationBarHeight$delegate", "rect", "Landroid/graphics/Rect;", "getSafeMode", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "getTabType", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1;", "adjustOptionLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "adjustSeekLayout", "adjustUserLayout", "calculateMediaLayoutParams", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkScrollToNextFeed", "checkShowFollowLikeLayout", "checkShowLittleFollowLayout", "checkShowShareSnsLayout", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "formatDesc", "incCount", "suffix", "", "descTv", "Landroid/widget/TextView;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "handleLinkTvOnClick", "link", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "handlePoiOnClick", "poiText", "isNewsObject", "isShowRealNameRecommendLayout", "likeAvatarAnimator", "likeCount", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "avatarLayoutList", "", "Landroid/view/View;", "parent", "likeFeed", "likeAction", "e", "Landroid/view/MotionEvent;", "mergeContent", "Lkotlin/Pair;", "Landroid/text/SpannableString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)Lkotlin/Pair;", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onDeepEnjoyMedia", "onMediaClick", "view", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onPostFinished", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "onUnFocusFeedCenter", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "refreshAwesomeIv", "isLike", "isPrivate", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshCommentLayout", "refreshDescContent", "refreshFav", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFollowState", "refreshForwardCount", "refreshFriendFollowCount", "refreshFullGuideTips", "refreshLivingIcon", "refreshMoreBtn", "refreshNewsLayout", "userName", "refreshNickname", "refreshPostProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshPrivateIcon", "refreshRead", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshSelfScene", "refreshUpdateTime", "setGroupLikeIcon", "imageView", "Landroid/widget/ImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "shareFeed", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class o<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.e<T>
{
  public static final a tBI = new a((byte)0);
  final int dLS;
  private Rect rect;
  private final HashSet<b<T>> tAb;
  private final boolean tAf;
  private final boolean tAg;
  private final i tAi;
  private boolean tAj;
  private final kotlin.f tBE;
  private final kotlin.f tBF;
  private final kotlin.f tBG;
  private final FinderFeedFullConvert.uiLifecycleObserver.1 tBH;
  
  public o(i parami, boolean paramBoolean, int paramInt)
  {
    this.tAi = parami;
    this.tAj = paramBoolean;
    this.dLS = paramInt;
    this.tAb = new HashSet();
    this.tBE = kotlin.g.ah((kotlin.g.a.a)o.h.tBQ);
    this.tBF = kotlin.g.ah((kotlin.g.a.a)o.l.tCc);
    this.tBG = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.rect = new Rect();
    parami = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsp().value()).intValue() == 1)
    {
      paramBoolean = true;
      this.tAf = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsq().value()).intValue() != 1) {
        break label168;
      }
    }
    label168:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.tAg = paramBoolean;
      this.tBH = new FinderFeedFullConvert.uiLifecycleObserver.1(this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final int a(boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    int j = 2131690239;
    int i;
    if (this.tAi.dbZ()) {
      i = 2131690240;
    }
    do
    {
      do
      {
        return i;
        y localy = y.vXH;
        i = j;
      } while (y.i(paramBaseFinderFeed.contact));
      i = j;
    } while (paramBoolean);
    return 2131690243;
  }
  
  public static com.tencent.mm.bw.b a(T paramT)
  {
    kotlin.g.b.p.h(paramT, "item");
    return paramT.likeBuffer;
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.h paramh, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt + ')';
    paramString = new StringBuilder(paramString);
    paramInt = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    paramh = paramh.getContext();
    kotlin.g.b.p.g(paramh, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.getResources().getColor(2131099818)), paramInt, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private static void a(ImageView paramImageView, azu paramazu)
  {
    if (paramazu != null)
    {
      paramazu = paramazu.LJJ;
      localObject = (CharSequence)paramazu;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label87;
      }
      paramImageView.setLayerPaint(null);
      paramazu = paramImageView.getContext();
      localObject = paramImageView.getContext();
      kotlin.g.b.p.g(localObject, "imageView.context");
      paramImageView.setImageDrawable(ar.m(paramazu, 2131690578, ((Context)localObject).getResources().getColor(2131099824)));
      return;
      paramazu = null;
      break;
    }
    label87:
    paramImageView.setLayerPaint(null);
    Object localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
    localObject = com.tencent.mm.plugin.finder.loader.m.djY();
    paramazu = new com.tencent.mm.plugin.finder.loader.p(paramazu, com.tencent.mm.plugin.finder.storage.x.vEn);
    com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
    ((com.tencent.mm.loader.d)localObject).a(paramazu, paramImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.h paramh, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.j.dBt().p(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    final int j = com.tencent.mm.plugin.finder.upload.action.j.dBt().o(paramT.feedObject.getFeedObject());
    if (!d(paramT))
    {
      Log.i("Finder.FeedFullConvert", "[refreshRealNameRecommendLayout] tabType:" + this.dLS + ", " + Util.isNullOrNil((List)localLinkedList) + ", " + j + ' ' + this.tAf);
      paramT = paramh.Mn(2131306595);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      return;
    }
    if (this.tAg) {}
    final boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    FrameLayout localFrameLayout;
    int i;
    int k;
    for (final float f = 0.1F;; f = 0.5F)
    {
      bool1 = this.tAg;
      localObject1 = paramh.Mn(2131306595);
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = (List)new ArrayList();
      ((List)localObject2).add(paramh.Mn(2131301770));
      ((List)localObject2).add(paramh.Mn(2131301772));
      ((List)localObject2).add(paramh.Mn(2131301774));
      localObject3 = (List)new ArrayList();
      localObject4 = (FrameLayout)paramh.Mn(2131301771);
      localObject5 = (FrameLayout)paramh.Mn(2131301773);
      localFrameLayout = (FrameLayout)paramh.Mn(2131301775);
      localObject1 = (FrameLayout)paramh.Mn(2131301780);
      i = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 24);
      localObject6 = paramh.getContext();
      kotlin.g.b.p.g(localObject6, "holder.context");
      k = (int)((Context)localObject6).getResources().getDimension(2131165297);
      if (!this.tAg) {
        break label751;
      }
      kotlin.g.b.p.g(localObject4, "layout1");
      localObject6 = ((FrameLayout)localObject4).getLayoutParams();
      if (localObject6 != null) {
        break label373;
      }
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    label373:
    Object localObject6 = (FrameLayout.LayoutParams)localObject6;
    ((FrameLayout.LayoutParams)localObject6).width = i;
    ((FrameLayout.LayoutParams)localObject6).height = i;
    ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localObject5, "layout2");
    localObject6 = ((FrameLayout)localObject5).getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    ((FrameLayout.LayoutParams)localObject6).leftMargin = i;
    ((FrameLayout.LayoutParams)localObject6).width = i;
    ((FrameLayout.LayoutParams)localObject6).height = i;
    ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localFrameLayout, "layout3");
    localObject6 = localFrameLayout.getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    ((FrameLayout.LayoutParams)localObject6).leftMargin = (i * 2);
    ((FrameLayout.LayoutParams)localObject6).width = i;
    ((FrameLayout.LayoutParams)localObject6).height = i;
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localObject1, "layoutExtra");
    localObject6 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    ((FrameLayout.LayoutParams)localObject6).width = i;
    ((FrameLayout.LayoutParams)localObject6).height = i;
    ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject6 = ((List)localObject2).iterator();
    if (((Iterator)localObject6).hasNext())
    {
      ImageView localImageView = (ImageView)((Iterator)localObject6).next();
      if (localImageView != null) {}
      for (localObject1 = localImageView.getLayoutParams();; localObject1 = null)
      {
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).width = k;
        }
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = k;
        }
        if (localImageView == null) {
          break;
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    localObject6 = paramh.Mn(2131301776);
    if (localObject6 != null)
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      label715:
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = k;
      }
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).height = k;
      }
      if (localObject6 != null) {
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label751:
      ((List)localObject3).add(localObject4);
      ((List)localObject3).add(localObject5);
      ((List)localObject3).add(localFrameLayout);
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297354);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = ((RoundLinearLayout)localObject1).getChildAt(0);
        kotlin.g.b.p.g(localObject1, "it.getChildAt(0)");
        ((View)localObject1).setBackground(null);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297355);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = ((RoundLinearLayout)localObject1).getChildAt(0);
        kotlin.g.b.p.g(localObject1, "it.getChildAt(0)");
        ((View)localObject1).setBackground(null);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297356);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = ((RoundLinearLayout)localObject1).getChildAt(0);
        kotlin.g.b.p.g(localObject1, "it.getChildAt(0)");
        ((View)localObject1).setBackground(null);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131301777);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
      ((kotlin.g.a.a)new ap((List)localObject2, (List)localObject3, (kotlin.g.a.a)new ao(((Boolean)((kotlin.o)localObject1).first).booleanValue(), ((Boolean)((kotlin.o)localObject1).second).booleanValue(), this, paramh, f, paramT, paramBoolean, localLinkedList, bool1, j), this, paramh, f, paramT, paramBoolean, localLinkedList, bool1, j)).invoke();
      localObject4 = (TextView)paramh.Mn(2131306597);
      if (localObject4 != null)
      {
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        ((TextView)localObject4).setTextColor(((Context)localObject1).getResources().getColor(2131100618));
        ao.a((Paint)((TextView)localObject4).getPaint(), 0.1F);
        ((TextView)localObject4).setTextSize(1, 14.0F);
        if (!bool1) {
          break label1726;
        }
        if (localLinkedList.size() > 3) {
          break label1643;
        }
        localObject5 = paramh.getContext();
        localObject1 = y.vXH;
        localObject1 = (FinderCommentInfo)kotlin.a.j.kv((List)localLinkedList);
        if (localObject1 != null)
        {
          localObject1 = ((FinderCommentInfo)localObject1).username;
          if (localObject1 != null) {
            break label2041;
          }
        }
        localObject1 = "";
      }
    }
    label1410:
    label1452:
    label1476:
    label1643:
    label2038:
    label2041:
    for (;;)
    {
      localObject2 = (FinderCommentInfo)kotlin.a.j.kv((List)localLinkedList);
      if (localObject2 != null)
      {
        localObject3 = ((FinderCommentInfo)localObject2).nickname;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)y.hf((String)localObject1, (String)localObject2));
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject4).setText((CharSequence)localObject1);
      localObject1 = kotlin.x.SXb;
      localObject3 = (TextView)paramh.Mn(2131306594);
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      ((TextView)localObject3).setTextColor(((Context)localObject1).getResources().getColor(2131100618));
      kotlin.g.b.p.g(localObject3, "descTv");
      ao.a((Paint)((TextView)localObject3).getPaint(), 0.1F);
      ((TextView)localObject3).setTextSize(1, 14.0F);
      localObject1 = y.vXH;
      boolean bool2 = y.v(paramT);
      k = paramT.feedObject.getFeedObject().incFriendLikeCount;
      int m = j - k;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramT.feedObject.getFeedObject().objectType);
      if (j <= 1) {
        if (localObject1 == null)
        {
          localObject1 = paramh.getContext().getString(2131760497);
          kotlin.g.b.p.g(localObject1, "if (wordingConfig == nul…里不需要文案了\n                }");
          if ((k <= 0) || (!bool2)) {
            break label1820;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          a(k, paramh, (String)localObject2, (TextView)localObject3);
          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dwq().value()).intValue() != 1) {
            break label1994;
          }
          i = 1;
          localObject1 = paramh.Mn(2131301651);
          if (i == 0) {
            break label2017;
          }
          localObject2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
          localObject2 = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
          bool2 = ((Boolean)((kotlin.o)localObject2).first).booleanValue();
          ((Boolean)((kotlin.o)localObject2).second).booleanValue();
          if ((paramT.isDeepEnjoy) && (!bool2)) {
            break label2000;
          }
          kotlin.g.b.p.g(localObject1, "followLikeLayout");
          ((View)localObject1).setVisibility(8);
          ((View)localObject1).setOnClickListener((View.OnClickListener)new aq((View)localObject1, this, paramh, f, paramT, paramBoolean, localLinkedList, bool1, j));
          localObject1 = paramh.Mn(2131306596);
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setOnClickListener((View.OnClickListener)new ar(this, paramh, f, paramT, paramBoolean, localLinkedList, bool1, j));
          paramT = kotlin.x.SXb;
          return;
          localObject1 = null;
          break label715;
          localObject5 = paramh.getContext();
          localObject1 = y.vXH;
          localObject1 = ((FinderCommentInfo)localLinkedList.get(2)).username;
          if (localObject1 != null) {
            break label2038;
          }
          localObject1 = "";
        }
      }
      for (;;)
      {
        localObject3 = ((FinderCommentInfo)localLinkedList.get(2)).nickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)y.hf((String)localObject1, (String)localObject2));
        break;
        localObject5 = paramh.getContext();
        localObject1 = y.vXH;
        localObject1 = ((FinderCommentInfo)localLinkedList.get(0)).username;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject3 = ((FinderCommentInfo)localLinkedList.get(0)).nickname;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject1 = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)y.hf((String)localObject1, (String)localObject2));
          break;
          localObject1 = "";
          break label1410;
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1452;
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((azu)localObject1).LJz;
            if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label1941;
              }
            }
          }
          else
          {
            localObject1 = paramh.getContext().getString(2131760496, new Object[] { String.valueOf(m + k) });
          }
          for (;;)
          {
            if ((k <= 0) || (!bool2)) {
              break label1981;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            a(k, paramh, (String)localObject2, (TextView)localObject3);
            break;
            i = 0;
            break label1866;
            localObject1 = ((azu)localObject1).LJz;
            if (localObject1 != null) {
              localObject1 = n.j((String)localObject1, "$$", String.valueOf(m + k), true);
            } else {
              localObject1 = null;
            }
          }
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1452;
          i = 0;
          break label1476;
          kotlin.g.b.p.g(localObject1, "followLikeLayout");
          ((View)localObject1).setVisibility(0);
          break label1562;
          kotlin.g.b.p.g(localObject1, "followLikeLayout");
          ((View)localObject1).setVisibility(8);
          break label1591;
        }
      }
    }
  }
  
  private final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.h paramh)
  {
    com.tencent.mm.plugin.finder.loader.m localm = null;
    int j = 0;
    int k = 1;
    Object localObject1 = (FinderFullSeekBarLayout)paramh.Mn(2131301839);
    if (localObject1 != null) {
      ((FinderFullSeekBarLayout)localObject1).tNO = paramBaseFinderFeed;
    }
    localObject1 = paramh.hgv();
    kotlin.g.b.p.g(localObject1, "holder.getAssociatedObject()");
    f(paramh, (BaseFinderFeed)localObject1);
    ImageView localImageView = (ImageView)paramh.Mn(2131302492);
    int i;
    Object localObject2;
    boolean bool;
    azu localazu;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        kotlin.g.b.p.g(localImageView, "awesomeIv");
        localImageView.setTag(Integer.valueOf(2));
        localObject1 = paramh.getContext();
        i = a(paramBoolean2, paramBaseFinderFeed);
        localObject2 = paramh.getContext();
        kotlin.g.b.p.g(localObject2, "holder.context");
        localObject1 = ar.m((Context)localObject1, i, ((Context)localObject2).getResources().getColor(2131099824));
        localObject2 = y.vXH;
        bool = y.i(paramBaseFinderFeed.contact);
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        localazu = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label383;
        }
        a(localImageView, localazu);
      }
    }
    for (;;)
    {
      localObject1 = (TextView)paramh.Mn(2131303177);
      if (!this.tAi.dbZ()) {
        break label627;
      }
      kotlin.g.b.p.g(localObject1, "likeTv");
      ao.b((Paint)((TextView)localObject1).getPaint());
      paramh = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(com.tencent.mm.plugin.finder.upload.action.j.dBt().n(paramBaseFinderFeed.feedObject.getFeedObject())));
      return;
      kotlin.g.b.p.g(localImageView, "awesomeIv");
      localImageView.setTag(Integer.valueOf(1));
      break;
      kotlin.g.b.p.g(localImageView, "awesomeIv");
      localImageView.setTag(Integer.valueOf(0));
      localObject1 = paramh.getContext();
      if ((paramBoolean2) && (paramBoolean1)) {}
      for (bool = true;; bool = false)
      {
        i = a(bool, paramBaseFinderFeed);
        localObject2 = paramh.getContext();
        kotlin.g.b.p.g(localObject2, "holder.context");
        localObject1 = ar.m((Context)localObject1, i, ((Context)localObject2).getResources().getColor(2131100620));
        break;
      }
      label383:
      if ((localazu != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {}
        for (localObject1 = localazu.LJE;; localObject1 = localazu.LJL)
        {
          localImageView.setLayerPaint(null);
          localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
          localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject2).a(localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb)).c(localImageView);
          break;
        }
      }
      localImageView.setLayerPaint(null);
      if (localazu != null)
      {
        localObject2 = localazu.LJL;
        label492:
        localObject2 = (CharSequence)localObject2;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label555;
        }
      }
      label555:
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (!this.tAi.dbZ()) && (!bool)) {
          break label561;
        }
        localImageView.setImageDrawable((Drawable)localObject1);
        break;
        localObject2 = null;
        break label492;
      }
      label561:
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
      localObject1 = localm;
      if (localazu != null) {
        localObject1 = localazu.LJL;
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
      localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb)).c(localImageView);
    }
    label627:
    if (paramInt > 0)
    {
      i = k;
      if (!this.tAi.dbZ()) {
        i = 2;
      }
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.k.gm(i, paramInt);
      kotlin.g.b.p.g(paramBaseFinderFeed, "FinderFormatUtil.formatN….SCENE_FINDER, likeCount)");
      kotlin.g.b.p.g(localObject1, "likeTv");
      ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed);
      return;
    }
    if (localazu != null)
    {
      paramBaseFinderFeed = (CharSequence)localazu.LJI;
      if (paramBaseFinderFeed != null)
      {
        paramInt = j;
        if (paramBaseFinderFeed.length() != 0) {}
      }
      else
      {
        paramInt = 1;
      }
      if (paramInt == 0) {}
    }
    else
    {
      paramBaseFinderFeed = paramh.getContext().getString(2131759831);
      kotlin.g.b.p.g(paramBaseFinderFeed, "holder.context.getString…g.finder_like_count_text)");
    }
    for (;;)
    {
      kotlin.g.b.p.g(localObject1, "likeTv");
      ao.b((Paint)((TextView)localObject1).getPaint());
      break;
      paramBaseFinderFeed = localazu.LJI;
      if (paramBaseFinderFeed == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  private static void a(com.tencent.mm.view.recyclerview.h paramh)
  {
    paramh.aus.performHapticFeedback(0, 3);
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(final com.tencent.mm.view.recyclerview.h paramh, final T paramT)
  {
    Object localObject1 = FinderReporterUIC.wzC;
    localObject1 = paramh.getContext();
    kotlin.g.b.p.g(localObject1, "holder.context");
    localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
    int i;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).tCE;
      localObject1 = (TextView)paramh.Mn(2131303243);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new ag(this, paramh, paramT));
      kotlin.g.b.p.g(localObject1, "followIv");
      ((TextView)localObject1).setTextSize(0, com.tencent.mm.cb.a.aH(((TextView)localObject1).getContext(), 2131165213));
      localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
      bool = com.tencent.mm.plugin.finder.api.c.a.asJ(paramT.feedObject.field_username);
      if (!this.tAj) {
        break label146;
      }
      paramh.mf(2131303243, 8);
      label127:
      if (!cZC()) {
        break label390;
      }
      ((TextView)localObject1).setVisibility(0);
    }
    label146:
    while (paramT.isDeepEnjoy)
    {
      return;
      i = 0;
      break;
      if ((this.dLS != 3) && (bool) && (i != 1))
      {
        localObject2 = y.vXH;
        if (!y.h(paramT))
        {
          localObject2 = paramT.contact;
          if (localObject2 != null) {}
          for (i = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_liveStatus; i == 1; i = 2)
          {
            ((TextView)localObject1).setVisibility(8);
            return;
          }
          ((TextView)localObject1).setVisibility(0);
          localObject2 = ((TextView)localObject1).getContext();
          kotlin.g.b.p.g(localObject2, "followIv.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131761616));
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          ((TextView)localObject1).setTextColor(paramh.getResources().getColor(2131100616));
          ((TextView)localObject1).setBackgroundResource(2131232546);
          break label127;
        }
      }
      if ((!bool) && (this.dLS != 3))
      {
        ((TextView)localObject1).setVisibility(0);
        localObject2 = ((TextView)localObject1).getContext();
        kotlin.g.b.p.g(localObject2, "followIv.context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766785));
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        ((TextView)localObject1).setTextColor(paramh.getResources().getColor(2131099844));
        ((TextView)localObject1).setBackgroundResource(2131232544);
        break label127;
      }
      ((TextView)localObject1).setVisibility(8);
      break label127;
    }
    label390:
    ((TextView)localObject1).setVisibility(8);
  }
  
  private final boolean a(com.tencent.mm.view.recyclerview.h paramh, int paramInt, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramh.hgv();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((kotlin.o)localObject1).first).booleanValue();
    boolean bool3 = ((Boolean)((kotlin.o)localObject1).second).booleanValue();
    WeImageView localWeImageView;
    Object localObject2;
    label121:
    boolean bool2;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label660;
      }
      View localView = paramh.Mn(2131302492);
      localWeImageView = f(paramh);
      localWeImageView.setLayerPaint(null);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(localBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (localObject2 != null) {
        break label450;
      }
      localObject1 = "";
      if (!paramBoolean) {
        break label460;
      }
      a((ImageView)localWeImageView, (azu)localObject2);
      label135:
      localObject1 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
      com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 1.4F, paramMotionEvent, true, 16);
      paramMotionEvent = com.tencent.mm.plugin.finder.view.animation.c.wrB;
      kotlin.g.b.p.g(localView, "likeIcon");
      com.tencent.mm.plugin.finder.view.animation.c.ei(localView);
      if ((paramInt == 2) || (paramBoolean)) {
        a(paramh);
      }
      paramMotionEvent = paramh.Mn(2131301471);
      if (paramMotionEvent != null) {
        paramMotionEvent.setVisibility(8);
      }
      label208:
      if (!bool1) {
        break label706;
      }
      bool2 = false;
      label216:
      paramMotionEvent = this.tAi;
      kotlin.g.b.p.g(localBaseFinderFeed, "item");
      paramMotionEvent.a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      paramMotionEvent = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(localBaseFinderFeed.feedObject.getFeedObject()), paramh);
      paramMotionEvent = y.vXH;
      if ((y.v(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label713;
        }
        paramMotionEvent = localBaseFinderFeed.feedObject.getFeedObject();
        paramMotionEvent.incFriendLikeCount += 1;
      }
      label318:
      paramMotionEvent = new hn();
      paramMotionEvent.dLW.id = localBaseFinderFeed.lT();
      paramMotionEvent.dLW.type = 4;
      localObject1 = paramMotionEvent.dLW;
      if ((!bool1) || (!paramBoolean)) {
        break label743;
      }
      paramInt = 2;
    }
    for (;;)
    {
      ((hn.a)localObject1).dLZ = paramInt;
      EventCenter.instance.publish((IEvent)paramMotionEvent);
      paramMotionEvent = FinderReporterUIC.wzC;
      paramh = paramh.getContext();
      kotlin.g.b.p.g(paramh, "holder.context");
      paramh = FinderReporterUIC.a.fH(paramh);
      if (paramh != null)
      {
        paramh = FinderReporterUIC.b(paramh);
        if (paramh != null)
        {
          paramh = paramh.cZR();
          if (!bool1) {
            break label758;
          }
          paramh.Eo(localBaseFinderFeed.lT());
        }
      }
      return bool1;
      bool1 = false;
      break;
      label450:
      localObject1 = ((azu)localObject2).LJE;
      break label121;
      label460:
      localObject2 = y.vXH;
      if (y.i(localBaseFinderFeed.contact))
      {
        localObject1 = paramh.getContext();
        localObject2 = paramh.getContext();
        kotlin.g.b.p.g(localObject2, "holder.context");
        localWeImageView.setImageDrawable(ar.m((Context)localObject1, 2131690239, ((Context)localObject2).getResources().getColor(2131099824)));
        break label135;
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label613;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
        localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        break;
      }
      label613:
      localObject1 = paramh.getContext();
      localObject2 = paramh.getContext();
      kotlin.g.b.p.g(localObject2, "holder.context");
      localWeImageView.setImageDrawable(ar.m((Context)localObject1, 2131690243, ((Context)localObject2).getResources().getColor(2131099824)));
      break label135;
      label660:
      paramMotionEvent = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dux().value()).intValue() != 1) {
        break label208;
      }
      localBaseFinderFeed.showCommentEdu = false;
      kotlin.g.b.p.g(localBaseFinderFeed, "item");
      b(paramh, localBaseFinderFeed, 1);
      break label208;
      label706:
      bool2 = bool3;
      break label216;
      label713:
      if (bool3) {
        break label318;
      }
      paramMotionEvent = localBaseFinderFeed.feedObject.getFeedObject();
      paramMotionEvent.incFriendLikeCount -= 1;
      break label318;
      label743:
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    label758:
    paramh.Ep(localBaseFinderFeed.lT());
    return bool1;
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.h paramh, final T paramT, final int paramInt)
  {
    View localView = paramh.Mn(2131300577);
    if (paramT.showCommentEdu)
    {
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(locala, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)locala).dxX())
      {
        kotlin.g.b.p.g(localView, "layout");
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new ac(this, paramh, paramT, paramInt));
        return;
      }
    }
    kotlin.g.b.p.g(localView, "layout");
    localView.setVisibility(8);
  }
  
  private final void c(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    int j = 0;
    if (this.tAf)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      if (!Util.isNullOrNil((List)com.tencent.mm.plugin.finder.upload.action.j.dBt().p(paramT.feedObject.getFeedObject())))
      {
        paramh.mf(2131306677, 8);
        return;
      }
    }
    Object localObject1 = FinderReporterUIC.wzC;
    localObject1 = paramh.getContext();
    kotlin.g.b.p.g(localObject1, "holder.context");
    localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
    int k;
    if (localObject1 != null)
    {
      i = ((FinderReporterUIC)localObject1).tCE;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE)))) {
        break label527;
      }
      k = paramT.feedObject.getFeedObject().recommendType;
      paramh.mf(2131306677, 0);
      localObject1 = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label417;
      }
      i = 1;
      label197:
      if (i != 0) {
        break label454;
      }
      localObject1 = (TextView)paramh.Mn(2131306678);
      Object localObject2 = paramh.getContext();
      kotlin.g.b.p.g(localObject2, "holder.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100618));
      kotlin.g.b.p.g(localObject1, "reasonTv");
      paramT = com.tencent.mm.pluginsdk.ui.span.l.h(paramh.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject1).getTextSize());
      localObject2 = paramh.getContext();
      kotlin.g.b.p.g(localObject2, "holder.context");
      k = ((Context)localObject2).getResources().getColor(2131100613);
      paramh = paramh.getContext();
      kotlin.g.b.p.g(paramh, "holder.context");
      paramh = paramh.getResources();
      localObject2 = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)localObject2).dxX()) {
        break label422;
      }
    }
    label417:
    label422:
    for (int i = 2131100631;; i = 2131100620)
    {
      int m = paramh.getColor(i);
      paramh = (com.tencent.mm.pluginsdk.ui.span.p[])paramT.getSpans(0, paramT.length(), com.tencent.mm.pluginsdk.ui.span.p.class);
      if (paramh == null) {
        break label429;
      }
      int n = paramh.length;
      i = j;
      while (i < n)
      {
        paramh[i].setColor(m, k);
        i += 1;
      }
      i = 0;
      break;
      i = 0;
      break label197;
    }
    label429:
    ((TextView)localObject1).setText((CharSequence)paramT);
    ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o());
    return;
    label454:
    Log.w("Finder.FeedFullConvert", "hide recommend layout type=" + k + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    paramh.mf(2131306677, 8);
    return;
    label527:
    paramh.mf(2131306677, 8);
  }
  
  private static boolean c(T paramT)
  {
    y localy = y.vXH;
    if (!y.h(paramT)) {}
    while ((paramT.feedObject.isPostFinish()) || ((!paramT.feedObject.isPostFailed()) && ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().Mpc >= 100)))) {
      return true;
    }
    return false;
  }
  
  private boolean cZC()
  {
    return ((Boolean)this.tBG.getValue()).booleanValue();
  }
  
  private final void d(final com.tencent.mm.view.recyclerview.h paramh, final FinderItem paramFinderItem, final String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramFinderItem != null)
    {
      localObject1 = paramFinderItem.getFeedObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).hotTopics;
        if (localObject1 != null)
        {
          localObject1 = ((azx)localObject1).Gbc;
          StringBuilder localStringBuilder = new StringBuilder("showNewsIndicator objectType: ");
          if (paramFinderItem == null) {
            break label285;
          }
          localObject2 = paramFinderItem.getFeedObject();
          if (localObject2 == null) {
            break label285;
          }
          localObject2 = Integer.valueOf(((FinderObject)localObject2).objectType);
          label71:
          localStringBuilder = localStringBuilder.append(localObject2).append(" size:");
          if (localObject1 == null) {
            break label291;
          }
          localObject2 = Integer.valueOf(((LinkedList)localObject1).size());
          label101:
          Log.i("Finder.FeedFullConvert", localObject2);
          if (localObject1 == null) {
            break label303;
          }
          localObject2 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (azw)((Iterator)localObject2).next();
          } while ((localObject1 == null) || (((azw)localObject1).LJN != 5));
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic " + ((azw)localObject1).twp + ' ' + ((azw)localObject1).riB + ' ' + ((azw)localObject1).LJO);
        if ((paramh.getContext() instanceof FinderShareFeedRelUI))
        {
          Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic ui is FinderShareFeedRelUI block");
          paramFinderItem = paramh.Mn(2131300831);
          if (paramFinderItem != null) {
            paramFinderItem.setVisibility(8);
          }
          paramh = paramh.Mn(2131300832);
          if (paramh != null) {
            paramh.setVisibility(8);
          }
          return;
          localObject1 = null;
          break;
          label285:
          localObject2 = null;
          break label71;
          label291:
          localObject2 = null;
          break label101;
          localObject1 = null;
          continue;
          label303:
          localObject1 = null;
          continue;
        }
        localObject2 = (TextView)paramh.Mn(2131300574);
        if (localObject2 != null)
        {
          if (((azw)localObject1).LJO <= 0) {
            break label591;
          }
          ((TextView)localObject2).setTextColor(((TextView)localObject2).getResources().getColor(2131100631));
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setBackgroundResource(2131232527);
      localObject2 = (WeImageView)paramh.Mn(2131301412);
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(((WeImageView)localObject2).getResources().getColor(2131100615));
      }
      localObject2 = paramh.Mn(2131300831);
      if (localObject2 != null)
      {
        ((View)localObject2).setVisibility(0);
        ((View)localObject2).setOnClickListener((View.OnClickListener)new ai((View)localObject2, (azw)localObject1, this, paramh, paramFinderItem, paramString));
      }
      paramFinderItem = (TextView)paramh.Mn(2131300574);
      if (paramFinderItem != null)
      {
        paramString = new StringBuilder();
        localObject2 = paramFinderItem.getContext();
        kotlin.g.b.p.g(localObject2, "context");
        paramString = ((Context)localObject2).getResources().getString(2131760330) + ((azw)localObject1).riB;
        paramFinderItem.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString));
      }
      paramFinderItem = (TextView)paramh.Mn(2131300573);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      if (localObject1 != null) {
        break;
      }
      Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic null let");
      paramFinderItem = paramh.Mn(2131300831);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      paramh = paramh.Mn(2131300832);
      if (paramh != null) {
        paramh.setVisibility(8);
      }
      paramh = kotlin.x.SXb;
      return;
      label591:
      ((TextView)localObject2).setTextColor(((TextView)localObject2).getResources().getColor(2131100617));
    }
  }
  
  private final boolean d(T paramT)
  {
    Object localObject = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    localObject = com.tencent.mm.plugin.finder.upload.action.j.dBt().p(paramT.feedObject.getFeedObject());
    j.a locala = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    int i = com.tencent.mm.plugin.finder.upload.action.j.dBt().o(paramT.feedObject.getFeedObject());
    if ((this.tAf) && (!Util.isNullOrNil((List)localObject)) && (i > 0) && (!this.tAi.dbZ()))
    {
      localObject = y.vXH;
      if (!y.i(paramT.contact)) {
        return true;
      }
    }
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  private static WeImageView f(com.tencent.mm.view.recyclerview.h paramh)
  {
    WeImageView localWeImageView = new WeImageView(paramh.getContext());
    localWeImageView.setVisibility(4);
    Object localObject = paramh.getContext();
    kotlin.g.b.p.g(localObject, "holder.context");
    int i = (int)((Context)localObject).getResources().getDimension(2131165309);
    localObject = new FrameLayout.LayoutParams(i, i);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localWeImageView.setImageResource(2131690243);
    localObject = paramh.getContext();
    kotlin.g.b.p.g(localObject, "holder.context");
    localWeImageView.setIconColor(((Context)localObject).getResources().getColor(2131099824));
    localObject = paramh.Mn(2131304552);
    paramh = (com.tencent.mm.view.recyclerview.h)localObject;
    if (!(localObject instanceof ViewGroup)) {
      paramh = null;
    }
    paramh = (ViewGroup)paramh;
    if (paramh != null) {
      paramh.addView((View)localWeImageView);
    }
    return localWeImageView;
  }
  
  private static void f(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    TextView localTextView = (TextView)paramh.aus.findViewById(2131305436);
    kotlin.g.b.p.g(localTextView, "nickTv");
    localTextView.setText((CharSequence)paramT.feedObject.getNickNameSpan());
    ao.a((Paint)localTextView.getPaint(), 0.8F);
    localTextView.setOnClickListener((View.OnClickListener)new o.aj(paramh));
    View localView2 = paramh.Mn(2131297096);
    paramT = paramh.Mn(2131303243);
    View localView1 = paramh.Mn(2131301346);
    kotlin.g.b.p.g(localView1, "livingIcon");
    float f;
    if (localView1.getVisibility() == 0)
    {
      paramT = localView1;
      f = com.tencent.mm.cb.a.ez(paramh.getContext());
      if (f > 1.0F) {
        break label189;
      }
      f = 1.0F;
    }
    for (;;)
    {
      kotlin.g.b.p.g(localView2, "authIcon");
      if (localView2.getVisibility() != 0) {
        break label211;
      }
      kotlin.g.b.p.g(paramT, "otherIcon");
      if (paramT.getVisibility() != 0) {
        break label211;
      }
      paramT = paramh.getContext();
      kotlin.g.b.p.g(paramT, "holder.context");
      localTextView.setMaxWidth((int)(paramT.getResources().getDimension(2131165310) * f));
      return;
      break;
      label189:
      if (f <= 1.125F) {
        f = 0.7F;
      } else {
        f = 0.55F;
      }
    }
    label211:
    if (localView2.getVisibility() != 0)
    {
      kotlin.g.b.p.g(paramT, "otherIcon");
      if (paramT.getVisibility() == 0)
      {
        paramT = paramh.getContext();
        kotlin.g.b.p.g(paramT, "holder.context");
        localTextView.setMaxWidth((int)(paramT.getResources().getDimension(2131165280) * f));
        return;
      }
    }
    if (localView2.getVisibility() == 0)
    {
      kotlin.g.b.p.g(paramT, "otherIcon");
      if (paramT.getVisibility() != 0)
      {
        paramT = paramh.getContext();
        kotlin.g.b.p.g(paramT, "holder.context");
        localTextView.setMaxWidth((int)(paramT.getResources().getDimension(2131165282) * f));
        return;
      }
    }
    paramT = paramh.getContext();
    kotlin.g.b.p.g(paramT, "holder.context");
    localTextView.setMaxWidth((int)(paramT.getResources().getDimension(2131165286) * f));
  }
  
  private final void f(com.tencent.mm.view.recyclerview.h paramh, final T paramT)
  {
    int i = 1;
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dwq().value()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      localObject = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
      bool = ((Boolean)((kotlin.o)localObject).first).booleanValue();
      ((Boolean)((kotlin.o)localObject).second).booleanValue();
      StringBuilder localStringBuilder = new StringBuilder("[checkShowFollowLikeLayout] isLike=").append(bool).append(" tabType=").append(this.dLS).append(" id=").append(com.tencent.mm.ac.d.zs(paramT.lT())).append(" nickname=");
      localObject = paramT.contact;
      if (localObject == null) {
        break label164;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).getNickname();
      label138:
      Log.i("Finder.FeedFullConvert", (String)localObject);
      if (i != 0) {
        break label170;
      }
    }
    label164:
    label170:
    do
    {
      return;
      i = 0;
      break;
      localObject = null;
      break label138;
      localObject = paramh.Mn(2131301651);
      kotlin.g.b.p.g(localObject, "followLikeLayout");
    } while ((((View)localObject).getVisibility() == 0) || (bool));
    ((View)localObject).setVisibility(0);
    ((View)localObject).setAlpha(0.0F);
    ((View)localObject).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new d(paramh, paramT)).start();
  }
  
  public static void g(final com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramh, "holder");
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    final View localView1 = paramh.Mn(2131299220);
    final View localView2 = paramh.Mn(2131301467);
    View localView3 = paramh.Mn(2131306109);
    if (localView3 != null) {
      localView3.post((Runnable)new c(localView3, paramh, localFinderMediaBanner, localView1, localView2));
    }
  }
  
  private final void h(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    Object localObject = paramh.Mn(2131301674);
    int i;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131307800);
      if (localObject != null)
      {
        int j = paramT.feedObject.getForwardCount();
        if ((j <= 0) && (!this.tAi.dbZ())) {
          break label115;
        }
        if (this.tAi.dbZ()) {
          break label110;
        }
        i = 2;
        paramT = com.tencent.mm.plugin.finder.utils.k.gm(i, j);
        kotlin.g.b.p.g(paramT, "FinderFormatUtil.formatN…ENE_FINDER, forwardCount)");
        ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText((CharSequence)paramT);
      return;
      label110:
      i = 1;
      break;
      label115:
      paramT = paramh.getContext().getString(2131760567);
      kotlin.g.b.p.g(paramT, "holder.context.getString…g.finder_share_icon_text)");
      ao.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  @SuppressLint({"ResourceType"})
  private final void i(final T paramT, final com.tencent.mm.view.recyclerview.h paramh)
  {
    TextView localTextView = (TextView)paramh.Mn(2131298937);
    View localView = paramh.Mn(2131298948);
    ImageView localImageView = (ImageView)paramh.Mn(2131302490);
    int j;
    if (paramT.feedObject.isCommentClose())
    {
      y localy = y.vXH;
      if (y.In(paramT.feedObject.field_username))
      {
        localImageView.setImageResource(2131690438);
        localView.setOnClickListener((View.OnClickListener)new ad(this, paramh, paramT));
        j = paramT.feedObject.getCommentCount();
        if ((j <= 0) && (!this.tAi.dbZ())) {
          break label171;
        }
        kotlin.g.b.p.g(localTextView, "seeAllCommentsTv");
        if (this.tAi.dbZ()) {
          break label166;
        }
      }
    }
    label166:
    for (int i = 2;; i = 1)
    {
      localTextView.setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(i, j));
      com.tencent.mm.plugin.finder.utils.e.n(localTextView);
      return;
      localImageView.setImageResource(2131690241);
      break;
    }
    label171:
    kotlin.g.b.p.g(localTextView, "seeAllCommentsTv");
    localTextView.setText((CharSequence)localTextView.getContext().getString(2131759594));
    com.tencent.mm.plugin.finder.utils.e.o(localTextView);
  }
  
  private final void i(final com.tencent.mm.view.recyclerview.h paramh, T paramT)
  {
    Object localObject = paramh.Mn(2131300469);
    if (!this.tAi.dbZ())
    {
      kotlin.g.b.p.g(localObject, "favView");
      ((View)localObject).setVisibility(8);
    }
    int j;
    do
    {
      return;
      kotlin.g.b.p.g(localObject, "favView");
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener((View.OnClickListener)new af(this, paramh));
      localObject = com.tencent.mm.plugin.finder.upload.action.c.vUa;
      j = com.tencent.mm.plugin.finder.upload.action.c.dBq().l(paramT.feedObject.getFeedObject());
      paramT = (TextView)paramh.Mn(2131300449);
    } while (paramT == null);
    ao.a((Paint)paramT.getPaint(), 0.8F);
    int i;
    if (j > 0) {
      if (!this.tAi.dbZ()) {
        i = 2;
      }
    }
    for (paramh = com.tencent.mm.plugin.finder.utils.k.gm(i, j);; paramh = "0")
    {
      paramT.setText((CharSequence)paramh);
      return;
      i = 1;
      break;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void j(final T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramT, "item");
    kotlin.g.b.p.h(paramh, "holder");
    Object localObject1 = y.vXH;
    if (y.h(paramT)) {
      if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().Mpc >= 100)) {
        if (paramT.isFinishPostSoon)
        {
          e(paramT, paramh);
          paramT.isFinishPostSoon = false;
        }
      }
    }
    label386:
    do
    {
      return;
      localObject1 = paramh.Mn(2131301391);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = paramh.Mn(2131301674);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      Object localObject3 = (FinderPostProgressView)paramh.Mn(2131306079);
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      ((FinderPostProgressView)localObject3).setBackColor(((Context)localObject1).getResources().getColor(2131100612));
      View localView2 = paramh.Mn(2131306080);
      View localView3 = paramh.Mn(2131306063);
      Object localObject2 = (TextView)paramh.Mn(2131300420);
      localObject1 = paramh.Mn(2131306076);
      View localView1 = paramh.Mn(2131306059);
      kotlin.g.b.p.g(localView1, "delArea");
      localView1.setVisibility(0);
      if (paramT.feedObject.isPostFailed())
      {
        kotlin.g.b.p.g(localView3, "failedArea");
        localView3.setVisibility(0);
        kotlin.g.b.p.g(localView2, "progressArea");
        localView2.setVisibility(8);
        if (!paramT.feedObject.isPostFailedCanRetry())
        {
          kotlin.g.b.p.g(localObject1, "retryArea");
          ((View)localObject1).setVisibility(8);
          if (!paramT.feedObject.isPostNoAuth()) {
            break label386;
          }
          kotlin.g.b.p.g(localObject2, "failedTv");
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          ((TextView)localObject2).setText((CharSequence)Html.fromHtml(paramh.getResources().getString(2131760421)));
          ((TextView)localObject2).setOnClickListener((View.OnClickListener)new ak(this));
          ((View)localObject1).setVisibility(0);
        }
      }
      for (;;)
      {
        localView1.setOnClickListener((View.OnClickListener)new am(this, paramT));
        ((View)localObject1).setOnClickListener((View.OnClickListener)new an(paramT));
        return;
        kotlin.g.b.p.g(localObject1, "retryArea");
        ((View)localObject1).setVisibility(0);
        break;
        if (paramT.feedObject.isEventClosed())
        {
          kotlin.g.b.p.g(localObject2, "failedTv");
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          ((TextView)localObject2).setText((CharSequence)paramh.getResources().getString(2131760420));
        }
        else
        {
          kotlin.g.b.p.g(localObject2, "failedTv");
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          ((TextView)localObject2).setText((CharSequence)paramh.getResources().getString(2131759818));
          continue;
          kotlin.g.b.p.g(localView3, "failedArea");
          localView3.setVisibility(8);
          kotlin.g.b.p.g(localView2, "progressArea");
          localView2.setVisibility(0);
          kotlin.g.b.p.g(localObject1, "retryArea");
          ((View)localObject1).setVisibility(8);
          localObject2 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject3).getProgress(), paramT.feedObject.getPostInfo().Mpc });
          ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new al((FinderPostProgressView)localObject3));
          localObject3 = ((ValueAnimator)localObject2).setDuration(400L);
          if (localObject3 != null) {
            ((ValueAnimator)localObject3).start();
          }
          paramh.setTag(localObject2);
        }
      }
      paramT = paramh.Mn(2131301391);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = paramh.Mn(2131301674);
    } while (paramT == null);
    paramT.setVisibility(0);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    Object localObject = paramh.aus;
    kotlin.g.b.p.g(localObject, "holder.itemView");
    ((View)localObject).getLayoutParams().width = -1;
    localObject = paramh.aus;
    kotlin.g.b.p.g(localObject, "holder.itemView");
    ((View)localObject).getLayoutParams().height = -1;
    paramh.aus.post((Runnable)new o.s(paramh));
    paramRecyclerView.getLayoutParams().height = -1;
    paramRecyclerView.getLayoutParams().width = -1;
    localObject = paramRecyclerView.getParent();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).getLayoutParams().width = -1;
    paramRecyclerView = paramRecyclerView.getParent();
    if (paramRecyclerView == null) {
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)paramRecyclerView).getLayoutParams().height = -1;
    paramRecyclerView = (FinderMediaBanner)paramh.Mn(2131304549);
    paramRecyclerView.setIndicatorStyle(MediaBanner.d.RjR);
    paramRecyclerView.setNeedSpaceView(false);
    paramRecyclerView.removeView((View)paramRecyclerView.wog);
    paramRecyclerView = (View.OnClickListener)new y(paramh);
    ((ImageView)paramh.Mn(2131297134)).setOnClickListener(paramRecyclerView);
    paramRecyclerView = (NeatTextView)paramh.Mn(2131308992);
    localObject = y.vXH;
    kotlin.g.b.p.g(paramRecyclerView, "contentTv");
    paramRecyclerView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h(paramRecyclerView, y.eh((View)paramRecyclerView)));
    paramRecyclerView = new b(this, paramh);
    paramh.aus.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
    paramRecyclerView.alive();
    this.tAb.add(paramRecyclerView);
    paramRecyclerView = paramh.Mn(2131297154);
    paramRecyclerView.setOnTouchListener((View.OnTouchListener)new t());
    paramRecyclerView.setOnClickListener((View.OnClickListener)new u(this, paramh));
    paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new v(this, paramh));
    kotlin.g.b.p.g(paramRecyclerView, "awesomeContainer");
    paramRecyclerView.setHapticFeedbackEnabled(false);
    paramRecyclerView = paramh.Mn(2131301674);
    if (paramRecyclerView != null)
    {
      paramRecyclerView.setOnClickListener((View.OnClickListener)o.w.tCh);
      localObject = (TextView)paramRecyclerView.findViewById(2131306546);
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 12.0F);
      }
      localObject = (TextView)paramRecyclerView.findViewById(2131300449);
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 12.0F);
      }
      localObject = (TextView)paramRecyclerView.findViewById(2131307800);
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 12.0F);
      }
      localObject = (TextView)paramRecyclerView.findViewById(2131303177);
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 12.0F);
      }
      paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131298937);
      if (paramRecyclerView != null) {
        paramRecyclerView.setTextSize(1, 12.0F);
      }
    }
    paramRecyclerView = (TextView)paramh.Mn(2131303243);
    if (paramRecyclerView != null) {
      paramRecyclerView.setTextSize(1, 10.0F);
    }
    paramRecyclerView = FinderReporterUIC.wzC;
    paramRecyclerView = paramh.getContext();
    kotlin.g.b.p.g(paramRecyclerView, "holder.context");
    paramRecyclerView = FinderReporterUIC.a.fH(paramRecyclerView);
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.MA(this.dLS);
      if (paramRecyclerView != null) {
        paramRecyclerView.a((com.tencent.mm.plugin.finder.event.base.d)new x(this, paramh));
      }
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, MotionEvent paramMotionEvent)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramView, "view");
    kotlin.g.b.p.h(paramMotionEvent, "e");
    Object localObject1 = (BaseFinderFeed)paramh.hgv();
    if (!((BaseFinderFeed)localObject1).feedObject.isPostFinish()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((this.tAi.dbZ()) || (((BaseFinderFeed)localObject1).isPreview));
      paramView = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      paramView = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(((BaseFinderFeed)localObject1).feedObject.getFeedObject());
      bool1 = ((Boolean)paramView.first).booleanValue();
      bool2 = ((Boolean)paramView.second).booleanValue();
    } while ((bool1) && (bool2));
    if (bool1)
    {
      WeImageView localWeImageView = f(paramh);
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.Lj(((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectType);
      int i;
      if (paramView == null)
      {
        paramView = "";
        Object localObject2 = (CharSequence)paramView;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label269;
        }
        i = 1;
        label177:
        if (i != 0) {
          break label275;
        }
        paramh = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramh = com.tencent.mm.plugin.finder.loader.m.djY();
        paramView = new com.tencent.mm.plugin.finder.loader.p(paramView, com.tencent.mm.plugin.finder.storage.x.vEn);
        localObject1 = (ImageView)localWeImageView;
        localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramh.a(paramView, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
      }
      for (;;)
      {
        paramh = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 1.4F, paramMotionEvent, true, 16);
        return;
        if (ao.isDarkMode())
        {
          paramView = paramView.LJE;
          break;
        }
        paramView = paramView.LJF;
        break;
        label269:
        i = 0;
        break label177;
        label275:
        paramView = y.vXH;
        if (y.i(((BaseFinderFeed)localObject1).contact))
        {
          paramView = paramh.getContext();
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          localWeImageView.setImageDrawable(ar.m(paramView, 2131690239, paramh.getResources().getColor(2131099824)));
        }
        else
        {
          paramView = paramh.getContext();
          paramh = paramh.getContext();
          kotlin.g.b.p.g(paramh, "holder.context");
          localWeImageView.setImageDrawable(ar.m(paramView, 2131690243, paramh.getResources().getColor(2131099824)));
        }
      }
    }
    a(paramh, 2, false, paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(final com.tencent.mm.view.recyclerview.h paramh, final T paramT, final int paramInt1, final int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    paramT.feedObject.setReplaceLongVideoToNormal(true);
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      paramInt1 = 1;
    }
    boolean bool;
    while (paramInt1 == 0)
    {
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject1 = paramList.next();
          if ((localObject1 instanceof kotlin.o))
          {
            localObject1 = (kotlin.o)localObject1;
            switch (((Number)((kotlin.o)localObject1).first).intValue())
            {
            case 5: 
            case 7: 
            default: 
              break;
            case 1: 
              i(paramT, paramh);
              return;
              paramInt1 = 0;
              break;
            case 2: 
              j(paramT, paramh);
              return;
            case 11: 
              i(paramT, paramh);
              return;
            case 9: 
              h(paramT, paramh);
              return;
            case 10: 
              paramList = paramT.feedObject;
              paramList.setForwardCount(paramList.getForwardCount() + 1);
              h(paramT, paramh);
              return;
            case 12: 
              i(paramT, paramh);
              h(paramT, paramh);
              return;
            case 3: 
              paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
              paramList = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
              paramBoolean = ((Boolean)paramList.first).booleanValue();
              bool = ((Boolean)paramList.second).booleanValue();
              paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
              a(paramT, paramBoolean, bool, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(paramT.feedObject.getFeedObject()), paramh);
              a(paramT, paramh, true);
              c(paramT, paramh);
              return;
            case 4: 
              i(paramh, paramT);
              return;
            case 6: 
              paramList = ((kotlin.o)localObject1).second;
              if (paramList == null) {
                throw new t("null cannot be cast to non-null type com.tencent.mm.autogen.events.FeedUpdateEvent");
              }
              paramList = (hn)paramList;
              if (paramList.dLW.dLY == 1) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                paramT.showCommentEdu = paramBoolean;
                if (paramT.feedObject.isCommentClose()) {
                  break;
                }
                b(paramh, paramT, paramList.dLW.dLX);
                return;
              }
            case 8: 
              a(paramh, paramT.feedObject, Boolean.TRUE);
              return;
            }
          }
        }
      }
    }
    if (!paramBoolean) {
      g(paramh, paramT);
    }
    paramList = paramh.aus.findViewById(2131302835);
    kotlin.g.b.p.g(paramList, "holder.itemView.findViewById<View>(R.id.item_mask)");
    paramList.setAlpha(0.0F);
    h(paramh, paramT);
    a(paramh, paramT);
    a(paramh, paramT.feedObject, Boolean.FALSE);
    label526:
    label544:
    Object localObject2;
    Object localObject3;
    label660:
    int i;
    int j;
    Object localObject4;
    label1061:
    label1141:
    Object localObject6;
    if (!this.tAi.dbZ())
    {
      paramList = paramh.Mn(2131309605);
      if (paramList != null) {
        paramList.setVisibility(8);
      }
      paramList = paramT.contact;
      if (paramList == null) {
        break label3439;
      }
      paramList = paramList.cXH();
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
      paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
      localObject2 = paramh.Mn(2131297134);
      kotlin.g.b.p.g(localObject2, "holder.getView(R.id.avatar_iv)");
      localObject2 = (ImageView)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject2 = (NeatTextView)paramh.Mn(2131308992);
      if (!c(paramT)) {
        break label3445;
      }
      paramList = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(paramList, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)paramList).dxX()) {
        break label3445;
      }
      paramBoolean = true;
      paramList = paramh.getContext();
      kotlin.g.b.p.g(paramList, "holder.context");
      paramInt1 = paramList.getResources().getColor(2131100631);
      paramList = paramh.getContext();
      kotlin.g.b.p.g(paramList, "holder.context");
      paramInt2 = paramList.getResources().getColor(2131100613);
      paramList = paramh.getContext();
      kotlin.g.b.p.g(paramList, "holder.context");
      i = paramList.getResources().getColor(2131100620);
      paramList = paramh.getContext();
      kotlin.g.b.p.g(paramList, "holder.context");
      j = paramList.getResources().getColor(2131101287);
      paramList = w.vXp;
      localObject1 = paramT.feedObject.getDescriptionFullSpan();
      paramList = (List<Object>)localObject1;
      if (localObject1 == null) {
        paramList = new SpannableString((CharSequence)"");
      }
      w.a(paramList, paramBoolean, paramInt1, paramInt2, i, j);
      localObject1 = (NeatTextView)paramh.Mn(2131308992);
      paramList = paramT.feedObject.getDescriptionFullSpan();
      final int k = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 24);
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      final int m = (int)((Context)localObject3).getResources().getDimension(2131165296);
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      final int n = (int)((Context)localObject3).getResources().getDimension(2131165306);
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      final int i1 = (int)((Context)localObject3).getResources().getDimension(2131165314);
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      localObject3 = ((Context)localObject3).getResources();
      kotlin.g.b.p.g(localObject3, "holder.context.resources");
      final float f = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      f -= 2.0F * ((Context)localObject3).getResources().getDimension(2131165296);
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      localObject3 = ((Context)localObject3).getResources();
      localObject4 = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(localObject4, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)localObject4).dxX()) {
        break label3451;
      }
      paramInt1 = 2131100631;
      paramInt1 = ((Resources)localObject3).getColor(paramInt1);
      localObject3 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject3).append((CharSequence)paramList);
      localObject4 = new z.a();
      ((z.a)localObject4).SYB = false;
      Object localObject5 = FinderReporterUIC.wzC;
      localObject5 = paramh.getContext();
      kotlin.g.b.p.g(localObject5, "holder.context");
      localObject5 = FinderReporterUIC.a.fH((Context)localObject5);
      if (localObject5 == null) {
        break label3458;
      }
      paramInt2 = ((FinderReporterUIC)localObject5).tCE;
      localObject5 = y.vXH;
      localObject5 = y.hg(paramT.feedObject.getLocation().fuK, paramT.feedObject.getLocation().kHV);
      label1192:
      label1222:
      Object localObject7;
      Object localObject8;
      if (localObject5 != null)
      {
        if (((CharSequence)localObject5).length() <= 0) {
          break label3464;
        }
        i = 1;
        if (i != 0)
        {
          localObject6 = (CharSequence)paramList;
          if ((localObject6 != null) && (((CharSequence)localObject6).length() != 0)) {
            break label3470;
          }
          i = 1;
          if (i == 0) {
            ((SpannableStringBuilder)localObject3).append((CharSequence)"\n");
          }
          i = com.tencent.mm.cb.a.n(paramh.getContext(), 2131100410);
          localObject6 = new StringBuilder("  ");
          localObject7 = (CharSequence)localObject5;
          kotlin.g.b.p.g(localObject1, "collapseTextLayout");
          localObject7 = TextUtils.ellipsize((CharSequence)localObject7, ((NeatTextView)localObject1).getPaint(), f - k, TextUtils.TruncateAt.END);
          localObject6 = new SpannableString((CharSequence)localObject7);
          localObject8 = paramh.getContext();
          if (paramT.isPreview) {
            break label3476;
          }
          j = paramInt1;
          label1337:
          localObject8 = ar.m((Context)localObject8, 2131690589, j);
          ((SpannableString)localObject6).setSpan(new com.tencent.mm.plugin.finder.view.q(n), 1, 2, 17);
          ((Drawable)localObject8).setBounds(0, 0, m, m);
          ((SpannableString)localObject6).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject8), 0, 1, 17);
          if (paramT.isPreview) {
            break label3483;
          }
          i = paramInt1;
          label1406:
          localObject8 = paramh.getContext();
          kotlin.g.b.p.g(localObject8, "holder.context");
          ((SpannableString)localObject6).setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject5, i, ((Context)localObject8).getResources().getColor(2131100605), (kotlin.g.a.b)new j(this, paramList, (SpannableStringBuilder)localObject3, paramh, (NeatTextView)localObject1, f, k, paramT, paramInt1, n, m, paramInt2, (z.a)localObject4)), 1, ((String)localObject7).length(), 17);
          if (paramInt2 != 16) {
            break label3486;
          }
          paramList = paramh.Mn(2131306042);
          kotlin.g.b.p.g(paramList, "holder.getView<View>(R.id.position_layout)");
          paramList.setVisibility(0);
          paramList = paramh.Mn(2131306013);
          kotlin.g.b.p.g(paramList, "holder.getView<TextView>(R.id.poi_name)");
          ((TextView)paramList).setText((CharSequence)localObject6);
        }
      }
      label1547:
      paramList = y.vXH;
      localObject5 = paramT.feedObject.getExtReading().link;
      localObject6 = paramT.feedObject.getExtReading().title;
      label1706:
      if ((localObject5 != null) && (localObject6 != null))
      {
        if (((CharSequence)localObject6).length() <= 0) {
          break label3530;
        }
        paramInt2 = 1;
        label1602:
        if (paramInt2 != 0)
        {
          if (((CharSequence)localObject3).length() <= 0) {
            break label3536;
          }
          paramInt2 = 1;
          label1623:
          if (paramInt2 != 0) {
            ((SpannableStringBuilder)localObject3).append((CharSequence)"\n");
          }
          paramList = new StringBuilder("  ");
          localObject7 = (CharSequence)localObject6;
          kotlin.g.b.p.g(localObject1, "collapseTextLayout");
          localObject7 = paramList.append(TextUtils.ellipsize((CharSequence)localObject7, ((NeatTextView)localObject1).getPaint(), f - k, TextUtils.TruncateAt.END));
          if (!((z.a)localObject4).SYB) {
            break label3542;
          }
          paramList = "\n ";
          paramList = paramList;
          localObject7 = new SpannableString((CharSequence)paramList);
          localObject8 = ar.m(paramh.getContext(), 2131690579, paramInt1);
          ((Drawable)localObject8).setBounds(0, 0, m, m);
          if (!((z.a)localObject4).SYB) {
            ((SpannableString)localObject7).setSpan(new com.tencent.mm.plugin.finder.view.q(n), 1, 2, 17);
          }
          ((SpannableString)localObject7).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject8), 0, 1, 17);
          localObject8 = paramh.getContext();
          kotlin.g.b.p.g(localObject8, "holder.context");
          ((SpannableString)localObject7).setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject6, paramInt1, ((Context)localObject8).getResources().getColor(2131100605), (kotlin.g.a.b)new k((String)localObject5, this, (SpannableStringBuilder)localObject3, (NeatTextView)localObject1, f, k, (z.a)localObject4, paramh, paramInt1, m, n, paramT, i1)), 1, paramList.length(), 17);
          if (((z.a)localObject4).SYB) {
            ((SpannableString)localObject7).setSpan(new com.tencent.mm.plugin.finder.view.q(i1), paramList.length() - 1, paramList.length(), 17);
          }
          ((SpannableStringBuilder)localObject3).append((CharSequence)localObject7);
        }
      }
      if ((this.tAi.dbZ()) || (paramT.feedObject.getCreateTime() <= 0)) {
        break label3583;
      }
      if (paramT.feedObject.getFeedObject().objectType != 1) {
        break label3550;
      }
      paramInt1 = 1;
      label1965:
      if (paramInt1 == 0) {
        break label3583;
      }
      ((NeatTextView)localObject1).aw((CharSequence)localObject3);
      kotlin.g.b.p.g(localObject1, "collapseTextLayout");
      paramInt2 = ((NeatTextView)localObject1).getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0)
      {
        paramList = paramh.getContext();
        kotlin.g.b.p.g(paramList, "holder.context");
        paramList = paramList.getResources();
        kotlin.g.b.p.g(paramList, "holder.context.resources");
        f = paramList.getDisplayMetrics().widthPixels;
        paramList = paramh.getContext();
        kotlin.g.b.p.g(paramList, "holder.context");
        paramInt1 = kotlin.h.a.cR(f - 2.0F * paramList.getResources().getDimension(2131165296));
      }
      paramList = ((NeatTextView)localObject1).mq(paramInt1, 2147483647);
      if (((CharSequence)localObject3).length() <= 0) {
        break label3555;
      }
      paramInt1 = 1;
      label2102:
      if (paramInt1 != 0) {
        ((SpannableStringBuilder)localObject3).append((CharSequence)"\n");
      }
      localObject1 = new SpannableString((CharSequence)com.tencent.mm.plugin.finder.utils.k.m(paramh.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      localObject4 = paramh.getContext();
      kotlin.g.b.p.g(localObject4, "holder.context");
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(((Context)localObject4).getResources().getColor(2131100616)), 0, ((SpannableString)localObject1).length(), 17);
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      if (paramList != null) {
        break label3560;
      }
      paramBoolean = true;
      label2213:
      paramList = new kotlin.o(Boolean.valueOf(paramBoolean), new SpannableString((CharSequence)localObject3));
      label2239:
      localObject1 = (SpannableString)paramList.second;
      if (((CharSequence)localObject1).length() != 0) {
        break label3610;
      }
      paramInt1 = 1;
      label2264:
      if (paramInt1 == 0) {
        break label3615;
      }
      if (localObject2 != null) {
        ((NeatTextView)localObject2).setVisibility(8);
      }
      i(paramT, paramh);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label3729;
        }
        paramInt1 = ((FinderAuthInfo)localObject1).authIconType;
        label2315:
        localObject1 = y.vXH;
        localObject1 = paramh.Mn(2131297096);
        kotlin.g.b.p.g(localObject1, "holder.getView<ImageView>(R.id.auth_icon)");
        y.a((ImageView)localObject1, paramList.field_authInfo);
      }
      switch (paramInt1)
      {
      default: 
        label2372:
        paramList = paramh.Mn(2131301842);
        if (paramList != null)
        {
          if (paramT.feedObject.getFeedObject().warnFlag == 0) {
            break label3758;
          }
          paramList.setVisibility(0);
          paramList = (TextView)paramh.Mn(2131301844);
          if (paramList != null) {
            paramList.setText((CharSequence)paramT.feedObject.getFeedObject().warnWording);
          }
        }
        label2440:
        paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        paramList = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
        paramBoolean = ((Boolean)paramList.first).booleanValue();
        bool = ((Boolean)paramList.second).booleanValue();
        paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(paramT, paramBoolean, bool, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(paramT.feedObject.getFeedObject()), paramh);
        localObject1 = paramh.aus;
        paramList = (List<Object>)localObject1;
        if (!(localObject1 instanceof HardTouchableLayout)) {
          paramList = null;
        }
        paramList = (HardTouchableLayout)paramList;
        if (paramList != null)
        {
          paramList.setEnableScale(false);
          paramList.setOnDoubleClickListener((HardTouchableLayout.b)new m(paramList, this, paramh));
        }
        paramList = (FinderFullSeekBarLayout)paramh.Mn(2131301839);
        if (paramList != null)
        {
          paramList.setOnPrivateLikeClickListener((kotlin.g.a.a)new n(this, paramT, paramh));
          paramList.setFinderFeed(paramT);
          label2613:
          paramList = paramh.Mn(2131301391);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          paramList = paramh.Mn(2131301674);
          if (paramList != null) {
            paramList.setVisibility(0);
          }
          paramList = paramh.Mn(2131307809);
          if (paramList != null) {
            paramList.setOnClickListener((View.OnClickListener)new q(this, paramh, paramT));
          }
          paramh.Mn(2131307809).setOnLongClickListener((View.OnLongClickListener)new r(paramh, paramT));
          localObject1 = paramT.feedObject;
          paramList = paramT.contact;
          if (paramList == null) {
            break label3860;
          }
          paramList = paramList.getUsername();
          label2732:
          d(paramh, (FinderItem)localObject1, paramList);
          a(paramT, paramh, false);
          c(paramT, paramh);
          paramList = y.vXH;
          if ((y.h(paramT)) && (paramT.showShareSns))
          {
            paramT.showShareSns = false;
            paramList = new d.a(paramh.getContext());
            paramList.aoS(2131759763);
            paramList.Dk(false);
            paramList.Dl(true);
            paramList.aoW(2131759764);
            paramList.aoV(2131759765).c((DialogInterface.OnClickListener)new f(this, paramh));
            paramList.f((DialogInterface.OnCancelListener)new g(paramh));
            paramList.hbn().show();
          }
          h(paramT, paramh);
          if (!paramT.feedObject.isPrivate()) {
            break label3866;
          }
          paramList = y.vXH;
          if (!y.h(paramT)) {
            break label3866;
          }
          paramList = paramh.Mn(2131300582);
          if (paramList != null) {
            paramList.setVisibility(0);
          }
          paramList = paramh.Mn(2131300581);
          if (paramList != null) {
            paramList.setVisibility(0);
          }
          label2940:
          j(paramT, paramh);
          paramList = (TextView)paramh.Mn(2131301821);
          kotlin.g.b.p.g(paramList, "friendFollowCountTv");
          paramList.setVisibility(8);
          if (paramT.streamDivider != null) {
            break label3926;
          }
          localObject1 = paramT.contact;
          if (localObject1 == null) {
            break label3911;
          }
          paramInt1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_friendFollowCount;
          label2997:
          if (paramInt1 <= 0) {
            break label3916;
          }
          localObject1 = paramh.getContext();
          kotlin.g.b.p.g(localObject1, "holder.context");
          paramList.setText((CharSequence)((Context)localObject1).getResources().getString(2131759796, new Object[] { Integer.valueOf(paramInt1) }));
          paramList.setVisibility(0);
          label3051:
          if (this.tAi.dbZ())
          {
            paramList = paramh.Mn(2131301821);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
            paramList = paramh.Mn(2131300557);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
          }
          i(paramh, paramT);
          paramList = paramh.Mn(2131306547);
          if (this.tAi.dbZ()) {
            break label3968;
          }
          kotlin.g.b.p.g(paramList, "readView");
          paramList.setVisibility(8);
          label3147:
          if (paramT.isShowGuideTips != 1) {
            break label4038;
          }
          localObject1 = paramh.Mn(2131302228);
          paramList = (List<Object>)localObject1;
          if (localObject1 == null) {
            paramList = ((ViewStub)paramh.Mn(2131296284)).inflate();
          }
          if (paramList != null) {
            paramList.setVisibility(0);
          }
        }
        break;
      }
    }
    for (;;)
    {
      g(paramT, paramh);
      f(paramT, paramh);
      paramList = paramh.Mn(2131310691);
      if (paramList == null) {
        break;
      }
      if (!this.tAi.dbZ()) {
        break label4077;
      }
      localObject1 = y.vXH;
      if ((!y.h(paramT)) || (paramT.feedObject.isLiveFeed())) {
        break label4077;
      }
      paramList.setOnClickListener((View.OnClickListener)new o.as(this, paramT, paramh));
      paramInt1 = au.getStatusBarHeight(paramh.getContext());
      paramh = paramList.getLayoutParams();
      if (paramh != null) {
        break label4062;
      }
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      paramList = (TextView)paramh.Mn(2131309604);
      if (paramList == null) {
        break label526;
      }
      if (!this.tAi.dbZ())
      {
        localObject1 = y.vXH;
        if (!y.w(paramT.feedObject.getFeedObject())) {}
      }
      else
      {
        paramList.setVisibility(0);
        localObject1 = paramh.Mn(2131309605);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        paramList.setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.m(paramh.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        break label526;
      }
      localObject1 = paramh.Mn(2131309605);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      paramList.setVisibility(8);
      break label526;
      label3439:
      paramList = null;
      break label544;
      label3445:
      paramBoolean = false;
      break label660;
      label3451:
      paramInt1 = 2131100620;
      break label1061;
      label3458:
      paramInt2 = 0;
      break label1141;
      label3464:
      i = 0;
      break label1192;
      label3470:
      i = 0;
      break label1222;
      label3476:
      j = i;
      break label1337;
      label3483:
      break label1406;
      label3486:
      paramList = paramh.Mn(2131306042);
      kotlin.g.b.p.g(paramList, "holder.getView<View>(R.id.position_layout)");
      paramList.setVisibility(8);
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject6);
      ((z.a)localObject4).SYB = true;
      break label1547;
      label3530:
      paramInt2 = 0;
      break label1602;
      label3536:
      paramInt2 = 0;
      break label1623;
      label3542:
      paramList = "";
      break label1706;
      label3550:
      paramInt1 = 0;
      break label1965;
      label3555:
      paramInt1 = 0;
      break label2102;
      label3560:
      if (paramList.hiG() > 2)
      {
        paramBoolean = true;
        break label2213;
      }
      paramBoolean = false;
      break label2213;
      label3583:
      paramList = new kotlin.o(Boolean.TRUE, new SpannableString((CharSequence)localObject3));
      break label2239;
      label3610:
      paramInt1 = 0;
      break label2264;
      label3615:
      if (localObject2 != null) {
        ((NeatTextView)localObject2).setOnClickListener((View.OnClickListener)new ae(this, paramh, paramT));
      }
      if (!((Boolean)paramList.first).booleanValue()) {
        if (localObject2 != null) {
          ((NeatTextView)localObject2).setEllipsize(null);
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          ((NeatTextView)localObject2).setVisibility(0);
        }
        paramT.feedObject.getTopicClickExtra().aWF = new WeakReference(paramh.getContext());
        if (localObject2 == null) {
          break;
        }
        ((NeatTextView)localObject2).aw((CharSequence)localObject1);
        break;
        if (localObject2 != null) {
          ((NeatTextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        }
      }
      label3729:
      paramInt1 = 0;
      break label2315;
      paramh.mf(2131297096, 0);
      break label2372;
      paramh.mf(2131297096, 0);
      break label2372;
      label3758:
      paramList.setVisibility(8);
      break label2440;
      localObject2 = (o)this;
      paramList = paramh.Mn(2131300827);
      if (paramList != null) {
        paramList.setOnClickListener((View.OnClickListener)new o((o)localObject2, paramh));
      }
      localObject1 = paramh.aus;
      paramList = (List<Object>)localObject1;
      if (!(localObject1 instanceof HardTouchableLayout)) {
        paramList = null;
      }
      paramList = (HardTouchableLayout)paramList;
      if (paramList == null) {
        break label2613;
      }
      paramList.setOnSingleClickListener((HardTouchableLayout.g)new p((o)localObject2, paramh));
      break label2613;
      label3860:
      paramList = null;
      break label2732;
      label3866:
      paramList = paramh.Mn(2131300582);
      if (paramList != null) {
        paramList.setVisibility(8);
      }
      paramList = paramh.Mn(2131300581);
      if (paramList == null) {
        break label2940;
      }
      paramList.setVisibility(8);
      break label2940;
      label3911:
      paramInt1 = 0;
      break label2997;
      label3916:
      paramList.setVisibility(8);
      break label3051;
      label3926:
      localObject1 = paramT.streamDivider;
      if (localObject1 == null) {
        break label3051;
      }
      localObject1 = ((bcw)localObject1).dQx;
      if (localObject1 == null) {
        break label3051;
      }
      paramList.setVisibility(0);
      paramList.setText((CharSequence)localObject1);
      break label3051;
      label3968:
      kotlin.g.b.p.g(paramList, "readView");
      paramList.setVisibility(0);
      paramList = com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getReadCount());
      localObject1 = (TextView)paramh.Mn(2131306546);
      if (localObject1 == null) {
        break label3147;
      }
      ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      ((TextView)localObject1).setText((CharSequence)paramList);
      break label3147;
      label4038:
      paramList = paramh.Mn(2131302228);
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
    label4062:
    ((FrameLayout.LayoutParams)paramh).topMargin = paramInt1;
    paramList.setVisibility(0);
    return;
    label4077:
    paramList.setVisibility(8);
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    kotlin.g.b.p.h(paramh, "holder");
    FinderFeedLiveNoticeView localFinderFeedLiveNoticeView = (FinderFeedLiveNoticeView)paramh.Mn(2131300834);
    String str;
    if (paramFinderItem != null)
    {
      str = paramFinderItem.getUserName();
      if (str != null) {}
    }
    else
    {
      str = "";
    }
    for (;;)
    {
      if (localFinderFeedLiveNoticeView != null)
      {
        if (kotlin.g.b.p.j(paramBoolean, Boolean.FALSE)) {
          localFinderFeedLiveNoticeView.setVisibility(8);
        }
        paramBoolean = y.vXH;
        paramBoolean = paramh.getContext();
        kotlin.g.b.p.g(paramBoolean, "holder.context");
        if (!y.b(paramBoolean, paramFinderItem)) {
          break label302;
        }
        if (!(paramh.getContext() instanceof MMActivity)) {
          break label169;
        }
        paramBoolean = com.tencent.mm.ui.component.a.PRN;
        paramBoolean = paramh.getContext();
        if (paramBoolean == null) {
          throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        com.tencent.mm.ui.component.a.b((AppCompatActivity)paramBoolean).get(FinderLiveNoticePreLoadUIC.class);
      }
      label169:
      for (paramBoolean = com.tencent.mm.plugin.finder.feed.model.f.atq(str); paramBoolean != null; paramBoolean = null)
      {
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        localFinderFeedLiveNoticeView.a(paramh, paramBoolean, str, true);
        return;
      }
      if (localFinderFeedLiveNoticeView.getVisibility() == 0)
      {
        Log.i("Finder.FeedFullConvert", "notice info no cache ,request again");
        paramBoolean = com.tencent.mm.ui.component.a.PRN;
        paramh = paramh.getContext();
        if (paramh == null) {
          throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        paramBoolean = ((FinderLiveNoticePreLoadUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramh).get(FinderLiveNoticePreLoadUIC.class)).wyi;
        if (paramFinderItem != null)
        {
          paramh = paramFinderItem.getFeedObject();
          if (paramh != null)
          {
            paramh = Long.valueOf(paramh.id);
            if (paramFinderItem == null) {
              break label289;
            }
            paramFinderItem = paramFinderItem.getFeedObject();
            if (paramFinderItem == null) {
              break label289;
            }
          }
        }
        label289:
        for (paramFinderItem = paramFinderItem.objectNonceId;; paramFinderItem = null)
        {
          paramBoolean.a(paramh, paramFinderItem);
          return;
          paramh = null;
          break;
        }
      }
      localFinderFeedLiveNoticeView.setVisibility(8);
      return;
      label302:
      localFinderFeedLiveNoticeView.setVisibility(8);
      return;
    }
  }
  
  public boolean b(com.tencent.mm.view.recyclerview.h paramh, View paramView, FinderObject paramFinderObject)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramView, "view");
    kotlin.g.b.p.h(paramFinderObject, "finderObj");
    return false;
  }
  
  public final void c(com.tencent.mm.view.recyclerview.h paramh, T paramT, int paramInt)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    FinderFullSeekBarLayout localFinderFullSeekBarLayout = (FinderFullSeekBarLayout)paramh.Mn(2131301839);
    int i;
    if (localFinderFullSeekBarLayout != null)
    {
      Object localObject2 = localFinderFullSeekBarLayout.getPauseIcon().getTag();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof Integer)) {
        localObject1 = null;
      }
      localObject1 = (Integer)localObject1;
      if (localObject1 == null) {
        break label201;
      }
      i = ((Integer)localObject1).intValue();
      if (i != 1) {
        break label207;
      }
    }
    label201:
    label207:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FeedFullConvert", "[onUnFocusFeedCenter] tabType=" + this.dLS + " pos=" + paramInt + " isInSeekMode=" + localFinderFullSeekBarLayout.wbG + " isPlaying=" + bool + " id=" + com.tencent.mm.ac.d.zs(paramT.lT()));
      if ((localFinderFullSeekBarLayout.wbG) && (bool)) {
        localFinderFullSeekBarLayout.awG("onUnFocusFeedCenter");
      }
      paramh = paramh.Mn(2131301471);
      if (paramh != null) {
        paramh.setVisibility(8);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void e(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramT, "item");
    kotlin.g.b.p.h(paramh, "holder");
    Log.i("Finder.FeedFullConvert", "[onPostFinished] feed=" + com.tencent.mm.ac.d.zs(paramT.lT()));
    g(paramh);
    Object localObject = (FinderFullSeekBarLayout)paramh.Mn(2131301839);
    boolean bool;
    if (localObject != null)
    {
      bool = ((FinderFullSeekBarLayout)localObject).wbG;
      localObject = paramh.Mn(2131301391);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = paramh.Mn(2131301391);
      if (localObject != null) {
        ((View)localObject).setTag(2131301467, Boolean.FALSE);
      }
      if (bool) {
        break label157;
      }
      localObject = paramh.Mn(2131301674);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      label140:
      localObject = y.vXH;
      if (!y.dCF()) {
        break label206;
      }
    }
    label157:
    label206:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject = paramh.Mn(2131301674);
        if (localObject != null) {
          ((View)localObject).setTag(2131301467, Boolean.TRUE);
        }
        localObject = paramh.Mn(2131301674);
        if (localObject == null) {
          break label140;
        }
        ((View)localObject).setVisibility(8);
        break label140;
        localObject = y.vXH;
      } while (y.i(paramT.contact));
      paramT = com.tencent.mm.plugin.finder.storage.c.vCb;
    } while (com.tencent.mm.plugin.finder.storage.c.dsS() >= 6);
    paramT = new z.f();
    paramT.SYG = paramh.Mn(2131301471);
    if ((View)paramT.SYG == null) {
      paramT.SYG = ((ViewStub)paramh.Mn(2131301472)).inflate();
    }
    paramh = (View)paramT.SYG;
    kotlin.g.b.p.g(paramh, "tips");
    paramh.setVisibility(0);
    paramh = (View)paramT.SYG;
    kotlin.g.b.p.g(paramh, "tips");
    paramh.setAlpha(0.0F);
    ((View)paramT.SYG).animate().setDuration(300L).alpha(1.0F).start();
    ((View)paramT.SYG).postDelayed((Runnable)new z(paramT), 5000L);
  }
  
  public final void e(com.tencent.mm.view.recyclerview.h paramh, final T paramT)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    if (this.tAi.dbZ()) {}
    while (paramT.isDeepEnjoy) {
      return;
    }
    paramT.isDeepEnjoy = true;
    Object localObject1 = paramT.contact;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_liveStatus;
      localObject2 = new StringBuilder("[checkShowFollowLikeLayout] tabType=").append(this.dLS).append(" liveStatus=").append(i).append(" id=").append(com.tencent.mm.ac.d.zs(paramT.lT())).append(" nickname=");
      localObject1 = paramT.contact;
      if (localObject1 == null) {
        break label476;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname();
      label125:
      Log.i("Finder.FeedFullConvert", (String)localObject1);
      if (i != 1)
      {
        localObject1 = paramh.Mn(2131303243);
        kotlin.g.b.p.g(localObject1, "followTv");
        if (((View)localObject1).getVisibility() != 0)
        {
          localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
          if ((!com.tencent.mm.plugin.finder.api.c.a.asJ(paramT.feedObject.field_username)) && (this.dLS != 3))
          {
            ((View)localObject1).setVisibility(0);
            ((View)localObject1).setAlpha(0.0F);
            ((View)localObject1).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(paramh, paramT)).start();
            f(paramT, paramh);
          }
        }
      }
      f(paramh, paramT);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dwy().value()).intValue() != 1) {
        break label482;
      }
      i = 1;
      label276:
      if (i != 0)
      {
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
        if (localObject1 == null) {
          break label487;
        }
        i = ((FinderReporterUIC)localObject1).tCE;
        label317:
        localObject1 = paramh.getRecyclerView();
        kotlin.g.b.p.g(localObject1, "holder.recyclerView");
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 == null) {
          break label492;
        }
      }
    }
    label476:
    label482:
    label487:
    label492:
    for (int j = ((RecyclerView.a)localObject1).getItemCount();; j = 0)
    {
      if ((paramh.lR() + 1 < j) && ((i == 38) || (i == 25)))
      {
        localObject1 = paramh.getRecyclerView();
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramh.lR() + 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      f(paramT, paramh);
      return;
      i = 2;
      break;
      localObject1 = null;
      break label125;
      i = 0;
      break label276;
      i = 0;
      break label317;
    }
  }
  
  public void g(final T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramT, "item");
    kotlin.g.b.p.h(paramh, "holder");
    View localView = paramh.Mn(2131301346);
    com.tencent.mm.plugin.finder.api.g localg = paramT.contact;
    int i;
    if (localg != null)
    {
      i = localg.field_liveStatus;
      if (i != 1) {
        break label105;
      }
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new ah(paramh, paramT));
      }
      paramT = (TextView)paramh.Mn(2131303243);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
    }
    label105:
    while (localView == null)
    {
      return;
      i = 2;
      break;
    }
    localView.setVisibility(8);
  }
  
  public abstract void g(com.tencent.mm.view.recyclerview.h paramh, T paramT);
  
  public final int getDisplayHeight()
  {
    return ((Number)this.tBE.getValue()).intValue();
  }
  
  public void h(com.tencent.mm.view.recyclerview.h paramh, T paramT)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    int i;
    int j;
    if (localFinderMediaBanner != null)
    {
      if ((localFinderMediaBanner.getContext() instanceof Activity))
      {
        paramh = localFinderMediaBanner.getContext();
        if (paramh == null) {
          throw new t("null cannot be cast to non-null type android.app.Activity");
        }
      }
      int k;
      for (paramh = ((Activity)paramh).getBaseContext();; paramh = localFinderMediaBanner.getContext())
      {
        kotlin.g.b.p.g(paramh, "baseContext");
        paramh = paramh.getResources();
        kotlin.g.b.p.g(paramh, "baseContext.resources");
        i = paramh.getDisplayMetrics().widthPixels;
        j = getDisplayHeight();
        paramh = y.vXH;
        float f1 = y.eA((List)paramT.feedObject.getMediaList());
        paramh = y.vXH;
        if (!y.bl(f1)) {
          break label293;
        }
        paramh = localFinderMediaBanner.getContext();
        kotlin.g.b.p.g(paramh, "context");
        k = (int)paramh.getResources().getDimension(2131165278);
        float f2 = i;
        localFinderMediaBanner.getPagerView().getLayoutParams().width = i;
        localFinderMediaBanner.getPagerView().getLayoutParams().height = kotlin.h.a.cR(f1 * i);
        if (f2 * f1 > j - k * 2) {
          break label261;
        }
        paramh = localFinderMediaBanner.getLayoutParams();
        if (paramh != null) {
          break;
        }
        throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)paramh).topMargin = (-k / 2);
    }
    for (;;)
    {
      localFinderMediaBanner.requestLayout();
      return;
      label261:
      paramh = localFinderMediaBanner.getLayoutParams();
      if (paramh == null) {
        throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)paramh).topMargin = 0;
      continue;
      label293:
      localFinderMediaBanner.getPagerView().getLayoutParams().width = i;
      localFinderMediaBanner.getPagerView().getLayoutParams().height = j;
      paramh = localFinderMediaBanner.getLayoutParams();
      if (paramh == null) {
        throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)paramh).topMargin = 0;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$Companion;", "", "()V", "MENU_ID_ONLY_POSTER_CAN_SEE", "", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class aa
    implements Runnable
  {
    aa(o paramo, View paramView, com.tencent.mm.view.recyclerview.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242920);
      int i = this.tAL.getHeight();
      int j = KeyBoardUtil.getKeyBordHeightPx(this.qhp.getContext()) - this.tAM + i;
      Log.i("Finder.FeedFullConvert", "[openCommentDrawer] offset=" + j + " itemBottom=" + this.tAN + " recyclerViewBottom=" + o.c(this.tBP).bottom + " editLayoutHeight=" + i);
      if (j > 0)
      {
        FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = o.b(this.tBP).getVideoCore().weS;
        if (localFinderVideoAutoPlayManager != null) {
          FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, "openCommentDrawer", true);
        }
        this.qhp.getRecyclerView().smoothScrollBy(0, j);
      }
      AppMethodBeat.o(242920);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class ab
    implements CommentDrawerContract.CloseDrawerCallback
  {
    ab(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.h paramh, z.d paramd) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.s> paramList)
    {
      AppMethodBeat.i(242921);
      kotlin.g.b.p.h(paramList, "data");
      o.b(this.tBP, this.tAr, this.qhp);
      paramList = o.b(this.tBP).getVideoCore().weS;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (o.b(this.tBP).dbZ())
      {
        paramList = this.qhp.Mn(2131298937);
        kotlin.g.b.p.g(paramList, "holder.getView<TextView>(R.id.comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(1, this.tAr.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtx().value()).intValue() == 1) {
        this.qhp.getRecyclerView().smoothScrollBy(0, -this.tAO.SYE);
      }
      AppMethodBeat.o(242921);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(o paramo, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242922);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
      com.tencent.mm.plugin.finder.storage.c.KQ(2);
      o.a(this.tBP, paramh, paramT, true, ((Rect)localObject).top - com.tencent.mm.view.d.e(paramh.getContext(), 16.0F), paramInt, 24);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242922);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(o paramo, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242923);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(paramView, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)paramView).dxX())
      {
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(paramh.getContext());
        com.tencent.mm.plugin.report.service.h.CyF.a(20912, new Object[] { Integer.valueOf(3), Integer.valueOf(5), paramT.feedObject.getUserName(), paramT.feedObject.getNickName() });
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242923);
        return;
        o.a(this.tBP, paramh, paramT, false, 0, 0, 120);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(o paramo, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242924);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(paramView, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)paramView).dxX())
      {
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(paramh.getContext());
        com.tencent.mm.plugin.report.service.h.CyF.a(20912, new Object[] { Integer.valueOf(3), Integer.valueOf(5), paramT.feedObject.getUserName(), paramT.feedObject.getNickName() });
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242924);
        return;
        if (o.e(paramT)) {
          o.a(this.tBP, paramh, paramT, false, 0, 4, 56);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class af
    implements View.OnClickListener
  {
    af(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242925);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!o.b(this.tBP).dbZ())
      {
        Log.i("Finder.FeedFullConvert", "onClickFav:" + paramh.lR());
        o.a(this.tBP, paramh);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242925);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ag
    implements View.OnClickListener
  {
    ag(o paramo, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242926);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFollowState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = aj.viU;
      paramView = FinderReporterUIC.wzC;
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        aj.a(paramView, "follow", false, paramT.lT());
        paramView = com.tencent.mm.plugin.finder.api.c.tsp;
        if (!com.tencent.mm.plugin.finder.api.c.a.asJ(paramT.feedObject.field_username))
        {
          paramView = o.b(this.tBP);
          localObject = paramT;
          com.tencent.mm.plugin.finder.api.c.a locala = com.tencent.mm.plugin.finder.api.c.tsp;
          if (com.tencent.mm.plugin.finder.api.c.a.asJ(paramT.feedObject.field_username)) {
            break label186;
          }
        }
      }
      label186:
      for (boolean bool = true;; bool = false)
      {
        paramView.b((BaseFinderFeed)localObject, bool);
        o.a(this.tBP, paramh, paramT);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFollowState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242926);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242927);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshLivingIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.qhp.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      paramView = paramT.contact;
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        new com.tencent.mm.plugin.finder.view.r((Context)localObject, paramView, this.qhp.lR(), paramT.feedObject.isLiveFeed()).dzC();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshLivingIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242927);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$2$3$1", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$apply$lambda$1"})
  static final class ai
    implements View.OnClickListener
  {
    ai(View paramView, azw paramazw, o paramo, com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, String paramString) {}
    
    public final void onClick(View paramView)
    {
      int i = 0;
      AppMethodBeat.i(242928);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      long l1;
      if (this.tBo.LJO > 0)
      {
        l1 = 1L;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_topic_type", this.tBo.LJN);
        localIntent.putExtra("key_topic_title", this.tBo.riB);
        localIntent.putExtra("KEY_TOPIC_ID", this.tBo.twp);
        paramView = this.tBo.LJP;
        if (paramView != null) {
          localIntent.putExtra("KEY_HOT_TOPIC_BUFFER", paramView.zy);
        }
        localIntent.putExtra("key_hot_topic_type", this.tBo.LJN);
        paramView = paramFinderItem;
        if (paramView != null)
        {
          paramView = Long.valueOf(paramView.getId());
          localIntent.putExtra("KEY_CLICK_FEED_ID", (Serializable)paramView);
          paramView = paramFinderItem;
          if (paramView == null) {
            break label428;
          }
          paramView = Long.valueOf(paramView.getId());
          label190:
          localIntent.putExtra("key_ref_object_id", (Serializable)paramView);
          localIntent.putExtra("KEY_TAB_TYPE", jdField_this.dLS);
          localObject = paramString;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localIntent.putExtra("key_from_user", paramView);
          paramView = FinderReporterUIC.wzC;
          paramView = paramh.getContext();
          kotlin.g.b.p.g(paramView, "holder.context");
          FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
          paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
          paramView = paramh.getContext();
          kotlin.g.b.p.g(paramView, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.P(paramView, localIntent);
          label296:
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          paramView = paramFinderItem;
          if (paramView == null) {
            break label499;
          }
          paramView = paramView.getFeedObject();
          if (paramView == null) {
            break label499;
          }
        }
      }
      label428:
      label499:
      for (long l2 = paramView.id;; l2 = 0L)
      {
        long l3 = this.tBo.twp;
        localObject = this.tBo.riB;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localObject = FinderReporterUIC.wzC;
        localObject = paramh.getContext();
        kotlin.g.b.p.g(localObject, "holder.context");
        localObject = FinderReporterUIC.a.fH((Context)localObject);
        if (localObject != null) {
          i = ((FinderReporterUIC)localObject).tCE;
        }
        com.tencent.mm.plugin.finder.report.k.a(l2, 2L, l3, paramView, l1, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242928);
        return;
        paramView = null;
        break;
        paramView = null;
        break label190;
        paramView = jdField_this;
        localObject = paramh.hgv();
        kotlin.g.b.p.g(localObject, "holder.getAssociatedObject()");
        boolean bool = o.a(paramView, (BaseFinderFeed)localObject);
        Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] hot news not support jump! isShowRealNameRecommendLayout=".concat(String.valueOf(bool)));
        if (bool) {
          this.tCl.setVisibility(8);
        }
        l1 = 0L;
        break label296;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(o paramo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242930);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = o.b(this.tBP).getActivity();
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.h((Activity)paramView, ".ui.FinderHomeUI");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242930);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class al
    implements ValueAnimator.AnimatorUpdateListener
  {
    al(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242931);
      FinderPostProgressView localFinderPostProgressView = this.tAY;
      kotlin.g.b.p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(242931);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.tAY.invalidate();
      AppMethodBeat.o(242931);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class am
    implements View.OnClickListener
  {
    am(o paramo, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242932);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      o.f(paramT);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242932);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class an
    implements View.OnClickListener
  {
    an(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242933);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().t(this.tAr.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242933);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
  static final class ao
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    ao(boolean paramBoolean1, boolean paramBoolean2, o paramo, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean3, LinkedList paramLinkedList, boolean paramBoolean4, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
  static final class ap
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    ap(List paramList1, List paramList2, kotlin.g.a.a parama, o paramo, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$5"})
  static final class aq
    implements View.OnClickListener
  {
    aq(View paramView, o paramo, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242937);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = aj.viU;
      paramView = FinderReporterUIC.wzC;
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null) {}
      for (paramView = paramView.dIx();; paramView = null)
      {
        aj.a(paramView, "follow_like", false, paramT.lT());
        paramh.Mn(2131297154).callOnClick();
        this.tCp.animate().alpha(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new com.tencent.mm.plugin.finder.animation.a()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(242936);
            paramAnonymousAnimator = this.tCq.tCp;
            kotlin.g.b.p.g(paramAnonymousAnimator, "followLikeLayout");
            paramAnonymousAnimator.setVisibility(8);
            paramAnonymousAnimator = this.tCq.tCp;
            kotlin.g.b.p.g(paramAnonymousAnimator, "followLikeLayout");
            paramAnonymousAnimator.setAlpha(1.0F);
            AppMethodBeat.o(242936);
          }
        }).start();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242937);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$6"})
  static final class ar
    implements View.OnClickListener
  {
    ar(o paramo, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242938);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = paramh.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131300826);; paramView = null)
      {
        if (paramView == null) {
          kotlin.g.b.p.hyc();
        }
        paramView.a(paramT.feedObject, o.a(paramT));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242938);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends IListener<hf>
    implements View.OnAttachStateChangeListener
  {
    final com.tencent.mm.view.recyclerview.h tAm;
    final o<T> tBJ;
    
    public b(o<T> paramo, com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(242885);
      this.tBJ = paramo;
      this.tAm = paramh;
      if ((this.tAm.getContext() instanceof MMActivity))
      {
        paramo = this.tAm.getContext();
        if (paramo == null)
        {
          paramo = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(242885);
          throw paramo;
        }
        ((MMActivity)paramo).getLifecycle().addObserver((LifecycleObserver)o.a(this.tBJ));
      }
      AppMethodBeat.o(242885);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(242884);
      kotlin.g.b.p.h(paramView, "v");
      AppMethodBeat.o(242884);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(242883);
      kotlin.g.b.p.h(paramView, "v");
      AppMethodBeat.o(242883);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(o.b paramb, hf paramhf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$adjustSeekLayout$1$1"})
  static final class c
    implements Runnable
  {
    c(View paramView1, com.tencent.mm.view.recyclerview.h paramh, FinderMediaBanner paramFinderMediaBanner, View paramView2, View paramView3) {}
    
    public final void run()
    {
      AppMethodBeat.i(242886);
      Object localObject2 = new int[2];
      Object localObject1 = new int[2];
      int[] arrayOfInt = new int[2];
      paramh.aus.getLocationInWindow((int[])localObject2);
      localFinderMediaBanner.getLocationInWindow((int[])localObject1);
      localObject1[0] -= localObject2[0];
      localObject1[1] -= localObject2[1];
      localView1.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] -= localObject2[0];
      arrayOfInt[1] -= localObject2[1];
      localObject2 = localView2;
      kotlin.g.b.p.g(localObject2, "seekLayout");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(242886);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      int i = ((FrameLayout.LayoutParams)localObject2).topMargin;
      Object localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      int j = (int)((Context)localObject3).getResources().getDimension(2131165312);
      int k = localObject1[1];
      localObject3 = localFinderMediaBanner;
      kotlin.g.b.p.g(localObject3, "banner");
      if (k + ((FinderMediaBanner)localObject3).getHeight() + this.tBL.getHeight() > arrayOfInt[1]) {}
      for (((FrameLayout.LayoutParams)localObject2).topMargin = (arrayOfInt[1] - j);; ((FrameLayout.LayoutParams)localObject2).topMargin = (j + ((FinderMediaBanner)localObject1).getHeight()))
      {
        if (((FrameLayout.LayoutParams)localObject2).topMargin != i) {
          localView2.requestLayout();
        }
        AppMethodBeat.o(242886);
        return;
        j = localObject1[1];
        localObject1 = localFinderMediaBanner;
        kotlin.g.b.p.g(localObject1, "banner");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$checkShowFollowLikeLayout$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.animation.a
  {
    d(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242887);
      paramAnimator = aj.viU;
      paramAnimator = FinderReporterUIC.wzC;
      paramAnimator = this.qhp.getContext();
      kotlin.g.b.p.g(paramAnimator, "holder.context");
      paramAnimator = FinderReporterUIC.a.fH(paramAnimator);
      if (paramAnimator != null) {}
      for (paramAnimator = paramAnimator.dIx();; paramAnimator = null)
      {
        aj.a(paramAnimator, "follow_like", true, paramT.lT());
        AppMethodBeat.o(242887);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$checkShowLittleFollowLayout$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.plugin.finder.animation.a
  {
    e(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242888);
      paramAnimator = aj.viU;
      paramAnimator = FinderReporterUIC.wzC;
      paramAnimator = this.qhp.getContext();
      kotlin.g.b.p.g(paramAnimator, "holder.context");
      paramAnimator = FinderReporterUIC.a.fH(paramAnimator);
      if (paramAnimator != null) {}
      for (paramAnimator = paramAnimator.dIx();; paramAnimator = null)
      {
        aj.a(paramAnimator, "follow", true, paramT.lT());
        AppMethodBeat.o(242888);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(242889);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramh.hgv();
      long l;
      if (!localBaseFinderFeed.feedObject.isPostFinish())
      {
        l = 0L;
        String str = com.tencent.mm.ac.d.zs(l);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
        paramDialogInterface = FinderReporterUIC.wzC;
        paramDialogInterface = paramh.getContext();
        kotlin.g.b.p.g(paramDialogInterface, "holder.context");
        paramDialogInterface = FinderReporterUIC.a.fH(paramDialogInterface);
        if (paramDialogInterface == null) {
          break label209;
        }
        paramDialogInterface = paramDialogInterface.sGQ;
        label73:
        localh.a(21180, new Object[] { paramDialogInterface, str, Integer.valueOf(1), com.tencent.mm.plugin.sns.data.r.eZx() });
        paramDialogInterface = o.b(this.tBP).getActivity();
        if (paramDialogInterface == null) {
          break label214;
        }
        paramDialogInterface = paramDialogInterface.getIntent();
        if ((paramDialogInterface == null) || (paramDialogInterface.getBooleanExtra("key_form_sns", false) != true)) {
          break label214;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.utils.s.vWt;
        paramDialogInterface = o.b(this.tBP).getActivity();
        if (paramDialogInterface == null) {
          kotlin.g.b.p.hyc();
        }
        paramDialogInterface = (AppCompatActivity)paramDialogInterface;
        kotlin.g.b.p.g(localBaseFinderFeed, "currItem");
        s.a.a(paramDialogInterface, localBaseFinderFeed, 5, paramInt, 4);
        AppMethodBeat.o(242889);
        return;
        l = localBaseFinderFeed.feedObject.getId();
        break;
        label209:
        paramDialogInterface = null;
        break label73;
        label214:
        paramDialogInterface = o.b(this.tBP).getActivity();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getIntent();
          if (paramDialogInterface != null)
          {
            if (paramDialogInterface.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) != true) {
              break label261;
            }
            paramInt = 2;
            continue;
          }
        }
        paramInt = 0;
        continue;
        label261:
        paramInt = 0;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class g
    implements DialogInterface.OnCancelListener
  {
    g(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(242890);
      paramDialogInterface = (BaseFinderFeed)this.qhp.hgv();
      long l;
      String str;
      com.tencent.mm.plugin.report.service.h localh;
      if (!paramDialogInterface.feedObject.isPostFinish())
      {
        l = 0L;
        str = com.tencent.mm.ac.d.zs(l);
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        paramDialogInterface = FinderReporterUIC.wzC;
        paramDialogInterface = this.qhp.getContext();
        kotlin.g.b.p.g(paramDialogInterface, "holder.context");
        paramDialogInterface = FinderReporterUIC.a.fH(paramDialogInterface);
        if (paramDialogInterface == null) {
          break label122;
        }
      }
      label122:
      for (paramDialogInterface = paramDialogInterface.sGQ;; paramDialogInterface = null)
      {
        localh.a(21180, new Object[] { paramDialogInterface, str, Integer.valueOf(0), com.tencent.mm.plugin.sns.data.r.eZx() });
        AppMethodBeat.o(242890);
        return;
        l = paramDialogInterface.feedObject.getId();
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    i(o paramo)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "txt", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$1$1"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    j(o paramo, SpannableString paramSpannableString, SpannableStringBuilder paramSpannableStringBuilder, com.tencent.mm.view.recyclerview.h paramh, NeatTextView paramNeatTextView, float paramFloat, int paramInt1, BaseFinderFeed paramBaseFinderFeed, int paramInt2, int paramInt3, int paramInt4, int paramInt5, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "txt", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$2$1"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    k(String paramString, o paramo, SpannableStringBuilder paramSpannableStringBuilder, NeatTextView paramNeatTextView, float paramFloat, int paramInt1, z.a parama, com.tencent.mm.view.recyclerview.h paramh, int paramInt2, int paramInt3, int paramInt4, BaseFinderFeed paramBaseFinderFeed, int paramInt5)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$4$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class m
    implements HardTouchableLayout.b
  {
    m(HardTouchableLayout paramHardTouchableLayout, o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242898);
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramMotionEvent, "e");
      Log.i("Finder.FeedFullConvert", "onDoubleClick " + (BaseFinderFeed)paramh.hgv());
      jdField_this.a(paramh, (View)this.tAC, paramMotionEvent);
      AppMethodBeat.o(242898);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$5$1"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    n(o paramo, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$6$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$let$lambda$1"})
  static final class o
    implements View.OnClickListener
  {
    o(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242900);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tCd;
      com.tencent.mm.view.recyclerview.h localh = paramh;
      kotlin.g.b.p.g(paramView, "it");
      ((o)localObject).b(localh, paramView, ((BaseFinderFeed)paramh.hgv()).feedObject.getFeedObject());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242900);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$6$2$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$let$lambda$2"})
  public static final class p
    implements HardTouchableLayout.g
  {
    p(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242901);
      kotlin.g.b.p.h(paramView, "view");
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(242901);
        return;
      }
      Rect localRect = new Rect();
      View localView = paramh.Mn(2131300827);
      if (localView != null) {
        localView.getGlobalVisibleRect(localRect);
      }
      if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        this.tCd.b(paramh, paramView, ((BaseFinderFeed)paramh.hgv()).feedObject.getFeedObject());
      }
      AppMethodBeat.o(242901);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(o paramo, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242903);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 0, false);
      paramView.a(o.b(this.tBP).a(paramT, paramView));
      paramView.b(o.b(this.tBP).i(paramT));
      paramView.a(o.b(this.tBP).j(paramT));
      paramView.b(o.b(this.tBP).j(paramT));
      paramView.b((e.b)new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(242902);
          Object localObject = FinderReporterUIC.wzC;
          localObject = this.tCe.qhp.getContext();
          kotlin.g.b.p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.fH((Context)localObject);
          if (localObject != null) {}
          for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
          {
            BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.tCe.qhp.hgv();
            com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", (bbn)localObject, 0L, null, 96);
            AppMethodBeat.o(242902);
            return;
          }
        }
      });
      paramView.dGm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242903);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class r
    implements View.OnLongClickListener
  {
    r(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242904);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = (FinderVideoLayout)this.qhp.Mn(2131300776);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.uPf;; paramView = null)
      {
        localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = this.qhp.getContext();
        if (localObject != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(242904);
        throw paramView;
      }
      localObject = (FinderDebugUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject).get(FinderDebugUIC.class);
      Context localContext = this.qhp.getContext();
      kotlin.g.b.p.g(localContext, "holder.context");
      ((FinderDebugUIC)localObject).a(localContext, paramT, paramView, this.qhp);
      this.qhp.getRecyclerView().requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(242904);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class t
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242906);
      kotlin.g.b.p.g(paramMotionEvent, "event");
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.removeCallbacks(this.tCf);
      }
      AppMethodBeat.o(242906);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242907);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Log.i("Finder.FeedFullConvert", "onClickLike:" + paramh.lR());
      if (!o.b(this.tBP).dbZ())
      {
        o.a(this.tBP, paramh, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242907);
        return;
      }
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramh.hgv();
      localObject = paramh.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131300823);; paramView = null)
      {
        if (paramView == null) {
          kotlin.g.b.p.hyc();
        }
        paramView.a(localBaseFinderFeed.feedObject, null);
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class v
    implements View.OnLongClickListener
  {
    v(o paramo, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242910);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (!o.b(this.tBP).dbZ())
      {
        paramView = (BaseFinderFeed)paramh.hgv();
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dtQ().value()).intValue() == 1)
        {
          localObject = y.vXH;
          if (!y.i(paramView.contact))
          {
            Log.i("Finder.FeedFullConvert", "onLongClick Private Like:" + paramh.lR());
            paramView = (ImageView)paramh.Mn(2131302492);
            kotlin.g.b.p.g(paramView, "awesomeIv");
            if (((paramView.getTag() instanceof Integer)) && (kotlin.g.b.p.j(paramView.getTag(), Integer.valueOf(0))))
            {
              paramView = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 1, true);
              paramView.setTitleView(aa.jQ(paramh.getContext()).inflate(2131494583, null));
              paramView.a((com.tencent.mm.ui.base.o.f)new com.tencent.mm.ui.base.o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
                {
                  AppMethodBeat.i(242908);
                  kotlin.g.b.p.g(paramAnonymousm, "it");
                  if (paramAnonymousm.gKQ())
                  {
                    Context localContext = this.tCg.qhp.getContext();
                    kotlin.g.b.p.g(localContext, "holder.context");
                    paramAnonymousm.d(10003, (CharSequence)localContext.getResources().getString(2131760445));
                  }
                  AppMethodBeat.o(242908);
                }
              });
              paramView.a((com.tencent.mm.ui.base.o.g)new com.tencent.mm.ui.base.o.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(242909);
                  kotlin.g.b.p.g(paramAnonymousMenuItem, "menuItem");
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(242909);
                    return;
                    o.a(this.tCg.tBP, this.tCg.qhp, true);
                  }
                }
              });
              paramView.dGm();
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(242910);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$6", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"})
  public static final class x
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private final MMHandler hAk;
    private long tCi;
    
    x(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(242917);
      this.hAk = new MMHandler(Looper.getMainLooper());
      AppMethodBeat.o(242917);
    }
    
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(242914);
      kotlin.g.b.p.h(paramb, "ev");
      Object localObject1;
      Object localObject2;
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) && (((com.tencent.mm.plugin.finder.event.c.a)paramb).type == 2))
      {
        if (((BaseFinderFeed)paramh.hgv()).lT() == ((com.tencent.mm.plugin.finder.event.c.a)paramb).feedId)
        {
          paramb = this.tBP;
          localObject1 = paramh;
          localObject2 = paramh.hgv();
          kotlin.g.b.p.g(localObject2, "holder.getAssociatedObject()");
          localObject2 = (BaseFinderFeed)localObject2;
          paramh.lR();
          paramb.e((com.tencent.mm.view.recyclerview.h)localObject1, (BaseFinderFeed)localObject2);
          AppMethodBeat.o(242914);
        }
      }
      else if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6))
      {
        if ((((BaseFinderFeed)paramh.hgv()).lT() == this.tCi) && (this.tCi != ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC))
        {
          localObject1 = this.tBP;
          localObject2 = paramh;
          Object localObject3 = paramh.hgv();
          kotlin.g.b.p.g(localObject3, "holder.getAssociatedObject()");
          ((o)localObject1).c((com.tencent.mm.view.recyclerview.h)localObject2, (BaseFinderFeed)localObject3, paramh.lR());
        }
        this.tCi = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIF;
        if (localObject1 != null)
        {
          if (((FeedData)localObject1).getMediaType() == 2)
          {
            this.hAk.removeCallbacksAndMessages(null);
            this.hAk.postDelayed((Runnable)new a(this, paramb), 10000L);
            AppMethodBeat.o(242914);
          }
        }
        else {
          AppMethodBeat.o(242914);
        }
      }
      else if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 10) && (((BaseFinderFeed)paramh.hgv()).lT() == ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC))
      {
        paramb = this.tBP;
        localObject1 = paramh;
        localObject2 = paramh.hgv();
        kotlin.g.b.p.g(localObject2, "holder.getAssociatedObject()");
        paramb.c((com.tencent.mm.view.recyclerview.h)localObject1, (BaseFinderFeed)localObject2, paramh.lR());
      }
      AppMethodBeat.o(242914);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(242916);
      kotlin.g.b.p.h(paramc, "dispatcher");
      kotlin.g.b.p.h(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) || ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)))
      {
        AppMethodBeat.o(242916);
        return true;
      }
      AppMethodBeat.o(242916);
      return false;
    }
    
    public final boolean cZD()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(242915);
      super.onRelease();
      this.hAk.removeCallbacksAndMessages(null);
      AppMethodBeat.o(242915);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class a
      implements Runnable
    {
      a(o.x paramx, com.tencent.mm.plugin.finder.event.base.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(242913);
        if (((BaseFinderFeed)this.tCj.qhp.hgv()).lT() == ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC)
        {
          o localo = this.tCj.tBP;
          com.tencent.mm.view.recyclerview.h localh = this.tCj.qhp;
          Object localObject = this.tCj.qhp.hgv();
          kotlin.g.b.p.g(localObject, "holder.getAssociatedObject()");
          localObject = (BaseFinderFeed)localObject;
          this.tCj.qhp.lR();
          localo.e(localh, (BaseFinderFeed)localObject);
        }
        AppMethodBeat.o(242913);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242918);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$onAvatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = (BaseFinderFeed)this.qhp.hgv();
      paramView = FinderReporterUIC.wzC;
      paramView = this.qhp.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      int i;
      Intent localIntent;
      long l3;
      String str;
      label210:
      long l4;
      Object localObject2;
      long l1;
      label238:
      awe localawe;
      if (paramView != null)
      {
        i = paramView.tCE;
        localIntent = new Intent();
        localIntent.putExtra("finder_username", ((BaseFinderFeed)localObject1).feedObject.getUserName());
        localIntent.putExtra("finder_read_feed_id", ((BaseFinderFeed)localObject1).feedObject.getId());
        paramView = FinderReporterUIC.wzC;
        paramView = this.qhp.getContext();
        kotlin.g.b.p.g(paramView, "holder.context");
        FinderReporterUIC.a.a(paramView, localIntent, ((BaseFinderFeed)localObject1).lT(), 1, false, 64);
        paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
        kotlin.g.b.p.g(localObject1, "item");
        l3 = this.qhp.lR();
        str = String.valueOf(i);
        kotlin.g.b.p.h(localObject1, "feed");
        kotlin.g.b.p.h(str, "commentscene");
        if (((BaseFinderFeed)localObject1).cxn() != 9) {
          break label368;
        }
        paramView = s.p.voD;
        l4 = ((BaseFinderFeed)localObject1).lT();
        localObject2 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
        if (localObject2 == null) {
          break label375;
        }
        l1 = ((awe)localObject2).liveId;
        localObject2 = ((BaseFinderFeed)localObject1).feedObject.getUserName();
        localawe = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
        if (localawe == null) {
          break label380;
        }
      }
      label368:
      label375:
      label380:
      for (long l2 = localawe.uBn;; l2 = -1L)
      {
        com.tencent.mm.plugin.finder.report.live.k.b(new com.tencent.mm.plugin.finder.report.live.p(l4, l1, (String)localObject2, l3, l2, paramView, str));
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.qhp.getContext();
        kotlin.g.b.p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
        if (!(this.qhp.getContext() instanceof MMActivity)) {
          break label428;
        }
        paramView = com.tencent.mm.ui.component.a.PRN;
        paramView = this.qhp.getContext();
        if (paramView != null) {
          break label388;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(242918);
        throw paramView;
        i = 0;
        break;
        paramView = s.p.voE;
        break label210;
        l1 = 0L;
        break label238;
      }
      label388:
      paramView = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramView).get(FinderReporterUIC.class));
      if (paramView != null) {
        paramView.cZR().Eq(((BaseFinderFeed)localObject1).lT());
      }
      label428:
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(3, ((BaseFinderFeed)localObject1).lT(), i, 1, ((BaseFinderFeed)localObject1).feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$onAvatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242918);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class z
    implements Runnable
  {
    z(z.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(242919);
      View localView = (View)this.tBq.SYG;
      kotlin.g.b.p.g(localView, "tips");
      localView.setVisibility(8);
      AppMethodBeat.o(242919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */