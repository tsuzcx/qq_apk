package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.e;

final class ExdeviceConnectWifiUI$3
  implements Runnable
{
  ExdeviceConnectWifiUI$3(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19874);
    try
    {
      Object localObject = new StringBuilder();
      aw.aaz();
      localObject = e.i(c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
      if (localObject != null)
      {
        ExdeviceConnectWifiUI.o(this.lLW).parseFrom((byte[])localObject);
        ExdeviceConnectWifiUI.p(this.lLW);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
      }
    }
    al.p(new ExdeviceConnectWifiUI.3.1(this), 500L);
    AppMethodBeat.o(19874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.3
 * JD-Core Version:    0.7.0.1
 */