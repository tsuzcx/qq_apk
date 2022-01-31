package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceAddDataSourceUI$9
  implements Runnable
{
  ExdeviceAddDataSourceUI$9(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19783);
    ExdeviceAddDataSourceUI.e(this.lKc).setVisibility(8);
    ExdeviceAddDataSourceUI.c(this.lKc).notifyDataSetChanged();
    AppMethodBeat.o(19783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.9
 * JD-Core Version:    0.7.0.1
 */