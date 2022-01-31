package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BakOperatingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BakOperatingUI$1(BakOperatingUI paramBakOperatingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17933);
    if (BakOperatingUI.a(this.jIE))
    {
      AppMethodBeat.o(17933);
      return true;
    }
    BakOperatingUI.b(this.jIE);
    BakOperatingUI.c(this.jIE);
    AppMethodBeat.o(17933);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.1
 * JD-Core Version:    0.7.0.1
 */