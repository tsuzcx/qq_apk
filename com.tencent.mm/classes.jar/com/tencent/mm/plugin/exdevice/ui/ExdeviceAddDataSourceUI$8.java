package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceAddDataSourceUI$8
  implements Runnable
{
  ExdeviceAddDataSourceUI$8(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19782);
    ExdeviceAddDataSourceUI.c(this.lKc).bt(ExdeviceAddDataSourceUI.d(this.lKc));
    ExdeviceAddDataSourceUI.c(this.lKc).notifyDataSetChanged();
    AppMethodBeat.o(19782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.8
 * JD-Core Version:    0.7.0.1
 */