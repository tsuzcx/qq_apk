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
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
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
import d.g.b.v.f;
import d.o;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bqs;>;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "MENU_ID_UNFOLLOW", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "checkPostOk", "item", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "convertMedia", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "context", "Landroid/content/Context;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "favAnimator", "favFeed", "hideOrDimissMoreBtn", "ifShow", "initAuthIcon", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "jumpFoldedUI", "feedList", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "likeAvatorAnimator", "likeCount", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onFocusedViewHolder", "isFocused", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "onMediaClick", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshExposeLayout", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "refreshFavIv", "isFav", "favCount", "refreshFollowState", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "refreshHeaderFooterWording", "refreshOpLayout", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setNicknameCalculateWidth", "shareFeed", "showOrDimissSelfFeedLikeTips", "Companion", "StateListener", "plugin-finder_release"})
public abstract class g<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.b<T>
{
  public static final g.a rao = new g.a((byte)0);
  final int diw;
  private final int raj;
  private final HashSet<b<T>> rak;
  private final FinderFeedConvert.uiLifecycleObserver.1 ral;
  private final com.tencent.mm.plugin.finder.feed.g ram;
  protected boolean ran;
  private final Rect rect;
  Dialog tipDialog;
  
  public g(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean, int paramInt)
  {
    this.ram = paramg;
    this.ran = paramBoolean;
    this.diw = paramInt;
    this.raj = 10000;
    this.rak = new HashSet();
    this.ral = new FinderFeedConvert.uiLifecycleObserver.1(this);
    this.rect = new Rect();
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.k.h(parame, "holder");
    parame.kl(2131300208, paramInt);
  }
  
  private static void a(BaseFinderFeed paramBaseFinderFeed)
  {
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getMediaList()).iterator();
    while (localIterator.hasNext())
    {
      bqs localbqs = (bqs)localIterator.next();
      if (localbqs.mediaType <= 0) {
        localbqs.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  private static void a(T paramT, com.tencent.mm.view.recyclerview.e parame)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czO())
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.g.rOb;
      if (!bs.gY((List)com.tencent.mm.plugin.finder.upload.action.g.cCH().m(paramT.feedObject.getFeedObject())))
      {
        parame.kl(2131303868, 8);
        return;
      }
    }
    localObject = FinderReporterUIC.seQ;
    localObject = parame.getContext();
    d.g.b.k.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.eV((Context)localObject);
    label86:
    int j;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).rfR;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)))) {
        break label414;
      }
      parame.kl(2131303868, 8);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label332;
      }
      i = 1;
      label187:
      if (i != 0) {
        break label335;
      }
      j = paramT.feedObject.getFeedObject().recommendType;
      parame.kl(2131303860, 8);
      parame.kl(2131303868, 0);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label337;
      }
    }
    label332:
    label335:
    label337:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label342;
      }
      localObject = (TextView)parame.adJ(2131303869);
      d.g.b.k.g(localObject, "reasonTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.e(parame.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize()));
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.n());
      return;
      i = 0;
      break label86;
      i = 0;
      break label187;
      break;
    }
    label342:
    ac.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    parame.kl(2131303868, 8);
    return;
    label414:
    parame.kl(2131303868, 8);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.e parame, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.g.cCH().m(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    final int j = com.tencent.mm.plugin.finder.upload.action.g.cCH().l(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if ((!com.tencent.mm.plugin.finder.storage.b.czO()) || (bs.gY((List)localLinkedList)) || (j <= 0))
    {
      paramT = new StringBuilder("refreshRealNameRecommendLayout ").append(bs.gY((List)localLinkedList)).append(", ").append(j).append(' ');
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      ac.i("Finder.FeedConvert", com.tencent.mm.plugin.finder.storage.b.czO());
      paramT = parame.adJ(2131307922);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
    }
    int i;
    label164:
    label196:
    do
    {
      return;
      localObject1 = (List)localLinkedList;
      i = 0;
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label668;
      }
      if (!d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject1).next()).username, u.axw())) {
        break;
      }
      if ((i >= 0) && (i >= 3) && (localLinkedList.size() >= 3))
      {
        localObject1 = localLinkedList.remove(i);
        d.g.b.k.g(localObject1, "likeList.removeAt(meExistIndex)");
        localLinkedList.add(2, (FinderCommentInfo)localObject1);
      }
      localObject1 = parame.adJ(2131307922);
    } while (localObject1 == null);
    ((View)localObject1).setVisibility(0);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).add(parame.adJ(2131307453));
    ((List)localObject1).add(parame.adJ(2131307455));
    ((List)localObject1).add(parame.adJ(2131307457));
    Object localObject2 = (List)new ArrayList();
    ((List)localObject2).add(parame.adJ(2131307454));
    ((List)localObject2).add(parame.adJ(2131307456));
    ((List)localObject2).add(parame.adJ(2131307458));
    Object localObject3 = new v.a();
    Object localObject4 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    ((v.a)localObject3).KUL = com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramT.feedObject.getFeedObject());
    localObject4 = new v.f();
    ((v.f)localObject4).KUQ = ((d.g.a.a)new aj((v.a)localObject3, this, parame, paramT, paramBoolean, localLinkedList, j));
    ((d.g.a.a)new ak((List)localObject1, (List)localObject2, (v.f)localObject4, this, parame, paramT, paramBoolean, localLinkedList, j)).invoke();
    localObject4 = (TextView)parame.adJ(2131307924);
    Context localContext;
    if (localObject4 != null)
    {
      localContext = parame.getContext();
      localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject1 = ((FinderCommentInfo)localLinkedList.get(0)).username;
      if (localObject1 != null) {
        break label762;
      }
      localObject1 = "";
    }
    label668:
    label762:
    for (;;)
    {
      localObject3 = ((FinderCommentInfo)localLinkedList.get(0)).nickname;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)com.tencent.mm.plugin.finder.utils.n.gm((String)localObject1, (String)localObject2)));
      localObject1 = (TextView)parame.adJ(2131307921);
      if (j == 1)
      {
        d.g.b.k.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766492));
      }
      for (;;)
      {
        localObject1 = parame.adJ(2131307923);
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new al(this, parame, paramT, paramBoolean, localLinkedList, j));
        return;
        i += 1;
        break label164;
        i = -1;
        break label196;
        if (j <= 3)
        {
          d.g.b.k.g(localObject1, "descTv");
          ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766493, new Object[] { String.valueOf(j) }));
        }
        else
        {
          d.g.b.k.g(localObject1, "descTv");
          ((TextView)localObject1).setText((CharSequence)parame.getContext().getString(2131766491, new Object[] { String.valueOf(j) }));
        }
      }
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, LinkedList<bqs> paramLinkedList, long paramLong)
  {
    d.g.b.k.h(paramFinderMediaBanner, "banner");
    d.g.b.k.h(paramLinkedList, "mediaList");
    if (j.iP((List)paramLinkedList) == null)
    {
      ac.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject1 = (bqs)paramLinkedList.getFirst();
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    paramLinkedList = (LinkedList<bqs>)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bqs)((Iterator)localObject2).next();
      float f = ((bqs)localObject1).height * 1.0F / ((bqs)localObject1).width;
      if (paramLinkedList.height * 1.0F / paramLinkedList.width >= f) {
        break label331;
      }
      paramLinkedList = (LinkedList<bqs>)localObject1;
    }
    label331:
    for (;;)
    {
      break;
      localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
      d.g.b.k.g(paramLinkedList, "maxRadioMedia");
      localObject1 = paramFinderMediaBanner.getPagerView().getLayoutParams();
      d.g.b.k.g(localObject1, "banner.pagerView.layoutParams");
      localObject2 = (View)paramFinderMediaBanner;
      d.g.b.k.h(paramLinkedList, "mediaObj");
      d.g.b.k.h(localObject1, "params");
      d.g.b.k.h(localObject2, "view");
      int i = ((ViewGroup.LayoutParams)localObject1).height;
      int j = ((ViewGroup.LayoutParams)localObject1).width;
      paramLinkedList = com.tencent.mm.plugin.finder.utils.n.fE((int)paramLinkedList.width, (int)paramLinkedList.height);
      ((ViewGroup.LayoutParams)localObject1).width = paramLinkedList.getInt("media_layout_width", 0);
      ((ViewGroup.LayoutParams)localObject1).height = paramLinkedList.getInt("media_layout_height", 0);
      ImageView.ScaleType.values();
      paramLinkedList.getInt("media_layout_sale_type", ImageView.ScaleType.CENTER_CROP.ordinal());
      if ((i != ((ViewGroup.LayoutParams)localObject1).height) || (j != ((ViewGroup.LayoutParams)localObject1).width)) {
        ((View)localObject2).requestLayout();
      }
      ac.d("Finder.FeedConvert", "feedId=" + paramLong + ' ' + paramFinderMediaBanner.getLayoutParams().height);
      return;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parame.fzs();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    if (!com.tencent.mm.plugin.finder.upload.action.g.cCH().j(localBaseFinderFeed.feedObject.getFeedObject())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject1 = parame.adJ(2131300888);
        Object localObject2 = parame.adJ(2131301417);
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.finder.view.animation.b localb = com.tencent.mm.plugin.finder.view.animation.b.sag;
          com.tencent.mm.plugin.finder.view.animation.b.ec((View)localObject2);
          localObject2 = com.tencent.mm.plugin.finder.view.animation.b.sag;
          d.g.b.k.g(localObject1, "likeIcon");
          com.tencent.mm.plugin.finder.view.animation.b.eb((View)localObject1);
        }
      }
      localObject1 = this.ram;
      d.g.b.k.g(localBaseFinderFeed, "item");
      ((com.tencent.mm.plugin.finder.feed.g)localObject1).a(localBaseFinderFeed, bool, paramInt);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.g.rOb;
      a(bool, com.tencent.mm.plugin.finder.upload.action.g.cCH().k(localBaseFinderFeed.feedObject.getFeedObject()), parame);
      b(bool, parame, localBaseFinderFeed);
      localObject1 = new ha();
      ((ha)localObject1).dhX.id = localBaseFinderFeed.lx();
      ((ha)localObject1).dhX.type = 4;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = FinderReporterUIC.seQ;
      parame = parame.getContext();
      d.g.b.k.g(parame, "holder.context");
      parame = FinderReporterUIC.a.eV(parame);
      if (parame != null)
      {
        parame = FinderReporterUIC.b(parame);
        if (parame != null)
        {
          parame = parame.ctb();
          if (!bool) {
            break;
          }
          parame.tV(localBaseFinderFeed.lx());
        }
      }
      return;
    }
    parame.tW(localBaseFinderFeed.lx());
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    Object localObject = FinderReporterUIC.seQ;
    localObject = parame.getContext();
    d.g.b.k.g(localObject, "holder.context");
    localObject = FinderReporterUIC.a.eV((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((FinderReporterUIC)localObject).rfR;
      localObject = com.tencent.mm.plugin.finder.api.b.qWt;
      bool = b.a.adk(paramT.feedObject.field_username);
      if (!this.ran) {
        break label115;
      }
      parame.kl(2131300192, 8);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < ce.azH() - 86400000L)) {
        break label293;
      }
      parame.kl(2131303868, 8);
      return;
      i = 0;
      break;
      label115:
      if ((this.diw != 3) && (bool) && (i != 1))
      {
        localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (!com.tencent.mm.plugin.finder.utils.n.l(paramT))
        {
          parame.kl(2131300192, 0);
          localObject = (TextView)parame.adJ(2131300192);
          d.g.b.k.g(localObject, "followIv");
          Context localContext = ((TextView)localObject).getContext();
          d.g.b.k.g(localContext, "followIv.context");
          ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131760230));
          ((TextView)localObject).setTextSize(0, com.tencent.mm.cc.a.av(((TextView)localObject).getContext(), 2131165284));
          localContext = parame.getContext();
          d.g.b.k.g(localContext, "holder.context");
          ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099734));
          ((TextView)localObject).setBackgroundResource(2131232351);
          continue;
        }
      }
      if ((!bool) || (this.diw == 3)) {
        parame.kl(2131300192, 8);
      }
    }
    label293:
    parame.kl(2131303868, 0);
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
      localObject = (WeImageView)parame.adJ(2131300888);
      ((WeImageView)localObject).setImageResource(i);
      ((WeImageView)localObject).setIconColor(j);
      localObject = (TextView)parame.adJ(2131301416);
      d.g.b.k.g(localObject, "likeTv");
      aj.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label197;
      }
    }
    label197:
    for (parame = com.tencent.mm.plugin.finder.utils.g.fD(2, paramInt);; parame = "")
    {
      ((TextView)localObject).setText((CharSequence)parame);
      return;
      localObject = parame.getContext();
      d.g.b.k.g(localObject, "holder.context");
      localObject = new o(Integer.valueOf(2131690330), Integer.valueOf(((Context)localObject).getResources().getColor(2131100018)));
      break;
    }
  }
  
  private static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    d.g.b.k.h(parame, "holder");
    parame = parame.adJ(2131302457);
    if (paramBoolean)
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
    final FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)parame.adJ(2131305725);
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    localObject = (FinderHomeTabStateVM)localObject;
    if (((FinderHomeTabStateVM)localObject).sbS)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      i = locale.agA().getInt(ah.a.GUp, 0);
      if (i >= 3) {
        ((FinderHomeTabStateVM)localObject).sbS = false;
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
        parame.asD.postDelayed((Runnable)new w(paramT, localFinderCollapsibleTextView), 2000L);
      }
      return;
    }
    parame = localFinderCollapsibleTextView.getTipsTv();
    d.g.b.k.g(parame, "collapseTextLayout.tipsTv");
    parame.setVisibility(8);
  }
  
  private final void b(final T paramT, final com.tencent.mm.view.recyclerview.e parame)
  {
    ac.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + parame.lv());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)parame.adJ(2131298523);
    d.g.b.k.g(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((d.g.a.m)new y(this, parame, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((d.g.a.m)new z(this, parame, paramT));
    Object localObject = parame.asD;
    d.g.b.k.g(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (d.g.a.m)new aa(this, paramT));
    if (bs.gY((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)parame.adJ(2131304549);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      if (!com.tencent.mm.plugin.finder.utils.n.aeD(paramT.feedObject.field_username)) {
        break label378;
      }
      d.g.b.k.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(am.k(((ImageView)localObject).getContext(), 2131690331, com.tencent.mm.cc.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
    for (;;)
    {
      paramT = parame.adJ(2131304548);
      paramT.setOnClickListener((View.OnClickListener)new ab(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      d.g.b.k.g(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(am.k(((ImageView)localObject).getContext(), 2131690547, com.tencent.mm.cc.a.n(((ImageView)localObject).getContext(), 2131100018)));
    }
  }
  
  private final void b(final T paramT, com.tencent.mm.view.recyclerview.e parame, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (!com.tencent.mm.plugin.finder.utils.n.l(paramT))
    {
      a(0, parame);
      paramT = parame.adJ(2131303506);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, parame);
      return;
    }
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = parame.adJ(2131303506);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, parame);
      b(paramT, parame);
      localObject1 = com.tencent.mm.plugin.finder.utils.m.rPH;
      localObject2 = paramT.feedObject.getDescriptionFullSpan();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new SpannableString((CharSequence)"");
      }
      com.tencent.mm.plugin.finder.utils.m.a((SpannableString)localObject1, true);
      if (paramBoolean) {
        ((FinderCollapsibleTextView)parame.adJ(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
      }
      a(true, parame);
      return;
    }
    localObject1 = parame.adJ(2131303506);
    if (localObject1 == null) {
      localObject1 = ((ViewStub)parame.adJ(2131303507)).inflate();
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
      parame.kl(2131303503, 0);
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
          parame.kl(2131303503, 8);
          bool = false;
        }
      }
      for (;;)
      {
        parame.adJ(2131303501).setOnClickListener((View.OnClickListener)new ag(this, paramT));
        parame.adJ(2131303502).setOnClickListener((View.OnClickListener)new ah(this, paramT));
        parame.adJ(2131303503).setOnClickListener((View.OnClickListener)new ai(paramT));
        localObject1 = com.tencent.mm.plugin.finder.utils.m.rPH;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        com.tencent.mm.plugin.finder.utils.m.a((SpannableString)localObject1, bool);
        if (paramBoolean) {
          ((FinderCollapsibleTextView)parame.adJ(2131305725)).setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
        }
        ac.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool);
        return;
        if (paramT.feedObject.isPostNoAuth())
        {
          d.g.b.k.g(localObject3, "failedTv");
          localObject1 = parame.getContext();
          d.g.b.k.g(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(2131759305)));
          ((TextView)localObject3).setOnClickListener((View.OnClickListener)new ae(this));
          break;
        }
        d.g.b.k.g(localObject3, "failedTv");
        localObject1 = parame.getContext();
        d.g.b.k.g(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(2131759304));
        break;
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().FfV >= 100))
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
          localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().FfV });
          ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new af((FinderPostProgressView)localObject2));
          localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
          if (localObject3 != null) {
            ((ValueAnimator)localObject3).start();
          }
          parame.setTag(localObject1);
          ac.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().FfV);
          bool = false;
        }
      }
    }
  }
  
  private final void b(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.e parame)
  {
    WeImageView localWeImageView = (WeImageView)parame.adJ(2131307331);
    TextView localTextView = (TextView)parame.adJ(2131307332);
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        parame = parame.getContext();
        d.g.b.k.g(parame, "holder.context");
        parame = new o(Integer.valueOf(2131691482), Integer.valueOf(parame.getResources().getColor(2131099778)));
        int i = ((Number)parame.first).intValue();
        int j = ((Number)parame.second).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else if (localTextView != null)
    {
      if (!this.ram.cuq()) {
        break label210;
      }
      aj.a((Paint)localTextView.getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label203;
      }
    }
    label203:
    for (parame = com.tencent.mm.plugin.finder.utils.g.fD(2, paramInt);; parame = "")
    {
      localTextView.setText((CharSequence)parame);
      return;
      parame = parame.getContext();
      d.g.b.k.g(parame, "holder.context");
      parame = new o(Integer.valueOf(2131691485), Integer.valueOf(parame.getResources().getColor(2131099732)));
      break;
    }
    label210:
    localTextView.setText((CharSequence)"");
  }
  
  private static void b(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, T paramT)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
    com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.cDk())
    {
      parame = parame.adJ(2131307433);
      d.g.b.k.g(parame, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
      parame.setVisibility(8);
      return;
    }
    localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    if ((com.tencent.mm.plugin.finder.utils.n.l(paramT)) && (paramT.showLikeTips))
    {
      if (paramBoolean)
      {
        paramT.showLikeTips = false;
        paramT = parame.adJ(2131307433);
        d.g.b.k.g(paramT, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
        paramT.setVisibility(0);
        paramT = parame.adJ(2131307434);
        d.g.b.k.g(paramT, "holder.getView<TextView>…r_self_feed_like_tips_tv)");
        ((TextView)paramT).setText((CharSequence)com.tencent.mm.cc.a.aw(parame.getContext(), 2131766417));
        return;
      }
      paramT = parame.adJ(2131307433);
      d.g.b.k.g(paramT, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
      paramT.setVisibility(0);
      paramT = parame.adJ(2131307434);
      d.g.b.k.g(paramT, "holder.getView<TextView>…r_self_feed_like_tips_tv)");
      ((TextView)paramT).setText((CharSequence)com.tencent.mm.cc.a.aw(parame.getContext(), 2131766416));
      return;
    }
    parame = parame.adJ(2131307433);
    d.g.b.k.g(parame, "holder.getView<View>(R.i…nder_self_feed_like_tips)");
    parame.setVisibility(8);
  }
  
  public void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    Object localObject1 = (View.OnClickListener)new v(parame);
    paramRecyclerView = (ImageView)parame.adJ(2131297008);
    paramRecyclerView.setOnClickListener((View.OnClickListener)localObject1);
    paramRecyclerView.post((Runnable)new m(paramRecyclerView));
    localObject1 = (TextView)parame.adJ(2131302863);
    d.g.b.k.g(localObject1, "nickTv");
    aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    Object localObject2 = parame.getContext();
    d.g.b.k.g(localObject2, "holder.context");
    ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100021));
    localObject1 = (WeImageView)parame.adJ(2131302457);
    localObject2 = parame.getContext();
    d.g.b.k.g(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131100018));
    localObject1 = (HardTouchableLayout)parame.adJ(2131302206);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new n());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new k((HardTouchableLayout)localObject1, this, parame));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new l((HardTouchableLayout)localObject1, this, parame));
    }
    parame.adJ(2131297023).setOnClickListener((View.OnClickListener)new o(this, parame));
    localObject1 = (FinderCollapsibleTextView)parame.adJ(2131305725);
    ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g(((FinderCollapsibleTextView)localObject1).getContentTextView(), new com.tencent.mm.pluginsdk.ui.span.n(parame.getContext())));
    localObject1 = new v.f();
    ((v.f)localObject1).KUQ = parame.adJ(2131307333);
    localObject2 = (View)((v.f)localObject1).KUQ;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)new p(this, parame));
    }
    localObject2 = (View)((v.f)localObject1).KUQ;
    if (localObject2 != null) {
      ((View)localObject2).post((Runnable)new q(parame, (v.f)localObject1, paramRecyclerView));
    }
    localObject1 = new v.f();
    ((v.f)localObject1).KUQ = parame.adJ(2131307979);
    localObject2 = (View)((v.f)localObject1).KUQ;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)new r(this, parame));
    }
    localObject2 = (View)((v.f)localObject1).KUQ;
    if (localObject2 != null) {
      ((View)localObject2).post((Runnable)new s(parame, (v.f)localObject1, paramRecyclerView));
    }
    parame.adJ(2131302457).setOnLongClickListener((View.OnLongClickListener)new t(parame));
    paramRecyclerView = parame.adJ(2131298523);
    d.g.b.k.g(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
    paramRecyclerView.setClickable(false);
    paramRecyclerView = new b(this, parame);
    parame.asD.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
    paramRecyclerView.alive();
    this.rak.add(paramRecyclerView);
    paramRecyclerView = FinderReporterUIC.seQ;
    paramRecyclerView = parame.getContext();
    d.g.b.k.g(paramRecyclerView, "holder.context");
    paramRecyclerView = FinderReporterUIC.a.eV(paramRecyclerView);
    if (paramRecyclerView != null)
    {
      paramRecyclerView = FinderReporterUIC.a(paramRecyclerView);
      if (paramRecyclerView != null) {
        paramRecyclerView.a((com.tencent.mm.plugin.finder.event.base.d)new u(this, parame));
      }
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.e parame, View paramView)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramView, "view");
    paramView = (BaseFinderFeed)parame.fzs();
    if (!paramView.feedObject.isPostFinish()) {
      return;
    }
    com.tencent.mm.plugin.finder.upload.action.g.a locala = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    if (com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramView.feedObject.getFeedObject()))
    {
      parame = parame.adJ(2131301417);
      paramView = com.tencent.mm.plugin.finder.view.animation.b.sag;
      d.g.b.k.g(parame, "likeIconBanner");
      com.tencent.mm.plugin.finder.view.animation.b.ec(parame);
      return;
    }
    a(parame, 2);
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
              b(paramT, parame, false);
              return;
            case 3: 
              paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
              if (!com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramT.feedObject.getFeedObject())) {
                b(false, parame, paramT);
              }
              paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
              a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.g.cCH().k(paramT.feedObject.getFeedObject()), parame);
              a(paramT, parame);
              a(paramT, parame, true);
              return;
            case 4: 
              paramList = com.tencent.mm.plugin.finder.upload.action.c.rNN;
              paramBoolean = com.tencent.mm.plugin.finder.upload.action.c.cCG().h(paramT.feedObject.getFeedObject());
              paramList = com.tencent.mm.plugin.finder.upload.action.c.rNN;
              b(paramBoolean, com.tencent.mm.plugin.finder.upload.action.c.cCG().i(paramT.feedObject.getFeedObject()), parame);
              return;
            }
          }
        }
      }
    }
    paramList = parame.adJ(2131301417);
    d.g.b.k.g(paramList, "holder.getView<View>(R.id.like_icon)");
    paramList.setVisibility(8);
    parame.adJ(2131302457).setOnClickListener((View.OnClickListener)new i(this, parame));
    paramT.feedObject.getTopicClickExtra().aMw = new WeakReference(parame.getContext());
    label438:
    label486:
    Object localObject2;
    label515:
    label538:
    Object localObject3;
    if (this.ram.cuq())
    {
      parame.kl(2131306206, 0);
      parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.g.k(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      a(paramT);
      parame.kl(2131296976, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label1814;
        }
        paramInt1 = ((FinderAuthInfo)localObject1).authIconType;
        if (paramInt1 <= 0) {
          break label2007;
        }
      }
      switch (paramInt1)
      {
      default: 
        parame.kl(2131296977, 8);
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
              break label2026;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).crZ();
            localObject1 = bs.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.b.qWt;
            localObject2 = b.a.adh(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!bs.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).crZ())) {
                paramList = ((com.tencent.mm.plugin.finder.api.f)localObject2).crZ();
              }
              localObject1 = y.KTp;
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.h.rtK;
            localObject1 = com.tencent.mm.plugin.finder.loader.h.cwo();
            paramList = new com.tencent.mm.plugin.finder.loader.a(paramList);
            localObject2 = parame.adJ(2131297008);
            d.g.b.k.g(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.h.rtK;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
            paramList = y.KTp;
          }
          if (paramBoolean) {
            break label3283;
          }
          paramList = parame.adJ(2131298775);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label2032;
          }
          paramInt1 = 1;
          label697:
          if (paramInt1 == 0) {
            break label2042;
          }
          parame.kl(2131305725, 8);
          if (paramList == null) {
            break label2037;
          }
          localObject1 = paramList.getContext();
          d.g.b.k.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.KTp;
          paramInt1 = 0;
          label772:
          paramList = parame.adJ(2131307449);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          localObject2 = paramT.feedObject.getFoldedLayout();
          paramInt2 = paramInt1;
          if (localObject2 != null)
          {
            if (((ajz)localObject2).rXu != 1) {
              break label2256;
            }
            paramList = com.tencent.mm.plugin.finder.storage.b.rCU;
            if (com.tencent.mm.plugin.finder.storage.b.czO()) {
              break label2256;
            }
            paramList = parame.adJ(2131307449);
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
    label913:
    label3091:
    for (;;)
    {
      b(paramT, parame);
      label871:
      Object localObject4;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        b(paramT, parame, paramBoolean);
        if (bs.isNullOrNil(paramT.headerWording)) {
          break label3065;
        }
        parame.kl(2131300730, 0);
        parame.d(2131300729, (CharSequence)paramT.headerWording);
        if (bs.isNullOrNil(paramT.footerWording)) {
          break label3078;
        }
        parame.kl(2131300213, 0);
        parame.d(2131300211, (CharSequence)paramT.footerWording);
        label947:
        a(parame, paramT);
        d.g.b.k.h(parame, "holder");
        ((TextView)parame.adJ(2131302863)).post((Runnable)new am(parame));
        a(paramT, parame);
        a(paramT, parame, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
        b(com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramT.feedObject.getFeedObject()), parame, paramT);
        localObject2 = paramT.feedObject.getLocation();
        paramList = parame.adJ(2131303355);
        localObject1 = (TextView)parame.adJ(2131303336);
        localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
        localObject2 = com.tencent.mm.plugin.finder.utils.n.gn(((alt)localObject2).exW, ((alt)localObject2).gPy);
        if (!bs.isNullOrNil((String)localObject2)) {
          break label3091;
        }
        d.g.b.k.g(paramList, "positionLayout");
        paramList.setVisibility(8);
        label1093:
        paramList = y.KTp;
        paramList = parame.adJ(2131301435);
        d.g.b.k.g(paramList, "linkLayout");
        paramList.setVisibility(8);
        localObject1 = paramT.feedObject.getExtReading();
        if ((!bs.isNullOrNil(((ajq)localObject1).link)) && (!bs.isNullOrNil(((ajq)localObject1).title)))
        {
          localObject2 = ((ajq)localObject1).link;
          localObject3 = ((ajq)localObject1).title;
          localObject4 = (TextView)parame.adJ(2131301436);
          parame.d(2131301436, (CharSequence)localObject3);
          ac.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((ajq)localObject1).title);
          paramList.post((Runnable)new f((TextView)localObject4, (String)localObject3, parame, paramList));
          paramList.setVisibility(0);
          ((TextView)localObject4).setOnClickListener((View.OnClickListener)new g((String)localObject2, parame, paramList));
        }
        paramList = y.KTp;
        localObject1 = parame.adJ(2131303869);
        paramList = parame.adJ(2131298523);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
        {
          localObject1 = paramList.getContext();
          d.g.b.k.g(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165274);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.KTp;
        }
        if (!this.ram.cuq()) {
          break label3171;
        }
        parame.kl(2131300205, 8);
        parame.kl(2131304551, 0);
        paramList = parame.adJ(2131304558);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.Ey(paramT.feedObject.getReadCount()));
        paramList = parame.adJ(2131304552);
        d.g.b.k.g(paramList, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.Ey(paramT.feedObject.getForwardCount()));
        paramList = parame.adJ(2131304553);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_like_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.Ey(paramT.feedObject.getLikeCount()));
        paramList = parame.adJ(2131304550);
        d.g.b.k.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.Ey(paramT.feedObject.getCommentCount()));
        paramList = parame.adJ(2131307971);
        d.g.b.k.g(paramList, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.Ey(paramT.feedObject.getFavCount()));
        parame.adJ(2131307972).setOnClickListener((View.OnClickListener)new ac(parame, paramT));
        parame.adJ(2131307974).setOnClickListener((View.OnClickListener)new ad(this, parame));
        parame.kl(2131298523, 0);
        parame.kl(2131306206, 0);
        parame.d(2131306206, (CharSequence)com.tencent.mm.plugin.finder.utils.g.f(parame.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        paramT = parame.getContext();
        d.g.b.k.g(paramT, "holder.context");
        float f = paramT.getResources().getDimensionPixelSize(2131165257);
        ((TextView)parame.adJ(2131304558)).setTextSize(0, f);
        ((TextView)parame.adJ(2131304552)).setTextSize(0, f);
        ((TextView)parame.adJ(2131304553)).setTextSize(0, f);
        ((TextView)parame.adJ(2131304550)).setTextSize(0, f);
        ((TextView)parame.adJ(2131307971)).setTextSize(0, f);
        return;
        parame.kl(2131306206, 8);
        break;
        label1814:
        paramInt1 = 0;
        break label438;
        parame.kl(2131296977, 0);
        ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131100725)));
        parame.kl(2131296976, 0);
        localObject1 = (TextView)parame.adJ(2131296976);
        d.g.b.k.g(localObject1, "descTv");
        ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
        paramList = parame.getContext();
        d.g.b.k.g(paramList, "holder.context");
        ((TextView)localObject1).setTextColor(paramList.getResources().getColor(2131099734));
        paramList = y.KTp;
        break label486;
        parame.kl(2131296977, 0);
        ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131099748)));
        paramList = y.KTp;
        break label486;
        parame.kl(2131296977, 8);
        break label486;
        label2007:
        parame.kl(2131296977, 8);
        break label486;
        paramList = null;
        break label515;
        label2026:
        localObject1 = null;
        break label538;
        label2032:
        paramInt1 = 0;
        break label697;
        label2037:
        paramInt1 = 0;
        break label772;
        label2042:
        if (paramList != null)
        {
          paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = y.KTp;
        }
        paramList = parame.adJ(2131305725);
        if (paramT.feedObject.getMediaList().size() <= 1) {
          if (paramList != null)
          {
            localObject1 = paramList.getContext();
            d.g.b.k.g(localObject1, "context");
            paramInt1 = (int)((Context)localObject1).getResources().getDimension(2131165303);
            paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = y.KTp;
          }
        }
        for (;;)
        {
          parame.kl(2131305725, 0);
          paramList = (FinderCollapsibleTextView)parame.adJ(2131305725);
          paramList.setCollapse(paramT.isContentCollapsed);
          paramList.setText((CharSequence)paramT.feedObject.getDescriptionFullSpan());
          paramList.setOnCollapse((d.g.a.b)new j(paramT, parame));
          paramInt1 = 1;
          break;
          if (paramList != null)
          {
            paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
            paramList = y.KTp;
          }
        }
        label2256:
        if (((ajz)localObject2).rXu != 1)
        {
          paramInt2 = paramInt1;
          if (((ajz)localObject2).rXu != 2) {
            continue;
          }
        }
        paramList = parame.adJ(2131307449);
        if (paramList != null) {
          paramList.setVisibility(0);
        }
        paramList = parame.adJ(2131307449);
        if (paramList != null) {
          break label3280;
        }
        paramList = ((ViewStub)parame.adJ(2131307450)).inflate();
      }
      label2498:
      label3011:
      label3280:
      for (;;)
      {
        localObject1 = paramList.findViewById(2131307451);
        localObject3 = paramList.findViewById(2131307494);
        label2384:
        Object localObject5;
        if (((ajz)localObject2).rXu == 1)
        {
          d.g.b.k.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          d.g.b.k.g(localObject1, "followSplitLine");
          ((View)localObject1).setVisibility(8);
          localObject1 = (TextView)paramList.findViewById(2131307338);
          if (((ajz)localObject2).rXu != 1) {
            break label2646;
          }
          localObject3 = parame.getContext();
          localObject4 = parame.getContext();
          localObject5 = com.tencent.mm.plugin.finder.utils.n.rPN;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(2131766421, new Object[] { com.tencent.mm.plugin.finder.utils.n.gm(((ajz)localObject2).username, ""), String.valueOf(((ajz)localObject2).fAw) }));
          d.g.b.k.g(localObject1, "titleTv");
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)localObject3));
          localObject3 = paramT.feedObject.getFoldedFeedList();
          localObject4 = (FinderFoldedScrollLayout)parame.adJ(2131307336);
          d.g.b.k.g(localObject4, "foldedScrollLayout");
          localObject1 = ((FinderFoldedScrollLayout)localObject4).getLayoutParams();
          if (((ajz)localObject2).rXu != 2) {
            break label2724;
          }
          ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 208);
          label2558:
          ((FinderFoldedScrollLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (!bs.gY((List)localObject3)) {
            break label2742;
          }
          ((FinderFoldedScrollLayout)localObject4).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(2131307337).setOnClickListener((View.OnClickListener)new h(this, (List)localObject3, paramT, (ajz)localObject2, parame));
          paramInt2 = paramInt1;
          break;
          d.g.b.k.g(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          d.g.b.k.g(localObject1, "followSplitLine");
          ((View)localObject1).setVisibility(0);
          break label2384;
          label2646:
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)parame.getContext().getString(2131766420, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((ajz)localObject2).fAw) }));
          d.g.b.k.g(localObject1, "titleTv");
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)localObject3));
          break label2498;
          ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 240);
          break label2558;
          ((FinderFoldedScrollLayout)localObject4).setVisibility(0);
          d.g.b.k.h(localObject2, "foldedLayout");
          d.g.b.k.h(paramT, "parentFeed");
          ((FinderFoldedScrollLayout)localObject4).rXv = paramT;
          ((FinderFoldedScrollLayout)localObject4).foldedLayout = ((ajz)localObject2);
          ((FinderFoldedScrollLayout)localObject4).rXu = ((ajz)localObject2).rXu;
          ((FinderFoldedScrollLayout)localObject4).dataList.clear();
          localObject5 = paramT.feedObject.getFoldedFeedList();
          StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
          localObject1 = paramT.feedObject;
          if (localObject1 != null)
          {
            localObject1 = ((FinderItem)localObject1).getDebugDescription();
            localStringBuilder = localStringBuilder.append((String)localObject1).append(' ').append(paramT.feedObject).append(' ');
            localObject1 = (BaseFinderFeed)j.C((List)localObject5, 0);
            if (localObject1 == null) {
              break label3005;
            }
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            if (localObject1 == null) {
              break label3005;
            }
          }
          for (localObject1 = ((FinderItem)localObject1).getDebugDescription();; localObject1 = null)
          {
            ac.i("Finder.FinderFoldedScrollLayout", (String)localObject1);
            ((FinderFoldedScrollLayout)localObject4).dataList.addAll((Collection)localObject5);
            paramInt2 = ((ajz)localObject2).fAw;
            localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
            if (paramInt2 >= com.tencent.mm.plugin.finder.storage.b.cAc()) {
              ((FinderFoldedScrollLayout)localObject4).dataList.add(((FinderFoldedScrollLayout)localObject4).rXt);
            }
            localObject1 = ((FinderFoldedScrollLayout)localObject4).rlU;
            if (localObject1 == null) {
              d.g.b.k.aVY("recyclerView");
            }
            localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
            if (localObject1 != null) {
              break label3011;
            }
            throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
            localObject1 = null;
            break;
          }
          ((FinderLayoutManager)localObject1).af(0, 0);
          localObject1 = ((FinderFoldedScrollLayout)localObject4).rlU;
          if (localObject1 == null) {
            d.g.b.k.aVY("recyclerView");
          }
          localObject1 = ((WxRecyclerView)localObject1).getAdapter();
          if (localObject1 != null) {
            ((RecyclerView.a)localObject1).notifyDataSetChanged();
          }
        }
        paramBoolean = false;
        break label871;
        label3065:
        parame.kl(2131300730, 8);
        break label913;
        parame.kl(2131300213, 8);
        break label947;
        d.g.b.k.g(localObject1, "poiTv");
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).post((Runnable)new d(paramList, (TextView)localObject1, (String)localObject2, this, parame, paramT));
        d.g.b.k.g(paramList, "positionLayout");
        paramList.setVisibility(0);
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new e((String)localObject2, this, parame, paramT));
        break label1093;
        label3171:
        parame.kl(2131300205, 0);
        parame.kl(2131304551, 8);
        paramList = com.tencent.mm.plugin.finder.upload.action.c.rNN;
        paramBoolean = com.tencent.mm.plugin.finder.upload.action.c.cCG().h(paramT.feedObject.getFeedObject());
        paramList = com.tencent.mm.plugin.finder.upload.action.c.rNN;
        b(paramBoolean, com.tencent.mm.plugin.finder.upload.action.c.cCG().i(paramT.feedObject.getFeedObject()), parame);
        paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
        paramBoolean = com.tencent.mm.plugin.finder.upload.action.g.cCH().j(paramT.feedObject.getFeedObject());
        paramList = com.tencent.mm.plugin.finder.upload.action.g.rOb;
        a(paramBoolean, com.tencent.mm.plugin.finder.upload.action.g.cCH().k(paramT.feedObject.getFeedObject()), parame);
        return;
      }
      label2724:
      label2742:
      label3005:
      label3283:
      paramInt2 = 0;
    }
  }
  
  protected final void a(final com.tencent.mm.view.recyclerview.e parame, final T paramT, long paramLong, t paramt)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramT, "item");
    com.tencent.mm.plugin.finder.view.d locald = this.ram.cuv();
    x localx = new x(this, parame, paramT);
    if ((parame.getContext() instanceof MMActivity))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
      parame = parame.getContext();
      if (parame == null) {
        throw new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      }
      parame = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)parame).get(FinderReporterUIC.class));
      if (parame != null) {
        parame.ctb().tU(paramT.lx());
      }
    }
    parame = paramT.feedObject;
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      locald.a(parame, paramLong, bool, paramt, (CommentDrawerContract.CloseDrawerCallback)localx);
      return;
    }
  }
  
  public abstract void b(com.tencent.mm.view.recyclerview.e parame, T paramT);
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.m<FinderCommentInfo, Boolean, y>
  {
    aa(g paramg, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ab
    implements View.OnClickListener
  {
    ab(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201276);
      paramView = this.raV.getOnCommentClickListener();
      if (paramView != null)
      {
        View localView = paramT;
        d.g.b.k.g(localView, "selfCommentContainer");
        paramView.n(localView, null);
        AppMethodBeat.o(201276);
        return;
      }
      AppMethodBeat.o(201276);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201277);
      Context localContext = this.ojH.getContext();
      paramView = localContext;
      if (!(localContext instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307396);; paramView = null)
      {
        if (paramView == null) {
          d.g.b.k.fOy();
        }
        paramView.p(paramT.feedObject);
        AppMethodBeat.o(201277);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201278);
      g.c(this.rat, parame);
      AppMethodBeat.o(201278);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ae
    implements View.OnClickListener
  {
    ae(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165374);
      paramView = g.b(this.rat).getActivity();
      if (paramView != null)
      {
        com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.c((Activity)paramView, ".ui.FinderHomeUI");
        AppMethodBeat.o(165374);
        return;
      }
      AppMethodBeat.o(165374);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class af
    implements ValueAnimator.AnimatorUpdateListener
  {
    af(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(165375);
      FinderPostProgressView localFinderPostProgressView = this.raX;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(165375);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.raX.invalidate();
      AppMethodBeat.o(165375);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ag
    implements View.OnClickListener
  {
    ag(g paramg, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165376);
      g.c(paramT);
      AppMethodBeat.o(165376);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(g paramg, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165377);
      g.c(paramT);
      AppMethodBeat.o(165377);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ai
    implements View.OnClickListener
  {
    ai(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165378);
      paramView = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.cCv().j(this.rav.feedObject);
      AppMethodBeat.o(165378);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
  static final class aj
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    aj(v.a parama, g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, LinkedList paramLinkedList, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
  static final class ak
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    ak(List paramList1, List paramList2, v.f paramf, g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, LinkedList paramLinkedList, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
  static final class al
    implements View.OnClickListener
  {
    al(g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, LinkedList paramLinkedList, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201281);
      Object localObject = new apw();
      ((apw)localObject).dig = paramT.lx();
      ((apw)localObject).objectNonceId = paramT.feedObject.getObjectNonceId();
      ((apw)localObject).scene = 2;
      paramView = FinderReporterUIC.seQ;
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null)
      {
        paramView = paramView.cGb();
        ((apw)localObject).contextObj = paramView;
        localObject = parame.getContext();
        paramView = (View)localObject;
        if (!(localObject instanceof Activity)) {
          paramView = null;
        }
        paramView = (Activity)paramView;
        if (paramView == null) {
          break label147;
        }
      }
      label147:
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307397);; paramView = null)
      {
        if (paramView == null) {
          d.g.b.k.fOy();
        }
        paramView.p(paramT.feedObject);
        AppMethodBeat.o(201281);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class am
    implements Runnable
  {
    am(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.ojH.fzs();
      if (localBaseFinderFeed == null)
      {
        ac.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.ojH.adJ(2131297934);
      d.g.b.k.g(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.ojH.adJ(2131296977);
        localObject1 = (TextView)this.ojH.adJ(2131300192);
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
            float f = com.tencent.mm.cc.a.au(this.ojH.getContext(), 2131165294);
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
          localObject1 = (TextView)this.ojH.adJ(2131302863);
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
          this.ojH.d(2131302863, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends com.tencent.mm.sdk.b.c<gw>
    implements View.OnAttachStateChangeListener
  {
    final g<T> rap;
    final com.tencent.mm.view.recyclerview.e raq;
    
    public b(g<T> paramg, com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(165341);
      this.rap = paramg;
      this.raq = parame;
      if ((this.raq.getContext() instanceof MMActivity))
      {
        paramg = this.raq.getContext();
        if (paramg == null)
        {
          paramg = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw paramg;
        }
        ((MMActivity)paramg).getLifecycle().addObserver((LifecycleObserver)g.a(this.rap));
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(g.b paramb, gw paramgw)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(g paramg, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.rat.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (d.g.a.a)new b(this, (d.g.a.a)new d(this), (d.g.a.a)new c(this));
        if (this.rau.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.rat;
        localObject = this.cgl;
        this.cgl.getString(2131755906);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b((Context)localObject, this.cgl.getString(2131755936), false, (DialogInterface.OnCancelListener)g.c.a.rax));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.rau.client_id;
      d.g.b.k.g(localObject, "comment.client_id");
      paramDialogInterface.uM(Long.parseLong((String)localObject));
      AppMethodBeat.o(165347);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(g.c paramc, d.g.a.a parama1, d.g.a.a parama2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(g.c paramc)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(g.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
  static final class d
    implements Runnable
  {
    d(View paramView, TextView paramTextView, String paramString, g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.raC;
      d.g.b.k.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.raD;
        d.g.b.k.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.raE) + j > i)
        {
          localObject = this.raD;
          d.g.b.k.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.raE;
          TextView localTextView = this.raD;
          d.g.b.k.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
  static final class e
    implements View.OnClickListener
  {
    e(String paramString, g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czo())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czu())
        {
          if (g.b(paramT))
          {
            paramView = new Intent();
            paramView.putExtra("key_topic_type", 2);
            paramView.putExtra("key_ref_object_id", paramT.feedObject.getId());
            paramView.putExtra("key_topic_title", this.raE);
            paramView.putExtra("key_topic_poi_location", paramT.feedObject.getLocation().toByteArray());
            paramView.putExtra("KEY_TAB_TYPE", jdField_this.diw);
            Object localObject = FinderReporterUIC.seQ;
            localObject = parame.getContext();
            d.g.b.k.g(localObject, "holder.context");
            FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
            localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
            localObject = parame.getContext();
            d.g.b.k.g(localObject, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.I((Context)localObject, paramView);
            paramView = FinderReporterUIC.seQ;
            paramView = parame.getContext();
            d.g.b.k.g(paramView, "holder.context");
            FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.eV(paramView);
            if (localFinderReporterUIC != null)
            {
              paramView = com.tencent.mm.plugin.finder.report.d.rxr;
              long l = paramT.lx();
              localObject = this.raE;
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              com.tencent.mm.plugin.finder.report.d.a(l, paramView, 2, localFinderReporterUIC.rfR);
              paramView = FinderReporterUIC.b(localFinderReporterUIC);
              if (paramView != null)
              {
                paramView.ctb().ub(paramT.lx());
                AppMethodBeat.o(165349);
                return;
              }
              AppMethodBeat.o(165349);
              return;
            }
            AppMethodBeat.o(165349);
            return;
          }
          ac.i("Finder.FeedConvert", "click poi but isPostOk false");
          AppMethodBeat.o(165349);
          return;
        }
      }
      paramView = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.n.a(paramView, paramT.feedObject.getLocation());
      AppMethodBeat.o(165349);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$1"})
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
        int j = com.tencent.mm.cc.a.fromDPToPix(parame.getContext(), 20);
        localObject = this.raG;
        d.g.b.k.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.raH) + j > i)
        {
          localObject = this.raG;
          d.g.b.k.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.raH;
          TextView localTextView = this.raG;
          d.g.b.k.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$2"})
  static final class g
    implements View.OnClickListener
  {
    g(String paramString, com.tencent.mm.view.recyclerview.e parame, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      paramView = FinderReporterUIC.seQ;
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null) {}
      for (int i = paramView.rfR;; i = 0)
      {
        paramView = new Intent();
        String str = com.tencent.mm.ah.m.d(this.raJ, 156, i + 10000, (int)(System.currentTimeMillis() / 1000L));
        ac.i("Finder.FeedConvert", "click linkLayout, url:" + this.raJ + ", urlWithReportParams:" + str);
        paramView.putExtra("rawUrl", str);
        com.tencent.mm.br.d.b(parame.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(165351);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(g paramg, List paramList, BaseFinderFeed paramBaseFinderFeed, ajz paramajz, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201262);
      g.a(this.raK, paramT, this.raL, parame);
      AppMethodBeat.o(201262);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201263);
      paramView = (BaseFinderFeed)parame.fzs();
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(parame.getContext(), 0, false);
      com.tencent.mm.plugin.finder.feed.g localg = g.b(this.rat);
      d.g.b.k.g(paramView, "item");
      locale.a(localg.a(paramView, locale));
      locale.b(g.b(this.rat).d(paramView));
      locale.a(g.b(this.rat).e(paramView));
      locale.b(g.b(this.rat).e(paramView));
      locale.cED();
      AppMethodBeat.o(201263);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class k
    implements HardTouchableLayout.b
  {
    k(HardTouchableLayout paramHardTouchableLayout, g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(165353);
      d.g.b.k.h(paramView, "view");
      ac.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)parame.fzs());
      jdField_this.a(parame, (View)this.raM);
      AppMethodBeat.o(165353);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class l
    implements HardTouchableLayout.g
  {
    l(HardTouchableLayout paramHardTouchableLayout, g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void dV(View paramView)
    {
      AppMethodBeat.i(165354);
      d.g.b.k.h(paramView, "view");
      ac.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)parame.fzs());
      jdField_this.a(parame, (View)this.raM, ((BaseFinderFeed)parame.fzs()).feedObject.getFeedObject());
      AppMethodBeat.o(165354);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class m
    implements Runnable
  {
    m(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201265);
      Object localObject1 = new Rect();
      this.raN.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.raN;
      d.g.b.k.g(localObject2, "avatarView");
      localObject2 = ((ImageView)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(201265);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.raN));
      AppMethodBeat.o(201265);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.c
  {
    public final boolean S(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(201266);
      d.g.b.k.h(paramMotionEvent, "event");
      AppMethodBeat.o(201266);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165357);
      ac.i("Finder.FeedConvert", "onClickComment:" + parame.lv());
      g.a(this.rat, parame);
      AppMethodBeat.o(165357);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201267);
      ac.i("Finder.FeedConvert", "onClickFav:" + parame.lv());
      g.b(this.rat, parame);
      AppMethodBeat.o(201267);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class q
    implements Runnable
  {
    q(com.tencent.mm.view.recyclerview.e parame, v.f paramf, ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201268);
      int i = com.tencent.mm.cc.a.av(this.ojH.getContext(), 2131165303);
      Object localObject = new Rect();
      ((View)this.raO.KUQ).getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-i, -i);
      ViewParent localViewParent = ((View)this.raO.KUQ).getParent();
      if (localViewParent == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(201268);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)paramRecyclerView));
      AppMethodBeat.o(201268);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(g paramg, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201269);
      ac.i("Finder.FeedConvert", "onClickShare:" + parame.lv());
      g.c(this.rat, parame);
      AppMethodBeat.o(201269);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class s
    implements Runnable
  {
    s(com.tencent.mm.view.recyclerview.e parame, v.f paramf, ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201270);
      int i = com.tencent.mm.cc.a.av(this.ojH.getContext(), 2131165303);
      Object localObject = new Rect();
      ((View)this.raP.KUQ).getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-i, -i);
      ViewParent localViewParent = ((View)this.raP.KUQ).getParent();
      if (localViewParent == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(201270);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)paramRecyclerView));
      AppMethodBeat.o(201270);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class t
    implements View.OnLongClickListener
  {
    t(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201271);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.ojH.fzs();
      paramView = com.tencent.mm.ui.component.a.IrY;
      paramView = this.ojH.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201271);
        throw paramView;
      }
      FinderDebugUIC localFinderDebugUIC = (FinderDebugUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramView).get(FinderDebugUIC.class);
      Context localContext;
      com.tencent.mm.view.recyclerview.e locale;
      com.tencent.mm.ui.widget.a.e locale1;
      long l;
      boolean bool;
      Object localObject;
      if (localFinderDebugUIC != null)
      {
        localContext = this.ojH.getContext();
        d.g.b.k.g(localContext, "holder.context");
        d.g.b.k.g(localBaseFinderFeed, "item");
        locale = this.ojH;
        d.g.b.k.h(localContext, "context");
        d.g.b.k.h(localBaseFinderFeed, "item");
        d.g.b.k.h(locale, "holder");
        locale1 = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
        l = localBaseFinderFeed.lx();
        paramView = (bqs)j.iP((List)localBaseFinderFeed.feedObject.getMediaList());
        if ((paramView == null) || (paramView.mediaType != 4)) {
          break label650;
        }
        bool = true;
        paramView = new StringBuilder(" [ClickMoreDebug]FeedId=").append(com.tencent.mm.ac.c.pb(localBaseFinderFeed.feedObject.getId())).append("\n                posTriggerConfig=");
        localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
        localObject = paramView.append(com.tencent.mm.plugin.finder.storage.data.g.uV(localBaseFinderFeed.feedObject.getId())).append("\n                videoDuration=");
        paramView = (bqs)j.iP((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label656;
        }
        paramView = Integer.valueOf(paramView.videoDuration);
        label260:
        paramView = ((StringBuilder)localObject).append(paramView).append("\n                signedFeedId=").append(localBaseFinderFeed.feedObject.getId()).append("\n                username=").append(localBaseFinderFeed.feedObject.field_username).append("\n                ctFlag=");
        localObject = com.tencent.mm.plugin.finder.api.b.qWt;
        StringBuilder localStringBuilder = paramView.append(b.a.adk(localBaseFinderFeed.feedObject.field_username)).append("\n                mediaType=").append(localBaseFinderFeed.feedObject.getMediaType()).append("\n                mediaId=");
        paramView = (bqs)j.iP((List)localBaseFinderFeed.feedObject.getMediaList());
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
        localObject = localStringBuilder.append(ah.dg(paramView)).append("\n                url=");
        paramView = (bqs)j.iP((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label661;
        }
        paramView = paramView.url;
        label429:
        localObject = ((StringBuilder)localObject).append(paramView).append("\n                thumbUrl=");
        paramView = (bqs)j.iP((List)localBaseFinderFeed.feedObject.getMediaList());
        if (paramView == null) {
          break label666;
        }
      }
      label650:
      label656:
      label661:
      label666:
      for (paramView = paramView.thumbUrl;; paramView = null)
      {
        paramView = paramView + "\n                description=" + localBaseFinderFeed.feedObject.getDescription() + "\n                        ";
        localObject = d.n.n.aWZ("content=" + com.tencent.mm.ac.f.bD(localBaseFinderFeed.feedObject.getFeedObject()));
        ac.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(paramView)));
        ac.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(localObject)));
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.eUk()))
        {
          locale1.a((n.c)new FinderDebugUIC.b(localFinderDebugUIC, bool));
          locale1.a((n.d)new FinderDebugUIC.c(localFinderDebugUIC, localContext, paramView, localBaseFinderFeed, l, (String)localObject, locale));
          locale1.cED();
        }
        this.ojH.asD.requestLayout();
        AppMethodBeat.o(201271);
        return true;
        bool = false;
        break;
        paramView = null;
        break label260;
        paramView = null;
        break label429;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class u
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private long raQ = -1L;
    
    u(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201272);
      d.g.b.k.h(paramb, "ev");
      Object localObject1;
      Object localObject2;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        localObject1 = parame.fzs();
        if (((localObject1 instanceof BaseFinderFeed)) && (this.raQ != ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL))
        {
          long l = ((BaseFinderFeed)localObject1).feedObject.getExpectId();
          if (((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL != l) {
            break label139;
          }
          localObject1 = parame;
          localObject2 = parame.fzs();
          if (localObject2 == null)
          {
            paramb = new v("null cannot be cast to non-null type T");
            AppMethodBeat.o(201272);
            throw paramb;
          }
          g.a(true, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
        }
      }
      for (;;)
      {
        this.raQ = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL;
        AppMethodBeat.o(201272);
        return;
        label139:
        localObject1 = parame;
        localObject2 = parame.fzs();
        if (localObject2 == null)
        {
          paramb = new v("null cannot be cast to non-null type T");
          AppMethodBeat.o(201272);
          throw paramb;
        }
        g.a(false, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(201273);
      d.g.b.k.h(paramc, "dispatcher");
      d.g.b.k.h(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(201273);
      return bool;
    }
    
    public final boolean csW()
    {
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165362);
      paramView = (BaseFinderFeed)this.ojH.fzs();
      Object localObject1 = FinderReporterUIC.seQ;
      localObject1 = this.ojH.getContext();
      d.g.b.k.g(localObject1, "holder.context");
      localObject1 = FinderReporterUIC.a.eV((Context)localObject1);
      int i;
      if (localObject1 != null) {
        i = ((FinderReporterUIC)localObject1).rfR;
      }
      while ((i == 1) || (i == 8))
      {
        ac.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.a(3, paramView.lx(), i, 1, paramView.feedObject.getUserName());
        paramView = this.ojH.getContext();
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
      Object localObject2 = FinderReporterUIC.seQ;
      localObject2 = this.ojH.getContext();
      d.g.b.k.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, paramView.lx(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject2 = this.ojH.getContext();
      d.g.b.k.g(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((this.ojH.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.a.IrY;
        localObject1 = this.ojH.getContext();
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165362);
          throw paramView;
        }
        localObject1 = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)localObject1).get(FinderReporterUIC.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).ctb().tX(paramView.lx());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(3, paramView.lx(), i, 1, paramView.feedObject.getUserName());
      AppMethodBeat.o(165362);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class w
    implements Runnable
  {
    w(BaseFinderFeed paramBaseFinderFeed, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(201274);
      if (this.rav.isContentCollapsed)
      {
        Object localObject1 = localFinderCollapsibleTextView;
        Object localObject2 = ((FinderCollapsibleTextView)localObject1).getCollapseTextView();
        d.g.b.k.g(localObject2, "collapseTextView");
        if ((((TextView)localObject2).getVisibility() != 0) || (!((FinderCollapsibleTextView)localObject1).rVH))
        {
          AppMethodBeat.o(201274);
          return;
        }
        localObject2 = com.tencent.mm.ui.component.a.IrY;
        com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
        FinderHomeTabStateVM.cFL();
        localObject1 = ((FinderCollapsibleTextView)localObject1).getTipsTv();
        if (((View)localObject1).getVisibility() == 8)
        {
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).animate().alpha(1.0F).setDuration(300L).start();
        }
      }
      AppMethodBeat.o(201274);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class x
    implements CommentDrawerContract.CloseDrawerCallback
  {
    x(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.l> paramList)
    {
      AppMethodBeat.i(201275);
      d.g.b.k.h(paramList, "data");
      ((FinderFeedExposeLayout)parame.adJ(2131298523)).EQ(paramT.feedObject.getCommentCount());
      paramList = g.b(this.rat).getVideoCore().rSr;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (g.b(this.rat).cuq())
      {
        paramList = parame.adJ(2131304550);
        d.g.b.k.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.g.fD(1, paramT.feedObject.getCommentCount()));
      }
      AppMethodBeat.o(201275);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.m<View, FinderCommentInfo, y>
  {
    y(g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.m<View, FinderCommentInfo, y>
  {
    z(g paramg, com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g
 * JD-Core Version:    0.7.0.1
 */