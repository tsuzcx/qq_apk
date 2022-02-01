package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i$a
{
  public BroadcastReceiver jHB;
  private BluetoothAdapter jRx;
  private volatile boolean nqO;
  boolean nqP;
  Map<String, i.b> nqQ;
  long nqR;
  Runnable nqS;
  private BluetoothAdapter.LeScanCallback nqT;
  
  private i$a(i parami)
  {
    AppMethodBeat.i(112650);
    this.nqO = false;
    this.nqP = false;
    this.nqQ = new ConcurrentHashMap();
    this.nqR = 3000L;
    this.nqS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112647);
        i.a.this.bII();
        i.a.this.bIH();
        AppMethodBeat.o(112647);
      }
    };
    this.nqT = new BluetoothAdapter.LeScanCallback()
    {
      public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(112649);
        if (paramAnonymousBluetoothDevice == null)
        {
          ad.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
          AppMethodBeat.o(112649);
          return;
        }
        if ((i.a.this.nqN.nqF == null) || (bt.isNullOrNil(i.a.this.nqN.nqF.name)))
        {
          AppMethodBeat.o(112649);
          return;
        }
        String str = bt.nullAsNil(paramAnonymousBluetoothDevice.getName());
        paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
        if (str.equals(i.a.this.nqN.nqF.name))
        {
          ad.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.aK(paramAnonymousArrayOfByte));
          i.a.this.nqQ.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
          AppMethodBeat.o(112649);
          return;
        }
        ad.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(112649);
      }
    };
    AppMethodBeat.o(112650);
  }
  
  public static byte[] aK(byte[] paramArrayOfByte)
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
  
  public final i.b bIG()
  {
    AppMethodBeat.i(112652);
    Object localObject = new i.b("", -100, "", null);
    if (this.nqQ.size() <= 0)
    {
      AppMethodBeat.o(112652);
      return localObject;
    }
    Iterator localIterator = this.nqQ.values().iterator();
    if (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      if (((i.b)localObject).dhP >= localb.dhP) {
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
  
  @TargetApi(18)
  public final void bIH()
  {
    AppMethodBeat.i(112653);
    if (Build.VERSION.SDK_INT < 18)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(112653);
      return;
    }
    if (this.nqO)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "already start");
      AppMethodBeat.o(112653);
      return;
    }
    this.nqQ.clear();
    BluetoothManager localBluetoothManager = (BluetoothManager)aj.getContext().getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      this.nqP = false;
      ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
      AppMethodBeat.o(112653);
      return;
    }
    this.nqP = true;
    this.jRx = localBluetoothManager.getAdapter();
    if ((this.jRx == null) || (!this.jRx.isEnabled()))
    {
      this.nqP = false;
      ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(112653);
      return;
    }
    ad.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.jRx.startLeScan(this.nqT)) });
    this.nqO = true;
    AppMethodBeat.o(112653);
  }
  
  @TargetApi(18)
  public final void bII()
  {
    AppMethodBeat.i(112654);
    if (Build.VERSION.SDK_INT < 18)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(112654);
      return;
    }
    if (!this.nqO)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "not start");
      AppMethodBeat.o(112654);
      return;
    }
    if ((this.jRx == null) || (!this.jRx.isEnabled()))
    {
      this.nqP = false;
      ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(112654);
      return;
    }
    this.nqP = true;
    this.jRx.stopLeScan(this.nqT);
    ad.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
    this.nqO = false;
    AppMethodBeat.o(112654);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112651);
    this.nqQ.clear();
    AppMethodBeat.o(112651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a
 * JD-Core Version:    0.7.0.1
 */