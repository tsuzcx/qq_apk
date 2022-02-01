package com.tencent.mm.plugin.card.ui.v4;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class HistoryCardListUI$l
  implements MenuItem.OnMenuItemClickListener
{
  HistoryCardListUI$l(HistoryCardListUI paramHistoryCardListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(247250);
    this.tFv.finish();
    AppMethodBeat.o(247250);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI.l
 * JD-Core Version:    0.7.0.1
 */