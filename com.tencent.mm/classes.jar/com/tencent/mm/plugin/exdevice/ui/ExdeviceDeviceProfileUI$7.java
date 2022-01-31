package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.base.h.b;

final class ExdeviceDeviceProfileUI$7
  implements h.b
{
  ExdeviceDeviceProfileUI$7(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramCharSequence });
    String str = "";
    if (paramCharSequence != null) {
      str = paramCharSequence.toString();
    }
    if (ExdeviceDeviceProfileUI.a(this.jDf))
    {
      ExdeviceDeviceProfileUI.a(this.jDf, str);
      this.jDf.runOnUiThread(new ExdeviceDeviceProfileUI.7.1(this));
      paramCharSequence = ad.aLL().cQ(ExdeviceDeviceProfileUI.b(this.jDf), ExdeviceDeviceProfileUI.c(this.jDf));
      if (paramCharSequence == null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(this.jDf), ExdeviceDeviceProfileUI.c(this.jDf) });
        return false;
      }
      paramCharSequence.cZ(ExdeviceDeviceProfileUI.d(this.jDf));
      ad.aLL().c(paramCharSequence, new String[0]);
    }
    for (;;)
    {
      return true;
      paramCharSequence = new com.tencent.mm.plugin.exdevice.model.y(ExdeviceDeviceProfileUI.b(this.jDf), ExdeviceDeviceProfileUI.c(this.jDf), str);
      ExdeviceDeviceProfileUI.a(this.jDf, paramCharSequence);
      au.Dk().a(1263, this.jDf);
      au.Dk().a(paramCharSequence, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.7
 * JD-Core Version:    0.7.0.1
 */