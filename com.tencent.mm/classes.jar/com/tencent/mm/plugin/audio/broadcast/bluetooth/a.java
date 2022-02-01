package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mIshappendActiveChanged", "", "mPreBTAddress", "onAclStateDisconnected", "", "intent", "Landroid/content/Intent;", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static String nwO;
  private static boolean nwP;
  public static final a nwQ;
  
  static
  {
    AppMethodBeat.i(201050);
    nwQ = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(201050);
  }
  
  public static final void W(Intent paramIntent)
  {
    AppMethodBeat.i(201045);
    p.h(paramIntent, "intent");
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(201045);
      return;
    }
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      String str = TAG;
      paramIntent = new StringBuilder("dkbt  action :").append(paramIntent.getAction()).append(" state:").append(i).append(" isBluetoothScoOn :");
      Object localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      paramIntent = paramIntent.append(com.tencent.mm.plugin.audio.d.a.bHz()).append(" ");
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      com.tencent.mm.sdk.platformtools.ae.d(str, a.a.bHy().bHx());
      if ((nwO != null) && (i == 0) && (nwP))
      {
        com.tencent.mm.sdk.platformtools.ae.i(TAG, "current run a active device changed");
        AppMethodBeat.o(201045);
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e(TAG, "%s", new Object[] { bu.o((Throwable)localException) });
        i = 0;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201045);
      return;
      com.tencent.mm.sdk.platformtools.ae.d(TAG, "sco connected!");
      if (nwP) {
        nwP = false;
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(2);
      AppMethodBeat.o(201045);
      return;
      com.tencent.mm.sdk.platformtools.ae.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geX.aaj()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(3);
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(201046);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "device is unavailable");
      AppMethodBeat.o(201046);
      return;
    }
    if ((p.i(nwO, paramIntent.getAddress()) ^ true))
    {
      nwO = paramIntent.getAddress();
      nwP = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(0);
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "android pie switch bt device,%s", new Object[] { nwO });
    }
    AppMethodBeat.o(201046);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(201047);
    p.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(1);
    }
    com.tencent.mm.sdk.platformtools.ae.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label148;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(201047);
      return;
      label148:
      if (paramIntent.getState() == 10) {
        com.tencent.mm.plugin.report.service.g.yxI.f(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void Z(Intent paramIntent)
  {
    AppMethodBeat.i(201048);
    p.h(paramIntent, "intent");
    String str = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "pre address is null");
      AppMethodBeat.o(201048);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i(TAG, " mPreBTAddress = device.address %s", new Object[] { paramIntent.getAddress() });
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(paramIntent.getBondState()) });
    if (nwO == null)
    {
      nwO = paramIntent.getAddress();
      AppMethodBeat.o(201048);
      return;
    }
    if (p.i(paramIntent.getAddress(), nwO))
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "dkbt onReceive action[" + str + "] state:" + i);
      if (i == 2)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
        a.a.bHy().hE(5);
        AppMethodBeat.o(201048);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
        a.a.bHy().hE(6);
        nwO = null;
      }
      AppMethodBeat.o(201048);
      return;
    }
    nwP = false;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(201048);
  }
  
  public static final void aa(Intent paramIntent)
  {
    AppMethodBeat.i(201049);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "pre address is null");
      AppMethodBeat.o(201049);
      return;
    }
    if (p.i(paramIntent.getAddress(), nwO))
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(7);
    }
    AppMethodBeat.o(201049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */