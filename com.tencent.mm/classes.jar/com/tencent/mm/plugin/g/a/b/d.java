package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

public final class d
{
  private int cHb;
  public MMHandler mHandler;
  long mSessionId;
  BluetoothDevice rOZ;
  private BluetoothAdapter vug;
  Context vvd;
  BluetoothGatt vve;
  b vvf;
  BluetoothGattCharacteristic vvg;
  BluetoothGattCharacteristic vvh;
  a vvi;
  Runnable vvj;
  Runnable vvk;
  Runnable vvl;
  d vvm;
  final LinkedList<byte[]> vvn;
  volatile boolean vvo;
  int vvp;
  final BluetoothGattCallback vvq;
  
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.vvn = new LinkedList();
    this.vvo = false;
    this.vvq = new d.1(this);
    this.cHb = -1;
    this.cHb = hashCode();
    this.vvm = this;
    this.vvf = paramb;
    this.vvd = paramContext;
    this.vug = ((BluetoothManager)this.vvd.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.vvp = 3;
    this.rOZ = this.vug.getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.kg(paramLong));
    this.vvg = null;
    this.vvh = null;
    this.vvi = new a();
    this.mHandler = new a(com.tencent.threadpool.j.a.bFV("BluetoothLESession_handlerThread"), this);
    this.vvj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.vvf != null) {
          d.this.vvf.vuL.s(d.this.mSessionId, false);
        }
        d.this.daU();
        AppMethodBeat.o(22504);
      }
    };
    this.vvk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.vvl);
        d.this.vvp = 2;
        if (d.this.vvf != null) {
          d.this.vvf.vuL.r(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.vvl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.vvk);
        d.this.vvp = 2;
        if (d.this.vvf != null) {
          d.this.vvf.vuL.r(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  public final void close()
  {
    AppMethodBeat.i(22511);
    Log.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22511);
  }
  
  public final boolean cmB()
  {
    AppMethodBeat.i(22510);
    Log.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  final void daT()
  {
    AppMethodBeat.i(22512);
    this.vvo = false;
    this.vvn.clear();
    AppMethodBeat.o(22512);
  }
  
  final void daU()
  {
    AppMethodBeat.i(22513);
    if (this.vvn.isEmpty())
    {
      this.vvo = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.vvn.pop();
    this.vvi.setData(arrayOfByte);
    arrayOfByte = this.vvi.daO();
    Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bK(arrayOfByte) });
    this.vvh.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.vvj, 5000L);
    if (!this.vve.writeCharacteristic(this.vvh)) {
      Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.vvo = true;
    AppMethodBeat.o(22513);
  }
  
  static final class a
    extends MMHandler
  {
    private final WeakReference<d> vvs;
    
    public a(com.tencent.threadpool.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.vvs = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.vvs.get();
      if (locald == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
        AppMethodBeat.o(22508);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
        if (1 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.vvp == 0)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.daT();
        if (locald.vve != null)
        {
          if (!locald.vve.connect())
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.vvf != null) {
              locald.vvf.vuL.r(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.vvp = 0;
          locald.mHandler.postDelayed(locald.vvl, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.vve = locald.rOZ.connectGatt(locald.vvd, false, locald.vvq);
        if (locald.vve == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvp = 0;
        locald.mHandler.postDelayed(locald.vvl, 10000L);
        AppMethodBeat.o(22508);
        return;
        i = paramMessage.arg1;
        if (i == 2) {}
        for (paramMessage = "Connected";; paramMessage = "Disconnected")
        {
          Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
          if (i != 2) {
            break label565;
          }
          Log.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.vvp) });
          if (3 != locald.vvp) {
            break;
          }
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.vvl);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.vvl);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.vve.discoverServices())
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
        AppMethodBeat.o(22508);
        return;
        label565:
        if (i == 0)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.vvl);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.vvl);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.vvS));
        if (paramMessage == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvg = paramMessage.getCharacteristic(UUID.fromString(h.vvU));
        if (locald.vvg == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvh = paramMessage.getCharacteristic(UUID.fromString(h.vvT));
        if (locald.vvh == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.vvg.getProperties();
        Log.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.vvp = 2;
          locald.mHandler.removeCallbacks(locald.vvl);
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.vvm;
        localObject = locald.vvg;
        if (!paramMessage.vve.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.vvp = 2;
            locald.mHandler.removeCallbacks(locald.vvl);
            if (locald.vvf != null) {
              locald.vvf.vuL.r(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.vvR));
          if (localObject == null)
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
            i = 0;
          }
          else
          {
            Log.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
            if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
            {
              Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
              i = 0;
            }
            else if (!paramMessage.vve.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.vvk, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.vvk);
        locald.mHandler.removeCallbacks(locald.vvl);
        if (3 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.vvp = 2;
          if (locald.vvf != null) {
            locald.vvf.vuL.r(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvp = 1;
        if (locald.vvf != null) {
          locald.vvf.vuL.r(locald.mSessionId, true);
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.vvp) });
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.daT();
        if (locald.vve == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvp = 3;
        locald.mHandler.removeCallbacks(locald.vvl);
        locald.mHandler.removeCallbacks(locald.vvk);
        locald.vve.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.vvp)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.vvp) });
          if (locald.vvf != null) {
            locald.vvf.vuL.s(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.vve != null) && (locald.vvh != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.vvn.add(paramMessage);
          if (!locald.vvo) {
            if (1 != locald.vvn.size()) {
              break label1842;
            }
          }
        }
        label1842:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.daU();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.vvj);
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.vvf != null) {
            locald.vvf.vuL.s(locald.mSessionId, false);
          }
          locald.daU();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.vvi.daO();
        Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bK(paramMessage) });
        if (paramMessage == null)
        {
          Log.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.vvf != null) {
            locald.vvf.vuL.s(locald.mSessionId, true);
          }
          locald.daU();
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.vvh.setValue(paramMessage);
        locald.vve.writeCharacteristic(locald.vvh);
        locald.mHandler.postDelayed(locald.vvj, 5000L);
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
        if (Util.isNullOrNil(paramMessage))
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
          AppMethodBeat.o(22508);
          return;
        }
        localObject = com.tencent.mm.plugin.exdevice.k.b.W(paramMessage, paramMessage.length);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        Log.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.vvf != null) {
          locald.vvf.vuL.c(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.vvp)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.daT();
        if (locald.vve == null)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.vvp = 3;
        locald.vve.disconnect();
        locald.vve.close();
        locald.vve = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.d
 * JD-Core Version:    0.7.0.1
 */