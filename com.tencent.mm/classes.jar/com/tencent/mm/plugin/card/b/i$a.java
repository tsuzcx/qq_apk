package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i$a
{
  public BroadcastReceiver glu;
  private BluetoothAdapter gqX;
  private volatile boolean ikK = false;
  boolean ikL = false;
  Map<String, i.b> ikM = new ConcurrentHashMap();
  long ikN = 3000L;
  Runnable ikO = new i.a.1(this);
  private BluetoothAdapter.LeScanCallback ikP = new i.a.3(this);
  
  private i$a(i parami) {}
  
  public static byte[] ad(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    if (paramArrayOfByte == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return arrayOfByte2;
        i = 0;
        arrayOfByte2 = arrayOfByte1;
      } while (i >= paramArrayOfByte.length);
      j = i + 1;
      i = paramArrayOfByte[i] & 0xFF;
      arrayOfByte2 = arrayOfByte1;
    } while (i == 0);
    i -= 1;
    int k = j + 1;
    switch (paramArrayOfByte[j] & 0xFF)
    {
    }
    for (;;)
    {
      i += k;
      break;
      arrayOfByte1 = new byte[i];
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, i);
    }
  }
  
  public final i.b aAc()
  {
    Object localObject = new i.b("", -100, "", null);
    if (this.ikM.size() <= 0) {
      return localObject;
    }
    Iterator localIterator = this.ikM.values().iterator();
    if (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      if (((i.b)localObject).bLz >= localb.bLz) {
        break label81;
      }
      localObject = localb;
    }
    label81:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  @TargetApi(18)
  public final void aAd()
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      return;
    }
    if (this.ikK)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "already start");
      return;
    }
    this.ikM.clear();
    BluetoothManager localBluetoothManager = (BluetoothManager)ae.getContext().getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      this.ikL = false;
      y.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
      return;
    }
    this.ikL = true;
    this.gqX = localBluetoothManager.getAdapter();
    if ((this.gqX == null) || (!this.gqX.isEnabled()))
    {
      this.ikL = false;
      y.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      return;
    }
    y.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.gqX.startLeScan(this.ikP)) });
    this.ikK = true;
  }
  
  @TargetApi(18)
  public final void aAe()
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      return;
    }
    if (!this.ikK)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "not start");
      return;
    }
    if ((this.gqX == null) || (!this.gqX.isEnabled()))
    {
      this.ikL = false;
      y.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      return;
    }
    this.ikL = true;
    this.gqX.stopLeScan(this.ikP);
    y.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
    this.ikK = false;
  }
  
  public final void reset()
  {
    this.ikM.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a
 * JD-Core Version:    0.7.0.1
 */