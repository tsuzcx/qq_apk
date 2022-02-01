package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mIshappendActiveChanged", "", "mPreBTAddress", "onAclStateDisconnected", "", "intent", "Landroid/content/Intent;", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static String mQW;
  private static boolean mQX;
  public static final a mQY;
  
  static
  {
    AppMethodBeat.i(198340);
    mQY = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(198340);
  }
  
  public static final void U(Intent paramIntent)
  {
    AppMethodBeat.i(198335);
    d.g.b.k.h(paramIntent, "intent");
    if (!g.agM())
    {
      AppMethodBeat.o(198335);
      return;
    }
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      String str = TAG;
      paramIntent = new StringBuilder("dkbt  action :").append(paramIntent.getAction()).append(" state:").append(i).append(" isBluetoothScoOn :");
      Object localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      paramIntent = paramIntent.append(com.tencent.mm.plugin.audio.d.a.bCy()).append(" ");
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      ac.d(str, a.a.bCx().bCw());
      if ((mQW != null) && (i == 0) && (mQX))
      {
        ac.i(TAG, "current run a active device changed");
        AppMethodBeat.o(198335);
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        ac.e(TAG, "%s", new Object[] { bs.m((Throwable)localException) });
        i = 0;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198335);
      return;
      ac.d(TAG, "sco connected!");
      if (mQX) {
        mQX = false;
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(2);
      AppMethodBeat.o(198335);
      return;
      ac.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(ae.fJo.Xz()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(3);
    }
  }
  
  public static final void V(Intent paramIntent)
  {
    AppMethodBeat.i(198336);
    d.g.b.k.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ac.i(TAG, "device is unavailable");
      AppMethodBeat.o(198336);
      return;
    }
    if ((d.g.b.k.g(mQW, paramIntent.getAddress()) ^ true))
    {
      mQW = paramIntent.getAddress();
      mQX = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(0);
      ac.i(TAG, "android pie switch bt device,%s", new Object[] { mQW });
    }
    AppMethodBeat.o(198336);
  }
  
  public static final void W(Intent paramIntent)
  {
    AppMethodBeat.i(198337);
    d.g.b.k.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    ac.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(1);
    }
    ac.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label148;
      }
      h.wUl.f(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      ac.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(198337);
      return;
      label148:
      if (paramIntent.getState() == 10) {
        h.wUl.f(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(198338);
    d.g.b.k.h(paramIntent, "intent");
    String str = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ac.i(TAG, "pre address is null");
      AppMethodBeat.o(198338);
      return;
    }
    ac.i(TAG, " mPreBTAddress = device.address %s", new Object[] { paramIntent.getAddress() });
    ac.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(paramIntent.getBondState()) });
    if (mQW == null)
    {
      mQW = paramIntent.getAddress();
      AppMethodBeat.o(198338);
      return;
    }
    if (d.g.b.k.g(paramIntent.getAddress(), mQW))
    {
      ac.i(TAG, "dkbt onReceive action[" + str + "] state:" + i);
      if (i == 2)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
        a.a.bCx().hv(5);
        AppMethodBeat.o(198338);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
        a.a.bCx().hv(6);
        mQW = null;
      }
      AppMethodBeat.o(198338);
      return;
    }
    mQX = false;
    ac.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(198338);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(198339);
    d.g.b.k.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      ac.i(TAG, "pre address is null");
      AppMethodBeat.o(198339);
      return;
    }
    if (d.g.b.k.g(paramIntent.getAddress(), mQW))
    {
      ac.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      ac.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(7);
    }
    AppMethodBeat.o(198339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */