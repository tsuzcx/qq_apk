package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.report.q.b;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "initPos", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;I)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "getInitPos", "()I", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "plugin-finder_release"})
public final class t$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<t.b>
{
  private final String TAG;
  public RecyclerView fTr;
  public final MMActivity iMV;
  public RefreshLoadMoreLayout rfT;
  public d rgg;
  final int rht;
  public final t.b riE;
  private boolean riF;
  private final d.f riG;
  
  static
  {
    AppMethodBeat.i(165790);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "feedViewPool", "getFeedViewPool()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")) };
    AppMethodBeat.o(165790);
  }
  
  public t$c(MMActivity paramMMActivity, final t.b paramb, int paramInt)
  {
    AppMethodBeat.i(165792);
    this.iMV = paramMMActivity;
    this.rht = paramInt;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.riE = paramb;
    this.riF = true;
    this.riG = g.K((d.g.a.a)a.riJ);
    paramMMActivity = this.iMV.findViewById(2131304203);
    d.g.b.k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.rfT;
    if (paramMMActivity == null) {
      d.g.b.k.aVY("rlLayout");
    }
    this.fTr = paramMMActivity.getRecyclerView();
    paramMMActivity = this.fTr;
    if (paramMMActivity == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramMMActivity.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    paramMMActivity = this.fTr;
    if (paramMMActivity == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.n)this.riG.getValue());
    paramMMActivity = this.fTr;
    if (paramMMActivity == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new t.b.a(this.riE), (ArrayList)getModel().getDataListJustForAdapter()));
    this.rgg = ((d)new d()
    {
      public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165775);
        this.rhB.at(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(165775);
      }
      
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165771);
        t.c.f(this.riH).au(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = t.c.f(this.riH).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.cuV().requestLoadMore();
          }
          AppMethodBeat.o(165771);
          return;
        }
        AppMethodBeat.o(165771);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165777);
        d.g.b.k.h(paramAnonymousc, "reason");
        this.rhB.c(paramAnonymousc);
        AppMethodBeat.o(165777);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165776);
        d.g.b.k.h(paramAnonymousc, "reason");
        this.rhB.d(paramAnonymousc);
        AppMethodBeat.o(165776);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(165774);
        this.rhB.f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(165774);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(165773);
        this.rhB.onChanged();
        AppMethodBeat.o(165773);
      }
    });
    AppMethodBeat.o(165792);
  }
  
  private final BaseFinderFeedLoader getModel()
  {
    AppMethodBeat.i(201766);
    BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)this.riE.cuV();
    AppMethodBeat.o(201766);
    return localBaseFinderFeedLoader;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165791);
    RecyclerView localRecyclerView = this.fTr;
    if (localRecyclerView == null) {
      d.g.b.k.aVY("recyclerView");
    }
    AppMethodBeat.o(165791);
    return localRecyclerView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<1>
  {
    public static final a riJ;
    
    static
    {
      AppMethodBeat.i(165781);
      riJ = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean rgb = true;
    
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201764);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201764);
    }
    
    public final void DE(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.rgb) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.IrY;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.riH.iMV).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).ctt().b(t.c.e(this.riH), 5);
        }
        this.rgb = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      ac.i(t.c.b(this.riH), "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      if ((!paramc.Jyb) && (t.c.e(this.riH).getChildCount() > 0))
      {
        localObject = t.c.e(this.riH).getChildAt(t.c.e(this.riH).getChildCount() - 1);
        paramc = t.c.e(this.riH).bu((View)localObject);
        if (paramc == null) {
          break label170;
        }
        paramc = Integer.valueOf(paramc.ly());
        d.g.b.k.g(localObject, "itemView");
        if (((View)localObject).getHeight() > 0) {
          if (paramc != null) {
            break label175;
          }
        }
      }
      label170:
      label175:
      while (paramc.intValue() != 4)
      {
        if (paramc != null) {
          break label237;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(165784);
        return;
        paramc = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a(this.riH).getDisplayMetrics().heightPixels - ((View)localObject).getHeight();
        t.c.f(this.riH).setExtraOverScrollFooterDx(i / 3);
        ac.i(t.c.b(this.riH), "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label237:
        if (paramc.intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201765);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201765);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      ac.i(t.c.b(this.riH), "onRequestLoadMore");
      h.JZN.aS((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(t.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        Object localObject = (BaseFinderFeed)t.c.c(this.riK.riH).getLast();
        if ((t.c.c(this.riK.riH).isEmpty()) || (localObject == null))
        {
          localObject = t.c.d(this.riK.riH);
          n localn = n.rPN;
          n.vl(System.currentTimeMillis());
          t.b.a((t.b)localObject);
          AppMethodBeat.o(165782);
          return;
        }
        t.c.d(this.riK.riH).cuV().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    public c(t.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t.c
 * JD-Core Version:    0.7.0.1
 */