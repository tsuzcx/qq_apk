package com.tencent.mm.plugin.finder.convert;

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
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.d.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.v.a;
import d.g.b.v.e;
import d.o;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bmd;>;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "MENU_ID_UNFOLLOW", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "checkPostOk", "item", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "convertMedia", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "favAnimator", "favFeed", "hideOrDimissMoreBtn", "ifShow", "initAuthIcon", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "jumpFoldedUI", "feedList", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "likeAvatorAnimator", "likeCount", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onFocusedViewHolder", "isFocused", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "onMediaClick", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshExposeLayout", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "refreshFavIv", "isFav", "favCount", "refreshFollowState", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "refreshHeaderFooterWording", "refreshOpLayout", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setNicknameCalculateWidth", "shareFeed", "showOrDimissSelfFeedLikeTips", "Companion", "StateListener", "plugin-finder_release"})
public abstract class e<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.b<T>
{
  public static final a qqG = new a((byte)0);
  final int IoU;
  private final int qqA;
  private final HashSet<b<T>> qqB;
  private final FinderFeedConvert.uiLifecycleObserver.1 qqC;
  private final com.tencent.mm.plugin.finder.feed.c qqD;
  protected boolean qqF;
  private final Rect rect;
  Dialog tipDialog;
  
  public e(com.tencent.mm.plugin.finder.feed.c paramc, boolean paramBoolean, int paramInt)
  {
    this.qqD = paramc;
    this.qqF = paramBoolean;
    this.IoU = paramInt;
    this.qqA = 10000;
    this.qqB = new HashSet();
    this.qqC = new FinderFeedConvert.uiLifecycleObserver.1(this);
    this.rect = new Rect();
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.k.h(parame, "holder");
    parame.jY(2131300208, paramInt);
  }
  
  private final void a(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUr())
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.d.qRR;
      if (!bt.gL((List)com.tencent.mm.plugin.finder.upload.action.d.crL().o(paramT.feedObject.getFeedObject()))) {
        parame.jY(2131303868, 8);
      }
    }
    label86:
    do
    {
      return;
      localObject = FinderReporterUIC.Ljl;
      localObject = parame.getContext();
      d.g.b.k.g(localObject, "holder.context");
      localObject = FinderReporterUIC.a.lB((Context)localObject);
      if (localObject == null) {
        break;
      }
      i = ((FinderReporterUIC)localObject).qqE;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)))) {
        break label423;
      }
      parame.jY(2131303868, 8);
    } while (this.qqF);
    localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
    label194:
    int j;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label343;
      }
      j = paramT.feedObject.getFeedObject().recommendType;
      parame.jY(2131303860, 8);
      parame.jY(2131303868, 0);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label345;
      }
    }
    label343:
    label345:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label350;
      }
      localObject = (TextView)parame.abq(2131303869);
      d.g.b.k.g(localObject, "reasonTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.h(parame.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize()));
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new n());
      return;
      i = 0;
      break label86;
      i = 0;
      break label194;
      break;
    }
    label350:
    ad.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    parame.jY(2131303868, 8);
    return;
    label423:
    parame.jY(2131303868, 8);
  }
  
  private final void a(final T paramT, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    Object localObject1 = i.qTa;
    if (!i.k(paramT))
    {
      a(0, parame);
      paramT = parame.abq(2131303506);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, parame);
      return;
    }
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = parame.abq(2131303506);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, parame);
      b(paramT, parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.h.qSR;
      localObject2 = paramT.feedObject.getDescriptionFullSpan();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new SpannableString((CharSequence)"");
      }
      com.tencent.mm.plugin.finder.utils.h.a((SpannableString)localObject1, true);
      if (paramBoolean) {
        ((FinderCollapsibleTextView)parame.abq(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
      }
      a(true, parame);
      return;
    }
    localObject1 = parame.abq(2131303506);
    if (localObject1 == null) {
      localObject1 = ((ViewStub)parame.abq(2131303507)).inflate();
    }
    for (;;)
    {
      localObject2 = (FinderPostProgressView)((View)localObject1).findViewById(2131303505);
      View localView1 = ((View)localObject1).findViewById(2131303504);
      View localView2 = ((View)localObject1).findViewById(2131303466);
      Object localObject3 = (TextView)((View)localObject1).findViewById(2131303467);
      d.g.b.k.g(localObject1, "container");
      ((View)localObject1).setVisibility(0);
      a(8, parame);
      parame.jY(2131303503, 0);
      a(false, parame);
      boolean bool;
      if ((paramT.feedObject.isPostFailed()) || (paramT.feedObject.isUploadFailed()))
      {
        d.g.b.k.g(localView2, "failedArea");
        localView2.setVisibility(0);
        d.g.b.k.g(localView1, "progressArea");
        localView1.setVisibility(8);
        if (!paramT.feedObject.isPostFailedCanRetry())
        {
          parame.jY(2131303503, 8);
          bool = false;
        }
      }
      for (;;)
      {
        parame.abq(2131303501).setOnClickListener((View.OnClickListener)new w(this, paramT));
        parame.abq(2131303502).setOnClickListener((View.OnClickListener)new x(this, paramT));
        parame.abq(2131303503).setOnClickListener((View.OnClickListener)new y(paramT));
        localObject1 = com.tencent.mm.plugin.finder.utils.h.qSR;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        com.tencent.mm.plugin.finder.utils.h.a((SpannableString)localObject1, bool);
        if (paramBoolean) {
          ((FinderCollapsibleTextView)parame.abq(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
        }
        ad.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool);
        return;
        if (paramT.feedObject.isPostNoAuth())
        {
          d.g.b.k.g(localObject3, "failedTv");
          localObject1 = parame.getContext();
          d.g.b.k.g(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(2131759305)));
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)new u(this));
          break;
        }
        d.g.b.k.g(localObject3, "failedTv");
        localObject1 = parame.getContext();
        d.g.b.k.g(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(2131759304));
        break;
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().DJH >= 100))
        {
          d.g.b.k.g(localView2, "failedArea");
          localView2.setVisibility(8);
          d.g.b.k.g(localView1, "progressArea");
          localView1.setVisibility(8);
          ((View)localObject1).setVisibility(8);
          a(0, parame);
          a(true, parame);
          bool = true;
        }
        else
        {
          d.g.b.k.g(localView2, "failedArea");
          localView2.setVisibility(8);
          d.g.b.k.g(localView1, "progressArea");
          localView1.setVisibility(0);
          localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().DJH });
          ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new v((FinderPostProgressView)localObject2));
          localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
          if (localObject3 != null) {
            ((ValueAnimator)localObject3).start();
          }
          parame.setTag(localObject1);
          ad.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().DJH);
          bool = false;
        }
      }
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, LinkedList<bmd> paramLinkedList, long paramLong)
  {
    d.g.b.k.h(paramFinderMediaBanner, "banner");
    d.g.b.k.h(paramLinkedList, "mediaList");
    if (j.iz((List)paramLinkedList) == null)
    {
      ad.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject1 = (bmd)paramLinkedList.getFirst();
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    paramLinkedList = (LinkedList<bmd>)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bmd)((Iterator)localObject2).next();
      float f = ((bmd)localObject1).height * 1.0F / ((bmd)localObject1).width;
      if (paramLinkedList.height * 1.0F / paramLinkedList.width >= f) {
        break label331;
      }
      paramLinkedList = (LinkedList<bmd>)localObject1;
    }
    label331:
    for (;;)
    {
      break;
      localObject1 = i.qTa;
      d.g.b.k.g(paramLinkedList, "maxRadioMedia");
      localObject1 = paramFinderMediaBanner.getPagerView().getLayoutParams();
      d.g.b.k.g(localObject1, "banner.pagerView.layoutParams");
      localObject2 = (View)paramFinderMediaBanner;
      d.g.b.k.h(paramLinkedList, "mediaObj");
      d.g.b.k.h(localObject1, "params");
      d.g.b.k.h(localObject2, "view");
      int i = ((ViewGroup.LayoutParams)localObject1).height;
      int j = ((ViewGroup.LayoutParams)localObject1).width;
      paramLinkedList = i.fA((int)paramLinkedList.width, (int)paramLinkedList.height);
      ((ViewGroup.LayoutParams)localObject1).width = paramLinkedList.getInt("media_layout_width", 0);
      ((ViewGroup.LayoutParams)localObject1).height = paramLinkedList.getInt("media_layout_height", 0);
      ImageView.ScaleType.values();
      paramLinkedList.getInt("media_layout_sale_type", ImageView.ScaleType.CENTER_CROP.ordinal());
      if ((i != ((ViewGroup.LayoutParams)localObject1).height) || (j != ((ViewGroup.LayoutParams)localObject1).width)) {
        ((View)localObject2).requestLayout();
      }
      ad.d("Finder.FeedConvert", "feedId=" + paramLong + ' ' + paramFinderMediaBanner.getLayoutParams().height);
      return;
    }
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    if (this.qqF)
    {
      parame.jY(2131300192, 8);
      parame.jY(2131303868, 8);
      return;
    }
    Object localObject = FinderReporterUIC.Ljl;
    localObject = parame.getContext();
    d.g.b.k.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.lB((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).qqE;
      localObject = com.tencent.mm.plugin.finder.api.b.qnX;
      bool = b.a.YO(paramT.feedObject.field_username);
      if ((this.IoU == 3) || (!bool) || (i == 1)) {
        break label275;
      }
      localObject = i.qTa;
      if (i.k(paramT)) {
        break label275;
      }
      parame.jY(2131300192, 0);
      localObject = (TextView)parame.abq(2131300192);
      d.g.b.k.g(localObject, "followIv");
      Context localContext = ((TextView)localObject).getContext();
      d.g.b.k.g(localContext, "followIv.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760230));
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cd.a.ap(((TextView)localObject).getContext(), 2131165284));
      localContext = parame.getContext();
      d.g.b.k.g(localContext, "holder.context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099734));
      ((TextView)localObject).setBackgroundResource(2131232351);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < ce.asQ() - 86400000L)) {
        break label301;
      }
      parame.jY(2131303868, 8);
      return;
      i = 0;
      break;
      label275:
      if ((!bool) || (this.IoU == 3)) {
        parame.jY(2131300192, 8);
      }
    }
    label301:
    parame.jY(2131303868, 0);
  }
  
  private static void a(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = parame.getContext();
      d.g.b.k.g(localObject, "holder.context");
      localObject = new o(Integer.valueOf(2131690326), Integer.valueOf(((Context)localObject).getResources().getColor(2131099809)));
      int i = ((Number)((o)localObject).first).intValue();
      int j = ((Number)((o)localObject).second).intValue();
      localObject = (WeImageView)parame.abq(2131300888);
      ((WeImageView)localObject).setImageResource(i);
      ((WeImageView)localObject).setIconColor(j);
      localObject = (TextView)parame.abq(2131301416);
      d.g.b.k.g(localObject, "likeTv");
      ai.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label197;
      }
    }
    label197:
    for (parame = com.tencent.mm.plugin.finder.utils.e.fz(2, paramInt);; parame = "")
    {
      ((TextView)localObject).setText((CharSequence)parame);
      return;
      localObject = parame.getContext();
      d.g.b.k.g(localObject, "holder.context");
      localObject = new o(Integer.valueOf(2131690330), Integer.valueOf(((Context)localObject).getResources().getColor(2131100018)));
      break;
    }
  }
  
  private void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.k.h(parame, "holder");
    parame = parame.abq(2131302457);
    if ((!this.qqF) && (paramBoolean))
    {
      d.g.b.k.g(parame, "moreBtn");
      parame.setVisibility(0);
      return;
    }
    d.g.b.k.g(parame, "moreBtn");
    parame.setVisibility(8);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
    FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)parame.abq(2131305725);
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    localObject = (FinderHomeTabStateVM)localObject;
    if (((FinderHomeTabStateVM)localObject).Lhc)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      i = locale.afk().getInt(ae.a.LAQ, 0);
      if (i >= 3) {
        ((FinderHomeTabStateVM)localObject).Lhc = false;
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
        parame.arI.postDelayed((Runnable)new e.af(paramT, localFinderCollapsibleTextView), 2000L);
      }
      return;
    }
    parame = localFinderCollapsibleTextView.getTipsTv();
    d.g.b.k.g(parame, "collapseTextLayout.tipsTv");
    parame.setVisibility(8);
  }
  
  private final void b(final T paramT, final com.tencent.mm.view.recyclerview.e parame)
  {
    ad.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + parame.ln());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)parame.abq(2131298523);
    d.g.b.k.g(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((d.g.a.m)new r(this, parame, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((d.g.a.m)new s(this, parame, paramT));
    Object localObject = parame.arI;
    d.g.b.k.g(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (d.g.a.m)new t(this, paramT));
    if (bt.gL((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)parame.abq(2131304549);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      i locali = i.qTa;
      if (!i.ZR(paramT.feedObject.field_username)) {
        break label378;
      }
      d.g.b.k.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(am.i(((ImageView)localObject).getContext(), 2131690331, com.tencent.mm.cd.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
    for (;;)
    {
      paramT = parame.abq(2131304548);
      paramT.setOnClickListener((View.OnClickListener)new e.ah(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      d.g.b.k.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(am.i(((ImageView)localObject).getContext(), 2131690547, com.tencent.mm.cd.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
  }
  
  private final void b(T paramT, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
    LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.d.crL().o(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
    int j = com.tencent.mm.plugin.finder.upload.action.d.crL().n(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if ((!com.tencent.mm.plugin.finder.storage.b.fUr()) || (bt.gL((List)localLinkedList)) || (j <= 0))
    {
      paramT = new StringBuilder("refreshRealNameRecommendLayout ").append(bt.gL((List)localLinkedList)).append(", ").append(j).append(' ');
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      ad.i("Finder.FeedConvert", com.tencent.mm.plugin.finder.storage.b.fUr());
      paramT = parame.abq(2131307828);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
    }
    label164:
    label196:
    do
    {
      return;
      localObject1 = (List)localLinkedList;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        if (d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject1).next()).username, u.aqG())) {
          if (i >= 0)
          {
            if (localLinkedList.size() > 3) {
              break label279;
            }
            localObject1 = localLinkedList.remove(i);
            d.g.b.k.g(localObject1, "likeList.removeAt(meExistIndex)");
            localLinkedList.add((FinderCommentInfo)localObject1);
          }
        }
      }
      for (;;)
      {
        if (!this.qqF) {
          break label310;
        }
        paramT = parame.abq(2131307828);
        if (paramT == null) {
          break;
        }
        paramT.setVisibility(8);
        return;
        i += 1;
        break label164;
        i = -1;
        break label196;
        localObject1 = localLinkedList.remove(i);
        d.g.b.k.g(localObject1, "likeList.removeAt(meExistIndex)");
        localLinkedList.add(2, (FinderCommentInfo)localObject1);
      }
      localObject1 = parame.abq(2131307828);
    } while (localObject1 == null);
    label279:
    label310:
    ((View)localObject1).setVisibility(0);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).add(parame.abq(2131307384));
    ((List)localObject1).add(parame.abq(2131307386));
    ((List)localObject1).add(parame.abq(2131307388));
    Object localObject2 = (List)new ArrayList();
    ((List)localObject2).add(parame.abq(2131307385));
    ((List)localObject2).add(parame.abq(2131307387));
    ((List)localObject2).add(parame.abq(2131307389));
    Object localObject3 = new v.a();
    Object localObject4 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
    ((v.a)localObject3).Jhs = com.tencent.mm.plugin.finder.upload.action.d.crL().d(paramT.feedObject.getFeedObject());
    localObject4 = new v.e();
    ((v.e)localObject4).Jhw = ((d.g.a.a)new e.ak((v.a)localObject3, this, parame, paramT, paramBoolean, localLinkedList, j));
    ((d.g.a.a)new e.al((List)localObject1, (List)localObject2, (v.e)localObject4, this, parame, paramT, paramBoolean, localLinkedList, j)).invoke();
    localObject4 = (TextView)parame.abq(2131307830);
    Context localContext;
    if (localObject4 != null)
    {
      localContext = parame.getContext();
      localObject1 = i.qTa;
      localObject1 = ((FinderCommentInfo)localLinkedList.get(0)).username;
      if (localObject1 != null) {
        break label813;
      }
      localObject1 = "";
    }
    label813:
    for (;;)
    {
      localObject3 = ((FinderCommentInfo)localLinkedList.get(0)).nickname;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)i.fX((String)localObject1, (String)localObject2)));
      localObject1 = (TextView)parame.abq(2131307827);
      if (j == 1)
      {
        d.g.b.k.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766478));
      }
      for (;;)
      {
        localObject1 = parame.abq(2131307829);
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new e.am(this, parame, paramT, paramBoolean, localLinkedList, j));
        return;
        if (j <= 3)
        {
          d.g.b.k.g(localObject1, "descTv");
          ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766479, new Object[] { String.valueOf(j) }));
        }
        else
        {
          d.g.b.k.g(localObject1, "descTv");
          ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766477, new Object[] { String.valueOf(j) }));
        }
      }
    }
  }
  
  private final void b(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    WeImageView localWeImageView = (WeImageView)parame.abq(2131307300);
    TextView localTextView = (TextView)parame.abq(2131307301);
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        parame = parame.getContext();
        d.g.b.k.g(parame, "holder.context");
        parame = new o(Integer.valueOf(2131691481), Integer.valueOf(parame.getResources().getColor(2131099778)));
        int i = ((Number)parame.first).intValue();
        int j = ((Number)parame.second).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else if (localTextView != null)
    {
      if (!this.qqD.clH()) {
        break label210;
      }
      ai.a((Paint)localTextView.getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label203;
      }
    }
    label203:
    for (parame = com.tencent.mm.plugin.finder.utils.e.fz(2, paramInt);; parame = "")
    {
      localTextView.setText((CharSequence)parame);
      return;
      parame = parame.getContext();
      d.g.b.k.g(parame, "holder.context");
      parame = new o(Integer.valueOf(2131691484), Integer.valueOf(parame.getResources().getColor(2131099732)));
      break;
    }
    label210:
    localTextView.setText((CharSequence)"");
  }
  
  private static void b(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
    i locali = i.qTa;
    if (i.fWf())
    {
      parame = parame.abq(2131307364);
      d.g.b.k.g(parame, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
      parame.setVisibility(8);
      return;
    }
    locali = i.qTa;
    if ((i.k(paramT)) && (paramT.showLikeTips))
    {
      if (paramBoolean)
      {
        paramT.showLikeTips = false;
        paramT = parame.abq(2131307364);
        d.g.b.k.g(paramT, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
        paramT.setVisibility(0);
        paramT = parame.abq(2131307365);
        d.g.b.k.g(paramT, "holder.getView<TextView>…r_self_feed_like_tips_tv)");
        ((TextView)paramT).setText((CharSequence)com.tencent.mm.cd.a.aq(parame.getContext(), 2131766395));
        return;
      }
      paramT = parame.abq(2131307364);
      d.g.b.k.g(paramT, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
      paramT.setVisibility(0);
      paramT = parame.abq(2131307365);
      d.g.b.k.g(paramT, "holder.getView<TextView>…r_self_feed_like_tips_tv)");
      ((TextView)paramT).setText((CharSequence)com.tencent.mm.cd.a.aq(parame.getContext(), 2131766394));
      return;
    }
    parame = parame.abq(2131307364);
    d.g.b.k.g(parame, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
    parame.setVisibility(8);
  }
  
  private static void g(BaseFinderFeed paramBaseFinderFeed)
  {
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getMediaList()).iterator();
    while (localIterator.hasNext())
    {
      bmd localbmd = (bmd)localIterator.next();
      if (localbmd.mediaType <= 0) {
        localbmd.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  public void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    int i = 4;
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    Object localObject1 = (View.OnClickListener)new p(this, parame);
    paramRecyclerView = (ImageView)parame.abq(2131297008);
    paramRecyclerView.setOnClickListener((View.OnClickListener)localObject1);
    paramRecyclerView.post((Runnable)new q(paramRecyclerView));
    localObject1 = (TextView)parame.abq(2131302863);
    d.g.b.k.g(localObject1, "nickTv");
    ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    Object localObject2 = parame.getContext();
    d.g.b.k.g(localObject2, "holder.context");
    ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100021));
    localObject1 = (WeImageView)parame.abq(2131302457);
    localObject2 = parame.getContext();
    d.g.b.k.g(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100018));
    localObject1 = (HardTouchableLayout)parame.abq(2131302206);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new e.aa());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new i((HardTouchableLayout)localObject1, this, parame));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new j((HardTouchableLayout)localObject1, this, parame));
    }
    parame.abq(2131297023).setOnClickListener((View.OnClickListener)new m(this, parame));
    localObject1 = (FinderCollapsibleTextView)parame.abq(2131305725);
    if (!this.qqF) {
      ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g(((FinderCollapsibleTextView)localObject1).getContentTextView(), new n(parame.getContext())));
    }
    localObject1 = parame.abq(2131298522);
    d.g.b.k.g(localObject1, "holder.getView<View>(R.id.comment_icon_container)");
    if (this.qqF)
    {
      paramInt = 8;
      ((View)localObject1).setVisibility(paramInt);
      localObject1 = new v.e();
      ((v.e)localObject1).Jhw = parame.abq(2131307302);
      localObject2 = (View)((v.e)localObject1).Jhw;
      d.g.b.k.g(localObject2, "favView");
      if (!this.qqF) {
        break label742;
      }
      paramInt = 4;
      label402:
      ((View)localObject2).setVisibility(paramInt);
      localObject2 = (View)((v.e)localObject1).Jhw;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new n(this, parame));
      }
      localObject2 = (View)((v.e)localObject1).Jhw;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new o(parame, (v.e)localObject1, paramRecyclerView));
      }
      localObject1 = new v.e();
      ((v.e)localObject1).Jhw = parame.abq(2131307871);
      localObject2 = (View)((v.e)localObject1).Jhw;
      d.g.b.k.g(localObject2, "shareView");
      if (!this.qqF) {
        break label747;
      }
    }
    label742:
    label747:
    for (paramInt = i;; paramInt = 0)
    {
      ((View)localObject2).setVisibility(paramInt);
      localObject2 = (View)((v.e)localObject1).Jhw;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new e.ab(this, parame));
      }
      localObject2 = (View)((v.e)localObject1).Jhw;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new e.ac(parame, (v.e)localObject1, paramRecyclerView));
      }
      parame.abq(2131302457).setOnLongClickListener((View.OnLongClickListener)new e.ad(parame));
      paramRecyclerView = parame.abq(2131298523);
      d.g.b.k.g(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
      paramRecyclerView.setClickable(false);
      paramRecyclerView = new b(this, parame);
      parame.arI.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
      paramRecyclerView.alive();
      this.qqB.add(paramRecyclerView);
      if (this.qqF) {
        a(false, parame);
      }
      paramRecyclerView = FinderReporterUIC.Ljl;
      paramRecyclerView = parame.getContext();
      d.g.b.k.g(paramRecyclerView, "holder.context");
      paramRecyclerView = FinderReporterUIC.a.lB(paramRecyclerView);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = FinderReporterUIC.a(paramRecyclerView);
        if (paramRecyclerView != null) {
          paramRecyclerView.a((com.tencent.mm.plugin.finder.event.base.f)new e.ae(this, parame));
        }
      }
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label402;
    }
  }
  
  final void a(com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parame.fjf();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
    if (!com.tencent.mm.plugin.finder.upload.action.d.crL().d(localBaseFinderFeed.feedObject.getFeedObject())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject1 = parame.abq(2131300888);
        Object localObject2 = parame.abq(2131301417);
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.finder.view.animation.b localb = com.tencent.mm.plugin.finder.view.animation.b.qYv;
          com.tencent.mm.plugin.finder.view.animation.b.dV((View)localObject2);
          localObject2 = com.tencent.mm.plugin.finder.view.animation.b.qYv;
          d.g.b.k.g(localObject1, "likeIcon");
          com.tencent.mm.plugin.finder.view.animation.b.dU((View)localObject1);
        }
      }
      localObject1 = this.qqD;
      d.g.b.k.g(localBaseFinderFeed, "item");
      ((com.tencent.mm.plugin.finder.feed.c)localObject1).a(localBaseFinderFeed, bool, paramInt);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.d.qRR;
      a(bool, com.tencent.mm.plugin.finder.upload.action.d.crL().e(localBaseFinderFeed.feedObject.getFeedObject()), parame);
      b(bool, parame, localBaseFinderFeed);
      localObject1 = new gy();
      ((gy)localObject1).dkz.id = localBaseFinderFeed.bMs();
      ((gy)localObject1).dkz.type = 4;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = FinderReporterUIC.Ljl;
      parame = parame.getContext();
      d.g.b.k.g(parame, "holder.context");
      parame = FinderReporterUIC.a.lB(parame);
      if (parame != null)
      {
        parame = FinderReporterUIC.b(parame);
        if (parame != null)
        {
          parame = parame.fSl();
          if (!bool) {
            break;
          }
          parame.Bx(localBaseFinderFeed.bMs());
        }
      }
      return;
    }
    parame.By(localBaseFinderFeed.bMs());
  }
  
  public void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramFinderObject, "finderObj");
  }
  
  public void a(final com.tencent.mm.view.recyclerview.e parame, final T paramT, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
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
          if ((localObject1 instanceof o)) {
            switch (((Number)((o)localObject1).first).intValue())
            {
            default: 
              break;
            case 1: 
              b(paramT, parame);
              return;
              paramInt1 = 0;
              break;
            case 2: 
              a(paramT, parame, false);
              return;
            case 3: 
              paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
              if (!com.tencent.mm.plugin.finder.upload.action.d.crL().d(paramT.feedObject.getFeedObject())) {
                b(false, parame, paramT);
              }
              paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.d.crL().d(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
              a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.d.crL().e(paramT.feedObject.getFeedObject()), parame);
              a(paramT, parame);
              b(paramT, parame, true);
              return;
            case 4: 
              paramList = com.tencent.mm.plugin.finder.upload.action.h.Lan;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.h.fVL().l(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.h.Lan;
              b(paramBoolean, com.tencent.mm.plugin.finder.upload.action.h.fVL().m(paramT.feedObject.getFeedObject()), parame);
              return;
            }
          }
        }
      }
    }
    parame.abq(2131302457).setOnClickListener((View.OnClickListener)new k(this, parame));
    paramT.feedObject.getTopicClickExtra().aLG = new WeakReference(parame.getContext());
    label415:
    label466:
    label495:
    Object localObject2;
    label518:
    Object localObject3;
    if (this.qqD.clH())
    {
      parame.jY(2131306206, 0);
      parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.e.u(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      g(paramT);
      parame.jY(2131296976, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label1827;
        }
        paramInt1 = ((FinderAuthInfo)localObject1).authIconType;
        if (paramInt1 <= 0) {
          break label2020;
        }
      }
      switch (paramInt1)
      {
      default: 
        parame.jY(2131296977, 8);
        if (!paramBoolean) {
          b(parame, paramT);
        }
        paramList = paramT.contact;
        if (paramList != null)
        {
          paramList = paramList.getUsername();
          if (paramList != null)
          {
            localObject1 = paramT.contact;
            if (localObject1 == null) {
              break label2039;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).cks();
            localObject1 = bt.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.b.qnX;
            localObject2 = b.a.YL(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).cks())) {
                paramList = ((com.tencent.mm.plugin.finder.api.f)localObject2).cks();
              }
              localObject1 = y.JfV;
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
            localObject1 = com.tencent.mm.plugin.finder.loader.h.cmV();
            paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
            localObject2 = parame.abq(2131297008);
            d.g.b.k.g(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.h.qCF;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
            paramList = y.JfV;
          }
          if (paramBoolean) {
            break label3381;
          }
          paramList = parame.abq(2131298775);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label2045;
          }
          paramInt1 = 1;
          label677:
          if (paramInt1 == 0) {
            break label2055;
          }
          parame.jY(2131305725, 8);
          if (paramList == null) {
            break label2050;
          }
          localObject1 = paramList.getContext();
          d.g.b.k.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.JfV;
          paramInt1 = 0;
          label752:
          paramList = parame.abq(2131307380);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          localObject1 = paramT.feedObject.getFoldedLayout();
          paramInt2 = paramInt1;
          if (localObject1 != null)
          {
            if (((ain)localObject1).Dlf != 1) {
              break label2335;
            }
            paramList = com.tencent.mm.plugin.finder.storage.b.qJA;
            if (com.tencent.mm.plugin.finder.storage.b.fUr()) {
              break label2335;
            }
            paramList = parame.abq(2131307380);
            paramInt2 = paramInt1;
            if (paramList != null)
            {
              paramList.setVisibility(8);
              paramInt2 = paramInt1;
            }
          }
        }
        break;
      }
    }
    label2050:
    label2821:
    for (;;)
    {
      b(paramT, parame);
      label851:
      label893:
      Object localObject4;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        a(paramT, parame, paramBoolean);
        if (bt.isNullOrNil(paramT.headerWording)) {
          break label3025;
        }
        parame.jY(2131300730, 0);
        parame.d(2131300729, (CharSequence)paramT.headerWording);
        if (bt.isNullOrNil(paramT.footerWording)) {
          break label3038;
        }
        parame.jY(2131300213, 0);
        parame.d(2131300211, (CharSequence)paramT.footerWording);
        label927:
        a(parame, paramT);
        d.g.b.k.h(parame, "holder");
        ((TextView)parame.abq(2131302863)).post((Runnable)new z(parame));
        a(paramT, parame);
        b(paramT, parame, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
        b(com.tencent.mm.plugin.finder.upload.action.d.crL().d(paramT.feedObject.getFeedObject()), parame, paramT);
        localObject1 = paramT.feedObject.getLocation();
        localObject2 = parame.abq(2131303355);
        paramList = (TextView)parame.abq(2131303336);
        localObject3 = i.qTa;
        localObject3 = i.fY(((ajq)localObject1).evA, ((ajq)localObject1).goQ);
        if (!bt.isNullOrNil((String)localObject3)) {
          break label3051;
        }
        d.g.b.k.g(localObject2, "positionLayout");
        ((View)localObject2).setVisibility(8);
        paramList = y.JfV;
        label1079:
        paramList = parame.abq(2131301435);
        d.g.b.k.g(paramList, "linkLayout");
        paramList.setVisibility(8);
        localObject1 = paramT.feedObject.getExtReading();
        if ((!bt.isNullOrNil(((aig)localObject1).link)) && (!bt.isNullOrNil(((aig)localObject1).title)))
        {
          localObject2 = ((aig)localObject1).link;
          localObject3 = ((aig)localObject1).title;
          localObject4 = (TextView)parame.abq(2131301436);
          parame.d(2131301436, (CharSequence)localObject3);
          ad.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((aig)localObject1).title);
          paramList.post((Runnable)new f((TextView)localObject4, (String)localObject3, parame, paramList));
          paramList.setVisibility(0);
          ((TextView)localObject4).setOnClickListener((View.OnClickListener)new g((String)localObject2, parame, paramList));
        }
        paramList = y.JfV;
        localObject1 = parame.abq(2131303869);
        paramList = parame.abq(2131298523);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
        {
          localObject1 = paramList.getContext();
          d.g.b.k.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.JfV;
        }
        if (!this.qqD.clH()) {
          break label3269;
        }
        parame.jY(2131300205, 8);
        parame.jY(2131304551, 0);
        paramList = parame.abq(2131304558);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.ahF(paramT.feedObject.getReadCount()));
        paramList = parame.abq(2131304552);
        d.g.b.k.g(paramList, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.ahF(paramT.feedObject.getForwardCount()));
        paramList = parame.abq(2131304553);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_like_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.ahF(paramT.feedObject.getLikeCount()));
        paramList = parame.abq(2131304550);
        d.g.b.k.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.ahF(paramT.feedObject.getCommentCount()));
        paramList = parame.abq(2131307863);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.ahF(paramT.feedObject.getFavCount()));
        parame.abq(2131307864).setOnClickListener((View.OnClickListener)new e.ai(parame, paramT));
        paramList = parame.abq(2131307871);
        d.g.b.k.g(paramList, "holder.getView<View>(R.id.share_icon_container)");
        if (!this.qqF) {
          break label3264;
        }
        paramInt1 = 4;
        label1632:
        paramList.setVisibility(paramInt1);
        parame.abq(2131307866).setOnClickListener((View.OnClickListener)new e.aj(this, parame));
        parame.jY(2131298523, 0);
        parame.jY(2131306206, 0);
        parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.e.f(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        paramT = parame.getContext();
        d.g.b.k.g(paramT, "holder.context");
        float f = paramT.getResources().getDimensionPixelSize(2131165257);
        ((TextView)parame.abq(2131304558)).setTextSize(0, f);
        ((TextView)parame.abq(2131304552)).setTextSize(0, f);
        ((TextView)parame.abq(2131304553)).setTextSize(0, f);
        ((TextView)parame.abq(2131304550)).setTextSize(0, f);
        ((TextView)parame.abq(2131307863)).setTextSize(0, f);
        return;
        parame.jY(2131306206, 8);
        break;
        label1827:
        paramInt1 = 0;
        break label415;
        parame.jY(2131296977, 0);
        ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131100725)));
        parame.jY(2131296976, 0);
        localObject1 = (TextView)parame.abq(2131296976);
        d.g.b.k.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
        paramList = parame.getContext();
        d.g.b.k.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099734));
        paramList = y.JfV;
        break label466;
        parame.jY(2131296977, 0);
        ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131099748)));
        paramList = y.JfV;
        break label466;
        parame.jY(2131296977, 8);
        break label466;
        label2020:
        parame.jY(2131296977, 8);
        break label466;
        paramList = null;
        break label495;
        label2039:
        localObject1 = null;
        break label518;
        label2045:
        paramInt1 = 0;
        break label677;
        paramInt1 = 0;
        break label752;
        label2055:
        if (paramList != null)
        {
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.JfV;
        }
        paramList = parame.abq(2131305725);
        if (paramT.feedObject.getMediaList().size() <= 1)
        {
          if (paramList != null)
          {
            localObject1 = paramList.getContext();
            d.g.b.k.g(localObject1, "context");
            paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165303);
            paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = y.JfV;
          }
          label2168:
          parame.jY(2131305725, 0);
          paramList = (FinderCollapsibleTextView)parame.abq(2131305725);
          paramList.setCollapse(paramT.isContentCollapsed);
          if (!this.qqF) {
            break label2317;
          }
          localObject1 = parame.getContext();
          localObject2 = (CharSequence)String.valueOf(paramT.feedObject.getDescriptionFullSpan());
          localObject3 = paramList.getContentTextView();
          d.g.b.k.g(localObject3, "collapseTextLayout.contentTextView");
          paramList.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject1, (CharSequence)localObject2, ((NeatTextView)localObject3).getTextSize()));
        }
        for (;;)
        {
          paramList.setOnCollapse((d.g.a.b)new l(paramT, parame));
          paramInt1 = 1;
          break;
          if (paramList == null) {
            break label2168;
          }
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.JfV;
          break label2168;
          label2317:
          paramList.setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
        }
        label2335:
        if (((ain)localObject1).Dlf != 1)
        {
          paramInt2 = paramInt1;
          if (((ain)localObject1).Dlf != 2) {
            continue;
          }
        }
        paramList = parame.abq(2131307380);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = parame.abq(2131307380);
        if (paramList != null) {
          break label3378;
        }
        paramList = ((ViewStub)parame.abq(2131307381)).inflate();
      }
      label2463:
      label2725:
      label3378:
      for (;;)
      {
        localObject2 = paramList.findViewById(2131307382);
        localObject3 = paramList.findViewById(2131307418);
        if (((ain)localObject1).Dlf == 1)
        {
          d.g.b.k.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          d.g.b.k.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(8);
          localObject2 = (TextView)paramList.findViewById(2131307307);
          if (((ain)localObject1).Dlf != 1) {
            break label2725;
          }
          localObject3 = parame.getContext();
          localObject4 = parame.getContext();
          i locali = i.qTa;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(2131766399, new Object[] { i.fX(((ain)localObject1).username, ""), String.valueOf(((ain)localObject1).fwP) }));
          d.g.b.k.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)localObject3));
          localObject2 = paramT.feedObject.getFoldedFeedList();
          localObject3 = (FinderFoldedScrollLayout)parame.abq(2131307305);
          d.g.b.k.g(localObject3, "foldedScrollLayout");
          localObject4 = ((FinderFoldedScrollLayout)localObject3).getLayoutParams();
          if (((ain)localObject1).Dlf != 2) {
            break label2803;
          }
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cd.a.fromDPToPix(parame.getContext(), 208);
          label2637:
          ((FinderFoldedScrollLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (!bt.gL((List)localObject2)) {
            break label2821;
          }
          ((FinderFoldedScrollLayout)localObject3).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(2131307306).setOnClickListener((View.OnClickListener)new h(this, (List)localObject2, paramT, (ain)localObject1, parame));
          paramInt2 = paramInt1;
          break;
          d.g.b.k.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          d.g.b.k.g(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(0);
          break label2463;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)parame.getContext().getString(2131766398, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((ain)localObject1).fwP) }));
          d.g.b.k.g(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)localObject3));
          break label2577;
          label2803:
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.cd.a.fromDPToPix(parame.getContext(), 240);
          break label2637;
          ((FinderFoldedScrollLayout)localObject3).setVisibility(0);
          d.g.b.k.h(localObject1, "foldedLayout");
          d.g.b.k.h(paramT, "parentFeed");
          ((FinderFoldedScrollLayout)localObject3).LeR = paramT;
          ((FinderFoldedScrollLayout)localObject3).foldedLayout = ((ain)localObject1);
          ((FinderFoldedScrollLayout)localObject3).Dlf = ((ain)localObject1).Dlf;
          ((FinderFoldedScrollLayout)localObject3).dataList.clear();
          localObject4 = paramT.feedObject.getFoldedFeedList();
          ((FinderFoldedScrollLayout)localObject3).dataList.addAll((Collection)localObject4);
          paramInt2 = ((ain)localObject1).fwP;
          localObject4 = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (paramInt2 >= com.tencent.mm.plugin.finder.storage.b.fUF()) {
            ((FinderFoldedScrollLayout)localObject3).dataList.add(((FinderFoldedScrollLayout)localObject3).LeQ);
          }
          localObject4 = ((FinderFoldedScrollLayout)localObject3).KPx;
          if (localObject4 == null) {
            d.g.b.k.aPZ("recyclerView");
          }
          localObject4 = ((WxRecyclerView)localObject4).getLayoutManager();
          if (localObject4 == null) {
            throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          }
          ((FinderLayoutManager)localObject4).af(0, 0);
          localObject3 = ((FinderFoldedScrollLayout)localObject3).KPx;
          if (localObject3 == null) {
            d.g.b.k.aPZ("recyclerView");
          }
          localObject3 = ((WxRecyclerView)localObject3).getAdapter();
          if (localObject3 != null) {
            ((RecyclerView.a)localObject3).notifyDataSetChanged();
          }
        }
        paramBoolean = false;
        break label851;
        label3025:
        parame.jY(2131300730, 8);
        break label893;
        label3038:
        parame.jY(2131300213, 8);
        break label927;
        label3051:
        d.g.b.k.g(paramList, "poiTv");
        paramList.setText((CharSequence)localObject3);
        paramList.post((Runnable)new d((View)localObject2, paramList, (String)localObject3, this, parame, paramT));
        d.g.b.k.g(localObject2, "positionLayout");
        ((View)localObject2).setVisibility(0);
        if (this.qqF)
        {
          localObject1 = (CharSequence)((ajq)localObject1).goQ;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label3236;
            }
            localObject1 = parame.getContext();
            d.g.b.k.g(localObject1, "holder.context");
            paramList.setTextColor(((Context)localObject1).getResources().getColor(2131100021));
            paramList = (WeImageView)parame.abq(2131303328);
            if (paramList == null) {
              break;
            }
            localObject1 = parame.getContext();
            d.g.b.k.g(localObject1, "holder.context");
            paramList.setIconColor(((Context)localObject1).getResources().getColor(2131100021));
            paramList = y.JfV;
            break;
          }
        }
        paramList.setOnClickListener((View.OnClickListener)new e((String)localObject3, this, parame, paramT));
        paramList = y.JfV;
        break label1079;
        label3264:
        paramInt1 = 0;
        break label1632;
        label3269:
        parame.jY(2131300205, 0);
        parame.jY(2131304551, 8);
        paramList = com.tencent.mm.plugin.finder.upload.action.h.Lan;
        paramBoolean = com.tencent.mm.plugin.finder.upload.action.h.fVL().l(paramT.feedObject.getFeedObject());
        paramList = com.tencent.mm.plugin.finder.upload.action.h.Lan;
        b(paramBoolean, com.tencent.mm.plugin.finder.upload.action.h.fVL().m(paramT.feedObject.getFeedObject()), parame);
        paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
        paramBoolean = com.tencent.mm.plugin.finder.upload.action.d.crL().d(paramT.feedObject.getFeedObject());
        paramList = com.tencent.mm.plugin.finder.upload.action.d.qRR;
        a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.d.crL().e(paramT.feedObject.getFeedObject()), parame);
        return;
      }
      label2577:
      label3236:
      label3381:
      paramInt2 = 0;
    }
  }
  
  protected final void a(com.tencent.mm.view.recyclerview.e parame, T paramT, long paramLong, com.tencent.mm.plugin.finder.storage.k paramk)
  {
    boolean bool2 = true;
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
    com.tencent.mm.plugin.finder.view.f localf = this.qqD.fSW();
    e.ag localag = new e.ag(this, parame, paramT);
    if ((parame.getContext() instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
      parame = parame.getContext();
      if (parame == null) {
        throw new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      }
      parame = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)parame).get(FinderReporterUIC.class));
      if (parame != null) {
        parame.fSl().Bw(paramT.bMs());
      }
    }
    parame = paramT.feedObject;
    boolean bool1;
    if (!this.qqF)
    {
      bool1 = true;
      if (paramLong == 0L) {
        break label158;
      }
    }
    for (;;)
    {
      localf.a(parame, paramLong, bool2, bool1, paramk, (CommentDrawerContract.CloseDrawerCallback)localag);
      return;
      bool1 = false;
      break;
      label158:
      bool2 = false;
    }
  }
  
  public abstract void b(com.tencent.mm.view.recyclerview.e parame, T paramT);
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$Companion;", "", "()V", "TAG", "", "payloadsExposeInfoType", "", "payloadsFavInfoType", "payloadsProgressType", "payloadsRefreshLike", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends com.tencent.mm.sdk.b.c<gv>
    implements View.OnAttachStateChangeListener
  {
    final e<T> qqH;
    final com.tencent.mm.view.recyclerview.e qqI;
    
    public b(e<T> parame, com.tencent.mm.view.recyclerview.e parame1)
    {
      AppMethodBeat.i(165341);
      this.qqH = parame;
      this.qqI = parame1;
      if ((this.qqI.getContext() instanceof MMActivity))
      {
        parame = this.qqI.getContext();
        if (parame == null)
        {
          parame = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw parame;
        }
        ((MMActivity)parame).getLifecycle().addObserver((LifecycleObserver)e.a(this.qqH));
      }
      AppMethodBeat.o(165341);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(165340);
      d.g.b.k.h(paramView, "v");
      AppMethodBeat.o(165340);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(165339);
      d.g.b.k.h(paramView, "v");
      AppMethodBeat.o(165339);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(e.b paramb, gv paramgv)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(e parame, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.qqM.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)new d(this), (d.g.a.a)new c(this));
        if (this.qqN.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.qqM;
        localObject = this.cjo;
        this.cjo.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, this.cjo.getString(2131755936), false, (DialogInterface.OnCancelListener)e.c.a.qqQ));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.qqN.client_id;
      d.g.b.k.g(localObject, "comment.client_id");
      paramDialogInterface.qw(Long.parseLong((String)localObject));
      AppMethodBeat.o(165347);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(e.c paramc, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(e.c paramc)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(e.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
  static final class d
    implements Runnable
  {
    d(View paramView, TextView paramTextView, String paramString, e parame, com.tencent.mm.view.recyclerview.e parame1, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.qqV;
      d.g.b.k.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cd.a.fromDPToPix(parame.getContext(), 20);
        localObject = paramList;
        d.g.b.k.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.qqX) + j > i)
        {
          localObject = paramList;
          d.g.b.k.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.qqX;
          TextView localTextView = paramList;
          d.g.b.k.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$3"})
  static final class e
    implements View.OnClickListener
  {
    e(String paramString, e parame, com.tencent.mm.view.recyclerview.e parame1, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      if (!jdField_this.qqF)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.cpO())
        {
          paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (com.tencent.mm.plugin.finder.storage.b.cpR())
          {
            if (e.a(paramT))
            {
              paramView = new Intent();
              paramView.putExtra("key_topic_type", 2);
              paramView.putExtra("key_ref_object_id", paramT.feedObject.getId());
              paramView.putExtra("key_topic_title", this.qqX);
              paramView.putExtra("key_topic_poi_location", paramT.feedObject.getLocation().toByteArray());
              paramView.putExtra("KEY_TAB_TYPE", jdField_this.IoU);
              Object localObject = FinderReporterUIC.Ljl;
              localObject = parame.getContext();
              d.g.b.k.g(localObject, "holder.context");
              FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
              localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
              localObject = parame.getContext();
              d.g.b.k.g(localObject, "holder.context");
              com.tencent.mm.plugin.finder.utils.a.F((Context)localObject, paramView);
              paramView = FinderReporterUIC.Ljl;
              paramView = parame.getContext();
              d.g.b.k.g(paramView, "holder.context");
              FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.lB(paramView);
              if (localFinderReporterUIC != null)
              {
                paramView = com.tencent.mm.plugin.finder.report.b.qFq;
                long l = paramT.bMs();
                localObject = this.qqX;
                paramView = (View)localObject;
                if (localObject == null) {
                  paramView = "";
                }
                com.tencent.mm.plugin.finder.report.b.a(l, paramView, 2, localFinderReporterUIC.qqE);
                paramView = FinderReporterUIC.b(localFinderReporterUIC);
                if (paramView != null)
                {
                  paramView.fSl().BD(paramT.bMs());
                  AppMethodBeat.o(165349);
                  return;
                }
                AppMethodBeat.o(165349);
                return;
              }
              AppMethodBeat.o(165349);
              return;
            }
            ad.i("Finder.FeedConvert", "click poi but isPostOk false");
            AppMethodBeat.o(165349);
            return;
          }
        }
      }
      paramView = i.qTa;
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      i.a(paramView, paramT.feedObject.getLocation());
      AppMethodBeat.o(165349);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$1"})
  static final class f
    implements Runnable
  {
    f(TextView paramTextView, String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(165350);
      Object localObject = paramList;
      d.g.b.k.g(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cd.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.qqZ;
        d.g.b.k.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.qra) + j > i)
        {
          localObject = this.qqZ;
          d.g.b.k.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.qra;
          TextView localTextView = this.qqZ;
          d.g.b.k.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$2"})
  static final class g
    implements View.OnClickListener
  {
    g(String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      paramView = FinderReporterUIC.Ljl;
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null) {}
      for (int i = paramView.qqE;; i = 0)
      {
        paramView = new Intent();
        String str = com.tencent.mm.ai.m.d(this.qrc, 156, i + 10000, (int)(System.currentTimeMillis() / 1000L));
        ad.i("Finder.FeedConvert", "click linkLayout, url:" + this.qrc + ", urlWithReportParams:" + str);
        paramView.putExtra("rawUrl", str);
        com.tencent.mm.bs.d.b(parame.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(165351);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(e parame, List paramList, BaseFinderFeed paramBaseFinderFeed, ain paramain, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197387);
      e.a(this.KKx, paramT, this.KKy, parame);
      AppMethodBeat.o(197387);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class i
    implements HardTouchableLayout.b
  {
    i(HardTouchableLayout paramHardTouchableLayout, e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void dQ(View paramView)
    {
      AppMethodBeat.i(165353);
      d.g.b.k.h(paramView, "view");
      ad.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)parame.fjf());
      paramView = jdField_this;
      Object localObject1 = parame;
      Object localObject2 = (View)this.qrd;
      d.g.b.k.h(localObject1, "holder");
      d.g.b.k.h(localObject2, "view");
      localObject2 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fjf();
      if (((BaseFinderFeed)localObject2).feedObject.isPostFinish())
      {
        d.a locala = com.tencent.mm.plugin.finder.upload.action.d.qRR;
        if (com.tencent.mm.plugin.finder.upload.action.d.crL().d(((BaseFinderFeed)localObject2).feedObject.getFeedObject()))
        {
          paramView = ((com.tencent.mm.view.recyclerview.e)localObject1).abq(2131301417);
          localObject1 = com.tencent.mm.plugin.finder.view.animation.b.qYv;
          d.g.b.k.g(paramView, "likeIconBanner");
          com.tencent.mm.plugin.finder.view.animation.b.dV(paramView);
          AppMethodBeat.o(165353);
          return;
        }
        paramView.a((com.tencent.mm.view.recyclerview.e)localObject1, 2);
      }
      AppMethodBeat.o(165353);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class j
    implements HardTouchableLayout.g
  {
    j(HardTouchableLayout paramHardTouchableLayout, e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void dR(View paramView)
    {
      AppMethodBeat.i(165354);
      d.g.b.k.h(paramView, "view");
      ad.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)parame.fjf());
      jdField_this.a(parame, (View)this.qrd, ((BaseFinderFeed)parame.fjf()).feedObject.getFeedObject());
      AppMethodBeat.o(165354);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197388);
      paramView = (BaseFinderFeed)parame.fjf();
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(parame.getContext(), 0, false);
      com.tencent.mm.plugin.finder.feed.c localc = e.b(this.qqM);
      d.g.b.k.g(paramView, "item");
      locale.a(localc.a(paramView, locale));
      locale.b(e.b(this.qqM).c(paramView));
      locale.a(e.b(this.qqM).d(paramView));
      locale.b(e.b(this.qqM).d(paramView));
      locale.csG();
      AppMethodBeat.o(197388);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    l(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165357);
      ad.i("Finder.FeedConvert", "onClickComment:" + parame.ln());
      e.a(this.qqM, parame);
      AppMethodBeat.o(165357);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197392);
      ad.i("Finder.FeedConvert", "onClickFav:" + parame.ln());
      e.b(this.qqM, parame);
      AppMethodBeat.o(197392);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class o
    implements Runnable
  {
    o(com.tencent.mm.view.recyclerview.e parame, v.e parame1, ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(197393);
      int i = com.tencent.mm.cd.a.ap(this.nGG.getContext(), 2131165303);
      Object localObject = new Rect();
      ((View)this.KKA.Jhw).getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-i, -i);
      ViewParent localViewParent = ((View)this.KKA.Jhw).getParent();
      if (localViewParent == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(197393);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)paramRecyclerView));
      AppMethodBeat.o(197393);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165362);
      if (this.qqM.qqF)
      {
        ad.i("Finder.FeedConvert", "hit safeMode, avatar can't click.");
        AppMethodBeat.o(165362);
        return;
      }
      paramView = (BaseFinderFeed)parame.fjf();
      Object localObject1 = FinderReporterUIC.Ljl;
      localObject1 = parame.getContext();
      d.g.b.k.g(localObject1, "holder.context");
      localObject1 = FinderReporterUIC.a.lB((Context)localObject1);
      int i;
      if (localObject1 != null) {
        i = ((FinderReporterUIC)localObject1).qqE;
      }
      while ((i == 1) || (i == 8))
      {
        ad.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(3, paramView.bMs(), i, 1, paramView.feedObject.getUserName());
        paramView = parame.getContext();
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
          AppMethodBeat.o(165362);
          return;
        }
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramView.feedObject.getUserName());
      Object localObject2 = FinderReporterUIC.Ljl;
      localObject2 = parame.getContext();
      d.g.b.k.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, paramView.bMs(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject2 = parame.getContext();
      d.g.b.k.g(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((parame.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.LCX;
        localObject1 = parame.getContext();
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165362);
          throw paramView;
        }
        localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.c)localObject1).fSl().Bz(paramView.bMs());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(3, paramView.bMs(), i, 1, paramView.feedObject.getUserName());
      AppMethodBeat.o(165362);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class q
    implements Runnable
  {
    q(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(197390);
      Object localObject1 = new Rect();
      this.KKz.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.KKz;
      d.g.b.k.g(localObject2, "avatarView");
      localObject2 = ((ImageView)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(197390);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.KKz));
      AppMethodBeat.o(197390);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.m<View, FinderCommentInfo, y>
  {
    r(e parame, com.tencent.mm.view.recyclerview.e parame1, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.m<View, FinderCommentInfo, y>
  {
    s(e parame, com.tencent.mm.view.recyclerview.e parame1, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.m<FinderCommentInfo, Boolean, y>
  {
    t(e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165374);
      paramView = e.b(this.qqM).getActivity();
      if (paramView != null)
      {
        com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.c((Activity)paramView, ".ui.FinderHomeUI");
        AppMethodBeat.o(165374);
        return;
      }
      AppMethodBeat.o(165374);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class v
    implements ValueAnimator.AnimatorUpdateListener
  {
    v(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(165375);
      FinderPostProgressView localFinderPostProgressView = this.qri;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(165375);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.qri.invalidate();
      AppMethodBeat.o(165375);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165376);
      e.b(paramT);
      AppMethodBeat.o(165376);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165377);
      e.b(paramT);
      AppMethodBeat.o(165377);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165378);
      paramView = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.crB().i(this.qqO.feedObject);
      AppMethodBeat.o(165378);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class z
    implements Runnable
  {
    z(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.nGG.fjf();
      if (localBaseFinderFeed == null)
      {
        ad.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.nGG.abq(2131297934);
      d.g.b.k.g(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.nGG.abq(2131296977);
        localObject1 = (TextView)this.nGG.abq(2131300192);
        d.g.b.k.g(localObject2, "authIconIv");
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label380;
        }
      }
      label197:
      label348:
      label380:
      for (int j = ((ImageView)localObject2).getWidth();; j = 0)
      {
        d.g.b.k.g(localObject1, "followTv");
        CharSequence localCharSequence;
        int i;
        if (((TextView)localObject1).getVisibility() == 0) {
          if (((TextView)localObject1).getText() != null)
          {
            float f = com.tencent.mm.cd.a.ao(this.nGG.getContext(), 2131165294);
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
          localObject1 = (TextView)this.nGG.abq(2131302863);
          d.g.b.k.g(localObject1, "nicknameTv");
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
          this.nGG.d(2131302863, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */