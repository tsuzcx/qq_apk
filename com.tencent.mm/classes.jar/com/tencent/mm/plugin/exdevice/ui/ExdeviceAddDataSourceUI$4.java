package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceAddDataSourceUI$4
  extends BroadcastReceiver
{
  ExdeviceAddDataSourceUI$4(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
    }
    label157:
    label198:
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext))
      {
        if (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) != 12) {
          break label157;
        }
        if (a.awB())
        {
          this.jAD.runOnUiThread(new ExdeviceAddDataSourceUI.4.1(this));
          if ((!ExdeviceAddDataSourceUI.a(this.jAD)) || (ExdeviceAddDataSourceUI.b(this.jAD).isProviderEnabled("gps")))
          {
            ad.aLW();
            e.aLy();
          }
        }
      }
      for (;;)
      {
        if ((!ExdeviceAddDataSourceUI.a(this.jAD)) || (!"android.location.MODE_CHANGED".equals(paramContext))) {
          break label198;
        }
        if (!ExdeviceAddDataSourceUI.b(this.jAD).isProviderEnabled("gps")) {
          break label200;
        }
        this.jAD.runOnUiThread(new ExdeviceAddDataSourceUI.4.3(this));
        if (!a.awB()) {
          break;
        }
        ad.aLW();
        e.aLy();
        return;
        if ((paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!a.awB()))
        {
          this.jAD.runOnUiThread(new ExdeviceAddDataSourceUI.4.2(this));
          ad.aLX().awl();
        }
      }
    }
    label200:
    this.jAD.runOnUiThread(new ExdeviceAddDataSourceUI.4.4(this));
    ad.aLX().awl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.4
 * JD-Core Version:    0.7.0.1
 */