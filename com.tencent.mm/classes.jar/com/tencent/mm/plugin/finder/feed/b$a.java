package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bb.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "getMENU_ID_CANCEL_FAV_TO_FINDER", "()I", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "getMENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "getMENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "getMENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "tabType", "getTabType", "setTabType", "(I)V", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isEnableFullScreenEnjoyByScene", "", "isFinderSelfScene", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract class b$a
  implements ab.a, i, com.tencent.mm.plugin.finder.presenter.base.a<b.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  public int dLS;
  public final MMActivity gte;
  final int pLU;
  final int pMa;
  public final com.tencent.mm.plugin.finder.video.k tCD;
  public final int tCE;
  final int tLD;
  private final int tLE;
  private final int tLF;
  final int tLG;
  final int tLH;
  final int tLI;
  final int tLJ;
  final int tLK;
  final int tLL;
  final int tLM;
  public b.b tLN;
  private RecyclerView.m tLO;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  private final f tLQ;
  final int tqv;
  private final int tzW;
  
  private b$a(MMActivity paramMMActivity, int paramInt)
  {
    this.gte = paramMMActivity;
    this.tCE = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.tLD = 99;
    this.tzW = 100;
    this.pMa = 101;
    this.tqv = 102;
    this.pLU = 103;
    this.tLE = 104;
    this.tLF = 105;
    this.tLG = 106;
    this.tLH = 107;
    this.tLI = 108;
    this.tLJ = 109;
    this.tLK = 110;
    this.tLL = 111;
    this.tLM = 112;
    this.tLP = new CopyOnWriteArraySet();
    this.tLO = new RecyclerView.m();
    this.tLO.aw(1, 10);
    this.tLO.aw(2, 10);
    this.tCD = new com.tencent.mm.plugin.finder.video.k();
    this.tLQ = new f(this);
  }
  
  public abstract bo IE(int paramInt);
  
  public final o.f a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame)
  {
    p.h(paramBaseFinderFeed, "feed");
    p.h(parame, "sheet");
    return (o.f)new g(this, paramBaseFinderFeed);
  }
  
  public void a(b.b paramb)
  {
    p.h(paramb, "callback");
    this.tLN = paramb;
    dcb();
    EventCenter.instance.add((IListener)this.tLQ);
    paramb = this.tCD;
    b.b localb = this.tLN;
    if (localb == null) {
      p.hyc();
    }
    com.tencent.mm.plugin.finder.video.k.a(paramb, (AppCompatActivity)localb.gte, (k.b)new j(this), 4);
  }
  
  @SuppressLint({"ResourceType"})
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    FinderObjectDesc localFinderObjectDesc = null;
    Object localObject2 = null;
    Object localObject1 = null;
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    Log.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.tLD)
    {
      paramInt = l(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
        com.tencent.mm.plugin.finder.feed.logic.c.a((Context)this.gte, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new a(this, paramBaseFinderFeed));
      }
    }
    label335:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            Log.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
            return;
          } while (paramInt == this.tzW);
          if (paramInt == this.tqv)
          {
            new Bundle();
            s.a.a(s.vWt, (AppCompatActivity)this.gte, paramBaseFinderFeed.feedObject, 3, 4);
            return;
          }
          if (paramInt == this.pLU)
          {
            paramMenuItem = s.vWt;
            s.a.a((AppCompatActivity)this.gte, paramBaseFinderFeed, 0, 0, 28);
            return;
          }
          if (paramInt == this.tLE)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.g.vVq;
            com.tencent.mm.plugin.finder.utils.g.a(paramBaseFinderFeed, this.gte);
            return;
          }
          if (paramInt != this.pMa) {
            break label335;
          }
          paramMenuItem = y.vXH;
          if (!y.w(paramBaseFinderFeed)) {
            break;
          }
          paramMenuItem = paramBaseFinderFeed.feedObject.getLiveInfo();
        } while (paramMenuItem == null);
        long l = paramMenuItem.liveId;
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
        com.tencent.mm.plugin.finder.feed.logic.a.b((Context)this.gte, l, paramBaseFinderFeed.feedObject.getUserName());
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
        com.tencent.mm.plugin.finder.feed.logic.a.a((Context)this.gte, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 12);
        return;
        if (paramInt == this.tLF)
        {
          localObject1 = new Intent();
          paramMenuItem = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.toByteArray();; paramMenuItem = null)
          {
            ((Intent)localObject1).putExtra("postRefMediaList", paramMenuItem);
            paramMenuItem = y.vXH;
            ((Intent)localObject1).putExtra("postRefFeedInfo", y.u(paramBaseFinderFeed).toByteArray());
            ((Intent)localObject1).putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
            ((Intent)localObject1).putExtra("key_finder_post_from", 5);
            paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.gte, (Intent)localObject1);
            return;
          }
        }
        if (paramInt == this.tLH)
        {
          ((v)com.tencent.mm.kernel.g.af(v.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (ai)new b(this));
          return;
        }
        if (paramInt == this.tLG)
        {
          ((v)com.tencent.mm.kernel.g.af(v.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (ai)new c(this));
          return;
        }
        if (paramInt != this.tLJ) {
          break;
        }
      } while (!paramBaseFinderFeed.feedObject.isPostFinish());
      paramMenuItem = FinderReporterUIC.wzC;
      paramMenuItem = FinderReporterUIC.a.fH((Context)this.gte);
      if (paramMenuItem != null) {
        paramInt = paramMenuItem.tCE;
      }
      for (;;)
      {
        if (paramInt == 52) {
          if ((this.gte instanceof FinderTopicTimelineUI))
          {
            paramMenuItem = this.gte;
            if (paramMenuItem == null)
            {
              throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
              paramInt = 0;
              continue;
            }
            ((FinderTopicTimelineUI)paramMenuItem).onBackPressed();
          }
        }
      }
      for (;;)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((Context)this.gte, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
        return;
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        e.a.n(paramBaseFinderFeed.feedObject);
        paramMenuItem = w.vXp;
        localFinderObjectDesc = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        paramMenuItem = (MenuItem)localObject1;
        if (localFinderObjectDesc != null) {
          paramMenuItem = localFinderObjectDesc.feedBgmInfo;
        }
        w.a(paramMenuItem, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
      }
      if (paramInt == this.tLK)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.aj.viU;
        paramMenuItem = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
        paramMenuItem = localFinderObjectDesc;
        if (localObject1 != null) {
          paramMenuItem = ((FinderReporterUIC)localObject1).dIx();
        }
        com.tencent.mm.plugin.finder.report.aj.a(paramMenuItem, "fav_in_menu", false, paramBaseFinderFeed.lT());
        u.a((Context)this.gte, this.gte.getResources().getString(2131759810), (u.b)new d(this, paramBaseFinderFeed));
        return;
      }
      if (paramInt == this.tLL)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.aj.viU;
        paramMenuItem = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
        paramMenuItem = localObject2;
        if (localObject1 != null) {
          paramMenuItem = ((FinderReporterUIC)localObject1).dIx();
        }
        com.tencent.mm.plugin.finder.report.aj.a(paramMenuItem, "unfav_in_menu", false, paramBaseFinderFeed.lT());
        u.a((Context)this.gte, this.gte.getResources().getString(2131759809), (u.b)new e(this, paramBaseFinderFeed));
        return;
      }
    } while (paramInt != this.tLM);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("KEY_FROM_SCENE", 1);
    paramMenuItem.putExtra("KEY_USERNAME", z.aUg());
    paramMenuItem.putExtra("KEY_FINDER_SELF_FLAG", true);
    localObject1 = OccupyFinderUI10.udX;
    paramMenuItem.putExtra(OccupyFinderUI10.dez(), true);
    localObject1 = OccupyFinderUI10.udX;
    paramMenuItem.putExtra(OccupyFinderUI10.deA(), false);
    localObject1 = y.vXH;
    y.a(0, j.listOf(paramBaseFinderFeed), null, paramMenuItem);
    paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.ac((Context)this.gte, paramMenuItem);
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, m paramm)
  {
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramm, "menu");
    Object localObject = y.vXH;
    boolean bool;
    if (y.C(paramBaseFinderFeed.feedObject))
    {
      int i = this.tLJ;
      localObject = y.vXH;
      localObject = (CharSequence)y.x(paramBaseFinderFeed);
      if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed()))
      {
        bool = true;
        paramm.a(i, (CharSequence)localObject, 2131690227, bool);
      }
    }
    else
    {
      localObject = y.vXH;
      if (y.h(paramBaseFinderFeed)) {
        break label128;
      }
      paramm.b(this.pMa, (CharSequence)this.gte.getString(2131763159), 2131690898);
    }
    label128:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (dca());
      localObject = y.vXH;
    } while ((!y.isAnyEnableFullScreenEnjoy()) || ((paramBaseFinderFeed.cxn() != 4) && (paramBaseFinderFeed.cxn() != 2)));
    paramm.b(this.tLM, (CharSequence)this.gte.getString(2131759752), 2131690257);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx();
    Object localObject2 = com.tencent.mm.plugin.finder.model.aj.uOw;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    y localy = y.vXH;
    com.tencent.mm.plugin.finder.model.aj.a((bbn)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, y.i(paramBaseFinderFeed.contact));
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    p.h(paramFinderItem, "feed");
    s.a.a(s.vWt, (AppCompatActivity)this.gte, paramFinderItem, 0, 12);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    p.h(paramFinderItem, "feed");
    p.h(paramFinderCommentInfo, "comment");
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, h paramh)
  {
    p.h(paramFinderItem, "feed");
    paramh = r.uNW;
    r.a((AppCompatActivity)this.gte, paramFinderItem, paramBoolean);
  }
  
  public void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.h(paramc, "reason");
  }
  
  public final void b(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    p.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    bbn localbbn = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx();
    localObject = ag.uOs;
    localObject = paramBaseFinderFeed.contact;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).getUsername();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      bb.a locala;
      int i;
      if (paramBoolean)
      {
        locala = bb.tve;
        i = bb.cYi();
        localObject = ag.a(localbbn, (String)localObject, i);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localObject);
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        paramBaseFinderFeed = paramBaseFinderFeed.contact;
        if (paramBaseFinderFeed != null)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.getUsername();
          if (paramBaseFinderFeed != null) {
            break label173;
          }
        }
        paramBaseFinderFeed = "";
      }
      label173:
      for (;;)
      {
        if (paramBoolean) {
          localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        }
        for (i = com.tencent.mm.plugin.finder.api.g.cXO();; i = com.tencent.mm.plugin.finder.api.g.cXP())
        {
          c.a.du(paramBaseFinderFeed, i);
          return;
          locala = bb.tve;
          i = bb.cYj();
          break;
          localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        }
      }
    }
  }
  
  public abstract void boE();
  
  public boolean dbZ()
  {
    return false;
  }
  
  public boolean dca()
  {
    y localy = y.vXH;
    return y.gr(this.dLS, this.tCE);
  }
  
  public abstract void dcb();
  
  public abstract DataBuffer<bo> dcc();
  
  public void dcd() {}
  
  public abstract com.tencent.mm.view.recyclerview.f dce();
  
  public final RecyclerView.m dcf()
  {
    return this.tLO;
  }
  
  public final com.tencent.mm.plugin.finder.view.e dcg()
  {
    Object localObject = this.tLN;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.e locale = ((b.b)localObject).dcm();
      localObject = locale;
      if (locale != null) {}
    }
    else
    {
      localObject = new com.tencent.mm.plugin.finder.view.e();
    }
    return localObject;
  }
  
  public final MMActivity getActivity()
  {
    return this.gte;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final com.tencent.mm.plugin.finder.video.k getVideoCore()
  {
    return this.tCD;
  }
  
  public o.f i(final BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    return (o.f)new h(this, paramBaseFinderFeed);
  }
  
  public final o.g j(final BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    return (o.g)new i(this, paramBaseFinderFeed);
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    s.a locala = s.vWt;
    s.a.a((AppCompatActivity)this.gte, paramBaseFinderFeed, 4, 0, 20);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.tLP.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcm();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).dGs())) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).dGr();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.tLN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).tLW;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).QFs))
          {
            ((TouchMediaPreviewLayout)localObject).gZk();
            return;
          }
        }
        localObject = this.tLN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).dcn();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).dGs()))
          {
            ((FinderLikeDrawer)localObject).dGr();
            return;
          }
        }
        localObject = this.tLN;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).dcj();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).dGs()))
          {
            ((FinderLikeDrawer)localObject).dGr();
            return;
          }
        }
        localObject = this.tLN;
      } while (localObject == null);
      localObject = ((b.b)localObject).gte;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
    Object localObject = ((Iterable)this.tLP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.tLP.clear();
    EventCenter.instance.removeListener((IListener)this.tLQ);
    this.tLN = null;
    localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcm();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onDetach();
      }
    }
  }
  
  public final void onUIPause()
  {
    b.b localb = this.tLN;
    if (localb != null) {
      localb.dcm();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcm();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.e)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    a(b.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements ai<ayy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements ai<ayy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class d
    implements u.b
  {
    d(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(243674);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(2131309260);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(2131309259);
        if (paramView != null)
        {
          paramView.setImageResource(2131690537);
          localObject = paramView.getContext();
          p.g(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(2131101426));
        }
      }
      this.tLR.a(paramBaseFinderFeed.feedObject, true, null);
      AppMethodBeat.o(243674);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class e
    implements u.b
  {
    e(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(243675);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(2131309260);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(2131309259);
        if (paramView != null)
        {
          paramView.setImageResource(2131690537);
          localObject = paramView.getContext();
          p.g(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(2131101426));
        }
      }
      this.tLR.a(paramBaseFinderFeed.feedObject, false, null);
      AppMethodBeat.o(243675);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.plugin.finder.view.f
  {
    private String tag;
    
    f()
    {
      AppMethodBeat.i(165612);
      this.tag = localObject.getTAG();
      AppMethodBeat.o(165612);
    }
    
    public final FinderItem EB(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.tLR.tLN;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).tLS.getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165610);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).lR();
            localObject = this.tLR.tLN;
            if (localObject == null) {
              p.hyc();
            }
            int j = ((b.b)localObject).sHN;
            localObject = this.tLR.IE(i - j);
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
    
    public final void a(long paramLong, azt paramazt)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.tLR.tLN;
      if (localObject1 != null)
      {
        localObject1 = ((b.b)localObject1).tLS.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramazt = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw paramazt;
          }
          localObject2 = com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).lR();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramazt));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements o.f
  {
    g(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(165613);
      b.a locala = this.tLR;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.g(paramm, "menu");
      p.h(localBaseFinderFeed, "feed");
      p.h(paramm, "menu");
      Object localObject1 = locala.gte.getString(2131755985);
      p.g(localObject1, "context.getString(R.string.app_share_to_weixin)");
      Object localObject2 = locala.gte.getString(2131760572);
      p.g(localObject2, "context.getString(R.string.finder_share_timeline)");
      p.g(locala.gte.getString(2131759168), "context.getString(R.string.favorite)");
      boolean bool1 = false;
      if ((localBaseFinderFeed.feedObject.isOnlySelfSee()) || (localBaseFinderFeed.feedObject.isNotShare()))
      {
        localObject1 = y.vXH;
        localObject1 = y.dP("FinderSafeSelfSeeForward", 2131760540);
        localObject2 = y.vXH;
        localObject2 = y.dP("FinderSafeSelfSeeShare", 2131760541);
        y localy = y.vXH;
        y.dP("FinderSafeSelfSeeCollect", 2131760539);
        bool1 = true;
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramm.a(locala.tqv, (CharSequence)localObject1, 2131690251, locala.gte.getResources().getColor(2131099710), bool1);
        paramm.a(locala.pLU, (CharSequence)localObject2, 2131689830, 0, bool2);
        int i;
        if (locala.dca())
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
          if (com.tencent.mm.plugin.finder.upload.action.c.dBq().k(localBaseFinderFeed.feedObject.getFeedObject())) {
            break label350;
          }
          i = 1;
          if (i == 0) {
            break label355;
          }
          paramm.a(locala.tLK, (CharSequence)locala.gte.getString(2131759168), 2131691821, locala.gte.getResources().getColor(2131100919));
        }
        for (;;)
        {
          paramm = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.I(localBaseFinderFeed.lT(), locala.tCE);
          paramm = FinderReporterUIC.wzC;
          paramm = FinderReporterUIC.a.fH((Context)locala.gte);
          if (paramm == null) {
            break label396;
          }
          paramm = FinderReporterUIC.b(paramm);
          if (paramm == null) {
            break label396;
          }
          paramm.cZR().Ew(localBaseFinderFeed.lT());
          AppMethodBeat.o(165613);
          return;
          label350:
          i = 0;
          break;
          label355:
          paramm.a(locala.tLL, (CharSequence)locala.gte.getString(2131759570), 2131691822, locala.gte.getResources().getColor(2131100919));
        }
        label396:
        AppMethodBeat.o(165613);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class h
    implements o.f
  {
    h(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(165614);
      b.a locala = this.tLR;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.g(paramm, "menu");
      locala.a(localBaseFinderFeed, paramm);
      AppMethodBeat.o(165614);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class i
    implements o.g
  {
    i(b.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      b.a locala = this.tLR;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      p.g(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(165615);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class j
    implements k.b
  {
    public final RecyclerView dch()
    {
      AppMethodBeat.i(165616);
      Object localObject = this.tLR.tLN;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((b.b)localObject).tLS.getRecyclerView();
      AppMethodBeat.o(165616);
      return localObject;
    }
    
    public final DataBuffer<bo> dci()
    {
      AppMethodBeat.i(243676);
      DataBuffer localDataBuffer = this.tLR.dcc();
      AppMethodBeat.o(243676);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */