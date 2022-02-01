package com.tencent.mm.plugin.finder.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderSelfUI$aa
  implements MenuItem.OnMenuItemClickListener
{
  FinderSelfUI$aa(FinderSelfUI paramFinderSelfUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(167585);
    this.sRH.onBackPressed();
    AppMethodBeat.o(167585);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.aa
 * JD-Core Version:    0.7.0.1
 */