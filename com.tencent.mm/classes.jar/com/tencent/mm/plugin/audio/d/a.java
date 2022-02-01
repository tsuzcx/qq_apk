package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class a
{
  private static boolean mRx;
  private static int mRy;
  public static final a mRz;
  
  static
  {
    AppMethodBeat.i(198400);
    mRz = new a();
    mRy = -1;
    AppMethodBeat.o(198400);
  }
  
  public static final int a(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(198392);
    d.g.b.k.h(paramAudioManager, "audioManager");
    if (!bCA())
    {
      AppMethodBeat.o(198392);
      return -1;
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.m("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", new Object[] { a.a.bCx().bCw() });
    if (!paramAudioManager.isBluetoothScoAvailableOffCall())
    {
      ac.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
      bool = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      ac.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { a.a.bCx().bCw(), Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(198392);
      return -1;
      if (bb.NU())
      {
        bool = false;
      }
      else
      {
        if (!paramAudioManager.isBluetoothScoOn())
        {
          ac.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bs.eWi() });
          paramAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    localObject = new StringBuilder("dkbt  tryStartBluetooth ");
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.d("MicroMsg.BluetoothUtil", a.a.bCx().bCw() + " ret:true");
    boolean bool = bCy();
    if (bool)
    {
      paramAudioManager.setBluetoothScoOn(true);
      mRx = true;
    }
    ac.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(198392);
      return 1;
    }
    AppMethodBeat.o(198392);
    return 0;
  }
  
  public static final boolean a(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198394);
    d.g.b.k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
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
      if (!bCA()) {
        break;
      }
      if (paramStack.contains(Integer.valueOf(4))) {
        paramStack.removeElement(Integer.valueOf(4));
      }
      paramStack.push(Integer.valueOf(4));
      bool = true;
      AppMethodBeat.o(198394);
      return bool;
    }
    for (;;)
    {
      bool = false;
      break;
      ac.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
    }
  }
  
  public static final void b(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(198393);
    d.g.b.k.h(paramAudioManager, "audioManager");
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.m("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", new Object[] { a.a.bCx().bCw() });
    paramAudioManager.setBluetoothScoOn(false);
    mRx = false;
    if (!bb.NU())
    {
      ac.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(ae.fJo.XB()), Integer.valueOf(ae.fJo.XA()) });
      if ((ae.fJo.XA() == 1) || (ae.fJo.XB() == -1))
      {
        ac.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bs.eWi() });
        paramAudioManager.stopBluetoothSco();
      }
    }
    paramAudioManager = com.tencent.mm.plugin.audio.c.a.mRw;
    ac.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", new Object[] { a.a.bCx().bCw() });
    AppMethodBeat.o(198393);
  }
  
  public static final void b(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198395);
    d.g.b.k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
    paramStack.removeElement(Integer.valueOf(4));
    AppMethodBeat.o(198395);
  }
  
  public static boolean bCA()
  {
    AppMethodBeat.i(198397);
    boolean bool = bCF();
    if (!bool)
    {
      ac.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(198397);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      ac.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(198397);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      ac.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(198397);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      ac.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(198397);
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
        ac.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
        AppMethodBeat.o(198397);
        return false;
      }
      ac.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(198397);
      return true;
    }
  }
  
  public static boolean bCD()
  {
    return mRx;
  }
  
  public static final void bCE()
  {
    AppMethodBeat.i(198390);
    mRx = bCy();
    AppMethodBeat.o(198390);
  }
  
  private static boolean bCF()
  {
    AppMethodBeat.i(198399);
    try
    {
      int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
      ac.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
      if (i == 2)
      {
        AppMethodBeat.o(198399);
        return true;
      }
      AppMethodBeat.o(198399);
      return false;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(198399);
    }
    return false;
  }
  
  public static boolean bCy()
  {
    AppMethodBeat.i(198391);
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    boolean bool1 = a.a.bCx().audioManager.isBluetoothScoOn();
    locala = com.tencent.mm.plugin.audio.c.a.mRw;
    boolean bool2 = a.a.bCx().audioManager.isBluetoothA2dpOn();
    ac.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bCA()) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(198391);
      return true;
    }
    AppMethodBeat.o(198391);
    return false;
  }
  
  public static int c(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(198396);
    d.g.b.k.h(paramAudioManager, "audioManager");
    if (mRy == -1) {}
    try
    {
      i = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO").getInt(paramAudioManager);
      mRy = i;
      i = mRy;
      AppMethodBeat.o(198396);
      return i;
    }
    catch (Exception paramAudioManager)
    {
      for (;;)
      {
        ac.e("MicroMsg.BluetoothUtil", "ClassNotFoundException  android.media.AudioManager,exception:" + paramAudioManager.getMessage());
        int i = 6;
      }
    }
  }
  
  public static boolean d(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(198398);
    d.g.b.k.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isBluetoothScoOn();
    AppMethodBeat.o(198398);
    return bool;
  }
  
  public static void ip(boolean paramBoolean)
  {
    mRx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */