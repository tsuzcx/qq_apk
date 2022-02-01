package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class s
  implements aq, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, d.c<e>, d.d<e>
{
  public static final s.a seU;
  final ArrayList<com.tencent.mm.plugin.finder.model.p> data;
  private int fVS;
  boolean hAF;
  private volatile com.tencent.mm.bw.b lastBuffer;
  com.tencent.mm.bw.b likeBuffer;
  public FinderItem scK;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> scf;
  private boolean sdm;
  private boolean sdn;
  private com.tencent.mm.loader.g.i sdq;
  final String seP;
  com.tencent.mm.plugin.finder.view.builder.a seQ;
  public boolean seR;
  public boolean seS;
  private final d seT;
  
  static
  {
    AppMethodBeat.i(202407);
    seU = new s.a((byte)0);
    AppMethodBeat.o(202407);
  }
  
  public s()
  {
    AppMethodBeat.i(202406);
    this.data = new ArrayList();
    this.seP = v.aAC();
    this.sdn = true;
    this.scf = new CopyOnWriteArraySet();
    this.seT = new d(this);
    AppMethodBeat.o(202406);
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(202389);
    Object localObject = this.seQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        AppMethodBeat.o(202389);
        return localObject;
      }
    }
    AppMethodBeat.o(202389);
    return null;
  }
  
  private final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(202390);
    this.sdn = paramBoolean;
    ae.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(202390);
  }
  
  public final void A(final d.g.a.b<? super LinkedList<apg>, ? extends LinkedList<apg>> paramb)
  {
    AppMethodBeat.i(202393);
    com.tencent.mm.loader.g.i locali = this.sdq;
    if (locali != null)
    {
      locali.a(new com.tencent.mm.loader.g.h((d.g.a.b)new g(this, paramb)));
      AppMethodBeat.o(202393);
      return;
    }
    AppMethodBeat.o(202393);
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(202405);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramFrameLayout, "headerLayout");
    AppMethodBeat.o(202405);
  }
  
  public void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(202391);
    d.g.b.p.h(parama, "builder");
    d.g.b.p.h(paramFinderItem, "feedObj");
    this.scK = paramFinderItem;
    this.likeBuffer = paramb;
    this.sdq = new com.tencent.mm.loader.g.i("FinderLikeExecutor");
    this.seQ = parama;
    ae.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId());
    paramFinderItem = this.sdq;
    if (paramFinderItem != null) {
      paramFinderItem.start();
    }
    cCX();
    this.data.clear();
    try
    {
      paramFinderItem = parama.cEX().getRecyclerView().getAdapter();
      if (paramFinderItem != null) {
        paramFinderItem.a((RecyclerView.c)this.seT);
      }
    }
    catch (IllegalStateException paramFinderItem)
    {
      for (;;)
      {
        ae.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramFinderItem, "", new Object[0]);
      }
    }
    parama.cQt();
    paramFinderItem = this.seQ;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.cCy();
      if (paramFinderItem != null) {
        paramFinderItem.fUI();
      }
    }
    parama.cEX().getRecyclerView().setLayoutFrozen(false);
    parama.cEX().setActionCallback((RefreshLoadMoreLayout.a)new f(this));
    parama = this.seQ;
    if (parama != null) {
      parama.hideLoading();
    }
    parama = this.seQ;
    if (parama != null) {
      parama.showLoading();
    }
    A(null);
    if (!this.sdn)
    {
      parama = this.seQ;
      if (parama != null)
      {
        parama = parama.cEX();
        if (parama != null) {
          RefreshLoadMoreLayout.f(parama);
        }
      }
    }
    this.hAF = true;
    AppMethodBeat.o(202391);
  }
  
  public c cCV()
  {
    AppMethodBeat.i(202400);
    c localc = (c)new b(this);
    AppMethodBeat.o(202400);
    return localc;
  }
  
  public final int cCW()
  {
    return this.fVS;
  }
  
  public final void cCX()
  {
    AppMethodBeat.i(202396);
    Object localObject2;
    if (this.fVS <= 0)
    {
      localObject1 = this.seQ;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).cQs();
        if (localObject2 != null)
        {
          localObject1 = getResources();
          if (localObject1 != null) {}
          for (localObject1 = ((Resources)localObject1).getString(2131766432);; localObject1 = null)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            AppMethodBeat.o(202396);
            return;
          }
        }
      }
      AppMethodBeat.o(202396);
      return;
    }
    Object localObject1 = f.sLy;
    localObject1 = this.scK;
    if (localObject1 == null) {
      d.g.b.p.bdF("feedObj");
    }
    localObject1 = f.FV(((FinderItem)localObject1).getFeedObject().objectType);
    int i;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((aqo)localObject1).GHs;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label219;
        }
      }
    }
    else
    {
      localObject1 = this.seQ;
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).getContext();
      if (localObject1 == null) {
        break label214;
      }
      localObject1 = ((Context)localObject1).getString(2131766433, new Object[] { com.tencent.mm.plugin.finder.utils.h.Gf(this.fVS) });
    }
    for (;;)
    {
      localObject2 = this.seQ;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject2).cQs();
      if (localObject2 == null) {
        break label247;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      AppMethodBeat.o(202396);
      return;
      i = 0;
      break;
      label214:
      localObject1 = null;
      continue;
      label219:
      localObject1 = com.tencent.mm.plugin.finder.utils.h.Gf(this.fVS) + ((aqo)localObject1).GHs;
    }
    label247:
    AppMethodBeat.o(202396);
  }
  
  public RecyclerView.h eO(Context paramContext)
  {
    AppMethodBeat.i(202401);
    d.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.h)new s.c();
    AppMethodBeat.o(202401);
    return paramContext;
  }
  
  public RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202403);
    d.g.b.p.h(paramContext, "context");
    paramContext = (RecyclerView.i)new LinearLayoutManager(1);
    AppMethodBeat.o(202403);
    return paramContext;
  }
  
  public WxRecyclerAdapter<?> eQ(Context paramContext)
  {
    AppMethodBeat.i(202395);
    d.g.b.p.h(paramContext, "context");
    paramContext = new WxRecyclerAdapter(cCV(), this.data, true);
    paramContext.av(false);
    paramContext.LRY = ((d.c)this);
    paramContext.LRX = ((d.d)this);
    AppMethodBeat.o(202395);
    return paramContext;
  }
  
  public void ee(View paramView)
  {
    AppMethodBeat.i(202404);
    d.g.b.p.h(paramView, "view");
    AppMethodBeat.o(202404);
  }
  
  public final FinderItem getFeedObj()
  {
    AppMethodBeat.i(202388);
    FinderItem localFinderItem = this.scK;
    if (localFinderItem == null) {
      d.g.b.p.bdF("feedObj");
    }
    AppMethodBeat.o(202388);
    return localFinderItem;
  }
  
  public int getScene()
  {
    AppMethodBeat.i(202402);
    FinderLikeDrawer.a locala = FinderLikeDrawer.tgd;
    int i = FinderLikeDrawer.cQe();
    AppMethodBeat.o(202402);
    return i;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(202399);
    this.scf.add(parama);
    AppMethodBeat.o(202399);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(202392);
    if (!this.hAF)
    {
      ae.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
      AppMethodBeat.o(202392);
      return;
    }
    this.hAF = false;
    Object localObject = this.sdq;
    if (localObject != null) {
      ((com.tencent.mm.loader.g.i)localObject).stop();
    }
    this.sdq = null;
    localObject = ((Iterable)this.scf).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.scf.clear();
    this.data.clear();
    this.lastBuffer = null;
    this.sdm = false;
    ae.i("Finder.DrawerPresenter", "set upContinue false");
    lQ(true);
    localObject = this.seQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cEX();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    localObject = this.seQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cEX();
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
    localObject = this.seQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cEX();
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setLayoutFrozen(true);
        }
      }
    }
    localObject = this.seQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.view.builder.a)localObject).cEX();
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setActionCallback(null);
      }
    }
    this.seQ = null;
    AppMethodBeat.o(202392);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(202369);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new m(s.f(this.seV), (d.g.a.a)new a(this), (d.g.a.b)new b(this), (d.g.a.a)new c(this));
      AppMethodBeat.o(202369);
      return localb;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<Boolean>
    {
      a(s.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "like", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.b<Boolean, z>
    {
      b(s.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(s.b paramb)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202373);
      super.at(paramInt1, paramInt2);
      this.seV.cCX();
      AppMethodBeat.o(202373);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202372);
      super.au(paramInt1, paramInt2);
      this.seV.cCX();
      AppMethodBeat.o(202372);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202375);
      super.av(paramInt1, paramInt2);
      this.seV.cCX();
      AppMethodBeat.o(202375);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202374);
      super.f(paramInt1, paramInt2, paramObject);
      this.seV.cCX();
      AppMethodBeat.o(202374);
    }
    
    @SuppressLint({"StringFormatMatches"})
    public final void onChanged()
    {
      AppMethodBeat.i(202371);
      super.onChanged();
      this.seV.cCX();
      AppMethodBeat.o(202371);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.loader.g.h, z>
  {
    e(s params)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202382);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202382);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202381);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      d.g.b.p.h(paramc, "reason");
      super.a(paramc);
      s.c(this.seV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202381);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202383);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202383);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(202380);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      com.tencent.e.h.MqF.aO((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202380);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(202379);
        s.b(this.seY.seV);
        AppMethodBeat.o(202379);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s
 * JD-Core Version:    0.7.0.1
 */