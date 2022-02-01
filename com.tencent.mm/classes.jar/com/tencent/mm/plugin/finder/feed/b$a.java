package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aa;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.al.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "getMENU_ID_CANCEL_FAV_TO_FINDER", "()I", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "getMENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "getMENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "getMENU_ID_FOLLOW_PAT", "MENU_ID_NOT_SHOW_AT_FEED", "getMENU_ID_NOT_SHOW_AT_FEED", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "getMENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_POST_SAME_STYLE", "getMENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_RINGTONE", "getMENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "getMENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_AT_FEED", "getMENU_ID_SHOW_AT_FEED", "MENU_ID_SPEED_CTRL", "getMENU_ID_SPEED_CTRL", "MENU_ID_SPLIT_SCREEN", "getMENU_ID_SPLIT_SCREEN", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "tabType", "getTabType", "setTabType", "(I)V", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "from", "createSecondMenu", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isEnableFullScreenEnjoyByScene", "", "isFinderSelfScene", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract class b$a
  implements ah.a, i, com.tencent.mm.plugin.finder.presenter.base.a<b.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  public int fEH;
  public final MMActivity iXq;
  private final int wXf;
  private final int wXg;
  private final int xhI;
  public final com.tencent.mm.plugin.finder.video.l xkW;
  public final int xkX;
  private final int xvA;
  private final int xvB;
  public b.b xvC;
  private RecyclerView.m xvD;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  private final f xvF;
  final int xvj;
  final int xvk;
  private final int xvl;
  private final int xvm;
  final int xvn;
  final int xvo;
  final int xvp;
  final int xvq;
  final int xvr;
  final int xvs;
  final int xvt;
  private final int xvu;
  private final int xvv;
  private final int xvw;
  private final int xvx;
  private final int xvy;
  private final int xvz;
  
  private b$a(MMActivity paramMMActivity, int paramInt)
  {
    this.iXq = paramMMActivity;
    this.xkX = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.xvj = 99;
    this.xhI = 100;
    this.xvk = 101;
    this.wXf = 102;
    this.wXg = 103;
    this.xvl = 104;
    this.xvm = 105;
    this.xvn = 106;
    this.xvo = 107;
    this.xvp = 108;
    this.xvq = 109;
    this.xvr = 110;
    this.xvs = 111;
    this.xvt = 112;
    this.xvu = 113;
    this.xvv = 114;
    this.xvw = 115;
    this.xvx = 116;
    this.xvy = 117;
    this.xvz = 118;
    this.xvA = 119;
    this.xvB = 200;
    this.xvE = new CopyOnWriteArraySet();
    this.xvD = new RecyclerView.m();
    this.xvD.aJ(1, 10);
    this.xvD.aJ(2, 10);
    this.xkW = new com.tencent.mm.plugin.finder.video.l();
    this.xvF = new f(this);
  }
  
  public abstract bu Mv(int paramInt);
  
  public q.f a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    p.k(paramBaseFinderFeed, "feed");
    p.k(parame, "sheet");
    return (q.f)new h(this, paramBaseFinderFeed, parame);
  }
  
  public final q.f a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame, final int paramInt)
  {
    p.k(paramBaseFinderFeed, "feed");
    p.k(parame, "sheet");
    return (q.f)new g(this, paramBaseFinderFeed, paramInt);
  }
  
  public final q.g a(final BaseFinderFeed paramBaseFinderFeed, final int paramInt, final com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(paramBaseFinderFeed, "feed");
    p.k(parami, "holder");
    return (q.g)new i(this, paramBaseFinderFeed, paramInt, parami);
  }
  
  public void a(b.b paramb)
  {
    p.k(paramb, "callback");
    this.xvC = paramb;
    dsr();
    EventCenter.instance.add((IListener)this.xvF);
    paramb = this.xkW;
    b.b localb = this.xvC;
    if (localb == null) {
      p.iCn();
    }
    com.tencent.mm.plugin.finder.video.l.a(paramb, (AppCompatActivity)localb.iXq, (l.b)new j(this), 4);
  }
  
  @SuppressLint({"ResourceType"})
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramMenuItem, "menuItem");
    p.k(parami, "holder");
    Log.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt1 + " menuItem:" + paramMenuItem.getItemId());
    paramInt1 = paramMenuItem.getItemId();
    if (paramInt1 == this.xvy)
    {
      paramMenuItem = this.xvC;
      if (paramMenuItem != null)
      {
        parami = com.tencent.mm.ui.component.g.Xox;
        com.tencent.mm.plugin.finder.viewmodel.component.t.a((com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.t.class), new bs(paramBaseFinderFeed.feedObject.getFeedObject()), paramMenuItem.xvJ.getRecyclerView());
      }
    }
    label539:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt1 != this.xvz) {
                break;
              }
            } while (this.xvC == null);
            localObject1 = (List)new ArrayList();
            paramBaseFinderFeed = parami.RD(b.f.finder_feed_full_footer_layout);
            if (paramBaseFinderFeed != null) {
              ((List)localObject1).add(paramBaseFinderFeed);
            }
            paramBaseFinderFeed = (FinderVideoLayout)parami.RD(b.f.finder_banner_video_layout);
            if (paramBaseFinderFeed != null) {}
            for (paramBaseFinderFeed = paramBaseFinderFeed.getVideoView();; paramBaseFinderFeed = null)
            {
              paramMenuItem = paramBaseFinderFeed;
              if (!(paramBaseFinderFeed instanceof FinderThumbPlayerProxy)) {
                paramMenuItem = null;
              }
              paramBaseFinderFeed = (FinderThumbPlayerProxy)paramMenuItem;
              if (paramBaseFinderFeed == null) {
                break;
              }
              paramMenuItem = com.tencent.mm.ui.component.g.Xox;
              com.tencent.mm.plugin.finder.viewmodel.component.al.a((com.tencent.mm.plugin.finder.viewmodel.component.al)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.al.class), (List)localObject1, paramBaseFinderFeed);
              return;
            }
            if (paramInt1 == this.xvj)
            {
              paramInt1 = m(paramBaseFinderFeed);
              if (paramInt1 >= 0)
              {
                paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.c.xFs;
                com.tencent.mm.plugin.finder.feed.logic.c.a((Context)this.iXq, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new a(this, paramBaseFinderFeed));
                return;
              }
              Log.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt1)));
              return;
            }
          } while (paramInt1 == this.xhI);
          if (paramInt1 == this.wXf)
          {
            new Bundle();
            ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramBaseFinderFeed.feedObject, null, 3, null, 20);
            return;
          }
          if (paramInt1 == this.wXg)
          {
            ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramBaseFinderFeed, 0, 0, 28);
            return;
          }
          if (paramInt1 == this.xvl)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.i.ADk;
            com.tencent.mm.plugin.finder.utils.i.a(paramBaseFinderFeed, this.iXq);
            return;
          }
          if (paramInt1 != this.xvk) {
            break label539;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (!com.tencent.mm.plugin.finder.utils.aj.w(paramBaseFinderFeed)) {
            break;
          }
          paramMenuItem = paramBaseFinderFeed.feedObject.getLiveInfo();
        } while (paramMenuItem == null);
        long l = paramMenuItem.liveId;
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
        com.tencent.mm.plugin.finder.feed.logic.a.d((Context)this.iXq, l, paramBaseFinderFeed.feedObject.getUserName());
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
        com.tencent.mm.plugin.finder.feed.logic.a.a((Context)this.iXq, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 12);
        return;
        if (paramInt1 == this.xvm)
        {
          parami = new Intent();
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          paramMenuItem = localObject4;
          if (localObject1 != null) {
            paramMenuItem = ((FinderObjectDesc)localObject1).toByteArray();
          }
          parami.putExtra("postRefMediaList", paramMenuItem);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
          parami.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.aj.u(paramBaseFinderFeed).toByteArray());
          parami.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          parami.putExtra("key_finder_post_from", 5);
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.iXq, parami);
          return;
        }
        if (paramInt1 == this.xvo)
        {
          ((com.tencent.mm.plugin.finder.service.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.finder.service.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.findersdk.a.aj)new b(this));
          return;
        }
        if (paramInt1 == this.xvn)
        {
          ((com.tencent.mm.plugin.finder.service.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.finder.service.l.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.findersdk.a.aj)new c(this));
          return;
        }
        if (paramInt1 != this.xvq) {
          break;
        }
      } while (!paramBaseFinderFeed.feedObject.isPostFinish());
      paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramMenuItem = aj.a.fZ((Context)this.iXq);
      if (paramMenuItem != null) {
        paramInt1 = paramMenuItem.xkX;
      }
      for (;;)
      {
        if (paramInt1 == 52) {
          if ((this.iXq instanceof FinderTopicTimelineUI))
          {
            paramMenuItem = this.iXq;
            if (paramMenuItem == null)
            {
              throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
              paramInt1 = 0;
              continue;
            }
            ((FinderTopicTimelineUI)paramMenuItem).onBackPressed();
          }
        }
      }
      for (;;)
      {
        paramMenuItem = n.zWF;
        n.a((Context)this.iXq, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        e.a.o(paramBaseFinderFeed.feedObject);
        paramMenuItem = ag.AFH;
        parami = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        paramMenuItem = (MenuItem)localObject1;
        if (parami != null) {
          paramMenuItem = parami.feedBgmInfo;
        }
        ag.a(paramMenuItem, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
      }
      if (paramInt1 == this.xvr)
      {
        paramMenuItem = am.zZN;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        parami = aj.a.fZ((Context)this.iXq);
        paramMenuItem = localObject2;
        if (parami != null) {
          paramMenuItem = parami.ekY();
        }
        am.a(paramMenuItem, "fav_in_menu", false, paramBaseFinderFeed.mf());
        w.a((Context)this.iXq, this.iXq.getResources().getString(b.j.finder_has_fav_title), (w.b)new d(this, paramBaseFinderFeed));
        return;
      }
      if (paramInt1 == this.xvs)
      {
        paramMenuItem = am.zZN;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        parami = aj.a.fZ((Context)this.iXq);
        paramMenuItem = localObject3;
        if (parami != null) {
          paramMenuItem = parami.ekY();
        }
        am.a(paramMenuItem, "unfav_in_menu", false, paramBaseFinderFeed.mf());
        w.a((Context)this.iXq, this.iXq.getResources().getString(b.j.finder_has_cancel_fav_title), (w.b)new e(this, paramBaseFinderFeed));
        return;
      }
      if (paramInt1 == this.xvt)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("KEY_FROM_SCENE", 1);
        paramMenuItem.putExtra("KEY_USERNAME", z.bdh());
        paramMenuItem.putExtra("KEY_FINDER_SELF_FLAG", true);
        parami = FinderPostPreviewUI.xRF;
        paramMenuItem.putExtra(FinderPostPreviewUI.dvS(), true);
        parami = FinderPostPreviewUI.xRF;
        paramMenuItem.putExtra(FinderPostPreviewUI.dvT(), false);
        parami = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a(0, j.listOf(paramBaseFinderFeed), null, paramMenuItem);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.ac((Context)this.iXq, paramMenuItem);
        return;
      }
      if (paramInt1 == this.xvu)
      {
        paramMenuItem = ac.AEJ;
        ac.a.a((AppCompatActivity)this.iXq, paramBaseFinderFeed, null, 12);
        return;
      }
      if (paramInt1 == this.xvx)
      {
        paramMenuItem = aa.AEn;
        aa.a((AppCompatActivity)this.iXq, paramBaseFinderFeed);
        return;
      }
      if (paramInt1 == this.xvB)
      {
        paramMenuItem = ab.AEA;
        paramMenuItem = (Activity)this.iXq;
        parami = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
        ab.a(paramBaseFinderFeed, paramMenuItem, com.tencent.mm.plugin.finder.storage.logic.g.aEW(paramBaseFinderFeed.feedObject.getFromAppId()));
        return;
      }
    } while (paramInt1 != this.xvA);
    if (ar.atR(this.iXq.getTaskId()))
    {
      az.a(az.hXf(), this.iXq.getTaskId(), 0);
      u.a(u.hHB(), this.iXq.getTaskId(), 0);
      return;
    }
    az.a(az.hXf(), this.iXq.getTaskId(), 2);
    u.a(u.hHB(), this.iXq.getTaskId(), 2);
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.o paramo, int paramInt)
  {
    paramInt = 0;
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    Object localObject1 = this.iXq.getString(b.j.app_share_to_weixin);
    p.j(localObject1, "context.getString(R.string.app_share_to_weixin)");
    Object localObject2 = this.iXq.getString(b.j.finder_share_timeline);
    p.j(localObject2, "context.getString(R.string.finder_share_timeline)");
    p.j(this.iXq.getString(b.j.favorite), "context.getString(R.string.favorite)");
    boolean bool2;
    if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
      com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeCollect", b.j.finder_self_see_tips_fav);
      bool2 = true;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      paramo.a(this.wXf, (CharSequence)localObject1, b.i.finder_icons_filled_share, this.iXq.getResources().getColor(b.c.Brand), bool1);
      paramo.a(this.wXg, (CharSequence)localObject2, b.i.bottomsheet_icon_moment, 0, bool2);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.z(paramBaseFinderFeed.feedObject.getFeedObject())) {
        paramo.a(this.xvr, (CharSequence)this.iXq.getString(b.j.finder_self_see_tips_fav), b.i.finder_icons_filled_star2, this.iXq.getResources().getColor(b.c.orange_100), true);
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXB().aSr()).intValue() == 1)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject.getFeedObject()))
          {
            localObject1 = n.zWF;
            n.j((Context)this.iXq, paramBaseFinderFeed.mf());
            paramo.a(this.xvu, (CharSequence)this.iXq.getString(b.j.finder_share_text_stauts_title), b.i.state_icon_main, this.iXq.getResources().getColor(b.c.Blue));
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.C(paramBaseFinderFeed.feedObject.getFeedObject())) {
          paramo.a(this.xvx, (CharSequence)this.iXq.getString(b.j.finder_share_ringtone_title), b.i.finder_icons_colorring, this.iXq.getResources().getColor(b.c.Yellow));
        }
        paramo = n.zWF;
        n.O(paramBaseFinderFeed.mf(), this.xkX);
        paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramo = aj.a.fZ((Context)this.iXq);
        if (paramo != null)
        {
          paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.b(paramo);
          if (paramo != null) {
            paramo.dpO().KL(paramBaseFinderFeed.mf());
          }
        }
        return;
        if (dsq())
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
          if (!com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramBaseFinderFeed.feedObject.getFeedObject())) {
            paramInt = 1;
          }
          if (paramInt != 0) {
            paramo.a(this.xvr, (CharSequence)this.iXq.getString(b.j.favorite), b.i.finder_icons_filled_star2, this.iXq.getResources().getColor(b.c.orange_100));
          } else {
            paramo.a(this.xvs, (CharSequence)this.iXq.getString(b.j.finder_cancel_fav_title), b.i.finder_icons_filled_unstar2, this.iXq.getResources().getColor(b.c.orange_100));
          }
        }
      }
      bool2 = false;
    }
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.o paramo, com.tencent.mm.ui.widget.a.e parame)
  {
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    p.k(parame, "sheet");
    label167:
    boolean bool;
    if (ar.hIH())
    {
      if (ar.atR(this.iXq.getTaskId())) {
        paramo.b(this.xvA, (CharSequence)this.iXq.getString(b.j.close_split_screen), b.i.icons_outlined_merge);
      }
    }
    else
    {
      if (paramBaseFinderFeed.feedObject.isLongVideo())
      {
        paramo.b(this.xvy, (CharSequence)this.iXq.getString(b.j.finder_live_more_action_mini_window), b.i.icons_filled_mini_window_2);
        localObject1 = this.xvC;
        if (localObject1 != null)
        {
          localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.al.Bou;
            localObject2 = al.a.w((RecyclerView)localObject1);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label167;
            }
          }
        }
        localObject1 = this.iXq.getString(b.j.mega_video_play_speed_text);
        p.j(localObject1, "context.getString(R.stri…ga_video_play_speed_text)");
        paramo.b(this.xvz, (CharSequence)localObject1, b.i.icons_outlined_play_control_2);
      }
      Object localObject1 = ab.AEA;
      ab.a((Activity)this.iXq, paramBaseFinderFeed, paramo, parame, this.xvB);
      parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject))
      {
        int i = this.xvq;
        parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
        parame = (CharSequence)com.tencent.mm.plugin.finder.utils.aj.x(paramBaseFinderFeed);
        int j = b.i.icons_outlined_bgm_play;
        if ((paramBaseFinderFeed.feedObject.isPostFinish()) && (!paramBaseFinderFeed.feedObject.isPostFailed())) {
          break label343;
        }
        bool = true;
        label266:
        paramo.a(i, parame, j, bool);
      }
      parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed)) {
        break label349;
      }
      paramo.b(this.xvk, (CharSequence)this.iXq.getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
    }
    label343:
    label349:
    do
    {
      do
      {
        return;
        paramo.b(this.xvA, (CharSequence)this.iXq.getString(b.j.split_screen), b.i.icons_outlined_sperated);
        break;
        bool = false;
        break label266;
      } while (dsq());
      parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
    } while ((!com.tencent.mm.plugin.finder.utils.aj.isAnyEnableFullScreenEnjoy()) || ((paramBaseFinderFeed.bAQ() != 4) && (paramBaseFinderFeed.bAQ() != 2)));
    paramo.b(this.xvt, (CharSequence)this.iXq.getString(b.j.finder_feed_open_in_full_window), b.i.finder_icons_outlined_max_window);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    Object localObject2 = com.tencent.mm.plugin.finder.model.al.zAN;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    com.tencent.mm.plugin.finder.model.al.a((bid)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed.contact));
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    p.k(paramFinderItem, "feed");
    p.k(paramFinderCommentInfo, "comment");
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(paramFinderItem, "feed");
    parami = r.zAk;
    r.a((AppCompatActivity)this.iXq, paramFinderItem, paramBoolean);
  }
  
  public void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
  }
  
  public final void b(FinderItem paramFinderItem)
  {
    p.k(paramFinderItem, "feed");
    ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramFinderItem, null, 0, null, 28);
  }
  
  public abstract void byN();
  
  public final int dsn()
  {
    return this.xvv;
  }
  
  public final int dso()
  {
    return this.xvw;
  }
  
  public boolean dsp()
  {
    return false;
  }
  
  public boolean dsq()
  {
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    return com.tencent.mm.plugin.finder.utils.aj.hd(this.fEH, this.xkX);
  }
  
  public abstract void dsr();
  
  public abstract DataBuffer<bu> dss();
  
  public void dst() {}
  
  public abstract com.tencent.mm.view.recyclerview.f dsu();
  
  public final RecyclerView.m dsv()
  {
    return this.xvD;
  }
  
  public final com.tencent.mm.plugin.finder.view.f dsw()
  {
    Object localObject = this.xvC;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.f localf = ((b.b)localObject).dsC();
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = new com.tencent.mm.plugin.finder.view.f();
    }
    return localObject;
  }
  
  public final MMActivity getActivity()
  {
    return this.iXq;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final com.tencent.mm.plugin.finder.video.l getVideoCore()
  {
    return this.xkW;
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    p.k(paramBaseFinderFeed, "feed");
    ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramBaseFinderFeed, 4, 0, 20);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.xvE.add(parama);
  }
  
  public void l(BaseFinderFeed paramBaseFinderFeed)
  {
    p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    bid localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    localObject1 = ai.zAJ;
    localObject1 = paramBaseFinderFeed.contact;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.i)localObject1).getUsername();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = com.tencent.mm.plugin.finder.cgi.o.xaR;
    ai.a(localbid, (String)localObject1, com.tencent.mm.plugin.finder.cgi.o.dnA(), paramBaseFinderFeed.mf(), paramBaseFinderFeed.isDeepEnjoy, 96);
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null)
    {
      localObject1 = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramBaseFinderFeed = "";
    }
    localObject1 = com.tencent.mm.plugin.finder.api.i.xai;
    d.a.dP(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.i.dny());
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsC();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.f)localObject).eis())) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).eir();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.xvC;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).xvN;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).YdO))
          {
            ((TouchMediaPreviewLayout)localObject).iaa();
            return;
          }
        }
        localObject = this.xvC;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).dsD();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).eis()))
          {
            ((FinderLikeDrawer)localObject).eir();
            return;
          }
        }
        localObject = this.xvC;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).dsz();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).eis()))
          {
            ((FinderLikeDrawer)localObject).eir();
            return;
          }
        }
        localObject = this.xvC;
      } while (localObject == null);
      localObject = ((b.b)localObject).iXq;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.f.Anc.clearCache();
    Object localObject = ((Iterable)this.xvE).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.xvE.clear();
    EventCenter.instance.removeListener((IListener)this.xvF);
    this.xvC = null;
    localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsC();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).onDetach();
      }
    }
  }
  
  public final void onUIPause()
  {
    b.b localb = this.xvC;
    if (localb != null) {
      localb.dsC();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsC();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    a(b.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$5", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$6", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class d
    implements w.b
  {
    d(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(289800);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(b.f.toast_text);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(b.i.icons_filled_done);
          localObject = paramView.getContext();
          p.j(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(b.c.White));
        }
      }
      this.xvG.a(paramBaseFinderFeed.feedObject, true, null);
      AppMethodBeat.o(289800);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class e
    implements w.b
  {
    e(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(287027);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(b.f.toast_text);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(b.i.icons_filled_done);
          localObject = paramView.getContext();
          p.j(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(b.c.White));
        }
      }
      this.xvG.a(paramBaseFinderFeed.feedObject, false, null);
      AppMethodBeat.o(287027);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.plugin.finder.view.g
  {
    private String tag;
    
    f()
    {
      AppMethodBeat.i(165612);
      this.tag = localObject.getTAG();
      AppMethodBeat.o(165612);
    }
    
    public final FinderItem KQ(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.xvG.xvC;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).xvJ.getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165610);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).md();
            localObject = this.xvG.xvC;
            if (localObject == null) {
              p.iCn();
            }
            int j = ((b.b)localObject).wnI;
            localObject = this.xvG.Mv(i - j);
            if ((localObject instanceof BaseFinderFeed))
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165610);
              return localObject;
            }
          }
        }
      }
      AppMethodBeat.o(165610);
      return null;
    }
    
    public final void a(long paramLong, bfw parambfw)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.xvG.xvC;
      if (localObject1 != null)
      {
        localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            parambfw = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw parambfw;
          }
          localObject2 = com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).md();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).d(i, new kotlin.o(Integer.valueOf(1), parambfw));
              AppMethodBeat.o(165611);
              return;
            }
            AppMethodBeat.o(165611);
            return;
          }
          AppMethodBeat.o(165611);
          return;
        }
      }
      AppMethodBeat.o(165611);
    }
    
    public final String getTag()
    {
      return this.tag;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements q.f
  {
    g(b.a parama, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(165613);
      b.a locala = this.xvG;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.j(paramo, "menu");
      locala.a(localBaseFinderFeed, paramo, paramInt);
      AppMethodBeat.o(165613);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class h
    implements q.f
  {
    h(b.a parama, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(165614);
      b.a locala = this.xvG;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.j(paramo, "menu");
      locala.a(localBaseFinderFeed, paramo, parame);
      AppMethodBeat.o(165614);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class i
    implements q.g
  {
    i(b.a parama, BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      b.a locala = this.xvG;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.j(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt, paramInt, parami);
      AppMethodBeat.o(165615);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
  public static final class j
    implements l.b
  {
    public final RecyclerView dsx()
    {
      AppMethodBeat.i(280147);
      Object localObject = this.xvG.xvC;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((b.b)localObject).xvJ.getRecyclerView();
      AppMethodBeat.o(280147);
      return localObject;
    }
    
    public final DataBuffer<bu> dsy()
    {
      AppMethodBeat.i(280148);
      DataBuffer localDataBuffer = this.xvG.dss();
      AppMethodBeat.o(280148);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */