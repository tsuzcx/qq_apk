package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.f;

final class ExdeviceAddDataSourceUI$10$2
  implements DialogInterface.OnClickListener
{
  ExdeviceAddDataSourceUI$10$2(ExdeviceAddDataSourceUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(19785);
    f.an(this.lKh.lKc.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
    AppMethodBeat.o(19785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.10.2
 * JD-Core Version:    0.7.0.1
 */