package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class ModSafeDeviceNameUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ModSafeDeviceNameUI$2(ModSafeDeviceNameUI paramModSafeDeviceNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ModSafeDeviceNameUI.a(this.fke, ModSafeDeviceNameUI.a(this.fke).getText().toString());
    if (bk.bl(ModSafeDeviceNameUI.b(this.fke))) {
      return true;
    }
    this.fke.XM();
    paramMenuItem = new c(ModSafeDeviceNameUI.c(this.fke), ModSafeDeviceNameUI.b(this.fke), ModSafeDeviceNameUI.d(this.fke));
    g.Dk().a(paramMenuItem, 0);
    ModSafeDeviceNameUI.a(this.fke, h.b(this.fke, a.ac(this.fke, a.d.app_waiting), true, new ModSafeDeviceNameUI.2.1(this, paramMenuItem)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.2
 * JD-Core Version:    0.7.0.1
 */