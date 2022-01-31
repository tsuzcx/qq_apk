package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;

final class ExdeviceProfileUI$23
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$23(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20049);
    paramMenuItem = new d(this.lOl.getContext(), 1, false);
    paramMenuItem.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(20048);
        paramAnonymousl.e(2, ExdeviceProfileUI.23.this.lOl.getString(2131299445));
        AppMethodBeat.o(20048);
      }
    };
    paramMenuItem.sap = ExdeviceProfileUI.n(this.lOl);
    paramMenuItem.crd();
    AppMethodBeat.o(20049);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.23
 * JD-Core Version:    0.7.0.1
 */