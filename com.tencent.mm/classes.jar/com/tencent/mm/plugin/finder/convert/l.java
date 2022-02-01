package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.Size;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.upload.action.j.a;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
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
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.g;
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
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.cjl;>;
import java.util.List<Ljava.lang.Object;>;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "FINDER_FOLLOW_PAT_ENTRANCE_VALUE", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "MENU_ID_UNFOLLOW", "avatarRectControl", "feedHeadBarStyle", "getFeedHeadBarStyle", "()I", "setFeedHeadBarStyle", "(I)V", "hideSelfTipsRunnable", "Ljava/lang/Runnable;", "isRealNameLike", "onAvatarClickListener", "Landroid/view/View$OnClickListener;", "getOnAvatarClickListener", "()Landroid/view/View$OnClickListener;", "setOnAvatarClickListener", "(Landroid/view/View$OnClickListener;)V", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateOpArea", "item", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "canFetchSimilarFeeds", "context", "Landroid/content/Context;", "checkHideLikeTips", "tipsView", "Landroid/view/View;", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkShowShareSnsLayout", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "fetchSimilarFeeds", "enable", "enableOnClick", "fromFav", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ZZZ)V", "formatDesc", "incCount", "suffix", "descTv", "Landroid/widget/TextView;", "preCount", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "handleLinkTvOnClick", "link", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "handlePoiOnClick", "poiText", "hideOrDimissMoreBtn", "ifShow", "hideSelfFeedLikeTips", "jumpFoldedUI", "feedList", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "jumpRelatedUI", "title", "lastBuffer", "needRefresh", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "likeAvatorAnimator", "likeCount", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "likeLocalFeed", "isPrivate", "onBindFinish", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onPostFinished", "onViewRecycled", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshBgmTag", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshExposeLayout", "refreshFavIv", "isFav", "favCount", "refreshFeedHeaderBar", "refreshFinderLiveNoticeView", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFoldedLayout", "refreshFollowState", "refreshHeaderFooterWording", "refreshImgBgmTag", "refreshLiveIcon", "refreshLocalAwesomeIv", "refreshOpLayout", "refreshPrivateIcon", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshSimilarEntrance", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setGroupLikeIcon", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "setNewsTitle", "topicName", "setNicknameCalculateWidth", "shareFeed", "showActivityInfo", "nickName", "showNewsIndicator", "userName", "showOrDimissSelfFeedLikeTips", "isBind", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "showPrivateFeedLikeTips", "isPrivateClick", "showSelfFeedLikeTips", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class l<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.e<T>
{
  public static final a tAk = new a((byte)0);
  final int dLS;
  private Rect rect;
  private int tAa;
  private final HashSet<b<T>> tAb;
  public View.OnClickListener tAc;
  private Runnable tAd;
  private final FinderFeedConvert.uiLifecycleObserver.1 tAe;
  private final boolean tAf;
  private final boolean tAg;
  private final int tAh;
  private final i tAi;
  protected boolean tAj;
  Dialog tipDialog;
  private final int tzW;
  private final int tzX;
  private final int tzY;
  private final int tzZ;
  
  public l(i parami, boolean paramBoolean, int paramInt)
  {
    this.tAi = parami;
    this.tAj = paramBoolean;
    this.dLS = paramInt;
    this.tzW = 10000;
    this.tzX = 10001;
    this.tzY = 10002;
    this.tzZ = 10003;
    parami = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.tAa = ((Number)com.tencent.mm.plugin.finder.storage.c.dtV().value()).intValue();
    this.tAb = new HashSet();
    this.tAe = new FinderFeedConvert.uiLifecycleObserver.1(this);
    parami = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsp().value()).intValue() == 1)
    {
      paramBoolean = true;
      this.tAf = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsq().value()).intValue() != 1) {
        break label192;
      }
    }
    label192:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.tAg = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.c.vCb;
      this.tAh = ((Number)com.tencent.mm.plugin.finder.storage.c.dvx().value()).intValue();
      this.rect = new Rect();
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, BaseFinderFeed paramBaseFinderFeed)
  {
    y localy = y.vXH;
    if (y.i(paramBaseFinderFeed.contact)) {
      if (!paramBoolean1) {}
    }
    do
    {
      return 2131690239;
      return 2131690283;
      if (!paramBoolean1) {
        break;
      }
    } while (paramBoolean2);
    return 2131690436;
    return 2131690453;
  }
  
  private static void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.h paramh, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt2 + ')';
    paramString = new StringBuilder(paramString);
    paramInt1 = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    paramh = paramh.getContext();
    kotlin.g.b.p.g(paramh, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.getResources().getColor(2131099818)), paramInt1, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.h paramh, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt + ')';
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    paramString = new StringBuilder(paramString);
    paramInt = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    paramh = paramh.getContext();
    kotlin.g.b.p.g(paramh, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.getResources().getColor(2131099818)), paramInt, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.h paramh)
  {
    if (this.tAi.dbZ())
    {
      paramh.mf(2131301674, 8);
      paramh.mf(2131307583, 0);
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Boolean)com.tencent.mm.plugin.finder.storage.c.dtM().value()).booleanValue()) && (paramT.feedObject.field_id % 2L == 0L))
      {
        if ((!kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, "zh_CN")) && (!kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, "zh_HK")) && (!kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, "zh_TW"))) {
          break label558;
        }
        paramT.feedObject.setReadCount(9998);
        paramT.feedObject.setForwardCount(99980000);
        paramT.feedObject.setLikeCount(120000000);
        paramT.feedObject.setCommentCount(120000000);
        paramT.feedObject.setFavCount(120000000);
      }
      for (;;)
      {
        localObject = paramh.Mn(2131307596);
        kotlin.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getReadCount()));
        localObject = paramh.Mn(2131307588);
        kotlin.g.b.p.g(localObject, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getForwardCount()));
        localObject = paramh.Mn(2131307590);
        kotlin.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_like_count_tv)");
        localObject = (TextView)localObject;
        j.a locala = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(com.tencent.mm.plugin.finder.upload.action.j.dBt().n(paramT.feedObject.getFeedObject())));
        localObject = paramh.Mn(2131307578);
        kotlin.g.b.p.g(localObject, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getCommentCount()));
        localObject = paramh.Mn(2131307582);
        kotlin.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getFavCount()));
        paramh.Mn(2131307589).setOnClickListener((View.OnClickListener)new am(paramh, paramT));
        paramh.Mn(2131307598).setOnClickListener((View.OnClickListener)new an(this, paramh));
        paramh.mf(2131298951, 0);
        paramh.mf(2131309604, 0);
        paramh.e(2131309604, (CharSequence)com.tencent.mm.plugin.finder.utils.k.f(paramh.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        localObject = paramh.getContext();
        kotlin.g.b.p.g(localObject, "holder.context");
        float f = ((Context)localObject).getResources().getDimensionPixelSize(2131165261);
        ((TextView)paramh.Mn(2131307596)).setTextSize(0, f);
        ((TextView)paramh.Mn(2131307588)).setTextSize(0, f);
        ((TextView)paramh.Mn(2131307590)).setTextSize(0, f);
        ((TextView)paramh.Mn(2131307578)).setTextSize(0, f);
        ((TextView)paramh.Mn(2131307582)).setTextSize(0, f);
        b(paramT, paramh);
        return;
        label558:
        paramT.feedObject.setReadCount(999);
        paramT.feedObject.setForwardCount(1000);
        paramT.feedObject.setLikeCount(1000000);
        paramT.feedObject.setCommentCount(990000000);
        paramT.feedObject.setFavCount(1200000000);
      }
    }
    paramh.mf(2131301674, 0);
    paramh.mf(2131307583, 8);
    Object localObject = com.tencent.mm.plugin.finder.upload.action.c.vUa;
    boolean bool1 = com.tencent.mm.plugin.finder.upload.action.c.dBq().k(paramT.feedObject.getFeedObject());
    localObject = com.tencent.mm.plugin.finder.upload.action.c.vUa;
    a(bool1, com.tencent.mm.plugin.finder.upload.action.c.dBq().l(paramT.feedObject.getFeedObject()), paramh);
    localObject = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    localObject = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
    bool1 = ((Boolean)((kotlin.o)localObject).first).booleanValue();
    boolean bool2 = ((Boolean)((kotlin.o)localObject).second).booleanValue();
    localObject = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(paramT.feedObject.getFeedObject()), paramh);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.h paramh, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.j.dBt().p(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    final int j = com.tencent.mm.plugin.finder.upload.action.j.dBt().o(paramT.feedObject.getFeedObject());
    if ((this.tAf) && (!Util.isNullOrNil((List)localLinkedList)) && (j > 0) && (!this.tAi.dbZ()))
    {
      localObject1 = y.vXH;
      if (!y.i(paramT.contact)) {}
    }
    else
    {
      Log.i("Finder.FeedConvert", "refreshRealNameRecommendLayout tabType:" + this.dLS + ", " + Util.isNullOrNil((List)localLinkedList) + ", " + j + ' ' + this.tAf);
      paramT = paramh.Mn(2131306595);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      return;
    }
    localObject1 = y.vXH;
    final boolean bool1 = y.v(paramT);
    if (this.tAg) {}
    final boolean bool2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    FrameLayout localFrameLayout;
    for (final float f = 0.2F;; f = 0.5F)
    {
      bool2 = this.tAg;
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
      if (!this.tAg) {
        break label1099;
      }
      kotlin.g.b.p.g(localObject4, "layout1");
      localObject6 = ((FrameLayout)localObject4).getLayoutParams();
      if (localObject6 != null) {
        break label387;
      }
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    label387:
    Object localObject6 = (FrameLayout.LayoutParams)localObject6;
    Object localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localObject5, "layout2");
    localObject6 = ((FrameLayout)localObject5).getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localFrameLayout, "layout3");
    localObject6 = localFrameLayout.getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(2131165310));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject6);
    kotlin.g.b.p.g(localObject1, "layoutExtra");
    localObject6 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject6 == null) {
      throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    localObject7 = paramh.getContext();
    kotlin.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165300));
    ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject6 = ((List)localObject2).iterator();
    if (((Iterator)localObject6).hasNext())
    {
      localObject7 = (ImageView)((Iterator)localObject6).next();
      if (localObject7 != null) {}
      for (localObject1 = ((ImageView)localObject7).getLayoutParams();; localObject1 = null)
      {
        Context localContext;
        if (localObject1 != null)
        {
          localContext = paramh.getContext();
          kotlin.g.b.p.g(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).width = ((int)localContext.getResources().getDimension(2131165299));
        }
        if (localObject1 != null)
        {
          localContext = paramh.getContext();
          kotlin.g.b.p.g(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).height = ((int)localContext.getResources().getDimension(2131165299));
        }
        if (localObject7 == null) {
          break;
        }
        ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    localObject6 = paramh.Mn(2131301776);
    if (localObject6 != null)
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      label1015:
      if (localObject1 != null)
      {
        localObject7 = paramh.getContext();
        kotlin.g.b.p.g(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).width = ((int)((Context)localObject7).getResources().getDimension(2131165299));
      }
      if (localObject1 != null)
      {
        localObject7 = paramh.getContext();
        kotlin.g.b.p.g(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).height = ((int)((Context)localObject7).getResources().getDimension(2131165299));
      }
      if (localObject6 != null) {
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label1099:
      ((List)localObject3).add(localObject4);
      ((List)localObject3).add(localObject5);
      ((List)localObject3).add(localFrameLayout);
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297354);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297355);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131297356);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = (RoundLinearLayout)paramh.Mn(2131301777);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = new z.a();
      localObject4 = new z.a();
      localObject5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      localObject5 = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
      ((z.a)localObject1).SYB = ((Boolean)((kotlin.o)localObject5).first).booleanValue();
      ((z.a)localObject4).SYB = ((Boolean)((kotlin.o)localObject5).second).booleanValue();
      localObject5 = new z.f();
      ((z.f)localObject5).SYG = ((kotlin.g.a.a)new ay((z.a)localObject1, (z.a)localObject4, this, paramh, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
      ((kotlin.g.a.a)new az((List)localObject2, (List)localObject3, (z.f)localObject5, this, paramh, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1)).invoke();
      localObject4 = (TextView)paramh.Mn(2131306597);
      if (localObject4 != null)
      {
        if (!bool2) {
          break label1802;
        }
        if (localLinkedList.size() > 3) {
          break label1719;
        }
        localObject5 = paramh.getContext();
        localObject1 = y.vXH;
        localObject1 = (FinderCommentInfo)kotlin.a.j.kv((List)localLinkedList);
        if (localObject1 != null)
        {
          localObject1 = ((FinderCommentInfo)localObject1).username;
          if (localObject1 != null) {
            break label2122;
          }
        }
        localObject1 = "";
      }
    }
    label1665:
    label1719:
    label2119:
    label2122:
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
      int k = paramT.feedObject.getFeedObject().incFriendLikeCount;
      int m = j - k;
      if (j == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        if (com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramT.feedObject.getFeedObject().objectType) == null)
        {
          localObject1 = paramh.getContext().getString(2131760497);
          label1615:
          kotlin.g.b.p.g(localObject1, "if (wordingConfig == nul…里不需要文案了\n                }");
          if ((k <= 0) || (!bool1)) {
            break label1896;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          kotlin.g.b.p.g(localObject3, "descTv");
          a(k, paramh, (String)localObject2, (TextView)localObject3);
          localObject1 = paramh.Mn(2131306596);
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setOnClickListener((View.OnClickListener)new ba(this, paramh, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
          paramT = kotlin.x.SXb;
          return;
          localObject1 = null;
          break label1015;
          localObject5 = paramh.getContext();
          localObject1 = y.vXH;
          localObject1 = ((FinderCommentInfo)localLinkedList.get(2)).username;
          if (localObject1 != null) {
            break label2119;
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
          break label1615;
          label1896:
          kotlin.g.b.p.g(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1665;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramT.feedObject.getFeedObject().objectType);
          int i;
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((azu)localObject1).LJz;
            if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label2055;
              }
            }
          }
          else
          {
            localObject1 = paramh.getContext().getString(2131760496, new Object[] { String.valueOf(m + k) });
          }
          for (;;)
          {
            if ((k <= 0) || (!bool1)) {
              break label2095;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            kotlin.g.b.p.g(localObject3, "descTv");
            a(m, k, paramh, (String)localObject2, (TextView)localObject3);
            break;
            i = 0;
            break label1970;
            localObject1 = ((azu)localObject1).LJz;
            if (localObject1 != null) {
              localObject1 = n.j((String)localObject1, "$$", String.valueOf(m + k), true);
            } else {
              localObject1 = null;
            }
          }
          kotlin.g.b.p.g(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1665;
        }
      }
    }
  }
  
  private final void a(T paramT, final com.tencent.mm.view.recyclerview.h paramh, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    boolean bool2 = false;
    if (((!paramBoolean1) || (!paramBoolean2)) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject = paramh.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      if (fk((Context)localObject)) {
        u.makeText(paramh.getContext(), (CharSequence)("enable:" + paramBoolean1 + ", enableOnClick:" + paramBoolean2), 0).show();
      }
    }
    Object localObject = new StringBuilder("CgiFinderGetFeedRelList fromFav:").append(paramBoolean3).append(", ").append(paramT.doingRelReq).append(", ");
    boolean bool1;
    long l;
    String str;
    if (paramT.feedObject.getFoldedLayout() == null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", ");
      bool1 = bool2;
      if (paramT.attachFavInfo == null) {
        bool1 = true;
      }
      Log.i("Finder.FeedConvert", bool1 + ", " + this.dLS + ", " + paramBoolean1 + ", enableOnClick:" + paramBoolean2);
      if ((paramBoolean1) && (!paramT.doingRelReq) && (paramT.attachFavInfo == null))
      {
        localObject = paramh.getContext();
        kotlin.g.b.p.g(localObject, "holder.context");
        if (fk((Context)localObject))
        {
          paramT.doingRelReq = true;
          if (paramBoolean2)
          {
            paramT.attachFavInfo = new com.tencent.mm.plugin.finder.storage.k(null);
            localObject = paramT.attachFavInfo;
            if (localObject != null) {
              ((com.tencent.mm.plugin.finder.storage.k)localObject).vDG = paramBoolean3;
            }
            c(paramh, paramT);
          }
          l = paramT.feedObject.field_id;
          str = paramT.feedObject.getObjectNonceId();
          localObject = FinderReporterUIC.wzC;
          localObject = paramh.getContext();
          kotlin.g.b.p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.fH((Context)localObject);
          if (localObject == null) {
            break label410;
          }
        }
      }
    }
    label410:
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      com.tencent.mm.ac.d.b((com.tencent.mm.vending.g.c)new com.tencent.mm.plugin.finder.cgi.l(l, str, (bbn)localObject).aYI(), (kotlin.g.a.b)new f(paramT, paramBoolean3, paramh));
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.h paramh)
  {
    Object localObject2 = (WeImageView)paramh.Mn(2131302492);
    int i;
    Object localObject1;
    label89:
    int j;
    boolean bool;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        kotlin.g.b.p.g(localObject2, "awesomeIv");
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, paramBaseFinderFeed);
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131099824)));
        i = ((Number)((kotlin.o)localObject1).first).intValue();
        j = ((Number)((kotlin.o)localObject1).second).intValue();
        localObject1 = y.vXH;
        bool = y.i(paramBaseFinderFeed.contact);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label322;
        }
        a((WeImageView)localObject2, (azu)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = (TextView)paramh.Mn(2131300579);
      if (paramInt <= 0) {
        break label483;
      }
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.k.gm(2, paramInt);
      kotlin.g.b.p.g(paramBaseFinderFeed, "FinderFormatUtil.formatN…cene.SCENE_WX, likeCount)");
      kotlin.g.b.p.g(localObject1, "likeTv");
      ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed);
      return;
      kotlin.g.b.p.g(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      kotlin.g.b.p.g(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, paramBaseFinderFeed);
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131100044)));
      break label89;
      label322:
      if ((localObject1 != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {
          if (ao.isDarkMode()) {
            localObject1 = ((azu)localObject1).LJE;
          }
        }
        for (;;)
        {
          Object localObject3 = ((WeImageView)localObject2).getDrawable();
          if (localObject3 != null) {
            ((Drawable)localObject3).clearColorFilter();
          }
          ((WeImageView)localObject2).setClearColorFilter(true);
          localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
          localObject2 = (ImageView)localObject2;
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          break;
          localObject1 = ((azu)localObject1).LJF;
          continue;
          if (ao.isDarkMode()) {
            localObject1 = ((azu)localObject1).LJG;
          } else {
            localObject1 = ((azu)localObject1).LJH;
          }
        }
      }
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(j);
    }
    label483:
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
    paramBaseFinderFeed = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
    if (paramBaseFinderFeed != null)
    {
      localObject2 = (CharSequence)paramBaseFinderFeed.LJI;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        paramInt = 1;
        label532:
        if (paramInt == 0) {
          break label582;
        }
      }
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
      paramInt = 0;
      break label532;
      label582:
      paramBaseFinderFeed = paramBaseFinderFeed.LJI;
      if (paramBaseFinderFeed == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, List<? extends cjl> paramList, long paramLong)
  {
    int j = 1;
    kotlin.g.b.p.h(paramFinderMediaBanner, "banner");
    kotlin.g.b.p.h(paramList, "mediaList");
    if (kotlin.a.j.kt(paramList) == null)
    {
      Log.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject = (cjl)kotlin.a.j.ks(paramList);
    float f1 = 0.0F;
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = (List<? extends cjl>)localObject;
    label80:
    if (localIterator.hasNext())
    {
      localObject = (cjl)localIterator.next();
      Size localSize = com.tencent.mm.plugin.finder.storage.data.j.a((cjl)localObject, false);
      float f2 = 1.0F * localSize.getHeight() / localSize.getWidth();
      if (f1 >= f2) {
        break label285;
      }
      f1 = f2;
      paramList = (List<? extends cjl>)localObject;
    }
    label285:
    for (;;)
    {
      break label80;
      paramList = com.tencent.mm.plugin.finder.storage.data.j.a(paramList, false);
      localObject = y.vXH;
      localObject = paramFinderMediaBanner.getContext();
      kotlin.g.b.p.g(localObject, "banner.context");
      paramList = y.g((Context)localObject, paramList.getWidth(), paramList.getHeight());
      localObject = paramFinderMediaBanner.getPagerView().getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).width != ((Number)paramList.second).intValue()) {
        ((ViewGroup.LayoutParams)localObject).width = ((Number)paramList.second).intValue();
      }
      for (int i = 1;; i = 0)
      {
        if (((ViewGroup.LayoutParams)localObject).height != ((Number)paramList.SWY).intValue())
        {
          ((ViewGroup.LayoutParams)localObject).height = ((Number)paramList.SWY).intValue();
          i = j;
        }
        while (i != 0)
        {
          paramFinderMediaBanner.requestLayout();
          return;
        }
        break;
      }
    }
  }
  
  private static void a(WeImageView paramWeImageView, azu paramazu)
  {
    if (paramazu != null)
    {
      paramazu = paramazu.LJJ;
      localObject = (CharSequence)paramazu;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label82;
      }
      paramazu = paramWeImageView.getContext();
      localObject = paramWeImageView.getContext();
      kotlin.g.b.p.g(localObject, "imageView.context");
      paramWeImageView.setImageDrawable(ar.m(paramazu, 2131690578, ((Context)localObject).getResources().getColor(2131099824)));
      return;
      paramazu = null;
      break;
    }
    label82:
    Object localObject = paramWeImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).clearColorFilter();
    }
    paramWeImageView.setClearColorFilter(true);
    localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
    localObject = com.tencent.mm.plugin.finder.loader.m.djY();
    paramazu = new com.tencent.mm.plugin.finder.loader.p(paramazu, com.tencent.mm.plugin.finder.storage.x.vEn);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
    ((com.tencent.mm.loader.d)localObject).a(paramazu, paramWeImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
  }
  
  private static void a(com.tencent.mm.view.recyclerview.h paramh)
  {
    paramh.aus.performHapticFeedback(0, 3);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.h paramh, int paramInt, boolean paramBoolean)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramh.hgv();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((kotlin.o)localObject1).first).booleanValue();
    boolean bool3 = ((Boolean)((kotlin.o)localObject1).second).booleanValue();
    Object localObject2;
    WeImageView localWeImageView;
    Object localObject3;
    label126:
    boolean bool2;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label844;
      }
      localObject2 = paramh.Mn(2131302492);
      localWeImageView = (WeImageView)paramh.Mn(2131303181);
      if (localWeImageView != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(localBaseFinderFeed.feedObject.getFeedObject().objectType);
        if (localObject3 != null) {
          break label471;
        }
        localObject1 = "";
        if (!paramBoolean) {
          break label497;
        }
        a(localWeImageView, (azu)localObject3);
        label137:
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 0.0F, null, false, 30);
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        kotlin.g.b.p.g(localObject2, "likeIcon");
        com.tencent.mm.plugin.finder.view.animation.c.ei((View)localObject2);
      }
      if ((paramInt == 1) || (paramInt == 2) || (paramBoolean)) {
        a(paramh);
      }
      localObject1 = y.vXH;
      if (!y.i(localBaseFinderFeed.contact)) {
        break label720;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dtO() > 0) {
        a(paramh, false);
      }
      label223:
      if (!bool1) {
        break label890;
      }
      bool2 = false;
      label231:
      localObject1 = this.tAi;
      kotlin.g.b.p.g(localBaseFinderFeed, "item");
      ((i)localObject1).a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(localBaseFinderFeed.feedObject.getFeedObject()), paramh);
      localObject1 = y.vXH;
      if ((y.v(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label897;
        }
        localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
        ((FinderObject)localObject1).incFriendLikeCount += 1;
      }
      label332:
      a(this, bool1, paramh, localBaseFinderFeed);
      localObject1 = new hn();
      ((hn)localObject1).dLW.id = localBaseFinderFeed.lT();
      ((hn)localObject1).dLW.type = 4;
      localObject2 = ((hn)localObject1).dLW;
      if ((!bool1) || (!paramBoolean)) {
        break label927;
      }
      paramInt = 2;
    }
    for (;;)
    {
      ((hn.a)localObject2).dLZ = paramInt;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = FinderReporterUIC.wzC;
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
            break label942;
          }
          paramh.Eo(localBaseFinderFeed.lT());
        }
      }
      return;
      bool1 = false;
      break;
      label471:
      if (ao.isDarkMode())
      {
        localObject1 = ((azu)localObject3).LJE;
        break label126;
      }
      localObject1 = ((azu)localObject3).LJF;
      break label126;
      label497:
      localObject3 = y.vXH;
      if (y.i(localBaseFinderFeed.contact))
      {
        localObject1 = paramh.getContext();
        localObject3 = paramh.getContext();
        kotlin.g.b.p.g(localObject3, "holder.context");
        localWeImageView.setImageDrawable(ar.m((Context)localObject1, 2131690239, ((Context)localObject3).getResources().getColor(2131099824)));
        break label137;
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label673;
        }
        localObject3 = localWeImageView.getDrawable();
        if (localObject3 != null) {
          ((Drawable)localObject3).clearColorFilter();
        }
        localWeImageView.setClearColorFilter(true);
        localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
        localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((com.tencent.mm.loader.d)localObject3).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        break;
      }
      label673:
      localObject1 = paramh.getContext();
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      localWeImageView.setImageDrawable(ar.m((Context)localObject1, 2131690436, ((Context)localObject3).getResources().getColor(2131099824)));
      break label137;
      label720:
      if (paramBoolean) {
        break label223;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dux().value()).intValue() == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dux().value()).intValue() == 1)
        {
          localBaseFinderFeed.showCommentEdu = true;
          kotlin.g.b.p.g(localBaseFinderFeed, "item");
          b(paramh, localBaseFinderFeed, 1);
        }
      }
      bool2 = localBaseFinderFeed.triggerConfig.vDV;
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dud().value()).intValue() == 1) {
        bool2 = true;
      }
      kotlin.g.b.p.g(localBaseFinderFeed, "item");
      a(localBaseFinderFeed, paramh, bool2, true, false);
      break label223;
      label844:
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dux().value()).intValue() != 1) {
        break label223;
      }
      localBaseFinderFeed.showCommentEdu = false;
      kotlin.g.b.p.g(localBaseFinderFeed, "item");
      b(paramh, localBaseFinderFeed, 1);
      break label223;
      label890:
      bool2 = bool3;
      break label231;
      label897:
      if (bool3) {
        break label332;
      }
      localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
      ((FinderObject)localObject1).incFriendLikeCount -= 1;
      break label332;
      label927:
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    label942:
    paramh.Ep(localBaseFinderFeed.lT());
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.h paramh, T paramT)
  {
    Object localObject = FinderReporterUIC.wzC;
    localObject = paramh.getContext();
    kotlin.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.fH((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).tCE;
      localObject = com.tencent.mm.plugin.finder.api.c.tsp;
      bool = com.tencent.mm.plugin.finder.api.c.a.asJ(paramT.feedObject.field_username);
      if (!this.tAj) {
        break label115;
      }
      paramh.mf(2131301657, 8);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < cl.aWy() - 86400000L)) {
        break label293;
      }
      paramh.mf(2131306677, 8);
      return;
      i = 0;
      break;
      label115:
      if ((this.dLS != 3) && (bool) && (i != 1))
      {
        localObject = y.vXH;
        if (!y.h(paramT))
        {
          paramh.mf(2131301657, 0);
          localObject = (TextView)paramh.Mn(2131301657);
          kotlin.g.b.p.g(localObject, "followIv");
          Context localContext = ((TextView)localObject).getContext();
          kotlin.g.b.p.g(localContext, "followIv.context");
          ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131761616));
          ((TextView)localObject).setTextSize(0, com.tencent.mm.cb.a.aH(((TextView)localObject).getContext(), 2131165289));
          localContext = paramh.getContext();
          kotlin.g.b.p.g(localContext, "holder.context");
          ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099748));
          ((TextView)localObject).setBackgroundResource(2131232538);
          continue;
        }
      }
      if ((!bool) || (this.dLS == 3)) {
        paramh.mf(2131301657, 8);
      }
    }
    label293:
    paramh.mf(2131306677, 0);
  }
  
  private static void a(com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, Boolean paramBoolean)
  {
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
          break label298;
        }
        if (!(paramh.getContext() instanceof MMActivity)) {
          break label165;
        }
        paramBoolean = com.tencent.mm.ui.component.a.PRN;
        paramBoolean = paramh.getContext();
        if (paramBoolean == null) {
          throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        com.tencent.mm.ui.component.a.b((AppCompatActivity)paramBoolean).get(FinderLiveNoticePreLoadUIC.class);
      }
      label165:
      for (paramBoolean = f.atq(str); paramBoolean != null; paramBoolean = null)
      {
        Log.i("Finder.FeedConvert", "update live notice from cache");
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        FinderFeedLiveNoticeView.a(localFinderFeedLiveNoticeView, paramh, paramBoolean, str);
        return;
      }
      if (localFinderFeedLiveNoticeView.getVisibility() == 0)
      {
        Log.i("Finder.FeedConvert", "notice info no cache ,request again");
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
              break label285;
            }
            paramFinderItem = paramFinderItem.getFeedObject();
            if (paramFinderItem == null) {
              break label285;
            }
          }
        }
        label285:
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
      label298:
      localFinderFeedLiveNoticeView.setVisibility(8);
      return;
    }
  }
  
  private static void a(com.tencent.mm.view.recyclerview.h paramh, boolean paramBoolean)
  {
    kotlin.g.b.p.h(paramh, "holder");
    z.f localf = new z.f();
    localf.SYG = paramh.Mn(2131301408);
    if ((View)localf.SYG == null) {
      localf.SYG = ((ViewStub)paramh.Mn(2131301409)).inflate();
    }
    Object localObject = (View)localf.SYG;
    kotlin.g.b.p.g(localObject, "tips");
    if (((View)localObject).getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (TextView)((View)localf.SYG).findViewById(2131301407);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramh.getContext().getString(2131760441));
      }
      paramh = com.tencent.mm.plugin.finder.storage.c.vCb;
      com.tencent.mm.plugin.finder.storage.c.KU(com.tencent.mm.plugin.finder.storage.c.dtP() - 1);
    }
    for (;;)
    {
      paramh = (View)localf.SYG;
      kotlin.g.b.p.g(paramh, "tips");
      paramh.setVisibility(0);
      paramh = (View)localf.SYG;
      kotlin.g.b.p.g(paramh, "tips");
      paramh.setAlpha(1.0F);
      ((View)localf.SYG).animate().cancel();
      ((View)localf.SYG).animate().alpha(0.0F).setDuration(300L).setStartDelay(2000L).setListener((Animator.AnimatorListener)new bi(localf)).start();
      return;
      localObject = (TextView)((View)localf.SYG).findViewById(2131301407);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramh.getContext().getString(2131760440));
      }
      paramh = com.tencent.mm.plugin.finder.storage.c.vCb;
      com.tencent.mm.plugin.finder.storage.c.KT(com.tencent.mm.plugin.finder.storage.c.dtO() - 1);
    }
  }
  
  private final void a(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.h paramh)
  {
    WeImageView localWeImageView = (WeImageView)paramh.Mn(2131300448);
    TextView localTextView = (TextView)paramh.Mn(2131300449);
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        paramh = new kotlin.o(Integer.valueOf(2131690253), Integer.valueOf(paramh.getResources().getColor(2131099793)));
        int i = ((Number)paramh.first).intValue();
        int j = ((Number)paramh.second).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else if (localTextView != null)
    {
      if (!this.tAi.dbZ()) {
        break label210;
      }
      ao.a((Paint)localTextView.getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label203;
      }
    }
    label203:
    for (paramh = com.tencent.mm.plugin.finder.utils.k.gm(2, paramInt);; paramh = "")
    {
      localTextView.setText((CharSequence)paramh);
      return;
      paramh = paramh.getContext();
      kotlin.g.b.p.g(paramh, "holder.context");
      paramh = new kotlin.o(Integer.valueOf(2131690258), Integer.valueOf(paramh.getResources().getColor(2131099746)));
      break;
    }
    label210:
    localTextView.setText(2131759707);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramh, "holder");
    paramh = paramh.Mn(2131304863);
    if (paramBoolean)
    {
      kotlin.g.b.p.g(paramh, "moreBtn");
      paramh.setVisibility(0);
      return;
    }
    kotlin.g.b.p.g(paramh, "moreBtn");
    paramh.setVisibility(8);
  }
  
  private void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.h paramh, final T paramT, boolean paramBoolean2)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    Object localObject1 = y.vXH;
    if (y.dCF())
    {
      paramT = paramh.Mn(2131303193);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramh = paramh.Mn(2131301471);
      if (paramh != null) {
        paramh.setVisibility(8);
      }
    }
    do
    {
      return;
      localObject1 = y.vXH;
      if (!y.i(paramT.contact)) {
        break;
      }
      paramT = paramh.Mn(2131303193);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramh = paramh.Mn(2131301471);
    } while (paramh == null);
    paramh.setVisibility(8);
    return;
    localObject1 = y.vXH;
    if ((y.h(paramT)) && (paramT.showLikeTips) && (!paramT.feedObject.isPostFailed()))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dsS() < 6)
      {
        localObject1 = paramh.Mn(2131301471);
        if (localObject1 != null) {
          break label569;
        }
        localObject1 = ((ViewStub)paramh.Mn(2131301472)).inflate();
      }
    }
    label569:
    for (;;)
    {
      if (!paramT.feedObject.isPostFinish())
      {
        if (paramBoolean1)
        {
          paramT.showLikeTips = false;
          kotlin.g.b.p.g(localObject1, "tips");
          dT((View)localObject1);
        }
        for (;;)
        {
          paramh = paramh.Mn(2131303193);
          if (paramh == null) {
            break;
          }
          paramh.setVisibility(0);
          return;
          localObject2 = paramh.Mn(2131301469);
          kotlin.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.aI(paramh.getContext(), 2131759760));
          if (paramBoolean2)
          {
            kotlin.g.b.p.g(localObject1, "tips");
            if (a((View)localObject1, paramh))
            {
              paramT.showLikeTips = false;
              continue;
            }
          }
          kotlin.g.b.p.g(localObject1, "tips");
          if (((View)localObject1).getVisibility() != 0)
          {
            localObject2 = paramh.Mn(2131303193);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = this.tAd;
              if (localObject2 != null) {
                ((View)localObject1).removeCallbacks((Runnable)localObject2);
              }
              this.tAd = ((Runnable)new bj(this, paramT, (View)localObject1));
              ((View)localObject1).postDelayed(this.tAd, 5000L);
            }
          }
        }
      }
      Object localObject2 = paramh.Mn(2131303193);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if (paramBoolean1)
      {
        paramT.showLikeTips = false;
        kotlin.g.b.p.g(localObject1, "tips");
        dT((View)localObject1);
        return;
      }
      localObject2 = paramh.Mn(2131301469);
      kotlin.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.aI(paramh.getContext(), 2131759760));
      kotlin.g.b.p.g(localObject1, "tips");
      if ((!a((View)localObject1, paramh)) || (!paramBoolean2)) {
        break;
      }
      paramT.showLikeTips = false;
      return;
      paramT = paramh.Mn(2131301471);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = paramh.Mn(2131306270);
      if ((paramT == null) || (paramT.getVisibility() != 0)) {
        break;
      }
      paramh = paramh.Mn(2131303193);
      if (paramh == null) {
        break;
      }
      paramh.setVisibility(0);
      return;
    }
  }
  
  private static void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.h paramh, boolean paramBoolean2)
  {
    Object localObject2 = (BaseFinderFeed)paramh.hgv();
    Object localObject1 = (WeImageView)paramh.Mn(2131306267);
    Object localObject3;
    label105:
    int j;
    int k;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        if (localObject1 != null) {
          ((WeImageView)localObject1).setTag(Integer.valueOf(2));
        }
        localObject3 = paramh.hgv();
        kotlin.g.b.p.g(localObject3, "holder.getAssociatedObject()");
        i = a(true, paramBoolean2, (BaseFinderFeed)localObject3);
        paramh = paramh.getContext();
        kotlin.g.b.p.g(paramh, "holder.context");
        paramh = new kotlin.o(Integer.valueOf(i), Integer.valueOf(paramh.getResources().getColor(2131099824)));
        j = ((Number)paramh.first).intValue();
        k = ((Number)paramh.second).intValue();
        if (localObject1 != null)
        {
          paramh = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectType);
          if (localObject2 != null) {
            break label275;
          }
          paramh = "";
        }
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) || (!paramBoolean1)) {
        break label299;
      }
      a((WeImageView)localObject1, (azu)localObject2);
      return;
      if (localObject1 == null) {
        break;
      }
      ((WeImageView)localObject1).setTag(Integer.valueOf(1));
      break;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setTag(Integer.valueOf(0));
      }
      localObject3 = paramh.hgv();
      kotlin.g.b.p.g(localObject3, "holder.getAssociatedObject()");
      i = a(false, paramBoolean2, (BaseFinderFeed)localObject3);
      paramh = paramh.getContext();
      kotlin.g.b.p.g(paramh, "holder.context");
      paramh = new kotlin.o(Integer.valueOf(i), Integer.valueOf(paramh.getResources().getColor(2131100044)));
      break label105;
      label275:
      if (ao.isDarkMode()) {
        paramh = ((azu)localObject2).LJG;
      } else {
        paramh = ((azu)localObject2).LJH;
      }
    }
    label299:
    localObject2 = (CharSequence)paramh;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject2 = y.vXH;
      if (y.dnv()) {
        break;
      }
      localObject2 = ((WeImageView)localObject1).getDrawable();
      if (localObject2 != null) {
        ((Drawable)localObject2).clearColorFilter();
      }
      ((WeImageView)localObject1).setClearColorFilter(true);
      localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject2 = com.tencent.mm.plugin.finder.loader.m.djY();
      paramh = new com.tencent.mm.plugin.finder.loader.p(paramh, com.tencent.mm.plugin.finder.storage.x.vEn);
      localObject1 = (ImageView)localObject1;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(paramh, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
      return;
    }
    ((WeImageView)localObject1).setImageResource(j);
    ((WeImageView)localObject1).setIconColor(k);
  }
  
  private final boolean a(View paramView, com.tencent.mm.view.recyclerview.h paramh)
  {
    Object localObject = paramh.getRecyclerView();
    kotlin.g.b.p.g(localObject, "holder.recyclerView");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      if ((localObject instanceof LinearLayoutManager)) {}
      while (localObject != null) {
        if (localObject == null)
        {
          throw new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          localObject = null;
        }
        else
        {
          int j = ((LinearLayoutManager)localObject).ks();
          int k = ((LinearLayoutManager)localObject).ku();
          localObject = paramh.getRecyclerView();
          kotlin.g.b.p.g(localObject, "holder.recyclerView");
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            if (localObject == null) {
              throw new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            }
            localObject = (com.tencent.mm.view.recyclerview.g)localObject;
          }
          for (int i = paramh.lQ() - ((com.tencent.mm.view.recyclerview.g)localObject).RqM.size(); (j < k) && (i >= 0) && ((i < j) || (i > k)); i = -1)
          {
            dT(paramView);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static void b(BaseFinderFeed paramBaseFinderFeed)
  {
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getMediaList()).iterator();
    while (localIterator.hasNext())
    {
      cjl localcjl = (cjl)localIterator.next();
      if (localcjl.mediaType <= 0) {
        localcjl.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  private static void b(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    View localView = paramh.Mn(2131307596);
    kotlin.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_read_count_tv)");
    float f1 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getReadCount()));
    localView = paramh.Mn(2131307588);
    kotlin.g.b.p.g(localView, "holder.getView<TextView>…id.self_forward_count_tv)");
    float f2 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getForwardCount()));
    localView = paramh.Mn(2131307590);
    kotlin.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_like_count_tv)");
    float f3 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getLikeCount()));
    localView = paramh.Mn(2131307578);
    kotlin.g.b.p.g(localView, "holder.getView<TextView>…id.self_comment_count_tv)");
    float f4 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getCommentCount()));
    localView = paramh.Mn(2131307582);
    kotlin.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_fav_count_tv)");
    float f5 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(paramT.feedObject.getFavCount()));
    paramT = paramh.getContext();
    kotlin.g.b.p.g(paramT, "holder.context");
    float f6 = paramT.getResources().getDimensionPixelSize(2131165299);
    paramT = paramh.getContext();
    kotlin.g.b.p.g(paramT, "holder.context");
    int i = paramT.getResources().getDimensionPixelSize(2131165282);
    int j = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
    f1 = f5 + 1.0F + (f1 + 1.0F + (f2 + 1.0F) + (f3 + 1.0F) + (f4 + 1.0F)) + f6 * 5.0F + i;
    Log.d("Finder.FeedConvert", "contentWidthSum : " + f1 + " ,screenWidth : " + j);
    localView = paramh.Mn(2131307585);
    paramT = paramh.Mn(2131307584);
    kotlin.g.b.p.g(paramT, "holder.getView<LinearLay…ter_op_layout_first_line)");
    paramT = (LinearLayout)paramT;
    paramh = paramh.Mn(2131307586);
    kotlin.g.b.p.g(paramh, "holder.getView<LinearLay…er_op_layout_second_line)");
    paramh = (LinearLayout)paramh;
    if (f1 < j) {
      paramh.setVisibility(8);
    }
    for (;;)
    {
      kotlin.g.b.p.g(localView, "rightPart");
      paramh = localView.getParent();
      if (paramh != null) {
        break;
      }
      throw new t("null cannot be cast to non-null type android.widget.LinearLayout");
      paramh.setVisibility(0);
      paramT = paramh;
    }
    ((LinearLayout)paramh).removeView(localView);
    paramT.addView(localView);
  }
  
  private void b(final T paramT, final com.tencent.mm.view.recyclerview.h paramh, boolean paramBoolean)
  {
    boolean bool2 = true;
    kotlin.g.b.p.h(paramT, "item");
    kotlin.g.b.p.h(paramh, "holder");
    Object localObject1 = y.vXH;
    if (!y.h(paramT))
    {
      a(0, paramh);
      paramT = paramh.Mn(2131306272);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, paramh);
      return;
    }
    boolean bool1;
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = paramh.Mn(2131306272);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, paramh);
      d(paramT, paramh);
      localObject1 = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject1).dxX()) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = w.vXp;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        w.a((SpannableString)localObject1, bool1);
        if (paramBoolean)
        {
          localObject1 = (FinderCollapsibleTextView)paramh.Mn(2131308992);
          localObject2 = paramh.Mn(2131307089);
          ((FinderCollapsibleTextView)localObject1).a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject2, (kotlin.g.a.b)new as((FinderCollapsibleTextView)localObject1));
        }
        a(true, paramh);
        e(paramT, paramh);
        a(paramh, paramT.feedObject);
        return;
      }
    }
    localObject1 = paramh.Mn(2131306272);
    Object localObject3;
    View localView1;
    if (localObject1 == null)
    {
      localObject3 = (l)this;
      localObject2 = ((ViewStub)paramh.Mn(2131306273)).inflate();
      localView1 = ((View)localObject2).findViewById(2131297155);
      localObject1 = localObject2;
      if (localView1 != null)
      {
        localView1.setOnTouchListener((View.OnTouchListener)new ao((l)localObject3, paramh));
        localView1.setOnClickListener((View.OnClickListener)new ap((l)localObject3, paramh));
        localView1.setOnLongClickListener((View.OnLongClickListener)new aq((l)localObject3, paramh));
        localView1.setHapticFeedbackEnabled(false);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = (FinderPostProgressView)((View)localObject1).findViewById(2131306271);
      localView1 = ((View)localObject1).findViewById(2131306270);
      View localView2 = ((View)localObject1).findViewById(2131306206);
      localObject3 = (TextView)((View)localObject1).findViewById(2131306207);
      if (paramT.isPreview)
      {
        kotlin.g.b.p.g(localObject1, "container");
        ((View)localObject1).setVisibility(8);
        a(8, paramh);
        paramh.mf(2131306268, 0);
        a(false, paramh);
        if (!paramT.feedObject.isPostFailed()) {
          break label1036;
        }
        kotlin.g.b.p.g(localView2, "failedArea");
        localView2.setVisibility(0);
        kotlin.g.b.p.g(localView1, "progressArea");
        localView1.setVisibility(8);
        if (paramT.feedObject.isPostFailedCanRetry()) {
          break label920;
        }
        paramh.mf(2131306268, 8);
        label525:
        if (!paramT.feedObject.isPostNoAuth()) {
          break label932;
        }
        kotlin.g.b.p.g(localObject3, "failedTv");
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(2131760421)));
        ((TextView)localObject3).setOnClickListener((View.OnClickListener)new at(this));
        label595:
        localObject1 = paramh.Mn(2131301471);
        if (localObject1 == null) {
          break label1030;
        }
        ((View)localObject1).setVisibility(8);
        bool1 = false;
        label619:
        paramh.Mn(2131299483).setOnClickListener((View.OnClickListener)new av(this, paramT));
        localObject1 = paramh.Mn(2131299490);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        paramh.Mn(2131306266).setOnClickListener((View.OnClickListener)new aw(this, paramT));
        paramh.Mn(2131306268).setOnClickListener((View.OnClickListener)new ax(paramT));
        if (!bool1) {
          break label1306;
        }
        localObject1 = com.tencent.mm.kernel.g.af(ad.class);
        kotlin.g.b.p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad)localObject1).dxX()) {
          break label1306;
        }
      }
      for (;;)
      {
        localObject1 = w.vXp;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        w.a((SpannableString)localObject1, bool2);
        if (paramBoolean)
        {
          localObject1 = (FinderCollapsibleTextView)paramh.Mn(2131308992);
          localObject2 = paramh.Mn(2131307089);
          ((FinderCollapsibleTextView)localObject1).a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject2, (kotlin.g.a.b)new ar((FinderCollapsibleTextView)localObject1));
        }
        Log.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool1);
        a(paramh, paramT.feedObject);
        return;
        kotlin.g.b.p.g(localObject1, "container");
        ((View)localObject1).setVisibility(0);
        break;
        label920:
        paramh.mf(2131306268, 0);
        break label525;
        label932:
        if (paramT.feedObject.isEventClosed())
        {
          kotlin.g.b.p.g(localObject3, "failedTv");
          localObject1 = paramh.getContext();
          kotlin.g.b.p.g(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(2131760420));
          break label595;
        }
        kotlin.g.b.p.g(localObject3, "failedTv");
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(2131760419));
        break label595;
        label1030:
        bool1 = false;
        break label619;
        label1036:
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().Mpc >= 100))
        {
          kotlin.g.b.p.g(localView2, "failedArea");
          localView2.setVisibility(8);
          kotlin.g.b.p.g(localView1, "progressArea");
          localView1.setVisibility(8);
          ((View)localObject1).setVisibility(8);
          a(0, paramh);
          a(true, paramh);
          e(paramT, paramh);
          bool1 = true;
          break label619;
        }
        localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(this, ((Boolean)com.tencent.mm.plugin.finder.upload.action.j.dBt().Ga(paramT.feedObject.getLocalId()).first).booleanValue(), paramh, paramT);
        kotlin.g.b.p.g(localView2, "failedArea");
        localView2.setVisibility(8);
        kotlin.g.b.p.g(localView1, "progressArea");
        localView1.setVisibility(0);
        localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().Mpc });
        ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new au((FinderPostProgressView)localObject2));
        localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
        if (localObject3 != null) {
          ((ValueAnimator)localObject3).start();
        }
        paramh.setTag(localObject1);
        Log.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().Mpc);
        bool1 = false;
        break label619;
        label1306:
        bool2 = false;
      }
    }
  }
  
  private static void b(com.tencent.mm.view.recyclerview.h paramh, final T paramT)
  {
    Object localObject = paramT.contact;
    int i;
    View localView;
    label56:
    boolean bool;
    if (localObject != null)
    {
      i = ((com.tencent.mm.plugin.finder.api.g)localObject).field_liveStatus;
      localView = paramh.Mn(2131301215);
      StringBuilder localStringBuilder = new StringBuilder("refreshLiveIcon username:");
      localObject = paramT.contact;
      if (localObject == null) {
        break label202;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).getNickname();
      localObject = localStringBuilder.append((String)localObject).append(",liveStatus:").append(i).append(",onliveView is null:");
      if (localView != null) {
        break label208;
      }
      bool = true;
      label88:
      Log.i("Finder.FeedConvert", bool);
      if (i != 1) {
        break label213;
      }
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView.post((Runnable)new ak(localView));
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new al(paramh, paramT));
      }
      paramh = (TextView)paramh.Mn(2131301657);
      kotlin.g.b.p.g(paramh, "followTv");
      if (Util.isNullOrNil(paramh.getText().toString())) {
        paramh.setVisibility(8);
      }
    }
    label202:
    label208:
    label213:
    while (localView == null)
    {
      return;
      i = 2;
      break;
      localObject = null;
      break label56;
      bool = false;
      break label88;
    }
    localView.setVisibility(8);
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
        localView.setOnClickListener((View.OnClickListener)new ae(this, paramh, paramT, paramInt));
        return;
      }
    }
    kotlin.g.b.p.g(localView, "layout");
    localView.setVisibility(8);
  }
  
  private final void c(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    if (this.tAf)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      if (!Util.isNullOrNil((List)com.tencent.mm.plugin.finder.upload.action.j.dBt().p(paramT.feedObject.getFeedObject())))
      {
        paramh.mf(2131306677, 8);
        return;
      }
    }
    Object localObject = FinderReporterUIC.wzC;
    localObject = paramh.getContext();
    kotlin.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.fH((Context)localObject);
    label82:
    int j;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).tCE;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE)))) {
        break label412;
      }
      paramh.mf(2131306677, 8);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label329;
      }
      i = 1;
      label183:
      if (i != 0) {
        break label332;
      }
      j = paramT.feedObject.getFeedObject().recommendType;
      paramh.mf(2131306669, 8);
      paramh.mf(2131306677, 0);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label334;
      }
    }
    label329:
    label332:
    label334:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label339;
      }
      localObject = (TextView)paramh.Mn(2131306678);
      kotlin.g.b.p.g(localObject, "reasonTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.h(paramh.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize()));
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o());
      return;
      i = 0;
      break label82;
      i = 0;
      break label183;
      break;
    }
    label339:
    Log.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    paramh.mf(2131306677, 8);
    return;
    label412:
    paramh.mf(2131306677, 8);
  }
  
  private final void c(final com.tencent.mm.view.recyclerview.h paramh, final T paramT)
  {
    final com.tencent.mm.plugin.finder.storage.k localk = paramT.attachFavInfo;
    Object localObject1;
    label99:
    final boolean bool;
    if (localk != null)
    {
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      if (fk((Context)localObject1))
      {
        final ViewGroup localViewGroup = (ViewGroup)paramh.Mn(2131300583);
        if (localViewGroup != null)
        {
          localObject1 = localViewGroup.getLayoutParams();
          Object localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
            localObject2 = null;
          }
          localObject1 = (LinearLayout.LayoutParams)localObject2;
          if (!localk.vDG) {
            break label222;
          }
          if (localObject1 != null) {
            ((LinearLayout.LayoutParams)localObject1).gravity = 3;
          }
          localObject2 = (TextView)paramh.Mn(2131300584);
          final List localList = localk.dxB();
          if (localk.vDI != null) {
            break label236;
          }
          bool = true;
          label128:
          if (!Util.isNullOrNil(localk.getWording())) {
            break label241;
          }
          localObject1 = paramh.getContext().getString(2131759711);
          label151:
          kotlin.g.b.p.g(localObject1, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
          if (localViewGroup != null) {
            localViewGroup.setVisibility(0);
          }
          if (localViewGroup != null) {
            localViewGroup.setOnClickListener((View.OnClickListener)new bb(this, localk, paramh, localList, paramT, bool, localViewGroup));
          }
        }
      }
    }
    label222:
    label236:
    label241:
    do
    {
      return;
      localObject1 = null;
      break;
      if (localObject1 == null) {
        break label99;
      }
      ((LinearLayout.LayoutParams)localObject1).gravity = 5;
      break label99;
      bool = false;
      break label128;
      localObject1 = localk.getWording();
      break label151;
      paramh = paramh.Mn(2131300583);
      if (paramh != null) {
        paramh.setOnClickListener(null);
      }
    } while (paramh == null);
    paramh.setVisibility(8);
  }
  
  private final void c(final com.tencent.mm.view.recyclerview.h paramh, final FinderItem paramFinderItem, final String paramString)
  {
    Object localObject3 = null;
    StringBuilder localStringBuilder;
    if (paramFinderItem != null)
    {
      localObject1 = paramFinderItem.getFeedObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).hotTopics;
        if (localObject1 != null)
        {
          localObject1 = ((azx)localObject1).Gbc;
          localStringBuilder = new StringBuilder("showNewsIndicator objectType: ");
          if (paramFinderItem == null) {
            break label296;
          }
          localObject2 = paramFinderItem.getFeedObject();
          if (localObject2 == null) {
            break label296;
          }
          localObject2 = Integer.valueOf(((FinderObject)localObject2).objectType);
          label74:
          localStringBuilder = localStringBuilder.append(localObject2).append(" size:");
          if (localObject1 == null) {
            break label302;
          }
        }
      }
    }
    label296:
    label302:
    for (Object localObject2 = Integer.valueOf(((LinkedList)localObject1).size());; localObject2 = null)
    {
      Log.i("Finder.FeedConvert", localObject2);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (azw)((Iterator)localObject1).next();
        } while ((localObject2 == null) || (((azw)localObject2).LJN != 5));
      }
      if (localObject2 == null) {
        break label497;
      }
      Log.i("Finder.FeedConvert", "showNewsIndicator topic " + ((azw)localObject2).twp + ' ' + ((azw)localObject2).riB + ' ' + ((azw)localObject2).LJO);
      if (!(paramh.getContext() instanceof FinderShareFeedRelUI)) {
        break label308;
      }
      Log.i("Finder.FeedConvert", "showNewsIndicator topic ui is FinderShareFeedRelUI block");
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
      localObject2 = null;
      break label74;
    }
    label308:
    Object localObject1 = (TextView)paramh.Mn(2131300574);
    if (localObject1 != null)
    {
      if (((azw)localObject2).LJO <= 0) {
        break label547;
      }
      ((TextView)localObject1).setTextColor(((TextView)localObject1).getResources().getColor(2131099787));
    }
    for (;;)
    {
      localObject1 = paramh.Mn(2131300831);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener((View.OnClickListener)new bh((azw)localObject2, this, paramh, paramFinderItem, paramString));
      }
      paramFinderItem = (TextView)paramh.Mn(2131300574);
      if (paramFinderItem != null)
      {
        paramString = new StringBuilder();
        localObject1 = paramFinderItem.getContext();
        kotlin.g.b.p.g(localObject1, "context");
        paramString = ((Context)localObject1).getResources().getString(2131760330) + ((azw)localObject2).riB;
        paramFinderItem.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString));
      }
      paramFinderItem = (TextView)paramh.Mn(2131300573);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      if (localObject2 != null) {
        break;
      }
      label497:
      Log.i("Finder.FeedConvert", "showNewsIndicator topic null let");
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
      label547:
      ((TextView)localObject1).setTextColor(((TextView)localObject1).getResources().getColor(2131099748));
    }
  }
  
  private final void d(final T paramT, final com.tencent.mm.view.recyclerview.h paramh)
  {
    Log.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + paramh.lR());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)paramh.Mn(2131298951);
    kotlin.g.b.p.g(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((kotlin.g.a.m)new af(this, paramh, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((kotlin.g.a.m)new ag(this, paramh, paramT));
    Object localObject = paramh.aus;
    kotlin.g.b.p.g(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (kotlin.g.a.m)new ah(this, paramT));
    if (Util.isNullOrNil((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)paramh.Mn(2131307577);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      y localy = y.vXH;
      if (!y.In(paramT.feedObject.field_username)) {
        break label378;
      }
      kotlin.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ar.m(((ImageView)localObject).getContext(), 2131690454, com.tencent.mm.cb.a.n(((ImageView)localObject).getContext(), 2131100044)));
    }
    for (;;)
    {
      paramT = paramh.Mn(2131307576);
      paramT.setOnClickListener((View.OnClickListener)new ai(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      kotlin.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ar.m(((ImageView)localObject).getContext(), 2131690775, com.tencent.mm.cb.a.n(((ImageView)localObject).getContext(), 2131100044)));
    }
  }
  
  private final void dT(View paramView)
  {
    paramView.setVisibility(8);
    Runnable localRunnable = this.tAd;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      this.tAd = null;
    }
  }
  
  private static void e(T paramT, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramT, "item");
    kotlin.g.b.p.h(paramh, "holder");
  }
  
  private final boolean fk(Context paramContext)
  {
    boolean bool = false;
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null) {}
    for (int i = paramContext.tCE;; i = 0)
    {
      if ((this.dLS == 3) || (this.dLS == 1) || (this.dLS == 4) || (i == 16)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public com.tencent.mm.bw.b a(T paramT)
  {
    kotlin.g.b.p.h(paramT, "item");
    return paramT.likeBuffer;
  }
  
  public void a(int paramInt, com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramh, "holder");
    paramh.mf(2131301677, paramInt);
  }
  
  public void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    this.tAc = ((View.OnClickListener)new p(paramh));
    Object localObject1 = paramh.Mn(2131301674);
    paramRecyclerView = new z.f();
    paramRecyclerView.SYG = new ak((View)localObject1);
    kotlin.g.b.p.g(localObject1, "footerTouchDelegateView");
    ((View)localObject1).setTouchDelegate((TouchDelegate)paramRecyclerView.SYG);
    localObject1 = (ImageView)paramh.Mn(2131297134);
    Object localObject2 = this.tAc;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("onAvatarClickListener");
    }
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    ((ImageView)localObject1).post((Runnable)new u((ImageView)localObject1));
    localObject1 = (TextView)paramh.Mn(2131305436);
    localObject2 = this.tAc;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("onAvatarClickListener");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    kotlin.g.b.p.g(localObject1, "nickTv");
    ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject2 = paramh.getContext();
    kotlin.g.b.p.g(localObject2, "holder.context");
    ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100047));
    localObject1 = (WeImageView)paramh.Mn(2131304863);
    localObject2 = paramh.getContext();
    kotlin.g.b.p.g(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100044));
    localObject1 = (HardTouchableLayout)paramh.Mn(2131304552);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new v());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new n((HardTouchableLayout)localObject1, this, paramh));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new o((HardTouchableLayout)localObject1, this, paramh));
      localObject2 = ((HardTouchableLayout)localObject1).getContext();
      kotlin.g.b.p.g(localObject2, "mediaContainer.context");
      paramInt = (int)((Context)localObject2).getResources().getDimension(2131165311);
      if (this.tAa != 0) {
        break label932;
      }
      localObject1 = ((HardTouchableLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)localObject1).topMargin = paramInt;
      localObject1 = paramh.Mn(2131300557);
      kotlin.g.b.p.g(localObject1, "it");
      ((View)localObject1).setBackground(null);
      ((View)localObject1).setTag(Boolean.FALSE);
    }
    for (;;)
    {
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = null;
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = paramh.Mn(2131297154);
      ((View)((z.f)localObject2).SYG).setOnTouchListener((View.OnTouchListener)new w((z.f)localObject1));
      ((View)((z.f)localObject2).SYG).setOnClickListener((View.OnClickListener)new x(this, paramh));
      ((View)((z.f)localObject2).SYG).setOnLongClickListener((View.OnLongClickListener)new y(this, paramh));
      ((View)((z.f)localObject2).SYG).setHapticFeedbackEnabled(false);
      ((View)((z.f)localObject2).SYG).post((Runnable)new z((z.f)localObject2, paramh, paramRecyclerView));
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = paramh.Mn(2131298948);
      ((View)((z.f)localObject1).SYG).post((Runnable)new aa((z.f)localObject1, paramh, paramRecyclerView));
      localObject1 = (FinderCollapsibleTextView)paramh.Mn(2131308992);
      ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h(((FinderCollapsibleTextView)localObject1).getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o(paramh.getContext())));
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = paramh.Mn(2131300490);
      localObject2 = (View)((z.f)localObject1).SYG;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new ab(this, paramh));
      }
      localObject2 = (View)((z.f)localObject1).SYG;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new q(paramh, (z.f)localObject1, paramRecyclerView));
      }
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = paramh.Mn(2131307809);
      localObject2 = (View)((z.f)localObject1).SYG;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new r(this, paramh));
      }
      localObject2 = (View)((z.f)localObject1).SYG;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new s(paramh, (z.f)localObject1, paramRecyclerView));
      }
      paramh.Mn(2131304863).setOnLongClickListener((View.OnLongClickListener)new t(paramh));
      paramRecyclerView = paramh.Mn(2131298951);
      kotlin.g.b.p.g(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
      paramRecyclerView.setClickable(false);
      paramRecyclerView = new b(this, paramh);
      paramh.aus.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
      paramRecyclerView.alive();
      this.tAb.add(paramRecyclerView);
      return;
      label932:
      if (this.tAa == 1)
      {
        localObject2 = ((HardTouchableLayout)localObject1).getLayoutParams();
        if (localObject2 == null) {
          throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        localObject2 = paramh.Mn(2131300557);
        kotlin.g.b.p.g(localObject2, "it");
        ((View)localObject2).setBackground(((HardTouchableLayout)localObject1).getResources().getDrawable(2131232411));
        ((View)localObject2).setTag(Boolean.TRUE);
      }
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, View paramView)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramView, "view");
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
      WeImageView localWeImageView = (WeImageView)paramh.Mn(2131303181);
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.Lj(((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectType);
      int i;
      if (paramView == null)
      {
        paramView = "";
        Object localObject2 = (CharSequence)paramView;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label300;
        }
        i = 1;
        label175:
        if (i != 0) {
          break label305;
        }
        kotlin.g.b.p.g(localWeImageView, "likeIconBanner");
        paramh = localWeImageView.getDrawable();
        if (paramh != null) {
          paramh.clearColorFilter();
        }
        localWeImageView.setClearColorFilter(true);
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
        kotlin.g.b.p.g(localWeImageView, "likeIconBanner");
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 0.0F, null, false, 30);
        return;
        if (ao.isDarkMode())
        {
          paramView = paramView.LJE;
          break;
        }
        paramView = paramView.LJF;
        break;
        label300:
        i = 0;
        break label175;
        label305:
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
          localWeImageView.setImageDrawable(ar.m(paramView, 2131690436, paramh.getResources().getColor(2131099824)));
        }
      }
    }
    a(paramh, 2, false);
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, FinderObject paramFinderObject)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramView, "view");
    kotlin.g.b.p.h(paramFinderObject, "finderObj");
  }
  
  public abstract void a(com.tencent.mm.view.recyclerview.h paramh, T paramT, int paramInt);
  
  public void a(final com.tencent.mm.view.recyclerview.h paramh, final T paramT, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
    paramT.feedObject.setReplaceLongVideoToNormal(false);
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      paramInt2 = 1;
      if (paramInt2 == 0) {
        paramList = ((Iterable)paramList).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label412;
        }
        localObject1 = paramList.next();
        if ((localObject1 instanceof kotlin.o))
        {
          localObject1 = (kotlin.o)localObject1;
          switch (((Number)((kotlin.o)localObject1).first).intValue())
          {
          default: 
            break;
          case 1: 
            d(paramT, paramh);
            return;
            paramInt2 = 0;
            break;
          case 2: 
            b(paramT, paramh, false);
            return;
          case 3: 
            paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            paramList = com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject());
            paramBoolean = ((Boolean)paramList.first).booleanValue();
            ((Boolean)paramList.second).booleanValue();
            if (!paramBoolean) {
              a(this, false, paramh, paramT);
            }
            a(paramT, paramh);
            c(paramT, paramh);
            a(paramT, paramh, true);
            return;
          case 4: 
            paramList = com.tencent.mm.plugin.finder.upload.action.c.vUa;
            paramBoolean = com.tencent.mm.plugin.finder.upload.action.c.dBq().k(paramT.feedObject.getFeedObject());
            paramList = com.tencent.mm.plugin.finder.upload.action.c.vUa;
            a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.c.dBq().l(paramT.feedObject.getFeedObject()), paramh);
            return;
          case 5: 
            c(paramh, paramT);
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
          case 7: 
            b(paramh, paramT);
            return;
          case 8: 
            a(paramh, paramT.feedObject, Boolean.TRUE);
          }
        }
      }
    }
    label412:
    paramList = paramh.Mn(2131303181);
    kotlin.g.b.p.g(paramList, "holder.getView<View>(R.id.like_icon)");
    paramList.setVisibility(8);
    paramh.Mn(2131304863).setOnClickListener((View.OnClickListener)new l(this, paramh));
    paramT.feedObject.getTopicClickExtra().aWF = new WeakReference(paramh.getContext());
    label592:
    label743:
    Object localObject2;
    label657:
    label693:
    label720:
    Object localObject3;
    if (!this.tAi.dbZ())
    {
      paramList = y.vXH;
      if (!y.w(paramT.feedObject.getFeedObject())) {}
    }
    else
    {
      paramh.mf(2131309604, 0);
      paramh.e(2131309604, (CharSequence)com.tencent.mm.plugin.finder.utils.k.m(paramh.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      b(paramT);
      paramh.mf(2131297095, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label2081;
        }
        paramInt2 = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = y.vXH;
        localObject1 = paramh.Mn(2131297096);
        kotlin.g.b.p.g(localObject1, "holder.getView<ImageView>(R.id.auth_icon)");
        y.a((ImageView)localObject1, paramList.field_authInfo);
      }
      switch (paramInt2)
      {
      default: 
        paramList = kotlin.x.SXb;
        if (!paramBoolean) {
          a(paramh, paramT, paramInt1);
        }
        localObject1 = paramT.feedObject;
        paramList = paramT.contact;
        if (paramList != null)
        {
          paramList = paramList.getUsername();
          c(paramh, (FinderItem)localObject1, paramList);
          paramList = paramT.contact;
          if (paramList == null) {
            break label2197;
          }
          paramList = paramList.getUsername();
          if (paramList != null)
          {
            localObject1 = paramT.contact;
            if (localObject1 == null) {
              break label2203;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).cXH();
            localObject1 = Util.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
            localObject2 = com.tencent.mm.plugin.finder.api.c.a.asG(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).cXH())) {
                paramList = ((com.tencent.mm.plugin.finder.api.g)localObject2).cXH();
              }
              localObject1 = kotlin.x.SXb;
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
            localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
            paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
            localObject2 = paramh.Mn(2131297134);
            kotlin.g.b.p.g(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
            paramList = kotlin.x.SXb;
          }
          if (paramBoolean) {
            break label3638;
          }
          paramList = paramh.Mn(2131299220);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label2209;
          }
          paramInt1 = 1;
          label902:
          if (paramInt1 == 0) {
            break label2219;
          }
          paramh.mf(2131308992, 8);
          if (paramList == null) {
            break label2214;
          }
          localObject1 = paramList.getContext();
          kotlin.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165277);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = kotlin.x.SXb;
          paramInt1 = 0;
          label977:
          paramList = paramh.Mn(2131301631);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          paramList = paramh.Mn(2131301631);
          if (paramList != null) {
            paramList.setAlpha(1.0F);
          }
          localObject1 = paramT.feedObject.getFoldedLayout();
          if (localObject1 != null)
          {
            if ((((ard)localObject1).tQR != 1) || (this.tAf)) {
              break label2456;
            }
            paramList = paramh.Mn(2131301631);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
          }
          label1069:
          c(paramh, paramT);
          paramList = paramh.Mn(2131301408);
          paramInt2 = paramInt1;
          if (paramList != null) {
            paramList.setVisibility(8);
          }
        }
        break;
      }
    }
    label1158:
    label1192:
    label2219:
    label2995:
    label3638:
    for (paramInt2 = paramInt1;; paramInt2 = 0)
    {
      d(paramT, paramh);
      label1116:
      Object localObject4;
      label1778:
      float f;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        b(paramT, paramh, paramBoolean);
        if (Util.isNullOrNil(paramT.headerWording)) {
          break label2969;
        }
        paramh.mf(2131302311, 0);
        paramh.e(2131302310, (CharSequence)paramT.headerWording);
        if (Util.isNullOrNil(paramT.footerWording)) {
          break label2982;
        }
        paramh.mf(2131301682, 0);
        paramh.e(2131301680, (CharSequence)paramT.footerWording);
        a(paramh, paramT);
        kotlin.g.b.p.h(paramh, "holder");
        ((TextView)paramh.Mn(2131305436)).post((Runnable)new bc(paramh));
        c(paramT, paramh);
        b(paramh, paramT, 1);
        a(paramT, paramh, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        paramList = com.tencent.mm.plugin.finder.upload.action.j.dBt().Ga(paramT.feedObject.getLocalId());
        a(((Boolean)paramList.first).booleanValue(), paramh, ((Boolean)paramList.second).booleanValue());
        paramList = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(((Boolean)com.tencent.mm.plugin.finder.upload.action.j.dBt().m(paramT.feedObject.getFeedObject()).first).booleanValue(), paramh, paramT, true);
        paramList = y.vXH;
        if ((y.h(paramT)) && (paramT.showShareSns))
        {
          paramT.showShareSns = false;
          paramList = new d.a(paramh.getContext());
          paramList.aoS(2131759763);
          paramList.Dk(false);
          paramList.Dl(true);
          paramList.aoW(2131759764);
          paramList.aoV(2131759765).c((DialogInterface.OnClickListener)new c(this, paramh));
          paramList.f((DialogInterface.OnCancelListener)new d(paramh));
          paramList.hbn().show();
        }
        paramList = paramh.Mn(2131307824);
        if (paramList != null) {
          paramList.setVisibility(8);
        }
        localObject2 = paramT.feedObject.getLocation();
        localObject1 = paramh.Mn(2131306042);
        paramList = (TextView)paramh.Mn(2131306013);
        localObject3 = y.vXH;
        localObject2 = y.hg(((axt)localObject2).fuK, ((axt)localObject2).kHV);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label2995;
        }
        kotlin.g.b.p.g(localObject1, "positionLayout");
        ((View)localObject1).setVisibility(8);
        paramList = kotlin.x.SXb;
        localObject1 = paramh.Mn(2131303217);
        kotlin.g.b.p.g(localObject1, "linkLayout");
        ((View)localObject1).setVisibility(8);
        localObject3 = paramT.feedObject.getExtReading();
        if ((!Util.isNullOrNil(((aqp)localObject3).link)) && (!Util.isNullOrNil(((aqp)localObject3).title)))
        {
          localObject2 = ((aqp)localObject3).link;
          localObject4 = ((aqp)localObject3).title;
          paramList = (TextView)paramh.Mn(2131303219);
          paramh.e(2131303219, (CharSequence)localObject4);
          Log.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((aqp)localObject3).title);
          ((View)localObject1).post((Runnable)new i(paramList, (String)localObject4, this, paramh, (View)localObject1, paramT));
          ((View)localObject1).setVisibility(0);
          localObject3 = com.tencent.mm.kernel.g.af(ad.class);
          kotlin.g.b.p.g(localObject3, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if (!((ad)localObject3).dxX()) {
            break label3138;
          }
          kotlin.g.b.p.g(paramList, "linkTv");
          localObject1 = paramList.getContext();
          kotlin.g.b.p.g(localObject1, "linkTv.context");
          paramList.setTextColor(((Context)localObject1).getResources().getColor(2131099746));
        }
        paramList = kotlin.x.SXb;
        localObject1 = paramh.Mn(2131306678);
        paramList = paramh.Mn(2131298951);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
        {
          localObject1 = paramList.getContext();
          kotlin.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165277);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = kotlin.x.SXb;
        }
        a(paramh, paramT.feedObject, Boolean.FALSE);
        a(paramT, paramh);
        paramList = y.vXH;
        if (y.h(paramT)) {
          break label3163;
        }
        paramList = paramh.Mn(2131306139);
        if (paramList != null) {
          paramList.setVisibility(8);
        }
        localObject3 = (FinderMediaBanner)paramh.Mn(2131304549);
        f = 1.0F * ((FinderMediaBanner)localObject3).getPagerView().getLayoutParams().height / ((FinderMediaBanner)localObject3).getPagerView().getLayoutParams().width;
        paramList = (TextView)paramh.Mn(2131305436);
        localObject1 = (WeImageView)paramh.Mn(2131304863);
        localObject2 = (TextView)paramh.Mn(2131297095);
        localObject4 = y.vXH;
        if (!y.b(f, this.tAa)) {
          break label3403;
        }
        localObject3 = (HardTouchableLayout)paramh.Mn(2131304552);
        kotlin.g.b.p.g(localObject3, "mediaContainer");
        localObject4 = ((HardTouchableLayout)localObject3).getLayoutParams();
        if (localObject4 != null) {
          break label3220;
        }
        throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        paramh.mf(2131309604, 8);
        break;
        paramInt2 = 0;
        break label592;
        paramh.mf(2131297096, 0);
        paramh.mf(2131297095, 0);
        localObject1 = (TextView)paramh.Mn(2131297095);
        kotlin.g.b.p.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
        paramList = paramh.getContext();
        kotlin.g.b.p.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099748));
        paramList = kotlin.x.SXb;
        break label657;
        paramh.mf(2131297096, 0);
        break label657;
        paramList = null;
        break label693;
        paramList = null;
        break label720;
        localObject1 = null;
        break label743;
        paramInt1 = 0;
        break label902;
        paramInt1 = 0;
        break label977;
        if (paramList != null)
        {
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = kotlin.x.SXb;
        }
        paramList = paramh.Mn(2131308992);
        if (paramT.feedObject.getMediaList().size() <= 1) {
          if (paramList != null)
          {
            localObject1 = paramList.getContext();
            kotlin.g.b.p.g(localObject1, "context");
            paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165314);
            paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = kotlin.x.SXb;
          }
        }
        for (;;)
        {
          paramh.mf(2131308992, 0);
          paramList = (FinderCollapsibleTextView)paramh.Mn(2131308992);
          localObject1 = paramh.Mn(2131307089);
          paramList.setCollapse(paramT.isContentCollapsed);
          paramList.a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject1, (kotlin.g.a.b)new m(paramList));
          paramList.setOnCollapse((kotlin.g.a.b)new k(paramT, paramh));
          paramInt1 = 1;
          break;
          if (paramList != null)
          {
            paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = kotlin.x.SXb;
          }
        }
        if ((((ard)localObject1).tQR != 1) && (((ard)localObject1).tQR != 2)) {
          break label1069;
        }
        paramList = paramh.Mn(2131301631);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = paramh.Mn(2131301631);
        if (paramList != null) {
          break label3635;
        }
        paramList = ((ViewStub)paramh.Mn(2131301632)).inflate();
      }
      for (;;)
      {
        localObject2 = paramList.findViewById(2131301652);
        localObject3 = paramList.findViewById(2131303187);
        if (((ard)localObject1).tQR == 1)
        {
          kotlin.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          kotlin.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(8);
          localObject2 = (TextView)paramList.findViewById(2131300576);
          if (((ard)localObject1).tQR != 1) {
            break label2840;
          }
          localObject3 = paramh.getContext();
          localObject4 = paramh.getContext();
          y localy = y.vXH;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(2131759773, new Object[] { y.hf(((ard)localObject1).username, ""), String.valueOf(((ard)localObject1).gAZ) }));
          kotlin.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramh.getContext(), (CharSequence)localObject3));
          localObject2 = paramT.feedObject.getFoldedFeedList();
          localObject3 = (FinderFoldedScrollLayout)paramh.Mn(2131300570);
          kotlin.g.b.p.g(localObject3, "foldedScrollLayout");
          localObject4 = ((FinderFoldedScrollLayout)localObject3).getLayoutParams();
          if (((ard)localObject1).tQR != 2) {
            break label2918;
          }
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 208);
          label2755:
          ((FinderFoldedScrollLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (!Util.isNullOrNil((List)localObject2)) {
            break label2936;
          }
          ((FinderFoldedScrollLayout)localObject3).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(2131300575).setOnClickListener((View.OnClickListener)new aj(this, (List)localObject2, paramT, (ard)localObject1, paramh));
          break;
          kotlin.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          kotlin.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(0);
          break label2581;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(paramh.getContext(), (CharSequence)paramh.getContext().getString(2131759772, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((ard)localObject1).gAZ) }));
          kotlin.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramh.getContext(), (CharSequence)localObject3));
          break label2695;
          label2918:
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 240);
          break label2755;
          label2936:
          ((FinderFoldedScrollLayout)localObject3).setVisibility(0);
          ((FinderFoldedScrollLayout)localObject3).setup((com.tencent.mm.plugin.finder.view.p)new com.tencent.mm.plugin.finder.view.g((ard)localObject1, paramT));
        }
        paramBoolean = false;
        break label1116;
        paramh.mf(2131302311, 8);
        break label1158;
        paramh.mf(2131301682, 8);
        break label1192;
        kotlin.g.b.p.g(paramList, "poiTv");
        paramList.setText((CharSequence)localObject2);
        paramList.post((Runnable)new g((View)localObject1, paramList, (String)localObject2, this, paramh, paramT));
        kotlin.g.b.p.g(localObject1, "positionLayout");
        ((View)localObject1).setVisibility(0);
        localObject1 = com.tencent.mm.kernel.g.af(ad.class);
        kotlin.g.b.p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad)localObject1).dxX())
        {
          localObject1 = paramList.getContext();
          kotlin.g.b.p.g(localObject1, "poiTv.context");
          paramList.setTextColor(((Context)localObject1).getResources().getColor(2131099746));
          break label1542;
        }
        paramList.setOnClickListener((View.OnClickListener)new h((String)localObject2, this, paramh, paramT));
        break label1542;
        label3138:
        paramList.setOnClickListener((View.OnClickListener)new j((String)localObject2, this, paramh, (View)localObject1, paramT));
        break label1778;
        label3163:
        if (paramT.feedObject.isPrivate())
        {
          paramList = paramh.Mn(2131306139);
          if (paramList == null) {
            break label1931;
          }
          paramList.setVisibility(0);
          break label1931;
        }
        paramList = paramh.Mn(2131306139);
        if (paramList == null) {
          break label1931;
        }
        paramList.setVisibility(8);
        break label1931;
        ((FrameLayout.LayoutParams)localObject4).topMargin = 0;
        localObject4 = paramh.Mn(2131300557);
        kotlin.g.b.p.g(localObject4, "it");
        ((View)localObject4).setBackground(((HardTouchableLayout)localObject3).getResources().getDrawable(2131232411));
        ((View)localObject4).setTag(Boolean.TRUE);
        localObject3 = paramh.Mn(2131300557);
        kotlin.g.b.p.g(localObject3, "holder.getView<View>(R.id.feedHeaderBar)");
        if (kotlin.g.b.p.j(((View)localObject3).getTag(), Boolean.TRUE))
        {
          localObject3 = paramh.getContext();
          kotlin.g.b.p.g(localObject3, "holder.context");
          paramList.setTextColor(((Context)localObject3).getResources().getColor(2131101427));
          paramList = paramh.getContext();
          kotlin.g.b.p.g(paramList, "holder.context");
          ((TextView)localObject2).setTextColor(paramList.getResources().getColor(2131101427));
          paramList = paramh.getContext();
          kotlin.g.b.p.g(paramList, "holder.context");
          ((WeImageView)localObject1).setIconColor(paramList.getResources().getColor(2131101427));
        }
        for (;;)
        {
          b(paramh, paramT);
          d(paramh, paramT);
          return;
          label3403:
          if ((this.tAa != 2) || (f >= 1.316667F)) {
            break;
          }
          kotlin.g.b.p.g(localObject3, "banner");
          localObject3 = ((FinderMediaBanner)localObject3).getContext();
          kotlin.g.b.p.g(localObject3, "banner.context");
          paramInt1 = (int)((Context)localObject3).getResources().getDimension(2131165311);
          localObject3 = (HardTouchableLayout)paramh.Mn(2131304552);
          kotlin.g.b.p.g(localObject3, "mediaContainer");
          localObject3 = ((HardTouchableLayout)localObject3).getLayoutParams();
          if (localObject3 == null) {
            throw new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          }
          ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt1;
          localObject3 = paramh.Mn(2131300557);
          kotlin.g.b.p.g(localObject3, "it");
          ((View)localObject3).setBackground(null);
          ((View)localObject3).setTag(Boolean.FALSE);
          break;
          localObject3 = paramh.getContext();
          kotlin.g.b.p.g(localObject3, "holder.context");
          ((WeImageView)localObject1).setIconColor(((Context)localObject3).getResources().getColor(2131100047));
          localObject1 = paramh.getContext();
          kotlin.g.b.p.g(localObject1, "holder.context");
          ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131099748));
          localObject1 = paramh.getContext();
          kotlin.g.b.p.g(localObject1, "holder.context");
          paramList.setTextColor(((Context)localObject1).getResources().getColor(2131100047));
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem)
  {
    Object localObject2 = null;
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramFinderItem, "finderItem");
    Object localObject1 = com.tencent.mm.kernel.g.af(ad.class);
    kotlin.g.b.p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject1).dxX()) {
      Log.i("Finder.FeedConvert", "refreshBgmTag return for 青少年模式");
    }
    label262:
    label315:
    label321:
    label451:
    for (;;)
    {
      return;
      localObject1 = y.vXH;
      if (y.D(paramFinderItem))
      {
        Log.i("Finder.FeedConvert", "refreshBgmTag: this feed has long video attachment, do not need to refresh bgm");
        return;
      }
      localObject1 = (FinderImgFeedMusicTag)paramh.aus.findViewById(2131297363);
      kotlin.g.b.p.g(localObject1, "tag");
      ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
      ((FinderImgFeedMusicTag)localObject1).setTag(2131301376, Boolean.FALSE);
      if (this.tAh == 1)
      {
        Object localObject3 = y.vXH;
        if (!y.x(paramFinderItem.getFeedObject())) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label451;
          }
          ((FinderImgFeedMusicTag)localObject1).setTag(2131301376, Boolean.TRUE);
          if (paramFinderItem.getMediaType() == 2)
          {
            localObject2 = paramFinderItem.getFeedObject().objectDesc;
            if (localObject2 != null)
            {
              localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
              if (localObject2 != null)
              {
                localObject2 = paramFinderItem.getFeedObject().objectDesc;
                if (localObject2 != null)
                {
                  localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
                  if ((localObject2 != null) && (((azr)localObject2).LJw == 0)) {}
                }
                else
                {
                  localObject2 = paramFinderItem.getFeedObject().objectDesc;
                  if (localObject2 == null) {
                    break label315;
                  }
                  localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
                  if (localObject2 == null) {
                    break label315;
                  }
                  localObject2 = ((azr)localObject2).groupId;
                  localObject2 = (CharSequence)localObject2;
                  if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                    break label321;
                  }
                }
              }
            }
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label326;
              }
              ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
              ((FinderImgFeedMusicTag)localObject1).dle();
              ((FinderImgFeedMusicTag)localObject1).setViewPager(null);
              return;
              localObject2 = null;
              break;
              localObject2 = null;
              break label262;
            }
            label326:
            paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
            if (paramFinderItem == null) {
              break;
            }
            paramFinderItem = paramFinderItem.feedBgmInfo;
            if (paramFinderItem == null) {
              break;
            }
            paramFinderItem = paramFinderItem.musicInfo;
            if (paramFinderItem == null) {
              break;
            }
            ((FinderImgFeedMusicTag)localObject1).a(paramFinderItem);
            ((FinderImgFeedMusicTag)localObject1).setViewPager((FinderMediaBanner)paramh.Mn(2131304549));
            return;
          }
          if (paramFinderItem.getMediaType() != 4) {
            break;
          }
          localObject3 = paramFinderItem.getFeedObject().objectDesc;
          paramh = (com.tencent.mm.view.recyclerview.h)localObject2;
          if (localObject3 != null) {
            paramh = ((FinderObjectDesc)localObject3).feedBgmInfo;
          }
          if (paramh == null) {
            break;
          }
          paramh = paramFinderItem.getFeedObject().objectDesc;
          if (paramh != null)
          {
            paramh = paramh.feedBgmInfo;
            if ((paramh != null) && (paramh.LJw == 1)) {
              break;
            }
          }
          ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
          return;
        }
      }
    }
  }
  
  public void b(com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramh, "holder");
    super.b(paramh);
  }
  
  public final void c(com.tencent.mm.view.recyclerview.h paramh)
  {
    kotlin.g.b.p.h(paramh, "holder");
    Object localObject1 = (BaseFinderFeed)paramh.hgv();
    Object localObject2 = y.vXH;
    if (!y.u(((BaseFinderFeed)localObject1).feedObject.getFeedObject()))
    {
      localObject1 = y.vXH;
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      paramh = paramh.getContext().getString(2131760436);
      kotlin.g.b.p.g(paramh, "holder.context.getString…finder_private_ban_share)");
      y.aF((Context)localObject1, paramh);
      return;
    }
    if (((BaseFinderFeed)localObject1).feedObject.isPrivate())
    {
      u.a(paramh.getContext(), paramh.getContext().getString(2131760442), (u.b)bd.tBn);
      return;
    }
    localObject2 = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.f)new be(this));
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.g)new bf(this, (BaseFinderFeed)localObject1));
    ((com.tencent.mm.ui.widget.a.e)localObject2).b((e.b)new bg(paramh));
    ((com.tencent.mm.ui.widget.a.e)localObject2).dGm();
  }
  
  public void d(com.tencent.mm.view.recyclerview.h paramh, T paramT)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramT, "item");
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$Companion;", "", "()V", "TAG", "", "payloadsAttachInfo", "", "payloadsCommentEdu", "payloadsExposeInfoType", "payloadsFavInfoType", "payloadsLiveNotice", "payloadsLiveStatus", "payloadsPlayMusic", "payloadsPostEnd", "payloadsProgressType", "payloadsRefreshAddForward", "payloadsRefreshComment", "payloadsRefreshForward", "payloadsRefreshLike", "payloadsRefreshOpCount", "payloadsStopMusic", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class aa
    implements Runnable
  {
    aa(z.f paramf1, com.tencent.mm.view.recyclerview.h paramh, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242836);
      Rect localRect = new Rect();
      ((View)this.tAK.SYG).getHitRect(localRect);
      int i = com.tencent.mm.cb.a.aH(paramh.getContext(), 2131165314);
      localRect.inset(-i, -i);
      ak localak = (ak)paramRecyclerView.SYG;
      View localView = (View)this.tAK.SYG;
      kotlin.g.b.p.g(localView, "commentView");
      localak.a(new al(localRect, localView));
      AppMethodBeat.o(242836);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ab
    implements View.OnClickListener
  {
    ab(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242837);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("Finder.FeedConvert", "onClickFav:" + paramh.lR());
      l.a(this.tAp, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242837);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ac
    implements Runnable
  {
    ac(l paraml, View paramView, com.tencent.mm.view.recyclerview.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242838);
      int i = this.tAL.getHeight();
      int j = KeyBoardUtil.getKeyBordHeightPx(this.qhp.getContext()) - this.tAM + i;
      Log.i("Finder.FeedConvert", "[openCommentDrawer] offset=" + j + " itemBottom=" + this.tAN + " recyclerViewBottom=" + l.h(this.tAp).bottom + " editLayoutHeight=" + i);
      if (j > 0)
      {
        FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = l.e(this.tAp).getVideoCore().weS;
        if (localFinderVideoAutoPlayManager != null) {
          FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, "openCommentDrawer", true);
        }
        this.qhp.getRecyclerView().smoothScrollBy(0, j);
      }
      AppMethodBeat.o(242838);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class ad
    implements CommentDrawerContract.CloseDrawerCallback
  {
    ad(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed, z.d paramd) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.s> paramList)
    {
      AppMethodBeat.i(242839);
      kotlin.g.b.p.h(paramList, "data");
      ((FinderFeedExposeLayout)this.qhp.Mn(2131298951)).Mo(this.tAr.feedObject.getCommentCount());
      paramList = l.e(this.tAp).getVideoCore().weS;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (l.e(this.tAp).dbZ())
      {
        paramList = this.qhp.Mn(2131307578);
        kotlin.g.b.p.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(1, this.tAr.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtx().value()).intValue() == 1) {
        this.qhp.getRecyclerView().smoothScrollBy(0, -this.tAO.SYE);
      }
      AppMethodBeat.o(242839);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(l paraml, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242840);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
      com.tencent.mm.plugin.finder.storage.c.KQ(2);
      l.a(this.tAp, paramh, paramT, true, 0L, null, ((Rect)localObject).top - com.tencent.mm.view.d.e(paramh.getContext(), 16.0F), paramInt, 24);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242840);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x>
  {
    af(l paraml, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class ag
    extends q
    implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x>
  {
    ag(l paraml, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class ah
    extends q
    implements kotlin.g.a.m<FinderCommentInfo, Boolean, kotlin.x>
  {
    ah(l paraml, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ai
    implements View.OnClickListener
  {
    ai(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242841);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tAS.getOnCommentClickListener();
      if (paramView != null)
      {
        localObject = paramT;
        kotlin.g.b.p.g(localObject, "selfCommentContainer");
        paramView.invoke(localObject, null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242841);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(l paraml, List paramList, BaseFinderFeed paramBaseFinderFeed, ard paramard, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242842);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      l.a(this.tAU, paramT, this.tAV, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242842);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ak
    implements Runnable
  {
    ak(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(242843);
      Object localObject1 = new Rect();
      this.tAW.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165277);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.tAW;
      kotlin.g.b.p.g(localObject2, "onliveView");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(242843);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.tAW));
      AppMethodBeat.o(242843);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class al
    implements View.OnClickListener
  {
    al(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242844);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.qhp.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      paramView = paramT.contact;
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        new com.tencent.mm.plugin.finder.view.r((Context)localObject, paramView, this.qhp.lR(), paramT.feedObject.isLiveFeed()).dzC();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242844);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class am
    implements View.OnClickListener
  {
    am(com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242845);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.qhp.getContext();
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
        paramView.a(paramT.feedObject, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242845);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class an
    implements View.OnClickListener
  {
    an(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242846);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tAp.c(paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242846);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$3"})
  static final class ao
    implements View.OnTouchListener
  {
    ao(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242847);
      kotlin.g.b.p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramMotionEvent = (WeImageView)paramh.Mn(2131306267);
        if (paramMotionEvent == null) {
          break label75;
        }
      }
      label75:
      for (paramView = paramMotionEvent.getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (kotlin.g.b.p.j(paramMotionEvent.getTag(), Integer.valueOf(0)))) {
          l.d(paramh);
        }
        AppMethodBeat.o(242847);
        return false;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$2", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$4"})
  static final class ap
    implements View.OnClickListener
  {
    ap(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242848);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("Finder.FeedConvert", "onClickLikeLocal:" + paramh.lR());
      l.b(this.tAX, paramh, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242848);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$3", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$5"})
  static final class aq
    implements View.OnLongClickListener
  {
    aq(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242849);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtQ().value()).intValue() == 1)
      {
        Log.i("Finder.FeedConvert", "onLongClickLikeLocal:" + paramh.lR());
        localObject = (WeImageView)paramh.Mn(2131306267);
        if (localObject == null) {
          break label156;
        }
      }
      label156:
      for (paramView = ((WeImageView)localObject).getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (kotlin.g.b.p.j(((WeImageView)localObject).getTag(), Integer.valueOf(0)))) {
          l.b(this.tAX, paramh, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(242849);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class ar
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    ar(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class as
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    as(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class at
    implements View.OnClickListener
  {
    at(l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242852);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = l.e(this.tAp).getActivity();
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.h((Activity)paramView, ".ui.FinderHomeUI");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242852);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class au
    implements ValueAnimator.AnimatorUpdateListener
  {
    au(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242853);
      FinderPostProgressView localFinderPostProgressView = this.tAY;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(242853);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.tAY.invalidate();
      AppMethodBeat.o(242853);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class av
    implements View.OnClickListener
  {
    av(l paraml, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165378);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      l.a(paramT, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165378);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aw
    implements View.OnClickListener
  {
    aw(l paraml, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242854);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      l.a(paramT, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242854);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ax
    implements View.OnClickListener
  {
    ax(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242855);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().t(this.tAr.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242855);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
  static final class ay
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    ay(z.a parama1, z.a parama2, l paraml, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
  static final class az
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    az(List paramList1, List paramList2, z.f paramf, l paraml, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends IListener<hf>
    implements View.OnAttachStateChangeListener
  {
    final l<T> tAl;
    final com.tencent.mm.view.recyclerview.h tAm;
    
    public b(l<T> paraml, com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(165341);
      this.tAl = paraml;
      this.tAm = paramh;
      if ((this.tAm.getContext() instanceof MMActivity))
      {
        paraml = this.tAm.getContext();
        if (paraml == null)
        {
          paraml = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw paraml;
        }
        ((MMActivity)paraml).getLifecycle().addObserver((LifecycleObserver)l.a(this.tAl));
      }
      AppMethodBeat.o(165341);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(165340);
      kotlin.g.b.p.h(paramView, "v");
      AppMethodBeat.o(165340);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(165339);
      kotlin.g.b.p.h(paramView, "v");
      AppMethodBeat.o(165339);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(l.b paramb, hf paramhf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
  static final class ba
    implements View.OnClickListener
  {
    ba(l paraml, com.tencent.mm.view.recyclerview.h paramh, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242858);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = new bfp();
      ((bfp)localObject).feedId = paramT.lT();
      ((bfp)localObject).objectNonceId = paramT.feedObject.getObjectNonceId();
      ((bfp)localObject).scene = 2;
      paramView = FinderReporterUIC.wzC;
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        ((bfp)localObject).ttO = paramView;
        localObject = paramh.getContext();
        paramView = (View)localObject;
        if (!(localObject instanceof Activity)) {
          paramView = null;
        }
        paramView = (Activity)paramView;
        if (paramView == null) {
          break label199;
        }
      }
      label199:
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131300826);; paramView = null)
      {
        if (paramView == null) {
          kotlin.g.b.p.hyc();
        }
        paramView.a(paramT.feedObject, this.tAp.a(paramT));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242858);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class bb
    implements View.OnClickListener
  {
    bb(l paraml, com.tencent.mm.plugin.finder.storage.k paramk, com.tencent.mm.view.recyclerview.h paramh, List paramList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, ViewGroup paramViewGroup) {}
    
    public final void onClick(View paramView)
    {
      int k = 1;
      String str = null;
      AppMethodBeat.i(242859);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = com.tencent.mm.kernel.g.af(ad.class);
      kotlin.g.b.p.g(paramView, "MMKernel.service(IFinder…enModeConfig::class.java)");
      Object localObject2;
      label166:
      long l1;
      int i;
      if (!((ad)paramView).dxX()) {
        if (Util.isNullOrNil(localk.getWording()))
        {
          paramView = paramh.getContext().getString(2131759711);
          kotlin.g.b.p.g(paramView, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
          Object localObject3 = localList;
          BaseFinderFeed localBaseFinderFeed = paramT;
          com.tencent.mm.view.recyclerview.h localh = paramh;
          localObject1 = localk.vDI;
          if (localObject1 != null)
          {
            localObject2 = ((aqv)localObject1).lastBuffer;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = null;
          }
          l.a(paramView, (List)localObject3, localBaseFinderFeed, localh, (com.tencent.mm.bw.b)localObject1, bool);
          paramView = FinderReporterUIC.wzC;
          paramView = paramh.getContext();
          kotlin.g.b.p.g(paramView, "holder.context");
          localObject2 = FinderReporterUIC.a.fH(paramView);
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          l1 = paramT.lT();
          if (localObject2 == null) {
            break label415;
          }
          i = ((FinderReporterUIC)localObject2).tCE;
          label214:
          if (localObject2 == null) {
            break label420;
          }
          paramView = ((FinderReporterUIC)localObject2).sGE;
          label225:
          if (localObject2 == null) {
            break label425;
          }
          localObject1 = ((FinderReporterUIC)localObject2).sGQ;
          label237:
          if (localObject2 != null) {
            str = ((FinderReporterUIC)localObject2).sessionId;
          }
          localObject3 = com.tencent.mm.plugin.finder.report.k.vfA;
          long l2 = paramT.lT();
          if (localObject2 == null) {
            break label431;
          }
          j = ((FinderReporterUIC)localObject2).tCE;
          label274:
          localObject2 = com.tencent.mm.plugin.finder.report.k.G(l2, j);
          if (!localk.vDG) {
            break label436;
          }
        }
      }
      label415:
      label420:
      label425:
      label431:
      label436:
      for (int j = k;; j = 2)
      {
        com.tencent.mm.plugin.finder.report.k.a(l1, 3, i, paramView, (String)localObject1, str, (String)localObject2, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242859);
        return;
        paramView = localk.getWording();
        break;
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(localViewGroup.getContext());
        com.tencent.mm.plugin.report.service.h.CyF.a(20912, new Object[] { Integer.valueOf(3), Integer.valueOf(5), paramT.feedObject.getUserName(), paramT.feedObject.getNickName() });
        break label166;
        i = 0;
        break label214;
        paramView = null;
        break label225;
        localObject1 = null;
        break label237;
        j = 0;
        break label274;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bc
    implements Runnable
  {
    bc(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.qhp.hgv();
      if (localBaseFinderFeed == null)
      {
        Log.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.qhp.Mn(2131298256);
      kotlin.g.b.p.g(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.qhp.Mn(2131297096);
        localObject1 = (TextView)this.qhp.Mn(2131301657);
        kotlin.g.b.p.g(localObject2, "authIconIv");
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label380;
        }
      }
      label197:
      label348:
      label380:
      for (int j = ((ImageView)localObject2).getWidth();; j = 0)
      {
        kotlin.g.b.p.g(localObject1, "followTv");
        CharSequence localCharSequence;
        int i;
        if (((TextView)localObject1).getVisibility() == 0) {
          if (((TextView)localObject1).getText() != null)
          {
            float f = com.tencent.mm.cb.a.aG(this.qhp.getContext(), 2131165303);
            localObject2 = ((TextView)localObject1).getPaint();
            localCharSequence = ((TextView)localObject1).getText();
            localObject1 = ((TextView)localObject1).getText();
            if (localObject1 != null)
            {
              i = ((CharSequence)localObject1).length();
              i = (int)(((TextPaint)localObject2).measureText(localCharSequence, 0, i) + f);
            }
          }
        }
        for (;;)
        {
          localObject1 = (TextView)this.qhp.Mn(2131305436);
          kotlin.g.b.p.g(localObject1, "nicknameTv");
          localObject2 = ((TextView)localObject1).getPaint();
          localCharSequence = (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan();
          SpannableString localSpannableString = localBaseFinderFeed.feedObject.getNickNameSpan();
          if (localSpannableString != null) {}
          for (int k = localSpannableString.length();; k = 0)
          {
            if (((TextPaint)localObject2).measureText(localCharSequence, 0, k) + (j + i) <= localLinearLayout.getWidth()) {
              break label348;
            }
            ((TextView)localObject1).setText(TextUtils.ellipsize((CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan(), ((TextView)localObject1).getPaint(), localLinearLayout.getWidth() - j - i, TextUtils.TruncateAt.END));
            AppMethodBeat.o(165379);
            return;
            i = 0;
            break;
            i = ((TextView)localObject1).getWidth();
            break label197;
          }
          this.qhp.e(2131305436, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class bd
    implements u.b
  {
    public static final bd tBn;
    
    static
    {
      AppMethodBeat.i(242861);
      tBn = new bd();
      AppMethodBeat.o(242861);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(242860);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(2131309260);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(242860);
          return;
        }
      }
      AppMethodBeat.o(242860);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class be
    implements o.f
  {
    be(l paraml) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(242862);
      kotlin.g.b.p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(l.c(this.tAp), 2131760573);
        paramm.kV(l.d(this.tAp), 2131760574);
      }
      AppMethodBeat.o(242862);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class bf
    implements o.g
  {
    bf(l paraml, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(242863);
      kotlin.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == l.c(this.tAp))
      {
        l.e(this.tAp).a(this.tAr.feedObject);
        AppMethodBeat.o(242863);
        return;
      }
      if (paramInt == l.d(this.tAp))
      {
        paramMenuItem = l.e(this.tAp);
        BaseFinderFeed localBaseFinderFeed = this.tAr;
        kotlin.g.b.p.g(localBaseFinderFeed, "item");
        paramMenuItem.k(localBaseFinderFeed);
      }
      AppMethodBeat.o(242863);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onDismiss"})
  static final class bg
    implements e.b
  {
    bg(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(242864);
      Object localObject = FinderReporterUIC.wzC;
      localObject = this.qhp.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      localObject = FinderReporterUIC.a.fH((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.qhp.hgv();
        com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(localBaseFinderFeed.feedObject.getId(), 1, 3L, "", (bbn)localObject, 0L, null, 96);
        AppMethodBeat.o(242864);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$2$2$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$2"})
  static final class bh
    implements View.OnClickListener
  {
    bh(azw paramazw, l paraml, com.tencent.mm.view.recyclerview.h paramh, FinderItem paramFinderItem, String paramString) {}
    
    public final void onClick(View paramView)
    {
      int i = 0;
      AppMethodBeat.i(242865);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
            break label445;
          }
          paramView = paramView.getFeedObject();
          if (paramView == null) {
            break label445;
          }
        }
      }
      label428:
      label445:
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242865);
        return;
        paramView = null;
        break;
        paramView = null;
        break label190;
        Log.i("Finder.FeedConvert", "hot news not support jump!");
        l1 = 0L;
        break label296;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showPrivateFeedLikeTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class bi
    implements Animator.AnimatorListener
  {
    bi(z.f paramf) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242866);
      paramAnimator = (View)this.tBq.SYG;
      kotlin.g.b.p.g(paramAnimator, "tips");
      paramAnimator.setVisibility(8);
      AppMethodBeat.o(242866);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bj
    implements Runnable
  {
    bj(l paraml, BaseFinderFeed paramBaseFinderFeed, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(242867);
      paramT.showLikeTips = false;
      this.tBr.setVisibility(8);
      l.f(this.tAp);
      AppMethodBeat.o(242867);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(242815);
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
        paramDialogInterface = l.e(this.tAp).getActivity();
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
        paramDialogInterface = l.e(this.tAp).getActivity();
        if (paramDialogInterface == null) {
          kotlin.g.b.p.hyc();
        }
        paramDialogInterface = (AppCompatActivity)paramDialogInterface;
        kotlin.g.b.p.g(localBaseFinderFeed, "currItem");
        s.a.a(paramDialogInterface, localBaseFinderFeed, 5, paramInt, 4);
        AppMethodBeat.o(242815);
        return;
        l = localBaseFinderFeed.feedObject.getId();
        break;
        label209:
        paramDialogInterface = null;
        break label73;
        label214:
        paramDialogInterface = l.e(this.tAp).getActivity();
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
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(242816);
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
        AppMethodBeat.o(242816);
        return;
        l = paramDialogInterface.feedObject.getId();
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(l paraml, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.tAp.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (kotlin.g.a.a)new b(this, (kotlin.g.a.a)new d(this), (kotlin.g.a.a)new c(this));
        if (this.tAq.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.tAp;
        localObject = this.$context;
        this.$context.getString(2131755998);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, this.$context.getString(2131756029), false, (DialogInterface.OnCancelListener)a.tAt));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.tAq.client_id;
      if (localObject != null) {}
      for (long l = Long.parseLong((String)localObject);; l = 0L)
      {
        paramDialogInterface.Fv(l);
        AppMethodBeat.o(165347);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tAt;
      
      static
      {
        AppMethodBeat.i(165342);
        tAt = new a();
        AppMethodBeat.o(165342);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(l.e parame, kotlin.g.a.a parama1, kotlin.g.a.a parama2)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(l.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      d(l.e parame)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.ak.c.a<atp>, Boolean>
  {
    f(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
  static final class g
    implements Runnable
  {
    g(View paramView, TextView paramTextView, String paramString, l paraml, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.tzP;
      kotlin.g.b.p.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 20);
        localObject = paramList;
        kotlin.g.b.p.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.tzR) + j > i)
        {
          localObject = paramList;
          kotlin.g.b.p.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.tzR;
          TextView localTextView = paramList;
          kotlin.g.b.p.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
  static final class h
    implements View.OnClickListener
  {
    h(String paramString, l paraml, com.tencent.mm.view.recyclerview.h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      l.a(jdField_this, paramh, paramT, this.tzR);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165349);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$1"})
  static final class i
    implements Runnable
  {
    i(TextView paramTextView, String paramString, l paraml, com.tencent.mm.view.recyclerview.h paramh, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165350);
      Object localObject = this.tzN;
      kotlin.g.b.p.g(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 20);
        localObject = this.tzL;
        kotlin.g.b.p.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.tzM) + j > i)
        {
          localObject = this.tzL;
          kotlin.g.b.p.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.tzM;
          TextView localTextView = this.tzL;
          kotlin.g.b.p.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$2"})
  static final class j
    implements View.OnClickListener
  {
    j(String paramString, l paraml, com.tencent.mm.view.recyclerview.h paramh, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      l.a(paramh, paramT, this.nNF);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165351);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    k(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242820);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = (BaseFinderFeed)paramh.hgv();
      localObject1 = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 0, false);
      Object localObject2 = y.vXH;
      kotlin.g.b.p.g(paramView, "item");
      if (y.w(paramView))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        localObject2 = paramh.getContext();
        kotlin.g.b.p.g(localObject2, "holder.context");
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(com.tencent.mm.plugin.finder.utils.m.a((Context)localObject2, paramView, (com.tencent.mm.ui.widget.a.e)localObject1));
        localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        int i = this.tAp.dLS;
        localObject2 = paramh.getContext();
        kotlin.g.b.p.g(localObject2, "holder.context");
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(com.tencent.mm.plugin.finder.utils.m.a(i, (Context)localObject2, paramView));
      }
      for (;;)
      {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(l.e(this.tAp).j(paramView));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(l.e(this.tAp).j(paramView));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(242819);
            Object localObject = FinderReporterUIC.wzC;
            localObject = this.tAA.qhp.getContext();
            kotlin.g.b.p.g(localObject, "holder.context");
            localObject = FinderReporterUIC.a.fH((Context)localObject);
            if (localObject != null) {}
            for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
            {
              BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.tAA.qhp.hgv();
              com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
              com.tencent.mm.plugin.finder.report.k.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", (bbn)localObject, 0L, null, 96);
              AppMethodBeat.o(242819);
              return;
            }
          }
        });
        ((com.tencent.mm.ui.widget.a.e)localObject1).dGm();
        localObject1 = y.vXH;
        if (y.C(paramView.feedObject))
        {
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = paramh.getContext();
          kotlin.g.b.p.g(localObject1, "holder.context");
          localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
          if (localObject1 != null)
          {
            localObject1 = ((FinderReporterUIC)localObject1).dIx();
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
              com.tencent.mm.plugin.finder.report.k.a((bbn)localObject1, paramView.feedObject.field_id, Integer.valueOf(paramView.feedObject.getFeedObject().follow_feed_count));
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242820);
        return;
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(l.e(this.tAp).a(paramView, (com.tencent.mm.ui.widget.a.e)localObject1));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(l.e(this.tAp).i(paramView));
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    m(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.b
  {
    n(HardTouchableLayout paramHardTouchableLayout, l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242822);
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramMotionEvent, "e");
      Log.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)paramh.hgv());
      jdField_this.a(paramh, (View)this.tAC);
      AppMethodBeat.o(242822);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class o
    implements HardTouchableLayout.g
  {
    o(HardTouchableLayout paramHardTouchableLayout, l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242823);
      kotlin.g.b.p.h(paramView, "view");
      Log.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)paramh.hgv());
      jdField_this.a(paramh, (View)this.tAC, ((BaseFinderFeed)paramh.hgv()).feedObject.getFeedObject());
      AppMethodBeat.o(242823);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242824);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = (BaseFinderFeed)this.qhp.hgv();
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = this.qhp.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
      if (localObject1 != null) {}
      for (int i = ((FinderReporterUIC)localObject1).tCE;; i = 0)
      {
        localObject1 = this.qhp.getContext().getClass().getName();
        kotlin.g.b.p.g(localObject1, "holder.context.javaClass.name");
        if (((kotlin.g.b.p.j(localObject1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) || (kotlin.g.b.p.j(localObject1, "FinderProfileTimeLineUI"))) && ((paramView instanceof BaseFinderFeed))) {
          com.tencent.mm.plugin.finder.report.live.k.vkd.a(paramView, this.qhp.lR(), s.p.voF, "1");
        }
        if ((i != 1) && (i != 8)) {
          break label240;
        }
        Log.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(3, paramView.lT(), i, 1, paramView.feedObject.getUserName());
        paramView = this.qhp.getContext();
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(242824);
        throw paramView;
      }
      ((Activity)paramView).finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242824);
      return;
      label240:
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramView.feedObject.getUserName());
      ((Intent)localObject1).putExtra("finder_read_feed_id", paramView.feedObject.getId());
      Object localObject2 = FinderReporterUIC.wzC;
      localObject2 = this.qhp.getContext();
      kotlin.g.b.p.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, paramView.lT(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject2 = this.qhp.getContext();
      kotlin.g.b.p.g(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((this.qhp.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        localObject1 = this.qhp.getContext();
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(242824);
          throw paramView;
        }
        localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject1).get(FinderReporterUIC.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).cZR().Eq(paramView.lT());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(3, paramView.lT(), i, 1, paramView.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242824);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class q
    implements Runnable
  {
    q(com.tencent.mm.view.recyclerview.h paramh, z.f paramf1, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242825);
      int i = com.tencent.mm.cb.a.aH(this.qhp.getContext(), 2131165314);
      Rect localRect = new Rect();
      ((View)this.tAD.SYG).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((ak)paramRecyclerView.SYG).a(new al(localRect, (View)this.tAD.SYG));
      AppMethodBeat.o(242825);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242826);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("Finder.FeedConvert", "onClickShare:" + paramh.lR());
      this.tAp.c(paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242826);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class s
    implements Runnable
  {
    s(com.tencent.mm.view.recyclerview.h paramh, z.f paramf1, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242827);
      int i = com.tencent.mm.cb.a.aH(this.qhp.getContext(), 2131165314);
      Rect localRect = new Rect();
      ((View)this.tAF.SYG).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((ak)paramRecyclerView.SYG).a(new al(localRect, (View)this.tAF.SYG));
      AppMethodBeat.o(242827);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class t
    implements View.OnLongClickListener
  {
    t(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242828);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = (BaseFinderFeed)this.qhp.hgv();
      paramView = (FinderVideoLayout)this.qhp.Mn(2131300776);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.uPf;; paramView = null)
      {
        localObject2 = com.tencent.mm.ui.component.a.PRN;
        localObject2 = this.qhp.getContext();
        if (localObject2 != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(242828);
        throw paramView;
      }
      Object localObject2 = (FinderDebugUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject2).get(FinderDebugUIC.class);
      Context localContext = this.qhp.getContext();
      kotlin.g.b.p.g(localContext, "holder.context");
      kotlin.g.b.p.g(localObject1, "item");
      ((FinderDebugUIC)localObject2).a(localContext, (BaseFinderFeed)localObject1, paramView, this.qhp);
      this.qhp.aus.requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(242828);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class u
    implements Runnable
  {
    u(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(242829);
      Object localObject1 = new Rect();
      this.tAG.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.tAG;
      kotlin.g.b.p.g(localObject2, "avatarView");
      localObject2 = ((ImageView)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(242829);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.tAG));
      AppMethodBeat.o(242829);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class v
    implements HardTouchableLayout.c
  {
    public final boolean S(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242830);
      kotlin.g.b.p.h(paramMotionEvent, "event");
      AppMethodBeat.o(242830);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class w
    implements View.OnTouchListener
  {
    w(z.f paramf) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242831);
      kotlin.g.b.p.g(paramMotionEvent, "event");
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.removeCallbacks((Runnable)this.tAH.SYG);
      }
      AppMethodBeat.o(242831);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165361);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("Finder.FeedConvert", "onClickLike:" + paramh.lR());
      l.a(this.tAp, paramh, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165361);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class y
    implements View.OnLongClickListener
  {
    y(l paraml, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242834);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = (BaseFinderFeed)paramh.hgv();
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtQ().value()).intValue() == 1)
      {
        localObject = y.vXH;
        if (!y.i(paramView.contact))
        {
          Log.i("Finder.FeedConvert", "onLongClick Private Like:" + paramh.lR());
          paramView = (WeImageView)paramh.Mn(2131302492);
          kotlin.g.b.p.g(paramView, "awesomeIv");
          if (((paramView.getTag() instanceof Integer)) && (kotlin.g.b.p.j(paramView.getTag(), Integer.valueOf(0))))
          {
            paramView = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 1, true);
            paramView.setTitleView(aa.jQ(paramh.getContext()).inflate(2131494583, null));
            paramView.a((o.f)new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
              {
                AppMethodBeat.i(242832);
                kotlin.g.b.p.g(paramAnonymousm, "it");
                if (paramAnonymousm.gKQ())
                {
                  int i = l.b(this.tAI.tAp);
                  Context localContext = this.tAI.qhp.getContext();
                  kotlin.g.b.p.g(localContext, "holder.context");
                  paramAnonymousm.d(i, (CharSequence)localContext.getResources().getString(2131760445));
                }
                AppMethodBeat.o(242832);
              }
            });
            paramView.a((o.g)new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(242833);
                kotlin.g.b.p.g(paramAnonymousMenuItem, "menuItem");
                if (paramAnonymousMenuItem.getItemId() == l.b(this.tAI.tAp)) {
                  l.a(this.tAI.tAp, this.tAI.qhp, true);
                }
                AppMethodBeat.o(242833);
              }
            });
            paramView.dGm();
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(242834);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class z
    implements Runnable
  {
    z(z.f paramf1, com.tencent.mm.view.recyclerview.h paramh, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242835);
      Rect localRect = new Rect();
      ((View)this.tAJ.SYG).getHitRect(localRect);
      int i = com.tencent.mm.cb.a.aH(paramh.getContext(), 2131165314);
      localRect.inset(-i, -i);
      ak localak = (ak)paramRecyclerView.SYG;
      View localView = (View)this.tAJ.SYG;
      kotlin.g.b.p.g(localView, "awesomeView");
      localak.a(new al(localRect, localView));
      AppMethodBeat.o(242835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.l
 * JD-Core Version:    0.7.0.1
 */