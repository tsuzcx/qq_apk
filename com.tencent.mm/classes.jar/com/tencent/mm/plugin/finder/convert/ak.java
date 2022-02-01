package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionContactConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "contactViewList", "", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ak
  extends b<v>
{
  private final List<View> KLo;
  
  public ak()
  {
    AppMethodBeat.i(197466);
    this.KLo = ((List)new ArrayList());
    AppMethodBeat.o(197466);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197464);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    paramRecyclerView = this.KLo;
    View localView = parame.abq(2131307844);
    k.g(localView, "holder.getView(R.id.section_item_bottom_1)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.KLo;
    localView = parame.abq(2131307845);
    k.g(localView, "holder.getView(R.id.section_item_bottom_2)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.KLo;
    parame = parame.abq(2131307846);
    k.g(parame, "holder.getView(R.id.section_item_bottom_3)");
    paramRecyclerView.add(parame);
    AppMethodBeat.o(197464);
  }
  
  public final int getLayoutId()
  {
    return 2131496216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ak
 * JD-Core Version:    0.7.0.1
 */