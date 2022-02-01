package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.plugin.audio.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mConnectRetryCount", "", "mCurrentBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mCurrentMacAddress", "mIshappendActiveChanged", "", "mLastConnectTime", "", "value", "mPreBTAddress", "setMPreBTAddress", "(Ljava/lang/String;)V", "checkBluetoothDevice", "", "intent", "Landroid/content/Intent;", "onAclStateDisconnected", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "refreshForbiddenCauseRequest", "type", "tickLastForbiddenTimes", "plugin-audio_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BluetoothMgr";
  private static int mConnectRetryCount;
  private static String oHE;
  private static boolean oHF;
  private static String oHG;
  private static BluetoothDevice oHH;
  private static long oHI;
  public static final a oHJ;
  
  static
  {
    AppMethodBeat.i(223947);
    oHJ = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(223947);
  }
  
  public static final void V(Intent paramIntent)
  {
    AppMethodBeat.i(223941);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(223941);
      return;
    }
    Object localObject;
    if (f.cew())
    {
      localObject = b.oIo;
      localObject = paramIntent.getBluetoothClass();
      p.g(localObject, "device.bluetoothClass");
      if (((BluetoothClass)localObject).getDeviceClass() != 1032) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      b.jx(bool);
      if ((p.j(oHG, paramIntent.getAddress()) ^ true))
      {
        localObject = paramIntent.getBluetoothClass();
        if (localObject != null)
        {
          com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.oIj;
          int i = ((BluetoothClass)localObject).getMajorDeviceClass();
          int j = ((BluetoothClass)localObject).getDeviceClass();
          localObject = com.tencent.mm.plugin.audio.c.a.oIh;
          com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), a.a.cek(), 0, paramIntent.getName(), paramIntent.getAddress());
        }
        oHG = paramIntent.getAddress();
        mConnectRetryCount = 0;
        paramIntent = b.oIo;
        b.jx(true);
      }
      AppMethodBeat.o(223941);
      return;
    }
  }
  
  public static final void W(Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(223942);
    p.h(paramIntent, "intent");
    if (!g.aAc())
    {
      AppMethodBeat.o(223942);
      return;
    }
    int i;
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      Log.d(TAG, "dkbt  action :" + paramIntent.getAction() + " state:" + i);
      if ((oHE != null) && (i == 0) && (oHF))
      {
        Log.i(TAG, "current run a active device changed");
        AppMethodBeat.o(223942);
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
      AppMethodBeat.o(223942);
      return;
      if (f.cex() != 0)
      {
        if ((mConnectRetryCount >= f.cez()) && (Util.ticksToNow(oHI) < 1000L))
        {
          Log.i(TAG, "aim at the sco connect limited");
          mConnectRetryCount = 0;
          paramIntent = b.oIo;
          b.jx(false);
          paramIntent = oHH;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getBluetoothClass();
            if (paramIntent != null)
            {
              Object localObject = com.tencent.mm.plugin.audio.d.a.oIj;
              i = paramIntent.getMajorDeviceClass();
              int j = paramIntent.getDeviceClass();
              paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
              localObject = a.a.cek();
              paramIntent = oHH;
              if (paramIntent == null) {
                break label397;
              }
              paramIntent = paramIntent.getName();
              BluetoothDevice localBluetoothDevice = oHH;
              if (localBluetoothDevice != null) {
                str = localBluetoothDevice.getAddress();
              }
              com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), (String)localObject, 1, paramIntent, str);
              paramIntent = com.tencent.mm.plugin.audio.d.a.oIj;
              paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
              paramIntent = a.a.cek();
              p.h(paramIntent, "caller");
              switch (paramIntent.hashCode())
              {
              }
            }
          }
          for (;;)
          {
            paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
            a.a.cea().iY(3);
            AppMethodBeat.o(223942);
            return;
            label397:
            paramIntent = null;
            break;
            if (paramIntent.equals("ipcall"))
            {
              com.tencent.mm.plugin.audio.d.a.cep();
              continue;
              if (paramIntent.equals("music"))
              {
                com.tencent.mm.plugin.audio.d.a.ceq();
                continue;
                if (paramIntent.equals("openvoice"))
                {
                  com.tencent.mm.plugin.audio.d.a.ceo();
                  continue;
                  if (paramIntent.equals("record"))
                  {
                    com.tencent.mm.plugin.audio.d.a.cem();
                    continue;
                    if (paramIntent.equals("voip"))
                    {
                      com.tencent.mm.plugin.audio.d.a.cel();
                      continue;
                      if (paramIntent.equals("voipcs"))
                      {
                        com.tencent.mm.plugin.audio.d.a.cer();
                        continue;
                        if (paramIntent.equals("multitalke")) {
                          com.tencent.mm.plugin.audio.d.a.cen();
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
          oHI = Util.currentTicks();
        }
        mConnectRetryCount += 1;
        Log.d(TAG, "sco connected!");
        if (oHF) {
          oHF = false;
        }
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(2);
      AppMethodBeat.o(223942);
      return;
      Log.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(ae.gKE.aoi()) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(3);
    }
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(223943);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(223943);
      return;
    }
    if ((p.j(oHE, paramIntent.getAddress()) ^ true))
    {
      ago(paramIntent.getAddress());
      oHF = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(0);
      Log.i(TAG, "android pie switch bt device,%s", new Object[] { oHE });
    }
    AppMethodBeat.o(223943);
  }
  
  public static final void Y(Intent paramIntent)
  {
    AppMethodBeat.i(223944);
    p.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    Log.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(1);
    }
    Log.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label155;
      }
      h.CyF.a(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      Log.e(TAG, "[oneliang]bluetoothAdapter state:" + paramIntent.getState());
      AppMethodBeat.o(223944);
      return;
      label155:
      if (paramIntent.getState() == 10) {
        h.CyF.a(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void Z(Intent paramIntent)
  {
    Object localObject1 = null;
    AppMethodBeat.i(223945);
    p.h(paramIntent, "intent");
    Object localObject2 = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (localBluetoothDevice == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(223945);
      return;
    }
    Log.i(TAG, " mPreBTAddress = device.address %s", new Object[] { localBluetoothDevice.getAddress() });
    Log.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(localBluetoothDevice.getBondState()) });
    if (oHE == null)
    {
      ago(localBluetoothDevice.getAddress());
      AppMethodBeat.o(223945);
      return;
    }
    if (p.j(localBluetoothDevice.getAddress(), oHE))
    {
      Log.i(TAG, "dkbt onReceive action[" + (String)localObject2 + "] state:" + i);
      if (i == 2)
      {
        if (oHH != null)
        {
          localObject2 = oHH;
          paramIntent = localObject1;
          if (localObject2 != null) {
            paramIntent = ((BluetoothDevice)localObject2).getAddress();
          }
          if (!(p.j(paramIntent, localBluetoothDevice.getAddress()) ^ true)) {}
        }
        else
        {
          paramIntent = b.oIo;
          b.jx(true);
        }
        paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
        a.a.cea().iY(5);
        AppMethodBeat.o(223945);
        return;
      }
      if (i == 0)
      {
        paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
        a.a.cea().iY(6);
        ago(null);
      }
      AppMethodBeat.o(223945);
      return;
    }
    oHF = false;
    Log.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(223945);
  }
  
  public static final void aa(Intent paramIntent)
  {
    AppMethodBeat.i(223946);
    p.h(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(223946);
      return;
    }
    if (p.j(paramIntent.getAddress(), oHE))
    {
      Log.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      Log.i(TAG, "pre connect device is " + paramIntent.getAddress());
      paramIntent = b.oIo;
      b.jx(true);
      paramIntent = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(7);
    }
    AppMethodBeat.o(223946);
  }
  
  private static void ago(String paramString)
  {
    AppMethodBeat.i(223938);
    b localb = b.oIo;
    b.agu(oHE);
    oHE = paramString;
    AppMethodBeat.o(223938);
  }
  
  public static final void agp(String paramString)
  {
    AppMethodBeat.i(223940);
    p.h(paramString, "type");
    Log.i(TAG, "refreshForbiddenCauseVoipRequest，".concat(String.valueOf(paramString)));
    paramString = b.oIo;
    b.jx(true);
    mConnectRetryCount = 0;
    AppMethodBeat.o(223940);
  }
  
  public static final void cdS()
  {
    AppMethodBeat.i(223939);
    if ((Util.ticksToNow(oHI) > f.cey() * 1000) && (f.cex() == 1))
    {
      Log.i(TAG, "refresh forbidden time");
      b localb = b.oIo;
      b.jx(true);
    }
    mConnectRetryCount = 0;
    AppMethodBeat.o(223939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */