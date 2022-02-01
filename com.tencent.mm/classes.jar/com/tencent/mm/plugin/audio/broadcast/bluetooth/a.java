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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mConnectRetryCount", "", "mCurrentBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mCurrentMacAddress", "mIshappendActiveChanged", "", "mLastConnectTime", "", "value", "mPreBTAddress", "setMPreBTAddress", "(Ljava/lang/String;)V", "checkBluetoothDevice", "", "intent", "Landroid/content/Intent;", "onAclStateDisconnected", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "refreshForbiddenCauseRequest", "type", "tickLastForbiddenTimes", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  private static int mConnectRetryCount;
  public static final a uUM;
  private static String uUN;
  private static boolean uUO;
  private static String uUP;
  private static BluetoothDevice uUQ;
  private static long uUR;
  
  static
  {
    AppMethodBeat.i(263863);
    uUM = new a();
    TAG = "MicroMsg.BluetoothMgr";
    AppMethodBeat.o(263863);
  }
  
  public static final void X(Intent paramIntent)
  {
    AppMethodBeat.i(263824);
    s.u(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(263824);
      return;
    }
    Object localObject;
    if (f.cUt())
    {
      localObject = b.uVo;
      if (paramIntent.getBluetoothClass().getDeviceClass() != 1032) {
        break label163;
      }
    }
    label163:
    for (boolean bool = true;; bool = false)
    {
      b.lV(bool);
      if (!s.p(uUP, paramIntent.getAddress()))
      {
        localObject = paramIntent.getBluetoothClass();
        if (localObject != null)
        {
          com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.uVn;
          int i = ((BluetoothClass)localObject).getMajorDeviceClass();
          int j = ((BluetoothClass)localObject).getDeviceClass();
          localObject = com.tencent.mm.plugin.audio.c.a.uVi;
          com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), a.a.cUg(), 0, paramIntent.getName(), paramIntent.getAddress());
        }
        uUP = paramIntent.getAddress();
        mConnectRetryCount = 0;
        paramIntent = b.uVo;
        b.lV(true);
      }
      AppMethodBeat.o(263824);
      return;
    }
  }
  
  public static final void Y(Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(263843);
    s.u(paramIntent, "intent");
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(263843);
      return;
    }
    int i;
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      Log.d(TAG, "dkbt  action :" + paramIntent.getAction() + " state:" + i);
      if ((uUN != null) && (i == 0) && (uUO))
      {
        Log.i(TAG, "current run a active device changed");
        AppMethodBeat.o(263843);
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
      AppMethodBeat.o(263843);
      return;
      if (f.cUu() != 0)
      {
        if ((mConnectRetryCount >= f.cUw()) && (Util.ticksToNow(uUR) < 1000L))
        {
          Log.i(TAG, "aim at the sco connect limited");
          mConnectRetryCount = 0;
          paramIntent = b.uVo;
          b.lV(false);
          paramIntent = uUQ;
          BluetoothDevice localBluetoothDevice;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getBluetoothClass();
            if (paramIntent != null)
            {
              Object localObject = com.tencent.mm.plugin.audio.d.a.uVn;
              i = paramIntent.getMajorDeviceClass();
              int j = paramIntent.getDeviceClass();
              paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
              localObject = a.a.cUg();
              paramIntent = uUQ;
              if (paramIntent != null) {
                break label389;
              }
              paramIntent = null;
              localBluetoothDevice = uUQ;
              if (localBluetoothDevice != null) {
                break label397;
              }
              label267:
              com.tencent.mm.plugin.audio.d.a.a(Integer.valueOf(i), Integer.valueOf(j), (String)localObject, 1, paramIntent, str);
              paramIntent = com.tencent.mm.plugin.audio.d.a.uVn;
              paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
              paramIntent = a.a.cUg();
              s.u(paramIntent, "caller");
              switch (paramIntent.hashCode())
              {
              }
            }
          }
          for (;;)
          {
            paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
            a.a.cTW().nW(3);
            AppMethodBeat.o(263843);
            return;
            label389:
            paramIntent = paramIntent.getName();
            break;
            label397:
            str = localBluetoothDevice.getAddress();
            break label267;
            if (paramIntent.equals("ipcall"))
            {
              com.tencent.mm.plugin.audio.d.a.cUm();
              continue;
              if (paramIntent.equals("music"))
              {
                com.tencent.mm.plugin.audio.d.a.cUn();
                continue;
                if (paramIntent.equals("openvoice"))
                {
                  com.tencent.mm.plugin.audio.d.a.cUl();
                  continue;
                  if (paramIntent.equals("record"))
                  {
                    com.tencent.mm.plugin.audio.d.a.cUj();
                    continue;
                    if (paramIntent.equals("voip"))
                    {
                      com.tencent.mm.plugin.audio.d.a.cUi();
                      continue;
                      if (paramIntent.equals("voipcs"))
                      {
                        com.tencent.mm.plugin.audio.d.a.cUo();
                        continue;
                        if (paramIntent.equals("multitalke")) {
                          com.tencent.mm.plugin.audio.d.a.cUk();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        Log.i(TAG, s.X("not aim at the sco connect limited ", Integer.valueOf(mConnectRetryCount)));
        if (mConnectRetryCount == 0) {
          uUR = Util.currentTicks();
        }
        mConnectRetryCount += 1;
        Log.d(TAG, "sco connected!");
        if (uUO) {
          uUO = false;
        }
      }
      paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(2);
      AppMethodBeat.o(263843);
      return;
      Log.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(af.lYj.lTT) });
      paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(3);
    }
  }
  
  public static final void Z(Intent paramIntent)
  {
    AppMethodBeat.i(263847);
    s.u(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "device is unavailable");
      AppMethodBeat.o(263847);
      return;
    }
    if (!s.p(uUN, paramIntent.getAddress()))
    {
      aho(paramIntent.getAddress());
      uUO = true;
      paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(0);
      Log.i(TAG, "android pie switch bt device,%s", new Object[] { uUN });
    }
    AppMethodBeat.o(263847);
  }
  
  public static final void aa(Intent paramIntent)
  {
    AppMethodBeat.i(263853);
    s.u(paramIntent, "intent");
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
    Log.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 10)
    {
      paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(1);
    }
    Log.d(TAG, "BluetoothStateReceiver.onReceive()");
    paramIntent = BluetoothAdapter.getDefaultAdapter();
    if (paramIntent != null)
    {
      if (paramIntent.getState() != 12) {
        break label148;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      Log.e(TAG, s.X("[oneliang]bluetoothAdapter state:", Integer.valueOf(paramIntent.getState())));
      AppMethodBeat.o(263853);
      return;
      label148:
      if (paramIntent.getState() == 10) {
        com.tencent.mm.plugin.report.service.h.OAn.b(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
  
  public static final void ab(Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(263856);
    s.u(paramIntent, "intent");
    String str = paramIntent.getAction();
    int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (localBluetoothDevice == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(263856);
      return;
    }
    Log.i(TAG, " mPreBTAddress = device.address %s", new Object[] { localBluetoothDevice.getAddress() });
    Log.i(TAG, "current bond state is %s", new Object[] { Integer.valueOf(localBluetoothDevice.getBondState()) });
    if (uUN == null)
    {
      aho(localBluetoothDevice.getAddress());
      AppMethodBeat.o(263856);
      return;
    }
    if (s.p(localBluetoothDevice.getAddress(), uUN))
    {
      Log.i(TAG, "dkbt onReceive action[" + str + "] state:" + i);
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(263856);
        return;
        if (uUQ != null)
        {
          paramIntent = uUQ;
          if (paramIntent != null) {
            break label256;
          }
        }
        label256:
        for (paramIntent = localObject;; paramIntent = paramIntent.getAddress())
        {
          if (!s.p(paramIntent, localBluetoothDevice.getAddress()))
          {
            paramIntent = b.uVo;
            b.lV(true);
          }
          paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
          a.a.cTW().nW(5);
          AppMethodBeat.o(263856);
          return;
        }
        paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
        a.a.cTW().nW(6);
        aho(null);
      }
    }
    uUO = false;
    Log.i(TAG, "current run device change and not allow to stop");
    AppMethodBeat.o(263856);
  }
  
  public static final void ac(Intent paramIntent)
  {
    AppMethodBeat.i(263861);
    s.u(paramIntent, "intent");
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent == null)
    {
      Log.i(TAG, "pre address is null");
      AppMethodBeat.o(263861);
      return;
    }
    if (s.p(paramIntent.getAddress(), uUN))
    {
      Log.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
      Log.i(TAG, s.X("pre connect device is ", paramIntent.getAddress()));
      paramIntent = b.uVo;
      b.lV(true);
      paramIntent = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(7);
    }
    AppMethodBeat.o(263861);
  }
  
  private static void aho(String paramString)
  {
    AppMethodBeat.i(263793);
    b localb = b.uVo;
    b.ahv(uUN);
    uUN = paramString;
    AppMethodBeat.o(263793);
  }
  
  public static final void ahp(String paramString)
  {
    AppMethodBeat.i(263813);
    s.u(paramString, "type");
    Log.i(TAG, s.X("refreshForbiddenCauseVoipRequest，", paramString));
    paramString = b.uVo;
    b.lV(true);
    mConnectRetryCount = 0;
    AppMethodBeat.o(263813);
  }
  
  public static final void cTI()
  {
    AppMethodBeat.i(263803);
    if ((Util.ticksToNow(uUR) > f.cUv() * 1000) && (f.cUu() == 1))
    {
      Log.i(TAG, "refresh forbidden time");
      b localb = b.uVo;
      b.lV(true);
    }
    mConnectRetryCount = 0;
    AppMethodBeat.o(263803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */