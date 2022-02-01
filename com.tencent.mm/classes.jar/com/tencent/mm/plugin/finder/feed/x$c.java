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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "plugin-finder_release"})
public final class x$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<x.b>
{
  final String TAG;
  public final MMActivity fNT;
  public RecyclerView gpr;
  public RefreshLoadMoreLayout scj;
  public d scv;
  public final x.b sfC;
  boolean sfD;
  private final d.f sfE;
  
  public x$c(MMActivity paramMMActivity, final x.b paramb)
  {
    AppMethodBeat.i(202455);
    this.fNT = paramMMActivity;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.sfC = paramb;
    this.sfD = true;
    this.sfE = g.O((d.g.a.a)a.sfH);
    paramMMActivity = this.fNT.findViewById(2131304203);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.scj;
    if (paramMMActivity == null) {
      p.bdF("rlLayout");
    }
    this.gpr = paramMMActivity.getRecyclerView();
    paramMMActivity = this.gpr;
    if (paramMMActivity == null) {
      p.bdF("recyclerView");
    }
    paramMMActivity.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    paramMMActivity = this.gpr;
    if (paramMMActivity == null) {
      p.bdF("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.n)this.sfE.getValue());
    paramMMActivity = this.gpr;
    if (paramMMActivity == null) {
      p.bdF("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new x.b.a(this.sfC), (ArrayList)((BaseFinderFeedLoader)this.sfC.cCY()).getDataListJustForAdapter()));
    this.scv = ((d)new d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165775);
        this.sen.au(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(165775);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165771);
        x.c.c(this.sfF).av(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = x.c.c(this.sfF).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.cCY().requestLoadMore();
          }
          AppMethodBeat.o(165771);
          return;
        }
        AppMethodBeat.o(165771);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165777);
        p.h(paramAnonymousc, "reason");
        this.sen.c(paramAnonymousc);
        AppMethodBeat.o(165777);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165776);
        p.h(paramAnonymousc, "reason");
        this.sen.d(paramAnonymousc);
        AppMethodBeat.o(165776);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(165774);
        this.sen.f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(165774);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(165773);
        this.sen.onChanged();
        AppMethodBeat.o(165773);
      }
    });
    AppMethodBeat.o(202455);
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165791);
    RecyclerView localRecyclerView = this.gpr;
    if (localRecyclerView == null) {
      p.bdF("recyclerView");
    }
    AppMethodBeat.o(165791);
    return localRecyclerView;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends q
    implements d.g.a.a<1>
  {
    public static final a sfH;
    
    static
    {
      AppMethodBeat.i(165781);
      sfH = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean scq = true;
    
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202453);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202453);
    }
    
    public final void EK(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.scq) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.sfF.fNT).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).cBd().b(x.c.b(this.sfF), 5);
        }
        this.scq = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramc, "reason");
      super.a(paramc);
      ae.i(this.sfF.TAG, "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      if ((!paramc.LNT) && (x.c.b(this.sfF).getChildCount() > 0))
      {
        localObject = x.c.b(this.sfF).getChildAt(x.c.b(this.sfF).getChildCount() - 1);
        paramc = x.c.b(this.sfF).bu((View)localObject);
        if (paramc == null) {
          break label170;
        }
        paramc = Integer.valueOf(paramc.lQ());
        p.g(localObject, "itemView");
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
        int i = c.a.a(this.sfF).getDisplayMetrics().heightPixels - ((View)localObject).getHeight();
        x.c.c(this.sfF).setExtraOverScrollFooterDx(i / 3);
        ae.i(this.sfF.TAG, "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label237:
        if (paramc.intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202454);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202454);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      ae.i(this.sfF.TAG, "onRequestLoadMore");
      com.tencent.e.h.MqF.aO((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(x.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        this.sfI.sfF.sfC.cCY().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  public static final class c
    extends q
    implements d.g.a.b<Void, z>
  {
    public c(x.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x.c
 * JD-Core Version:    0.7.0.1
 */