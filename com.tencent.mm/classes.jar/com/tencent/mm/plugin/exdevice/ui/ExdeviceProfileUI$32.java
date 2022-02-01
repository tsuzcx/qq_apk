package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceProfileUI$32
  implements n.c
{
  ExdeviceProfileUI$32(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(179629);
    if (ExdeviceProfileUI.x(this.peX))
    {
      paraml.c(1, this.peX.getString(2131758573));
      AppMethodBeat.o(179629);
      return;
    }
    paraml.c(4, this.peX.getString(2131758579));
    AppMethodBeat.o(179629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.32
 * JD-Core Version:    0.7.0.1
 */