package com.tencent.mm.plugin.exdevice.ui;

import android.location.LocationManager;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceAddDataSourceUI$4$1
  implements Runnable
{
  ExdeviceAddDataSourceUI$4$1(ExdeviceAddDataSourceUI.4 param4) {}
  
  public final void run()
  {
    if ((ExdeviceAddDataSourceUI.a(this.jAG.jAD)) && (!ExdeviceAddDataSourceUI.b(this.jAG.jAD).isProviderEnabled("gps")))
    {
      ExdeviceAddDataSourceUI.a(this.jAG.jAD, 4);
      return;
    }
    ExdeviceAddDataSourceUI.a(this.jAG.jAD, 3);
    y.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4.1
 * JD-Core Version:    0.7.0.1
 */