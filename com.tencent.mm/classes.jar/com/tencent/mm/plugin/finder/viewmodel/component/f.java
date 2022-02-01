package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.hs;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.b;
import com.tencent.mm.plugin.finder.feed.model.internal.m.c;
import com.tencent.mm.plugin.finder.feed.model.internal.m.d;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "atFeedManageGroup", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1;", "atFeedState", "Lcom/tencent/mm/plugin/finder/viewmodel/atfeed/AtFeedState;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "username", "", "initLoader", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refresh", "isShouldSelect", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class f
  extends UIComponent
{
  public static final a Bis;
  private final d Biq;
  private final m Bir;
  private String username;
  private final kotlin.f xDO;
  public FinderAtFeedLoader xLy;
  private final bid xbu;
  private final kotlin.f xjx;
  private final com.tencent.mm.plugin.finder.viewmodel.atfeed.a xnZ;
  private final kotlin.f zQB;
  private final kotlin.f zQC;
  private final kotlin.f zQD;
  private final kotlin.f zQE;
  private final kotlin.f zQF;
  
  static
  {
    AppMethodBeat.i(270337);
    Bis = new a((byte)0);
    AppMethodBeat.o(270337);
  }
  
  public f(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(270336);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    this.xbu = ((aj)com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(aj.class)).ekY();
    String str = getIntent().getStringExtra("KEY_PARAMS_USERNAME");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.username = ((String)localObject);
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.xnZ = new com.tencent.mm.plugin.finder.viewmodel.atfeed.a();
    this.zQB = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new j(this, paramAppCompatActivity));
    this.zQF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.zQE = kotlin.g.ar((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.xDO = kotlin.g.ar((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.Biq = new d(this);
    this.Bir = new m(this);
    AppMethodBeat.o(270336);
  }
  
  private final com.tencent.mm.plugin.finder.storage.b ekq()
  {
    AppMethodBeat.i(270324);
    com.tencent.mm.plugin.finder.storage.b localb = (com.tencent.mm.plugin.finder.storage.b)this.zQB.getValue();
    AppMethodBeat.o(270324);
    return localb;
  }
  
  private final b ekr()
  {
    AppMethodBeat.i(270325);
    b localb = (b)this.zQF.getValue();
    AppMethodBeat.o(270325);
    return localb;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(270327);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(270327);
    return localRecyclerView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(270326);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(270326);
    return localRefreshLoadMoreLayout;
  }
  
  public final FinderAtFeedLoader ekp()
  {
    AppMethodBeat.i(270322);
    FinderAtFeedLoader localFinderAtFeedLoader = this.xLy;
    if (localFinderAtFeedLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(270322);
    return localFinderAtFeedLoader;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270331);
    super.onCreate(paramBundle);
    this.xLy = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g.xKE, this.username, this.xbu);
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.register((com.tencent.mm.view.j)ekr());
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setSuperNestedScroll(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    paramBundle = getRlLayout();
    Object localObject1 = ad.kS((Context)getActivity()).inflate(b.g.load_more_footer, null);
    p.j(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)this.zQC.getValue());
    getRecyclerView().b(ekq().getItemDecoration());
    paramBundle = getRecyclerView();
    localObject1 = ekq();
    Object localObject2 = getActivity();
    if (localObject2 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(270331);
      throw paramBundle;
    }
    paramBundle.setRecycledViewPool(((com.tencent.mm.plugin.finder.storage.b)localObject1).g((MMActivity)localObject2));
    paramBundle = getRecyclerView();
    localObject1 = ekq().dtg();
    localObject2 = this.xLy;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)localObject1, (ArrayList)((FinderAtFeedLoader)localObject2).getDataListJustForAdapter()));
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new e(this));
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.xEI = ((kotlin.g.a.a)new f(this));
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    BaseFeedLoader.requestInit$default(paramBundle, false, 1, null);
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.requestRefresh();
    paramBundle = this.xLy;
    if (paramBundle == null) {
      p.bGy("feedLoader");
    }
    paramBundle.xGJ = ((kotlin.g.a.b)new k(this));
    this.Bir.alive();
    paramBundle = m.xKK;
    paramBundle = (m.d)this.Biq;
    p.k(paramBundle, "owner");
    localObject1 = paramBundle.duD();
    if (m.duy().keySet().contains(localObject1))
    {
      localObject2 = (m.b)m.duy().get(localObject1);
      if (localObject2 != null) {
        ((m.b)localObject2).xKL = paramBundle;
      }
    }
    while (m.duy().keySet().contains(localObject1))
    {
      paramBundle = (m.b)m.duy().get(localObject1);
      if ((paramBundle == null) || (paramBundle.xKL == null)) {
        break;
      }
      paramBundle = paramBundle.xKM.iterator();
      while (paramBundle.hasNext()) {
        ((m.c)paramBundle.next()).duB();
      }
      localObject2 = (Map)m.duy();
      m.b localb = new m.b();
      localb.xKL = paramBundle;
      ((Map)localObject2).put(localObject1, localb);
    }
    Log.i("Finder.LoaderShareStore", "");
    AppMethodBeat.o(270331);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(270333);
    super.onDestroy();
    Object localObject1 = this.xLy;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    ((FinderAtFeedLoader)localObject1).unregister((com.tencent.mm.view.j)ekr());
    this.Bir.dead();
    localObject1 = m.xKK;
    localObject1 = (m.d)this.Biq;
    p.k(localObject1, "owner");
    localObject1 = ((m.d)localObject1).duD();
    if (m.duy().keySet().contains(localObject1))
    {
      m.b localb = (m.b)m.duy().get(localObject1);
      if (localb != null)
      {
        Object localObject2 = m.xKK;
        if (m.duy().keySet().contains(localObject1))
        {
          localObject2 = (m.b)m.duy().get(localObject1);
          if ((localObject2 != null) && (((m.b)localObject2).xKL != null))
          {
            localObject2 = ((m.b)localObject2).xKM.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((m.c)((Iterator)localObject2).next()).duC();
            }
          }
        }
        localObject2 = localb.xKM.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
        if (localb.xKM.isEmpty()) {
          m.duy().remove(localObject1);
        }
        AppMethodBeat.o(270333);
        return;
      }
      AppMethodBeat.o(270333);
      return;
    }
    Log.i("Finder.LoaderShareStore", "unregisterOwner not exit");
    AppMethodBeat.o(270333);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(270334);
    this.xnZ.BhC = paramBoolean;
    FinderAtFeedLoader localFinderAtFeedLoader = this.xLy;
    if (localFinderAtFeedLoader == null) {
      p.bGy("feedLoader");
    }
    localFinderAtFeedLoader.dispatcher().onChanged();
    AppMethodBeat.o(270334);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.view.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(270604);
      AppMethodBeat.o(270604);
    }
    
    public final void dFf()
    {
      AppMethodBeat.i(270603);
      d.a(0L, (kotlin.g.a.a)new a(this));
      AppMethodBeat.o(270603);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(f.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<f.b>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$atFeedManageGroup$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "dataSource", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "groupKey", "", "plugin-finder_release"})
  public static final class d
    extends m.d
  {
    public final String duD()
    {
      return "atFeedManage";
    }
    
    public final DataBuffer<bu> duE()
    {
      AppMethodBeat.i(279660);
      DataBuffer localDataBuffer = this.Bit.ekp().getDataListJustForAdapter();
      AppMethodBeat.o(279660);
      return localDataBuffer;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initLoader$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(275210);
      f.d(this.Bit).dFf();
      AppMethodBeat.o(275210);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(285954);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(285954);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(285953);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      paramc = com.tencent.mm.ui.component.g.Xox;
      localObject = (h)com.tencent.mm.ui.component.g.b(this.Bit.getActivity()).i(h.class);
      paramc = this.Bit.ekp().zsL;
      b localb = ((h)localObject).BiA;
      if (localb == null) {
        p.bGy("stateMachine");
      }
      if ((localb.BhD == b.d.BhN) || (localb.BhD == b.d.BhO))
      {
        Log.i("Finder.AtFeedSelectStateMachine", "onLoadMore update");
        if (paramc != null)
        {
          Iterator localIterator = ((Iterable)paramc).iterator();
          while (localIterator.hasNext())
          {
            localObject = (bu)localIterator.next();
            paramc = (RefreshLoadMoreLayout.c<Object>)localObject;
            if (!(localObject instanceof BaseFinderFeed)) {
              paramc = null;
            }
            paramc = (BaseFinderFeed)paramc;
            if (paramc != null) {
              ((Map)localb.BhF).put(Long.valueOf(paramc.mf()), Integer.valueOf(paramc.feedObject.getMentionListSelected()));
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285953);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(285952);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      this.Bit.ekp().requestLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(285952);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(285956);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285956);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderAtFeedManagerLayoutConfig;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.b>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    j(f paramf, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtFeedManageUIC$removeFeedEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class m
    extends IListener<hs>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.f
 * JD-Core Version:    0.7.0.1
 */