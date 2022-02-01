package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.a.e;

final class ExdeviceProfileUI$12
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceProfileUI$12(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24106);
    paramMenuItem = new e(this.vpc.getContext(), 1, false);
    paramMenuItem.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(24105);
        paramAnonymouso.b(0, ExdeviceProfileUI.12.this.vpc.getString(R.l.eDK), R.k.bottomsheet_icon_transmit);
        paramAnonymouso.b(1, ExdeviceProfileUI.12.this.vpc.getString(R.l.eDM), R.k.bottomsheet_icon_moment);
        AppMethodBeat.o(24105);
      }
    };
    paramMenuItem.ODU = ExdeviceProfileUI.j(this.vpc);
    paramMenuItem.eik();
    AppMethodBeat.o(24106);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.12
 * JD-Core Version:    0.7.0.1
 */