package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "pageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Lkotlin/collections/ArrayList;", "dispatchHidePanel", "", "dispatchKeyboardChange", "show", "", "height", "", "dispatchMicSettingChanged", "micSettingFlag", "", "dispatchUpdateLinkList", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "ApplyLinkViewHolder", "Companion", "plugin-finder_release"})
public final class i
  extends RecyclerView.a<a>
{
  private static final int yWt = 0;
  private static final int yWu = 1;
  public static final b yWv;
  public final ArrayList<FinderLiveApplyLinkView> mcZ;
  public a xYp;
  private final an ybM;
  
  static
  {
    AppMethodBeat.i(269064);
    yWv = new b((byte)0);
    yWu = 1;
    AppMethodBeat.o(269064);
  }
  
  public i(an paraman)
  {
    AppMethodBeat.i(269063);
    this.ybM = paraman;
    this.mcZ = new ArrayList();
    AppMethodBeat.o(269063);
  }
  
  public final void dFo()
  {
    AppMethodBeat.i(269062);
    Iterator localIterator = ((Iterable)this.mcZ).iterator();
    while (localIterator.hasNext()) {
      ((FinderLiveApplyLinkView)localIterator.next()).dEV();
    }
    AppMethodBeat.o(269062);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(269059);
    int i = this.mcZ.size();
    AppMethodBeat.o(269059);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return yWt;
    }
    return yWu;
  }
  
  public final void o(a parama)
  {
    AppMethodBeat.i(269061);
    Iterator localIterator = ((Iterable)this.mcZ).iterator();
    while (localIterator.hasNext()) {
      ((FinderLiveApplyLinkView)localIterator.next()).n(parama);
    }
    AppMethodBeat.o(269061);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pageView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;)V", "getPageView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final FinderLiveApplyLinkView yWw;
    
    public a(FinderLiveApplyLinkView paramFinderLiveApplyLinkView)
    {
      super();
      AppMethodBeat.i(225730);
      this.yWw = paramFinderLiveApplyLinkView;
      AppMethodBeat.o(225730);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$Companion;", "", "()V", "PAGE_TYPE_ANCHOR", "", "getPAGE_TYPE_ANCHOR", "()I", "PAGE_TYPE_VISITOR", "getPAGE_TYPE_VISITOR", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.i
 * JD-Core Version:    0.7.0.1
 */