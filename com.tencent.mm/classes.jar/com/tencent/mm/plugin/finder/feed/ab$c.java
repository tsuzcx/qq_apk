package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.ah;
import com.tencent.mm.plugin.finder.report.ah.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "isOtherEnableFullScreenEnjoy", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "smoothScrollToNextPosition", "plugin-finder_release"})
public final class ab$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<ab.b>
{
  final String TAG;
  public final MMActivity gte;
  public RecyclerView hak;
  public RefreshLoadMoreLayout tLS;
  public j tMe;
  public final ab.b tPU;
  boolean tPV;
  public final boolean tPW;
  private final kotlin.f tPX;
  
  public ab$c(MMActivity paramMMActivity, final ab.b paramb)
  {
    AppMethodBeat.i(244090);
    this.gte = paramMMActivity;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.tPU = paramb;
    this.tPV = true;
    paramMMActivity = y.vXH;
    this.tPW = y.isOtherEnableFullScreenEnjoy();
    this.tPX = g.ah((kotlin.g.a.a)a.tQa);
    paramMMActivity = this.gte.findViewById(2131307118);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.tLS;
    if (paramMMActivity == null) {
      p.btv("rlLayout");
    }
    this.hak = paramMMActivity.getRecyclerView();
    paramMMActivity = this.hak;
    if (paramMMActivity == null) {
      p.btv("recyclerView");
    }
    Object localObject = new FinderLinearLayoutManager((Context)this.gte);
    if (this.tPW) {
      ((FinderLinearLayoutManager)localObject).wsx = 40.0F;
    }
    paramMMActivity.setLayoutManager((RecyclerView.LayoutManager)localObject);
    paramMMActivity = this.hak;
    if (paramMMActivity == null) {
      p.btv("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.m)this.tPX.getValue());
    paramMMActivity = this.hak;
    if (paramMMActivity == null) {
      p.btv("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new ab.b.a(this.tPU), (ArrayList)((BaseFinderFeedLoader)this.tPU.getFeedLoader()).getDataListJustForAdapter()));
    if (this.tPW)
    {
      paramMMActivity = new e();
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      paramMMActivity.f((RecyclerView)localObject);
    }
    this.tMe = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(244080);
        this.tNU.onChanged();
        AppMethodBeat.o(244080);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244081);
        this.tNU.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(244081);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(244082);
        this.tNU.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(244082);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244083);
        this.tNU.onItemRangeInserted(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(244083);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(244078);
        ab.c.c(this.tPY).onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = ab.c.c(this.tPY).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.getFeedLoader().requestLoadMore();
          }
          AppMethodBeat.o(244078);
          return;
        }
        AppMethodBeat.o(244078);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244084);
        p.h(paramAnonymousc, "reason");
        this.tNU.onPreFinishLoadMore(paramAnonymousc);
        AppMethodBeat.o(244084);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244085);
        p.h(paramAnonymousc, "reason");
        this.tNU.onPreFinishLoadMoreSmooth(paramAnonymousc);
        AppMethodBeat.o(244085);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(244086);
        p.h(paramAnonymousc, "reason");
        this.tNU.onPreFinishRefresh(paramAnonymousc);
        AppMethodBeat.o(244086);
      }
    });
    AppMethodBeat.o(244090);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165791);
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView == null) {
      p.btv("recyclerView");
    }
    AppMethodBeat.o(165791);
    return localRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends q
    implements kotlin.g.a.a<1>
  {
    public static final a tQa;
    
    static
    {
      AppMethodBeat.i(165781);
      tQa = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean tMa = true;
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244088);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244088);
    }
    
    public final void IF(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.tMa) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tPY.gte).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dap().onScrollStateChanged(ab.c.b(this.tPY), 5);
        }
        this.tMa = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramc, "reason");
      super.a(paramc);
      Log.i(this.tPY.TAG, "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      Object localObject2;
      if ((!paramc.Rmj) && (ab.c.b(this.tPY).getChildCount() > 0))
      {
        localObject2 = ab.c.b(this.tPY).getChildAt(ab.c.b(this.tPY).getChildCount() - 1);
        localObject1 = ab.c.b(this.tPY).bu((View)localObject2);
        if (localObject1 == null) {
          break label225;
        }
        localObject1 = Integer.valueOf(((RecyclerView.v)localObject1).lU());
        p.g(localObject2, "itemView");
        if (((View)localObject2).getHeight() > 0) {
          if (localObject1 != null) {
            break label230;
          }
        }
      }
      label225:
      label230:
      while (((Integer)localObject1).intValue() != 4)
      {
        if (localObject1 != null) {
          break label294;
        }
        if ((!paramc.Rml) || (!paramc.Rmj)) {
          break label351;
        }
        paramc = ab.c.b(this.tPY);
        if ((paramc == null) || (!this.tPY.tPW)) {
          break label351;
        }
        localObject1 = this.tPY;
        localObject2 = paramc.getLayoutManager();
        if (localObject2 != null) {
          break label306;
        }
        paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(165784);
        throw paramc;
        localObject1 = null;
        break;
      }
      for (;;)
      {
        i = c.a.a(this.tPY).getDisplayMetrics().heightPixels - ((View)localObject2).getHeight();
        ab.c.c(this.tPY).setExtraOverScrollFooterDx(i / 3);
        Log.i(this.tPY.TAG, "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label294:
        if (((Integer)localObject1).intValue() != 8) {
          break;
        }
      }
      label306:
      int i = ((FinderLinearLayoutManager)localObject2).ks() + 1;
      Log.i(((ab.c)localObject1).TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(i)));
      paramc.post((Runnable)new ab.c.d(paramc, i));
      label351:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165784);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      Log.i(this.tPY.TAG, "onRequestLoadMore");
      com.tencent.f.h.RTc.aX((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = k.vkd;
      k.b(ab.c.b(this.tPY), s.p.voA, "1", com.tencent.mm.plugin.finder.report.live.c.vjh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244087);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ab.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        this.tQb.tPY.tPU.getFeedLoader().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<Void, x>
  {
    public c(ab.c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(RecyclerView paramRecyclerView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(244089);
      RecyclerView localRecyclerView = this.tDJ;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.tQg, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(244089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab.c
 * JD-Core Version:    0.7.0.1
 */