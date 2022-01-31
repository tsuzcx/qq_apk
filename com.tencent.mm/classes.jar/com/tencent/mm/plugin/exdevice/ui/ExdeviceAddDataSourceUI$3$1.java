package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;

final class ExdeviceAddDataSourceUI$3$1
  implements DialogInterface.OnCancelListener
{
  ExdeviceAddDataSourceUI$3$1(ExdeviceAddDataSourceUI.3 param3) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(ExdeviceAddDataSourceUI.g(this.jAF.jAD));
    ExdeviceAddDataSourceUI.h(this.jAF.jAD);
    paramDialogInterface = ExdeviceAddDataSourceUI.c(this.jAF.jAD).BL(this.jAF.jAE);
    if (paramDialogInterface != null) {
      paramDialogInterface.jAK = ExdeviceAddDataSourceUI.c.jAL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.3.1
 * JD-Core Version:    0.7.0.1
 */