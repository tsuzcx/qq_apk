package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceProfileUI$1$3
  implements Runnable
{
  ExdeviceProfileUI$1$3(ExdeviceProfileUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(20022);
    ExdeviceProfileUI.k(this.lOn.lOl);
    ExdeviceProfileUI.l(this.lOn.lOl).notifyDataSetChanged();
    AppMethodBeat.o(20022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1.3
 * JD-Core Version:    0.7.0.1
 */