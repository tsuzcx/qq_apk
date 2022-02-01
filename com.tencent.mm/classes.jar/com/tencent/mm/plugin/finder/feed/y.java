package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class y
  implements ak, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c, d.d
{
  public static final a KNI;
  com.tencent.mm.plugin.finder.view.builder.b KNG;
  private final d KNH;
  final ArrayList<z> data;
  private int fwP;
  private volatile com.tencent.mm.bx.b lastBuffer;
  private boolean quA;
  private m quD;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  public FinderItem quu;
  private boolean quz;
  
  static
  {
    AppMethodBeat.i(197843);
    KNI = new a((byte)0);
    AppMethodBeat.o(197843);
  }
  
  public y()
  {
    AppMethodBeat.i(197842);
    this.data = new ArrayList();
    this.quA = true;
    this.quc = new CopyOnWriteArraySet();
    this.KNH = new d(this);
    AppMethodBeat.o(197842);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(197825);
    Object localObject = this.KNG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(197825);
        return localObject;
      }
    }
    AppMethodBeat.o(197825);
    return null;
  }
  
  private final void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(197826);
    this.quA = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(197826);
  }
  
  public final void G(final d.g.a.b<? super LinkedList<dzd>, ? extends LinkedList<dzd>> paramb)
  {
    AppMethodBeat.i(197829);
    m localm = this.quD;
    if (localm != null)
    {
      localm.a(new com.tencent.mm.plugin.finder.utils.l((d.g.a.b)new g(this, paramb)));
      AppMethodBeat.o(197829);
      return;
    }
    AppMethodBeat.o(197829);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(197841);
    k.h(paramContext, "context");
    k.h(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(197841);
  }
  
  public void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(197834);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(197834);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.b paramb, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(197827);
    k.h(paramb, "builder");
    k.h(paramFinderItem, "feedObj");
    this.quu = paramFinderItem;
    this.quD = new m("FinderLikeExecutor");
    this.KNG = paramb;
    ad.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.quD;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    fTl();
    this.data.clear();
    try
    {
      paramFinderItem = paramb.cny().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.KNH);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        ad.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
      AppMethodBeat.o(197827);
    }
    paramb.fXa();
    paramFinderItem = this.KNG;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.fSZ();
      if (paramFinderItem != null) {
        paramFinderItem.fiP();
      }
    }
    paramb.cny().getRecyclerView().setLayoutFrozen(false);
    paramb.cny().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    paramb = this.KNG;
    if (paramb != null) {
      paramb.hideLoading();
    }
    paramb = this.KNG;
    if (paramb != null) {
      paramb.showLoading();
    }
    G(null);
    if (!this.quA)
    {
      paramb = this.KNG;
      if (paramb != null)
      {
        paramb = paramb.cny();
        if (paramb != null)
        {
          RefreshLoadMoreLayout.c(paramb);
          AppMethodBeat.o(197827);
          return;
        }
      }
    }
  }
  
  public final boolean b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(197833);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    AppMethodBeat.o(197833);
    return false;
  }
  
  public RecyclerView.h eC(Context paramContext)
  {
    AppMethodBeat.i(197837);
    k.h(paramContext, "context");
    Resources localResources = paramContext.getResources();
    k.g(localResources, "context.resources");
    paramContext = (RecyclerView.h)new b((localResources.getDisplayMetrics().widthPixels - com.tencent.mm.cd.a.fromDPToPix(paramContext, 24) * 2 - com.tencent.mm.cd.a.ap(paramContext, 2131165298) * 5) / 20);
    AppMethodBeat.o(197837);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> eD(Context paramContext)
  {
    AppMethodBeat.i(197831);
    k.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(fTj(), this.data, true);
    paramContext.av(false);
    paramContext.Ibo = ((d.c)this);
    paramContext.Ibn = ((d.d)this);
    AppMethodBeat.o(197831);
    return paramContext;
  }
  
  public c fTj()
  {
    AppMethodBeat.i(197836);
    c localc = (c)new c();
    AppMethodBeat.o(197836);
    return localc;
  }
  
  public final int fTk()
  {
    return this.fwP;
  }
  
  public final void fTl()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(197832);
    Object localObject3;
    if (this.fwP <= 0)
    {
      localObject2 = this.KNG;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).csV();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(2131766419);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(197832);
          return;
        }
      }
      AppMethodBeat.o(197832);
      return;
    }
    localObject1 = this.KNG;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).csV();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131766420, new Object[] { e.Df(this.fwP) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(197832);
        return;
      }
    }
    AppMethodBeat.o(197832);
  }
  
  public void gO(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(197840);
    k.h(paramView, "view");
    Object localObject2 = paramView.getLayoutParams();
    paramView = (View)localObject2;
    if (!(localObject2 instanceof CoordinatorLayout.d)) {
      paramView = null;
    }
    localObject2 = (CoordinatorLayout.d)paramView;
    if (localObject2 != null)
    {
      paramView = this.KNG;
      if (paramView != null) {}
      for (paramView = paramView.getContext();; paramView = null)
      {
        ((CoordinatorLayout.d)localObject2).setMarginStart(com.tencent.mm.cd.a.fromDPToPix(paramView, 24));
        com.tencent.mm.plugin.finder.view.builder.b localb = this.KNG;
        paramView = localObject1;
        if (localb != null) {
          paramView = localb.getContext();
        }
        ((CoordinatorLayout.d)localObject2).setMarginEnd(com.tencent.mm.cd.a.fromDPToPix(paramView, 24));
        paramView = this.KNG;
        if (paramView != null)
        {
          paramView = paramView.cny();
          if (paramView != null) {
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        paramView = this.KNG;
        if (paramView == null) {
          break;
        }
        paramView = paramView.cny();
        if (paramView == null) {
          break;
        }
        paramView.invalidate();
        AppMethodBeat.o(197840);
        return;
      }
      AppMethodBeat.o(197840);
      return;
    }
    AppMethodBeat.o(197840);
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(197824);
    FinderItem localFinderItem = this.quu;
    if (localFinderItem == null) {
      k.aPZ("feedObj");
    }
    AppMethodBeat.o(197824);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(197838);
    FinderLikeDrawer.a locala = FinderLikeDrawer.Lfb;
    int i = FinderLikeDrawer.fWR();
    AppMethodBeat.o(197838);
    return i;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(197835);
    this.quc.add(parama);
    AppMethodBeat.o(197835);
  }
  
  public RecyclerView.i lw(Context paramContext)
  {
    AppMethodBeat.i(197839);
    k.h(paramContext, "context");
    paramContext = (RecyclerView.i)new GridLayoutManager(5);
    AppMethodBeat.o(197839);
    return paramContext;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(197828);
    Object localObject = this.quD;
    if (localObject != null) {
      ((m)localObject).stop();
    }
    this.quD = null;
    localObject = ((Iterable)this.quc).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.quc.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.quz = false;
    ad.i("Finder.DrawerPresenter", "set upContinue false");
    kS(true);
    localObject = this.KNG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cny();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.KNG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cny();
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
    localObject = this.KNG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cny();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setLayoutFrozen(true);
        }
      }
    }
    localObject = this.KNG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).cny();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.KNG = null;
    AppMethodBeat.o(197828);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$SpaceItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "column", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  static final class b
    extends RecyclerView.h
  {
    private final int column;
    private final int qwE;
    
    public b(int paramInt)
    {
      this.qwE = paramInt;
      this.column = 5;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(197805);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      paramRect.left = (RecyclerView.bw(paramView) % this.column * this.qwE);
      AppMethodBeat.o(197805);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(197806);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new ab();
      AppMethodBeat.o(197806);
      return localb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197809);
      super.as(paramInt1, paramInt2);
      this.KNJ.fTl();
      AppMethodBeat.o(197809);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197808);
      super.at(paramInt1, paramInt2);
      this.KNJ.fTl();
      AppMethodBeat.o(197808);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197811);
      super.au(paramInt1, paramInt2);
      this.KNJ.fTl();
      AppMethodBeat.o(197811);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(197810);
      super.f(paramInt1, paramInt2, paramObject);
      this.KNJ.fTl();
      AppMethodBeat.o(197810);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(197807);
      super.onChanged();
      this.KNJ.fTl();
      AppMethodBeat.o(197807);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, d.y>
  {
    e(y paramy)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197817);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.a(paramc);
      y.c(this.KNJ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197817);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(197818);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(197818);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(197819);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197819);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(197816);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      h.Iye.aP((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(197816);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(y.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(197815);
        y.b(this.KNL.KNJ);
        AppMethodBeat.o(197815);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, d.y>
  {
    g(y paramy, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y
 * JD-Core Version:    0.7.0.1
 */