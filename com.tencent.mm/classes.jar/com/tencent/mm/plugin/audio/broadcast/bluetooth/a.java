package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mIshappendActiveChanged", "", "mPreBTAddress", "onAclStateDisconnected", "", "intent", "Landroid/content/Intent;", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static String nrv;
  private static boolean nrw;
  public static final a nrx;
  
  static
  {
    AppMethodBeat.i(199738);
    nrx = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(199738);
  }
  
  public static final void W(Intent paramIntent)
  {
    AppMethodBeat.i(199733);
    p.h(paramIntent, "intent");
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(199733);
      return;
    }
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      String str = TAG;
      paramIntent = new StringBuilder("dkbt  action :").append(paramIntent.getAction()).append(" state:").append(i).append(" isBluetoothScoOn :");
      Object localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      paramIntent = paramIntent.append(com.tencent.mm.plugin.audio.d.a.bGD()).append(" ");
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      ad.d(str, a.a.bGC().bGB());
      if ((nrv != null) && (i == 0) && (nrw))
      {
        ad.i(TAG, "current run a active device changed");
        AppMethodBeat.o(199733);
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        ad.e(TAG, "%s", new Object[] { bt.n((Throwable)localException) });
        i = 0;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199733);
      return;
      ad.d(TAG, "sco connected!");
      if (nrw) {
        nrw = false;
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(2);
      AppMethodBeat.o(199733);
      return;
      ad.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(ae.gcP.aaa()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(3);
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(199734);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "device is unavailable");
      AppMethodBeat.o(199734);
      return;
    }
    if ((p.i(nrv, paramIntent.getAddress()) ^ true))
    {
      nrv = paramIntent.getAddress();
      nrw = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(0);
      ad.i(TAG, "android pie switch bt device,%s", new Object[] { nrv });
    }
    AppMethodBeat.o(199734);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(199735);
    p.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    ad.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(1);
    }
    ad.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label148;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      ad.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(199735);
      return;
      label148:
      if (paramIntent.getState() == 10) {
        com.tencent.mm.plugin.report.service.g.yhR.f(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void Z(Intent paramIntent)
  {
    AppMethodBeat.i(199736);
    p.h(paramIntent, "intent");
    String str = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "pre address is null");
      AppMethodBeat.o(199736);
      return;
    }
    ad.i(TAG, " mPreBTAddress = device.address %s", new Object[] { paramIntent.getAddress() });
    ad.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(paramIntent.getBondState()) });
    if (nrv == null)
    {
      nrv = paramIntent.getAddress();
      AppMethodBeat.o(199736);
      return;
    }
    if (p.i(paramIntent.getAddress(), nrv))
    {
      ad.i(TAG, "dkbt onReceive action[" + str + "] state:" + i);
      if (i == 2)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
        a.a.bGC().hC(5);
        AppMethodBeat.o(199736);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
        a.a.bGC().hC(6);
        nrv = null;
      }
      AppMethodBeat.o(199736);
      return;
    }
    nrw = false;
    ad.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(199736);
  }
  
  public static final void aa(Intent paramIntent)
  {
    AppMethodBeat.i(199737);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ad.i(TAG, "pre address is null");
      AppMethodBeat.o(199737);
      return;
    }
    if (p.i(paramIntent.getAddress(), nrv))
    {
      ad.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      ad.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(7);
    }
    AppMethodBeat.o(199737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */