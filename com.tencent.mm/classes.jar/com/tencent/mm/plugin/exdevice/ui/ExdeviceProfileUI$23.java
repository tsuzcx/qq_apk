package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;

final class ExdeviceProfileUI$23
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$23(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24120);
    paramMenuItem = new e(this.peX.getContext(), 1, false);
    paramMenuItem.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(24119);
        paramAnonymousl.a(0, ExdeviceProfileUI.23.this.peX.getString(2131758565), 2131689831);
        paramAnonymousl.a(1, ExdeviceProfileUI.23.this.peX.getString(2131758568), 2131689817);
        AppMethodBeat.o(24119);
      }
    };
    paramMenuItem.HrY = ExdeviceProfileUI.n(this.peX);
    paramMenuItem.csG();
    AppMethodBeat.o(24120);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.23
 * JD-Core Version:    0.7.0.1
 */