package com.tencent.mm.plugin.finder.nearby.live;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "firstAttach", "", "fragment", "Landroid/support/v4/app/Fragment;", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "(Landroid/support/v4/app/Fragment;)V", "isRequestingLbs", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "createFeedLoader", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getCommentScene", "getFileCacheFlag", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getMemoryCacheFlag", "getReportContextObj", "getTabType", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public class d
  implements b.a<bo>
{
  public static final a uQW;
  private final MMActivity activity;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  private boolean firstAttach;
  protected Fragment fragment;
  private boolean isRequestingLbs;
  private final FinderHomeTabStateVM tlCache;
  private int totalDy;
  protected final bbn ttO;
  protected axj uQK;
  public b.b<bo> uQT;
  NearbyLiveFeedLoader uQU;
  private j uQV;
  
  static
  {
    AppMethodBeat.i(249097);
    uQW = new a((byte)0);
    AppMethodBeat.o(249097);
  }
  
  public d(MMActivity paramMMActivity, bbn parambbn)
  {
    AppMethodBeat.i(249096);
    this.activity = paramMMActivity;
    this.ttO = parambbn;
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramMMActivity);
    this.uQV = ((j)new k(this));
    this.emptyData = new com.tencent.mm.plugin.finder.model.g();
    AppMethodBeat.o(249096);
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(249095);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramc));
    AppMethodBeat.o(249095);
  }
  
  private static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(249094);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[0];
      AppMethodBeat.o(249094);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).ks();
      AppMethodBeat.o(249094);
      return i;
    }
    AppMethodBeat.o(249094);
    return 0;
  }
  
  public final void ED(long paramLong)
  {
    AppMethodBeat.i(249090);
    Object localObject = this.uQT;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((b.b)localObject).dcQ();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(249090);
  }
  
  public final void a(b.b<bo> paramb)
  {
    AppMethodBeat.i(249091);
    p.h(paramb, "callback");
    final boolean bool = this.tlCache.JN(dlr());
    Object localObject = this.ttO;
    int j = getCommentScene();
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      localObject = new NearbyLiveFeedLoader((bbn)localObject, j, i, getTabType(), dlq());
      ((NearbyLiveFeedLoader)localObject).setInitDone((h)new d((NearbyLiveFeedLoader)localObject, this, bool));
      ((NearbyLiveFeedLoader)localObject).fetchEndCallback = ((kotlin.g.a.b)new e((NearbyLiveFeedLoader)localObject));
      this.uQU = ((NearbyLiveFeedLoader)localObject);
      this.uQT = paramb;
      paramb = this.uQT;
      if (paramb == null) {
        p.btv("viewCallback");
      }
      localObject = this.uQU;
      if (localObject == null) {
        p.hyc();
      }
      paramb.ab((ArrayList)((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter());
      paramb = this.uQU;
      if (paramb != null) {
        paramb.register(this.uQV);
      }
      paramb = this.uQT;
      if (paramb == null) {
        p.btv("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb != null) {
        paramb.a((RecyclerView.l)new f(this));
      }
      this.firstAttach = true;
      AppMethodBeat.o(249091);
      return;
    }
  }
  
  public final b.b<bo> dlp()
  {
    AppMethodBeat.i(249082);
    b.b localb = this.uQT;
    if (localb == null) {
      p.btv("viewCallback");
    }
    AppMethodBeat.o(249082);
    return localb;
  }
  
  protected int dlq()
  {
    return 15;
  }
  
  public final int dlr()
  {
    AppMethodBeat.i(249088);
    Object localObject = this.uQK;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.nearby.live.square.tab.a locala = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
      localObject = ((axj)localObject).LHR;
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "tabInfo.tab_name!!");
    }
    for (int i = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.aul((String)localObject); i == -1; i = getTabType())
    {
      i = getTabType();
      AppMethodBeat.o(249088);
      return i;
    }
    AppMethodBeat.o(249088);
    return i;
  }
  
  public int getCommentScene()
  {
    return 76;
  }
  
  protected int getTabType()
  {
    return 1001;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(249087);
    Object localObject = this.uQT;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((b.b)localObject).getRecyclerView();
    if (localObject == null)
    {
      AppMethodBeat.o(249087);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject);
    Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    if (paramBoolean)
    {
      com.tencent.mm.hellhoundlib.b.a locala;
      if (i <= 12)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      while (i <= 12)
      {
        ED(20L);
        AppMethodBeat.o(249087);
        return;
        locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      }
      ED(600L);
    }
    AppMethodBeat.o(249087);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(249093);
    Object localObject = this.uQU;
    if (localObject != null) {
      ((NearbyLiveFeedLoader)localObject).unregister(this.uQV);
    }
    localObject = this.uQU;
    if (localObject == null) {
      p.hyc();
    }
    if (((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter().size() > 0)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(dlr());
    }
    this.firstAttach = false;
    AppMethodBeat.o(249093);
  }
  
  public final void onFinishing()
  {
    AppMethodBeat.i(249086);
    Object localObject = this.uQT;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    int i = ((b.b)localObject).dlo().getScrollY();
    localObject = this.uQT;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((b.b)localObject).getRecyclerView();
    if (localObject == null)
    {
      AppMethodBeat.o(249086);
      return;
    }
    int j = findFirstPosition((RecyclerView)localObject);
    localObject = this.uQU;
    if (localObject == null) {
      p.hyc();
    }
    int m = ((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter().size();
    int k = dlr();
    Log.i("Finder.NearbyLivePresenter", "[onFinishing] memoryCacheFlag:" + k + " position=" + j + " totalDy=" + this.totalDy + " size:" + m);
    if (m > 0)
    {
      localObject = this.tlCache;
      m = this.totalDy;
      NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.uQU;
      if (localNearbyLiveFeedLoader == null) {
        p.hyc();
      }
      FinderHomeTabStateVM.a((FinderHomeTabStateVM)localObject, k, i, j, m, (ArrayList)localNearbyLiveFeedLoader.getDataListJustForAdapter());
    }
    AppMethodBeat.o(249086);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(249085);
    NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.uQU;
    if (localNearbyLiveFeedLoader != null)
    {
      localNearbyLiveFeedLoader.b(this.uQK);
      AppMethodBeat.o(249085);
      return;
    }
    AppMethodBeat.o(249085);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(249083);
    com.tencent.mm.plugin.finder.utils.l locall = com.tencent.mm.plugin.finder.utils.l.vVE;
    com.tencent.mm.plugin.finder.utils.l.a((kotlin.g.a.a)new g(this), (kotlin.g.a.a)new h(this), (kotlin.g.a.a)new i(this));
    AppMethodBeat.o(249083);
  }
  
  public void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(249084);
    p.h(paramc, "reason");
    Object localObject = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
    localObject = com.tencent.mm.plugin.finder.nearby.base.d.a.JA(dlr());
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQs = System.currentTimeMillis();
    Log.i("NearbyTimeConsumingHelper-" + ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).dLS, "onVisible->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQs - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQm) + " \nonAttach->startFetch:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQn - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQm) + " \nstartFetch->startCgi:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQo - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQn) + " \nstartCgi->onCgiBack:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQp - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQo) + " \nonCgiBack->onFetchDone:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQq - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQp) + " \nonFetchDone->onViewUpdate:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQr - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQq) + " \nonViewUpdate->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQs - ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQr));
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQm = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQn = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQo = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQp = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQq = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQr = 0L;
    ((com.tencent.mm.plugin.finder.nearby.base.d)localObject).uQs = 0L;
    if (paramc.Rmk <= 0)
    {
      localObject = this.uQT;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      ((b.b)localObject).dcQ().b(0L, (kotlin.g.a.a)j.uRh);
    }
    if (paramc.Rmj)
    {
      localObject = this.uQT;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      localObject = ((b.b)localObject).dcQ();
      if (localObject == null) {
        break label644;
      }
      localObject = Boolean.valueOf(((RefreshLoadMoreLayout)localObject).RlV);
      if (!((Boolean)localObject).booleanValue())
      {
        localObject = this.uQT;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
        }
        localObject = this.uQT;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131303685);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
          }
        }
        localObject = this.uQT;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131303684);
            if (localObject != null) {
              ((View)localObject).setVisibility(8);
            }
          }
        }
      }
      localObject = this.uQT;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      localObject = ((b.b)localObject).dcQ();
      if (localObject == null) {
        break label649;
      }
    }
    label644:
    label649:
    for (localObject = Boolean.valueOf(((RefreshLoadMoreLayout)localObject).getEnableLoadMore());; localObject = null)
    {
      if (!((Boolean)localObject).booleanValue())
      {
        localObject = this.uQT;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setEnableLoadMore(true);
        }
        localObject = this.uQT;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          View localView = aa.jQ((Context)this.activity).inflate(2131495297, null);
          p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
          ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
        }
      }
      checkEmptyHeader(paramc);
      paramc = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramc).getRedDotManager().asV("NearbyLiveTab");
      paramc = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramc).getRedDotManager().gI("NearbyLiveTab", "onRefreshEnd");
      AppMethodBeat.o(249084);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249089);
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
    com.tencent.mm.plugin.finder.nearby.base.d.a.JA(dlr()).uQm = System.currentTimeMillis();
    int i;
    if (this.firstAttach)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.l.vVE;
      if (!com.tencent.mm.plugin.finder.utils.l.dBJ()) {
        break label137;
      }
      localObject1 = this.uQU;
      if (localObject1 == null) {
        p.hyc();
      }
      int j = dlr();
      Object localObject2 = this.uQK;
      if (localObject2 == null) {
        break label129;
      }
      com.tencent.mm.plugin.finder.nearby.live.square.tab.a locala = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
      localObject2 = ((axj)localObject2).LHR;
      if (localObject2 == null) {
        p.hyc();
      }
      p.g(localObject2, "tabInfo.tab_name!!");
      i = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.aul((String)localObject2);
      label102:
      if (i == -1) {
        break label135;
      }
      ((NearbyLiveFeedLoader)localObject1).a(j, i, this.uQK);
    }
    for (;;)
    {
      this.firstAttach = false;
      AppMethodBeat.o(249089);
      return;
      label129:
      i = dlq();
      break label102;
      label135:
      break;
      label137:
      localObject1 = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject1).Rmh = -2;
      checkEmptyHeader((RefreshLoadMoreLayout.c)localObject1);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(249057);
      this.$rlLayout.DD(this.$isSilence);
      AppMethodBeat.o(249057);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(d paramd, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$1$1$1", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$$special$$inlined$let$lambda$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(axj paramaxj1, axj paramaxj2, d.c paramc, RefreshLoadMoreLayout.c paramc1)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements h
  {
    d(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, d paramd, boolean paramBoolean) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(249061);
      Log.i(this.uRb.getTAG(), "[initData] canTimelineRefresh=" + bool + ", incrementCount=" + paramInt);
      if (bool)
      {
        jdField_this.ED(0L);
        AppMethodBeat.o(249061);
        return;
      }
      Object localObject = d.c(jdField_this).Mq(jdField_this.dlr());
      int i = ((FinderHomeTabStateVM.a)localObject).wue;
      final int j = ((FinderHomeTabStateVM.a)localObject).wuf;
      final int k = ((FinderHomeTabStateVM.a)localObject).wug;
      Log.i(this.uRb.getTAG(), "[initData] canTimelineRefresh " + bool + " lastRootScrollPy:" + i + " lastPos=" + j + " fromTopPixel=" + k);
      RecyclerView localRecyclerView = jdField_this.dlp().getRecyclerView();
      if (localRecyclerView != null) {}
      for (localObject = localRecyclerView.getLayoutManager();; localObject = null)
      {
        d.a(jdField_this, k);
        if ((localObject instanceof StaggeredGridLayoutManager))
        {
          ((StaggeredGridLayoutManager)localObject).ah(j, k);
          if (localRecyclerView != null) {
            localRecyclerView.post((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249060);
                ((StaggeredGridLayoutManager)this.$layoutManager).ah(j, k);
                AppMethodBeat.o(249060);
              }
            });
          }
        }
        if (paramInt <= 0) {
          d.d(jdField_this);
        }
        AppMethodBeat.o(249061);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    e(NearbyLiveFeedLoader paramNearbyLiveFeedLoader)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(249064);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(249064);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(249063);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = this.uQX;
      d.a((d)localObject, d.b((d)localObject) - paramInt2);
      Log.d("Finder.NearbyLivePresenter", "onScrolled totalDy:" + d.b(this.uQX) + " dy:" + paramInt2);
      localObject = k.vkd;
      k.a(paramRecyclerView, s.p.voA, String.valueOf(this.uQX.getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.vje, -100, -100);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(249063);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final j uRh;
    
    static
    {
      AppMethodBeat.i(249072);
      uRh = new j();
      AppMethodBeat.o(249072);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$viewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(249073);
      Object localObject1 = this.uQX.dlp().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(249073);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(249074);
      Object localObject = this.uQX.dlp();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(249074);
          return;
        }
      }
      AppMethodBeat.o(249074);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(249075);
      Object localObject = this.uQX.dlp();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(249075);
            return;
          }
        }
      }
      AppMethodBeat.o(249075);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(249076);
      Object localObject = this.uQX.dlp();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(249076);
            return;
          }
        }
      }
      AppMethodBeat.o(249076);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(249077);
      Object localObject = this.uQX.dlp();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter == null) {
            break label89;
          }
        }
      }
      label89:
      for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
        localObject = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
        com.tencent.mm.plugin.finder.nearby.base.d.a.JA(this.uQX.dlr()).uQr = System.currentTimeMillis();
        AppMethodBeat.o(249077);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(249078);
      Object localObject = this.uQX.dlp();
      if (localObject != null)
      {
        localObject = ((b.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(249078);
            return;
          }
        }
      }
      AppMethodBeat.o(249078);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249080);
      p.h(paramc, "reason");
      this.uQX.dlp().dcQ().onPreFinishLoadMore(paramc);
      AppMethodBeat.o(249080);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249081);
      p.h(paramc, "reason");
      this.uQX.dlp().dcQ().onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(249081);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249079);
      p.h(paramc, "reason");
      this.uQX.dlp().dcQ().onPreFinishRefresh(paramc);
      AppMethodBeat.o(249079);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.d
 * JD-Core Version:    0.7.0.1
 */