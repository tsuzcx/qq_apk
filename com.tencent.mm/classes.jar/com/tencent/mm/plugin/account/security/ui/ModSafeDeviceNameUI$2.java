package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class ModSafeDeviceNameUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ModSafeDeviceNameUI$2(ModSafeDeviceNameUI paramModSafeDeviceNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69864);
    ModSafeDeviceNameUI.a(this.gBv, ModSafeDeviceNameUI.a(this.gBv).getText().toString());
    if (bo.isNullOrNil(ModSafeDeviceNameUI.b(this.gBv)))
    {
      AppMethodBeat.o(69864);
      return true;
    }
    this.gBv.hideVKB();
    paramMenuItem = new c(ModSafeDeviceNameUI.c(this.gBv), ModSafeDeviceNameUI.b(this.gBv), ModSafeDeviceNameUI.d(this.gBv));
    g.Rc().a(paramMenuItem, 0);
    ModSafeDeviceNameUI.a(this.gBv, h.b(this.gBv, a.aq(this.gBv, 2131297112), true, new ModSafeDeviceNameUI.2.1(this, paramMenuItem)));
    AppMethodBeat.o(69864);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.2
 * JD-Core Version:    0.7.0.1
 */