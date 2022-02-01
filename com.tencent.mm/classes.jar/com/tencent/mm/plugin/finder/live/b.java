package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewHolder;", "finderLiveDataModel", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "isFromFloat", "", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "autoBindChild", "getAutoBindChild", "()Z", "setAutoBindChild", "(Z)V", "datas", "getDatas", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "setDatas", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;)V", "itemViewList", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getItemViewList", "()Ljava/util/List;", "getViewManager", "()Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "setViewManager", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;)V", "consumeView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "pos", "", "getItemCount", "onBindViewHolder", "vh", "onCreateViewHolder", "vg", "onViewDetachedFromWindow", "holder", "produceView", "protectViewItemRecycleHealthy", "view", "Landroid/view/View;", "plugin-finder_release"})
public final class b
  extends RecyclerView.a<e>
{
  private final bbn reportObj;
  boolean ufl;
  private d ufm;
  f ufn;
  private final List<FinderLiveVisitorPluginLayout> ufo;
  private final boolean ufp;
  
  public b(d paramd, f paramf, boolean paramBoolean, bbn parambbn)
  {
    AppMethodBeat.i(245794);
    this.ufp = paramBoolean;
    this.reportObj = parambbn;
    this.ufl = true;
    this.ufm = paramd;
    this.ufn = paramf;
    this.ufo = ((List)new ArrayList());
    AppMethodBeat.o(245794);
  }
  
  private final void dW(View paramView)
  {
    AppMethodBeat.i(245793);
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
          dW(localView);
        }
        i += 1;
      }
      paramView.animate().cancel();
    }
    AppMethodBeat.o(245793);
  }
  
  private e q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(245787);
    p.h(paramViewGroup, "vg");
    ??? = paramViewGroup.getContext();
    p.g(???, "parent.context");
    FinderLiveVisitorPluginLayout localFinderLiveVisitorPluginLayout = new FinderLiveVisitorPluginLayout((Context)???, null, this.reportObj);
    synchronized (this.ufo)
    {
      this.ufo.add(localFinderLiveVisitorPluginLayout);
      paramViewGroup = new FrameLayout(paramViewGroup.getContext());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -1));
      paramViewGroup = new e((View)paramViewGroup);
      AppMethodBeat.o(245787);
      return paramViewGroup;
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.c IW(int paramInt)
  {
    AppMethodBeat.i(245791);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      localObject = FinderLiveViewCallback.ufM;
      Log.i(FinderLiveViewCallback.access$getTAG$cp(), "getData invalid pos!");
      AppMethodBeat.o(245791);
      return null;
    }
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.c)this.ufm.uCu.get(paramInt);
    AppMethodBeat.o(245791);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(245789);
    int i = this.ufm.uCu.size();
    AppMethodBeat.o(245789);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245786);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.ufq.ufn.ufR;
      localObject = com.tencent.mm.hellhoundlib.b.c.a(this.prP, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245786);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b
 * JD-Core Version:    0.7.0.1
 */