package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$29$1
  implements DialogInterface.OnClickListener
{
  ExdeviceProfileUI$29$1(ExdeviceProfileUI.29 param29) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    au.Hx();
    paramDialogInterface = com.tencent.mm.model.c.Fw().abl(ExdeviceProfileUI.u(this.jEV.jEM));
    d.jdMethod_if(37);
    s.g(paramDialogInterface);
    ExdeviceProfileUI.v(this.jEV.jEM).cqo();
    if (ExdeviceProfileUI.d(this.jEV.jEM) != null) {
      ExdeviceProfileUI.d(this.jEV.jEM).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29.1
 * JD-Core Version:    0.7.0.1
 */