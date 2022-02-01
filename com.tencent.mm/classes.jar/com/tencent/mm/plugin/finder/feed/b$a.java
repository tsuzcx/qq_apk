package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.p.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.x;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "getMENU_ID_CANCEL_FAV_TO_FINDER", "()I", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "MENU_ID_CREATION_BY_SAME_TEMPLATE", "getMENU_ID_CREATION_BY_SAME_TEMPLATE", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "getMENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "getMENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "getMENU_ID_FOLLOW_PAT", "MENU_ID_NOT_SHOW_AT_FEED", "getMENU_ID_NOT_SHOW_AT_FEED", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "getMENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_POST_SAME_STYLE", "getMENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_RINGTONE", "getMENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "getMENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_AT_FEED", "getMENU_ID_SHOW_AT_FEED", "MENU_ID_SPEED_CTRL", "getMENU_ID_SPEED_CTRL", "MENU_ID_SPLIT_SCREEN", "getMENU_ID_SPLIT_SCREEN", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "quickMenuHelper", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "tabType", "getTabType", "setTabType", "(I)V", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "from", "createQuickMenu", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "createSecondMenu", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "getCreateQuickMoreMenuListener", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemLongSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "bottomSheet", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "handleNoInterest", "initVideoAbout", "initViewCallback", "isFinderSelfScene", "", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "source", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b$a
  implements an.a, i, com.tencent.mm.plugin.finder.presenter.base.a<b.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public final l AJn;
  public final int AJo;
  private final int AST;
  private final int ASU;
  private final int ASV;
  private final int ASW;
  private final int ASX;
  private final int ASY;
  private final int ASZ;
  private final int ATa;
  private final int ATb;
  private final int ATc;
  private final int ATd;
  private final int ATe;
  private final int ATf;
  private final int ATg;
  private final int ATh;
  private final int ATi;
  private final int ATj;
  private final int ATk;
  private final int ATl;
  private final int ATm;
  private final int ATn;
  public b.b ATo;
  private RecyclerView.m ATp;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  private final com.tencent.mm.pluginsdk.q ATr;
  private final FinderBaseFeedUIContract.Presenter.feedExposeInfoChangeListener.1 ATs;
  private final int Auf;
  private final int Aug;
  private final String TAG;
  public int hJx;
  public final MMActivity lzt;
  
  private b$a(MMActivity paramMMActivity, int paramInt)
  {
    this.lzt = paramMMActivity;
    this.AJo = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.AST = 99;
    this.ASU = 100;
    this.ASV = 101;
    this.Auf = 102;
    this.Aug = 103;
    this.ASW = 104;
    this.ASX = 105;
    this.ASY = 106;
    this.ASZ = 107;
    this.ATa = 108;
    this.ATb = 109;
    this.ATc = 110;
    this.ATd = 111;
    this.ATe = 112;
    this.ATf = 113;
    this.ATg = 114;
    this.ATh = 115;
    this.ATi = 116;
    this.ATj = 117;
    this.ATk = 118;
    this.ATl = 119;
    this.ATm = 120;
    this.ATn = 200;
    this.ATq = new CopyOnWriteArraySet();
    this.ATr = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
    this.ATp = new RecyclerView.m();
    this.ATp.bD(1, 10);
    this.ATp.bD(2, 10);
    this.AJn = new l();
    this.ATs = new FinderBaseFeedUIContract.Presenter.feedExposeInfoChangeListener.1(this);
  }
  
  private static final void a(a parama)
  {
    kotlin.g.b.s.u(parama, "this$0");
  }
  
  private static final void a(a parama, BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.ui.base.s params)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.s(params, "menu");
    parama.a(paramBaseFinderFeed, params, paramInt);
  }
  
  private static final void a(a parama, BaseFinderFeed paramBaseFinderFeed, int paramInt1, j paramj, MenuItem paramMenuItem, int paramInt2)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.s(paramMenuItem, "menuItem");
    parama.a(paramBaseFinderFeed, paramMenuItem, paramInt2, paramInt1, paramj);
  }
  
  private static final void a(a parama, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)parama, paramBaseFinderFeed.feedObject, true);
  }
  
  private static final void a(a parama, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramf, "$sheet");
    kotlin.g.b.s.s(params, "menu");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    if (!paramBaseFinderFeed.feedObject.isNotShareConversation())
    {
      parama.ATr.a((Context)parama.lzt, params, paramf);
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.an.GhR;
      com.tencent.mm.plugin.finder.utils.an.a.TX(parama.ATr.getItemCount());
    }
  }
  
  private static final void a(a parama, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, j paramj, com.tencent.mm.ui.base.s params)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramf, "$sheet");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.s(params, "menu");
    parama.a(paramBaseFinderFeed, params, paramf, paramj);
  }
  
  private static final void a(a parama, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    com.tencent.mm.pluginsdk.q localq = parama.ATr;
    if (paramMenuItem == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
    }
    boolean bool = localq.a(paramf, (t)paramMenuItem);
    Log.i(parama.getTAG(), kotlin.g.b.s.X("getMoreMenuItemLongSelectedListener :", Boolean.valueOf(bool)));
  }
  
  private static final void b(a parama, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)parama, paramBaseFinderFeed.feedObject, false);
  }
  
  public abstract cc NC(int paramInt);
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    return new b.a..ExternalSyntheticLambda3(this, paramBaseFinderFeed, paramf);
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, int paramInt)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    return new b.a..ExternalSyntheticLambda2(this, paramBaseFinderFeed, paramInt);
  }
  
  public u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, j paramj)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    return new b.a..ExternalSyntheticLambda4(this, paramBaseFinderFeed, paramf, paramj);
  }
  
  public final u.h a(com.tencent.mm.ui.widget.a.f paramf, BaseFinderFeed paramBaseFinderFeed, j paramj)
  {
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    return new b.a..ExternalSyntheticLambda5(this, paramf);
  }
  
  public final u.i a(BaseFinderFeed paramBaseFinderFeed, int paramInt, j paramj)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    return new b.a..ExternalSyntheticLambda6(this, paramBaseFinderFeed, paramInt, paramj);
  }
  
  public void a(b.b paramb)
  {
    kotlin.g.b.s.u(paramb, "callback");
    this.ATo = paramb;
    dUM();
    this.ATs.alive();
    paramb = this.AJn;
    b.b localb = this.ATo;
    kotlin.g.b.s.checkNotNull(localb);
    l.a(paramb, (AppCompatActivity)localb.lzt, (l.b)new e(this), 4);
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    paramInt = h(paramBaseFinderFeed);
    if (paramInt >= 0)
    {
      com.tencent.mm.plugin.finder.feed.logic.c localc = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
      com.tencent.mm.plugin.finder.feed.logic.c.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new f(this, paramBaseFinderFeed));
      return;
    }
    Log.i(getTAG(), kotlin.g.b.s.X("[UNINTEREST] pos error ", Integer.valueOf(paramInt)));
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, final MenuItem paramMenuItem, int paramInt1, int paramInt2, j paramj)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    kotlin.g.b.s.u(paramj, "holder");
    Log.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt1 + " menuItem:" + paramMenuItem.getItemId());
    paramInt2 = paramMenuItem.getItemId();
    if (paramInt2 == this.ATj)
    {
      paramMenuItem = this.ATo;
      if (paramMenuItem != null)
      {
        paramj = k.aeZF;
        paramj = k.d((AppCompatActivity)this.lzt).q(x.class);
        kotlin.g.b.s.s(paramj, "UICProvider.of(getActivi…tMiniViewUIC::class.java)");
        x.a((x)paramj, new ca(paramBaseFinderFeed.feedObject.getFeedObject()), paramMenuItem.ATx.getRecyclerView());
        paramBaseFinderFeed = ah.aiuX;
        paramBaseFinderFeed = ah.aiuX;
      }
    }
    label310:
    label313:
    label586:
    label843:
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (paramInt2 != this.ATk) {
                break;
              }
              if (this.ATo != null)
              {
                paramMenuItem = (List)new ArrayList();
                paramBaseFinderFeed = paramj.UH(e.e.finder_feed_full_footer_layout);
                if (paramBaseFinderFeed != null) {
                  paramMenuItem.add(paramBaseFinderFeed);
                }
                paramBaseFinderFeed = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
                if (paramBaseFinderFeed == null)
                {
                  paramBaseFinderFeed = null;
                  if (!(paramBaseFinderFeed instanceof FinderThumbPlayerProxy)) {
                    break label310;
                  }
                }
                for (paramBaseFinderFeed = (FinderThumbPlayerProxy)paramBaseFinderFeed;; paramBaseFinderFeed = null)
                {
                  if (paramBaseFinderFeed == null) {
                    break label313;
                  }
                  paramj = k.aeZF;
                  paramj = k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.av.class);
                  kotlin.g.b.s.s(paramj, "UICProvider.of(getActivi…edControlUIC::class.java)");
                  com.tencent.mm.plugin.finder.viewmodel.component.av.a((com.tencent.mm.plugin.finder.viewmodel.component.av)paramj, paramMenuItem, paramBaseFinderFeed, 0, false, null, 28);
                  paramBaseFinderFeed = ah.aiuX;
                  paramBaseFinderFeed = ah.aiuX;
                  return;
                  paramBaseFinderFeed = paramBaseFinderFeed.getVideoView();
                  break;
                }
              }
            }
            if (paramInt2 != this.AST) {
              break;
            }
            a(paramBaseFinderFeed, paramInt1);
          } while (h(paramBaseFinderFeed) <= 0);
          ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("feed_uninterest_clk", paramj.caK, null, 24617);
          return;
        } while (paramInt2 == this.ASU);
        if (paramInt2 == this.Auf)
        {
          new Bundle();
          com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)this.lzt, paramBaseFinderFeed.feedObject, null, 3, 20);
          return;
        }
        if (paramInt2 == this.Aug)
        {
          com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)this.lzt, paramBaseFinderFeed, 0, 0, 28);
          return;
        }
        if (paramInt2 == this.ATm)
        {
          paramMenuItem = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          Object localObject;
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            if (paramMenuItem != null) {
              break label586;
            }
            aa.dc((Context)this.lzt, this.lzt.getString(e.h.finder_get_video_template_error));
            paramMenuItem = k.aeZF;
            paramj = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
            paramMenuItem = bb.FuK;
            localObject = new JSONObject();
            paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramBaseFinderFeed != null) {
              break label685;
            }
            paramBaseFinderFeed = Integer.valueOf(0);
          }
          for (;;)
          {
            ((JSONObject)localObject).put("templateId", paramBaseFinderFeed);
            paramBaseFinderFeed = ah.aiuX;
            bb.a(paramj, "shoot_same_video", true, (JSONObject)localObject);
            return;
            paramMenuItem = paramMenuItem.video_tmpl_info;
            break;
            paramj = new Intent();
            switch (paramMenuItem.type)
            {
            default: 
              paramInt1 = -1;
            }
            for (;;)
            {
              localObject = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
              Activity localActivity = (Activity)this.lzt;
              paramj.putExtra("key_maas_entrance", 5);
              ah localah = ah.aiuX;
              ((com.tencent.mm.mj_template.api.d)localObject).creationBySameTemplate(localActivity, paramMenuItem, paramj, paramInt1);
              break;
              paramInt1 = 16;
              continue;
              paramInt1 = 13;
            }
            paramBaseFinderFeed = paramBaseFinderFeed.video_tmpl_info;
            if (paramBaseFinderFeed == null)
            {
              paramBaseFinderFeed = Integer.valueOf(0);
            }
            else
            {
              paramMenuItem = paramBaseFinderFeed.id;
              paramBaseFinderFeed = paramMenuItem;
              if (paramMenuItem == null) {
                paramBaseFinderFeed = Integer.valueOf(0);
              }
            }
          }
        }
        if (paramInt2 == this.ASW)
        {
          paramMenuItem = n.Ggy;
          n.a(paramBaseFinderFeed, (Activity)this.lzt);
          return;
        }
        if (paramInt2 != this.ASV) {
          break label843;
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (!com.tencent.mm.plugin.finder.utils.aw.s(paramBaseFinderFeed)) {
          break;
        }
        paramMenuItem = paramBaseFinderFeed.feedObject.getLiveInfo();
      } while (paramMenuItem == null);
      long l = paramMenuItem.liveId;
      paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
      com.tencent.mm.plugin.finder.feed.logic.a.c((Context)this.lzt, l, paramBaseFinderFeed.feedObject.getUserName());
      paramBaseFinderFeed = ah.aiuX;
      paramBaseFinderFeed = ah.aiuX;
      return;
      paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
      com.tencent.mm.plugin.finder.feed.logic.a.a((Context)this.lzt, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 0, 28);
      return;
      if (paramInt2 == this.ASX)
      {
        paramj = new Intent();
        paramMenuItem = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramMenuItem == null) {}
        for (paramMenuItem = null;; paramMenuItem = paramMenuItem.toByteArray())
        {
          paramj.putExtra("postRefMediaList", paramMenuItem);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.av.GiL;
          paramj.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.av.o(paramBaseFinderFeed).toByteArray());
          paramj.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          paramj.putExtra("key_finder_post_from", 5);
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.lzt, paramj);
          return;
        }
      }
      if (paramInt2 == this.ASZ)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (ck)new c(this));
        return;
      }
      if (paramInt2 == this.ASY)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (ck)new d(this));
        return;
      }
      if (paramInt2 != this.ATb) {
        break;
      }
    } while (!paramBaseFinderFeed.feedObject.isPostFinish());
    label685:
    paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramMenuItem = as.a.hu((Context)this.lzt);
    if (paramMenuItem == null) {}
    for (paramInt1 = 0; paramInt1 == 52; paramInt1 = paramMenuItem.AJo)
    {
      if ((this.lzt instanceof FinderTopicTimelineUI)) {
        ((FinderTopicTimelineUI)this.lzt).onBackPressed();
      }
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a((Context)this.lzt, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
      return;
    }
    paramMenuItem = e.FMN;
    e.a.s(paramBaseFinderFeed.feedObject);
    paramMenuItem = com.tencent.mm.plugin.finder.utils.as.GiG;
    paramj = (Context)this.lzt;
    paramMenuItem = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    if (paramMenuItem == null) {}
    for (paramMenuItem = null;; paramMenuItem = paramMenuItem.feedBgmInfo)
    {
      com.tencent.mm.plugin.finder.utils.as.a(paramj, paramMenuItem, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
      break;
    }
    if (paramInt2 == this.ATc)
    {
      paramMenuItem = bb.FuK;
      paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramMenuItem = as.a.hu((Context)this.lzt);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        bb.a(paramMenuItem, "fav_in_menu", false, paramBaseFinderFeed.bZA());
        paramMenuItem = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label1362;
        }
      }
      label1362:
      for (paramMenuItem = this.lzt.getResources().getString(e.h.finder_has_fav_title);; paramMenuItem = this.lzt.getResources().getString(e.h.finder_has_fav_title2))
      {
        kotlin.g.b.s.s(paramMenuItem, "if (FinderConfig.FINDER_…e2)\n                    }");
        aa.a((Context)this.lzt, paramMenuItem, new b.a..ExternalSyntheticLambda1(this, paramBaseFinderFeed));
        return;
        paramMenuItem = paramMenuItem.fou();
        break;
      }
    }
    if (paramInt2 == this.ATd)
    {
      paramMenuItem = bb.FuK;
      paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramMenuItem = as.a.hu((Context)this.lzt);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        bb.a(paramMenuItem, "unfav_in_menu", false, paramBaseFinderFeed.bZA());
        paramMenuItem = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label1494;
        }
      }
      label1494:
      for (paramMenuItem = this.lzt.getResources().getString(e.h.finder_has_cancel_fav_title);; paramMenuItem = this.lzt.getResources().getString(e.h.finder_has_cancel_fav_title2))
      {
        kotlin.g.b.s.s(paramMenuItem, "if (FinderConfig.FINDER_…e2)\n                    }");
        aa.a((Context)this.lzt, paramMenuItem, new b.a..ExternalSyntheticLambda0(this, paramBaseFinderFeed));
        return;
        paramMenuItem = paramMenuItem.fou();
        break;
      }
    }
    if (paramInt2 == this.ATe)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("KEY_FROM_SCENE", 1);
      paramMenuItem.putExtra("KEY_USERNAME", com.tencent.mm.model.z.bAW());
      paramMenuItem.putExtra("KEY_FINDER_SELF_FLAG", true);
      paramMenuItem.putExtra("KEY_IS_FULLSCREEN", true);
      paramMenuItem.putExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", false);
      paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
      com.tencent.mm.plugin.finder.utils.av.a(0, kotlin.a.p.listOf(paramBaseFinderFeed), null, paramMenuItem);
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.S((Context)this.lzt, paramMenuItem);
      return;
    }
    if (paramInt2 == this.ATf)
    {
      com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)this.lzt, paramBaseFinderFeed);
      return;
    }
    if (paramInt2 == this.ATi)
    {
      paramMenuItem = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
      paramMenuItem.fiH();
      paramj = al.GhB;
      al.a((AppCompatActivity)this.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new a(paramMenuItem, this));
      return;
    }
    if (paramInt2 == this.ATn)
    {
      paramMenuItem = am.GhD;
      paramMenuItem = (Activity)this.lzt;
      paramj = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      am.a(paramBaseFinderFeed, paramMenuItem, com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId()));
      return;
    }
    if (paramInt2 == this.ATl)
    {
      ag.a(this.lzt.getTaskId(), null);
      return;
    }
    this.ATr.a((t)paramMenuItem, (kotlin.g.a.b)new b(this, paramMenuItem, paramBaseFinderFeed));
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, int paramInt)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    Object localObject3 = com.tencent.mm.plugin.finder.utils.av.a((Context)this.lzt, paramBaseFinderFeed, null, 12);
    boolean bool1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).GiW;
    boolean bool2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).GiX;
    boolean bool3 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).GiY;
    localObject1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).GiZ;
    Object localObject2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).Gja;
    localObject3 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject3).Gjb;
    params.a(this.Auf, (CharSequence)localObject1, e.g.finder_icons_filled_share, this.lzt.getResources().getColor(e.b.Brand), bool1);
    params.a(this.Aug, (CharSequence)localObject2, e.g.bottomsheet_icon_moment, 0, bool2);
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    label173:
    label212:
    int i;
    label232:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label831;
      }
      paramInt = 1;
      label286:
      label323:
      label341:
      if (paramInt == 0)
      {
        localObject1 = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig();
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject2 != null) {
          break label836;
        }
        paramInt = 0;
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject2 != null) {
          break label879;
        }
        i = 0;
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject2 != null) {
          break label925;
        }
        j = -1;
        label252:
        if (((com.tencent.mm.mj_template.api.a)localObject1).ag(paramInt, i, j))
        {
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label953;
          }
          paramInt = 0;
          if (paramInt <= 0) {
            break label1004;
          }
          localObject2 = this.lzt;
          i = e.h.finder_share_use_same_template_with_count;
          if (paramInt <= 99999) {
            break label979;
          }
          localObject1 = String.valueOf(this.lzt.getString(e.h.finder_hundred_thousand_ringtone));
          localObject1 = ((MMActivity)localObject2).getString(i, new Object[] { localObject1 });
          kotlin.g.b.s.s(localObject1, "if (count > 0) context.g…_share_use_same_template)");
          params.a(this.ATm, (CharSequence)localObject1, e.d.icons_filled_saneeffects, this.lzt.getResources().getColor(e.b.Brand), false);
          localObject1 = k.aeZF;
          bui localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
          localObject1 = bb.FuK;
          JSONObject localJSONObject = new JSONObject();
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label1019;
          }
          localObject1 = Integer.valueOf(0);
          localJSONObject.put("templateId", localObject1);
          localObject1 = ah.aiuX;
          bb.a(localbui, "shoot_same_video", false, localJSONObject);
        }
      }
      label446:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        if (!bool3) {
          break label1065;
        }
        params.a(this.ATc, (CharSequence)localObject3, e.g.finder_icons_filled_star2, this.lzt.getResources().getColor(e.b.orange_100), true);
      }
      label529:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWt().bmg()).intValue() == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.F(paramBaseFinderFeed.feedObject.getFeedObject()))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.j((Context)this.lzt, paramBaseFinderFeed.bZA());
          params.a(this.ATf, (CharSequence)this.lzt.getString(e.h.finder_share_text_stauts_title), e.g.state_icon_main, this.lzt.getResources().getColor(e.b.Blue));
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.p(paramBaseFinderFeed))
      {
        localObject1 = paramBaseFinderFeed.feedObject;
        if (localObject1 != null) {
          break label1179;
        }
        paramInt = 0;
        label650:
        if (paramInt == 0) {
          break label1230;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (paramInt < com.tencent.mm.plugin.finder.utils.av.fgc()) {
          break label1230;
        }
        if (paramInt <= 99999) {
          break label1205;
        }
        localObject1 = String.valueOf(this.lzt.getString(e.h.finder_hundred_thousand_ringtone));
      }
    }
    label688:
    label831:
    label836:
    label1230:
    for (localObject1 = this.lzt.getString(e.h.finder_feed_has_been_set_ringtone, new Object[] { localObject1 });; localObject1 = this.lzt.getString(e.h.finder_share_ringtone_title))
    {
      kotlin.g.b.s.s(localObject1, "if(count != 0 && count >…_title)\n                }");
      params.a(this.ATi, (CharSequence)localObject1, e.g.icons_filled_ringtone, 0);
      params = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.aa(paramBaseFinderFeed.bZA(), this.AJo);
      params = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      params = as.a.hu((Context)this.lzt);
      if (params != null)
      {
        params = ((bn)params).foy();
        if (params != null)
        {
          params = params.dYj();
          if (params != null) {
            params.nj(paramBaseFinderFeed.bZA());
          }
        }
      }
      return;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((byy)localObject1).id;
      break;
      paramInt = 0;
      break label173;
      localObject2 = ((FinderObjectDesc)localObject2).video_tmpl_info;
      if (localObject2 == null)
      {
        paramInt = 0;
        break label212;
      }
      localObject2 = ((byy)localObject2).aahY;
      if (localObject2 == null)
      {
        paramInt = 0;
        break label212;
      }
      paramInt = ((fxe)localObject2).abME;
      break label212;
      label879:
      localObject2 = ((FinderObjectDesc)localObject2).video_tmpl_info;
      if (localObject2 == null)
      {
        i = 0;
        break label232;
      }
      localObject2 = ((byy)localObject2).aahY;
      if (localObject2 == null)
      {
        i = 0;
        break label232;
      }
      i = ((fxe)localObject2).abMF;
      break label232;
      localObject2 = ((FinderObjectDesc)localObject2).video_tmpl_info;
      if (localObject2 == null)
      {
        j = -1;
        break label252;
      }
      j = ((byy)localObject2).type;
      break label252;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        paramInt = 0;
        break label286;
      }
      paramInt = ((byy)localObject1).ZmT;
      break label286;
      label979:
      if (paramInt > 9999)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.Ul(paramInt);
        break label323;
      }
      localObject1 = String.valueOf(paramInt);
      break label323;
      label1004:
      localObject1 = this.lzt.getString(e.h.finder_share_use_same_template);
      break label341;
      label1019:
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        localObject1 = Integer.valueOf(0);
        break label446;
      }
      localObject2 = ((byy)localObject1).id;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label446;
      }
      localObject1 = Integer.valueOf(0);
      break label446;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1138;
        }
        params.a(this.ATc, (CharSequence)this.lzt.getString(e.h.favorite), e.g.finder_icons_filled_star2, this.lzt.getResources().getColor(e.b.orange_100));
        break;
      }
      label1138:
      params.a(this.ATd, (CharSequence)this.lzt.getString(e.h.finder_cancel_fav_title), e.g.finder_icons_filled_unstar2, this.lzt.getResources().getColor(e.b.orange_100));
      break label529;
      localObject1 = ((FinderItem)localObject1).field_finderObject;
      if (localObject1 == null)
      {
        paramInt = 0;
        break label650;
      }
      paramInt = ((FinderObject)localObject1).ringtone_count;
      break label650;
      if (paramInt > 9999)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.Ul(paramInt);
        break label688;
      }
      localObject1 = String.valueOf(paramInt);
      break label688;
    }
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, j paramj)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    label97:
    Object localObject;
    int i;
    int j;
    if (com.tencent.mm.ui.aw.jkS())
    {
      if (com.tencent.mm.ui.aw.aAj(this.lzt.getTaskId())) {
        params.a(this.ATl, (CharSequence)this.lzt.getString(e.h.close_split_screen), e.g.icons_outlined_merge);
      }
    }
    else
    {
      if (paramBaseFinderFeed.feedObject.isLongVideo())
      {
        paramj = this.ATo;
        if (paramj != null) {
          break label302;
        }
        paramj = null;
        localObject = paramj;
        if (paramj == null)
        {
          localObject = this.lzt.getString(e.h.mega_video_play_speed_text);
          kotlin.g.b.s.s(localObject, "context.getString(R.stri…ga_video_play_speed_text)");
        }
        params.a(this.ATk, (CharSequence)localObject, e.g.icons_outlined_play_control_2);
      }
      paramj = am.GhD;
      am.a((Activity)this.lzt, paramBaseFinderFeed, params, paramf, this.ATn);
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.I(paramBaseFinderFeed.feedObject))
      {
        i = this.ATb;
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        paramf = (CharSequence)com.tencent.mm.plugin.finder.utils.av.r(paramBaseFinderFeed);
        j = e.g.icons_outlined_bgm_play;
        if ((paramBaseFinderFeed.feedObject.isPostFinish()) && (!paramBaseFinderFeed.feedObject.isPostFailed())) {
          break label327;
        }
      }
    }
    label302:
    label327:
    for (boolean bool = true;; bool = false)
    {
      params.a(i, paramf, j, bool);
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!com.tencent.mm.plugin.finder.utils.av.e(paramBaseFinderFeed)) {
        params.a(this.ASV, (CharSequence)this.lzt.getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
      }
      return;
      params.a(this.ATl, (CharSequence)this.lzt.getString(e.h.split_screen), e.g.icons_outlined_sperated);
      break;
      paramj = paramj.ATx.getRecyclerView();
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.av.GUq;
      paramj = com.tencent.mm.plugin.finder.viewmodel.component.av.a.H(paramj);
      break label97;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    Object localObject2 = com.tencent.mm.plugin.finder.model.an.ECX;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    com.tencent.mm.plugin.finder.model.an.a((bui)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.aw.n(paramBaseFinderFeed.contact));
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, j paramj, int paramInt)
  {
    kotlin.g.b.s.u(paramFinderItem, "feed");
    paramj = com.tencent.mm.plugin.finder.model.s.ECs;
    com.tencent.mm.plugin.finder.model.s.a((AppCompatActivity)this.lzt, paramFinderItem, paramBoolean, paramInt);
  }
  
  public void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    kotlin.g.b.s.u(paramd, "reason");
  }
  
  public abstract void bXB();
  
  public abstract g dUK();
  
  public abstract void dUM();
  
  public final com.tencent.mm.plugin.finder.view.f ebA()
  {
    b.b localb = this.ATo;
    if (localb == null) {
      return new com.tencent.mm.plugin.finder.view.f();
    }
    return localb.ebH();
  }
  
  public final int ebj()
  {
    return this.AST;
  }
  
  public final int ebk()
  {
    return this.ASV;
  }
  
  public final int ebl()
  {
    return this.Aug;
  }
  
  public final int ebm()
  {
    return this.ASY;
  }
  
  public final int ebn()
  {
    return this.ASZ;
  }
  
  public final int ebo()
  {
    return this.ATa;
  }
  
  public final int ebp()
  {
    return this.ATb;
  }
  
  public final int ebq()
  {
    return this.ATc;
  }
  
  public final int ebr()
  {
    return this.ATd;
  }
  
  public final int ebs()
  {
    return this.ATe;
  }
  
  public final int ebt()
  {
    return this.ATg;
  }
  
  public final int ebu()
  {
    return this.ATh;
  }
  
  public final int ebv()
  {
    return this.ATi;
  }
  
  public boolean ebw()
  {
    return false;
  }
  
  public abstract DataBuffer<cc> ebx();
  
  public void eby() {}
  
  public final RecyclerView.m ebz()
  {
    return this.ATp;
  }
  
  public void f(BaseFinderFeed paramBaseFinderFeed)
  {
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject = k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    ak localak = ak.ECS;
    Context localContext = (Context)this.lzt;
    p.a locala = com.tencent.mm.plugin.finder.cgi.p.AyV;
    ak.a(localak, localContext, (bui)localObject, paramBaseFinderFeed, com.tencent.mm.plugin.finder.cgi.p.dVd(), paramBaseFinderFeed.isDeepEnjoy);
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {
      paramBaseFinderFeed = "";
    }
    for (;;)
    {
      localObject = m.Axk;
      d.a.et(paramBaseFinderFeed, m.dUG());
      return;
      localObject = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject;
      if (localObject == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.lzt;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final l getVideoCore()
  {
    return this.AJn;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.ATq.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ebH();
      if (((com.tencent.mm.plugin.finder.view.f)localObject).fkp()) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).fdh();
      }
    }
    do
    {
      return;
      localObject = this.ATo;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).ATB;
        if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).afVJ))
        {
          ((TouchMediaPreviewLayout)localObject).jFh();
          return;
        }
      }
      localObject = this.ATo;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).ebI();
        if (((FinderLikeDrawer)localObject).fkp())
        {
          ((FinderLikeDrawer)localObject).fdh();
          return;
        }
      }
      localObject = this.ATo;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).ebF();
        if (((FinderLikeDrawer)localObject).fkp())
        {
          ((FinderLikeDrawer)localObject).fdh();
          return;
        }
      }
      localObject = this.ATo;
    } while (localObject == null);
    ((b.b)localObject).lzt.finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.f.FMT.clearCache();
    Object localObject = ((Iterable)this.ATq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.ATq.clear();
    this.ATs.dead();
    this.ATo = null;
    localObject = this.ATo;
    if (localObject != null) {
      ((b.b)localObject).ebH().onDetach();
    }
  }
  
  public final void onUIPause()
  {
    b.b localb = this.ATo;
    if (localb != null) {
      localb.ebH();
    }
  }
  
  public final void onUIResume()
  {
    b.b localb = this.ATo;
    if (localb != null) {
      localb.ebH().onUIResume();
    }
    localb = this.ATo;
    if (localb != null) {
      localb.ATx.getRecyclerView().post(new b.a..ExternalSyntheticLambda7(this));
    }
  }
  
  public abstract void requestRefresh();
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, b.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(b.a parama, MenuItem paramMenuItem, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$6", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ck<bpu>
  {
    c(b.a parama) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$7", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ck<bpu>
  {
    d(b.a parama) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements l.b
  {
    e(b.a parama) {}
    
    public final RecyclerView ebB()
    {
      AppMethodBeat.i(363934);
      Object localObject = this.ATt.ATo;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((b.b)localObject).ATx.getRecyclerView();
      AppMethodBeat.o(363934);
      return localObject;
    }
    
    public final boolean ebC()
    {
      return true;
    }
    
    public final boolean ebD()
    {
      return true;
    }
    
    public final DataBuffer<cc> ebE()
    {
      AppMethodBeat.i(363944);
      DataBuffer localDataBuffer = this.ATt.ebx();
      AppMethodBeat.o(363944);
      return localDataBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    f(b.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */