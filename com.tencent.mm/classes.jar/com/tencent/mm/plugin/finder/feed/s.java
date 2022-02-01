package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class s
  implements aq, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c<e>, d.d<e>
{
  public static final a rWk;
  public boolean EIC;
  final String EWS;
  public boolean GpL;
  final ArrayList<o> data;
  private int fTM;
  boolean hxR;
  private volatile com.tencent.mm.bx.b lastBuffer;
  com.tencent.mm.bx.b likeBuffer;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rTB;
  private boolean rUI;
  private boolean rUJ;
  private com.tencent.mm.loader.g.i rUM;
  public FinderItem rUg;
  com.tencent.mm.plugin.finder.view.builder.a rWi;
  private final d rWj;
  
  static
  {
    AppMethodBeat.i(201944);
    rWk = new a((byte)0);
    AppMethodBeat.o(201944);
  }
  
  public s()
  {
    AppMethodBeat.i(201943);
    this.data = new ArrayList();
    this.EWS = u.aAm();
    this.rUJ = true;
    this.rTB = new CopyOnWriteArraySet();
    this.rWj = new d(this);
    AppMethodBeat.o(201943);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(201926);
    Object localObject = this.rWi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(201926);
        return localObject;
      }
    }
    AppMethodBeat.o(201926);
    return null;
  }
  
  private final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(201927);
    this.rUJ = paramBoolean;
    ad.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(201927);
  }
  
  public final void A(final d.g.a.b<? super LinkedList<aot>, ? extends LinkedList<aot>> paramb)
  {
    AppMethodBeat.i(201930);
    com.tencent.mm.loader.g.i locali = this.rUM;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((d.g.a.b)new g(this, paramb)));
      AppMethodBeat.o(201930);
      return;
    }
    AppMethodBeat.o(201930);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(201942);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(201942);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(201928);
    p.h(parama, "builder");
    p.h(paramFinderItem, "feedObj");
    this.rUg = paramFinderItem;
    this.likeBuffer = paramb;
    this.rUM = new com.tencent.mm.loader.g.i("FinderLikeExecutor");
    this.rWi = parama;
    ad.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.rUM;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    cBl();
    this.data.clear();
    try
    {
      paramFinderItem = parama.cDf().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.rWj);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        ad.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
    }
    parama.cNJ();
    paramFinderItem = this.rWi;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.cAM();
      if (paramFinderItem != null) {
        paramFinderItem.fQm();
      }
    }
    parama.cDf().getRecyclerView().setLayoutFrozen(false);
    parama.cDf().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    parama = this.rWi;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.rWi;
    if (parama != null) {
      parama.showLoading();
    }
    A(null);
    if (!this.rUJ)
    {
      parama = this.rWi;
      if (parama != null)
      {
        parama = parama.cDf();
        if (parama != null) {
          RefreshLoadMoreLayout.f(parama);
        }
      }
    }
    this.hxR = true;
    AppMethodBeat.o(201928);
  }
  
  public c cBj()
  {
    AppMethodBeat.i(201937);
    c localc = (c)new b(this);
    AppMethodBeat.o(201937);
    return localc;
  }
  
  public final int cBk()
  {
    return this.fTM;
  }
  
  public final void cBl()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(201933);
    Object localObject3;
    if (this.fTM <= 0)
    {
      localObject2 = this.rWi;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).cNI();
        if (localObject2 != null)
        {
          localObject3 = getResources();
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getString(2131766432);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(201933);
          return;
        }
      }
      AppMethodBeat.o(201933);
      return;
    }
    localObject1 = this.rWi;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cNI();
      if (localObject3 != null)
      {
        Resources localResources = getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = localResources.getString(2131766433, new Object[] { com.tencent.mm.plugin.finder.utils.h.FH(this.fTM) });
        }
        ((TextView)localObject3).setText((CharSequence)localObject1);
        AppMethodBeat.o(201933);
        return;
      }
    }
    AppMethodBeat.o(201933);
  }
  
  public RecyclerView.h eK(Context paramContext)
  {
    AppMethodBeat.i(201938);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new c();
    AppMethodBeat.o(201938);
    return paramContext;
  }
  
  public RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201940);
    p.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(201940);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(201932);
    p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cBj(), this.data, true);
    paramContext.av(false);
    paramContext.Lvl = ((d.c)this);
    paramContext.Lvk = ((d.d)this);
    AppMethodBeat.o(201932);
    return paramContext;
  }
  
  public void ee(View paramView)
  {
    AppMethodBeat.i(201941);
    p.h(paramView, "view");
    AppMethodBeat.o(201941);
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(201925);
    FinderItem localFinderItem = this.rUg;
    if (localFinderItem == null) {
      p.bcb("feedObj");
    }
    AppMethodBeat.o(201925);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(201939);
    FinderLikeDrawer.a locala = FinderLikeDrawer.sUO;
    int i = FinderLikeDrawer.cNu();
    AppMethodBeat.o(201939);
    return i;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(201936);
    this.rTB.add(parama);
    AppMethodBeat.o(201936);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(201929);
    if (!this.hxR)
    {
      ad.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(201929);
      return;
    }
    this.hxR = false;
    Object localObject = this.rUM;
    if (localObject != null) {
      ((com.tencent.mm.loader.g.i)localObject).stop();
    }
    this.rUM = null;
    localObject = ((Iterable)this.rTB).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rTB.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.rUI = false;
    ad.i("Finder.DrawerPresenter", "set upContinue false");
    lQ(true);
    localObject = this.rWi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cDf();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.rWi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cDf();
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
    localObject = this.rWi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cDf();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setLayoutFrozen(true);
        }
      }
    }
    localObject = this.rWi;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cDf();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.rWi = null;
    AppMethodBeat.o(201929);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(201906);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new m(s.h(this.rWl), (d.g.a.a)new s.b.a(this), (d.g.a.b)new s.b.b(this), (d.g.a.a)new s.b.c(this));
      AppMethodBeat.o(201906);
      return localb;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(201907);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(201907);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201910);
      super.at(paramInt1, paramInt2);
      this.rWl.cBl();
      AppMethodBeat.o(201910);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201909);
      super.au(paramInt1, paramInt2);
      this.rWl.cBl();
      AppMethodBeat.o(201909);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201912);
      super.av(paramInt1, paramInt2);
      this.rWl.cBl();
      AppMethodBeat.o(201912);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201911);
      super.f(paramInt1, paramInt2, paramObject);
      this.rWl.cBl();
      AppMethodBeat.o(201911);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(201908);
      super.onChanged();
      this.rWl.cBl();
      AppMethodBeat.o(201908);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    e(s params)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(201919);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201919);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201918);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      s.c(this.rWl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201918);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201920);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201920);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(201917);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      com.tencent.e.h.LTJ.aR((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201917);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(201916);
        s.b(this.rWn.rWl);
        AppMethodBeat.o(201916);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    g(s params, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s
 * JD-Core Version:    0.7.0.1
 */