package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$29$1
  implements DialogInterface.OnClickListener
{
  ExdeviceProfileUI$29$1(ExdeviceProfileUI.29 param29) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20056);
    aw.aaz();
    paramDialogInterface = com.tencent.mm.model.c.YA().arw(ExdeviceProfileUI.u(this.lOt.lOl));
    d.kS(37);
    t.g(paramDialogInterface);
    ExdeviceProfileUI.v(this.lOt.lOl).alive();
    if (ExdeviceProfileUI.d(this.lOt.lOl) != null) {
      ExdeviceProfileUI.d(this.lOt.lOl).show();
    }
    AppMethodBeat.o(20056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29.1
 * JD-Core Version:    0.7.0.1
 */