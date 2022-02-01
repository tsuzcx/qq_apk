package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionContactConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "contactViewList", "", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ae
  extends b<c>
{
  private final List<View> rOX;
  
  public ae()
  {
    AppMethodBeat.i(201435);
    this.rOX = ((List)new ArrayList());
    AppMethodBeat.o(201435);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201433);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = this.rOX;
    View localView = parame.Gd(2131307952);
    p.g(localView, "holder.getView(R.id.section_item_bottom_1)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rOX;
    localView = parame.Gd(2131307953);
    p.g(localView, "holder.getView(R.id.section_item_bottom_2)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rOX;
    parame = parame.Gd(2131307954);
    p.g(parame, "holder.getView(R.id.section_item_bottom_3)");
    paramRecyclerView.add(parame);
    AppMethodBeat.o(201433);
  }
  
  public final int getLayoutId()
  {
    return 2131496217;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */