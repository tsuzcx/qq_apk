package com.tencent.mm.plugin.finder.live.olympic;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback;", "", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;", "rootView", "Landroid/view/View;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "emptyView", "Landroid/widget/TextView;", "getEmptyView", "()Landroid/widget/TextView;", "emptyView$delegate", "Lkotlin/Lazy;", "lastVisibleViewPos", "", "getLastVisibleViewPos", "()[I", "setLastVisibleViewPos", "([I)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;", "progressView", "Landroid/widget/ProgressBar;", "getProgressView", "()Landroid/widget/ProgressBar;", "progressView$delegate", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rfLayout$delegate", "getRootView", "()Landroid/view/View;", "rvScrollListener", "com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback$rvScrollListener$2$1", "getRvScrollListener", "()Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback$rvScrollListener$2$1;", "rvScrollListener$delegate", "selfItemPosition", "", "getSelfItemPosition", "()I", "setSelfItemPosition", "(I)V", "stickContainer", "getStickContainer", "stickContainer$delegate", "stickView", "getStickView", "stickView$delegate", "stickViewY", "getStickViewY", "setStickViewY", "checkStickViewLogic", "", "Landroidx/recyclerview/widget/RecyclerView;", "initView", "onDetach", "showEmptyView", "show", "", "showLocationRequstView", "showProgress", "updateStickView", "stickItemPos", "data", "Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b
{
  com.tencent.mm.view.k ATF;
  final g.a CNN;
  private final j CNO;
  final j CNP;
  private final j CNQ;
  private final j CNR;
  final j CNS;
  private final j CNT;
  private final j CNU;
  int CNV;
  int CNW;
  private int[] CNX;
  final Context context;
  final View rootView;
  
  public g$b(Context paramContext, g.a parama, View paramView)
  {
    AppMethodBeat.i(360408);
    this.context = paramContext;
    this.CNN = parama;
    this.rootView = paramView;
    this.CNO = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.CNP = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.CNR = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.CNS = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.CNT = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.CNU = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.ATF = ((com.tencent.mm.view.k)new d(this));
    this.CNV = 2147483647;
    this.CNW = 2147483647;
    this.CNX = new int[2];
    AppMethodBeat.o(360408);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(360424);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.CNN.CNK;
    if (paramb != null) {
      paramb.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360424);
  }
  
  private ProgressBar eny()
  {
    AppMethodBeat.i(360414);
    Object localObject = this.CNR.getValue();
    s.s(localObject, "<get-progressView>(...)");
    localObject = (ProgressBar)localObject;
    AppMethodBeat.o(360414);
    return localObject;
  }
  
  public final View enA()
  {
    AppMethodBeat.i(360452);
    Object localObject = this.CNU.getValue();
    s.s(localObject, "<get-stickView>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(360452);
    return localObject;
  }
  
  public final RefreshLoadMoreLayout enx()
  {
    AppMethodBeat.i(360439);
    Object localObject = this.CNO.getValue();
    s.s(localObject, "<get-rfLayout>(...)");
    localObject = (RefreshLoadMoreLayout)localObject;
    AppMethodBeat.o(360439);
    return localObject;
  }
  
  public final View enz()
  {
    AppMethodBeat.i(360450);
    Object localObject = this.CNT.getValue();
    s.s(localObject, "<get-stickContainer>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(360450);
    return localObject;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(360445);
    Object localObject = this.CNQ.getValue();
    s.s(localObject, "<get-recyclerView>(...)");
    localObject = (WxRecyclerView)localObject;
    AppMethodBeat.o(360445);
    return localObject;
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(360461);
    ProgressBar localProgressBar = eny();
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      AppMethodBeat.o(360461);
      return;
    }
  }
  
  public final void qP(boolean paramBoolean)
  {
    AppMethodBeat.i(360481);
    if (paramBoolean)
    {
      this.rootView.findViewById(p.e.BYM).setVisibility(0);
      TextView localTextView = (TextView)this.rootView.findViewById(p.e.BYL);
      if (localTextView != null)
      {
        aw.a((Paint)localTextView.getPaint(), 0.8F);
        localTextView.setOnClickListener(new g.b..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(360481);
      }
    }
    else
    {
      this.rootView.findViewById(p.e.BYM).setVisibility(8);
    }
    AppMethodBeat.o(360481);
  }
  
  public final void w(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(360472);
    s.u(paramRecyclerView, "recyclerView");
    if ((this.CNV <= 0) || (this.CNV >= 2147483647))
    {
      AppMethodBeat.o(360472);
      return;
    }
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(360472);
      throw paramRecyclerView;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    int i = paramRecyclerView.Jw();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", "onScrolled lastVisiblePos:" + i + ",selfItemPosition:" + this.CNV);
    if (i < this.CNV)
    {
      enz().setVisibility(0);
      AppMethodBeat.o(360472);
      return;
    }
    if (i <= this.CNV)
    {
      this.CNX[1] = 0;
      paramRecyclerView = paramRecyclerView.findViewByPosition(i);
      if (paramRecyclerView != null) {
        paramRecyclerView.getLocationOnScreen(this.CNX);
      }
      paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", "onScrolled lastVisibleViewY:" + this.CNX[1] + ",stickViewY:" + this.CNW);
      if (this.CNX[1] > this.CNW)
      {
        enz().setVisibility(0);
        AppMethodBeat.o(360472);
        return;
      }
    }
    enz().setVisibility(4);
    AppMethodBeat.o(360472);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    b(g.b paramb) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(360572);
      super.IH(paramInt);
      this.CNY.CNN.j(false, 0L);
      AppMethodBeat.o(360572);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(360597);
      s.u(paramd, "reason");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", s.X("onLoadMoreEnd ", paramd));
      super.a(paramd);
      this.CNY.pZ(false);
      AppMethodBeat.o(360597);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(360580);
      s.u(paramd, "reason");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", s.X("onRefreshEnd ", paramd));
      super.onRefreshEnd(paramd);
      RefreshLoadMoreLayout.c(this.CNY.enx());
      this.CNY.pZ(false);
      AppMethodBeat.o(360580);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(360590);
      super.qI(paramInt);
      g.a locala = this.CNY.CNN;
      Log.i("FinderLiveOlympicRunnerPannelContract", "boardScene:" + locala.CNG + ", loader:" + locala.CNJ.hashCode() + "  loadMore");
      BaseFeedLoader.requestLoadMore$default(locala.CNJ, false, 1, null);
      AppMethodBeat.o(360590);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ProgressBar>
  {
    c(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback$proxyRLayout$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.k
  {
    d(g.b paramb) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(360574);
      this.CNY.enx().onChanged();
      AppMethodBeat.o(360574);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(360582);
      this.CNY.enx().onItemRangeChanged(this.CNY.CNN.getAdapter().agOb.size() + paramInt1, paramInt2);
      AppMethodBeat.o(360582);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(360593);
      this.CNY.enx().onItemRangeChanged(this.CNY.CNN.getAdapter().agOb.size() + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(360593);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(360600);
      this.CNY.enx().onItemRangeInserted(this.CNY.CNN.getAdapter().agOb.size() + paramInt1, paramInt2);
      AppMethodBeat.o(360600);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(360606);
      this.CNY.enx().onItemRangeRemoved(this.CNY.CNN.getAdapter().agOb.size() + paramInt1, paramInt2);
      AppMethodBeat.o(360606);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(360564);
      s.u(paramd, "reason");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", s.X("onPreFinishLoadMore ", paramd));
      this.CNY.enx().onPreFinishLoadMore(paramd);
      AppMethodBeat.o(360564);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(360570);
      s.u(paramd, "reason");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", s.X("onPreFinishLoadMoreSmooth ", paramd));
      this.CNY.enx().onPreFinishLoadMoreSmooth(paramd);
      AppMethodBeat.o(360570);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(360559);
      s.u(paramd, "reason");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveOlympicRunnerPannelContract", s.X("onPreFinishRefresh ", paramd));
      this.CNY.enx().onPreFinishRefresh(paramd);
      AppMethodBeat.o(360559);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    e(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    f(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback$rvScrollListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<1>
  {
    g(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<View>
  {
    h(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(g.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.g.b
 * JD-Core Version:    0.7.0.1
 */