package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;

final class ModSafeDeviceNameUI$2$1
  implements DialogInterface.OnCancelListener
{
  ModSafeDeviceNameUI$2$1(ModSafeDeviceNameUI.2 param2, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(69863);
    g.Rc().a(this.gBw);
    AppMethodBeat.o(69863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.2.1
 * JD-Core Version:    0.7.0.1
 */