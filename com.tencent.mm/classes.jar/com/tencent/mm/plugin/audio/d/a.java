package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class a
{
  private static boolean nrW;
  private static int nrX;
  public static final a nrY;
  
  static
  {
    AppMethodBeat.i(199803);
    nrY = new a();
    nrX = -1;
    AppMethodBeat.o(199803);
  }
  
  public static final boolean a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199794);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoAvailableOffCall();
    AppMethodBeat.o(199794);
    return bool;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199797);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
    Integer localInteger;
    boolean bool;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {}
    }
    else
    {
      if (!bGG()) {
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
      AppMethodBeat.o(199797);
      return bool;
      if (localInteger.intValue() != 4) {
        break;
      }
      bool = true;
      continue;
      label94:
      bool = false;
      ad.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
    }
  }
  
  public static final int b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199795);
    p.h(paramAudioManager, "audioManager");
    if (!bGG())
    {
      AppMethodBeat.o(199795);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.m("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.bGC().bGB() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      ad.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      ad.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.bGC().bGB(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(199795);
      return -1;
      if (bc.PD())
      {
        bool = false;
      }
      else
      {
        if (!paramAudioManager.isBluetoothScoOn())
        {
          ad.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bt.flS() });
          paramAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    localObject = new StringBuilder("dkbt  tryStartBluetooth ");
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.d("MicroMsg.BluetoothUtil", a.a.bGC().bGB() + " ret:true");
    boolean bool = bGD();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      nrW = true;
    }
    ad.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(199795);
      return 1;
    }
    AppMethodBeat.o(199795);
    return 0;
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199798);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(199798);
  }
  
  public static boolean bGD()
  {
    AppMethodBeat.i(199793);
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    boolean bool1 = a.a.bGC().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.nrV;
    boolean bool2 = a.a.bGC().audioManager.isBluetoothA2dpOn();
    ad.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bGG()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(199793);
      return true;
    }
    AppMethodBeat.o(199793);
    return false;
  }
  
  public static boolean bGG()
  {
    AppMethodBeat.i(199800);
    boolean bool = bGN();
    if (!bool)
    {
      ad.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(199800);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      ad.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(199800);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      ad.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(199800);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      ad.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(199800);
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
        ad.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(199800);
        return false;
      }
      ad.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(199800);
      return true;
    }
  }
  
  public static boolean bGL()
  {
    return nrW;
  }
  
  public static final void bGM()
  {
    AppMethodBeat.i(199792);
    nrW = bGD();
    AppMethodBeat.o(199792);
  }
  
  private static boolean bGN()
  {
    AppMethodBeat.i(199802);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      ad.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(199802);
        return true;
      }
      AppMethodBeat.o(199802);
      return false;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(199802);
    }
    return false;
  }
  
  public static final void c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199796);
    p.h(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.m("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.bGC().bGB() });
    paramAudioManager.setBluetoothScoOn(false);
    nrW = false;
    if (!bc.PD())
    {
      ad.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(ae.gcP.aac()), Integer.valueOf(ae.gcP.aab()) });
      if ((ae.gcP.aab() == 1) || (ae.gcP.aac() == -1))
      {
        ad.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bt.flS() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.nrV;
    ad.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.bGC().bGB() });
    AppMethodBeat.o(199796);
  }
  
  public static int d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199799);
    p.h(paramAudioManager, "audioManager");
    if (nrX == -1) {}
    try
    {
      i = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO").getInt(paramAudioManager);
      nrX = i;
      i = nrX;
      AppMethodBeat.o(199799);
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
  
  public static boolean e(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199801);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(199801);
    return bool;
  }
  
  public static void iy(boolean paramBoolean)
  {
    nrW = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */