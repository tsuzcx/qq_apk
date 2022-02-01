package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;

final class ExdeviceProfileUI$28
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$28(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(179624);
    paramMenuItem = new e(this.peX.getContext(), 1, false);
    paramMenuItem.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(179623);
        if (!bt.isNullOrNil(ExdeviceProfileUI.o(ExdeviceProfileUI.28.this.peX))) {
          paramAnonymousl.c(5, ExdeviceProfileUI.28.this.peX.getString(2131758574));
        }
        paramAnonymousl.c(3, ExdeviceProfileUI.28.this.peX.getString(2131758570));
        AppMethodBeat.o(179623);
      }
    };
    paramMenuItem.HrY = ExdeviceProfileUI.n(this.peX);
    paramMenuItem.csG();
    AppMethodBeat.o(179624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.28
 * JD-Core Version:    0.7.0.1
 */