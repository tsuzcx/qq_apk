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
import android.view.InputDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b
{
  public Context GX;
  public ao mHandler;
  public volatile boolean mIsInit;
  private Runnable mRunnable;
  public BluetoothAdapter nox;
  public a npc;
  public final HashMap<String, d> npd;
  volatile boolean npe;
  public c npf;
  public g npg;
  final HashSet<Long> nph;
  private c.a npi;
  private g.a npj;
  
  public b(String paramString)
  {
    AppMethodBeat.i(179580);
    this.npc = null;
    this.GX = null;
    this.npd = new HashMap();
    this.nox = null;
    this.mHandler = null;
    this.mRunnable = null;
    this.npe = false;
    this.mIsInit = false;
    this.nph = new HashSet();
    this.npi = new c.a()
    {
      public final void a(final BluetoothDevice paramAnonymousBluetoothDevice, final int paramAnonymousInt, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22476);
        ac.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.Zs(paramAnonymousBluetoothDevice.getAddress())) });
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
      
      public final void bIu() {}
    };
    this.npj = new g.a()
    {
      public final void a(final BluetoothDevice paramAnonymousBluetoothDevice, final int paramAnonymousInt, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22479);
        ac.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.Zs(paramAnonymousBluetoothDevice.getAddress())) });
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
      
      public final void ym(int paramAnonymousInt)
      {
        AppMethodBeat.i(22480);
        ac.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt != 1) {
          b.this.mHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22478);
              if (!b.this.nph.isEmpty())
              {
                Iterator localIterator = b.this.nph.iterator();
                while (localIterator.hasNext())
                {
                  Long localLong = (Long)localIterator.next();
                  ac.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
                  if (b.this.npc != null) {
                    b.this.npc.l(localLong.longValue(), false);
                  }
                }
                b.this.nph.clear();
              }
              AppMethodBeat.o(22478);
            }
          });
        }
        AppMethodBeat.o(22480);
      }
    };
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22474);
        b.this.npe = false;
        b.this.iY(false);
        ac.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
        b.this.bIs();
        if (b.this.npc != null) {
          b.this.npc.bIu();
        }
        AppMethodBeat.o(22474);
      }
    };
    this.mHandler = new ao(paramString);
    AppMethodBeat.o(179580);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22485);
    if (!this.npe)
    {
      AppMethodBeat.o(22485);
      return;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    this.npe = false;
    iY(false);
    bIs();
    if (this.npc != null) {
      this.npc.bIu();
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
      ac.i("MicroMsg.exdevice.BluetoothLEManager", (String)localObject);
      Assert.assertTrue(this.mIsInit);
      if (bIt()) {
        break;
      }
      ac.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22486);
      return false;
    }
    if (paramBoolean)
    {
      if (this.npe)
      {
        AppMethodBeat.o(22486);
        return true;
      }
      if (!iY(paramBoolean))
      {
        ac.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
        if (!this.nph.isEmpty())
        {
          paramVarArgs = this.nph.iterator();
          while (paramVarArgs.hasNext())
          {
            localObject = (Long)paramVarArgs.next();
            ac.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localObject });
            if (this.npc != null) {
              this.npc.l(((Long)localObject).longValue(), false);
            }
          }
          this.nph.clear();
        }
        AppMethodBeat.o(22486);
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] == 1)) {
        this.mHandler.removeCallbacks(this.mRunnable);
      }
      for (;;)
      {
        this.npe = true;
        AppMethodBeat.o(22486);
        return true;
        this.mHandler.postDelayed(this.mRunnable, 10000L);
      }
    }
    stopScan();
    AppMethodBeat.o(22486);
    return true;
  }
  
  final void bIs()
  {
    AppMethodBeat.i(22483);
    ac.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
    if (!this.nph.isEmpty())
    {
      Iterator localIterator = this.nph.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ac.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.npc != null) {
          this.npc.l(localLong.longValue(), false);
        }
      }
      this.nph.clear();
    }
    AppMethodBeat.o(22483);
  }
  
  @TargetApi(18)
  public final boolean bIt()
  {
    AppMethodBeat.i(22484);
    Assert.assertTrue(this.mIsInit);
    boolean bool = this.GX.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22484);
    return bool;
  }
  
  public final boolean connect(long paramLong)
  {
    AppMethodBeat.i(22488);
    ac.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[] { Long.valueOf(paramLong) });
    Assert.assertTrue(this.mIsInit);
    if (!bIt())
    {
      ac.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22488);
      return false;
    }
    d locald = (d)this.npd.get(String.valueOf(paramLong));
    boolean bool;
    Object localObject1;
    if (locald != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = (BluetoothManager)this.GX.getSystemService("bluetooth");
      if (localObject1 != null) {
        break label148;
      }
      ac.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
    }
    label148:
    label632:
    for (;;)
    {
      this.nph.add(Long.valueOf(paramLong));
      bool = a(true, new int[0]);
      AppMethodBeat.o(22488);
      return bool;
      bool = false;
      break;
      Object localObject2 = ((BluetoothManager)localObject1).getConnectedDevices(8);
      if (localObject2 == null)
      {
        ac.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothDevice)((Iterator)localObject2).next();
          l = com.tencent.mm.plugin.exdevice.k.b.Zs(((BluetoothDevice)localObject3).getAddress());
          ac.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject3).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject3).getName() });
          if (paramLong == l)
          {
            ac.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
            bool = locald.connect();
            AppMethodBeat.o(22488);
            return bool;
          }
        }
        ac.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[] { Build.VERSION.RELEASE });
        if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!((LocationManager)this.GX.getSystemService("location")).isProviderEnabled("gps")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
        {
          bool = locald.connect();
          AppMethodBeat.o(22488);
          return bool;
        }
        localObject1 = ((BluetoothManager)localObject1).getAdapter().getBondedDevices();
        if (localObject1 == null)
        {
          ac.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
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
            l = com.tencent.mm.plugin.exdevice.k.b.Zs(((BluetoothDevice)localObject2).getAddress());
            ac.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[] { ((BluetoothDevice)localObject2).getAddress(), Long.valueOf(l), ((BluetoothDevice)localObject2).getName() });
            if (paramLong == l)
            {
              ac.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
              localObject3 = (InputManager)this.GX.getSystemService("input");
              int[] arrayOfInt = ((InputManager)localObject3).getInputDeviceIds();
              if (arrayOfInt == null)
              {
                ac.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                break;
              }
              int i = 0;
              while (i < arrayOfInt.length)
              {
                Object localObject4 = ((InputManager)localObject3).getInputDevice(arrayOfInt[i]);
                if (localObject4 != null)
                {
                  localObject4 = ((InputDevice)localObject4).getName();
                  ac.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[] { localObject4 });
                  if ((localObject4 != null) && (((String)localObject4).equals(((BluetoothDevice)localObject2).getName())))
                  {
                    ac.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                    bool = locald.connect();
                    AppMethodBeat.o(22488);
                    return bool;
                  }
                }
                i += 1;
              }
              ac.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
            }
          }
        }
      }
    }
  }
  
  final boolean iY(boolean paramBoolean)
  {
    AppMethodBeat.i(22487);
    boolean bool = false;
    if ((com.tencent.mm.compatible.util.d.kZ(21)) && (this.npg != null)) {
      paramBoolean = this.npg.a(paramBoolean, this.npj);
    }
    for (;;)
    {
      AppMethodBeat.o(22487);
      return paramBoolean;
      if (this.npf != null)
      {
        paramBoolean = this.npf.a(paramBoolean, this.npi);
      }
      else
      {
        ac.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        paramBoolean = bool;
      }
    }
  }
  
  public static abstract class a
  {
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bIu() {}
    
    public void i(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void l(long paramLong, boolean paramBoolean) {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long npo = 0L;
    private long npp = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.npo = paramLong1;
      this.npp = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22481);
      b localb = b.this;
      long l = this.npo;
      d locald1 = new d(l, localb.GX, localb);
      String str = String.valueOf(locald1.mSessionId);
      ac.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[] { Integer.valueOf(locald1.hashCode()), Long.valueOf(l), str });
      d locald2 = (d)localb.npd.remove(str);
      if (locald2 != null) {
        locald2.close();
      }
      localb.npd.put(str, locald1);
      l = locald1.mSessionId;
      if (b.this.npc != null) {
        b.this.npc.i(l, this.npo, this.npp);
      }
      AppMethodBeat.o(22481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */