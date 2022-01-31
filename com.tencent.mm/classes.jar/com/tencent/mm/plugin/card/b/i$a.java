package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i$a
{
  public BroadcastReceiver hFt;
  private BluetoothAdapter hMm;
  private volatile boolean klI;
  boolean klJ;
  Map<String, i.b> klK;
  long klL;
  Runnable klM;
  private BluetoothAdapter.LeScanCallback klN;
  
  private i$a(i parami)
  {
    AppMethodBeat.i(87706);
    this.klI = false;
    this.klJ = false;
    this.klK = new ConcurrentHashMap();
    this.klL = 3000L;
    this.klM = new i.a.1(this);
    this.klN = new i.a.3(this);
    AppMethodBeat.o(87706);
  }
  
  public static byte[] av(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(87711);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(87711);
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
    AppMethodBeat.o(87711);
    return arrayOfByte;
  }
  
  public final i.b bbO()
  {
    AppMethodBeat.i(87708);
    Object localObject = new i.b("", -100, "", null);
    if (this.klK.size() <= 0)
    {
      AppMethodBeat.o(87708);
      return localObject;
    }
    Iterator localIterator = this.klK.values().iterator();
    if (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      if (((i.b)localObject).csT >= localb.csT) {
        break label96;
      }
      localObject = localb;
    }
    label96:
    for (;;)
    {
      break;
      AppMethodBeat.o(87708);
      return localObject;
    }
  }
  
  @TargetApi(18)
  public final void bbP()
  {
    AppMethodBeat.i(87709);
    if (Build.VERSION.SDK_INT < 18)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(87709);
      return;
    }
    if (this.klI)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "already start");
      AppMethodBeat.o(87709);
      return;
    }
    this.klK.clear();
    BluetoothManager localBluetoothManager = (BluetoothManager)ah.getContext().getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      this.klJ = false;
      ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
      AppMethodBeat.o(87709);
      return;
    }
    this.klJ = true;
    this.hMm = localBluetoothManager.getAdapter();
    if ((this.hMm == null) || (!this.hMm.isEnabled()))
    {
      this.klJ = false;
      ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(87709);
      return;
    }
    ab.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.hMm.startLeScan(this.klN)) });
    this.klI = true;
    AppMethodBeat.o(87709);
  }
  
  @TargetApi(18)
  public final void bbQ()
  {
    AppMethodBeat.i(87710);
    if (Build.VERSION.SDK_INT < 18)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
      AppMethodBeat.o(87710);
      return;
    }
    if (!this.klI)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "not start");
      AppMethodBeat.o(87710);
      return;
    }
    if ((this.hMm == null) || (!this.hMm.isEnabled()))
    {
      this.klJ = false;
      ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
      AppMethodBeat.o(87710);
      return;
    }
    this.klJ = true;
    this.hMm.stopLeScan(this.klN);
    ab.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
    this.klI = false;
    AppMethodBeat.o(87710);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(87707);
    this.klK.clear();
    AppMethodBeat.o(87707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a
 * JD-Core Version:    0.7.0.1
 */