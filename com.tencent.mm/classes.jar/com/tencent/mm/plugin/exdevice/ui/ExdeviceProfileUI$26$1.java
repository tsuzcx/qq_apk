package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceProfileUI$26$1
  implements n.c
{
  ExdeviceProfileUI$26$1(ExdeviceProfileUI.26 param26) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(20052);
    if (!bo.isNullOrNil(ExdeviceProfileUI.o(this.lOs.lOl))) {
      paraml.e(5, this.lOs.lOl.getString(2131299444));
    }
    paraml.e(3, this.lOs.lOl.getString(2131299440));
    AppMethodBeat.o(20052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26.1
 * JD-Core Version:    0.7.0.1
 */