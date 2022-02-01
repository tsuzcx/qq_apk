package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mIshappendActiveChanged", "", "mPreBTAddress", "onAclStateDisconnected", "", "intent", "Landroid/content/Intent;", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static String moV;
  private static boolean moW;
  public static final a moX;
  
  static
  {
    AppMethodBeat.i(189220);
    moX = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(189220);
  }
  
  public static final void U(Intent paramIntent)
  {
    AppMethodBeat.i(189215);
    d.g.b.k.h(paramIntent, "intent");
    if (!g.afw())
    {
      AppMethodBeat.o(189215);
      return;
    }
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      String str = TAG;
      paramIntent = new StringBuilder("dkbt  action :").append(paramIntent.getAction()).append(" state:").append(i).append(" isBluetoothScoOn :");
      Object localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      paramIntent = paramIntent.append(com.tencent.mm.plugin.audio.d.a.bvC()).append(" ");
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      ad.d(str, a.a.bvB().bvA());
      if ((moV != null) && (i == 0) && (moW))
      {
        ad.i(TAG, "current run a active device changed");
        AppMethodBeat.o(189215);
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        ad.e(TAG, "%s", new Object[] { bt.m((Throwable)localException) });
        i = 0;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(189215);
      return;
      ad.d(TAG, "sco connected!");
      if (moW) {
        moW = false;
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(2);
      AppMethodBeat.o(189215);
      return;
      ad.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(ae.fFH.WB()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(3);
    }
  }
  
  public static final void V(Intent paramIntent)
  {
    AppMethodBeat.i(189216);
    d.g.b.k.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "device is unavailable");
      AppMethodBeat.o(189216);
      return;
    }
    if ((d.g.b.k.g(moV, paramIntent.getAddress()) ^ true))
    {
      moV = paramIntent.getAddress();
      moW = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(0);
      ad.i(TAG, "android pie switch bt device,%s", new Object[] { moV });
    }
    AppMethodBeat.o(189216);
  }
  
  public static final void W(Intent paramIntent)
  {
    AppMethodBeat.i(189217);
    d.g.b.k.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    ad.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(1);
    }
    ad.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label148;
      }
      h.vKh.f(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      ad.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(189217);
      return;
      label148:
      if (paramIntent.getState() == 10) {
        h.vKh.f(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(189218);
    d.g.b.k.h(paramIntent, "intent");
    String str = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "pre address is null");
      AppMethodBeat.o(189218);
      return;
    }
    ad.i(TAG, " mPreBTAddress = device.address %s", new Object[] { paramIntent.getAddress() });
    ad.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(paramIntent.getBondState()) });
    if (moV == null)
    {
      moV = paramIntent.getAddress();
      AppMethodBeat.o(189218);
      return;
    }
    if (d.g.b.k.g(paramIntent.getAddress(), moV))
    {
      ad.i(TAG, "dkbt onReceive action[" + str + "] state:" + i);
      if (i == 2)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
        a.a.bvB().hL(5);
        AppMethodBeat.o(189218);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
        a.a.bvB().hL(6);
        moV = null;
      }
      AppMethodBeat.o(189218);
      return;
    }
    moW = false;
    ad.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(189218);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(189219);
    d.g.b.k.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "pre address is null");
      AppMethodBeat.o(189219);
      return;
    }
    if (d.g.b.k.g(paramIntent.getAddress(), moV))
    {
      ad.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      ad.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(7);
    }
    AppMethodBeat.o(189219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */