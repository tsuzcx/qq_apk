package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;

final class ExdeviceDeviceProfileUI$10
  implements DialogInterface.OnCancelListener
{
  ExdeviceDeviceProfileUI$10(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(19947);
    aw.Rc().b(536, this.lMD);
    paramDialogInterface = new dd();
    paramDialogInterface.cqA.opType = 2;
    paramDialogInterface.cqA.cqE = this.ckS;
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(19947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.10
 * JD-Core Version:    0.7.0.1
 */