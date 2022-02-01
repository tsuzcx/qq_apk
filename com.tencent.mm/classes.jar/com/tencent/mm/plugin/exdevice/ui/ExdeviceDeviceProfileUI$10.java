package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.b.a;

final class ExdeviceDeviceProfileUI$10
  implements DialogInterface.OnCancelListener
{
  ExdeviceDeviceProfileUI$10(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24016);
    ba.aiU().b(536, this.qke);
    paramDialogInterface = new dn();
    paramDialogInterface.don.opType = 2;
    paramDialogInterface.don.dor = this.diy;
    a.IbL.l(paramDialogInterface);
    AppMethodBeat.o(24016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.10
 * JD-Core Version:    0.7.0.1
 */