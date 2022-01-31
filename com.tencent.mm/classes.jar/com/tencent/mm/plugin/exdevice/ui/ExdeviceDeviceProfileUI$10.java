package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.da;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;

final class ExdeviceDeviceProfileUI$10
  implements DialogInterface.OnCancelListener
{
  ExdeviceDeviceProfileUI$10(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().b(536, this.jDf);
    paramDialogInterface = new da();
    paramDialogInterface.bJg.opType = 2;
    paramDialogInterface.bJg.bJk = this.bEe;
    a.udP.m(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.10
 * JD-Core Version:    0.7.0.1
 */