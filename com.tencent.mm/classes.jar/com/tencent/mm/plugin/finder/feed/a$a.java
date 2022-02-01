package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.o;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "()I", "MENU_ID_DELETE_FEED", "getMENU_ID_DELETE_FEED", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCommentScene", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "createSecondMenu", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getActivity", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataAt", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getVideoCoreInitializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initVideoAbout", "initViewCallback", "isFinderSelfScene", "", "keep", "p0", "loadMoreData", "onAttach", "callback", "onBackPressed", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onUIPause", "onUIResume", "requestRefresh", "shareFeed", "plugin-finder_release"})
public abstract class a$a
  implements c, f.a, com.tencent.mm.plugin.finder.presenter.base.a<a.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final int KMM;
  private final String TAG;
  final MMActivity imP;
  final int nmj;
  private final int nmp;
  private final int qqA;
  public final int qqE;
  public final com.tencent.mm.plugin.finder.video.c qrq;
  private final int qtT;
  private final int qtU;
  private final int qtV;
  private final int qtW;
  final int qtX;
  final int qtY;
  public a.b qtZ;
  private RecyclerView.n qub;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  private final d que;
  
  private a$a(MMActivity paramMMActivity, int paramInt)
  {
    this.imP = paramMMActivity;
    this.qqE = paramInt;
    this.TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
    this.qtT = 99;
    this.qqA = 100;
    this.nmp = 101;
    this.qtU = 102;
    this.nmj = 103;
    this.qtV = 104;
    this.qtW = 105;
    this.qtX = 106;
    this.qtY = 107;
    this.KMM = 108;
    this.quc = new CopyOnWriteArraySet();
    this.qub = new RecyclerView.n();
    this.qub.aB(1, 10);
    this.qub.aB(2, 10);
    this.qrq = new com.tencent.mm.plugin.finder.video.c();
    this.que = new d(this);
  }
  
  public abstract BaseFinderFeed CB(int paramInt);
  
  public final n.c a(final BaseFinderFeed paramBaseFinderFeed, e parame)
  {
    k.h(paramBaseFinderFeed, "feed");
    k.h(parame, "sheet");
    return (n.c)new e(this, paramBaseFinderFeed);
  }
  
  public void a(a.b paramb)
  {
    k.h(paramb, "callback");
    this.qtZ = paramb;
    clJ();
    com.tencent.mm.sdk.b.a.ESL.b((com.tencent.mm.sdk.b.c)this.que);
    paramb = this.qrq;
    a.b localb = this.qtZ;
    if (localb == null) {
      k.fvU();
    }
    com.tencent.mm.plugin.finder.video.c.a(paramb, localb.imP, (com.tencent.mm.plugin.finder.video.c.b)new h(this), 4);
  }
  
  public void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    k.h(paramBaseFinderFeed, "feed");
    k.h(paramMenuItem, "menuItem");
    ad.i(getTAG(), "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.qtT)
    {
      paramInt = e(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.qya;
        com.tencent.mm.plugin.finder.feed.logic.b.a((Context)this.imP, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new a(this, paramBaseFinderFeed));
      }
    }
    do
    {
      do
      {
        return;
        ad.i(getTAG(), "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
        return;
      } while (paramInt == this.qqA);
      if (paramInt == this.qtU)
      {
        new Bundle();
        g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, this.imP, paramBaseFinderFeed.feedObject);
        return;
      }
      if (paramInt == this.nmj)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.g.qSw;
        g.a.a(this.imP, paramBaseFinderFeed);
        return;
      }
      if (paramInt == this.qtV)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.b.qSc;
        com.tencent.mm.plugin.finder.utils.b.a(paramBaseFinderFeed, this.imP);
        return;
      }
      if (paramInt == this.nmp)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.qxZ;
        com.tencent.mm.plugin.finder.feed.logic.a.i((Context)this.imP, paramBaseFinderFeed.feedObject.field_id);
        return;
      }
      if (paramInt == this.qtW)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("postRefMediaList", paramBaseFinderFeed.feedObject.getFeedObject().objectDesc.toByteArray());
        com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
        paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.i.l(paramBaseFinderFeed).toByteArray());
        paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
        paramMenuItem.putExtra("key_finder_post_from", 5);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this.imP, paramMenuItem);
        return;
      }
      if (paramInt == this.qtY)
      {
        ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.i)new c(this));
        return;
      }
    } while (paramInt != this.qtX);
    ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.i)new b(this));
  }
  
  public void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    k.h(paramBaseFinderFeed, "feed");
    k.h(paraml, "menu");
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
    if (!com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed)) {
      paraml.a(this.nmp, (CharSequence)this.imP.getString(2131761332), 2131690646);
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs();
    p localp = p.qDG;
    p.a((dzp)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    k.h(paramFinderItem, "feed");
    g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, this.imP, paramFinderItem);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    k.h(paramFinderItem, "feed");
    k.h(paramFinderCommentInfo, "comment");
  }
  
  public abstract void aJq();
  
  public final n.c c(final BaseFinderFeed paramBaseFinderFeed)
  {
    k.h(paramBaseFinderFeed, "feed");
    return (n.c)new f(this, paramBaseFinderFeed);
  }
  
  public boolean clH()
  {
    return false;
  }
  
  public abstract void clJ();
  
  public abstract com.tencent.mm.view.recyclerview.c clL();
  
  public final RecyclerView.n clM()
  {
    return this.qub;
  }
  
  public final n.d d(final BaseFinderFeed paramBaseFinderFeed)
  {
    k.h(paramBaseFinderFeed, "feed");
    return (n.d)new g(this, paramBaseFinderFeed);
  }
  
  public final void d(FinderItem paramFinderItem, boolean paramBoolean)
  {
    k.h(paramFinderItem, "feed");
    y localy = y.KTo;
    y.a(this.imP, paramFinderItem, paramBoolean);
  }
  
  public abstract DataBuffer<BaseFinderFeed> fSV();
  
  public final com.tencent.mm.plugin.finder.view.f fSW()
  {
    Object localObject = this.qtZ;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.view.f localf = ((a.b)localObject).fSY();
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
    return this.imP;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final com.tencent.mm.plugin.finder.video.c getVideoCore()
  {
    return this.qrq;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.quc.add(parama);
  }
  
  public final void onBackPressed()
  {
    Object localObject = this.qtZ;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).fSY();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.f)localObject).fiQ())) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).csJ();
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.qtZ;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).qum;
          if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).HCz))
          {
            ((TouchMediaPreviewLayout)localObject).ffe();
            return;
          }
        }
        localObject = this.qtZ;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).fSZ();
          if ((localObject != null) && (((FinderLikeDrawer)localObject).fiQ()))
          {
            ((FinderLikeDrawer)localObject).csJ();
            return;
          }
        }
        localObject = this.qtZ;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).KMP;
          if (localObject == null) {
            k.aPZ("friendLikeDrawer");
          }
          if ((localObject != null) && (((FinderLikeDrawer)localObject).fiQ()))
          {
            ((FinderLikeDrawer)localObject).csJ();
            return;
          }
        }
        localObject = this.qtZ;
      } while (localObject == null);
      localObject = ((a.b)localObject).imP;
    } while (localObject == null);
    ((MMActivity)localObject).finish();
  }
  
  public void onDetach()
  {
    com.tencent.mm.plugin.finder.storage.data.c.qKo.clearCache();
    Iterator localIterator = ((Iterable)this.quc).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.quc.clear();
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.que);
    this.qtZ = null;
  }
  
  public final void onUIPause()
  {
    a.b localb = this.qtZ;
    if (localb != null) {
      localb.fSY();
    }
  }
  
  public final void onUIResume()
  {
    Object localObject = this.qtZ;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).fSY();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.view.f)localObject).onUIResume();
      }
    }
  }
  
  public abstract void requestRefresh();
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    a(a.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$dealMenuClick$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.view.d
  {
    private String tag;
    
    d()
    {
      AppMethodBeat.i(165612);
      this.tag = localObject.getTAG();
      AppMethodBeat.o(165612);
    }
    
    public final void a(long paramLong, ake paramake)
    {
      AppMethodBeat.i(165611);
      Object localObject1 = this.quf.qtZ;
      if (localObject1 != null)
      {
        localObject1 = ((a.b)localObject1).quj.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramake = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165611);
            throw paramake;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).ln();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramake));
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
    
    public final FinderItem pZ(long paramLong)
    {
      AppMethodBeat.i(165610);
      Object localObject = this.quf.qtZ;
      if (localObject != null)
      {
        localObject = ((a.b)localObject).quj.getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165610);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).ln();
            localObject = this.quf.qtZ;
            if (localObject == null) {
              k.fvU();
            }
            int j = ((a.b)localObject).qui;
            localObject = this.quf.CB(i - j);
            if (localObject != null)
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165610);
              return localObject;
            }
            AppMethodBeat.o(165610);
            return null;
          }
        }
      }
      AppMethodBeat.o(165610);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165613);
      a.a locala = this.quf;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      k.g(paraml, "menu");
      k.h(localBaseFinderFeed, "feed");
      k.h(paraml, "menu");
      locala.imP.getString(2131755893);
      Object localObject = locala.imP.getString(2131755892);
      locala.imP.getString(2131758845);
      if ((localBaseFinderFeed.feedObject.isOnlySelfSee()) || (localBaseFinderFeed.feedObject.isNotShare()))
      {
        localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
        com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeForward", 2131759344);
        localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject = com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeShare", 2131759345);
        com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
        com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeCollect", 2131759343);
      }
      for (boolean bool = true;; bool = false)
      {
        paraml.a(locala.nmj, (CharSequence)localObject, 2131689817, 0, bool);
        paraml = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.E(localBaseFinderFeed.bMs(), locala.qqE);
        paraml = FinderReporterUIC.Ljl;
        paraml = FinderReporterUIC.a.lB((Context)locala.imP);
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.fSl().BF(localBaseFinderFeed.bMs());
            AppMethodBeat.o(165613);
            return;
          }
        }
        AppMethodBeat.o(165613);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.c
  {
    f(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165614);
      a.a locala = this.quf;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      k.g(paraml, "menu");
      locala.a(localBaseFinderFeed, paraml);
      AppMethodBeat.o(165614);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(a.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165615);
      a.a locala = this.quf;
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      k.g(paramMenuItem, "menuItem");
      locala.a(localBaseFinderFeed, paramMenuItem, paramInt);
      AppMethodBeat.o(165615);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$getVideoCoreInitializer$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.finder.video.c.b
  {
    public final RecyclerView clN()
    {
      AppMethodBeat.i(165616);
      Object localObject = this.quf.qtZ;
      if (localObject == null) {
        k.fvU();
      }
      localObject = ((a.b)localObject).quj.getRecyclerView();
      AppMethodBeat.o(165616);
      return localObject;
    }
    
    public final DataBuffer<BaseFinderFeed> fSX()
    {
      AppMethodBeat.i(197620);
      DataBuffer localDataBuffer = this.quf.fSV();
      AppMethodBeat.o(197620);
      return localDataBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.a
 * JD-Core Version:    0.7.0.1
 */