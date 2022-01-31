package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class ExdeviceProfileUI$26
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$26(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20053);
    paramMenuItem = new d(this.lOl.getContext(), 1, false);
    paramMenuItem.sao = new ExdeviceProfileUI.26.1(this);
    paramMenuItem.sap = ExdeviceProfileUI.n(this.lOl);
    paramMenuItem.crd();
    AppMethodBeat.o(20053);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26
 * JD-Core Version:    0.7.0.1
 */