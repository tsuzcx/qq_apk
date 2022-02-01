package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class q
  implements ak, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c, d.d
{
  public static final q.a rid;
  final ArrayList<n> data;
  private int fAw;
  private volatile com.tencent.mm.bw.b lastBuffer;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private boolean rgB;
  private boolean rgC;
  private r rgF;
  public FinderItem rgw;
  com.tencent.mm.plugin.finder.view.builder.a rib;
  private final d ric;
  
  static
  {
    AppMethodBeat.i(201740);
    rid = new q.a((byte)0);
    AppMethodBeat.o(201740);
  }
  
  public q()
  {
    AppMethodBeat.i(201739);
    this.data = new ArrayList();
    this.rgC = true;
    this.rfP = new CopyOnWriteArraySet();
    this.ric = new d(this);
    AppMethodBeat.o(201739);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(201722);
    Object localObject = this.rib;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(201722);
        return localObject;
      }
    }
    AppMethodBeat.o(201722);
    return null;
  }
  
  private final void lv(boolean paramBoolean)
  {
    AppMethodBeat.i(201723);
    this.rgC = paramBoolean;
    ac.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(201723);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(201738);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(201738);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(201724);
    k.h(parama, "builder");
    k.h(paramFinderItem, "feedObj");
    this.rgw = paramFinderItem;
    this.rgF = new r("FinderLikeExecutor");
    this.rib = parama;
    ac.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.rgF;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    cuU();
    this.data.clear();
    try
    {
      paramFinderItem = parama.cwM().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.ric);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        ac.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
      AppMethodBeat.o(201724);
    }
    parama.cFn();
    paramFinderItem = this.rib;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.cuA();
      if (paramFinderItem != null) {
        paramFinderItem.fzd();
      }
    }
    parama.cwM().getRecyclerView().setLayoutFrozen(false);
    parama.cwM().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    parama = this.rib;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.rib;
    if (parama != null) {
      parama.showLoading();
    }
    z(null);
    if (!this.rgC)
    {
      parama = this.rib;
      if (parama != null)
      {
        parama = parama.cwM();
        if (parama != null)
        {
          RefreshLoadMoreLayout.f(parama);
          AppMethodBeat.o(201724);
          return;
        }
      }
    }
  }
  
  public void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201731);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(201731);
  }
  
  public final boolean c(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201730);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(201730);
    return false;
  }
  
  public c cuS()
  {
    AppMethodBeat.i(201733);
    c localc = (c)new c();
    AppMethodBeat.o(201733);
    return localc;
  }
  
  public final int cuT()
  {
    return this.fAw;
  }
  
  public final void cuU()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(201729);
    Object localObject3;
    if (this.fAw <= 0)
    {
      localObject2 = this.rib;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).cFm();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(2131766432);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(201729);
          return;
        }
      }
      AppMethodBeat.o(201729);
      return;
    }
    localObject1 = this.rib;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cFm();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131766433, new Object[] { g.Ex(this.fAw) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(201729);
        return;
      }
    }
    AppMethodBeat.o(201729);
  }
  
  public void dY(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(201737);
    k.h(paramView, "view");
    Object localObject2 = paramView.getLayoutParams();
    paramView = (View)localObject2;
    if (!(localObject2 instanceof CoordinatorLayout.d)) {
      paramView = null;
    }
    localObject2 = (CoordinatorLayout.d)paramView;
    if (localObject2 != null)
    {
      paramView = this.rib;
      if (paramView != null) {}
      for (paramView = paramView.getContext();; paramView = null)
      {
        ((CoordinatorLayout.d)localObject2).setMarginStart(com.tencent.mm.cc.a.fromDPToPix(paramView, 24));
        com.tencent.mm.plugin.finder.view.builder.a locala = this.rib;
        paramView = localObject1;
        if (locala != null) {
          paramView = locala.getContext();
        }
        ((CoordinatorLayout.d)localObject2).setMarginEnd(com.tencent.mm.cc.a.fromDPToPix(paramView, 24));
        paramView = this.rib;
        if (paramView != null)
        {
          paramView = paramView.cwM();
          if (paramView != null) {
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        paramView = this.rib;
        if (paramView == null) {
          break;
        }
        paramView = paramView.cwM();
        if (paramView == null) {
          break;
        }
        paramView.invalidate();
        AppMethodBeat.o(201737);
        return;
      }
      AppMethodBeat.o(201737);
      return;
    }
    AppMethodBeat.o(201737);
  }
  
  public RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(201734);
    k.h(paramContext, "context");
    Resources localResources = paramContext.getResources();
    k.g(localResources, "context.resources");
    paramContext = (RecyclerView.h)new q.b((localResources.getDisplayMetrics().widthPixels - com.tencent.mm.cc.a.fromDPToPix(paramContext, 24) * 2 - com.tencent.mm.cc.a.av(paramContext, 2131165298) * 5) / 20);
    AppMethodBeat.o(201734);
    return paramContext;
  }
  
  public RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201736);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.i)new GridLayoutManager(5);
    AppMethodBeat.o(201736);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(201728);
    k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cuS(), this.data, true);
    paramContext.av(false);
    paramContext.JCe = ((d.c)this);
    paramContext.JCd = ((d.d)this);
    AppMethodBeat.o(201728);
    return paramContext;
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(201721);
    FinderItem localFinderItem = this.rgw;
    if (localFinderItem == null) {
      k.aVY("feedObj");
    }
    AppMethodBeat.o(201721);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(201735);
    FinderLikeDrawer.a locala = FinderLikeDrawer.rXU;
    int i = FinderLikeDrawer.cFa();
    AppMethodBeat.o(201735);
    return i;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(201732);
    this.rfP.add(parama);
    AppMethodBeat.o(201732);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(201725);
    Object localObject = this.rgF;
    if (localObject != null) {
      ((r)localObject).stop();
    }
    this.rgF = null;
    localObject = ((Iterable)this.rfP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rfP.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.rgB = false;
    ac.i("Finder.DrawerPresenter", "set upContinue false");
    lv(true);
    localObject = this.rib;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cwM();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.rib;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cwM();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).notifyDataSetChanged();
          }
        }
      }
    }
    localObject = this.rib;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cwM();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setLayoutFrozen(true);
        }
      }
    }
    localObject = this.rib;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cwM();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.rib = null;
    AppMethodBeat.o(201725);
  }
  
  public final void z(final d.g.a.b<? super LinkedList<alo>, ? extends LinkedList<alo>> paramb)
  {
    AppMethodBeat.i(201726);
    r localr = this.rgF;
    if (localr != null)
    {
      localr.a(new com.tencent.mm.plugin.finder.utils.q((d.g.a.b)new g(this, paramb)));
      AppMethodBeat.o(201726);
      return;
    }
    AppMethodBeat.o(201726);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(201703);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.l();
      AppMethodBeat.o(201703);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201706);
      super.as(paramInt1, paramInt2);
      this.rif.cuU();
      AppMethodBeat.o(201706);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201705);
      super.at(paramInt1, paramInt2);
      this.rif.cuU();
      AppMethodBeat.o(201705);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201708);
      super.au(paramInt1, paramInt2);
      this.rif.cuU();
      AppMethodBeat.o(201708);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201707);
      super.f(paramInt1, paramInt2, paramObject);
      this.rif.cuU();
      AppMethodBeat.o(201707);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(201704);
      super.onChanged();
      this.rif.cuU();
      AppMethodBeat.o(201704);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.q, y>
  {
    e(q paramq)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201715);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201715);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201714);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.a(paramc);
      q.c(this.rif);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201714);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201716);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201716);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201713);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      h.JZN.aS((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201713);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(q.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(201712);
        q.b(this.rih.rif);
        AppMethodBeat.o(201712);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.q, y>
  {
    g(q paramq, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q
 * JD-Core Version:    0.7.0.1
 */