package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  public Context mAppContext;
  public MMHandler mHandler;
  public volatile boolean mIsInit;
  private Runnable mRunnable;
  public a vuL;
  public final HashMap<String, d> vuM;
  volatile boolean vuN;
  public c vuO;
  public g vuP;
  final HashSet<Long> vuQ;
  private c.a vuR;
  private g.a vuS;
  public BluetoothAdapter vug;
  
  public b(String paramString)
  {
    AppMethodBeat.i(179580);
    this.vuL = null;
    this.mAppContext = null;
    this.vuM = new HashMap();
    this.vug = null;
    this.mHandler = null;
    this.mRunnable = null;
    this.vuN = false;
    this.mIsInit = false;
    this.vuQ = new HashSet();
    this.vuR = new c.a()
    {
      public final void a(final BluetoothDevice paramAnonymousBluetoothDevice, final int paramAnonymousInt, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22476);
        Log.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.apW(paramAnonymousBluetoothDevice.getAddress())) });
        b.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22475);
            b.a(b.this, paramAnonymousBluetoothDevice, paramAnonymousInt, paramAnonymousArrayOfByte);
            AppMethodBeat.o(22475);
          }
        });
        AppMethodBeat.o(22476);
      }
      
      public final void daR() {}
    };
    this.vuS = new g.a()
    {
      public final void GP(int paramAnonymousInt)
      {
        AppMethodBeat.i(22480);
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt != 1) {
          b.this.mHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22478);
              if (!b.this.vuQ.isEmpty())
              {
                Iterator localIterator = b.this.vuQ.iterator();
                while (localIterator.hasNext())
                {
                  Long localLong = (Long)localIterator.next();
                  Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
                  if (b.this.vuL != null) {
                    b.this.vuL.r(localLong.longValue(), false);
                  }
                }
                b.this.vuQ.clear();
              }
              AppMethodBeat.o(22478);
            }
          });
        }
        AppMethodBeat.o(22480);
      }
      
      public final void a(final BluetoothDevice paramAnonymousBluetoothDevice, final int paramAnonymousInt, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22479);
        Log.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.apW(paramAnonymousBluetoothDevice.getAddress())) });
        b.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22477);
            b.a(b.this, paramAnonymousBluetoothDevice, paramAnonymousInt, paramAnonymousArrayOfByte);
            AppMethodBeat.o(22477);
          }
        });
        AppMethodBeat.o(22479);
      }
    };
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22474);
        b.this.vuN = false;
        b.this.mI(false);
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
        b.this.daP();
        if (b.this.vuL != null) {
          b.this.vuL.daR();
        }
        AppMethodBeat.o(22474);
      }
    };
    this.mHandler = new MMHandler(paramString);
    AppMethodBeat.o(179580);
  }
  
  private void daL()
  {
    AppMethodBeat.i(22485);
    if (!this.vuN)
    {
      AppMethodBeat.o(22485);
      return;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    this.vuN = false;
    mI(false);
    daP();
    if (this.vuL != null) {
      this.vuL.daR();
    }
    AppMethodBeat.o(22485);
  }
  
  public final boolean a(boolean paramBoolean, int... paramVarArgs)
  {
    AppMethodBeat.i(22486);
    StringBuilder localStringBuilder = new StringBuilder("------scanLEDevice------");
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      Log.i("MicroMsg.exdevice.BluetoothLEManager", (String)localObject);
      Assert.assertTrue(this.mIsInit);
      if (daQ()) {
        break;
      }
      Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22486);
      return false;
    }
    if (paramBoolean)
    {
      if (this.vuN)
      {
        AppMethodBeat.o(22486);
        return true;
      }
      if (!mI(paramBoolean))
      {
        Log.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
        if (!this.vuQ.isEmpty())
        {
          paramVarArgs = this.vuQ.iterator();
          while (paramVarArgs.hasNext())
          {
            localObject = (Long)paramVarArgs.next();
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localObject });
            if (this.vuL != null) {
              this.vuL.r(((Long)localObject).longValue(), false);
            }
          }
          this.vuQ.clear();
        }
        AppMethodBeat.o(22486);
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] == 1)) {
        this.mHandler.removeCallbacks(this.mRunnable);
      }
      for (;;)
      {
        this.vuN = true;
        AppMethodBeat.o(22486);
        return true;
        this.mHandler.postDelayed(this.mRunnable, 10000L);
      }
    }
    daL();
    AppMethodBeat.o(22486);
    return true;
  }
  
  public final boolean connect(long paramLong)
  {
    AppMethodBeat.i(22488);
    Log.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[] { Long.valueOf(paramLong) });
    Assert.assertTrue(this.mIsInit);
    if (!daQ())
    {
      Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22488);
      return false;
    }
    d locald = (d)this.vuM.get(String.valueOf(paramLong));
    boolean bool;
    Object localObject1;
    if (locald != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = (BluetoothManager)this.mAppContext.getSystemService("bluetooth");
      if (localObject1 != null) {
        break label148;
      }
      Log.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
    }
    label148:
    label616:
    for (;;)
    {
      this.vuQ.add(Long.valueOf(paramLong));
      bool = a(true, new int[0]);
      AppMethodBeat.o(22488);
      return bool;
      bool = false;
      break;
      Object localObject2 = ((BluetoothManager)localObject1).getConnectedDevices(8);
      if (localObject2 == null)
      {
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothDevice)((Iterator)localObject2).next();
          l = com.tencent.mm.plugin.exdevice.k.b.apW(((BluetoothDevice)localObject3).getAddress());
          Log.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject3).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject3).getName() });
          if (paramLong == l)
          {
            Log.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
            bool = locald.cmB();
            AppMethodBeat.o(22488);
            return bool;
          }
        }
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[] { Build.VERSION.RELEASE });
        if ((com.tencent.mm.compatible.util.d.rb(23)) && (!com.tencent.mm.modelgeo.d.bJm()) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
        {
          bool = locald.cmB();
          AppMethodBeat.o(22488);
          return bool;
        }
        localObject1 = ((BluetoothManager)localObject1).getAdapter().getBondedDevices();
        if (localObject1 == null)
        {
          Log.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
        }
        else
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label616;
            }
            localObject2 = (BluetoothDevice)((Iterator)localObject1).next();
            l = com.tencent.mm.plugin.exdevice.k.b.apW(((BluetoothDevice)localObject2).getAddress());
            Log.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject2).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject2).getName() });
            if (paramLong == l)
            {
              Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
              localObject3 = (InputManager)this.mAppContext.getSystemService("input");
              int[] arrayOfInt = ((InputManager)localObject3).getInputDeviceIds();
              if (arrayOfInt == null)
              {
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                break;
              }
              int i = 0;
              while (i < arrayOfInt.length)
              {
                Object localObject4 = ((InputManager)localObject3).getInputDevice(arrayOfInt[i]);
                if (localObject4 != null)
                {
                  localObject4 = ((InputDevice)localObject4).getName();
                  Log.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[] { localObject4 });
                  if ((localObject4 != null) && (((String)localObject4).equals(((BluetoothDevice)localObject2).getName())))
                  {
                    Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                    bool = locald.cmB();
                    AppMethodBeat.o(22488);
                    return bool;
                  }
                }
                i += 1;
              }
              Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
            }
          }
        }
      }
    }
  }
  
  final void daP()
  {
    AppMethodBeat.i(22483);
    Log.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
    if (!this.vuQ.isEmpty())
    {
      Iterator localIterator = this.vuQ.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.vuL != null) {
          this.vuL.r(localLong.longValue(), false);
        }
      }
      this.vuQ.clear();
    }
    AppMethodBeat.o(22483);
  }
  
  public final boolean daQ()
  {
    AppMethodBeat.i(22484);
    Assert.assertTrue(this.mIsInit);
    boolean bool = this.mAppContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22484);
    return bool;
  }
  
  final boolean mI(boolean paramBoolean)
  {
    AppMethodBeat.i(22487);
    boolean bool = false;
    if ((com.tencent.mm.compatible.util.d.rb(21)) && (this.vuP != null)) {
      paramBoolean = this.vuP.a(paramBoolean, this.vuS);
    }
    for (;;)
    {
      AppMethodBeat.o(22487);
      return paramBoolean;
      if (this.vuO != null)
      {
        paramBoolean = this.vuO.a(paramBoolean, this.vuR);
      }
      else
      {
        Log.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        paramBoolean = bool;
      }
    }
  }
  
  public static abstract class a
  {
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void c(long paramLong, byte[] paramArrayOfByte) {}
    
    public void daR() {}
    
    public void k(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void r(long paramLong, boolean paramBoolean) {}
    
    public void s(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long vuX = 0L;
    private long vuY = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.vuX = paramLong1;
      this.vuY = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22481);
      b localb = b.this;
      long l = this.vuX;
      d locald1 = new d(l, localb.mAppContext, localb);
      String str = String.valueOf(locald1.mSessionId);
      Log.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[] { Integer.valueOf(locald1.hashCode()), Long.valueOf(l), str });
      d locald2 = (d)localb.vuM.remove(str);
      if (locald2 != null) {
        locald2.close();
      }
      localb.vuM.put(str, locald1);
      l = locald1.mSessionId;
      if (b.this.vuL != null) {
        b.this.vuL.k(l, this.vuX, this.vuY);
      }
      AppMethodBeat.o(22481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.b
 * JD-Core Version:    0.7.0.1
 */