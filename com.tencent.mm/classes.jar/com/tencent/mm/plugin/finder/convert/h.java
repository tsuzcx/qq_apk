package com.tencent.mm.plugin.finder.convert;

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
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.action.g.a;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
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
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.neattextview.textview.view.NeatTextView;
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
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bvz;>;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "MENU_ID_UNFOLLOW", "avatarRectControl", "feedHeadBarStyle", "getFeedHeadBarStyle", "()I", "setFeedHeadBarStyle", "(I)V", "hideSelfTipsRunnable", "Ljava/lang/Runnable;", "isRealNameLike", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "calculateOpArea", "item", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "checkHideLikeTips", "tipsView", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkShowShareSnsLayout", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "formatDesc", "incCount", "suffix", "descTv", "Landroid/widget/TextView;", "preCount", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "hideOrDimissMoreBtn", "ifShow", "hideSelfFeedLikeTips", "jumpFoldedUI", "feedList", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "jumpRelatedUI", "title", "lastBuffer", "needRefresh", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "likeAvatorAnimator", "likeCount", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "likeLocalFeed", "isPrivate", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onFocusedViewHolder", "isFocused", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "onMediaClick", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshExposeLayout", "refreshFavIv", "isFav", "favCount", "refreshFavSimilar", "refreshFeedHeaderBar", "refreshFoldedLayout", "refreshFollowState", "refreshHeaderFooterWording", "refreshLocalAwesomeIv", "refreshOpLayout", "refreshPrivateIcon", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setNicknameCalculateWidth", "shareFeed", "showOrDimissSelfFeedLikeTips", "isBind", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "showPrivateFeedLikeTips", "isPrivateClick", "showSelfFeedLikeTips", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class h<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.b<T>
{
  public static final h.a rUY = new h.a((byte)0);
  final int dvm;
  private final int rUN;
  private final int rUO;
  private final int rUP;
  private int rUQ;
  private final HashSet<b<T>> rUR;
  private Runnable rUS;
  private final FinderFeedConvert.uiLifecycleObserver.1 rUT;
  private final boolean rUU;
  private final boolean rUV;
  private final com.tencent.mm.plugin.finder.feed.h rUW;
  protected boolean rUX;
  private Rect rect;
  Dialog tipDialog;
  
  public h(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    this.rUW = paramh;
    this.rUX = paramBoolean;
    this.dvm = paramInt;
    this.rUN = 10000;
    this.rUO = 10001;
    this.rUP = 10002;
    paramh = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.rUQ = ((Number)com.tencent.mm.plugin.finder.storage.b.cKe().value()).intValue();
    this.rUR = new HashSet();
    this.rUT = new FinderFeedConvert.uiLifecycleObserver.1(this);
    paramh = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIJ().value()).intValue() == 1)
    {
      paramBoolean = true;
      this.rUU = paramBoolean;
      paramh = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIK().value()).intValue() != 1) {
        break label165;
      }
    }
    label165:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.rUV = paramBoolean;
      this.rect = new Rect();
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, BaseFinderFeed paramBaseFinderFeed)
  {
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
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
  
  private static void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt2 + ')';
    paramString = new StringBuilder(paramString);
    paramInt1 = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parame.getResources().getColor(2131099803)), paramInt1, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.p.h(parame, "holder");
    parame.kH(2131300208, paramInt);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt + ')';
    paramString = new StringBuilder(paramString);
    paramInt = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parame.getResources().getColor(2131099803)), paramInt, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private final void a(final T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    if (this.rUW.cCl())
    {
      parame.kH(2131300205, 8);
      parame.kH(2131304551, 0);
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((((Boolean)com.tencent.mm.plugin.finder.storage.b.cJV().value()).booleanValue()) && (paramT.feedObject.field_id % 2L == 0L))
      {
        if ((!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sWx, "zh_CN")) && (!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sWx, "zh_HK")) && (!d.g.b.p.i(com.tencent.mm.plugin.finder.utils.h.sWx, "zh_TW"))) {
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
        localObject = parame.GD(2131304558);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getReadCount()));
        localObject = parame.GD(2131304552);
        d.g.b.p.g(localObject, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getForwardCount()));
        localObject = parame.GD(2131304553);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_like_count_tv)");
        localObject = (TextView)localObject;
        g.a locala = com.tencent.mm.plugin.finder.upload.action.g.sVv;
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(com.tencent.mm.plugin.finder.upload.action.g.cNz().l(paramT.feedObject.getFeedObject())));
        localObject = parame.GD(2131304550);
        d.g.b.p.g(localObject, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getCommentCount()));
        localObject = parame.GD(2131307971);
        d.g.b.p.g(localObject, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getFavCount()));
        parame.GD(2131307972).setOnClickListener((View.OnClickListener)new am(parame, paramT));
        parame.GD(2131307974).setOnClickListener((View.OnClickListener)new h.an(this, parame));
        parame.kH(2131298523, 0);
        parame.kH(2131306206, 0);
        parame.e(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.h.f(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        localObject = parame.getContext();
        d.g.b.p.g(localObject, "holder.context");
        float f = ((Context)localObject).getResources().getDimensionPixelSize(2131165257);
        ((TextView)parame.GD(2131304558)).setTextSize(0, f);
        ((TextView)parame.GD(2131304552)).setTextSize(0, f);
        ((TextView)parame.GD(2131304553)).setTextSize(0, f);
        ((TextView)parame.GD(2131304550)).setTextSize(0, f);
        ((TextView)parame.GD(2131307971)).setTextSize(0, f);
        b(paramT, parame);
        return;
        label558:
        paramT.feedObject.setReadCount(999);
        paramT.feedObject.setForwardCount(1000);
        paramT.feedObject.setLikeCount(1000000);
        paramT.feedObject.setCommentCount(990000000);
        paramT.feedObject.setFavCount(1200000000);
      }
    }
    parame.kH(2131300205, 0);
    parame.kH(2131304551, 8);
    Object localObject = com.tencent.mm.plugin.finder.upload.action.c.sVf;
    boolean bool1 = com.tencent.mm.plugin.finder.upload.action.c.cNx().i(paramT.feedObject.getFeedObject());
    localObject = com.tencent.mm.plugin.finder.upload.action.c.sVf;
    a(bool1, com.tencent.mm.plugin.finder.upload.action.c.cNx().j(paramT.feedObject.getFeedObject()), parame);
    localObject = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    localObject = com.tencent.mm.plugin.finder.upload.action.g.cNz().k(paramT.feedObject.getFeedObject());
    bool1 = ((Boolean)((d.o)localObject).first).booleanValue();
    boolean bool2 = ((Boolean)((d.o)localObject).second).booleanValue();
    localObject = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.g.cNz().l(paramT.feedObject.getFeedObject()), parame);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.e parame, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.g.cNz().n(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    final int j = com.tencent.mm.plugin.finder.upload.action.g.cNz().m(paramT.feedObject.getFeedObject());
    if ((this.rUU) && (!bu.ht((List)localLinkedList)) && (j > 0) && (!this.rUW.cCl()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.j(paramT.contact)) {}
    }
    else
    {
      ae.i("Finder.FeedConvert", "refreshRealNameRecommendLayout tabType:" + this.dvm + ", " + bu.ht((List)localLinkedList) + ", " + j + ' ' + this.rUU);
      paramT = parame.GD(2131307922);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    final boolean bool1 = com.tencent.mm.plugin.finder.utils.p.o(paramT);
    if (this.rUV) {}
    final boolean bool2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    FrameLayout localFrameLayout;
    for (final float f = 0.2F;; f = 0.5F)
    {
      bool2 = this.rUV;
      localObject1 = parame.GD(2131307922);
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = (List)new ArrayList();
      ((List)localObject2).add(parame.GD(2131307453));
      ((List)localObject2).add(parame.GD(2131307455));
      ((List)localObject2).add(parame.GD(2131307457));
      localObject3 = (List)new ArrayList();
      localObject4 = (FrameLayout)parame.GD(2131307454);
      localObject5 = (FrameLayout)parame.GD(2131307456);
      localFrameLayout = (FrameLayout)parame.GD(2131307458);
      localObject1 = (FrameLayout)parame.GD(2131307461);
      if (!this.rUV) {
        break label1130;
      }
      d.g.b.p.g(localObject4, "layout1");
      localObject6 = ((FrameLayout)localObject4).getLayoutParams();
      if (localObject6 != null) {
        break label387;
      }
      throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    label387:
    Object localObject6 = (FrameLayout.LayoutParams)localObject6;
    Object localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    d.g.b.p.g(localObject5, "layout2");
    localObject6 = ((FrameLayout)localObject5).getLayoutParams();
    if (localObject6 == null) {
      throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    d.g.b.p.g(localFrameLayout, "layout3");
    localObject6 = localFrameLayout.getLayoutParams();
    if (localObject6 == null) {
      throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(2131165299));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject6);
    d.g.b.p.g(localObject1, "layoutExtra");
    localObject6 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject6 == null) {
      throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(2131165293));
    localObject7 = parame.getContext();
    d.g.b.p.g(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(2131165293));
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
          localContext = parame.getContext();
          d.g.b.p.g(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).width = ((int)localContext.getResources().getDimension(2131165292));
        }
        if (localObject1 != null)
        {
          localContext = parame.getContext();
          d.g.b.p.g(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).height = ((int)localContext.getResources().getDimension(2131165292));
        }
        if (localObject7 == null) {
          break;
        }
        ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    localObject6 = parame.GD(2131307459);
    if (localObject6 != null)
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      label1046:
      if (localObject1 != null)
      {
        localObject7 = parame.getContext();
        d.g.b.p.g(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).width = ((int)((Context)localObject7).getResources().getDimension(2131165292));
      }
      if (localObject1 != null)
      {
        localObject7 = parame.getContext();
        d.g.b.p.g(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).height = ((int)((Context)localObject7).getResources().getDimension(2131165292));
      }
      if (localObject6 != null) {
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label1130:
      ((List)localObject3).add(localObject4);
      ((List)localObject3).add(localObject5);
      ((List)localObject3).add(localFrameLayout);
      localObject1 = (RoundLinearLayout)parame.GD(2131308473);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = z.Nhr;
      }
      localObject1 = (RoundLinearLayout)parame.GD(2131308474);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = z.Nhr;
      }
      localObject1 = (RoundLinearLayout)parame.GD(2131308475);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = z.Nhr;
      }
      localObject1 = new y.a();
      localObject4 = new y.a();
      localObject5 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
      localObject5 = com.tencent.mm.plugin.finder.upload.action.g.cNz().k(paramT.feedObject.getFeedObject());
      ((y.a)localObject1).NiT = ((Boolean)((d.o)localObject5).first).booleanValue();
      ((y.a)localObject4).NiT = ((Boolean)((d.o)localObject5).second).booleanValue();
      localObject5 = new y.f();
      ((y.f)localObject5).NiY = ((d.g.a.a)new h.aw((y.a)localObject1, (y.a)localObject4, this, parame, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
      ((d.g.a.a)new h.ax((List)localObject2, (List)localObject3, (y.f)localObject5, this, parame, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1)).invoke();
      localObject4 = (TextView)parame.GD(2131307924);
      if (localObject4 != null)
      {
        if (!bool2) {
          break label1833;
        }
        if (localLinkedList.size() > 3) {
          break label1750;
        }
        localObject5 = parame.getContext();
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = (FinderCommentInfo)d.a.j.jo((List)localLinkedList);
        if (localObject1 != null)
        {
          localObject1 = ((FinderCommentInfo)localObject1).username;
          if (localObject1 != null) {
            break label2161;
          }
        }
        localObject1 = "";
      }
    }
    label1637:
    label2158:
    label2161:
    for (;;)
    {
      localObject2 = (FinderCommentInfo)d.a.j.jo((List)localLinkedList);
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
      localObject1 = k.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.p.gC((String)localObject1, (String)localObject2));
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject4).setText((CharSequence)localObject1);
      localObject1 = z.Nhr;
      localObject3 = (TextView)parame.GD(2131307921);
      int k = paramT.feedObject.getFeedObject().incFriendLikeCount;
      int m = j - k;
      int i;
      if (j == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.FV(paramT.feedObject.getFeedObject().objectType);
        if (localObject1 != null)
        {
          localObject2 = (CharSequence)((aqo)localObject1).GHq;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
          {
            i = 1;
            if (i == 0) {
              break label1925;
            }
          }
        }
        else
        {
          localObject1 = parame.getContext().getString(2131766492);
          label1654:
          if ((k <= 0) || (!bool1)) {
            break label1935;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          d.g.b.p.g(localObject3, "descTv");
          a(k, parame, (String)localObject2, (TextView)localObject3);
          localObject1 = parame.GD(2131307923);
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setOnClickListener((View.OnClickListener)new ay(this, parame, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
          paramT = z.Nhr;
          return;
          localObject1 = null;
          break label1046;
          localObject5 = parame.getContext();
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject1 = ((FinderCommentInfo)localLinkedList.get(2)).username;
          if (localObject1 != null) {
            break label2158;
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
        localObject1 = k.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.p.gC((String)localObject1, (String)localObject2));
        break;
        localObject5 = parame.getContext();
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
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
          localObject1 = (CharSequence)k.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.p.gC((String)localObject1, (String)localObject2));
          break;
          i = 0;
          break label1637;
          localObject1 = ((aqo)localObject1).GHq;
          break label1654;
          d.g.b.p.g(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1696;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.FV(paramT.feedObject.getFeedObject().objectType);
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((aqo)localObject1).GHr;
            if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label2094;
              }
            }
          }
          else
          {
            localObject1 = parame.getContext().getString(2131766491, new Object[] { String.valueOf(m + k) });
          }
          for (;;)
          {
            if ((k <= 0) || (!bool1)) {
              break label2134;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            d.g.b.p.g(localObject3, "descTv");
            a(m, k, parame, (String)localObject2, (TextView)localObject3);
            break;
            i = 0;
            break label2009;
            localObject1 = ((aqo)localObject1).GHr;
            if (localObject1 != null) {
              localObject1 = d.n.n.h((String)localObject1, "$$", String.valueOf(m + k), true);
            } else {
              localObject1 = null;
            }
          }
          d.g.b.p.g(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1696;
        }
      }
    }
  }
  
  private static void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject2 = (WeImageView)parame.GD(2131300888);
    int i;
    Object localObject1;
    label89:
    int j;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        d.g.b.p.g(localObject2, "awesomeIv");
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, paramBaseFinderFeed);
        localObject1 = parame.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        localObject1 = new d.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131099809)));
        i = ((Number)((d.o)localObject1).first).intValue();
        j = ((Number)((d.o)localObject1).second).intValue();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.storage.logic.f.FV(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
        if (paramBaseFinderFeed == null) {
          break label390;
        }
        if (!paramBoolean1) {
          break label368;
        }
        if (!al.isDarkMode()) {
          break label360;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.GHw;
        label153:
        ((WeImageView)localObject2).setClearColorFilter(true);
        localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cEn();
        paramBaseFinderFeed = new com.tencent.mm.plugin.finder.loader.l(paramBaseFinderFeed, r.sJu);
        localObject2 = (ImageView)localObject2;
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((com.tencent.mm.loader.d)localObject1).a(paramBaseFinderFeed, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        label207:
        localObject1 = (TextView)parame.GD(2131301416);
        if (paramInt <= 0) {
          break label407;
        }
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.h.fR(2, paramInt);
        d.g.b.p.g(paramBaseFinderFeed, "FinderFormatUtil.formatN…cene.SCENE_WX, likeCount)");
        d.g.b.p.g(localObject1, "likeTv");
        al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed);
      return;
      d.g.b.p.g(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      d.g.b.p.g(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, paramBaseFinderFeed);
      localObject1 = parame.getContext();
      d.g.b.p.g(localObject1, "holder.context");
      localObject1 = new d.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131100018)));
      break label89;
      label360:
      paramBaseFinderFeed = paramBaseFinderFeed.GHx;
      break label153;
      label368:
      if (al.isDarkMode())
      {
        paramBaseFinderFeed = paramBaseFinderFeed.GHy;
        break label153;
      }
      paramBaseFinderFeed = paramBaseFinderFeed.GHz;
      break label153;
      label390:
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(j);
      break label207;
      label407:
      paramBaseFinderFeed = parame.getContext().getString(2131766760);
      d.g.b.p.g(paramBaseFinderFeed, "holder.context.getString…g.finder_like_count_text)");
      d.g.b.p.g(localObject1, "likeTv");
      al.b((Paint)((TextView)localObject1).getPaint());
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, LinkedList<bvz> paramLinkedList, long paramLong)
  {
    d.g.b.p.h(paramFinderMediaBanner, "banner");
    d.g.b.p.h(paramLinkedList, "mediaList");
    if (d.a.j.jm((List)paramLinkedList) == null)
    {
      ae.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject = (bvz)paramLinkedList.getFirst();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    paramLinkedList = (LinkedList<bvz>)localObject;
    label77:
    if (localIterator.hasNext())
    {
      localObject = (bvz)localIterator.next();
      float f = ((bvz)localObject).height * 1.0F / ((bvz)localObject).width;
      if (paramLinkedList.height * 1.0F / paramLinkedList.width >= f) {
        break label290;
      }
      paramLinkedList = (LinkedList<bvz>)localObject;
    }
    label290:
    for (;;)
    {
      break label77;
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
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
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parame.fUY();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.cNz().k(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((d.o)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((d.o)localObject1).second).booleanValue();
    Object localObject2;
    WeImageView localWeImageView;
    label126:
    Object localObject3;
    int i;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label777;
      }
      localObject2 = parame.GD(2131300888);
      localWeImageView = (WeImageView)parame.GD(2131301417);
      if (localWeImageView != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.FV(localBaseFinderFeed.feedObject.getFeedObject().objectType);
        if (localObject1 != null) {
          break label537;
        }
        localObject1 = "";
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label563;
        }
        i = 1;
        label151:
        if (i != 0) {
          break label569;
        }
        localWeImageView.setClearColorFilter(true);
        localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject3 = com.tencent.mm.plugin.finder.loader.i.cEn();
        localObject1 = new com.tencent.mm.plugin.finder.loader.l((String)localObject1, r.sJu);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((com.tencent.mm.loader.d)localObject3).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        label213:
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.tiL;
        com.tencent.mm.plugin.finder.view.animation.c.ek((View)localWeImageView);
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.tiL;
        d.g.b.p.g(localObject2, "likeIcon");
        com.tencent.mm.plugin.finder.view.animation.c.ej((View)localObject2);
      }
      if ((paramInt == 2) || (paramBoolean)) {
        a(parame);
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {
        break label683;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJX() > 0) {
        a(parame, false);
      }
      label289:
      if (bool1) {
        bool2 = false;
      }
      localObject1 = this.rUW;
      d.g.b.p.g(localBaseFinderFeed, "item");
      ((com.tencent.mm.plugin.finder.feed.h)localObject1).a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.g.cNz().l(localBaseFinderFeed.feedObject.getFeedObject()), parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if ((com.tencent.mm.plugin.finder.utils.p.o(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label823;
        }
        localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
        ((FinderObject)localObject1).incFriendLikeCount += 1;
      }
      label398:
      a(this, bool1, parame, localBaseFinderFeed);
      localObject1 = new hf();
      ((hf)localObject1).duE.id = localBaseFinderFeed.lP();
      ((hf)localObject1).duE.type = 4;
      localObject2 = ((hf)localObject1).duE;
      if ((!bool1) || (!paramBoolean)) {
        break label853;
      }
      paramInt = 2;
    }
    for (;;)
    {
      ((hf.a)localObject2).duH = paramInt;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = FinderReporterUIC.tnG;
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
      parame = FinderReporterUIC.a.fc(parame);
      if (parame != null)
      {
        parame = FinderReporterUIC.b(parame);
        if (parame != null)
        {
          parame = parame.cAI();
          if (!bool1) {
            break label868;
          }
          parame.wi(localBaseFinderFeed.lP());
        }
      }
      return;
      bool1 = false;
      break;
      label537:
      if (al.isDarkMode())
      {
        localObject1 = ((aqo)localObject1).GHw;
        break label126;
      }
      localObject1 = ((aqo)localObject1).GHx;
      break label126;
      label563:
      i = 0;
      break label151;
      label569:
      if (!paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {}
      }
      else
      {
        localObject1 = parame.getContext();
        localObject3 = parame.getContext();
        d.g.b.p.g(localObject3, "holder.context");
        localWeImageView.setImageDrawable(ao.k((Context)localObject1, 2131691596, ((Context)localObject3).getResources().getColor(2131099809)));
        break label213;
      }
      localObject1 = parame.getContext();
      localObject3 = parame.getContext();
      d.g.b.p.g(localObject3, "holder.context");
      localWeImageView.setImageDrawable(ao.k((Context)localObject1, 2131690326, ((Context)localObject3).getResources().getColor(2131099809)));
      break label213;
      label683:
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cJY() > 0)
        {
          a(parame, true);
          break label289;
        }
      }
      if (paramBoolean) {
        break label289;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKD().value()).intValue() != 1) {
        break label289;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKD().value()).intValue() != 1) {
        break label289;
      }
      localBaseFinderFeed.showCommentEdu = true;
      d.g.b.p.g(localBaseFinderFeed, "item");
      a(parame, localBaseFinderFeed, 1);
      break label289;
      label777:
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKD().value()).intValue() != 1) {
        break label289;
      }
      localBaseFinderFeed.showCommentEdu = false;
      d.g.b.p.g(localBaseFinderFeed, "item");
      a(parame, localBaseFinderFeed, 1);
      break label289;
      label823:
      if (bool2) {
        break label398;
      }
      localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
      ((FinderObject)localObject1).incFriendLikeCount -= 1;
      break label398;
      label853:
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    label868:
    parame.wj(localBaseFinderFeed.lP());
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    Object localObject = FinderReporterUIC.tnG;
    localObject = parame.getContext();
    d.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.fc((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).sch;
      localObject = com.tencent.mm.plugin.finder.api.c.rPy;
      bool = c.a.ahW(paramT.feedObject.field_username);
      if (!this.rUX) {
        break label115;
      }
      parame.kH(2131300192, 8);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < ch.aDa() - 86400000L)) {
        break label293;
      }
      parame.kH(2131303868, 8);
      return;
      i = 0;
      break;
      label115:
      if ((this.dvm != 3) && (bool) && (i != 1))
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (!com.tencent.mm.plugin.finder.utils.p.d(paramT))
        {
          parame.kH(2131300192, 0);
          localObject = (TextView)parame.GD(2131300192);
          d.g.b.p.g(localObject, "followIv");
          Context localContext = ((TextView)localObject).getContext();
          d.g.b.p.g(localContext, "followIv.context");
          ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760230));
          ((TextView)localObject).setTextSize(0, com.tencent.mm.cb.a.ay(((TextView)localObject).getContext(), 2131165284));
          localContext = parame.getContext();
          d.g.b.p.g(localContext, "holder.context");
          ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099734));
          ((TextView)localObject).setBackgroundResource(2131232351);
          continue;
        }
      }
      if ((!bool) || (this.dvm == 3)) {
        parame.kH(2131300192, 8);
      }
    }
    label293:
    parame.kH(2131303868, 0);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.e parame, T paramT, int paramInt)
  {
    View localView = parame.GD(2131302586);
    if (paramT.showCommentEdu)
    {
      d.g.b.p.g(localView, "layout");
      localView.setVisibility(0);
      localView.setOnClickListener((View.OnClickListener)new h.af(this, parame, paramT, paramInt));
      return;
    }
    d.g.b.p.g(localView, "layout");
    localView.setVisibility(8);
  }
  
  private static void a(com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    d.g.b.p.h(parame, "holder");
    y.f localf = new y.f();
    localf.NiY = parame.GD(2131308309);
    if ((View)localf.NiY == null) {
      localf.NiY = ((ViewStub)parame.GD(2131308310)).inflate();
    }
    Object localObject = (View)localf.NiY;
    d.g.b.p.g(localObject, "tips");
    if (((View)localObject).getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (TextView)((View)localf.NiY).findViewById(2131308308);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parame.getContext().getString(2131767022));
      }
      parame = com.tencent.mm.plugin.finder.storage.b.sHP;
      com.tencent.mm.plugin.finder.storage.b.FH(com.tencent.mm.plugin.finder.storage.b.cJY() - 1);
    }
    for (;;)
    {
      parame = (View)localf.NiY;
      d.g.b.p.g(parame, "tips");
      parame.setVisibility(0);
      parame = (View)localf.NiY;
      d.g.b.p.g(parame, "tips");
      parame.setAlpha(1.0F);
      ((View)localf.NiY).animate().cancel();
      ((View)localf.NiY).animate().alpha(0.0F).setDuration(300L).setStartDelay(2000L).setListener((Animator.AnimatorListener)new h.be(localf)).start();
      return;
      localObject = (TextView)((View)localf.NiY).findViewById(2131308308);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parame.getContext().getString(2131767021));
      }
      parame = com.tencent.mm.plugin.finder.storage.b.sHP;
      com.tencent.mm.plugin.finder.storage.b.FG(com.tencent.mm.plugin.finder.storage.b.cJX() - 1);
    }
  }
  
  private final void a(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    WeImageView localWeImageView = (WeImageView)parame.GD(2131307331);
    TextView localTextView = (TextView)parame.GD(2131307332);
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
      if (!this.rUW.cCl()) {
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
    parame = parame.GD(2131302457);
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
    final FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)parame.GD(2131305725);
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    localObject = (FinderHomeTabStateVM)localObject;
    if (((FinderHomeTabStateVM)localObject).tky)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(locale, "MMKernel.storage()");
      i = locale.ajA().getInt(am.a.Jbw, 0);
      if (i >= 3) {
        ((FinderHomeTabStateVM)localObject).tky = false;
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
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (com.tencent.mm.plugin.finder.utils.p.cOi())
    {
      paramT = parame.GD(2131308145);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parame = parame.GD(2131308110);
      if (parame != null) {
        parame.setVisibility(8);
      }
    }
    do
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.j(paramT.contact)) {
        break;
      }
      paramT = parame.GD(2131308145);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parame = parame.GD(2131308110);
    } while (parame == null);
    parame.setVisibility(8);
    return;
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    if ((com.tencent.mm.plugin.finder.utils.p.d(paramT)) && (paramT.showLikeTips) && (!paramT.feedObject.isPostFailed()) && (!paramT.feedObject.isUploadFailed()))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJd() < 6)
      {
        localObject1 = parame.GD(2131308110);
        if (localObject1 != null) {
          break label592;
        }
        localObject1 = ((ViewStub)parame.GD(2131308111)).inflate();
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
          parame = parame.GD(2131308145);
          if (parame == null) {
            break;
          }
          parame.setVisibility(0);
          return;
          localObject2 = parame.GD(2131308109);
          d.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.az(parame.getContext(), 2131766416));
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
          localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if ((com.tencent.mm.plugin.finder.storage.b.cJd() >= 6) && (((View)localObject1).getVisibility() != 0))
          {
            localObject2 = parame.GD(2131308145);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = this.rUS;
              if (localObject2 != null) {
                ((View)localObject1).removeCallbacks((Runnable)localObject2);
              }
              this.rUS = ((Runnable)new bf(this, paramT, (View)localObject1));
              ((View)localObject1).postDelayed(this.rUS, 5000L);
            }
          }
        }
      }
      Object localObject2 = parame.GD(2131308145);
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
      localObject2 = parame.GD(2131308109);
      d.g.b.p.g(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.az(parame.getContext(), 2131766416));
      d.g.b.p.g(localObject1, "tips");
      if ((!a((View)localObject1, parame)) || (!paramBoolean2)) {
        break;
      }
      paramT.showLikeTips = false;
      return;
      paramT = parame.GD(2131308110);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = parame.GD(2131303504);
      if ((paramT == null) || (paramT.getVisibility() != 0)) {
        break;
      }
      parame = parame.GD(2131308145);
      if (parame == null) {
        break;
      }
      parame.setVisibility(0);
      return;
    }
  }
  
  private static void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean2)
  {
    Object localObject2 = (BaseFinderFeed)parame.fUY();
    Object localObject1 = (WeImageView)parame.GD(2131308184);
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
        localObject3 = parame.fUY();
        d.g.b.p.g(localObject3, "holder.getAssociatedObject()");
        i = a(true, paramBoolean2, (BaseFinderFeed)localObject3);
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        parame = new d.o(Integer.valueOf(i), Integer.valueOf(parame.getResources().getColor(2131099809)));
        j = ((Number)parame.first).intValue();
        k = ((Number)parame.second).intValue();
        if (localObject1 != null)
        {
          parame = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
          parame = com.tencent.mm.plugin.finder.storage.logic.f.FV(((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectType);
          if (parame != null) {
            break label339;
          }
          parame = "";
          label161:
          localObject2 = (CharSequence)parame;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label361;
          }
        }
      }
    }
    label339:
    label361:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label366;
      }
      ((WeImageView)localObject1).setClearColorFilter(true);
      localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
      parame = new com.tencent.mm.plugin.finder.loader.l(parame, r.sJu);
      localObject1 = (ImageView)localObject1;
      localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((com.tencent.mm.loader.d)localObject2).a(parame, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
      return;
      if (localObject1 == null) {
        break;
      }
      ((WeImageView)localObject1).setTag(Integer.valueOf(1));
      break;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setTag(Integer.valueOf(0));
      }
      localObject3 = parame.fUY();
      d.g.b.p.g(localObject3, "holder.getAssociatedObject()");
      i = a(false, paramBoolean2, (BaseFinderFeed)localObject3);
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
      parame = new d.o(Integer.valueOf(i), Integer.valueOf(parame.getResources().getColor(2131100018)));
      break label105;
      if (al.isDarkMode())
      {
        parame = parame.GHy;
        break label161;
      }
      parame = parame.GHz;
      break label161;
    }
    label366:
    ((WeImageView)localObject1).setImageResource(j);
    ((WeImageView)localObject1).setIconColor(k);
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
          for (int i = parame.lM() - ((com.tencent.mm.view.recyclerview.d)localObject).LRV.size(); (j < k) && (i >= 0) && ((i < j) || (i > k)); i = -1)
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
      bvz localbvz = (bvz)localIterator.next();
      if (localbvz.mediaType <= 0) {
        localbvz.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  private static void b(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    View localView = parame.GD(2131304558);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_read_count_tv)");
    float f1 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getReadCount()));
    localView = parame.GD(2131304552);
    d.g.b.p.g(localView, "holder.getView<TextView>…id.self_forward_count_tv)");
    float f2 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getForwardCount()));
    localView = parame.GD(2131304553);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_like_count_tv)");
    float f3 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getLikeCount()));
    localView = parame.GD(2131304550);
    d.g.b.p.g(localView, "holder.getView<TextView>…id.self_comment_count_tv)");
    float f4 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getCommentCount()));
    localView = parame.GD(2131307971);
    d.g.b.p.g(localView, "holder.getView<TextView>(R.id.self_fav_count_tv)");
    float f5 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.h.Gg(paramT.feedObject.getFavCount()));
    paramT = parame.getContext();
    d.g.b.p.g(paramT, "holder.context");
    float f6 = paramT.getResources().getDimensionPixelSize(2131165292);
    paramT = parame.getContext();
    d.g.b.p.g(paramT, "holder.context");
    int i = paramT.getResources().getDimensionPixelSize(2131165278);
    int j = com.tencent.mm.cb.a.iu(ak.getContext());
    f1 = f5 + 1.0F + (f1 + 1.0F + (f2 + 1.0F) + (f3 + 1.0F) + (f4 + 1.0F)) + f6 * 5.0F + i;
    ae.d("Finder.FeedConvert", "contentWidthSum : " + f1 + " ,screenWidth : " + j);
    localView = parame.GD(2131308418);
    paramT = parame.GD(2131308417);
    d.g.b.p.g(paramT, "holder.getView<LinearLay…ter_op_layout_first_line)");
    paramT = (LinearLayout)paramT;
    parame = parame.GD(2131308419);
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
  
  private final void b(T paramT, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (!com.tencent.mm.plugin.finder.utils.p.d(paramT))
    {
      a(0, parame);
      paramT = parame.GD(2131303506);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, parame);
      return;
    }
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = parame.GD(2131303506);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, parame);
      d(paramT, parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.o.sXt;
      localObject2 = paramT.feedObject.getDescriptionFullSpan();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new SpannableString((CharSequence)"");
      }
      com.tencent.mm.plugin.finder.utils.o.a((SpannableString)localObject1, true);
      if (paramBoolean) {
        ((FinderCollapsibleTextView)parame.GD(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
      }
      a(true, parame);
      return;
    }
    localObject1 = parame.GD(2131303506);
    Object localObject3;
    View localView1;
    if (localObject1 == null)
    {
      localObject3 = (h)this;
      localObject2 = ((ViewStub)parame.GD(2131303507)).inflate();
      localView1 = ((View)localObject2).findViewById(2131300054);
      localObject1 = localObject2;
      if (localView1 != null)
      {
        localView1.setOnTouchListener((View.OnTouchListener)new h.ao((h)localObject3, parame));
        localView1.setOnClickListener((View.OnClickListener)new h.ap((h)localObject3, parame));
        localView1.setOnLongClickListener((View.OnLongClickListener)new h.aq((h)localObject3, parame));
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
      parame.kH(2131303503, 0);
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
          parame.kH(2131303503, 8);
          localObject1 = parame.GD(2131308110);
          if (localObject1 == null) {
            break label782;
          }
          ((View)localObject1).setVisibility(8);
          bool = false;
        }
      }
      for (;;)
      {
        parame.GD(2131308082).setOnClickListener((View.OnClickListener)new h.at(this, paramT));
        localObject1 = parame.GD(2131308083);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        parame.GD(2131303502).setOnClickListener((View.OnClickListener)new h.au(this, paramT));
        parame.GD(2131303503).setOnClickListener((View.OnClickListener)new av(paramT));
        localObject1 = com.tencent.mm.plugin.finder.utils.o.sXt;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        com.tencent.mm.plugin.finder.utils.o.a((SpannableString)localObject1, bool);
        if (paramBoolean) {
          ((FinderCollapsibleTextView)parame.GD(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
        }
        ae.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool);
        return;
        if (paramT.feedObject.isPostNoAuth())
        {
          d.g.b.p.g(localObject3, "failedTv");
          localObject1 = parame.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(2131759305)));
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)new ar(this));
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
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().Hjb >= 100))
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
          localObject1 = com.tencent.mm.plugin.finder.upload.action.g.sVv;
          a(this, ((Boolean)com.tencent.mm.plugin.finder.upload.action.g.cNz().xD(paramT.feedObject.getLocalId()).first).booleanValue(), parame, paramT);
          d.g.b.p.g(localView2, "failedArea");
          localView2.setVisibility(8);
          d.g.b.p.g(localView1, "progressArea");
          localView1.setVisibility(0);
          localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().Hjb });
          ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new as((FinderPostProgressView)localObject2));
          localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
          if (localObject3 != null) {
            ((ValueAnimator)localObject3).start();
          }
          parame.setTag(localObject1);
          ae.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().Hjb);
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
    if ((localh != null) && ((this.dvm == 3) || (this.dvm == 1) || (this.dvm == 4)))
    {
      FinderBubbleLayout localFinderBubbleLayout = (FinderBubbleLayout)parame.GD(2131308304);
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
      TextView localTextView = (TextView)parame.GD(2131308305);
      final List localList = localh.cKW();
      if (localh.sIH == null)
      {
        if (!bu.isNullOrNil(localh.getWording())) {
          break label242;
        }
        localObject = parame.getContext().getString(2131766973);
        label192:
        if (localTextView != null) {
          localTextView.setText((CharSequence)localObject);
        }
        localFinderBubbleLayout.setVisibility(0);
        localFinderBubbleLayout.setOnClickListener((View.OnClickListener)new ak(this, localh, parame, localList, paramT, bool));
      }
    }
    label242:
    do
    {
      return;
      bool = false;
      break;
      localObject = localh.getWording();
      break label192;
      parame = parame.GD(2131308304);
      if (parame != null) {
        parame.setOnClickListener(null);
      }
    } while (parame == null);
    parame.setVisibility(8);
  }
  
  private final void c(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    if (this.rUU)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.g.sVv;
      if (!bu.ht((List)com.tencent.mm.plugin.finder.upload.action.g.cNz().n(paramT.feedObject.getFeedObject())))
      {
        parame.kH(2131303868, 8);
        return;
      }
    }
    Object localObject = FinderReporterUIC.tnG;
    localObject = parame.getContext();
    d.g.b.p.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.fc((Context)localObject);
    label82:
    int j;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).sch;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!com.tencent.mm.sdk.platformtools.j.DEBUG) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)))) {
        break label412;
      }
      parame.kH(2131303868, 8);
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
      parame.kH(2131303860, 8);
      parame.kH(2131303868, 0);
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
      localObject = (TextView)parame.GD(2131303869);
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
    ae.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    parame.kH(2131303868, 8);
    return;
    label412:
    parame.kH(2131303868, 8);
  }
  
  private final void d(final T paramT, final com.tencent.mm.view.recyclerview.e parame)
  {
    ae.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + parame.lN());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)parame.GD(2131298523);
    d.g.b.p.g(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((d.g.a.m)new h.ag(this, parame, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((d.g.a.m)new ah(this, parame, paramT));
    Object localObject = parame.auu;
    d.g.b.p.g(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (d.g.a.m)new ai(this, paramT));
    if (bu.ht((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)parame.GD(2131304549);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.ajU(paramT.feedObject.field_username)) {
        break label378;
      }
      d.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ao.k(((ImageView)localObject).getContext(), 2131690331, com.tencent.mm.cb.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
    for (;;)
    {
      paramT = parame.GD(2131304548);
      paramT.setOnClickListener((View.OnClickListener)new aj(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      d.g.b.p.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(ao.k(((ImageView)localObject).getContext(), 2131690547, com.tencent.mm.cb.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
  }
  
  private final void dZ(View paramView)
  {
    paramView.setVisibility(8);
    Runnable localRunnable = this.rUS;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      this.rUS = null;
    }
  }
  
  public com.tencent.mm.bw.b a(T paramT)
  {
    d.g.b.p.h(paramT, "item");
    return paramT.likeBuffer;
  }
  
  public void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    Object localObject1 = (View.OnClickListener)new ab(parame);
    Object localObject2 = parame.GD(2131300205);
    paramRecyclerView = new y.f();
    paramRecyclerView.NiY = new ah((View)localObject2);
    d.g.b.p.g(localObject2, "footerTouchDelegateView");
    ((View)localObject2).setTouchDelegate((TouchDelegate)paramRecyclerView.NiY);
    localObject2 = (ImageView)parame.GD(2131297008);
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    ((ImageView)localObject2).post((Runnable)new h.o((ImageView)localObject2));
    localObject2 = (TextView)parame.GD(2131302863);
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    d.g.b.p.g(localObject2, "nickTv");
    al.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
    localObject1 = parame.getContext();
    d.g.b.p.g(localObject1, "holder.context");
    ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131100021));
    localObject1 = (WeImageView)parame.GD(2131302457);
    localObject2 = parame.getContext();
    d.g.b.p.g(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100018));
    localObject1 = (HardTouchableLayout)parame.GD(2131302206);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new h.t());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new m((HardTouchableLayout)localObject1, this, parame));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new n((HardTouchableLayout)localObject1, this, parame));
      localObject2 = ((HardTouchableLayout)localObject1).getContext();
      d.g.b.p.g(localObject2, "mediaContainer.context");
      paramInt = (int)((Context)localObject2).getResources().getDimension(2131165300);
      if (this.rUQ != 0) {
        break label928;
      }
      localObject1 = ((HardTouchableLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)localObject1).topMargin = paramInt;
      localObject1 = parame.GD(2131308303);
      d.g.b.p.g(localObject1, "it");
      ((View)localObject1).setBackground(null);
      ((View)localObject1).setTag(Boolean.FALSE);
    }
    for (;;)
    {
      localObject1 = new y.f();
      ((y.f)localObject1).NiY = parame.GD(2131297023);
      ((View)((y.f)localObject1).NiY).setOnTouchListener((View.OnTouchListener)new h.u(this, parame));
      ((View)((y.f)localObject1).NiY).setOnClickListener((View.OnClickListener)new h.v(this, parame));
      ((View)((y.f)localObject1).NiY).setOnLongClickListener((View.OnLongClickListener)new h.w(this, parame));
      ((View)((y.f)localObject1).NiY).setHapticFeedbackEnabled(false);
      ((View)((y.f)localObject1).NiY).post((Runnable)new x((y.f)localObject1, parame, paramRecyclerView));
      localObject1 = new y.f();
      ((y.f)localObject1).NiY = parame.GD(2131298522);
      ((View)((y.f)localObject1).NiY).post((Runnable)new y((y.f)localObject1, parame, paramRecyclerView));
      localObject1 = (FinderCollapsibleTextView)parame.GD(2131305725);
      ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g(((FinderCollapsibleTextView)localObject1).getContentTextView(), new com.tencent.mm.pluginsdk.ui.span.n(parame.getContext())));
      localObject1 = new y.f();
      ((y.f)localObject1).NiY = parame.GD(2131307333);
      localObject2 = (View)((y.f)localObject1).NiY;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new h.z(this, parame));
      }
      localObject2 = (View)((y.f)localObject1).NiY;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new aa(parame, (y.f)localObject1, paramRecyclerView));
      }
      localObject1 = new y.f();
      ((y.f)localObject1).NiY = parame.GD(2131307979);
      localObject2 = (View)((y.f)localObject1).NiY;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new h.p(this, parame));
      }
      localObject2 = (View)((y.f)localObject1).NiY;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new q(parame, (y.f)localObject1, paramRecyclerView));
      }
      parame.GD(2131302457).setOnLongClickListener((View.OnLongClickListener)new r(parame));
      paramRecyclerView = parame.GD(2131298523);
      d.g.b.p.g(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
      paramRecyclerView.setClickable(false);
      paramRecyclerView = new b(this, parame);
      parame.auu.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
      paramRecyclerView.alive();
      this.rUR.add(paramRecyclerView);
      paramRecyclerView = FinderReporterUIC.tnG;
      paramRecyclerView = parame.getContext();
      d.g.b.p.g(paramRecyclerView, "holder.context");
      paramRecyclerView = FinderReporterUIC.a.fc(paramRecyclerView);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = FinderReporterUIC.a(paramRecyclerView);
        if (paramRecyclerView != null) {
          paramRecyclerView.a((com.tencent.mm.plugin.finder.event.base.d)new s(this, parame));
        }
      }
      return;
      label928:
      if (this.rUQ == 1)
      {
        localObject2 = ((HardTouchableLayout)localObject1).getLayoutParams();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        localObject2 = parame.GD(2131308303);
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
    Object localObject1 = (BaseFinderFeed)parame.fUY();
    if (!((BaseFinderFeed)localObject1).feedObject.isPostFinish()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.rUW.cCl());
      paramView = com.tencent.mm.plugin.finder.upload.action.g.sVv;
      paramView = com.tencent.mm.plugin.finder.upload.action.g.cNz().k(((BaseFinderFeed)localObject1).feedObject.getFeedObject());
      bool1 = ((Boolean)paramView.first).booleanValue();
      bool2 = ((Boolean)paramView.second).booleanValue();
    } while ((bool1) && (bool2));
    if (bool1)
    {
      WeImageView localWeImageView = (WeImageView)parame.GD(2131301417);
      paramView = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
      paramView = com.tencent.mm.plugin.finder.storage.logic.f.FV(((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectType);
      int i;
      if (paramView == null)
      {
        paramView = "";
        Object localObject2 = (CharSequence)paramView;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label273;
        }
        i = 1;
        label167:
        if (i != 0) {
          break label278;
        }
        localWeImageView.setClearColorFilter(true);
        parame = com.tencent.mm.plugin.finder.loader.i.srW;
        parame = com.tencent.mm.plugin.finder.loader.i.cEn();
        paramView = new com.tencent.mm.plugin.finder.loader.l(paramView, r.sJu);
        d.g.b.p.g(localWeImageView, "likeIconBanner");
        localObject1 = (ImageView)localWeImageView;
        localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
        parame.a(paramView, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
      }
      for (;;)
      {
        parame = com.tencent.mm.plugin.finder.view.animation.c.tiL;
        d.g.b.p.g(localWeImageView, "likeIconBanner");
        com.tencent.mm.plugin.finder.view.animation.c.ek((View)localWeImageView);
        return;
        if (al.isDarkMode())
        {
          paramView = paramView.GHw;
          break;
        }
        paramView = paramView.GHx;
        break;
        label273:
        i = 0;
        break label167;
        label278:
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.j(((BaseFinderFeed)localObject1).contact))
        {
          paramView = parame.getContext();
          parame = parame.getContext();
          d.g.b.p.g(parame, "holder.context");
          localWeImageView.setImageDrawable(ao.k(paramView, 2131691596, parame.getResources().getColor(2131099809)));
        }
        else
        {
          paramView = parame.getContext();
          parame = parame.getContext();
          d.g.b.p.g(parame, "holder.context");
          localWeImageView.setImageDrawable(ao.k(paramView, 2131690326, parame.getResources().getColor(2131099809)));
        }
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
          if ((localObject1 instanceof d.o))
          {
            localObject1 = (d.o)localObject1;
            switch (((Number)((d.o)localObject1).first).intValue())
            {
            default: 
              break;
            case 1: 
              d(paramT, parame);
              return;
              paramInt1 = 0;
              break;
            case 2: 
              b(paramT, parame, false);
              return;
            case 3: 
              paramList = com.tencent.mm.plugin.finder.upload.action.g.sVv;
              paramList = com.tencent.mm.plugin.finder.upload.action.g.cNz().k(paramT.feedObject.getFeedObject());
              paramBoolean = ((Boolean)paramList.first).booleanValue();
              ((Boolean)paramList.second).booleanValue();
              if (!paramBoolean) {
                a(this, false, parame, paramT);
              }
              a(paramT, parame);
              c(paramT, parame);
              a(paramT, parame, true);
              return;
            case 4: 
              paramList = com.tencent.mm.plugin.finder.upload.action.c.sVf;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.c.cNx().i(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.c.sVf;
              a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.c.cNx().j(paramT.feedObject.getFeedObject()), parame);
              return;
            case 5: 
              b(parame, paramT);
              return;
            case 6: 
              paramList = ((d.o)localObject1).second;
              if (paramList == null) {
                throw new v("null cannot be cast to non-null type com.tencent.mm.autogen.events.FeedUpdateEvent");
              }
              paramList = (hf)paramList;
              if (paramList.duE.duG == 1) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                paramT.showCommentEdu = paramBoolean;
                if (paramT.feedObject.isCommentClose()) {
                  break;
                }
                a(parame, paramT, paramList.duE.duF);
                return;
              }
            }
          }
        }
      }
    }
    paramList = parame.GD(2131301417);
    d.g.b.p.g(paramList, "holder.getView<View>(R.id.like_icon)");
    paramList.setVisibility(8);
    parame.GD(2131302457).setOnClickListener((View.OnClickListener)new k(this, parame));
    paramT.feedObject.getTopicClickExtra().aWN = new WeakReference(parame.getContext());
    label550:
    label613:
    Object localObject2;
    label642:
    label665:
    Object localObject3;
    if (!this.rUW.cCl())
    {
      paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.s(paramT.feedObject.getFeedObject())) {}
    }
    else
    {
      parame.kH(2131306206, 0);
      parame.e(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.h.l(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      b(paramT);
      parame.kH(2131296976, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label1866;
        }
        paramInt1 = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = parame.GD(2131296977);
        d.g.b.p.g(localObject1, "holder.getView<ImageView>(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject1, paramList.field_authInfo);
      }
      switch (paramInt1)
      {
      default: 
        paramList = z.Nhr;
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
              break label1981;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).czm();
            localObject1 = bu.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.c.rPy;
            localObject2 = c.a.ahT(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!bu.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).czm())) {
                paramList = ((com.tencent.mm.plugin.finder.api.g)localObject2).czm();
              }
              localObject1 = z.Nhr;
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
            localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
            paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
            localObject2 = parame.GD(2131297008);
            d.g.b.p.g(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
            paramList = z.Nhr;
          }
          if (paramBoolean) {
            break label3339;
          }
          paramList = parame.GD(2131298775);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label1987;
          }
          paramInt1 = 1;
          label824:
          if (paramInt1 == 0) {
            break label1997;
          }
          parame.kH(2131305725, 8);
          if (paramList == null) {
            break label1992;
          }
          localObject1 = paramList.getContext();
          d.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = z.Nhr;
          paramInt1 = 0;
          label899:
          paramList = parame.GD(2131307449);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          paramList = parame.GD(2131307449);
          if (paramList != null) {
            paramList.setAlpha(1.0F);
          }
          localObject1 = paramT.feedObject.getFoldedLayout();
          if (localObject1 != null)
          {
            if ((((ank)localObject1).sgH != 1) || (this.rUU)) {
              break label2211;
            }
            paramList = parame.GD(2131307449);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
          }
          label991:
          b(parame, paramT);
          paramList = parame.GD(2131308309);
          paramInt2 = paramInt1;
          if (paramList != null) {
            paramList.setVisibility(8);
          }
        }
        break;
      }
    }
    label2691:
    label3336:
    label3339:
    for (paramInt2 = paramInt1;; paramInt2 = 0)
    {
      d(paramT, parame);
      label1038:
      label1080:
      label1114:
      label1390:
      Object localObject4;
      label1317:
      label1717:
      float f;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        b(paramT, parame, paramBoolean);
        if (bu.isNullOrNil(paramT.headerWording)) {
          break label2724;
        }
        parame.kH(2131300730, 0);
        parame.e(2131300729, (CharSequence)paramT.headerWording);
        if (bu.isNullOrNil(paramT.footerWording)) {
          break label2737;
        }
        parame.kH(2131300213, 0);
        parame.e(2131300211, (CharSequence)paramT.footerWording);
        a(parame, paramT);
        d.g.b.p.h(parame, "holder");
        ((TextView)parame.GD(2131302863)).post((Runnable)new az(parame));
        c(paramT, parame);
        a(parame, paramT, 1);
        a(paramT, parame, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.g.sVv;
        paramList = com.tencent.mm.plugin.finder.upload.action.g.cNz().xD(paramT.feedObject.getLocalId());
        a(((Boolean)paramList.first).booleanValue(), parame, ((Boolean)paramList.second).booleanValue());
        paramList = com.tencent.mm.plugin.finder.upload.action.g.sVv;
        a(((Boolean)com.tencent.mm.plugin.finder.upload.action.g.cNz().k(paramT.feedObject.getFeedObject()).first).booleanValue(), parame, paramT, true);
        paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
        if ((!com.tencent.mm.plugin.finder.utils.p.d(paramT)) || (!paramT.showShareSns)) {
          break label2790;
        }
        if (paramT.feedObject.isPostFinish()) {
          break label2750;
        }
        paramList = parame.GD(2131308421);
        if (paramList != null)
        {
          paramList.setVisibility(0);
          paramList.setOnClickListener((View.OnClickListener)new h.c(parame));
        }
        localObject2 = paramT.feedObject.getLocation();
        paramList = parame.GD(2131303355);
        localObject1 = (TextView)parame.GD(2131303336);
        localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.gD(((apl)localObject2).eRg, ((apl)localObject2).jGd);
        if (!bu.isNullOrNil((String)localObject2)) {
          break label2814;
        }
        d.g.b.p.g(paramList, "positionLayout");
        paramList.setVisibility(8);
        paramList = z.Nhr;
        paramList = parame.GD(2131301435);
        d.g.b.p.g(paramList, "linkLayout");
        paramList.setVisibility(8);
        localObject1 = paramT.feedObject.getExtReading();
        if ((!bu.isNullOrNil(((amz)localObject1).link)) && (!bu.isNullOrNil(((amz)localObject1).title)))
        {
          localObject2 = ((amz)localObject1).link;
          localObject3 = ((amz)localObject1).title;
          localObject4 = (TextView)parame.GD(2131301436);
          parame.e(2131301436, (CharSequence)localObject3);
          ae.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((amz)localObject1).title);
          paramList.post((Runnable)new i((TextView)localObject4, (String)localObject3, parame, paramList, paramT));
          paramList.setVisibility(0);
          ((TextView)localObject4).setOnClickListener((View.OnClickListener)new j((String)localObject2, parame, paramList, paramT));
        }
        paramList = z.Nhr;
        localObject1 = parame.GD(2131303869);
        paramList = parame.GD(2131298523);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
        {
          localObject1 = paramList.getContext();
          d.g.b.p.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = z.Nhr;
        }
        a(paramT, parame);
        paramList = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.d(paramT)) {
          break label2894;
        }
        paramT = parame.GD(2131308375);
        if (paramT != null) {
          paramT.setVisibility(8);
        }
        localObject2 = (FinderMediaBanner)parame.GD(2131302203);
        f = 1.0F * ((FinderMediaBanner)localObject2).getPagerView().getLayoutParams().height / ((FinderMediaBanner)localObject2).getPagerView().getLayoutParams().width;
        paramT = (TextView)parame.GD(2131302863);
        paramList = (WeImageView)parame.GD(2131302457);
        localObject1 = (TextView)parame.GD(2131296976);
        if ((this.rUQ != 2) || (f < 1.316667F)) {
          break label3110;
        }
        localObject2 = (HardTouchableLayout)parame.GD(2131302206);
        d.g.b.p.g(localObject2, "mediaContainer");
        localObject3 = ((HardTouchableLayout)localObject2).getLayoutParams();
        if (localObject3 != null) {
          break label2945;
        }
        throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        parame.kH(2131306206, 8);
        break;
        label1866:
        paramInt1 = 0;
        break label550;
        parame.kH(2131296977, 0);
        parame.kH(2131296976, 0);
        localObject1 = (TextView)parame.GD(2131296976);
        d.g.b.p.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
        paramList = parame.getContext();
        d.g.b.p.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099734));
        paramList = z.Nhr;
        break label613;
        parame.kH(2131296977, 0);
        break label613;
        paramList = null;
        break label642;
        label1981:
        localObject1 = null;
        break label665;
        label1987:
        paramInt1 = 0;
        break label824;
        label1992:
        paramInt1 = 0;
        break label899;
        label1997:
        if (paramList != null)
        {
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = z.Nhr;
        }
        paramList = parame.GD(2131305725);
        if (paramT.feedObject.getMediaList().size() <= 1) {
          if (paramList != null)
          {
            localObject1 = paramList.getContext();
            d.g.b.p.g(localObject1, "context");
            paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165303);
            paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = z.Nhr;
          }
        }
        for (;;)
        {
          parame.kH(2131305725, 0);
          paramList = (FinderCollapsibleTextView)parame.GD(2131305725);
          paramList.setCollapse(paramT.isContentCollapsed);
          paramList.setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
          paramList.setOnCollapse((d.g.a.b)new l(paramT, parame));
          paramInt1 = 1;
          break;
          if (paramList != null)
          {
            paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = z.Nhr;
          }
        }
        label2211:
        if ((((ank)localObject1).sgH != 1) && (((ank)localObject1).sgH != 2)) {
          break label991;
        }
        paramList = parame.GD(2131307449);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = parame.GD(2131307449);
        if (paramList != null) {
          break label3336;
        }
        paramList = ((ViewStub)parame.GD(2131307450)).inflate();
      }
      for (;;)
      {
        localObject2 = paramList.findViewById(2131307451);
        localObject3 = paramList.findViewById(2131307494);
        if (((ank)localObject1).sgH == 1)
        {
          d.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          d.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(8);
          label2336:
          localObject2 = (TextView)paramList.findViewById(2131307338);
          if (((ank)localObject1).sgH != 1) {
            break label2595;
          }
          localObject3 = parame.getContext();
          localObject4 = parame.getContext();
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject3 = k.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(2131766421, new Object[] { com.tencent.mm.plugin.finder.utils.p.gC(((ank)localObject1).username, ""), String.valueOf(((ank)localObject1).fVS) }));
          d.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)k.c(parame.getContext(), (CharSequence)localObject3));
          label2450:
          localObject2 = paramT.feedObject.getFoldedFeedList();
          localObject3 = (FinderFoldedScrollLayout)parame.GD(2131307336);
          d.g.b.p.g(localObject3, "foldedScrollLayout");
          localObject4 = ((FinderFoldedScrollLayout)localObject3).getLayoutParams();
          if (((ank)localObject1).sgH != 2) {
            break label2673;
          }
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cb.a.fromDPToPix(parame.getContext(), 208);
          label2510:
          ((FinderFoldedScrollLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (!bu.ht((List)localObject2)) {
            break label2691;
          }
          ((FinderFoldedScrollLayout)localObject3).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(2131307337).setOnClickListener((View.OnClickListener)new h.al(this, (List)localObject2, paramT, (ank)localObject1, parame));
          break;
          d.g.b.p.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          d.g.b.p.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(0);
          break label2336;
          label2595:
          localObject3 = k.c(parame.getContext(), (CharSequence)parame.getContext().getString(2131766420, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((ank)localObject1).fVS) }));
          d.g.b.p.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)k.c(parame.getContext(), (CharSequence)localObject3));
          break label2450;
          label2673:
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cb.a.fromDPToPix(parame.getContext(), 240);
          break label2510;
          ((FinderFoldedScrollLayout)localObject3).setVisibility(0);
          ((FinderFoldedScrollLayout)localObject3).setup((com.tencent.mm.plugin.finder.view.n)new com.tencent.mm.plugin.finder.view.g((ank)localObject1, paramT));
        }
        paramBoolean = false;
        break label1038;
        label2724:
        parame.kH(2131300730, 8);
        break label1080;
        label2737:
        parame.kH(2131300213, 8);
        break label1114;
        label2750:
        paramList = parame.GD(2131308421);
        if (paramList == null) {
          break label1317;
        }
        paramList.setVisibility(0);
        paramList.setOnClickListener((View.OnClickListener)new d(this, parame));
        break label1317;
        label2790:
        paramList = parame.GD(2131308421);
        if (paramList == null) {
          break label1317;
        }
        paramList.setVisibility(8);
        break label1317;
        label2814:
        d.g.b.p.g(localObject1, "poiTv");
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).post((Runnable)new g(paramList, (TextView)localObject1, (String)localObject2, this, parame, paramT));
        d.g.b.p.g(paramList, "positionLayout");
        paramList.setVisibility(0);
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new h((String)localObject2, this, parame, paramT));
        break label1390;
        label2894:
        if (paramT.feedObject.isPrivate())
        {
          paramT = parame.GD(2131308375);
          if (paramT == null) {
            break label1717;
          }
          paramT.setVisibility(0);
          break label1717;
        }
        paramT = parame.GD(2131308375);
        if (paramT == null) {
          break label1717;
        }
        paramT.setVisibility(8);
        break label1717;
        ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
        localObject3 = parame.GD(2131308303);
        d.g.b.p.g(localObject3, "it");
        ((View)localObject3).setBackground(((HardTouchableLayout)localObject2).getResources().getDrawable(2131235046));
        ((View)localObject3).setTag(Boolean.TRUE);
        for (;;)
        {
          localObject2 = parame.GD(2131308303);
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
          label3110:
          if ((this.rUQ == 2) && (f < 1.316667F))
          {
            d.g.b.p.g(localObject2, "banner");
            localObject2 = ((FinderMediaBanner)localObject2).getContext();
            d.g.b.p.g(localObject2, "banner.context");
            paramInt1 = (int)((Context)localObject2).getResources().getDimension(2131165300);
            localObject2 = (HardTouchableLayout)parame.GD(2131302206);
            d.g.b.p.g(localObject2, "mediaContainer");
            localObject2 = ((HardTouchableLayout)localObject2).getLayoutParams();
            if (localObject2 == null) {
              throw new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt1;
            localObject2 = parame.GD(2131308303);
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class aa
    implements Runnable
  {
    aa(com.tencent.mm.view.recyclerview.e parame, y.f paramf1, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201770);
      int i = com.tencent.mm.cb.a.ay(this.oTF.getContext(), 2131165303);
      Rect localRect = new Rect();
      ((View)this.rVC.NiY).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((ah)paramRecyclerView.NiY).a(new ai(localRect, (View)this.rVC.NiY));
      AppMethodBeat.o(201770);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ab
    implements View.OnClickListener
  {
    ab(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165362);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = (BaseFinderFeed)this.oTF.fUY();
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = this.oTF.getContext();
      d.g.b.p.g(localObject1, "holder.context");
      localObject1 = FinderReporterUIC.a.fc((Context)localObject1);
      int i;
      if (localObject1 != null) {
        i = ((FinderReporterUIC)localObject1).sch;
      }
      while ((i == 1) || (i == 8))
      {
        ae.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.a(3, paramView.lP(), i, 1, paramView.feedObject.getUserName());
        paramView = this.oTF.getContext();
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
      Object localObject2 = FinderReporterUIC.tnG;
      localObject2 = this.oTF.getContext();
      d.g.b.p.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, paramView.lP(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject2 = this.oTF.getContext();
      d.g.b.p.g(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((this.oTF.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.KEX;
        localObject1 = this.oTF.getContext();
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165362);
          throw paramView;
        }
        localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).cAI().wk(paramView.lP());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(3, paramView.lP(), i, 1, paramView.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165362);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ac
    implements Runnable
  {
    ac(BaseFinderFeed paramBaseFinderFeed, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201771);
      if (this.rVf.isContentCollapsed)
      {
        Object localObject1 = localFinderCollapsibleTextView;
        Object localObject2 = ((FinderCollapsibleTextView)localObject1).getCollapseTextView();
        d.g.b.p.g(localObject2, "collapseTextView");
        if ((((TextView)localObject2).getVisibility() != 0) || (!((FinderCollapsibleTextView)localObject1).tdC))
        {
          AppMethodBeat.o(201771);
          return;
        }
        localObject2 = com.tencent.mm.ui.component.a.KEX;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        FinderHomeTabStateVM.cQP();
        localObject1 = ((FinderCollapsibleTextView)localObject1).getTipsTv();
        if (((View)localObject1).getVisibility() == 8)
        {
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).animate().alpha(1.0F).setDuration(300L).start();
        }
      }
      AppMethodBeat.o(201771);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ad
    implements Runnable
  {
    ad(h paramh, View paramView, com.tencent.mm.view.recyclerview.e parame, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201772);
      int i = this.rVE.getHeight();
      int j = aa.iK(this.oTF.getContext()) - this.rVF + i;
      ae.i("Finder.FeedConvert", "[openCommentDrawer] offset=" + j + " itemBottom=" + this.rVG + " recyclerViewBottom=" + h.f(this.rVd).bottom + " editLayoutHeight=" + i);
      if (j > 0)
      {
        FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = h.d(this.rVd).getVideoCore().tam;
        if (localFinderVideoAutoPlayManager != null) {
          FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, "openCommentDrawer", true);
        }
        this.oTF.getRecyclerView().smoothScrollBy(0, j);
      }
      AppMethodBeat.o(201772);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class ae
    implements CommentDrawerContract.CloseDrawerCallback
  {
    ae(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, y.d paramd) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.n> paramList)
    {
      AppMethodBeat.i(201773);
      d.g.b.p.h(paramList, "data");
      ((FinderFeedExposeLayout)this.oTF.GD(2131298523)).GE(this.rVf.feedObject.getCommentCount());
      paramList = h.d(this.rVd).getVideoCore().tam;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (h.d(this.rVd).cCl())
      {
        paramList = this.oTF.GD(2131304550);
        d.g.b.p.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.h.fR(1, this.rVf.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJG().value()).intValue() == 1) {
        this.oTF.getRecyclerView().smoothScrollBy(0, -this.rVH.NiW);
      }
      AppMethodBeat.o(201773);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class ah
    extends q
    implements d.g.a.m<View, FinderCommentInfo, z>
  {
    ah(h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class ai
    extends q
    implements d.g.a.m<FinderCommentInfo, Boolean, z>
  {
    ai(h paramh, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aj
    implements View.OnClickListener
  {
    aj(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201775);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.rVL.getOnCommentClickListener();
      if (paramView != null)
      {
        localObject = paramT;
        d.g.b.p.g(localObject, "selfCommentContainer");
        paramView.p(localObject, null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201775);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(h paramh, com.tencent.mm.plugin.finder.storage.h paramh1, com.tencent.mm.view.recyclerview.e parame, List paramList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      int j = 0;
      String str = null;
      AppMethodBeat.i(201776);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFavSimilar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      Object localObject3;
      Object localObject2;
      long l1;
      int i;
      if (bu.isNullOrNil(localh.getWording()))
      {
        paramView = parame.getContext().getString(2131766973);
        d.g.b.p.g(paramView, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
        localObject3 = localList;
        BaseFinderFeed localBaseFinderFeed = paramT;
        com.tencent.mm.view.recyclerview.e locale = parame;
        localObject1 = localh.sIH;
        if (localObject1 != null)
        {
          localObject2 = ((anf)localObject1).lastBuffer;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = null;
        }
        h.a(paramView, (List)localObject3, localBaseFinderFeed, locale, (com.tencent.mm.bw.b)localObject1, bool);
        paramView = FinderReporterUIC.tnG;
        paramView = parame.getContext();
        d.g.b.p.g(paramView, "holder.context");
        localObject2 = FinderReporterUIC.a.fc(paramView);
        paramView = com.tencent.mm.plugin.finder.report.i.syT;
        l1 = paramT.lP();
        if (localObject2 == null) {
          break label296;
        }
        i = ((FinderReporterUIC)localObject2).sch;
        label189:
        if (localObject2 == null) {
          break label301;
        }
        paramView = ((FinderReporterUIC)localObject2).rfo;
        label200:
        if (localObject2 == null) {
          break label306;
        }
      }
      label296:
      label301:
      label306:
      for (localObject1 = ((FinderReporterUIC)localObject2).rfA;; localObject1 = null)
      {
        if (localObject2 != null) {
          str = ((FinderReporterUIC)localObject2).sessionId;
        }
        localObject3 = com.tencent.mm.plugin.finder.report.i.syT;
        long l2 = paramT.lP();
        if (localObject2 != null) {
          j = ((FinderReporterUIC)localObject2).sch;
        }
        com.tencent.mm.plugin.finder.report.i.a(l1, 3, i, paramView, (String)localObject1, str, com.tencent.mm.plugin.finder.report.i.I(l2, j));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFavSimilar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201776);
        return;
        paramView = localh.getWording();
        break;
        i = 0;
        break label189;
        paramView = null;
        break label200;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class am
    implements View.OnClickListener
  {
    am(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201778);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.oTF.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307396);; paramView = null)
      {
        if (paramView == null) {
          d.g.b.p.gkB();
        }
        paramView.a(paramT.feedObject, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201778);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ar
    implements View.OnClickListener
  {
    ar(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165374);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = h.d(this.rVd).getActivity();
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.d((Activity)paramView, ".ui.FinderHomeUI");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165374);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class as
    implements ValueAnimator.AnimatorUpdateListener
  {
    as(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201783);
      FinderPostProgressView localFinderPostProgressView = this.rVS;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201783);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.rVS.invalidate();
      AppMethodBeat.o(201783);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class av
    implements View.OnClickListener
  {
    av(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201785);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.upload.g.sUx;
      com.tencent.mm.plugin.finder.upload.g.cNo().k(this.rVf.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201785);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
  static final class ay
    implements View.OnClickListener
  {
    ay(h paramh, com.tencent.mm.view.recyclerview.e parame, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201788);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = new aug();
      ((aug)localObject).duw = paramT.lP();
      ((aug)localObject).objectNonceId = paramT.feedObject.getObjectNonceId();
      ((aug)localObject).scene = 2;
      paramView = FinderReporterUIC.tnG;
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fc(paramView);
      if (paramView != null)
      {
        paramView = paramView.cQZ();
        ((aug)localObject).rQw = paramView;
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
          d.g.b.p.gkB();
        }
        paramView.a(paramT.feedObject, this.rVd.a(paramT));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201788);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class az
    implements Runnable
  {
    az(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oTF.fUY();
      if (localBaseFinderFeed == null)
      {
        ae.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.oTF.GD(2131297934);
      d.g.b.p.g(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.oTF.GD(2131296977);
        localObject1 = (TextView)this.oTF.GD(2131300192);
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
            float f = com.tencent.mm.cb.a.ax(this.oTF.getContext(), 2131165294);
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
          localObject1 = (TextView)this.oTF.GD(2131302863);
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
          this.oTF.e(2131302863, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends com.tencent.mm.sdk.b.c<hb>
    implements View.OnAttachStateChangeListener
  {
    final h<T> rUZ;
    final com.tencent.mm.view.recyclerview.e rVa;
    
    public b(h<T> paramh, com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(165341);
      this.rUZ = paramh;
      this.rVa = parame;
      if ((this.rVa.getContext() instanceof MMActivity))
      {
        paramh = this.rVa.getContext();
        if (paramh == null)
        {
          paramh = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw paramh;
        }
        ((MMActivity)paramh).getLifecycle().addObserver((LifecycleObserver)h.a(this.rUZ));
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
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(h.b paramb, hb paramhb)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class bb
    implements n.d
  {
    bb(h paramh) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(201791);
      d.g.b.p.g(paraml, "it");
      if (paraml.fCR())
      {
        paraml.jM(h.b(this.rVd), 2131767037);
        paraml.jM(h.c(this.rVd), 2131767039);
      }
      AppMethodBeat.o(201791);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class bc
    implements n.e
  {
    bc(h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201792);
      d.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == h.b(this.rVd))
      {
        h.d(this.rVd).a(this.rVf.feedObject);
        AppMethodBeat.o(201792);
        return;
      }
      if (paramInt == h.c(this.rVd))
      {
        paramMenuItem = h.d(this.rVd);
        BaseFinderFeed localBaseFinderFeed = this.rVf;
        d.g.b.p.g(localBaseFinderFeed, "item");
        paramMenuItem.g(localBaseFinderFeed);
      }
      AppMethodBeat.o(201792);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onDismiss"})
  static final class bd
    implements e.b
  {
    bd(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(201793);
      Object localObject = FinderReporterUIC.tnG;
      localObject = this.oTF.getContext();
      d.g.b.p.g(localObject, "holder.context");
      localObject = FinderReporterUIC.a.fc((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oTF.fUY();
        com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.a(localBaseFinderFeed.feedObject.getId(), 1, 3L, "", (arn)localObject);
        AppMethodBeat.o(201793);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bf
    implements Runnable
  {
    bf(h paramh, BaseFinderFeed paramBaseFinderFeed, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201795);
      paramT.showLikeTips = false;
      this.rWg.setVisibility(8);
      h.e(this.rVd);
      AppMethodBeat.o(201795);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201752);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.m.sWJ;
      paramView = h.d(this.rVd).getActivity();
      if (paramView == null) {
        d.g.b.p.gkB();
      }
      localObject = parame.fUY();
      d.g.b.p.g(localObject, "holder.getAssociatedObject<T>()");
      m.a.a(paramView, (BaseFinderFeed)localObject, 5, 4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$checkShowShareSnsLayout$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201752);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(h paramh, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.rVd.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)new d(this), (d.g.a.a)new c(this));
        if (this.rVe.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.rVd;
        localObject = this.crf;
        this.crf.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, this.crf.getString(2131755936), false, (DialogInterface.OnCancelListener)a.rVh));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.rVe.client_id;
      if (localObject != null) {}
      for (long l = Long.parseLong((String)localObject);; l = 0L)
      {
        paramDialogInterface.xe(l);
        AppMethodBeat.o(165347);
        return;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rVh;
      
      static
      {
        AppMethodBeat.i(165342);
        rVh = new a();
        AppMethodBeat.o(165342);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(h.e parame, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(h.e parame)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<a.a<aox>, Boolean>
  {
    f(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$10$1"})
  static final class g
    implements Runnable
  {
    g(View paramView, TextView paramTextView, String paramString, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.rVm;
      d.g.b.p.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.rVn;
        d.g.b.p.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.rVo) + j > i)
        {
          localObject = this.rVn;
          d.g.b.p.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.rVo;
          TextView localTextView = this.rVn;
          d.g.b.p.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$10$2"})
  static final class h
    implements View.OnClickListener
  {
    h(String paramString, h paramh, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIc())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cIe()) {
          if (h.c(paramT))
          {
            paramView = new Intent();
            paramView.putExtra("key_topic_type", 2);
            paramView.putExtra("key_ref_object_id", paramT.feedObject.getId());
            paramView.putExtra("key_topic_title", this.rVo);
            paramView.putExtra("key_topic_poi_location", paramT.feedObject.getLocation().toByteArray());
            paramView.putExtra("KEY_TAB_TYPE", jdField_this.dvm);
            localObject = FinderReporterUIC.tnG;
            localObject = parame.getContext();
            d.g.b.p.g(localObject, "holder.context");
            FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
            localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
            localObject = parame.getContext();
            d.g.b.p.g(localObject, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.J((Context)localObject, paramView);
            paramView = FinderReporterUIC.tnG;
            paramView = parame.getContext();
            d.g.b.p.g(paramView, "holder.context");
            FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.fc(paramView);
            if (localFinderReporterUIC != null)
            {
              paramView = com.tencent.mm.plugin.finder.report.i.syT;
              long l = paramT.lP();
              localObject = this.rVo;
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              com.tencent.mm.plugin.finder.report.i.a(l, paramView, 2, localFinderReporterUIC.sch);
              paramView = FinderReporterUIC.b(localFinderReporterUIC);
              if (paramView != null) {
                paramView.cAI().wo(paramT.lP());
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
        ae.i("Finder.FeedConvert", "click poi but isPostOk false");
        continue;
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        paramView = parame.getContext();
        d.g.b.p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.p.a(paramView, paramT.feedObject.getLocation());
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
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
        int j = com.tencent.mm.cb.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.rVq;
        d.g.b.p.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.rVr) + j > i)
        {
          localObject = this.rVq;
          d.g.b.p.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.rVr;
          TextView localTextView = this.rVq;
          d.g.b.p.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
  static final class j
    implements View.OnClickListener
  {
    j(String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = FinderReporterUIC.tnG;
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fc(paramView);
      if (paramView != null) {}
      for (int i = paramView.sch;; i = 0)
      {
        paramView = new Intent();
        localObject = com.tencent.mm.ah.m.d(this.rVt, 156, i + 10000, (int)(System.currentTimeMillis() / 1000L));
        ae.i("Finder.FeedConvert", "click linkLayout, url:" + this.rVt + ", urlWithReportParams:" + (String)localObject);
        paramView.putExtra("rawUrl", (String)localObject);
        com.tencent.mm.br.d.b(parame.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        paramView = FinderReporterUIC.tnG;
        paramView = parame.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fc(paramView);
        if (paramView != null)
        {
          paramView = FinderReporterUIC.b(paramView);
          if (paramView != null) {
            paramView.cAI().wt(paramT.lP());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165351);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201755);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = (BaseFinderFeed)parame.fUY();
      localObject = new com.tencent.mm.ui.widget.a.e(parame.getContext(), 0, false);
      com.tencent.mm.plugin.finder.feed.h localh = h.d(this.rVd);
      d.g.b.p.g(paramView, "item");
      ((com.tencent.mm.ui.widget.a.e)localObject).a(localh.a(paramView, (com.tencent.mm.ui.widget.a.e)localObject));
      ((com.tencent.mm.ui.widget.a.e)localObject).b(h.d(this.rVd).e(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).a(h.d(this.rVd).f(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).b(h.d(this.rVd).f(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).b((e.b)new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(201754);
          Object localObject = FinderReporterUIC.tnG;
          localObject = this.rVu.oTF.getContext();
          d.g.b.p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.fc((Context)localObject);
          if (localObject != null) {}
          for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
          {
            BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.rVu.oTF.fUY();
            com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.syT;
            com.tencent.mm.plugin.finder.report.i.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", (arn)localObject);
            AppMethodBeat.o(201754);
            return;
          }
        }
      });
      ((com.tencent.mm.ui.widget.a.e)localObject).cPF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201755);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.b<Boolean, z>
  {
    l(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class m
    implements HardTouchableLayout.b
  {
    m(HardTouchableLayout paramHardTouchableLayout, h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void ea(View paramView)
    {
      AppMethodBeat.i(165353);
      d.g.b.p.h(paramView, "view");
      ae.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)parame.fUY());
      jdField_this.a(parame, (View)this.rVv);
      AppMethodBeat.o(165353);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.g
  {
    n(HardTouchableLayout paramHardTouchableLayout, h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void eb(View paramView)
    {
      AppMethodBeat.i(165354);
      d.g.b.p.h(paramView, "view");
      ae.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)parame.fUY());
      jdField_this.a(parame, (View)this.rVv, ((BaseFinderFeed)parame.fUY()).feedObject.getFeedObject());
      AppMethodBeat.o(165354);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class q
    implements Runnable
  {
    q(com.tencent.mm.view.recyclerview.e parame, y.f paramf1, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201759);
      int i = com.tencent.mm.cb.a.ay(this.oTF.getContext(), 2131165303);
      Rect localRect = new Rect();
      ((View)this.rVx.NiY).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((ah)paramRecyclerView.NiY).a(new ai(localRect, (View)this.rVx.NiY));
      AppMethodBeat.o(201759);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class r
    implements View.OnLongClickListener
  {
    r(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201760);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.oTF.fUY();
      paramView = (FinderVideoLayout)this.oTF.GD(2131299975);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.suv;; paramView = null)
      {
        localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = this.oTF.getContext();
        if (localObject != null) {
          break;
        }
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201760);
        throw paramView;
      }
      FinderDebugUIC localFinderDebugUIC = (FinderDebugUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject).get(FinderDebugUIC.class);
      Context localContext = this.oTF.getContext();
      d.g.b.p.g(localContext, "holder.context");
      d.g.b.p.g(localBaseFinderFeed, "item");
      com.tencent.mm.view.recyclerview.e locale = this.oTF;
      d.g.b.p.h(localContext, "context");
      d.g.b.p.h(localBaseFinderFeed, "item");
      d.g.b.p.h(locale, "holder");
      com.tencent.mm.ui.widget.a.e locale1 = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
      long l = localBaseFinderFeed.lP();
      localObject = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
      boolean bool;
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      if ((localObject != null) && (((bvz)localObject).mediaType == 4))
      {
        bool = true;
        localJSONObject1 = new JSONObject();
        localJSONObject2 = localJSONObject1.put("tag", "ClickMoreDebug").put("feedId", com.tencent.mm.ac.c.rp(localBaseFinderFeed.feedObject.getId())).put("feedTime", bu.DA(localBaseFinderFeed.feedObject.getCreateTime() * 1L));
        localObject = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (localObject == null) {
          break label895;
        }
        localObject = Integer.valueOf(((bvz)localObject).videoDuration);
        label333:
        localObject = localJSONObject2.put("videoDuration", localObject).put("signedFeedId", localBaseFinderFeed.feedObject.getId()).put("isVideo", bool);
        if (paramView == null) {
          break label901;
        }
        paramView = paramView.sry;
        label373:
        paramView = ((JSONObject)localObject).put("file_format", paramView).put("username", localBaseFinderFeed.feedObject.field_username);
        localObject = com.tencent.mm.plugin.finder.api.c.rPy;
        localJSONObject2 = paramView.put("isFollow", c.a.ahW(localBaseFinderFeed.feedObject.field_username)).put("mediaType", localBaseFinderFeed.feedObject.getMediaType());
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
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
        localObject = localJSONObject2.put("mediaId", com.tencent.mm.sdk.platformtools.aj.ej(paramView));
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label906;
        }
        paramView = paramView.url;
        label514:
        localObject = ((JSONObject)localObject).put("url", paramView);
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label911;
        }
        paramView = paramView.thumbUrl;
        label552:
        localObject = ((JSONObject)localObject).put("thumbUrl", paramView);
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label916;
        }
        paramView = paramView.thumb_url_token;
        label590:
        localObject = ((JSONObject)localObject).put("thumbUrlToken", paramView);
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label921;
        }
        paramView = paramView.coverUrl;
        label628:
        localObject = ((JSONObject)localObject).put("coverUrl", paramView);
        paramView = (bvz)d.a.j.jm((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label926;
        }
      }
      label901:
      label906:
      label911:
      label916:
      label921:
      label926:
      for (paramView = paramView.cover_url_token;; paramView = null)
      {
        localJSONObject2 = ((JSONObject)localObject).put("coverUrlToken", paramView).put("description", localBaseFinderFeed.feedObject.getDescription());
        localObject = localBaseFinderFeed.feedObject.getFeedObject().debugMessage;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localJSONObject2.put("debugMessage", paramView);
        paramView = d.n.n.beG("content=" + com.tencent.mm.ac.f.bF(localBaseFinderFeed.feedObject.getFeedObject()));
        ae.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(localJSONObject1)));
        ae.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(paramView)));
        if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fnF()))
        {
          locale1.a((n.d)new FinderDebugUIC.b(localFinderDebugUIC, bool));
          locale1.a((n.e)new FinderDebugUIC.c(localFinderDebugUIC, localContext, localJSONObject1, localBaseFinderFeed, l, paramView, locale));
          locale1.cPF();
        }
        this.oTF.auu.requestLayout();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$12", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(201760);
        return true;
        bool = false;
        break;
        label895:
        localObject = null;
        break label333;
        paramView = null;
        break label373;
        paramView = null;
        break label514;
        paramView = null;
        break label552;
        paramView = null;
        break label590;
        paramView = null;
        break label628;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class s
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private long rVz = -1L;
    
    s(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201761);
      d.g.b.p.h(paramb, "ev");
      Object localObject1;
      Object localObject2;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        localObject1 = parame.fUY();
        if (((localObject1 instanceof BaseFinderFeed)) && (this.rVz != ((com.tencent.mm.plugin.finder.event.base.h)paramb).rZL))
        {
          long l = ((BaseFinderFeed)localObject1).feedObject.getExpectId();
          if (((com.tencent.mm.plugin.finder.event.base.h)paramb).rZL != l) {
            break label139;
          }
          localObject1 = parame;
          localObject2 = parame.fUY();
          if (localObject2 == null)
          {
            paramb = new v("null cannot be cast to non-null type T");
            AppMethodBeat.o(201761);
            throw paramb;
          }
          h.a(true, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
        }
      }
      for (;;)
      {
        this.rVz = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rZL;
        AppMethodBeat.o(201761);
        return;
        label139:
        localObject1 = parame;
        localObject2 = parame.fUY();
        if (localObject2 == null)
        {
          paramb = new v("null cannot be cast to non-null type T");
          AppMethodBeat.o(201761);
          throw paramb;
        }
        h.a(false, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201762);
      d.g.b.p.h(paramc, "dispatcher");
      d.g.b.p.h(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(201762);
      return bool;
    }
    
    public final boolean cAA()
    {
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class x
    implements Runnable
  {
    x(y.f paramf1, com.tencent.mm.view.recyclerview.e parame, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201767);
      Rect localRect = new Rect();
      ((View)this.rVA.NiY).getHitRect(localRect);
      int i = com.tencent.mm.cb.a.ay(parame.getContext(), 2131165303);
      localRect.inset(-i, -i);
      ah localah = (ah)paramRecyclerView.NiY;
      View localView = (View)this.rVA.NiY;
      d.g.b.p.g(localView, "awesomeView");
      localah.a(new ai(localRect, localView));
      AppMethodBeat.o(201767);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class y
    implements Runnable
  {
    y(y.f paramf1, com.tencent.mm.view.recyclerview.e parame, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201768);
      Rect localRect = new Rect();
      ((View)this.rVB.NiY).getHitRect(localRect);
      int i = com.tencent.mm.cb.a.ay(parame.getContext(), 2131165303);
      localRect.inset(-i, -i);
      ah localah = (ah)paramRecyclerView.NiY;
      View localView = (View)this.rVB.NiY;
      d.g.b.p.g(localView, "commentView");
      localah.a(new ai(localRect, localView));
      AppMethodBeat.o(201768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h
 * JD-Core Version:    0.7.0.1
 */