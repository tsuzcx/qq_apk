package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class ExdeviceManageDeviceUI$a$1
  implements n.d
{
  ExdeviceManageDeviceUI$a$1(ExdeviceManageDeviceUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(19983);
    paramInt = paramMenuItem.getItemId();
    int i = this.lNf.getCount();
    ab.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(19983);
      return;
    }
    ExdeviceManageDeviceUI.a.a(this.lNf, paramInt);
    ExdeviceManageDeviceUI.a.a(this.lNf, (b)ExdeviceManageDeviceUI.a.a(this.lNf).get(paramInt));
    this.lNf.notifyDataSetChanged();
    AppMethodBeat.o(19983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.1
 * JD-Core Version:    0.7.0.1
 */