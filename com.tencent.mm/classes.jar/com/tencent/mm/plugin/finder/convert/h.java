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
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.he.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.g.a;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.FinderBubbleLayout;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.d;
import d.g.b.y.f;
import d.v;
import d.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bvf;>;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "MENU_ID_UNFOLLOW", "feedHeadBarStyle", "getFeedHeadBarStyle", "()I", "setFeedHeadBarStyle", "(I)V", "hideSelfTipsRunnable", "Ljava/lang/Runnable;", "isRealNameLike", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "calculateOpArea", "item", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "checkHideLikeTips", "tipsView", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkShowShareSnsLayout", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "formatDesc", "incCount", "id", "descTv", "Landroid/widget/TextView;", "preCount", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "hideOrDimissMoreBtn", "ifShow", "hideSelfFeedLikeTips", "jumpFoldedUI", "feedList", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "jumpRelatedUI", "title", "lastBuffer", "needRefresh", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "likeAvatorAnimator", "likeCount", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "likeLocalFeed", "isPrivate", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onFocusedViewHolder", "isFocused", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "onMediaClick", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshCommentEdu", "refreshExposeLayout", "refreshFavIv", "isFav", "favCount", "refreshFavSimilar", "refreshFeedHeaderBar", "refreshFoldedLayout", "refreshFollowState", "refreshHeaderFooterWording", "refreshLocalAwesomeIv", "refreshOpLayout", "refreshPrivateIcon", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setNicknameCalculateWidth", "shareFeed", "showOrDimissSelfFeedLikeTips", "isBind", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "showPrivateFeedLikeTips", "isPrivateClick", "showSelfFeedLikeTips", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class h<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.b<T>
{
  public static final a rMK = new a((byte)0);
  final int duh;
  private final int rMA;
  private final int rMB;
  private final int rMC;
  private int rMD;
  private final HashSet<b<T>> rME;
  private Runnable rMF;
  private final FinderFeedConvert.uiLifecycleObserver.1 rMG;
  private final boolean rMH;
  private final com.tencent.mm.plugin.finder.feed.h rMI;
  protected boolean rMJ;
  private Rect rect;
  Dialog tipDialog;
  
  public h(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    this.rMI = paramh;
    this.rMJ = paramBoolean;
    this.duh = paramInt;
    this.rMA = 10000;
    this.rMB = 10001;
    this.rMC = 10002;
    paramh = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.rMD = ((Number)com.tencent.mm.plugin.finder.storage.b.cIi().value()).intValue();
    this.rME = new HashSet();
    this.rMG = new FinderFeedConvert.uiLifecycleObserver.1(this);
    paramh = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGL().value()).intValue() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.rMH = paramBoolean;
      this.rect = new Rect();
      return;
    }
  }
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, BaseFinderFeed paramBaseFinderFeed)
  {
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.j(paramBaseFinderFeed.contact)) {
      if (!paramBoolean1) {}
    }
    do
    {
      return 2131691596;
      return 2131691597;
      if (!paramBoolean1) {
        break;
      }
    } while (paramBoolean2);
    return 2131690326;
    return 2131690330;
  }
  
  private static void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt2 + ')';
    StringBuilder localStringBuilder = new StringBuilder(parame.getContext().getString(2131766491, new Object[] { String.valueOf(paramInt1 + paramInt2) }));
    paramInt1 = localStringBuilder.length();
    localStringBuilder.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)localStringBuilder);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parame.getResources().getColor(2131099803)), paramInt1, localStringBuilder.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.p.h(parame, "holder");
    parame.kA(2131300208, paramInt);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt + ')';
    StringBuilder localStringBuilder = new StringBuilder(parame.getContext().getString(2131766492));
    paramInt = localStringBuilder.length();
    localStringBuilder.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)localStringBuilder);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parame.getResources().getColor(2131099803)), paramInt, localStringBuilder.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private final void a(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    if (this.rMH)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.g.sKi;
      if (!bt.hj((List)com.tencent.mm.plugin.finder.upload.action.g.cKV().n(paramT.feedObject.getFeedObject())))
      {
        parame.kA(2131303868, 8);
        return;
      }
    }
    Object localObject = FinderReporterUIC.tcM;
    localObject = parame.getContext();
    d.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.eY((Context)localObject);
    label82:
    int j;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).rTD;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!com.tencent.mm.sdk.platformtools.i.DEBUG) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)))) {
        break label412;
      }
      parame.kA(2131303868, 8);
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
      parame.kA(2131303860, 8);
      parame.kA(2131303868, 0);
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
      localObject = (TextView)parame.Gd(2131303869);
      d.g.b.p.g(localObject, "reasonTv");
      ((TextView)localObject).setText((CharSequence)k.e(parame.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize()));
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.n());
      return;
      i = 0;
      break label82;
      i = 0;
      break label183;
      break;
    }
    label339:
    ad.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    parame.kA(2131303868, 8);
    return;
    label412:
    parame.kA(2131303868, 8);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.e parame, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.g.cKV().n(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    final int i = com.tencent.mm.plugin.finder.upload.action.g.cKV().m(paramT.feedObject.getFeedObject());
    if ((this.rMH) && (!bt.hj((List)localLinkedList)) && (i > 0) && (!this.rMI.cAz()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.j(paramT.contact)) {}
    }
    else
    {
      ad.i("Finder.FeedConvert", "refreshRealNameRecommendLayout tabType:" + this.duh + ", " + bt.hj((List)localLinkedList) + ", " + i + ' ' + this.rMH);
      paramT = parame.Gd(2131307922);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
    }
    final boolean bool;
    do
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      bool = com.tencent.mm.plugin.finder.utils.p.o(paramT);
      localObject1 = parame.Gd(2131307922);
    } while (localObject1 == null);
    ((View)localObject1).setVisibility(0);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).add(parame.Gd(2131307453));
    ((List)localObject1).add(parame.Gd(2131307455));
    ((List)localObject1).add(parame.Gd(2131307457));
    Object localObject2 = (List)new ArrayList();
    ((List)localObject2).add(parame.Gd(2131307454));
    ((List)localObject2).add(parame.Gd(2131307456));
    ((List)localObject2).add(parame.Gd(2131307458));
    Object localObject3 = new y.a();
    Object localObject4 = new y.a();
    Object localObject5 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    localObject5 = com.tencent.mm.plugin.finder.upload.action.g.cKV().k(paramT.feedObject.getFeedObject());
    ((y.a)localObject3).MLQ = ((Boolean)((d.o)localObject5).first).booleanValue();
    ((y.a)localObject4).MLQ = ((Boolean)((d.o)localObject5).second).booleanValue();
    localObject5 = new y.f();
    ((y.f)localObject5).MLV = ((d.g.a.a)new au((y.a)localObject3, (y.a)localObject4, this, parame, paramT, paramBoolean, localLinkedList, i, bool));
    ((d.g.a.a)new av((List)localObject1, (List)localObject2, (y.f)localObject5, this, parame, paramT, paramBoolean, localLinkedList, i, bool)).invoke();
    localObject4 = (TextView)parame.Gd(2131307924);
    if (localObject4 != null)
    {
      localObject5 = parame.getContext();
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject1 = ((FinderCommentInfo)localLinkedList.get(0)).username;
      if (localObject1 != null) {
        break label766;
      }
      localObject1 = "";
    }
    label766:
    for (;;)
    {
      localObject3 = ((FinderCommentInfo)localLinkedList.get(0)).nickname;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((TextView)localObject4).setText((CharSequence)k.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.p.gx((String)localObject1, (String)localObject2)));
      localObject1 = (TextView)parame.Gd(2131307921);
      int j = paramT.feedObject.getFeedObject().incFriendLikeCount;
      if (i == 1) {
        if ((j > 0) && (bool))
        {
          d.g.b.p.g(localObject1, "descTv");
          a(j, parame, (TextView)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = parame.Gd(2131307923);
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new aw(this, parame, paramT, paramBoolean, localLinkedList, i, bool));
        return;
        d.g.b.p.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766492));
        continue;
        if ((j > 0) && (bool))
        {
          d.g.b.p.g(localObject1, "descTv");
          a(i - j, j, parame, (TextView)localObject1);
        }
        else
        {
          d.g.b.p.g(localObject1, "descTv");
          ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766491, new Object[] { String.valueOf(i).toString() }));
        }
      }
    }
  }
  
  private static void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject = (WeImageView)parame.Gd(2131300888);
    int i;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        d.g.b.p.g(localObject, "awesomeIv");
        ((WeImageView)localObject).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, paramBaseFinderFeed);
        paramBaseFinderFeed = parame.getContext();
        d.g.b.p.g(paramBaseFinderFeed, "holder.context");
        paramBaseFinderFeed = new d.o(Integer.valueOf(i), Integer.valueOf(paramBaseFinderFeed.getResources().getColor(2131099809)));
        label85:
        i = ((Number)paramBaseFinderFeed.first).intValue();
        int j = ((Number)paramBaseFinderFeed.second).intValue();
        ((WeImageView)localObject).setImageResource(i);
        ((WeImageView)localObject).setIconColor(j);
        localObject = (TextView)parame.Gd(2131301416);
        if (paramInt <= 0) {
          break label272;
        }
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.h.fR(2, paramInt);
        d.g.b.p.g(paramBaseFinderFeed, "FinderFormatUtil.formatN…cene.SCENE_WX, likeCount)");
        d.g.b.p.g(localObject, "likeTv");
        al.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText((CharSequence)paramBaseFinderFeed);
      return;
      d.g.b.p.g(localObject, "awesomeIv");
      ((WeImageView)localObject).setTag(Integer.valueOf(1));
      break;
      d.g.b.p.g(localObject, "awesomeIv");
      ((WeImageView)localObject).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, paramBaseFinderFeed);
      paramBaseFinderFeed = parame.getContext();
      d.g.b.p.g(paramBaseFinderFeed, "holder.context");
      paramBaseFinderFeed = new d.o(Integer.valueOf(i), Integer.valueOf(paramBaseFinderFeed.getResources().getColor(2131100018)));
      break label85;
      label272:
      paramBaseFinderFeed = parame.getContext().getString(2131766760);
      d.g.b.p.g(paramBaseFinderFeed, "holder.context.getString…g.finder_like_count_text)");
      d.g.b.p.g(localObject, "likeTv");
      al.b((Paint)((TextView)localObject).getPaint());
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, LinkedList<bvf> paramLinkedList, long paramLong)
  {
    d.g.b.p.h(paramFinderMediaBanner, "banner");
    d.g.b.p.h(paramLinkedList, "mediaList");
    if (j.jd((List)paramLinkedList) == null)
    {
      ad.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject = (bvf)paramLinkedList.getFirst();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    paramLinkedList = (LinkedList<bvf>)localObject;
    label77:
    if (localIterator.hasNext())
    {
      localObject = (bvf)localIterator.next();
      float f = ((bvf)localObject).height * 1.0F / ((bvf)localObject).width;
      if (paramLinkedList.height * 1.0F / paramLinkedList.width >= f) {
        break label290;
      }
      paramLinkedList = (LinkedList<bvf>)localObject;
    }
    label290:
    for (;;)
    {
      break label77;
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      d.g.b.p.g(paramLinkedList, "maxRadioMedia");
      localObject = paramFinderMediaBanner.getPagerView().getLayoutParams();
      d.g.b.p.g(localObject, "banner.pagerView.layoutParams");
      paramFinderMediaBanner = (View)paramFinderMediaBanner;
      d.g.b.p.h(paramLinkedList, "mediaObj");
      d.g.b.p.h(localObject, "params");
      d.g.b.p.h(paramFinderMediaBanner, "view");
      int i = ((ViewGroup.LayoutParams)localObject).height;
      int j = ((ViewGroup.LayoutParams)localObject).width;
      paramLinkedList = com.tencent.mm.plugin.finder.utils.p.fS((int)paramLinkedList.width, (int)paramLinkedList.height);
      ((ViewGroup.LayoutParams)localObject).width = paramLinkedList.getInt("media_layout_width", 0);
      ((ViewGroup.LayoutParams)localObject).height = paramLinkedList.getInt("media_layout_height", 0);
      ImageView.ScaleType.values();
      paramLinkedList.getInt("media_layout_sale_type", ImageView.ScaleType.CENTER_CROP.ordinal());
      if ((i == ((ViewGroup.LayoutParams)localObject).height) && (j == ((ViewGroup.LayoutParams)localObject).width)) {
        break;
      }
      paramFinderMediaBanner.requestLayout();
      return;
    }
  }
  
  private static void a(com.tencent.mm.view.recyclerview.e parame)
  {
    parame.auu.performHapticFeedback(0, 3);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.e parame, int paramInt, boolean paramBoolean)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parame.fQC();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.cKV().k(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((d.o)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((d.o)localObject1).second).booleanValue();
    Object localObject2;
    Object localObject3;
    Context localContext;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label602;
      }
      localObject1 = parame.Gd(2131300888);
      localObject2 = (ImageView)parame.Gd(2131301417);
      if (localObject2 != null)
      {
        if (!paramBoolean)
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {
            break label483;
          }
        }
        localObject3 = parame.getContext();
        localContext = parame.getContext();
        d.g.b.p.g(localContext, "holder.context");
        ((ImageView)localObject2).setImageDrawable(ao.k((Context)localObject3, 2131691596, localContext.getResources().getColor(2131099809)));
        label159:
        localObject3 = com.tencent.mm.plugin.finder.view.animation.c.sXx;
        com.tencent.mm.plugin.finder.view.animation.c.ek((View)localObject2);
        localObject2 = com.tencent.mm.plugin.finder.view.animation.c.sXx;
        d.g.b.p.g(localObject1, "likeIcon");
        com.tencent.mm.plugin.finder.view.animation.c.ej((View)localObject1);
      }
      if ((paramInt == 2) || (paramBoolean)) {
        a(parame);
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {
        break label530;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cIb() > 0) {
        a(parame, false);
      }
      label235:
      if (bool1) {
        bool2 = false;
      }
      localObject1 = this.rMI;
      d.g.b.p.g(localBaseFinderFeed, "item");
      ((com.tencent.mm.plugin.finder.feed.h)localObject1).a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.g.cKV().l(localBaseFinderFeed.feedObject.getFeedObject()), parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((com.tencent.mm.plugin.finder.utils.p.o(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label626;
        }
        localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
        ((FinderObject)localObject1).incFriendLikeCount += 1;
      }
      label344:
      a(this, bool1, parame, localBaseFinderFeed);
      localObject1 = new he();
      ((he)localObject1).dtz.id = localBaseFinderFeed.lP();
      ((he)localObject1).dtz.type = 4;
      localObject2 = ((he)localObject1).dtz;
      if ((!bool1) || (!paramBoolean)) {
        break label656;
      }
      paramInt = 2;
    }
    for (;;)
    {
      ((he.a)localObject2).dtC = paramInt;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = FinderReporterUIC.tcM;
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
      parame = FinderReporterUIC.a.eY(parame);
      if (parame != null)
      {
        parame = FinderReporterUIC.b(parame);
        if (parame != null)
        {
          parame = parame.cze();
          if (!bool1) {
            break label671;
          }
          parame.vS(localBaseFinderFeed.lP());
        }
      }
      return;
      bool1 = false;
      break;
      label483:
      localObject3 = parame.getContext();
      localContext = parame.getContext();
      d.g.b.p.g(localContext, "holder.context");
      ((ImageView)localObject2).setImageDrawable(ao.k((Context)localObject3, 2131690326, localContext.getResources().getColor(2131099809)));
      break label159;
      label530:
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cIc() > 0)
        {
          a(parame, true);
          break label235;
        }
      }
      if (paramBoolean) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.eQq().value()).intValue() != 1) {
        break label235;
      }
      localBaseFinderFeed.showCommentEdu = true;
      d.g.b.p.g(localBaseFinderFeed, "item");
      e(parame, localBaseFinderFeed);
      break label235;
      label602:
      localBaseFinderFeed.showCommentEdu = false;
      d.g.b.p.g(localBaseFinderFeed, "item");
      e(parame, localBaseFinderFeed);
      break label235;
      label626:
      if (bool2) {
        break label344;
      }
      localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
      ((FinderObject)localObject1).incFriendLikeCount -= 1;
      break label344;
      label656:
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    label671:
    parame.vT(localBaseFinderFeed.lP());
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    Object localObject = FinderReporterUIC.tcM;
    localObject = parame.getContext();
    d.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.eY((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).rTD;
      localObject = com.tencent.mm.plugin.finder.api.c.rHn;
      bool = c.a.agZ(paramT.feedObject.field_username);
      if (!this.rMJ) {
        break label115;
      }
      parame.kA(2131300192, 8);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < cf.aCK() - 86400000L)) {
        break label293;
      }
      parame.kA(2131303868, 8);
      return;
      i = 0;
      break;
      label115:
      if ((this.duh != 3) && (bool) && (i != 1))
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (!com.tencent.mm.plugin.finder.utils.p.d(paramT))
        {
          parame.kA(2131300192, 0);
          localObject = (TextView)parame.Gd(2131300192);
          d.g.b.p.g(localObject, "followIv");
          Context localContext = ((TextView)localObject).getContext();
          d.g.b.p.g(localContext, "followIv.context");
          ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760230));
          ((TextView)localObject).setTextSize(0, com.tencent.mm.cc.a.ay(((TextView)localObject).getContext(), 2131165284));
          localContext = parame.getContext();
          d.g.b.p.g(localContext, "holder.context");
          ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099734));
          ((TextView)localObject).setBackgroundResource(2131232351);
          continue;
        }
      }
      if ((!bool) || (this.duh == 3)) {
        parame.kA(2131300192, 8);
      }
    }
    label293:
    parame.kA(2131303868, 0);
  }
  
  private static void a(com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    d.g.b.p.h(parame, "holder");
    y.f localf = new y.f();
    localf.MLV = parame.Gd(2131308309);
    if ((View)localf.MLV == null) {
      localf.MLV = ((ViewStub)parame.Gd(2131308310)).inflate();
    }
    Object localObject = (View)localf.MLV;
    d.g.b.p.g(localObject, "tips");
    if (((View)localObject).getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (TextView)((View)localf.MLV).findViewById(2131308308);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parame.getContext().getString(2131767022));
      }
      parame = com.tencent.mm.plugin.finder.storage.b.sxa;
      com.tencent.mm.plugin.finder.storage.b.Fl(com.tencent.mm.plugin.finder.storage.b.cIc() - 1);
    }
    for (;;)
    {
      parame = (View)localf.MLV;
      d.g.b.p.g(parame, "tips");
      parame.setVisibility(0);
      parame = (View)localf.MLV;
      d.g.b.p.g(parame, "tips");
      parame.setAlpha(1.0F);
      ((View)localf.MLV).animate().cancel();
      ((View)localf.MLV).animate().alpha(0.0F).setDuration(300L).setStartDelay(2000L).setListener((Animator.AnimatorListener)new bc(localf)).start();
      return;
      localObject = (TextView)((View)localf.MLV).findViewById(2131308308);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parame.getContext().getString(2131767021));
      }
      parame = com.tencent.mm.plugin.finder.storage.b.sxa;
      com.tencent.mm.plugin.finder.storage.b.Fk(com.tencent.mm.plugin.finder.storage.b.cIb() - 1);
    }
  }
  
  private final void a(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    WeImageView localWeImageView = (WeImageView)parame.Gd(2131307331);
    TextView localTextView = (TextView)parame.Gd(2131307332);
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        parame = new d.o(Integer.valueOf(2131691482), Integer.valueOf(parame.getResources().getColor(2131099778)));
        int i = ((Number)parame.first).intValue();
        int j = ((Number)parame.second).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else if (localTextView != null)
    {
      if (!this.rMI.cAz()) {
        break label210;
      }
      al.a((Paint)localTextView.getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label203;
      }
    }
    label203:
    for (parame = com.tencent.mm.plugin.finder.utils.h.fR(2, paramInt);; parame = "")
    {
      localTextView.setText((CharSequence)parame);
      return;
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
      parame = new d.o(Integer.valueOf(2131691485), Integer.valueOf(parame.getResources().getColor(2131099732)));
      break;
    }
    label210:
    localTextView.setText(2131766747);
  }
  
  private static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.p.h(parame, "holder");
    parame = parame.Gd(2131302457);
    if (paramBoolean)
    {
      d.g.b.p.g(parame, "moreBtn");
      parame.setVisibility(0);
      return;
    }
    d.g.b.p.g(parame, "moreBtn");
    parame.setVisibility(8);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramT, "item");
    final FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)parame.Gd(2131305725);
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    localObject = (FinderHomeTabStateVM)localObject;
    if (((FinderHomeTabStateVM)localObject).sZk)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(locale, "MMKernel.storage()");
      i = locale.ajl().getInt(al.a.IGV, 0);
      if (i >= 3) {
        ((FinderHomeTabStateVM)localObject).sZk = false;
      }
      if (i >= 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((!paramBoolean) || (!paramT.isContentCollapsed)) {
          break;
        }
        parame.auu.postDelayed((Runnable)new ac(paramT, localFinderCollapsibleTextView), 2000L);
      }
      return;
    }
    parame = localFinderCollapsibleTextView.getTipsTv();
    d.g.b.p.g(parame, "collapseTextLayout.tipsTv");
    parame.setVisibility(8);
  }
  
  private void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.e parame, final T paramT, boolean paramBoolean2)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramT, "item");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.cLB())
    {
      paramT = parame.Gd(2131308145);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parame = parame.Gd(2131308110);
      if (parame != null) {
        parame.setVisibility(8);
      }
    }
    do
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.j(paramT.contact)) {
        break;
      }
      paramT = parame.Gd(2131308145);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parame = parame.Gd(2131308110);
    } while (parame == null);
    parame.setVisibility(8);
    return;
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    if ((com.tencent.mm.plugin.finder.utils.p.d(paramT)) && (paramT.showLikeTips) && (!paramT.feedObject.isPostFailed()) && (!paramT.feedObject.isUploadFailed()))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cHe() < 6)
      {
        localObject1 = parame.Gd(2131308110);
        if (localObject1 != null) {
          break label592;
        }
        localObject1 = ((ViewStub)parame.Gd(2131308111)).inflate();
      }
    }
    label592:
    for (;;)
    {
      if (!paramT.feedObject.isPostFinish())
      {
        if (paramBoolean1)
        {
          paramT.showLikeTips = false;
          d.g.b.p.g(localObject1, "tips");
          dZ((View)localObject1);
        }
        for (;;)
        {
          parame = parame.Gd(2131308145);
          if (parame == null) {
            break;
          }
          parame.setVisibility(0);
          return;
          localObject2 = parame.Gd(2131308109);
          d.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cc.a.az(parame.getContext(), 2131766416));
          if (paramBoolean2)
          {
            d.g.b.p.g(localObject1, "tips");
            if (a((View)localObject1, parame))
            {
              paramT.showLikeTips = false;
              continue;
            }
          }
          d.g.b.p.g(localObject1, "tips");
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
          if ((com.tencent.mm.plugin.finder.storage.b.cHe() >= 6) && (((View)localObject1).getVisibility() != 0))
          {
            localObject2 = parame.Gd(2131308145);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = this.rMF;
              if (localObject2 != null) {
                ((View)localObject1).removeCallbacks((Runnable)localObject2);
              }
              this.rMF = ((Runnable)new bd(this, paramT, (View)localObject1));
              ((View)localObject1).postDelayed(this.rMF, 5000L);
            }
          }
        }
      }
      Object localObject2 = parame.Gd(2131308145);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if (paramBoolean1)
      {
        paramT.showLikeTips = false;
        d.g.b.p.g(localObject1, "tips");
        dZ((View)localObject1);
        return;
      }
      localObject2 = parame.Gd(2131308109);
      d.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cc.a.az(parame.getContext(), 2131766416));
      d.g.b.p.g(localObject1, "tips");
      if ((!a((View)localObject1, parame)) || (!paramBoolean2)) {
        break;
      }
      paramT.showLikeTips = false;
      return;
      paramT = parame.Gd(2131308110);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = parame.Gd(2131303504);
      if ((paramT == null) || (paramT.getVisibility() != 0)) {
        break;
      }
      parame = parame.Gd(2131308145);
      if (parame == null) {
        break;
      }
      parame.setVisibility(0);
      return;
    }
  }
  
  private static void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean2)
  {
    WeImageView localWeImageView = (WeImageView)parame.Gd(2131308184);
    Object localObject;
    int i;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        if (localWeImageView != null) {
          localWeImageView.setTag(Integer.valueOf(2));
        }
        localObject = parame.fQC();
        d.g.b.p.g(localObject, "holder.getAssociatedObject()");
        i = a(true, paramBoolean2, (BaseFinderFeed)localObject);
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
      }
    }
    for (parame = new d.o(Integer.valueOf(i), Integer.valueOf(parame.getResources().getColor(2131099809)));; parame = new d.o(Integer.valueOf(i), Integer.valueOf(parame.getResources().getColor(2131100018))))
    {
      i = ((Number)parame.first).intValue();
      int j = ((Number)parame.second).intValue();
      if (localWeImageView != null) {
        localWeImageView.setImageResource(i);
      }
      if (localWeImageView != null) {
        localWeImageView.setIconColor(j);
      }
      return;
      if (localWeImageView == null) {
        break;
      }
      localWeImageView.setTag(Integer.valueOf(1));
      break;
      if (localWeImageView != null) {
        localWeImageView.setTag(Integer.valueOf(0));
      }
      localObject = parame.fQC();
      d.g.b.p.g(localObject, "holder.getAssociatedObject()");
      i = a(false, paramBoolean2, (BaseFinderFeed)localObject);
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
    }
  }
  
  private final boolean a(View paramView, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject = parame.getRecyclerView();
    d.g.b.p.g(localObject, "holder.recyclerView");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      if ((localObject instanceof LinearLayoutManager)) {}
      while (localObject != null) {
        if (localObject == null)
        {
          throw new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          localObject = null;
        }
        else
        {
          int j = ((LinearLayoutManager)localObject).km();
          int k = ((LinearLayoutManager)localObject).ko();
          localObject = parame.getRecyclerView();
          d.g.b.p.g(localObject, "holder.recyclerView");
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            if (localObject == null) {
              throw new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            }
            localObject = (com.tencent.mm.view.recyclerview.d)localObject;
          }
          for (int i = parame.lM() - ((com.tencent.mm.view.recyclerview.d)localObject).Lvi.size(); (j < k) && (i >= 0) && ((i < j) || (i > k)); i = -1)
          {
            dZ(paramView);
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
      bvf localbvf = (bvf)localIterator.next();
      if (localbvf.mediaType <= 0) {
        localbvf.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  private final void b(final T paramT, final com.tencent.mm.view.recyclerview.e parame)
  {
    ad.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + parame.lN());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)parame.Gd(2131298523);
    d.g.b.p.g(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((d.g.a.m)new ae(this, parame, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((d.g.a.m)new af(this, parame, paramT));
    Object localObject = parame.auu;
    d.g.b.p.g(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (d.g.a.m)new ag(this, paramT));
    if (bt.hj((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)parame.Gd(2131304549);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.aiX(paramT.feedObject.field_username)) {
        break label378;
      }
      d.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ao.k(((ImageView)localObject).getContext(), 2131690331, com.tencent.mm.cc.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
    for (;;)
    {
      paramT = parame.Gd(2131304548);
      paramT.setOnClickListener((View.OnClickListener)new ah(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      d.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ao.k(((ImageView)localObject).getContext(), 2131690547, com.tencent.mm.cc.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
  }
  
  private final void b(final T paramT, final com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (!com.tencent.mm.plugin.finder.utils.p.d(paramT))
    {
      a(0, parame);
      paramT = parame.Gd(2131303506);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, parame);
      return;
    }
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = parame.Gd(2131303506);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, parame);
      b(paramT, parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.o.sMi;
      localObject2 = paramT.feedObject.getDescriptionFullSpan();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new SpannableString((CharSequence)"");
      }
      com.tencent.mm.plugin.finder.utils.o.a((SpannableString)localObject1, true);
      if (paramBoolean) {
        ((FinderCollapsibleTextView)parame.Gd(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
      }
      a(true, parame);
      return;
    }
    localObject1 = parame.Gd(2131303506);
    Object localObject3;
    View localView1;
    if (localObject1 == null)
    {
      localObject3 = (h)this;
      localObject2 = ((ViewStub)parame.Gd(2131303507)).inflate();
      localView1 = ((View)localObject2).findViewById(2131300054);
      localObject1 = localObject2;
      if (localView1 != null)
      {
        localView1.setOnTouchListener((View.OnTouchListener)new am((h)localObject3, parame));
        localView1.setOnClickListener((View.OnClickListener)new an((h)localObject3, parame));
        localView1.setOnLongClickListener((View.OnLongClickListener)new ao((h)localObject3, parame));
        localView1.setHapticFeedbackEnabled(false);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = (FinderPostProgressView)((View)localObject1).findViewById(2131303505);
      localView1 = ((View)localObject1).findViewById(2131303504);
      View localView2 = ((View)localObject1).findViewById(2131303466);
      localObject3 = (TextView)((View)localObject1).findViewById(2131303467);
      d.g.b.p.g(localObject1, "container");
      ((View)localObject1).setVisibility(0);
      a(8, parame);
      parame.kA(2131303503, 0);
      a(false, parame);
      boolean bool;
      if ((paramT.feedObject.isPostFailed()) || (paramT.feedObject.isUploadFailed()))
      {
        d.g.b.p.g(localView2, "failedArea");
        localView2.setVisibility(0);
        d.g.b.p.g(localView1, "progressArea");
        localView1.setVisibility(8);
        if (!paramT.feedObject.isPostFailedCanRetry())
        {
          parame.kA(2131303503, 8);
          localObject1 = parame.Gd(2131308110);
          if (localObject1 == null) {
            break label782;
          }
          ((View)localObject1).setVisibility(8);
          bool = false;
        }
      }
      for (;;)
      {
        parame.Gd(2131308082).setOnClickListener((View.OnClickListener)new ar(this, paramT));
        localObject1 = parame.Gd(2131308083);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        parame.Gd(2131303502).setOnClickListener((View.OnClickListener)new as(this, paramT));
        parame.Gd(2131303503).setOnClickListener((View.OnClickListener)new at(paramT));
        localObject1 = com.tencent.mm.plugin.finder.utils.o.sMi;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        com.tencent.mm.plugin.finder.utils.o.a((SpannableString)localObject1, bool);
        if (paramBoolean) {
          ((FinderCollapsibleTextView)parame.Gd(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
        }
        ad.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool);
        return;
        if (paramT.feedObject.isPostNoAuth())
        {
          d.g.b.p.g(localObject3, "failedTv");
          localObject1 = parame.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(2131759305)));
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)new ap(this));
          break;
        }
        d.g.b.p.g(localObject3, "failedTv");
        localObject1 = parame.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(2131759304));
        break;
        label782:
        bool = false;
        continue;
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().GPz >= 100))
        {
          d.g.b.p.g(localView2, "failedArea");
          localView2.setVisibility(8);
          d.g.b.p.g(localView1, "progressArea");
          localView1.setVisibility(8);
          ((View)localObject1).setVisibility(8);
          a(0, parame);
          a(true, parame);
          bool = true;
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sKi;
          a(this, ((Boolean)com.tencent.mm.plugin.finder.upload.action.g.cKV().xm(paramT.feedObject.getLocalId()).first).booleanValue(), parame, paramT);
          d.g.b.p.g(localView2, "failedArea");
          localView2.setVisibility(8);
          d.g.b.p.g(localView1, "progressArea");
          localView1.setVisibility(0);
          localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().GPz });
          ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new aq((FinderPostProgressView)localObject2));
          localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
          if (localObject3 != null) {
            ((ValueAnimator)localObject3).start();
          }
          parame.setTag(localObject1);
          ad.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().GPz);
          bool = false;
        }
      }
    }
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.e parame, final T paramT)
  {
    final boolean bool = true;
    final com.tencent.mm.plugin.finder.storage.h localh = paramT.attachFavInfo;
    Object localObject;
    if ((localh != null) && ((this.duh == 3) || (this.duh == 1) || (this.duh == 4)))
    {
      FinderBubbleLayout localFinderBubbleLayout = (FinderBubbleLayout)parame.Gd(2131308304);
      d.g.b.p.g(localFinderBubbleLayout, "layout");
      if (localFinderBubbleLayout.getTag() == null)
      {
        localObject = parame.getContext();
        d.g.b.p.g(localObject, "holder.context");
        localFinderBubbleLayout.setTopViewMargin$255f295((int)((Context)localObject).getResources().getDimension(2131165292));
        localFinderBubbleLayout.setContent(2131496361);
        localObject = parame.getContext();
        d.g.b.p.g(localObject, "holder.context");
        localFinderBubbleLayout.setBubbleColor(((Context)localObject).getResources().getColor(2131099682));
        localFinderBubbleLayout.setTag(Boolean.TRUE);
      }
      TextView localTextView = (TextView)parame.Gd(2131308305);
      final List localList = localh.cIr();
      if (localh.sxQ == null)
      {
        if (!bt.isNullOrNil(localh.dxD)) {
          break label244;
        }
        localObject = parame.getContext().getString(2131766973);
        label192:
        if (localTextView != null) {
          localTextView.setText((CharSequence)localObject);
        }
        localFinderBubbleLayout.setVisibility(0);
        localFinderBubbleLayout.setOnClickListener((View.OnClickListener)new ai(this, (String)localObject, localList, paramT, parame, localh, bool));
      }
    }
    label244:
    do
    {
      return;
      bool = false;
      break;
      localObject = localh.dxD;
      break label192;
      parame = parame.Gd(2131308304);
      if (parame != null) {
        parame.setOnClickListener(null);
      }
    } while (parame == null);
    parame.setVisibility(8);
  }
  
  private final void c(final T paramT, final com.tencent.mm.view.recyclerview.e parame)
  {
    if (this.rMI.cAz())
    {
      parame.kA(2131300205, 8);
      parame.kA(2131304551, 0);
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((((Boolean)com.tencent.mm.plugin.finder.storage.b.cHZ().value()).booleanValue()) && (paramT.feedObject.field_id % 2L == 0L))
      {
        if ((!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sLm, "zh_CN")) && (!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sLm, "zh_HK")) && (!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sLm, "zh_TW"))) {
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
        localObject = parame.Gd(2131304558);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getReadCount()));
        localObject = parame.Gd(2131304552);
        d.g.b.p.g(localObject, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getForwardCount()));
        localObject = parame.Gd(2131304553);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_like_count_tv)");
        localObject = (TextView)localObject;
        g.a locala = com.tencent.mm.plugin.finder.upload.action.g.sKi;
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(com.tencent.mm.plugin.finder.upload.action.g.cKV().l(paramT.feedObject.getFeedObject())));
        localObject = parame.Gd(2131304550);
        d.g.b.p.g(localObject, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getCommentCount()));
        localObject = parame.Gd(2131307971);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getFavCount()));
        parame.Gd(2131307972).setOnClickListener((View.OnClickListener)new ak(parame, paramT));
        parame.Gd(2131307974).setOnClickListener((View.OnClickListener)new al(this, parame));
        parame.kA(2131298523, 0);
        parame.kA(2131306206, 0);
        parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.h.f(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        localObject = parame.getContext();
        d.g.b.p.g(localObject, "holder.context");
        float f = ((Context)localObject).getResources().getDimensionPixelSize(2131165257);
        ((TextView)parame.Gd(2131304558)).setTextSize(0, f);
        ((TextView)parame.Gd(2131304552)).setTextSize(0, f);
        ((TextView)parame.Gd(2131304553)).setTextSize(0, f);
        ((TextView)parame.Gd(2131304550)).setTextSize(0, f);
        ((TextView)parame.Gd(2131307971)).setTextSize(0, f);
        d(paramT, parame);
        return;
        label558:
        paramT.feedObject.setReadCount(999);
        paramT.feedObject.setForwardCount(1000);
        paramT.feedObject.setLikeCount(1000000);
        paramT.feedObject.setCommentCount(990000000);
        paramT.feedObject.setFavCount(1200000000);
      }
    }
    parame.kA(2131300205, 0);
    parame.kA(2131304551, 8);
    Object localObject = com.tencent.mm.plugin.finder.upload.action.c.sJS;
    boolean bool1 = com.tencent.mm.plugin.finder.upload.action.c.cKT().i(paramT.feedObject.getFeedObject());
    localObject = com.tencent.mm.plugin.finder.upload.action.c.sJS;
    a(bool1, com.tencent.mm.plugin.finder.upload.action.c.cKT().j(paramT.feedObject.getFeedObject()), parame);
    localObject = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    localObject = com.tencent.mm.plugin.finder.upload.action.g.cKV().k(paramT.feedObject.getFeedObject());
    bool1 = ((Boolean)((d.o)localObject).first).booleanValue();
    boolean bool2 = ((Boolean)((d.o)localObject).second).booleanValue();
    localObject = com.tencent.mm.plugin.finder.upload.action.g.sKi;
    a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.g.cKV().l(paramT.feedObject.getFeedObject()), parame);
  }
  
  private static void d(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    View localView = parame.Gd(2131304558);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_read_count_tv)");
    float f1 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getReadCount()));
    localView = parame.Gd(2131304552);
    d.g.b.p.g(localView, "holder.getView<TextView>…id.self_forward_count_tv)");
    float f2 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getForwardCount()));
    localView = parame.Gd(2131304553);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_like_count_tv)");
    float f3 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getLikeCount()));
    localView = parame.Gd(2131304550);
    d.g.b.p.g(localView, "holder.getView<TextView>…id.self_comment_count_tv)");
    float f4 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getCommentCount()));
    localView = parame.Gd(2131307971);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_fav_count_tv)");
    float f5 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.FI(paramT.feedObject.getFavCount()));
    paramT = parame.getContext();
    d.g.b.p.g(paramT, "holder.context");
    float f6 = paramT.getResources().getDimensionPixelSize(2131165292);
    paramT = parame.getContext();
    d.g.b.p.g(paramT, "holder.context");
    int i = paramT.getResources().getDimensionPixelSize(2131165278);
    int j = com.tencent.mm.cc.a.ip(aj.getContext());
    f1 = f5 + 1.0F + (f1 + 1.0F + (f2 + 1.0F) + (f3 + 1.0F) + (f4 + 1.0F)) + f6 * 5.0F + i;
    ad.d("Finder.FeedConvert", "contentWidthSum : " + f1 + " ,screenWidth : " + j);
    localView = parame.Gd(2131308418);
    paramT = parame.Gd(2131308417);
    d.g.b.p.g(paramT, "holder.getView<LinearLay…ter_op_layout_first_line)");
    paramT = (LinearLayout)paramT;
    parame = parame.Gd(2131308419);
    d.g.b.p.g(parame, "holder.getView<LinearLay…er_op_layout_second_line)");
    parame = (LinearLayout)parame;
    if (f1 < j) {
      parame.setVisibility(8);
    }
    for (;;)
    {
      d.g.b.p.g(localView, "rightPart");
      parame = localView.getParent();
      if (parame != null) {
        break;
      }
      throw new v("null cannot be cast to non-null type android.widget.LinearLayout");
      parame.setVisibility(0);
      paramT = parame;
    }
    ((LinearLayout)parame).removeView(localView);
    paramT.addView(localView);
  }
  
  private final void dZ(View paramView)
  {
    paramView.setVisibility(8);
    Runnable localRunnable = this.rMF;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      this.rMF = null;
    }
  }
  
  private final void e(com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    View localView = parame.Gd(2131302586);
    if (paramT.showCommentEdu)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.eQq().value()).intValue() == 1)
      {
        d.g.b.p.g(localView, "layout");
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new h.bf(this, parame, paramT));
        return;
      }
    }
    d.g.b.p.g(localView, "layout");
    localView.setVisibility(8);
  }
  
  public com.tencent.mm.bx.b a(T paramT)
  {
    d.g.b.p.h(paramT, "item");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.eQo().value()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.o(paramT)) {
        return paramT.likeBuffer;
      }
      return null;
    }
    return paramT.likeBuffer;
  }
  
  public void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    Object localObject1 = (View.OnClickListener)new ab(parame);
    Object localObject2 = parame.Gd(2131300205);
    paramRecyclerView = new y.f();
    paramRecyclerView.MLV = new ah((View)localObject2);
    d.g.b.p.g(localObject2, "footerTouchDelegateView");
    ((View)localObject2).setTouchDelegate((TouchDelegate)paramRecyclerView.MLV);
    localObject2 = (ImageView)parame.Gd(2131297008);
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    ((ImageView)localObject2).post((Runnable)new h.o((ImageView)localObject2));
    localObject2 = (TextView)parame.Gd(2131302863);
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    d.g.b.p.g(localObject2, "nickTv");
    al.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
    localObject1 = parame.getContext();
    d.g.b.p.g(localObject1, "holder.context");
    ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131100021));
    localObject1 = (WeImageView)parame.Gd(2131302457);
    localObject2 = parame.getContext();
    d.g.b.p.g(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100018));
    localObject1 = (HardTouchableLayout)parame.Gd(2131302206);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new t());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new m((HardTouchableLayout)localObject1, this, parame));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new n((HardTouchableLayout)localObject1, this, parame));
      localObject2 = ((HardTouchableLayout)localObject1).getContext();
      d.g.b.p.g(localObject2, "mediaContainer.context");
      paramInt = (int)((Context)localObject2).getResources().getDimension(2131165300);
      if (this.rMD != 0) {
        break label928;
      }
      localObject1 = ((HardTouchableLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)localObject1).topMargin = paramInt;
      localObject1 = parame.Gd(2131308303);
      d.g.b.p.g(localObject1, "it");
      ((View)localObject1).setBackground(null);
      ((View)localObject1).setTag(Boolean.FALSE);
    }
    for (;;)
    {
      localObject1 = new y.f();
      ((y.f)localObject1).MLV = parame.Gd(2131297023);
      ((View)((y.f)localObject1).MLV).setOnTouchListener((View.OnTouchListener)new u(this, parame));
      ((View)((y.f)localObject1).MLV).setOnClickListener((View.OnClickListener)new v(this, parame));
      ((View)((y.f)localObject1).MLV).setOnLongClickListener((View.OnLongClickListener)new w(this, parame));
      ((View)((y.f)localObject1).MLV).setHapticFeedbackEnabled(false);
      ((View)((y.f)localObject1).MLV).post((Runnable)new h.x((y.f)localObject1, parame, paramRecyclerView));
      localObject1 = new y.f();
      ((y.f)localObject1).MLV = parame.Gd(2131298522);
      ((View)((y.f)localObject1).MLV).post((Runnable)new h.y((y.f)localObject1, parame, paramRecyclerView));
      localObject1 = (FinderCollapsibleTextView)parame.Gd(2131305725);
      ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g(((FinderCollapsibleTextView)localObject1).getContentTextView(), new com.tencent.mm.pluginsdk.ui.span.n(parame.getContext())));
      localObject1 = new y.f();
      ((y.f)localObject1).MLV = parame.Gd(2131307333);
      localObject2 = (View)((y.f)localObject1).MLV;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new z(this, parame));
      }
      localObject2 = (View)((y.f)localObject1).MLV;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new h.aa(parame, (y.f)localObject1, paramRecyclerView));
      }
      localObject1 = new y.f();
      ((y.f)localObject1).MLV = parame.Gd(2131307979);
      localObject2 = (View)((y.f)localObject1).MLV;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new p(this, parame));
      }
      localObject2 = (View)((y.f)localObject1).MLV;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new h.q(parame, (y.f)localObject1, paramRecyclerView));
      }
      parame.Gd(2131302457).setOnLongClickListener((View.OnLongClickListener)new r(parame));
      paramRecyclerView = parame.Gd(2131298523);
      d.g.b.p.g(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
      paramRecyclerView.setClickable(false);
      paramRecyclerView = new b(this, parame);
      parame.auu.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
      paramRecyclerView.alive();
      this.rME.add(paramRecyclerView);
      paramRecyclerView = FinderReporterUIC.tcM;
      paramRecyclerView = parame.getContext();
      d.g.b.p.g(paramRecyclerView, "holder.context");
      paramRecyclerView = FinderReporterUIC.a.eY(paramRecyclerView);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = FinderReporterUIC.a(paramRecyclerView);
        if (paramRecyclerView != null) {
          paramRecyclerView.a((com.tencent.mm.plugin.finder.event.base.d)new s(this, parame));
        }
      }
      return;
      label928:
      if (this.rMD == 1)
      {
        localObject2 = ((HardTouchableLayout)localObject1).getLayoutParams();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        localObject2 = parame.Gd(2131308303);
        d.g.b.p.g(localObject2, "it");
        ((View)localObject2).setBackground(((HardTouchableLayout)localObject1).getResources().getDrawable(2131235046));
        ((View)localObject2).setTag(Boolean.TRUE);
      }
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.e parame, View paramView)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramView, "view");
    Object localObject = (BaseFinderFeed)parame.fQC();
    if (!((BaseFinderFeed)localObject).feedObject.isPostFinish()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.rMI.cAz());
      paramView = com.tencent.mm.plugin.finder.upload.action.g.sKi;
      paramView = com.tencent.mm.plugin.finder.upload.action.g.cKV().k(((BaseFinderFeed)localObject).feedObject.getFeedObject());
      bool1 = ((Boolean)paramView.first).booleanValue();
      bool2 = ((Boolean)paramView.second).booleanValue();
    } while ((bool1) && (bool2));
    if (bool1)
    {
      paramView = (ImageView)parame.Gd(2131301417);
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.j(((BaseFinderFeed)localObject).contact))
      {
        localObject = parame.getContext();
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        paramView.setImageDrawable(ao.k((Context)localObject, 2131691596, parame.getResources().getColor(2131099809)));
      }
      for (;;)
      {
        parame = com.tencent.mm.plugin.finder.view.animation.c.sXx;
        d.g.b.p.g(paramView, "likeIconBanner");
        com.tencent.mm.plugin.finder.view.animation.c.ek((View)paramView);
        return;
        localObject = parame.getContext();
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        paramView.setImageDrawable(ao.k((Context)localObject, 2131690326, parame.getResources().getColor(2131099809)));
      }
    }
    a(parame, 2, false);
  }
  
  public void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramView, "view");
    d.g.b.p.h(paramFinderObject, "finderObj");
  }
  
  public void a(final com.tencent.mm.view.recyclerview.e parame, final T paramT, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramT, "item");
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      paramInt1 = 1;
    }
    while (paramInt1 == 0)
    {
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject1 = paramList.next();
          if ((localObject1 instanceof d.o)) {
            switch (((Number)((d.o)localObject1).first).intValue())
            {
            default: 
              break;
            case 1: 
              b(paramT, parame);
            case 6: 
              return;
              paramInt1 = 0;
              break;
            case 2: 
              b(paramT, parame, false);
              return;
            case 3: 
              paramList = com.tencent.mm.plugin.finder.upload.action.g.sKi;
              paramList = com.tencent.mm.plugin.finder.upload.action.g.cKV().k(paramT.feedObject.getFeedObject());
              paramBoolean = ((Boolean)paramList.first).booleanValue();
              ((Boolean)paramList.second).booleanValue();
              if (!paramBoolean) {
                a(this, false, parame, paramT);
              }
              c(paramT, parame);
              a(paramT, parame);
              a(paramT, parame, true);
              return;
            case 4: 
              paramList = com.tencent.mm.plugin.finder.upload.action.c.sJS;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.c.cKT().i(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.c.sJS;
              a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.c.cKT().j(paramT.feedObject.getFeedObject()), parame);
              return;
            case 5: 
              b(parame, paramT);
              return;
            }
          }
        }
      }
    }
    paramList = parame.Gd(2131301417);
    d.g.b.p.g(paramList, "holder.getView<View>(R.id.like_icon)");
    paramList.setVisibility(8);
    parame.Gd(2131302457).setOnClickListener((View.OnClickListener)new k(this, parame));
    paramT.feedObject.getTopicClickExtra().aWN = new WeakReference(parame.getContext());
    label464:
    Object localObject2;
    label524:
    label553:
    label576:
    Object localObject3;
    if (!this.rMI.cAz())
    {
      paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.s(paramT.feedObject.getFeedObject())) {}
    }
    else
    {
      parame.kA(2131306206, 0);
      parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.h.v(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      b(paramT);
      parame.kA(2131296976, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label1746;
        }
        paramInt1 = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject1 = parame.Gd(2131296977);
        d.g.b.p.g(localObject1, "holder.getView<ImageView>(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject1, paramList.field_authInfo);
      }
      switch (paramInt1)
      {
      default: 
        if (!paramBoolean) {
          c(parame, paramT);
        }
        paramList = paramT.contact;
        if (paramList != null)
        {
          paramList = paramList.getUsername();
          if (paramList != null)
          {
            localObject1 = paramT.contact;
            if (localObject1 == null) {
              break label1856;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).cxL();
            localObject1 = bt.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.c.rHn;
            localObject2 = c.a.agW(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).cxL())) {
                paramList = ((com.tencent.mm.plugin.finder.api.g)localObject2).cxL();
              }
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
            localObject1 = com.tencent.mm.plugin.finder.loader.i.cCC();
            paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
            localObject2 = parame.Gd(2131297008);
            d.g.b.p.g(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.i.sja;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
          }
          if (paramBoolean) {
            break label3199;
          }
          paramList = parame.Gd(2131298775);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label1862;
          }
          paramInt1 = 1;
          label725:
          if (paramInt1 == 0) {
            break label1872;
          }
          parame.kA(2131305725, 8);
          if (paramList == null) {
            break label1867;
          }
          localObject1 = paramList.getContext();
          d.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramInt1 = 0;
          label795:
          paramList = parame.Gd(2131307449);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          paramList = parame.Gd(2131307449);
          if (paramList != null) {
            paramList.setAlpha(1.0F);
          }
          localObject1 = paramT.feedObject.getFoldedLayout();
          if (localObject1 != null)
          {
            if ((((amx)localObject1).sUo != 1) || (this.rMH)) {
              break label2071;
            }
            paramList = parame.Gd(2131307449);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
          }
          label887:
          b(parame, paramT);
          paramList = parame.Gd(2131308309);
          paramInt2 = paramInt1;
          if (paramList != null) {
            paramList.setVisibility(8);
          }
        }
        break;
      }
    }
    label934:
    label976:
    label1010:
    label2551:
    label3196:
    label3199:
    for (paramInt2 = paramInt1;; paramInt2 = 0)
    {
      b(paramT, parame);
      Object localObject4;
      float f;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        b(paramT, parame, paramBoolean);
        if (bt.isNullOrNil(paramT.headerWording)) {
          break label2584;
        }
        parame.kA(2131300730, 0);
        parame.d(2131300729, (CharSequence)paramT.headerWording);
        if (bt.isNullOrNil(paramT.footerWording)) {
          break label2597;
        }
        parame.kA(2131300213, 0);
        parame.d(2131300211, (CharSequence)paramT.footerWording);
        a(parame, paramT);
        d.g.b.p.h(parame, "holder");
        ((TextView)parame.Gd(2131302863)).post((Runnable)new ax(parame));
        a(paramT, parame);
        e(parame, paramT);
        a(paramT, parame, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.g.sKi;
        paramList = com.tencent.mm.plugin.finder.upload.action.g.cKV().xm(paramT.feedObject.getLocalId());
        a(((Boolean)paramList.first).booleanValue(), parame, ((Boolean)paramList.second).booleanValue());
        paramList = com.tencent.mm.plugin.finder.upload.action.g.sKi;
        a(((Boolean)com.tencent.mm.plugin.finder.upload.action.g.cKV().k(paramT.feedObject.getFeedObject()).first).booleanValue(), parame, paramT, true);
        paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
        if ((!com.tencent.mm.plugin.finder.utils.p.d(paramT)) || (!paramT.showShareSns)) {
          break label2650;
        }
        if (paramT.feedObject.isPostFinish()) {
          break label2610;
        }
        paramList = parame.Gd(2131308421);
        if (paramList != null)
        {
          paramList.setVisibility(0);
          paramList.setOnClickListener((View.OnClickListener)new c(parame));
        }
        localObject2 = paramT.feedObject.getLocation();
        paramList = parame.Gd(2131303355);
        localObject1 = (TextView)parame.Gd(2131303336);
        localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.gy(((aoy)localObject2).ePv, ((aoy)localObject2).jDf);
        if (!bt.isNullOrNil((String)localObject2)) {
          break label2674;
        }
        d.g.b.p.g(paramList, "positionLayout");
        paramList.setVisibility(8);
        paramList = parame.Gd(2131301435);
        d.g.b.p.g(paramList, "linkLayout");
        paramList.setVisibility(8);
        localObject1 = paramT.feedObject.getExtReading();
        if ((!bt.isNullOrNil(((amn)localObject1).link)) && (!bt.isNullOrNil(((amn)localObject1).title)))
        {
          localObject2 = ((amn)localObject1).link;
          localObject3 = ((amn)localObject1).title;
          localObject4 = (TextView)parame.Gd(2131301436);
          parame.d(2131301436, (CharSequence)localObject3);
          ad.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((amn)localObject1).title);
          paramList.post((Runnable)new i((TextView)localObject4, (String)localObject3, parame, paramList, paramT));
          paramList.setVisibility(0);
          ((TextView)localObject4).setOnClickListener((View.OnClickListener)new j((String)localObject2, parame, paramList, paramT));
        }
        localObject1 = parame.Gd(2131303869);
        paramList = parame.Gd(2131298523);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
        {
          localObject1 = paramList.getContext();
          d.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
        }
        c(paramT, parame);
        paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.d(paramT)) {
          break label2754;
        }
        paramT = parame.Gd(2131308375);
        if (paramT != null) {
          paramT.setVisibility(8);
        }
        localObject2 = (FinderMediaBanner)parame.Gd(2131302203);
        f = 1.0F * ((FinderMediaBanner)localObject2).getPagerView().getLayoutParams().height / ((FinderMediaBanner)localObject2).getPagerView().getLayoutParams().width;
        paramT = (TextView)parame.Gd(2131302863);
        paramList = (WeImageView)parame.Gd(2131302457);
        localObject1 = (TextView)parame.Gd(2131296976);
        if ((this.rMD != 2) || (f < 1.316667F)) {
          break label2970;
        }
        localObject2 = (HardTouchableLayout)parame.Gd(2131302206);
        d.g.b.p.g(localObject2, "mediaContainer");
        localObject3 = ((HardTouchableLayout)localObject2).getLayoutParams();
        if (localObject3 != null) {
          break label2805;
        }
        throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        parame.kA(2131306206, 8);
        break;
        paramInt1 = 0;
        break label464;
        parame.kA(2131296977, 0);
        parame.kA(2131296976, 0);
        localObject1 = (TextView)parame.Gd(2131296976);
        d.g.b.p.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
        paramList = parame.getContext();
        d.g.b.p.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099734));
        break label524;
        parame.kA(2131296977, 0);
        break label524;
        paramList = null;
        break label553;
        localObject1 = null;
        break label576;
        paramInt1 = 0;
        break label725;
        paramInt1 = 0;
        break label795;
        if (paramList != null) {
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
        }
        paramList = parame.Gd(2131305725);
        if (paramT.feedObject.getMediaList().size() <= 1) {
          if (paramList != null)
          {
            localObject1 = paramList.getContext();
            d.g.b.p.g(localObject1, "context");
            paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165303);
            paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          }
        }
        for (;;)
        {
          parame.kA(2131305725, 0);
          paramList = (FinderCollapsibleTextView)parame.Gd(2131305725);
          paramList.setCollapse(paramT.isContentCollapsed);
          paramList.setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
          paramList.setOnCollapse((d.g.a.b)new l(paramT, parame));
          paramInt1 = 1;
          break;
          if (paramList != null) {
            paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          }
        }
        if ((((amx)localObject1).sUo != 1) && (((amx)localObject1).sUo != 2)) {
          break label887;
        }
        paramList = parame.Gd(2131307449);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = parame.Gd(2131307449);
        if (paramList != null) {
          break label3196;
        }
        paramList = ((ViewStub)parame.Gd(2131307450)).inflate();
      }
      for (;;)
      {
        localObject2 = paramList.findViewById(2131307451);
        localObject3 = paramList.findViewById(2131307494);
        if (((amx)localObject1).sUo == 1)
        {
          d.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          d.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(8);
          localObject2 = (TextView)paramList.findViewById(2131307338);
          if (((amx)localObject1).sUo != 1) {
            break label2455;
          }
          localObject3 = parame.getContext();
          localObject4 = parame.getContext();
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject3 = k.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(2131766421, new Object[] { com.tencent.mm.plugin.finder.utils.p.gx(((amx)localObject1).username, ""), String.valueOf(((amx)localObject1).fTM) }));
          d.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)k.c(parame.getContext(), (CharSequence)localObject3));
          localObject2 = paramT.feedObject.getFoldedFeedList();
          localObject3 = (FinderFoldedScrollLayout)parame.Gd(2131307336);
          d.g.b.p.g(localObject3, "foldedScrollLayout");
          localObject4 = ((FinderFoldedScrollLayout)localObject3).getLayoutParams();
          if (((amx)localObject1).sUo != 2) {
            break label2533;
          }
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 208);
          ((FinderFoldedScrollLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (!bt.hj((List)localObject2)) {
            break label2551;
          }
          ((FinderFoldedScrollLayout)localObject3).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(2131307337).setOnClickListener((View.OnClickListener)new aj(this, (List)localObject2, paramT, (amx)localObject1, parame));
          break;
          d.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          d.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(0);
          break label2196;
          localObject3 = k.c(parame.getContext(), (CharSequence)parame.getContext().getString(2131766420, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((amx)localObject1).fTM) }));
          d.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)k.c(parame.getContext(), (CharSequence)localObject3));
          break label2310;
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 240);
          break label2370;
          ((FinderFoldedScrollLayout)localObject3).setVisibility(0);
          ((FinderFoldedScrollLayout)localObject3).setup((com.tencent.mm.plugin.finder.view.m)new com.tencent.mm.plugin.finder.view.g((amx)localObject1, paramT));
        }
        paramBoolean = false;
        break label934;
        parame.kA(2131300730, 8);
        break label976;
        parame.kA(2131300213, 8);
        break label1010;
        paramList = parame.Gd(2131308421);
        if (paramList == null) {
          break label1212;
        }
        paramList.setVisibility(0);
        paramList.setOnClickListener((View.OnClickListener)new d(this, parame));
        break label1212;
        paramList = parame.Gd(2131308421);
        if (paramList == null) {
          break label1212;
        }
        paramList.setVisibility(8);
        break label1212;
        d.g.b.p.g(localObject1, "poiTv");
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).post((Runnable)new g(paramList, (TextView)localObject1, (String)localObject2, this, parame, paramT));
        d.g.b.p.g(paramList, "positionLayout");
        paramList.setVisibility(0);
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new h((String)localObject2, this, parame, paramT));
        break label1285;
        if (paramT.feedObject.isPrivate())
        {
          paramT = parame.Gd(2131308375);
          if (paramT == null) {
            break label1597;
          }
          paramT.setVisibility(0);
          break label1597;
        }
        paramT = parame.Gd(2131308375);
        if (paramT == null) {
          break label1597;
        }
        paramT.setVisibility(8);
        break label1597;
        ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
        localObject3 = parame.Gd(2131308303);
        d.g.b.p.g(localObject3, "it");
        ((View)localObject3).setBackground(((HardTouchableLayout)localObject2).getResources().getDrawable(2131235046));
        ((View)localObject3).setTag(Boolean.TRUE);
        for (;;)
        {
          localObject2 = parame.Gd(2131308303);
          d.g.b.p.g(localObject2, "holder.getView<View>(R.id.feedHeaderBar)");
          if (!d.g.b.p.i(((View)localObject2).getTag(), Boolean.TRUE)) {
            break;
          }
          localObject2 = parame.getContext();
          d.g.b.p.g(localObject2, "holder.context");
          paramT.setTextColor(((Context)localObject2).getResources().getColor(2131101182));
          paramT = parame.getContext();
          d.g.b.p.g(paramT, "holder.context");
          ((TextView)localObject1).setTextColor(paramT.getResources().getColor(2131101182));
          parame = parame.getContext();
          d.g.b.p.g(parame, "holder.context");
          paramList.setIconColor(parame.getResources().getColor(2131101182));
          return;
          if ((this.rMD == 2) && (f < 1.316667F))
          {
            d.g.b.p.g(localObject2, "banner");
            localObject2 = ((FinderMediaBanner)localObject2).getContext();
            d.g.b.p.g(localObject2, "banner.context");
            paramInt1 = (int)((Context)localObject2).getResources().getDimension(2131165300);
            localObject2 = (HardTouchableLayout)parame.Gd(2131302206);
            d.g.b.p.g(localObject2, "mediaContainer");
            localObject2 = ((HardTouchableLayout)localObject2).getLayoutParams();
            if (localObject2 == null) {
              throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt1;
            localObject2 = parame.Gd(2131308303);
            d.g.b.p.g(localObject2, "it");
            ((View)localObject2).setBackground(null);
            ((View)localObject2).setTag(Boolean.FALSE);
          }
        }
        localObject2 = parame.getContext();
        d.g.b.p.g(localObject2, "holder.context");
        paramList.setIconColor(((Context)localObject2).getResources().getColor(2131100021));
        paramList = parame.getContext();
        d.g.b.p.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099734));
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        paramT.setTextColor(parame.getResources().getColor(2131100021));
        return;
      }
    }
  }
  
  public abstract void c(com.tencent.mm.view.recyclerview.e parame, T paramT);
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$Companion;", "", "()V", "TAG", "", "payloadsAttachInfo", "", "payloadsCommentEdu", "payloadsExposeInfoType", "payloadsFavInfoType", "payloadsProgressType", "payloadsRefreshLike", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ab
    implements View.OnClickListener
  {
    ab(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165362);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = (BaseFinderFeed)this.oNd.fQC();
      localObject1 = FinderReporterUIC.tcM;
      localObject1 = this.oNd.getContext();
      d.g.b.p.g(localObject1, "holder.context");
      localObject1 = FinderReporterUIC.a.eY((Context)localObject1);
      int i;
      if (localObject1 != null) {
        i = ((FinderReporterUIC)localObject1).rTD;
      }
      while ((i == 1) || (i == 8))
      {
        ad.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
        com.tencent.mm.plugin.finder.report.h.a(3, paramView.lP(), i, 1, paramView.feedObject.getUserName());
        paramView = this.oNd.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(165362);
          throw paramView;
          i = 0;
        }
        else
        {
          ((Activity)paramView).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(165362);
          return;
        }
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramView.feedObject.getUserName());
      Object localObject2 = FinderReporterUIC.tcM;
      localObject2 = this.oNd.getContext();
      d.g.b.p.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, paramView.lP(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject2 = this.oNd.getContext();
      d.g.b.p.g(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((this.oNd.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.KiD;
        localObject1 = this.oNd.getContext();
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165362);
          throw paramView;
        }
        localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).cze().vU(paramView.lP());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(3, paramView.lP(), i, 1, paramView.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165362);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ac
    implements Runnable
  {
    ac(BaseFinderFeed paramBaseFinderFeed, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201344);
      if (this.rMR.isContentCollapsed)
      {
        Object localObject1 = localFinderCollapsibleTextView;
        Object localObject2 = ((FinderCollapsibleTextView)localObject1).getCollapseTextView();
        d.g.b.p.g(localObject2, "collapseTextView");
        if ((((TextView)localObject2).getVisibility() != 0) || (!((FinderCollapsibleTextView)localObject1).sSq))
        {
          AppMethodBeat.o(201344);
          return;
        }
        localObject2 = com.tencent.mm.ui.component.a.KiD;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        FinderHomeTabStateVM.cOf();
        localObject1 = ((FinderCollapsibleTextView)localObject1).getTipsTv();
        if (((View)localObject1).getVisibility() == 8)
        {
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).animate().alpha(1.0F).setDuration(300L).start();
        }
      }
      AppMethodBeat.o(201344);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class ad
    implements CommentDrawerContract.CloseDrawerCallback
  {
    ad(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, y.d paramd) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.m> paramList)
    {
      AppMethodBeat.i(201345);
      d.g.b.p.h(paramList, "data");
      ((FinderFeedExposeLayout)this.oNd.Gd(2131298523)).Ge(this.rMR.feedObject.getCommentCount());
      paramList = h.d(this.rMP).getVideoCore().sOZ;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (h.d(this.rMP).cAz())
      {
        paramList = this.oNd.Gd(2131304550);
        d.g.b.p.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.fR(1, this.rMR.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHH().value()).intValue() == 1) {
        this.oNd.getRecyclerView().smoothScrollBy(0, -this.rNq.MLT);
      }
      AppMethodBeat.o(201345);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class ae
    extends q
    implements d.g.a.m<View, FinderCommentInfo, z>
  {
    ae(h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class af
    extends q
    implements d.g.a.m<View, FinderCommentInfo, z>
  {
    af(h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class ag
    extends q
    implements d.g.a.m<FinderCommentInfo, Boolean, z>
  {
    ag(h paramh, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201346);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.rNu.getOnCommentClickListener();
      if (paramView != null)
      {
        localObject = paramT;
        d.g.b.p.g(localObject, "selfCommentContainer");
        paramView.p(localObject, null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201346);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ai
    implements View.OnClickListener
  {
    ai(h paramh, String paramString, List paramList, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.storage.h paramh1, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      int j = 0;
      String str = null;
      AppMethodBeat.i(201347);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFavSimilar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.rNw;
      d.g.b.p.g(paramView, "wording");
      h.a(paramView, localList, paramT, parame, localh.lastBuffer, bool);
      paramView = FinderReporterUIC.tcM;
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.eY(paramView);
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      long l1 = paramT.lP();
      int i;
      if (localFinderReporterUIC != null)
      {
        i = localFinderReporterUIC.rTD;
        if (localFinderReporterUIC == null) {
          break label229;
        }
        paramView = localFinderReporterUIC.qXj;
        label139:
        if (localFinderReporterUIC == null) {
          break label234;
        }
      }
      label229:
      label234:
      for (localObject = localFinderReporterUIC.qXu;; localObject = null)
      {
        if (localFinderReporterUIC != null) {
          str = localFinderReporterUIC.sessionId;
        }
        com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
        long l2 = paramT.lP();
        if (localFinderReporterUIC != null) {
          j = localFinderReporterUIC.rTD;
        }
        com.tencent.mm.plugin.finder.report.h.a(l1, 3, i, paramView, (String)localObject, str, com.tencent.mm.plugin.finder.report.h.I(l2, j));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFavSimilar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201347);
        return;
        i = 0;
        break;
        paramView = null;
        break label139;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(h paramh, List paramList, BaseFinderFeed paramBaseFinderFeed, amx paramamx, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201348);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      h.a(this.rNx, paramT, this.rNA, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201348);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201349);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.oNd.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307396);; paramView = null)
      {
        if (paramView == null) {
          d.g.b.p.gfZ();
        }
        paramView.a(paramT.feedObject, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201349);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class al
    implements View.OnClickListener
  {
    al(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201350);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      h.b(this.rMP, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201350);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$1"})
  static final class am
    implements View.OnTouchListener
  {
    am(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(201351);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      d.g.b.p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramMotionEvent = (WeImageView)parame.Gd(2131308184);
        if (paramMotionEvent == null) {
          break label122;
        }
      }
      label122:
      for (paramView = paramMotionEvent.getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (d.g.b.p.i(paramMotionEvent.getTag(), Integer.valueOf(0)))) {
          h.b(parame);
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(201351);
        return false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$2", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$2"})
  static final class an
    implements View.OnClickListener
  {
    an(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201352);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i("Finder.FeedConvert", "onClickLikeLocal:" + parame.lN());
      h.b(this.rNB, parame, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201352);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$3", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$3"})
  static final class ao
    implements View.OnLongClickListener
  {
    ao(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201353);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cId().value()).intValue() == 1)
      {
        ad.i("Finder.FeedConvert", "onLongClickLikeLocal:" + parame.lN());
        localObject = (WeImageView)parame.Gd(2131308184);
        if (localObject == null) {
          break label156;
        }
      }
      label156:
      for (paramView = ((WeImageView)localObject).getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (d.g.b.p.i(((WeImageView)localObject).getTag(), Integer.valueOf(0)))) {
          h.b(this.rNB, parame, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(201353);
        return true;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ap
    implements View.OnClickListener
  {
    ap(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165374);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = h.d(this.rMP).getActivity();
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.c((Activity)paramView, ".ui.FinderHomeUI");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165374);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class aq
    implements ValueAnimator.AnimatorUpdateListener
  {
    aq(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201354);
      FinderPostProgressView localFinderPostProgressView = this.rNC;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201354);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rNC.invalidate();
      AppMethodBeat.o(201354);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ar
    implements View.OnClickListener
  {
    ar(h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165377);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      h.a(paramT, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165377);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class as
    implements View.OnClickListener
  {
    as(h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201355);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      h.a(paramT, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201355);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class at
    implements View.OnClickListener
  {
    at(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201356);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().k(this.rMR.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201356);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
  static final class au
    extends q
    implements d.g.a.a<Boolean>
  {
    au(y.a parama1, y.a parama2, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, int paramInt, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
  static final class av
    extends q
    implements d.g.a.a<z>
  {
    av(List paramList1, List paramList2, y.f paramf, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, int paramInt, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
  static final class aw
    implements View.OnClickListener
  {
    aw(h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, int paramInt, boolean paramBoolean2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201359);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = new atq();
      ((atq)localObject).dtq = paramT.lP();
      ((atq)localObject).objectNonceId = paramT.feedObject.getObjectNonceId();
      ((atq)localObject).scene = 2;
      paramView = FinderReporterUIC.tcM;
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eY(paramView);
      if (paramView != null)
      {
        paramView = paramView.cOu();
        ((atq)localObject).rIl = paramView;
        localObject = parame.getContext();
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
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307397);; paramView = null)
      {
        if (paramView == null) {
          d.g.b.p.gfZ();
        }
        paramView.a(paramT.feedObject, this.rMP.a(paramT));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201359);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ax
    implements Runnable
  {
    ax(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oNd.fQC();
      if (localBaseFinderFeed == null)
      {
        ad.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.oNd.Gd(2131297934);
      d.g.b.p.g(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.oNd.Gd(2131296977);
        localObject1 = (TextView)this.oNd.Gd(2131300192);
        d.g.b.p.g(localObject2, "authIconIv");
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label380;
        }
      }
      label197:
      label348:
      label380:
      for (int j = ((ImageView)localObject2).getWidth();; j = 0)
      {
        d.g.b.p.g(localObject1, "followTv");
        CharSequence localCharSequence;
        int i;
        if (((TextView)localObject1).getVisibility() == 0) {
          if (((TextView)localObject1).getText() != null)
          {
            float f = com.tencent.mm.cc.a.ax(this.oNd.getContext(), 2131165294);
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
          localObject1 = (TextView)this.oNd.Gd(2131302863);
          d.g.b.p.g(localObject1, "nicknameTv");
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
          this.oNd.d(2131302863, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class az
    implements n.d
  {
    az(h paramh) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(201362);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(h.b(this.rMP), 2131767037);
        paraml.jI(h.c(this.rMP), 2131767039);
      }
      AppMethodBeat.o(201362);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends com.tencent.mm.sdk.b.c<ha>
    implements View.OnAttachStateChangeListener
  {
    final h<T> rML;
    final com.tencent.mm.view.recyclerview.e rMM;
    
    public b(h<T> paramh, com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(165341);
      this.rML = paramh;
      this.rMM = parame;
      if ((this.rMM.getContext() instanceof MMActivity))
      {
        paramh = this.rMM.getContext();
        if (paramh == null)
        {
          paramh = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw paramh;
        }
        ((MMActivity)paramh).getLifecycle().addObserver((LifecycleObserver)h.a(this.rML));
      }
      AppMethodBeat.o(165341);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(165340);
      d.g.b.p.h(paramView, "v");
      AppMethodBeat.o(165340);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(165339);
      d.g.b.p.h(paramView, "v");
      AppMethodBeat.o(165339);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(h.b paramb, ha paramha)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class ba
    implements n.e
  {
    ba(h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201363);
      d.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == h.b(this.rMP))
      {
        h.d(this.rMP).a(this.rMR.feedObject);
        AppMethodBeat.o(201363);
        return;
      }
      if (paramInt == h.c(this.rMP))
      {
        paramMenuItem = h.d(this.rMP);
        BaseFinderFeed localBaseFinderFeed = this.rMR;
        d.g.b.p.g(localBaseFinderFeed, "item");
        paramMenuItem.g(localBaseFinderFeed);
      }
      AppMethodBeat.o(201363);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onDismiss"})
  static final class bb
    implements e.b
  {
    bb(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(201364);
      Object localObject = FinderReporterUIC.tcM;
      localObject = this.oNd.getContext();
      d.g.b.p.g(localObject, "holder.context");
      localObject = FinderReporterUIC.a.eY((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oNd.fQC();
        com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
        com.tencent.mm.plugin.finder.report.h.a(localBaseFinderFeed.feedObject.getId(), 1, 3L, "", (aqy)localObject);
        AppMethodBeat.o(201364);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showPrivateFeedLikeTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class bc
    implements Animator.AnimatorListener
  {
    bc(y.f paramf) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221454);
      paramAnimator = (View)this.rNN.MLV;
      d.g.b.p.g(paramAnimator, "tips");
      paramAnimator.setVisibility(8);
      AppMethodBeat.o(221454);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bd
    implements Runnable
  {
    bd(h paramh, BaseFinderFeed paramBaseFinderFeed, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201366);
      paramT.showLikeTips = false;
      this.rNO.setVisibility(8);
      h.e(this.rMP);
      AppMethodBeat.o(201366);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201324);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      t.makeText(this.rMh.getContext(), 2131766983, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201324);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201325);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.m.sLy;
      paramView = h.d(this.rMP).getActivity();
      if (paramView == null) {
        d.g.b.p.gfZ();
      }
      localObject = parame.fQC();
      d.g.b.p.g(localObject, "holder.getAssociatedObject<T>()");
      m.a.a(paramView, (BaseFinderFeed)localObject, 5, 4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201325);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(h paramh, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.rMP.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)new d(this), (d.g.a.a)new c(this));
        if (this.rMQ.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.rMP;
        localObject = this.cqB;
        this.cqB.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, this.cqB.getString(2131755936), false, (DialogInterface.OnCancelListener)a.rMT));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.rMQ.client_id;
      d.g.b.p.g(localObject, "comment.client_id");
      paramDialogInterface.wN(Long.parseLong((String)localObject));
      AppMethodBeat.o(165347);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rMT;
      
      static
      {
        AppMethodBeat.i(165342);
        rMT = new a();
        AppMethodBeat.o(165342);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(h.e parame, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(h.e parame)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(h.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<a.a<aok>, Boolean>
  {
    f(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$10$1"})
  static final class g
    implements Runnable
  {
    g(View paramView, TextView paramTextView, String paramString, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.rMY;
      d.g.b.p.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.rMZ;
        d.g.b.p.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.rNa) + j > i)
        {
          localObject = this.rMZ;
          d.g.b.p.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.rNa;
          TextView localTextView = this.rMZ;
          d.g.b.p.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$10$2"})
  static final class h
    implements View.OnClickListener
  {
    h(String paramString, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGf())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cGh()) {
          if (h.c(paramT))
          {
            paramView = new Intent();
            paramView.putExtra("key_topic_type", 2);
            paramView.putExtra("key_ref_object_id", paramT.feedObject.getId());
            paramView.putExtra("key_topic_title", this.rNa);
            paramView.putExtra("key_topic_poi_location", paramT.feedObject.getLocation().toByteArray());
            paramView.putExtra("KEY_TAB_TYPE", jdField_this.duh);
            localObject = FinderReporterUIC.tcM;
            localObject = parame.getContext();
            d.g.b.p.g(localObject, "holder.context");
            FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
            localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
            localObject = parame.getContext();
            d.g.b.p.g(localObject, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.J((Context)localObject, paramView);
            paramView = FinderReporterUIC.tcM;
            paramView = parame.getContext();
            d.g.b.p.g(paramView, "holder.context");
            FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.eY(paramView);
            if (localFinderReporterUIC != null)
            {
              paramView = com.tencent.mm.plugin.finder.report.h.soM;
              long l = paramT.lP();
              localObject = this.rNa;
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              com.tencent.mm.plugin.finder.report.h.a(l, paramView, 2, localFinderReporterUIC.rTD);
              paramView = FinderReporterUIC.b(localFinderReporterUIC);
              if (paramView != null) {
                paramView.cze().vY(paramT.lP());
              }
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165349);
        return;
        ad.i("Finder.FeedConvert", "click poi but isPostOk false");
        continue;
        paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
        paramView = parame.getContext();
        d.g.b.p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.p.a(paramView, paramT.feedObject.getLocation());
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
  static final class i
    implements Runnable
  {
    i(TextView paramTextView, String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165350);
      Object localObject = paramList;
      d.g.b.p.g(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.rNc;
        d.g.b.p.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.rNd) + j > i)
        {
          localObject = this.rNc;
          d.g.b.p.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.rNd;
          TextView localTextView = this.rNc;
          d.g.b.p.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
  static final class j
    implements View.OnClickListener
  {
    j(String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = FinderReporterUIC.tcM;
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eY(paramView);
      if (paramView != null) {}
      for (int i = paramView.rTD;; i = 0)
      {
        paramView = new Intent();
        localObject = com.tencent.mm.ai.m.d(this.rNf, 156, i + 10000, (int)(System.currentTimeMillis() / 1000L));
        ad.i("Finder.FeedConvert", "click linkLayout, url:" + this.rNf + ", urlWithReportParams:" + (String)localObject);
        paramView.putExtra("rawUrl", (String)localObject);
        com.tencent.mm.bs.d.b(parame.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        paramView = FinderReporterUIC.tcM;
        paramView = parame.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eY(paramView);
        if (paramView != null)
        {
          paramView = FinderReporterUIC.b(paramView);
          if (paramView != null) {
            paramView.cze().wd(paramT.lP());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165351);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201328);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = (BaseFinderFeed)parame.fQC();
      localObject = new com.tencent.mm.ui.widget.a.e(parame.getContext(), 0, false);
      com.tencent.mm.plugin.finder.feed.h localh = h.d(this.rMP);
      d.g.b.p.g(paramView, "item");
      ((com.tencent.mm.ui.widget.a.e)localObject).a(localh.a(paramView, (com.tencent.mm.ui.widget.a.e)localObject));
      ((com.tencent.mm.ui.widget.a.e)localObject).b(h.d(this.rMP).e(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).a(h.d(this.rMP).f(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).b(h.d(this.rMP).f(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).b((e.b)new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(201327);
          Object localObject = FinderReporterUIC.tcM;
          localObject = this.rNg.oNd.getContext();
          d.g.b.p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.eY((Context)localObject);
          if (localObject != null) {}
          for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
          {
            BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.rNg.oNd.fQC();
            com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
            com.tencent.mm.plugin.finder.report.h.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", (aqy)localObject);
            AppMethodBeat.o(201327);
            return;
          }
        }
      });
      ((com.tencent.mm.ui.widget.a.e)localObject).cMW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201328);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<Boolean, z>
  {
    l(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class m
    implements HardTouchableLayout.b
  {
    m(HardTouchableLayout paramHardTouchableLayout, h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void ea(View paramView)
    {
      AppMethodBeat.i(165353);
      d.g.b.p.h(paramView, "view");
      ad.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)parame.fQC());
      jdField_this.a(parame, (View)this.rNh);
      AppMethodBeat.o(165353);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.g
  {
    n(HardTouchableLayout paramHardTouchableLayout, h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void eb(View paramView)
    {
      AppMethodBeat.i(165354);
      d.g.b.p.h(paramView, "view");
      ad.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)parame.fQC());
      jdField_this.a(parame, (View)this.rNh, ((BaseFinderFeed)parame.fQC()).feedObject.getFeedObject());
      AppMethodBeat.o(165354);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201331);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i("Finder.FeedConvert", "onClickShare:" + parame.lN());
      h.b(this.rMP, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201331);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class r
    implements View.OnLongClickListener
  {
    r(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201333);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oNd.fQC();
      paramView = com.tencent.mm.ui.component.a.KiD;
      paramView = this.oNd.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201333);
        throw paramView;
      }
      FinderDebugUIC localFinderDebugUIC = (FinderDebugUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramView).get(FinderDebugUIC.class);
      Context localContext;
      com.tencent.mm.view.recyclerview.e locale;
      com.tencent.mm.ui.widget.a.e locale1;
      long l;
      boolean bool;
      label314:
      StringBuilder localStringBuilder;
      if (localFinderDebugUIC != null)
      {
        localContext = this.oNd.getContext();
        d.g.b.p.g(localContext, "holder.context");
        d.g.b.p.g(localBaseFinderFeed, "item");
        locale = this.oNd;
        d.g.b.p.h(localContext, "context");
        d.g.b.p.h(localBaseFinderFeed, "item");
        d.g.b.p.h(locale, "holder");
        locale1 = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
        l = localBaseFinderFeed.lP();
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if ((paramView == null) || (paramView.mediaType != 4)) {
          break label813;
        }
        bool = true;
        paramView = new StringBuilder(" [ClickMoreDebug]FeedId=").append(com.tencent.mm.ad.c.rc(localBaseFinderFeed.feedObject.getId())).append("\n                feedTime=").append(bt.Dc(localBaseFinderFeed.feedObject.getCreateTime() * 1L)).append("\n                posTriggerConfig=");
        localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
        localObject = paramView.append(com.tencent.mm.plugin.finder.storage.data.g.wX(localBaseFinderFeed.feedObject.getId())).append("\n                videoDuration=");
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label819;
        }
        paramView = Integer.valueOf(paramView.videoDuration);
        paramView = ((StringBuilder)localObject).append(paramView).append("\n                signedFeedId=").append(localBaseFinderFeed.feedObject.getId()).append("\n                username=").append(localBaseFinderFeed.feedObject.field_username).append("\n                ctFlag=");
        localObject = com.tencent.mm.plugin.finder.api.c.rHn;
        localStringBuilder = paramView.append(c.a.agZ(localBaseFinderFeed.feedObject.field_username)).append("\n                mediaType=").append(localBaseFinderFeed.feedObject.getMediaType()).append("\n                mediaId=");
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView != null)
        {
          localObject = paramView.url;
          paramView = (View)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramView = "";
        }
        localObject = localStringBuilder.append(com.tencent.mm.sdk.platformtools.ai.ee(paramView)).append("\n                url=");
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label824;
        }
        paramView = paramView.url;
        label484:
        localObject = ((StringBuilder)localObject).append(paramView).append("\n                thumbUrl=");
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label829;
        }
      }
      label813:
      label819:
      label824:
      label829:
      for (paramView = paramView.thumbUrl;; paramView = null)
      {
        localStringBuilder = ((StringBuilder)localObject).append(paramView).append("\n                coverUrl=");
        paramView = (bvf)j.jd((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView != null)
        {
          localObject = paramView.coverUrl;
          paramView = (View)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramView = "";
        }
        localStringBuilder = localStringBuilder.append(paramView).append("\n                description=").append(localBaseFinderFeed.feedObject.getDescription()).append("\n                debugMessage=");
        localObject = localBaseFinderFeed.feedObject.getFeedObject().debugMessage;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        paramView = paramView + "\n                        ";
        localObject = d.n.n.bdc("content=" + f.bF(localBaseFinderFeed.feedObject.getFeedObject()));
        ad.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(paramView)));
        ad.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(localObject)));
        if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fjN()))
        {
          locale1.a((n.d)new FinderDebugUIC.b(localFinderDebugUIC, bool));
          locale1.a((n.e)new FinderDebugUIC.c(localFinderDebugUIC, localContext, paramView, localBaseFinderFeed, l, (String)localObject, locale));
          locale1.cMW();
        }
        this.oNd.auu.requestLayout();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(201333);
        return true;
        bool = false;
        break;
        paramView = null;
        break label314;
        paramView = null;
        break label484;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class s
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private long rNl = -1L;
    
    s(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201334);
      d.g.b.p.h(paramb, "ev");
      Object localObject1;
      Object localObject2;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        localObject1 = parame.fQC();
        if (((localObject1 instanceof BaseFinderFeed)) && (this.rNl != ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRj))
        {
          long l = ((BaseFinderFeed)localObject1).feedObject.getExpectId();
          if (((com.tencent.mm.plugin.finder.event.base.h)paramb).rRj != l) {
            break label139;
          }
          localObject1 = parame;
          localObject2 = parame.fQC();
          if (localObject2 == null)
          {
            paramb = new v("null cannot be cast to non-null type T");
            AppMethodBeat.o(201334);
            throw paramb;
          }
          h.a(true, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
        }
      }
      for (;;)
      {
        this.rNl = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRj;
        AppMethodBeat.o(201334);
        return;
        label139:
        localObject1 = parame;
        localObject2 = parame.fQC();
        if (localObject2 == null)
        {
          paramb = new v("null cannot be cast to non-null type T");
          AppMethodBeat.o(201334);
          throw paramb;
        }
        h.a(false, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201335);
      d.g.b.p.h(paramc, "dispatcher");
      d.g.b.p.h(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(201335);
      return bool;
    }
    
    public final boolean cyW()
    {
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class t
    implements HardTouchableLayout.c
  {
    public final boolean Q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(201336);
      d.g.b.p.h(paramMotionEvent, "event");
      AppMethodBeat.o(201336);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class u
    implements View.OnTouchListener
  {
    u(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(201337);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      d.g.b.p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = (WeImageView)parame.Gd(2131300888);
        d.g.b.p.g(paramView, "awesomeIv");
        if (((paramView.getTag() instanceof Integer)) && (d.g.b.p.i(paramView.getTag(), Integer.valueOf(0)))) {
          h.b(parame);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(201337);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201338);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i("Finder.FeedConvert", "onClickLike:" + parame.lN());
      h.a(this.rMP, parame, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201338);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class w
    implements View.OnLongClickListener
  {
    w(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cId().value()).intValue() == 1)
      {
        ad.i("Finder.FeedConvert", "onLongClick Private Like:" + parame.lN());
        paramView = (WeImageView)parame.Gd(2131300888);
        d.g.b.p.g(paramView, "awesomeIv");
        if (((paramView.getTag() instanceof Integer)) && (d.g.b.p.i(paramView.getTag(), Integer.valueOf(0)))) {
          h.a(this.rMP, parame, true);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(201339);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class z
    implements View.OnClickListener
  {
    z(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201342);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i("Finder.FeedConvert", "onClickFav:" + parame.lN());
      h.a(this.rMP, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201342);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h
 * JD-Core Version:    0.7.0.1
 */