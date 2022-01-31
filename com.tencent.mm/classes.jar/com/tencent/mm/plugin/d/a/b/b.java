package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.view.InputDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b
{
  public b.a jNN;
  public final HashMap<String, d> jNO;
  volatile boolean jNP;
  public c jNQ;
  public g jNR;
  final HashSet<Long> jNS;
  private c.a jNT;
  private g.a jNU;
  public BluetoothAdapter jNi;
  public ak mHandler;
  public volatile boolean mIsInit;
  private Runnable mRunnable;
  public Context zF;
  
  public b(al paramal)
  {
    AppMethodBeat.i(18371);
    this.jNN = null;
    this.zF = null;
    this.jNO = new HashMap();
    this.jNi = null;
    this.mHandler = null;
    this.mRunnable = null;
    this.jNP = false;
    this.mIsInit = false;
    this.jNS = new HashSet();
    this.jNT = new b.2(this);
    this.jNU = new b.3(this);
    this.mRunnable = new b.1(this);
    this.mHandler = new ak(paramal.oNc.getLooper());
    AppMethodBeat.o(18371);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(18374);
    if (!this.jNP)
    {
      AppMethodBeat.o(18374);
      return;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    this.jNP = false;
    fJ(false);
    aVS();
    if (this.jNN != null) {
      this.jNN.aVU();
    }
    AppMethodBeat.o(18374);
  }
  
  public final boolean a(boolean paramBoolean, int... paramVarArgs)
  {
    AppMethodBeat.i(18375);
    StringBuilder localStringBuilder = new StringBuilder("------scanLEDevice------");
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      ab.i("MicroMsg.exdevice.BluetoothLEManager", (String)localObject);
      Assert.assertTrue(this.mIsInit);
      if (aVT()) {
        break;
      }
      ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(18375);
      return false;
    }
    if (paramBoolean)
    {
      if (this.jNP)
      {
        AppMethodBeat.o(18375);
        return true;
      }
      if (!fJ(paramBoolean))
      {
        ab.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
        if (!this.jNS.isEmpty())
        {
          paramVarArgs = this.jNS.iterator();
          while (paramVarArgs.hasNext())
          {
            localObject = (Long)paramVarArgs.next();
            ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localObject });
            if (this.jNN != null) {
              this.jNN.l(((Long)localObject).longValue(), false);
            }
          }
          this.jNS.clear();
        }
        AppMethodBeat.o(18375);
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] == 1)) {
        this.mHandler.removeCallbacks(this.mRunnable);
      }
      for (;;)
      {
        this.jNP = true;
        AppMethodBeat.o(18375);
        return true;
        this.mHandler.postDelayed(this.mRunnable, 10000L);
      }
    }
    stopScan();
    AppMethodBeat.o(18375);
    return true;
  }
  
  final void aVS()
  {
    AppMethodBeat.i(18372);
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
    if (!this.jNS.isEmpty())
    {
      Iterator localIterator = this.jNS.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.jNN != null) {
          this.jNN.l(localLong.longValue(), false);
        }
      }
      this.jNS.clear();
    }
    AppMethodBeat.o(18372);
  }
  
  @TargetApi(18)
  public final boolean aVT()
  {
    AppMethodBeat.i(18373);
    Assert.assertTrue(this.mIsInit);
    boolean bool = this.zF.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(18373);
    return bool;
  }
  
  public final boolean connect(long paramLong)
  {
    AppMethodBeat.i(18377);
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[] { Long.valueOf(paramLong) });
    Assert.assertTrue(this.mIsInit);
    if (!aVT())
    {
      ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(18377);
      return false;
    }
    d locald = (d)this.jNO.get(String.valueOf(paramLong));
    boolean bool;
    Object localObject1;
    if (locald != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = (BluetoothManager)this.zF.getSystemService("bluetooth");
      if (localObject1 != null) {
        break label148;
      }
      ab.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
    }
    label148:
    label632:
    for (;;)
    {
      this.jNS.add(Long.valueOf(paramLong));
      bool = a(true, new int[0]);
      AppMethodBeat.o(18377);
      return bool;
      bool = false;
      break;
      Object localObject2 = ((BluetoothManager)localObject1).getConnectedDevices(8);
      if (localObject2 == null)
      {
        ab.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothDevice)((Iterator)localObject2).next();
          l = com.tencent.mm.plugin.exdevice.j.b.LX(((BluetoothDevice)localObject3).getAddress());
          ab.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject3).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject3).getName() });
          if (paramLong == l)
          {
            ab.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
            bool = locald.connect();
            AppMethodBeat.o(18377);
            return bool;
          }
        }
        ab.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[] { Build.VERSION.RELEASE });
        if ((com.tencent.mm.compatible.util.d.fv(23)) && (!((LocationManager)this.zF.getSystemService("location")).isProviderEnabled("gps")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
        {
          bool = locald.connect();
          AppMethodBeat.o(18377);
          return bool;
        }
        localObject1 = ((BluetoothManager)localObject1).getAdapter().getBondedDevices();
        if (localObject1 == null)
        {
          ab.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
        }
        else
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label632;
            }
            localObject2 = (BluetoothDevice)((Iterator)localObject1).next();
            l = com.tencent.mm.plugin.exdevice.j.b.LX(((BluetoothDevice)localObject2).getAddress());
            ab.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject2).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject2).getName() });
            if (paramLong == l)
            {
              ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
              localObject3 = (InputManager)this.zF.getSystemService("input");
              int[] arrayOfInt = ((InputManager)localObject3).getInputDeviceIds();
              if (arrayOfInt == null)
              {
                ab.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                break;
              }
              int i = 0;
              while (i < arrayOfInt.length)
              {
                Object localObject4 = ((InputManager)localObject3).getInputDevice(arrayOfInt[i]);
                if (localObject4 != null)
                {
                  localObject4 = ((InputDevice)localObject4).getName();
                  ab.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[] { localObject4 });
                  if ((localObject4 != null) && (((String)localObject4).equals(((BluetoothDevice)localObject2).getName())))
                  {
                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                    bool = locald.connect();
                    AppMethodBeat.o(18377);
                    return bool;
                  }
                }
                i += 1;
              }
              ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
            }
          }
        }
      }
    }
  }
  
  final boolean fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(18376);
    boolean bool = false;
    if ((com.tencent.mm.compatible.util.d.fv(21)) && (this.jNR != null)) {
      paramBoolean = this.jNR.a(paramBoolean, this.jNU);
    }
    for (;;)
    {
      AppMethodBeat.o(18376);
      return paramBoolean;
      if (this.jNQ != null)
      {
        paramBoolean = this.jNQ.a(paramBoolean, this.jNT);
      }
      else
      {
        ab.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        paramBoolean = bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */