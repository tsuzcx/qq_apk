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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "currentBluetoothAddress", "isRecordAllowToUseSco", "", "()Z", "setRecordAllowToUseSco", "(Z)V", "mIsPlugged", "getMIsPlugged", "setMIsPlugged", "checkBluetoothType", "", "context", "Landroid/content/Context;", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "isBluetoothCanRecord", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "setActiveDevice", "address", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class b
{
  private static boolean rKa;
  private static int rKb;
  private static String rKc;
  private static boolean rKd;
  public static final b rKe;
  
  static
  {
    AppMethodBeat.i(257781);
    rKe = new b();
    rKb = -1;
    rKd = true;
    AppMethodBeat.o(257781);
  }
  
  public static final boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(257756);
    p.k(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoAvailableOffCall();
    AppMethodBeat.o(257756);
    return bool;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(257767);
    p.k(paramStack, "mDeviceQueue");
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
      if (!crr()) {
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
      AppMethodBeat.o(257767);
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
  
  public static void anY(String paramString)
  {
    rKc = paramString;
  }
  
  public static final int b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(257761);
    p.k(paramAudioManager, "audioManager");
    if (!crr())
    {
      AppMethodBeat.o(257761);
      return -1;
    }
    if (!rKd)
    {
      AppMethodBeat.o(257761);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.crw() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      Log.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      Log.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.crw(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(257761);
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
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.d("MicroMsg.BluetoothUtil", a.a.crw() + " ret:true");
    boolean bool = cro();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      rKa = true;
    }
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(257761);
      return 1;
    }
    AppMethodBeat.o(257761);
    return 0;
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(257768);
    p.k(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(257768);
  }
  
  public static final void c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(257763);
    p.k(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.crw() });
    paramAudioManager.setBluetoothScoOn(false);
    rKa = false;
    if (!PhoneStatusWatcher.isCalling())
    {
      Log.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(af.juS.aup()), Integer.valueOf(af.juS.auo()) });
      if ((af.juS.auo() == 1) || (af.juS.aup() == -1))
      {
        Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { Util.getStack() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.rJX;
    Log.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.crw() });
    AppMethodBeat.o(257763);
  }
  
  public static boolean crF()
  {
    return rKa;
  }
  
  public static final void crG()
  {
    AppMethodBeat.i(257752);
    rKa = cro();
    AppMethodBeat.o(257752);
  }
  
  public static boolean crH()
  {
    return rKd;
  }
  
  private static boolean crI()
  {
    AppMethodBeat.i(257778);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      Log.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(257778);
        return true;
      }
      AppMethodBeat.o(257778);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(257778);
    }
    return false;
  }
  
  public static boolean cro()
  {
    AppMethodBeat.i(257754);
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    boolean bool1 = a.a.crn().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.rJX;
    boolean bool2 = a.a.crn().audioManager.isBluetoothA2dpOn();
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(crr()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(257754);
      return true;
    }
    AppMethodBeat.o(257754);
    return false;
  }
  
  public static boolean crr()
  {
    AppMethodBeat.i(257773);
    boolean bool = crI();
    if (!bool)
    {
      Log.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(257773);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      Log.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(257773);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      Log.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(257773);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(257773);
      return false;
    }
    localObject = ((Set)localObject).iterator();
    BluetoothDevice localBluetoothDevice;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
      p.j(localBluetoothDevice, "dev");
    } while (localBluetoothDevice.getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(257773);
        return false;
      }
      Log.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(257773);
      return true;
    }
  }
  
  public static int d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(257770);
    p.k(paramAudioManager, "audioManager");
    if (rKb == -1) {}
    try
    {
      Object localObject = Class.forName("android.media.AudioManager");
      p.j(localObject, "Class.forName(\"android.media.AudioManager\")");
      localObject = ((Class)localObject).getField("STREAM_BLUETOOTH_SCO");
      p.j(localObject, "calzz.getField(\"STREAM_BLUETOOTH_SCO\")");
      i = ((Field)localObject).getInt(paramAudioManager);
      rKb = i;
      i = rKb;
      AppMethodBeat.o(257770);
      return i;
    }
    catch (Exception paramAudioManager)
    {
      for (;;)
      {
        Log.e("MicroMsg.BluetoothUtil", "ClassNotFoundException  android.media.AudioManager,exception:" + paramAudioManager.getMessage());
        int i = 6;
      }
    }
  }
  
  public static boolean e(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(257776);
    p.k(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(257776);
    return bool;
  }
  
  public static void kH(boolean paramBoolean)
  {
    rKa = paramBoolean;
  }
  
  public static void kI(boolean paramBoolean)
  {
    rKd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.b
 * JD-Core Version:    0.7.0.1
 */