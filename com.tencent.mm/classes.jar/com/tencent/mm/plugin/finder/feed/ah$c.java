package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.ak;
import com.tencent.mm.plugin.finder.report.ak.b;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "isOtherEnableFullScreenEnjoy", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "smoothScrollToNextPosition", "plugin-finder_release"})
public final class ah$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<ah.b>
{
  final String TAG;
  public final MMActivity iXq;
  public RecyclerView jLl;
  public final ah.b xAK;
  boolean xAL;
  public final boolean xAM;
  private final kotlin.f xAN;
  public RefreshLoadMoreLayout xvJ;
  public com.tencent.mm.view.j xvV;
  
  public ah$c(MMActivity paramMMActivity, final ah.b paramb)
  {
    AppMethodBeat.i(282211);
    this.iXq = paramMMActivity;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.xAK = paramb;
    this.xAL = true;
    paramMMActivity = com.tencent.mm.plugin.finder.utils.aj.AGc;
    this.xAM = com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy();
    this.xAN = kotlin.g.ar((kotlin.g.a.a)a.xAQ);
    paramMMActivity = this.iXq.findViewById(b.f.rl_layout);
    p.j(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.xvJ;
    if (paramMMActivity == null) {
      p.bGy("rlLayout");
    }
    this.jLl = paramMMActivity.getRecyclerView();
    paramMMActivity = this.jLl;
    if (paramMMActivity == null) {
      p.bGy("recyclerView");
    }
    Object localObject = new FinderLinearLayoutManager((Context)this.iXq);
    if (this.xAM)
    {
      ((FinderLinearLayoutManager)localObject).BdV = 25.0F;
      ((FinderLinearLayoutManager)localObject).uqm = 100;
    }
    paramMMActivity.setLayoutManager((RecyclerView.LayoutManager)localObject);
    paramMMActivity = this.jLl;
    if (paramMMActivity == null) {
      p.bGy("recyclerView");
    }
    paramMMActivity.setRecycledViewPool((RecyclerView.m)this.xAN.getValue());
    paramMMActivity = this.jLl;
    if (paramMMActivity == null) {
      p.bGy("recyclerView");
    }
    paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new ah.b.a(this.xAK), (ArrayList)((BaseFinderFeedLoader)this.xAK.getFeedLoader()).getDataListJustForAdapter()));
    if (this.xAM)
    {
      paramMMActivity = new e();
      localObject = this.jLl;
      if (localObject == null) {
        p.bGy("recyclerView");
      }
      paramMMActivity.a((RecyclerView)localObject);
    }
    this.xvV = ((com.tencent.mm.view.j)new com.tencent.mm.view.j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(275197);
        this.xxU.onChanged();
        AppMethodBeat.o(275197);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(275198);
        this.xxU.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(275198);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(275199);
        this.xxU.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(275199);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(275200);
        this.xxU.onItemRangeInserted(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(275200);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(275195);
        ah.c.c(this.xAO).onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.a locala = ah.c.c(this.xAO).getRecyclerView().getAdapter();
        if (locala != null)
        {
          if (locala.getItemCount() < 10) {
            paramb.getFeedLoader().requestLoadMore();
          }
          AppMethodBeat.o(275195);
          return;
        }
        AppMethodBeat.o(275195);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(275202);
        p.k(paramAnonymousc, "reason");
        this.xxU.onPreFinishLoadMore(paramAnonymousc);
        AppMethodBeat.o(275202);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(275203);
        p.k(paramAnonymousc, "reason");
        this.xxU.onPreFinishLoadMoreSmooth(paramAnonymousc);
        AppMethodBeat.o(275203);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(275204);
        p.k(paramAnonymousc, "reason");
        this.xxU.onPreFinishRefresh(paramAnonymousc);
        AppMethodBeat.o(275204);
      }
    });
    AppMethodBeat.o(282211);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(282210);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView == null) {
      p.bGy("recyclerView");
    }
    AppMethodBeat.o(282210);
    return localRecyclerView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1;"})
  static final class a
    extends q
    implements kotlin.g.a.a<1>
  {
    public static final a xAQ;
    
    static
    {
      AppMethodBeat.i(165781);
      xAQ = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(230958);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(230958);
    }
    
    public final void Mw(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.xvR) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.g.Xox;
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.d((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xAO.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dqn().onScrollStateChanged(ah.c.b(this.xAO), 5);
        }
        this.xvR = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165784);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      Log.i(this.xAO.TAG, "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
      Object localObject2;
      if ((!paramc.YNF) && (ah.c.b(this.xAO).getChildCount() > 0))
      {
        localObject2 = ah.c.b(this.xAO).getChildAt(ah.c.b(this.xAO).getChildCount() - 1);
        localObject1 = ah.c.b(this.xAO).bf((View)localObject2);
        if (localObject1 == null) {
          break label225;
        }
        localObject1 = Integer.valueOf(((RecyclerView.v)localObject1).mg());
        p.j(localObject2, "itemView");
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
        if ((!paramc.YNH) || (!paramc.YNF)) {
          break label351;
        }
        paramc = ah.c.b(this.xAO);
        if ((paramc == null) || (!this.xAO.xAM)) {
          break label351;
        }
        localObject1 = this.xAO;
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
        i = c.a.a(this.xAO).getDisplayMetrics().heightPixels - ((View)localObject2).getHeight();
        ah.c.c(this.xAO).setExtraOverScrollFooterDx(i / 3);
        Log.i(this.xAO.TAG, "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        break;
        label294:
        if (((Integer)localObject1).intValue() != 8) {
          break;
        }
      }
      label306:
      int i = ((FinderLinearLayoutManager)localObject2).kJ() + 1;
      Log.i(((ah.c)localObject1).TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(i)));
      paramc.post((Runnable)new ah.c.d(paramc, i));
      label351:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165784);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(165783);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      Log.i(this.xAO.TAG, "onRequestLoadMore");
      h.ZvG.be((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165783);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(230955);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      paramc = k.yBj;
      k.b(ah.c.b(this.xAO), s.t.yGN, "1", com.tencent.mm.plugin.finder.live.report.c.yAk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(230955);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ah.c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(165782);
        this.xAR.xAO.xAK.getFeedLoader().requestLoadMore();
        AppMethodBeat.o(165782);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<Void, x>
  {
    public c(ah.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(RecyclerView paramRecyclerView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(246725);
      RecyclerView localRecyclerView = this.xmk;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.xAW, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(246725);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ah.c
 * JD-Core Version:    0.7.0.1
 */