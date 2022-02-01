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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d
{
  private int aHQ;
  BluetoothDevice kKg;
  public aq mHandler;
  long mSessionId;
  private BluetoothAdapter nUZ;
  Context nVX;
  BluetoothGatt nVY;
  b nVZ;
  BluetoothGattCharacteristic nWa;
  BluetoothGattCharacteristic nWb;
  a nWc;
  Runnable nWd;
  Runnable nWe;
  Runnable nWf;
  d nWg;
  final LinkedList<byte[]> nWh;
  volatile boolean nWi;
  int nWj;
  final BluetoothGattCallback nWk;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.nWh = new LinkedList();
    this.nWi = false;
    this.nWk = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22501);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22501);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22502);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(22502);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22503);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22503);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22498);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.nWj) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22498);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22500);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22500);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22499);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22499);
      }
    };
    this.aHQ = -1;
    this.aHQ = hashCode();
    this.nWg = this;
    this.nVZ = paramb;
    this.nVX = paramContext;
    this.nUZ = ((BluetoothManager)this.nVX.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.nWj = 3;
    this.kKg = this.nUZ.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.tw(paramLong));
    this.nWa = null;
    this.nWb = null;
    this.nWc = new a();
    this.mHandler = new a(com.tencent.e.j.a.bbi("BluetoothLESession_handlerThread"), this);
    this.nWd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        ae.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.nVZ != null) {
          d.this.nVZ.nVE.m(d.this.mSessionId, false);
        }
        d.this.bNI();
        AppMethodBeat.o(22504);
      }
    };
    this.nWe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        ae.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.nWf);
        d.this.nWj = 2;
        if (d.this.nVZ != null) {
          d.this.nVZ.nVE.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.nWf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        ae.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.nWe);
        d.this.nWj = 2;
        if (d.this.nVZ != null) {
          d.this.nVZ.nVE.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  final void bNH()
  {
    AppMethodBeat.i(22512);
    this.nWi = false;
    this.nWh.clear();
    AppMethodBeat.o(22512);
  }
  
  final void bNI()
  {
    AppMethodBeat.i(22513);
    if (this.nWh.isEmpty())
    {
      this.nWi = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.nWh.pop();
    this.nWc.setData(arrayOfByte);
    arrayOfByte = this.nWc.bNC();
    ae.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bf(arrayOfByte) });
    this.nWb.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.nWd, 5000L);
    if (!this.nVY.writeCharacteristic(this.nWb)) {
      ae.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.nWi = true;
    AppMethodBeat.o(22513);
  }
  
  public final void close()
  {
    AppMethodBeat.i(22511);
    ae.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      ae.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22511);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22510);
    ae.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  static final class a
    extends aq
  {
    private final WeakReference<d> nWm;
    
    public a(com.tencent.e.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.nWm = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.nWm.get();
      if (locald == null)
      {
        ae.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
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
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
        if (1 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.nWj == 0)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bNH();
        if (locald.nVY != null)
        {
          if (!locald.nVY.connect())
          {
            ae.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.nVZ != null) {
              locald.nVZ.nVE.l(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.nWj = 0;
          locald.mHandler.postDelayed(locald.nWf, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.nVY = locald.kKg.connectGatt(locald.nVX, false, locald.nWk);
        if (locald.nVY == null)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWj = 0;
        locald.mHandler.postDelayed(locald.nWf, 10000L);
        AppMethodBeat.o(22508);
        return;
        i = paramMessage.arg1;
        if (i == 2) {}
        for (paramMessage = "Connected";; paramMessage = "Disconnected")
        {
          ae.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
          if (i != 2) {
            break label565;
          }
          ae.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.nWj) });
          if (3 != locald.nWj) {
            break;
          }
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.nWf);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.nWf);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.nVY.discoverServices())
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ae.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
        AppMethodBeat.o(22508);
        return;
        label565:
        if (i == 0)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.nWf);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.nWf);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.nWM));
        if (paramMessage == null)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWa = paramMessage.getCharacteristic(UUID.fromString(h.nWO));
        if (locald.nWa == null)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWb = paramMessage.getCharacteristic(UUID.fromString(h.nWN));
        if (locald.nWb == null)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.nWa.getProperties();
        ae.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.nWj = 2;
          locald.mHandler.removeCallbacks(locald.nWf);
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ae.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.nWg;
        localObject = locald.nWa;
        if (!paramMessage.nVY.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            ae.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.nWj = 2;
            locald.mHandler.removeCallbacks(locald.nWf);
            if (locald.nVZ != null) {
              locald.nVZ.nVE.l(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.nWL));
          if (localObject == null)
          {
            ae.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
            i = 0;
          }
          else
          {
            ae.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
            if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
            {
              ae.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
              i = 0;
            }
            else if (!paramMessage.nVY.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              ae.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.nWe, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.nWe);
        locald.mHandler.removeCallbacks(locald.nWf);
        if (3 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.nWj = 2;
          if (locald.nVZ != null) {
            locald.nVZ.nVE.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWj = 1;
        if (locald.nVZ != null) {
          locald.nVZ.nVE.l(locald.mSessionId, true);
        }
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.nWj) });
        AppMethodBeat.o(22508);
        return;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bNH();
        if (locald.nVY == null)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWj = 3;
        locald.mHandler.removeCallbacks(locald.nWf);
        locald.mHandler.removeCallbacks(locald.nWe);
        locald.nVY.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.nWj)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.nWj) });
          if (locald.nVZ != null) {
            locald.nVZ.nVE.m(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.nVY != null) && (locald.nWb != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.nWh.add(paramMessage);
          if (!locald.nWi) {
            if (1 != locald.nWh.size()) {
              break label1845;
            }
          }
        }
        label1845:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.bNI();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.nWd);
        if (i != 0)
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.nVZ != null) {
            locald.nVZ.nVE.m(locald.mSessionId, false);
          }
          locald.bNI();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.nWc.bNC();
        ae.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bf(paramMessage) });
        if (paramMessage == null)
        {
          ae.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.nVZ != null) {
            locald.nVZ.nVE.m(locald.mSessionId, true);
          }
          locald.bNI();
          AppMethodBeat.o(22508);
          return;
        }
        ae.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.nWb.setValue(paramMessage);
        locald.nVY.writeCharacteristic(locald.nWb);
        locald.mHandler.postDelayed(locald.nWd, 5000L);
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
        if (bu.cF(paramMessage))
        {
          ae.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
          AppMethodBeat.o(22508);
          return;
        }
        localObject = com.tencent.mm.plugin.exdevice.k.b.T(paramMessage, paramMessage.length);
        ae.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        ae.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.nVZ != null) {
          locald.nVZ.nVE.b(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        ae.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.nWj)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bNH();
        if (locald.nVY == null)
        {
          ae.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.nWj = 3;
        locald.nVY.disconnect();
        locald.nVY.close();
        locald.nVY = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */