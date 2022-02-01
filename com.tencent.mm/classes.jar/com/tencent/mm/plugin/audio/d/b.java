package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "currentBluetoothAddress", "isRecordAllowToUseSco", "", "()Z", "setRecordAllowToUseSco", "(Z)V", "mIsPlugged", "getMIsPlugged", "setMIsPlugged", "checkBluetoothType", "", "context", "Landroid/content/Context;", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "isBluetoothCanRecord", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "setActiveDevice", "address", "startBluetooth", "stopBluetooth", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b uVo;
  private static boolean uVp;
  private static int uVq;
  private static String uVr;
  private static boolean uVs;
  
  static
  {
    AppMethodBeat.i(263846);
    uVo = new b();
    uVq = -1;
    uVs = true;
    AppMethodBeat.o(263846);
  }
  
  public static final boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(263763);
    s.u(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoAvailableOffCall();
    AppMethodBeat.o(263763);
    return bool;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(263789);
    s.u(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
    Integer localInteger;
    boolean bool;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {}
    }
    else
    {
      if (!cUa()) {
        break label94;
      }
      if (paramStack.contains(Integer.valueOf(4))) {
        paramStack.removeElement(Integer.valueOf(4));
      }
      paramStack.push(Integer.valueOf(4));
      bool = true;
    }
    for (;;)
    {
      AppMethodBeat.o(263789);
      return bool;
      if (localInteger.intValue() != 4) {
        break;
      }
      bool = true;
      continue;
      label94:
      bool = false;
      Log.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
    }
  }
  
  public static void ahv(String paramString)
  {
    uVr = paramString;
  }
  
  public static final int b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(263773);
    s.u(paramAudioManager, "audioManager");
    if (!cUa())
    {
      AppMethodBeat.o(263773);
      return -1;
    }
    if (!uVs)
    {
      AppMethodBeat.o(263773);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.cUf() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      Log.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      Log.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.cUf(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(263773);
      return -1;
      if (PhoneStatusWatcher.isCalling())
      {
        bool = false;
      }
      else
      {
        if (!paramAudioManager.isBluetoothScoOn())
        {
          Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { Util.getStack() });
          paramAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    localObject = new StringBuilder("dkbt  tryStartBluetooth ");
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.d("MicroMsg.BluetoothUtil", a.a.cUf() + " ret:true");
    boolean bool = cTX();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      uVp = true;
    }
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(263773);
      return 1;
    }
    AppMethodBeat.o(263773);
    return 0;
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(263799);
    s.u(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(263799);
  }
  
  public static final void c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(263781);
    s.u(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.cUf() });
    paramAudioManager.setBluetoothScoOn(false);
    uVp = false;
    if (!PhoneStatusWatcher.isCalling())
    {
      Log.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(af.lYj.lTV), Integer.valueOf(af.lYj.lTU) });
      if ((af.lYj.lTU == 1) || (af.lYj.lTV == -1))
      {
        Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { Util.getStack() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.uVi;
    Log.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.cUf() });
    AppMethodBeat.o(263781);
  }
  
  public static boolean cTX()
  {
    AppMethodBeat.i(263758);
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    boolean bool1 = a.a.cTW().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.uVi;
    boolean bool2 = a.a.cTW().audioManager.isBluetoothA2dpOn();
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(cUa()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(263758);
      return true;
    }
    AppMethodBeat.o(263758);
    return false;
  }
  
  public static boolean cUa()
  {
    AppMethodBeat.i(263827);
    boolean bool = cUs();
    if (!bool)
    {
      Log.i("MicroMsg.BluetoothUtil", s.X("dkbt isConnectHeadset() = ", Boolean.valueOf(bool)));
      AppMethodBeat.o(263827);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      Log.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(263827);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      Log.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(263827);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(263827);
      return false;
    }
    localObject = ((Set)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((BluetoothDevice)((Iterator)localObject).next()).getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(263827);
        return false;
      }
      Log.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(263827);
      return true;
    }
  }
  
  public static boolean cUp()
  {
    return uVp;
  }
  
  public static final void cUq()
  {
    AppMethodBeat.i(263749);
    uVp = cTX();
    AppMethodBeat.o(263749);
  }
  
  public static boolean cUr()
  {
    return uVs;
  }
  
  private static boolean cUs()
  {
    AppMethodBeat.i(263842);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      Log.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(263842);
        return true;
      }
      AppMethodBeat.o(263842);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(263842);
    }
    return false;
  }
  
  public static int d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(263810);
    s.u(paramAudioManager, "audioManager");
    if (uVq == -1) {}
    try
    {
      i = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO").getInt(paramAudioManager);
      uVq = i;
      i = uVq;
      AppMethodBeat.o(263810);
      return i;
    }
    catch (Exception paramAudioManager)
    {
      for (;;)
      {
        Log.e("MicroMsg.BluetoothUtil", s.X("ClassNotFoundException  android.media.AudioManager,exception:", paramAudioManager.getMessage()));
        int i = 6;
      }
    }
  }
  
  public static boolean e(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(263837);
    s.u(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(263837);
    return bool;
  }
  
  public static void lU(boolean paramBoolean)
  {
    uVp = paramBoolean;
  }
  
  public static void lV(boolean paramBoolean)
  {
    uVs = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.b
 * JD-Core Version:    0.7.0.1
 */