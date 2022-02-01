package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.d;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedFooterNoMoreData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class p
  extends b<d>
{
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201822);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201822);
  }
  
  public final int getLayoutId()
  {
    return 2131496264;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.p
 * JD-Core Version:    0.7.0.1
 */