package com.tencent.mm.plugin.finder.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderPostAtUI$f
  implements MenuItem.OnMenuItemClickListener
{
  FinderPostAtUI$f(FinderPostAtUI paramFinderPostAtUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(203259);
    this.rJy.finish();
    AppMethodBeat.o(203259);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI.f
 * JD-Core Version:    0.7.0.1
 */