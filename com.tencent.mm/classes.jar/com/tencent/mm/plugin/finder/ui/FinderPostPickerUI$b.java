package com.tencent.mm.plugin.finder.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderPostPickerUI$b
  implements MenuItem.OnMenuItemClickListener
{
  FinderPostPickerUI$b(FinderPostPickerUI paramFinderPostPickerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(167484);
    this.rJF.setResult(0);
    this.rJF.finish();
    AppMethodBeat.o(167484);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostPickerUI.b
 * JD-Core Version:    0.7.0.1
 */