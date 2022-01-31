package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$18
  implements Runnable
{
  ExdeviceProfileUI$18(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20042);
    if (ExdeviceProfileUI.d(this.lOl) != null) {
      ExdeviceProfileUI.d(this.lOl).show();
    }
    AppMethodBeat.o(20042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.18
 * JD-Core Version:    0.7.0.1
 */