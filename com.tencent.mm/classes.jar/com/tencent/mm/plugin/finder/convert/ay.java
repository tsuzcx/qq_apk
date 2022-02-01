package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryHistoryConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class ay
  extends e<ap>
{
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(286511);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(286511);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_history_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ay
 * JD-Core Version:    0.7.0.1
 */