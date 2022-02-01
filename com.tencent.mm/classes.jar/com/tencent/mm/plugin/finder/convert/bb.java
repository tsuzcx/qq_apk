package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionContactConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "contactViewList", "", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class bb
  extends e<c>
{
  private final List<View> tEI;
  
  public bb()
  {
    AppMethodBeat.i(243176);
    this.tEI = ((List)new ArrayList());
    AppMethodBeat.o(243176);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243174);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = this.tEI;
    View localView = paramh.Mn(2131307455);
    p.g(localView, "holder.getView(R.id.section_item_bottom_1)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.tEI;
    localView = paramh.Mn(2131307456);
    p.g(localView, "holder.getView(R.id.section_item_bottom_2)");
    paramRecyclerView.add(localView);
    paramRecyclerView = this.tEI;
    paramh = paramh.Mn(2131307457);
    p.g(paramh, "holder.getView(R.id.section_item_bottom_3)");
    paramRecyclerView.add(paramh);
    AppMethodBeat.o(243174);
  }
  
  public final int getLayoutId()
  {
    return 2131494351;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bb
 * JD-Core Version:    0.7.0.1
 */