package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
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

@TargetApi(18)
public final class d
{
  private int aHK;
  BluetoothDevice lOM;
  public MMHandler mHandler;
  long mSessionId;
  private BluetoothAdapter pfW;
  Context pgT;
  BluetoothGatt pgU;
  b pgV;
  BluetoothGattCharacteristic pgW;
  BluetoothGattCharacteristic pgX;
  a pgY;
  Runnable pgZ;
  Runnable pha;
  Runnable phb;
  d phc;
  final LinkedList<byte[]> phd;
  volatile boolean phe;
  int phf;
  final BluetoothGattCallback phg;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.phd = new LinkedList();
    this.phe = false;
    this.phg = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22501);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22501);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22502);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(22502);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22503);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22503);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22498);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.phf) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22498);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22500);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22500);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22499);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22499);
      }
    };
    this.aHK = -1;
    this.aHK = hashCode();
    this.phc = this;
    this.pgV = paramb;
    this.pgT = paramContext;
    this.pfW = ((BluetoothManager)this.pgT.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.phf = 3;
    this.lOM = this.pfW.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.BC(paramLong));
    this.pgW = null;
    this.pgX = null;
    this.pgY = new a();
    this.mHandler = new a(com.tencent.f.j.a.bqt("BluetoothLESession_handlerThread"), this);
    this.pgZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.pgV != null) {
          d.this.pgV.pgB.m(d.this.mSessionId, false);
        }
        d.this.ckI();
        AppMethodBeat.o(22504);
      }
    };
    this.pha = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.phb);
        d.this.phf = 2;
        if (d.this.pgV != null) {
          d.this.pgV.pgB.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.phb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.pha);
        d.this.phf = 2;
        if (d.this.pgV != null) {
          d.this.pgV.pgB.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  final void ckH()
  {
    AppMethodBeat.i(22512);
    this.phe = false;
    this.phd.clear();
    AppMethodBeat.o(22512);
  }
  
  final void ckI()
  {
    AppMethodBeat.i(22513);
    if (this.phd.isEmpty())
    {
      this.phe = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.phd.pop();
    this.pgY.setData(arrayOfByte);
    arrayOfByte = this.pgY.ckC();
    Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bw(arrayOfByte) });
    this.pgX.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.pgZ, 5000L);
    if (!this.pgU.writeCharacteristic(this.pgX)) {
      Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.phe = true;
    AppMethodBeat.o(22513);
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
  
  public final boolean connect()
  {
    AppMethodBeat.i(22510);
    Log.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  static final class a
    extends MMHandler
  {
    private final WeakReference<d> phi;
    
    public a(com.tencent.f.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.phi = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.phi.get();
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
        if (1 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.phf == 0)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.ckH();
        if (locald.pgU != null)
        {
          if (!locald.pgU.connect())
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.pgV != null) {
              locald.pgV.pgB.l(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.phf = 0;
          locald.mHandler.postDelayed(locald.phb, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.pgU = locald.lOM.connectGatt(locald.pgT, false, locald.phg);
        if (locald.pgU == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.phf = 0;
        locald.mHandler.postDelayed(locald.phb, 10000L);
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
          Log.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.phf) });
          if (3 != locald.phf) {
            break;
          }
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.phb);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.phb);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.pgU.discoverServices())
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
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
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.phb);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.phb);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.phI));
        if (paramMessage == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.pgW = paramMessage.getCharacteristic(UUID.fromString(h.phK));
        if (locald.pgW == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.pgX = paramMessage.getCharacteristic(UUID.fromString(h.phJ));
        if (locald.pgX == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.pgW.getProperties();
        Log.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.phf = 2;
          locald.mHandler.removeCallbacks(locald.phb);
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.phc;
        localObject = locald.pgW;
        if (!paramMessage.pgU.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.phf = 2;
            locald.mHandler.removeCallbacks(locald.phb);
            if (locald.pgV != null) {
              locald.pgV.pgB.l(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.phH));
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
            else if (!paramMessage.pgU.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.pha, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.pha);
        locald.mHandler.removeCallbacks(locald.phb);
        if (3 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.phf = 2;
          if (locald.pgV != null) {
            locald.pgV.pgB.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.phf = 1;
        if (locald.pgV != null) {
          locald.pgV.pgB.l(locald.mSessionId, true);
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.phf) });
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.ckH();
        if (locald.pgU == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.phf = 3;
        locald.mHandler.removeCallbacks(locald.phb);
        locald.mHandler.removeCallbacks(locald.pha);
        locald.pgU.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.phf)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.phf) });
          if (locald.pgV != null) {
            locald.pgV.pgB.m(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.pgU != null) && (locald.pgX != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.phd.add(paramMessage);
          if (!locald.phe) {
            if (1 != locald.phd.size()) {
              break label1845;
            }
          }
        }
        label1845:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.ckI();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.pgZ);
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.pgV != null) {
            locald.pgV.pgB.m(locald.mSessionId, false);
          }
          locald.ckI();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.pgY.ckC();
        Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bw(paramMessage) });
        if (paramMessage == null)
        {
          Log.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.pgV != null) {
            locald.pgV.pgB.m(locald.mSessionId, true);
          }
          locald.ckI();
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.pgX.setValue(paramMessage);
        locald.pgU.writeCharacteristic(locald.pgX);
        locald.mHandler.postDelayed(locald.pgZ, 5000L);
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
        localObject = com.tencent.mm.plugin.exdevice.k.b.V(paramMessage, paramMessage.length);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        Log.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.pgV != null) {
          locald.pgV.pgB.b(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.phf)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.ckH();
        if (locald.pgU == null)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.phf = 3;
        locald.pgU.disconnect();
        locald.pgU.close();
        locald.pgU = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */