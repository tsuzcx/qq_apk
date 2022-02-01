package com.tencent.mm.plugin.card.mgr;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class h$a
{
  public BroadcastReceiver rJV;
  private BluetoothAdapter rZi;
  private volatile boolean wrV;
  boolean wrW;
  Map<String, h.b> wrX;
  long wrY;
  Runnable wrZ;
  private BluetoothAdapter.LeScanCallback wsa;
  
  private h$a(h paramh)
  {
    AppMethodBeat.i(112650);
    this.wrV = false;
    this.wrW = false;
    this.wrX = new ConcurrentHashMap();
    this.wrY = 3000L;
    this.wrZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112647);
        h.a.this.dkw();
        h.a.this.dkv();
        AppMethodBeat.o(112647);
      }
    };
    this.wsa = new BluetoothAdapter.LeScanCallback()
    {
      public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(112649);
        if (paramAnonymousBluetoothDevice == null)
        {
          Log.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
          AppMethodBeat.o(112649);
          return;
        }
        if ((h.b(h.a.this.wrU) == null) || (Util.isNullOrNil(h.b(h.a.this.wrU).name)))
        {
          AppMethodBeat.o(112649);
          return;
        }
        String str = Util.nullAsNil(paramAnonymousBluetoothDevice.getName());
        paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
        if (str.equals(h.b(h.a.this.wrU).name))
        {
          Log.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          paramAnonymousArrayOfByte = new h.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, h.a.bp(paramAnonymousArrayOfByte));
          h.a.this.wrX.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
          AppMethodBeat.o(112649);
          return;
        }
        Log.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(112649);
      }
    };
    AppMethodBeat.o(112650);
  }
  
  public static byte[] bp(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(112655);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(112655);
      return null;
    }
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = i + 1;
      i = paramArrayOfByte[i] & 0xFF;
      if (i != 0)
      {
        i -= 1;
        int k = j + 1;
        switch (paramArrayOfByte[j] & 0xFF)
        {
        }
        for (;;)
        {
          i += k;
          break;
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, k, arrayOfByte, 0, i);
        }
      }
    }
    AppMethodBeat.o(112655);
    return arrayOfByte;
  }
  
  public final h.b dku()
  {
    AppMethodBeat.i(112652);
    Object localObject = new h.b("", -100, "", null);
    if (this.wrX.size() <= 0)
    {
      AppMethodBeat.o(112652);
      return localObject;
    }
    Iterator localIterator = this.wrX.values().iterator();
    if (localIterator.hasNext())
    {
      h.b localb = (h.b)localIterator.next();
      if (((h.b)localObject).rssi >= localb.rssi) {
        break label96;
      }
      localObject = localb;
    }
    label96:
    for (;;)
    {
      break;
      AppMethodBeat.o(112652);
      return localObject;
    }
  }
  
  public final void dkv()
  {
    AppMethodBeat.i(112653);
    if (Build.VERSION.SDK_INT < 18)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(112653);
      return;
    }
    if (this.wrV)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "already start");
      AppMethodBeat.o(112653);
      return;
    }
    this.wrX.clear();
    Object localObject = (BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth");
    if (localObject == null)
    {
      this.wrW = false;
      Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
      AppMethodBeat.o(112653);
      return;
    }
    this.wrW = true;
    this.rZi = ((BluetoothManager)localObject).getAdapter();
    if ((this.rZi == null) || (!this.rZi.isEnabled()))
    {
      this.wrW = false;
      Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(112653);
      return;
    }
    Log.i("MicroMsg.CardLbsOrBluetooth", "[BluetoothTrace] start scan");
    Log.printErrStackTrace("MicroMsg.CardLbsOrBluetooth", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
    localObject = this.rZi;
    BluetoothAdapter.LeScanCallback localLeScanCallback = this.wsa;
    Log.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(localObject, new com.tencent.mm.hellhoundlib.b.a().cG(localLeScanCallback).aYi(), "com/tencent/mm/plugin/card/mgr/CardLbsOrBluetoothInfoManager$BluetoothHelper", "startScanBluetooth", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue()) });
    this.wrV = true;
    AppMethodBeat.o(112653);
  }
  
  public final void dkw()
  {
    AppMethodBeat.i(112654);
    if (Build.VERSION.SDK_INT < 18)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(112654);
      return;
    }
    if (!this.wrV)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "not start");
      AppMethodBeat.o(112654);
      return;
    }
    if ((this.rZi == null) || (!this.rZi.isEnabled()))
    {
      this.wrW = false;
      Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(112654);
      return;
    }
    this.wrW = true;
    this.rZi.stopLeScan(this.wsa);
    Log.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
    this.wrV = false;
    AppMethodBeat.o(112654);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112651);
    this.wrX.clear();
    AppMethodBeat.o(112651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.h.a
 * JD-Core Version:    0.7.0.1
 */