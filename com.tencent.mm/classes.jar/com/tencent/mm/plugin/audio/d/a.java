package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class a
{
  private static boolean mpw;
  private static int mpx;
  public static final a mpy;
  
  static
  {
    AppMethodBeat.i(189277);
    mpy = new a();
    mpx = -1;
    AppMethodBeat.o(189277);
  }
  
  public static final int a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(189269);
    d.g.b.k.h(paramAudioManager, "audioManager");
    if (!bvE())
    {
      AppMethodBeat.o(189269);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.m("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.bvB().bvA() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      ad.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      ad.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.bvB().bvA(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(189269);
      return -1;
      if (bc.NY())
      {
        bool = false;
      }
      else
      {
        if (!paramAudioManager.isBluetoothScoOn())
        {
          ad.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bt.eGN() });
          paramAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    localObject = new StringBuilder("dkbt  tryStartBluetooth ");
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.d("MicroMsg.BluetoothUtil", a.a.bvB().bvA() + " ret:true");
    boolean bool = bvC();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      mpw = true;
    }
    ad.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(189269);
      return 1;
    }
    AppMethodBeat.o(189269);
    return 0;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(189271);
    d.g.b.k.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
    Integer localInteger;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {
        break label81;
      }
    }
    boolean bool;
    label81:
    while (localInteger.intValue() != 4)
    {
      if (!bvE()) {
        break;
      }
      if (paramStack.contains(Integer.valueOf(4))) {
        paramStack.removeElement(Integer.valueOf(4));
      }
      paramStack.push(Integer.valueOf(4));
      bool = true;
      AppMethodBeat.o(189271);
      return bool;
    }
    for (;;)
    {
      bool = false;
      break;
      ad.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
    }
  }
  
  public static final void b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(189270);
    d.g.b.k.h(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.m("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.bvB().bvA() });
    paramAudioManager.setBluetoothScoOn(false);
    mpw = false;
    if (!bc.NY())
    {
      ad.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(ae.fFH.WD()), Integer.valueOf(ae.fFH.WC()) });
      if ((ae.fFH.WC() == 1) || (ae.fFH.WD() == -1))
      {
        ad.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bt.eGN() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.mpv;
    ad.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.bvB().bvA() });
    AppMethodBeat.o(189270);
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(189272);
    d.g.b.k.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(189272);
  }
  
  public static boolean bvC()
  {
    AppMethodBeat.i(189268);
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    boolean bool1 = a.a.bvB().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.mpv;
    boolean bool2 = a.a.bvB().audioManager.isBluetoothA2dpOn();
    ad.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bvE()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(189268);
      return true;
    }
    AppMethodBeat.o(189268);
    return false;
  }
  
  public static boolean bvE()
  {
    AppMethodBeat.i(189274);
    boolean bool = bvJ();
    if (!bool)
    {
      ad.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(189274);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      ad.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(189274);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      ad.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(189274);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      ad.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(189274);
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
      d.g.b.k.g(localBluetoothDevice, "dev");
    } while (localBluetoothDevice.getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(189274);
        return false;
      }
      ad.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(189274);
      return true;
    }
  }
  
  public static boolean bvH()
  {
    return mpw;
  }
  
  public static final void bvI()
  {
    AppMethodBeat.i(189267);
    mpw = bvC();
    AppMethodBeat.o(189267);
  }
  
  private static boolean bvJ()
  {
    AppMethodBeat.i(189276);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      ad.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(189276);
        return true;
      }
      AppMethodBeat.o(189276);
      return false;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(189276);
    }
    return false;
  }
  
  public static int c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(189273);
    d.g.b.k.h(paramAudioManager, "audioManager");
    if (mpx == -1) {}
    try
    {
      i = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO").getInt(paramAudioManager);
      mpx = i;
      i = mpx;
      AppMethodBeat.o(189273);
      return i;
    }
    catch (Exception paramAudioManager)
    {
      for (;;)
      {
        ad.e("MicroMsg.BluetoothUtil", "ClassNotFoundException  android.media.AudioManager,exception:" + paramAudioManager.getMessage());
        int i = 6;
      }
    }
  }
  
  public static boolean d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(189275);
    d.g.b.k.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(189275);
    return bool;
  }
  
  public static void hP(boolean paramBoolean)
  {
    mpw = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */