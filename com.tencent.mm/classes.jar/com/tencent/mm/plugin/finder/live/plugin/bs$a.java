package com.tencent.mm.plugin.finder.live.plugin;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRandomMatchLinkMicStatePlugin$AutoScrollAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRandomMatchLinkMicStatePlugin$ViewHolder;", "()V", "dataList", "", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRandomMatchLinkMicStatePlugin$ItemData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceItemAtPosition", "item", "setDataList", "list", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bs$a
  extends RecyclerView.a<bs.d>
{
  final List<bs.c> dataList;
  
  public bs$a()
  {
    AppMethodBeat.i(353831);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(353831);
  }
  
  public final int getItemCount()
  {
    return 2147483647;
  }
  
  public final void setDataList(List<bs.c> paramList)
  {
    AppMethodBeat.i(353841);
    s.u(paramList, "list");
    this.dataList.clear();
    this.dataList.addAll((Collection)paramList);
    AppMethodBeat.o(353841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bs.a
 * JD-Core Version:    0.7.0.1
 */