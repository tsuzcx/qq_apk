package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            y.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + paramContext);
            if (!"android.bluetooth.device.action.FOUND".equals(paramContext)) {
              break;
            }
            paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          } while (paramContext.getBondState() == 12);
          this.hWV.hWS.co(paramContext.getAddress(), paramContext.getName());
          return;
          if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramContext))
          {
            this.hWV.hWS.awr();
            return;
          }
          if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(paramContext))
          {
            switch (paramIntent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1))
            {
            case 22: 
            default: 
              return;
            case 20: 
            case 21: 
              paramContext = this.hWV.hWS;
              return;
            }
            paramContext = this.hWV.hWS;
            return;
          }
        } while (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramContext));
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        paramIntent = paramContext.getAddress();
      } while (!a.a(this.hWV).containsKey(Long.valueOf(b.BU(paramIntent))));
      y.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramContext.getName(), paramIntent });
    } while (this.hWV.hWS == null);
    this.hWV.hWS.i(b.BU(paramIntent), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */