package com.tencent.mm.plugin.finder.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderSelfUI$c
  implements MenuItem.OnMenuItemClickListener
{
  FinderSelfUI$c(FinderSelfUI paramFinderSelfUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(167585);
    this.qPI.onBackPressed();
    AppMethodBeat.o(167585);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.c
 * JD-Core Version:    0.7.0.1
 */