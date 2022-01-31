package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(18475);
    if (paramIntent == null)
    {
      AppMethodBeat.o(18475);
      return;
    }
    paramContext = paramIntent.getAction();
    ab.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(paramContext)));
    if ("android.bluetooth.device.action.FOUND".equals(paramContext))
    {
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (paramContext.getBondState() != 12) {
        this.jQO.jQL.dh(paramContext.getAddress(), paramContext.getName());
      }
      AppMethodBeat.o(18475);
      return;
    }
    if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramContext))
    {
      this.jQO.jQL.aVU();
      AppMethodBeat.o(18475);
      return;
    }
    if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(paramContext))
    {
      paramIntent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1);
      AppMethodBeat.o(18475);
      return;
    }
    if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramContext))
    {
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      paramIntent = paramContext.getAddress();
      if (!a.a(this.jQO).containsKey(Long.valueOf(b.LX(paramIntent))))
      {
        AppMethodBeat.o(18475);
        return;
      }
      ab.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramContext.getName(), paramIntent });
      if (this.jQO.jQL != null) {
        this.jQO.jQL.l(b.LX(paramIntent), false);
      }
    }
    AppMethodBeat.o(18475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */