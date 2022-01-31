package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class ExdeviceProfileUI$23
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$23(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.jEM.mController.uMN, 1, false);
    paramMenuItem.phH = new ExdeviceProfileUI.23.1(this);
    paramMenuItem.phI = ExdeviceProfileUI.n(this.jEM);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.23
 * JD-Core Version:    0.7.0.1
 */