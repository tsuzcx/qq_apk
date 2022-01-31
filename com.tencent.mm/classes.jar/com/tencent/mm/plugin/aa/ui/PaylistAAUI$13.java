package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.ui.widget.b.d;

final class PaylistAAUI$13
  implements MenuItem.OnMenuItemClickListener
{
  PaylistAAUI$13(PaylistAAUI paramPaylistAAUI, v paramv) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40881);
    paramMenuItem = new d(this.grF, 1, false);
    paramMenuItem.sao = new PaylistAAUI.13.1(this);
    paramMenuItem.sap = new PaylistAAUI.13.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(40881);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.13
 * JD-Core Version:    0.7.0.1
 */