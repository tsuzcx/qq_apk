package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderSearchData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class ci
  extends e<bn>
{
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(273274);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(273274);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_header_search_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ci
 * JD-Core Version:    0.7.0.1
 */