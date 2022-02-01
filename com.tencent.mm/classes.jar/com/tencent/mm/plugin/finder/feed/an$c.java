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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.az;
import com.tencent.mm.plugin.finder.report.az.b;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;)V", "TAG", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "feedViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "firstLoadMore", "", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getProxyRLayout", "getRecyclerView", "initView", "", "onFetchEnd", "onUIAttach", "onUIDestroy", "onUIPause", "onUIResume", "smoothScrollToNextPosition", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an$c
  implements com.tencent.mm.plugin.finder.presenter.base.c<an.b>
{
  public com.tencent.mm.view.k ATF;
  public RefreshLoadMoreLayout ATx;
  public final an.b AYo;
  boolean AYp;
  private final kotlin.j AYq;
  final String TAG;
  public final MMActivity lzt;
  public RecyclerView mkw;
  
  public an$c(MMActivity paramMMActivity, final an.b paramb)
  {
    AppMethodBeat.i(363014);
    this.lzt = paramMMActivity;
    this.TAG = "Finder.FinderProfileTimelineContract.ProfileTimelineViewCallback";
    this.AYo = paramb;
    this.AYp = true;
    this.AYq = kotlin.k.cm((kotlin.g.a.a)a.AYt);
    paramMMActivity = this.lzt.findViewById(e.e.rl_layout);
    s.s(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramMMActivity);
    Object localObject2 = this.ATx;
    paramMMActivity = (MMActivity)localObject2;
    if (localObject2 == null)
    {
      s.bIx("rlLayout");
      paramMMActivity = null;
    }
    this.mkw = paramMMActivity.getRecyclerView();
    paramMMActivity = this.mkw;
    if (paramMMActivity == null)
    {
      s.bIx("recyclerView");
      paramMMActivity = null;
      localObject2 = new FinderLinearLayoutManager((Context)this.lzt);
      ((FinderLinearLayoutManager)localObject2).GGx = 25.0F;
      ((FinderLinearLayoutManager)localObject2).xwJ = 100;
      ah localah = ah.aiuX;
      paramMMActivity.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      paramMMActivity = this.mkw;
      if (paramMMActivity != null) {
        break label319;
      }
      s.bIx("recyclerView");
      paramMMActivity = null;
      label187:
      paramMMActivity.setRecycledViewPool((RecyclerView.m)this.AYq.getValue());
      paramMMActivity = this.mkw;
      if (paramMMActivity != null) {
        break label322;
      }
      s.bIx("recyclerView");
      paramMMActivity = null;
      label219:
      paramMMActivity.setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new an.b.a(this.AYo), (ArrayList)((BaseFinderFeedLoader)this.AYo.getFeedLoader()).getDataListJustForAdapter()));
      localObject2 = new e();
      paramMMActivity = this.mkw;
      if (paramMMActivity != null) {
        break label325;
      }
      s.bIx("recyclerView");
      paramMMActivity = localObject1;
    }
    label319:
    label322:
    label325:
    for (;;)
    {
      ((e)localObject2).a(paramMMActivity);
      this.ATF = ((com.tencent.mm.view.k)new com.tencent.mm.view.k()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(362505);
          this.AVe.onChanged();
          AppMethodBeat.o(362505);
        }
        
        public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(362508);
          this.AVe.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(362508);
        }
        
        public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(362515);
          this.AVe.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(362515);
        }
        
        public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(362521);
          this.AVe.onItemRangeInserted(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(362521);
        }
        
        public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          Object localObject2 = null;
          AppMethodBeat.i(362549);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AYr.ATx;
          Object localObject1 = localRefreshLoadMoreLayout;
          if (localRefreshLoadMoreLayout == null)
          {
            s.bIx("rlLayout");
            localObject1 = null;
          }
          ((RefreshLoadMoreLayout)localObject1).onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.AYr.ATx;
          if (localObject1 == null)
          {
            s.bIx("rlLayout");
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
            if (localObject1 != null)
            {
              paramAnonymousInt1 = ((RecyclerView.a)localObject1).getItemCount();
              localObject1 = paramb;
              if (paramAnonymousInt1 < 10) {
                ((an.b)localObject1).ecx();
              }
            }
            AppMethodBeat.o(362549);
            return;
          }
        }
        
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(362529);
          s.u(paramAnonymousd, "reason");
          this.AVe.onPreFinishLoadMore(paramAnonymousd);
          AppMethodBeat.o(362529);
        }
        
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(362537);
          s.u(paramAnonymousd, "reason");
          this.AVe.onPreFinishLoadMoreSmooth(paramAnonymousd);
          AppMethodBeat.o(362537);
        }
        
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(362544);
          s.u(paramAnonymousd, "reason");
          this.AVe.onPreFinishRefresh(paramAnonymousd);
          AppMethodBeat.o(362544);
        }
      });
      AppMethodBeat.o(363014);
      return;
      break;
      break label187;
      break label219;
    }
  }
  
  private static final void l(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(363020);
    s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(363020);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(363040);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView == null)
    {
      s.bIx("recyclerView");
      AppMethodBeat.o(363040);
      return null;
    }
    AppMethodBeat.o(363040);
    return localRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$feedViewPool$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<1>
  {
    public static final a AYt;
    
    static
    {
      AppMethodBeat.i(165781);
      AYt = new a();
      AppMethodBeat.o(165781);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    public b(an.c paramc) {}
    
    private static final void b(an.c paramc)
    {
      AppMethodBeat.i(363960);
      s.u(paramc, "this$0");
      paramc.AYo.ecx();
      AppMethodBeat.o(363960);
    }
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(165785);
      if ((this.ATC) && (paramInt > 0))
      {
        Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AYr.lzt).q(as.class);
        s.s(localObject1, "UICProvider.of(context).…rReporterUIC::class.java)");
        Object localObject2 = as.b((as)localObject1);
        if (localObject2 != null)
        {
          localObject1 = this.AYr;
          RecyclerView.l locall = ((f)localObject2).dYJ();
          localObject2 = ((an.c)localObject1).mkw;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("recyclerView");
            localObject1 = null;
          }
          locall.onScrollStateChanged((RecyclerView)localObject1, 5);
        }
        this.ATC = false;
      }
      AppMethodBeat.o(165785);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      Object localObject3 = null;
      AppMethodBeat.i(165784);
      s.u(paramd, "reason");
      super.a(paramd);
      Log.i(this.AYr.TAG, s.X("[onLoadMoreEnd] reason=", paramd));
      Object localObject2;
      Object localObject1;
      Object localObject4;
      if (!paramd.agJu)
      {
        localObject2 = this.AYr.mkw;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("recyclerView");
          localObject1 = null;
        }
        if (((RecyclerView)localObject1).getChildCount() > 0)
        {
          localObject2 = this.AYr.mkw;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("recyclerView");
            localObject1 = null;
          }
          localObject4 = this.AYr.mkw;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("recyclerView");
            localObject2 = null;
          }
          localObject4 = ((RecyclerView)localObject1).getChildAt(((RecyclerView)localObject2).getChildCount() - 1);
          localObject2 = this.AYr.mkw;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("recyclerView");
            localObject1 = null;
          }
          localObject1 = ((RecyclerView)localObject1).by((View)localObject4);
          if (localObject1 != null) {
            break label237;
          }
          localObject1 = null;
          if (((View)localObject4).getHeight() > 0)
          {
            if (localObject1 != null) {
              break label248;
            }
            label185:
            if (localObject1 != null) {
              break label329;
            }
          }
        }
      }
      if ((paramd.agJw) && (paramd.agJu))
      {
        paramd = this.AYr.mkw;
        if (paramd != null) {
          break label341;
        }
        s.bIx("recyclerView");
        paramd = localObject3;
      }
      label329:
      label341:
      for (;;)
      {
        an.c.a(this.AYr, paramd);
        AppMethodBeat.o(165784);
        return;
        label237:
        localObject1 = Integer.valueOf(((RecyclerView.v)localObject1).caO);
        break;
        label248:
        if (((Integer)localObject1).intValue() != 4) {
          break label185;
        }
        for (;;)
        {
          int i = c.a.a(this.AYr).getDisplayMetrics().heightPixels - ((View)localObject4).getHeight();
          localObject2 = this.AYr.ATx;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("rlLayout");
            localObject1 = null;
          }
          ((RefreshLoadMoreLayout)localObject1).setExtraOverScrollFooterDx(i / 3);
          Log.i(this.AYr.TAG, s.X("extraOverScrollFooterDx=", Integer.valueOf(i)));
          break;
          if (((Integer)localObject1).intValue() != 8) {
            break;
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363995);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      RecyclerView localRecyclerView = this.AYr.mkw;
      paramd = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("recyclerView");
        paramd = null;
      }
      localce.b(paramd, q.w.DwP, "1", com.tencent.mm.plugin.finder.live.report.d.Dnh);
      AppMethodBeat.o(363995);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363973);
      super.qI(paramInt);
      Log.i(this.AYr.TAG, "onRequestLoadMore");
      com.tencent.threadpool.h.ahAA.bm(new an.c.b..ExternalSyntheticLambda0(this.AYr));
      AppMethodBeat.o(363973);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements b<Void, ah>
  {
    public c(an.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.an.c
 * JD-Core Version:    0.7.0.1
 */