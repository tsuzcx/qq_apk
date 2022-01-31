package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceAddDataSourceUI$4$3
  implements Runnable
{
  ExdeviceAddDataSourceUI$4$3(ExdeviceAddDataSourceUI.4 param4) {}
  
  public final void run()
  {
    if (a.awB())
    {
      ExdeviceAddDataSourceUI.a(this.jAG.jAD, 3);
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
      return;
    }
    ExdeviceAddDataSourceUI.a(this.jAG.jAD, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4.3
 * JD-Core Version:    0.7.0.1
 */