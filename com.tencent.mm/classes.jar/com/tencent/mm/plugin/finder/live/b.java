package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "finderLiveDataModel", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "isFromFloat", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;ZLcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "datas", "getDatas", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "setDatas", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "itemViewList", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getItemViewList", "()Ljava/util/List;", "runningIdleRunnable", "Landroid/os/MessageQueue$IdleHandler;", "getViewManager", "()Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "setViewManager", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;)V", "checkProduceVisitorView", "", "context", "Landroid/content/Context;", "consumeView", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "pos", "", "getItemCount", "onBindViewHolder", "vh", "onCreateViewHolder", "vg", "type", "onViewDetachedFromWindow", "holder", "produceView", "protectViewItemRecycleHealthy", "view", "Landroid/view/View;", "plugin-finder_release"})
public final class b
  extends RecyclerView.a<k>
{
  private final Fragment fragment;
  private final bid reportObj;
  g xUF;
  l xUG;
  final List<FinderLiveVisitorPluginLayout> xUH;
  private MessageQueue.IdleHandler xUI;
  private final boolean xUJ;
  private final FinderLiveViewCallback xUK;
  
  public b(Fragment paramFragment, g paramg, l paraml, boolean paramBoolean, FinderLiveViewCallback paramFinderLiveViewCallback, bid parambid)
  {
    AppMethodBeat.i(228789);
    this.fragment = paramFragment;
    this.xUJ = paramBoolean;
    this.xUK = paramFinderLiveViewCallback;
    this.reportObj = parambid;
    this.xUF = paramg;
    this.xUG = paraml;
    this.xUH = ((List)new ArrayList());
    AppMethodBeat.o(228789);
  }
  
  private final void ew(View paramView)
  {
    AppMethodBeat.i(228785);
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      int j = ((ViewGroup)paramView).getChildCount();
      while (i < j)
      {
        View localView = ((ViewGroup)paramView).getChildAt(i);
        if (localView != null)
        {
          localView.animate().cancel();
          if (localView.hasTransientState()) {
            Log.i("RecyclerViewAdapterEx", "[protectViewItemRecycleHealthy] child=".concat(String.valueOf(localView)));
          }
          ew(localView);
        }
        i += 1;
      }
      paramView.animate().cancel();
    }
    AppMethodBeat.o(228785);
  }
  
  private final void fu(Context arg1)
  {
    AppMethodBeat.i(228742);
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = new FinderLiveVisitorPluginLayout(???, this.fragment, null, this.reportObj);
    synchronized (this.xUH)
    {
      this.xUH.add(localFinderLiveVisitorPluginLayout);
      AppMethodBeat.o(228742);
      return;
    }
  }
  
  private k l(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(228734);
    p.k(paramViewGroup, "vg");
    Log.i("Finder.LiveViewCallback", "onCreateViewHolder type:".concat(String.valueOf(paramInt)));
    Context localContext = paramViewGroup.getContext();
    p.j(localContext, "vg.context");
    fu(localContext);
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setBackgroundColor(-16777216);
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -1));
    paramViewGroup = new k((View)paramViewGroup);
    AppMethodBeat.o(228734);
    return paramViewGroup;
  }
  
  public final f MU(int paramInt)
  {
    AppMethodBeat.i(228771);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      Log.i("Finder.LiveViewCallback", "getData invalid pos:" + paramInt + '!');
      AppMethodBeat.o(228771);
      return null;
    }
    f localf = (f)this.xUF.zeA.get(paramInt);
    AppMethodBeat.o(228771);
    return localf;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(228744);
    int i = this.xUF.zeA.size();
    AppMethodBeat.o(228744);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(b paramb, Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269339);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.xUL.xUG.xUj;
      localObject = c.a(this.sAW, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b
 * JD-Core Version:    0.7.0.1
 */