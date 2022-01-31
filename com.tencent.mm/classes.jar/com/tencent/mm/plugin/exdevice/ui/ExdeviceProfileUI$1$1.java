package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$1$1
  implements Runnable
{
  ExdeviceProfileUI$1$1(ExdeviceProfileUI.1 param1, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(20020);
    if (ExdeviceProfileUI.d(this.lOn.lOl) != null) {
      ExdeviceProfileUI.d(this.lOn.lOl).dismiss();
    }
    ExdeviceProfileUI.a(this.lOn.lOl, this.lOm.lHv);
    ExdeviceProfileUI.f(this.lOn.lOl).setAffectedUserInfo(ExdeviceProfileUI.e(this.lOn.lOl));
    AppMethodBeat.o(20020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1.1
 * JD-Core Version:    0.7.0.1
 */