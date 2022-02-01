package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "pageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Lkotlin/collections/ArrayList;", "dispatchHidePanel", "", "dispatchKeyboardChange", "show", "", "height", "", "dispatchMicSettingChanged", "micSettingFlag", "", "dispatchUpdateLinkList", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "ApplyLinkViewHolder", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.a<a>
{
  public static final j.b DQo;
  private static final int DQp = 0;
  private static final int DQq;
  public a CvU;
  private final ap CzZ;
  public final ArrayList<FinderLiveApplyLinkView> oVS;
  
  static
  {
    AppMethodBeat.i(358544);
    DQo = new j.b((byte)0);
    DQq = 1;
    AppMethodBeat.o(358544);
  }
  
  public j(ap paramap)
  {
    AppMethodBeat.i(358537);
    this.CzZ = paramap;
    this.oVS = new ArrayList();
    AppMethodBeat.o(358537);
  }
  
  public final void evN()
  {
    AppMethodBeat.i(358584);
    Iterator localIterator = ((Iterable)this.oVS).iterator();
    while (localIterator.hasNext()) {
      ((FinderLiveApplyLinkView)localIterator.next()).euZ();
    }
    AppMethodBeat.o(358584);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358561);
    int i = this.oVS.size();
    AppMethodBeat.o(358561);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return DQp;
    }
    return DQq;
  }
  
  public final void u(a parama)
  {
    AppMethodBeat.i(358572);
    Iterator localIterator = ((Iterable)this.oVS).iterator();
    while (localIterator.hasNext()) {
      ((FinderLiveApplyLinkView)localIterator.next()).t(parama);
    }
    AppMethodBeat.o(358572);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pageView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;)V", "getPageView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final FinderLiveApplyLinkView DQr;
    
    public a(FinderLiveApplyLinkView paramFinderLiveApplyLinkView)
    {
      super();
      AppMethodBeat.i(358898);
      this.DQr = paramFinderLiveApplyLinkView;
      AppMethodBeat.o(358898);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.j
 * JD-Core Version:    0.7.0.1
 */