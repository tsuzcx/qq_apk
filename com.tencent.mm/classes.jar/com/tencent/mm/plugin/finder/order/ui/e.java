package com.tencent.mm.plugin.finder.order.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/SpuCollapseConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/order/data/SpuCollapseFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<com.tencent.mm.plugin.finder.order.data.e>
{
  private static final void a(com.tencent.mm.plugin.finder.order.data.e parame, View paramView)
  {
    AppMethodBeat.i(332383);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/ui/SpuCollapseConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "$item");
    parame.meC.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/ui/SpuCollapseConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332383);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(332402);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(332402);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.e
 * JD-Core Version:    0.7.0.1
 */