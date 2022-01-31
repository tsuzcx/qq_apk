package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceAddDataSourceUI$4
  extends BroadcastReceiver
{
  ExdeviceAddDataSourceUI$4(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19777);
    if (paramIntent == null)
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
      AppMethodBeat.o(19777);
      return;
    }
    paramContext = paramIntent.getAction();
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext))
    {
      if (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) != 12) {
        break label175;
      }
      if (a.aWe())
      {
        this.lKc.runOnUiThread(new ExdeviceAddDataSourceUI.4.1(this));
        if ((!ExdeviceAddDataSourceUI.a(this.lKc)) || (ExdeviceAddDataSourceUI.b(this.lKc).isProviderEnabled("gps")))
        {
          ad.bqj();
          e.bpM();
        }
      }
    }
    while ((ExdeviceAddDataSourceUI.a(this.lKc)) && ("android.location.MODE_CHANGED".equals(paramContext))) {
      if (ExdeviceAddDataSourceUI.b(this.lKc).isProviderEnabled("gps"))
      {
        this.lKc.runOnUiThread(new ExdeviceAddDataSourceUI.4.3(this));
        if (a.aWe())
        {
          ad.bqj();
          e.bpM();
          AppMethodBeat.o(19777);
          return;
          label175:
          if ((paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!a.aWe()))
          {
            this.lKc.runOnUiThread(new ExdeviceAddDataSourceUI.4.2(this));
            ad.bqk().stopScan();
          }
        }
      }
      else
      {
        this.lKc.runOnUiThread(new ExdeviceAddDataSourceUI.4.4(this));
        ad.bqk().stopScan();
      }
    }
    AppMethodBeat.o(19777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4
 * JD-Core Version:    0.7.0.1
 */