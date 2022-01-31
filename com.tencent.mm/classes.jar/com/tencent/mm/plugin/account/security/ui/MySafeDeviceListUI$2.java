package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.b;

final class MySafeDeviceListUI$2
  implements DialogInterface.OnCancelListener
{
  MySafeDeviceListUI$2(MySafeDeviceListUI paramMySafeDeviceListUI, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(69873);
    g.Rc().a(this.gBE);
    AppMethodBeat.o(69873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.2
 * JD-Core Version:    0.7.0.1
 */