package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;

final class MySafeDeviceListUI$4$1
  implements DialogInterface.OnCancelListener
{
  MySafeDeviceListUI$4$1(MySafeDeviceListUI.4 param4, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(69875);
    g.Rc().a(this.gBw);
    AppMethodBeat.o(69875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.4.1
 * JD-Core Version:    0.7.0.1
 */