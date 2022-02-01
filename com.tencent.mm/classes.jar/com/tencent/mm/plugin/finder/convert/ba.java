package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgSysMsgConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgSysHead;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ba
  extends b<ak>
{
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201912);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201912);
  }
  
  public final int getLayoutId()
  {
    return 2131496235;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ba
 * JD-Core Version:    0.7.0.1
 */