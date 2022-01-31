package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceAddDataSourceUI$4$3
  implements Runnable
{
  ExdeviceAddDataSourceUI$4$3(ExdeviceAddDataSourceUI.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(19775);
    if (a.aWe())
    {
      ExdeviceAddDataSourceUI.a(this.lKf.lKc, 3);
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
      AppMethodBeat.o(19775);
      return;
    }
    ExdeviceAddDataSourceUI.a(this.lKf.lKc, 1);
    AppMethodBeat.o(19775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4.3
 * JD-Core Version:    0.7.0.1
 */