package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.plugin.audio.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mConnectRetryCount", "", "mCurrentBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mCurrentMacAddress", "mIshappendActiveChanged", "", "mLastConnectTime", "", "value", "mPreBTAddress", "setMPreBTAddress", "(Ljava/lang/String;)V", "checkBluetoothDevice", "", "intent", "Landroid/content/Intent;", "onAclStateDisconnected", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "refreshForbiddenCauseRequest", "type", "tickLastForbiddenTimes", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static int mConnectRetryCount;
  private static String rJu;
  private static boolean rJv;
  private static String rJw;
  private static BluetoothDevice rJx;
  private static long rJy;
  public static final a rJz;
  
  static
  {
    AppMethodBeat.i(257573);
    rJz = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(257573);
  }
  
  public static final void T(Intent paramIntent)
  {
    AppMethodBeat.i(257564);
    p.k(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(257564);
      return;
    }
    Object localObject;
    if (f.crJ())
    {
      localObject = b.rKe;
      localObject = paramIntent.getBluetoothClass();
      p.j(localObject, "device.bluetoothClass");
      if (((BluetoothClass)localObject).getDeviceClass() != 1032) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      b.kI(bool);
      if ((p.h(rJw, paramIntent.getAddress()) ^ true))
      {
        localObject = paramIntent.getBluetoothClass();
        if (localObject != null)
        {
          com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.rJZ;
          int i = ((BluetoothClass)localObject).getMajorDeviceClass();
          int j = ((BluetoothClass)localObject).getDeviceClass();
          localObject = com.tencent.mm.plugin.audio.c.a.rJX;
          com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), a.a.crx(), 0, paramIntent.getName(), paramIntent.getAddress());
        }
        rJw = paramIntent.getAddress();
        mConnectRetryCount = 0;
        paramIntent = b.rKe;
        b.kI(true);
      }
      AppMethodBeat.o(257564);
      return;
    }
  }
  
  public static final void U(Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(257565);
    p.k(paramIntent, "intent");
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(257565);
      return;
    }
    int i;
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      Log.d(TAG, "dkbt  action :" + paramIntent.getAction() + " state:" + i);
      if ((rJu != null) && (i == 0) && (rJv))
      {
        Log.i(TAG, "current run a active device changed");
        AppMethodBeat.o(257565);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(TAG, "%s", new Object[] { Util.stackTraceToString((Throwable)localException) });
        i = 0;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(257565);
      return;
      if (f.crK() != 0)
      {
        if ((mConnectRetryCount >= f.crM()) && (Util.ticksToNow(rJy) < 1000L))
        {
          Log.i(TAG, "aim at the sco connect limited");
          mConnectRetryCount = 0;
          paramIntent = b.rKe;
          b.kI(false);
          paramIntent = rJx;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getBluetoothClass();
            if (paramIntent != null)
            {
              Object localObject = com.tencent.mm.plugin.audio.d.a.rJZ;
              i = paramIntent.getMajorDeviceClass();
              int j = paramIntent.getDeviceClass();
              paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
              localObject = a.a.crx();
              paramIntent = rJx;
              if (paramIntent == null) {
                break label397;
              }
              paramIntent = paramIntent.getName();
              BluetoothDevice localBluetoothDevice = rJx;
              if (localBluetoothDevice != null) {
                str = localBluetoothDevice.getAddress();
              }
              com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), (String)localObject, 1, paramIntent, str);
              paramIntent = com.tencent.mm.plugin.audio.d.a.rJZ;
              paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
              paramIntent = a.a.crx();
              p.k(paramIntent, "caller");
              switch (paramIntent.hashCode())
              {
              }
            }
          }
          for (;;)
          {
            paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
            a.a.crn().ko(3);
            AppMethodBeat.o(257565);
            return;
            label397:
            paramIntent = null;
            break;
            if (paramIntent.equals("ipcall"))
            {
              com.tencent.mm.plugin.audio.d.a.crC();
              continue;
              if (paramIntent.equals("music"))
              {
                com.tencent.mm.plugin.audio.d.a.crD();
                continue;
                if (paramIntent.equals("openvoice"))
                {
                  com.tencent.mm.plugin.audio.d.a.crB();
                  continue;
                  if (paramIntent.equals("record"))
                  {
                    com.tencent.mm.plugin.audio.d.a.crz();
                    continue;
                    if (paramIntent.equals("voip"))
                    {
                      com.tencent.mm.plugin.audio.d.a.cry();
                      continue;
                      if (paramIntent.equals("voipcs"))
                      {
                        com.tencent.mm.plugin.audio.d.a.crE();
                        continue;
                        if (paramIntent.equals("multitalke")) {
                          com.tencent.mm.plugin.audio.d.a.crA();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        Log.i(TAG, "not aim at the sco connect limited " + mConnectRetryCount);
        if (mConnectRetryCount == 0) {
          rJy = Util.currentTicks();
        }
        mConnectRetryCount += 1;
        Log.d(TAG, "sco connected!");
        if (rJv) {
          rJv = false;
        }
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(2);
      AppMethodBeat.o(257565);
      return;
      Log.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(af.juS.aun()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(3);
    }
  }
  
  public static final void V(Intent paramIntent)
  {
    AppMethodBeat.i(257566);
    p.k(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(257566);
      return;
    }
    if ((p.h(rJu, paramIntent.getAddress()) ^ true))
    {
      anR(paramIntent.getAddress());
      rJv = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(0);
      Log.i(TAG, "android pie switch bt device,%s", new Object[] { rJu });
    }
    AppMethodBeat.o(257566);
  }
  
  public static final void W(Intent paramIntent)
  {
    AppMethodBeat.i(257567);
    p.k(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    Log.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(1);
    }
    Log.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label155;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      Log.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(257567);
      return;
      label155:
      if (paramIntent.getState() == 10) {
        com.tencent.mm.plugin.report.service.h.IzE.a(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    Object localObject1 = null;
    AppMethodBeat.i(257569);
    p.k(paramIntent, "intent");
    Object localObject2 = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (localBluetoothDevice == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(257569);
      return;
    }
    Log.i(TAG, " mPreBTAddress = device.address %s", new Object[] { localBluetoothDevice.getAddress() });
    Log.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(localBluetoothDevice.getBondState()) });
    if (rJu == null)
    {
      anR(localBluetoothDevice.getAddress());
      AppMethodBeat.o(257569);
      return;
    }
    if (p.h(localBluetoothDevice.getAddress(), rJu))
    {
      Log.i(TAG, "dkbt onReceive action[" + (String)localObject2 + "] state:" + i);
      if (i == 2)
      {
        if (rJx != null)
        {
          localObject2 = rJx;
          paramIntent = localObject1;
          if (localObject2 != null) {
            paramIntent = ((BluetoothDevice)localObject2).getAddress();
          }
          if (!(p.h(paramIntent, localBluetoothDevice.getAddress()) ^ true)) {}
        }
        else
        {
          paramIntent = b.rKe;
          b.kI(true);
        }
        paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
        a.a.crn().ko(5);
        AppMethodBeat.o(257569);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
        a.a.crn().ko(6);
        anR(null);
      }
      AppMethodBeat.o(257569);
      return;
    }
    rJv = false;
    Log.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(257569);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(257571);
    p.k(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(257571);
      return;
    }
    if (p.h(paramIntent.getAddress(), rJu))
    {
      Log.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      Log.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = b.rKe;
      b.kI(true);
      paramIntent = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(7);
    }
    AppMethodBeat.o(257571);
  }
  
  private static void anR(String paramString)
  {
    AppMethodBeat.i(257561);
    b localb = b.rKe;
    b.anY(rJu);
    rJu = paramString;
    AppMethodBeat.o(257561);
  }
  
  public static final void anS(String paramString)
  {
    AppMethodBeat.i(257563);
    p.k(paramString, "type");
    Log.i(TAG, "refreshForbiddenCauseVoipRequest，".concat(String.valueOf(paramString)));
    paramString = b.rKe;
    b.kI(true);
    mConnectRetryCount = 0;
    AppMethodBeat.o(257563);
  }
  
  public static final void crb()
  {
    AppMethodBeat.i(257562);
    if ((Util.ticksToNow(rJy) > f.crL() * 1000) && (f.crK() == 1))
    {
      Log.i(TAG, "refresh forbidden time");
      b localb = b.rKe;
      b.kI(true);
    }
    mConnectRetryCount = 0;
    AppMethodBeat.o(257562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */