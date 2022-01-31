package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceProfileUI$30
  implements n.c
{
  ExdeviceProfileUI$30(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(20058);
    if (ExdeviceProfileUI.x(this.lOl))
    {
      paraml.e(1, this.lOl.getString(2131299443));
      AppMethodBeat.o(20058);
      return;
    }
    paraml.e(4, this.lOl.getString(2131299449));
    AppMethodBeat.o(20058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.30
 * JD-Core Version:    0.7.0.1
 */