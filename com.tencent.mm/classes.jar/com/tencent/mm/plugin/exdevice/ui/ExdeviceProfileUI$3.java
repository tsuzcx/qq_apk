package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceProfileUI$3
  implements Runnable
{
  ExdeviceProfileUI$3(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20025);
    ExdeviceProfileUI.g(this.lOl);
    ExdeviceProfileUI.l(this.lOl).notifyDataSetChanged();
    AppMethodBeat.o(20025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.3
 * JD-Core Version:    0.7.0.1
 */