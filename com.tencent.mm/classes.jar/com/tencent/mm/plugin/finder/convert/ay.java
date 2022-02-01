package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryRecordConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryRecordData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ay
  extends e<ap>
{
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243165);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243165);
  }
  
  public final int getLayoutId()
  {
    return 2131494430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ay
 * JD-Core Version:    0.7.0.1
 */