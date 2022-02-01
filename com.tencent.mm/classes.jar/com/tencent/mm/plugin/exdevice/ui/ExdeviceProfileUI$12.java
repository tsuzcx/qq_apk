package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;

final class ExdeviceProfileUI$12
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$12(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24106);
    paramMenuItem = new f(this.yBy.getContext(), 1, false);
    paramMenuItem.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(24105);
        paramAnonymouss.a(0, ExdeviceProfileUI.12.this.yBy.getString(R.l.gGy), R.k.bottomsheet_icon_transmit);
        paramAnonymouss.a(1, ExdeviceProfileUI.12.this.yBy.getString(R.l.gGA), R.k.bottomsheet_icon_moment);
        AppMethodBeat.o(24105);
      }
    };
    paramMenuItem.GAC = ExdeviceProfileUI.j(this.yBy);
    paramMenuItem.dDn();
    AppMethodBeat.o(24106);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.12
 * JD-Core Version:    0.7.0.1
 */