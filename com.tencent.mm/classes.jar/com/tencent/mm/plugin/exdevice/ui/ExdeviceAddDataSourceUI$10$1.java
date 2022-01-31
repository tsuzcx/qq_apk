package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

final class ExdeviceAddDataSourceUI$10$1
  implements DialogInterface.OnClickListener
{
  ExdeviceAddDataSourceUI$10$1(ExdeviceAddDataSourceUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ExdeviceAddDataSourceUI.d(this.jAI.jAD).remove(this.jAI.jAH);
    ExdeviceAddDataSourceUI.c(this.jAI.jAD).bc(ExdeviceAddDataSourceUI.d(this.jAI.jAD));
    ExdeviceAddDataSourceUI.c(this.jAI.jAD).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.10.1
 * JD-Core Version:    0.7.0.1
 */