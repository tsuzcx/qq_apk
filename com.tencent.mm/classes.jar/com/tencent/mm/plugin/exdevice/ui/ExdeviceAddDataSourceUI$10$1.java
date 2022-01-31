package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ExdeviceAddDataSourceUI$10$1
  implements DialogInterface.OnClickListener
{
  ExdeviceAddDataSourceUI$10$1(ExdeviceAddDataSourceUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(19784);
    ExdeviceAddDataSourceUI.d(this.lKh.lKc).remove(this.lKh.lKg);
    ExdeviceAddDataSourceUI.c(this.lKh.lKc).bt(ExdeviceAddDataSourceUI.d(this.lKh.lKc));
    ExdeviceAddDataSourceUI.c(this.lKh.lKc).notifyDataSetChanged();
    AppMethodBeat.o(19784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.10.1
 * JD-Core Version:    0.7.0.1
 */