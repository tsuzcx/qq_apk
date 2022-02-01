package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;

final class ExdeviceDeviceProfileUI$10
  implements DialogInterface.OnCancelListener
{
  ExdeviceDeviceProfileUI$10(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24016);
    bg.azz().b(536, this.rHQ);
    paramDialogInterface = new dr();
    paramDialogInterface.dGF.opType = 2;
    paramDialogInterface.dGF.dGJ = this.dAK;
    EventCenter.instance.publish(paramDialogInterface);
    AppMethodBeat.o(24016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.10
 * JD-Core Version:    0.7.0.1
 */