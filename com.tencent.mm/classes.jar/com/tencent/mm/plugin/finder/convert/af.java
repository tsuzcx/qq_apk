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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionContactConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "contactViewList", "", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class af
  extends b<c>
{
  private final List<View> rXy;
  
  public af()
  {
    AppMethodBeat.i(201877);
    this.rXy = ((List)new ArrayList());
    AppMethodBeat.o(201877);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201875);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = this.rXy;
    View localView = parame.GD(2131307952);
    p.g(localView, "holder.getView(R.id.section_item_bottom_1)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rXy;
    localView = parame.GD(2131307953);
    p.g(localView, "holder.getView(R.id.section_item_bottom_2)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rXy;
    parame = parame.GD(2131307954);
    p.g(parame, "holder.getView(R.id.section_item_bottom_3)");
    paramRecyclerView.add(parame);
    AppMethodBeat.o(201875);
  }
  
  public final int getLayoutId()
  {
    return 2131496217;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */