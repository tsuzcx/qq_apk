package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceAddDataSourceUI$7
  implements Runnable
{
  ExdeviceAddDataSourceUI$7(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19781);
    ab.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
    sv localsv = new sv();
    a.ymk.l(localsv);
    AppMethodBeat.o(19781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.7
 * JD-Core Version:    0.7.0.1
 */