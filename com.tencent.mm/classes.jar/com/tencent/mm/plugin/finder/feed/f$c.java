package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.j.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "initPos", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;I)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "getInitPos", "()I", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "plugin-finder_release"})
public final class f$c
  implements com.tencent.mm.plugin.finder.presenter.base.b<f.b>
{
  private final String TAG;
  public RecyclerView fPw;
  public final MMActivity imP;
  public RefreshLoadMoreLayout quj;
  final int qvB;
  public final f.b qvM;
  private boolean qvN;
  public com.tencent.mm.view.d qvO;
  private final f qvP;
  
  static
  {
    AppMethodBeat.i(165790);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(c.class), "feedViewPool", "getFeedViewPool()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")) };
    AppMethodBeat.o(165790);
  }
  
  public f$c(MMActivity paramMMActivity, final f.b paramb, int paramInt)
  {
    AppMethodBeat.i(165792);
    this.imP = paramMMActivity;
    this.qvB = paramInt;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.qvM = paramb;
    this.qvN = true;
    this.qvP = d.g.E((d.g.a.a)a.qvS);
    paramMMActivity = this.imP.findViewById(2131304203);
    d.g.b.k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.quj;
    if (paramMMActivity == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    this.fPw = paramMMActivity.getRecyclerView();
    paramMMActivity = this.fPw;
    if (paramMMActivity == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramMMActivity.setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    paramMMActivity = this.fPw;
    if (paramMMActivity == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.n)this.qvP.getValue());
    paramMMActivity = this.fPw;
    if (paramMMActivity == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f.b.a(this.qvM), (ArrayList)getModel().getDataListJustForAdapter()));
    this.qvO = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165775);
        this.qvq.at(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(165775);
      }
      
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(165771);
        f.c.f(this.qvQ).au(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = f.c.f(this.qvQ).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.fTm().requestLoadMore();
          }
          AppMethodBeat.o(165771);
          return;
        }
        AppMethodBeat.o(165771);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165776);
        d.g.b.k.h(paramAnonymousc, "reason");
        this.qvq.c(paramAnonymousc);
        AppMethodBeat.o(165776);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(165777);
        d.g.b.k.h(paramAnonymousc, "reason");
        this.qvq.d(paramAnonymousc);
        AppMethodBeat.o(165777);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(165774);
        this.qvq.f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(165774);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(165773);
        this.qvq.onChanged();
        AppMethodBeat.o(165773);
      }
    });
    AppMethodBeat.o(165792);
  }
  
  private final BaseFinderFeedLoader getModel()
  {
    AppMethodBeat.i(197869);
    BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)this.qvM.fTm();
    AppMethodBeat.o(197869);
    return localBaseFinderFeedLoader;
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165791);
    RecyclerView localRecyclerView = this.fPw;
    if (localRecyclerView == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    AppMethodBeat.o(165791);
    return localRecyclerView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<1>
  {
    public static final a qvS;
    
    static
    {
      AppMethodBeat.i(165781);
      qvS = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean qup = true;
    
    public final void CC(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.qup) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.LCX;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qvQ.imP).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((e)localObject).fSD().b(f.c.e(this.qvQ), 5);
        }
        this.qup = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      ad.i(f.c.b(this.qvQ), "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      if ((!paramc.HXq) && (f.c.e(this.qvQ).getChildCount() > 0))
      {
        localObject = f.c.e(this.qvQ).getChildAt(f.c.e(this.qvQ).getChildCount() - 1);
        paramc = f.c.e(this.qvQ).bu((View)localObject);
        if (paramc == null) {
          break label170;
        }
        paramc = Integer.valueOf(paramc.lp());
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
        int i = b.a.a(this.qvQ).getDisplayMetrics().heightPixels - ((View)localObject).getHeight();
        f.c.f(this.qvQ).setExtraOverScrollFooterDx(i / 3);
        ad.i(f.c.b(this.qvQ), "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label237:
        if (paramc.intValue() != 8) {
          break;
        }
      }
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(197867);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(197867);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(197868);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197868);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      ad.i(f.c.b(this.qvQ), "onRequestLoadMore");
      h.Iye.aP((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        Object localObject = (BaseFinderFeed)f.c.c(this.qvT.qvQ).getLast();
        if ((f.c.c(this.qvT.qvQ).isEmpty()) || (localObject == null))
        {
          localObject = f.c.d(this.qvT.qvQ);
          com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
          com.tencent.mm.plugin.finder.utils.i.qO(System.currentTimeMillis());
          f.b.a((f.b)localObject);
          AppMethodBeat.o(165782);
          return;
        }
        f.c.d(this.qvT.qvQ).fTm().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    public c(f.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.c
 * JD-Core Version:    0.7.0.1
 */