package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;

final class ExdeviceProfileUI$27
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$27(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24124);
    paramMenuItem = new e(this.peX.getContext(), 1, false);
    paramMenuItem.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(24123);
        paramAnonymousl.c(2, ExdeviceProfileUI.27.this.peX.getString(2131758575));
        AppMethodBeat.o(24123);
      }
    };
    paramMenuItem.HrY = ExdeviceProfileUI.n(this.peX);
    paramMenuItem.csG();
    AppMethodBeat.o(24124);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.27
 * JD-Core Version:    0.7.0.1
 */