package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.d.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class ExdeviceConnectWifiUI$3
  implements Runnable
{
  ExdeviceConnectWifiUI$3(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      au.Hx();
      localObject = e.c(c.FU() + "exdevice_wifi_infos", 0, 2147483647);
      if (localObject != null)
      {
        ExdeviceConnectWifiUI.o(this.jCy).aH((byte[])localObject);
        ExdeviceConnectWifiUI.p(this.jCy);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
      }
    }
    ai.l(new ExdeviceConnectWifiUI.3.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.3
 * JD-Core Version:    0.7.0.1
 */