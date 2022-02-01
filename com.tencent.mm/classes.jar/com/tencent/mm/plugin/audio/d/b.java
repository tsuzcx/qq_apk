package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "currentBluetoothAddress", "isRecordAllowToUseSco", "", "()Z", "setRecordAllowToUseSco", "(Z)V", "mIsPlugged", "getMIsPlugged", "setMIsPlugged", "checkBluetoothType", "", "context", "Landroid/content/Context;", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "isBluetoothCanRecord", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "setActiveDevice", "address", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class b
{
  private static boolean oIk;
  private static int oIl;
  private static String oIm;
  private static boolean oIn;
  public static final b oIo;
  
  static
  {
    AppMethodBeat.i(224023);
    oIo = new b();
    oIl = -1;
    oIn = true;
    AppMethodBeat.o(224023);
  }
  
  public static final boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(224014);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoAvailableOffCall();
    AppMethodBeat.o(224014);
    return bool;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224017);
    p.h(paramStack, "mDeviceQueue");
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
      if (!cee()) {
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
      AppMethodBeat.o(224017);
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
  
  public static void agu(String paramString)
  {
    oIm = paramString;
  }
  
  public static final int b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(224015);
    p.h(paramAudioManager, "audioManager");
    if (!cee())
    {
      AppMethodBeat.o(224015);
      return -1;
    }
    if (!oIn)
    {
      AppMethodBeat.o(224015);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.cej() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      Log.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      Log.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.cej(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(224015);
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
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.d("MicroMsg.BluetoothUtil", a.a.cej() + " ret:true");
    boolean bool = ceb();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      oIk = true;
    }
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(224015);
      return 1;
    }
    AppMethodBeat.o(224015);
    return 0;
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224018);
    p.h(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(224018);
  }
  
  public static final void c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(224016);
    p.h(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.cej() });
    paramAudioManager.setBluetoothScoOn(false);
    oIk = false;
    if (!PhoneStatusWatcher.isCalling())
    {
      Log.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(ae.gKE.aok()), Integer.valueOf(ae.gKE.aoj()) });
      if ((ae.gKE.aoj() == 1) || (ae.gKE.aok() == -1))
      {
        Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { Util.getStack() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.oIh;
    Log.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.cej() });
    AppMethodBeat.o(224016);
  }
  
  public static boolean ceb()
  {
    AppMethodBeat.i(224013);
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    boolean bool1 = a.a.cea().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.oIh;
    boolean bool2 = a.a.cea().audioManager.isBluetoothA2dpOn();
    Log.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(cee()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(224013);
      return true;
    }
    AppMethodBeat.o(224013);
    return false;
  }
  
  public static boolean cee()
  {
    AppMethodBeat.i(224020);
    boolean bool = cev();
    if (!bool)
    {
      Log.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(224020);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      Log.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(224020);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      Log.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(224020);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(224020);
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
      p.g(localBluetoothDevice, "dev");
    } while (localBluetoothDevice.getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(224020);
        return false;
      }
      Log.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(224020);
      return true;
    }
  }
  
  public static boolean ces()
  {
    return oIk;
  }
  
  public static final void cet()
  {
    AppMethodBeat.i(224012);
    oIk = ceb();
    AppMethodBeat.o(224012);
  }
  
  public static boolean ceu()
  {
    return oIn;
  }
  
  private static boolean cev()
  {
    AppMethodBeat.i(224022);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      Log.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(224022);
        return true;
      }
      AppMethodBeat.o(224022);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(224022);
    }
    return false;
  }
  
  public static int d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(224019);
    p.h(paramAudioManager, "audioManager");
    if (oIl == -1) {}
    try
    {
      Object localObject = Class.forName("android.media.AudioManager");
      p.g(localObject, "Class.forName(\"android.media.AudioManager\")");
      localObject = ((Class)localObject).getField("STREAM_BLUETOOTH_SCO");
      p.g(localObject, "calzz.getField(\"STREAM_BLUETOOTH_SCO\")");
      i = ((Field)localObject).getInt(paramAudioManager);
      oIl = i;
      i = oIl;
      AppMethodBeat.o(224019);
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
    AppMethodBeat.i(224021);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(224021);
    return bool;
  }
  
  public static void jw(boolean paramBoolean)
  {
    oIk = paramBoolean;
  }
  
  public static void jx(boolean paramBoolean)
  {
    oIn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.b
 * JD-Core Version:    0.7.0.1
 */