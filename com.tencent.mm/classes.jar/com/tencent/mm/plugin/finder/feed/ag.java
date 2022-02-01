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
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
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
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "MENU_ID_CLOSE_COMMENT", "", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "canTimelineRefresh", "", "commentChangeEventListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1;", "commentFailedNotifyDataList", "", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1;", "emptyData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "emptyFooterData", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1;", "hasPrefetch", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "isAutoLoadingMore", "isCurrentEmptyData", "isFooterEmpty", "isFragment", "isPreLoadingMore", "lastPositionToPreLoad", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "needToRefreshForPrefetch", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "tabType", "tipDialog", "Landroid/app/Dialog;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "whatsNewView", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "getWhatsNewView", "()Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "whatsNewView$delegate", "Lkotlin/Lazy;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "isWithRefresh", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "checkNoMoreFooter", "isRefreshEnd", "findUnreadFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feed", "dataList", "", "genHasMoreCacheKey", "", "getActivity", "getAdapter", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getFinderContextId", "getHeaderInfo", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getTabType", "getVideoCore", "hideSearchBar", "delay", "", "isSmooth", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isFinderSelfScene", "isSelf", "keep", "p0", "loadMoreData", "notifyChanged", "rv", "Landroid/support/v7/widget/RecyclerView;", "itemId", "onAttach", "onBackPressed", "onDetach", "onEventHappen", "ev", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onLoadMoreEnd", "reason", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "refreshMsgNotify", "requestInsert", "centerFeed", "maxUnreadCount", "hasReadFeeds", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "requestRefresh", "shareFeed", "Companion", "plugin-finder_release"})
public final class ag
  extends com.tencent.mm.plugin.finder.event.base.d
  implements x.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private static ConcurrentHashMap<String, RefreshLoadMoreLayout.c<Object>> rkZ;
  public static final ag.a rla;
  private final int diw;
  private final int iBw;
  private final MMActivity iMV;
  private final int nPj;
  private final int nPp;
  private final int raj;
  private x.b rbJ;
  private final com.tencent.mm.plugin.finder.video.i rbo;
  private final com.tencent.mm.plugin.finder.feed.model.c rfE;
  private final int rfG;
  private final int rfH;
  private final int rfI;
  private final int rfJ;
  private final int rfK;
  private final int rfL;
  private RecyclerView.n rfO;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private com.tencent.mm.view.d rgg;
  private final FinderHomeTabStateVM rjC;
  private boolean rjD;
  private final FinderHomeTabFragment rjJ;
  private boolean rkJ;
  private boolean rkK;
  private final g rkL;
  private final boolean rkM;
  private final d.f rkN;
  private boolean rkO;
  private boolean rkP;
  private final i rkQ;
  private d.b rkR;
  private d.b rkS;
  private final List<com.tencent.mm.plugin.finder.model.d> rkT;
  private final int rkU;
  private boolean rkV;
  private boolean rkW;
  private final j rkX;
  private final h rkY;
  private final com.tencent.mm.plugin.finder.feed.model.m rke;
  private final com.tencent.mm.plugin.finder.model.f rkf;
  private final com.tencent.mm.plugin.finder.model.g rkt;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(165897);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(ag.class), "whatsNewView", "getWhatsNewView()Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;")) };
    rla = new ag.a((byte)0);
    rkZ = new ConcurrentHashMap();
    AppMethodBeat.o(165897);
  }
  
  public ag(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(201982);
    this.iMV = paramMMActivity;
    this.rjJ = paramFinderHomeTabFragment;
    this.rfP = new CopyOnWriteArraySet();
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rjC = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = this.rjJ;
    int i;
    if (paramMMActivity != null)
    {
      i = paramMMActivity.diw;
      this.diw = i;
      this.rjD = this.rjC.ES(this.diw);
      paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.c.roo;
      paramMMActivity = c.a.DJ(this.diw);
      if (!this.rjD) {
        break label481;
      }
      i = 0;
      label128:
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.IrY;
      this.rke = new com.tencent.mm.plugin.finder.feed.model.m(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).Fc(this.diw));
      this.rfG = 99;
      this.raj = 100;
      this.nPp = 101;
      this.rfH = 102;
      this.nPj = 103;
      this.rfI = 104;
      this.rfJ = 105;
      this.rfK = 106;
      this.rfL = 107;
      this.iBw = 108;
      paramMMActivity = com.tencent.mm.ui.component.a.IrY;
      this.rfO = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderRecyclerViewPool.class)).rfO;
      this.rbo = new com.tencent.mm.plugin.finder.video.i(this.diw);
      this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(this.iMV);
      this.rkL = new g(this);
      this.rgg = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
      {
        public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165863);
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = ag.k(this.rlb);
              if (locald != null) {}
              for (int i = locald.JCb.size();; i = 0)
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
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = ag.k(this.rlb);
              if (locald != null) {}
              for (int i = locald.JCb.size();; i = 0)
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
          AppMethodBeat.i(165859);
          d.g.b.k.h(paramAnonymousc, "reason");
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
            if (localObject != null)
            {
              ((RefreshLoadMoreLayout)localObject).c(paramAnonymousc);
              AppMethodBeat.o(165859);
              return;
            }
          }
          AppMethodBeat.o(165859);
        }
        
        public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(165860);
          d.g.b.k.h(paramAnonymousc, "reason");
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
            if (localObject != null)
            {
              ((RefreshLoadMoreLayout)localObject).d(paramAnonymousc);
              AppMethodBeat.o(165860);
              return;
            }
          }
          AppMethodBeat.o(165860);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(165862);
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
            if (localObject != null)
            {
              com.tencent.mm.view.recyclerview.d locald = ag.k(this.rlb);
              if (locald != null) {}
              for (int i = locald.JCb.size();; i = 0)
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
          Object localObject = ag.i(this.rlb);
          if (localObject != null)
          {
            localObject = ((x.b)localObject).cvl();
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
      if (this.rjJ == null) {
        break label486;
      }
    }
    for (;;)
    {
      this.rkM = bool;
      this.rkN = d.g.K((d.g.a.a)new ab(this));
      this.rkQ = new i(this);
      this.rkf = new com.tencent.mm.plugin.finder.model.f();
      this.rkt = new com.tencent.mm.plugin.finder.model.g();
      this.rkR = ((d.b)new com.tencent.mm.plugin.finder.model.e());
      this.rkS = ((d.b)new com.tencent.mm.plugin.finder.model.c());
      this.rkT = ((List)new ArrayList());
      paramMMActivity = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramMMActivity, "MMKernel.storage()");
      this.rkU = paramMMActivity.agA().getInt(ah.a.GUU, 0);
      this.rkX = new j(this);
      this.rkY = new h(this);
      AppMethodBeat.o(201982);
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
  
  private final void a(final RefreshLoadMoreLayout.c<Object> paramc, final boolean paramBoolean)
  {
    final boolean bool = false;
    AppMethodBeat.i(201971);
    Object localObject = this.rbJ;
    if (localObject != null)
    {
      localObject = ((x.b)localObject).getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if ((localObject instanceof WxRecyclerAdapter)) {
          break label275;
        }
        localObject = null;
      }
    }
    label275:
    for (;;)
    {
      localObject = (WxRecyclerAdapter)localObject;
      if (localObject != null) {}
      com.tencent.mm.plugin.finder.storage.b localb;
      for (int i = ((com.tencent.mm.view.recyclerview.d)localObject).fzq();; i = 0)
      {
        if (i <= 0) {
          bool = true;
        }
        localb = com.tencent.mm.plugin.finder.storage.b.rCU;
        if ((com.tencent.mm.plugin.finder.storage.b.czZ()) || (!bool)) {
          break label111;
        }
        AppMethodBeat.o(201971);
        return;
        localObject = null;
        break;
      }
      label111:
      if (((this.diw == 3) || (this.diw == 1)) && (paramc != null))
      {
        localb = com.tencent.mm.plugin.finder.storage.b.rCU;
        if ((com.tencent.mm.plugin.finder.storage.b.czZ()) || ((!bool) && (!paramc.Jyb)))
        {
          this.rkP = true;
          com.tencent.mm.ac.c.g((d.g.a.a)new f(this, bool, paramc, (WxRecyclerAdapter)localObject, paramBoolean));
          ((Map)rkZ).put(cvs(), paramc);
          AppMethodBeat.o(201971);
          return;
        }
        if ((paramBoolean) && (localObject != null) && (((WxRecyclerAdapter)localObject).b(this.rkS)))
        {
          com.tencent.mm.view.recyclerview.d.b((com.tencent.mm.view.recyclerview.d)localObject, this.rkS.lx());
          paramc = this.rbJ;
          if (paramc != null)
          {
            paramc = paramc.cvl();
            if (paramc != null)
            {
              paramc.setEnableLoadMore(true);
              AppMethodBeat.o(201971);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(201971);
      return;
    }
  }
  
  private final FinderWhatsNewView cvr()
  {
    AppMethodBeat.i(165899);
    FinderWhatsNewView localFinderWhatsNewView = (FinderWhatsNewView)this.rkN.getValue();
    AppMethodBeat.o(165899);
    return localFinderWhatsNewView;
  }
  
  private final com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.e> cvt()
  {
    AppMethodBeat.i(165914);
    Object localObject1 = this.rbJ;
    if (localObject1 != null)
    {
      localObject1 = ((x.b)localObject1).getRecyclerView();
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
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165903);
    com.tencent.mm.ac.c.g((d.g.a.a)new e(this, paramc));
    AppMethodBeat.o(165903);
  }
  
  private final void s(final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(165902);
    Object localObject = this.rbJ;
    if (localObject != null)
    {
      localObject = ((x.b)localObject).getRecyclerView();
      if (localObject != null)
      {
        ((RecyclerView)localObject).postDelayed((Runnable)new n(this, paramBoolean, paramLong), paramLong);
        AppMethodBeat.o(165902);
        return;
      }
    }
    AppMethodBeat.o(165902);
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201980);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.rjC.ES(this.diw)) || (paramBoolean1))
    {
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((x.b)localObject1).getRecyclerView();
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      localObject2 = localObject1;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        localObject2 = null;
      }
      localObject1 = (LinearLayoutManager)localObject2;
      if (localObject1 == null) {
        break label333;
      }
      i = ((LinearLayoutManager)localObject1).jW();
      label89:
      ac.i("Finder.TimelinePresenter", "[checkAutoFlingToRefresh] isHard=" + paramBoolean1 + " isWithRefresh=" + paramBoolean2 + " offset=" + i);
      if (i > 3) {
        break label338;
      }
      localObject1 = this.rbJ;
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
      }
      localObject1 = this.rbJ;
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).post((Runnable)new c(this));
        }
      }
      label285:
      if (paramBoolean2)
      {
        if (1 <= i) {
          break label489;
        }
        label294:
        localObject1 = this.rbJ;
        if (localObject1 != null) {
          ((x.b)localObject1).uh(200L);
        }
      }
    }
    for (;;)
    {
      this.rjD = false;
      AppMethodBeat.o(201980);
      return;
      label327:
      localObject1 = null;
      break;
      label333:
      i = 0;
      break label89;
      label338:
      localObject1 = this.rbJ;
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "checkAutoFlingToRefresh", "(ZZ)V", "Undefined", "scrollToPosition", "(I)V");
        }
      }
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        break label285;
      }
      localObject1 = ((x.b)localObject1).getRecyclerView();
      if (localObject1 == null) {
        break label285;
      }
      ((RecyclerView)localObject1).post((Runnable)new d(this));
      break label285;
      label489:
      if (3 < i) {
        break label294;
      }
      localObject1 = this.rbJ;
      if (localObject1 != null) {
        ((x.b)localObject1).uh(600L);
      }
    }
  }
  
  public final n.c a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(165915);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parame, "sheet");
    paramBaseFinderFeed = (n.c)new k(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(165915);
    return paramBaseFinderFeed;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(165919);
    d.g.b.k.h(paramb, "ev");
    if ((this.rkU > 0) && (!this.rkV) && ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)))
    {
      int j = this.rke.rnh.qZp.length;
      Object localObject = cvt();
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.view.recyclerview.d)localObject).getItemCount() + j - ((com.tencent.mm.view.recyclerview.d)localObject).JCb.size();; i = 0)
      {
        int k = i - this.rkU;
        if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).rdJ < k) || (i < 4) || (j != 0)) {
          break label318;
        }
        ac.i("Finder.TimelinePresenter", "[onAutoToLoadMore] lastPositionToPreLoad=" + this.rkU + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdJ + ", preLoadPos=" + k + ", bufferSize=" + j + ", count=" + i);
        if (this.diw != 4) {
          break;
        }
        if (this.rkW) {
          break label318;
        }
        paramb = this.rbJ;
        if (paramb != null)
        {
          paramb = paramb.cvl();
          if (paramb != null) {
            paramb.yu(true);
          }
        }
        this.rkW = true;
        AppMethodBeat.o(165919);
        return;
      }
      if (!this.rkV)
      {
        paramb = this.rke;
        localObject = (com.tencent.mm.plugin.finder.feed.model.internal.d)new u(this);
        d.g.b.k.h(localObject, "callback");
        z localz = new z(2);
        ac.i(paramb.getTAG(), "preloadMore ".concat(String.valueOf(localz)));
        localz.rnE = true;
        paramb.fetchData((com.tencent.mm.plugin.finder.feed.model.internal.i)localz, (com.tencent.mm.plugin.finder.feed.model.internal.d)localObject);
        this.rkV = true;
      }
    }
    label318:
    AppMethodBeat.o(165919);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed1, BaseFinderFeed paramBaseFinderFeed2, int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, ald paramald)
  {
    AppMethodBeat.i(201974);
    d.g.b.k.h(paramBaseFinderFeed1, "feed");
    d.g.b.k.h(paramBaseFinderFeed2, "centerFeed");
    d.g.b.k.h(paramList, "hasReadFeeds");
    paramList = new com.tencent.mm.plugin.finder.feed.model.y();
    paramList.rdD = paramBaseFinderFeed1;
    paramList.rde = paramBaseFinderFeed2;
    paramList.rnC = paramBoolean;
    paramList.rnB = paramInt;
    paramList.qXD = paramald;
    this.rke.requestInsert((com.tencent.mm.plugin.finder.feed.model.internal.i)paramList);
    AppMethodBeat.o(201974);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201978);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb();
    com.tencent.mm.plugin.finder.model.u localu = com.tencent.mm.plugin.finder.model.u.ruV;
    com.tencent.mm.plugin.finder.model.u.a((anm)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
    AppMethodBeat.o(201978);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(201977);
    d.g.b.k.h(paramFinderItem, "feed");
    k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, this.iMV, paramFinderItem);
    AppMethodBeat.o(201977);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165922);
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165922);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(201976);
    d.g.b.k.h(paramFinderItem, "feed");
    com.tencent.mm.plugin.finder.model.k localk = com.tencent.mm.plugin.finder.model.k.ruF;
    com.tencent.mm.plugin.finder.model.k.a(this.iMV, paramFinderItem, paramBoolean);
    AppMethodBeat.o(201976);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165901);
    d.g.b.k.h(paramc, "reason");
    g(paramc);
    Object localObject = this.rbJ;
    if (localObject != null)
    {
      localObject = ((x.b)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).post((Runnable)new v(this));
      }
    }
    a(paramc, false);
    this.rkW = false;
    AppMethodBeat.o(165901);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(165920);
    d.g.b.k.h(paramc, "dispatcher");
    d.g.b.k.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0)
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
  
  public final void aQh()
  {
    AppMethodBeat.i(165906);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new o(this));
    AppMethodBeat.o(165906);
  }
  
  public final void b(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165900);
    d.g.b.k.h(paramc, "reason");
    Object localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
    com.tencent.mm.plugin.finder.report.d.ge(cvh(), "EndCgi");
    Object localObject2 = this.rbo.rSr;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      localStringBuilder = new StringBuilder();
      localObject1 = this.rjJ;
      if (localObject1 == null) {
        break label163;
      }
      localObject1 = localObject1.getClass();
      if (localObject1 == null) {
        break label163;
      }
    }
    label163:
    for (localObject1 = ((Class)localObject1).getSimpleName();; localObject1 = null)
    {
      FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject2, (String)localObject1 + "#onAttach", false);
      ac.i("Finder.TimelinePresenter", "[onRefreshEnd] reason=".concat(String.valueOf(paramc)));
      if (cvr() == null) {
        break label175;
      }
      localObject1 = cvr();
      if ((localObject1 == null) || (((FinderWhatsNewView)localObject1).isAttachedToWindow() != true)) {
        break label175;
      }
      localObject1 = cvr();
      if (localObject1 == null) {
        break;
      }
      ((FinderWhatsNewView)localObject1).setDetachFinish((d.g.a.a)new w(this, paramc));
      AppMethodBeat.o(165900);
      return;
    }
    AppMethodBeat.o(165900);
    return;
    label175:
    if (paramc.Jyc <= 0)
    {
      localObject1 = this.rbJ;
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).cvl();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
          ((RefreshLoadMoreLayout)localObject1).b(com.tencent.mm.plugin.finder.storage.b.czS(), (d.g.a.a)new x(this));
        }
      }
      g(paramc);
      localObject1 = this.rbJ;
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).post((Runnable)new y(this));
        }
      }
      this.rkJ = false;
      this.rkK = false;
      a(paramc, true);
      paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
      paramc = ((PluginFinder)paramc).getRedDotManager();
      switch (this.diw)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(165900);
      return;
      s(0L, false);
      break;
      paramc.Dy(7);
      AppMethodBeat.o(165900);
      return;
      paramc.Dy(8);
      AppMethodBeat.o(165900);
      return;
      paramc.Dy(1004);
    }
  }
  
  public final boolean cuq()
  {
    return false;
  }
  
  public final com.tencent.mm.view.recyclerview.c cut()
  {
    AppMethodBeat.i(165910);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new b(this);
    AppMethodBeat.o(165910);
    return localc;
  }
  
  public final RecyclerView.n cuu()
  {
    return this.rfO;
  }
  
  public final com.tencent.mm.plugin.finder.view.d cuv()
  {
    AppMethodBeat.i(201969);
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderCommentDrawerUIC.class)).cuz();
    AppMethodBeat.o(201969);
    return localObject;
  }
  
  public final List<d.b> cvf()
  {
    AppMethodBeat.i(165909);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUV, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUW, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUX, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUY, 0);
    this.rkf.count = (i + j + k + m);
    localObject2 = this.rkf;
    Object localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).agA().get(ah.a.GUZ, "");
    if (localObject3 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165909);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.f)localObject2).setAvatar((String)localObject3);
    ac.i("Finder.TimelinePresenter", "commentCnt " + i + ", likeCnt " + j + " objectLikeLikeCnt " + k + " objectRecommendLikeCnt " + m + " avatar: " + this.rkf.ruB + " tabType " + this.diw);
    ((LinkedList)localObject1).add(this.rkt);
    ((LinkedList)localObject1).add(this.rkf);
    localObject3 = (Iterable)((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().cxV();
    localObject2 = (Collection)this.rkT;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      com.tencent.mm.plugin.finder.storage.a.b localb = (com.tencent.mm.plugin.finder.storage.a.b)((Iterator)localObject3).next();
      ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.d(localb.dig, localb.objectNonceId, (byte)0));
    }
    ((LinkedList)localObject1).addAll((Collection)this.rkT);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(165909);
    return localObject1;
  }
  
  public final void cvg()
  {
    AppMethodBeat.i(201981);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new z(this));
    AppMethodBeat.o(201981);
  }
  
  public final String cvh()
  {
    AppMethodBeat.i(201970);
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    String str = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).qox;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(201970);
    return localObject;
  }
  
  public final int cvi()
  {
    return this.diw;
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(201979);
    cvg();
    AppMethodBeat.o(201979);
  }
  
  public final String cvs()
  {
    AppMethodBeat.i(201973);
    Object localObject = this.rke.getDataListJustForAdapter();
    int i;
    long l1;
    if (this.rke.getDataListJustForAdapter().size() == 0)
    {
      i = 1;
      if (i == 0) {
        break label108;
      }
      l1 = 0L;
      label36:
      if (i == 0) {
        break label127;
      }
    }
    label108:
    label127:
    for (long l2 = 0L;; l2 = ((BaseFinderFeed)((DataBuffer)localObject).get(((DataBuffer)localObject).size() - 1)).feedObject.getId())
    {
      localObject = this.diw + '_' + l1 + '_' + l2 + '_' + ((DataBuffer)localObject).size();
      AppMethodBeat.o(201973);
      return localObject;
      i = 0;
      break;
      l1 = ((BaseFinderFeed)((DataBuffer)localObject).get(0)).feedObject.getId();
      break label36;
    }
  }
  
  public final n.c d(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165916);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.c)new l(this, paramBaseFinderFeed);
    AppMethodBeat.o(165916);
    return paramBaseFinderFeed;
  }
  
  public final n.d e(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165917);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.d)new m(this, paramBaseFinderFeed);
    AppMethodBeat.o(165917);
    return paramBaseFinderFeed;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final com.tencent.mm.plugin.finder.video.i getVideoCore()
  {
    return this.rbo;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165921);
    d.g.b.k.h(parama, "p0");
    this.rfP.add(parama);
    AppMethodBeat.o(165921);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(201975);
    if (this.rbJ == null) {}
    x.b localb;
    for (boolean bool = false;; bool = localb.onBackPressed())
    {
      AppMethodBeat.o(201975);
      return bool;
      localb = this.rbJ;
      if (localb == null) {
        d.g.b.k.fOy();
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165913);
    ac.i("Finder.TimelinePresenter", "onDestroy");
    com.tencent.mm.plugin.finder.storage.data.e.rEI.clearCache();
    this.rkL.dead();
    Object localObject1 = this.rbJ;
    if (localObject1 != null)
    {
      Object localObject2 = ((x.b)localObject1).getRecyclerView().getLayoutManager();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(165913);
        throw ((Throwable)localObject1);
      }
      int k = ((LinearLayoutManager)localObject2).jW();
      localObject2 = cvt();
      int i;
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.view.recyclerview.d)localObject2).JCb.size();
        localObject1 = ((x.b)localObject1).getRecyclerView().ch(k);
        if (localObject1 == null) {
          break label191;
        }
        localObject1 = ((RecyclerView.w)localObject1).asD;
        if (localObject1 == null) {
          break label191;
        }
      }
      label191:
      for (int j = ((View)localObject1).getTop();; j = 0)
      {
        localObject1 = ((Iterable)this.rke.getDataListJustForAdapter()).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((BaseFinderFeed)((Iterator)localObject1).next()).showLikeTips = false;
        }
        i = 0;
        break;
      }
      localObject1 = com.tencent.mm.ui.component.a.IrY;
      FinderHomeTabStateVM.a((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class), this.diw, k - i, j, (ArrayList)this.rke.getDataListJustForAdapter());
    }
    localObject1 = ((Iterable)this.rfP).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
    }
    this.rfP.clear();
    localObject1 = com.tencent.mm.ui.component.a.IrY;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).Fi(this.diw);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
    }
    this.rfE.onDetach();
    this.rke.unregister(this.rgg, this.iMV);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.rkQ);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.rkX);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.rkY);
    this.rbJ = null;
    AppMethodBeat.o(165913);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(165911);
    cvg();
    com.tencent.mm.plugin.finder.utils.j localj = com.tencent.mm.plugin.finder.utils.j.rOX;
    AppMethodBeat.o(165911);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165905);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new aa(this));
    AppMethodBeat.o(165905);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    aa(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends d.g.b.l
    implements d.g.a.a<FinderWhatsNewView>
  {
    ab(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(165865);
      switch (paramInt)
      {
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.j((g)this.rlb, false, 0, 6);
        AppMethodBeat.o(165865);
        return localObject;
      case -7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.o();
        AppMethodBeat.o(165865);
        return localObject;
      case -1: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.h((d.g.a.a)new a(this));
        AppMethodBeat.o(165865);
        return localObject;
      case -4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.e();
        AppMethodBeat.o(165865);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n();
        AppMethodBeat.o(165865);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new r();
        AppMethodBeat.o(165865);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.v(ag.d(this.rlb), (g)this.rlb, false, ag.h(this.rlb), 4);
        AppMethodBeat.o(165865);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.j((g)this.rlb, false, ag.h(this.rlb), 2);
        AppMethodBeat.o(165865);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.t((g)this.rlb, false, ag.h(this.rlb), 2);
        AppMethodBeat.o(165865);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.m(ag.d(this.rlb), (g)this.rlb, false, ag.h(this.rlb), 4);
        AppMethodBeat.o(165865);
        return localObject;
      case 1: 
        localObject = (com.tencent.mm.view.recyclerview.b)new p((g)this.rlb, false, ag.h(this.rlb), 2);
        AppMethodBeat.o(165865);
        return localObject;
      }
      Object localObject = ag.i(this.rlb);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.u((x.b)localObject, ag.h(this.rlb));
      AppMethodBeat.o(165865);
      return localObject;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(ag.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ag paramag) {}
    
    public final void run()
    {
      AppMethodBeat.i(201951);
      Object localObject = ag.i(this.rlb);
      if (localObject != null)
      {
        localObject = ((x.b)localObject).getRecyclerView();
        if (localObject != null)
        {
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkAutoFlingToRefresh$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkAutoFlingToRefresh$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(201951);
          return;
        }
      }
      AppMethodBeat.o(201951);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ag paramag) {}
    
    public final void run()
    {
      AppMethodBeat.i(201952);
      Object localObject = ag.i(this.rlb);
      if (localObject != null)
      {
        localObject = ((x.b)localObject).getRecyclerView();
        if (localObject != null)
        {
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkAutoFlingToRefresh$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkAutoFlingToRefresh$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(201952);
          return;
        }
      }
      AppMethodBeat.o(201952);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    e(ag paramag, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$checkNoMoreFooter$1$1"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    f(ag paramag, boolean paramBoolean1, RefreshLoadMoreLayout.c paramc, WxRecyclerAdapter paramWxRecyclerAdapter, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.sdk.b.c<hd>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1$callback$2$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(com.tencent.mm.plugin.finder.model.d paramd, ag.g paramg, hd paramhd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      b(ag.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$contactUninterestListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<hl>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.plugin.finder.view.e
  {
    private String tag = "Finder.TimelinePresenter";
    
    public final void a(long paramLong, amp paramamp)
    {
      AppMethodBeat.i(165868);
      Object localObject1 = ag.i(this.rlb);
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramamp = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165868);
            throw paramamp;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lv();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new d.o(Integer.valueOf(1), paramamp));
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
    
    public final FinderItem uf(long paramLong)
    {
      AppMethodBeat.i(165867);
      Object localObject1 = ag.i(this.rlb);
      if (localObject1 != null)
      {
        localObject1 = ((x.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165867);
            throw ((Throwable)localObject1);
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lv();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 == null)
            {
              localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
              AppMethodBeat.o(165867);
              throw ((Throwable)localObject1);
            }
            int j = ((com.tencent.mm.view.recyclerview.d)localObject1).JCb.size();
            localObject1 = (BaseFinderFeed)ag.b(this.rlb).safeGet(i - j);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.sdk.b.c<gz>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements n.c
  {
    k(ag paramag, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
    {
      boolean bool = true;
      AppMethodBeat.i(165871);
      ag.j(this.rlb).getString(2131755893);
      Object localObject1 = ag.j(this.rlb).getString(2131755892);
      ag.j(this.rlb).getString(2131758845);
      Object localObject2 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      ac.i("Finder.TimelinePresenter", com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
      if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed))
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.i.rOT;
          localObject1 = (String)com.tencent.mm.plugin.finder.utils.i.a((Context)ag.j(this.rlb), paramBaseFinderFeed, 2, (d.g.a.b)new a(this, paraml)).second;
        }
      }
      for (;;)
      {
        paraml.a(ag.s(this.rlb), (CharSequence)localObject1, 2131689817, 0, bool);
        paraml = FinderReporterUIC.seQ;
        paraml = FinderReporterUIC.a.eV((Context)ag.j(this.rlb));
        if (paraml != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.H(paramBaseFinderFeed.lx(), paraml.rfR);
        }
        paraml = FinderReporterUIC.seQ;
        paraml = FinderReporterUIC.a.eV((Context)ag.j(this.rlb));
        if (paraml != null)
        {
          paraml = FinderReporterUIC.b(paraml);
          if (paraml != null)
          {
            paraml.ctb().ud(paramBaseFinderFeed.lx());
            AppMethodBeat.o(165871);
            return;
            if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
              break label393;
            }
            localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
            com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject1 = com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeShare", 2131759345);
            localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
            com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeCollect", 2131759343);
            continue;
          }
        }
        AppMethodBeat.o(165871);
        return;
        label393:
        bool = false;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, d.y>
    {
      a(ag.k paramk, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class l
    implements n.c
  {
    l(ag paramag, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165872);
      if (!ag.h(paramBaseFinderFeed))
      {
        paraml.a(ag.t(this.rlb), (CharSequence)ag.j(this.rlb).getString(2131761335), 2131690191);
        paraml.a(ag.u(this.rlb), (CharSequence)ag.j(this.rlb).getString(2131761332), 2131690646);
      }
      for (;;)
      {
        int i = ag.b(this.rlb).getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
        if (i < 0)
        {
          ac.i("Finder.TimelinePresenter", "pos is error " + i + ' ' + paramBaseFinderFeed);
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {
            com.tencent.mm.ui.base.t.makeText(ai.getContext(), (CharSequence)("pos is error " + i + ' ' + paramBaseFinderFeed + ' '), 1).show();
          }
        }
        AppMethodBeat.o(165872);
        return;
        paraml.aJ(ag.v(this.rlb), 2131755707, 2131690551);
        if (paramBaseFinderFeed.feedObject.isCommentClose()) {
          paraml.a(ag.w(this.rlb), (CharSequence)ag.j(this.rlb).getString(2131759223), 2131690547);
        } else {
          paraml.a(ag.x(this.rlb), (CharSequence)ag.j(this.rlb).getString(2131759210), 2131690190);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class m
    implements n.d
  {
    m(ag paramag, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, final int paramInt)
    {
      AppMethodBeat.i(165876);
      Object localObject = new StringBuilder("[getMoreMenuItemSelectedListener] feed ").append(paramBaseFinderFeed).append(' ').append(paramInt).append(" menuItem:");
      d.g.b.k.g(paramMenuItem, "menuItem");
      ac.i("Finder.TimelinePresenter", paramMenuItem.getItemId());
      int i = paramMenuItem.getItemId();
      if (i == ag.t(this.rlb))
      {
        paramMenuItem = ag.b(this.rlb).getDataListJustForAdapter();
        i = paramMenuItem.indexOf(paramBaseFinderFeed);
        if (i >= 0)
        {
          localObject = com.tencent.mm.plugin.finder.feed.logic.b.rmm;
          com.tencent.mm.plugin.finder.feed.logic.b.a((Context)ag.j(this.rlb), paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new d.g.b.l(paramMenuItem)
          {
            private LinkedList<Long> DG(int paramAnonymousInt)
            {
              int i = 0;
              AppMethodBeat.i(201959);
              LinkedList localLinkedList = new LinkedList();
              Set localSet;
              if (ag.h(this.rlm.rlb) == 4)
              {
                localSet = ag.a(this.rlm.rlb, this.rlm.rce, (List)paramMenuItem);
                ??? = com.tencent.mm.ui.component.a.IrY;
                ??? = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(ag.j(this.rlm.rlb)).get(FinderReporterUIC.class)).cGb();
                localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
                com.tencent.mm.plugin.finder.utils.n.a(ag.h(this.rlm.rlb), d.a.j.l((Iterable)localSet), (anm)???);
              }
              for (;;)
              {
                localObject3 = new LinkedList();
                synchronized ((Iterable)paramMenuItem)
                {
                  Object localObject4 = ((Iterable)???).iterator();
                  for (;;)
                  {
                    if (((Iterator)localObject4).hasNext())
                    {
                      Object localObject5 = ((Iterator)localObject4).next();
                      if (i < 0) {
                        d.a.j.fOc();
                      }
                      localObject5 = (BaseFinderFeed)localObject5;
                      if ((((BaseFinderFeed)localObject5).feedObject.getId() == this.rlm.rce.feedObject.getId()) || (localSet.contains(localObject5))) {
                        ((LinkedList)localObject3).add(0, new d.o(Integer.valueOf(i), localObject5));
                      }
                      i += 1;
                      continue;
                      localSet = (Set)new HashSet(0);
                      break;
                    }
                  }
                  localObject4 = d.y.KTp;
                  ??? = ((Iterable)localObject3).iterator();
                  if (((Iterator)???).hasNext())
                  {
                    localObject3 = (d.o)((Iterator)???).next();
                    ac.i("Finder.TimelinePresenter", "[not interested] removeAt " + paramInt + " subType=" + paramAnonymousInt + ' ' + ((BaseFinderFeed)((d.o)localObject3).second).feedObject);
                    paramMenuItem.remove(((d.o)localObject3).second);
                    localLinkedList.add(Long.valueOf(((BaseFinderFeed)((d.o)localObject3).second).feedObject.getCreateTime()));
                    ag.y(this.rlm.rlb).au(((Number)((d.o)localObject3).first).intValue(), 1);
                  }
                }
              }
              ??? = new StringBuilder("[not interested] feed ").append(this.rlm.rce).append(", unreadSet=");
              Object localObject3 = (Iterable)localObject1;
              Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                localCollection.add(com.tencent.mm.ac.c.pb(((BaseFinderFeed)((Iterator)localObject3).next()).feedObject.getId()));
              }
              ac.i("Finder.TimelinePresenter", (List)localCollection);
              ag.a(this.rlm.rlb);
              AppMethodBeat.o(201959);
              return localLinkedList;
            }
          });
          AppMethodBeat.o(165876);
          return;
        }
        ac.i("Finder.TimelinePresenter", "[not interested] pos error=" + i + ", feed=" + paramBaseFinderFeed + ", dataList=" + paramMenuItem);
        AppMethodBeat.o(165876);
        return;
      }
      if (i == ag.v(this.rlb))
      {
        if (paramBaseFinderFeed.feedObject.isPostFinish())
        {
          com.tencent.mm.ui.base.h.a((Context)ag.j(this.rlb), 2131759309, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(178269);
              paramAnonymousDialogInterface = com.tencent.mm.model.u.axE();
              d.g.b.k.g(paramAnonymousDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
              paramAnonymousDialogInterface = new com.tencent.mm.plugin.finder.cgi.v(paramAnonymousDialogInterface, this.rlm.rce.feedObject.getId(), this.rlm.rce.feedObject.getObjectNonceId());
              Object localObject = ag.z(this.rlm.rlb);
              if (localObject != null) {
                ((Dialog)localObject).show();
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface.getType(), (com.tencent.mm.ak.g)new com.tencent.mm.ak.g()
                {
                  public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
                  {
                    AppMethodBeat.i(178268);
                    if (((paramAnonymous2n instanceof com.tencent.mm.plugin.finder.cgi.v)) && (((com.tencent.mm.plugin.finder.cgi.v)paramAnonymous2n).qXP == paramAnonymousDialogInterface.qXP)) {
                      com.tencent.mm.kernel.g.agi().b(paramAnonymousDialogInterface.getType(), (com.tencent.mm.ak.g)this);
                    }
                    paramAnonymous2String = ag.z(this.rlp.rlm.rlb);
                    if (paramAnonymous2String != null) {
                      paramAnonymous2String.dismiss();
                    }
                    if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                      com.tencent.mm.ui.base.t.makeText((Context)ag.j(this.rlp.rlm.rlb), 2131766485, 0).show();
                    }
                    AppMethodBeat.o(178268);
                  }
                });
                com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramAnonymousDialogInterface);
                AppMethodBeat.o(178269);
                return;
                localObject = this.rlm.rlb;
                Context localContext = (Context)ag.j((ag)localObject);
                ag.j((ag)localObject).getString(2131755906);
                ag.a((ag)localObject, (Dialog)com.tencent.mm.ui.base.h.b(localContext, ag.j((ag)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)ag.m.2.a.rlo));
              }
            }
          }, null);
          AppMethodBeat.o(165876);
        }
      }
      else if (i != ag.A(this.rlb))
      {
        if (i == ag.B(this.rlb))
        {
          new Bundle();
          com.tencent.mm.plugin.finder.utils.k.rPa.a(ag.j(this.rlb), paramBaseFinderFeed.feedObject);
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.s(this.rlb))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.k.rPa;
          k.a.a(ag.j(this.rlb), paramBaseFinderFeed);
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.C(this.rlb))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.c.rOA;
          com.tencent.mm.plugin.finder.utils.c.a(paramBaseFinderFeed, ag.j(this.rlb));
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.u(this.rlb))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.rml;
          com.tencent.mm.plugin.finder.feed.logic.a.i((Context)ag.j(this.rlb), paramBaseFinderFeed.feedObject.field_id);
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.D(this.rlb))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("postRefMediaList", paramBaseFinderFeed.feedObject.getFeedObject().objectDesc.toByteArray());
          localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
          paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.n.m(paramBaseFinderFeed).toByteArray());
          paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          paramMenuItem.putExtra("key_finder_post_from", 5);
          localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)ag.j(this.rlb), paramMenuItem);
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.w(this.rlb))
        {
          ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.k)new com.tencent.mm.plugin.i.a.k() {});
          AppMethodBeat.o(165876);
          return;
        }
        if (i == ag.x(this.rlb)) {
          ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.k)new com.tencent.mm.plugin.i.a.k() {});
        }
      }
      AppMethodBeat.o(165876);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(ag paramag, boolean paramBoolean, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(165877);
      Object localObject1 = ag.k(this.rlb);
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject1, ag.l(this.rlb).hashCode());
        if (localObject1 != null)
        {
          Rect localRect = new Rect();
          ((com.tencent.mm.view.recyclerview.e)localObject1).asD.getGlobalVisibleRect(localRect);
          if (localRect.height() > 0)
          {
            if (paramBoolean)
            {
              localObject1 = ag.i(this.rlb);
              if (localObject1 != null)
              {
                localObject1 = ((x.b)localObject1).getRecyclerView();
                if (localObject1 != null) {
                  ((RecyclerView)localObject1).smoothScrollBy(0, localRect.height());
                }
              }
              ac.i("Finder.TimelinePresenter", "[hideSearchBar] to hide search bar. delay=" + paramLong + " isSmooth=" + paramBoolean + " height=" + localRect.height());
            }
          }
          else
          {
            AppMethodBeat.o(165877);
            return;
          }
          localObject1 = ag.i(this.rlb);
          if (localObject1 != null)
          {
            localObject1 = ((x.b)localObject1).getRecyclerView();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    o(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class p
    implements i.b
  {
    p(x.b paramb) {}
    
    public final RecyclerView cuw()
    {
      AppMethodBeat.i(165879);
      RecyclerView localRecyclerView = this.rbN.getRecyclerView();
      AppMethodBeat.o(165879);
      return localRecyclerView;
    }
    
    public final DataBuffer<BaseFinderFeed> cux()
    {
      AppMethodBeat.i(201960);
      DataBuffer localDataBuffer = ag.b(this.rlb).getDataListJustForAdapter();
      AppMethodBeat.o(201960);
      return localDataBuffer;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "visiblePosition", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    q(ag paramag, x.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$4", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class r
    implements TouchMediaPreviewLayout.b
  {
    private final RecyclerView fTr;
    private FinderMediaBanner rge;
    
    r(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, x.b paramb)
    {
      AppMethodBeat.i(201964);
      this.fTr = paramb.getRecyclerView();
      AppMethodBeat.o(201964);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(201963);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(201963);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(201961);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      paramScaleGestureDetector = this.fTr.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {}
      Object localObject;
      for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
      {
        this.rge = paramScaleGestureDetector;
        paramScaleGestureDetector = this.rge;
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        localObject = this.rge;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        paramScaleGestureDetector = paramScaleGestureDetector.ci(((FinderMediaBanner)localObject).getFocusPosition());
        if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.ly() != 2)) {
          break label148;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.cyY()) {
          break;
        }
        paramScaleGestureDetector = paramScaleGestureDetector.asD.findViewById(2131299974);
        if (paramScaleGestureDetector == null) {
          break label262;
        }
        this.rlr.gF(paramScaleGestureDetector);
        AppMethodBeat.o(201961);
        return true;
      }
      AppMethodBeat.o(201961);
      return false;
      label148:
      if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.ly() == 4))
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.cyZ())
        {
          paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.asD.findViewById(2131299975);
          if (paramScaleGestureDetector != null)
          {
            localObject = paramScaleGestureDetector.getVideoView();
            if ((localObject != null) && (!((com.tencent.mm.plugin.finder.video.o)localObject).isPlaying()))
            {
              AppMethodBeat.o(201961);
              return false;
            }
            paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
            if (paramScaleGestureDetector != null)
            {
              paramScaleGestureDetector.setPreview(true);
              paramScaleGestureDetector.setInterceptDetach(true);
              this.rlr.gF(paramScaleGestureDetector.getVideoView());
              AppMethodBeat.o(201961);
              return true;
            }
          }
        }
        else
        {
          AppMethodBeat.o(201961);
          return false;
        }
      }
      label262:
      AppMethodBeat.o(201961);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(201962);
      d.g.b.k.h(paramScaleGestureDetector, "detector");
      if ((this.rlr.getTouchView() instanceof com.tencent.mm.plugin.finder.video.o))
      {
        paramScaleGestureDetector = this.rlr.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(201962);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (com.tencent.mm.plugin.finder.video.o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(201962);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(ag paramag, x.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(201965);
      Object localObject = com.tencent.mm.plugin.finder.convert.u.rbM;
      localObject = this.rbN;
      View localView = this.rbN.getRootView();
      if (localView == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(201965);
        throw ((Throwable)localObject);
      }
      u.a.a((x.b)localObject, (ViewGroup)localView, this.rbN.getRecyclerView(), true, ag.h(this.rlb));
      AppMethodBeat.o(201965);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$init$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class t
    implements com.tencent.mm.plugin.finder.feed.model.internal.f
  {
    t(x.b paramb, FinderHomeTabStateVM.a parama, int paramInt) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(165889);
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramInt));
      AppMethodBeat.o(165889);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(ag.t paramt, int paramInt)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onEventHappen$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"})
  public static final class u
    implements com.tencent.mm.plugin.finder.feed.model.internal.d<com.tencent.mm.plugin.finder.feed.model.internal.h>
  {
    public final void onFetchDone(IResponse<com.tencent.mm.plugin.finder.feed.model.internal.h> paramIResponse)
    {
      AppMethodBeat.i(201966);
      d.g.b.k.h(paramIResponse, "response");
      ag.E(this.rlb);
      AppMethodBeat.o(201966);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(ag paramag) {}
    
    public final void run()
    {
      AppMethodBeat.i(178272);
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)ag.j(this.rlb));
      if (localObject != null)
      {
        localObject = ((FinderReporterUIC)localObject).Ff(ag.h(this.rlb));
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.event.base.f)localObject).rdy;
          if (localObject != null)
          {
            ((RecyclerView.c)localObject).onChanged();
            AppMethodBeat.o(178272);
            return;
          }
        }
      }
      AppMethodBeat.o(178272);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    w(ag paramag, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    x(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(ag paramag) {}
    
    public final void run()
    {
      AppMethodBeat.i(178273);
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)ag.j(this.rlb));
      if (localObject != null)
      {
        localObject = ((FinderReporterUIC)localObject).Ff(ag.h(this.rlb));
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.event.base.f)localObject).rdy;
          if (localObject != null)
          {
            ((RecyclerView.c)localObject).onChanged();
            AppMethodBeat.o(178273);
            return;
          }
        }
      }
      AppMethodBeat.o(178273);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    z(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */