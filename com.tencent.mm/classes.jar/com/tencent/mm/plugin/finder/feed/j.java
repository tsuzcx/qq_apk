package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.convert.ac;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.a.b;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
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
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.b;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "MENU_ID_CLOSE_COMMENT", "", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "canTimelineRefresh", "", "commentChangeEventListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1;", "commentFailedNotifyDataList", "", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1;", "emptyData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "emptyFooterData", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1;", "hasPrefetch", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "isAutoLoadingMore", "isCurrentEmptyData", "isFooterEmpty", "isFragment", "isPreLoadingMore", "lastPositionToPreLoad", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "needToRefreshForPrefetch", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "tabType", "tipDialog", "Landroid/app/Dialog;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "whatsNewView", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "getWhatsNewView", "()Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "whatsNewView$delegate", "Lkotlin/Lazy;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "isWithRefresh", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "checkNoMoreFooter", "findUnreadFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feed", "dataList", "", "getActivity", "getAdapter", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getFinderContextId", "", "getHeaderInfo", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getTabType", "getVideoCore", "hideSearchBar", "delay", "", "isSmooth", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isFinderSelfScene", "isSelf", "keep", "p0", "loadMoreData", "notifyChanged", "rv", "Landroid/support/v7/widget/RecyclerView;", "itemId", "onAttach", "onBackPressed", "onDetach", "onEventHappen", "ev", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onLoadMoreEnd", "reason", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "refreshMsgNotify", "requestInsert", "centerFeed", "maxUnreadCount", "hasReadFeeds", "isPrefetch", "requestRefresh", "shareFeed", "Companion", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.plugin.finder.event.base.f
  implements i.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public static final a qwW;
  private final int IoU;
  private final n KOY;
  private final boolean KOZ;
  private final FinderHomeTabStateVM KOa;
  private final FinderHomeTabFragment KOg;
  private boolean KPa;
  private boolean KPb;
  private d.b KPc;
  private d.b KPd;
  private boolean KPe;
  private boolean KPf;
  private final p KPg;
  private final int ibt;
  private final MMActivity imP;
  private final int nmj;
  private final int nmp;
  private final int qqA;
  private final com.tencent.mm.plugin.finder.feed.model.h qrj;
  private final com.tencent.mm.plugin.finder.video.c qrq;
  private i.b qrz;
  private final int qtT;
  private final int qtU;
  private final int qtV;
  private final int qtW;
  private final int qtX;
  private final int qtY;
  private RecyclerView.n qub;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  private com.tencent.mm.view.d qvO;
  private final com.tencent.mm.plugin.finder.feed.model.e qvy;
  private boolean qwK;
  private boolean qwL;
  private boolean qwM;
  private final d.f qwN;
  private final d qwO;
  private final com.tencent.mm.plugin.finder.model.d qwP;
  private final com.tencent.mm.plugin.finder.model.e qwQ;
  private final List<com.tencent.mm.plugin.finder.model.b> qwS;
  private final int qwT;
  private final e qwU;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165897);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(j.class), "whatsNewView", "getWhatsNewView()Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;")) };
    qwW = new a((byte)0);
    AppMethodBeat.o(165897);
  }
  
  public j(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(198080);
    this.imP = paramMMActivity;
    this.KOg = paramFinderHomeTabFragment;
    this.quc = new CopyOnWriteArraySet();
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KOa = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = this.KOg;
    int i;
    if (paramMMActivity != null)
    {
      i = paramMMActivity.IoU;
      this.IoU = i;
      this.qwK = this.KOa.ahN(this.IoU);
      paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.b.KQP;
      paramMMActivity = b.a.ahj(this.IoU);
      if (!this.qwK) {
        break label481;
      }
      i = 0;
      label128:
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.LCX;
      this.qrj = new com.tencent.mm.plugin.finder.feed.model.h(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).ahV(this.IoU));
      this.qtT = 99;
      this.qqA = 100;
      this.nmp = 101;
      this.qtU = 102;
      this.nmj = 103;
      this.qtV = 104;
      this.qtW = 105;
      this.qtX = 106;
      this.qtY = 107;
      this.ibt = 108;
      paramMMActivity = com.tencent.mm.ui.component.a.LCX;
      this.qub = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s(this.imP).get(FinderRecyclerViewPool.class)).qub;
      this.qrq = new com.tencent.mm.plugin.finder.video.c(this.IoU);
      this.qvy = new com.tencent.mm.plugin.finder.feed.model.e(this.imP);
      this.KOY = new n(this);
      this.qvO = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
      {
        public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165863);
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = j.h(this.qwX);
              if (locald != null) {}
              for (int i = locald.Ibl.size();; i = 0)
              {
                ((RefreshLoadMoreLayout)localObject).at(i + paramAnonymousInt1, paramAnonymousInt2);
                AppMethodBeat.o(165863);
                return;
              }
            }
          }
          AppMethodBeat.o(165863);
        }
        
        public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165864);
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = j.h(this.qwX);
              if (locald != null) {}
              for (int i = locald.Ibl.size();; i = 0)
              {
                ((RefreshLoadMoreLayout)localObject).au(i + paramAnonymousInt1, paramAnonymousInt2);
                AppMethodBeat.o(165864);
                return;
              }
            }
          }
          AppMethodBeat.o(165864);
        }
        
        public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(165860);
          d.g.b.k.h(paramAnonymousc, "reason");
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              ((RefreshLoadMoreLayout)localObject).c(paramAnonymousc);
              AppMethodBeat.o(165860);
              return;
            }
          }
          AppMethodBeat.o(165860);
        }
        
        public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(165859);
          d.g.b.k.h(paramAnonymousc, "reason");
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              ((RefreshLoadMoreLayout)localObject).d(paramAnonymousc);
              AppMethodBeat.o(165859);
              return;
            }
          }
          AppMethodBeat.o(165859);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(165862);
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = j.h(this.qwX);
              if (locald != null) {}
              for (int i = locald.Ibl.size();; i = 0)
              {
                ((RefreshLoadMoreLayout)localObject).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
                AppMethodBeat.o(165862);
                return;
              }
            }
          }
          AppMethodBeat.o(165862);
        }
        
        public final void onChanged()
        {
          AppMethodBeat.i(165861);
          Object localObject = j.g(this.qwX);
          if (localObject != null)
          {
            localObject = ((i.b)localObject).cmp();
            if (localObject != null)
            {
              ((RefreshLoadMoreLayout)localObject).onChanged();
              AppMethodBeat.o(165861);
              return;
            }
          }
          AppMethodBeat.o(165861);
        }
      });
      if (this.KOg == null) {
        break label486;
      }
    }
    for (;;)
    {
      this.KOZ = bool;
      this.qwN = d.g.E((d.g.a.a)new v(this));
      this.qwO = new d(this);
      this.qwP = new com.tencent.mm.plugin.finder.model.d();
      this.qwQ = new com.tencent.mm.plugin.finder.model.e();
      this.KPc = ((d.b)new com.tencent.mm.plugin.finder.model.c());
      this.KPd = ((d.b)new com.tencent.mm.plugin.finder.model.w());
      this.qwS = ((List)new ArrayList());
      paramMMActivity = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramMMActivity, "MMKernel.storage()");
      this.qwT = paramMMActivity.afk().getInt(ae.a.FwF, 0);
      this.qwU = new e(this);
      this.KPg = new p(this);
      AppMethodBeat.o(198080);
      return;
      i = 0;
      break;
      label481:
      i = 1;
      break label128;
      label486:
      bool = false;
    }
  }
  
  private final FinderWhatsNewView cmq()
  {
    AppMethodBeat.i(165899);
    FinderWhatsNewView localFinderWhatsNewView = (FinderWhatsNewView)this.qwN.getValue();
    AppMethodBeat.o(165899);
    return localFinderWhatsNewView;
  }
  
  private final com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.e> cmr()
  {
    AppMethodBeat.i(165914);
    Object localObject1 = this.qrz;
    if (localObject1 != null)
    {
      localObject1 = ((i.b)localObject1).getRecyclerView();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.d)) {
        localObject2 = null;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.d)localObject2;
      AppMethodBeat.o(165914);
      return localObject1;
    }
  }
  
  private final void e(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165903);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(165903);
  }
  
  private final void j(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    final boolean bool = false;
    AppMethodBeat.i(198071);
    Object localObject1 = this.qrz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((i.b)localObject1).getRecyclerView();
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        if (localObject1 == null) {
          break label107;
        }
      }
    }
    label107:
    for (int i = ((com.tencent.mm.view.recyclerview.d)localObject1).fjd();; i = 0)
    {
      if (i <= 0) {
        bool = true;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((com.tencent.mm.plugin.finder.storage.b.fUC()) || (!bool)) {
        break label112;
      }
      AppMethodBeat.o(198071);
      return;
      localObject1 = null;
      break;
    }
    label112:
    if (((this.IoU == 3) || (this.IoU == 1)) && (paramc != null))
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((com.tencent.mm.plugin.finder.storage.b.fUC()) || ((!bool) && (!paramc.HXq)))
      {
        this.KPb = true;
        com.tencent.mm.ad.c.g((d.g.a.a)new m(this, bool, paramc, (WxRecyclerAdapter)localObject1));
      }
    }
    AppMethodBeat.o(198071);
  }
  
  private final void s(final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(165902);
    Object localObject = this.qrz;
    if (localObject != null)
    {
      localObject = ((i.b)localObject).getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).postDelayed((Runnable)new i(this, paramBoolean, paramLong), paramLong);
        AppMethodBeat.o(165902);
        return;
      }
    }
    AppMethodBeat.o(165902);
  }
  
  public final n.c a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(165915);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parame, "sheet");
    paramBaseFinderFeed = (n.c)new f(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(165915);
    return paramBaseFinderFeed;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(165919);
    d.g.b.k.h(paramc, "ev");
    if ((this.qwT > 0) && (!this.KPe) && ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i)))
    {
      int j = this.qrj.KQn.KKn.length;
      Object localObject = cmr();
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.view.recyclerview.d)localObject).getItemCount() + j - ((com.tencent.mm.view.recyclerview.d)localObject).Ibl.size();; i = 0)
      {
        int k = i - this.qwT;
        if ((((com.tencent.mm.plugin.finder.event.base.i)paramc).qsj < k) || (i < 4) || (j != 0)) {
          break label318;
        }
        ad.i("Finder.TimelinePresenter", "[onAutoToLoadMore] lastPositionToPreLoad=" + this.qwT + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsj + ", preLoadPos=" + k + ", bufferSize=" + j + ", count=" + i);
        if (this.IoU != 4) {
          break;
        }
        if (this.KPf) {
          break label318;
        }
        paramc = this.qrz;
        if (paramc != null)
        {
          paramc = paramc.cmp();
          if (paramc != null) {
            paramc.zk(true);
          }
        }
        this.KPf = true;
        AppMethodBeat.o(165919);
        return;
      }
      if (!this.KPe)
      {
        paramc = this.qrj;
        localObject = (com.tencent.mm.plugin.finder.feed.model.internal.e)new j.y(this);
        d.g.b.k.h(localObject, "callback");
        com.tencent.mm.plugin.finder.feed.model.t localt = new com.tencent.mm.plugin.finder.feed.model.t(2);
        ad.i(paramc.getTAG(), "preloadMore ".concat(String.valueOf(localt)));
        localt.KQw = true;
        paramc.fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)localt, (com.tencent.mm.plugin.finder.feed.model.internal.e)localObject);
        this.KPe = true;
      }
    }
    label318:
    AppMethodBeat.o(165919);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed1, BaseFinderFeed paramBaseFinderFeed2, int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(198072);
    d.g.b.k.h(paramBaseFinderFeed1, "feed");
    d.g.b.k.h(paramBaseFinderFeed2, "centerFeed");
    d.g.b.k.h(paramList, "hasReadFeeds");
    paramList = new com.tencent.mm.plugin.finder.feed.model.ab();
    paramList.qHv = paramBaseFinderFeed1;
    paramList.qsl = paramBaseFinderFeed2;
    paramList.KQv = paramBoolean;
    paramList.KQu = paramInt;
    this.qrj.requestInsert((com.tencent.mm.plugin.finder.feed.model.internal.j)paramList);
    AppMethodBeat.o(198072);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(198076);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs();
    p localp = p.qDG;
    p.a((dzp)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
    AppMethodBeat.o(198076);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(198075);
    d.g.b.k.h(paramFinderItem, "feed");
    g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, this.imP, paramFinderItem);
    AppMethodBeat.o(198075);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165922);
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165922);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165901);
    d.g.b.k.h(paramc, "reason");
    e(paramc);
    Object localObject = this.qrz;
    if (localObject != null)
    {
      localObject = ((i.b)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).post((Runnable)new q(this));
      }
    }
    j(paramc);
    this.KPf = false;
    AppMethodBeat.o(165901);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(165920);
    d.g.b.k.h(paramd, "dispatcher");
    d.g.b.k.h(paramc, "event");
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i))
    {
      if (((com.tencent.mm.plugin.finder.event.base.i)paramc).type == 0)
      {
        AppMethodBeat.o(165920);
        return true;
      }
      AppMethodBeat.o(165920);
      return false;
    }
    AppMethodBeat.o(165920);
    return false;
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(165906);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new j(this));
    AppMethodBeat.o(165906);
  }
  
  public final void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(198078);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.qwK) || (paramBoolean1))
    {
      localObject1 = this.qrz;
      if (localObject1 == null) {
        break label231;
      }
      localObject1 = ((i.b)localObject1).getRecyclerView();
      if (localObject1 == null) {
        break label231;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      localObject2 = localObject1;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        localObject2 = null;
      }
      localObject1 = (LinearLayoutManager)localObject2;
      if (localObject1 == null) {
        break label237;
      }
      i = ((LinearLayoutManager)localObject1).jO();
      label82:
      if (i > 12) {
        break label242;
      }
      localObject1 = this.qrz;
      if (localObject1 != null)
      {
        localObject1 = ((i.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
      }
      if (paramBoolean2)
      {
        localObject1 = this.qrz;
        if (localObject1 != null) {
          ((i.b)localObject1).BH(40L);
        }
      }
    }
    for (;;)
    {
      this.qwK = false;
      AppMethodBeat.o(198078);
      return;
      label231:
      localObject1 = null;
      break;
      label237:
      i = 0;
      break label82;
      label242:
      localObject1 = this.qrz;
      if (localObject1 != null)
      {
        localObject1 = ((i.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "scrollToPosition", "(I)V");
        }
      }
      if (paramBoolean2)
      {
        localObject1 = this.qrz;
        if (localObject1 != null) {
          ((i.b)localObject1).BH(300L);
        }
      }
    }
  }
  
  public final void b(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165900);
    d.g.b.k.h(paramc, "reason");
    Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    com.tencent.mm.plugin.finder.report.b.fQ(cmn(), "EndCgi");
    localObject = this.qrq.qTH;
    if (localObject != null) {
      FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject, "onUserVisibleFocused", false);
    }
    ad.i("Finder.TimelinePresenter", "[onRefreshEnd] reason=".concat(String.valueOf(paramc)));
    if (cmq() != null)
    {
      localObject = cmq();
      if ((localObject != null) && (((FinderWhatsNewView)localObject).isAttachedToWindow() == true))
      {
        localObject = cmq();
        if (localObject != null)
        {
          ((FinderWhatsNewView)localObject).setDetachFinish((d.g.a.a)new r(this, paramc));
          AppMethodBeat.o(165900);
          return;
        }
        AppMethodBeat.o(165900);
        return;
      }
    }
    if (paramc.HXr <= 0)
    {
      localObject = this.qrz;
      if (localObject != null)
      {
        localObject = ((i.b)localObject).cmp();
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
          ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.fUv(), (d.g.a.a)new s(this));
        }
      }
      e(paramc);
      localObject = this.qrz;
      if (localObject != null)
      {
        localObject = ((i.b)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).post((Runnable)new t(this));
        }
      }
      this.qwL = false;
      this.qwM = false;
      j(paramc);
      paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
      paramc = ((PluginFinder)paramc).getRedDotManager();
      switch (this.IoU)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(165900);
      return;
      s(0L, false);
      break;
      paramc.ahg(7);
      AppMethodBeat.o(165900);
      return;
      paramc.ahg(8);
      AppMethodBeat.o(165900);
      return;
      paramc.ahg(1004);
    }
  }
  
  public final n.c c(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165916);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.c)new g(this, paramBaseFinderFeed);
    AppMethodBeat.o(165916);
    return paramBaseFinderFeed;
  }
  
  public final boolean clH()
  {
    return false;
  }
  
  public final com.tencent.mm.view.recyclerview.c clL()
  {
    AppMethodBeat.i(165910);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(165910);
    return localc;
  }
  
  public final RecyclerView.n clM()
  {
    return this.qub;
  }
  
  public final List<d.b> cmm()
  {
    AppMethodBeat.i(165909);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.FwJ, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.FwK, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LBe, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LBf, 0);
    this.qwP.count = (i + j + k + m);
    localObject2 = this.qwP;
    Object localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).afk().get(ae.a.FwL, "");
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165909);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.d)localObject2).setAvatar((String)localObject3);
    ad.i("Finder.TimelinePresenter", "commentCnt " + i + ", likeCnt " + j + " objectLikeLikeCnt " + k + " objectRecommendLikeCnt " + m + " avatar: " + this.qwP.qDs + " tabType " + this.IoU);
    ((LinkedList)localObject1).add(this.qwQ);
    ((LinkedList)localObject1).add(this.qwP);
    localObject3 = (Iterable)((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().coy();
    localObject2 = (Collection)this.qwS;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      a.b localb = (a.b)((Iterator)localObject3).next();
      ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.b(localb.feedId, localb.objectNonceId, (byte)0));
    }
    ((LinkedList)localObject1).addAll((Collection)this.qwS);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(165909);
    return localObject1;
  }
  
  public final String cmn()
  {
    AppMethodBeat.i(198070);
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    String str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).qwV;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(198070);
    return localObject;
  }
  
  public final n.d d(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165917);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.d)new h(this, paramBaseFinderFeed);
    AppMethodBeat.o(165917);
    return paramBaseFinderFeed;
  }
  
  public final void d(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(198074);
    d.g.b.k.h(paramFinderItem, "feed");
    com.tencent.mm.plugin.finder.model.y localy = com.tencent.mm.plugin.finder.model.y.KTo;
    com.tencent.mm.plugin.finder.model.y.a(this.imP, paramFinderItem, paramBoolean);
    AppMethodBeat.o(198074);
  }
  
  public final int epE()
  {
    return this.IoU;
  }
  
  public final com.tencent.mm.plugin.finder.view.f fSW()
  {
    AppMethodBeat.i(198069);
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderCommentDrawerUIC.class)).fSY();
    AppMethodBeat.o(198069);
    return localObject;
  }
  
  public final void fTn()
  {
    AppMethodBeat.i(198079);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new j.z(this));
    AppMethodBeat.o(198079);
  }
  
  public final void fTo()
  {
    AppMethodBeat.i(198077);
    fTn();
    AppMethodBeat.o(198077);
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final com.tencent.mm.plugin.finder.video.c getVideoCore()
  {
    return this.qrq;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165921);
    d.g.b.k.h(parama, "p0");
    this.quc.add(parama);
    AppMethodBeat.o(165921);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(198073);
    if (this.qrz == null) {}
    i.b localb;
    for (boolean bool = false;; bool = localb.onBackPressed())
    {
      AppMethodBeat.o(198073);
      return bool;
      localb = this.qrz;
      if (localb == null) {
        d.g.b.k.fvU();
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165913);
    ad.i("Finder.TimelinePresenter", "onDestroy");
    com.tencent.mm.plugin.finder.storage.data.c.qKo.clearCache();
    this.KOY.dead();
    Object localObject1 = this.qrz;
    int k;
    int i;
    if (localObject1 != null)
    {
      Object localObject2 = ((i.b)localObject1).getRecyclerView().getLayoutManager();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(165913);
        throw ((Throwable)localObject1);
      }
      k = ((LinearLayoutManager)localObject2).jO();
      localObject2 = cmr();
      if (localObject2 == null) {
        break label225;
      }
      i = ((com.tencent.mm.view.recyclerview.d)localObject2).Ibl.size();
      localObject1 = ((i.b)localObject1).getRecyclerView().ci(k);
      if (localObject1 == null) {
        break label230;
      }
      localObject1 = ((RecyclerView.v)localObject1).arI;
      if (localObject1 == null) {
        break label230;
      }
    }
    label225:
    label230:
    for (int j = ((View)localObject1).getTop();; j = 0)
    {
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      FinderHomeTabStateVM.a((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class), this.IoU, k - i, j, (ArrayList)this.qrj.getDataListJustForAdapter());
      localObject1 = ((Iterable)this.quc).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
      i = 0;
      break;
    }
    this.quc.clear();
    localObject1 = com.tencent.mm.ui.component.a.LCX;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).ahZ(this.IoU);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.d)localObject1).b((com.tencent.mm.plugin.finder.event.base.f)this);
      ((com.tencent.mm.plugin.finder.event.base.d)localObject1).b((com.tencent.mm.plugin.finder.event.base.f)this.qvy);
    }
    this.qvy.onDetach();
    this.qrj.unregister(this.qvO, this.imP);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.qwO);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.qwU);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.KPg);
    this.qrz = null;
    AppMethodBeat.o(165913);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(165911);
    fTn();
    com.tencent.mm.plugin.finder.utils.q localq = com.tencent.mm.plugin.finder.utils.q.LaJ;
    AppMethodBeat.o(165911);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165905);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new u(this));
    AppMethodBeat.o(165905);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(165865);
      switch (paramInt)
      {
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.qwX, false, 0, 6);
        AppMethodBeat.o(165865);
        return localObject;
      case -7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ac();
        AppMethodBeat.o(165865);
        return localObject;
      case -1: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.f((d.g.a.a)new j.b.a(this));
        AppMethodBeat.o(165865);
        return localObject;
      case -4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(165865);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(165865);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n();
        AppMethodBeat.o(165865);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new r(j.e(this.qwX), (c)this.qwX, false, j.w(this.qwX), 4);
        AppMethodBeat.o(165865);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.qwX, false, j.w(this.qwX), 2);
        AppMethodBeat.o(165865);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.o((c)this.qwX, false, j.w(this.qwX), 2);
        AppMethodBeat.o(165865);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.i(j.e(this.qwX), (c)this.qwX, false, j.w(this.qwX), 4);
        AppMethodBeat.o(165865);
        return localObject;
      case 1: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.l((c)this.qwX, false, j.w(this.qwX), 2);
        AppMethodBeat.o(165865);
        return localObject;
      }
      Object localObject = j.g(this.qwX);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.q((i.b)localObject, j.w(this.qwX));
      AppMethodBeat.o(165865);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    c(j paramj, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.view.d
  {
    private String tag = "Finder.TimelinePresenter";
    
    public final void a(long paramLong, ake paramake)
    {
      AppMethodBeat.i(165868);
      Object localObject1 = j.g(this.qwX);
      if (localObject1 != null)
      {
        localObject1 = ((i.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramake = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165868);
            throw paramake;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).ln();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new d.o(Integer.valueOf(1), paramake));
              AppMethodBeat.o(165868);
              return;
            }
            AppMethodBeat.o(165868);
            return;
          }
          AppMethodBeat.o(165868);
          return;
        }
      }
      AppMethodBeat.o(165868);
    }
    
    public final String getTag()
    {
      return this.tag;
    }
    
    public final FinderItem pZ(long paramLong)
    {
      AppMethodBeat.i(165867);
      Object localObject1 = j.g(this.qwX);
      if (localObject1 != null)
      {
        localObject1 = ((i.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165867);
            throw ((Throwable)localObject1);
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).ln();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
              AppMethodBeat.o(165867);
              throw ((Throwable)localObject1);
            }
            int j = ((com.tencent.mm.view.recyclerview.d)localObject1).Ibl.size();
            localObject1 = (BaseFinderFeed)j.b(this.qwX).safeGet(i - j);
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              AppMethodBeat.o(165867);
              return localObject1;
            }
            AppMethodBeat.o(165867);
            return null;
          }
        }
      }
      AppMethodBeat.o(165867);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<gx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.c
  {
    f(j paramj, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
    {
      boolean bool = true;
      AppMethodBeat.i(165871);
      j.f(this.qwX).getString(2131755893);
      Object localObject1 = j.f(this.qwX).getString(2131755892);
      j.f(this.qwX).getString(2131758845);
      Object localObject2 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
      com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
      ad.i("Finder.TimelinePresenter", com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
      if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
        if (com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed))
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.f.qSs;
          localObject1 = (String)com.tencent.mm.plugin.finder.utils.f.a((Context)j.f(this.qwX), paramBaseFinderFeed, 2, (d.g.a.b)new a(this, paraml)).second;
        }
      }
      for (;;)
      {
        paraml.a(j.m(this.qwX), (CharSequence)localObject1, 2131689817, 0, bool);
        paraml = FinderReporterUIC.Ljl;
        paraml = FinderReporterUIC.a.lB((Context)j.f(this.qwX));
        if (paraml != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.E(paramBaseFinderFeed.bMs(), paraml.qqE);
        }
        paraml = FinderReporterUIC.Ljl;
        paraml = FinderReporterUIC.a.lB((Context)j.f(this.qwX));
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.fSl().BF(paramBaseFinderFeed.bMs());
            AppMethodBeat.o(165871);
            return;
            if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
              break label393;
            }
            localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
            com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject1 = com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeShare", 2131759345);
            localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
            com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeCollect", 2131759343);
            continue;
          }
        }
        AppMethodBeat.o(165871);
        return;
        label393:
        bool = false;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, d.y>
    {
      a(j.f paramf, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements n.c
  {
    g(j paramj, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165872);
      if (!j.f(paramBaseFinderFeed))
      {
        paraml.a(j.o(this.qwX), (CharSequence)j.f(this.qwX).getString(2131761335), 2131690191);
        paraml.a(j.p(this.qwX), (CharSequence)j.f(this.qwX).getString(2131761332), 2131690646);
        AppMethodBeat.o(165872);
        return;
      }
      paraml.aI(j.q(this.qwX), 2131755707, 2131690551);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paraml.a(j.r(this.qwX), (CharSequence)j.f(this.qwX).getString(2131759223), 2131690547);
        AppMethodBeat.o(165872);
        return;
      }
      paraml.a(j.s(this.qwX), (CharSequence)j.f(this.qwX).getString(2131759210), 2131690190);
      AppMethodBeat.o(165872);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class h
    implements n.d
  {
    h(j paramj, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165876);
      Object localObject = new StringBuilder("[getMoreMenuItemSelectedListener] feed ").append(paramBaseFinderFeed).append(' ').append(paramInt).append(" menuItem:");
      d.g.b.k.g(paramMenuItem, "menuItem");
      ad.i("Finder.TimelinePresenter", paramMenuItem.getItemId());
      paramInt = paramMenuItem.getItemId();
      if (paramInt == j.o(this.qwX))
      {
        paramMenuItem = j.b(this.qwX).getDataListJustForAdapter();
        paramInt = paramMenuItem.indexOf(paramBaseFinderFeed);
        if (paramInt >= 0)
        {
          localObject = com.tencent.mm.plugin.finder.feed.logic.b.qya;
          com.tencent.mm.plugin.finder.feed.logic.b.a((Context)j.f(this.qwX), paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new d.g.b.l(paramMenuItem) {});
          AppMethodBeat.o(165876);
          return;
        }
        ad.i("Finder.TimelinePresenter", "[not interested] pos error=" + paramInt + ", feed=" + paramBaseFinderFeed + ", dataList=" + paramMenuItem);
        AppMethodBeat.o(165876);
        return;
      }
      if (paramInt == j.q(this.qwX))
      {
        if (paramBaseFinderFeed.feedObject.isPostFinish())
        {
          com.tencent.mm.ui.base.h.a((Context)j.f(this.qwX), 2131759309, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(178269);
              paramAnonymousDialogInterface = com.tencent.mm.model.u.aqO();
              d.g.b.k.g(paramAnonymousDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
              paramAnonymousDialogInterface = new m(paramAnonymousDialogInterface, this.qxa.qug.feedObject.getId(), this.qxa.qug.feedObject.getObjectNonceId());
              Object localObject = j.u(this.qxa.qwX);
              if (localObject != null) {
                ((Dialog)localObject).show();
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface.getType(), (com.tencent.mm.al.g)new com.tencent.mm.al.g()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
                  {
                    AppMethodBeat.i(178268);
                    if (((paramAnonymous2n instanceof m)) && (((m)paramAnonymous2n).objectId == paramAnonymousDialogInterface.objectId)) {
                      com.tencent.mm.kernel.g.aeS().b(paramAnonymousDialogInterface.getType(), (com.tencent.mm.al.g)this);
                    }
                    paramAnonymous2String = j.u(this.qxc.qxa.qwX);
                    if (paramAnonymous2String != null) {
                      paramAnonymous2String.dismiss();
                    }
                    if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                      com.tencent.mm.ui.base.t.makeText((Context)j.f(this.qxc.qxa.qwX), 2131766471, 0).show();
                    }
                    AppMethodBeat.o(178268);
                  }
                });
                com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramAnonymousDialogInterface);
                AppMethodBeat.o(178269);
                return;
                localObject = this.qxa.qwX;
                Context localContext = (Context)j.f((j)localObject);
                j.f((j)localObject).getString(2131755906);
                j.a((j)localObject, (Dialog)com.tencent.mm.ui.base.h.b(localContext, j.f((j)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)j.h.2.a.qxb));
              }
            }
          }, null);
          AppMethodBeat.o(165876);
        }
      }
      else if (paramInt != j.v(this.qwX))
      {
        if (paramInt == j.l(this.qwX))
        {
          new Bundle();
          com.tencent.mm.plugin.finder.utils.g.qSw.a(j.f(this.qwX), paramBaseFinderFeed.feedObject);
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.m(this.qwX))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.g.qSw;
          g.a.a(j.f(this.qwX), paramBaseFinderFeed);
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.n(this.qwX))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.b.qSc;
          com.tencent.mm.plugin.finder.utils.b.a(paramBaseFinderFeed, j.f(this.qwX));
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.p(this.qwX))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.qxZ;
          com.tencent.mm.plugin.finder.feed.logic.a.i((Context)j.f(this.qwX), paramBaseFinderFeed.feedObject.field_id);
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.x(this.qwX))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("postRefMediaList", paramBaseFinderFeed.feedObject.getFeedObject().objectDesc.toByteArray());
          localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
          paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.i.l(paramBaseFinderFeed).toByteArray());
          paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          paramMenuItem.putExtra("key_finder_post_from", 5);
          localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)j.f(this.qwX), paramMenuItem);
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.r(this.qwX))
        {
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.i)new com.tencent.mm.plugin.i.a.i() {});
          AppMethodBeat.o(165876);
          return;
        }
        if (paramInt == j.s(this.qwX)) {
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.i)new com.tencent.mm.plugin.i.a.i() {});
        }
      }
      AppMethodBeat.o(165876);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(j paramj, boolean paramBoolean, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(165877);
      Object localObject1 = j.h(this.qwX);
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject1, j.i(this.qwX).hashCode());
        if (localObject1 != null)
        {
          Rect localRect = new Rect();
          ((com.tencent.mm.view.recyclerview.e)localObject1).arI.getGlobalVisibleRect(localRect);
          if (localRect.height() > 0)
          {
            if (paramBoolean)
            {
              localObject1 = j.g(this.qwX);
              if (localObject1 != null)
              {
                localObject1 = ((i.b)localObject1).getRecyclerView();
                if (localObject1 != null) {
                  ((RecyclerView)localObject1).smoothScrollBy(0, localRect.height());
                }
              }
              ad.i("Finder.TimelinePresenter", "[hideSearchBar] to hide search bar. delay=" + paramLong + " isSmooth=" + paramBoolean + " height=" + localRect.height());
            }
          }
          else
          {
            AppMethodBeat.o(165877);
            return;
          }
          localObject1 = j.g(this.qwX);
          if (localObject1 != null)
          {
            localObject1 = ((i.b)localObject1).getRecyclerView();
            if (localObject1 == null) {}
          }
          for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
          {
            Object localObject2 = localObject1;
            if (!(localObject1 instanceof LinearLayoutManager)) {
              localObject2 = null;
            }
            localObject1 = (LinearLayoutManager)localObject2;
            if (localObject1 == null) {
              break;
            }
            ((LinearLayoutManager)localObject1).af(1, 0);
            break;
          }
        }
      }
      AppMethodBeat.o(165877);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    j(j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.finder.video.c.b
  {
    k(i.b paramb) {}
    
    public final RecyclerView clN()
    {
      AppMethodBeat.i(165879);
      RecyclerView localRecyclerView = this.qrC.getRecyclerView();
      AppMethodBeat.o(165879);
      return localRecyclerView;
    }
    
    public final DataBuffer<BaseFinderFeed> fSX()
    {
      AppMethodBeat.i(198060);
      DataBuffer localDataBuffer = j.b(this.qwX).getDataListJustForAdapter();
      AppMethodBeat.o(198060);
      return localDataBuffer;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "visiblePosition", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    l(j paramj, i.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkNoMoreFooter$1$1"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    m(j paramj, boolean paramBoolean, RefreshLoadMoreLayout.c paramc, WxRecyclerAdapter paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class n
    extends com.tencent.mm.sdk.b.c<hb>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$init$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    o(i.b paramb, FinderHomeTabStateVM.a parama, int paramInt) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(165889);
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramInt));
      AppMethodBeat.o(165889);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(j.o paramo, int paramInt)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class p
    extends com.tencent.mm.sdk.b.c<yq>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(178272);
      com.tencent.mm.plugin.finder.event.base.a locala = new com.tencent.mm.plugin.finder.event.base.a(4);
      Object localObject = j.e(this.qwX).qTI;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.event.a)localObject).qrZ;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.b)localObject).b((com.tencent.mm.plugin.finder.event.base.c)locala);
          AppMethodBeat.o(178272);
          return;
        }
      }
      AppMethodBeat.o(178272);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    r(j paramj, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    s(j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(178273);
      com.tencent.mm.plugin.finder.event.base.a locala = new com.tencent.mm.plugin.finder.event.base.a(3);
      Object localObject = j.e(this.qwX).qTI;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.event.a)localObject).qrZ;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.b)localObject).b((com.tencent.mm.plugin.finder.event.base.c)locala);
          AppMethodBeat.o(178273);
          return;
        }
      }
      AppMethodBeat.o(178273);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    u(j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<FinderWhatsNewView>
  {
    v(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j
 * JD-Core Version:    0.7.0.1
 */