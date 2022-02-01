package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class a
{
  private static boolean nxp;
  private static int nxq;
  public static final a nxr;
  
  static
  {
    AppMethodBeat.i(201115);
    nxr = new a();
    nxq = -1;
    AppMethodBeat.o(201115);
  }
  
  public static final boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(201106);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoAvailableOffCall();
    AppMethodBeat.o(201106);
    return bool;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(201109);
    p.h(paramStack, "mDeviceQueue");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
    Integer localInteger;
    boolean bool;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {}
    }
    else
    {
      if (!bHC()) {
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
      AppMethodBeat.o(201109);
      return bool;
      if (localInteger.intValue() != 4) {
        break;
      }
      bool = true;
      continue;
      label94:
      bool = false;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
    }
  }
  
  public static final int b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(201107);
    p.h(paramAudioManager, "audioManager");
    if (!bHC())
    {
      AppMethodBeat.o(201107);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.bHy().bHx() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.bHy().bHx(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(201107);
      return -1;
      if (bd.PC())
      {
        bool = false;
      }
      else
      {
        if (!paramAudioManager.isBluetoothScoOn())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bu.fpN() });
          paramAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    localObject = new StringBuilder("dkbt  tryStartBluetooth ");
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BluetoothUtil", a.a.bHy().bHx() + " ret:true");
    boolean bool = bHz();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      nxp = true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(201107);
      return 1;
    }
    AppMethodBeat.o(201107);
    return 0;
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(201110);
    p.h(paramStack, "mDeviceQueue");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(201110);
  }
  
  public static boolean bHC()
  {
    AppMethodBeat.i(201112);
    boolean bool = bHJ();
    if (!bool)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(201112);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(201112);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(201112);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(201112);
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(201112);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(201112);
      return true;
    }
  }
  
  public static boolean bHH()
  {
    return nxp;
  }
  
  public static final void bHI()
  {
    AppMethodBeat.i(201104);
    nxp = bHz();
    AppMethodBeat.o(201104);
  }
  
  private static boolean bHJ()
  {
    AppMethodBeat.i(201114);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(201114);
        return true;
      }
      AppMethodBeat.o(201114);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(201114);
    }
    return false;
  }
  
  public static boolean bHz()
  {
    AppMethodBeat.i(201105);
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    boolean bool1 = a.a.bHy().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.nxo;
    boolean bool2 = a.a.bHy().audioManager.isBluetoothA2dpOn();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bHC()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(201105);
      return true;
    }
    AppMethodBeat.o(201105);
    return false;
  }
  
  public static final void c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(201108);
    p.h(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.bHy().bHx() });
    paramAudioManager.setBluetoothScoOn(false);
    nxp = false;
    if (!bd.PC())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geX.aal()), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geX.aak()) });
      if ((com.tencent.mm.compatible.deviceinfo.ae.geX.aak() == 1) || (com.tencent.mm.compatible.deviceinfo.ae.geX.aal() == -1))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bu.fpN() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.bHy().bHx() });
    AppMethodBeat.o(201108);
  }
  
  public static int d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(201111);
    p.h(paramAudioManager, "audioManager");
    if (nxq == -1) {}
    try
    {
      i = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO").getInt(paramAudioManager);
      nxq = i;
      i = nxq;
      AppMethodBeat.o(201111);
      return i;
    }
    catch (Exception paramAudioManager)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BluetoothUtil", "ClassNotFoundException  android.media.AudioManager,exception:" + paramAudioManager.getMessage());
        int i = 6;
      }
    }
  }
  
  public static boolean e(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(201113);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(201113);
    return bool;
  }
  
  public static void iw(boolean paramBoolean)
  {
    nxp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */