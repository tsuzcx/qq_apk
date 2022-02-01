package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

final class ExdeviceAddDataSourceUI$7
  implements Runnable
{
  ExdeviceAddDataSourceUI$7(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(23849);
    ac.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
    vc localvc = new vc();
    a.GpY.l(localvc);
    AppMethodBeat.o(23849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.7
 * JD-Core Version:    0.7.0.1
 */