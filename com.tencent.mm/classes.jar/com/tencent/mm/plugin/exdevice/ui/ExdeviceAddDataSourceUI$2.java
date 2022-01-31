package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ui.base.p;

final class ExdeviceAddDataSourceUI$2
  implements Runnable
{
  ExdeviceAddDataSourceUI$2(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    if ((ExdeviceAddDataSourceUI.f(this.jAD) != null) && (ExdeviceAddDataSourceUI.f(this.jAD).isShowing())) {
      ExdeviceAddDataSourceUI.f(this.jAD).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.2
 * JD-Core Version:    0.7.0.1
 */