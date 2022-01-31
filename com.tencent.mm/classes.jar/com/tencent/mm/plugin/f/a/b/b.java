package com.tencent.mm.plugin.f.a.b;

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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b
{
  public b.a hTT = null;
  public final HashMap<String, d> hTU = new HashMap();
  volatile boolean hTV = false;
  public c hTW;
  public g hTX;
  final HashSet<Long> hTY = new HashSet();
  private c.a hTZ = new c.a()
  {
    public final void awr() {}
    
    public final void b(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
    {
      y.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.BU(paramAnonymousBluetoothDevice.getAddress())) });
      b.this.mHandler.post(new b.2.1(this, paramAnonymousBluetoothDevice, paramAnonymousInt, paramAnonymousArrayOfByte));
    }
  };
  public BluetoothAdapter hTo = null;
  private g.a hUa = new b.3(this);
  public ah mHandler = null;
  public volatile boolean mIsInit = false;
  private Runnable mRunnable = null;
  public Context ze = null;
  
  public b(ai paramai)
  {
    this.mHandler = new ah(paramai.mnU.getLooper());
  }
  
  private void awl()
  {
    if (!this.hTV) {}
    do
    {
      return;
      this.mHandler.removeCallbacks(this.mRunnable);
      this.hTV = false;
      eo(false);
      awp();
    } while (this.hTT == null);
    this.hTT.awr();
  }
  
  public final boolean a(boolean paramBoolean, int... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("------scanLEDevice------");
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      y.i("MicroMsg.exdevice.BluetoothLEManager", (String)localObject);
      Assert.assertTrue(this.mIsInit);
      if (awq()) {
        break;
      }
      y.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      return false;
    }
    if (paramBoolean)
    {
      if (this.hTV) {
        return true;
      }
      if (!eo(paramBoolean))
      {
        y.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
        if (!this.hTY.isEmpty())
        {
          paramVarArgs = this.hTY.iterator();
          while (paramVarArgs.hasNext())
          {
            localObject = (Long)paramVarArgs.next();
            y.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localObject });
            if (this.hTT != null) {
              this.hTT.i(((Long)localObject).longValue(), false);
            }
          }
          this.hTY.clear();
        }
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] == 1)) {
        this.mHandler.removeCallbacks(this.mRunnable);
      }
      for (;;)
      {
        this.hTV = true;
        return true;
        this.mHandler.postDelayed(this.mRunnable, 10000L);
      }
    }
    awl();
    return true;
  }
  
  final void awp()
  {
    y.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
    if (!this.hTY.isEmpty())
    {
      Iterator localIterator = this.hTY.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        y.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.hTT != null) {
          this.hTT.i(localLong.longValue(), false);
        }
      }
      this.hTY.clear();
    }
  }
  
  @TargetApi(18)
  public final boolean awq()
  {
    Assert.assertTrue(this.mIsInit);
    return this.ze.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
  
  public final boolean connect(long paramLong)
  {
    y.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[] { Long.valueOf(paramLong) });
    Assert.assertTrue(this.mIsInit);
    if (!awq())
    {
      y.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      return false;
    }
    d locald = (d)this.hTU.get(String.valueOf(paramLong));
    boolean bool;
    Object localObject1;
    if (locald != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = (BluetoothManager)this.ze.getSystemService("bluetooth");
      if (localObject1 != null) {
        break label126;
      }
      y.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
    }
    label580:
    for (;;)
    {
      this.hTY.add(Long.valueOf(paramLong));
      return a(true, new int[0]);
      bool = false;
      break;
      label126:
      Object localObject2 = ((BluetoothManager)localObject1).getConnectedDevices(8);
      if (localObject2 == null)
      {
        y.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothDevice)((Iterator)localObject2).next();
          l = com.tencent.mm.plugin.exdevice.j.b.BU(((BluetoothDevice)localObject3).getAddress());
          y.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject3).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject3).getName() });
          if (paramLong == l)
          {
            y.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
            return locald.connect();
          }
        }
        y.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[] { Build.VERSION.RELEASE });
        if ((com.tencent.mm.compatible.util.d.gF(23)) && (!((LocationManager)this.ze.getSystemService("location")).isProviderEnabled("gps")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
          return locald.connect();
        }
        localObject1 = ((BluetoothManager)localObject1).getAdapter().getBondedDevices();
        if (localObject1 == null)
        {
          y.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
        }
        else
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label580;
            }
            localObject2 = (BluetoothDevice)((Iterator)localObject1).next();
            l = com.tencent.mm.plugin.exdevice.j.b.BU(((BluetoothDevice)localObject2).getAddress());
            y.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject2).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject2).getName() });
            if (paramLong == l)
            {
              y.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
              localObject3 = (InputManager)this.ze.getSystemService("input");
              int[] arrayOfInt = ((InputManager)localObject3).getInputDeviceIds();
              if (arrayOfInt == null)
              {
                y.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                break;
              }
              int i = 0;
              while (i < arrayOfInt.length)
              {
                Object localObject4 = ((InputManager)localObject3).getInputDevice(arrayOfInt[i]);
                if (localObject4 != null)
                {
                  localObject4 = ((InputDevice)localObject4).getName();
                  y.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[] { localObject4 });
                  if ((localObject4 != null) && (((String)localObject4).equals(((BluetoothDevice)localObject2).getName())))
                  {
                    y.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                    return locald.connect();
                  }
                }
                i += 1;
              }
              y.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
            }
          }
        }
      }
    }
  }
  
  final boolean eo(boolean paramBoolean)
  {
    boolean bool = false;
    if ((com.tencent.mm.compatible.util.d.gF(21)) && (this.hTX != null))
    {
      Object localObject = this.hTX;
      g.a locala = this.hUa;
      y.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
      localObject = (Boolean)new g.1((g)localObject, paramBoolean, locala).b(((g)localObject).mHandler);
      paramBoolean = bool;
      if (localObject != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      return ((Boolean)localObject).booleanValue();
    }
    if (this.hTW != null) {
      return this.hTW.a(paramBoolean, this.hTZ);
    }
    y.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.b
 * JD-Core Version:    0.7.0.1
 */