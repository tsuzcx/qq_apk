package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class ExdeviceProfileUI$29
  implements o.f
{
  ExdeviceProfileUI$29(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(179629);
    if (ExdeviceProfileUI.s(this.rJu))
    {
      paramm.d(1, this.rJu.getString(2131758874));
      AppMethodBeat.o(179629);
      return;
    }
    paramm.d(4, this.rJu.getString(2131758880));
    AppMethodBeat.o(179629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29
 * JD-Core Version:    0.7.0.1
 */