package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.b;

final class MySafeDeviceListUI$2
  implements DialogInterface.OnCancelListener
{
  MySafeDeviceListUI$2(MySafeDeviceListUI paramMySafeDeviceListUI, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125555);
    g.aeS().a(this.ioY);
    AppMethodBeat.o(125555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.2
 * JD-Core Version:    0.7.0.1
 */