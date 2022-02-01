package com.tencent.mm.plugin.card.ui.v4;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
final class HistoryCardListUI$i
  implements MRecyclerView.b
{
  HistoryCardListUI$i(HistoryCardListUI paramHistoryCardListUI) {}
  
  public final boolean V(View paramView, int paramInt)
  {
    AppMethodBeat.i(244596);
    HistoryCardListUI localHistoryCardListUI = this.tFv;
    p.j(paramView, "view");
    boolean bool = HistoryCardListUI.a(localHistoryCardListUI, paramInt, paramView);
    AppMethodBeat.o(244596);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI.i
 * JD-Core Version:    0.7.0.1
 */