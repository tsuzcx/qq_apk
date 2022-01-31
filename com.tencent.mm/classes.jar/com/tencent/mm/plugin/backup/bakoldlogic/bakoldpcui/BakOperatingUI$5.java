package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BakOperatingUI$5
  implements MenuItem.OnMenuItemClickListener
{
  BakOperatingUI$5(BakOperatingUI paramBakOperatingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17937);
    if (BakOperatingUI.a(this.jIE))
    {
      BakOperatingUI.e(this.jIE);
      AppMethodBeat.o(17937);
      return false;
    }
    BakOperatingUI.b(this.jIE);
    BakOperatingUI.f(this.jIE);
    AppMethodBeat.o(17937);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.5
 * JD-Core Version:    0.7.0.1
 */