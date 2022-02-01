package com.tencent.mm.plugin.finder.live;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.r;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector;", "Lcom/tencent/mm/plugin/finder/live/IFinderLivePlayViewSelector;", "()V", "autoPlayRunnable", "Ljava/lang/Runnable;", "dataSet", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "getDataSet", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "setDataSet", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "selectResult", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "selectorCallback", "Lcom/tencent/mm/plugin/finder/live/SelectorResult;", "getSelectorCallback", "()Lcom/tencent/mm/plugin/finder/live/SelectorResult;", "setSelectorCallback", "(Lcom/tencent/mm/plugin/finder/live/SelectorResult;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "unSelectResult", "check", "", "checkAutoPlayDelay", "delayMs", "", "checkAutoPlayImpl", "getLiveData", "pos", "initSelector", "setBaseData", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "selectCallback", "Companion", "plugin-finder_release"})
public final class f
  implements p
{
  public static final a xVi;
  private MMHandler knk;
  private WxRecyclerView xUj;
  private Runnable xVd;
  private com.tencent.mm.plugin.finder.model.x xVe;
  x<Integer, ViewGroup, y> xVf;
  private ArrayList<r<Integer, ViewGroup, y>> xVg;
  private ArrayList<r<Integer, ViewGroup, y>> xVh;
  
  static
  {
    AppMethodBeat.i(268450);
    xVi = new a((byte)0);
    AppMethodBeat.o(268450);
  }
  
  public f()
  {
    AppMethodBeat.i(268449);
    this.knk = new MMHandler(Looper.getMainLooper());
    this.xVg = new ArrayList();
    this.xVh = new ArrayList();
    AppMethodBeat.o(268449);
  }
  
  private final void Lg(long paramLong)
  {
    AppMethodBeat.i(268446);
    if (this.xVd != null)
    {
      this.knk.removeCallbacks(this.xVd);
      this.xVd = null;
    }
    this.xVd = ((Runnable)new b(this));
    this.knk.postDelayed(this.xVd, paramLong);
    AppMethodBeat.o(268446);
  }
  
  public final void a(WxRecyclerView paramWxRecyclerView, bu parambu, x<Integer, ViewGroup, y> paramx)
  {
    AppMethodBeat.i(268444);
    kotlin.g.b.p.k(paramWxRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parambu, "dataSet");
    kotlin.g.b.p.k(paramx, "selectCallback");
    this.xUj = paramWxRecyclerView;
    if (!(parambu instanceof com.tencent.mm.plugin.finder.model.x)) {}
    for (paramWxRecyclerView = null;; paramWxRecyclerView = parambu)
    {
      this.xVe = ((com.tencent.mm.plugin.finder.model.x)paramWxRecyclerView);
      this.xVf = paramx;
      paramWxRecyclerView = this.xUj;
      if (paramWxRecyclerView != null) {
        paramWxRecyclerView.a((RecyclerView.l)new f.c(this));
      }
      paramWxRecyclerView = this.xUj;
      if (paramWxRecyclerView != null)
      {
        paramWxRecyclerView.a((RecyclerView.i)new d(this));
        AppMethodBeat.o(268444);
        return;
      }
      AppMethodBeat.o(268444);
      return;
    }
  }
  
  public final void dwn()
  {
    AppMethodBeat.i(268443);
    Lg(0L);
    AppMethodBeat.o(268443);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$Companion;", "", "()V", "NOTIFY_BUFFERING_START_DELAY_MS", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(267266);
      f.d(this.xVj);
      AppMethodBeat.o(267266);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$2", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.i
  {
    public final void aT(View paramView)
    {
      AppMethodBeat.i(288369);
      kotlin.g.b.p.k(paramView, "view");
      AppMethodBeat.o(288369);
    }
    
    public final void aU(final View paramView)
    {
      AppMethodBeat.i(288368);
      kotlin.g.b.p.k(paramView, "view");
      f.b(this.xVj).post((Runnable)new a(this, paramView));
      AppMethodBeat.o(288368);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.d paramd, View paramView) {}
      
      public final void run()
      {
        AppMethodBeat.i(281571);
        if ((paramView instanceof ViewGroup))
        {
          Log.i("FinderLiveLivePlayRecyclerViewSelector", "view:" + paramView + " detached!");
          f.c(this.xVk.xVj).clear();
          f.c(this.xVk.xVj).add(new r(Integer.valueOf(-1), paramView, null));
          x localx = this.xVk.xVj.xVf;
          if (localx != null)
          {
            localx.ei((List)f.c(this.xVk.xVj));
            AppMethodBeat.o(281571);
            return;
          }
        }
        AppMethodBeat.o(281571);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.f
 * JD-Core Version:    0.7.0.1
 */