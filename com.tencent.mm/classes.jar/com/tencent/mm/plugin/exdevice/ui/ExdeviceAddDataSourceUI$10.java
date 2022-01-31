package com.tencent.mm.plugin.exdevice.ui;

import android.app.Dialog;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class ExdeviceAddDataSourceUI$10
  implements Runnable
{
  ExdeviceAddDataSourceUI$10(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI, ExdeviceAddDataSourceUI.b paramb) {}
  
  public final void run()
  {
    h.a(this.jAD, R.l.exdevice_connect_failed_tips, R.l.exdevice_connect_failed, R.l.exdevice_connect_failed_confirm, R.l.exdevice_connect_help, false, new ExdeviceAddDataSourceUI.10.1(this), new ExdeviceAddDataSourceUI.10.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.10
 * JD-Core Version:    0.7.0.1
 */