package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.w;

final class ExdeviceProfileUI$25$1
  implements DialogInterface.OnClickListener
{
  ExdeviceProfileUI$25$1(ExdeviceProfileUI.25 param25) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24127);
    bh.bCz();
    paramDialogInterface = c.bzA().JE(ExdeviceProfileUI.p(this.yBG.yBy));
    d.rG(37);
    ab.s(paramDialogInterface);
    ExdeviceProfileUI.q(this.yBG.yBy).alive();
    if (ExdeviceProfileUI.c(this.yBG.yBy) != null) {
      ExdeviceProfileUI.c(this.yBG.yBy).show();
    }
    AppMethodBeat.o(24127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.25.1
 * JD-Core Version:    0.7.0.1
 */