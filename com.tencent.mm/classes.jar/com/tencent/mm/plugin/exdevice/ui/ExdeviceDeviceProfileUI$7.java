package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.b;

final class ExdeviceDeviceProfileUI$7
  implements h.b
{
  ExdeviceDeviceProfileUI$7(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(19944);
    ab.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramCharSequence });
    String str = "";
    if (paramCharSequence != null) {
      str = paramCharSequence.toString();
    }
    if (ExdeviceDeviceProfileUI.a(this.lMD))
    {
      ExdeviceDeviceProfileUI.a(this.lMD, str);
      this.lMD.runOnUiThread(new ExdeviceDeviceProfileUI.7.1(this));
      paramCharSequence = ad.bpY().dU(ExdeviceDeviceProfileUI.b(this.lMD), ExdeviceDeviceProfileUI.c(this.lMD));
      if (paramCharSequence == null)
      {
        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(this.lMD), ExdeviceDeviceProfileUI.c(this.lMD) });
        AppMethodBeat.o(19944);
        return false;
      }
      paramCharSequence.jm(ExdeviceDeviceProfileUI.d(this.lMD));
      ad.bpY().update(paramCharSequence, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(19944);
      return true;
      paramCharSequence = new y(ExdeviceDeviceProfileUI.b(this.lMD), ExdeviceDeviceProfileUI.c(this.lMD), str);
      ExdeviceDeviceProfileUI.a(this.lMD, paramCharSequence);
      aw.Rc().a(1263, this.lMD);
      aw.Rc().a(paramCharSequence, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.7
 * JD-Core Version:    0.7.0.1
 */