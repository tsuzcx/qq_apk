package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionContactConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "contactViewList", "", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ad
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private final List<View> rcb;
  
  public ad()
  {
    AppMethodBeat.i(201341);
    this.rcb = ((List)new ArrayList());
    AppMethodBeat.o(201341);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201339);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    paramRecyclerView = this.rcb;
    View localView = parame.adJ(2131307952);
    k.g(localView, "holder.getView(R.id.section_item_bottom_1)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rcb;
    localView = parame.adJ(2131307953);
    k.g(localView, "holder.getView(R.id.section_item_bottom_2)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.rcb;
    parame = parame.adJ(2131307954);
    k.g(parame, "holder.getView(R.id.section_item_bottom_3)");
    paramRecyclerView.add(parame);
    AppMethodBeat.o(201339);
  }
  
  public final int getLayoutId()
  {
    return 2131496217;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */