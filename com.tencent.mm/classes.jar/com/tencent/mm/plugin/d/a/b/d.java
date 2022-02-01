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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d
{
  private int aHQ;
  BluetoothDevice kGR;
  public ap mHandler;
  long mSessionId;
  private BluetoothAdapter nPt;
  d nQA;
  final LinkedList<byte[]> nQB;
  volatile boolean nQC;
  int nQD;
  final BluetoothGattCallback nQE;
  Context nQr;
  BluetoothGatt nQs;
  b nQt;
  BluetoothGattCharacteristic nQu;
  BluetoothGattCharacteristic nQv;
  a nQw;
  Runnable nQx;
  Runnable nQy;
  Runnable nQz;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.nQB = new LinkedList();
    this.nQC = false;
    this.nQE = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22501);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22501);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22502);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(22502);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22503);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22503);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22498);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.nQD) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22498);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22500);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22500);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22499);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22499);
      }
    };
    this.aHQ = -1;
    this.aHQ = hashCode();
    this.nQA = this;
    this.nQt = paramb;
    this.nQr = paramContext;
    this.nPt = ((BluetoothManager)this.nQr.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.nQD = 3;
    this.kGR = this.nPt.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.ti(paramLong));
    this.nQu = null;
    this.nQv = null;
    this.nQw = new a();
    this.mHandler = new a(com.tencent.e.j.a.aZF("BluetoothLESession_handlerThread"), this);
    this.nQx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        ad.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.nQt != null) {
          d.this.nQt.nPY.m(d.this.mSessionId, false);
        }
        d.this.bMK();
        AppMethodBeat.o(22504);
      }
    };
    this.nQy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        ad.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.nQz);
        d.this.nQD = 2;
        if (d.this.nQt != null) {
          d.this.nQt.nPY.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.nQz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        ad.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.nQy);
        d.this.nQD = 2;
        if (d.this.nQt != null) {
          d.this.nQt.nPY.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  final void bMJ()
  {
    AppMethodBeat.i(22512);
    this.nQC = false;
    this.nQB.clear();
    AppMethodBeat.o(22512);
  }
  
  final void bMK()
  {
    AppMethodBeat.i(22513);
    if (this.nQB.isEmpty())
    {
      this.nQC = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.nQB.pop();
    this.nQw.setData(arrayOfByte);
    arrayOfByte = this.nQw.bME();
    ad.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bg(arrayOfByte) });
    this.nQv.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.nQx, 5000L);
    if (!this.nQs.writeCharacteristic(this.nQv)) {
      ad.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.nQC = true;
    AppMethodBeat.o(22513);
  }
  
  public final void close()
  {
    AppMethodBeat.i(22511);
    ad.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      ad.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22511);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22510);
    ad.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  static final class a
    extends ap
  {
    private final WeakReference<d> nQG;
    
    public a(com.tencent.e.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.nQG = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.nQG.get();
      if (locald == null)
      {
        ad.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
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
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
        if (1 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.nQD == 0)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bMJ();
        if (locald.nQs != null)
        {
          if (!locald.nQs.connect())
          {
            ad.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.nQt != null) {
              locald.nQt.nPY.l(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.nQD = 0;
          locald.mHandler.postDelayed(locald.nQz, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQs = locald.kGR.connectGatt(locald.nQr, false, locald.nQE);
        if (locald.nQs == null)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQD = 0;
        locald.mHandler.postDelayed(locald.nQz, 10000L);
        AppMethodBeat.o(22508);
        return;
        i = paramMessage.arg1;
        if (i == 2) {}
        for (paramMessage = "Connected";; paramMessage = "Disconnected")
        {
          ad.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
          if (i != 2) {
            break label565;
          }
          ad.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.nQD) });
          if (3 != locald.nQD) {
            break;
          }
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.nQz);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.nQz);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.nQs.discoverServices())
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ad.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
        AppMethodBeat.o(22508);
        return;
        label565:
        if (i == 0)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.nQz);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.nQz);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.nRg));
        if (paramMessage == null)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQu = paramMessage.getCharacteristic(UUID.fromString(h.nRi));
        if (locald.nQu == null)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQv = paramMessage.getCharacteristic(UUID.fromString(h.nRh));
        if (locald.nQv == null)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.nQu.getProperties();
        ad.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.nQD = 2;
          locald.mHandler.removeCallbacks(locald.nQz);
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ad.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.nQA;
        localObject = locald.nQu;
        if (!paramMessage.nQs.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            ad.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.nQD = 2;
            locald.mHandler.removeCallbacks(locald.nQz);
            if (locald.nQt != null) {
              locald.nQt.nPY.l(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.nRf));
          if (localObject == null)
          {
            ad.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
            i = 0;
          }
          else
          {
            ad.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
            if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
            {
              ad.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
              i = 0;
            }
            else if (!paramMessage.nQs.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              ad.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.nQy, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.nQy);
        locald.mHandler.removeCallbacks(locald.nQz);
        if (3 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.nQD = 2;
          if (locald.nQt != null) {
            locald.nQt.nPY.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQD = 1;
        if (locald.nQt != null) {
          locald.nQt.nPY.l(locald.mSessionId, true);
        }
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.nQD) });
        AppMethodBeat.o(22508);
        return;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bMJ();
        if (locald.nQs == null)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQD = 3;
        locald.mHandler.removeCallbacks(locald.nQz);
        locald.mHandler.removeCallbacks(locald.nQy);
        locald.nQs.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.nQD)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.nQD) });
          if (locald.nQt != null) {
            locald.nQt.nPY.m(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.nQs != null) && (locald.nQv != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.nQB.add(paramMessage);
          if (!locald.nQC) {
            if (1 != locald.nQB.size()) {
              break label1845;
            }
          }
        }
        label1845:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.bMK();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.nQx);
        if (i != 0)
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.nQt != null) {
            locald.nQt.nPY.m(locald.mSessionId, false);
          }
          locald.bMK();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.nQw.bME();
        ad.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bg(paramMessage) });
        if (paramMessage == null)
        {
          ad.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.nQt != null) {
            locald.nQt.nPY.m(locald.mSessionId, true);
          }
          locald.bMK();
          AppMethodBeat.o(22508);
          return;
        }
        ad.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.nQv.setValue(paramMessage);
        locald.nQs.writeCharacteristic(locald.nQv);
        locald.mHandler.postDelayed(locald.nQx, 5000L);
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
        if (bt.cC(paramMessage))
        {
          ad.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
          AppMethodBeat.o(22508);
          return;
        }
        localObject = com.tencent.mm.plugin.exdevice.k.b.T(paramMessage, paramMessage.length);
        ad.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        ad.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.nQt != null) {
          locald.nQt.nPY.b(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        ad.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.nQD)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bMJ();
        if (locald.nQs == null)
        {
          ad.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.nQD = 3;
        locald.nQs.disconnect();
        locald.nQs.close();
        locald.nQs = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */