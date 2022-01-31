package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class ExdeviceAddDataSourceUI$3$1
  implements DialogInterface.OnCancelListener
{
  ExdeviceAddDataSourceUI$3$1(ExdeviceAddDataSourceUI.3 param3) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(19771);
    aw.Rc().a(ExdeviceAddDataSourceUI.g(this.lKe.lKc));
    ExdeviceAddDataSourceUI.h(this.lKe.lKc);
    paramDialogInterface = ExdeviceAddDataSourceUI.c(this.lKe.lKc).LN(this.lKe.lKd);
    if (paramDialogInterface != null) {
      paramDialogInterface.lKj = ExdeviceAddDataSourceUI.c.lKk;
    }
    AppMethodBeat.o(19771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.3.1
 * JD-Core Version:    0.7.0.1
 */