package com.tencent.mm.plugin.exdevice.ui;

import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceAddDataSourceUI$4$1
  implements Runnable
{
  ExdeviceAddDataSourceUI$4$1(ExdeviceAddDataSourceUI.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(19773);
    if ((ExdeviceAddDataSourceUI.a(this.lKf.lKc)) && (!ExdeviceAddDataSourceUI.b(this.lKf.lKc).isProviderEnabled("gps")))
    {
      ExdeviceAddDataSourceUI.a(this.lKf.lKc, 4);
      AppMethodBeat.o(19773);
      return;
    }
    ExdeviceAddDataSourceUI.a(this.lKf.lKc, 3);
    ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
    AppMethodBeat.o(19773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4.1
 * JD-Core Version:    0.7.0.1
 */