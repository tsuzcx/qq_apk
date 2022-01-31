package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceAddDataSourceUI$2
  implements Runnable
{
  ExdeviceAddDataSourceUI$2(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19770);
    if ((ExdeviceAddDataSourceUI.f(this.lKc) != null) && (ExdeviceAddDataSourceUI.f(this.lKc).isShowing())) {
      ExdeviceAddDataSourceUI.f(this.lKc).dismiss();
    }
    AppMethodBeat.o(19770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.2
 * JD-Core Version:    0.7.0.1
 */