package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class ExdeviceManageDeviceUI$a$1
  implements n.d
{
  ExdeviceManageDeviceUI$a$1(ExdeviceManageDeviceUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    int i = this.jDH.getCount();
    y.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((paramInt < 0) || (paramInt >= i)) {
      return;
    }
    ExdeviceManageDeviceUI.a.a(this.jDH, paramInt);
    ExdeviceManageDeviceUI.a.a(this.jDH, (b)ExdeviceManageDeviceUI.a.a(this.jDH).get(paramInt));
    this.jDH.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.1
 * JD-Core Version:    0.7.0.1
 */