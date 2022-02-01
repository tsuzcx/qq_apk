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
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.w.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
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
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "plugin-finder_release"})
public final class x$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<x.b>
{
  final String TAG;
  public final MMActivity fLP;
  public RecyclerView gmV;
  public RefreshLoadMoreLayout rTF;
  public d rTR;
  public final x.b rWR;
  boolean rWS;
  private final d.f rWT;
  
  public x$c(MMActivity paramMMActivity, final x.b paramb)
  {
    AppMethodBeat.i(201991);
    this.fLP = paramMMActivity;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.rWR = paramb;
    this.rWS = true;
    this.rWT = g.O((d.g.a.a)a.rWW);
    paramMMActivity = this.fLP.findViewById(2131304203);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.rTF;
    if (paramMMActivity == null) {
      p.bcb("rlLayout");
    }
    this.gmV = paramMMActivity.getRecyclerView();
    paramMMActivity = this.gmV;
    if (paramMMActivity == null) {
      p.bcb("recyclerView");
    }
    paramMMActivity.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    paramMMActivity = this.gmV;
    if (paramMMActivity == null) {
      p.bcb("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.n)this.rWT.getValue());
    paramMMActivity = this.gmV;
    if (paramMMActivity == null) {
      p.bcb("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new x.b.a(this.rWR), (ArrayList)((BaseFinderFeedLoader)this.rWR.cBm()).getDataListJustForAdapter()));
    this.rTR = ((d)new d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165775);
        this.rVH.au(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(165775);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165771);
        x.c.c(this.rWU).av(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = x.c.c(this.rWU).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.cBm().requestLoadMore();
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
        this.rVH.c(paramAnonymousc);
        AppMethodBeat.o(165777);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165776);
        p.h(paramAnonymousc, "reason");
        this.rVH.d(paramAnonymousc);
        AppMethodBeat.o(165776);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(165774);
        this.rVH.f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(165774);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(165773);
        this.rVH.onChanged();
        AppMethodBeat.o(165773);
      }
    });
    AppMethodBeat.o(201991);
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165791);
    RecyclerView localRecyclerView = this.gmV;
    if (localRecyclerView == null) {
      p.bcb("recyclerView");
    }
    AppMethodBeat.o(165791);
    return localRecyclerView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends q
    implements d.g.a.a<1>
  {
    public static final a rWW;
    
    static
    {
      AppMethodBeat.i(165781);
      rWW = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean rTM = true;
    
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(201989);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201989);
    }
    
    public final void Ex(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.rTM) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KiD;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.rWU.fLP).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).czz().b(x.c.b(this.rWU), 5);
        }
        this.rTM = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      ad.i(this.rWU.TAG, "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      if ((!paramc.Lri) && (x.c.b(this.rWU).getChildCount() > 0))
      {
        localObject = x.c.b(this.rWU).getChildAt(x.c.b(this.rWU).getChildCount() - 1);
        paramc = x.c.b(this.rWU).bu((View)localObject);
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
        int i = c.a.a(this.rWU).getDisplayMetrics().heightPixels - ((View)localObject).getHeight();
        x.c.c(this.rWU).setExtraOverScrollFooterDx(i / 3);
        ad.i(this.rWU.TAG, "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label237:
        if (paramc.intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201990);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201990);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      ad.i(this.rWU.TAG, "onRequestLoadMore");
      com.tencent.e.h.LTJ.aR((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(x.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        this.rWX.rWU.rWR.cBm().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x.c
 * JD-Core Version:    0.7.0.1
 */